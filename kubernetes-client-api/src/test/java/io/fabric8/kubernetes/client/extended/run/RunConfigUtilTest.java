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
package io.fabric8.kubernetes.client.extended.run;

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RunConfigUtilTest {
  @Test
  void testGetObjectMetadataFromRunConfig() {
    // Given
    RunConfig config = new RunConfigBuilder()
        .withName("test")
        .withLabels(Collections.singletonMap("foo", "bar"))
        .build();

    // When
    ObjectMeta objectMeta = RunConfigUtil.getObjectMetadataFromRunConfig(config);

    // Then
    assertNotNull(objectMeta);
    assertEquals("test", objectMeta.getName());
    assertFalse(objectMeta.getLabels().isEmpty());
    assertEquals("bar", objectMeta.getLabels().get("foo"));
  }

  @Test
  void testGetPodSpecFromRunConfig() {
    // Given
    RunConfig config = new RunConfigBuilder()
        .withName("test")
        .withImage("test:latest")
        .withEnv(Collections.singletonMap("TEST_KEY", "TEST_VALUE"))
        .withImagePullPolicy("IfNotPresent")
        .withLimits(getLimits())
        .build();

    // When
    PodSpec podSpec = RunConfigUtil.getPodSpecFromRunConfig(config);

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
  void testContainerFromConfig() {
    // Given
    RunConfig config = initMockRunConfigBuilder().build();

    // When
    Container container = RunConfigUtil.containerFromConfig(config);

    // Then
    assertNotNull(container);
    assertEquals("test", container.getName());
    assertEquals("IfNotPresent", container.getImagePullPolicy());
    assertEquals("test:latest", container.getImage());
    assertEquals(Collections.emptyList(), container.getArgs());
    assertEquals(Collections.emptyList(), container.getCommand());
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

  @Test
  void testContainerFromConfigWithArgs() {
    // Given
    final RunConfig runConfig = initMockRunConfigBuilder()
        .withArgs("arg1", "arg2")
        .build();
    // When
    final Container result = RunConfigUtil.containerFromConfig(runConfig);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("command", Collections.emptyList())
        .extracting(Container::getArgs)
        .asList().containsExactly("arg1", "arg2");
  }

  @Test
  void testContainerFromConfigWithCommand() {
    // Given
    final RunConfig runConfig = initMockRunConfigBuilder()
        .withCommand("/bin/sh")
        .build();
    // When
    final Container result = RunConfigUtil.containerFromConfig(runConfig);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("args", Collections.emptyList())
        .extracting(Container::getCommand)
        .asList().containsExactly("/bin/sh");
  }

  @Test
  void testContainerFromConfigWithCommandAndArgs() {
    // Given
    final RunConfig runConfig = initMockRunConfigBuilder()
        .withCommand("/bin/sh")
        .withArgs("-c", "echo hello")
        .build();
    // When
    final Container result = RunConfigUtil.containerFromConfig(runConfig);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("args", Collections.emptyList())
        .extracting(Container::getCommand)
        .asList().containsExactly("/bin/sh", "-c", "echo hello");
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

  private RunConfigBuilder initMockRunConfigBuilder() {
    return new RunConfigBuilder()
        .withName("test")
        .withImage("test:latest")
        .withEnv(Collections.singletonMap("TEST_KEY", "TEST_VALUE"))
        .withImagePullPolicy("IfNotPresent")
        .withPort(5701)
        .withLimits(getLimits())
        .withRequests(getRequests());
  }
}
