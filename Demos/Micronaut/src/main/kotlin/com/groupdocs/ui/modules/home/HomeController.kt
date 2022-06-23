package com.groupdocs.ui.modules.home

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.View
import java.net.URI

@Controller("/")
class HomeController {
    @Get("/")
    fun home(): HttpResponse<String> {
        return HttpResponse.redirect(URI("/comparison"))
    }

    @View("comparison")
    @Get("/comparison")
    fun comparison() {

    }
}