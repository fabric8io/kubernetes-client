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
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetListBuilder;
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
class ReplicaSetTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testList() {
    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets").andReturn(200, new ReplicaSetListBuilder().build())
        .once();
    server.expect().withPath("/apis/apps/v1/namespaces/ns1/replicasets").andReturn(200, new ReplicaSetListBuilder()
        .addNewItem().and()
        .addNewItem().and().build())
        .once();

    ReplicaSetList replicaSetList = client.apps().replicaSets().list();
    assertNotNull(replicaSetList);
    assertEquals(0, replicaSetList.getItems().size());

    replicaSetList = client.apps().replicaSets().inNamespace("ns1").list();
    assertNotNull(replicaSetList);
    assertEquals(2, replicaSetList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1").andReturn(200, new ReplicaSetBuilder().build())
        .once();
    server.expect().withPath("/apis/apps/v1/namespaces/ns1/replicasets/repl2").andReturn(200, new ReplicaSetBuilder().build())
        .once();

    ReplicaSet repl1 = client.apps().replicaSets().withName("repl1").get();
    assertNotNull(repl1);

    repl1 = client.apps().replicaSets().withName("repl2").get();
    assertNull(repl1);

    repl1 = client.apps().replicaSets().inNamespace("ns1").withName("repl2").get();
    assertNotNull(repl1);
  }

