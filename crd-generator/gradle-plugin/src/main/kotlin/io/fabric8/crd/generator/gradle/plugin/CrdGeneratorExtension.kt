package io.fabric8.crd.generator.gradle.plugin

import org.gradle.api.tasks.Internal

/**
 * Extension object decorating [CrdGeneratorConfig].
 */
abstract class CrdGeneratorExtension(
    @Internal val generatorTask: CrdGeneratorTask,
) : CrdGeneratorConfig()
