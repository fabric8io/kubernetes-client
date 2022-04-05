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
package io.fabric8.knative.test.crud;

import io.fabric8.knative.client.KnativeClient;
import io.fabric8.knative.serving.v1.Service;
import io.fabric8.knative.serving.v1.ServiceBuilder;
import io.fabric8.knative.serving.v1.ServiceList;
import io.fabric8.knative.serving.v1.ServiceStatusBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
class ServiceCrudTest {

  KnativeClient client;

  @Test
  void shouldReturnEmptyList() {

    ServiceList serviceList = client.services().inNamespace("ns1").list();
    assertNotNull(serviceList);
    assertTrue(serviceList.getItems().isEmpty());
  }

  @Test
  void shouldListAndGetService() {

    Service service2 = new ServiceBuilder().withNewMetadata().withName("service2").endMetadata().build();

    client.services().inNamespace("ns2").create(service2);
    ServiceList serviceList = client.services().inNamespace("ns2").list();
    assertNotNull(serviceList);
    assertEquals(1, serviceList.getItems().size());
    Service service = client.services().inNamespace("ns2").withName("service2").get();
    assertNotNull(service);
    assertEquals("service2", service.getMetadata().getName());
  }

  @Test
  void shouldIncludeServiceStatus() {

    Service service = new ServiceBuilder()
        .withNewMetadata().withName("service").endMetadata()
        .build();

    Service created = client.services().inNamespace("ns2").create(service);

    ServiceList serviceList = client.services().inNamespace("ns2").list();
    assertNotNull(serviceList);
    assertEquals(1, serviceList.getItems().size());

    created.setStatus(new ServiceStatusBuilder().withNewAddress("http://my-service").build());

    assertNotNull(client.services().inNamespace("ns2").withName("service").updateStatus(created).getStatus());
  }

  @Test
  void shouldDeleteAService() {

    Service service3 = new ServiceBuilder().withNewMetadata().withName("service3").endMetadata().build();

    client.services().inNamespace("ns3").create(service3);
    boolean deleted = client.services().inNamespace("ns3").withName("service3").delete().size() == 1;
    assertTrue(deleted);
  }
}
