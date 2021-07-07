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

import io.fabric8.kubernetes.client.informers.ResourceEventHandler;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Supplier;

/**
 * SharedProcessor class manages all the registered ProcessListener and distributes
 * notifications.
 *
 * This has been taken from official-client: https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/cache/SharedProcessor.java
 * 
 * <br>Modified to simplify threading
 */
public class SharedProcessor<T> {
  private final ReadWriteLock lock = new ReentrantReadWriteLock();

  private final List<ProcessorListener<T>> listeners = new ArrayList<>();
  private final List<ProcessorListener<T>> syncingListeners = new ArrayList<>();
  private final Executor executor;
  
  public SharedProcessor() {
    this(Runnable::run);
  }

  public SharedProcessor(Executor executor) {
    this.executor = executor;
  }

  /**
   * Adds the specific processorListener
   *
   * @param processorListener specific processor listener
   */
  public void addListener(final ProcessorListener<T> processorListener) {
    lock.writeLock().lock();
    try {
      this.listeners.add(processorListener);
      this.syncingListeners.add(processorListener);
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * Distribute the object amount listeners.
   *
   * @param obj specific obj
   * @param isSync whether in sync or not
   */
  public void distribute(ProcessorListener.Notification<T> obj, boolean isSync) {
    // obtain the list to call outside before submitting
    lock.readLock().lock();
    List<ProcessorListener<T>> toCall;
    try {
      if (isSync) {
        toCall = new ArrayList<>(syncingListeners);
      } else {
        toCall = new ArrayList<>(listeners);
      }
    } finally {
      lock.readLock().unlock();
    }
    executor.execute(() -> {
      for (ProcessorListener<T> listener : toCall) {
        listener.add(obj);
      }
    });
  }

  public boolean shouldResync() {
    lock.writeLock().lock();
    boolean resyncNeeded = false;
    try {
      this.syncingListeners.clear();

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
      syncingListeners.clear();
      listeners.clear();
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * Adds a new listener.  When running this will pause event distribution until
   * the new listener has received an initial set of add events
   */
  public ProcessorListener<T> addProcessorListener(ResourceEventHandler<T> handler, long resyncPeriodMillis, Supplier<Collection<T>> initialItems) {
    lock.writeLock().lock();
    try {
      ProcessorListener<T> listener = new ProcessorListener<>(handler, resyncPeriodMillis);
      
      for (T item : initialItems.get()) {
        listener.add(new ProcessorListener.AddNotification<>(item));
      }
      
      addListener(listener);
      return listener;
    } finally {
      lock.writeLock().unlock();
    }
  }
}
