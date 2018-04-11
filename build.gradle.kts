import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.github.gonozalviii"
version = "0.5"

plugins {
    kotlin("jvm") version "1.2.31"
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.1.0")
    testImplementation("org.mockito", "mockito-core", "2.18.0")
}

tasks {
    withType<KotlinCompile> {
        targetCompatibility = "1.8"
    }

    "sourcesJar"(Jar::class) {
        classifier = "sources"
        from(java.sourceSets["main"].allSource)
        dependsOn("classes")
    }

    withType<Test>{
        useJUnitPlatform() {

        }
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

