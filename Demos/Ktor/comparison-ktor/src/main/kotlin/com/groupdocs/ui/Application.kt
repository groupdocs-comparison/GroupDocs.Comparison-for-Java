package com.groupdocs.ui

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.config.ServerConfig
import com.groupdocs.ui.di.ModulesInjection
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.util.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.hocon.Hocon
import org.koin.core.logger.PrintLogger
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

@ExperimentalSerializationApi
@KtorExperimentalAPI
fun main(args: Array<String>) {
    val environment = System.getenv()["ENVIRONMENT"] ?: handleDefaultEnvironment()
    val applicationConfig = extractApplicationConfig(environment)
    val comparisonConfig by lazy { extractComparisonConfig() }

    embeddedServer(Netty, port = applicationConfig.port) {
        println("Starting instance in ${applicationConfig.host}:${applicationConfig.port}")
        module {
            install(Koin) {
                logger(PrintLogger())
                modules(
                    module {
                        single { applicationConfig }
                        single { comparisonConfig }
                    },
                    ModulesInjection.controllerBeans,
                    ModulesInjection.usecaseBeans,
                    ModulesInjection.managerBeans
                )
            }
            main()
        }
    }.start(wait = true)
}

fun handleDefaultEnvironment(): String {
    println("Falling back to default environment 'dev'")
    return "dev"
}

fun Application.main() {
    module()
}

fun extractApplicationConfig(environment: String): ServerConfig {
    val hoconConfig = HoconApplicationConfig(ConfigFactory.load("server.conf"))
    val hoconEnvironment = hoconConfig.config("ktor.deployment.$environment")

    return ServerConfig(
        hoconEnvironment.property("host").getString(),
        Integer.parseInt(hoconEnvironment.property("port").getString())
    )
}

@OptIn(ExperimentalSerializationApi::class)
fun extractComparisonConfig(): ApplicationConfig {
    val hocon = Hocon {
        useConfigNamingConvention = false
    }
    return hocon.decodeFromConfig(ApplicationConfig.serializer(), ConfigFactory.load("application.conf"))
}
