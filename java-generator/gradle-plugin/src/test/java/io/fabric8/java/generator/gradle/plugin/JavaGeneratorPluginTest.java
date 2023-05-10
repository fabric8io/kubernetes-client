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

import io.fabric8.java.generator.gradle.plugin.task.JavaGeneratorCrd2JavaTask;
import org.gradle.api.Project;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

class JavaGeneratorPluginTest {
  private Project project;

  @Test
  void apply_withValidProject_shouldCreateExtensionAndRegisterTask() {
    project = mock(Project.class, RETURNS_DEEP_STUBS);
    // When
    new JavaGeneratorPlugin().apply(project);
    // Then
    verify(project.getExtensions(), times(1))
        .create(JavaGeneratorPluginExtension.NAME, JavaGeneratorPluginExtension.class, project);
    verify(project.getTasks(), times(1))
        .register(JavaGeneratorCrd2JavaTask.NAME, JavaGeneratorCrd2JavaTask.class, JavaGeneratorPluginExtension.class);
  }
}
