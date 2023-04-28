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

package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WatchIT {

  KubernetesClient client;

  private static final Logger logger = LoggerFactory.getLogger(WatchIT.class);

  @Test
  void testWatch() throws InterruptedException {
    Pod pod1 = new PodBuilder()
        .withNewMetadata().withName("sample-watch-pod").endMetadata()
        .withNewSpec()
        .addNewContainer().withName("nginx").withImage("nginx").endContainer()
        .endSpec()
        .build();

    client.pods().create(pod1);

    final CountDownLatch eventLatch = new CountDownLatch(1);
    final CountDownLatch modifyLatch = new CountDownLatch(1);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    Watch watch = client.pods().withName("sample-watch-pod").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod pod) {
        eventLatch.countDown();

        if (action.equals(Action.MODIFIED))
          modifyLatch.countDown();
        logger.info("Action : {} Pod name : {}", action.name(), pod.getMetadata().getName());
      }

      @Override
      public void onClose(WatcherException cause) {

      }

      @Override
      public void onClose() {
        closeLatch.countDown();
        logger.info("watch closed...");
      }
    });

    client.pods()

        .withName("sample-watch-pod")
        .patch(PatchContext.of(PatchType.STRATEGIC_MERGE), new PodBuilder()
            .withNewMetadata()
            .addToLabels("foo", "bar")
            .endMetadata()
            .build());

    assertTrue(eventLatch.await(10, TimeUnit.SECONDS));
    assertTrue(modifyLatch.await(10, TimeUnit.SECONDS));
    watch.close();
    assertTrue(closeLatch.await(30, TimeUnit.SECONDS));
  }

  @Test
  void testWatchFailureHandling() throws InterruptedException {
    String name = "sample-configmap-watch";

    Resource<ConfigMap> configMapClient = client.configMaps().withName(name);

    configMapClient.create(new ConfigMapBuilder().withNewMetadata().withName(name).endMetadata().build());

    final CountDownLatch eventLatch = new CountDownLatch(1);
    final CountDownLatch modifyLatch = new CountDownLatch(1);
    final AtomicBoolean inMethod = new AtomicBoolean();
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final AtomicBoolean concurrent = new AtomicBoolean();
    Watch watch = configMapClient.watch(new Watcher<ConfigMap>() {
      @Override
      public void eventReceived(Action action, ConfigMap pod) {
        eventLatch.countDown();

        if (action.equals(Action.MODIFIED)) {
          if (inMethod.getAndSet(true)) {
            concurrent.set(true);
            modifyLatch.countDown();
          }
          try {
            // introduce a delay to cause the ping to terminate the connection
            // and that holds the thread for longer than the request timeout
            Thread.sleep(Config.DEFAULT_REQUEST_TIMEOUT);
            // TODO: could use withRequestConfig to use a shorter timeout
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
          }
          modifyLatch.countDown();
          inMethod.set(false);
        }
      }

      @Override
      public void onClose(WatcherException cause) {

      }

      @Override
      public void onClose() {
        closeLatch.countDown();
        logger.info("watch closed...");
      }
    });

    configMapClient
        .patch(PatchContext.of(PatchType.STRATEGIC_MERGE), new ConfigMapBuilder()
            .withNewMetadata()
            .addToLabels("foo", "bar")
            .endMetadata()
            .build());

    configMapClient
        .patch(PatchContext.of(PatchType.STRATEGIC_MERGE), new ConfigMapBuilder()
            .withNewMetadata()
            .addToLabels("foo", "bar1")
            .endMetadata()
            .build());

    assertTrue(eventLatch.await(10, TimeUnit.SECONDS));
    assertTrue(modifyLatch.await(30, TimeUnit.SECONDS));
    assertFalse(concurrent.get());
    watch.close();
    assertTrue(closeLatch.await(30, TimeUnit.SECONDS));
  }
}
