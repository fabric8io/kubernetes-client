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
import io.fabric8.kubernetes.api.model.ServiceBuilder;
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
    Service svc1 = client.services().inNamespace(session.getNamespace()).withName("service-get").get();
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
    Service svc1 = client.services().inNamespace(session.getNamespace()).withName("service-update").edit(s -> new ServiceBuilder (s)
      .editSpec().addNewPort().withName("https").withProtocol("TCP").withPort(443).withTargetPort(new IntOrString(9377)).endPort().endSpec()
      .build());
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

  @Test
  public void testChangeServiceType() {
    // Given
    Service svc = client.services().inNamespace(session.getNamespace()).withName("service-change-service-type").get();

    // When
    svc.getSpec().setType("ExternalName");
    svc.getSpec().setExternalName("my.database.example.com");
    svc.getSpec().setClusterIP("");
    svc.getSpec().setClusterIPs(Collections.emptyList());
    svc = client.services().inNamespace(session.getNamespace()).createOrReplace(svc);

    // Then
    assertNotNull(svc);
    assertEquals("ExternalName", svc.getSpec().getType());
    assertEquals("my.database.example.com", svc.getSpec().getExternalName());
  }

  @Test
  public void testClusterIpServiceCreateOrReplace() {
    // Given
    Service clusterIPSvc = new ServiceBuilder()
      .withNewMetadata().withName("serviceit-clusterip-createorreplace").endMetadata()
      .withNewSpec()
      .addToSelector("app", "myapp")
      .addNewPort()
      .withName("http")
      .withProtocol("TCP")
      .withPort(80)
      .withTargetPort(new IntOrString(9376))
      .endPort()
      .endSpec()
      .build();

    // When
    // Create resource
    client.services().inNamespace(session.getNamespace()).createOrReplace(clusterIPSvc);
    // Modify resource
    clusterIPSvc.getSpec().getPorts().get(0).setTargetPort(new IntOrString(9380));
    // Do createOrReplace again; resource should get updated
    clusterIPSvc = client.services().inNamespace(session.getNamespace()).createOrReplace(clusterIPSvc);

    // Then
    assertNotNull(clusterIPSvc);
    assertEquals("ClusterIP", clusterIPSvc.getSpec().getType());
    assertEquals(9380, clusterIPSvc.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
  }

  @Test
  public void testNodePortServiceCreateOrReplace() {
    // Given
    Service nodePortSvc = new ServiceBuilder()
      .withNewMetadata().withName("serviceit-nodeport-createorreplace").endMetadata()
      .withNewSpec()
      .withType("NodePort")
      .addToSelector("app", "myapp")
      .addNewPort()
      .withPort(80)
      .withTargetPort(new IntOrString(80))
      .endPort()
      .endSpec()
      .build();

    // When
    // Create resource
    client.services().inNamespace(session.getNamespace()).createOrReplace(nodePortSvc);
    // Modify resource
    nodePortSvc.getSpec().getPorts().get(0).setTargetPort(new IntOrString(81));
    nodePortSvc.getSpec().getPorts().get(0).setNodePort(32124);
    // Do createOrReplace again; resource should get updated
    nodePortSvc = client.services().inNamespace(session.getNamespace()).createOrReplace(nodePortSvc);

    // Then
    assertNotNull(nodePortSvc);
    assertEquals("NodePort", nodePortSvc.getSpec().getType());
    assertEquals(81, nodePortSvc.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
    assertEquals(32124, nodePortSvc.getSpec().getPorts().get(0).getNodePort().intValue());
  }

  @Test
  public void testLoadBalancerServiceCreateOrReplace() {
    // Given
    Service loadBalancerSvc = new ServiceBuilder()
      .withNewMetadata().withName("serviceit-loadbalancer-createorreplace").endMetadata()
      .withNewSpec()
      .withType("LoadBalancer")
      .addToSelector("app", "myapp")
      .addNewPort()
      .withProtocol("TCP")
      .withPort(80)
      .withTargetPort(new IntOrString(9376))
      .endPort()
      .endSpec()
      .build();

    // When
    // Create resource
    client.services().inNamespace(session.getNamespace()).createOrReplace(loadBalancerSvc);
    // Modify resource
    loadBalancerSvc.getSpec().getPorts().get(0).setTargetPort(new IntOrString(9380));
    // Do createOrReplace again; resource should get updated
    loadBalancerSvc = client.services().inNamespace(session.getNamespace()).createOrReplace(loadBalancerSvc);

    // Then
    assertNotNull(loadBalancerSvc);
    assertEquals("LoadBalancer", loadBalancerSvc.getSpec().getType());
    assertEquals(9380, loadBalancerSvc.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
  }

  @Test
  public void testExternalNameServiceCreateOrReplace() {
    // Given
    Service service = new ServiceBuilder()
      .withNewMetadata().withName("serviceit-externalname-createorreplace").endMetadata()
      .withNewSpec()
      .withType("ExternalName")
      .withExternalName("my.database.example.com")
      .endSpec()
      .build();

    // When
    client.services().inNamespace(session.getNamespace()).createOrReplace(service);
    service.getSpec().setExternalName("his.database.example.com");
    service = client.services().inNamespace(session.getNamespace()).createOrReplace(service);

    // Then
    assertNotNull(service);
    assertEquals("serviceit-externalname-createorreplace", service.getMetadata().getName());
    assertEquals("ExternalName", service.getSpec().getType());
    assertEquals("his.database.example.com", service.getSpec().getExternalName());
  }

  @Test
  public void waitUntilReady() throws InterruptedException {
    // Given
    String svcName = "service-wait-until-ready";

    // When
    Service service = client.services().inNamespace(session.getNamespace())
      .withName(svcName)
      .waitUntilReady(10, TimeUnit.SECONDS);

    // Then
    assertNotNull(service);
    assertEquals(svcName, service.getMetadata().getName());
    assertTrue(client.pods().inNamespace(session.getNamespace()).withName(svcName).delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ServiceIT.class.getResourceAsStream("/service-it.yml"));
  }

}
