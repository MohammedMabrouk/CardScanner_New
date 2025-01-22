plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.mabrouk.mohamed.cardscanner"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mabrouk.mohamed.cardscanner"
        minSdk = 23
        targetSdk = 34
        versionCode = Integer.parseInt(project.properties["VERSION_CODE"].toString())
        versionName = project.properties["VERSION_NAME"] as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)

    // splash screen
    implementation(libs.splash.screen)

    // Google Play
    implementation(libs.app.review)
    implementation(libs.app.update)

    // google services
    implementation(libs.google.services)

    // firebase
    implementation(libs.firebase.cloud.messaging)

    // tensorFlow
    implementation(libs.tensorflow)
    implementation(libs.tensorflow.gpu)
    implementation(libs.tensorflow.gpu.api)
    implementation(libs.tensorflow.gpu.delegate)
    implementation(libs.tensorflow.metadata)
    implementation(libs.tensorflow.support)
    implementation(libs.tensorflow.api)
    implementation(libs.tensorflow.select)

    // Timber
    implementation(libs.timber)

    // datastore
    implementation(libs.datastore.preferences)

    // permissions
    implementation(libs.accompanist.permissions)

    // lottie
    implementation(libs.lottie.compose)

    // testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}