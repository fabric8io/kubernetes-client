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
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JandexIndexerTest {

  @Test
  void checkClassFile() {
    File customResourceClassFile1 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyCustomResource.class");

    JandexIndexer indexer = new JandexIndexer();
    indexer.withFile(customResourceClassFile1);
    Index index = indexer.createIndex();
    assertEquals(1, index.getKnownClasses().size());
  }

  @Test
  void checkDirectoryWithNoClassFiles(@TempDir File tempDir) {
    JandexIndexer indexer = new JandexIndexer();
    indexer.withFile(tempDir);
    Index index = indexer.createIndex();
    assertEquals(0, index.getKnownClasses().size());
  }

  @Test
  void checkDirectoryWithClassFiles(@TempDir File tempDir) throws IOException {
    List<String> expectedClasses = TestUtils.prepareDirectoryWithClasses(tempDir);
    JandexIndexer indexer = new JandexIndexer();
    indexer.withFile(tempDir);
    Index index = indexer.createIndex();
    expectedClasses.forEach(s -> assertNotNull(index.getClassByName(s)));
  }

  @Test
  void checkJarFileWithNoClassFiles(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    TestUtils.prepareEmptyJarFile(jarFile);
    JandexIndexer indexer = new JandexIndexer();
    indexer.withFile(jarFile);
    Index index = indexer.createIndex();
    assertEquals(0, index.getKnownClasses().size());
  }

  @Test
  void checkJarFileWithClassFiles(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    List<String> expectedClasses = TestUtils.prepareJarFileWithClasses(jarFile);
    JandexIndexer indexer = new JandexIndexer();
    indexer.withFile(jarFile);
    Index index = indexer.createIndex();
    expectedClasses.forEach(s -> assertNotNull(index.getClassByName(s)));
  }

  @Test
  void checkNullsafe() {
    JandexIndexer indexer = new JandexIndexer();
    indexer.withFile((File[]) null);
    indexer.withFile((File) null);
    indexer.withFiles(null);
    Index index = indexer.createIndex();
    assertNotNull(index);
  }

  @Test
  void checkJarFileEntriesLimit(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    TestUtils.prepareJarFileWithClasses(jarFile);
    JandexIndexer indexer = new JandexIndexer();
    indexer.withMaxJarEntries(1);
    indexer.withFile(jarFile);
    assertThrows(CustomResourceCollectorException.class, indexer::createIndex);
  }

  @Test
  void checkJarFileBytesReadLimit(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    TestUtils.prepareJarFileWithClasses(jarFile);
    JandexIndexer indexer = new JandexIndexer();
    indexer.withMaxBytesReadFromJar(10);
    indexer.withFile(jarFile);
    assertThrows(CustomResourceCollectorException.class, indexer::createIndex);
  }

  @Test
  void checkClassFileBytesReadLimit(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "my-dependency.jar");
    TestUtils.prepareJarFileWithClasses(jarFile);
    JandexIndexer indexer = new JandexIndexer();
    indexer.withMaxClassFileSize(10);
    indexer.withFile(jarFile);
    assertThrows(CustomResourceCollectorException.class, indexer::createIndex);
  }

  @Test
  void checkIllegalArguments() {
    JandexIndexer indexer = new JandexIndexer();
    assertThrows(IllegalArgumentException.class, () -> indexer.withMaxClassFileSize(-1));
    assertThrows(IllegalArgumentException.class, () -> indexer.withMaxBytesReadFromJar(-1));
    assertThrows(IllegalArgumentException.class, () -> indexer.withMaxJarEntries(-1));
  }

  @Nested
  class BoundedInputStreamTest {
    @Test
    void checkWithinLimit() throws IOException {
      String testString = "test";
      byte[] testStringAsByteArray = testString.getBytes(StandardCharsets.UTF_8);
      InputStream in = new ByteArrayInputStream(testStringAsByteArray);
      JandexIndexer.BoundedInputStream boundedInputStream = new JandexIndexer.BoundedInputStream(in, 10);
      int totalBytesRead = 0;
      while (boundedInputStream.read() != -1) {
        totalBytesRead++;
        assertTrue(totalBytesRead <= testStringAsByteArray.length);
      }
      assertEquals(testStringAsByteArray.length, totalBytesRead);
    }

    @Test
    void checkExceedLimit() {
      String testString = "testtesttest";
      byte[] testStringAsByteArray = testString.getBytes(StandardCharsets.UTF_8);
      InputStream in = new ByteArrayInputStream(testStringAsByteArray);
      JandexIndexer.BoundedInputStream boundedInputStream = new JandexIndexer.BoundedInputStream(in, 10);
      AtomicInteger totalBytesRead = new AtomicInteger();
      assertThrows(IOException.class, () -> {
        while (boundedInputStream.read() != -1) {
          totalBytesRead.getAndIncrement();
          assertTrue(totalBytesRead.get() <= 10);
        }
      });
      assertEquals(10, totalBytesRead.get());
    }
  }
}
