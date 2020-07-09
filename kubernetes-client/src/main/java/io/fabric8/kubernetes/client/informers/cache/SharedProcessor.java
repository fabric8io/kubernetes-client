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

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * SharedProcessor class manages all the registered ProcessListener and distributes
 * notifications.
 *
 * This has been taken from official-client: https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/cache/SharedProcessor.java
 */
public class SharedProcessor<T> {
  private ReadWriteLock lock = new ReentrantReadWriteLock();

  private List<ProcessorListener<T>> listeners;
  private List<ProcessorListener<T>> syncingListeners;

  private ExecutorService executorService;

  public SharedProcessor() {
    this(Executors.newCachedThreadPool());
  }

  public SharedProcessor(ExecutorService threadPool) {
    this.listeners = new ArrayList<>();
    this.syncingListeners = new ArrayList<>();
    this.executorService = threadPool;
  }

  /**
   * First adds the specific processorListener then starts the listener
   * with executor.
   *
   * @param processorListener specific processor listener
   */
  public void addAndStartListener(final ProcessorListener<T> processorListener) {
    lock.writeLock().lock();
    try {
      addListenerLocked(processorListener);

      executorService.execute(processorListener);
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * Adds the specific processorListener, but not start it.
   *
   * @param processorListener specific processor listener
   */
  public void addListener(final ProcessorListener<T> processorListener) {
    lock.writeLock().lock();
    try {
      addListenerLocked(processorListener);
    } finally {
      lock.writeLock().unlock();
    }
  }

  private void addListenerLocked(final ProcessorListener<T> processorListener) {
    this.listeners.add(processorListener);
    this.syncingListeners.add(processorListener);
  }

  /**
   * Starts the processor listeners.
   */
  public void run() {
    lock.readLock().lock();
    try {
      if (listeners == null || listeners.isEmpty()) {
        return;
      }
      for (ProcessorListener<T> listener : listeners) {
        if (!executorService.isShutdown()) {
          executorService.submit(listener);
        }
      }
    } finally {
      lock.readLock().unlock();
    }
  }

  /**
   * Distribute the object amount listeners.
   *
   * @param obj specific obj
   * @param isSync whether in sync or not
   */
  public void distribute(ProcessorListener.Notification<T> obj, boolean isSync) {
    lock.readLock().lock();
    try {
      if (isSync) {
        for (ProcessorListener<T> listener : syncingListeners) {
          listener.add(obj);
        }
      } else {
        for (ProcessorListener<T> listener : listeners) {
          listener.add(obj);
        }
      }
    } finally {
      lock.readLock().unlock();
    }
  }

  public boolean shouldResync() {
    lock.writeLock().lock();
    boolean resyncNeeded = false;
    try {
      this.syncingListeners = new ArrayList<>();

      ZonedDateTime now = ZonedDateTime.now();
      for (ProcessorListener<T> listener : this.listeners) {
        if (listener.shouldResync(now)) {
          resyncNeeded = true;
          this.syncingListeners.add(listener);
          listener.determineNextResync(now);
        }
      }
    } finally {
      lock.writeLock().unlock();
    }
    return resyncNeeded;
  }

  public void stop() {
    lock.writeLock().lock();
    try {
      listeners = null;
    } finally {
      lock.writeLock().unlock();
    }
    executorService.shutdownNow();
  }
}
