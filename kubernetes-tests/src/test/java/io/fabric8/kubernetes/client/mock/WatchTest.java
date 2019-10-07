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

import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.api.model.WatchEventBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import java.net.HttpURLConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableRuleMigrationSupport
public class WatchTest {
  Logger logger = LoggerFactory.getLogger(WatchTest.class);

  @Rule
  public KubernetesServer server = new KubernetesServer(false);

  static final Pod pod1 = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
      .withResourceVersion("1").endMetadata().build();

  static final Status outdatedStatus = new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
      .withMessage(
          "401: The event in requested index is outdated and cleared (the requested history has been cleared [3/1]) [2]")
      .build();
  static final WatchEvent outdatedEvent = new WatchEventBuilder().withStatusObject(outdatedStatus).build();

  private static final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void testDeletedOutdatedAndAdded() throws InterruptedException {
    logger.info("testDeletedAndOutdated");
    KubernetesClient client = server.getClient().inNamespace("test");

    final String path = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true";
    final String pathWithoutResourceVersion = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=true";

    // DELETED event, then history outdated
    server.expect()
        .withPath(path)
        .andUpgradeToWebSocket().open().waitFor(2000).andEmit(new WatchEvent(pod1, "DELETED")).waitFor(2000)
        .andEmit(outdatedEvent).done().once();

    // ADDED event
    server.expect()
        .withPath(pathWithoutResourceVersion)
        .andUpgradeToWebSocket().open().waitFor(2000).andEmit(new WatchEvent(pod1, "ADDED")).done().once();

    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch addLatch = new CountDownLatch(1);
    final boolean[] onCloseCalled = {false};
    try (Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        switch (action) {
        case DELETED:
          deleteLatch.countDown();
          break;
        case ADDED:
          addLatch.countDown();
          break;
        default:
          throw new AssertionFailedError();
        }
      }

      @Override
      public void onClose(KubernetesClientException cause) {
        onCloseCalled[0] =true;
      }
    })) /* autoclose */ {
      assertTrue(deleteLatch.await(10, TimeUnit.SECONDS));
      assertTrue(addLatch.await(10, TimeUnit.SECONDS));
    }
    assertTrue(onCloseCalled[0]);
  }

  @Test
  public void testHttpOutdatedAndModified() throws InterruptedException,
                                                   JsonProcessingException {
    KubernetesClient client = server.getClient().inNamespace("test");

    final String path = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true";
    final String pathWithoutResourceVersion = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=true";

    server.expect()
        .withPath(path)
        .andReturn(200, new StatusBuilder().withCode(200).build()).once();
    server.expect()
        .withPath(path)
        .andReturn(200, mapper.writeValueAsString(outdatedEvent) + '\n').once();
    server.expect()
        .withPath(pathWithoutResourceVersion)
        .andReturn(201, mapper.writeValueAsString(pod1) + '\n').once();

    final CountDownLatch modifyLatch = new CountDownLatch(1);
    try (Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        switch (action) {
          case MODIFIED:
            modifyLatch.countDown();
            break;
          default:
            throw new AssertionFailedError();
        }
      }

      @Override
      public void onClose(KubernetesClientException cause) {
      }
    })) /* autoclose */ {
      assertTrue(modifyLatch.await(10, TimeUnit.SECONDS));
    }
  }

  @Test
  public void testHttpErrorWithOutdated() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      logger.info("testHttpErrorWithOutdated");
      KubernetesClient client = server.getClient().inNamespace("test");
      // http error: history outdated
      server.expect()
        .withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true")
        .andReturn(410, outdatedEvent).once();
      final boolean[] onCloseCalled = {false};
      try (Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
        @Override
        public void eventReceived(Action action, Pod resource) {
          throw new AssertionFailedError();
        }

        @Override
        public void onClose(KubernetesClientException cause) {
          onCloseCalled[0] =true;
        }
      })) {

      }
      assertTrue(onCloseCalled[0]);
    });
  }

  @Test
  public void testHttpErrorReconnect() throws InterruptedException {
    logger.info("testHttpErrorReconnect");
    String path = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true";
    KubernetesClient client = server.getClient().inNamespace("test");
    // accept watch and disconnect
    server.expect().withPath(path).andUpgradeToWebSocket().open().done().once();
    // refuse reconnect attempts 6 times
    server.expect().withPath(path).andReturn(503, new StatusBuilder().withCode(503).build()).times(6);
    // accept next reconnect and send ADDED event
    server.expect().withPath(path)
        .andUpgradeToWebSocket().open(new WatchEvent(pod1, "ADDED")).done().once();

    final CountDownLatch addLatch = new CountDownLatch(1);
    final boolean[] onCloseCalled = {false};
    try (Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        addLatch.countDown();
      }

      @Override
      public void onClose(KubernetesClientException cause) {
        logger.debug("onClose", cause);
        onCloseCalled[0] =true;
      }
    })) /* autoclose */ {
      assertTrue(addLatch.await(3, TimeUnit.MINUTES));
    }
    assertTrue(onCloseCalled[0]);
  }

  @Test
  public void testOnCloseEvent() throws InterruptedException {
    logger.info("testOnCloseEvent");
    final CountDownLatch eventLatch = new CountDownLatch(2);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    KubernetesClient client = server.getClient().inNamespace("test");

    server.expect()
      .withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true")
      .andUpgradeToWebSocket().open().waitFor(2000).andEmit(new WatchEvent(pod1, "MODIFIED")).waitFor(2000)
      .andEmit(new WatchEvent(pod1, "MODIFIED")).done().once();

    Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        eventLatch.countDown();
      }

      @Override
      public void onClose(KubernetesClientException cause) {
        closeLatch.countDown();
      }
    });

    assertTrue(eventLatch.await(10, TimeUnit.SECONDS));
    watch.close();
    assertTrue(closeLatch.await(10, TimeUnit.SECONDS));
  }

  @Test
  public void testReconnectsWithLastResourceVersion() throws InterruptedException {
    logger.info("testOnCloseEvent");
    final CountDownLatch eventLatch = new CountDownLatch(3);
    KubernetesClient client = server.getClient().inNamespace("test");


    final Pod pod1initial = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
      .withResourceVersion("9").endMetadata().build();


    final Pod pod1update = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
      .withResourceVersion("10").endMetadata().build();

    final String path = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true";

    server.expect()
      .withPath(path)
      .andUpgradeToWebSocket().open()
      .waitFor(2000).andEmit(new WatchEvent(pod1initial, "MODIFIED"))
      .waitFor(2000).andEmit(new WatchEvent(pod1update, "MODIFIED"))
      .done().once();

    final String reconnectPath = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=10&watch=true";

    server.expect()
      .withPath(reconnectPath)
      .andUpgradeToWebSocket().open()
      .waitFor(2000).andEmit(new WatchEvent(pod1update, "MODIFIED"))
      .done().once();


    Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        eventLatch.countDown();
      }

      @Override
      public void onClose(KubernetesClientException cause) {
      }
    });

    assertTrue(eventLatch.await(10, TimeUnit.SECONDS));
    watch.close();
  }

}
