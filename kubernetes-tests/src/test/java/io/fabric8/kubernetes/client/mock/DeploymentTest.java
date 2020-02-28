/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.ContainerPortBuilder;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.api.model.apps.DeploymentListBuilder;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetListBuilder;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollbackBuilder;
import io.fabric8.kubernetes.api.model.v1.Scale;
import io.fabric8.kubernetes.api.model.v1.ScaleBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;

import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableRuleMigrationSupport
public class DeploymentTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
    server.expect().withPath("/apis/apps/v1/namespaces/test/deployments").andReturn(200, new DeploymentListBuilder().build()).once();
    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments").andReturn(200, new DeploymentListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    server.expect().withPath("/apis/apps/v1/deployments").andReturn(200, new DeploymentListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();


    KubernetesClient client = server.getClient();
    DeploymentList deploymentList = client.apps().deployments().list();
    assertNotNull(deploymentList);
    assertEquals(0, deploymentList.getItems().size());

    deploymentList = client.apps().deployments().inNamespace("ns1").list();
    assertNotNull(deploymentList);
    assertEquals(2, deploymentList.getItems().size());

    deploymentList = client.apps().deployments().inAnyNamespace().list();
    assertNotNull(deploymentList);
    assertEquals(3, deploymentList.getItems().size());
  }

  @Test
  public void testListWithLabels() {
    server.expect().withPath("/apis/apps/v1/namespaces/test/deployments?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new DeploymentListBuilder().build()).always();
    server.expect().withPath("/apis/apps/v1/namespaces/test/deployments?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new DeploymentListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
    DeploymentList deploymentList = client.apps().deployments()
      .withLabel("key1", "value1")
      .withLabel("key2", "value2")
      .withLabel("key3", "value3")
      .list();


    assertNotNull(deploymentList);
    assertEquals(0, deploymentList.getItems().size());

    deploymentList = client.apps().deployments()
      .withLabel("key1", "value1")
      .withLabel("key2", "value2")
      .list();

    assertNotNull(deploymentList);
    assertEquals(3, deploymentList.getItems().size());
  }


  @Test
  public void testGet() {
    server.expect().withPath("/apis/apps/v1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder().build()).once();
    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder().build()).once();

    KubernetesClient client = server.getClient();

    Deployment deployment = client.apps().deployments().withName("deployment1").get();
    assertNotNull(deployment);

    deployment = client.apps().deployments().withName("deployment2").get();
    assertNull(deployment);

    deployment = client.apps().deployments().inNamespace("ns1").withName("deployment2").get();
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


    server.expect().withPath("/apis/apps/v1/namespaces/test/deployments/deployment1").andReturn(200, deployment1).once();
    server.expect().withPath("/apis/apps/v1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder(deployment1).editSpec().withReplicas(0).endSpec().build()).times(5);

    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets?labelSelector=key1%3Dvalue1").andReturn(200, new ReplicaSetListBuilder().addToItems(replicaSet1).build()).once();
    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/rs1").andReturn(200, replicaSet1).once();

    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments/deployment2").andReturn(200, deployment2).once();
    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder(deployment2).editSpec().withReplicas(0).endSpec().build()).times(5);

    KubernetesClient client = server.getClient();

    Boolean deleted = client.apps().deployments().withName("deployment1").delete();
    assertTrue(deleted);

    deleted = client.apps().deployments().withName("deployment2").delete();
    assertFalse(deleted);

    deleted = client.apps().deployments().inNamespace("ns1").withName("deployment2").delete();
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

    Deployment deployment3 = new DeploymentBuilder().withNewMetadata().withName("deployment3").withNamespace("any").endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .endSpec()
      .build();

    server.expect().withPath("/apis/apps/v1/namespaces/test/deployments/deployment1").andReturn(200, deployment1).once();
    server.expect().withPath("/apis/apps/v1/namespaces/test/deployments/deployment1").andReturn(200, new DeploymentBuilder(deployment1)
      .editStatus()
      .withReplicas(0)
      .withObservedGeneration(2l)
      .endStatus()
      .build()).times(5);

    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments/deployment2").andReturn(200, deployment2).once();
    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder(deployment2)
      .editStatus()
      .withReplicas(0)
      .withObservedGeneration(2l)
      .endStatus()
      .build()).times(5);

    KubernetesClient client = server.getClient();

    Boolean deleted = client.apps().deployments().inAnyNamespace().delete(deployment1, deployment2);
    assertTrue(deleted);

    deleted = client.apps().deployments().inAnyNamespace().delete(deployment3);
    assertFalse(deleted);
  }

  @Test
  public void testDeleteWithNamespaceMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .endSpec()
        .build();
      KubernetesClient client = server.getClient();

      Boolean deleted = client.apps().deployments().inNamespace("test1").delete(deployment1);
      assertFalse(deleted);
    });
  }

  @Test
  public void testCreateWithNameMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").and().build();
      Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("deployment2").withNamespace("ns1").and().build();
      KubernetesClient client = server.getClient();

      client.apps().deployments().inNamespace("test1").withName("mydeployment1").create(deployment1);
    });
  }

  @Test
  public void testRollingUpdate() {
    Deployment deployment = new DeploymentBuilder()
      .withNewMetadata()
      .withName("deployment1")
      .withNamespace("ns1")
      .endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .withNewSelector()
      .withMatchLabels(Collections.singletonMap("service", "http-server"))
      .endSelector()
      .withNewStrategy()
      .withType("RollingUpdate")
      .withNewRollingUpdate()
      .withNewMaxSurge().withIntVal(1).endMaxSurge()
      .withNewMaxUnavailable().withIntVal(1).endMaxUnavailable()
      .endRollingUpdate()
      .endStrategy()
      .withMinReadySeconds(5)
      .withNewTemplate()
      .withNewMetadata().withLabels(Collections.singletonMap("service", "http-server")).endMetadata()
      .withNewSpec()
      .addToContainers(new ContainerBuilder()
        .withName("nginx")
        .withImage("nginx:1.10.2")
        .withImagePullPolicy("IfNotPresent")
        .withPorts(Arrays.asList(new ContainerPortBuilder().withContainerPort(80).build()))
        .build())
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();

    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments/deployment1").andReturn(200, deployment).always();
    server.expect().withPath("/api/v1/namespaces/ns1/pods?labelSelector=service%3Dhttp-server").andReturn(200, new KubernetesListBuilder().build()).once();
    server.expect().post().withPath("/apis/apps/v1/namespaces/ns1/deployments").andReturn(201, deployment).times(2);
    KubernetesClient client = server.getClient();

    client.apps().deployments().inNamespace("ns1")
      .withName("deployment1")
      .rolling()
      .withTimeout(5, TimeUnit.MINUTES)
      .updateImage("");
  }

  @Test
  public void testListFromServer() {
    DeploymentBuilder deploymentBuilder = new DeploymentBuilder()
      .withNewMetadata()
        .withNamespace("test")
        .withName("deployment1")
      .endMetadata();

    Deployment clientDeployment = deploymentBuilder.build();
    Deployment serverDeployment = deploymentBuilder
      .editMetadata()
        .withResourceVersion("1")
      .endMetadata()
      .withNewStatus()
        .addNewCondition()
          .withType("Ready")
          .withStatus("True")
        .endCondition()
      .endStatus()
      .build();

    server.expect()
      .withPath("/apis/apps/v1/namespaces/test/deployments/deployment1")
      .andReturn(200, serverDeployment).once();

    KubernetesClient client = server.getClient();

    List<HasMetadata> resources = client.resourceList(clientDeployment).fromServer().get();

    assertNotNull(resources);
    assertEquals(1, resources.size());
    assertNotNull(resources.get(0));
    assertTrue(resources.get(0) instanceof Deployment);

    Deployment fromServerDeployment = (Deployment) resources.get(0);
    assertNotNull(fromServerDeployment.getMetadata());
    assertEquals("1", fromServerDeployment.getMetadata().getResourceVersion());
    assertNotNull(fromServerDeployment.getStatus());
    assertNotNull(fromServerDeployment.getStatus().getConditions());
    assertEquals(1, fromServerDeployment.getStatus().getConditions().size());
    assertEquals("Ready", fromServerDeployment.getStatus().getConditions().get(0).getType());
    assertEquals("True", fromServerDeployment.getStatus().getConditions().get(0).getStatus());
  }

  @Test
  public void testScaleGet() {
    Scale scaleObj = new ScaleBuilder()
      .withNewMetadata().addToLabels("foo", "bar").endMetadata()
      .withNewSpec().withReplicas(Integer.parseInt("2")).endSpec()
      .build();

    server.expect()
      .get()
      .withPath("/apis/apps/v1/namespaces/test/deployments/deployment1/scale")
      .andReturn(200, scaleObj).once();

    KubernetesClient client = server.getClient();
    Scale scaleResponse  = client.apps().deployments().inNamespace("test").withName("deployment1").scale();
    assertEquals("bar", scaleResponse.getMetadata().getLabels().get("foo"));
  }

  @Test
  public void testScaleUpdate() {
    Scale scaleObj = new ScaleBuilder()
      .withNewMetadata().addToLabels("foo", "bar").endMetadata()
      .withNewSpec().withReplicas(Integer.parseInt("2")).endSpec()
      .build();

    server.expect()
      .put()
      .withPath("/apis/apps/v1/namespaces/test/deployments/deployment1/scale")
      .andReturn(200, scaleObj).once();

    KubernetesClient client = server.getClient();

    Scale scaleResponse  = client.apps().deployments().inNamespace("test").withName("deployment1").scale(scaleObj);
    assertEquals("bar", scaleResponse.getMetadata().getLabels().get("foo"));
  }

  @Test
  public void testRollback() {
    DeploymentRollback deploymentRollback = new DeploymentRollbackBuilder()
      .withName("deployment1")
      .withNewRollbackTo().withRevision(1l).endRollbackTo()
      .withUpdatedAnnotations(Collections.singletonMap("foo", "bar"))
      .build();

    Status status = new StatusBuilder().build();
    KubernetesClient client = server.getClient();
    server.expect()
      .post()
      .withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1/rollback")
      .andReturn(201, status).once();

    client.extensions().deployments().inNamespace("test").withName("deployment1").rollback(deploymentRollback);
  }
}
