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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 16)
@LoadKubernetesManifests("/rawclusterscopedcustomresource-it.yml")
class GenericClusterScopedCustomResourceIT {

  static KubernetesClient client;

  private final CustomResourceDefinitionContext customResourceDefinitionContext = new CustomResourceDefinitionContext.Builder()
      .withVersion("v1alpha1")
      .withScope("Cluster")
      .withGroup("demos.fabric8.io")
      .withPlural("satellites")
      .build();

  @BeforeAll
  public static void initCrd() {
    // Wait for CRD to be deployed and ready
    client.apiextensions().v1().customResourceDefinitions()
        .withName("satellites.demos.fabric8.io")
        .waitUntilCondition(
            c -> c != null && c.getStatus() != null && c.getStatus().getConditions() != null
                && c.getStatus().getConditions().stream()
                    .anyMatch(crdc -> crdc.getType().equals("Established") && crdc.getStatus().equals("True")),
            10L, TimeUnit.SECONDS);
  }

  @Test
  void testCrud() {
    // Create
    GenericKubernetesResource satellite = createSatellite("moon", "earth", "1.7371e+3", "7.34767309e+22");
    GenericKubernetesResource createdSatellite = client.genericKubernetesResources(customResourceDefinitionContext)
        .create(satellite);

    assertThat(createdSatellite)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "moon");

    // Get
    GenericKubernetesResource satelliteFromServer = client.genericKubernetesResources(customResourceDefinitionContext)
        .withName("moon").get();
    assertThat(satelliteFromServer).isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "moon");

    // List
    GenericKubernetesResourceList satellites = client.genericKubernetesResources(customResourceDefinitionContext).list();
    assertThat(satellites).isNotNull();
    assertThat(satellites.getItems()).hasSize(1);

    // Delete
    boolean isDeleted = client.genericKubernetesResources(customResourceDefinitionContext).withName("moon").delete()
        .size() == 1;
    assertThat(isDeleted).isTrue();
  }

  private GenericKubernetesResource createSatellite(String name, String planet, String radius, String mass) {
    Map<String, Object> crAsMap = new HashMap<>();
    crAsMap.put("apiVersion", "demos.fabric8.io/v1alpha1");
    crAsMap.put("kind", "Satellite");

    Map<String, Object> crMetadata = new HashMap<>();
    crMetadata.put("name", name);
    crMetadata.put("labels", Collections.singletonMap("foo", "bar"));
    Map<String, Object> crSpec = new HashMap<>();
    crSpec.put("planet", planet);
    crSpec.put("radius", radius);
    crSpec.put("mass", mass);

    crAsMap.put("metadata", crMetadata);
    crAsMap.put("spec", crSpec);

    return Serialization.jsonMapper().convertValue(crAsMap, GenericKubernetesResource.class);
  }
}
