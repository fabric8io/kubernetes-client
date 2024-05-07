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

import org.jboss.jandex.Index;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JandexUtilsTest {

  @Test
  void checkDirectoryWithIndex(@TempDir File tempDir) throws IOException {
    List<String> expectedClasses = TestUtils.prepareDirectoryWithClassesAndIndex(tempDir);
    Optional<Index> index = JandexUtils.findExistingIndex(tempDir);
    assertTrue(index.isPresent());
    expectedClasses.forEach(s -> assertNotNull(index.get().getClassByName(s)));
  }

  @Test
  void checkDirectoryWithoutIndex(@TempDir File tempDir) {
    Optional<Index> index = JandexUtils.findExistingIndex(tempDir);
    assertFalse(index.isPresent());
  }

  @Test
  void checkJarFileWithIndex(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    List<String> expectedClasses = TestUtils.prepareJarFileWithClassesAndIndex(jarFile);
    Optional<Index> index = JandexUtils.findExistingIndex(jarFile);
    assertTrue(index.isPresent());
    expectedClasses.forEach(s -> assertNotNull(index.get().getClassByName(s)));
  }

  @Test
  void checkJarFileWithoutIndex(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    TestUtils.prepareJarFileWithClasses(jarFile);
    Optional<Index> index = JandexUtils.findExistingIndex(jarFile);
    assertFalse(index.isPresent());
  }

  @Test
  void checkJarFileWithInvalidIndex(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    TestUtils.prepareJarFileWithInvalidIndex(jarFile);
    assertThrows(CustomResourceCollectorException.class, () -> JandexUtils.findExistingIndex(jarFile));
  }

}
