package com.groupdocs.ui.modules.tree

import com.groupdocs.comparison.result.FileType
import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.model.FileDescriptionEntity
import com.groupdocs.ui.model.TreeRequest
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.usecase.GetLocalFilesUseCase
import com.groupdocs.ui.usecase.LocalStorageEntry
import org.koin.core.component.KoinComponent

class TreeControllerImpl(
    private val getLocalFiles: GetLocalFilesUseCase,
    private val pathManager: PathManager
) : BaseController(), TreeController, KoinComponent {

    override suspend fun tree(request: TreeRequest): List<FileDescriptionEntity> {
        val path = pathManager.assertPathIsInsideFilesDirectory(request.path)

        val localFiles = getLocalFiles(path)
        return localFiles.sortedBy {
            it is LocalStorageEntry.File
        }.map {
            val docType = if (it is LocalStorageEntry.File) FileType.fromFileNameOrExtension(it.name).fileFormat else null
            val isDirectory = it is LocalStorageEntry.Directory
            val size = if (it is LocalStorageEntry.File) it.size else 0

            val filesDirectory = pathManager.filesDirectory
            val fileFullPath = it.fullPath
            val guid = filesDirectory.relativize(fileFullPath).toString()
            FileDescriptionEntity(
                guid = guid,
                name = it.name,
                docType = docType,
                directory = isDirectory,
                size = size
            )
        }
    }

}

interface TreeController {
    suspend fun tree(request: TreeRequest): List<FileDescriptionEntity>
}