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
import org.jboss.jandex.IndexReader;
import org.jboss.jandex.UnsupportedVersion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Optional;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Utility methods to find an existing Jandex index in a directory or JAR file.
 */
class JandexUtils {

  static final String JAR_FILE_SUFFIX = ".jar";
  private static final String DEFAULT_JANDEX_INDEX = "META-INF/jandex.idx";

  private JandexUtils() {
  }

  static Optional<Index> findExistingIndex(File file) {
    return findExistingIndexInDirectory(file).map(Optional::of)
        .orElseGet(() -> findExistingIndexInJarFile(file));
  }

  static Optional<Index> findExistingIndexInDirectory(File file) {
    if (!file.isDirectory()) {
      return Optional.empty();
    }
    File jandexIndexFile = new File(file, DEFAULT_JANDEX_INDEX);
    if (!jandexIndexFile.exists()) {
      return Optional.empty();
    }

    try (InputStream in = Files.newInputStream(jandexIndexFile.toPath())) {
      return Optional.of(readIndex(in));
    } catch (IOException e) {
      throw new CustomResourceCollectorException(
          "Could not read Jandex index from directory: " + file, e);
    }
  }

  static Optional<Index> findExistingIndexInJarFile(File file) {
    if (!file.isFile() || !file.getName().endsWith(JAR_FILE_SUFFIX)) {
      return Optional.empty();
    }

    try (JarFile zip = new JarFile(file)) {
      JarEntry entry = zip.getJarEntry(DEFAULT_JANDEX_INDEX);
      if (entry == null) {
        return Optional.empty();
      }
      return Optional.of(readIndex(zip.getInputStream(entry)));
    } catch (IOException | IllegalArgumentException | UnsupportedVersion e) {
      throw new CustomResourceCollectorException(
          "Could not read Jandex index from JAR file " + file, e);
    }
  }

  private static Index readIndex(InputStream in) throws IOException {
    IndexReader reader = new IndexReader(in);
    return reader.read();
  }

}
