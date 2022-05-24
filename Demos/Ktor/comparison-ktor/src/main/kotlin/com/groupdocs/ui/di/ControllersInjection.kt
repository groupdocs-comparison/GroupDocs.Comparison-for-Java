package com.groupdocs.ui.di

import com.groupdocs.ui.modules.compare.CompareController
import com.groupdocs.ui.modules.compare.CompareControllerImpl
import com.groupdocs.ui.modules.config.ConfigController
import com.groupdocs.ui.modules.config.ConfigControllerImpl
import com.groupdocs.ui.modules.description.DescriptionController
import com.groupdocs.ui.modules.description.DescriptionControllerImpl
import com.groupdocs.ui.modules.download.DownloadController
import com.groupdocs.ui.modules.download.DownloadControllerImpl
import com.groupdocs.ui.modules.home.HomeController
import com.groupdocs.ui.modules.home.HomeControllerImpl
import com.groupdocs.ui.modules.page.PageController
import com.groupdocs.ui.modules.page.PageControllerImpl
import com.groupdocs.ui.modules.tree.TreeController
import com.groupdocs.ui.modules.tree.TreeControllerImpl
import com.groupdocs.ui.modules.upload.UploadController
import com.groupdocs.ui.modules.upload.UploadControllerImpl
import org.koin.dsl.module

object ModulesInjection {
    val koinBeans = module {
        single<HomeController> { HomeControllerImpl() }
        single<ConfigController> { ConfigControllerImpl() }
        single<TreeController> { TreeControllerImpl() }
        single<DownloadController> { DownloadControllerImpl() }
        single<UploadController> { UploadControllerImpl() }
        single<CompareController> { CompareControllerImpl() }
        single<PageController> { PageControllerImpl() }
        single<DescriptionController> { DescriptionControllerImpl() }
    }
}