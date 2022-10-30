plugins {
    java
//    id("com.gorylenko.gradle-git-properties").apply(false)
}

configure(subprojects) {
    apply(plugin = "java")
//    apply(plugin = "com.gorylenko.gradle-git-properties")
    configure<JavaPluginExtension> {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
    tasks {
        test {
            useJUnitPlatform()
        }
    }

    dependencies {
        implementation(enforcedPlatform(platform("com.ddd:dependency-platform")))
        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
}