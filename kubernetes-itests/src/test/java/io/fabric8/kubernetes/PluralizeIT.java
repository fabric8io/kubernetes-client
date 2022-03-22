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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.Pluralize;
import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIResource;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.GroupVersionForDiscovery;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.internal.OperationSupport;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

// Not running with Arquillian because I want to make it parameterized.
// We should probably remove Arquillian anyway so we can update this module to JUnit 5.
@RunWith(Parameterized.class)
public class PluralizeIT {

  @Parameterized.Parameters(name = "{index} {0}: ''{1}'' plural is ''{2}''")
  public static Collection<Object[]> parameters() {
    if (!ClusterEntity.kubernetesVersionAtLeast("1", "16")) {
      return Collections.emptyList();
    }
    final List<APIResource> testCases;
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      // Core Resources
      testCases = new ArrayList<>(new OperationSupport(client)
        .restCall(APIResourceList.class, "api/v1").getResources());
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
      .map(ar -> new Object[]{
        ar.getKind(),
        // So far singularName field is always blank, we fall back to lower-cased kind
        Utils.isNullOrEmpty(ar.getSingularName()) ? ar.getKind().toLowerCase(Locale.ROOT) : ar.getSingularName(),
        ar.getName()
      })
      .collect(Collectors.toList());
  }

  @Parameterized.Parameter
  public String kind;

  @Parameterized.Parameter(1)
  public String singular;

  @Parameterized.Parameter(2)
  public String plural;

  @Test
  public void toPlural() {
    assertEquals(plural, Pluralize.toPlural(singular));
  }
}
