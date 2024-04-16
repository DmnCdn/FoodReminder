plugins {
    alias(libs.plugins.foodReminderAndroidLibrary)
    alias(libs.plugins.foodReminderCompose)
}

android {
    namespace = "com.example.foodreminder.ui.common"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}