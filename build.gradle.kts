import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.github.gonozalviii"
version = "0.6"

plugins {
    kotlin("jvm") version "1.2.61"
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

    withType<Test> {
        useJUnitPlatform()
        setForkEvery(1)
    }

    withType<Wrapper> {
        gradleVersion = "4.10.1"
    }

}

val sourcesJar by tasks.registering(Jar::class) {
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}