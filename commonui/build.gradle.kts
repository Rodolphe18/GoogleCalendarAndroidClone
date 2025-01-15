plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.COMPOSE_COMPILER) version "2.0.20"
}

android {
    compileSdk = ProjectProperties.COMPILE_SDK
    namespace = "dev.baseio.googlecalendar.GoogleCalendarClone"

    defaultConfig {
        minSdk = (ProjectProperties.MIN_SDK)
        targetSdk = (ProjectProperties.TARGET_SDK)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Lib.Android.COMPOSE_COMPILER_VERSION
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
}

// Required for annotation processing plugins like Dagger
kapt {
  //  generateStubs = true
    correctErrorTypes = true
}

dependencies {
    implementation(libs.androidx.material.android)
    testImplementation(libs.junit.junit)
    testImplementation(libs.junit.junit)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    /*Kotlin*/
    api(Lib.Kotlin.KT_STD)
    api(Lib.Kotlin.KTX_CORE)
    /* Android Designing and layout */
    api(Lib.Android.MATERIAL_THREE)
    api(Lib.Android.COMPOSE_UI)
    implementation(Lib.Android.CONSTRAINT_LAYOUT_COMPOSE)
    implementation(Lib.Android.ACCOMPANIST_SYSTEM_UI_CONTROLLER)
    api(Lib.Android.COIL_COMPOSE)
    api(Lib.Android.COMPOSE_TOOLING)
    debugApi(Lib.Android.COMPOSE_DEBUG_TOOLING)
    api(Lib.Android.ACTIVITY_COMPOSE)

    /* Dependency Injection */
    api(Lib.Di.hiltAndroid)
    kapt(Lib.Di.hiltAndroidCompiler)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.coil.kt.compose)
}