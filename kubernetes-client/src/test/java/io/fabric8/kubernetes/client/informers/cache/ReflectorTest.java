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
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class ReflectorTest {

  @Test
  void testStateFlags() {
    ListerWatcher<Pod, PodList> mock = Mockito.mock(ListerWatcher.class);
    PodList list = new PodListBuilder().withNewMetadata().withResourceVersion("1").endMetadata().build();
    Mockito.when(mock.list(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(list);

    Reflector<Pod, PodList> reflector =
        new Reflector<>(Pod.class, mock, Mockito.mock(SyncableStore.class), new OperationContext());

    assertFalse(reflector.isWatching());
    assertFalse(reflector.isRunning());

    // throw an exception, then watch normally
    Mockito.when(mock.watch(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
        .thenThrow(new KubernetesClientException("error"))
        .thenReturn(Mockito.mock(Watch.class));

    assertThrows(KubernetesClientException.class, () -> reflector.listSyncAndWatch());

    // running but watch failed
    assertFalse(reflector.isWatching());
    assertTrue(reflector.isRunning());

    reflector.listSyncAndWatch();

    assertTrue(reflector.isWatching());
    assertTrue(reflector.isRunning());

    reflector.stop();

    assertFalse(reflector.isWatching());
    assertFalse(reflector.isRunning());
  }

}
