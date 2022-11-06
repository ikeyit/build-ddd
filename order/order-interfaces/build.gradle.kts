plugins {
    id("buildlogic.spring-boot")
}

tasks {
    bootRun {
        mainClass.set("com.ddd.order.interfaces.AllInOneApp")
    }
    bootJar {
        archiveClassifier.set("boot")
        mainClass.set("com.ddd.order.interfaces.AllInOneApp")
        launchScript()
    }
}


dependencies {
    implementation(project(":order-domain"))
    implementation(project(":order-application"))
    implementation(project(":order-infrastructure"))
    implementation("org.quartz-scheduler:quartz")
}