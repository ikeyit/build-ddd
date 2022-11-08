package io.ikeyit

import com.google.protobuf.gradle.*
import gradle.kotlin.dsl.accessors._0b6bf4a515836b3ae806020a15174855.implementation
import gradle.kotlin.dsl.accessors._0b6bf4a515836b3ae806020a15174855.main
import gradle.kotlin.dsl.accessors._0b6bf4a515836b3ae806020a15174855.protobuf
import gradle.kotlin.dsl.accessors._0b6bf4a515836b3ae806020a15174855.sourceSets
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("io.ikeyit.build-java-library")
    id("com.google.protobuf")
}

val grpcVersion = "1.50.1"
val protobufVersion = "3.21.9"

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${protobufVersion}"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
    }

    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                id("grpc") {
                    option("lite")
                }
            }
        }
    }
}

sourceSets {
    main {
        java {
            srcDirs("build/generated/source/proto/main/grpc")
            srcDirs("build/generated/source/proto/main/java")
        }
    }
}

dependencies {
    implementation("io.grpc:grpc-protobuf")
    implementation("io.grpc:grpc-stub")
    implementation("javax.annotation:javax.annotation-api")
}
