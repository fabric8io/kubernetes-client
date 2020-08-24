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

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GeneratorRunConfigUtilTest {
  @Test
  void testGetObjectMetadataFromRunConfig() {
    // Given
    GeneratorRunConfig config = new GeneratorRunConfigBuilder()
      .withName("test")
      .withLabels(Collections.singletonMap("foo", "bar"))
      .build();

    // When
    ObjectMeta objectMeta = GeneratorRunConfigUtil.getObjectMetadataFromRunConfig(config);

    // Then
    assertNotNull(objectMeta);
    assertEquals("test", objectMeta.getName());
    assertFalse(objectMeta.getLabels().isEmpty());
    assertEquals("bar", objectMeta.getLabels().get("foo"));
  }

  @Test
  void testGetPodSpecFromRunConfig() {
    // Given
    GeneratorRunConfig config = new GeneratorRunConfigBuilder()
      .withName("test")
      .withImage("test:latest")
      .withEnv(Collections.singletonMap("TEST_KEY", "TEST_VALUE"))
      .withImagePullPolicy("IfNotPresent")
      .withLimits(getLimits())
      .build();

    // When
    PodSpec podSpec = GeneratorRunConfigUtil.getPodSpecFromRunConfig(config);

    // Then
    assertNotNull(podSpec);
    assertNotNull(podSpec.getContainers());
    assertEquals(1, podSpec.getContainers().size());
    assertEquals("test", podSpec.getContainers().get(0).getName());
    assertEquals("IfNotPresent", podSpec.getContainers().get(0).getImagePullPolicy());
    assertEquals("test:latest", podSpec.getContainers().get(0).getImage());
    assertEquals(1, podSpec.getContainers().get(0).getEnv().size());
    assertEquals("TEST_KEY", podSpec.getContainers().get(0).getEnv().get(0).getName());
    assertEquals("TEST_VALUE", podSpec.getContainers().get(0).getEnv().get(0).getValue());
  }

  @Test
  void testGetContainersFromRunConfig() {
    // Given
    GeneratorRunConfig config = getCompleteGeneratorRunConfig();

    // When
    Container container = GeneratorRunConfigUtil.getContainersFromRunConfig(config);

    // Then
    assertNotNull(container);
    assertEquals("test", container.getName());
    assertEquals("IfNotPresent", container.getImagePullPolicy());
    assertEquals("test:latest", container.getImage());
    assertEquals(1, container.getEnv().size());
    assertEquals(1, container.getPorts().size());
    assertEquals(5701, container.getPorts().get(0).getContainerPort());
    assertEquals("TEST_KEY", container.getEnv().get(0).getName());
    assertEquals("TEST_VALUE", container.getEnv().get(0).getValue());
    assertEquals(new Quantity("200m"), container.getResources().getLimits().get("cpu"));
    assertEquals(new Quantity("512Mi"), container.getResources().getLimits().get("memory"));
    assertEquals(new Quantity("150m"), container.getResources().getRequests().get("cpu"));
    assertEquals(new Quantity("64Mi"), container.getResources().getRequests().get("memory"));
  }


  private Map<String, Quantity> getLimits() {
    Map<String, Quantity> limits = new HashMap<>();
    limits.put("cpu", new Quantity("200m"));
    limits.put("memory", new Quantity("512Mi"));
    return limits;
  }

  private Map<String, Quantity> getRequests() {
    Map<String, Quantity> requests = new HashMap<>();
    requests.put("memory", new Quantity("64Mi"));
    requests.put("cpu", new Quantity("150m"));
    return requests;
  }

  private GeneratorRunConfig getCompleteGeneratorRunConfig() {
    return new GeneratorRunConfigBuilder()
      .withName("test")
      .withImage("test:latest")
      .withReplicas(1)
      .withEnv(Collections.singletonMap("TEST_KEY", "TEST_VALUE"))
      .withImagePullPolicy("IfNotPresent")
      .withPort(5701)
      .withLimits(getLimits())
      .withRequests(getRequests())
      .build();
  }
}
