/*
 * Copyright (c) 2018-2020, Alden Torres
 *
 * Licensed under the terms of the MIT license.
 * Copy of the license at https://opensource.org/licenses/MIT
 */

plugins {
    `java-library`
    `maven-publish`
    signing
    jacoco
}

group = "org.libtorrent4j"
version = "2.0.3-19"

java {
    // using java 8 for android compatibility
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    withJavadocJar()
    withSourcesJar()
}

val codacy: Configuration by configurations.creating

repositories {
    mavenCentral()
}

dependencies {

    testImplementation("junit:junit:4.12")

    codacy("com.codacy:codacy-coverage-reporter:7.1.0")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.test {
    testLogging {
        events("passed", "skipped", "failed", "standard_out")

        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }

    systemProperty("file.encoding", "utf-8")
    systemProperty("java.library.path", file(".").absolutePath)
    environment("LD_LIBRARY_PATH", File(".").absolutePath)
}

tasks.register<Zip>("nativeMacOSJar") {
    destinationDirectory.set(file("$buildDir/libs"))
    archiveBaseName.set("libtorrent4j-macos")
    archiveExtension.set("jar")

    from("swig/bin/release/macos") {
        include("**/*libtorrent4j.dylib")
        exclude("**/ed25519", "**/src", "**/*.dSYM")
        into("lib")
    }
}

tasks.register<Zip>("nativeWindowsJar") {
    destinationDirectory.set(file("$buildDir/libs"))
    archiveBaseName.set("libtorrent4j-windows")
    archiveExtension.set("jar")

    from("swig/bin/release/windows") {
        include("**/*libtorrent4j.dll")
        exclude("**/ed25519", "**/src")
        into("lib")
    }
}

tasks.register<Zip>("nativeLinuxJar") {
    destinationDirectory.set(file("$buildDir/libs"))
    archiveBaseName.set("libtorrent4j-linux")
    archiveExtension.set("jar")

    from("swig/bin/release/linux") {
        include("**/*libtorrent4j.so")
        exclude("**/ed25519", "**/src")
        into("lib")
    }
}

tasks.register<Zip>("nativeAndroidArmJar") {
    destinationDirectory.set(file("$buildDir/libs"))
    archiveBaseName.set("libtorrent4j-android-arm")
    archiveExtension.set("jar")

    from("swig/bin/release/android") {
        include("armeabi-v7a/libtorrent4j.so")
        into("lib")
    }
}

tasks.register<Zip>("nativeAndroidX86Jar") {
    destinationDirectory.set(file("$buildDir/libs"))
    archiveBaseName.set("libtorrent4j-android-x86")
    archiveExtension.set("jar")

    from("swig/bin/release/android") {
        include("x86/libtorrent4j.so")
        into("lib")
    }
}

tasks.register<Zip>("nativeAndroidArm64Jar") {
    destinationDirectory.set(file("$buildDir/libs"))
    archiveBaseName.set("libtorrent4j-android-arm64")
    archiveExtension.set("jar")

    from("swig/bin/release/android") {
        include("arm64-v8a/libtorrent4j.so")
        into("lib")
    }
}

tasks.register<Zip>("nativeAndroidX64Jar") {
    destinationDirectory.set(file("$buildDir/libs"))
    archiveBaseName.set("libtorrent4j-android-x86_64")
    archiveExtension.set("jar")

    from("swig/bin/release/android") {
        include("x86_64/libtorrent4j.so")
        into("lib")
    }
}

tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

fun generatePom(pomName: String, addDeps: Boolean = false) = Action<org.gradle.api.publish.maven.MavenPom> {
    name.set(pomName)
    description.set("A swig Java interface for libtorrent")
    url.set("https://github.com/aldenml/libtorrent4j")
    scm {
        connection.set("scm:git:git://github.com/aldenml/libtorrent4j.git")
        developerConnection.set("scm:git:ssh:git@github.com/aldenml/libtorrent4j.git")
        url.set("https://github.com/aldenml/libtorrent4j")
    }
    licenses {
        license {
            name.set("The MIT License")
            url.set("https://github.com/aldenml/libtorrent4j/blob/master/LICENSE.md")
        }
    }
    developers {
        developer {
            id.set("aldenml")
            name.set("Alden Torres")
            email.set("aldenml@gmail.com")
        }
    }

    if (addDeps)
        withXml {
            val root = asNode()
            val dependenciesNode = root.appendNode("dependencies")
            val depNode = dependenciesNode.appendNode("dependency")
            depNode.appendNode("groupId", group)
            depNode.appendNode("artifactId", "libtorrent4j")
            depNode.appendNode("version", version)
        }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "libtorrent4j"
            from(components["java"])
            pom(generatePom(artifactId))
        }
        create<MavenPublication>("mavenMacOS") {
            artifactId = "libtorrent4j-macos"
            artifact(tasks["nativeMacOSJar"])
            pom(generatePom(artifactId, true))
        }
        create<MavenPublication>("mavenWindows") {
            artifactId = "libtorrent4j-windows"
            artifact(tasks["nativeWindowsJar"])
            pom(generatePom(artifactId, true))
        }
        create<MavenPublication>("mavenLinux") {
            artifactId = "libtorrent4j-linux"
            artifact(tasks["nativeLinuxJar"])
            pom(generatePom(artifactId, true))
        }
        create<MavenPublication>("mavenAndroidArm") {
            artifactId = "libtorrent4j-android-arm"
            artifact(tasks["nativeAndroidArmJar"])
            pom(generatePom(artifactId, true))
        }
        create<MavenPublication>("mavenAndroidX86") {
            artifactId = "libtorrent4j-android-x86"
            artifact(tasks["nativeAndroidX86Jar"])
            pom(generatePom(artifactId, true))
        }
        create<MavenPublication>("mavenAndroidArm64") {
            artifactId = "libtorrent4j-android-arm64"
            artifact(tasks["nativeAndroidArm64Jar"])
            pom(generatePom(artifactId, true))
        }
        create<MavenPublication>("mavenAndroidX64") {
            artifactId = "libtorrent4j-android-x86_64"
            artifact(tasks["nativeAndroidX64Jar"])
            pom(generatePom(artifactId, true))
        }
    }

    repositories {
        maven {
            credentials {
                username = if (hasProperty("ossrhUsername"))
                    property("ossrhUsername").toString() else ""
                password = if (hasProperty("ossrhPassword"))
                    property("ossrhPassword").toString() else ""
            }
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
    sign(publishing.publications["mavenMacOS"])
    sign(publishing.publications["mavenWindows"])
    sign(publishing.publications["mavenLinux"])
    sign(publishing.publications["mavenAndroidArm"])
    sign(publishing.publications["mavenAndroidX86"])
    sign(publishing.publications["mavenAndroidArm64"])
    sign(publishing.publications["mavenAndroidX64"])
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
    }
}

tasks.register<JavaExec>("codacyCoverage") {
    dependsOn(tasks.jacocoTestReport)

    main = "com.codacy.CodacyCoverageReporter"
    classpath = codacy
    args = listOf(
        "report",
        "-l",
        "Java",
        "-r",
        "${buildDir}/reports/jacoco/test/jacocoTestReport.xml"
    )
}
