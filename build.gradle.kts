import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.github.gonozalviii"
version = "0.6"

plugins {
    kotlin("jvm") version "1.2.60"
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
    testImplementation("org.junit", "junit-bom", "5.2.0")
    testImplementation("org.junit.jupiter", "junit-jupiter-engine")
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
        setForkEvery(1)
    }

    withType<Wrapper> {
        gradleVersion = "4.9"
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

