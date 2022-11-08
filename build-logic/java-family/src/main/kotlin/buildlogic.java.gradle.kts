plugins {
    id("java")
}

configure<JavaPluginExtension> {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

configurations {
    val internal = create("internal") {
        isCanBeResolved = false
        isCanBeConsumed = false
    }
    implementation.get().extendsFrom(internal)
}

fun DependencyHandler.`internal`(dependencyNotation: Any): Dependency? =
    add("internal", dependencyNotation)

dependencies {
    internal(platform("com.ddd.build:java-platform:1.0-SNAPSHOT"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
    test {
        useJUnitPlatform()
    }
}