package com.groupdocs.ui.comparison.ktor.modules.config

import com.groupdocs.ui.comparison.ktor.model.ConfigResponse
import com.groupdocs.ui.comparison.ktor.modules.BaseController
import org.koin.core.component.KoinComponent

class ConfigControllerImpl : BaseController(), ConfigController, KoinComponent {

    override suspend fun config(): ConfigResponse {
        return ConfigResponse(
            browse = comparerConfig.common.browse,
            download = comparerConfig.common.download,
            enableRightClick = comparerConfig.common.enableRightClick,
            pageSelector = comparerConfig.common.pageSelector,
            preloadResultPageCount = comparerConfig.comparison.preloadResultPageCount,
            print = comparerConfig.common.print,
            rewrite = comparerConfig.common.rewrite,
            upload = comparerConfig.common.upload,
        )
    }

}

interface ConfigController {
    suspend fun config(): ConfigResponse
}