package com.groupdocs.ui.modules.description

import com.groupdocs.ui.model.DescriptionRequest
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Routing.descriptionModule() {
    val descriptionController by inject<DescriptionController>()

    post("/comparison/loadDocumentDescription") {
        val request = call.receive<DescriptionRequest>()
        val response = descriptionController.description(request)
        call.respond(response)
//        call.respondBytes(HttpStatusCode.OK)
    }
}