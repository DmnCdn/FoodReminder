package com.example.foodreminder.convention.plugins

import com.android.build.gradle.LibraryExtension
import com.example.foodreminder.convention.utils.debugImplementation
import com.example.foodreminder.convention.utils.getLibraryByName
import com.example.foodreminder.convention.utils.getVersionByName
import com.example.foodreminder.convention.utils.implementation
import com.example.foodreminder.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ComposePlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(extensions.getByType<LibraryExtension>()) {
                buildFeatures {
                    compose = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = libs.getVersionByName("composeCompiler")
                }

                dependencies {
                    implementation(platform(libs.getLibraryByName("androidx-compose-bom")))
                    implementation(libs.getLibraryByName("androidx-material3"))
                    implementation(libs.getLibraryByName("androidx-ui"))
                    implementation(libs.getLibraryByName("androidx-ui-tooling-preview"))
                    debugImplementation(libs.getLibraryByName("androidx-ui-tooling"))
                }
            }
        }
    }
}