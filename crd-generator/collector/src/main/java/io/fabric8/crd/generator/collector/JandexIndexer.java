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

import java.io.BufferedInputStream;
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
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

/**
 * Allows to create a Jandex index based on given class files, directories and JAR archives.
 * Unlike {@link Index#of(File...)}, this implementation performs a recursive scan of the directories.
 */
class JandexIndexer {

  private static final Logger log = LoggerFactory.getLogger(JandexIndexer.class);

  private static final String CLASS_FILE_SUFFIX = ".class";
  private static final String JAR_FILE_SUFFIX = ".jar";

  private final List<File> files = new ArrayList<>();

  private int maxJarEntries = 10000;
  private long maxBytesReadFromJar = 100000000; // 100 MB
  private long maxClassFileSize = 1000000; // 1 MB

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

  public JandexIndexer withMaxJarEntries(int maxJarEntries) {
    if (maxJarEntries < 1)
      throw new IllegalArgumentException("maxJarEntries must be greater than 0");
    this.maxJarEntries = maxJarEntries;
    return this;
  }

  public JandexIndexer withMaxClassFileSize(int maxClassFileSize) {
    if (maxClassFileSize < 10)
      throw new IllegalArgumentException("maxClassFileSize must be greater than 10");
    this.maxClassFileSize = maxClassFileSize;
    return this;
  }

  public JandexIndexer withMaxBytesReadFromJar(long maxBytesReadFromJar) {
    if (maxBytesReadFromJar < 10)
      throw new IllegalArgumentException("maxBytesReadFromJar must be greater than 10");
    this.maxBytesReadFromJar = maxBytesReadFromJar;
    return this;
  }

  public Index createIndex() {
    Indexer indexer = new Indexer();
    appendToIndex(indexer);
    return indexer.complete();
  }

  private void appendToIndex(Indexer indexer) {
    for (File file : files) {
      if (file.isDirectory()) {
        scanDirectoryAndAddToIndex(file, indexer);
      } else if (file.isFile() && file.getName().endsWith(CLASS_FILE_SUFFIX)) {
        addClassFileToIndex(file, indexer);
      } else if (file.isFile() && file.getName().endsWith(JAR_FILE_SUFFIX)) {
        scanJarFileAndAddToIndex(file, indexer);
      } else {
        throw new CustomResourceCollectorException("Not a class file, JAR file or directory: " + file);
      }
    }
  }

  private void addClassFileToIndex(File file, Indexer indexer) {
    try (InputStream in = Files.newInputStream(file.toPath())) {
      addToIndex(in, indexer);
    } catch (IOException e) {
      throw new CustomResourceCollectorException(e);
    }
  }

  private void scanJarFileAndAddToIndex(File file, Indexer indexer) {
    try (JarFile jar = new JarFile(file)) {
      Enumeration<? extends JarEntry> entries = jar.entries();
      int totalEntries = 0;
      long totalBytesRead = 0;
      while (entries.hasMoreElements()) {
        totalEntries++;
        JarEntry entry = entries.nextElement();
        if (!entry.isDirectory() && entry.getName().endsWith(CLASS_FILE_SUFFIX)) {
          long bytesRead = addToIndex(jar, entry, indexer);
          totalBytesRead = totalBytesRead + bytesRead;
        }
        if (totalEntries > maxJarEntries) {
          throw new CustomResourceCollectorException("Limit for total JAR file entries exceeded: " + totalEntries);
        }
        if (totalBytesRead > maxBytesReadFromJar) {
          throw new CustomResourceCollectorException(
              "Limit for total bytes read from JAR file exceeded: " + totalBytesRead + " bytes");
        }
      }
    } catch (IOException e) {
      throw new CustomResourceCollectorException("Could not index JAR file " + file, e);
    }
  }

  private void scanDirectoryAndAddToIndex(File directory, Indexer indexer) {
    try (Stream<Path> stream = Files.walk(directory.toPath())) {
      stream
          .filter(Files::isRegularFile)
          .filter(file -> file.toString().endsWith(CLASS_FILE_SUFFIX))
          .forEach(file -> addToIndex(file, indexer));
    } catch (IOException e) {
      throw new CustomResourceCollectorException(e);
    }
  }

  private long addToIndex(JarFile zip, JarEntry entry, Indexer indexer) {
    try (InputStream in = zip.getInputStream(entry)) {
      return addToIndex(in, indexer);
    } catch (IOException e) {
      throw new CustomResourceCollectorException("Could not index " + entry.getName() + " from JAR file " + zip.getName(), e);
    }
  }

  private long addToIndex(Path file, Indexer indexer) {
    try (InputStream in = Files.newInputStream(file)) {
      return addToIndex(in, indexer);
    } catch (IOException e) {
      throw new CustomResourceCollectorException("Could not index " + file, e);
    }
  }

  private long addToIndex(InputStream inputStream, Indexer indexer) throws IOException {
    try (BoundedInputStream boundedInputStream = new BoundedInputStream(inputStream, maxClassFileSize);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(boundedInputStream)) {
      ClassSummary info = indexer.indexWithSummary(bufferedInputStream);
      log.debug("Indexed: {} ({} Annotations)", info.name(), info.annotationsCount());
      return boundedInputStream.getBytesRead();
    }
  }

  public static Index indexFor(Collection<File> files) {
    return new JandexIndexer()
        .withFiles(files)
        .createIndex();
  }

  static class BoundedInputStream extends InputStream implements AutoCloseable {
    private final long maxBytes;
    private final InputStream inputStream;

    private long bytesRead = 0;

    public BoundedInputStream(InputStream inputStream, long maxBytes) {
      this.inputStream = inputStream;
      this.maxBytes = maxBytes;
    }

    public long getBytesRead() {
      return bytesRead;
    }

    @Override
    public int read() throws IOException {
      if (bytesRead >= maxBytes) {
        throw new IOException("Read limit of " + maxBytes + " bytes exceeded");
      }
      int result = inputStream.read();
      if (result != -1) {
        bytesRead++;
      }
      return result;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
      if (bytesRead >= maxBytes) {
        throw new IOException("Read limit of " + maxBytes + " bytes exceeded");
      }
      long bytesRemaining = maxBytes - bytesRead;
      if (len > bytesRemaining) {
        len = (int) bytesRemaining; // Reduce len to the maximum allowable bytes
      }
      int count = inputStream.read(b, off, len);
      if (count > 0) {
        bytesRead += count;
      }
      return count;
    }

    @Override
    public int available() throws IOException {
      long available = inputStream.available();
      long bytesRemaining = maxBytes - bytesRead;
      if (available > bytesRemaining) {
        return (int) bytesRemaining;
      } else {
        return (int) available;
      }
    }

    @Override
    public void close() throws IOException {
      inputStream.close();
      super.close();
    }
  }

}
