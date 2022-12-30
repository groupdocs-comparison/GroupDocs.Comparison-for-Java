package com.groupdocs.ui.modules.home

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.util.setGroupdocsLicense
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.View
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.net.URI

@Singleton
@Controller("/")
class HomeController(
    @Inject private val appConfig: ApplicationConfig
) {
    private var isLicenseSet: Boolean = false
    @Get("/")
    fun home(): HttpResponse<String> {
        return HttpResponse.redirect(URI("/comparison"))
    }

    @View("comparison")
    @Get("/comparison")
    fun comparison() {
        if (!isLicenseSet) {
            isLicenseSet = true
            val licensePath = appConfig.licensePathOrDefault
            setGroupdocsLicense(licensePath)
        }
    }

    @Get("/comparison/app-name")
    fun appName(): HttpResponse<String> {
        return HttpResponse.ok("comparison-micronaut")
    }
}