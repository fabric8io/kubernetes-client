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
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ServiceIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private Service svc1;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ServiceIT.class.getResourceAsStream("/service-it.yml"));
  }

  @Test
  public void load() {
    Service aService = client.services().inNamespace(session.getNamespace()).load(getClass().getResourceAsStream("/test-service.yml")).get();
    assertThat(aService).isNotNull();
    assertEquals("my-service", aService.getMetadata().getName());
  }

  @Test
  public void get() {
    svc1 = client.services().inNamespace(session.getNamespace()).withName("service-get").get();
    assertNotNull(svc1);
  }

  @Test
  public void list() {
    ServiceList aServiceList = client.services().inNamespace(session.getNamespace()).list();
    assertThat(aServiceList).isNotNull();
    assertTrue(aServiceList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReadyEntity<Service> serviceReady = new ReadyEntity<>(Service.class, client, "service-update", session.getNamespace());
    svc1 = client.services().inNamespace(session.getNamespace()).withName("service-update").edit()
      .editSpec().addNewPort().withName("https").withProtocol("TCP").withPort(443).withTargetPort(new IntOrString(9377)).endPort().endSpec()
      .done();
    await().atMost(30, TimeUnit.SECONDS).until(serviceReady);
    assertThat(svc1).isNotNull();
    assertEquals(2, svc1.getSpec().getPorts().size());
  }

  @Test
  public void delete() {
    ReadyEntity<Service> serviceReady = new ReadyEntity<>(Service.class, client, "service-delete", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(serviceReady);
    boolean bDeleted = client.services().inNamespace(session.getNamespace()).withName("service-delete").delete();
    assertTrue(bDeleted);
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ServiceIT.class.getResourceAsStream("/service-it.yml"));
  }

}
