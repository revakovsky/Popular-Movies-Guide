object Dependencies {

    // Firebase
    private const val versionBom = "30.0.1"
    private const val versionAuth = "7.2.0"
    private const val versionDatabase = "20.0.6"
    private const val versionGms = "20.3.0"

    // Project
    private const val versionConstraintLayout = "2.1.4"
    private const val versionRecyclerViewDependency = "1.2.1"
    private const val versionCardView = "1.0.0"

    // Android
    private const val versionCoreKtx = "1.8.0"
    private const val versionAppCompat = "1.4.2"
    private const val versionMaterial = "1.6.1"
    private const val versionWorkConverter = "2.7.1"

    // Remote
    private const val versionRetrofit = "2.9.0"
    private const val versionGsonConverter = "2.9.0"
    private const val versionPicasso = "2.71828"

    // Lifecycle
    private const val versionLivedata = "2.4.0-alpha03"
    private const val versionViewModel = "2.4.0-alpha03"

    // Dagger
    private const val versionDagger = "2.44"
    private const val versionJavax = "1"

    // Testing
    private const val versionJUnit = "4.13.2"
    private const val versionAndroidJUnit = "1.1.3"
    private const val versionEspresso = "3.4.0"

    // ProjectPlugins
    private const val versionGoogleServices = "4.3.14"


    object Firebase {
        const val firebaseBom = "com.google.firebase:firebase-bom:$versionBom"
        const val firebaseAuth = "com.firebaseui:firebase-ui-auth:$versionAuth"
        const val firebaseDatabase = "com.google.firebase:firebase-database-ktx:$versionDatabase"
        const val firebaseGms = "com.google.android.gms:play-services-auth:$versionGms"
    }

    object Project {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$versionConstraintLayout"
        const val recyclerViewDependency = "androidx.recyclerview:recyclerview:$versionRecyclerViewDependency"
        const val cardView = "androidx.cardview:cardview:$versionCardView"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:$versionCoreKtx"
        const val appCompat = "androidx.appcompat:appcompat:$versionAppCompat"
        const val material = "com.google.android.material:material:$versionMaterial"
        const val workConverter = "androidx.work:work-runtime-ktx:$versionWorkConverter"
    }

    object Remote {
        const val retrofit = "com.squareup.retrofit2:retrofit:$versionRetrofit"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$versionGsonConverter"
        const val picasso = "com.squareup.picasso:picasso:$versionPicasso"
    }

    object Lifecycle {
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$versionLivedata"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$versionViewModel"
    }

    object Dagger {
        const val dagger2 = "com.google.dagger:dagger:$versionDagger"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:$versionDagger"

        // added portable dependency injection annotations that can be used by any dependency injection framework
        const val javax = "javax.inject:javax.inject:$versionJavax"
    }

    object Test {
        const val jUnit = "junit:junit:$versionJUnit"
        const val androidJUnit = "androidx.test.ext:junit:$versionAndroidJUnit"
        const val espresso = "androidx.test.espresso:espresso-core:$versionEspresso"
    }

    object ProjectPlugins {
        const val googleServices = "com.google.gms:google-services:$versionGoogleServices"
    }

}