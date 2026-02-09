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
package io.fabric8.graalvm.plugin;

import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.DotName;
import org.jboss.jandex.IndexReader;
import org.jboss.jandex.IndexView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Scans classes using Jandex index to find classes that require reflection in GraalVM native-image.
 */
public class JandexReflectionScanner {

  private static final DotName JSON_DESERIALIZE = DotName
      .createSimple("com.fasterxml.jackson.databind.annotation.JsonDeserialize");
  private static final DotName JSON_PROPERTY = DotName.createSimple("com.fasterxml.jackson.annotation.JsonProperty");
  private static final DotName JSON_SERIALIZE = DotName.createSimple("com.fasterxml.jackson.databind.annotation.JsonSerialize");
  private static final DotName JSON_TYPE_INFO = DotName.createSimple("com.fasterxml.jackson.annotation.JsonTypeInfo");
  private static final DotName JSON_SUB_TYPES = DotName.createSimple("com.fasterxml.jackson.annotation.JsonSubTypes");
  private static final DotName BUILDABLE = DotName.createSimple("io.sundr.builder.annotations.Buildable");
  private static final DotName HAS_METADATA = DotName.createSimple("io.fabric8.kubernetes.api.model.HasMetadata");

  private final IndexView index;

  public JandexReflectionScanner(File indexFile) throws IOException {
    try (InputStream in = new FileInputStream(indexFile)) {
      IndexReader reader = new IndexReader(in);
      this.index = reader.read();
    }
  }

  /**
   * Find classes that match the given inclusion strategy.
   */
  public Set<String> findClasses(InclusionStrategy strategy, List<String> includePatterns, List<String> excludePatterns) {
    Set<String> classes = new HashSet<>();

    switch (strategy) {
      case JACKSON_ANNOTATIONS:
        classes.addAll(findJacksonAnnotatedClasses());
        break;
      case SUNDRIO_BUILDERS:
        classes.addAll(findSundrioBuilders());
        break;
      case KUBERNETES_RESOURCES:
        classes.addAll(findKubernetesResources());
        break;
      case COMPREHENSIVE:
        classes.addAll(findJacksonAnnotatedClasses());
        classes.addAll(findSundrioBuilders());
        classes.addAll(findKubernetesResources());
        break;
      case PATTERN_BASED:
        // Only use patterns, don't scan for annotations
        break;
      case ALL_PUBLIC_CLASSES:
        classes.addAll(findAllPublicClasses());
        break;
      case DIRECT_OBJECT_SUBCLASSES:
        classes.addAll(findDirectObjectSubclasses());
        break;
    }

    // Apply include patterns
    if (includePatterns != null && !includePatterns.isEmpty()) {
      Set<String> matchedByPatterns = findByPatterns(includePatterns);
      if (strategy == InclusionStrategy.PATTERN_BASED) {
        classes.addAll(matchedByPatterns);
      } else {
        // For other strategies, patterns are additive
        classes.addAll(matchedByPatterns);
      }
    }

    // Apply exclude patterns
    if (excludePatterns != null && !excludePatterns.isEmpty()) {
      Set<String> excluded = findByPatterns(excludePatterns);
      classes.removeAll(excluded);
    }

    return classes;
  }

  /**
   * Find classes with Jackson annotations.
   */
  private Set<String> findJacksonAnnotatedClasses() {
    Set<String> classes = new HashSet<>();

    // Find classes with class-level annotations
    addClassesWithClassAnnotation(classes, JSON_DESERIALIZE);
    addClassesWithClassAnnotation(classes, JSON_SERIALIZE);
    addClassesWithClassAnnotation(classes, JSON_TYPE_INFO);
    addClassesWithClassAnnotation(classes, JSON_SUB_TYPES);

    // Find classes with member-level annotations
    addClassesWithMemberAnnotation(classes, JSON_PROPERTY);

    return classes;
  }

