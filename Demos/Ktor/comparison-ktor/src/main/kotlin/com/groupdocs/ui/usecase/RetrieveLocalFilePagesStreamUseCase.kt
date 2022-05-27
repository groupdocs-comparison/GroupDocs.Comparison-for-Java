package com.groupdocs.ui.usecase

import com.groupdocs.comparison.Document
import com.groupdocs.comparison.common.Utils
import com.groupdocs.comparison.options.PreviewOptions
import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.status.InternalServerException
import org.koin.core.component.KoinComponent
import java.io.*
import java.nio.file.Files
import java.nio.file.Path

class RetrieveLocalFilePagesStreamUseCase(
    private val managerBeans: PathManager
) : KoinComponent {
    operator fun invoke(
        inputStream: InputStream,
        password: String? = null,
        previewWidth: Int,
        previewRatio: Float,
        processStream: (pageNumber: Int, inputStream: InputStream) -> Unit
    ) =
        try {
            Document(inputStream, password).use { document ->
                val pages = mutableMapOf<Int, Path>()

                document.generatePreview(PreviewOptions({ pageNumber ->
                    val pathForTempFile = managerBeans.createPathForTempFile()
                    pages[pageNumber] = pathForTempFile
                    BufferedOutputStream(FileOutputStream(pathForTempFile.toFile()))
                }) { pageNumber, stream ->
                    Utils.closeStreams(stream)

                    pages[pageNumber]?.let { pagePath ->
                        BufferedInputStream(FileInputStream(pagePath.toFile())).use { inputStream ->
                            processStream(pageNumber, inputStream)
                        }
                        Files.deleteIfExists(pagePath)
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

class RetrieveLocalFilePagesStreamException(message: String, e: Throwable? = null) : InternalServerException(message, e)