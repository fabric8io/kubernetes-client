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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ReflectorTest {
  @Test
  @DisplayName("Given Reflector with non zero resync period should invoke executorService")
  void testScheduleResyncExecutionWithNonZeroResyncPeriod() {
    // Given
    ScheduledExecutorService executorService = Mockito.mock(ScheduledExecutorService.class, Mockito.RETURNS_DEEP_STUBS);
    Reflector<Pod, PodList> reflector = getReflectorWithResyncPeriod(1000L, executorService);

    // When
    reflector.scheduleResyncExecution();

    // Then
    verify(executorService, times(1)).scheduleWithFixedDelay(any(), eq(0L), eq(1000L), eq(TimeUnit.MILLISECONDS));
  }

  @Test
  @DisplayName("Given Reflector with zero resync Period should not Then executorService is not invoked")
  void testScheduleResyncExecutionWithZeroResyncPeriod() {
    // Given
    ScheduledExecutorService executorService = Mockito.mock(ScheduledExecutorService.class, Mockito.RETURNS_DEEP_STUBS);
    Reflector<Pod, PodList> reflector = getReflectorWithResyncPeriod(0L, executorService);

    // When
    reflector.scheduleResyncExecution();

    // Then
    verify(executorService, times(0)).scheduleWithFixedDelay(any(), eq(0L), eq(1000L), eq(TimeUnit.MILLISECONDS));
  }

  private Reflector<Pod, PodList> getReflectorWithResyncPeriod(long resyncPeriodMillis, ScheduledExecutorService executorService) {
    ListerWatcher<Pod, PodList> listerWatcher = Mockito.mock(ListerWatcher.class, Mockito.RETURNS_DEEP_STUBS);
    Store store = Mockito.mock(Store.class, Mockito.RETURNS_DEEP_STUBS);
    OperationContext operationContext = Mockito.mock(OperationContext.class, Mockito.RETURNS_DEEP_STUBS);
    Reflector<Pod, PodList> reflector = new Reflector<>(Pod.class, listerWatcher, store, operationContext, resyncPeriodMillis, executorService);
    return reflector;
  }
}
