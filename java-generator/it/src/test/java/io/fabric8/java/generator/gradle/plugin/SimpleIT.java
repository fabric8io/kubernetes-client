/**
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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.gradle.testkit.runner.BuildResult;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleIT {

  @RegisterExtension
  private final ITGradleRunnerExtension gradleRunner = new ITGradleRunnerExtension();

  @AfterAll
  public static void cleanup() throws IOException {
    FileUtils.deleteDirectory(new File("src/it/plugin/gradle/simple/tmp/"));
    FileUtils.deleteDirectory(new File("src/it/plugin/gradle/simple/.gradle/"));
  }

  @Test
  void tasks_containsJavaGeneratorTasks() {
    // When
    final BuildResult result = gradleRunner.withITProject("simple").withArguments("tasks", "--all", "--stacktrace").build();
    // Then
    assertThat(result).extracting(BuildResult::getOutput).asString()
        .contains("Other tasks")
        .contains("crd2java - ");
  }

  @Test
  void tasks_crd2JavaApproval() throws IOException {
    // When
    final BuildResult result = gradleRunner.withITProject("simple").withArguments("crd2java", "--stacktrace").build();
    // Then
    try (
        InputStream generated = new FileInputStream(
            "src/it/plugin/gradle/simple/tmp/generated/io/amq/broker/v1beta1/ActiveMQArtemisSpec.java");
        InputStream expected = new FileInputStream("src/it/plugin/gradle/simple/expected/ActiveMQArtemisSpec.expected")) {
      assertTrue(IOUtils.contentEquals(generated, expected));
    }
  }
}
