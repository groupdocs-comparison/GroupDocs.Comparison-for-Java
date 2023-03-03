package com.groupdocs.ui.comparison.ktor.modules

import com.groupdocs.ui.comparison.ktor.config.ComparerConfig
import org.koin.java.KoinJavaComponent.inject

open class BaseController {

    protected val comparerConfig by inject<ComparerConfig>(ComparerConfig::class.java)
}