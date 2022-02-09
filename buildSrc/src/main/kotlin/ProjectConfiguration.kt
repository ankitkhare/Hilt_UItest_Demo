import org.gradle.api.JavaVersion

object ProjectConfiguration {
    const val MIN_SDK = 24
    const val COMPILE_SDK = 30
    const val TARGET_SDK = 30
    const val BUILD_TOOLS_VERSION = "30.0.2"
    const val TEST_INSTRUMENTATION_RUNNER = "com.example.myapplication.CustomRunner"
    val JAVA_VERSION = JavaVersion.VERSION_1_8
}