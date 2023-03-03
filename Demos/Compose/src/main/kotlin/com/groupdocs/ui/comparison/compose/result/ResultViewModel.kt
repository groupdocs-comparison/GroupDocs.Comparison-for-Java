package com.groupdocs.ui.comparison.compose.result

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.groupdocs.comparison.Comparer
import com.groupdocs.comparison.Document
import com.groupdocs.comparison.license.License
import com.groupdocs.comparison.options.CompareOptions
import com.groupdocs.comparison.options.PreviewOptions
import com.groupdocs.comparison.options.enums.PreviewFormats
import com.groupdocs.comparison.result.FileType
import com.groupdocs.ui.comparison.compose.common.NavigationException
import com.groupdocs.ui.comparison.compose.common.Screen
import com.groupdocs.ui.comparison.compose.common.Settings
import kotlinx.coroutines.*
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter
import kotlin.io.path.nameWithoutExtension


class ResultViewModel(private val screen: MutableState<Screen>) {
    private val _state: MutableState<ResultState> = mutableStateOf(ResultState())
    val state: State<ResultState> = _state
    private val tempDir: Path

    init {
        var resultPath = ""
        val sourcePath: String
        val targetPath: String
        val targetName: String
        tempDir = Paths.get(System.getenv("TMP"))
        if (screen.value is Screen.Result) {
            sourcePath = (screen.value as Screen.Result).source
            targetPath = (screen.value as Screen.Result).target
            targetName = Paths.get(targetPath).fileName.nameWithoutExtension
        } else throw NavigationException()
        //
        val licensePath = Settings.instance.licensePath
        if (licensePath == null || Files.exists(Paths.get(licensePath))) {
            CoroutineScope(Dispatchers.IO).launch {
                licensePath?.let { License().setLicense(it) }
                println("License is ${if (License.isValidLicense()) "valid" else "invalid"}")

                Comparer(sourcePath).use { comparison ->
                    comparison.add(targetPath)
                    try {
                        val fileType = FileType.fromFileNameOrExtension(targetPath)
                        resultPath = comparison.compare(
                            tempDir.resolve("Result_$targetName${fileType.extension}").toString(),
                            CompareOptions().apply {
                                detalisationLevel = Settings.instance.detalisationLevel
                                generateSummaryPage = Settings.instance.generateSummaryPage
                            }
                        ).toString()
                    } catch (e: Exception) {
                        _state.value = _state.value.copy(
                            errorMessage = "Converting error: ${e.message}",
                            isInProgress = false
                        )
                        return@use
                    }
                }
                _state.value = _state.value.copy(
                    sourcePath = sourcePath,
                    targetPath = targetPath,
                    resultPath = resultPath
                )
                displayResult(resultPath)
            }
        } else {
            _state.value = _state.value.copy(
                errorMessage = "License not found: '$licensePath'",
                isInProgress = false
            )
        }

    }

    private fun displayResult(resultPath: String) {
        println("Comparison result temporary saved to ${state.value.resultPath}")
        val pageList = mutableListOf<String>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = Document(resultPath)
                result.generatePreview(PreviewOptions {
                    val pagePath = tempDir.resolve("gd_${System.currentTimeMillis()}_page_$it.png")
                    pageList.add(pagePath.toString())
                    FileOutputStream(pagePath.toFile())
                }.apply {
                    previewFormat = PreviewFormats.PNG
                })
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    errorMessage = "Preview generating error: ${e.message}",
                    isInProgress = false
                )
                return@launch
            }
            _state.value = _state.value.copy(
                isInProgress = false,
                pageList = pageList
            )
        }
    }

    fun onDownload() {
        val resultName = state.value.resultName
        val extension =
            if (resultName.contains('.'))
                resultName.substring(resultName.lastIndexOf('.') + 1)
            else null
        JFileChooser().apply {
            extension?.let {
                fileFilter = FileNameExtensionFilter("Pdf file", extension)
            }
            selectedFile = File(resultName)
            if (showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                val resultPath = state.value.resultPath
                val downloadPath = selectedFile.path
                CoroutineScope(Dispatchers.IO).launch {
                    FileUtils.copyFile(File(resultPath), File(downloadPath))
                    withContext(Dispatchers.Main) {
                        _state.value = _state.value.copy(
                            infoMessage = "File was saved!"
                        )
                        delay(2500L)
                        _state.value = _state.value.copy(
                            infoMessage = null
                        )
                    }
                }
            }
        }
    }

    fun onDispose() {
        print("Deleting temporary files...")
        CoroutineScope(Dispatchers.IO).launch {
            state.value.pageList.toMutableList().apply {
                add(state.value.resultPath)
                forEach { path ->
                    try {
                        FileUtils.delete(File(path))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        println("Finished")
    }
}