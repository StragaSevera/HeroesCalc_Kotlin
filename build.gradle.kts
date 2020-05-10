plugins {
    kotlin("jvm") version "1.3.72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

val spekVersion: String by extra("2.0.9")
val atriumVersion: String by extra("0.11.1")
val mockkVersion: String by extra("1.10.0")

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testRuntimeOnly(kotlin("reflect"))
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
    testImplementation("ch.tutteli.atrium:atrium-fluent-en_GB:$atriumVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform {
            includeEngines("spek2")
        }
    }
}