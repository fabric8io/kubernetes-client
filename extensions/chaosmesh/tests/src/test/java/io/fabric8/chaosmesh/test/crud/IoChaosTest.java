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
package io.fabric8.chaosmesh.test.crud;


import io.fabric8.chaosmesh.client.ChaosMeshClient;
import io.fabric8.chaosmesh.server.mock.EnableChaosMeshMockClient;
import io.fabric8.chaosmesh.v1alpha1.IoChaos;
import io.fabric8.chaosmesh.v1alpha1.IoChaosBuilder;
import io.fabric8.chaosmesh.v1alpha1.IoChaosList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableChaosMeshMockClient(crud = true)
class IoChaosTest {

  ChaosMeshClient client;
  @Test
  void testCrud() {

    IoChaos ioc1 = new IoChaosBuilder()
      .withNewMetadata()
      .withName("partition")
      .addToLabels("key1", "value1")
      .endMetadata()
      .withNewSpec()
      .withAction("partition")
      .withNewScheduler().withCron("@every 10m").endScheduler()
      .endSpec().build();
    IoChaos ioc2 = new IoChaosBuilder()
      .withNewMetadata()
      .withName("latency")
      .addToLabels("key1", "value1")
      .endMetadata()
      .withNewSpec()
      .withAction("latency")
      .withDelay("100ms")
      .withDuration("100s")
      .withNewScheduler().withCron("@every 10m").endScheduler()
      .endSpec().build();

    //Create
    client.ioChaos().create(ioc1);
    client.ioChaos().create(ioc2);

    //Read
    IoChaosList vsList = client.ioChaos().list();
    assertNotNull(vsList);
    assertEquals(2, vsList.getItems().size());

    IoChaos s1 = client.ioChaos().withName("partition").get();
    assertNotNull(s1);

    //Update
    IoChaos u1 = client.ioChaos().withName("latency").edit(io -> new IoChaosBuilder(io)
      .editMetadata()
      .addToLabels("updated", "true")
      .endMetadata()
      .build());

    assertNotNull(u1);
    assertEquals("true", client.ioChaos().withName("latency").get().getMetadata().getLabels().get("updated"));

    //Delete
    assertTrue(client.ioChaos().withName("latency").delete());
    assertNull(client.ioChaos().withName("latency").get());
  }
}
