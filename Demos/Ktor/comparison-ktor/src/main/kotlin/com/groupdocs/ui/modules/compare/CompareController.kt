package com.groupdocs.ui.modules.compare

import com.groupdocs.ui.model.CompareResponse
import com.groupdocs.ui.modules.BaseController
import org.koin.core.component.KoinComponent

class CompareControllerImpl : BaseController(), CompareController, KoinComponent {
    override suspend fun compare(): CompareResponse {
        return CompareResponse(123)
    }

}

interface CompareController {
    suspend fun compare(): CompareResponse
}