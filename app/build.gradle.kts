plugins {
    id("buildlogic.java-application-conventions")
    id("checkstyle")
    id("com.github.spotbugs") version "6.1.7"
    id("io.freefair.lombok") version "8.13"
    id("java")
    kotlin("jvm") version "2.0.21" apply false
    jacoco
    pmd
    war
}

group = "jp.osaka.tomohisa"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))

    implementation(libs.bundles.logback)

    implementation(libs.jakartaee.api)
    implementation(libs.bundles.jakarta.faces)

    testImplementation(libs.bundles.test)
}

application {
    // Define the main class for the application.
    mainClass = "org.example.app.App"
}
java {
     modularity.inferModulePath = true
     toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
tasks.war {
    archiveFileName.set("app.war")
}

tasks.javadoc {
    exclude("**/generated/**")
}
tasks.withType<JavaExec> {
    jvmArgs("-XX:+EnableDynamicAgentLoading")
}
// checkstyleの設定
checkstyle {
    configFile = file("${rootProject.projectDir}/config/checkstyle/sun_checks.xml")
    toolVersion = "10.21.1"
    //sourceSets = listOf(sourceSets("main"))
}
tasks.named<Checkstyle>("checkstyleTest") {
    isEnabled = false
}
tasks.withType<Checkstyle> {
    ignoreFailures = true
    exclude("**/generated/**")
}

// jacocoの設定
jacoco {
    toolVersion = "0.8.12"
    reportsDirectory = layout.buildDirectory.dir("reports/jacoco")
}
tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

// pmdの設定
pmd {
    toolVersion = "7.10.0"
    ruleSets = emptyList()
    ruleSetFiles = files("${rootProject.projectDir}/config/pmd/pmd-ruleset.xml")
}
tasks.withType<Pmd> {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    ignoreFailures = true
    exclude("**/generated/**")
}

// spotBugsの設定
spotbugs {
    toolVersion = "4.9.0"
    effort.set(com.github.spotbugs.snom.Effort.MAX)
    reportLevel.set(com.github.spotbugs.snom.Confidence.HIGH)
    showProgress.set(true)
    ignoreFailures = true
}
tasks.withType<com.github.spotbugs.snom.SpotBugsTask> {
    reports {
        create("html") {
            required.set(true)
        }
    }
}

// testの設定
tasks.named<Test>("test") {
    jvmArgs("-XX:+EnableDynamicAgentLoading")
    useJUnitPlatform()
    ignoreFailures = true
    maxHeapSize = "1G"
    testLogging {
        events("passed", "skipped", "failed", "standardOut", "standardError")
    }
    finalizedBy(tasks.jacocoTestReport)
}