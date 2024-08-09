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
import org.jboss.jandex.IndexView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Collects Custom Resource class files from various places and loads them by using
 * {@link CustomResourceCollector#findCustomResourceClasses()}.
 */
public class CustomResourceCollector {

  private static final Logger log = LoggerFactory.getLogger(CustomResourceCollector.class);

  private final CustomResourceClassLoader customResourceClassLoader;
  private final JandexCustomResourceClassScanner jandexCustomResourceClassScanner;

  private final Set<String> customResourceClassNames = new HashSet<>();

  private final List<Predicate<String>> classNamePredicates = new LinkedList<>();

  private boolean forceScan = false;

  public CustomResourceCollector() {
    this(null, null);
  }

  CustomResourceCollector(
      CustomResourceClassLoader customResourceClassLoader,
      JandexCustomResourceClassScanner jandexCustomResourceClassScanner) {

    this.customResourceClassLoader = ofNullable(customResourceClassLoader)
        .orElseGet(CustomResourceClassLoader::new);
    this.jandexCustomResourceClassScanner = ofNullable(jandexCustomResourceClassScanner)
        .orElseGet(JandexCustomResourceClassScanner::new);
  }

  public CustomResourceCollector withParentClassLoader(ClassLoader classLoader) {
    this.customResourceClassLoader.withParentClassLoader(classLoader);
    return this;
  }

  @SuppressWarnings("UnusedReturnValue")
  public CustomResourceCollector withClasspathElement(String... classpathElement) {
    this.customResourceClassLoader.withClasspathElement(classpathElement);
    return this;
  }

  public CustomResourceCollector withClasspathElements(Collection<String> classpathElements) {
    this.customResourceClassLoader.withClasspathElements(classpathElements);
    return this;
  }

  @SuppressWarnings("UnusedReturnValue")
  public CustomResourceCollector withCustomResourceClass(String... className) {
    if (className != null) {
      withCustomResourceClasses(Arrays.asList(className));
    }
    return this;
  }

  @SuppressWarnings("UnusedReturnValue")
  public CustomResourceCollector withCustomResourceClasses(Collection<String> classNames) {
    if (classNames != null) {
      classNames.stream()
          .filter(Objects::nonNull)
          .forEach(this.customResourceClassNames::add);
    }
    return this;
  }

  @SuppressWarnings("UnusedReturnValue")
  public CustomResourceCollector withIndex(IndexView... index) {
    jandexCustomResourceClassScanner.withIndex(index);
    return this;
  }

  @SuppressWarnings("UnusedReturnValue")
  public CustomResourceCollector withIndices(Collection<IndexView> indices) {
    jandexCustomResourceClassScanner.withIndices(indices);
    return this;
  }

  public CustomResourceCollector withFileToScan(File... files) {
    jandexCustomResourceClassScanner.withFileToScan(files);
    return this;
  }

  public CustomResourceCollector withFilesToScan(Collection<File> files) {
    jandexCustomResourceClassScanner.withFilesToScan(files);
    return this;
  }

  public CustomResourceCollector withForceIndex(boolean forceIndex) {
    jandexCustomResourceClassScanner.withForceIndex(forceIndex);
    return this;
  }

  public CustomResourceCollector withForceScan(boolean forceScan) {
    this.forceScan = forceScan;
    return this;
  }

  public CustomResourceCollector withIncludePackages(Collection<String> packages) {
    if (packages != null) {
      packages.stream()
          .filter(Objects::nonNull)
          .map(pkg -> (Predicate<String>) s -> s.startsWith(pkg))
          .reduce(Predicate::or)
          .ifPresent(this.classNamePredicates::add);
    }
    return this;
  }

  public CustomResourceCollector withExcludePackages(Collection<String> packages) {
    if (packages != null) {
      packages.stream()
          .filter(Objects::nonNull)
          .map(pkg -> (Predicate<String>) s -> !s.startsWith(pkg))
          .reduce(Predicate::or)
          .ifPresent(this.classNamePredicates::add);
    }
    return this;
  }

  /**
   * Find and load Custom Resource classes in the previously defined context.
   * <p>
   * If at least one Custom Resource class name is given, scanning for classes is skipped.
   * Otherwise Custom Resource classes are searched in locations provided by
   * {@link #withFileToScan(File...)} or {@link #withFilesToScan(Collection)}.
   * </p>
   *
   * @return the Custom Resource classes
   */
  public List<Class<? extends HasMetadata>> findCustomResourceClasses() {
    Set<String> customResourcesClassNames = new HashSet<>(customResourceClassNames);

    if (forceScan || customResourcesClassNames.isEmpty()) {
      // search only if custom resource class names are not explicitly given
      customResourcesClassNames.addAll(jandexCustomResourceClassScanner.findCustomResourceClasses());
      log.debug("Found {} custom resource classes", customResourcesClassNames.size());
    } else {
      log.debug("Using explicit {} custom resource classes and skip scanning", customResourcesClassNames.size());
    }

    Predicate<String> classNamePredicate = classNamePredicates.stream()
        .reduce(Predicate::and)
        .orElse(className -> true);

    List<Class<? extends HasMetadata>> customResourceClasses = customResourcesClassNames.stream()
        .filter(classNamePredicate)
        .map(customResourceClassLoader::loadCustomResourceClass)
        .collect(Collectors.toList());

    log.debug("Retained {} custom resource classes after filtering", customResourceClasses.size());
    return customResourceClasses;
  }

  /**
   * Resets all internal states to defaults.
   */
  void reset() {
    customResourceClassLoader.reset();
    jandexCustomResourceClassScanner.reset();
    customResourceClassNames.clear();
    classNamePredicates.clear();
    forceScan = false;
  }

}
