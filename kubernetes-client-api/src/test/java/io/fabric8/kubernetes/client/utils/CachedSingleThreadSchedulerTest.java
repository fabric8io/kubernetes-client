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

package io.fabric8.kubernetes.client.utils;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

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
}
