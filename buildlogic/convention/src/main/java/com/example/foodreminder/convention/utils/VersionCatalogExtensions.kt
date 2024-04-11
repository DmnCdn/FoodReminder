package com.example.foodreminder.convention.utils

import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.provider.Provider

internal fun VersionCatalog.getVersionByName(name: String): String =
    findVersion(name).get().requiredVersion

internal fun VersionCatalog.getLibraryByName(name: String): Provider<MinimalExternalModuleDependency> =
    findLibrary(name).get()

internal fun VersionCatalog.getBundleByName(name: String): Provider<ExternalModuleDependencyBundle> =
    findBundle(name).get()