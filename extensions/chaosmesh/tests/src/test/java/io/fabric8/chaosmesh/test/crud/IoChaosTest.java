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
import io.fabric8.chaosmesh.v1alpha1.IOChaos;
import io.fabric8.chaosmesh.v1alpha1.IOChaosBuilder;
import io.fabric8.chaosmesh.v1alpha1.IOChaosList;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class IOChaosTest {

  ChaosMeshClient client;

  @Test
  void testCrud() {

    IOChaos ioc1 = new IOChaosBuilder()
        .withNewMetadata()
        .withName("partition")
        .addToLabels("key1", "value1")
        .endMetadata()
        .withNewSpec()
        .withAction("partition")
        .endSpec().build();
    IOChaos ioc2 = new IOChaosBuilder()
        .withNewMetadata()
        .withName("latency")
        .addToLabels("key1", "value1")
        .endMetadata()
        .withNewSpec()
        .withAction("latency")
        .withDelay("100ms")
        .withDuration("100s")
        .endSpec().build();

    //Create
    client.ioChaos().create(ioc1);
    client.ioChaos().create(ioc2);

    //Read
    IOChaosList vsList = client.ioChaos().list();
    assertNotNull(vsList);
    assertEquals(2, vsList.getItems().size());

    IOChaos s1 = client.ioChaos().withName("partition").get();
    assertNotNull(s1);

    //Update
    IOChaos u1 = client.ioChaos().withName("latency").edit(io -> new IOChaosBuilder(io)
        .editMetadata()
        .addToLabels("updated", "true")
        .endMetadata()
        .build());

    assertNotNull(u1);
    assertEquals("true", client.ioChaos().withName("latency").get().getMetadata().getLabels().get("updated"));

    //Delete
    assertEquals(1, client.ioChaos().withName("latency").delete().size());
    assertNull(client.ioChaos().withName("latency").get());
  }
}
