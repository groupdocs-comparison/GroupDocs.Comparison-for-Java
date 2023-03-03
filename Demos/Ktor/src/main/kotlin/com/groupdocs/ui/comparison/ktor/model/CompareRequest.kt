package com.groupdocs.ui.comparison.ktor.model

data class CompareRequest(
    val guids: List<CompareDocument> = emptyList()
)

data class CompareDocument(
    val guid: String,
    val password: String? = null
)