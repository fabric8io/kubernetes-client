package org.gradle.kotlin.dsl

import io.fabric8.crd.generator.gradle.plugin.CrdGeneratorConfig
import io.fabric8.crd.generator.gradle.plugin.CrdGeneratorExtension
import io.fabric8.crd.generator.gradle.plugin.CrdGeneratorPlugin
import io.fabric8.crd.generator.gradle.plugin.CrdGeneratorPlugin.Companion.generateCRDsTask
import io.fabric8.crd.generator.gradle.plugin.CrdGeneratorTask
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectProvider
import org.gradle.api.Project
import org.gradle.api.tasks.SourceSet
import org.gradle.kotlin.dsl.support.uppercaseFirstChar

/**
 * Add CRD generation for a [SourceSet].
 * @param sourceSet to add to
 * @receiver the project (necessary
 */
fun Project.generateCRDsFor(sourceSet: SourceSet): CrdGeneratorConfig {
    val nameSuffix = sourceSet.name.uppercaseFirstChar()
    val task =
        tasks.create<CrdGeneratorTask.Extension>("${CrdGeneratorPlugin.TASK_NAME}$nameSuffix") {
            val extension =
                extensions.create<CrdGeneratorExtension>("${CrdGeneratorPlugin.EXTENSION_NAME}$nameSuffix", this)
            configuration = extension
            sourceSet.extensions.add(CrdGeneratorPlugin.EXTENSION_NAME, extension)
            input.set(sourceSet.output)
            classpath.set(sourceSet.compileClasspath)
            output.set(layout.buildDirectory.dir("crds/${sourceSet.name}").get())
            group = CrdGeneratorPlugin.GROUP
            description = "Generate CRDs from the compiled classes of '${sourceSet.name}'"
            dependsOn(sourceSet.classesTaskName)
        }
    generateCRDsTask.dependsOn(task)
    return task.configuration
}

/**
 * Acquire the [CrdGeneratorConfig] for a [SourceSet].
 * @receiver [SourceSet] the CRDs are generated from
 */
val SourceSet.crds: CrdGeneratorExtension
    get() = extensions.getByType<CrdGeneratorExtension>()

/**
 * @see SourceSet.crds but for [NamedDomainObjectProvider]
 * @receiver [NamedDomainObjectProvider] for the [SourceSet] the CRDs are generated from
 */
val NamedDomainObjectProvider<SourceSet>.crds: CrdGeneratorExtension
    get() = this.get().crds

/**
 * Configure the [CrdGeneratorConfig] for a [SourceSet].
 * @receiver [SourceSet] the CRDs are generated from
 */
fun SourceSet.crds(configure: CrdGeneratorConfig.() -> Unit) {
    configure(crds)
}

/**
 * @see SourceSet.crds but for [NamedDomainObjectProvider]
 * @receiver [NamedDomainObjectProvider] for the [SourceSet] the CRDs are generated from
 */
fun NamedDomainObjectProvider<SourceSet>.crds(configure: CrdGeneratorConfig.() -> Unit) {
    configure(crds)
}

/**
 * Configure the [CrdGeneratorConfig] for a [SourceSet].
 * @receiver [SourceSet] the CRDs are generated from
 */
fun SourceSet.crds(configure: Action<CrdGeneratorConfig>) {
    crds(configure::execute)
}

/**
 * @see SourceSet.crds but for [NamedDomainObjectProvider]
 * @receiver [NamedDomainObjectProvider] for the [SourceSet] the CRDs are generated from
 */
fun NamedDomainObjectProvider<SourceSet>.crds(configure: Action<CrdGeneratorConfig>) {
    crds(configure::execute)
}
