package com.groupdocs.ui.modules.description

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Routing.descriptionModule() {
    val descriptionController by inject<DescriptionController>()

    post("/comparison/loadDocumentDescription") {
        val response = descriptionController.description()
        call.respond(response)
//        call.respondBytes(HttpStatusCode.OK)
    }
}