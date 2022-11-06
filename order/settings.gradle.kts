pluginManagement {
//    includeBuild("../build-logic")
    // manage the plugin versions
    plugins {
        id("com.gorylenko.gradle-git-properties").version("2.4.1")
        id("buildlogic.java").version("1.0-SNAPSHOT")
        id("buildlogic.java-library").version("1.0-SNAPSHOT")
        id("buildlogic.spring-boot").version("1.0-SNAPSHOT")
        id("buildlogic.grpc").version("1.0-SNAPSHOT")
    }
}
//includeBuild("../platforms")
rootProject.name = "order"
include("order-domain")
include("order-application")
include("order-infrastructure")
include("order-sdk")
include("order-interfaces")
include("order-demo")