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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaBuilder;
import io.fabric8.kubernetes.api.model.ResourceQuotaList;
import io.fabric8.kubernetes.api.model.ResourceQuotaListBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class ResourceQuotaTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  public void testList() {
    server.expect().withPath("/api/v1/namespaces/test/resourcequotas").andReturn(200, new ResourceQuotaListBuilder().build())
        .once();
    server.expect().withPath("/api/v1/namespaces/ns1/resourcequotas").andReturn(200, new ResourceQuotaListBuilder()
        .addNewItem().and()
        .addNewItem().and().build()).once();

    ResourceQuotaList resourceQuotaList = client.resourceQuotas().list();
    assertNotNull(resourceQuotaList);
    assertEquals(0, resourceQuotaList.getItems().size());

    resourceQuotaList = client.resourceQuotas().inNamespace("ns1").list();
    assertNotNull(resourceQuotaList);
    assertEquals(2, resourceQuotaList.getItems().size());
  }

  @Test
  public void testGet() {
    server.expect().withPath("/api/v1/namespaces/test/resourcequotas/resourcequota1")
        .andReturn(200, new ResourceQuotaListBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/resourcequotas/resourcequota2")
        .andReturn(200, new ResourceQuotaListBuilder().build()).once();

    ResourceQuota resourceQuota = client.resourceQuotas().withName("resourcequota1").get();
    assertNotNull(resourceQuota);

    resourceQuota = client.resourceQuotas().withName("resourcequota2").get();
    assertNull(resourceQuota);

    resourceQuota = client.resourceQuotas().inNamespace("ns1").withName("resourcequota2").get();
    assertNotNull(resourceQuota);
  }

  @Test
  public void testeDelete() {
    server.expect().withPath("/api/v1/namespaces/test/resourcequotas/resourcequota1")
        .andReturn(200, new ResourceQuotaBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/resourcequotas/resourcequota2")
        .andReturn(200, new ResourceQuotaBuilder().build()).once();

    boolean deleted = client.resourceQuotas().withName("resourcequota1").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.resourceQuotas().withName("resourcequota2").delete().size() == 1;
    assertFalse(deleted);

    deleted = client.resourceQuotas().inNamespace("ns1").withName("resourcequota2").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  public void testeDeleteMulti() {
    ResourceQuota resourcequota1 = new ResourceQuotaBuilder().withNewMetadata().withName("resourcequota1").withNamespace("test")
        .endMetadata().build();
    ResourceQuota resourcequota2 = new ResourceQuotaBuilder().withNewMetadata().withName("resourcequota2").withNamespace("ns1")
        .endMetadata().build();
    ResourceQuota resourcequota3 = new ResourceQuotaBuilder().withNewMetadata().withName("resourcequota3").withNamespace("any")
        .endMetadata().build();

    server.expect().withPath("/api/v1/namespaces/test/resourcequotas/resourcequota1").andReturn(200, resourcequota1).once();
    server.expect().withPath("/api/v1/namespaces/ns1/resourcequotas/resourcequota2").andReturn(200, resourcequota2).once();

    Boolean deleted = client.resourceQuotas().inAnyNamespace().delete(resourcequota1, resourcequota2);
    assertTrue(deleted);

    deleted = client.resourceQuotas().inAnyNamespace().delete(resourcequota3).size() == 1;
    assertFalse(deleted);
  }

  @Test
  public void testLoadFromFile() {
    List<HasMetadata> list = client.load(getClass().getResourceAsStream("/test-resourcequota.yml")).items();
    assertEquals(3, list.size());
    assertTrue(list.get(0) instanceof ResourceQuota);
    assertEquals("compute-quota", list.get(0).getMetadata().getName());
    assertEquals("myspace", list.get(0).getMetadata().getNamespace());
    assertEquals(new Quantity("1"), ((ResourceQuota) list.get(0)).getSpec().getHard().get("requests.cpu"));
    assertEquals(new Quantity("1Gi"), ((ResourceQuota) list.get(0)).getSpec().getHard().get("requests.memory"));
    assertEquals(new Quantity("2"), ((ResourceQuota) list.get(0)).getSpec().getHard().get("limits.cpu"));
    assertEquals(new Quantity("2Gi"), ((ResourceQuota) list.get(0)).getSpec().getHard().get("limits.memory"));
    assertTrue(list.get(1) instanceof ResourceQuota);
    assertEquals("object-quota", list.get(1).getMetadata().getName());
    assertEquals(new Quantity("10"), ((ResourceQuota) list.get(1)).getSpec().getHard().get("configmaps"));
    assertEquals(new Quantity("4"), ((ResourceQuota) list.get(1)).getSpec().getHard().get("persistentvolumeclaims"));
    assertEquals(new Quantity("20"), ((ResourceQuota) list.get(1)).getSpec().getHard().get("replicationcontrollers"));
    assertEquals(new Quantity("10"), ((ResourceQuota) list.get(1)).getSpec().getHard().get("secrets"));
    assertEquals(new Quantity("10"), ((ResourceQuota) list.get(1)).getSpec().getHard().get("services"));
    assertEquals(new Quantity("2"), ((ResourceQuota) list.get(1)).getSpec().getHard().get("services.loadbalancers"));
    assertTrue(list.get(2) instanceof Namespace);
    assertEquals("myspace", list.get(2).getMetadata().getName());
  }

  @Test
  public void testBuild() {
    server.expect().withPath("/api/v1/namespaces/myspace/resourcequotas/compute-quota")
        .andReturn(200, new ResourceQuotaBuilder()
            .withNewMetadata().withName("compute-quota").withNamespace("myspace").endMetadata()
            .withNewSpec().addToHard("pods", new Quantity("2"))
            .addToHard("requests.cpu", new Quantity("1"))
            .addToHard("limits.cpu", new Quantity("2")).endSpec().build())
        .once();

    Deployment deployment = client.apps().deployments()
        .load(getClass().getResourceAsStream("/test-resourcequota-deployment.yml")).item();
    server.expect().withPath("/apis/apps/v1/namespaces/myspace/deployments/deployment").andReturn(200, deployment).once();

    ResourceQuota resourcequota = client.resourceQuotas().inNamespace("myspace").withName("compute-quota").get();
    assertNotNull(resourcequota);

    deployment = client.apps().deployments().inNamespace("myspace").withName("deployment").get();
    assertNotNull(deployment);
  }

}
