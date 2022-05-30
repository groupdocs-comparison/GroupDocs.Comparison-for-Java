package com.groupdocs.ui.modules

import com.groupdocs.ui.config.ComparerConfig
import org.koin.java.KoinJavaComponent.inject

open class BaseController {

    protected val comparerConfig by inject<ComparerConfig>(ComparerConfig::class.java)
}