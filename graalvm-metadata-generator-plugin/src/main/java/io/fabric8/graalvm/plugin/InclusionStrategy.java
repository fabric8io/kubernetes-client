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

/**
 * Strategy for determining which classes should be included in GraalVM reflection configuration.
 */
public enum InclusionStrategy {
  /**
   * Include classes with Jackson annotations (@JsonDeserialize, @JsonProperty, @JsonSerialize, etc.)
   */
  JACKSON_ANNOTATIONS,

  /**
   * Include classes with Sundrio @Buildable annotation and generated builder classes
   */
  SUNDRIO_BUILDERS,

  /**
   * Include Kubernetes resource classes (HasMetadata implementations)
   */
  KUBERNETES_RESOURCES,

  /**
   * Combination of JACKSON_ANNOTATIONS, SUNDRIO_BUILDERS, and KUBERNETES_RESOURCES
   */
  COMPREHENSIVE,

  /**
   * Only use include/exclude patterns (no annotation-based detection)
   */
  PATTERN_BASED,

  /**
   * Include all public classes (use with caution - generates large config files)
   */
  ALL_PUBLIC_CLASSES,

  /**
   * Include only classes that directly extend java.lang.Object
   */
  DIRECT_OBJECT_SUBCLASSES
}
