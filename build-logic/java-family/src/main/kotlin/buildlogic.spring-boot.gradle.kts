plugins {
    id("buildlogic.java")
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