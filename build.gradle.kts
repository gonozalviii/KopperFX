group = "com.github.gonozalviii"
version = "0.6"

plugins {
    kotlin("jvm") version "1.3.10"
    `maven-publish`
}

repositories {
    mavenCentral()
}

apply(from = "testreport.gradle.kts")

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(enforcedPlatform("org.junit:junit-bom:5.3.1"))
    testImplementation("org.junit.jupiter", "junit-jupiter-engine")
}

tasks {

    compileKotlin {
        targetCompatibility = "1.8"
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
        gradleVersion = "5.0-rc-5"
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