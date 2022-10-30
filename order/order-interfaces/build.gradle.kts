plugins {
    id("org.springframework.boot")
}

tasks.processResources {
    filesMatching("**/application.yaml") {
        val profile = findProperty("profile") ?: "dev";
        expand(mapOf("profile" to profile))
    }
}

tasks.bootRun {
    mainClass.set("com.ddd.order.interfaces.AllInOneApp")
}

tasks.bootJar {
    archiveClassifier.set("boot")
    mainClass.set("com.ddd.order.interfaces.AllInOneApp")
    launchScript()
}


dependencies {
    implementation(project(":order-domain"))
    implementation(project(":order-application"))
    implementation(project(":order-infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.quartz-scheduler:quartz")
}