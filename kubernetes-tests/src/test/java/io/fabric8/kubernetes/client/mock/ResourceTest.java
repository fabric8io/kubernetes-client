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

import io.fabric8.kubernetes.api.model.DeleteOptions;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceNotFoundException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

import static java.net.HttpURLConnection.HTTP_GONE;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class ResourceTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testCreateOrReplace() {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    server.expect()
        .post()
        .withPath("/api/v1/namespaces/test/pods")
        .andReturn(HttpURLConnection.HTTP_CREATED, pod1)
        .once();

    // When
    HasMetadata response = client.resource(pod1).createOrReplace();

    // Then
    assertEquals(pod1, response);
  }

  @Test
  void testCreateOrReplaceString() {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    server.expect()
        .post()
        .withPath("/api/v1/namespaces/test/pods")
        .andReturn(HttpURLConnection.HTTP_CREATED, pod1)
        .once();

    // When
    HasMetadata response = client.resource(Serialization.asYaml(pod1)).createOrReplace();

    // Then
    assertEquals(pod1, response);
  }

  @Test
  void testGenericResourceFails() {
    assertThrows(KubernetesClientException.class,
        () -> client.resource(Serialization.unmarshal("apiVersion: example.io/v1\n"
            + "kind: GenericThatFails\n"
            + "metadata:\n"
            + "  name: failure\n", GenericKubernetesResource.class)));
  }

  @Test
  void testCreateOrReplaceWhenCreateFails() {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    server.expect()
        .post()
        .withPath("/api/v1/namespaces/test/pods")
        .andReturn(HttpURLConnection.HTTP_BAD_REQUEST, pod1)
        .once();

    NamespaceableResource<Pod> podOperation = client.resource(pod1);

    // When
    assertThrows(KubernetesClientException.class, podOperation::createOrReplace);
  }

  @Test
  void testCreateWithExplicitNamespace() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    server.expect()
        .post()
        .withPath("/api/v1/namespaces/ns1/pods")
        .andReturn(HttpURLConnection.HTTP_CREATED, pod1)
        .once();

    HasMetadata response = client.resource(pod1).inNamespace("ns1").createOrReplace();
    assertEquals(pod1, response);
  }

  @Test
  void testCreateOrReplaceWithDeleteExisting() throws Exception {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    server.expect()
        .delete()
        .withPath("/api/v1/namespaces/ns1/pods/pod1")
        .andReturn(HttpURLConnection.HTTP_OK, pod1)
        .once();
    server.expect()
        .post()
        .withPath("/api/v1/namespaces/ns1/pods")
        .andReturn(HttpURLConnection.HTTP_CREATED, pod1)
        .once();

    Resource<Pod> resource = client.resource(pod1).inNamespace("ns1");
    resource.delete();
    HasMetadata response = resource.createOrReplace();
    assertEquals(pod1, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(2, server.getRequestCount());
    assertEquals("/api/v1/namespaces/ns1/pods", request.getPath());
    assertEquals("POST", request.getMethod());
  }

  @Test
  void itPassesPropagationPolicyWithDeleteExisting() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    server.expect()
        .delete()
        .withPath("/api/v1/namespaces/ns1/pods/pod1")
        .andReturn(HttpURLConnection.HTTP_OK, pod1)
        .once();
    server.expect()
        .post()
        .withPath("/api/v1/namespaces/ns1/pods")
        .andReturn(HttpURLConnection.HTTP_CREATED, pod1)
        .once();

    Resource<Pod> resource = client.resource(pod1).inNamespace("ns1");
    resource.withPropagationPolicy(DeletionPropagation.FOREGROUND).delete();
    HasMetadata response = resource.createOrReplace();
    assertEquals(pod1, response);

    assertEquals(2, server.getRequestCount());

    RecordedRequest deleteRequest = server.takeRequest();
    assertEquals("/api/v1/namespaces/ns1/pods/pod1", deleteRequest.getPath());
    assertEquals("DELETE", deleteRequest.getMethod());
    DeleteOptions deleteOptions = Serialization.unmarshal(deleteRequest.getBody().readUtf8(), DeleteOptions.class);
    assertEquals("Foreground", deleteOptions.getPropagationPolicy());

    RecordedRequest postRequest = server.takeRequest();
    assertEquals("/api/v1/namespaces/ns1/pods", postRequest.getPath());
    assertEquals("POST", postRequest.getMethod());
  }

  @Test
  void testCreateOrReplaceWithDeleteExistingWithCreateFailed() {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    server.expect()
        .post()
        .withPath("/api/v1/namespaces/ns1/pods")
        .andReturn(HttpURLConnection.HTTP_CONFLICT, pod1)
        .once();
    server.expect()
        .delete()
        .withPath("/api/v1/namespaces/ns1/pods/pod1")
        .andReturn(HttpURLConnection.HTTP_OK, pod1)
        .once();
    server.expect()
        .post()
        .withPath("/api/v1/namespaces/ns1/pods")
        .andReturn(HttpURLConnection.HTTP_BAD_REQUEST, pod1)
        .once();
    Resource<Pod> podOperation = client.resource(pod1).inNamespace("ns1");
    podOperation.delete();
    // When
    assertThrows(KubernetesClientException.class, podOperation::createOrReplace);
  }

  @Test
  void testRequire() {
    server.expect()
        .get()
        .withPath("/api/v1/namespaces/ns1/pods/pod1")
        .andReturn(HttpURLConnection.HTTP_NOT_FOUND, "")
        .once();
    PodResource podOp = client.pods().inNamespace("ns1").withName("pod1");

    Assertions.assertThrows(ResourceNotFoundException.class, podOp::require);
  }

  @Test
  void testDelete() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").withNamespace("any").and().build();

    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).once();
    server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, pod2).once();

    Boolean deleted = client.resource(pod1).delete().size() == 1;
    assertTrue(deleted);
    deleted = client.resource(pod2).delete().size() == 1;
    assertTrue(deleted);

    deleted = client.resource(pod3).delete().size() == 1;
    assertFalse(deleted);
  }

  @Test
  void testWatch() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .build();

    server.expect().get().withPath("/api/v1/namespaces/test/pods").andReturn(200, pod1).once();
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, pod1).once();

    server.expect()
        .get()
        .withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(1000)
        .andEmit(new WatchEvent(pod1, "DELETED"))
        .done()
        .always();

    final CountDownLatch latch = new CountDownLatch(1);

    Watch watch = client.resource(pod1).watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        latch.countDown();
      }

      @Override
      public void onClose(WatcherException cause) {

      }
    });
    assertTrue(latch.await(5000, MILLISECONDS));
    watch.close();
  }

  @Test
  void testWaitUntilReady() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .build();

    Pod noReady = createReadyFrom(pod1, "False", "2");
    Pod ready = createReadyFrom(pod1, "True", "3");

    list(noReady);

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(500)
        .andEmit(new WatchEvent(ready, "MODIFIED"))
        .done()
        .always();

    Pod p = client.resource(noReady).waitUntilReady(10, SECONDS);
    assertTrue(Readiness.isPodReady(p));
  }

  /**
   * List the pod for the initial request from an informer
   * 
   * @param pod
   */
  private void list(Pod pod) {
    list(server, pod, null);
  }

  static void list(KubernetesMockServer server, Pod pod, String resourceVersion) {
    server.expect()
        .get()
        .withPath("/api/v1/namespaces/" + pod.getMetadata().getNamespace() + "/pods?fieldSelector=metadata.name%3D"
            + pod.getMetadata().getName() + (resourceVersion != null ? ("&resourceVersion=" + resourceVersion) : ""))
        .andReturn(200,
            new PodListBuilder().withItems(pod).withNewMetadata().withResourceVersion("1").endMetadata().build())
        .once();
  }

  @Test
  void testWaitUntilExistsThenReady() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .build();

    Pod noReady = createReadyFrom(pod1, "False", "1");
    Pod ready = createReadyFrom(pod1, "True", "2");

    // and again so that "periodicWatchUntilReady" successfully begins
    server.expect()
        .get()
        .withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1")
        .andReturn(200, noReady)
        .times(2);

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(100)
        .andEmit(new WatchEvent(ready, "MODIFIED"))
        .done()
        .always();

    Pod p = client.pods().withName("pod1").waitUntilReady(10, SECONDS);
    assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testWaitUntilCondition() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .build();

    Pod noReady = createReadyFrom(pod1, "False", "1");
    Pod ready = createReadyFrom(pod1, "True", "3");

    Pod withConditionBeingFalse = new PodBuilder(pod1).editMetadata()
        .withResourceVersion("2")
        .endMetadata()
        .withNewStatus()
        .addNewCondition()
        .withType("Ready")
        .withStatus("True")
        .endCondition()
        .addNewCondition()
        .withType("dummy")
        .withStatus("False")
        .endCondition()
        .endStatus()
        .build();

    Pod withConditionBeingTrue = new PodBuilder(pod1).editMetadata()
        .withResourceVersion("4")
        .endMetadata()
        .withNewStatus()
        .addNewCondition()
        .withType("Ready")
        .withStatus("True")
        .endCondition()
        .addNewCondition()
        .withType("Dummy")
        .withStatus("True")
        .endCondition()
        .endStatus()
        .build();

    // at first the pod is non-ready
    list(noReady);

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(1000)
        .andEmit(new WatchEvent(ready, "MODIFIED"))
        .waitFor(2000)
        .andEmit(new WatchEvent(withConditionBeingFalse, "MODIFIED"))
        .waitFor(2500)
        .andEmit(new WatchEvent(withConditionBeingTrue, "MODIFIED"))
        .done()
        .always();

    Pod p = client.pods()
        .withName("pod1")
        .waitUntilCondition(
            r -> r.getStatus()
                .getConditions()
                .stream()
                .anyMatch(c -> "Dummy".equals(c.getType()) && "True".equals(c.getStatus())),
            10, SECONDS);

    assertThat(p.getStatus().getConditions())
        .extracting("type", "status")
        .containsExactly(tuple("Ready", "True"), tuple("Dummy", "True"));
  }

  @Test
  void testErrorEventDuringWaitReturnFromAPIIfMatch() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .build();

    Pod noReady = createReadyFrom(pod1, "False", "2");
    Pod ready = createReadyFrom(pod1, "True", "3");

    Status status = new StatusBuilder()
        .withCode(HttpURLConnection.HTTP_FORBIDDEN)
        .build();

    // once not ready, to begin watch
    list(noReady);

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(500)
        .andEmit(new WatchEvent(status, "ERROR"))
        .done()
        .once();

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(500)
        .andEmit(new WatchEvent(ready, "MODIFIED"))
        .done()
        .once();

    Pod p = client.resource(noReady).waitUntilReady(10, SECONDS);
    assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testRetryOnErrorEventDuringWait() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .build();

    Pod noReady = createReadyFrom(pod1, "False", "2");
    Pod ready = createReadyFrom(pod1, "True", "3");

    Status status = new StatusBuilder()
        .withCode(HttpURLConnection.HTTP_FORBIDDEN)
        .build();

    // once not ready, to begin watch
    list(noReady);

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(500)
        .andEmit(new WatchEvent(status, "ERROR"))
        .done()
        .once();

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(500)
        .andEmit(new WatchEvent(ready, "MODIFIED"))
        .done()
        .once();

    Pod p = client.resource(noReady).waitUntilReady(10, SECONDS);
    assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testSkipWatchIfAlreadyMatchingCondition() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .build();

    Pod noReady = createReadyFrom(pod1, "False", "2");
    Pod ready = createReadyFrom(pod1, "True", "3");

    // once not ready, to begin watch
    list(ready);

    Pod p = client.resource(noReady).waitUntilReady(10, SECONDS);
    assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testRetryWatchOnHttpGone() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .build();

    Pod noReady = createReadyFrom(pod1, "False", "2");
    Pod ready = createReadyFrom(pod1, "True", "3");

    Status status = new StatusBuilder()
        .withCode(HTTP_GONE)
        .build();

    // once not ready, to begin watch
    list(noReady);

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(500)
        .andEmit(new WatchEvent(status, "ERROR"))
        .done()
        .once();

    list(server, ready, null);

    client.resource(noReady).waitUntilReady(10, SECONDS);
  }

  @Test
  void testWaitOnConditionDeleted() throws InterruptedException {
    Pod ready = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .withNewStatus()
        .addNewCondition()
        .withType("Ready")
        .withStatus("True")
        .endCondition()
        .endStatus()
        .build();

    list(ready);

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(1000)
        .andEmit(new WatchEvent(ready, "DELETED"))
        .done()
        .once();

    Pod p = client.pods().withName("pod1").waitUntilCondition(Objects::isNull, 10, SECONDS);
    assertNull(p);
  }

  @Test
  void testCreateAndWaitUntilReady() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
        .withNamespace("test")
        .and()
        .build();

    Pod noReady = createReadyFrom(pod1, "False", "2");
    Pod ready = createReadyFrom(pod1, "True", "3");

    list(noReady);
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, noReady).once();

    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(1000)
        .andEmit(new WatchEvent(ready, "MODIFIED"))
        .done()
        .always();

    NamespaceableResource<Pod> resource = client.resource(noReady);
    resource.create();
    Pod p = resource.waitUntilReady(10, SECONDS);
    assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testFromServerGet() {
    Pod pod = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withNamespace("test")
        .withResourceVersion("1")
        .and()
        .build();

    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod).once();

    HasMetadata response = client.resource(pod).get();
    assertEquals(pod, response);
  }

  @Test
  @DisplayName("resource().waitUntilCondition(), resource forced to be reloaded from server even if condition is met by local version")
  void testFromServerWaitUntilConditionAlwaysGetsResourceFromServer() throws Exception {
    // Given
    final Pod conditionNotMetPod = new PodBuilder().withNewMetadata()
        .withName("pod")
        .withNamespace("test")
        .withResourceVersion("1")
        .addToLabels("CONDITION", "NOT_MET")
        .endMetadata()
        .build();
    final Pod conditionMetPod = new PodBuilder().withNewMetadata()
        .withName("pod")
        .withNamespace("test")
        .withResourceVersion("2")
        .addToLabels("CONDITION", "MET")
        .endMetadata()
        .build();
    list(conditionNotMetPod);
    server.expect()
        .get()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod&resourceVersion=1&timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .immediately()
        .andEmit(new WatchEvent(conditionNotMetPod, "MODIFIED"))
        .waitFor(10)
        .andEmit(new WatchEvent(conditionMetPod, "MODIFIED"))
        .done()
        .once();
    // When
    HasMetadata response = client
        .resource(new PodBuilder(conditionMetPod).build())
        .waitUntilCondition(p -> "MET".equals(p.getMetadata().getLabels().get("CONDITION")), 10, SECONDS);
    // Then
    assertEquals(conditionMetPod, response);
    assertEquals(2, server.getRequestCount());
  }

  @Test
  void testWaitNullDoesntExist() throws InterruptedException {
    server.expect()
        .get()
        .withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1")
        .andReturn(200,
            new PodListBuilder().withNewMetadata().withResourceVersion("1").endMetadata().build())
        .once();

    Pod p = client.pods().withName("pod1").waitUntilCondition(Objects::isNull, 10, SECONDS);
    assertNull(p);
  }

  static Pod createReadyFrom(Pod pod, String status, String resourceVersion) {
    return new PodBuilder(pod)
        .editMetadata()
        .withResourceVersion(resourceVersion)
        .endMetadata()
        .withNewStatus()
        .addNewCondition()
        .withType("Ready")
        .withStatus(status)
        .endCondition()
        .endStatus()
        .build();
  }
}
