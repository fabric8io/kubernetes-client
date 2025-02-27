package org.gradle.kotlin.dsl

import io.fabric8.crd.generator.gradle.plugin.CrdGeneratorConfig
import io.fabric8.crd.generator.gradle.plugin.CrdGeneratorPlugin
import io.fabric8.crd.generator.gradle.plugin.CrdGeneratorPlugin.Companion.generateCRDsTask
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.contain
import io.kotest.matchers.nulls.beNull
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.types.instanceOf
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CrdGeneratorDslTest {
    private val project = ProjectBuilder.builder().build()

    @BeforeEach
    fun applyPlugin() {
        project.plugins.apply(CrdGeneratorPlugin::class.java)
    }

    @Test
    fun generateCRDsFor() {
        // WHEN: adding generation for another source set
        project.generateCRDsFor(project.sourceSets[SourceSet.TEST_SOURCE_SET_NAME])
        // THEN: a task is added
        val newTask = project.tasks.findByName("generateCRDsTest")
        newTask shouldNot beNull()
        // AND: the aggregation task depends on the task
        project.generateCRDsTask.ownDependencies should contain(newTask)
    }

    @Test
    fun `crds extension value`() {
        // EXPECT: the source set has the extension
        project.sourceSets[SourceSet.MAIN_SOURCE_SET_NAME].crds shouldNot beNull()
        // EXPECT: the source set provider has the extension
        project.sourceSets.named(SourceSet.MAIN_SOURCE_SET_NAME).crds shouldNot beNull()
    }

    @Test
    fun `crds configuration from source set with closure`() {
        // WHEN: configuring using the action
        val action = CrdAction()
        project.sourceSets[SourceSet.MAIN_SOURCE_SET_NAME].crds(action.asClosure)
        // THEN: action is called
        action.shouldHaveBeenCalled()
    }

    @Test
    fun `crds configuration from source set with action`() {
        // WHEN: configuring using the action
        val action = CrdAction()
        project.sourceSets[SourceSet.MAIN_SOURCE_SET_NAME].crds(action)
        // THEN: action is called
        action.shouldHaveBeenCalled()
    }

    @Test
    fun `crds configuration from source provider set with closure`() {
        // WHEN: configuring using the action
        val action = CrdAction()
        project.sourceSets.named(SourceSet.MAIN_SOURCE_SET_NAME).crds(action.asClosure)
        // THEN: action is called
        action.shouldHaveBeenCalled()
    }

    @Test
    fun `crds configuration from source set provider with action`() {
        // WHEN: configuring using the action
        val action = CrdAction()
        project.sourceSets.named(SourceSet.MAIN_SOURCE_SET_NAME).crds(action)
        // THEN: action is called
        action.shouldHaveBeenCalled()
    }

    val Project.sourceSets
        get() = extensions.getByType<SourceSetContainer>()

    val Task.ownDependencies
        get() = taskDependencies.getDependencies(this)

    class CrdAction : Action<CrdGeneratorConfig> {
        private var called = false

        val asClosure: CrdGeneratorConfig.() -> Unit get() = { execute(this) }

        fun shouldHaveBeenCalled() = called.shouldBeTrue()

        override fun execute(t: CrdGeneratorConfig) {
            t shouldBe instanceOf<CrdGeneratorConfig>()
            called = true
        }
    }
}
