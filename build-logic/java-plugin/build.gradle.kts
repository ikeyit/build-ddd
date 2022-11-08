plugins {
    `kotlin-dsl`
    `maven-publish`
}

afterEvaluate {
    // Avoid platform dependency generation in POM and Metadata file
    val runtimeElements by configurations
    val liteRuntimeElements = runtimeElements.copyRecursive {
        it.name != "plugin-platform"
    }
    val javaComponent = components.findByName("java") as AdhocComponentWithVariants
    javaComponent.addVariantsFromConfiguration(liteRuntimeElements) {
        mapToMavenScope("runtime")
    }
    javaComponent.withVariantsFromConfiguration(runtimeElements) {
        skip()
    }
}

publishing {
    publications {
        withType<MavenPublication>  {
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }

}
dependencies {
    implementation(platform(project(":plugin-platform")))
    implementation("org.springframework.boot:org.springframework.boot.gradle.plugin")
    implementation("com.google.protobuf:protobuf-gradle-plugin")
}
