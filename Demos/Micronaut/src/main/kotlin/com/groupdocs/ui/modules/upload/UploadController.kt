package com.groupdocs.ui.modules.upload

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.model.ConfigResponse
import com.groupdocs.ui.util.InternalServerException
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.multipart.CompletedFileUpload
import jakarta.inject.Inject
import kotlinx.coroutines.runBlocking
import java.io.BufferedInputStream

@Controller("/comparison")
class UploadController(
    @Inject private val uploadBean: UploadBean,
    @Inject private val appConfig: ApplicationConfig
) {
    @Post("/uploadDocument", consumes = [MediaType.MULTIPART_FORM_DATA])
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(rewrite: Boolean, file: CompletedFileUpload?, url: String?): HttpResponse<*> {
        val isUploadEnabled = appConfig.common.upload
        if (!isUploadEnabled) {
            throw InternalServerException("Files uploading is disabled!")
        }

        val response = runBlocking {
            if (url == null) {
                file?.let { uploadedFile ->
                    BufferedInputStream(uploadedFile.inputStream).use { inputStream ->
                        return@let uploadBean.uploadDisk(uploadedFile.filename, inputStream)
                    }
                } ?: throw InternalServerException("Incorrect request!")
            } else {
                uploadBean.uploadUrl(url)
            }
        }
        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}