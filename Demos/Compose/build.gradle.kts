import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0"
}

group = "com.groupdocs.ui"
version = "22.3"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://repository.groupdocs.com/repo/")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("commons-io:commons-io:2.11.0")
    implementation("com.groupdocs:groupdocs-comparison:22.3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "com.groupdocs.ui.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "groupdocs-comparison-compose"
            packageVersion = "22.3.0"

            windows {
                shortcut = true
                iconFile.set(project.file("icon.ico"))
            }
        }
    }
}