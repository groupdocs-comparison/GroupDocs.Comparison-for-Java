package com.groupdocs.ui.comparison.ktor.usecase

import com.groupdocs.comparison.Comparer
import com.groupdocs.comparison.options.CompareOptions
import com.groupdocs.comparison.options.load.LoadOptions
import com.groupdocs.comparison.result.ChangeInfo
import com.groupdocs.ui.comparison.ktor.status.InternalServerException
import org.koin.core.component.KoinComponent
import java.io.OutputStream
import java.nio.file.Path

class CompareDocumentsUseCase : KoinComponent {
    operator fun invoke(
        sourcePath: Path,
        targetPath: Path,
        sourcePassword: String? = null,
        targetPassword: String? = null,
        outputStream: OutputStream
    ): List<ChangeInfo> {
        try {
            Comparer(sourcePath, LoadOptions(sourcePassword)).use { comparer ->
                comparer.apply {
                    add(targetPath, LoadOptions(targetPassword))
                    compare(outputStream, CompareOptions().apply {
                        showDeletedContent = true
                        detectStyleChanges = true
                        calculateCoordinates = true
                    })
                    return changes.toList()
                }
            }

        } catch (e: Exception) {
            throw CompareDocumentsException("Can't compare document ${sourcePath.fileName} with ${targetPath.fileName}", e)
        }
    }
}

class CompareDocumentsException(message: String, e: Throwable? = null) : InternalServerException(message, e)