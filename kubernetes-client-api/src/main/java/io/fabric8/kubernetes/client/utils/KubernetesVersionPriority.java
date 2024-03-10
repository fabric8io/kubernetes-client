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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.fabric8.kubernetes.client.utils.KubernetesVersionFactory.Version;

/**
 * A utility class that allows to deal with Kubernetes versions and their priorities.
 *
 * The kubernetes specs v1.28 at <a href=
 * "https://v1-28.docs.kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definition-versioning/#version-priority">Version
 * Priority</a>
 * state the following:
 * <ul>
 * <li>Entries that follow Kubernetes version patterns are sorted before those that do not.</li>
 * <li>For entries that follow Kubernetes version patterns, the numeric portions of the version string is sorted largest to
 * smallest.</li>
 * <li>If the strings beta or alpha follow the first numeric portion, they sorted in that order, after the equivalent string
 * without the beta
 * or alpha suffix (which is presumed to be the GA version).</li>
 * <li>If another number follows the beta, or alpha, those numbers are also sorted from largest to smallest.</li>
 * <li>Strings that don’t fit the above format are sorted alphabetically and the numeric portions are not treated specially.
 * Notice that in the example below, foo1 is sorted above foo10.
 * This is different from the sorting of the numeric portion of entries that do follow the Kubernetes version patterns.</li>
 * </ul>
 *
 * @see KubernetesVersionFactory.KubernetesVersion#compareTo(Version)
 * @see KubernetesVersionFactory.NonKubernetesVersion#compareTo(Version)
 */
public class KubernetesVersionPriority {

  private KubernetesVersionPriority() {
  }

  /**
   * Returns the version with the highest priority for the given list of versions.
   *
   * @param versions the versions to pick the version with the highest priority from
   * @return the version with the highest priority
   * @see CustomResourceDefinitionVersion#getName()
   * @see CustomResourceDefinitionSpec#getVersions()
   * @see KubernetesVersionPriority
   */
  public static String highestPriority(List<String> versions) {
    List<Version> byPriority = sortByPriority(versions);
    if (byPriority.isEmpty()) {
      return null;
    }
    return byPriority.get(0).getFull();
  }

  private static List<Version> sortByPriority(List<String> versions) {
    if (versions == null || versions.isEmpty()) {
      return Collections.emptyList();
    }
    return versions.stream()
        .map(KubernetesVersionFactory::create)
        .sorted(Collections.reverseOrder())
        .collect(Collectors.toList());
  }

  /**
   * Returns a sorted list of resources, for example, {@link CustomResourceDefinitionVersion}s,
   * ordered from highest to lowest priority.
   *
   * @param resources the resources to sort
   * @param versionProvider a function to provide the version from the resource
   * @param <T> the resource type
   * @return the sorted list of resources
   * @see CustomResourceDefinitionVersion#getName()
   * @see CustomResourceDefinitionSpec#getVersions()
   * @see KubernetesVersionPriority
   */
  public static <T> List<T> sortByPriority(List<T> resources, Function<T, String> versionProvider) {
    Utils.checkNotNull(versionProvider, "versionProvider function can't be null");
    if (resources == null || resources.isEmpty()) {
      return Collections.emptyList();
    }

    return resources.stream()
        .sorted(Comparator.comparing(o -> KubernetesVersionFactory.create(versionProvider.apply(o)), Comparator.reverseOrder()))
        .collect(Collectors.toList());
  }
}
