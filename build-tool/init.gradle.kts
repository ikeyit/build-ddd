settingsEvaluated {
    pluginManagement {
        repositories {
            // define your private plugin repository
//            maven("https://maven.aliyun.com/repository/gradle-plugin")
            gradlePluginPortal()
        }
    }

    dependencyResolutionManagement {
        repositories {
            // define your private library repository
//            maven("https://maven.aliyun.com/repository/public/")
            mavenCentral()
            mavenLocal()
        }
    }
}

projectsEvaluated {
    allprojects {
        // define the centralized distribution repository for all projects
        if (plugins.hasPlugin("maven-publish")) {
            configure<PublishingExtension> {
                repositories {
                    maven {
                        val releasesRepoUrl = uri("https://maven.aliyun.com/repository/release")
                        val snapshotsRepoUrl = uri("https://maven.aliyun.com/repository/snapshot")
                        url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
                        credentials {
                            username = "yourUserName"
                            password = "yourPassword"
                        }
                    }
                }
            }
        }
    }
}