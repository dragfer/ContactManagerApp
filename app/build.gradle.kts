plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.contactmanager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.contactmanager"
        minSdk = 29
        targetSdk = 34
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
    implementation("androidx.core:core-ktx:1.10.0") // Ensure you use latest stable versions
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")
    implementation("androidx.activity:activity-compose:1.7.0")

    // Room dependencies
    implementation("androidx.room:room-runtime:2.5.0")
    implementation(libs.androidx.lifecycle.livedata.ktx) // Room runtime
    kapt("androidx.room:room-compiler:2.5.0") // Room compiler
    implementation("androidx.room:room-ktx:2.5.0") // Room Kotlin extensions

    // Compose UI dependencies
    implementation(platform("androidx.compose:compose-bom:2024.1.0")) // BOM for Compose versions
    implementation("androidx.compose.ui:ui:1.5.1") // Use latest stable Compose version
    implementation("androidx.compose.ui:ui-graphics:1.5.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.1")
    implementation("androidx.compose.material3:material3:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.1.0")) // BOM for Compose testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.1") // Jetpack Compose testing
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.1")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.1")

    // Additional dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0") // ViewModel for Compose
    implementation("androidx.navigation:navigation-compose:2.7.0") // Navigation for Compose
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10") // Specify Kotlin version
    }
}
