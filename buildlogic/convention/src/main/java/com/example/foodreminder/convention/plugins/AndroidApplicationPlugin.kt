package com.example.foodreminder.convention.plugins

import com.android.build.gradle.AppExtension
import com.example.foodreminder.convention.utils.getVersionByName
import com.example.foodreminder.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

class AndroidApplicationPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            with(kotlinExtension) {
                jvmToolchain(libs.getVersionByName("jvm").toInt())
            }

            with(extensions.getByType<AppExtension>()) {
                compileSdkVersion = libs.getVersionByName("compileSdk")

                with(defaultConfig) {
                    applicationId = "com.example.foodreminder"
                    minSdk = libs.getVersionByName("minSdk").toInt()
                    targetSdk = libs.getVersionByName("targetSdk").toInt()
                    versionCode = libs.getVersionByName("versionCode").toInt()
                    versionName = libs.getVersionByName("versionName")

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                with(buildTypes) {
                    getByName("release") {
                        isMinifyEnabled = true
                        isShrinkResources = true
                        isDebuggable = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }

                with(packagingOptions) {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
            }
        }
    }
}