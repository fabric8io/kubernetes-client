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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/service-it.yml")
class ServiceIT {

  KubernetesClient client;

  Namespace namespace;

  @Test
  void load() {
    Service aService = client.services().load(getClass().getResourceAsStream("/test-service.yml")).item();
    assertThat(aService).isNotNull();
    assertEquals("my-service", aService.getMetadata().getName());
  }

  @Test
  void get() {
    Service svc1 = client.services().withName("service-get").get();
    assertNotNull(svc1);
  }

  @Test
  void list() {
    ServiceList aServiceList = client.services().list();
    assertThat(aServiceList).isNotNull();
    assertTrue(aServiceList.getItems().size() >= 1);
  }

  @Test
  void update() {
    Service svc1 = client.services().withName("service-update").edit(s -> new ServiceBuilder(s)
        .editMetadata().withResourceVersion(null).endMetadata()
        .editSpec().addNewPort().withName("https").withProtocol("TCP").withPort(443).withTargetPort(new IntOrString(9377))
        .endPort().endSpec()
        .build());
    client.services().withName("service-update")
        .waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    assertThat(svc1).isNotNull();
    assertEquals(2, svc1.getSpec().getPorts().size());
  }

  @Test
  void delete() {
    client.services().withName("service-delete")
        .waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    boolean bDeleted = client.services().withName("service-delete").delete().size() == 1;
    assertTrue(bDeleted);
  }

  @Test
  void testChangeServiceType() {
    // Given
    Service svc = client.services().withName("service-change-service-type").get();

    // When
    svc.getSpec().setType("ExternalName");
    svc.getSpec().setExternalName("my.database.example.com");
    svc.getSpec().setClusterIP("");
    svc.getSpec().setClusterIPs(Collections.emptyList());
    svc.getSpec().setIpFamilies(Collections.emptyList());
    svc.getSpec().setIpFamilyPolicy(null);
    svc = client.services().createOrReplace(svc);

    // Then
    assertNotNull(svc);
    assertEquals("ExternalName", svc.getSpec().getType());
    assertEquals("my.database.example.com", svc.getSpec().getExternalName());
  }

  @Test
  void testChangeServiceTypePatch() {
    // Given
    Service svc = new ServiceBuilder()
        .withNewMetadata()
        .withNamespace(namespace.getMetadata().getName())
        .withName("service-change-service-type-patch")
        .endMetadata()
        .withNewSpec()
        .withType("ExternalName")
        .withExternalName("my.database.example.com")
        .endSpec()
        .build();

    // When
    svc = client.services()
        .withName("service-change-service-type-patch")
        .patch(svc);

    // Then
    assertNotNull(svc);
    assertEquals("ExternalName", svc.getSpec().getType());
    assertEquals("my.database.example.com", svc.getSpec().getExternalName());
  }

  @Test
  void testClusterIpServiceCreateOrReplace() {
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
    client.services().createOrReplace(clusterIPSvc);
    // Modify resource
    clusterIPSvc.getSpec().getPorts().get(0).setTargetPort(new IntOrString(9380));
    // Do createOrReplace again; resource should get updated
    clusterIPSvc = client.services().createOrReplace(clusterIPSvc);

    // Then
    assertNotNull(clusterIPSvc);
    assertEquals("ClusterIP", clusterIPSvc.getSpec().getType());
    assertEquals(9380, clusterIPSvc.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
  }

  @Test
  void testNodePortServiceCreateOrReplace() {
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
    client.services().createOrReplace(nodePortSvc);
    // Modify resource
    nodePortSvc.getSpec().getPorts().get(0).setTargetPort(new IntOrString(81));
    nodePortSvc.getSpec().getPorts().get(0).setNodePort(32124);
    // Do createOrReplace again; resource should get updated
    nodePortSvc = client.services().createOrReplace(nodePortSvc);

    // Then
    assertNotNull(nodePortSvc);
    assertEquals("NodePort", nodePortSvc.getSpec().getType());
    assertEquals(81, nodePortSvc.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
    assertEquals(32124, nodePortSvc.getSpec().getPorts().get(0).getNodePort().intValue());
  }

  @Test
  void testLoadBalancerServiceCreateOrReplace() {
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
    client.services().createOrReplace(loadBalancerSvc);
    // Modify resource
    loadBalancerSvc.getSpec().getPorts().get(0).setTargetPort(new IntOrString(9380));
    // Do createOrReplace again; resource should get updated
    loadBalancerSvc = client.services().createOrReplace(loadBalancerSvc);

    // Then
    assertNotNull(loadBalancerSvc);
    assertEquals("LoadBalancer", loadBalancerSvc.getSpec().getType());
    assertEquals(9380, loadBalancerSvc.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
  }

  @Test
  void testExternalNameServiceCreateOrReplace() {
    // Given
    Service service = new ServiceBuilder()
        .withNewMetadata().withName("serviceit-externalname-createorreplace").endMetadata()
        .withNewSpec()
        .withType("ExternalName")
        .withExternalName("my.database.example.com")
        .endSpec()
        .build();

    // When
    client.services().createOrReplace(service);
    service.getSpec().setExternalName("his.database.example.com");
    service = client.services().createOrReplace(service);

    // Then
    assertNotNull(service);
    assertEquals("serviceit-externalname-createorreplace", service.getMetadata().getName());
    assertEquals("ExternalName", service.getSpec().getType());
    assertEquals("his.database.example.com", service.getSpec().getExternalName());
  }

  @Test
  void waitUntilReady() {
    // Given
    String svcName = "service-wait-until-ready";

    // When
    Service service = client.services()
        .withName(svcName)
        .waitUntilReady(10, TimeUnit.SECONDS);

    // Then
    assertNotNull(service);
    assertEquals(svcName, service.getMetadata().getName());
    assertTrue(client.pods().withName(svcName).delete().size() == 1);
  }

}
