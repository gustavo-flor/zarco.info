import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}

group = "com.github.gustavo-flor"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2023.0.1"

val springDocVersion = "2.5.0"
val springCloudAwsVersion = "3.1.1"

dependencies {
    // Spring Web
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${springDocVersion}")

    // Spring Ops
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Spring I/O
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Spring Cloud
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Distributed Tracing
    implementation("io.micrometer:micrometer-tracing-bridge-brave")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // AWS
    implementation(platform("io.awspring.cloud:spring-cloud-aws-dependencies:${springCloudAwsVersion}"))
    implementation("io.awspring.cloud:spring-cloud-aws-starter-sqs")

    // Database
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    runtimeOnly("org.postgresql:postgresql")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testRuntimeOnly("com.h2database:h2")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
