plugins {
    id("buildlogic.java")
    `java-library`
    `maven-publish`
}


publishing {
    publications {
        create<MavenPublication>("sdk") {
            from(components["java"])
            pom {
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("liu")
                        name.set("zhe")
                        email.set("liuzhe@example.com")
                    }
                }
//                withXml {
//                    val root = asNode()
//                    val nodes = root["dependencyManagement"] as groovy.util.NodeList
//                    if (nodes.isNotEmpty()) {
//                        root.remove(nodes.first() as groovy.util.Node)
//                    }
//                }
            }

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