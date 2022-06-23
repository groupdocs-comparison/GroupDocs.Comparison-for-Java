package com.groupdocs.ui.modules.description

import com.groupdocs.ui.model.ConfigResponse
import com.groupdocs.ui.model.DescriptionRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import kotlinx.coroutines.runBlocking

@Controller("/comparison")
class DescriptionController(
    @Inject private val descriptionBean: DescriptionBean
) {
    @Post("/loadDocumentDescription")
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(request: DescriptionRequest): HttpResponse<*> {
        val response = runBlocking { descriptionBean.description(request) }

        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}