import cn.lalaki.pub.BaseCentralPortalPlusExtension.PublishingType

val v = "1.0.0"
val localMavenRepo = uri(layout.buildDirectory.dir("repo").get())

plugins {
  kotlin("jvm")
  kotlin("plugin.serialization") version "1.9.0"
  id("org.jetbrains.compose")
  id("org.jetbrains.kotlin.plugin.compose")
  alias(libs.plugins.spotless)
  alias(libs.plugins.central)
  alias(libs.plugins.dokka)
  `maven-publish`
  signing
}

group = "xyz.malefic"
version = v

repositories {
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  google()
}

dependencies {
  implementation(compose.desktop.common)
  implementation(libs.json)
  testImplementation(kotlin("test"))
  testImplementation(compose.desktop.currentOs)
}

spotless {
  kotlin {
    ktfmt().googleStyle()
  }
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
  withJavadocJar()
  withSourcesJar()
}

kotlin {
  jvmToolchain {
    this.languageVersion.set(JavaLanguageVersion.of(17))
  }
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      groupId = "xyz.malefic"
      artifactId = "malefictheming"
      version = v

      from(components["java"])

      pom {
        name.set("MaleficTheming")
        description.set("A Compose Desktop library for creating and managing material themes")
        url.set("https://github.com/MaleficCompose/MaleficTheming")
        developers {
          developer {
            name.set("Om Gupta")
            email.set("ogupta4242@gmail.com")
          }
        }
        licenses {
          license {
            name.set("MIT License")
            url.set("https://opensource.org/licenses/MIT")
          }
        }
        scm {
          connection.set("scm:git:git://github.com/MaleficCompose/MaleficTheming.git")
          developerConnection.set("scm:git:ssh://github.com/MaleficCompose/MaleficTheming.git")
          url.set("https://github.com/MaleficCompose/MaleficTheming")
        }
      }
    }
    repositories {
      maven {
        url = localMavenRepo
      }
    }
  }
}

signing {
  useGpgCmd()
  sign(publishing.publications)
}

centralPortalPlus {
  url = localMavenRepo
  username = System.getenv("centralPortalUsername") ?: ""
  password = System.getenv("centralPortalPassword") ?: ""
  publishingType = PublishingType.AUTOMATIC
}

tasks.apply {
  dokkaHtml {
    outputDirectory.set(layout.buildDirectory.dir("dokka"))
  }
  test {
    useJUnitPlatform()
  }
  build {
    dependsOn(spotlessApply)
  }
}
