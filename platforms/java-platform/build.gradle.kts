plugins {
    `java-platform`
    `maven-publish`
}

javaPlatform {
    allowDependencies()
}

publishing {
    publications {
        create<MavenPublication>("bom") {
            from(components["javaPlatform"])
        }
    }
}

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:2.7.5"))
    api(platform("com.fasterxml.jackson:jackson-bom:2.14.0-rc2"))
    api(platform("org.junit:junit-bom:5.9.1"))
    api(platform("org.mockito:mockito-bom:4.8.0"))
    api(platform("io.netty:netty5-bom:5.0.0.Alpha5"))
    api(platform("io.grpc:grpc-bom:1.50.2"))
    constraints {
        api("jakarta.servlet:jakarta.servlet-api:5.0.0")
        api("org.quartz-scheduler:quartz:2.3.2")
        api("com.google.guava:guava:31.1-jre")
        api("javax.annotation:javax.annotation-api:1.3.2")
    }
}