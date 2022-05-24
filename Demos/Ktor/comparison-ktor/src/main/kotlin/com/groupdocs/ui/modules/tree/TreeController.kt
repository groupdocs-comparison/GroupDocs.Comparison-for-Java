package com.groupdocs.ui.modules.tree

import com.groupdocs.ui.model.TreeResponse
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.modules.tree.TreeController
import org.koin.core.component.KoinComponent

class TreeControllerImpl : BaseController(), TreeController, KoinComponent {
    override suspend fun tree(): TreeResponse {
        return TreeResponse(123)
    }

}

interface TreeController {
    suspend fun tree(): TreeResponse
}