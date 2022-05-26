package com.groupdocs.ui.modules.home

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*


fun Routing.homeModule() {
    get("/comparison") {
        call.respondHtmlTemplate(HomeTemplate()) {
            pageTitle {
                +"GroupDocs.Comparison for Java Spring"
            }
        }
    }
}