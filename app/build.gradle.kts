plugins {
    alias(libs.plugins.foodReminderApplication)
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
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.tooling.preview)
//    debugImplementation(libs.androidx.ui.tooling)
//    implementation(libs.androidx.material3)

//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
}