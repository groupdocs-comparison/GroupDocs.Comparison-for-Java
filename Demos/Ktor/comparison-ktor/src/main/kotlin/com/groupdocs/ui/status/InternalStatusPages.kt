package com.groupdocs.ui.status

import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun StatusPagesConfig.internalStatusPages() {
    exception<InternalServerException> { call, cause ->
        call.respondText(cause.message, status = HttpStatusCode.InternalServerError)
    }
}

data class InternalServerException(override val message: String = "Internal server error") : Exception()