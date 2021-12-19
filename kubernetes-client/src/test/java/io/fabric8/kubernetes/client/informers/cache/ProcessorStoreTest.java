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
package io.fabric8.kubernetes.client.informers.cache;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.informers.cache.ProcessorListener.AddNotification;
import io.fabric8.kubernetes.client.informers.cache.ProcessorListener.DeleteNotification;
import io.fabric8.kubernetes.client.informers.cache.ProcessorListener.Notification;
import io.fabric8.kubernetes.client.informers.cache.ProcessorListener.UpdateNotification;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessorStoreTest {

  @Test
  public void testEvents() {
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

    Mockito.verify(processor, Mockito.times(4)).distribute(notificationCaptor.capture(), syncCaptor.capture());
    
    List<Notification<Pod>> notifications = notificationCaptor.getAllValues();
    
    assertThat(notifications.get(0)).isInstanceOf(AddNotification.class);
    assertThat(notifications.get(1)).isInstanceOf(AddNotification.class);
    assertThat(notifications.get(2)).isInstanceOf(UpdateNotification.class);
    assertThat(notifications.get(3)).isInstanceOf(DeleteNotification.class);
    
    assertTrue(syncCaptor.getAllValues().stream().allMatch(s->!s.booleanValue()));
  }
  
  @Test
  public void testSyncEvents() {
    ArgumentCaptor<Notification<Pod>> notificationCaptor = ArgumentCaptor.forClass(Notification.class);
    ArgumentCaptor<Boolean> syncCaptor = ArgumentCaptor.forClass(Boolean.class);
    CacheImpl<Pod> podCache = new CacheImpl<>();
    SharedProcessor<Pod> processor = Mockito.mock(SharedProcessor.class);

    ProcessorStore<Pod> processorStore = new ProcessorStore<>(podCache, processor);
    
    Pod pod = new PodBuilder().withNewMetadata().endMetadata().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").endMetadata().build();
    
    // replace empty store with two values
    processorStore.replace(Arrays.asList(pod, pod2));

    // resync two values
    processorStore.resync();
    
    // relist with deletes
    processorStore.replace(Collections.emptyList());
    
    Mockito.verify(processor, Mockito.times(6)).distribute(notificationCaptor.capture(), syncCaptor.capture());
    
    List<Notification<Pod>> notifications = notificationCaptor.getAllValues();
    
    assertThat(notifications.get(0)).isInstanceOf(AddNotification.class);
    assertThat(notifications.get(1)).isInstanceOf(AddNotification.class);
    assertThat(notifications.get(2)).isInstanceOf(UpdateNotification.class);
    assertThat(notifications.get(3)).isInstanceOf(UpdateNotification.class);
    assertTrue(syncCaptor.getAllValues().subList(0, 2).stream().allMatch(s->!s.booleanValue()));
    assertTrue(syncCaptor.getAllValues().subList(2, 4).stream().allMatch(s->s.booleanValue()));
    
    assertThat(notifications.get(4)).isInstanceOf(DeleteNotification.class);
    assertThat(notifications.get(5)).isInstanceOf(DeleteNotification.class);
    assertTrue(syncCaptor.getAllValues().subList(4, 6).stream().allMatch(s->!s.booleanValue()));    
  }
  
}
