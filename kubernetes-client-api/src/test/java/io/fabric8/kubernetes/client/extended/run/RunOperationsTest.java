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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RunOperationsTest {

  @Test
  void testConvertRunConfigIntoPod() {
    // Given
    Map<String, Quantity> limits = new HashMap<>();
    limits.put("cpu", new Quantity("200m"));
    limits.put("memory", new Quantity("512Mi"));
    Map<String, Quantity> requests = new HashMap<>();
    requests.put("memory", new Quantity("64Mi"));
    requests.put("cpu", new Quantity("150m"));
    Map<String, String> labels = new HashMap<>();
    labels.put("first", "FIRST");
    labels.put("second", "SECOND");
    RunConfigBuilder generatorRunConfig = new RunConfigBuilder()
        .withName("test")
        .withImage("test:latest")
        .withLabels(labels)
        .withEnv(Collections.singletonMap("TEST_KEY", "TEST_VALUE"))
        .withImagePullPolicy("IfNotPresent")
        .withRestartPolicy("OnFailure")
        .withServiceAccount("ribbon")
        .withPort(5701)
        .withLimits(limits)
        .withRequests(requests);
    RunOperations deploymentGenerator = new RunOperations(Mockito.mock(KubernetesClient.class), generatorRunConfig.build());

    // When
    Pod pod = deploymentGenerator.convertRunConfigIntoPod();

    // Then
    assertNotNull(pod);
    assertEquals("test", pod.getMetadata().getName());
    assertEquals("FIRST", pod.getMetadata().getLabels().get("first"));
    assertEquals("SECOND", pod.getMetadata().getLabels().get("second"));
    assertEquals("test", pod.getMetadata().getLabels().get("run"));
    assertNotNull(pod.getSpec());
    assertEquals("OnFailure", pod.getSpec().getRestartPolicy());
    assertEquals("ribbon", pod.getSpec().getServiceAccountName());
    assertEquals("test", pod.getSpec().getContainers().get(0).getName());
    assertEquals("IfNotPresent", pod.getSpec().getContainers().get(0).getImagePullPolicy());
    assertEquals("test:latest", pod.getSpec().getContainers().get(0).getImage());
    assertEquals(1, pod.getSpec().getContainers().get(0).getEnv().size());
    assertEquals(1, pod.getSpec().getContainers().get(0).getPorts().size());
    assertEquals(5701, pod.getSpec().getContainers().get(0).getPorts().get(0).getContainerPort());
    assertEquals("TEST_KEY", pod.getSpec().getContainers().get(0).getEnv().get(0).getName());
    assertEquals("TEST_VALUE", pod.getSpec().getContainers().get(0).getEnv().get(0).getValue());
    assertEquals(new Quantity("200m"), pod.getSpec().getContainers().get(0).getResources().getLimits().get("cpu"));
    assertEquals(new Quantity("512Mi"), pod.getSpec().getContainers().get(0).getResources().getLimits().get("memory"));
    assertEquals(new Quantity("150m"), pod.getSpec().getContainers().get(0).getResources().getRequests().get("cpu"));
    assertEquals(new Quantity("64Mi"), pod.getSpec().getContainers().get(0).getResources().getRequests().get("memory"));
  }
}
