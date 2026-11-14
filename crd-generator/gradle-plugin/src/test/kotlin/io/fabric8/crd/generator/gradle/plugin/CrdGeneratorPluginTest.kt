package io.fabric8.crd.generator.gradle.plugin

import io.fabric8.crd.generator.gradle.plugin.CrdGeneratorPlugin.Companion.generateCRDsTask
import io.kotest.matchers.nulls.beNull
import io.kotest.matchers.shouldNot
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.crds
import org.gradle.kotlin.dsl.getByType
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class CrdGeneratorPluginTest {
    private val project = ProjectBuilder.builder().build()

    @Test
    fun `should add task to main source set`() {
        // WHEN: applying plugin
        project.plugins.apply(CrdGeneratorPlugin::class.java)
        // THEN: extension object is present
        val extObj =
            project.extensions
                .getByType<SourceSetContainer>()
                .named(SourceSet.MAIN_SOURCE_SET_NAME)
                .crds
        extObj shouldNot beNull()
        // AND: generator task is present
        extObj.generatorTask shouldNot beNull()
        // AND: aggregation task is present
        project.generateCRDsTask shouldNot beNull()
    }
}
