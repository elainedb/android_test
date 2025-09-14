// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("org.sonarqube") version "6.3.1.5724"
    id("jacoco")
}

sonar {
    properties {
        property("sonar.projectKey", "elainedb_android_test")
        property("sonar.organization", "elainedb")
    }
}

tasks.register("jacocoTestReport") {
    dependsOn(":app:jacocoTestReport")
    group = "verification"
    description = "Generate Jacoco coverage reports for all modules"
}

