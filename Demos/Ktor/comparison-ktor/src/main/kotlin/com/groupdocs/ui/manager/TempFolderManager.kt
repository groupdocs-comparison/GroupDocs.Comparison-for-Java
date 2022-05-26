package com.groupdocs.ui.manager

import com.groupdocs.ui.Defaults
import org.koin.core.component.KoinComponent
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

/**
 * Manages path to temp directory according to config
 * Does not create or check is any directory exist
 */
class TempFolderManagerImpl(
    private val applicationConfig: com.groupdocs.ui.config.ApplicationConfig
) : TempFolderManager, KoinComponent {
    private val tempDirectory: Path by lazy {
        val absoluteOrRelativeTempDirectory = Paths.get(applicationConfig.comparison.tempDirectoryOrDefault)
        if (absoluteOrRelativeTempDirectory.isAbsolute) {
            absoluteOrRelativeTempDirectory
        } else if (applicationConfig.comparison.filesProviderTypeOrDefault == Defaults.Comparison.FilesProviderType.LOCAL) {
            applicationConfig.local.filesDirectoryOrDefault.resolve(absoluteOrRelativeTempDirectory)
        } else {
            absoluteOrRelativeTempDirectory
        }.toAbsolutePath().normalize()
    }

    override fun createPathForTempFile(): Path = tempDirectory.resolve("gd_${UUID.randomUUID()}.tmp")
}

interface TempFolderManager {
    fun createPathForTempFile(): Path
}