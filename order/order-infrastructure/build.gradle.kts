plugins {
    id("io.ikeyit.build-java")
}

dependencies {
    implementation(project(":order-domain"))
    implementation(project(":order-application"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    runtimeOnly("mysql:mysql-connector-java")
}

