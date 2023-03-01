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

package io.fabric8.openshift;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(Route.class)
@LoadKubernetesManifests("/route-it.yml")
class RouteIT {

  OpenShiftClient client;

  @Test
  void load() {
    Route aRoute = client.routes().load(getClass().getResourceAsStream("/test-route.yml")).item();
    assertThat(aRoute).isNotNull();
    assertEquals("host-route", aRoute.getMetadata().getName());
  }

  @Test
  void get() {
    final Route route1 = client.routes().withName("route-get").get();
    assertNotNull(route1);
  }

  @Test
  void list() {
    RouteList aRouteList = client.routes().list();
    assertThat(aRouteList).isNotNull();
    assertTrue(aRouteList.getItems().size() >= 1);
  }

  @Test
  void update() {
    final Route route = client.routes().withName("route-update").edit(r -> new RouteBuilder(r)
        .editMetadata().withResourceVersion(null).endMetadata()
        .editSpec().withPath("/test").endSpec().build());
    assertThat(route).isNotNull();
    assertEquals("/test", route.getSpec().getPath());
  }

  @Test
  void delete() {
    client.routes().withName("route-delete").waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    boolean bDeleted = client.routes().withName("route-delete").delete().size() == 1;
    assertTrue(bDeleted);
  }

  @Test
  void createOrReplace() {
    // Given
    Route route = client.routes().withName("route-createorreplace").get();

    // When
    route.getMetadata().setAnnotations(Collections.singletonMap("foo", "bar"));
    route.getSpec().setHost("test.fabric8.io");
    route = client.routes().createOrReplace(route);

    // Then
    assertNotNull(route);
    assertEquals("route-createorreplace", route.getMetadata().getName());
    assertEquals("bar", route.getMetadata().getAnnotations().get("foo"));
    assertEquals("test.fabric8.io", route.getSpec().getHost());
  }

}
