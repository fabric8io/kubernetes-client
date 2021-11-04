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
package io.fabric8.volcano.test;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.QuantityBuilder;
import io.fabric8.volcano.client.VolcanoClient;
import io.fabric8.volcano.scheduling.v1beta1.*;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupBuilder;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupSpecBuilder;
import io.fabric8.volcano.scheduling.v1beta1.QueueBuilder;
import io.fabric8.volcano.server.mock.EnableVolcanoMockClient;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableVolcanoMockClient(crud = true)
class VolcanoTest {
  VolcanoClient client;
  String TEST_GROUP_NAME = "group1";
  String TEST_NAMESPACE_NAME = "ns1";
  String TEST_CPU_NUM = "1";
  String TEST_MEMORY = "1024";

  @Test
  void testPodGroupWithMetaAndSpec() {

    Quantity cpu = new QuantityBuilder(false)
      .withAmount("1")
      .build();
    Quantity memory = new QuantityBuilder(false)
      .withAmount(TEST_MEMORY + "Mi")
      .build();
    Map<String, Quantity> resourceMap = new HashMap<>();
    resourceMap.put("cpu", cpu);
    resourceMap.put("memory", memory);

    // Create PodGroup with metadata and spec
    PodGroup podGroup = new PodGroupBuilder()
      .editOrNewMetadata()
        .withName(TEST_GROUP_NAME)
        .withNamespace(TEST_NAMESPACE_NAME)
      .endMetadata()
      .editOrNewSpec()
        .withMinResources(resourceMap)
      .endSpec()
      .build();
    client.PodGroups().inNamespace(TEST_NAMESPACE_NAME).create(podGroup);

    // Check podgroup
    PodGroupList podGroupList = client.PodGroups().inNamespace(TEST_NAMESPACE_NAME).list();
    assertNotNull(podGroupList);
    assertEquals(1, podGroupList.getItems().size());

    PodGroup group1 = podGroupList.getItems().get(0);
    // Check name and namespace in metadata
    assertEquals(TEST_GROUP_NAME, group1.getMetadata().getName());
    assertEquals(TEST_NAMESPACE_NAME, group1.getMetadata().getNamespace());
    // Check cpu/memory amount in spec
    assertEquals(TEST_CPU_NUM, group1.getSpec().getMinResources().get("cpu").getAmount());
    assertEquals(TEST_MEMORY, group1.getSpec().getMinResources().get("memory").getAmount());
  }

  @Test
  void testQueue() {
    Queue queue = new QueueBuilder()
      .editOrNewMetadata()
        .withName("queue1")
      .endMetadata()
      .build();
    client.Queues().inNamespace("ns1").create(queue);

    QueueList queueList = client.Queues().inNamespace("ns1").list();
    assertNotNull(queueList);
    assertEquals(1, queueList.getItems().size());
  }
}
