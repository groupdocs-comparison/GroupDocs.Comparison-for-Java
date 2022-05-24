package com.groupdocs.ui.modules.download

import com.groupdocs.ui.model.DownloadResponse
import com.groupdocs.ui.modules.BaseController
import org.koin.core.component.KoinComponent

class DownloadControllerImpl : BaseController(), DownloadController, KoinComponent {
    override suspend fun download(): DownloadResponse {
        return DownloadResponse(123)
    }

}

interface DownloadController {
    suspend fun download(): DownloadResponse
}