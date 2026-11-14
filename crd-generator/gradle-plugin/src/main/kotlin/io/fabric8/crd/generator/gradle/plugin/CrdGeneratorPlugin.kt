package io.fabric8.crd.generator.gradle.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.generateCRDsFor
import org.gradle.kotlin.dsl.getByType

/**
 * [Plugin] which generates CRDs from the compiled files of the [SourceSet.MAIN_SOURCE_SET_NAME].
 */
class CrdGeneratorPlugin : Plugin<Project> {
    companion object {
        /**
         * Name of task to be created.
         */
        const val TASK_NAME = "generateCRDs"

        /**
         * Group of the task
         */
        const val GROUP = "build"

        /**
         * Name of the extension object.
         */
        const val EXTENSION_NAME = "crds"

        /**
         * Aggregation task for generating all CRDs
         */
        val Project.generateCRDsTask: Task get() = tasks.getByName(TASK_NAME)
    }

    override fun apply(target: Project) {
        // Apply the java plugin, in order to have the main source set
        target.plugins.apply(JavaPlugin::class.java)
        // Create an aggregation task
        target.tasks.create<DefaultTask>(TASK_NAME) {
            group = GROUP
            description = "generates CRDs from all source sets registered"
        }
        target.generateCRDsFor(
            target.extensions.getByType<SourceSetContainer>().getByName(SourceSet.MAIN_SOURCE_SET_NAME),
        )
    }
}
