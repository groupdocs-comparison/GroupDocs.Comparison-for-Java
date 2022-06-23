package com.groupdocs.ui.modules.download

import com.groupdocs.ui.model.ConfigResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking
import java.io.BufferedInputStream
import java.nio.charset.StandardCharsets
import java.nio.file.Paths

@Singleton
@Controller("/comparison")
class DownloadController(
    @Inject private val downloadBean: DownloadBean
) {
    @Get("/downloadDocument")
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(@QueryValue guid: String): HttpResponse<*> {
        val decodedGuid = java.net.URLDecoder.decode(guid, StandardCharsets.UTF_8.name())
        val guidAsPath = Paths.get(decodedGuid)

        val inputStream = runBlocking { downloadBean.download(fileName = decodedGuid) }

        return HttpResponse.ok<ConfigResponse>()
            .header("Content-disposition", "attachment; filename=${guidAsPath.fileName}")
            .header("Content-Description", "File Transfer")
            .header("Content-Transfer-Encoding", "binary")
            .header("Cache-Control", "must-revalidate")
            .header("Pragma", "public")
            .body(BufferedInputStream(inputStream))
    }
}