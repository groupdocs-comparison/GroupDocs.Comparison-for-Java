package com.groupdocs.ui.modules.upload

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Routing.uploadModule() {
    val uploadController by inject<UploadController>()

    post("/comparison/uploadDocument") {
        val response = uploadController.upload()
        call.respond(response)
//        call.respondBytes(HttpStatusCode.OK)
    }
}