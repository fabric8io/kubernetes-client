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
package io.fabric8.kubernetes.client.informers.impl.cache;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.informers.cache.Cache;
import io.fabric8.kubernetes.client.informers.impl.cache.ProcessorListener.AddNotification;
import io.fabric8.kubernetes.client.informers.impl.cache.ProcessorListener.DeleteNotification;
import io.fabric8.kubernetes.client.informers.impl.cache.ProcessorListener.Notification;
import io.fabric8.kubernetes.client.informers.impl.cache.ProcessorListener.UpdateNotification;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProcessorStoreTest {

  @Test
  void testEvents() {
    ArgumentCaptor<Notification<Pod>> notificationCaptor = ArgumentCaptor.forClass(Notification.class);
    ArgumentCaptor<Boolean> syncCaptor = ArgumentCaptor.forClass(Boolean.class);
    CacheImpl<Pod> podCache = Mockito.mock(CacheImpl.class);
    SharedProcessor<Pod> processor = Mockito.mock(SharedProcessor.class);

    ProcessorStore<Pod> processorStore = new ProcessorStore<>(podCache, processor);
    Pod pod = new PodBuilder().withNewMetadata().withName("pod").endMetadata().build();

    // add notification
    processorStore.add(pod);

    // add notification, because the pod doesn't exist in the store
    processorStore.update(pod);

    // ignored
    processorStore.delete(pod);

    // update notification
    Mockito.when(podCache.put(pod)).thenReturn(pod);
    processorStore.update(pod);

    // delete notification
    Mockito.when(podCache.remove(pod)).thenReturn(pod);
    processorStore.delete(pod);

    Mockito.verify(processor, Mockito.times(3)).distribute(notificationCaptor.capture(), syncCaptor.capture());

    List<Notification<Pod>> notifications = notificationCaptor.getAllValues();

    assertThat(notifications.get(0)).isInstanceOf(AddNotification.class);
    assertThat(notifications.get(1)).isInstanceOf(AddNotification.class);
    assertThat(notifications.get(2)).isInstanceOf(DeleteNotification.class);

    List<Boolean> syncValues = syncCaptor.getAllValues();

    assertThat(syncValues.get(0)).isFalse();
    assertThat(syncValues.get(1)).isFalse();
    assertThat(syncValues.get(2)).isFalse();
  }

  @Test
  void testSyncEvents() {
    ArgumentCaptor<Notification<Pod>> notificationCaptor = ArgumentCaptor.forClass(Notification.class);
    ArgumentCaptor<Boolean> syncCaptor = ArgumentCaptor.forClass(Boolean.class);
    CacheImpl<Pod> podCache = new CacheImpl<>();
    SharedProcessor<Pod> processor = Mockito.mock(SharedProcessor.class);

    ProcessorStore<Pod> processorStore = new ProcessorStore<>(podCache, processor);

    Pod pod = new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion("1").endMetadata().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withResourceVersion("2").endMetadata().build();

    // replace empty store with two values
    List<Pod> pods = Arrays.asList(pod, pod2);
    processorStore.update(pods);

    processorStore.retainAll(pods.stream().map(Cache::metaNamespaceKeyFunc).collect(Collectors.toSet()));

    // resync two values
    processorStore.resync();

    // relist with deletes
    processorStore.retainAll(Collections.emptySet());

    Mockito.verify(processor, Mockito.times(6)).distribute(notificationCaptor.capture(), syncCaptor.capture());

    List<Notification<Pod>> notifications = notificationCaptor.getAllValues();

    assertThat(notifications.get(0)).isInstanceOf(AddNotification.class);
    assertThat(notifications.get(1)).isInstanceOf(AddNotification.class);
    assertThat(notifications.get(2)).isInstanceOf(UpdateNotification.class);
    assertThat(notifications.get(3)).isInstanceOf(UpdateNotification.class);
    assertTrue(syncCaptor.getAllValues().subList(0, 2).stream().allMatch(s -> !s.booleanValue()));
    assertTrue(syncCaptor.getAllValues().subList(2, 4).stream().allMatch(s -> s.booleanValue()));

    assertThat(notifications.get(4)).isInstanceOf(DeleteNotification.class);
    assertThat(notifications.get(5)).isInstanceOf(DeleteNotification.class);
    assertTrue(syncCaptor.getAllValues().subList(4, 6).stream().allMatch(s -> !s.booleanValue()));
  }

  @Test
  void testResyncLock() throws InterruptedException {
    CacheImpl<Pod> podCache = new CacheImpl<>();
    SharedProcessor<Pod> processor = Mockito.mock(SharedProcessor.class);

    ProcessorStore<Pod> processorStore = new ProcessorStore<>(podCache, processor);

    Pod pod = new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion("1").endMetadata().build();

    List<Pod> pods = Arrays.asList(pod);
    processorStore.update(pods);

    Mockito.doAnswer(invocation -> {
      assertTrue(Thread.holdsLock(podCache.getLockObject()));
      return null;
    }).when(processor).distribute(Mockito.any(ProcessorListener.Notification.class), Mockito.anyBoolean());
    processorStore.resync();

    Mockito.verify(processor).distribute(Mockito.any(ProcessorListener.Notification.class), Mockito.anyBoolean());
  }

}
