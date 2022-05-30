package com.groupdocs.ui.modules.page

import com.groupdocs.ui.model.PageResponse
import com.groupdocs.ui.modules.BaseController
import org.koin.core.component.KoinComponent

class PageControllerImpl : BaseController(), PageController, KoinComponent {
    override suspend fun page(): PageResponse {
        return PageResponse(123)
    }

}

interface PageController {
    suspend fun page(): PageResponse
}