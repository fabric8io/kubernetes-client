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

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Maintains a single thread daemon scheduler, which will terminate the thread
 * when not in use.
 * 
 * <br>
 * It is not intended for long-running tasks,
 * but it does not assume the task can be handed off to the common pool
 * 
 * <br>
 * This is very similar to the CompletableFuture.Delayer, but provides a scheduler method
 */
public class CachedSingleThreadScheduler {

  public static final long DEFAULT_TTL_MILLIS = TimeUnit.SECONDS.toMillis(10);

  private final long ttlMillis;
  private ScheduledThreadPoolExecutor executor;

  public CachedSingleThreadScheduler() {
    this(DEFAULT_TTL_MILLIS);
  }

  public CachedSingleThreadScheduler(long ttlMillis) {
    this.ttlMillis = ttlMillis;
  }

  public synchronized ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
      long initialDelay,
      long delay,
      TimeUnit unit) {
    startExecutor();
    return executor.scheduleWithFixedDelay(command, initialDelay, delay, unit);
  }

  public synchronized ScheduledFuture<?> schedule(Runnable command,
      long delay,
      TimeUnit unit) {
    startExecutor();
    return executor.schedule(command, delay, unit);
  }

  private void startExecutor() {
    if (executor == null) {
      // start the executor and add a ttl task
      executor = new ScheduledThreadPoolExecutor(1, Utils.daemonThreadFactory(this));
      executor.setRemoveOnCancelPolicy(true);
      executor.scheduleWithFixedDelay(this::shutdownCheck, ttlMillis, ttlMillis, TimeUnit.MILLISECONDS);
    }
  }

  /**
   * if the queue is empty since we're locked that means there's nothing pending.
   * since there is only a single thread, that means this running task is holding
   * it, so we can shut ourselves down
   */
  private synchronized void shutdownCheck() {
    if (executor.getQueue().isEmpty()) {
      executor.shutdownNow();
      executor = null;
    }
  }

  synchronized boolean hasExecutor() {
    return executor != null;
  }

}
