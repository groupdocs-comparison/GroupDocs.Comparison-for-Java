package com.groupdocs.ui.comparison.ktor.di

import com.groupdocs.ui.comparison.ktor.manager.PathManager
import com.groupdocs.ui.comparison.ktor.manager.PathManagerImpl
import com.groupdocs.ui.comparison.ktor.modules.compare.CompareController
import com.groupdocs.ui.comparison.ktor.modules.compare.CompareControllerImpl
import com.groupdocs.ui.comparison.ktor.modules.config.ConfigController
import com.groupdocs.ui.comparison.ktor.modules.config.ConfigControllerImpl
import com.groupdocs.ui.comparison.ktor.modules.description.DescriptionController
import com.groupdocs.ui.comparison.ktor.modules.description.DescriptionControllerImpl
import com.groupdocs.ui.comparison.ktor.modules.download.DownloadController
import com.groupdocs.ui.comparison.ktor.modules.download.DownloadControllerImpl
import com.groupdocs.ui.comparison.ktor.modules.page.PageController
import com.groupdocs.ui.comparison.ktor.modules.page.PageControllerImpl
import com.groupdocs.ui.comparison.ktor.modules.tree.TreeController
import com.groupdocs.ui.comparison.ktor.modules.tree.TreeControllerImpl
import com.groupdocs.ui.comparison.ktor.modules.upload.UploadController
import com.groupdocs.ui.comparison.ktor.modules.upload.UploadControllerImpl
import com.groupdocs.ui.comparison.ktor.usecase.*
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