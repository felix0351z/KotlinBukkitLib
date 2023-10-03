import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName
import java.net.URI

plugins {
    val kotlinPluginVersion = "1.8.20"
    val shadowVersion = "7.0.0"

    kotlin("jvm") version kotlinPluginVersion
    id("com.github.johnrengelman.shadow") version shadowVersion
}

group = "de.felix0351"
version = "1.0"

repositories {
    mavenCentral()
    maven {
        name = "spigotmc-repo"
        url = URI("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
    val kotlin_version = "1.8.20"
    val ktor_version = "2.3.4"
    val exposed_version = "0.44.0"
    val coroutines_version = "1.7.3"
    val sqlite_version = "3.43.0.0"
    val mariadb_version = "3.2.0"

    //Kotlin standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    //Kotlin Exposed SQL library
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    //Kotlin Coroutines Core for JVM
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    //Kotlin Ktor library for network communication
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-java:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

    //SQLite Driver
    implementation("org.xerial:sqlite-jdbc:$sqlite_version")
    //MariaDB Driver
    implementation("org.mariadb.jdbc:mariadb-java-client:$mariadb_version")

}

tasks.withType<PublishToMavenRepository> {
    dependsOn(tasks.shadowJar)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

shadow {
    archivesName.set("KotlinBukkitLib")
    version = "1.8.20" // Set the version to the current kotlin version
}