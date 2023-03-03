package com.groupdocs.ui.comparison.ktor.modules.page

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.pageModule() {
    val pageController by inject<PageController>()

    post("/loadDocumentPage") {
        val response = pageController.page()
        call.respond(response)
//        call.respondBytes(HttpStatusCode.OK)
    }
}