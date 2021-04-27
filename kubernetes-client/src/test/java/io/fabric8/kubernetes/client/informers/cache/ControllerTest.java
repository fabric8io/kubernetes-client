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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import io.fabric8.kubernetes.client.informers.SharedInformerEventListener;

class ControllerTest {
  private DeltaFIFO<Pod> deltaFIFO = Mockito.mock(DeltaFIFO.class, Mockito.RETURNS_DEEP_STUBS);
  private abstract class AbstractPodListerWatcher implements ListerWatcher<Pod, PodList> {};

  private ListerWatcher<Pod, PodList> listerWatcher = Mockito.mock(AbstractPodListerWatcher.class, Mockito.RETURNS_DEEP_STUBS);
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

  @Test
  @DisplayName("Controller initialized with resync period should have synced")
  void testControllerHasSync() throws InterruptedException {
    // Given + When
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { }, () -> true,
      10L, operationContext, eventListeners);
    Thread controllerThread = newControllerThread(controller);
    controllerThread.start();
    // Then
    ScheduledExecutorService resyncExecutor = controller.getResyncExecutor();
    assertNotNull(resyncExecutor);
    assertThat(controller.hasSynced()).isFalse();
    assertThat(controller.lastSyncResourceVersion()).isNull();
  }

  @Test
  @DisplayName("Controller with interrupted thread should not shutdown resyncExecutor")
  void testControllerRunWithInterruptedThread() throws InterruptedException {
    // Given + When
    // used to be able to interrupt the thread in the lambda
    ThreadWrapper controllerThreadWrapper = new ThreadWrapper(); 
    long fullResyncPeriod = 1L;
    int numberOfResyncs = 1;
    final CountDownLatch countDown = new CountDownLatch(numberOfResyncs);
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> {},
      () -> {
          controllerThreadWrapper.interrupt();
        return true;
      },
      fullResyncPeriod, operationContext, eventListeners);
    Thread controllerThread = newControllerThread(controller);
    controllerThreadWrapper.thread = controllerThread; // put the thread in the wrapper, so the lamba can interrupt it
    controllerThread.start();
    countDown.await(500, TimeUnit.MILLISECONDS); // a too short value does not allow the processLoop to start.
    // Then
    ScheduledExecutorService resyncExecutor = controller.getResyncExecutor();
    assertNotNull(resyncExecutor);
    assertThat(resyncExecutor.isShutdown()).isFalse();
  }

  @Test
  @DisplayName("Controller initialized with resync period should initialize resyncExecutor")
  void testControllerRunWithResyncPeriodGreaterThanZero() throws InterruptedException {
    // Given + When
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> true,
      1L, operationContext, eventListeners);
    Thread controllerThread = newControllerThread(controller);
    controllerThread.start();
    controller.stop();
    // Then
    ScheduledExecutorService resyncExecutor = controller.getResyncExecutor();
    assertNotNull(resyncExecutor);
    assertThat(resyncExecutor.isShutdown()).isTrue();
  }

  @Test
  @DisplayName("Controller with resync function throwing exception")
  void testControllerRunsReyncFunctionThrowingException() throws InterruptedException {
    // Given + When
    long fullResyncPeriod = 10L;
    int numberOfResyncs = 10;
    final CountDownLatch countDown = new CountDownLatch(numberOfResyncs);
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> {
        countDown.countDown();
        if( countDown.getCount() == 2 ) {
            RuntimeException exception = new RuntimeException("make it fail");
          throw exception;
        }
        return true;
      },
      fullResyncPeriod, operationContext, eventListeners);

    Executable controllerRun = newControllerRun(controller);
    assertDoesNotThrow(controllerRun);
    // We give an extra cycle to avoid clock inaccurracy interruptions
    countDown.await(( numberOfResyncs + 1 )  * fullResyncPeriod, TimeUnit.MILLISECONDS);
    controller.stop();
    // Then
    assertThat(countDown.getCount()).isLessThanOrEqualTo(2);
  }

  @Test
  @DisplayName("Controller initialized with resync period should initialize resyncExecutor")
  void testControllerRunWithResyncPeriodGreaterThanZeroAndExecutorNotShutdown() throws InterruptedException {
    // Given + When
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> true,
      1L, operationContext, eventListeners);
    Executable controllerRun = newControllerRun(controller);
    assertDoesNotThrow(controllerRun);
    ScheduledExecutorService resyncExecutor = controller.getResyncExecutor();
    // Then
    assertNotNull(resyncExecutor);
    assertThat(resyncExecutor.isShutdown()).isFalse();
  }

  @Test
  @DisplayName("Controller initialized with resync period should initialize resyncExecutor")
  void testControllerRunWithResyncPeriodGreaterThanZeroAndExecutorForcedShutdown() throws InterruptedException {
    // Given + When
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> true,
      1L, operationContext, eventListeners);
    Executable controllerRun = newControllerRun(controller);
    assertDoesNotThrow(controllerRun);
    ScheduledExecutorService resyncExecutor = controller.getResyncExecutor();
    // Then
    assertNotNull(resyncExecutor);
    resyncExecutor.shutdown();
    assertThat(resyncExecutor.isShutdown()).isTrue();
  }

  @Test
  @DisplayName("Controller initialized with resync period to 0 should initialize resyncExecutor")
  void testControllerRunWithResyncPeriodToZero() throws InterruptedException {
    // Given + When
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> true,
      0L, operationContext, eventListeners);
    Thread controllerThread = newControllerThread(controller);
    controllerThread.start();
    controller.stop();
    // Then
    ScheduledExecutorService resyncExecutor = controller.getResyncExecutor();
    assertNotNull(resyncExecutor);
    assertThat(resyncExecutor.isShutdown()).isTrue();
    assertThat(resyncExecutor.isTerminated()).isTrue();
  }

  @Test
  @DisplayName("Controller initialized with resync period should run, initialize resyncExecutor and resync at least a given number of times")
  void testControllerRunsReyncFunctionExpectedNumberOfTime() throws InterruptedException {
    // Given + When
    long fullResyncPeriod = 10L;
    int numberOfResyncs = 100;
    final CountDownLatch countDown = new CountDownLatch(numberOfResyncs);
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> {countDown.countDown(); return true;},
      fullResyncPeriod, operationContext, eventListeners);

    Executable controllerRun = newControllerRun(controller);
    assertDoesNotThrow(controllerRun);
    // We give an extra cycle to avoid clock inaccurracy interruptions
    countDown.await(( numberOfResyncs + 1 )  * fullResyncPeriod, TimeUnit.MILLISECONDS);
    controller.stop();
    // Then
    ScheduledExecutorService resyncExecutor = controller.getResyncExecutor();
    assertNotNull(resyncExecutor);
    assertThat(resyncExecutor.isShutdown()).isTrue();
    assertThat(resyncExecutor.isTerminated()).isTrue();
    assertThat(countDown.getCount()).isLessThanOrEqualTo(1);
  }

  @Test
  @DisplayName("Controller initialized with resync period to 0 should run but never resync")
  void testControllerNeverRunsReyncFunctionWhenPeriodIsZero() throws InterruptedException {
    // Given + When
    int count = 10;
    final CountDownLatch countDown = new CountDownLatch(count);
    Controller<Pod, PodList> controller = new Controller<>(Pod.class, deltaFIFO, listerWatcher,
      simpleEntries -> { },
      () -> {countDown.countDown(); return true;},
      0, operationContext, eventListeners);
    Executable controllerRun = newControllerRun(controller);
    assertDoesNotThrow(controllerRun);
    // We give an extra cycle to avoid clock inaccurracy interruptions
    countDown.await(1000, TimeUnit.MILLISECONDS);
    controller.stop();
    // Then
    ScheduledExecutorService resyncExecutor = controller.getResyncExecutor();
    assertNotNull(resyncExecutor);
    assertThat(resyncExecutor.isShutdown()).isTrue();
    assertThat(countDown.getCount()).isEqualTo(count);
  }

  private class ThreadWrapper{
    public Thread thread;
    public void interrupt() {
      if( thread != null) {
        thread.interrupt();
      }
    }
  }

  private Executable newControllerRun(Controller<Pod, PodList> controller) {
    return new Executable() {
      @Override
      public void execute() {
        Thread controllerThread = newControllerThread(controller);
        controllerThread.start();
      }
    };
  }

  private Thread newControllerThread(Controller<Pod, PodList> controller) {
    Thread controllerThread = new Thread( new Runnable() {
      @Override
      public void run() {
        controller.run();
      }
    });
    return controllerThread;
  }
}
