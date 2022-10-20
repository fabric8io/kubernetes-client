/**
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
import java.util.List;
import java.util.stream.Collectors;

import static io.fabric8.kubernetes.client.utils.KubernetesVersionFactory.Version;

/**
 * A util class that allows to deal with kubernetes versions.
 */
public class KubernetesVersionPriority {

  private KubernetesVersionPriority() {
  }

  /**
   * Returns the version with the highest priority for the given list of versions.
   *
   * @param versions the versions to pick the version with the highest priority from
   * @return the version with the highest priority
   *
   * @see CustomResourceDefinitionVersion#getName()
   * @see CustomResourceDefinitionSpec#getVersions()
   */
  public static String highestPriority(List<String> versions) {
    List<Version> byPriority = getByPriority(versions);
    if (byPriority.isEmpty()) {
      return null;
    }
    return byPriority.get(0).getFull();
  }

  private static List<Version> getByPriority(List<String> versions) {
    if (versions == null
        || versions.isEmpty()) {
      return Collections.emptyList();
    }
    return versions.stream()
        .map(KubernetesVersionFactory::create)
        .sorted(Collections.reverseOrder())
        .collect(Collectors.toList());
  }
}
