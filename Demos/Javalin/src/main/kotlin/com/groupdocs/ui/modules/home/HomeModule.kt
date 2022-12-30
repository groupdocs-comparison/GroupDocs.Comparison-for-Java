package com.groupdocs.ui.modules.home

import io.javalin.Javalin

fun Javalin.homeModule() {
    get("/comparison") { ctx ->
        ClassLoader.getSystemResourceAsStream("view/index.html")?.let {
            ctx.contentType("text/html")
            ctx.result(it)
        }
    }

    get("/comparison/app-name") { ctx ->
        ctx.result("comparison-javalin")
    }
}