package com.groupdocs.ui.modules.compare

import com.groupdocs.ui.model.CompareRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.compareModule() {
    val compareController by inject<CompareController>()

    post("/compare") {
        val request = call.receive<CompareRequest>()
        val response = compareController.compare(request)
        call.respond(HttpStatusCode.OK, response)
    }
}