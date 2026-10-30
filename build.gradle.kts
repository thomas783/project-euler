plugins {
    kotlin("jvm") version "2.2.21"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("solve") {
    group = "application"
    description = "Runs a problem's main function, e.g. ./gradlew solve -Pproblem=1 --args=\"1000\""
    val number = providers.gradleProperty("problem").map { "%03d".format(it.toInt()) }
    mainClass.set(number.map { "euler.p$it.Problem${it}Kt" })
    classpath = sourceSets.main.get().runtimeClasspath
    javaLauncher.set(javaToolchains.launcherFor { languageVersion.set(JavaLanguageVersion.of(21)) })
}
