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
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class DeltaFIFOTest {
  @Test
  void testBasic() throws InterruptedException {
    Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>> receivingDeltas = new LinkedList<>();
    Pod foo1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("default").endMetadata().build();
    Cache<Pod> cache = new Cache<>();

    DeltaFIFO<Pod> deltaFIFO = new DeltaFIFO<>(Cache::deletionHandlingMetaNamespaceKeyFunc, cache);
    AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object> receivingDelta;

    // Add operation
    deltaFIFO.add(foo1);
    cache.add(foo1);
    deltaFIFO.pop(
      (deltas) -> {
        AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object> delta = deltas.peekFirst();
        receivingDeltas.add(delta);
      });
    receivingDelta = receivingDeltas.peekFirst();
    receivingDeltas.removeFirst();
    assertEquals(foo1, receivingDelta.getValue());
    assertEquals(DeltaFIFO.DeltaType.ADDITION, receivingDelta.getKey());

    // Update operation
    deltaFIFO.update(foo1);
    cache.update(foo1);
    deltaFIFO.pop(
      (deltas) -> {
        AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object> delta = deltas.peekFirst();
        receivingDeltas.add(delta);
      });
    receivingDelta = receivingDeltas.peekFirst();
    receivingDeltas.removeFirst();
    assertEquals(foo1, receivingDelta.getValue());
    assertEquals(DeltaFIFO.DeltaType.UPDATION, receivingDelta.getKey());

    // Delete operation
    deltaFIFO.delete(foo1);
    cache.delete(foo1);
    deltaFIFO.pop(
      (deltas) -> {
        AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object> delta = deltas.peekFirst();
        receivingDeltas.add(delta);
      });
    receivingDelta = receivingDeltas.peekFirst();
    receivingDeltas.removeFirst();
    assertEquals(foo1, receivingDelta.getValue());
    assertEquals(DeltaFIFO.DeltaType.DELETION, receivingDelta.getKey());

    // Sync operation
    deltaFIFO.replace(Arrays.asList(foo1), "0");
    cache.add(foo1);
    deltaFIFO.pop(
      (deltas) -> {
        AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object> delta = deltas.peekFirst();
        receivingDeltas.add(delta);
      });
    receivingDelta = receivingDeltas.peekFirst();
    receivingDeltas.removeFirst();
    assertEquals(foo1, receivingDelta.getValue());
    assertEquals(DeltaFIFO.DeltaType.SYNCHRONIZATION, receivingDelta.getKey());
  }

  @Test
  void testDeduplication() {
    Pod foo1 = new PodBuilder().withNewMetadata().withName("foo1").withNamespace("default").endMetadata().build();
    Cache<Pod> cache = new Cache<>();
    DeltaFIFO<Pod> deltaFIFO = new DeltaFIFO<>(Cache::deletionHandlingMetaNamespaceKeyFunc, cache);
    Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>> deltas;

    // Add-delete deduplication
    deltaFIFO.add(foo1);
    deltaFIFO.delete(foo1);
    deltas = deltaFIFO.getItems().get(Cache.deletionHandlingMetaNamespaceKeyFunc(foo1));
    assertEquals(DeltaFIFO.DeltaType.DELETION, deltas.peekLast().getKey());
    assertEquals(foo1, deltas.peekLast().getValue());
    assertEquals(DeltaFIFO.DeltaType.ADDITION, deltas.peekFirst().getKey());
    assertEquals(foo1, deltas.peekFirst().getValue());
    assertEquals(2, deltas.size());
    deltaFIFO.getItems().remove(Cache.deletionHandlingMetaNamespaceKeyFunc(foo1));

    // Add-delete-delete deduplication
    deltaFIFO.add(foo1);
    deltaFIFO.delete(foo1);
    deltaFIFO.delete(foo1);
    deltas = deltaFIFO.getItems().get(Cache.deletionHandlingMetaNamespaceKeyFunc(foo1));
    assertEquals(foo1, deltas.peekLast().getValue());
    assertEquals(DeltaFIFO.DeltaType.ADDITION, deltas.peekFirst().getKey());
    assertEquals(foo1, deltas.peekFirst().getValue());
    assertEquals(2, deltas.size());
    deltaFIFO.getItems().remove(Cache.deletionHandlingMetaNamespaceKeyFunc(foo1));
  }

  @Test
  void testResync() {
    Pod foo1 = new PodBuilder().withNewMetadata().withName("foo1").withNamespace("default").endMetadata().build();
    Cache<Pod> cache = new Cache<>();
    DeltaFIFO<Pod> deltaFIFO = new DeltaFIFO<>(Cache::deletionHandlingMetaNamespaceKeyFunc, cache);

    // sync after addition
    cache.add(foo1);
    deltaFIFO.resync();

    Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>> deltas = deltaFIFO.getItems().get(Cache.deletionHandlingMetaNamespaceKeyFunc(foo1));
    assertEquals(1, deltas.size());
    assertEquals(foo1, deltas.peekLast().getValue());
    assertEquals(DeltaFIFO.DeltaType.SYNCHRONIZATION, deltas.peekLast().getKey());
  }

  @Test
  void testReplaceWithDeleteDeltaIn() throws InterruptedException {
    Pod oldPod = new PodBuilder().withNewMetadata().withNamespace("default").withName("foo1").endMetadata().build();
    Pod newPod = new PodBuilder().withNewMetadata().withNamespace("default").withName("foo2").endMetadata().build();

    Cache<Pod> mockCache = mock(Cache.class);
    doReturn(oldPod).when(mockCache).getByKey(Cache.deletionHandlingMetaNamespaceKeyFunc(oldPod));
    DeltaFIFO<Pod> deltaFIFO =
      new DeltaFIFO<>(Cache::deletionHandlingMetaNamespaceKeyFunc, mockCache);

    deltaFIFO.delete(oldPod);
    deltaFIFO.replace(Collections.singletonList(newPod), "0");

    deltaFIFO.pop(
      (deltas) -> {
        assertEquals(DeltaFIFO.DeltaType.DELETION, deltas.getFirst().getKey());
        assertEquals(oldPod, deltas.getFirst().getValue());
      });

    deltaFIFO.pop(
      (deltas) -> {
        assertEquals(DeltaFIFO.DeltaType.SYNCHRONIZATION, deltas.getFirst().getKey());
        assertEquals(newPod, deltas.getFirst().getValue());
      });
  }
}
