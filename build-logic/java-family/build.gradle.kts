import groovy.util.Node

plugins {
    `kotlin-dsl`
    `maven-publish`
//    id("com.gradle.plugin-publish").version("1.0.0")
}

//pluginBundle {
//    website = "http://ddd.org"
//    tags = listOf("ddd", "internal")
//}
afterEvaluate {
    val javaComponent = components.findByName("java") as AdhocComponentWithVariants
    configurations {
        val liteRuntimeElements = create("liteRuntimeElements") {
            isCanBeResolved = false
            isCanBeConsumed = true

        }

        liteRuntimeElements.attributes {
            val attr = runtimeElements.get().attributes;
            for (a in attr.keySet()) {
                attribute(a as Attribute<Any>, attr.getAttribute(a)!!)
            }
        }

        liteRuntimeElements.dependencies.addAll(runtimeElements.get().allDependencies.filter {
            println(it.name)
            it.name != "build-platform"
        })

        liteRuntimeElements.outgoing {
            runtimeElements.get().outgoing.artifacts.forEach {
                artifact(it)
            }
        }
        javaComponent.addVariantsFromConfiguration(liteRuntimeElements) {
            // dependencies for this variant are considered runtime dependencies
            mapToMavenScope("runtime")
        }

        javaComponent.withVariantsFromConfiguration(runtimeElements.get()) {
            skip()
        }
    }


}

gradlePlugin {
    plugins {
        named("buildlogic.java") {
            displayName = "displayName"
        }
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
    implementation(platform(project(":build-platform")))
    implementation("org.springframework.boot:org.springframework.boot.gradle.plugin")
    implementation("com.google.protobuf:protobuf-gradle-plugin")
}
