package com.groupdocs.ui.modules.home

import com.groupdocs.ui.model.HomeRequest
import com.groupdocs.ui.model.HomeResponse
import com.groupdocs.ui.modules.BaseController
import org.koin.core.component.KoinComponent

class HomeControllerImpl : BaseController(), HomeController, KoinComponent {
    override suspend fun home(postUser: HomeRequest): HomeResponse {
        return HomeResponse(123)
    }

}

interface HomeController {
    suspend fun home(postUser: HomeRequest): HomeResponse
}