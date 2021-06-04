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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.awaitility.Awaitility.await;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class RouteIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  private Route route1;

  private String currentNamespace;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(RouteIT.class.getResourceAsStream("/route-it.yml"));
  }

  @Test
  public void load() {
    Route aRoute = client.routes().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-route.yml")).get();
    assertThat(aRoute).isNotNull();
    assertEquals("host-route", aRoute.getMetadata().getName());
  }

  @Test
  public void get() {
    route1 = client.routes().inNamespace(currentNamespace).withName("route-get").get();
    assertNotNull(route1);
  }

  @Test
  public void list() {
    RouteList aRouteList = client.routes().inNamespace(currentNamespace).list();
    assertThat(aRouteList).isNotNull();
    assertTrue(aRouteList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReadyEntity<Route> route1Ready = new ReadyEntity<>(Route.class, client, "route-update", this.currentNamespace);
    route1 = client.routes().inNamespace(currentNamespace).withName("route-update").edit(r -> new RouteBuilder (r)
                   .editSpec().withPath("/test").endSpec().build());
    await().atMost(30, TimeUnit.SECONDS).until(route1Ready);
    assertThat(route1).isNotNull();
    assertEquals("/test", route1.getSpec().getPath());
  }

  @Test
  public void delete() {
    ReadyEntity<Route> route1Ready = new ReadyEntity<>(Route.class, client, "route-delete", this.currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(route1Ready);
    boolean bDeleted = client.routes().inNamespace(currentNamespace).withName("route-delete").delete();
    assertTrue(bDeleted);
  }

  @Test
  public void createOrReplace() {
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
