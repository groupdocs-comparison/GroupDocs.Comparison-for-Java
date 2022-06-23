package com.groupdocs.ui.modules.config

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.model.ConfigResponse
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton

interface ConfigBean {
    suspend fun config(): ConfigResponse
}

@Bean(typed = [ConfigBean::class])
@Singleton
class ConfigBeanImpl(
    @Inject private val appConfig: ApplicationConfig
) : ConfigBean {
    override suspend fun config(): ConfigResponse {
        return ConfigResponse(
            browse = appConfig.common.browse,
            download = appConfig.common.download,
            enableRightClick = appConfig.common.enableRightClick,
            pageSelector = appConfig.common.pageSelector,
            preloadResultPageCount = appConfig.comparison.preloadResultPageCount,
            print = appConfig.common.print,
            rewrite = appConfig.common.rewrite,
            upload = appConfig.common.upload,
        )
    }

}