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
import org.gradle.api.tasks.LocalState;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JavaGeneratorCrd2JavaTaskTest {

  @Test
  void taskProperties_shouldDeclareIncrementalBuildMetadata() throws NoSuchMethodException {
    assertHasAnnotations(method("getSourceFiles"), Optional.class, InputFiles.class, PathSensitive.class);
    assertEquals(PathSensitivity.RELATIVE, method("getSourceFiles").getAnnotation(PathSensitive.class).value());

    assertHasAnnotations(method("getUrls"), Input.class);
    assertHasAnnotations(method("getDownloadTarget"), LocalState.class);
    assertHasAnnotations(method("getTarget"), OutputDirectory.class);
    assertHasAnnotations(method("getEnumUppercase"), Input.class);
    assertHasAnnotations(method("getExtraAnnotations"), Input.class);
    assertHasAnnotations(method("getGeneratedAnnotations"), Input.class);
    assertHasAnnotations(method("getAlwaysPreserveUnknown"), Input.class);
    assertHasAnnotations(method("getFilesSuffixes"), Input.class);
    assertHasAnnotations(method("getSerializationDatetimeFormat"), Input.class);
    assertHasAnnotations(method("getDeserializationDatetimeFormat"), Input.class);
    assertHasAnnotations(method("getPackageOverrides"), Input.class);
    assertHasAnnotations(method("getExistingJavaTypes"), Input.class);
  }

  private static Method method(String name) throws NoSuchMethodException {
    return JavaGeneratorCrd2JavaTask.class.getMethod(name);
  }

  @SafeVarargs
  private static void assertHasAnnotations(Method method, Class<? extends Annotation>... annotationTypes) {
    for (Class<? extends Annotation> annotationType : annotationTypes) {
      assertNotNull(method.getAnnotation(annotationType),
          () -> method.getName() + " should be annotated with @" + annotationType.getSimpleName());
    }
  }
}
