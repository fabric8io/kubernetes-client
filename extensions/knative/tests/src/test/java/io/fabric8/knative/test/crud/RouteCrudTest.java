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
import io.fabric8.knative.serving.v1.Route;
import io.fabric8.knative.serving.v1.RouteBuilder;
import io.fabric8.knative.serving.v1.RouteList;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
class RouteCrudTest {

  KnativeClient client;

  @Test
  void shouldReturnEmptyList() {
    // Given

    // When
    RouteList RouteList = client.routes().inNamespace("ns1").list();

    // Then
    assertNotNull(RouteList);
    assertTrue(RouteList.getItems().isEmpty());
  }

  @Test
  void shouldListAndGetRoute() {
    // Given

    Route Route2 = new RouteBuilder().withNewMetadata().withName("Route2").endMetadata()
        .withNewSpec()
        .addNewTraffic()
        .withConfigurationName("greeter").withPercent(new Long(100l))
        .endTraffic()
        .endSpec()
        .build();

    // When
    client.routes().inNamespace("ns2").create(Route2);
    RouteList RouteList = client.routes().inNamespace("ns2").list();

    // Then
    assertNotNull(RouteList);
    assertEquals(1, RouteList.getItems().size());
    Route Route = client.routes().inNamespace("ns2").withName("Route2").get();
    assertNotNull(Route);
    assertEquals("Route2", Route.getMetadata().getName());
  }

  @Test
  void shouldDeleteARoute() {
    // Given

    Route route3 = new RouteBuilder().withNewMetadata().withName("route3").endMetadata().build();
    client.routes().inNamespace("ns3").create(route3);

    // When
    boolean deleted = client.routes().inNamespace("ns3").withName("route3").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }
}
