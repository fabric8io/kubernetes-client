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
package io.fabric8.crd.generator.collector;

import io.fabric8.kubernetes.api.model.HasMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomResourceCollectorE2ETest {

  @Test
  void scanClassDirWithCRs_thenFindAll(@TempDir File tempDir) throws IOException {
    List<String> expectedClasses = TestUtils.prepareDirectoryWithClasses(tempDir);
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToScan(tempDir);
    List<Class<? extends HasMetadata>> classes = collector.findCustomResourceClasses();
    assertEquals(expectedClasses.size(), classes.size());
    classes.forEach(aClass -> assertTrue(expectedClasses.contains(aClass.getName())));
  }

  @Test
  @DisplayName("Classes directories which were never created, like build/classes/java/main of a Kotlin-only Gradle project, don't fail the scan")
  void scanClassDirsWithMissingDir_thenFindAllInExistingDir(@TempDir File tempDir) throws IOException {
    File javaClassesDir = new File(tempDir, "java/main");
    File kotlinClassesDir = new File(tempDir, "kotlin/main");
    List<String> expectedClasses = TestUtils.prepareDirectoryWithClasses(kotlinClassesDir);
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFilesToScan(Arrays.asList(javaClassesDir, kotlinClassesDir));
    List<Class<? extends HasMetadata>> classes = collector.findCustomResourceClasses();
    assertEquals(expectedClasses.size(), classes.size());
    classes.forEach(aClass -> assertTrue(expectedClasses.contains(aClass.getName())));
  }

  @Test
  void scanJarWithCRs_thenFindAll(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "test.jar");
    List<String> expectedClasses = TestUtils.prepareJarFileWithClasses(jarFile);
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToScan(jarFile);
    List<Class<? extends HasMetadata>> classes = collector.findCustomResourceClasses();
    assertEquals(expectedClasses.size(), classes.size());
    classes.forEach(aClass -> assertTrue(expectedClasses.contains(aClass.getName())));
  }

}
