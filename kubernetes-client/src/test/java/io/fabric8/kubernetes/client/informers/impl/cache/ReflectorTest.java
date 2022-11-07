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
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.informers.impl.ListerWatcher;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReflectorTest {

  @Test
  void testStateFlags() {
    ListerWatcher<Pod, PodList> mock = Mockito.mock(ListerWatcher.class);
    PodList list = new PodListBuilder().withNewMetadata().withResourceVersion("1").endMetadata().build();
    Mockito.when(mock.submitList(Mockito.any())).thenReturn(CompletableFuture.completedFuture(list));

    Reflector<Pod, PodList> reflector = new Reflector<Pod, PodList>(mock, Mockito.mock(SyncableStore.class)) {
      @Override
      protected void reconnect() {
        // do nothing
      }
    };
    reflector.setExceptionHandler((b, t) -> true);

    assertFalse(reflector.isWatching());
    assertFalse(reflector.isStopped());

    // throw an exception, then watch normally
    Mockito.when(mock.submitWatch(Mockito.any(), Mockito.any()))
        .thenThrow(new KubernetesClientException("error"))
        .thenReturn(CompletableFuture.completedFuture(Mockito.mock(Watch.class)));

    CompletableFuture<Void> future = reflector.start();

    // since we're reconnecting, but have overridden reconnect, this won't be done
    assertFalse(future.isDone());

    // running but watch failed
    assertFalse(reflector.isWatching());
    assertFalse(reflector.isStopped());

    reflector.listSyncAndWatch().join();

    assertTrue(reflector.isWatching());
    assertFalse(reflector.isStopped());
    assertFalse(reflector.getStopFuture().isDone());
    assertTrue(future.isDone());
    assertTrue(!future.isCompletedExceptionally());

    reflector.stop();

    assertFalse(reflector.isWatching());
    assertTrue(reflector.isStopped());
    assertTrue(reflector.getStopFuture().isDone());
  }

  @Test
  void testNotRunningAfterStartError() {
    ListerWatcher<Pod, PodList> mock = Mockito.mock(ListerWatcher.class);
    PodList list = new PodListBuilder().withNewMetadata().withResourceVersion("1").endMetadata().build();
    Mockito.when(mock.submitList(Mockito.any())).thenReturn(CompletableFuture.completedFuture(list));

    Reflector<Pod, PodList> reflector = new Reflector<Pod, PodList>(mock, Mockito.mock(SyncableStore.class));

    // throw an exception, then watch normally
    Mockito.when(mock.submitWatch(Mockito.any(), Mockito.any()))
        .thenThrow(new KubernetesClientException("error"));

    // single start
    CompletableFuture<Void> future = reflector.start();

    assertThrows(CompletionException.class, future::join);

    assertTrue(reflector.isStopped());
  }

  @Test
  void testNonHttpGone() {
    ListerWatcher<Pod, PodList> mock = Mockito.mock(ListerWatcher.class);
    PodList list = new PodListBuilder().withNewMetadata().withResourceVersion("1").endMetadata().build();
    Mockito.when(mock.submitList(Mockito.any())).thenReturn(CompletableFuture.completedFuture(list));

    Reflector<Pod, PodList> reflector = new Reflector<>(mock, Mockito.mock(SyncableStore.class));

    Mockito.when(mock.submitWatch(Mockito.any(), Mockito.any()))
        .thenReturn(CompletableFuture.completedFuture(Mockito.mock(Watch.class)));

    reflector.start();

    assertTrue(reflector.isWatching());
    assertFalse(reflector.isStopped());

    reflector.getWatcher().onClose(new WatcherException(null));

    assertFalse(reflector.isWatching());
    assertTrue(reflector.isStopped());
  }

}
