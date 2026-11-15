/*
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
package io.fabric8.kubernetes.client.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CachedSingleThreadSchedulerTest {

  @Test
  void testAutoShutdown() throws InterruptedException {
    CachedSingleThreadScheduler scheduler = new CachedSingleThreadScheduler(50);
    assertFalse(scheduler.hasExecutor());
    CountDownLatch latch = new CountDownLatch(2);
    ScheduledFuture<?> future = scheduler.scheduleWithFixedDelay(latch::countDown, 50, 50, TimeUnit.MILLISECONDS);
    assertTrue(scheduler.hasExecutor());
    latch.await();
    assertFalse(future.isDone());
    future.cancel(true);
    await().atMost(1, TimeUnit.SECONDS).until(() -> !scheduler.hasExecutor());
    // should start again
    future = scheduler.scheduleWithFixedDelay(latch::countDown, 50, 50, TimeUnit.MILLISECONDS);
    assertTrue(scheduler.hasExecutor());
  }

  @Test
  @DisplayName("schedules tasks again after the idle shutdown fails with an Error thrown by shutdownNow()")
  void recoversWhenShutdownNowThrows() throws InterruptedException {
    AtomicInteger shutdownFailures = new AtomicInteger();
    CachedSingleThreadScheduler scheduler = new CachedSingleThreadScheduler(50) {
      @Override
      ScheduledThreadPoolExecutor createExecutor() {
        return new ScheduledThreadPoolExecutor(1, Utils.daemonThreadFactory(this)) {
          @Override
          public List<Runnable> shutdownNow() {
            // the executor is already shut down when the Error is thrown, like an
            // OutOfMemoryError raised by the allocations at the end of shutdownNow()
            List<Runnable> tasks = super.shutdownNow();
            if (shutdownFailures.getAndIncrement() == 0) {
              throw new OutOfMemoryError("simulated failure after the executor was shut down");
            }
            return tasks;
          }
        };
      }
    };
    CountDownLatch first = new CountDownLatch(1);
    scheduler.schedule(first::countDown, 1, TimeUnit.MILLISECONDS);
    assertThat(first.await(5, TimeUnit.SECONDS)).isTrue();

    await().atMost(5, TimeUnit.SECONDS).until(() -> shutdownFailures.get() > 0 && !scheduler.hasExecutor());

    CountDownLatch second = new CountDownLatch(1);
    scheduler.schedule(second::countDown, 1, TimeUnit.MILLISECONDS);
    assertThat(second.await(5, TimeUnit.SECONDS)).isTrue();
  }
}
