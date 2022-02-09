object Libraries {

    object Kotlin {
        const val version = "1.4.32"
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
    }

    object DependencyInjection {
        private const val version = "2.35"
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
    }

    object AndroidX {
        private const val supportVersion = "1.0.0"

        const val appcompat = "androidx.appcompat:appcompat:$supportVersion"
        const val v4 = "androidx.legacy:legacy-support-v4:$supportVersion"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val recyclerview = "androidx.recyclerview:recyclerview:$supportVersion"
        const val design = "com.google.android.material:material:$supportVersion"
        const val fragmentX = "androidx.fragment:fragment-ktx:1.3.3"
    }

    object Network {

        object Okhttp {
            private const val version = "4.9.0"
            const val okhttp3 = "com.squareup.okhttp3:okhttp:$version"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
            const val okhttpMockServer = "com.squareup.okhttp3:mockwebserver:$version"
        }

        object Retrofit {
            private const val version = "2.9.0"
            const val retrofitSdk = "com.squareup.retrofit2:retrofit:$version"
            const val kotlinSerializationConverter =
                "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
        }

        object Serialization {
            private const val version = "1.1.0"
            const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        }
    }

    object AndroidTestLibraries {
        private const val testVersion = "1.1.1"
        const val extJUnit = "androidx.test.ext:junit:$testVersion"
        const val testRules = "androidx.test:rules:$testVersion"
        const val espresso = "androidx.test.espresso:espresso-core:3.1.0"
        const val idling = "com.jakewharton.espresso:okhttp3-idling-resource:1.0.0"
        const val kakao = "io.github.kakaocup:kakao:3.0.2"
        const val hiltTest = "com.google.dagger:hilt-android-testing:2.35"
        const val hiltTestKapt = "com.google.dagger:hilt-android-compiler:2.35"
    }

    object TestLibraries {
        private const val androidxVersion = "1.3.0"
        const val junit4 = "junit:junit:4.12"
        const val mockito = "org.mockito:mockito-core:1.10.19"
        const val mockito_kotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
        const val androidxTest = "androidx.test:core:$androidxVersion"
        const val androidxRunners = "androidx.test:runner:$androidxVersion"
        const val androidxRules = "androidx.test:rules:$androidxVersion"
        const val androidxTestExt = "androidx.test.ext:junit:1.1.2"
        const val roboElectric = "org.robolectric:robolectric:4.5.1"
        const val junitKtx = "androidx.test.ext:junit-ktx:1.1.2"
    }
}