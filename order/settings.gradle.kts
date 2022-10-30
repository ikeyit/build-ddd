pluginManagement {
    // manage the plugin versions
    plugins {
        id("org.springframework.boot").version("2.7.5")
        id("com.gorylenko.gradle-git-properties").version("2.4.1")
        id("com.google.protobuf").version("0.9.1")
    }
}
includeBuild("../dependency-platform")
rootProject.name = "order"
include("order-domain")
include("order-application")
include("order-infrastructure")
include("order-sdk")
include("order-interfaces")

