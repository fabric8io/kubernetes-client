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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.dsl.Applicable;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.function.Predicate;

import static java.net.HttpURLConnection.HTTP_GONE;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@EnableKubernetesMockClient
class ResourceTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testCreateOrReplace() {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CREATED, pod1).once();

    // When
    HasMetadata response = client.resource(pod1).createOrReplace();

    // Then
    assertEquals(pod1, response);
  }

  @Test
  void testCreateOrReplaceWhenCreateFails() {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_BAD_REQUEST, pod1).once();
    
    NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<Pod> podOperation = client.resource(pod1);

    // When
    assertThrows(KubernetesClientException.class, podOperation::createOrReplace);
  }

    @Test
    void testCreateWithExplicitNamespace() {
      Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

      server.expect().post().withPath("/api/v1/namespaces/ns1/pods").andReturn(HttpURLConnection.HTTP_CREATED, pod1).once();

      HasMetadata response = client.resource(pod1).inNamespace("ns1").createOrReplace();
      assertEquals(pod1, response);
    }

    @Test
    void testCreateOrReplaceWithDeleteExisting() throws Exception {
      Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

      server.expect().delete().withPath("/api/v1/namespaces/ns1/pods/pod1").andReturn(HttpURLConnection.HTTP_OK, pod1).once();
      server.expect().post().withPath("/api/v1/namespaces/ns1/pods").andReturn(HttpURLConnection.HTTP_CREATED, pod1).once();

      HasMetadata response = client.resource(pod1).inNamespace("ns1").deletingExisting().createOrReplace();
      assertEquals(pod1, response);

      int requestCount = server.getRequestCount();
      RecordedRequest request = null;
      while(requestCount-- > 0)request = server.takeRequest();
      assertEquals(2, server.getRequestCount());
      assertEquals("/api/v1/namespaces/ns1/pods", request.getPath());
      assertEquals("POST", request.getMethod());
    }

  @Test
  void itPassesPropagationPolicyWithDeleteExisting() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    server.expect().delete().withPath("/api/v1/namespaces/ns1/pods/pod1").andReturn(HttpURLConnection.HTTP_OK, pod1).once();
    server.expect().post().withPath("/api/v1/namespaces/ns1/pods").andReturn(HttpURLConnection.HTTP_CREATED, pod1).once();

    HasMetadata response = client.resource(pod1).inNamespace("ns1").withPropagationPolicy(DeletionPropagation.FOREGROUND).deletingExisting().createOrReplace();
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
    server.expect().post().withPath("/api/v1/namespaces/ns1/pods").andReturn(HttpURLConnection.HTTP_CONFLICT, pod1).once();
    server.expect().delete().withPath("/api/v1/namespaces/ns1/pods/pod1").andReturn(HttpURLConnection.HTTP_OK, pod1).once();
    server.expect().post().withPath("/api/v1/namespaces/ns1/pods").andReturn(HttpURLConnection.HTTP_BAD_REQUEST, pod1).once();
    Applicable<Pod> podOperation = client.resource(pod1).inNamespace("ns1").deletingExisting();

    // When
    assertThrows(KubernetesClientException.class, podOperation::createOrReplace);
  }

    @Test
    void testRequire() {
      server.expect().get().withPath("/api/v1/namespaces/ns1/pods/pod1").andReturn(HttpURLConnection.HTTP_NOT_FOUND, "").once();
      PodResource<Pod> podOp = client.pods().inNamespace("ns1").withName("pod1");

      Assertions.assertThrows(ResourceNotFoundException.class, podOp::require);
    }

  @Test
  void testDelete() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").withNamespace("any").and().build();

   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).once();
   server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, pod2).once();

    Boolean deleted = client.resource(pod1).delete();
    assertTrue(deleted);
    deleted = client.resource(pod2).delete();
    assertTrue(deleted);

    deleted = client.resource(pod3).delete();
    assertFalse(deleted);
  }


  @Test
  void testWatch() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
      .withNamespace("test").and().build();

      server.expect().get().withPath("/api/v1/namespaces/test/pods").andReturn(200, pod1).once();
      server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, pod1).once();

     server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=true").andUpgradeToWebSocket()
        .open()
          .waitFor(1000).andEmit(new WatchEvent(pod1, "DELETED"))
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
    Assert.assertTrue(latch.await(5000, MILLISECONDS));
    watch.close();
  }


  @Test
  void testWaitUntilReady() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();

    Pod noReady = createReadyFrom(pod1, "False");
    Pod ready = createReadyFrom(pod1, "True");

    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, noReady).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(ready, "MODIFIED"))
      .done()
      .always();

    
    Pod p = client.resource(noReady).waitUntilReady(5, SECONDS);
    Assert.assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testWaitUntilExistsThenReady() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();

    Pod noReady = createReadyFrom(pod1, "False");
    Pod ready = createReadyFrom(pod1, "True");

    // so that "waitUntilExists" actually has some waiting to do
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(404, "").times(2);
    // once so that "waitUntilExists" successfully ends
    // and again so that "periodicWatchUntilReady" successfully begins
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, noReady).times(2);

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(100).andEmit(new WatchEvent(ready, "MODIFIED"))
      .done()
      .always();

    
    Pod p = client.pods().withName("pod1").waitUntilReady(5, SECONDS);
    Assert.assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testWaitUntilCondition() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();

    Pod noReady = createReadyFrom(pod1, "False");
    Pod ready = createReadyFrom(pod1, "True");

    Pod withConditionBeingFalse = new PodBuilder(pod1).withNewStatus()
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

    Pod withConditionBeingTrue = new PodBuilder(pod1).withNewStatus()
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
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, noReady).times(2);

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(1000).andEmit(new WatchEvent(ready, "MODIFIED"))
      .waitFor(2000).andEmit(new WatchEvent(withConditionBeingFalse, "MODIFIED"))
      .waitFor(2500).andEmit(new WatchEvent(withConditionBeingTrue, "MODIFIED"))
      .done()
      .always();

    
    Pod p = client.pods().withName("pod1").waitUntilCondition(
      r -> r.getStatus().getConditions()
            .stream()
            .anyMatch(c -> "Dummy".equals(c.getType()) && "True".equals(c.getStatus())),
      8, SECONDS
    );

    assertThat(p.getStatus().getConditions())
      .extracting("type", "status")
      .containsExactly(tuple("Ready", "True"), tuple("Dummy", "True"));
  }

  @Test
  void testWaitUntilConditionWhenResourceVersionTooOld() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();

    Pod noReady = createReadyFrom(pod1, "False");
    Pod ready = createReadyFrom(pod1, "True");

    // The pod is never ready if you request it directly.
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, noReady).always();

    Status gone = new StatusBuilder()
      .withCode(HTTP_GONE)
      .build();

    // Watches with the pod's own resource version fail with 410 "GONE".
    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(gone, "ERROR"))
      .done()
      .once();

    // Watches with a later resource version will return the "ready" pod.
    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=2&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(ready, "MODIFIED"))
      .done()
      .once();

    Predicate<Pod> isReady = p -> p.getStatus().getConditions().stream()
      .anyMatch(c -> "True".equals(c.getStatus()));

    final PodResource<Pod> ops = client.pods().withName("pod1");
    KubernetesClientException ex = assertThrows(KubernetesClientException.class, () ->
      ops.waitUntilCondition(isReady, 4, SECONDS)
    );
    assertThat(ex)
      .hasCauseExactlyInstanceOf(WatcherException.class)
      .extracting(Throwable::getCause)
      .asInstanceOf(InstanceOfAssertFactories.type(WatcherException.class))
      .extracting(WatcherException::isHttpGone)
      .isEqualTo(true);

    Pod pod = client.pods()
      .withName("pod1")
      .withResourceVersion("2")
      .waitUntilCondition(isReady, 4, SECONDS);
    assertThat(pod.getMetadata().getName()).isEqualTo("pod1");
    assertThat(pod.getMetadata().getResourceVersion()).isEqualTo("1");
    assertTrue(isReady.test(pod));
  }

  @Test
  void testRetryOnErrorEventDuringWaitReturnFromAPIIfMatch() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();

    Pod noReady = createReadyFrom(pod1, "False");
    Pod ready = createReadyFrom(pod1, "True");

    Status status = new StatusBuilder()
      .withCode(HttpURLConnection.HTTP_FORBIDDEN)
      .build();

    // once not ready, to begin watch
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, noReady).once();
    // once ready, after watch fails
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, ready).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(status, "ERROR"))
      .done()
      .once();

    
    Pod p = client.resource(noReady).waitUntilReady(5, SECONDS);
    Assert.assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testRetryOnErrorEventDuringWait() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();

    Pod noReady = createReadyFrom(pod1, "False");
    Pod ready = createReadyFrom(pod1, "True");

    Status status = new StatusBuilder()
      .withCode(HttpURLConnection.HTTP_FORBIDDEN)
      .build();

    // once not ready, to begin watch
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, noReady).times(2);

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(status, "ERROR"))
      .done()
      .once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(ready, "MODIFIED"))
      .done()
      .once();

    
    Pod p = client.resource(noReady).waitUntilReady(5, SECONDS);
    Assert.assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testSkipWatchIfAlreadyMatchingCondition() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();

    Pod noReady = createReadyFrom(pod1, "False");
    Pod ready = createReadyFrom(pod1, "True");

    // once not ready, to begin watch
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, ready).once();

    
    Pod p = client.resource(noReady).waitUntilReady(5, SECONDS);
    Assert.assertTrue(Readiness.isPodReady(p));
  }

  @Test
  void testDontRetryWatchOnHttpGone() throws InterruptedException {
    Pod noReady = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().withNewStatus()
      .addNewCondition()
      .withType("Ready")
      .withStatus("False")
      .endCondition()
      .endStatus()
      .build();

    Status status = new StatusBuilder()
      .withCode(HTTP_GONE)
      .build();

    // once not ready, to begin watch
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, noReady).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(500).andEmit(new WatchEvent(status, "ERROR"))
      .done()
      .once();

    
    try {
      client.resource(noReady).waitUntilReady(5, SECONDS);
      fail("should have thrown KubernetesClientException");
    } catch (KubernetesClientException e) {
      assertTrue(e.getCause() instanceof WatcherException);
    }
  }

  @Test
  void testWaitOnConditionDeleted() throws InterruptedException {
    Pod ready = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().withNewStatus()
      .addNewCondition()
      .withType("Ready")
      .withStatus("True")
      .endCondition()
      .endStatus()
      .build();

    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, ready).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(1000).andEmit(new WatchEvent(ready, "DELETED"))
      .done()
      .once();

    
    Pod p = client.pods().withName("pod1").waitUntilCondition(Objects::isNull,8, SECONDS);
    assertNull(p);
  }

  @Test
  void testCreateAndWaitUntilReady() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();

    Pod noReady = createReadyFrom(pod1, "False");
    Pod ready = createReadyFrom(pod1, "True");

    // once so that "waitUntilExists" successfully ends
    // and again so that "periodicWatchUntilReady" successfully begins
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, noReady).times(2);
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, noReady).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(1000).andEmit(new WatchEvent(ready, "MODIFIED"))
      .done()
      .always();

    
    Pod p = client.resource(noReady).createOrReplaceAnd().waitUntilReady(10, SECONDS);
    Assert.assertTrue(Readiness.isPodReady(p));
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

    
    HasMetadata response = client.resource(pod).fromServer().get();
    assertEquals(pod, response);
  }

  @Test
  @DisplayName("resource().waitUntilCondition(), resource forced to be reloaded from server even if condition is met by local version")
  void testFromServerWaitUntilConditionAlwaysGetsResourceFromServer() throws Exception {
    // Given
    final Pod conditionNotMetPod = new PodBuilder().withNewMetadata()
      .withName("pod")
      .withNamespace("test")
      .addToLabels("CONDITION", "NOT_MET")
      .endMetadata().build();
    final Pod conditionMetPod = new PodBuilder().withNewMetadata()
      .withName("pod")
      .withNamespace("test")
      .withResourceVersion("1")
      .addToLabels("CONDITION", "MET")
      .endMetadata()
      .build();
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod").andReturn(200, conditionNotMetPod).once();
    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod&watch=true")
      .andUpgradeToWebSocket().open()
      .immediately().andEmit(new WatchEvent(conditionNotMetPod, "MODIFIED"))
      .waitFor(10).andEmit(new WatchEvent(conditionMetPod, "MODIFIED"))
      .done()
      .once();
    // When
    HasMetadata response = client
      .resource(new PodBuilder(conditionMetPod).build())
      .waitUntilCondition(p -> "MET".equals(p.getMetadata().getLabels().get("CONDITION")), 1, SECONDS);
    // Then
    assertEquals(conditionMetPod, response);
    assertEquals(2, server.getRequestCount());
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
}

