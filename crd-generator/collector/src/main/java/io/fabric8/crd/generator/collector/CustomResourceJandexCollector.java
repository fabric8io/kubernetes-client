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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.CompositeIndex;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexView;
import org.jboss.jandex.Indexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Collects multiple Jandex index sources and allows to find Custom Resource class names by using
 * {@link CustomResourceJandexCollector#findCustomResourceClasses()} in the resulting composite index.
 *
 * @see Index
 * @see JandexIndexer
 */
class CustomResourceJandexCollector {

  private static final Logger log = LoggerFactory.getLogger(CustomResourceJandexCollector.class);

  private final List<IndexView> indices = new LinkedList<>();
  private final Set<File> filesToIndex = new HashSet<>();

  private boolean forceIndex = false;

  public CustomResourceJandexCollector withForceIndex(boolean forceIndex) {
    this.forceIndex = forceIndex;
    return this;
  }

  public CustomResourceJandexCollector withIndex(IndexView... index) {
    if (index != null) {
      withIndices(Arrays.asList(index));
    }
    return this;
  }

  public CustomResourceJandexCollector withIndices(Collection<IndexView> indices) {
    if (indices != null) {
      indices.stream()
          .filter(Objects::nonNull)
          .forEach(this.indices::add);
    }
    return this;
  }

  public CustomResourceJandexCollector withFileToIndex(File... files) {
    if (files != null) {
      withFilesToIndex(Arrays.asList(files));
    }
    return this;
  }

  public CustomResourceJandexCollector withFilesToIndex(Collection<File> files) {
    if (files != null) {
      files.stream()
          .filter(Objects::nonNull)
          .forEach(this.filesToIndex::add);
    }
    return this;
  }

  public List<String> findCustomResourceClasses() {
    Collection<IndexView> allIndices = new LinkedList<>();
    allIndices.add(createBaseIndex());
    allIndices.addAll(this.indices);

    if (!filesToIndex.isEmpty()) {
      Set<File> actualFilesToIndex = new HashSet<>();
      for (File file : filesToIndex) {
        if (forceIndex) {
          // no lookup for existing indices
          actualFilesToIndex.add(file);
        } else {
          Optional<Index> index = JandexUtils.findExistingIndex(file);
          if (index.isPresent()) {
            allIndices.add(index.get());
          } else {
            actualFilesToIndex.add(file);
          }
        }
      }

      log.debug("Creating {} indices", actualFilesToIndex.size());
      allIndices.add(JandexIndexer.indexFor(actualFilesToIndex));
    }

    CompositeIndex compositeIndex = CompositeIndex.create(allIndices);
    return findCustomResourceClasses(compositeIndex).stream()
        .map(ClassInfo::toString)
        .collect(Collectors.toList());
  }

  private List<ClassInfo> findCustomResourceClasses(IndexView index) {
    // Only works if HasMetadata and all intermediate classes (like CustomResource) have been indexed
    return index.getAllKnownImplementors(HasMetadata.class)
        .stream()
        .filter(classInfo -> classInfo.hasAnnotation(Group.class))
        .filter(classInfo -> classInfo.hasAnnotation(Version.class))
        .collect(Collectors.toList());
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
      return indexer.complete();
    } catch (IOException e) {
      throw new CustomResourceCollectorException("Could not create base index", e);
    }
  }

}
