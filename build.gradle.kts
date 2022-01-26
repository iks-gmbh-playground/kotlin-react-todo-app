plugins {
    kotlin("js") version "1.6.10"
}

group = "de.clsky"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.291-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.291-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-css:17.0.2-pre.291-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled-next:1.0-pre.291-kotlin-1.6.10")
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}