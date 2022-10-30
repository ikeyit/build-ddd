settingsEvaluated {
    pluginManagement {
        repositories {
            // use aliyun repository to speed up plugin download in China
//            maven("https://maven.aliyun.com/repository/gradle-plugin")
            gradlePluginPortal()
        }
    }

    dependencyResolutionManagement {
        repositories {
            // use aliyun repository to speed up library download in China
//            maven("https://maven.aliyun.com/repository/public/")
            mavenLocal()
            mavenCentral()
        }
    }
}