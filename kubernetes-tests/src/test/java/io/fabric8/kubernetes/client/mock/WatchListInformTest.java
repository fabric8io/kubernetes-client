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
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.api.model.WatchEventBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(https = false, kubernetesClientBuilderCustomizer = WatchListCustomizer.class)
class WatchListInformTest {

  private static final Long EVENT_WAIT_PERIOD_MS = 10L;

  private static final Status outdatedStatus = new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
      .withMessage("410: the requested watch resource version is outdated")
      .build();
  private static final WatchEvent outdatedEvent = new WatchEventBuilder().withType(Watcher.Action.ERROR.name())
      .withObject(outdatedStatus)
      .build();

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
    final CountDownLatch nonEmptyList = new CountDownLatch(1);
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

      @Override
      public void onList(String resourceVersion, boolean remainedEmpty) {
        if (!remainedEmpty) {
          nonEmptyList.countDown();
        }
      }

    };
    // When
    SharedIndexInformer<Pod> informer = client.pods().withLabel("my-label").inform(handler);

    assertTrue(deleteLatch.await(10, TimeUnit.SECONDS));
    assertTrue(addLatch.await(10, TimeUnit.SECONDS));
    assertTrue(nonEmptyList.await(10, TimeUnit.SECONDS));

    informer.stop();
  }

  @Test
  @DisplayName("watchList path delivers onBeforeList(null) before the initial add and before onList, through the real informer pipeline")
  void onBeforeListPrecedesInitialEventsOnWatchListPath() throws InterruptedException {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withNamespace("test").withName("pod1").withResourceVersion("1").endMetadata()
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
        .done()
        .once();

    final List<String> events = new CopyOnWriteArrayList<>();
    final CountDownLatch listLatch = new CountDownLatch(1);
    final ResourceEventHandler<Pod> handler = new ResourceEventHandler<Pod>() {
      @Override
      public void onBeforeList(String lastSyncResourceVersion) {
        events.add("beforeList:" + lastSyncResourceVersion);
      }

      @Override
      public void onAdd(Pod obj) {
        events.add("add:" + obj.getMetadata().getName());
      }

      @Override
      public void onUpdate(Pod oldObj, Pod newObj) {
        events.add("update:" + newObj.getMetadata().getName());
      }

      @Override
      public void onDelete(Pod obj, boolean deletedFinalStateUnknown) {
        events.add("delete:" + obj.getMetadata().getName());
      }

      @Override
      public void onList(String resourceVersion, boolean remainedEmpty) {
        events.add("list:" + resourceVersion);
        listLatch.countDown();
      }
    };

    // When
    SharedIndexInformer<Pod> informer = client.pods().withLabel("my-label").inform(handler);
    assertTrue(listLatch.await(10, TimeUnit.SECONDS));

    // Then the ordering guarantee holds on the watchList path too: onBeforeList(null) is first,
    // the initial add (flushed when the bookmark completes the synthetic list) precedes onList.
    assertThat(events.indexOf("beforeList:null")).isZero();
    assertThat(events.indexOf("beforeList:null")).isLessThan(events.indexOf("add:pod1"));
    assertThat(events.indexOf("add:pod1")).isLessThan(events.indexOf("list:2"));

    informer.stop();
  }

  @Test
  @DisplayName("watchList path re-arms onBeforeList after the bookmark completes the list, firing again with the frozen bookmark resourceVersion on HTTP GONE re-list")
  void onBeforeListReArmsOnWatchListRelist() throws InterruptedException {
    // Given a first watchList cycle that completes via a bookmark at v2, then sees an HTTP GONE
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withNamespace("test").withName("pod1").withResourceVersion("1").endMetadata()
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
        .andEmit(outdatedEvent)
        .done()
        .once();
    // the re-list cycle re-establishes a watchList from the frozen bookmark version (resourceVersion=2)
    server.expect()
        .withPath(
            "/api/v1/namespaces/test/pods?allowWatchBookmarks=true&labelSelector=my-label&resourceVersion=2&resourceVersionMatch=NotOlderThan&sendInitialEvents=true&timeoutSeconds=600&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();

    final List<String> beforeListArgs = new CopyOnWriteArrayList<>();
    final CountDownLatch twoBeforeLists = new CountDownLatch(2);
    final ResourceEventHandler<Pod> handler = new ResourceEventHandler<Pod>() {
      @Override
      public void onBeforeList(String lastSyncResourceVersion) {
        beforeListArgs.add(lastSyncResourceVersion);
        twoBeforeLists.countDown();
      }

      @Override
      public void onAdd(Pod obj) {
      }

      @Override
      public void onUpdate(Pod oldObj, Pod newObj) {
      }

      @Override
      public void onDelete(Pod obj, boolean deletedFinalStateUnknown) {
      }
    };

    // When
    SharedIndexInformer<Pod> informer = client.pods().withLabel("my-label").inform(handler);
    assertTrue(twoBeforeLists.await(10, TimeUnit.SECONDS));

    // Then onBeforeList re-armed via the BOOKMARK branch and fired again for the fresh cycle,
    // carrying the frozen bookmark version "2".
    assertThat(beforeListArgs.get(0)).isNull();
    assertThat(beforeListArgs.get(1)).isEqualTo("2");

    informer.stop();
  }

}
