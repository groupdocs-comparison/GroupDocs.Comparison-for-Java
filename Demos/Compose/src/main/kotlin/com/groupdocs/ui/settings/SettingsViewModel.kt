package com.groupdocs.ui.settings

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.groupdocs.ui.common.Screen
import com.groupdocs.ui.common.Settings
import com.groupdocs.ui.common.SettingsException
import com.groupdocs.ui.openInBrowser
import java.net.URI
import java.nio.file.Files
import java.nio.file.Paths
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter


class SettingsViewModel(private val screen: MutableState<Screen>) {
    private val _state: MutableState<SettingsState> = mutableStateOf(SettingsState())
    val state: State<SettingsState> = _state

    init {
        try {
            _state.value = _state.value.copy(
                licensePath = Settings.instance.licensePath
            )
        } catch (e: SettingsException) {
            _state.value = _state.value.copy(
                errorMessage = e.message
            )
        }
    }

    fun saveSettings() {
        Settings.instance.licensePath = state.value.licensePath
        Settings.instance.detalisationLevel = state.value.detalisationLevel
        Settings.instance.generateSummaryPage = state.value.generateSummaryPage
        Settings.instance.save()

        screen.value = Screen.Home
    }

    fun resetLicense() {
        _state.value = _state.value.copy(
            licensePath = null
        )
    }

    fun selectLicense() {
        JFileChooser().apply {
            fileFilter = FileNameExtensionFilter("License file", "lic")
            val licensePath = _state.value.licensePath
            if (!licensePath.isNullOrBlank()){
                val path = Paths.get(licensePath)
                if (Files.exists(path)) {
                    selectedFile = path.parent.toFile()
                }
            }
            isAcceptAllFileFilterUsed = false
            if (showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                _state.value = _state.value.copy(
                    licensePath = selectedFile.path
                )
            }
        }
    }

    fun onLicenseChanged(value: String) {
        _state.value = _state.value.copy(
            licensePath = value
        )
    }

    fun onDetalisationLevelChanged(value: Int) {
        _state.value = _state.value.copy(
            detalisationLevel = value
        )
    }

    fun onGenerateSummaryPageChanged(value: Boolean) {
        _state.value = _state.value.copy(
            generateSummaryPage = value
        )
    }

    fun openDocumentation() {
        try {
            openInBrowser(URI("https://docs.groupdocs.com/comparison/java/comparison/"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}