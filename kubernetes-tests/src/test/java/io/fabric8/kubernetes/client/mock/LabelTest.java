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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class LabelTest {

  KubernetesMockServer server;
  KubernetesClient client;

  static Pod pod1 = null, pod2 = null;

  @BeforeEach
  void init() {
    pod1 = new PodBuilder()
        .withNewMetadata().withName("pod1").addToLabels("foo", "bar").endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("test")
        .withImage("nginx")
        .addNewPort().withContainerPort(80).endPort()
        .endContainer()
        .endSpec()
        .build();

    pod2 = new PodBuilder()
        .withNewMetadata().withName("pod2").addToLabels("app", "busybox").endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withImage("busybox")
        .withCommand("sleep", "3600")
        .withImagePullPolicy("IfNotPresent")
        .withName("busybox")
        .endContainer()
        .withRestartPolicy("Always")
        .endSpec()
        .build();
  }

  @Test
  void testBasicList() {
    server.expect().get().withPath("/api/v1/namespaces/test/pods")
        .andReturn(200, new PodListBuilder().withItems(pod1, pod2).build())
        .once();

    PodList list = client.pods().inNamespace("test").list();
    assertNotNull(list);
    assertEquals(2, list.getItems().size());
  }

  @Test
  void testWithLabels() {
    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("foo=bar"))
        .andReturn(200, new PodListBuilder().withItems(pod1).build())
        .once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("app=nginx,foo=bar"))
        .andReturn(200, new PodListBuilder().build())
        .once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("app=nginx"))
        .andReturn(200, new PodListBuilder().withItems(pod2).build())
        .once();

    Map<String, String> filterLabels = new HashMap<>();

    filterLabels.put("foo", "bar");
    PodList list = client.pods().inNamespace("test").withLabels(filterLabels).list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());

    filterLabels.put("app", "nginx");
    list = client.pods().inNamespace("test").withLabels(filterLabels).list();
    assertNotNull(list);
    assertEquals(0, list.getItems().size());

    filterLabels.remove("foo");
    list = client.pods().inNamespace("test").withLabels(filterLabels).list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());
  }

  @Test
  void testWithLabel() {
    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=foo")
        .andReturn(200, new PodListBuilder().withItems(pod1).build())
        .once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=app")
        .andReturn(200, new PodListBuilder().withItems(pod2).build())
        .once();

    PodList list = client.pods().inNamespace("test").withLabel("foo").list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());

    list = client.pods().inNamespace("test").withLabel("app").list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());
  }

  @Test
  void testWithoutLabels() {
    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("foo!=bar"))
        .andReturn(200, new PodListBuilder().withItems(pod2).build())
        .once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("app!=nginx,foo!=bar"))
        .andReturn(200, new PodListBuilder().build())
        .once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("app!=nginx"))
        .andReturn(200, new PodListBuilder().withItems(pod1).build())
        .once();

    Map<String, String> filterLabels = new HashMap<>();

    filterLabels.put("foo", "bar");
    PodList list = client.pods().inNamespace("test").withoutLabels(filterLabels).list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());

    filterLabels.put("app", "nginx");
    list = client.pods().inNamespace("test").withoutLabels(filterLabels).list();
    assertNotNull(list);
    assertEquals(0, list.getItems().size());

    filterLabels.remove("foo");
    list = client.pods().inNamespace("test").withoutLabels(filterLabels).list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());
  }

  @Test
  void testWithoutLabel() {
    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("!foo"))
        .andReturn(200, new PodListBuilder().withItems(pod2).build())
        .once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("!app"))
        .andReturn(200, new PodListBuilder().withItems(pod1).build())
        .once();

    PodList list = client.pods().inNamespace("test").withoutLabel("foo").list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());

    list = client.pods().inNamespace("test").withoutLabel("app").list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());
  }

  @Test
  void testLabelsIn() {
    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=foo%20in%20%28bar%29")
        .andReturn(200, new PodListBuilder().withItems(pod1).build())
        .once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=app%20in%20%28nginx%29")
        .andReturn(200, new PodListBuilder().withItems(pod2).build())
        .once();

    Map<String, String> filterLabels = new HashMap<>();

    PodList list = client.pods().inNamespace("test").withLabelIn("foo", "bar").list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());

    filterLabels.put("app", "nginx");
    list = client.pods().inNamespace("test").withLabelIn("app", "nginx").list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());
  }

  @Test
  void testLabelsNotIn() {
    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=foo%20notin%20%28bar%29")
        .andReturn(200, new PodListBuilder().withItems(pod2).build())
        .once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?labelSelector=app%20notin%20%28nginx%29")
        .andReturn(200, new PodListBuilder().withItems(pod1).build())
        .once();

    Map<String, String> filterLabels = new HashMap<>();

    PodList list = client.pods().inNamespace("test").withLabelNotIn("foo", "bar").list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());

    filterLabels.put("app", "nginx");
    list = client.pods().inNamespace("test").withLabelNotIn("app", "nginx").list();
    assertNotNull(list);
    assertEquals(1, list.getItems().size());

  }

}
