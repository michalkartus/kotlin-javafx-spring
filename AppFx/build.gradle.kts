group = "pl.kartus.KotlinJavaFxSpring.AppFx"
version = "0.0.1"

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
    id("org.openjfx.javafxplugin") version "0.0.9"
    application
}

application {
    mainClass.set("pl.kartus.appfx.Launcher")
}

java.sourceCompatibility = JavaVersion.VERSION_11

javafx {
    version = "11.0.2"
    modules = listOf("javafx.controls","javafx.graphics",
            "javafx.base", "javafx.fxml", "javafx.media")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
