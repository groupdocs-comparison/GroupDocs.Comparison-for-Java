package com.groupdocs.ui.comparison.compose.home

import java.nio.file.Paths

data class HomeState(
    val isInProgress: Boolean = false,
    val sourceError: String? = null,
    val targetError: String? = null,
    val sourcePath: String? = null,
    val targetPath: String? = null,
) {
    val isSourcePresent: Boolean = !sourcePath.isNullOrEmpty()
    val isTargetPresent: Boolean = !targetPath.isNullOrEmpty()

    val sourceFileName: String? get() = sourcePath?.let { Paths.get(it).fileName.toString() }
    val targetFileName: String? get() = targetPath?.let { Paths.get(it).fileName.toString() }
}

