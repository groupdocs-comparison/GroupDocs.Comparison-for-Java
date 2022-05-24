package com.groupdocs.ui.modules.download

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Routing.downloadModule() {
    val downloadController by inject<DownloadController>()

    get("/comparison/downloadDocument") {
        val response = downloadController.download()
        call.respond(response)
//        call.respondBytes(HttpStatusCode.OK)
    }
}