package com.groupdocs.ui.usecase

import com.groupdocs.comparison.Document
import com.groupdocs.comparison.common.Utils
import com.groupdocs.comparison.options.PreviewOptions
import com.groupdocs.ui.manager.TempFolderManager
import com.groupdocs.ui.status.InternalServerException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.*
import java.nio.file.Files
import java.nio.file.Path

class RetrieveLocalFilePagesStreamUseCase(
    private val managerBeans: TempFolderManager
) : KoinComponent {
    suspend operator fun invoke(
        inputStream: InputStream,
        password: String,
        previewWidth: Int,
        previewRatio: Float,
        processStream: suspend (pageNumber: Int, inputStream: InputStream) -> Unit
    ) =
        withContext(Dispatchers.IO) {
            try {
                Document(inputStream, password).use { document ->
                    val pages = mutableMapOf<Int, Path>()

                    document.generatePreview(PreviewOptions({ pageNumber ->
                        val pathForTempFile = managerBeans.createPathForTempFile()
                        pages[pageNumber] = pathForTempFile
                        BufferedOutputStream(FileOutputStream(pathForTempFile.toFile()))
                    }) { pageNumber, stream ->
                        CoroutineScope(Dispatchers.Default).launch {
                            Utils.closeStreams(stream)

                            pages[pageNumber]?.let { pagePath ->
                                withContext(Dispatchers.IO) {
                                    BufferedInputStream(FileInputStream(pagePath.toFile())).use { inputStream ->
                                        processStream(pageNumber, inputStream)
                                    }
                                    Files.deleteIfExists(pagePath)
                                }
                            }
                        }
                    }.also { previewOptions ->
                        previewOptions.width = previewWidth
                        previewOptions.height = (previewWidth * previewRatio).toInt()
                    })
                }
            } catch (e: Exception) {
                throw RetrieveLocalFilePagesStreamException("Can't retrieve local file description", e)
            }
        }
}

class RetrieveLocalFilePagesStreamException(message: String, e: Throwable? = null) : InternalServerException(message, e)