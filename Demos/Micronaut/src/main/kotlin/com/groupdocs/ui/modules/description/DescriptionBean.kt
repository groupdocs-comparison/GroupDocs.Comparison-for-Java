package com.groupdocs.ui.modules.description

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.model.DescriptionRequest
import com.groupdocs.ui.model.LoadDocumentEntity
import com.groupdocs.ui.model.PageDescriptionEntity
import com.groupdocs.ui.usecase.RetrieveLocalFilePagesStreamUseCase
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*

interface DescriptionBean {
    suspend fun description(request: DescriptionRequest): LoadDocumentEntity
}

@Bean(typed = [DescriptionBean::class])
@Singleton
class DescriptionBeanImpl(
    @Inject private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesStreamUseCase,
    @Inject private val pathManager: PathManager,
    @Inject private val appConfig: ApplicationConfig
) : DescriptionBean {
    override suspend fun description(request: DescriptionRequest): LoadDocumentEntity {
        val guid = URLDecoder.decode(request.guid, StandardCharsets.UTF_8.toString())
        val path = pathManager.assertPathIsInsideFilesDirectory(guid)
        val password = request.password
        val previewPageWidth = appConfig.comparison.previewPageWidthOrDefault
        val previewPageRatio = appConfig.comparison.previewPageRatioOrDefault

        val entity = LoadDocumentEntity(
            guid = URLEncoder.encode(guid, StandardCharsets.UTF_8.toString()),
            printAllowed = appConfig.common.print
        )
        return withContext(Dispatchers.IO) {
            BufferedInputStream(FileInputStream(path.toFile())).use { inputStream ->
                retrieveLocalFilePagesStream(
                    inputStream = inputStream,
                    password = password,
                    previewWidth = previewPageWidth,
                    previewRatio = previewPageRatio
                ) { pageNumber, pageInputStream ->
                    val data = Base64.getEncoder().encodeToString(pageInputStream.readBytes())
                    entity.pages.add(
                        PageDescriptionEntity(
                            number = pageNumber - 1,
                            width = previewPageWidth,
                            height = (previewPageWidth * previewPageRatio).toInt(),
                            data = data
                        )
                    )
                }
                entity
            }
        }
    }

}