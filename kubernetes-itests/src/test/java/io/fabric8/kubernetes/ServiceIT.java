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

import io.fabric8.commons.DeleteEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
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

  private Service svc1, svc2;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    svc1 = new ServiceBuilder()
      .withNewMetadata()
      .withName("svc1")
      .endMetadata()
      .withNewSpec()
      .withSelector(Collections.singletonMap("app", "MyApp"))
      .addNewPort()
      .withName("http")
      .withProtocol("TCP")
      .withPort(80)
      .withTargetPort(new IntOrString(9376))
      .endPort()
      .withType("LoadBalancer")
      .endSpec()
      .withNewStatus()
      .withNewLoadBalancer()
      .addNewIngress()
      .withIp("146.148.47.155")
      .endIngress()
      .endLoadBalancer()
      .endStatus()
      .build();
    svc2 = new ServiceBuilder()
      .withNewMetadata().withName("svc2").endMetadata()
      .withNewSpec().withType("ExternalName").withExternalName("my.database.example.com")
      .addNewPort().withName("80").withProtocol("TCP").withPort(80).endPort()
      .endSpec()
      .withNewStatus()
      .withNewLoadBalancer()
      .addNewIngress()
      .withIp("146.148.47.155")
      .endIngress()
      .endLoadBalancer()
      .endStatus()
      .build();

    client.services().inNamespace(currentNamespace).createOrReplace(svc1);
    client.services().inNamespace(currentNamespace).createOrReplace(svc2);
  }

  @Test
  public void load() {
    String currentNamespace = session.getNamespace();
    Service aService = client.services().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-service.yml")).get();
    assertThat(aService).isNotNull();
    assertEquals("my-service", aService.getMetadata().getName());
  }

  @Test
  public void get() {
    svc1 = client.services().inNamespace(currentNamespace).withName("svc1").get();
    assertNotNull(svc1);
    svc2 = client.services().inNamespace(currentNamespace).withName("svc2").get();
    assertNotNull(svc2);
  }

  @Test
  public void list() {
    ServiceList aServiceList = client.services().inNamespace(currentNamespace).list();
    assertThat(aServiceList).isNotNull();
    assertEquals(2, aServiceList.getItems().size());
  }

  @Test
  public void update() {
    ReadyEntity<Service> serviceReady = new ReadyEntity<>(Service.class, client, "svc1", currentNamespace);
    svc1 = client.services().inNamespace(currentNamespace).withName("svc1").edit()
      .editSpec().addNewPort().withName("https").withProtocol("TCP").withPort(443).withTargetPort(new IntOrString(9377)).endPort().endSpec()
      .done();
    await().atMost(30, TimeUnit.SECONDS).until(serviceReady);
    assertThat(svc1).isNotNull();
    assertEquals(2, svc1.getSpec().getPorts().size());
  }

  @Test
  public void delete() {
    ReadyEntity<Service> serviceReady = new ReadyEntity<>(Service.class, client, "svc2", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(serviceReady);
    boolean bDeleted = client.services().inNamespace(currentNamespace).withName("svc2").delete();
    assertTrue(bDeleted);
  }



  @After
  public void cleanup() {
    if (client.services().inNamespace(currentNamespace).list().getItems().size()!= 0) {
      client.services().inNamespace(currentNamespace).delete();
    }

    // Wait for resources to get destroyed
    DeleteEntity<Service> service1Delete = new DeleteEntity<>(Service.class, client, "svc1", currentNamespace);
    await().atMost(60, TimeUnit.SECONDS).until(service1Delete);

    DeleteEntity<Service> service2Delete = new DeleteEntity<>(Service.class, client, "svc2", currentNamespace);
    await().atMost(60, TimeUnit.SECONDS).until(service2Delete);
  }
}
