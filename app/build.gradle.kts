plugins {
    alias(libs.plugins.foodReminderApplication)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.foodreminder"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}

dependencies {
    implementation(project(":ui-common"))
    implementation(project(":ui-products"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.core)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)

    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
}