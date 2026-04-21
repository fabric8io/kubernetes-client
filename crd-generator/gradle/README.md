# CRD Generator - Usage with Gradle in build script

The CRD Generator v2 can be used in a [build script](https://docs.gradle.org/current/userguide/writing_build_scripts.html) without an additional plugin:

## Kotlin DSL (`build.gradle.kts`)

```kotlin
import io.fabric8.crdv2.generator.CRDGenerationInfo
import io.fabric8.crdv2.generator.CRDGenerator
import io.fabric8.crd.generator.collector.CustomResourceCollector
import java.nio.file.Files

plugins {
    id("java")
}

group = "io.fabric8.crd-generator.gradle"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("io.fabric8:kubernetes-client-api:7.0.0")
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("io.fabric8:crd-generator-api-v2:7.0.0")
        classpath("io.fabric8:crd-generator-collector:7.0.0")
    }
}

tasks.register("generateCrds") {
  description = "Generate CRDs from compiled custom resource classes"
  group = "crd"

  val sourceSet = project.sourceSets["main"]

  val compileClasspathElements = sourceSet.compileClasspath.map { e -> e.absolutePath }

  val outputClassesDirs = sourceSet.output.classesDirs
  val outputClasspathElements = outputClassesDirs.map { d -> d.absolutePath }

  val classpathElements = listOf(outputClasspathElements, compileClasspathElements).flatten()
  val filesToScan = listOf(outputClassesDirs).flatten()
  val outputDir = sourceSet.output.resourcesDir

  doLast {
    Files.createDirectories(outputDir!!.toPath())

    val collector = CustomResourceCollector()
      .withParentClassLoader(Thread.currentThread().contextClassLoader)
      .withClasspathElements(classpathElements)
      .withFilesToScan(filesToScan)

    val crdGenerator = CRDGenerator()
      .customResourceClasses(collector.findCustomResourceClasses())
      .inOutputDir(outputDir)

    val crdGenerationInfo: CRDGenerationInfo = crdGenerator.detailedGenerate()

    crdGenerationInfo.crdDetailsPerNameAndVersion.forEach { (crdName, versionToInfo) ->
      println("Generated CRD $crdName:")
      versionToInfo.forEach { (version, info) -> println(" $version -> ${info.filePath}") }
    }
  }
}

tasks.named(JvmConstants.CLASSES_TASK_NAME) {
  finalizedBy("generateCrds")
}
```

> **Limitation — cross-JDK version builds**
>
> The `doLast` block above runs in the Gradle daemon's JVM.
> If the project is compiled with a newer JDK (e.g. JDK 17) than the daemon (e.g. JDK 11),
> the `CustomResourceCollector` will throw `UnsupportedClassVersionError` when it tries to load
> the compiled class files. Use the [forked approach](#forked-jvm-with-toolchain) below if your
> compile JDK differs from the JDK that runs the Gradle daemon.

## Forked JVM with toolchain

When the project is compiled with a different JDK version than the Gradle daemon, CRD generation
must run in a separate JVM process. This recipe uses a `JavaExec` task with Gradle's
[Java toolchain](https://docs.gradle.org/current/userguide/toolchains.html) support and
`crd-generator-cli` as the entry point.

The `javaLauncher` is resolved from `java.toolchain.languageVersion` so it always matches the
version used for compilation without duplicating the version number. If you need an explicit
version, replace it with `JavaLanguageVersion.of(17)` (Kotlin) or `JavaLanguageVersion.of(17)`
(Groovy).

### Kotlin DSL (`build.gradle.kts`)

```kotlin
plugins {
    id("java")
}

group = "io.fabric8.crd-generator.gradle"
version = "0.0.1-SNAPSHOT"

java {
    // Compile the project with JDK 17. Gradle will download it automatically if needed.
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("io.fabric8:kubernetes-client-api:7.0.0")
}

// Dedicated configuration for the CRD generator CLI and its dependencies.
// Kept separate so it does not affect the compile/runtime classpaths.
val crdGeneratorCli: Configuration by configurations.creating

dependencies {
    crdGeneratorCli("io.fabric8:crd-generator-cli:7.0.0")
}

tasks.register<JavaExec>("generateCrds") {
    description = "Generate CRDs from compiled custom resource classes (forked JVM)"
    group = "crd"

    val sourceSet = project.sourceSets["main"]
    val outputDir = sourceSet.output.resourcesDir!!

    dependsOn(tasks.named(JvmConstants.CLASSES_TASK_NAME))

    // Run in the same JDK that compiled the project so the forked process can load the class files.
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(java.toolchain.languageVersion)
    })

    // The forked JVM classpath: crd-generator-cli + its transitive dependencies (picocli, etc.).
    classpath = crdGeneratorCli

    mainClass.set("io.fabric8.crd.generator.cli.CRDGeneratorCLI")

    doFirst {
        outputDir.mkdirs()

        val projectClasspath = sourceSet.compileClasspath.map { it.absolutePath } +
            sourceSet.output.classesDirs.map { it.absolutePath }

        args = buildList {
            add("--output-dir"); add(outputDir.absolutePath)
            // Pass the project classpath so the CLI can load custom resource classes.
            projectClasspath.forEach { add("--classpath"); add(it) }
            // Directories to scan for custom resource classes.
            sourceSet.output.classesDirs.forEach { add(it.absolutePath) }
        }
    }
}

tasks.named(JvmConstants.CLASSES_TASK_NAME) {
    finalizedBy("generateCrds")
}
```

### Groovy DSL (`build.gradle`)

```groovy
plugins {
    id 'java'
}

group = 'io.fabric8.crd-generator.gradle'
version = '0.0.1-SNAPSHOT'

java {
    // Compile the project with JDK 17. Gradle will download it automatically if needed.
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly 'io.fabric8:kubernetes-client-api:7.0.0'
}

// Dedicated configuration for the CRD generator CLI and its dependencies.
// Kept separate so it does not affect the compile/runtime classpaths.
configurations {
    crdGeneratorCli
}

dependencies {
    crdGeneratorCli 'io.fabric8:crd-generator-cli:7.0.0'
}

tasks.register('generateCrds', JavaExec) {
    description = 'Generate CRDs from compiled custom resource classes (forked JVM)'
    group = 'crd'

    def sourceSet = project.sourceSets['main']
    def outputDir = sourceSet.output.resourcesDir

    dependsOn tasks.named('classes')

    // Run in the same JDK that compiled the project so the forked process can load the class files.
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion = java.toolchain.languageVersion
    })

    // The forked JVM classpath: crd-generator-cli + its transitive dependencies (picocli, etc.).
    classpath = configurations.crdGeneratorCli

    mainClass.set('io.fabric8.crd.generator.cli.CRDGeneratorCLI')

    doFirst {
        outputDir.mkdirs()

        def projectClasspath = (sourceSet.compileClasspath + sourceSet.output.classesDirs)
            .collect { it.absolutePath }

        def cliArgs = ['--output-dir', outputDir.absolutePath]
        projectClasspath.each { cliArgs << '--classpath' << it }
        sourceSet.output.classesDirs.each { cliArgs << it.absolutePath }

        args = cliArgs
    }
}

tasks.named('classes') {
    finalizedBy 'generateCrds'
}
```
