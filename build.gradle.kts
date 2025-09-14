// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("org.sonarqube") version "6.3.1.5724"
}

sonar {
    properties {
        property("sonar.projectKey", "elainedb_android_test")
        property("sonar.organization", "elainedb")
        property("sonar.coverage.jacoco.xmlReportPaths", "app/build/reports/jacoco/JacocoDebugCodeCoverage/JacocoDebugCodeCoverage.xml")
        property("sonar.junit.reportPaths", "app/build/test-results/testDebugUnitTest")
        property("sonar.android.lint.reportPaths", "app/build/reports/lint-results.xml")
    }
}

tasks.register("jacocoTestReport") {
    dependsOn(":app:JacocoDebugCodeCoverage")
    group = "verification"
    description = "Generate Jacoco coverage reports for all modules"
}