package com.groupdocs.ui

import com.groupdocs.ui.modules.compare.compareModule
import com.groupdocs.ui.modules.config.configModule
import com.groupdocs.ui.modules.description.descriptionModule
import com.groupdocs.ui.modules.download.downloadModule
import com.groupdocs.ui.modules.home.homeModule
import com.groupdocs.ui.modules.page.pageModule
import com.groupdocs.ui.modules.tree.treeModule
import com.groupdocs.ui.modules.upload.uploadModule
import com.groupdocs.ui.status.generalStatusPages
import com.groupdocs.ui.status.internalStatusPages
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import org.slf4j.event.Level

fun Application.module() {
    install(CallLogging) {
        level = Level.DEBUG
        filter { call -> call.request.path().startsWith("/comparison") }
    }
    install(ContentNegotiation) { gson { } }
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }
    install(StatusPages) {
        generalStatusPages()
        internalStatusPages()
    }
//    data class MySession(val count: Int = 0)
//    install(Sessions) {
//        cookie<MySession>("MY_SESSION") {
//            cookie.extensions["SameSite"] = "lax"
//        }
//    }


    install(Routing) {
        static("/static") {
            resources("static")
        }
        homeModule()
        configModule()
        treeModule()
        downloadModule()
        uploadModule()
        compareModule()
        pageModule()
        descriptionModule()
    }
}