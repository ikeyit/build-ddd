import com.google.protobuf.gradle.id

plugins {
    id("buildlogic.java-library")
    id("com.google.protobuf")
}

val grpcVersion = "1.50.1"
val protobufVersion = "3.21.9"
val protocVersion = protobufVersion

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${protocVersion}"
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
