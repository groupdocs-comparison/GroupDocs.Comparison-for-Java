package com.groupdocs.ui.modules.tree

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Routing.treeModule() {
    val treeController by inject<TreeController>()

    post("/comparison/loadFileTree") {
        val response = treeController.tree()
        call.respond(response)
//        call.respondBytes(HttpStatusCode.OK)
    }
}