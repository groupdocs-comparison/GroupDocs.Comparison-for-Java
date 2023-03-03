package com.groupdocs.ui.comparison.ktor.usecase

import com.groupdocs.ui.comparison.ktor.status.InternalServerException
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
            "bmp",
            "csv",
            "doc",
            "docx",
            "html",
            "jpeg",
            "jpg",
            "ods",
            "odt",
            "pdf",
            "png",
            "ppt",
            "pptx",
            "txt",
            "vsdx",
            "vss",
            "xls",
            "xlsx"
        )
    }
}

class AreFilesSupportedException(message: String, e: Throwable? = null) : InternalServerException(message, e)