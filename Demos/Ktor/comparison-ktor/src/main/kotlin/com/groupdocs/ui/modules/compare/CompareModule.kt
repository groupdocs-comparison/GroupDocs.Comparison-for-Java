package com.groupdocs.ui.modules.compare

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Routing.compareModule() {
    val compareController by inject<CompareController>()

    post("/comparison/compare") {
        val response = compareController.compare()
        call.respond(response)
//        call.respondBytes(HttpStatusCode.OK)
    }
}