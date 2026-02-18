package io.fabric8.crd.generator.gradle.plugin

import io.kotest.matchers.collections.containAll
import io.kotest.matchers.should
import org.gradle.kotlin.dsl.create
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File

class CrdGeneratorTaskTest {
    companion object {
        private val testBuildPath = File("build/classes/kotlin/integrationTest").normalize().absolutePath
    }

    private val project = ProjectBuilder.builder().build()

    @TempDir
    protected lateinit var tmpDir: File

    @Test
    fun `should generate the custom resources`() {
        // WHEN: creating a task
        val task =
            project.tasks.create<CrdGeneratorTask>("test") {
                input.set(project.layout.files(testBuildPath))
                output.set(project.layout.dir(project.provider { tmpDir.absoluteFile }))
                classpath.set(project.layout.files(tmpDir.absolutePath))
            }
        // AND: running it
        task.actions.forEach { it.execute(task) }
        // THEN: the CRDs are generated
        tmpDir.list()?.toList()!! should containAll("greetings.example.com-v1.yml")
    }
}
