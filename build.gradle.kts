import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val user = "MaleficCompose"
val repo = "MaleficTheming"
val g = "xyz.malefic.compose"
val artifact = "theming"
val v: String by project
val desc = "A Compose Multiplatform library for creating and managing material themes"

plugins {
    kotlin("multiplatform") version libs.versions.kotlin
    kotlin("plugin.compose") version libs.versions.kotlin
    kotlin("plugin.serialization") version libs.versions.kotlin
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.compose)
    alias(libs.plugins.vanniktech.mavenPublish)
    alias(libs.plugins.dokka)
}

group = g
version = v

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm()

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(compose.material)
            implementation(libs.json)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        jvmMain.dependencies {
            implementation(compose.desktop.common)
        }
        jvmTest.dependencies {
            implementation(compose.desktop.currentOs)
        }
        androidMain.dependencies {
            implementation(compose.material)
        }
        iosMain.dependencies {
            implementation(compose.material)
        }
    }
}

android {
    namespace = "xyz.malefic.compose.theming"
    compileSdk =
        libs.versions.android.compileSdk
            .get()
            .toInt()

    defaultConfig {
        minSdk =
            libs.versions.android.minSdk
                .get()
                .toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.apply {
    register("formatAndLintKotlin") {
        group = "formatting"
        description = "Fix Kotlin code style deviations with kotlinter"
        dependsOn(named("formatKotlin"))
        dependsOn(named("lintKotlin"))
    }
    named("build") {
        dependsOn(named("formatAndLintKotlin"))
        dependsOn(dokkaGenerate)
    }
    named("publish") {
        dependsOn(named("formatAndLintKotlin"))
    }
    withType<Test> {
        useJUnitPlatform()
    }
    named("check") {
        dependsOn("installKotlinterPrePushHook")
    }
}

dokka {
    dokkaPublications.html {
        outputDirectory.set(layout.buildDirectory.dir("dokka"))
    }
    pluginsConfiguration.html {
        footerMessage.set("&copy; 2025 Om Gupta &lt;ogupta4242@gmail.com&gt;")
    }
}

java {
    withSourcesJar()
}

kotlin {
    jvmToolchain(17)
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(g, artifact, v)

    pom {
        name = repo
        description = desc
        inceptionYear = "2025"
        url = "https://github.com/$user/$repo"
        licenses {
            license {
                name = "MIT License"
                url = "https://mit.malefic.xyz"
            }
        }
        developers {
            developer {
                name = "Om Gupta"
                email = "ogupta4242@gmail.com"
                url = "malefic.xyz"
            }
        }
        scm {
            url = "https://github.com/$user/$repo"
            connection = "scm:git:git://github.com/$user/$repo.git"
            developerConnection = "scm:git:ssh://github.com/$user/$repo.git"
        }
    }
}
