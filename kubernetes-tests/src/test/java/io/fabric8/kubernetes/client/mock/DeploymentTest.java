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
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.ContainerPortBuilder;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.OwnerReferenceBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
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
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.api.model.autoscaling.v1.ScaleBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;

import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
      .withObservedGeneration(1L)
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
      .withObservedGeneration(1L)
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
      .withObservedGeneration(1L)
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
      .withObservedGeneration(1L)
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
      .withObservedGeneration(1L)
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
      .withObservedGeneration(2L)
      .endStatus()
      .build()).times(5);

    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments/deployment2").andReturn(200, deployment2).once();
    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments/deployment2").andReturn(200, new DeploymentBuilder(deployment2)
      .editStatus()
      .withReplicas(0)
      .withObservedGeneration(2L)
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
    assertThrows(KubernetesClientException.class, () -> {
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
    assertThrows(KubernetesClientException.class, () -> {
      Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").and().build();
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
      .withNewMaxSurge(1)
      .withNewMaxUnavailable(1)
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
        .withPorts(Collections.singletonList(new ContainerPortBuilder().withContainerPort(80).build()))
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
      .withNewRollbackTo().withRevision(1L).endRollbackTo()
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

  @Test
  public void testCreate() {
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .endSpec()
      .build();

    server.expect().post().withPath("/apis/apps/v1/namespaces/test/deployments")
      .andReturn(200, deployment1)
      .once();

    KubernetesClient client = server.getClient();
    Deployment result = client.apps().deployments().inNamespace("test").create(deployment1);
    assertNotNull(result);
    assertEquals("deployment1", result.getMetadata().getName());
  }

  @Test
  public void testCreateMulti() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .endSpec()
        .build();
      Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("deployment1").withNamespace("test").endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .endSpec()
        .build();

      server.expect().post().withPath("/apis/apps/v1/namespaces/test/deployments")
        .andReturn(200, deployment1)
        .once();

      KubernetesClient client = server.getClient();
      // Will throw exception
      client.apps().deployments().inNamespace("test").create(deployment1, deployment2);
    });

    assertEquals("Too many items to create.", exception.getMessage());
  }

  @Test
  @DisplayName("Should update image based in single argument")
  void testRolloutUpdateSingleImage() throws InterruptedException {
    // Given
    String imageToUpdate = "nginx:latest";
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).times(3);
    server.expect().patch().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder()
        .editSpec().editTemplate().editSpec().editContainer(0)
          .withImage(imageToUpdate)
        .endContainer().endSpec().endTemplate().endSpec()
        .build()).once();
    KubernetesClient client = server.getClient();

    // When
    Deployment deployment = client.apps().deployments().inNamespace("ns1").withName("deploy1")
      .rolling().updateImage(imageToUpdate);

    // Then
    assertNotNull(deployment);
    assertEquals(imageToUpdate, deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("PATCH", recordedRequest.getMethod());
    assertTrue(recordedRequest.getBody().readUtf8().contains(imageToUpdate));
  }

  @Test
  @DisplayName("Should update image based in map based argument")
  void testRolloutUpdateImage() throws InterruptedException {
    // Given
    Map<String, String> containerToImageMap = Collections.singletonMap("nginx", "nginx:latest");
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).times(3);
    server.expect().patch().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder()
        .editSpec().editTemplate().editSpec().editContainer(0)
        .withImage(containerToImageMap.get("nginx"))
        .endContainer().endSpec().endTemplate().endSpec()
        .build()).once();
    KubernetesClient client = server.getClient();

    // When
    Deployment deployment = client.apps().deployments().inNamespace("ns1").withName("deploy1")
      .rolling().updateImage(containerToImageMap);

    // Then
    assertNotNull(deployment);
    assertEquals(containerToImageMap.get("nginx"), deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("PATCH", recordedRequest.getMethod());
    assertTrue(recordedRequest.getBody().readUtf8().contains(containerToImageMap.get("nginx")));
  }

  @Test
  @DisplayName("Should pause resource")
  void testRolloutPause() throws InterruptedException {
    // Given
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).times(3);
    server.expect().patch().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).once();
    KubernetesClient client = server.getClient();

    // When
    Deployment deployment = client.apps().deployments().inNamespace("ns1").withName("deploy1")
      .rolling().pause();

    // Then
    RecordedRequest recordedRequest = server.getLastRequest();
    assertNotNull(deployment);
    assertEquals("PATCH", recordedRequest.getMethod());
    assertEquals("{\"spec\":{\"paused\":true}}", recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should resume rollout")
  void testRolloutResume() throws InterruptedException {
    // Given
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).times(3);
    server.expect().patch().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).once();
    KubernetesClient client = server.getClient();

    // When
    Deployment deployment = client.apps().deployments().inNamespace("ns1").withName("deploy1")
      .rolling().resume();

    // Then
    RecordedRequest recordedRequest = server.getLastRequest();
    assertNotNull(deployment);
    assertEquals("PATCH", recordedRequest.getMethod());
    assertEquals("{\"spec\":{\"paused\":null}}", recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should restart rollout")
  void testRolloutRestart() throws InterruptedException {
    // Given
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).times(3);
    server.expect().patch().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).once();
    KubernetesClient client = server.getClient();

    // When
    Deployment deployment = client.apps().deployments().inNamespace("ns1").withName("deploy1")
      .rolling().restart();

    // Then
    RecordedRequest recordedRequest = server.getLastRequest();
    assertNotNull(deployment);
    assertEquals("PATCH", recordedRequest.getMethod());
    assertTrue(recordedRequest.getBody().readUtf8().contains("kubectl.kubernetes.io/restartedAt"));
  }

  @Test
  @DisplayName("Should undo rollout")
  void testRolloutUndo() throws InterruptedException {
    // Given
    ReplicaSet replicaSetRevision1 = new ReplicaSetBuilder()
      .withNewMetadata()
      .addToAnnotations("deployment.kubernetes.io/revision", "1")
      .withName("rs1")
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .withNewSelector().addToMatchLabels("app", "nginx").endSelector()
      .withNewTemplate()
      .withNewMetadata()
      .addToAnnotations("kubectl.kubernetes.io/restartedAt", "2020-06-08T11:52:50.022")
      .addToAnnotations("app", "rs1")
      .addToLabels("app", "nginx")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("nginx")
      .withImage("nginx:perl")
      .addNewPort().withContainerPort(80).endPort()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();
    ReplicaSet replicaSetRevision2 = new ReplicaSetBuilder()
      .withNewMetadata()
      .addToAnnotations("deployment.kubernetes.io/revision", "2")
      .withName("rs2")
      .endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .withNewSelector().addToMatchLabels("app", "nginx").endSelector()
      .withNewTemplate()
      .withNewMetadata()
      .addToAnnotations("kubectl.kubernetes.io/restartedAt", "2020-06-08T11:52:50.022")
      .addToAnnotations("app", "rs2")
      .addToLabels("app", "nginx")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("nginx")
      .withImage("nginx:1.19")
      .addNewPort().withContainerPort(80).endPort()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();

    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/replicasets?labelSelector=" + Utils.toUrlEncoded("app=nginx"))
      .andReturn(HttpURLConnection.HTTP_OK, new ReplicaSetListBuilder().withItems(replicaSetRevision1, replicaSetRevision2).build()).once();
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).times(3);
    server.expect().patch().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build()).once();
    KubernetesClient client = server.getClient();

    // When
    Deployment deployment = client.apps().deployments().inNamespace("ns1").withName("deploy1")
      .rolling().undo();

    // Then
    RecordedRequest recordedRequest = server.getLastRequest();
    assertNotNull(deployment);
    assertEquals("PATCH", recordedRequest.getMethod());
    assertTrue(recordedRequest.getBody().readUtf8().contains("\"app\":\"rs1\""));
  }

  @Test
  @DisplayName("Should get logs for a Deployment")
  void testDeploymentGetLog() {
    // Given
    ReplicaSet replicaSet = new ReplicaSetBuilder()
      .withNewMetadata()
      .withOwnerReferences(
        new OwnerReferenceBuilder()
        .withApiVersion("apps/v1")
        .withBlockOwnerDeletion(true)
        .withController(true)
        .withKind("Deployment")
        .withName("deploy1")
        .withUid("136581bf-82c2-4675-af05-63c55500b378")
        .build()
      )
      .withName("deploy1-hk9nf")
      .addToLabels("app", "nginx")
      .withUid("3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
      .endMetadata()
      .build();

    Pod deployPod = new PodBuilder()
      .withNewMetadata()
      .withOwnerReferences(new OwnerReferenceBuilder().withApiVersion("apps/v1")
        .withBlockOwnerDeletion(true)
        .withController(true)
        .withKind("ReplicaSet")
        .withName("1")
        .withUid("3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
        .build())
      .withName("deploy1-hk9nf").addToLabels("controller-uid", "3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
      .endMetadata()
      .build();

    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/deployments/deploy1")
      .andReturn(HttpURLConnection.HTTP_OK, getDeploymentBuilder().build())
      .always();

    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/replicasets?labelSelector=app%3Dnginx")
      .andReturn(HttpURLConnection.HTTP_OK, new ReplicaSetListBuilder().withItems(replicaSet).build())
      .once();
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/replicasets/deploy1-hk9nf")
      .andReturn(HttpURLConnection.HTTP_OK, replicaSet)
      .once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?labelSelector=app%3Dnginx")
      .andReturn(HttpURLConnection.HTTP_OK, new PodListBuilder().withItems(deployPod).build())
      .once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods/deploy1-hk9nf/log?pretty=false")
      .andReturn(HttpURLConnection.HTTP_OK, "hello")
      .once();
    KubernetesClient client = server.getClient();

    // When
    String log = client.apps().deployments().inNamespace("ns1").withName("deploy1").getLog();

    // Then
    assertNotNull(log);
    assertEquals("hello", log);
  }

  private DeploymentBuilder getDeploymentBuilder() {
    return new DeploymentBuilder()
      .withNewMetadata()
      .withName("deploy1")
      .withUid("136581bf-82c2-4675-af05-63c55500b378")
      .addToLabels("app", "nginx")
      .addToAnnotations("app", "nginx")
      .endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .withNewSelector()
      .addToMatchLabels("app", "nginx")
      .endSelector()
      .withNewTemplate()
      .withNewMetadata().addToLabels("app", "nginx").endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("nginx")
      .withImage("nginx:1.7.9")
      .addNewPort().withContainerPort(80).endPort()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec();
  }

}
