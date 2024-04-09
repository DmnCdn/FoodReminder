plugins {
    alias(libs.plugins.foodReminderAndroidLibrary)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.foodreminder.datasource"
}

dependencies {
    implementation(project(":model"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.room.core)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
}