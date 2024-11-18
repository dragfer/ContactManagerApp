plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android") version "1.9.0"
}

android {
    namespace = "com.example.contactmanager"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.contactmanager"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true // Enable ProGuard/R8 minification
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // Update if necessary
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core dependencies
    implementation(libs.androidx.core.ktx.v1100) // Ensure you use latest stable versions
    implementation(libs.androidx.lifecycle.runtime.ktx.v260)
    implementation(libs.androidx.activity.compose.v170)

    // Room dependencies
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.constraintlayout) // Room runtime
    kapt(libs.androidx.room.compiler) // Room compiler
    kapt("com.google.dagger:dagger-compiler:2.48")
    implementation(libs.androidx.room.ktx) // Room Kotlin extensions

    // Compose UI dependencies
    implementation(platform("androidx.compose:compose-bom:2024.11.00")) // BOM for Compose versions
    implementation(libs.ui) // Use latest stable Compose version
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.androidx.recyclerview)
    implementation(libs.material)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(platform(libs.androidx.compose.bom.v20241100)) // BOM for Compose testing
    androidTestImplementation(libs.ui.test.junit4) // Jetpack Compose testing
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    // Additional dependencies
    implementation(libs.androidx.lifecycle.viewmodel.compose) // ViewModel for Compose
    implementation(libs.androidx.navigation.compose) // Navigation for Compose
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlin.gradle.plugin) // Specify Kotlin version
    }
}
