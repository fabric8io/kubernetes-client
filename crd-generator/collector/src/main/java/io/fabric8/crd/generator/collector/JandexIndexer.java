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

import org.jboss.jandex.ClassSummary;
import org.jboss.jandex.Index;
import org.jboss.jandex.Indexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Allows to create a Jandex index based on given class files, directories and JAR archives.
 * Unlike {@link Index#of(File...)}, this implementation performs a recursive scan of the directories.
 */
public class JandexIndexer {

  private static final Logger log = LoggerFactory.getLogger(JandexIndexer.class);

  private static final String CLASS_FILE_SUFFIX = ".class";
  private static final String JAR_FILE_SUFFIX = ".jar";

  private final List<File> files = new ArrayList<>();

  public JandexIndexer withFile(File... file) {
    if (file != null) {
      withFiles(Arrays.asList(file));
    }
    return this;
  }

  public JandexIndexer withFiles(Collection<File> files) {
    if (files != null) {
      files.stream()
          .filter(Objects::nonNull)
          .forEach(this.files::add);
    }
    return this;
  }

  public Index createIndex() {
    Indexer indexer = new Indexer();
    appendToIndex(indexer);
    return indexer.complete();
  }

  void appendToIndex(Indexer indexer) {
    for (File file : files) {
      if (file.isDirectory()) {
        scanDirectoryAndAddToIndex(file, indexer);
      } else if (file.isFile() && file.getName().endsWith(CLASS_FILE_SUFFIX)) {
        scanClassFileAndAddToIndex(file, indexer);
      } else if (file.isFile() && file.getName().endsWith(JAR_FILE_SUFFIX)) {
        scanJarFileAndAddToIndex(file, indexer);
      } else {
        throw new IllegalArgumentException("Not a class file, JAR file or directory: " + file);
      }
    }
  }

  private void scanClassFileAndAddToIndex(File file, Indexer indexer) {
    try (InputStream in = Files.newInputStream(file.toPath())) {
      addToIndex(in, indexer);
    } catch (IOException e) {
      throw new CustomResourceCollectorException(e);
    }
  }

  private void scanJarFileAndAddToIndex(File file, Indexer indexer) {
    try (ZipFile zip = new ZipFile(file)) {
      Enumeration<? extends ZipEntry> entries = zip.entries();
      while (entries.hasMoreElements()) {
        ZipEntry entry = entries.nextElement();
        if (!entry.isDirectory()) {
          if (entry.getName().endsWith(CLASS_FILE_SUFFIX)) {
            try (InputStream in = zip.getInputStream(entry)) {
              addToIndex(in, indexer);
            } catch (Exception e) {
              throw new CustomResourceCollectorException(e);
            }
          }
        }
      }
    } catch (IOException e) {
      throw new CustomResourceCollectorException(e);
    }
  }

  private void scanDirectoryAndAddToIndex(File directory, Indexer indexer) {
    try (Stream<Path> stream = Files.walk(directory.toPath())) {
      stream
          .filter(Files::isRegularFile)
          .filter(file -> file.toString().endsWith(CLASS_FILE_SUFFIX))
          .forEach(file -> {
            try (InputStream in = Files.newInputStream(file)) {
              addToIndex(in, indexer);
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
          });
    } catch (IOException e) {
      throw new CustomResourceCollectorException(e);
    }
  }

  private void addToIndex(InputStream inputStream, Indexer indexer) throws IOException {
    ClassSummary info = indexer.indexWithSummary(inputStream);
    log.debug("Indexed: {} ({} Annotations)", info.name(), info.annotationsCount());
  }

  public static Index indexFor(Collection<File> files) {
    return new JandexIndexer()
        .withFiles(files)
        .createIndex();
  }

}
