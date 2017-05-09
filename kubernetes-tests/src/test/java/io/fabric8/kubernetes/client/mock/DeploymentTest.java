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

import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.DeploymentListBuilder;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DeploymentTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments").andReturn(200, new DeploymentListBuilder().build()).once();
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments").andReturn(200, new DeploymentListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    server.expect().withPath("/apis/extensions/v1beta1/deployments").andReturn(200, new DeploymentListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();


    KubernetesClient client = server.getClient();
    DeploymentList deploymentList = client.extensions().deployments().list();
    assertNotNull(deploymentList);
    assertEquals(0, deploymentList.getItems().size());

    deploymentList = client.extensions().deployments().inNamespace("ns1").list();
    assertNotNull(deploymentList);
    assertEquals(2, deploymentList.getItems().size());

    deploymentList = client.extensions().deployments().inAnyNamespace().list();
    assertNotNull(deploymentList);
    assertEquals(3, deploymentList.getItems().size());
  }

  @Test
  public void testListWithLabels() {
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments?labelSelector=" + toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new DeploymentListBuilder().build()).always();
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments?labelSelector=" + toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new DeploymentListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
    DeploymentList deploymentList = client.extensions().deployments()
      .withLabel("key1", "value1")
      .withLabel("key2", "value2")
      .withLabel("key3", "value3")
      .list();


    assertNotNull(deploymentList);
    assertEquals(0, deploymentList.getItems().size());

    deploymentList = client.extensions().deployments()
      .withLabel("key1", "value1")
      .withLabel("key2", "value2")
      .list();

    assertNotNull(deploymentList);
    assertEquals(3, deploymentList.getItems().size());
  }


  @Test
  public void testGet() {
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder().build()).once();
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder().build()).once();

    KubernetesClient client = server.getClient();

    Deployment deployment = client.extensions().deployments().withName("deployment1").get();
    assertNotNull(deployment);

    deployment = client.extensions().deployments().withName("deployment2").get();
    assertNull(deployment);

    deployment = client.extensions().deployments().inNamespace("ns1").withName("deployment2").get();
    assertNotNull(deployment);
  }


  @Test
  public void testDelete() {

    Deployment deployment1 = new DeploymentBuilder().withNewMetadata()
      .withName("deployment1")
      .addToLabels("key1", "value1")
      .withResourceVersion("1")
      .withGeneration(1L)
      .endMetadata()
      .withNewSpec()
      .withNewSelector()
      .addToMatchLabels("key1", "value1")
      .endSelector()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(1)
      .withObservedGeneration(1l)
      .endStatus()
      .build();

    ReplicaSet replicaSet1 = new ReplicaSetBuilder().withNewMetadata()
      .withName("rs1")
      .addToLabels("key1", "value1")
      .withResourceVersion("1")
      .withGeneration(1L)
      .endMetadata()
      .withNewSpec()
      .withNewSelector()
      .addToMatchLabels("key1", "value1")
      .endSelector()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(1)
      .withObservedGeneration(1l)
      .endStatus()
      .build();

    Deployment deployment2 = new DeploymentBuilder().withNewMetadata()
      .withName("deployment2")
      .addToLabels("key2", "value2")
      .withResourceVersion("1")
      .withGeneration(1L)
      .endMetadata()
      .withNewSpec()
      .withNewSelector()
      .addToMatchLabels("key2", "value2")
      .endSelector()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(1)
      .withObservedGeneration(1l)
      .endStatus()
      .build();


    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, deployment1).once();
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder(deployment1).editSpec().withReplicas(0).endSpec().build()).times(5);

    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets?labelSelector=key1%3Dvalue1").andReturn(200, new ReplicaSetListBuilder().addToItems(replicaSet1).build()).once();
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/rs1").andReturn(200, replicaSet1).once();

    server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, deployment2).once();
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder(deployment2).editSpec().withReplicas(0).endSpec().build()).times(5);

    KubernetesClient client = server.getClient();

    Boolean deleted = client.extensions().deployments().withName("deployment1").delete();
    assertNotNull(deleted);

    deleted = client.extensions().deployments().withName("deployment2").delete();
    assertFalse(deleted);

    deleted = client.extensions().deployments().inNamespace("ns1").withName("deployment2").delete();
    assertTrue(deleted);
  }


  @Test
  public void testDeleteMulti() {
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata()
      .withNamespace("test")
      .withName("deployment1")
      .withResourceVersion("1")
      .withGeneration(2L)
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(1)
      .withObservedGeneration(1l)
      .endStatus()
      .build();

    Deployment deployment2 = new DeploymentBuilder().withNewMetadata()
      .withNamespace("ns1")
      .withName("deployment2")
      .withResourceVersion("1")
      .withGeneration(2L)
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(1)
      .withObservedGeneration(1l)
      .endStatus()
      .build();

    Deployment deployment3 = new DeploymentBuilder().withNewMetadata().withName("deployment3").withNamespace("any").and().build();

    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, deployment1).once();
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder(deployment1)
      .editStatus()
      .withReplicas(0)
      .withObservedGeneration(2l)
      .endStatus()
      .build()).times(5);

    server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, deployment2).once();
    server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder(deployment2)
      .editStatus()
      .withReplicas(0)
      .withObservedGeneration(2l)
      .endStatus()
      .build()).times(5);

    KubernetesClient client = server.getClient();

    Boolean deleted = client.extensions().deployments().inAnyNamespace().delete(deployment1, deployment2);
    assertTrue(deleted);

    deleted = client.extensions().deployments().inAnyNamespace().delete(deployment3);
    assertFalse(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteWithNamespaceMismatch() {
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").and().build();
    KubernetesClient client = server.getClient();

    Boolean deleted = client.extensions().deployments().inNamespace("test1").delete(deployment1);
    assertNotNull(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testCreateWithNameMismatch() {
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").and().build();
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("deployment2").withNamespace("ns1").and().build();
    KubernetesClient client = server.getClient();

    client.extensions().deployments().inNamespace("test1").withName("mydeployment1").create(deployment1);
  }

  /**
   * Converts string to URL encoded string.
   * It's not a fullblown converter, it serves just the purpose of this test.
   * @param str
   * @return
   */
  private static final String toUrlEncoded(String str) {
    return str.replaceAll("=", "%3D");
  }
}
