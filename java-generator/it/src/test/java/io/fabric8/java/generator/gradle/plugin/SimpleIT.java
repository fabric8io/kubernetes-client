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

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.UnexpectedBuildFailure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SimpleIT {

  @RegisterExtension
  private final ITGradleRunnerExtension gradleRunner = new ITGradleRunnerExtension();

  /**
   * Verify that the {@code crd2java} Gradle task is available
   */
  @Test
  void tasks_containsJavaGeneratorTasks() {
    // When
    final BuildResult result = gradleRunner.withITProject("simple").withArguments("tasks", "--all", "--stacktrace").build();
    // Then
    assertThat(result).extracting(BuildResult::getOutput).asString()
        .contains("Other tasks")
        .contains("crd2java - ");
  }

  /**
   * Verify that the {@gradle-simple-example} example library sources actually build.
   * The only Java class ({@see Hello.java} is creating an instance of ActiveMQArtemis which must be available in the
   * classpath after the generation task has been executed.
   */
  @Test
  void tasks_javaCompilationIsSuccessfulAfterCrd2Java() {
    // When
    gradleRunner.withITProject("simple").withArguments("clean", "crd2Java", "--stacktrace").build();
    BuildResult build = gradleRunner.withITProject("simple").withArguments("build", "--stacktrace").build();
    // Then
    assertTrue(build.getOutput().contains("SUCCESS"));
  }

  /**
   * Verify that the {@gradle-example} example library sources don't build unless the {@code crd2java} task has been
   * executed.
   * The only Java class ({@see Hello.java} is creating an instance of ActiveMQArtemis which is not available in the
   * classpath, since the generation task hasn't been executed.
   */
  @Test
  void tasks_javaCompilationFailsIfCrd2JavaNotExecuted() {
    // Then
    assertThrows(UnexpectedBuildFailure.class,
        // When
        () -> gradleRunner.withITProject("simple").withArguments("clean", "build", "--stacktrace").build());
  }
}
