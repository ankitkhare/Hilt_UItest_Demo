plugins {
    `kotlin-dsl`
}

val androidGradlePlugin = "com.android.tools.build:gradle:4.1.0"
val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32"

repositories {
    mavenCentral()
    google()
    jcenter()
}

dependencies {
    implementation(androidGradlePlugin)
    implementation(kotlinGradlePlugin)
}