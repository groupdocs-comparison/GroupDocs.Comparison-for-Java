package com.groupdocs.ui.modules.compare

import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.model.ComparePage
import com.groupdocs.ui.model.CompareRequest
import com.groupdocs.ui.model.CompareResponse
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.status.InternalServerException
import com.groupdocs.ui.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.usecase.CompareDocumentsUseCase
import com.groupdocs.ui.usecase.RetrieveLocalFilePagesStreamUseCase
import io.ktor.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

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
        val changes = withContext(Dispatchers.IO) {
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
            val previewPageWidth = applicationConfig.comparison.previewPageWidthOrDefault
            val previewPageRatio = applicationConfig.comparison.previewPageRatioOrDefault

            BufferedInputStream(FileInputStream(resultPath.toFile())).use { inputStream ->
                retrieveLocalFilePagesStream(
                    inputStream = inputStream,
                    previewWidth = previewPageWidth,
                    previewRatio = previewPageRatio
                ) { pageNumber, pageInputStream ->
                    val data = Base64.getEncoder().encodeToString(pageInputStream.readAllBytes())
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

        val resultDirectory = pathManager.resultDirectory
        return CompareResponse(
            guid = resultDirectory.relativize(resultPath).toString(),
            changes = changes,
            extension = resultExtension,
            pages = pages
        )
    }

}

interface CompareController {
    suspend fun compare(request: CompareRequest): CompareResponse
}