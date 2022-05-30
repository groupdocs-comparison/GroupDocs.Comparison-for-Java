package com.groupdocs.ui.di

import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.manager.PathManagerImpl
import com.groupdocs.ui.modules.compare.CompareController
import com.groupdocs.ui.modules.compare.CompareControllerImpl
import com.groupdocs.ui.modules.config.ConfigController
import com.groupdocs.ui.modules.config.ConfigControllerImpl
import com.groupdocs.ui.modules.description.DescriptionController
import com.groupdocs.ui.modules.description.DescriptionControllerImpl
import com.groupdocs.ui.modules.download.DownloadController
import com.groupdocs.ui.modules.download.DownloadControllerImpl
import com.groupdocs.ui.modules.page.PageController
import com.groupdocs.ui.modules.page.PageControllerImpl
import com.groupdocs.ui.modules.tree.TreeController
import com.groupdocs.ui.modules.tree.TreeControllerImpl
import com.groupdocs.ui.modules.upload.UploadController
import com.groupdocs.ui.modules.upload.UploadControllerImpl
import com.groupdocs.ui.usecase.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object ModulesInjection {
    val controllerBeans = module {
        singleOf(::ConfigControllerImpl) { bind<ConfigController>() }
        singleOf(::TreeControllerImpl) { bind<TreeController>() }
        singleOf(::DownloadControllerImpl) { bind<DownloadController>() }
        singleOf(::UploadControllerImpl) { bind<UploadController>() }
        singleOf(::CompareControllerImpl) { bind<CompareController>() }
        singleOf(::PageControllerImpl) { bind<PageController>() }
        singleOf(::DescriptionControllerImpl) { bind<DescriptionController>() }

    }
    val usecaseBeans = module {
        singleOf(::GetLocalFilesUseCase)
        singleOf(::RetrieveLocalFilePagesStreamUseCase)
        singleOf(::AreFilesSupportedUseCase)
        singleOf(::CompareDocumentsUseCase)
        singleOf(::SaveStreamToFilesDirectoryUseCase)
    }
    val managerBeans = module {
        singleOf(::PathManagerImpl) { bind<PathManager>() }
    }
}