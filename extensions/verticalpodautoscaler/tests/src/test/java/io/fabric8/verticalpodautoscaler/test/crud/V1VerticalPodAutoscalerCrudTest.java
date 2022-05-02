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
package io.fabric8.verticalpodautoscaler.test.crud;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.verticalpodautoscaler.api.model.v1.VerticalPodAutoscaler;
import io.fabric8.verticalpodautoscaler.api.model.v1.VerticalPodAutoscalerBuilder;
import io.fabric8.verticalpodautoscaler.api.model.v1.VerticalPodAutoscalerList;
import io.fabric8.verticalpodautoscaler.client.VerticalPodAutoscalerClient;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
class V1VerticalPodAutoscalerCrudTest {
  VerticalPodAutoscalerClient client;

  @Test
  void shouldReturnEmptyList() {

    VerticalPodAutoscalerList verticalPodAutoscalerList = client.v1().verticalpodautoscalers().inNamespace("ns1").list();
    assertNotNull(verticalPodAutoscalerList);
    assertTrue(verticalPodAutoscalerList.getItems().isEmpty());
  }

  @Test
  void shouldListAndGetVerticalPodAutoscaler() {

    VerticalPodAutoscaler vpa2 = new VerticalPodAutoscalerBuilder().withNewMetadata().withName("vpa2").endMetadata().build();
    client.v1().verticalpodautoscalers().inNamespace("ns2").create(vpa2);
    VerticalPodAutoscalerList certificateList = client.v1().verticalpodautoscalers().inNamespace("ns2").list();
    assertNotNull(certificateList);
    assertEquals(1, certificateList.getItems().size());
  }

  @Test
  void shouldDeleteAVerticalPodAutoscaler() {

    VerticalPodAutoscaler vpa3 = new VerticalPodAutoscalerBuilder().withNewMetadata().withName("vpa3").endMetadata().build();
    client.v1().verticalpodautoscalers().inNamespace("ns3").create(vpa3);
    boolean deleted = client.v1().verticalpodautoscalers().inNamespace("ns3").withName("vpa3").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  void shouldLoadVerticalPodAutoscaler() {

    String certificateDefinition = String.join("\n", Arrays.asList(
        "apiVersion: autoscaling.k8s.io/v1",
        "kind: VerticalPodAutoscaler",
        "metadata:",
        "  name: my-app-vpa",
        "spec:",
        "  targetRef:",
        "    apiVersion: \"apps/v1\"",
        "    kind:       Deployment",
        "    name:       my-app",
        "  updatePolicy:",
        "    updateMode: \"Auto\"",
        "  resourcePolicy:",
        "    containerPolicies:",
        "      - containerName: container",
        "        controlledResources: [\"cpu\", \"memory\"]",
        "        controlledValues: RequestsOnly"));
    VerticalPodAutoscaler verticalPodAutoscaler = client.v1().verticalpodautoscalers().inNamespace("ns4")
        .load(new ByteArrayInputStream(certificateDefinition.getBytes())).createOrReplace();
    assertEquals("my-app-vpa", verticalPodAutoscaler.getMetadata().getName());
    assertEquals("my-app", verticalPodAutoscaler.getSpec().getTargetRef().getName());
    assertEquals("Auto", verticalPodAutoscaler.getSpec().getUpdatePolicy().getUpdateMode());
    assertEquals("container",
        verticalPodAutoscaler.getSpec().getResourcePolicy().getContainerPolicies().get(0).getContainerName());
    assertEquals(Arrays.asList("cpu", "memory"),
        verticalPodAutoscaler.getSpec().getResourcePolicy().getContainerPolicies().get(0).getControlledResources());
    assertEquals("RequestsOnly",
        verticalPodAutoscaler.getSpec().getResourcePolicy().getContainerPolicies().get(0).getControlledValues());
  }

}
