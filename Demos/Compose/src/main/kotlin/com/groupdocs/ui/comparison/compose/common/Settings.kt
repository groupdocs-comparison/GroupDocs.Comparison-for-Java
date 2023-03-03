package com.groupdocs.ui.comparison.compose.common

import com.groupdocs.comparison.options.style.DetalisationLevel
import java.io.*
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

class SettingsException(message: String) : RuntimeException(message)

class Settings private constructor(val path: Path) {
    private val properties: Properties = Properties()

    init {
        BufferedInputStream(FileInputStream(path.toFile())).use {
            properties.load(it)
        }
    }

    var licensePath: String?
        get() = properties.getProperty("licensePath")?.ifBlank { null }
        set(value) {
            properties.setProperty("licensePath", if (value.isNullOrBlank()) "" else value)
        }

    var detalisationLevel: DetalisationLevel
        get() =
            when (properties.getProperty("detalizationLevel", "Middle")) {
                "Low" -> DetalisationLevel.LOW
                "High" -> DetalisationLevel.HIGH
                else -> DetalisationLevel.MIDDLE
            }
        set(value) {
            properties.setProperty(
                "detalizationLevel", when (value) {
                    DetalisationLevel.LOW -> "Low"
                    DetalisationLevel.HIGH -> "High"
                    else -> "Middle"
                }
            )
        }

    var generateSummaryPage: Boolean
        get() =
            properties.getProperty("generateSummaryPage", "false") == "true"
        set(value) {
            properties.setProperty("generateSummaryPage", value.toString())
        }


    fun save() {
        BufferedOutputStream(FileOutputStream(path.toFile())).use {
            properties.store(it, "Application settings")
        }
    }

    companion object {

        private val settingsPath: Path = Paths.get(System.getProperty("user.home")).resolve("groupdocs-comparison-compose.properties")
        private var _instance: Settings? = null

        val instance: Settings
            get() {
                if (_instance == null) {
                    println("Settings path: $settingsPath")
                    if (Files.notExists(settingsPath)) {
                        try {
                            Files.createFile(settingsPath)
                        } catch (e: Exception) {
                            throw SettingsException("Error: can't create file '${e.message}'")
                        }
                    }
                    if (Files.exists(settingsPath)) {
                        _instance = Settings(settingsPath)
                    }
                }
                return _instance!!
            }
    }
}