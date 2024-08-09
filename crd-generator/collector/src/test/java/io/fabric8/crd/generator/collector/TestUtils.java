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
import org.jboss.jandex.IndexWriter;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

class TestUtils {
  private TestUtils() {
  }

  static List<String> prepareDirectoryWithClasses(File targetDir) throws IOException {
    File sourceCustomResourceClassFile1 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
    File targetCustomResourceClassFile1 = new File(targetDir.getAbsolutePath(),
        "io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
    File sourceCustomResourceClassFile2 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyOtherCustomResource.class");
    File targetCustomResourceClassFile2 = new File(targetDir.getAbsolutePath(),
        "io/fabric8/crd/generator/collector/examples/MyOtherCustomResource.class");

    targetCustomResourceClassFile1.getParentFile().mkdirs();
    targetCustomResourceClassFile2.getParentFile().mkdirs();
    Files.copy(sourceCustomResourceClassFile1.toPath(), targetCustomResourceClassFile1.toPath());
    Files.copy(sourceCustomResourceClassFile2.toPath(), targetCustomResourceClassFile2.toPath());

    return Arrays.asList(MyCustomResource.class.getName(), MyOtherCustomResource.class.getName());
  }

  static List<String> prepareDirectoryWithClassesAndIndex(File targetDir) throws IOException {
    List<String> expectedClasses = prepareDirectoryWithClasses(targetDir);
    File sourceCustomResourceClassFile1 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
    File sourceCustomResourceClassFile2 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyOtherCustomResource.class");
    File jandexIndexFile = new File(targetDir.getAbsolutePath(), "META-INF/jandex.idx");
    jandexIndexFile.getParentFile().mkdirs();
    try (OutputStream out = Files.newOutputStream(jandexIndexFile.toPath())) {
      new IndexWriter(out).write(Index.of(sourceCustomResourceClassFile1, sourceCustomResourceClassFile2));
    }
    return expectedClasses;
  }

  static List<String> prepareDirectoryWithClassesAndIncompleteIndex(File targetDir) throws IOException {
    File sourceCustomResourceClassFile1 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
    prepareDirectoryWithClasses(targetDir);
    File jandexIndexFile = new File(targetDir.getAbsolutePath(), "META-INF/jandex.idx");
    jandexIndexFile.getParentFile().mkdirs();
    try (OutputStream out = Files.newOutputStream(jandexIndexFile.toPath())) {
      // index contains only one custom resource
      new IndexWriter(out).write(Index.of(sourceCustomResourceClassFile1));
    }
    return Collections.singletonList(MyCustomResource.class.getName());
  }

  static List<String> prepareJarFileWithClasses(File jarFile) throws IOException {
    File sourceCustomResourceClassFile1 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
    File sourceCustomResourceClassFile2 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyOtherCustomResource.class");

    try (JarOutputStream out = new JarOutputStream(Files.newOutputStream(jarFile.toPath()))) {
      JarEntry zipEntry1 = new JarEntry("io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
      out.putNextEntry(zipEntry1);
      copyFile(sourceCustomResourceClassFile1, out);
      JarEntry zipEntry2 = new JarEntry("io/fabric8/crd/generator/collector/examples/MyOtherCustomResource.class");
      out.putNextEntry(zipEntry2);
      copyFile(sourceCustomResourceClassFile2, out);
    }

    return Arrays.asList(MyCustomResource.class.getName(), MyOtherCustomResource.class.getName());
  }

  static List<String> prepareJarFileWithClassesAndIndex(File jarFile) throws IOException {
    File sourceCustomResourceClassFile1 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
    File sourceCustomResourceClassFile2 = new File(
        "target/test-classes/io/fabric8/crd/generator/collector/examples/MyOtherCustomResource.class");

    try (JarOutputStream out = new JarOutputStream(Files.newOutputStream(jarFile.toPath()))) {
      JarEntry zipEntry1 = new JarEntry("io/fabric8/crd/generator/collector/examples/MyCustomResource.class");
      out.putNextEntry(zipEntry1);
      copyFile(sourceCustomResourceClassFile1, out);
      JarEntry zipEntry2 = new JarEntry("io/fabric8/crd/generator/collector/examples/MyOtherCustomResource.class");
      out.putNextEntry(zipEntry2);
      copyFile(sourceCustomResourceClassFile2, out);

      JarEntry zipEntryIndex = new JarEntry("META-INF/jandex.idx");
      out.putNextEntry(zipEntryIndex);
      new IndexWriter(out).write(Index.of(sourceCustomResourceClassFile1, sourceCustomResourceClassFile2));
    }

    return Arrays.asList(MyCustomResource.class.getName(), MyOtherCustomResource.class.getName());
  }

  static void prepareJarFileWithInvalidIndex(File jarFile) throws IOException {
    try (JarOutputStream out = new JarOutputStream(Files.newOutputStream(jarFile.toPath()))) {
      JarEntry zipEntryIndex = new JarEntry("META-INF/jandex.idx");
      out.putNextEntry(zipEntryIndex);

      try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, StandardCharsets.UTF_8)) {
        outputStreamWriter.write("invalid");
      }
    }
  }

  static void prepareEmptyJarFile(File jarFile) throws IOException {
    try (JarOutputStream out = new JarOutputStream(Files.newOutputStream(jarFile.toPath()))) {
      out.closeEntry();
    }
  }

  public static void copyFile(File in, OutputStream out) throws IOException {
    Files.copy(in.toPath(), out);
  }

}
