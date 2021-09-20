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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;

@EnableKubernetesMockClient
class GenerationTest {

  private final static String NAMESPACE = "test-namespace";

  KubernetesMockServer server;
  KubernetesClient client;
  
  @Test
  public void testCreatedObjectHasGeneration() {
    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata()
        .withName("test-configmap")
        .withNamespace(NAMESPACE)
        .endMetadata()
        .build();

    assertNull(configMap.getMetadata().getGeneration());
    configMap = client.configMaps().inNamespace(NAMESPACE).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 1L);
  }

  @Test
  public void testUpdatedSpecIncrementsGeneration() {
    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata()
        .withName("test-configmap")
        .withNamespace(NAMESPACE)
        .endMetadata()
        .build();

    configMap = client.configMaps().inNamespace(NAMESPACE).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 1L);

    Map<String, String> configMapData = new HashMap<>();
    configMapData.put("key", "value");
    configMap.setData(configMapData);

    configMap = client.configMaps().inNamespace(NAMESPACE).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 2L);
  }

  @Test
  public void testUpdatingMetadataDoesNotIncrementGeneration() {
    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata()
        .withName("test-configmap")
        .withNamespace(NAMESPACE)
        .endMetadata()
        .build();

    configMap = client.configMaps().inNamespace(NAMESPACE).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 1L);

    configMap.getMetadata().getAnnotations().put("new-annotation", "new-value");

    configMap = client.configMaps().inNamespace(NAMESPACE).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 1L);
  }

}
