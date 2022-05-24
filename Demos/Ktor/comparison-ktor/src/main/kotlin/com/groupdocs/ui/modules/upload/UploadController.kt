package com.groupdocs.ui.modules.upload

import com.groupdocs.ui.model.UploadResponse
import com.groupdocs.ui.modules.BaseController
import org.koin.core.component.KoinComponent

class UploadControllerImpl : BaseController(), UploadController, KoinComponent {
    override suspend fun upload(): UploadResponse {
        return UploadResponse(123)
    }

}

interface UploadController {
    suspend fun upload(): UploadResponse
}