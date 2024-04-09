plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        register("application") {
            id = "com.example.foodreminder.application"
            version = libs.versions.customPlugin.get()
            implementationClass = "com.example.foodreminder.convention.plugins.AndroidApplicationPlugin"
        }
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}