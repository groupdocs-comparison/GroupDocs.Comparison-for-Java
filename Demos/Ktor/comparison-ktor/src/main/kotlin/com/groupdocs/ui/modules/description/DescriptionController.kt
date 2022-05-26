package com.groupdocs.ui.modules.description

import com.groupdocs.ui.model.DescriptionRequest
import com.groupdocs.ui.model.LoadDocumentEntity
import com.groupdocs.ui.model.PageDescriptionEntity
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.usecase.RetrieveLocalFilePagesStreamUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.util.*

class DescriptionControllerImpl(
    private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesStreamUseCase
) : BaseController(), DescriptionController, KoinComponent {
    override suspend fun description(request: DescriptionRequest): LoadDocumentEntity {
        val path = makeSurePathIsInsideFilesDirectory(request.guid)
        val password = request.password
        val previewPageWidth = applicationConfig.comparison.previewPageWidth
        val previewPageRatio = applicationConfig.comparison.previewPageRatio

        val entity = LoadDocumentEntity(
            guid = request.guid,
            printAllowed = applicationConfig.common.print
        )
        withContext(Dispatchers.IO) {
            BufferedInputStream(FileInputStream(path.toFile())).use { inputStream ->
                retrieveLocalFilePagesStream(
                    inputStream = inputStream,
                    password = password,
                    previewWidth = previewPageWidth,
                    previewRatio = previewPageRatio
                ) { pageNumber, pageInputStream ->
                    val data = withContext(Dispatchers.IO) {
                        Base64.getEncoder().encodeToString(pageInputStream.readAllBytes())
                    }
                    entity.pages.add(
                        PageDescriptionEntity(
                            number = pageNumber,
                            width = previewPageWidth,
                            height = (previewPageWidth * previewPageRatio).toInt(),
                            data = data
                        )
                    )
                }
            }
        }
        return entity
    }

}

interface DescriptionController {
    suspend fun description(request: DescriptionRequest): LoadDocumentEntity
}