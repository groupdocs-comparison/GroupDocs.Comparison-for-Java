package com.groupdocs.ui.modules.config

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Routing.configModule() {
    val configController by inject<ConfigController>()

    get("/comparison/loadConfig") {
        val response = configController.config()
        call.respond(response)
//        call.respondBytes(HttpStatusCode.OK)
    }
}