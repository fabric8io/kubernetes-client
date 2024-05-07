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
import io.fabric8.crdv2.generator.CustomResourceInfo;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexView;
import org.jboss.jandex.IndexWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomResourceCollectorTest {

  // must be adjusted if new test custom resources are added
  private static final int CR_COUNT_ALL = 7;
  private static final int CR_COUNT_V1_PKG = 2;
  private static final int CR_COUNT_V1_VERSION = 2;
  private static final int CR_COUNT_OTHER_GROUP = 1;

  @Test
  void explicitClass_thenNoScanAndFind() {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(new File("target/classes"));
    collector.withCustomResourceClass(MyCustomResource.class.getName());
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(1, infos.length);
  }

  @Test
  void scanClassDirWithNoCRs_thenFindZero() {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(new File("target/classes"));
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(0, infos.length);
  }

  @Test
  void scanClassDirWithCRs_thenFindAll() {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(new File("target/test-classes"));
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(CR_COUNT_ALL, infos.length);
  }

  @Test
  void scanClassDirWithCRsAndFilterByPackageIncludes_thenFind() {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(new File("target/test-classes"));
    collector.withIncludePackages(
        Collections.singletonList("io.fabric8.crd.generator.collector.examples.v1"));
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(CR_COUNT_V1_PKG, infos.length);
  }

  @Test
  void scanClassDirWithCRsAndFilterByPackageExcludes_thenFind() {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(new File("target/test-classes"));
    collector.withExcludePackages(
        Collections.singletonList("io.fabric8.crd.generator.collector.examples.v1"));
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(CR_COUNT_ALL - CR_COUNT_V1_PKG, infos.length);
  }

  @Test
  void scanClassDirWithCRsAndFilterByVersionIncludes_thenFind() {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(new File("target/test-classes"));
    collector.withIncludeVersions(Collections.singletonList("v1"));
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(CR_COUNT_V1_VERSION, infos.length);
  }

  @Test
  void scanClassDirWithCRsAndFilterByVersionExcludes_thenFind() {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(new File("target/test-classes"));
    collector.withExcludeVersions(Collections.singletonList("v1"));
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(CR_COUNT_ALL - CR_COUNT_V1_VERSION, infos.length);
  }

  @Test
  void scanClassDirWithCRsAndFilterByGroupIncludes_thenFind() {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(new File("target/test-classes"));
    collector.withIncludeGroups(Collections.singletonList("other.samples.fabric8.io"));
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(CR_COUNT_OTHER_GROUP, infos.length);
  }

  @Test
  void scanClassDirWithCRsAndFilterByGroupExcludes_thenFind() {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(new File("target/test-classes"));
    collector.withExcludeGroups(Collections.singletonList("other.samples.fabric8.io"));
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(CR_COUNT_ALL - CR_COUNT_OTHER_GROUP, infos.length);
  }

  @Test
  void indexWithCR_thenFindCRFromIndex() throws IOException {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withIndex(Index.of(MyCustomResource.class));
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(1, infos.length);
  }

  @Test
  void classDirWithCRsAndIndex_thenFindOnlyCRFromIndex(@TempDir File tempDir) throws IOException {
    File sourceCustomResourceClassFile1 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
    File targetCustomResourceClassFile1 = new File(tempDir.getAbsolutePath(),
        "io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
    File sourceCustomResourceClassFile2 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyOtherCustomResource.class");
    File targetCustomResourceClassFile2 = new File(tempDir.getAbsolutePath(),
        "io/fabric8/crd/generator/collector/examples/MyOtherCustomResource.class");

    targetCustomResourceClassFile1.getParentFile().mkdirs();
    Files.copy(sourceCustomResourceClassFile1.toPath(), targetCustomResourceClassFile1.toPath());
    Files.copy(sourceCustomResourceClassFile2.toPath(), targetCustomResourceClassFile2.toPath());

    File jandexIndexFile = new File(tempDir.getAbsolutePath(), "META-INF/jandex.idx");
    jandexIndexFile.getParentFile().mkdirs();
    try (OutputStream out = Files.newOutputStream(jandexIndexFile.toPath())) {
      // index contains only one custom resource
      new IndexWriter(out).write(Index.of(sourceCustomResourceClassFile1));
    }
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(tempDir);

    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(1, infos.length);
  }

  @Test
  void classDirWithCRsAndIndexAndForceScan_thenFindAll(@TempDir File tempDir) throws IOException {
    TestUtils.prepareDirectoryWithClassesAndIncompleteIndex(tempDir);
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToIndex(tempDir);
    collector.withForceIndex(true);

    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(2, infos.length);
  }

  @Test
  void provideIndexWithCRAndForceScan_thenFindOnlyCRFromIndex() throws IOException {
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withIndex(Index.of(MyCustomResource.class));
    collector.withForceIndex(true);
    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(1, infos.length);
  }

  @Test
  void checkNullsafe() {
    CustomResourceCollector collector = new CustomResourceCollector();

    collector.withParentClassLoader(null);
    collector.withClasspathElement((String) null);
    collector.withClasspathElements(null);

    collector.withCustomResourceClass((String[]) null);
    collector.withCustomResourceClass((String) null);
    collector.withCustomResourceClasses(null);

    collector.withIndex((IndexView[]) null);
    collector.withIndex((IndexView) null);
    collector.withIndices(null);

    collector.withFileToIndex((File[]) null);
    collector.withFileToIndex((File) null);
    collector.withFilesToIndex(null);

    collector.withIncludePackages(null);
    collector.withExcludePackages(null);
    collector.withIncludeGroups(null);
    collector.withExcludeGroups(null);
    collector.withIncludeVersions(null);
    collector.withExcludeVersions(null);

    CustomResourceInfo[] infos = collector.findCustomResources();
    assertEquals(0, infos.length);
  }

}
