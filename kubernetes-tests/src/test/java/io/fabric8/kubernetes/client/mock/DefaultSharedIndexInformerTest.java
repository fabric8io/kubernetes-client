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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.api.model.WatchEventBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;

public class DefaultSharedIndexInformerTest {
  @Rule
  public KubernetesServer server = new KubernetesServer(false);

  static final Status outdatedStatus = new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
    .withMessage(
      "401: The event in requested index is outdated and cleared (the requested history has been cleared [3/1]) [2]")
    .build();
  static final WatchEvent outdatedEvent = new WatchEventBuilder().withObject(outdatedStatus).build();

  @Test
  public void testNamespacedPodInformer() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Arrays.asList()).build()).once();
    server.expect().withPath("/api/v1/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(2000)
      .andEmit(outdatedEvent).done().always();

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, 4000L);

    AtomicBoolean foundExistingPod = new AtomicBoolean(false);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) {
          if (obj.getMetadata().getName().equalsIgnoreCase("pod1")) {
            foundExistingPod.set(true);
          }
        }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    Thread.sleep(1000);
    factory.startAllRegisteredInformers();

    Thread.sleep(3000L);
    assertEquals(true, foundExistingPod.get());
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());

    factory.stopAllRegisteredInformers();
  }

  @Test
  public void testAllNamespacedInformer() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Arrays.asList()).build()).once();
    server.expect().withPath("/api/v1/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("default").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(2000)
      .andEmit(outdatedEvent).done().always();

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, 4000L);

    AtomicBoolean foundExistingPod = new AtomicBoolean(false);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) {
          if (obj.getMetadata().getName().equalsIgnoreCase("pod1") && obj.getMetadata().getNamespace().equalsIgnoreCase("default")) {
            foundExistingPod.set(true);
          }
        }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    Thread.sleep(1000);
    factory.startAllRegisteredInformers();

    Thread.sleep(3000L);
    assertEquals(true, foundExistingPod.get());
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());

    factory.stopAllRegisteredInformers();
  }
}
