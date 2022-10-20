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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DefaultSharedIndexInformerIT {

  KubernetesClient client;

  private static final long RESYNC_PERIOD = 1000L;

  @Test
  void testPodSharedIndexInformerGetsEvents() throws InterruptedException {
    // Given
    CountDownLatch addEvents = new CountDownLatch(1);
    CountDownLatch updateEvents = new CountDownLatch(0);
    SharedInformerFactory informerFactory = client.informers();
    SharedIndexInformer<Pod> podInformer = informerFactory.sharedIndexInformerFor(Pod.class, RESYNC_PERIOD);
    podInformer.addEventHandler(new TestResourceEventHandler<>(addEvents, updateEvents));

    // When
    informerFactory.startAllRegisteredInformers();
    addEvents.await(2 * RESYNC_PERIOD, TimeUnit.MILLISECONDS);

    // Then
    assertThat(addEvents.getCount()).isZero();
    informerFactory.stopAllRegisteredInformers();
  }

  @Test
  void testSharedIndexInformerGetsSingleUpdates() throws InterruptedException {
    client.configMaps().withName("my-map").delete();

    CountDownLatch addEvents = new CountDownLatch(1);
    // Let's assume informer resyncs at least two times
    CountDownLatch updateEvents = new CountDownLatch(2);

    TestResourceEventHandler<HasMetadata> eventHandler = new TestResourceEventHandler<>(addEvents, updateEvents);

    SharedIndexInformer<ConfigMap> informer = client.configMaps().withName("my-map").inform(eventHandler, RESYNC_PERIOD);

    client.configMaps().create(new ConfigMapBuilder().withNewMetadata().withName("my-map").endMetadata().build());
    try {
      // When
      addEvents.await(30000, TimeUnit.MILLISECONDS);
      updateEvents.await(30000, TimeUnit.MILLISECONDS);

      // Then
      assertThat(addEvents.getCount()).isZero();
      assertThat(updateEvents.getCount()).isZero();
    } finally {
      informer.stop();
    }
  }

  @Test
  void testLimit() throws Exception {
    client.configMaps().delete();

    client.configMaps().create(new ConfigMapBuilder().withNewMetadata().withName("my-map1").endMetadata().build());
    client.configMaps().create(new ConfigMapBuilder().withNewMetadata().withName("my-map2").endMetadata().build());

    CountDownLatch addEvents = new CountDownLatch(2);

    TestResourceEventHandler<HasMetadata> eventHandler = new TestResourceEventHandler<>(addEvents, new CountDownLatch(1));

    SharedIndexInformer<ConfigMap> informer = client.configMaps().withLimit(1L).inform(eventHandler, RESYNC_PERIOD);

    try {
      // When
      addEvents.await(30000, TimeUnit.MILLISECONDS);

      // Then
      assertThat(addEvents.getCount()).isZero();
    } finally {
      informer.stop();
    }
  }

  private static class TestResourceEventHandler<T extends HasMetadata> implements ResourceEventHandler<T> {
    private final CountDownLatch addEventRecievedLatch;
    private final CountDownLatch updateEventRecievedLatch;
    private final AtomicInteger updateCount;

    public TestResourceEventHandler(CountDownLatch addLatch, CountDownLatch updateLatch) {
      this.updateEventRecievedLatch = updateLatch;
      this.addEventRecievedLatch = addLatch;
      this.updateCount = new AtomicInteger(0);
    }

    @Override
    public void onAdd(T resource) {
      addEventRecievedLatch.countDown();
    }

    @Override
    public void onUpdate(T oldResource, T newResource) {
      updateEventRecievedLatch.countDown();
      updateCount.incrementAndGet();
    }

    @Override
    public void onDelete(T obj, boolean deletedFinalStateUnknown) {
    }

    public int getUpdateEventsCount() {
      return updateCount.get();
    }
  }
}
