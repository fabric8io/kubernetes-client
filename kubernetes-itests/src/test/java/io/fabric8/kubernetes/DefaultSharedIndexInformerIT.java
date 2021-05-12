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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class DefaultSharedIndexInformerIT {
  @ArquillianResource
  KubernetesClient client;

  private static final long RESYNC_PERIOD = 1000L;

  @Test
  public void testPodSharedIndexInformerGetsEvents() throws InterruptedException {
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
  public void testPodSharedIndexInformerGetsSingleUpdates() throws InterruptedException {
    // Given
    String namespace = "kube-system";
    PodList podList = client.pods().inNamespace(namespace).list();
    int expectedAddEvents = podList.getItems().size();
    CountDownLatch addEvents = new CountDownLatch(expectedAddEvents);
    // Let's assume informer resyncs at least two times so we would get update
    // events for all pods two times
    CountDownLatch updateEvents = new CountDownLatch(2 * expectedAddEvents);
    SharedInformerFactory informerFactory = client.informers();
    SharedIndexInformer<Pod> podInformer = informerFactory.inNamespace(namespace).sharedIndexInformerFor(Pod.class, RESYNC_PERIOD);
    TestResourceEventHandler<Pod> eventHandler = new TestResourceEventHandler<>(addEvents, updateEvents);
    podInformer.addEventHandler(eventHandler);

    // When
    informerFactory.startAllRegisteredInformers();
    updateEvents.await(3 * RESYNC_PERIOD, TimeUnit.MILLISECONDS);
    addEvents.await(3 * RESYNC_PERIOD, TimeUnit.MILLISECONDS);

    // Then
    assertThat(addEvents.getCount()).isZero();
    assertThat(updateEvents.getCount()).isZero();
    assertThat(eventHandler.getUpdateEventsCount()).isLessThan(4 * expectedAddEvents);
    informerFactory.stopAllRegisteredInformers();
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
    public void onDelete(T obj, boolean deletedFinalStateUnknown) { }

    public int getUpdateEventsCount() {
      return updateCount.get();
    }
  }
}
