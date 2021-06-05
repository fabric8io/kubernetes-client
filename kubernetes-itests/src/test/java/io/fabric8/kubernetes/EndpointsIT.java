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

package io.fabric8.kubernetes;

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsBuilder;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@Ignore
@RequiresKubernetes
public class EndpointsIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(EndpointsIT.class.getResourceAsStream("/endpoints-it.yml"));
  }

  @Test
  public void get() {
    Endpoints endpoints = client.endpoints().inNamespace(session.getNamespace()).withName("endpoints-get").get();
    assertThat(endpoints).isNotNull();
  }

  @Test
  public void list() {
    EndpointsList aEndpointList = client.endpoints().inNamespace(session.getNamespace()).list();
    assertNotNull(aEndpointList);
    assertTrue(aEndpointList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    Endpoints endpoints = client.endpoints().inNamespace(session.getNamespace()).withName("endpoints-update").edit(c -> new EndpointsBuilder(c)
      .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata().build());

    assertNotNull(endpoints);
    assertEquals("bar", endpoints.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.endpoints().inNamespace(session.getNamespace()).withName("endpoints-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(EndpointsIT.class.getResourceAsStream("/endpoints-it.yml"));
  }
}
