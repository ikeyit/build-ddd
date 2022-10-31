import com.google.protobuf.gradle.*

plugins {
    `java-library`
    `maven-publish`
    id("com.google.protobuf")
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
                        id.set("liu")
                        name.set("zhe")
                        email.set("liuzhe@example.com")
                    }
                }
            }
        }
    }
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
    implementation("javax.annotation:javax.annotation-api:1.3.2")
}

