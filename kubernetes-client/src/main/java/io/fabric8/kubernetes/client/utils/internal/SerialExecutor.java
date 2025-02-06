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
package io.fabric8.kubernetes.client.utils.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;

/**
 * See {@link Executor} docs
 *
 * <br>
 * Effectively creates a derived single thread executor, runnable tasks are executed in the order they are added.
 * This is a replacement for Executors.newSingleThreadExecutor() that uses threads in a non-dedicated way
 * <br>
 * Added shutdown support
 */
public class SerialExecutor implements Executor {

  private static final Logger log = LoggerFactory.getLogger(SerialExecutor.class);

  final Queue<Runnable> tasks = new LinkedBlockingDeque<>();
  final Executor executor;
  Runnable active;
  private volatile boolean shutdown;
  private Thread thread;
  private final Object threadLock = new Object();

  public SerialExecutor(Executor executor) {
    this.executor = executor;
  }

  /**
   * Executes the given command at some time in the future. Unlike a normal {@link Executor}, it will
   * not throw a {@link RejectedExecutionException}
   */
  @Override
  public synchronized void execute(final Runnable r) {
    if (shutdown) {
      log.debug("Task submitted after the executor was shutdown");
    }
    tasks.offer(() -> {
      try {
        if (shutdown) {
          return;
        }
        synchronized (threadLock) {
          thread = Thread.currentThread();
        }
        r.run();
      } catch (Throwable t) {
        thread.getUncaughtExceptionHandler().uncaughtException(thread, t);
      } finally {
        synchronized (threadLock) {
          thread = null;
        }
        Thread.interrupted();
        scheduleNext();
      }
    });
    if (active == null) {
      scheduleNext();
    }
  }

  protected synchronized void scheduleNext() {
    if ((active = tasks.poll()) != null) {
      try {
        executor.execute(active);
      } catch (RejectedExecutionException e) {
        log.debug("Underlying executor rejected execution", e);
      }
    }
  }

  /**
   * Shutdown the executor without executing any more tasks.
   * <p>
   * The the current task will be interrupting if it is not the thread that initiated the shutdown.
   */
  public void shutdownNow() {
    this.shutdown = true;
    tasks.clear();
    synchronized (threadLock) {
      if (thread != null && thread != Thread.currentThread()) {
        thread.interrupt();
      }
    }
  }

  public boolean isShutdown() {
    return shutdown;
  }

}
