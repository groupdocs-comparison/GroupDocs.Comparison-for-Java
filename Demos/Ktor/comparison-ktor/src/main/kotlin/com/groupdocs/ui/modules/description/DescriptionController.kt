package com.groupdocs.ui.modules.description

import com.groupdocs.ui.model.DescriptionResponse
import com.groupdocs.ui.modules.BaseController
import org.koin.core.component.KoinComponent

class DescriptionControllerImpl : BaseController(), DescriptionController, KoinComponent {
    override suspend fun description(): DescriptionResponse {
        return DescriptionResponse(123)
    }

}

interface DescriptionController {
    suspend fun description(): DescriptionResponse
}