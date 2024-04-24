plugins {
    alias(libs.plugins.foodReminderAndroidLibrary)
    alias(libs.plugins.foodReminderCompose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.foodreminder.ui.products"
}

dependencies {
    implementation(project(":ui-common"))
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.hilt.navigation)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.navigation)

    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
}