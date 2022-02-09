buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath(Libraries.DependencyInjection.hiltPlugin)
    }

    allprojects {
        repositories {
            google()
            jcenter()
            mavenCentral()
            maven("https://jitpack.io")

            tasks.withType<JavaCompile> {
                sourceCompatibility = ProjectConfiguration.JAVA_VERSION.toString()
                targetCompatibility = ProjectConfiguration.JAVA_VERSION.toString()
            }

            tasks.withType<Test> {
                testLogging {
                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
                    events = mutableSetOf(
                        org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
                        org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED)
                    showStandardStreams = true
                }
            }
        }
    }
}
