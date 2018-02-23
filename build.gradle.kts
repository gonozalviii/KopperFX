import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    withType<KotlinCompile> {
        targetCompatibility = "1.8"
    }

    withType<Wrapper> {
        gradleVersion = "4.5.1"
    }
}