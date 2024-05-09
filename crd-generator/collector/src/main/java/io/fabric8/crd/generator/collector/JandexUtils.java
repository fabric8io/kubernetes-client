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

import org.jboss.jandex.CompositeIndex;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexReader;
import org.jboss.jandex.IndexView;
import org.jboss.jandex.UnsupportedVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Utility methods for Jandex
 */
class JandexUtils {

  private static final Logger log = LoggerFactory.getLogger(JandexIndexer.class);

  static final String JAR_FILE_SUFFIX = ".jar";
  private static final String DEFAULT_JANDEX_INDEX = "META-INF/jandex.idx";

  private JandexUtils() {
  }

  /**
   * Creates a composite index from given Jandex indices, class files, directories of class files
   * and JAR files containing class files.
   * <p>
   * If not forced, the implementation uses an existing Jandex index if found in the source.
   * Otherwise, the index will be created on the fly.
   * </p>
   *
   * @param indices Jandex indices
   * @param filesToIndex files to index
   * @param forceIndex If <code>true</code>, indices will always be created even if an index
   *        exists at the source.
   * @return the composite index
   */
  static IndexView createIndex(Collection<IndexView> indices, Collection<File> filesToIndex,
      boolean forceIndex) {
    Collection<IndexView> allIndices = new LinkedList<>(indices);
    if (!filesToIndex.isEmpty()) {
      Set<File> actualFilesToIndex = new HashSet<>();
      for (File file : filesToIndex) {
        if (forceIndex) {
          // skip finding existing index and always create new index
          actualFilesToIndex.add(file);
        } else {
          // use existing index if exist otherwise create new index
          Optional<Index> index = findExistingIndex(file);
          if (index.isPresent()) {
            allIndices.add(index.get());
          } else {
            actualFilesToIndex.add(file);
          }
        }
      }

      log.debug("Creating {} indices", actualFilesToIndex.size());
      allIndices.add(new JandexIndexer().createIndex(actualFilesToIndex));
    }
    return CompositeIndex.create(allIndices);
  }

  static Optional<Index> findExistingIndex(File file) {
    return findExistingIndexInDirectory(file).map(Optional::of)
        .orElseGet(() -> findExistingIndexInJarFile(file));
  }

  /**
   * Returns the index from the given file if the file is a directory and the index exists.
   *
   * @param file the file
   * @return the index
   * @throws JandexException if a fatal error occurs
   */
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
      throw new JandexException(
          "Could not read Jandex index from directory: " + file, e);
    }
  }

  /**
   * Returns the index from the given file if the file is a JAR file and the index exists.
   *
   * @param file the file
   * @return the index
   * @throws JandexException if a fatal error occurs
   */
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
      throw new JandexException(
          "Could not read Jandex index from JAR file " + file, e);
    }
  }

  private static Index readIndex(InputStream in) throws IOException {
    IndexReader reader = new IndexReader(in);
    return reader.read();
  }

}
