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

import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.OwnerReferenceBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.apps.ControllerRevision;
import io.fabric8.kubernetes.api.model.apps.ControllerRevisionBuilder;
import io.fabric8.kubernetes.api.model.apps.ControllerRevisionListBuilder;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetBuilder;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.api.model.apps.StatefulSetListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Deletable;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class StatefulSetTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  public void testList() {
    server.expect()
        .withPath("/apis/apps/v1/namespaces/test/statefulsets")
        .andReturn(200, new StatefulSetListBuilder().build())
        .once();
    server.expect()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets")
        .andReturn(200, new StatefulSetListBuilder()
            .addNewItem()
            .and()
            .addNewItem()
            .and()
            .build())
        .once();

    StatefulSetList statefulSetList = client.apps().statefulSets().list();
    assertNotNull(statefulSetList);
    assertEquals(0, statefulSetList.getItems().size());

    statefulSetList = client.apps().statefulSets().inNamespace("ns1").list();
    assertNotNull(statefulSetList);
    assertEquals(2, statefulSetList.getItems().size());
  }

  @Test
  public void testGet() {
    server.expect()
        .withPath("/apis/apps/v1/namespaces/test/statefulsets/repl1")
        .andReturn(200, new StatefulSetBuilder().build())
        .once();
    server.expect()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/repl2")
        .andReturn(200, new StatefulSetBuilder().build())
        .once();

    StatefulSet repl1 = client.apps().statefulSets().withName("repl1").get();
    assertNotNull(repl1);

    repl1 = client.apps().statefulSets().withName("repl2").get();
    assertNull(repl1);

    repl1 = client.apps().statefulSets().inNamespace("ns1").withName("repl2").get();
    assertNotNull(repl1);
  }

  @Test
  public void testDelete() {
    server.expect()
        .withPath("/apis/apps/v1/namespaces/test/statefulsets/repl1")
        .andReturn(200, new StatefulSetBuilder().withNewMetadata()
            .withName("repl1")
            .withResourceVersion("1")
            .endMetadata()
            .withNewSpec()
            .withReplicas(0)
            .endSpec()
            .withNewStatus()
            .withReplicas(1)
            .endStatus()
            .build())
        .once();

    server.expect()
        .withPath("/apis/apps/v1/namespaces/test/statefulsets/repl1")
        .andReturn(200, new StatefulSetBuilder().withNewMetadata()
            .withName("repl1")
            .withResourceVersion("1")
            .endMetadata()
            .withNewSpec()
            .withReplicas(0)
            .endSpec()
            .withNewStatus()
            .withReplicas(0)
            .endStatus()
            .build())
        .times(5);

    server.expect()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/repl2")
        .andReturn(200, new StatefulSetBuilder().withNewMetadata()
            .withName("repl2")
            .withResourceVersion("1")
            .endMetadata()
            .withNewSpec()
            .withReplicas(0)
            .endSpec()
            .withNewStatus()
            .withReplicas(1)
            .endStatus()
            .build())
        .once();

    server.expect()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/repl2")
        .andReturn(200, new StatefulSetBuilder().withNewMetadata()
            .withName("repl2")
            .withResourceVersion("1")
            .endMetadata()
            .withNewSpec()
            .withReplicas(0)
            .endSpec()
            .withNewStatus()
            .withReplicas(0)
            .endStatus()
            .build())
        .times(5);

    boolean deleted = client.apps().statefulSets().withName("repl1").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.apps().statefulSets().withName("repl2").delete().size() == 1;
    assertFalse(deleted);

    deleted = client.apps().statefulSets().inNamespace("ns1").withName("repl2").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  public void testDeleteLoadedResource() {
    StatefulSet response = client.apps().statefulSets().load(getClass().getResourceAsStream("/test-statefulset.yml")).item();
    server.expect()
        .delete()
        .withPath("/apis/apps/v1/namespaces/test/statefulsets/example")
        .andReturn(200, response)
        .once();

    Deletable items = client.load(getClass().getResourceAsStream("/test-statefulset.yml"));
    assertTrue(items.delete().size() == 1);
  }

  @Disabled
  @Test
  public void testUpdate() {
    StatefulSet repl1 = new StatefulSetBuilder()
        .withNewMetadata()
        .withName("repl1")
        .withNamespace("test")
        .endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .withNewTemplate()
        .withNewMetadata()
        .withLabels(new HashMap<String, String>())
        .endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withImage("img1")
        .endContainer()
        .endSpec()
        .endTemplate()
        .endSpec()
        .withNewStatus()
        .withReplicas(1)
        .endStatus()
        .build();

    server.expect().withPath("/apis/apps/v1/namespaces/test/statefulsets/repl1").andReturn(200, repl1).once();
    server.expect().put().withPath("/apis/apps/v1/namespaces/test/statefulsets/repl1").andReturn(200, repl1).once();
    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/test/statefulsets")
        .andReturn(200, new StatefulSetListBuilder().withItems(repl1).build())
        .once();
    server.expect().post().withPath("/apis/apps/v1/namespaces/test/statefulsets").andReturn(201, repl1).once();
    server.expect()
        .withPath("/apis/apps/v1/namespaces/test/pods")
        .andReturn(200, new KubernetesListBuilder().build())
        .once();

    repl1 = client.apps()
        .statefulSets()
        .withName("repl1")
        .rolling()
        .withTimeout(5, TimeUnit.MINUTES)
        .updateImage("");
    assertNotNull(repl1);
  }

  @Test
  @DisplayName("Should update image based in single argument")
  void testRolloutUpdateSingleImage() throws InterruptedException {
    // Given
    String imageToUpdate = "nginx:latest";
    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .times(3);
    server.expect()
        .patch()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder()
            .editSpec()
            .editTemplate()
            .editSpec()
            .editContainer(0)
            .withImage(imageToUpdate)
            .endContainer()
            .endSpec()
            .endTemplate()
            .endSpec()
            .build())
        .once();

    // When
    StatefulSet statefulSet = client.apps()
        .statefulSets()
        .inNamespace("ns1")
        .withName("statefulset1")
        .rolling()
        .updateImage(imageToUpdate);

    // Then
    RecordedRequest recordedRequest = server.getLastRequest();
    assertNotNull(statefulSet);
    assertEquals(imageToUpdate, statefulSet.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
    assertEquals("PATCH", recordedRequest.getMethod());
    assertTrue(recordedRequest.getBody().readUtf8().contains(imageToUpdate));
  }

  @Test
  @DisplayName("Should update image based in map based argument")
  void testRolloutUpdateImage() throws InterruptedException {
    // Given
    Map<String, String> containerToImageMap = Collections.singletonMap("nginx", "nginx:latest");
    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .times(3);
    server.expect()
        .patch()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder()
            .editSpec()
            .editTemplate()
            .editSpec()
            .editContainer(0)
            .withImage(containerToImageMap.get("nginx"))
            .endContainer()
            .endSpec()
            .endTemplate()
            .endSpec()
            .build())
        .once();

    // When
    StatefulSet deployment = client.apps()
        .statefulSets()
        .inNamespace("ns1")
        .withName("statefulset1")
        .rolling()
        .updateImage(containerToImageMap);

    // Then
    assertNotNull(deployment);
    assertEquals(containerToImageMap.get("nginx"),
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
    assertTrue(server.getLastRequest().getBody().readUtf8().contains(containerToImageMap.get("nginx")));
  }

  @Test
  @DisplayName("Should not pause resource")
  void testRolloutPauseUnsupported() throws InterruptedException {
    // Given
    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .times(3);
    server.expect()
        .patch()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .once();

    // When
    TimeoutImageEditReplacePatchable<StatefulSet> rolling = client.apps()
        .statefulSets()
        .inNamespace("ns1")
        .withName("statefulset1")
        .rolling();

    // Then
    assertThrows(KubernetesClientException.class, () -> rolling.pause());
  }

  @Test
  @DisplayName("Should not resume rollout")
  void testRolloutResumeUnsupported() throws InterruptedException {
    // Given
    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .times(3);
    server.expect()
        .patch()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .once();

    // When
    TimeoutImageEditReplacePatchable<StatefulSet> rolling = client.apps()
        .statefulSets()
        .inNamespace("ns1")
        .withName("statefulset1")
        .rolling();

    // Then
    assertThrows(KubernetesClientException.class, () -> rolling.resume());
  }

  @Test
  @DisplayName("Should restart rollout")
  void testRolloutRestart() throws InterruptedException {
    // Given
    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .times(3);
    server.expect()
        .patch()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .once();

    // When
    StatefulSet deployment = client.apps()
        .statefulSets()
        .inNamespace("ns1")
        .withName("statefulset1")
        .rolling()
        .restart();

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
    ControllerRevision controllerRevision1 = new ControllerRevisionBuilder()
        .withNewMetadata()
        .addToAnnotations("deployment.kubernetes.io/revision", "1")
        .withName("rs1")
        .endMetadata()
        .withRevision(1L)
        .withNewStatefulSetData()
        .withNewSpec()
        .withReplicas(0)
        .withNewSelector()
        .addToMatchLabels("app", "nginx")
        .endSelector()
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
        .addNewPort()
        .withContainerPort(80)
        .endPort()
        .endContainer()
        .endSpec()
        .endTemplate()
        .endSpec()
        .endStatefulSetData()
        .build();
    ControllerRevision controllerRevision2 = new ControllerRevisionBuilder()
        .withNewMetadata()
        .addToAnnotations("deployment.kubernetes.io/revision", "2")
        .withName("rs2")
        .endMetadata()
        .withRevision(2L)
        .withNewStatefulSetData()
        .withNewSpec()
        .withReplicas(1)
        .withNewSelector()
        .addToMatchLabels("app", "nginx")
        .endSelector()
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
        .addNewPort()
        .withContainerPort(80)
        .endPort()
        .endContainer()
        .endSpec()
        .endTemplate()
        .endSpec()
        .endStatefulSetData()
        .build();

    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/ns1/controllerrevisions?labelSelector=" + Utils.toUrlEncoded("app=nginx"))
        .andReturn(HttpURLConnection.HTTP_OK,
            new ControllerRevisionListBuilder().withItems(controllerRevision1, controllerRevision2).build())
        .once();
    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .times(3);
    server.expect()
        .patch()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .once();

    // When
    StatefulSet deployment = client.apps()
        .statefulSets()
        .inNamespace("ns1")
        .withName("statefulset1")
        .rolling()
        .undo();

    // Then
    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("PATCH", recordedRequest.getMethod());
    assertTrue(recordedRequest.getBody().readUtf8().contains("\"app\":\"rs1\""));
  }

  @Test
  @DisplayName("Should test get logs from statefulset")
  void testGetLogStatefulSet() {
    // Given
    Pod jobPod = createPod();

    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .always();

    server.expect()
        .get()
        .withPath("/api/v1/namespaces/ns1/pods?labelSelector=app%3Dnginx")
        .andReturn(HttpURLConnection.HTTP_OK, new PodListBuilder().withItems(jobPod).build())
        .once();
    server.expect()
        .get()
        .withPath("/api/v1/namespaces/ns1/pods/ss-hk9nf/log?pretty=false")
        .andReturn(HttpURLConnection.HTTP_OK, "hello")
        .once();

    // When
    String log = client.apps().statefulSets().inNamespace("ns1").withName("statefulset1").getLog();

    // Then
    assertNotNull(log);
    assertEquals("hello", log);
  }

  @Test
  @DisplayName("Should test get logs from multi-container statefulset")
  void testGetLogStatefulSetMultiContainer() {
    // Given
    Pod jobPod = createPod();

    server.expect()
        .get()
        .withPath("/apis/apps/v1/namespaces/ns1/statefulsets/statefulset1")
        .andReturn(HttpURLConnection.HTTP_OK, createStatefulSetBuilder().build())
        .always();

    server.expect()
        .get()
        .withPath("/api/v1/namespaces/ns1/pods?labelSelector=app%3Dnginx")
        .andReturn(HttpURLConnection.HTTP_OK, new PodListBuilder().withItems(jobPod).build())
        .once();
    server.expect()
        .get()
        .withPath("/api/v1/namespaces/ns1/pods/ss-hk9nf/log?pretty=false&container=c1")
        .andReturn(HttpURLConnection.HTTP_OK, "hello")
        .once();

    // When
    String log = client.apps().statefulSets().inNamespace("ns1").withName("statefulset1").inContainer("c1").getLog();

    // Then
    assertNotNull(log);
    assertEquals("hello", log);
  }

  private Pod createPod() {
    return new PodBuilder()
        .withNewMetadata()
        .withOwnerReferences(new OwnerReferenceBuilder().withApiVersion("apps/v1")
            .withBlockOwnerDeletion(true)
            .withController(true)
            .withKind("StatefulSet")
            .withName("pi")
            .withUid("3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
            .build())
        .withName("ss-hk9nf")
        .addToLabels("controller-uid", "3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
        .endMetadata()
        .build();
  }

  private StatefulSetBuilder createStatefulSetBuilder() {
    return new StatefulSetBuilder()
        .withNewMetadata()
        .withName("statefulset1")
        .withUid("3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
        .addToLabels("app", "nginx")
        .addToAnnotations("app", "nginx")
        .endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .withNewSelector()
        .addToMatchLabels("app", "nginx")
        .endSelector()
        .withNewTemplate()
        .withNewMetadata()
        .addToLabels("app", "nginx")
        .endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("nginx")
        .withImage("nginx:1.7.9")
        .addNewPort()
        .withContainerPort(80)
        .endPort()
        .endContainer()
        .endSpec()
        .endTemplate()
        .endSpec();
  }
}
