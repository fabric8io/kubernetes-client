/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.java.generator.gradle.plugin;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.TaskOutcome;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigurationCacheIT {
  @RegisterExtension
  final ITGradleRunnerExtension gradleRunner = new ITGradleRunnerExtension();

  @Test
  void crd2JavaStoresAndReusesConfigurationCache() {
    // TestKit's debug agent is itself CC-incompatible, so disable it to test the plugin in isolation.
    gradleRunner.withoutDebug();

    BuildResult firstResult = gradleRunner.withITProject("simple")
        .withArguments("clean", "crd2java", "--configuration-cache")
        .build();
    assertTrue(firstResult.getOutput().contains("BUILD SUCCESSFUL"),
        "first crd2java build failed:\n" + firstResult.getOutput());
    assertEquals(TaskOutcome.SUCCESS, firstResult.task(":crd2java").getOutcome(),
        "crd2java did not execute on the first run:\n" + firstResult.getOutput());
    assertFalse(firstResult.getOutput().contains("Configuration cache entry discarded"),
        "configuration cache entry was discarded on first run:\n" + firstResult.getOutput());
    assertFalse(firstResult.getOutput().contains("cannot serialize"),
        "configuration cache serialization problem on first run:\n" + firstResult.getOutput());

    BuildResult secondResult = gradleRunner.withITProject("simple")
        .withArguments("clean", "crd2java", "--configuration-cache")
        .build();
    assertTrue(secondResult.getOutput().contains("Reusing configuration cache"),
        "configuration cache entry was not reused on second run:\n" + secondResult.getOutput());
    assertEquals(TaskOutcome.SUCCESS, secondResult.task(":crd2java").getOutcome(),
        "crd2java did not execute on the cache-reuse run:\n" + secondResult.getOutput());

    File projectDir = new File(System.getProperty(ITGradleRunnerExtension.GRADLE_PROJECT_PROPERTY_IT_DIR, ""))
        .toPath().resolve("src").resolve("it").resolve("plugin").resolve("gradle").resolve("simple").toFile();
    File generatedSources = projectDir.toPath().resolve("build").resolve("generated").resolve("sources").toFile();
    assertTrue(containsJavaFile(generatedSources),
        "no generated Java source found under " + generatedSources + " after the reuse run");
  }

  @Test
  void fullBuildStoresAndReusesConfigurationCache() {
    gradleRunner.withoutDebug();

    gradleRunner.withITProject("simple").withArguments("clean", "crd2Java").build();

    BuildResult firstResult = gradleRunner.withITProject("simple")
        .withArguments("build", "--configuration-cache")
        .build();
    assertTrue(firstResult.getOutput().contains("BUILD SUCCESSFUL"),
        "first build failed:\n" + firstResult.getOutput());
    assertFalse(firstResult.getOutput().contains("implicit dependency"),
        "crd2java/compileJava implicit dependency detected:\n" + firstResult.getOutput());
    assertFalse(firstResult.getOutput().contains("Configuration cache entry discarded"),
        "configuration cache entry was discarded on first build:\n" + firstResult.getOutput());

    BuildResult secondResult = gradleRunner.withITProject("simple")
        .withArguments("build", "--configuration-cache")
        .build();
    assertTrue(secondResult.getOutput().contains("Reusing configuration cache"),
        "configuration cache entry was not reused on second build:\n" + secondResult.getOutput());
    assertTrue(secondResult.getOutput().contains("BUILD SUCCESSFUL"),
        "reuse build failed:\n" + secondResult.getOutput());
    assertFalse(secondResult.getOutput().contains("implicit dependency"),
        "crd2java/compileJava implicit dependency detected on reuse:\n" + secondResult.getOutput());
  }

  @Test
  void crd2JavaReportsNoTaskValidationProblems() {
    gradleRunner.withoutDebug();
    BuildResult result = gradleRunner.withITProject("simple")
        .withArguments("clean", "crd2Java", "--warning-mode=all")
        .build();
    assertTrue(result.getOutput().contains("BUILD SUCCESSFUL"),
        "crd2java build failed:\n" + result.getOutput());
    String output = result.getOutput();
    assertFalse(output.contains("has been disabled for"),
        "execution optimizations disabled for crd2java:\n" + output);
    assertFalse(output.contains("without normalization"),
        "crd2java input missing path normalization:\n" + output);
    assertFalse(output.contains("implicit dependency"),
        "crd2java has an implicit dependency:\n" + output);
  }

  private static boolean containsJavaFile(File dir) {
    try (Stream<Path> walk = Files.walk(dir.toPath())) {
      return walk.anyMatch(p -> p.getFileName().toString().endsWith(".java"));
    } catch (IOException e) {
      return false;
    }
  }
}
