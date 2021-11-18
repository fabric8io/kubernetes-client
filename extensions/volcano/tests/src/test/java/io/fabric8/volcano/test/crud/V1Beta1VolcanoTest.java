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
package io.fabric8.volcano.test.crud;
import io.fabric8.volcano.client.VolcanoClient;
import io.fabric8.volcano.scheduling.v1beta1.*;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupBuilder;
import io.fabric8.volcano.scheduling.v1beta1.QueueBuilder;
import io.fabric8.volcano.server.mock.EnableVolcanoMockClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableVolcanoMockClient(crud = true)
class V1Beta1VolcanoTest {
  VolcanoClient client;

  @Test
  void testV1Beta1PodGroup() {
    PodGroup podGroup = new PodGroupBuilder()
      .editOrNewMetadata()
        .withName("Pod")
      .endMetadata()
      .build();
    client.v1beta1().podGroups().inNamespace("ns1").create(podGroup);

    PodGroupList podGroupList = client.v1beta1().podGroups().inNamespace("ns1").list();
    assertNotNull(podGroupList);
    assertEquals(1, podGroupList.getItems().size());
  }

  @Test
  void testV1Beta1Queue() {
    Queue queue = new QueueBuilder()
      .editOrNewMetadata()
        .withName("queue1")
      .endMetadata()
      .build();
    client.v1beta1().queues().inNamespace("ns1").create(queue);

    QueueList queueList = client.v1beta1().queues().inNamespace("ns1").list();
    assertNotNull(queueList);
    assertEquals(1, queueList.getItems().size());
  }
}
