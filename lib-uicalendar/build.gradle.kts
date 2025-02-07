plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
    id(BuildPlugins.COMPOSE_COMPILER) version "2.0.20"
    id("org.jlleitschuh.gradle.ktlint")
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
        //s
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Lib.Android.COMPOSE_COMPILER_VERSION
    }
    packagingOptions {
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("LICENSE.txt")
        resources.excludes.add( "/META-INF/{AL2.0,LGPL2.1}")
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

// Required for annotation processing plugins like Dagger
kapt {
  //  generateStubs = true
    correctErrorTypes = true
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation(project(":common"))
    implementation(project(":commonui"))

    api(Lib.Android.COMPOSE_UI)
    api(Lib.Android.COIL_COMPOSE)
    implementation(Lib.Android.ACCOMPANIST_SYSTEM_UI_CONTROLLER)

    api(Lib.Android.COMPOSE_UI)
    api(Lib.Android.COMPOSE_TOOLING)
    debugApi(Lib.Android.COMPOSE_DEBUG_TOOLING)
    api(Lib.Android.ACTIVITY_COMPOSE)
    api(Lib.Android.CONSTRAINT_LAYOUT_COMPOSE)

    api(Lib.Android.APP_COMPAT)
    api(Lib.Kotlin.KTX_CORE)

    api(Lib.Android.ACCOMPANIST_INSETS)

    /* Logger */
    api(Lib.Logger.TIMBER)
    /* Async */
    api(Lib.Async.COROUTINES)
    api(Lib.Async.COROUTINES_ANDROID)

    testImplementation(TestLib.JUNIT)
    testImplementation(TestLib.CORE_TEST)
    testImplementation(TestLib.ANDROID_JUNIT)
    testImplementation(TestLib.ARCH_CORE)
    testImplementation(TestLib.MOCK_WEB_SERVER)
    testImplementation(TestLib.ROBO_ELECTRIC)
    testImplementation(TestLib.COROUTINES)
    testImplementation(TestLib.MOCKK)
    testImplementation(TestLib.TURBINE)
}