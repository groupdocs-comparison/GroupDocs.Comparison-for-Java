package com.groupdocs.ui.modules.home

import com.groupdocs.ui.model.HomeRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Routing.homeModule() {
    val homeController by inject<HomeController>()

    get("/comparison") {
        val request = HomeRequest(123)//call.receive<HomeRequest>()
        val response = homeController.home(request)
        call.respond(response)
//        call.respond(HttpStatusCode.OK)
    }
}