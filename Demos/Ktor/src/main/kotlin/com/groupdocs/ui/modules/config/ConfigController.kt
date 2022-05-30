package com.groupdocs.ui.modules.config

import com.groupdocs.ui.model.ConfigResponse
import com.groupdocs.ui.modules.BaseController
import org.koin.core.component.KoinComponent

class ConfigControllerImpl : BaseController(), ConfigController, KoinComponent {

    override suspend fun config(): ConfigResponse {
        return ConfigResponse(
            browse = applicationConfig.common.browse,
            download = applicationConfig.common.download,
            enableRightClick = applicationConfig.common.enableRightClick,
            pageSelector = applicationConfig.common.pageSelector,
            preloadResultPageCount = applicationConfig.comparison.preloadResultPageCount,
            print = applicationConfig.common.print,
            rewrite = applicationConfig.common.rewrite,
            upload = applicationConfig.common.upload,
        )
    }

}

interface ConfigController {
    suspend fun config(): ConfigResponse
}