package io.fabric8.crd.generator.gradle.plugin

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.io.TempDir
import java.io.File

abstract class GradlePluginIntegrationTest {
    @TempDir
    lateinit var projectDir: File

    protected abstract val projectFiles: Map<String, String>

    protected val buildDir by lazy { File(projectDir, "build") }

    fun buildDirOf(subDir: String) = File(buildDir, subDir)

    private fun File.copyToProjectDir(targetDir: String) {
        File(projectDir, targetDir.trimStart('/') + name).let { targetFile ->
            if (!exists()) {
                throw IllegalArgumentException("source '$absolutePath' does not exist")
            }
            targetFile.parentFile.mkdirs()
            if (isDirectory) {
                copyRecursively(targetFile)
            } else {
                copyTo(targetFile)
            }
        }
    }

    @BeforeEach
    fun prepareProjectDir() {
        projectFiles.forEach { File(it.key).copyToProjectDir(it.value) }
    }
}
