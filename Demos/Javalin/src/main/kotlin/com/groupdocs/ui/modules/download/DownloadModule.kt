package com.groupdocs.ui.modules.download

import com.groupdocs.ui.util.InternalServerException
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject
import java.nio.file.Paths

fun Javalin.downloadModule() {
    val controller: DownloadController by inject(DownloadController::class.java)

    get("/comparison/downloadDocument") { ctx ->
        val guid = ctx.queryParam("guid") ?: throw InternalServerException("Document guid is not provided!")
        val guidAsPath = Paths.get(guid)
        ctx.header("Content-disposition", "attachment; filename=${guidAsPath.fileName}")
        ctx.header("Content-Description", "File Transfer")
        ctx.header("Content-Transfer-Encoding", "binary")
        ctx.header("Cache-Control", "must-revalidate")
        ctx.header("Pragma", "public")
        runBlocking {
            val inputStream = controller.download(fileName = guid)
            ctx.result(inputStream)
        }
    }
}