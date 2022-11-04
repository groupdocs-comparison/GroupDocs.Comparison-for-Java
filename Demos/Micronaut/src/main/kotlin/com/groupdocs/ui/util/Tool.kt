package com.groupdocs.ui.util

import com.groupdocs.comparison.license.License
import com.groupdocs.ui.Defaults
import java.io.BufferedInputStream
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

open class InternalServerException(override val message: String = "Internal server error", throwable: Throwable? = null) : Exception(message, throwable)
open class FileFormatNotSupportedException(override val message: String, throwable: Throwable? = null) : Exception(message, throwable)

fun setGroupdocsLicense(licensePath: String) {
    try {
        println("Setting Groupdocs license...")

        val licenseExtension = Defaults.DEFAULT_LICENSE_EXTENSION
        val license = License()
        if (licensePath.startsWith("http://") || licensePath.startsWith("https://")) {
            val url = URL(licensePath)
            BufferedInputStream(url.openStream()).use { inputStream -> license.setLicense(inputStream) }
        } else {
            val path = Paths.get(licensePath)
            if (Files.exists(path)) {
                if (Files.isRegularFile(path)) {
                    license.setLicense(licensePath)
                } else {
                    Files.list(path).use { pathStream ->
                        val first =
                            pathStream.filter { path ->
                                path.endsWith(licenseExtension)
                            }.findFirst()
                        first.ifPresent { licensePath: Path? ->
                            license.setLicense(licensePath)
                        }
                    }
                }
            }
        }
    } catch (e: Exception) {
        println("Can not verify Comparison license: ${e.message}")
    }
}