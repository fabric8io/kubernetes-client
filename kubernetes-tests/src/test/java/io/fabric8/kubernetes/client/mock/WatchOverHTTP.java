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
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WatchOverHTTP {
  static final Pod pod1 = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
    .withResourceVersion("1").endMetadata().build();
  static final Status outdatedStatus = new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
    .withMessage(
      "401: The event in requested index is outdated and cleared (the requested history has been cleared [3/1]) [2]")
    .build();
  static final WatchEvent outdatedEvent = new WatchEventBuilder().withStatusObject(outdatedStatus).build();
  final String path = "/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true";
  @Rule
  public KubernetesServer server = new KubernetesServer(false);
  Logger logger = LoggerFactory.getLogger(WatchTest.class);

  @Test
  public void testDeleted() throws InterruptedException {
    logger.info("testDeleted");
    KubernetesClient client = server.getClient().inNamespace("test");

    server.expect()
      .withPath(path)
      .andReturn(200, "Failed WebSocket Connection").once();
    server.expect().withPath(path).andReturnChunked(200,
      new WatchEvent(pod1, "DELETED"), "\n",
      new WatchEvent(pod1, "ADDED"), "\n").once();

    final CountDownLatch addLatch = new CountDownLatch(1);
    final CountDownLatch deleteLatch = new CountDownLatch(1);
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
      public void onClose(KubernetesClientException cause) {}
    })) /* autoclose */ {
      assertTrue(addLatch.await(10, TimeUnit.SECONDS));
      assertTrue(deleteLatch.await(10, TimeUnit.SECONDS));
    }
  }

  @Test
  public void testOutdated() throws InterruptedException {
    logger.info("testOutdated");
    KubernetesClient client = server.getClient().inNamespace("test");

    server.expect()
      .withPath(path)
      .andReturn(200, "Failed WebSocket Connection").once();
    server.expect().withPath(path).andReturnChunked(200, outdatedEvent, "\n").once();
    try (Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        throw new AssertionFailedError();
      }

      @Override
      public void onClose(KubernetesClientException cause) {
        throw new AssertionFailedError();
      }
    })){};
  }

  @Test
  public void testHttpErrorReconnect() throws InterruptedException {
    logger.info("testHttpErrorReconnect");
    KubernetesClient client = server.getClient().inNamespace("test");

    server.expect()
      .withPath(path)
      .andReturn(200, "Failed WebSocket Connection").once();
    server.expect().withPath(path).andReturnChunked(503, new StatusBuilder().withCode(503).build()).times(6);
    server.expect().withPath(path).andReturnChunked(200, outdatedEvent, "\n").once();

    final CountDownLatch closeLatch = new CountDownLatch(1);
    try (Watch watch = client.pods().withName("pod1").withResourceVersion("1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        throw new AssertionFailedError();
      }

      @Override
      public void onClose(KubernetesClientException cause) {
        logger.debug("onClose", cause);
        closeLatch.countDown();
      }
    })) /* autoclose */ {
      assertTrue(closeLatch.await(3, TimeUnit.MINUTES));
    }
  }
}
