plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
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

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

// Required for annotation processing plugins like Dagger 2
kapt {
  //  generateStubs = true
    correctErrorTypes = true
}

dependencies {
    testImplementation(libs.junit.junit)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    /*Kotlin*/
    api(Lib.Kotlin.KT_STD)

    /* Dependency Injection */
    api(Lib.Di.hiltAndroid)
    api(Lib.Di.hiltNavigationCompose)

    kapt(Lib.Di.hiltCompiler)
    kaptTest(Lib.Di.hiltCompiler)
    kapt(Lib.Di.hiltAndroidCompiler)
    kaptTest(Lib.Di.hiltAndroidCompiler)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.coil.kt.compose)
}