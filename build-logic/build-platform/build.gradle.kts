plugins {
    id("java-platform")
}

dependencies {
    constraints {
        api("org.springframework.boot:org.springframework.boot.gradle.plugin:2.7.5")
        api("com.google.protobuf:protobuf-gradle-plugin:0.9.1")
    }
}
