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
configurations {
    val internal = create("internal") {
        isCanBeResolved = false
        isCanBeConsumed = false
    }

    compileClasspath.get().extendsFrom(internal)
    runtimeClasspath.get().extendsFrom(internal)
    testCompileClasspath.get().extendsFrom(internal)
    testRuntimeClasspath.get().extendsFrom(internal)
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
            pom {
//                withXml {
//                    val root = asNode()
//                    val nodes = root["dependencyManagement"] as groovy.util.NodeList
//                    if (nodes.isNotEmpty()) {
//                        nodes.forEach {
//                            root.remove(it as Node?)
//                        }
//                    }
//                }
            }
        }
    }

}
dependencies {
    "internal"(platform(project(":build-platform")))
    implementation("org.springframework.boot:org.springframework.boot.gradle.plugin")
    implementation("com.google.protobuf:protobuf-gradle-plugin")
}
