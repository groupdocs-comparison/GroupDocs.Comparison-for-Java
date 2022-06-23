package com.groupdocs.ui.modules.upload

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.model.UploadResponse
import com.groupdocs.ui.usecase.SaveStreamToFilesDirectoryUseCase
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.net.URL
import java.nio.file.Paths

interface UploadBean {
    suspend fun uploadDisk(fileName: String, inputStream: BufferedInputStream): UploadResponse
    suspend fun uploadUrl(fileUrl: String): UploadResponse
}

@Bean(typed = [UploadBean::class])
@Singleton
class UploadBeanImpl(
    @Inject private val saveStreamToFilesDirectory: SaveStreamToFilesDirectoryUseCase,
    @Inject private val appConfig: ApplicationConfig
) : UploadBean {
    override suspend fun uploadDisk(fileName: String, inputStream: BufferedInputStream): UploadResponse {
        saveStreamToFilesDirectory(fileName, inputStream, appConfig.common.rewrite)
        return UploadResponse(fileName)
    }

    override suspend fun uploadUrl(fileUrl: String): UploadResponse {
        val url = URL(fileUrl)
        val fileName = Paths.get(url.path).fileName.toString()

        withContext(Dispatchers.IO) {
            url.openStream().use { inputStream ->
                saveStreamToFilesDirectory(fileName, inputStream, appConfig.common.rewrite)
            }
        }
        return UploadResponse(fileName)
    }
}