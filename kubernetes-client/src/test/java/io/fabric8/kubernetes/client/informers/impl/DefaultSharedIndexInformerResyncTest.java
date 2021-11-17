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
package io.fabric8.kubernetes.client.informers.impl;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultSharedIndexInformerResyncTest {
  private abstract static class AbstractPodListerWatcher implements ListerWatcher<Pod, PodList> {};
  private static final Long WAIT_TIME = 500L;
  private final ListerWatcher<Pod, PodList> listerWatcher = Mockito.mock(AbstractPodListerWatcher.class, Mockito.RETURNS_DEEP_STUBS);
  DefaultSharedIndexInformer<Pod, PodList> defaultSharedIndexInformer;

  private DefaultSharedIndexInformer<Pod, PodList> createDefaultSharedIndexInformer(long resyncPeriod) {
    defaultSharedIndexInformer = new DefaultSharedIndexInformer<>(Pod.class, listerWatcher, resyncPeriod, Runnable::run);
    return defaultSharedIndexInformer;
  }
  
  @AfterEach
  void afterEach() {
    if (defaultSharedIndexInformer != null) {
      defaultSharedIndexInformer.stop();
    }
  }

  @Test
  @DisplayName("Controller initialized with resync period greater than zero should use provided resync period")
  void testControllerCreationWithResyncPeriodMoreThanZero() {
    // Given + When
    DefaultSharedIndexInformer<Pod, PodList> controller = createDefaultSharedIndexInformer(1000L);

    // Then
    assertEquals(1000L, controller.getFullResyncPeriod());
  }

  @Test
  @DisplayName("Controller initialized with resync period less than zero should throw exception")
  void testControllerCreationWithResyncPeriodLessThanZero() {
    assertThrows(IllegalArgumentException.class, () -> createDefaultSharedIndexInformer(-1));
  }

  @Test
  @DisplayName("Controller initialized with resync period 0 should use provided resync period")
  void testControllerCreationWithResyncPeriodZero() {
    // Given + When
    DefaultSharedIndexInformer<Pod, PodList> controller = createDefaultSharedIndexInformer(0);

    // Then
    assertEquals(0L, controller.getFullResyncPeriod());
  }

  @Test
  @DisplayName("Controller stop shut downs/cancels all executor services")
  void testStop() {
    // Given
    DefaultSharedIndexInformer<Pod, PodList> controller = createDefaultSharedIndexInformer(0);
    controller.run();
    // When
    controller.stop();
    // Then
    assertThat(controller.isRunning()).isFalse();
  }

  @Test
  @DisplayName("Controller initialized with resync period should initialize resyncExecutor")
  void testControllerRunWithResyncPeriodGreaterThanZero() throws InterruptedException {
    // Given + When
    DefaultSharedIndexInformer<Pod, PodList> controller = createDefaultSharedIndexInformer(1);
    controller.run();
    
    assertNotNull(controller.getResyncFuture());
    
    controller.stop();
    
    assertNull(controller.getResyncFuture());
  }

  @Test
  @DisplayName("Controller with resync function throwing exception")
  void testControllerRunsResyncFunctionThrowingException() throws InterruptedException {
    // Given + When
    long fullResyncPeriod = 10L;
    int numberOfResyncs = 10;
    final CountDownLatch countDown = new CountDownLatch(numberOfResyncs);
    DefaultSharedIndexInformer<Pod, PodList> controller = createDefaultSharedIndexInformer(fullResyncPeriod);
    controller.scheduleResync(() -> {
      countDown.countDown();
      if( countDown.getCount() == 2 ) {
        throw new RuntimeException("make it fail");
      }
      return true;
    });
    countDown.await(WAIT_TIME, TimeUnit.MILLISECONDS);
    controller.stop();
    // Then
    assertThat(countDown.getCount()).isLessThanOrEqualTo(2);
  }

  @Test
  @DisplayName("Controller initialized with resync period to 0 should not initialize resyncExecutor")
  void testControllerRunWithResyncPeriodToZero() throws InterruptedException {
    // Given + When
    DefaultSharedIndexInformer<Pod, PodList> controller = createDefaultSharedIndexInformer(0);
    controller.run();
    
    // Then
    assertNull(controller.getResyncFuture());
  }

  @Test
  @DisplayName("Controller initialized with resync period should run, initialize resyncExecutor and resync at least a given number of times")
  void testControllerRunsReyncFunctionExpectedNumberOfTime() throws InterruptedException {
    // Given + When
    long fullResyncPeriod = 10L;
    int numberOfResyncs = 10;
    final CountDownLatch countDown = new CountDownLatch(numberOfResyncs);
    DefaultSharedIndexInformer<Pod, PodList> controller = createDefaultSharedIndexInformer(fullResyncPeriod);
    controller.scheduleResync(() -> {countDown.countDown(); return true;});
    // We give an extra cycle to avoid clock inaccurracy interruptions
    countDown.await(WAIT_TIME, TimeUnit.MILLISECONDS);
    controller.stop();
    // Then
    assertNull(controller.getResyncFuture());
    assertThat(countDown.getCount()).isLessThanOrEqualTo(1);
  }

  @Test
  @DisplayName("Controller initialized with resync period to 0 should run but never resync")
  void testControllerNeverRunsReyncFunctionWhenPeriodIsZero() throws InterruptedException {
    // Given + When
    int count = 10;
    final CountDownLatch countDown = new CountDownLatch(count);
    DefaultSharedIndexInformer<Pod, PodList> controller = createDefaultSharedIndexInformer(0);
    controller.scheduleResync(() -> {countDown.countDown(); return true;});
    countDown.await(1000, TimeUnit.MILLISECONDS);
    controller.stop();
    // Then
    assertNull(controller.getResyncFuture());
    assertThat(countDown.getCount()).isEqualTo(count);
  }

}
