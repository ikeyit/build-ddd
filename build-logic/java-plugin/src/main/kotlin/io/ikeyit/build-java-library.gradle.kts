package io.ikeyit

import gradle.kotlin.dsl.accessors._fa8ae7a11e714e4557697295cd0bbd61.publishing
import org.gradle.kotlin.dsl.`java-library`
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    id("io.ikeyit.build-java")
    `java-library`
    `maven-publish`
}

afterEvaluate {
    // Avoid internal dependency generation in POM and Metadata file
    val runtimeElements by configurations
    val dependencies = configurations["internal"].allDependencies
    val liteRuntimeElements = runtimeElements.copyRecursive {
        !dependencies.contains(it)
    }
    val javaComponent = components.findByName("java") as AdhocComponentWithVariants
    javaComponent.addVariantsFromConfiguration(liteRuntimeElements) {
        mapToMavenScope("runtime")
    }
    javaComponent.withVariantsFromConfiguration(runtimeElements) {
        skip()
    }
}

publishing {
    publications {
        create<MavenPublication>("sdk") {
            from(components["java"])
            pom {
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        name.set("ikeyit")
                        email.set("ikeyit@qq.com")
                    }
                }
            }

            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }
}