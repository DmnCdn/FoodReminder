plugins {
    alias(libs.plugins.foodReminderAndroidLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.foodreminder.datasource"
}

dependencies {
    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
}