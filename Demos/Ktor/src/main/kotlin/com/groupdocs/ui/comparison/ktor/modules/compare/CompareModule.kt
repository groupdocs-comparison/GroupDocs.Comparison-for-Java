package com.groupdocs.ui.comparison.ktor.modules.compare

import com.groupdocs.ui.comparison.ktor.model.CompareRequest
import com.groupdocs.ui.comparison.ktor.model.ErrorResponse
import com.groupdocs.ui.comparison.ktor.status.InternalServerException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.compareModule() {
    val compareController by inject<CompareController>()

    post("/compare") {
        try {
            val request = call.receive<CompareRequest>()
            val response = compareController.compare(request)
            call.respond(HttpStatusCode.OK, response)
        } catch (e: InternalServerException) {
            call.respond(
                status = HttpStatusCode.InternalServerError,
                message = ErrorResponse(
                    message = if (e.message == "File's types are different or are not supported") {
                        "Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Comparison itself. Other probable reason of the error - documents types are different."
                    } else {
                        e.message
                    }
                )
            )
        }
    }
}