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

package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient(crud = true)
class RouteCrudTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void testCrud() {

    Route route1 = new RouteBuilder().withNewMetadata().withName("route1")
        .addToLabels("foo", "bar")
        .and().build();
    Route route2 = new RouteBuilder().withNewMetadata().withName("route2")
        .addToLabels("foo", "bar")
        .and().build();
    Route route3 = new RouteBuilder().withNewMetadata().withName("route3")
        .addToLabels("foo", "bar")
        .and().build();

    client.routes().inNamespace("ns1").create(route1);
    client.routes().inNamespace("ns1").create(route2);
    client.routes().inNamespace("ns2").create(route3);

    RouteList aRouteList = client.routes().list();
    assertNotNull(aRouteList);
    assertEquals(0, aRouteList.getItems().size());

    aRouteList = client.routes().inAnyNamespace().list();
    assertNotNull(aRouteList);
    assertEquals(3, aRouteList.getItems().size());

    aRouteList = client.routes().inNamespace("ns1").list();
    assertNotNull(aRouteList);
    assertEquals(2, aRouteList.getItems().size());

    aRouteList = client.routes().inAnyNamespace().withLabels(Collections.singletonMap("foo", "bar")).list();
    assertNotNull(aRouteList);
    assertEquals(3, aRouteList.getItems().size());

    boolean bDeleted = client.routes().inNamespace("ns1").delete().size() == 2;
    aRouteList = client.routes().inNamespace("ns1").list();
    assertTrue(bDeleted);
    assertEquals(0, aRouteList.getItems().size());
  }
}
