package com.example.foodreminder.convention.plugins

import com.android.build.gradle.AppExtension
import com.example.foodreminder.convention.utils.getVersionByName
import com.example.foodreminder.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
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
            }
        }
    }
}