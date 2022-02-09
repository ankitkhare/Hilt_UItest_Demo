import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

fun PluginDependenciesSpec.androidApp(): PluginDependencySpec =
    id("com.android.application")

fun PluginDependenciesSpec.kotlinAndroid(): PluginDependencySpec =
    id("kotlin-android")

fun PluginDependenciesSpec.hilt(): PluginDependencySpec = id("dagger.hilt.android.plugin")

fun PluginDependenciesSpec.kapt(): PluginDependencySpec = id("kotlin-kapt")

fun PluginDependenciesSpec.kotlinSerialization(): PluginDependencySpec =
    kotlin("plugin.serialization") version Libraries.Kotlin.version