  /**
   * Add classes that have the specified annotation at the class level.
   */
  private void addClassesWithClassAnnotation(Set<String> classes, DotName annotationName) {
    for (AnnotationInstance annotation : index.getAnnotations(annotationName)) {
      if (annotation.target().kind() == org.jboss.jandex.AnnotationTarget.Kind.CLASS) {
        classes.add(annotation.target().asClass().name().toString());
      }
    }
  }

  /**
   * Add classes that have the specified annotation on fields or methods.
   */
  private void addClassesWithMemberAnnotation(Set<String> classes, DotName annotationName) {
    for (AnnotationInstance annotation : index.getAnnotations(annotationName)) {
      org.jboss.jandex.AnnotationTarget.Kind kind = annotation.target().kind();
      if (kind == org.jboss.jandex.AnnotationTarget.Kind.FIELD) {
        classes.add(annotation.target().asField().declaringClass().name().toString());
      } else if (kind == org.jboss.jandex.AnnotationTarget.Kind.METHOD) {
        classes.add(annotation.target().asMethod().declaringClass().name().toString());
      }
    }
  }

  /**
   * Find classes with Sundrio @Buildable annotation and generated builder classes.
   */
  private Set<String> findSundrioBuilders() {
    Set<String> classes = new HashSet<>();

    for (AnnotationInstance annotation : index.getAnnotations(BUILDABLE)) {
      if (annotation.target().kind() == org.jboss.jandex.AnnotationTarget.Kind.CLASS) {
        String className = annotation.target().asClass().name().toString();
        classes.add(className);

        // Add generated builder class
        String builderClassName = className + "Builder";
        if (index.getClassByName(DotName.createSimple(builderClassName)) != null) {
          classes.add(builderClassName);
        }
      }
    }

    return classes;
  }

  /**
   * Find Kubernetes resource classes (HasMetadata implementations).
   */
  @SuppressWarnings("deprecation")
  private Set<String> findKubernetesResources() {
    Set<String> classes = new HashSet<>();

    // Using getAllKnownImplementors which is deprecated in Jandex 3.x but still functional
    for (ClassInfo classInfo : index.getAllKnownImplementors(HAS_METADATA)) {
      classes.add(classInfo.name().toString());
    }

    return classes;
  }

  /**
   * Find all public classes.
   */
  private Set<String> findAllPublicClasses() {
    Set<String> classes = new HashSet<>();

    for (ClassInfo classInfo : index.getKnownClasses()) {
      if (java.lang.reflect.Modifier.isPublic(classInfo.flags())) {
        classes.add(classInfo.name().toString());
      }
    }

    return classes;
  }

  /**
   * Find classes that directly extend java.lang.Object (no other superclass).
   */
  private Set<String> findDirectObjectSubclasses() {
    Set<String> classes = new HashSet<>();
    DotName objectName = DotName.createSimple("java.lang.Object");

    for (ClassInfo classInfo : index.getKnownClasses()) {
      // Skip interfaces and annotations
      if (classInfo.isInterface() || classInfo.isAnnotation()) {
        continue;
      }

      // Get the superclass
      DotName superClass = classInfo.superName();

      // Include only if superclass is java.lang.Object
      if (superClass != null && superClass.equals(objectName)) {
        classes.add(classInfo.name().toString());
      }
    }

    return classes;
  }

  /**
   * Find classes matching the given patterns.
   */
  private Set<String> findByPatterns(List<String> patterns) {
    Set<String> classes = new HashSet<>();

    if (patterns == null || patterns.isEmpty()) {
      return classes;
    }

    List<Pattern> compiledPatterns = patterns.stream()
        .map(p -> Pattern.compile(p.replace(".", "\\.").replace("*", ".*")))
        .collect(java.util.stream.Collectors.toList());

    for (ClassInfo classInfo : index.getKnownClasses()) {
      String className = classInfo.name().toString();
      for (Pattern pattern : compiledPatterns) {
        if (pattern.matcher(className).matches()) {
          classes.add(className);
          break;
        }
      }
    }

    return classes;
  }
}
