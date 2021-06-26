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

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.dsl.ListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static java.net.HttpURLConnection.HTTP_CONFLICT;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_GONE;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class ResourceListTest {

  KubernetesMockServer server;
  KubernetesClient client;

  private Service service;
  private Service updatedService;
  private ConfigMap configMap;
  private ConfigMap updatedConfigMap;
  private KubernetesList resourcesToUpdate;

  @BeforeEach
  void setUp() {
    service = mockService().build();
    configMap = mockConfigMap().build();
    updatedService = mockService().editSpec().editFirstPort()
      .withTargetPort(new IntOrString(9999)).endPort().endSpec()
      .build();
    updatedConfigMap = mockConfigMap().addToData(Collections.singletonMap("foo", "bar")).build();
    resourcesToUpdate = new KubernetesListBuilder()
      .withItems(updatedService, updatedConfigMap).build();
  }

  @Test
  void testCreateOrReplace() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HTTP_CREATED, pod1).once();

    List<HasMetadata> response = client.resourceList(new PodListBuilder().addToItems(pod1).build()).createOrReplace();
    assertTrue(response.contains(pod1));
  }

  @Test
  void testCreateOrReplaceFailedCreate() {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HTTP_UNAVAILABLE, pod1).once();
    NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> listOp = client.resourceList(new PodListBuilder().addToItems(pod1).build());

    // When
    assertThrows(KubernetesClientException.class, listOp::createOrReplace);
  }

  @Test
  void testCreateWithExplicitNamespace() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    server.expect().post().withPath("/api/v1/namespaces/ns1/pods").andReturn(HTTP_CREATED, pod1).once();

    List<HasMetadata> response = client.resourceList(new PodListBuilder().addToItems(pod1).build()).inNamespace("ns1").apply();
    assertTrue(response.contains(pod1));
  }

  @Test
  void testDelete() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").withNamespace("any").and().build();


    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(HTTP_OK, pod1).times(2);
    server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(HTTP_OK, pod2).times(2);
    server.expect().withPath("/api/v1/namespaces/any/pods/pod3").andReturn(HTTP_OK, pod3).times(1);

    //First time all items should be deleted.
    Boolean deleted = client.resourceList(new PodListBuilder().withItems(pod1, pod2, pod3).build()).delete();
    assertTrue(deleted);

    //Now we expect pod3 to fail.
    deleted = client.resourceList(new PodListBuilder().withItems(pod1, pod2, pod3).build()).delete();
    assertFalse(deleted);
  }

  @Test
  void testCreateOrReplaceWithoutDeleteExisting() throws Exception {
    server.expect().post().withPath("/api/v1/namespaces/ns1/services").andReturn(HTTP_CONFLICT, service).once();
    server.expect().post().withPath("/api/v1/namespaces/ns1/configmaps").andReturn(HTTP_CONFLICT, configMap).once();
    // once for the ip and once for the resource version - this should be consolidated
    server.expect().get().withPath("/api/v1/namespaces/ns1/services/my-service").andReturn(HTTP_OK , service).times(2);
    server.expect().get().withPath("/api/v1/namespaces/ns1/configmaps/my-configmap").andReturn(HTTP_OK, configMap).once();
    server.expect().put().withPath("/api/v1/namespaces/ns1/services/my-service").andReturn(HTTP_OK, updatedService).once();
    server.expect().put().withPath("/api/v1/namespaces/ns1/configmaps/my-configmap").andReturn(HTTP_OK, updatedConfigMap).once();

    client.resourceList(resourcesToUpdate).inNamespace("ns1").createOrReplace();

    assertEquals(7, server.getRequestCount());
    RecordedRequest request = server.getLastRequest();
    assertEquals("/api/v1/namespaces/ns1/configmaps/my-configmap", request.getPath());
    assertEquals("PUT", request.getMethod());
  }

  @Test
  void testCreateOrReplaceWithDeleteExisting() throws Exception {
    server.expect().delete().withPath("/api/v1/namespaces/ns1/services/my-service").andReturn(HTTP_OK , service).once();
    server.expect().delete().withPath("/api/v1/namespaces/ns1/configmaps/my-configmap").andReturn(HTTP_OK, configMap).once();
    server.expect().post().withPath("/api/v1/namespaces/ns1/services").andReturn(HTTP_OK, updatedService).once();
    server.expect().post().withPath("/api/v1/namespaces/ns1/configmaps").andReturn(HTTP_OK, updatedConfigMap).once();

    client.resourceList(resourcesToUpdate).inNamespace("ns1").deletingExisting().createOrReplace();

    assertEquals(4, server.getRequestCount());
    RecordedRequest request = server.getLastRequest();
    assertEquals("/api/v1/namespaces/ns1/configmaps", request.getPath());
    assertEquals("POST", request.getMethod());
  }

  @Test
  void testSuccessfulWaitUntilCondition() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("ns1").and().build();
    Pod noReady1 = createReadyFrom(pod1, "False");
    Pod ready1 = createReadyFrom(pod1, "True");

    Pod pod2 = new PodBuilder().withNewMetadata()
      .withName("pod2")
      .withResourceVersion("1")
      .withNamespace("ns1").and().build();
    Pod noReady2 = createReadyFrom(pod2, "False");
    Pod ready2 = createReadyFrom(pod2, "True");

    Predicate<HasMetadata> isReady = p -> "Pod".equals(p.getKind()) && ((Pod) p).getStatus().getConditions().stream()
      .anyMatch(c -> "True".equals(c.getStatus()));

    // The pods are never ready if you request them directly.
    ResourceTest.list(server, noReady1);
    ResourceTest.list(server, noReady2);

    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(ready1, "MODIFIED"))
      .done()
      .once();

    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?fieldSelector=metadata.name%3Dpod2&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(ready2, "MODIFIED"))
      .done()
      .once();

    KubernetesList list = new KubernetesListBuilder().withItems(pod1, pod2).build();
    List<HasMetadata> results = client.resourceList(list).inNamespace("ns1")
      .waitUntilCondition(isReady, 5, SECONDS);
    assertThat(results)
      .containsExactlyInAnyOrder(ready1, ready2);
  }

  @Test
  void testPartialSuccessfulWaitUntilCondition() {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("ns1").and().build();
    Pod noReady1 = createReadyFrom(pod1, "False");

    Pod pod2 = new PodBuilder().withNewMetadata()
      .withName("pod2")
      .withResourceVersion("1")
      .withNamespace("ns1").and().build();
    Pod noReady2 = createReadyFrom(pod2, "False");
    Pod ready2 = createReadyFrom(pod2, "True");

    Predicate<HasMetadata> isReady = p -> "Pod".equals(p.getKind()) && ((Pod) p).getStatus().getConditions().stream()
      .anyMatch(c -> "True".equals(c.getStatus()));

    // The pods are never ready if you request them directly.
    ResourceTest.list(server, noReady1);
    ResourceTest.list(server, noReady2);

    Status gone = new StatusBuilder()
      .withCode(HTTP_GONE)
      .build();

    // This pod has a non-retryable error.
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(gone, "ERROR"))
      .done()
      .once();

    // This pod succeeds.
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?fieldSelector=metadata.name%3Dpod2&resourceVersion=1&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(ready2, "MODIFIED"))
      .done()
      .once();

      KubernetesList list = new KubernetesListBuilder().withItems(pod1, pod2).build();
      final ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> ops = client.resourceList(list).inNamespace("ns1");
      KubernetesClientTimeoutException ex = assertThrows(KubernetesClientTimeoutException.class, () ->
        ops.waitUntilCondition(isReady, 5, SECONDS)
      );
      assertThat(ex.getResourcesNotReady())
        .containsExactly(pod1);
  }

  @Test
  void testAllFailedWaitUntilCondition() {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("ns1").and().build();
    Pod noReady1 = createReadyFrom(pod1, "False");

    Pod pod2 = new PodBuilder().withNewMetadata()
      .withName("pod2")
      .withResourceVersion("1")
      .withNamespace("ns1").and().build();
    Pod noReady2 = createReadyFrom(pod2, "False");

    Predicate<HasMetadata> isReady = p -> "Pod".equals(p.getKind()) && ((Pod) p).getStatus().getConditions().stream()
      .anyMatch(c -> "True".equals(c.getStatus()));

    // The pods are never ready if you request them directly.
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods/pod1").andReturn(HTTP_OK, noReady1).once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(HTTP_OK, noReady2).once();

    Status gone = new StatusBuilder()
      .withCode(HTTP_GONE)
      .build();

    // Both pods have a non-retryable error.
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(gone, "ERROR"))
      .done()
      .once();

    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?fieldSelector=metadata.name%3Dpod2&resourceVersion=1&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(gone, "ERROR"))
      .done()
      .once();

    KubernetesList list = new KubernetesListBuilder().withItems(pod1, pod2).build();
    final ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> ops = client.resourceList(list).inNamespace("ns1");
    KubernetesClientTimeoutException ex = assertThrows(KubernetesClientTimeoutException.class, () ->
      ops.waitUntilCondition(isReady, 5, SECONDS)
    );
    assertThat(ex.getResourcesNotReady())
      .containsExactlyInAnyOrder(pod1, pod2);
  }

  private static Pod createReadyFrom(Pod pod, String status) {
    return new PodBuilder(pod)
      .withNewStatus()
      .addNewCondition()
      .withType("Ready")
      .withStatus(status)
      .endCondition()
      .endStatus()
      .build();
  }

  private static ServiceBuilder mockService() {
    return new ServiceBuilder()
      .withNewMetadata().withName("my-service").endMetadata()
      .withNewSpec()
      .addToSelector("app", "my-app")
      .addNewPort().withProtocol("TCP").withPort(80).withTargetPort(new IntOrString(9376)).endPort()
      .endSpec();
  }

  private static ConfigMapBuilder mockConfigMap() {
    return new ConfigMapBuilder()
      .withNewMetadata().withName("my-configmap").endMetadata()
      .addToData(Collections.singletonMap("app", "my-app"));
  }
}
