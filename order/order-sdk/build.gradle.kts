plugins {
    `java-library`
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
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
            }
        }
    }
}

dependencies {
    implementation("com.google.guava:guava")
}

