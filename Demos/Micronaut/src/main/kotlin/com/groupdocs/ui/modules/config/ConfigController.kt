package com.groupdocs.ui.modules.config

import com.groupdocs.ui.model.ConfigResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking

@Singleton
@Controller("/comparison")
class ConfigController(
    @Inject val configBean: ConfigBean
) {
    @Get("/loadConfig")
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(): HttpResponse<*> {
        val response = runBlocking { configBean.config() }

        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}