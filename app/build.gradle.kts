plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
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
    namespace = Config.namespace

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Android main
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.material)

    // Required to avoid crash on Android 12 API 31
    implementation(Dependencies.Android.workConverter)

    // Testing Implementation
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidJUnit)
    androidTestImplementation(Dependencies.Test.espresso)

    // Firebase platform
    implementation(Dependencies.Firebase.firebaseBom)
    implementation(Dependencies.Firebase.firebaseAuth)
    implementation(Dependencies.Firebase.firebaseDatabase)
    implementation(Dependencies.Firebase.firebaseGms)

    // Main project elements
    implementation(Dependencies.Project.constraintLayout)
    implementation(Dependencies.Project.recyclerViewDependency)
    implementation(Dependencies.Project.cardView)

    // Work with Remote Network
    implementation(Dependencies.Remote.retrofit)
    implementation(Dependencies.Remote.gsonConverter)
    implementation(Dependencies.Remote.picasso)

    // Lifecycle dependency
    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.livedata)

    // Dagger2
    implementation(Dependencies.Dagger.dagger2)
    kapt(Dependencies.Dagger.daggerCompiler)
    implementation(Dependencies.Dagger.javax)

}