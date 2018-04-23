import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.github.gonozalviii"
version = "0.5"

plugins {
    kotlin("jvm") version "1.2.40"
    `maven-publish`
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit", "junit-bom", "5.2.0-M1")
    testImplementation("org.junit.jupiter", "junit-jupiter-engine")
    val mockitoVersion = "2.18.0"
    testImplementation("org.mockito", "mockito-core", mockitoVersion)
    testImplementation("org.mockito", "mockito-inline", mockitoVersion)
    testImplementation("org.mockito", "mockito-junit-jupiter", mockitoVersion)
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

    withType<Test> {
        useJUnitPlatform()
    }

    withType<Wrapper> {
        gradleVersion = "4.7"
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

