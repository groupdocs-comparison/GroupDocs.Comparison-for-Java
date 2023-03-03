package com.groupdocs.ui.comparison.compose.settings

import com.groupdocs.comparison.options.style.DetalisationLevel
import com.groupdocs.ui.comparison.compose.common.Settings


data class SettingsState(
    val errorMessage: String? = null,
    val licensePath: String? = Settings.instance.licensePath,
    val detalisationLevel: DetalisationLevel = Settings.instance.detalisationLevel,
    val generateSummaryPage: Boolean = Settings.instance.generateSummaryPage,
)

