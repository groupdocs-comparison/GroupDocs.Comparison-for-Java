package com.groupdocs.ui.settings

import com.groupdocs.ui.common.Settings


data class SettingsState(
    val errorMessage: String? = null,
    val licensePath: String? = Settings.instance.licensePath,
    val detalisationLevel: Int = Settings.instance.detalisationLevel,
    val generateSummaryPage: Boolean = Settings.instance.generateSummaryPage,
)

