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

import io.fabric8.crdv2.generator.CustomResourceInfo;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.CompositeIndex;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexReader;
import org.jboss.jandex.IndexView;
import org.jboss.jandex.Indexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Collects CustomResource class files from various places and loads them by using
 * {@link CustomResourceCollector#findCustomResources()}.
 */
public class CustomResourceCollector {

  private static final Logger log = LoggerFactory.getLogger(CustomResourceCollector.class);

  private final CustomResourceClassLoader customResourceClassLoader = new CustomResourceClassLoader();

  private final Set<String> customResourceClassNames = new HashSet<>();

  private final Collection<IndexView> indexes = new LinkedList<>();
  private final Set<File> filesToIndex = new HashSet<>();

  private final List<Predicate<String>> classNameIncludes = new LinkedList<>();
  private final List<Predicate<String>> classNameExcludes = new LinkedList<>();
  private final List<Predicate<CustomResourceInfo>> customResourceInfoIncludes = new LinkedList<>();
  private final List<Predicate<CustomResourceInfo>> customResourceInfoExcludes = new LinkedList<>();

  private boolean forceScan = false;

  public CustomResourceCollector withParentClassLoader(ClassLoader classLoader) {
    if (classLoader != null) {
      this.customResourceClassLoader.withParentClassLoader(classLoader);
    }
    return this;
  }

  public CustomResourceCollector withClasspath(String... classpath) {
    if (classpath != null) {
      this.customResourceClassLoader.withClasspath(classpath);
    }
    return this;
  }

  public CustomResourceCollector withClasspaths(Collection<String> classpaths) {
    if (classpaths != null) {
      this.customResourceClassLoader.withClasspaths(classpaths);
    }
    return this;
  }

  public CustomResourceCollector withCustomResourceClass(String... className) {
    if (className != null) {
      withCustomResourceClasses(Arrays.asList(className));
    }
    return this;
  }

  public CustomResourceCollector withCustomResourceClasses(Collection<String> classNames) {
    if (classNames != null) {
      classNames.stream()
          .filter(Objects::nonNull)
          .forEach(this.customResourceClassNames::add);
    }
    return this;
  }

  public CustomResourceCollector withIndex(IndexView... index) {
    if (index != null) {
      withIndices(Arrays.asList(index));
    }
    return this;
  }

  public CustomResourceCollector withIndices(Collection<IndexView> indices) {
    if (indices != null) {
      indices.stream()
          .filter(Objects::nonNull)
          .forEach(this.indexes::add);
    }
    return this;
  }

  public CustomResourceCollector withFileToIndex(File... files) {
    if (files != null) {
      withFilesToIndex(Arrays.asList(files));
    }
    return this;
  }

  public CustomResourceCollector withFilesToIndex(Collection<File> files) {
    if (files != null) {
      files.stream()
          .filter(Objects::nonNull)
          .forEach(this.filesToIndex::add);
    }
    return this;
  }

  public CustomResourceCollector withIncludePackages(Collection<String> packages) {
    if (packages != null) {
      packages.stream()
          .filter(Objects::nonNull)
          .map(pkg -> (Predicate<String>) s -> s.startsWith(pkg))
          .reduce(Predicate::or)
          .ifPresent(this.classNameIncludes::add);
    }
    return this;
  }

  public CustomResourceCollector withExcludePackages(Collection<String> packages) {
    if (packages != null) {
      packages.stream()
          .filter(Objects::nonNull)
          .map(pkg -> (Predicate<String>) s -> s.startsWith(pkg))
          .reduce(Predicate::or)
          .ifPresent(this.classNameExcludes::add);
    }
    return this;
  }

  public CustomResourceCollector withIncludeGroups(Collection<String> groups) {
    if (groups != null) {
      groups.stream()
          .filter(Objects::nonNull)
          .map(group -> (Predicate<CustomResourceInfo>) cr -> group.equals(cr.group()))
          .reduce(Predicate::or)
          .ifPresent(customResourceInfoIncludes::add);
    }
    return this;
  }

  public CustomResourceCollector withExcludeGroups(Collection<String> groups) {
    if (groups != null) {
      groups.stream()
          .filter(Objects::nonNull)
          .map(groupToFilter -> (Predicate<CustomResourceInfo>) cr -> groupToFilter.equals(cr.group()))
          .reduce(Predicate::or)
          .ifPresent(customResourceInfoExcludes::add);
    }
    return this;
  }

  public CustomResourceCollector withIncludeVersions(Collection<String> versions) {
    if (versions != null) {
      versions.stream()
          .filter(Objects::nonNull)
          .map(versionToFilter -> (Predicate<CustomResourceInfo>) cr -> versionToFilter.equals(cr.version()))
          .reduce(Predicate::or)
          .ifPresent(customResourceInfoIncludes::add);
    }
    return this;
  }

  public CustomResourceCollector withExcludeVersions(Collection<String> versions) {
    if (versions != null) {
      versions.stream()
          .filter(Objects::nonNull)
          .map(versionToFilter -> (Predicate<CustomResourceInfo>) cr -> versionToFilter.equals(cr.version()))
          .reduce(Predicate::or)
          .ifPresent(customResourceInfoExcludes::add);
    }
    return this;
  }

  public CustomResourceInfo[] findCustomResources() {
    Set<String> customResourcesClassNames = new HashSet<>(customResourceClassNames);

    // create / consider indices only if custom resource are not explicitly named
    if (customResourcesClassNames.isEmpty()) {
      Collection<IndexView> indices = new LinkedList<>();

      indices.add(createBaseIndex());
      indices.addAll(this.indexes);

      if (!filesToIndex.isEmpty()) {
        Set<File> filesToIndex = new HashSet<>(this.filesToIndex);

        if (!forceScan) {
          List<File> directoriesWithIndex = filesToIndex.stream()
              .filter(this::isDirectoryWithIndex)
              .collect(Collectors.toList());

          directoriesWithIndex.stream()
              .map(this::getIndexFromDirectory)
              .forEach(indices::add);

          log.info("Found {} directories with existing indices", directoriesWithIndex.size());

          directoriesWithIndex.forEach(filesToIndex::remove);

          List<File> archivesWithIndex = filesToIndex.stream()
              .filter(this::isArchiveWithIndex)
              .collect(Collectors.toList());

          archivesWithIndex.stream()
              .map(this::getIndexFromArchive)
              .forEach(indices::add);

          log.info("Found {} archives with existing indices", archivesWithIndex.size());

          archivesWithIndex.forEach(filesToIndex::remove);
        }

        log.info("Creating {} indices", filesToIndex.size());
        indices.add(JandexIndexer.indexFor(filesToIndex));
      }

      CompositeIndex compositeIndex = CompositeIndex.create(indices);
      findCustomResourceClasses(compositeIndex).stream()
          .map(ClassInfo::toString)
          .forEach(customResourcesClassNames::add);

      log.info("Found {} custom resource classes before filtering", customResourcesClassNames.size());
    } else {
      log.info("Using explicit {} custom resource classes and skip scanning", customResourcesClassNames);
    }

    Predicate<String> classNameIncludePredicate = classNameIncludes.stream()
        .reduce(Predicate::and)
        .orElse(s -> true);

    Predicate<String> classNameExcludePredicate = classNameIncludes.stream()
        .reduce(Predicate::and)
        .orElse(s -> false)
        .negate();

    Predicate<CustomResourceInfo> customResourceInfoIncludePredicate = customResourceInfoIncludes.stream()
        .reduce(Predicate::and)
        .orElse(x -> true);

    Predicate<CustomResourceInfo> customResourceInfoExcludePredicate = customResourceInfoExcludes.stream()
        .reduce(Predicate::and)
        .orElse(x -> false)
        .negate();

    CustomResourceInfo[] infos = customResourcesClassNames.stream()
        .filter(classNameIncludePredicate)
        .filter(classNameExcludePredicate)
        .map(customResourceClassLoader::loadCustomResourceClass)
        .map(this::createCustomResourceInfo)
        .filter(customResourceInfoIncludePredicate)
        .filter(customResourceInfoExcludePredicate)
        .toArray(CustomResourceInfo[]::new);

    log.debug("Found {} custom resource classes after filtering", infos.length);

    return infos;
  }

  private List<ClassInfo> findCustomResourceClasses(IndexView index) {
    index.getKnownClasses()
        .forEach(classInfo -> log.info("Indexed class: {}", classInfo.toString()));

    // Only works if HasMetadata itself has been indexed
    return index.getAllKnownImplementors(HasMetadata.class)
        .stream()
        .filter(classInfo -> classInfo.hasAnnotation(Group.class))
        .filter(classInfo -> classInfo.hasAnnotation(Version.class))
        .collect(Collectors.toList());
  }

  private CustomResourceInfo createCustomResourceInfo(
      Class<? extends HasMetadata> customResourceClass) {
    return CustomResourceInfo.fromClass(customResourceClass);
  }

  /**
   * Creates the base index required to scan for custom resources.
   *
   * @return the base index.
   */
  private Index createBaseIndex() {
    try {
      Indexer indexer = new Indexer();
      indexer.indexClass(HasMetadata.class);
      indexer.indexClass(CustomResource.class);
      indexer.indexClass(Group.class);
      indexer.indexClass(Version.class);
      return indexer.complete();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private boolean isDirectoryWithIndex(File file) {
    return file.isDirectory() && new File(file, "META-INF/jandex.idx").exists();
  }

  private Index getIndexFromDirectory(File dir) {
    try (InputStream in = Files.newInputStream(new File(dir, "META-INF/jandex.idx").toPath())) {
      IndexReader reader = new IndexReader(in);
      return reader.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private boolean isArchiveWithIndex(File file) {
    if (file.isFile() && file.getName().endsWith(".jar")) {
      try (ZipFile zip = new ZipFile(file)) {
        ZipEntry entry = zip.getEntry("META-INF/jandex.idx");
        return entry != null;
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return false;
  }

  private Index getIndexFromArchive(File file) {
    try (ZipFile zip = new ZipFile(file)) {
      ZipEntry entry = zip.getEntry("META-INF/jandex.idx");
      try (InputStream in = zip.getInputStream(entry)) {
        IndexReader reader = new IndexReader(in);
        return reader.read();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
