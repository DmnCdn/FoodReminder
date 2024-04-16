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

        register("library") {
            id = "com.example.foodreminder.android.library"
            version = libs.versions.customPlugin.get()
            implementationClass = "com.example.foodreminder.convention.plugins.AndroidLibraryPlugin"
        }

        register("compose") {
            id = "com.example.foodreminder.compose"
            version = libs.versions.customPlugin.get()
            implementationClass = "com.example.foodreminder.convention.plugins.ComposePlugin"
        }
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}