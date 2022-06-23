package com.groupdocs.ui.modules.tree

import com.groupdocs.ui.model.ConfigResponse
import com.groupdocs.ui.model.FileDescriptionEntity
import com.groupdocs.ui.model.TreeRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import kotlinx.coroutines.runBlocking

@Controller("/comparison")
class TreeController(
    @Inject private val treeBean: TreeBean
) {
    @Post("/loadFileTree")
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(request: TreeRequest): HttpResponse<List<FileDescriptionEntity>> {
        val response = runBlocking { treeBean.tree(request) }

        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}