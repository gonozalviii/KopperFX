import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.types.checker.captureFromArguments

group = "com.github.gonozalviii"
version = "0.3"

plugins {
    kotlin("jvm") version "1.2.21"
    `maven-publish`
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

    "sourcesJar"(Jar::class) {
        classifier = "sources"
        from(java.sourceSets["main"].allSource)
        dependsOn("classes")
    }
}

publishing {
    (publications) {
        "mavenJava"(MavenPublication::class) {
            from(components["java"])
            artifact(tasks["sourcesJar"])
        }
    }
}

