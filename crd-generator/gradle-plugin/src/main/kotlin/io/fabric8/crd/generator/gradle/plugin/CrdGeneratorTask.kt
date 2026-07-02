package io.fabric8.crd.generator.gradle.plugin

import io.fabric8.crd.generator.collector.CustomResourceCollector
import io.fabric8.crdv2.generator.CRDGenerator
import io.fabric8.kubernetes.api.model.HasMetadata
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.FileCollection
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.net.URLClassLoader

/**
 * [DefaultTask] which generates the CRDs.
 */
abstract class CrdGeneratorTask : DefaultTask() {
    companion object {
        /**
         * File extension for class files.
         */
        const val CLASS_FILE_EXTENSION = "class"
    }

    /**
     * Input files
     */
    @get:InputFiles
    abstract val input: Property<FileCollection>

    /**
     * Classpath for the analysis
     */
    @get:Classpath
    abstract val classpath: Property<FileCollection>

    /**
     * Output directory.
     */
    @get:OutputDirectory
    abstract val output: DirectoryProperty

    /**
     * Configuration for the collection of the sources and generation of the CRDs.
     */
    @get:Nested
    abstract val configuration: CrdGeneratorConfig

    /**
     * Extension [CrdGeneratorTask], with a replaceable [CrdGeneratorTask.configuration].
     */
    internal abstract class Extension : CrdGeneratorTask() {
        override lateinit var configuration: CrdGeneratorConfig
    }

    @TaskAction
    fun generateCRDs() {
        emitCRDs(crdSources())
    }

    private fun crdSources(): List<Class<out HasMetadata>> {
        logger.debug("creating classloader for the classpath")
        val inputDirsURLs = input.get().files
        val classpathURLs = (classpath.get().files + inputDirsURLs).map { it.toURI().toURL() }
        // Kindly note: in order to load the classes correctly, we need the CRDGenerator's classloader to be the parent
        val classloader = URLClassLoader(classpathURLs.toTypedArray(), CRDGenerator::class.java.classLoader)
        logger.debug("scanning input directory for CRD classes")
        val classFiles =
            input
                .get()
                .asFileTree.files
                .filter { it.extension == CLASS_FILE_EXTENSION }
        val crCollector =
            CustomResourceCollector()
                .withParentClassLoader(classloader)
                .withCustomResourceClasses(configuration.collect.classes)
                .withForceIndex(configuration.collect.forceIndex.getOrElse(false))
                .withIncludePackages(configuration.collect.packages.include)
                .withExcludePackages(configuration.collect.packages.exclude)
                .withFilesToScan(classFiles)
        return crCollector.findCustomResourceClasses()
    }

    private fun emitCRDs(sources: List<Class<out HasMetadata>>) {
        logger.debug("creating target directory")
        val outputDir = output.get().asFile.absoluteFile
        outputDir.mkdirs()
        logger.debug("emitting CRDs using the generator")
        val generatedFiles =
            CRDGenerator()
                .withParallelGenerationEnabled(configuration.emit.parallel.getOrElse(true))
                .forCRDVersions(configuration.emit.crdVersions.toList())
                .inOutputDir(outputDir)
                .customResourceClasses(sources)
                .generate()
        logger.info("emitted $generatedFiles CRD(s)")
    }
}
