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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * SharedProcessor class manages all the registered ProcessListener and distributes
 * notifications.
 *
 * This has been taken from official-client: https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/cache/SharedProcessor.java
 * 
 * <br>Modified to simplify threading and synching
 */
public class SharedProcessor<T> {
  private ReadWriteLock lock = new ReentrantReadWriteLock();

  private List<ProcessorListener<T>> listeners;
  private List<ProcessorListener<T>> syncingListeners;
  private final Executor executor;
  
  public SharedProcessor() {
    this(Runnable::run);
  }

  public SharedProcessor(Executor executor) {
    this.listeners = new ArrayList<>();
    this.syncingListeners = new ArrayList<>();
    this.executor = executor;
  }

  /**
   * Adds the specific processorListener
   *
   * @param processorListener specific processor listener
   */
  public void addListener(final ProcessorListener<T> processorListener, boolean synching) {
    lock.writeLock().lock();
    try {
      this.listeners.add(processorListener);
      if (synching) {
        this.syncingListeners.add(processorListener);
      }
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

  public void stop() {
    lock.writeLock().lock();
    try {
      syncingListeners = null;
      listeners = null;
    } finally {
      lock.writeLock().unlock();
    }
  }

}
