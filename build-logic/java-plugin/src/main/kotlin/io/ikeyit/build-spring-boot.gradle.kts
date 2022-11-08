package io.ikeyit

import gradle.kotlin.dsl.accessors._8f74d40e65146e53e01081fb4d1e0967.implementation
import gradle.kotlin.dsl.accessors._8f74d40e65146e53e01081fb4d1e0967.processResources
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("io.ikeyit.build-java")
    id("org.springframework.boot")
}

tasks {
    processResources {
        filesMatching("**/application.yaml") {
            val profile = findProperty("profile") ?: "dev";
            expand(mapOf("profile" to profile))
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
}