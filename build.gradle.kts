plugins {
    `java-library`
    `maven-publish`
    signing
    jacoco
}

group = "org.libtorrent4j"
version = "1.3.0"

java {
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

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.test {
    testLogging {
        events("passed", "skipped", "failed")
    }

    environment("LD_LIBRARY_PATH", File(".").absolutePath)
}

tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "libtorrent4j"
            from(components["java"])
            pom {
                name.set("libtorrent4j")
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
            }
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
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
    }
}

tasks.register("codacyCoverage", JavaExec::class) {
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
