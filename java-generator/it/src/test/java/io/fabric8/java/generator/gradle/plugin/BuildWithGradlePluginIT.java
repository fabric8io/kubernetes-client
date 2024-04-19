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
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuildWithGradlePluginIT {
  @RegisterExtension
  final ITGradleRunnerExtension gradleRunner = new ITGradleRunnerExtension();

  /**
   * Exercise gradle plugin with various config option combinations and verify build succeeds.
   */
  static Stream<Arguments> javaCompilationIsSuccessfulAfterCrd2Java() {
    return Stream.of(
        Arguments.of("existing-java-types"),
        Arguments.of("implements-editable"));
  }

  @MethodSource
  @ParameterizedTest
  void javaCompilationIsSuccessfulAfterCrd2Java(String project) {
    // When
    gradleRunner.withITProject(project).withArguments("clean", "crd2Java", "--stacktrace").build();
    BuildResult build = gradleRunner.withITProject(project).withArguments("build", "--stacktrace").build();
    // Then
    assertTrue(build.getOutput().contains("SUCCESS"));
  }
}
