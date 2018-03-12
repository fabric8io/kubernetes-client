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

import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class RouteIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  private Route route1, route2;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    route1 = new RouteBuilder()
      .withNewMetadata().withName("route1").endMetadata()
      .withNewSpec().withHost("www.example.com").withNewTo().withKind("Service").withName("service-name1").endTo().endSpec()
      .build();
    route2 = new RouteBuilder()
      .withNewMetadata().withName("route2").endMetadata()
      .withNewSpec().withNewTo().withKind("Service").withName("service-name2").endTo().endSpec()
      .build();

    client.routes().inNamespace(currentNamespace).create(route1);
    client.routes().inNamespace(currentNamespace).create(route2);
  }

  @Test
  public void load() {
    Route aRoute = client.routes().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-route.yml")).get();
    assertThat(aRoute).isNotNull();
    assertEquals("host-route", aRoute.getMetadata().getName());
  }

  @Test
  public void get() {
    route1 = client.routes().inNamespace(currentNamespace).withName("route1").get();
    assertNotNull(route1);
    route2 = client.routes().inNamespace(currentNamespace).withName("route2").get();
    assertNotNull(route2);
  }

  @Test
  public void list() {
    RouteList aRouteList = client.routes().inNamespace(currentNamespace).list();
    assertThat(aRouteList).isNotNull();
    assertEquals(2, aRouteList.getItems().size());
  }

  @Test
  public void update() {
    route1 = client.routes().inNamespace(currentNamespace).withName("route1").edit()
      .editSpec().withPath("/test").endSpec().done();
    assertThat(route1).isNotNull();
    assertEquals("/test", route1.getSpec().getPath());
  }

  @Test
  public void delete() {
    boolean bDeleted = client.routes().inNamespace(currentNamespace).withName("route1").delete();
    assertTrue(bDeleted);
  }

  @After
  public void cleanup() throws InterruptedException {
    client.routes().inNamespace(currentNamespace).delete();
    // Wait for resources to get destroyed
    Thread.sleep(30000);
  }
}
