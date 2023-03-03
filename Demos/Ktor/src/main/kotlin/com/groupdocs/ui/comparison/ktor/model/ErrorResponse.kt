package com.groupdocs.ui.comparison.ktor.model

data class ErrorResponse(
    val message: String,
    val exception: Exception? = null
)
