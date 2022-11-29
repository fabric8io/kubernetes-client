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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class GenerationTest {

  private final static String NAMESPACE = "test-namespace";

  KubernetesClient client;

  @Test
  void testCreatedObjectHasGeneration() {
    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata()
        .withName("test-configmap-created")
        .withNamespace(NAMESPACE)
        .endMetadata()
        .build();

    assertNull(configMap.getMetadata().getGeneration());
    configMap = client.configMaps().inNamespace(NAMESPACE).createOrReplace(configMap);
    assertEquals(1L, configMap.getMetadata().getGeneration());
  }

  @Test
  void testUpdatedSpecIncrementsGeneration() {
    final ConfigMap original = new ConfigMapBuilder()
        .withNewMetadata()
        .withName("test-configmap-updated")
        .withNamespace(NAMESPACE)
        .endMetadata()
        .build();
    final ConfigMapBuilder inServer = new ConfigMapBuilder(
        client.configMaps().inNamespace(NAMESPACE).createOrReplace(original));
    inServer.addToData("key", "value");

    final ConfigMap result = client.configMaps().inNamespace(NAMESPACE).createOrReplace(inServer.build());
    assertEquals(2L, result.getMetadata().getGeneration());
  }

  @Test
  void testUpdatingMetadataDoesNotIncrementGeneration() {
    final ConfigMap original = new ConfigMapBuilder()
        .withNewMetadata()
        .withName("test-configmap-updated-metadata")
        .withNamespace(NAMESPACE)
        .endMetadata()
        .build();
    final ConfigMapBuilder inServer = new ConfigMapBuilder(
        client.configMaps().inNamespace(NAMESPACE).createOrReplace(original));

    inServer.editMetadata().addToAnnotations("new-annotation", "new-value");

    final ConfigMap result = client.configMaps().inNamespace(NAMESPACE).createOrReplace(inServer.build());
    assertEquals(1L, result.getMetadata().getGeneration());
  }

}
