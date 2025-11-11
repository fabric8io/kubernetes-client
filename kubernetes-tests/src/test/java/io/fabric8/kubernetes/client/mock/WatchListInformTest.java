/*
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
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(https = false, kubernetesClientBuilderCustomizer = WatchListCustomizer.class)
class WatchListInformTest {

  private static final Long EVENT_WAIT_PERIOD_MS = 10L;

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testInformPodWithLabel() throws InterruptedException {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withNamespace("test")
        .withName("pod1")
        .withResourceVersion("1")
        .endMetadata()
        .build();

    server.expect()
        .withPath(
            "/api/v1/namespaces/test/pods?allowWatchBookmarks=true&labelSelector=my-label&resourceVersionMatch=NotOlderThan&sendInitialEvents=true&timeoutSeconds=600&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "ADDED"))
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withResourceVersion("2").endMetadata().build(), "BOOKMARK"))
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "DELETED"))
        .done()
        .once();
    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch addLatch = new CountDownLatch(1);
    final ResourceEventHandler<Pod> handler = new ResourceEventHandler<Pod>() {

      @Override
      public void onAdd(Pod obj) {
        addLatch.countDown();
      }

      @Override
      public void onDelete(Pod obj, boolean deletedFinalStateUnknown) {
        deleteLatch.countDown();
      }

      @Override
      public void onUpdate(Pod oldObj, Pod newObj) {

      }

    };
    // When
    SharedIndexInformer<Pod> informer = client.pods().withLabel("my-label").inform(handler);

    assertTrue(deleteLatch.await(10, TimeUnit.SECONDS));
    assertTrue(addLatch.await(10, TimeUnit.SECONDS));

    informer.stop();
  }

}
