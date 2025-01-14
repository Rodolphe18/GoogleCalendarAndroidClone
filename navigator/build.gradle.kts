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

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    isCoreLibraryDesugaringEnabled = true
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  composeOptions {
    kotlinCompilerExtensionVersion = Lib.Android.COMPOSE_COMPILER_VERSION
  }
}

// Required for annotation processing plugins like Dagger
kapt {
 // generateStubs = true
  correctErrorTypes = true
}

dependencies {
  coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
  /*Kotlin*/
  implementation(Lib.Android.APP_COMPAT)
  implementation(Lib.Kotlin.KTX_CORE)
  api(Lib.Async.COROUTINES)
  api(Lib.Async.COROUTINES_ANDROID)

  implementation(Lib.Kotlin.KT_STD)
  implementation(Lib.Android.COMPOSE_NAVIGATION)

  implementation(Lib.Android.COMPOSE_NAVIGATION)
  implementation(Lib.Di.hiltNavigationCompose)
}