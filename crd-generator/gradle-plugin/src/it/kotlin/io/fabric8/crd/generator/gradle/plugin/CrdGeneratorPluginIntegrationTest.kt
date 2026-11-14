package io.fabric8.crd.generator.gradle.plugin

import io.kotest.matchers.collections.containAll
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test

class CrdGeneratorPluginIntegrationTest : GradlePluginIntegrationTest() {
    override val projectFiles =
        mapOf(
            "settings.gradle.kts" to "/",
            "gradle.properties" to "/",
            "src/integrationTest/kotlin/io/fabric8/crd/generator/example/GreetingResource.kt" to
                    "/src/main/kotlin/io/fabric8/crd/generator/example",
            "src/functionalTest/resources/base/build.gradle.kts" to
                    "/",
        )

    @Test
    fun `it should compile and generate from sources`() {
        // WHEN: running task
        val result =
            GradleRunner
                .create()
                .withProjectDir(projectDir)
                .withArguments("generateCRDs")
                .withPluginClasspath()
                .build()
        // THEN: kotlin sources have been build
        result.tasks.find { it.path == ":compileKotlin" }?.outcome shouldBe TaskOutcome.SUCCESS
        // AND: main crds have been generated
        result.tasks.find { it.path == ":generateCRDsMain" }?.outcome shouldBe TaskOutcome.SUCCESS
        // AND: generated file exists in the correct directory
        buildDirOf("crds/main").list()!!.toList() should containAll("greetings.example.com-v1.yml")
    }
}