  @Test
  void testDelete() {
    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1")
        .andReturn(200, new ReplicaSetBuilder().withNewMetadata()
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

    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1")
        .andReturn(200, new ReplicaSetBuilder().withNewMetadata()
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

    server.expect().withPath("/apis/apps/v1/namespaces/ns1/replicasets/repl2")
        .andReturn(200, new ReplicaSetBuilder().withNewMetadata()
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

    server.expect().withPath("/apis/apps/v1/namespaces/ns1/replicasets/repl2")
        .andReturn(200, new ReplicaSetBuilder().withNewMetadata()
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

    boolean deleted = client.apps().replicaSets().withName("repl1").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.apps().replicaSets().withName("repl2").delete().size() == 1;
    assertFalse(deleted);

    deleted = client.apps().replicaSets().inNamespace("ns1").withName("repl2").delete().size() == 1;
    assertTrue(deleted);
  }

  @Disabled
  @Test
  void testUpdate() {
    ReplicaSet repl1 = new ReplicaSetBuilder()
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

    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1").andReturn(200, repl1).once();
    server.expect().put().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1").andReturn(200, repl1).once();
    server.expect().get().withPath("/apis/apps/v1/namespaces/test/replicasets")
        .andReturn(200, new ReplicaSetListBuilder().withItems(repl1).build()).once();
    server.expect().post().withPath("/apis/apps/v1/namespaces/test/replicasets").andReturn(201, repl1).once();
    server.expect().withPath("/apis/apps/v1/namespaces/test/pods").andReturn(200, new KubernetesListBuilder().build()).once();

    repl1 = client.apps().replicaSets().withName("repl1")
        .rolling()
        .withTimeout(5, TimeUnit.MINUTES)
        .updateImage("");
    assertNotNull(repl1);
  }

  @Test
  void testDeprecatedApiVersion() {
    io.fabric8.kubernetes.api.model.extensions.ReplicaSet repl1 = new io.fabric8.kubernetes.api.model.extensions.ReplicaSetBuilder()
        .withApiVersion("extensions/v1beta1")
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

    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets").andReturn(200, repl1).once();

    client.resource(repl1).inNamespace("test").createOrReplace();
  }

  @Test
  @DisplayName("Should update image based in single argument")
  void testRolloutUpdateSingleImage() throws InterruptedException {
    // Given
    String imageToUpdate = "nginx:latest";
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/replicasets/replicaset1")
        .andReturn(HttpURLConnection.HTTP_OK, createReplicaSetBuilder().build()).times(3);
    server.expect().patch().withPath("/apis/apps/v1/namespaces/ns1/replicasets/replicaset1")
        .andReturn(HttpURLConnection.HTTP_OK, createReplicaSetBuilder()
            .editSpec().editTemplate().editSpec().editContainer(0)
            .withImage(imageToUpdate)
            .endContainer().endSpec().endTemplate().endSpec()
            .build())
        .times(2);

    // When
    ReplicaSet replicationController = client.apps().replicaSets().inNamespace("ns1").withName("replicaset1")
        .rolling().updateImage(imageToUpdate);

    // Then
    assertNotNull(replicationController);
    assertEquals(imageToUpdate, replicationController.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
    int requestCount = server.getRequestCount();
    assertTrue(server.getLastRequest().getBody().readUtf8().contains(imageToUpdate));
  }

  @Test
  @DisplayName("Should update image based in map based argument")
  void testRolloutUpdateImage() throws InterruptedException {
    // Given
    Map<String, String> containerToImageMap = Collections.singletonMap("nginx", "nginx:latest");
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/replicasets/replicaset1")
        .andReturn(HttpURLConnection.HTTP_OK, createReplicaSetBuilder().build()).times(3);
    server.expect().patch().withPath("/apis/apps/v1/namespaces/ns1/replicasets/replicaset1")
        .andReturn(HttpURLConnection.HTTP_OK, createReplicaSetBuilder()
            .editSpec().editTemplate().editSpec().editContainer(0)
            .withImage(containerToImageMap.get("nginx"))
            .endContainer().endSpec().endTemplate().endSpec()
            .build())
        .once();

    // When
    ReplicaSet replicationController = client.apps().replicaSets().inNamespace("ns1").withName("replicaset1")
        .rolling().updateImage(containerToImageMap);

    // Then
    assertNotNull(replicationController);
    assertEquals(containerToImageMap.get("nginx"),
        replicationController.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
    assertTrue(server.getLastRequest().getBody().readUtf8().contains(containerToImageMap.get("nginx")));
  }

  @Test
  void testGetLog() {
    ReplicaSet replicaSet = createReplicaSetBuilder().build();
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/replicasets/replicaset1")
        .andReturn(HttpURLConnection.HTTP_OK, replicaSet).times(3);
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?labelSelector=" + Utils.toUrlEncoded("app=nginx"))
        .andReturn(HttpURLConnection.HTTP_OK, getReplicaSetPodList(replicaSet)).once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods/pod1/log?pretty=true")
        .andReturn(HttpURLConnection.HTTP_OK, "testlog").once();

    // When
    String log = client.apps().replicaSets().inNamespace("ns1").withName("replicaset1").getLog(true);

    // Then
    assertNotNull(log);
    assertEquals("testlog", log);
  }

  @Test
  void testGetLogMultiContainer() {
    ReplicaSet replicaSet = createReplicaSetBuilder().build();
    server.expect().get().withPath("/apis/apps/v1/namespaces/ns1/replicasets/replicaset1")
        .andReturn(HttpURLConnection.HTTP_OK, replicaSet).times(3);
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?labelSelector=" + Utils.toUrlEncoded("app=nginx"))
        .andReturn(HttpURLConnection.HTTP_OK, getReplicaSetPodList(replicaSet)).once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods/pod1/log?pretty=true&container=c1")
        .andReturn(HttpURLConnection.HTTP_OK, "testlog").once();

    // When
    String log = client.apps().replicaSets().inNamespace("ns1").withName("replicaset1").inContainer("c1").getLog(true);

    // Then
    assertNotNull(log);
    assertEquals("testlog", log);
  }

  private ReplicaSetBuilder createReplicaSetBuilder() {
    return new ReplicaSetBuilder()
        .withNewMetadata()
        .withName("replicaset1")
        .addToLabels("app", "nginx")
        .addToAnnotations("app", "nginx")
        .withUid("0a133177-0c55-49de-82bb-0d97d9444cb2")
        .endMetadata()
        .withNewSpec()
        .withNewSelector()
        .addToMatchLabels("app", "nginx")
        .endSelector()
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

  private PodList getReplicaSetPodList(ReplicaSet rc) {
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
