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
package io.fabric8.java.generator.gradle.plugin.task;

import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputDirectory;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link JavaGeneratorCrd2JavaTask} to verify that the task has proper
 * Gradle input/output annotations for incremental build support.
 */
class JavaGeneratorCrd2JavaTaskTest {

  @Test
  void getSource_shouldHaveInputFilesAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getSource");
    InputFiles annotation = method.getAnnotation(InputFiles.class);
    assertNotNull(annotation, "getSource() should have @InputFiles annotation");

    Optional optional = method.getAnnotation(Optional.class);
    assertNotNull(optional, "getSource() should have @Optional annotation");
  }

  @Test
  void getUrls_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getUrls");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getUrls() should have @Input annotation");

    Optional optional = method.getAnnotation(Optional.class);
    assertNotNull(optional, "getUrls() should have @Optional annotation");
  }

  @Test
  void getTarget_shouldHaveOutputDirectoryAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getTarget");
    OutputDirectory annotation = method.getAnnotation(OutputDirectory.class);
    assertNotNull(annotation, "getTarget() should have @OutputDirectory annotation");
  }

  @Test
  void getDownloadTarget_shouldHaveOutputDirectoryAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getDownloadTarget");
    OutputDirectory annotation = method.getAnnotation(OutputDirectory.class);
    assertNotNull(annotation, "getDownloadTarget() should have @OutputDirectory annotation");
  }

  @Test
  void getEnumUppercase_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getEnumUppercase");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getEnumUppercase() should have @Input annotation");
  }

  @Test
  void getExtraAnnotations_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getExtraAnnotations");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getExtraAnnotations() should have @Input annotation");
  }

  @Test
  void getGeneratedAnnotations_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getGeneratedAnnotations");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getGeneratedAnnotations() should have @Input annotation");
  }

  @Test
  void getAlwaysPreserveUnknown_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getAlwaysPreserveUnknown");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getAlwaysPreserveUnknown() should have @Input annotation");
  }

  @Test
  void getPackageOverrides_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getPackageOverrides");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getPackageOverrides() should have @Input annotation");
  }

  @Test
  void getFilesSuffixes_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getFilesSuffixes");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getFilesSuffixes() should have @Input annotation");
  }

  @Test
  void getSerializationDatetimeFormat_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getSerializationDatetimeFormat");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getSerializationDatetimeFormat() should have @Input annotation");
  }

  @Test
  void getDeserializationDatetimeFormat_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getDeserializationDatetimeFormat");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getDeserializationDatetimeFormat() should have @Input annotation");
  }

  @Test
  void getExistingJavaTypes_shouldHaveInputAnnotation() throws NoSuchMethodException {
    Method method = JavaGeneratorCrd2JavaTask.class.getMethod("getExistingJavaTypes");
    Input annotation = method.getAnnotation(Input.class);
    assertNotNull(annotation, "getExistingJavaTypes() should have @Input annotation");
  }

  @Test
  void taskName_shouldBeCrd2java() {
    assertTrue(JavaGeneratorCrd2JavaTask.NAME.equals("crd2java"),
        "Task name should be 'crd2java'");
  }
}
