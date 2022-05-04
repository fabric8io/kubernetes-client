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
package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.Pluralize;
import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIResource;
import io.fabric8.kubernetes.api.model.GroupVersionForDiscovery;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 16)
class PluralizeIT {

  @DisplayName("toPlural, should return argument's plural")
  @ParameterizedTest(name = "{index} {0}: ''{1}'' plural is ''{2}''")
  @MethodSource("toPluralInput")
  void toPlural(String kind, String singular, String plural) {
    assertEquals(plural, Pluralize.toPlural(singular));
  }

  static Stream<Arguments> toPluralInput() {
    final List<APIResource> testCases;
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      // Core Resources
      testCases = new ArrayList<>(client.getApiResources("v1").getResources());
      // Additional groups
      for (APIGroup group : client.getApiGroups().getGroups()) {
        for (GroupVersionForDiscovery version : group.getVersions()) {
          testCases.addAll(client.getApiResources(version.getGroupVersion()).getResources());
        }
      }
    }
    if (testCases.isEmpty()) {
      throw new IllegalStateException("No API resources found");
    }
    return testCases.stream()
        .filter(ar -> !ar.getName().contains("/"))
        .map(ar -> arguments(
            ar.getKind(),
            // So far singularName field is always blank, we fall back to lower-cased kind
            Utils.isNullOrEmpty(ar.getSingularName()) ? ar.getKind().toLowerCase(Locale.ROOT) : ar.getSingularName(),
            ar.getName()));
  }
}
