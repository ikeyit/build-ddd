package io.ikeyit

import gradle.kotlin.dsl.accessors._72efc76fad8c8cf3476d335fb6323bde.implementation
import gradle.kotlin.dsl.accessors._72efc76fad8c8cf3476d335fb6323bde.test
import gradle.kotlin.dsl.accessors._72efc76fad8c8cf3476d335fb6323bde.testImplementation
import gradle.kotlin.dsl.accessors._72efc76fad8c8cf3476d335fb6323bde.testRuntimeOnly
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("java")
}

configure<JavaPluginExtension> {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

configurations {
    val internal = create("internal") {
        isCanBeResolved = false
        isCanBeConsumed = false
    }
    implementation.get().extendsFrom(internal)
}

fun DependencyHandler.`internal`(dependencyNotation: Any): Dependency? =
    add("internal", dependencyNotation)

dependencies {
    internal(platform("io.ikeyit:java-platform:1.0-SNAPSHOT"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
    test {
        useJUnitPlatform()
    }
}