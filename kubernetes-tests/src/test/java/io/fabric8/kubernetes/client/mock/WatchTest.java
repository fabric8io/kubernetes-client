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

import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.api.model.WatchEventBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.Watcher.Action.DELETED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@EnableKubernetesMockClient(https = false)
class WatchTest {

  private static final Long EVENT_WAIT_PERIOD_MS = 10L;

  KubernetesMockServer server;
  KubernetesClient client;
  private Pod pod1;

  @BeforeEach
  void setUp() {
    pod1 = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
      .withResourceVersion("1").endMetadata().build();
  }

  @Test
  @DisplayName("TryWithResources, connects and receives event then receives GONE, should receive first event and then close")
  void testTryWithResourcesConnectsThenReceivesEvent() throws InterruptedException {
    // Given
    server.expect()
        .withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true")
        .andUpgradeToWebSocket().open()
        .waitFor(EVENT_WAIT_PERIOD_MS).andEmit(new WatchEvent(pod1, "DELETED"))
        .waitFor(EVENT_WAIT_PERIOD_MS).andEmit(outdatedEvent()).done().once();
    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final Watcher<Pod> watcher = new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        if (action != DELETED) {
          fail();
        }
        deleteLatch.countDown();
      }

      @Override
      public void onClose(WatcherException cause) {
        assertTrue(cause.isHttpGone());
        closeLatch.countDown();
      }
    };
    // When
    try (Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(watcher)) {
      // Then
      assertNotNull(watch);
      assertTrue(deleteLatch.await(10, TimeUnit.SECONDS));
      assertTrue(closeLatch.await(10, TimeUnit.SECONDS));
    }
  }

  @Test
  @DisplayName("TryWithResources, receives error when connecting, should NOT receive events and close before propagating the connect exception")
  void testTryWithResourcesCantConnectShouldCloseAndThenThrowException() throws Exception {
    // Given
    final CountDownLatch closeLatch = new CountDownLatch(1);
    server.expect()
      .withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true")
      .andReturn(410, outdatedEvent()).once();
    final Watcher<Pod> watcher = new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        fail();
      }

      @Override
      public void onClose(WatcherException cause) {
        fail("Close event should be invoked by try-with-resources successful completion, not by exception");
      }

      @Override
      public void onClose() {
        closeLatch.countDown();
      }
    };
    final Watchable<Watcher<Pod>> watchable = client.pods().withName("pod1").withResourceVersion("1");
    // When
    final KubernetesClientException result = Assertions.assertThrows(KubernetesClientException.class, () -> {
      try (Watch watch = watchable.watch(watcher)) {
        assertNull(watch);
        fail("Close with resources should call Watcher#onClose when closing watch");
      }
    });
    // Then
    assertTrue(closeLatch.await(10, TimeUnit.SECONDS));
    assertEquals(410, result.getCode());
  }

  @Test
  void testWithTimeoutSecondsShouldAddQueryParam() throws InterruptedException {
    // Given
    server.expect()
      .withPath("/api/v1/namespaces/test/pods?timeoutSeconds=30&watch=true")
      .andUpgradeToWebSocket().open()
      .waitFor(EVENT_WAIT_PERIOD_MS).andEmit(new WatchEvent(pod1, "DELETED"))
      .waitFor(EVENT_WAIT_PERIOD_MS).andEmit(outdatedEvent()).done().once();


    // When
    final CountDownLatch eventReceivedLatch = new CountDownLatch(1);
    Watch watch = client.pods().watch(new ListOptionsBuilder().withTimeoutSeconds(30L).build(), new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) { eventReceivedLatch.countDown(); }

      @Override
      public void onClose(WatcherException cause) { }
    });

    // Then
    assertTrue(eventReceivedLatch.await(3, TimeUnit.SECONDS));
    watch.close();
  }

  /**
   * Will attempt a reconnect after 10ms..20ms...40ms....80ms.....160ms......320ms
   */
  @Test
  void testHttpErrorReconnect() throws InterruptedException {
    // Given
    client.getConfiguration().setWatchReconnectInterval(10);
    final String path = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true";
    // accept watch and disconnect
    server.expect().withPath(path).andUpgradeToWebSocket().open().done().once();
    // refuse reconnect attempts 6 times
    server.expect().withPath(path).andReturn(HttpURLConnection.HTTP_NOT_FOUND, new StatusBuilder().withCode(HttpURLConnection.HTTP_NOT_FOUND).build()).times(6);
    // accept next reconnect and send outdated event to stop the watch
    server.expect().withPath(path).andUpgradeToWebSocket().open(outdatedEvent()).done().once();
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final Watcher<Pod> watcher = new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        fail();
      }

      @Override
      public void onClose(WatcherException cause) {
        assertTrue(cause.isHttpGone());
        closeLatch.countDown();
      }
    };
    // When
    try (Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(watcher)) {
      // Then
      assertNotNull(watch);
      assertTrue(closeLatch.await(3, TimeUnit.MINUTES));
    }
  }

  @Test
  void testOnCloseEvent() throws InterruptedException {
    final CountDownLatch eventLatch = new CountDownLatch(2);
    final CountDownLatch closeLatch = new CountDownLatch(1);

    server.expect()
      .withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true")
      .andUpgradeToWebSocket().open().waitFor(EVENT_WAIT_PERIOD_MS).andEmit(new WatchEvent(pod1, "MODIFIED")).waitFor(EVENT_WAIT_PERIOD_MS)
      .andEmit(new WatchEvent(pod1, "MODIFIED")).done().once();

    Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        eventLatch.countDown();
      }

      @Override
      public void onClose(WatcherException cause) {
        fail();
      }

      @Override
      public void onClose() {
        closeLatch.countDown();
      }
    });

    assertTrue(eventLatch.await(10, TimeUnit.SECONDS));
    watch.close();
    assertTrue(closeLatch.await(10, TimeUnit.SECONDS));
  }

  @Test
  void testReconnectsWithLastResourceVersion() throws InterruptedException {
    final CountDownLatch eventLatch = new CountDownLatch(3);

    final Pod pod1initial = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
      .withResourceVersion("9").endMetadata().build();


    final Pod pod1update = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
      .withResourceVersion("10").endMetadata().build();

    final String path = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true";

    server.expect()
      .withPath(path)
      .andUpgradeToWebSocket().open()
      .waitFor(EVENT_WAIT_PERIOD_MS).andEmit(new WatchEvent(pod1initial, "MODIFIED"))
      .waitFor(EVENT_WAIT_PERIOD_MS).andEmit(new WatchEvent(pod1update, "MODIFIED"))
      .done().once();

    final String reconnectPath = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=10&watch=true";

    server.expect()
      .withPath(reconnectPath)
      .andUpgradeToWebSocket().open()
      .waitFor(EVENT_WAIT_PERIOD_MS).andEmit(new WatchEvent(pod1update, "MODIFIED"))
      .done().once();


    Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        eventLatch.countDown();
      }

      @Override
      public void onClose(WatcherException cause) {
      }
    });

    assertTrue(eventLatch.await(10, TimeUnit.SECONDS));
    watch.close();
  }

  private static WatchEvent outdatedEvent() {
    return new WatchEventBuilder().withStatusObject(
      new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
        .withMessage(
        "410: The event in requested index is outdated and cleared (the requested history has been cleared [3/1]) [2]")
      .build()).build();
  }
}
