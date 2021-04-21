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
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import io.fabric8.kubernetes.client.informers.SharedInformerEventListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.ConcurrentLinkedQueue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerTest {
  private DeltaFIFO<Pod> deltaFIFO = Mockito.mock(DeltaFIFO.class, Mockito.RETURNS_DEEP_STUBS);
  private ListerWatcher<Pod, PodList> listerWatcher = Mockito.mock(ListerWatcher.class, Mockito.RETURNS_DEEP_STUBS);
  private OperationContext operationContext = Mockito.mock(OperationContext.class, Mockito.RETURNS_DEEP_STUBS);
  private ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners = Mockito.mock(ConcurrentLinkedQueue.class, Mockito.RETURNS_DEEP_STUBS);

  @Test
  @DisplayName("Controller initialized with resync period greater than zero should use provided resync period")
  void testControllerCreationWithResyncPeriodMoreThanZero() {
    // Given + When
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> true,
      1000L, operationContext, eventListeners);

    // Then
    assertEquals(1000L, controller.getReflector().getResyncPeriodMillis());
  }

  @Test
  @DisplayName("Controller initialized with resync period less than zero should throw exception")
  void testControllerCreationWithResyncPeriodLessThanZero() {
    assertThrows(IllegalArgumentException.class, () -> new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> true,
      -1000L, operationContext, eventListeners));
  }

  @Test
  @DisplayName("Controller initialized with resync period 0 should use provided resync period")
  void testControllerCreationWithResyncPeriodZero() {
    // Given + When
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> true,
      0L, operationContext, eventListeners);

    // Then
    assertEquals(0L, controller.getReflector().getResyncPeriodMillis());
  }

  @Test
  @DisplayName("Controller stop shut downs/cancels all executor services")
  void testStop() {
    // Given
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> true,
      1000L, operationContext, eventListeners);

    // When
    controller.stop();

    // Then
    assertThat(controller.getReflectExecutor().isShutdown()).isTrue();
    assertThat(controller.getResyncExecutor().isShutdown()).isTrue();
  }
}
