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
package io.fabric8.servicecatalog.test.crud;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.servicecatalog.api.model.ClusterServiceBroker;
import io.fabric8.servicecatalog.api.model.ClusterServiceBrokerBuilder;
import io.fabric8.servicecatalog.api.model.ClusterServiceBrokerList;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class ClusterServiceBrokerTest {

  ServiceCatalogClient client;

  @Test
  void testCrud() {

    ClusterServiceBroker broker1 = new ClusterServiceBrokerBuilder()
        .withNewMetadata()
        .withName("broker1")
        .addToLabels("key1", "value1")
        .endMetadata()
        .withNewSpec()
        .withUrl("https://broker1.somewhere.com")
        .endSpec()
        .build();

    ClusterServiceBroker broker2 = new ClusterServiceBrokerBuilder()
        .withNewMetadata()
        .withName("broker2")
        .addToLabels("key2", "value2")
        .endMetadata()
        .withNewSpec()
        .withUrl("https://broker2.somewhere.com")
        .endSpec()
        .build();

    ClusterServiceBroker broker3 = new ClusterServiceBrokerBuilder()
        .withNewMetadata()
        .withName("broker3")
        .addToLabels("key3", "value3")
        .endMetadata()
        .withNewSpec()
        .withUrl("https://broker3.somewhere.com")
        .endSpec()
        .build();

    //Create
    client.clusterServiceBrokers().create(broker1);
    client.clusterServiceBrokers().create(broker2);
    client.clusterServiceBrokers().create(broker3);

    //Read
    ClusterServiceBrokerList brokers = client.clusterServiceBrokers().list();
    assertNotNull(brokers);
    assertEquals(3, brokers.getItems().size());

    ClusterServiceBroker r1 = client.clusterServiceBrokers().withName("broker1").get();
    assertNotNull(r1);

    //Update
    ClusterServiceBroker u1 = client.clusterServiceBrokers().withName("broker1").edit(c -> new ClusterServiceBrokerBuilder(c)
        .editMetadata()
        .addToLabels("updated", "true")
        .endMetadata()
        .build());

    assertNotNull(u1);
    assertEquals("true", u1.getMetadata().getLabels().get("updated"));

    //Delete
    assertEquals(1, client.clusterServiceBrokers().withName("broker1").delete().size());
    assertNull(client.clusterServiceBrokers().withName("broker1").get());
  }
}
