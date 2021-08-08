group = "com.github.gonozalviii"
version = "0.6"

plugins {
    java
    kotlin("jvm") version "1.3.20"
    id("org.openjfx.javafxplugin") version "0.0.10"
    `maven-publish`
}

repositories {
    mavenCentral()
}

apply(from = "testreport.gradle.kts")

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.4.0")
}

javafx {
    version = "11"
    modules("javafx.web", "javafx.fxml", "javafx.swing")
    configuration = "compileOnly"
}

java {
    targetCompatibility = JavaVersion.VERSION_11
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks {

    compileKotlin {
        targetCompatibility = "11"
    }

    val testWithFork by registering(Test::class) {
        useJUnitPlatform {
            includeTags("ForkVM")
        }
        setForkEvery(1)
        maxParallelForks = Runtime.getRuntime().availableProcessors()
    }

    test {
        useJUnitPlatform {
            excludeTags("ForkVM")
        }
        finalizedBy(testWithFork)
    }
    
    wrapper {
        gradleVersion = "5.2.1"
    }

}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
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