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

import io.fabric8.commons.AssumingK8sVersionAtLeast;
import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class RawClusterScopedCustomResourceIT {
  @ArquillianResource
  public KubernetesClient client;

  @ArquillianResource
  public Session session;

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion = new AssumingK8sVersionAtLeast("1", "16");

  private final CustomResourceDefinitionContext customResourceDefinitionContext = new CustomResourceDefinitionContext.Builder()
    .withVersion("v1alpha1")
    .withScope("Cluster")
    .withGroup("demos.fabric8.io")
    .withPlural("satellites")
    .build();

  @BeforeClass
  public static void initCrd() {
    // Create a Custom Resource Definition Animals:
    ClusterEntity.apply(RawCustomResourceIT.class.getResourceAsStream("/rawclusterscopedcustomresource-it.yml"));
  }

  @Test
  public void testCrud() throws IOException {
    // Create
    Map<String, Object> satellite = createSatellite("moon", "earth", "1.7371e+3", "7.34767309e+22");
    Map<String, Object> createdSatellite = client.customResource(customResourceDefinitionContext).create(satellite);

    assertThat(createdSatellite)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", "moon");

    // Get
    Map<String, Object> satelliteFromServer = client.customResource(customResourceDefinitionContext).withName("moon").get();
    assertThat(satelliteFromServer).isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", "moon");

    // List
    Map<String, Object> satellites = client.customResource(customResourceDefinitionContext).list();
    assertThat(satellites).isNotNull();
    assertThat(satellites.get("items")).isInstanceOfAny(ArrayList.class);
    assertThat((ArrayList<Object>)satellites.get("items")).hasSize(1);

    // Delete
    Boolean isDeleted = client.customResource(customResourceDefinitionContext).withName("moon").delete();
    assertThat(isDeleted).isTrue();
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(RawCustomResourceIT.class.getResourceAsStream("/rawclusterscopedcustomresource-it.yml"));
  }

  private Map<String, Object> createSatellite(String name, String planet, String radius, String mass) {
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

    return crAsMap;
  }
}
