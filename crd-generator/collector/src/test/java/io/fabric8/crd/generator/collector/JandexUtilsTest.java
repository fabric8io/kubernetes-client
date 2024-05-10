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

import io.fabric8.crd.generator.collector.examples.MyCustomResource;
import io.fabric8.crd.generator.collector.examples.MyOtherCustomResource;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JandexUtilsTest {

  @Test
  void directoryWithIndex_whenFindIndex(@TempDir File tempDir) throws IOException {
    List<String> expectedClasses = TestUtils.prepareDirectoryWithClassesAndIndex(tempDir);
    Optional<Index> index = JandexUtils.findIndex(tempDir);
    assertTrue(index.isPresent());
    expectedClasses.forEach(s -> assertNotNull(index.get().getClassByName(s)));
  }

  @Test
  void directoryWithoutIndex_whenFindIndex(@TempDir File tempDir) {
    Optional<Index> index = JandexUtils.findIndex(tempDir);
    assertFalse(index.isPresent());
  }

  @Test
  void jarFileWithIndex_whenFindIndex(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    List<String> expectedClasses = TestUtils.prepareJarFileWithClassesAndIndex(jarFile);
    Optional<Index> index = JandexUtils.findIndex(jarFile);
    assertTrue(index.isPresent());
    expectedClasses.forEach(s -> assertNotNull(index.get().getClassByName(s)));
  }

  @Test
  void jarFileWithoutIndex_whenFindIndex(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    TestUtils.prepareJarFileWithClasses(jarFile);
    Optional<Index> index = JandexUtils.findIndex(jarFile);
    assertFalse(index.isPresent());
  }

  @Test
  void jarFileWithInvalidIndex_whenFindIndex(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    TestUtils.prepareJarFileWithInvalidIndex(jarFile);
    assertThrows(JandexException.class, () -> JandexUtils.findIndex(jarFile));
  }

  @Test
  void directoryWithIndex_whenCreateIndex(@TempDir File tempDir) throws IOException {
    List<String> expectedClasses = TestUtils.prepareDirectoryWithClassesAndIndex(tempDir);
    IndexView index = JandexUtils.createIndex(Collections.emptyList(),
        Collections.singletonList(tempDir), false);
    assertNotNull(index);
    expectedClasses.forEach(s -> assertNotNull(index.getClassByName(s)));
  }

  @Test
  void directoryWithIndexAndForce_whenCreateIndex(@TempDir File tempDir) throws IOException {
    List<String> expectedClasses = TestUtils.prepareDirectoryWithClassesAndIndex(tempDir);
    IndexView index = JandexUtils.createIndex(Collections.emptyList(),
        Collections.singletonList(tempDir), true);
    assertNotNull(index);
    expectedClasses.forEach(s -> assertNotNull(index.getClassByName(s)));
  }

  @Test
  void directoryWithoutIndex_whenCreateIndex(@TempDir File tempDir) throws IOException {
    List<String> expectedClasses = TestUtils.prepareDirectoryWithClasses(tempDir);
    IndexView index = JandexUtils.createIndex(Collections.emptyList(),
        Collections.singletonList(tempDir), false);
    assertNotNull(index);
    expectedClasses.forEach(s -> assertNotNull(index.getClassByName(s)));
  }

  @Test
  void indicesOnly_whenCreateIndex() throws IOException {
    IndexView index = JandexUtils.createIndex(
        Arrays.asList(Index.of(MyCustomResource.class), Index.of(MyOtherCustomResource.class)), Collections.emptyList(), false);
    assertNotNull(index);
    assertNotNull(index.getClassByName(MyCustomResource.class));
    assertNotNull(index.getClassByName(MyOtherCustomResource.class));
  }

}
