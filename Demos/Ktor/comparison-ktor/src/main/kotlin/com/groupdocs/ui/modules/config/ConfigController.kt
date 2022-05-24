package com.groupdocs.ui.modules.config

import com.groupdocs.ui.model.ConfigResponse
import com.groupdocs.ui.modules.BaseController
import org.koin.core.component.KoinComponent

class ConfigControllerImpl : BaseController(), ConfigController, KoinComponent {
    override suspend fun config(): ConfigResponse {
        return ConfigResponse(123)
    }

}

interface ConfigController {
    suspend fun config(): ConfigResponse
}