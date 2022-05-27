package com.groupdocs.ui.usecase

import com.groupdocs.ui.status.InternalServerException
import io.ktor.util.*
import org.koin.core.component.KoinComponent
import java.nio.file.Paths

class AreFilesSupportedUseCase : KoinComponent {
    operator fun invoke(sourceFileName: String, targetFileName: String): Boolean {
        sourceFileName.ifBlank {
            throw AreFilesSupportedException("Source file name can't be blank")
        }
        targetFileName.ifBlank {
            throw AreFilesSupportedException("Target file name can't be blank")
        }

        val sourceExtension = Paths.get(sourceFileName).extension
        val targetExtension = Paths.get(targetFileName).extension

        return (sourceExtension == targetExtension && sourceExtension in SUPPORTED_EXTENSIONS)
    }

    companion object {
        val SUPPORTED_EXTENSIONS = listOf(
            "doc",
            "docx",
            "xls",
            "xlsx",
            "ppt",
            "pptx",
            "pdf",
            "png",
            "txt",
            "html",
            "htm",
            "jpg",
            "jpeg"
        )
    }
}

class AreFilesSupportedException(message: String, e: Throwable? = null) : InternalServerException(message, e)