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
import io.fabric8.kubernetes.client.utils.Serialization;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static io.fabric8.kubernetes.client.Watcher.Action.BOOKMARK;
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
    pod1 = new PodBuilder().withNewMetadata()
        .withNamespace("test")
        .withName("pod1")
        .withResourceVersion("1")
        .endMetadata()
        .build();
  }

  @Test
  @DisplayName("TryWithResources, connects and receives event then receives GONE, should receive first event and then close")
  void testTryWithResourcesConnectsThenReceivesEvent() throws InterruptedException {
    // Given
    server.expect()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "DELETED"))
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(outdatedEvent())
        .done()
        .once();
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
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&allowWatchBookmarks=true&watch=true")
        .andReturn(410, outdatedEvent())
        .once();
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
    final Watchable<Pod> watchable = client.pods().withName("pod1").withResourceVersion("1");
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
        .withPath("/api/v1/namespaces/test/pods?timeoutSeconds=30&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "DELETED"))
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(outdatedEvent())
        .done()
        .once();

    // When
    final CountDownLatch eventReceivedLatch = new CountDownLatch(1);
    Watch watch = client.pods().watch(new ListOptionsBuilder().withTimeoutSeconds(30L).build(), new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        eventReceivedLatch.countDown();
      }

      @Override
      public void onClose(WatcherException cause) {
      }
    });

    // Then
    assertTrue(eventReceivedLatch.await(10, TimeUnit.SECONDS));
    watch.close();
  }

  /**
   * Will attempt a reconnect after 10ms..20ms...40ms....80ms.....160ms......320ms
   */
  @Test
  void testHttpErrorReconnect() throws InterruptedException {
    // Given
    client.getConfiguration().setWatchReconnectInterval(10);
    final String path = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&allowWatchBookmarks=true&watch=true";
    // accept watch and disconnect
    server.expect().withPath(path).andUpgradeToWebSocket().open().done().once();
    // refuse reconnect attempts 6 times
    server.expect()
        .withPath(path)
        .andReturn(HttpURLConnection.HTTP_NOT_FOUND,
            new StatusBuilder().withCode(HttpURLConnection.HTTP_NOT_FOUND).build())
        .times(6);
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
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "MODIFIED"))
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "MODIFIED"))
        .done()
        .once();

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

    final Pod pod1initial = new PodBuilder().withNewMetadata()
        .withNamespace("test")
        .withName("pod1")
        .withResourceVersion("9")
        .endMetadata()
        .build();

    final Pod pod1update = new PodBuilder().withNewMetadata()
        .withNamespace("test")
        .withName("pod1")
        .withResourceVersion("10")
        .endMetadata()
        .build();

    final String path = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&allowWatchBookmarks=true&watch=true";

    server.expect()
        .withPath(path)
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1initial, "MODIFIED"))
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1update, "MODIFIED"))
        .done()
        .once();

    final String reconnectPath = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=10&allowWatchBookmarks=true&watch=true";

    server.expect()
        .withPath(reconnectPath)
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1update, "MODIFIED"))
        .done()
        .once();

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
    return new WatchEventBuilder().withType(Watcher.Action.ERROR.name())
        .withStatusObject(
            new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
                .withMessage(
                    "410: The event in requested index is outdated and cleared (the requested history has been cleared [3/1]) [2]")
                .build())
        .build();
  }

  @Test
  @DisplayName("TryWithResources, connects and receives event then receives GONE, should receive first event and then close")
  void testTryWithResourcesConnectsThenReceivesEventBookmark() throws InterruptedException {
    // Given
    server.expect()
        .withPath(
            "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "BOOKMARK"))
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(outdatedEvent())
        .done()
        .once();
    final CountDownLatch bookmarkLatch = new CountDownLatch(1);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final Watcher<Pod> watcher = new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        if (action != BOOKMARK) {
          fail();
        }
        bookmarkLatch.countDown();
      }

      @Override
      public void onClose(WatcherException cause) {
        assertTrue(cause.isHttpGone());
        closeLatch.countDown();
      }
    };
    // When
    try (Watch watch = client.pods()
        .withName("pod1")
        .withResourceVersion("1")
        .watch(new ListOptionsBuilder().withAllowWatchBookmarks(true).build(), watcher)) {
      // Then
      assertNotNull(watch);
      assertTrue(bookmarkLatch.await(10, TimeUnit.SECONDS));
      assertTrue(closeLatch.await(10, TimeUnit.SECONDS));
    }
  }

  @Test
  void testErrorResponse() throws InterruptedException {
    // Given
    server.expect()
        .withPath("/api/v1/namespaces/test/pods?allowWatchBookmarks=true&watch=true")
        .andReturn(503, "may not be a status")
        .once();

    client.pods().watch(new Watcher<Pod>() {

      @Override
      public void eventReceived(Action action, Pod resource) {

      }

      @Override
      public void onClose(WatcherException cause) {
      }
    });

    // initial failure, then the http retry
    Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> server.getRequestCount() == 2);
  }

  @Test
  void testWatcherException() throws InterruptedException {
    // Given
    server.expect()
        .withPath("/api/v1/namespaces/test/pods?allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "MODIFIED"))
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "MODIFIED"))
        .done()
        .once();

    CountDownLatch latch = new CountDownLatch(2);

    client.pods().watch(new Watcher<Pod>() {

      @Override
      public void eventReceived(Action action, Pod resource) {
        latch.countDown();
        if (latch.getCount() == 1) {
          throw new RuntimeException();
        }
      }

      @Override
      public void onClose(WatcherException cause) {
      }
    });

    // ensure that the exception does not inhibit further message processing
    assertTrue(latch.await(10, TimeUnit.SECONDS));
  }

  @Test
  void testHttpWatch() throws InterruptedException {
    // Given

    // trigger the usage of the http watch
    server.expect()
        .withPath("/api/v1/namespaces/test/pods?allowWatchBookmarks=true&watch=true")
        .andReturn(200, null)
        .once();

    String dummyEvent = Serialization.asJson(new WatchEventBuilder().withType("MODIFIED")
        .withObject(new PodBuilder().withNewMetadata().endMetadata().build())
        .build()) + "\n";

    // build a response that is large enough to span multiple messages
    // there's potentially a corner case here with utf multi-byte that is unhandled
    // if that happens we'll see an exception from the decode
    server.expect()
        .withPath("/api/v1/namespaces/test/pods?allowWatchBookmarks=true&watch=true")
        .andReturn(200, Collections.nCopies(200, dummyEvent).stream().collect(Collectors.joining()))
        .once();

    CountDownLatch latch = new CountDownLatch(200);

    client.pods().watch(new Watcher<Pod>() {

      @Override
      public void eventReceived(Action action, Pod resource) {
        latch.countDown();
      }

      @Override
      public void onClose(WatcherException cause) {
      }
    });

    // ensure that the exception does not inhibit further message processing
    assertTrue(latch.await(10, TimeUnit.SECONDS));
  }
}
