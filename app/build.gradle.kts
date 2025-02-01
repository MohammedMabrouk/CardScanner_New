plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    alias(libs.plugins.ksp)
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    alias(libs.plugins.compose.compiler)
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

    signingConfigs {
        create("release") {
            storeFile = file(project.properties["KEYSTORE_FILE"] as String)
            storePassword = project.properties["KEYSTORE_PASSWORD"] as String
            keyAlias = project.properties["KEY_ALIAS"] as String
            keyPassword = project.properties["KEY_PASSWORD"] as String
        }
    }

    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
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
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    hilt {
        enableAggregatingTask = true
    }
    kotlin {
        sourceSets.configureEach {
            kotlin.srcDir(layout.buildDirectory.files("generated/ksp/$name/kotlin/"))
        }
        sourceSets.all {
            languageSettings {
                languageVersion = "2.0"
            }
        }
    }
    android {
        androidResources.noCompress("tflite")
    }

    // Do NOT compress tflite model files (need to call out to developers!)
    aaptOptions.noCompress("tflite")
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

    // di
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // Google Play
    implementation(libs.app.review)
    implementation(libs.app.update)

    // google services
    implementation(libs.google.services)

    // firebase
//    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.cloud.messaging)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)


    // tensorFlow
//    implementation(libs.tensorflow)
//    implementation(libs.tensorflow.gpu)
//    implementation(libs.tensorflow.gpu.api)
//    implementation(libs.tensorflow.gpu.delegate)
//    implementation(libs.tensorflow.metadata)
//    implementation(libs.tensorflow.support)
//    implementation(libs.tensorflow.api)
//    implementation(libs.tensorflow.select)

    // ML Kit
    implementation(libs.mlkit)

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

apply(plugin = "com.google.gms.google-services")