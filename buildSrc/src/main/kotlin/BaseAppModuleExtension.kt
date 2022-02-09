import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

fun BaseAppModuleExtension.setAppConfig() {
    compileSdkVersion(ProjectConfiguration.COMPILE_SDK)
    buildToolsVersion(ProjectConfiguration.BUILD_TOOLS_VERSION)
    useLibrary("org.apache.http.legacy")

    defaultConfig {
        minSdkVersion(ProjectConfiguration.MIN_SDK)
        targetSdkVersion(ProjectConfiguration.TARGET_SDK)

        multiDexEnabled = true
        testInstrumentationRunner = ProjectConfiguration.TEST_INSTRUMENTATION_RUNNER

        proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = ProjectConfiguration.JAVA_VERSION
        targetCompatibility = ProjectConfiguration.JAVA_VERSION
    }

    lintOptions {
        isAbortOnError = false
    }

    //supported architectures for abi / Android App Bundle
    bundle {
        language {
            enableSplit = false
        }
    }
}