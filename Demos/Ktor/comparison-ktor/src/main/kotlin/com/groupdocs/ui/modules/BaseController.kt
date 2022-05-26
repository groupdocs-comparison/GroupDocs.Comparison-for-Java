package com.groupdocs.ui.modules

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.status.InternalServerException
import org.koin.java.KoinJavaComponent.inject
import java.nio.file.Path
import java.nio.file.Paths

open class BaseController {

    protected val applicationConfig by inject<ApplicationConfig>(ApplicationConfig::class.java)
    protected fun makeSurePathIsInsideFilesDirectory(pathToCheck: String): Path {
        val filesDirectory = Paths.get(applicationConfig.local.filesDirectory).toAbsolutePath().normalize()
        val path = filesDirectory.resolve(pathToCheck).toAbsolutePath().normalize()

        if (!path.startsWith(filesDirectory)) {
            // Avoid accessing to any directory outside filesDirectory
            throw AccessDeniedException()
        }
        return path
    }
}

class AccessDeniedException(message: String = "Access denied!") : InternalServerException(message,)