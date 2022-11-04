package com.groupdocs.ui.modules.compare

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.model.*
import com.groupdocs.ui.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.usecase.CompareDocumentsUseCase
import com.groupdocs.ui.usecase.RetrieveLocalFilePagesStreamUseCase
import com.groupdocs.ui.util.InternalServerException
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.*
import kotlin.io.path.extension

interface CompareBean {
    suspend fun compare(request: CompareRequest): CompareResponse
}

@Bean(typed = [CompareBean::class])
@Singleton
class CompareBeanImpl(
    @Inject private val checkAreFilesSupported: AreFilesSupportedUseCase,
    @Inject private val compareDocuments: CompareDocumentsUseCase,
    @Inject private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesStreamUseCase,
    @Inject private val pathManager: PathManager,
    @Inject private val appConfig: ApplicationConfig
) : CompareBean {
    override suspend fun compare(request: CompareRequest): CompareResponse {
        val (sourceDocument, targetDocument) = request.guids
        val sourceFile = URLDecoder.decode(sourceDocument.guid, StandardCharsets.UTF_8)
        val targetFile = URLDecoder.decode(targetDocument.guid, StandardCharsets.UTF_8)

        val sourceFilePath = pathManager.assertPathIsInsideFilesDirectory(sourceFile)
        val targetFilePath = pathManager.assertPathIsInsideFilesDirectory(targetFile)

        if (!checkAreFilesSupported(sourceFilePath.fileName.toString(), targetFilePath.fileName.toString())) {
            throw InternalServerException("Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Comparison itself. Other probable reason of the error - documents types are different.") // TODO: Need another exception type
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
            throw InternalServerException("Result directory does not exist") // TODO: Need another exception type
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

        val changes = changeInfos.map { changeInfo ->
            DocumentChange(
                id = changeInfo.id,
                type = changeInfo.type,
                comparisonAction = changeInfo.comparisonAction,
                sourceText = changeInfo.sourceText,
                targetText = changeInfo.targetText,
                text = changeInfo.text,
                componentType = changeInfo.componentType,
                box = ChangeBox(
                    x = changeInfo.box.x,
                    y = changeInfo.box.y,
                    width = changeInfo.box.width,
                    height = changeInfo.box.height
                ),
                authors = changeInfo.authors,
                pageInfo = PageInfo(
                    pageNumber = changeInfo.pageInfo.pageNumber,
                    width = changeInfo.pageInfo.width,
                    height = changeInfo.pageInfo.height
                ),
                styleChanges = changeInfo.styleChanges?.map { styleChangeInfo ->
                    StyleChange(
                        propertyName = styleChangeInfo.propertyName,
                        oldValue = styleChangeInfo.oldValue,
                        newValue = styleChangeInfo.newValue
                    )
                } ?: listOf()
            )
        }

        val filesDirectory = pathManager.filesDirectory
        val resultDirectory = pathManager.resultDirectory

        val guid = if (resultDirectory.startsWith(filesDirectory)) {
            filesDirectory.relativize(resultPath)
        } else resultDirectory.relativize(resultPath)

        return CompareResponse(
            guid = URLEncoder.encode(guid.toString(), StandardCharsets.UTF_8),
            changes = changes,
            pages = pages,
            extension = resultExtension
        )
    }
}