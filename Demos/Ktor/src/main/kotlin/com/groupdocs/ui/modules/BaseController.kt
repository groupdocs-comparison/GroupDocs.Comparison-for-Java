package com.groupdocs.ui.modules

import com.groupdocs.ui.config.ApplicationConfig
import org.koin.java.KoinJavaComponent.inject

open class BaseController {

    protected val applicationConfig by inject<ApplicationConfig>(ApplicationConfig::class.java)
}