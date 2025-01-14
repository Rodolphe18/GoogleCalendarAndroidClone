plugins {
  id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
  id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
  id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
  id(BuildPlugins.KOTLIN_KAPT)
  id(BuildPlugins.DAGGER_HILT)
  id(BuildPlugins.COMPOSE_COMPILER) version "2.0.20"
}

android {
  compileSdk = (ProjectProperties.COMPILE_SDK)
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

// Required for annotation processing plugins like Dagger f
kapt {
 // generateStubs = true
  correctErrorTypes = true
}

dependencies {
  coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
  implementation(project(":common"))

  /*Kotlin*/
  api(Lib.Kotlin.KT_STD)
  api(Lib.Async.COROUTINES)
  api(Lib.Logger.TIMBER)

  /* Paging */
  implementation(Lib.Paging.PAGING_3)

  /* Dependency Injection */
  api(Lib.Di.hiltAndroid)
  kapt(Lib.Di.hiltAndroidCompiler)
}