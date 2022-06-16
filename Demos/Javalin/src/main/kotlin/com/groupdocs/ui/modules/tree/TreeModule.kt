package com.groupdocs.ui.modules.tree

import com.groupdocs.ui.model.TreeRequest
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject

fun Javalin.treeModule() {
    val controller: TreeController by inject(TreeController::class.java)

    post("/comparison/loadFileTree") { ctx ->
        val request = ctx.bodyAsClass(TreeRequest::class.java)
        runBlocking {
            val response = controller.tree(request)
            ctx.json(response)
        }
    }
}