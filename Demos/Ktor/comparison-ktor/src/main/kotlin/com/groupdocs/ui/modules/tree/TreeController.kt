package com.groupdocs.ui.modules.tree

import com.groupdocs.comparison.result.FileType
import com.groupdocs.ui.model.FileDescriptionEntity
import com.groupdocs.ui.model.TreeRequest
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.usecase.GetLocalFilesUseCase
import com.groupdocs.ui.usecase.LocalStorageEntry
import org.koin.core.component.KoinComponent

class TreeControllerImpl(
    private val getLocalFiles: GetLocalFilesUseCase
) : BaseController(), TreeController, KoinComponent {
    override suspend fun tree(request: TreeRequest): List<FileDescriptionEntity> {
        val path = makeSurePathIsInsideFilesDirectory(request.path)

        val localFiles = getLocalFiles(path)
        return localFiles.sortedBy {
            it is LocalStorageEntry.File
        }.map {
            val docType = if (it is LocalStorageEntry.File) FileType.fromFileNameOrExtension(it.name).fileFormat else null
            val isDirectory = it is LocalStorageEntry.Directory
            val size = if (it is LocalStorageEntry.File) it.size else 0

            FileDescriptionEntity(
                guid = it.fullPath.toString(),
                name = it.name,
                docType = docType,
                isDirectory = isDirectory,
                size = size
            )
        }
    }

}

interface TreeController {
    suspend fun tree(request: TreeRequest): List<FileDescriptionEntity>
}