package com.groupdocs.ui.modules.compare

import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.model.*
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.usecase.CompareDocumentsUseCase
import com.groupdocs.ui.usecase.RetrieveLocalFilePagesStreamUseCase
import com.groupdocs.ui.util.InternalServerException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.*
import java.nio.file.Files
import java.util.*
import kotlin.io.path.extension

class CompareControllerImpl(
    private val checkAreFilesSupported: AreFilesSupportedUseCase,
    private val compareDocuments: CompareDocumentsUseCase,
    private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesStreamUseCase,
    private val pathManager: PathManager
) : BaseController(), CompareController, KoinComponent {

    override suspend fun compare(request: CompareRequest): CompareResponse {
        val (sourceDocument, targetDocument) = request.guids
        val sourceFile = sourceDocument.guid
        val targetFile = targetDocument.guid

        val sourceFilePath = pathManager.assertPathIsInsideFilesDirectory(sourceFile)
        val targetFilePath = pathManager.assertPathIsInsideFilesDirectory(targetFile)

        if (!checkAreFilesSupported(sourceFilePath.fileName.toString(), targetFilePath.fileName.toString())) {
            throw InternalServerException("File's types are different or are not supported") // TODO: Need another exception type
        }

        val sourcePassword = sourceDocument.password
        val targetPassword = targetDocument.password

        val resultExtension = sourceFilePath.fileName.extension
        val resultPath = pathManager.createPathForResultFile(
            sourceName = sourceFilePath.fileName.toString(),
            targetName = targetFilePath.fileName.toString(),
            extension = resultExtension
        )
        if (Files.notExists(resultPath.parent)) {
            throw InternalServerException("Result directory does not exist. Update 'resultDirectory' property in config or create directory with name 'ResultFiles' in the folder where files are placed") // TODO: Need another exception type
        }
        val changeInfos = withContext(Dispatchers.IO) {
            BufferedOutputStream(FileOutputStream(resultPath.toFile())).use { outputStream ->
                return@withContext compareDocuments(
                    sourcePath = sourceFilePath,
                    sourcePassword = sourcePassword,
                    targetPath = targetFilePath,
                    targetPassword = targetPassword,
                    outputStream = outputStream
                )
            }
        }
        val pages = withContext(Dispatchers.IO) {
            val pages = mutableListOf<ComparePage>()
            val previewPageWidth = appConfig.comparison.previewPageWidthOrDefault
            val previewPageRatio = appConfig.comparison.previewPageRatioOrDefault

            BufferedInputStream(FileInputStream(resultPath.toFile())).use { inputStream ->
                retrieveLocalFilePagesStream(
                    inputStream = inputStream,
                    previewWidth = previewPageWidth,
                    previewRatio = previewPageRatio
                ) { pageNumber, pageInputStream ->
                    val data = Base64.getEncoder().encodeToString(pageInputStream.readBytes())
                    pages.add(
                        ComparePage(
                            number = pageNumber - 1,
                            width = previewPageWidth,
                            height = (previewPageWidth * previewPageRatio).toInt(),
                            data = data
                        )
                    )
                }
            }
            pages
        }

        val changes = changeInfos.map { changeInfo ->
            DocumentChange(
                id = changeInfo.id,
                type = changeInfo.type.toInt(),
                comparisonAction = changeInfo.comparisonAction.toInt(),
                sourceText = changeInfo.sourceText,
                targetText = changeInfo.targetText,
                text = changeInfo.text ?: "",
                componentType = changeInfo.componentType,
                box = ChangeBox(
                    x = changeInfo.box.x,
                    y = changeInfo.box.y,
                    width = changeInfo.box.width,
                    height = changeInfo.box.height
                ),
                authors = changeInfo.authors ?: emptyList(),
                pageInfo = PageInfo(
                    pageNumber = changeInfo.pageInfo.pageNumber,
                    width = changeInfo.pageInfo.width,
                    height = changeInfo.pageInfo.height
                ),
                styleChanges = (changeInfo.styleChanges  ?: emptyList()).map { styleChangeInfo ->
                    StyleChange(
                        propertyName = styleChangeInfo.propertyName,
                        oldValue = styleChangeInfo.oldValue,
                        newValue = styleChangeInfo.newValue
                    )
                }
            )
        }

        val filesDirectory = pathManager.filesDirectory
        val resultDirectory = pathManager.resultDirectory

        val guid = if (resultDirectory.startsWith(filesDirectory)) {
            filesDirectory.relativize(resultPath)
        } else resultDirectory.relativize(resultPath)

        return CompareResponse(
            guid = guid.toString(),
            changes = changes,
            pages = pages,
            extension = resultExtension
        )
    }
}

interface CompareController {
    suspend fun compare(request: CompareRequest): CompareResponse
}