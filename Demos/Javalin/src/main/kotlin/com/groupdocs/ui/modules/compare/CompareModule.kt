package com.groupdocs.ui.modules.compare

import com.groupdocs.ui.model.CompareRequest
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject

fun Javalin.compareModule() {
    val controller: CompareController by inject(CompareController::class.java)

    post("/comparison/compare") { ctx ->
        val request = ctx.bodyAsClass(CompareRequest::class.java)
        runBlocking {
            val response = controller.compare(request)
            ctx.json(response)
        }
    }
}