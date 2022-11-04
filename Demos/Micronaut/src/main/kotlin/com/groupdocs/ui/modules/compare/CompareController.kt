package com.groupdocs.ui.modules.compare

import com.groupdocs.ui.model.CompareRequest
import com.groupdocs.ui.model.CompareResponse
import com.groupdocs.ui.model.ConfigResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking

@Singleton
@Controller("/comparison")
class CompareController(
    @Inject private val compareBean: CompareBean
) {
    @Post("/compare")
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(request: CompareRequest): HttpResponse<CompareResponse> {
        val response = runBlocking { compareBean.compare(request) }

        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}