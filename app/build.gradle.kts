plugins {
    androidApp()
    kotlinAndroid()
    kotlinSerialization()
    kapt()
    hilt()
}

android {
    setAppConfig()

    buildFeatures {
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    testOptions {
        animationsDisabled = true
    }
}

dependencies {

    // HILT
    implementation(Libraries.DependencyInjection.hiltAndroid)
    kapt(Libraries.DependencyInjection.hiltCompiler)

    implementation(Libraries.Kotlin.coreKtx)

    // Network
    implementation(Libraries.Network.Retrofit.retrofitSdk)
    implementation(Libraries.Network.Retrofit.kotlinSerializationConverter)
    implementation(Libraries.Network.Okhttp.okhttp3)
    implementation(Libraries.Network.Okhttp.loggingInterceptor)
    implementation(Libraries.Network.Serialization.json)
    implementation(Libraries.AndroidX.appcompat)
    implementation(Libraries.AndroidX.recyclerview)
    implementation(Libraries.AndroidX.constraintLayout)
    implementation(Libraries.AndroidX.fragmentX)
    implementation(Libraries.AndroidX.v4)
    implementation(Libraries.AndroidX.design)

    androidTestImplementation(Libraries.AndroidTestLibraries.espresso)

    androidTestImplementation(Libraries.AndroidTestLibraries.extJUnit)
    androidTestImplementation(Libraries.AndroidTestLibraries.testRules)
    androidTestImplementation(Libraries.AndroidTestLibraries.kakao)
    testImplementation(Libraries.TestLibraries.junit4)
    testImplementation(Libraries.TestLibraries.mockito)
    testImplementation(Libraries.TestLibraries.androidxTest)
    testImplementation(Libraries.TestLibraries.androidxRunners)
    testImplementation(Libraries.TestLibraries.androidxRules)
    testImplementation(Libraries.TestLibraries.androidxTestExt)
    testImplementation(Libraries.TestLibraries.roboElectric)
    testImplementation(Libraries.Network.Okhttp.okhttpMockServer)
    androidTestImplementation(Libraries.AndroidTestLibraries.idling)
    androidTestImplementation(Libraries.Network.Okhttp.okhttpMockServer)
    androidTestImplementation(Libraries.AndroidTestLibraries.hiltTest)
    androidTestImplementation(Libraries.TestLibraries.mockito_kotlin)
    kaptAndroidTest(Libraries.AndroidTestLibraries.hiltTestKapt)

    val mockk_version = "1.10.0"
    testImplementation("io.mockk:mockk:$mockk_version")
    androidTestImplementation("io.mockk:mockk-android:$mockk_version")
}

kapt {
    correctErrorTypes = true
}