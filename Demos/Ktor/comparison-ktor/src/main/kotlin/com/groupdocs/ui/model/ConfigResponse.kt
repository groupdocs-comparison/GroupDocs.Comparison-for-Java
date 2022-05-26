package com.groupdocs.ui.model

data class ConfigResponse(
    val browse: Boolean = true,
    val download: Boolean = true,
    val enableRightClick: Boolean = true,
    val pageSelector: Boolean = true,
    val preloadResultPageCount: Int = 0,
    val print: Boolean = true,
    val rewrite: Boolean = true,
    val upload: Boolean = true
)