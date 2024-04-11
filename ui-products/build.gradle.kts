plugins {
    alias(libs.plugins.foodReminderAndroidLibrary)
}

android {
    namespace = "com.example.foodreminder.ui.products"
}

dependencies {
    implementation(project(":ui-common"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}