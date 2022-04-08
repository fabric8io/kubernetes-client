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

import io.fabric8.commons.ReadyEntity;
import io.fabric8.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(Route.class)
class RouteIT {

  static OpenShiftClient client;

  Namespace namespace;

  private Route route1;

  private String currentNamespace;

  @BeforeAll
  public static void init() {
    client.load(RouteIT.class.getResourceAsStream("/route-it.yml")).create();
  }

  @BeforeEach
  public void before() {
    currentNamespace = namespace.getMetadata().getName();
  }

  @Test
  void load() {
    Route aRoute = client.routes().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-route.yml")).get();
    assertThat(aRoute).isNotNull();
    assertEquals("host-route", aRoute.getMetadata().getName());
  }

  @Test
  void get() {
    route1 = client.routes().inNamespace(currentNamespace).withName("route-get").get();
    assertNotNull(route1);
  }

  @Test
  void list() {
    RouteList aRouteList = client.routes().inNamespace(currentNamespace).list();
    assertThat(aRouteList).isNotNull();
    assertTrue(aRouteList.getItems().size() >= 1);
  }

  @Test
  void update() {
    ReadyEntity<Route> route1Ready = new ReadyEntity<>(Route.class, client, "route-update", this.currentNamespace);
    route1 = client.routes().inNamespace(currentNamespace).withName("route-update").edit(r -> new RouteBuilder (r)
                   .editSpec().withPath("/test").endSpec().build());
    await().atMost(30, TimeUnit.SECONDS).until(route1Ready);
    assertThat(route1).isNotNull();
    assertEquals("/test", route1.getSpec().getPath());
  }

  @Test
  void delete() {
    ReadyEntity<Route> route1Ready = new ReadyEntity<>(Route.class, client, "route-delete", this.currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(route1Ready);
    boolean bDeleted = client.routes().inNamespace(currentNamespace).withName("route-delete").delete();
    assertTrue(bDeleted);
  }

  @Test
  void createOrReplace() {
    // Given
    Route route = client.routes().inNamespace(currentNamespace).withName("route-createorreplace").get();

    // When
    route.getMetadata().setAnnotations(Collections.singletonMap("foo", "bar"));
    route.getSpec().setHost("test.fabric8.io");
    route = client.routes().inNamespace(currentNamespace).createOrReplace(route);

    // Then
    assertNotNull(route);
    assertEquals("route-createorreplace", route.getMetadata().getName());
    assertEquals("bar", route.getMetadata().getAnnotations().get("foo"));
    assertEquals("test.fabric8.io", route.getSpec().getHost());
  }

}
