plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp.plugin)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.safeargs.plugin)

}

android {
    namespace = "com.mehdisekoba.digiato"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mehdisekoba.digiato"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    //android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.swiperefreshlayout)

    //room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    // Dagger - Hilt
    implementation(libs.hilt)
    ksp(libs.hiltcompiler)
    // Navigation
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    // OkHTTP client
    implementation(libs.okhttp)
    implementation(libs.interceptor)
    // Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    // Lifecycle
    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.viewmodel)
    // Image Loading
    implementation(libs.coil)
    // Gson
    implementation(libs.google.gson)
    // Calligraphy
    implementation(libs.calligraphy)
    implementation(libs.viewpump)
    //shimmer
    implementation(libs.androidveil)
    //dynamic size
    implementation(libs.dynamicsizes)
    //date
    implementation(libs.threetenabp)
    //datastore
    implementation(libs.androidx.datastore.preferences)
    //divider
   implementation (libs.recycler.view.divider)


}