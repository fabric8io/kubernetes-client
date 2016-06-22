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
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DeploymentTest extends KubernetesMockServerTestBase {

  @Test
  public void testList() {
    expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments").andReturn(200, new DeploymentListBuilder().build()).once();
    expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments").andReturn(200, new DeploymentListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    expect().withPath("/apis/extensions/v1beta1/deployments").andReturn(200, new DeploymentListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();


    KubernetesClient client = getClient();
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
  public void testListWithLables() {
    expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments?labelSelector=" + toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new DeploymentListBuilder().build()).always();
    expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments?labelSelector=" + toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new DeploymentListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = getClient();
    DeploymentList deploymentList = client.extensions().deployments()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .withLabel("key3","value3")
      .list();


    assertNotNull(deploymentList);
    assertEquals(0, deploymentList.getItems().size());

    deploymentList = client.extensions().deployments()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .list();

    assertNotNull(deploymentList);
    assertEquals(3, deploymentList.getItems().size());
  }


  @Test
  public void testGet() {
    expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder().build()).once();
    expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder().build()).once();

    KubernetesClient client = getClient();

    Deployment deployment = client.extensions().deployments().withName("deployment1").get();
    assertNotNull(deployment);

    deployment = client.extensions().deployments().withName("deployment2").get();
    assertNull(deployment);

    deployment = client.extensions().deployments().inNamespace("ns1").withName("deployment2").get();
    assertNotNull(deployment);
  }


  @Test
  public void testDelete() {
    expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder().withNewMetadata()
      .withName("deployment1")
      .withResourceVersion("1")
      .withGeneration(1L)
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(1)
      .withObservedGeneration(1l)
      .endStatus()
      .build()).once();
    expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder().withNewMetadata()
      .withName("deployment1")
      .withResourceVersion("1")
      .withGeneration(1L)
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(0)
      .withObservedGeneration(2l)
      .endStatus()
      .build()).times(5);

    expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder().withNewMetadata()
      .withName("deployment2")
      .withResourceVersion("1")
      .withGeneration(1L)
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(1)
      .withObservedGeneration(1l)
      .endStatus()
      .build()).once();
    expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder().withNewMetadata()
      .withName("deployment2")
      .withResourceVersion("1")
      .withGeneration(1L)
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(0)
      .withObservedGeneration(2l)
      .endStatus()
      .build()).times(5);

    KubernetesClient client = getClient();

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

    expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, deployment1).once();
    expect().withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder(deployment1)
      .editStatus()
      .withReplicas(0)
      .withObservedGeneration(2l)
      .endStatus()
      .build()).times(5);

    expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, deployment2).once();
    expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder(deployment2)
      .editStatus()
      .withReplicas(0)
      .withObservedGeneration(2l)
      .endStatus()
      .build()).times(5);

    KubernetesClient client = getClient();

    Boolean deleted = client.extensions().deployments().inAnyNamespace().delete(deployment1, deployment2);
    assertTrue(deleted);

    deleted = client.extensions().deployments().inAnyNamespace().delete(deployment3);
    assertFalse(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteWithNamespaceMismatch() {
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").and().build();
    KubernetesClient client = getClient();

    Boolean deleted = client.extensions().deployments().inNamespace("test1").delete(deployment1);
    assertNotNull(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testCreateWithNameMismatch() {
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").and().build();
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("deployment2").withNamespace("ns1").and().build();
    KubernetesClient client = getClient();

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
