plugins {
    alias(libs.plugins.foodReminderAndroidLibrary)
    alias(libs.plugins.foodReminderCompose)
}

android {
    namespace = "com.example.foodreminder.ui.products"
}

dependencies {
    implementation(project(":ui-common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}