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
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.ReplicationControllerListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class ReplicationControllerTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testList() {
    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers")
        .andReturn(200, new ReplicationControllerListBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/replicationcontrollers")
        .andReturn(200, new ReplicationControllerListBuilder()
            .addNewItem().and()
            .addNewItem().and().build())
        .once();

    ReplicationControllerList replicationControllerList = client.replicationControllers().list();
    assertNotNull(replicationControllerList);
    assertEquals(0, replicationControllerList.getItems().size());

    replicationControllerList = client.replicationControllers().inNamespace("ns1").list();
    assertNotNull(replicationControllerList);
    assertEquals(2, replicationControllerList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/repl1")
        .andReturn(200, new ReplicationControllerBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/replicationcontrollers/repl2")
        .andReturn(200, new ReplicationControllerBuilder().build()).once();

    ReplicationController repl1 = client.replicationControllers().withName("repl1").get();
    assertNotNull(repl1);

    repl1 = client.replicationControllers().withName("repl2").get();
    assertNull(repl1);

    repl1 = client.replicationControllers().inNamespace("ns1").withName("repl2").get();
    assertNotNull(repl1);
  }

  @Test
  void testDelete() {
    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/repl1")
        .andReturn(200, new ReplicationControllerBuilder().withNewMetadata()
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

    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/repl1")
        .andReturn(200, new ReplicationControllerBuilder().withNewMetadata()
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

    server.expect().withPath("/api/v1/namespaces/ns1/replicationcontrollers/repl2")
        .andReturn(200, new ReplicationControllerBuilder().withNewMetadata()
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

    server.expect().withPath("/api/v1/namespaces/ns1/replicationcontrollers/repl2")
        .andReturn(200, new ReplicationControllerBuilder().withNewMetadata()
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

    boolean deleted = client.replicationControllers().withName("repl1").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.replicationControllers().withName("repl2").delete().size() == 1;
    assertFalse(deleted);

    deleted = client.replicationControllers().inNamespace("ns1").withName("repl2").delete().size() == 1;
    assertTrue(deleted);
  }

  @Disabled
  @Test
  void testUpdate() {
    ReplicationController repl1 = new ReplicationControllerBuilder()
        .withNewMetadata()
        .withName("repl1")
        .withNamespace("test")
        .endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .withNewTemplate()
        .withNewMetadata().withLabels(new HashMap<String, String>()).endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withImage("img1")
        .endContainer()
        .endSpec()
        .endTemplate()
        .endSpec()
        .withNewStatus().withReplicas(1).endStatus()
        .build();

    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/repl1").andReturn(200, repl1).once();
    server.expect().put().withPath("/api/v1/namespaces/test/replicationcontrollers/repl1").andReturn(200, repl1).once();
    server.expect().get().withPath("/api/v1/namespaces/test/replicationcontrollers")
        .andReturn(200, new ReplicationControllerListBuilder().withItems(repl1).build()).once();
    server.expect().post().withPath("/api/v1/namespaces/test/replicationcontrollers").andReturn(201, repl1).once();
    server.expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new KubernetesListBuilder().build()).once();

    repl1 = client.replicationControllers().withName("repl1")
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
    server.expect().get().withPath("/api/v1/namespaces/ns1/replicationcontrollers/replicationcontroller1")
        .andReturn(HttpURLConnection.HTTP_OK, createReplicationControllerBuilder().build()).times(3);
    server.expect().patch().withPath("/api/v1/namespaces/ns1/replicationcontrollers/replicationcontroller1")
        .andReturn(HttpURLConnection.HTTP_OK, createReplicationControllerBuilder()
            .editSpec().editTemplate().editSpec().editContainer(0)
            .withImage(imageToUpdate)
            .endContainer().endSpec().endTemplate().endSpec()
            .build())
        .once();

    // When
    ReplicationController replicationController = client.replicationControllers().inNamespace("ns1")
        .withName("replicationcontroller1")
        .rolling().updateImage(imageToUpdate);

    // Then
    assertNotNull(replicationController);
    assertEquals(imageToUpdate, replicationController.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
    assertTrue(server.getLastRequest().getBody().readUtf8().contains(imageToUpdate));
  }

  @Test
  @DisplayName("Should update image based in map based argument")
  void testRolloutUpdateImage() throws InterruptedException {
    // Given
    Map<String, String> containerToImageMap = Collections.singletonMap("nginx", "nginx:latest");
    server.expect().get().withPath("/api/v1/namespaces/ns1/replicationcontrollers/replicationcontroller1")
        .andReturn(HttpURLConnection.HTTP_OK, createReplicationControllerBuilder().build()).times(3);
    server.expect().patch().withPath("/api/v1/namespaces/ns1/replicationcontrollers/replicationcontroller1")
        .andReturn(HttpURLConnection.HTTP_OK, createReplicationControllerBuilder()
            .editSpec().editTemplate().editSpec().editContainer(0)
            .withImage(containerToImageMap.get("nginx"))
            .endContainer().endSpec().endTemplate().endSpec()
            .build())
        .once();

    // When
    ReplicationController replicationController = client.replicationControllers().inNamespace("ns1")
        .withName("replicationcontroller1")
        .rolling().updateImage(containerToImageMap);

    // Then
    assertNotNull(replicationController);
    assertEquals(containerToImageMap.get("nginx"),
        replicationController.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
    assertTrue(server.getLastRequest().getBody().readUtf8().contains(containerToImageMap.get("nginx")));
  }

  @Test
  void testGetLog() {
    // Given
    ReplicationController replicationController = createReplicationControllerBuilder().build();
    server.expect().get().withPath("/api/v1/namespaces/ns1/replicationcontrollers/replicationcontroller1")
        .andReturn(HttpURLConnection.HTTP_OK, replicationController).times(3);
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?labelSelector=" + Utils.toUrlEncoded("app=nginx"))
        .andReturn(HttpURLConnection.HTTP_OK, getReplicationControllerPodList(replicationController)).once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods/pod1/log?pretty=true")
        .andReturn(HttpURLConnection.HTTP_OK, "testlog").once();

    // When
    String log = client.replicationControllers().inNamespace("ns1").withName("replicationcontroller1").getLog(true);

    // Then
    assertNotNull(log);
    assertEquals("testlog", log);
  }

  @Test
  void testGetLogMultiContainer() {
    // Given
    ReplicationController replicationController = createReplicationControllerBuilder().build();
    server.expect().get().withPath("/api/v1/namespaces/ns1/replicationcontrollers/replicationcontroller1")
        .andReturn(HttpURLConnection.HTTP_OK, replicationController).times(3);
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?labelSelector=" + Utils.toUrlEncoded("app=nginx"))
        .andReturn(HttpURLConnection.HTTP_OK, getReplicationControllerPodList(replicationController)).once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods/pod1/log?pretty=false&container=c1")
        .andReturn(HttpURLConnection.HTTP_OK, "testlog").once();

    // When
    String log = client.replicationControllers().inNamespace("ns1").withName("replicationcontroller1").inContainer("c1")
        .getLog();

    // Then
    assertNotNull(log);
    assertEquals("testlog", log);
  }

  private ReplicationControllerBuilder createReplicationControllerBuilder() {
    return new ReplicationControllerBuilder()
        .withNewMetadata()
        .withName("replicationcontroller1")
        .withUid("0a133177-0c55-49de-82bb-0d97d9444cb2")
        .addToLabels("app", "nginx")
        .addToLabels("foo", "bar")
        .addToAnnotations("app", "nginx")
        .endMetadata()
        .withNewSpec()
        .addToSelector("app", "nginx")
        .withReplicas(1)
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

  private PodList getReplicationControllerPodList(ReplicationController rc) {
    return new PodListBuilder()
        .addToItems(new PodBuilder().withNewMetadata()
            .withName("pod1")
            .addToLabels("app", "nginx")
            .addNewOwnerReference()
            .withApiVersion("v1")
            .withController(true)
            .withUid(rc.getMetadata().getUid())
            .endOwnerReference()
            .endMetadata()
            .build())
        .build();
  }

}
