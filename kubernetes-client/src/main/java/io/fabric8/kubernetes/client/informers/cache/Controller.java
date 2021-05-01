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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import io.fabric8.kubernetes.client.informers.ResyncRunnable;
import io.fabric8.kubernetes.client.informers.SharedInformerEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Controller is a generic controller framework.
 *
 * This is taken from https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/cache/Controller.java
 * which has been ported from official go client: https://github.com/kubernetes/client-go/blob/master/tools/cache/controller.go
 */
public class Controller<T extends HasMetadata, L extends KubernetesResourceList<T>> {
  private static final Logger log = LoggerFactory.getLogger(Controller.class);

  /**
   * resync fifo internals in millis
   */
  private final long fullResyncPeriod;

  private final Store<T> store;

  private final ListerWatcher<T, L> listerWatcher;

  private Reflector<T, L> reflector;

  private final Supplier<Boolean> resyncFunc;

  private final ScheduledExecutorService resyncExecutor;

  private ScheduledFuture resyncFuture;

  private final OperationContext operationContext;

  private final ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners;

  private final Class<T> apiTypeClass;
  
  Controller(Class<T> apiTypeClass, Store<T> store, ListerWatcher<T, L> listerWatcher, Supplier<Boolean> resyncFunc, long fullResyncPeriod, OperationContext context, ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners, ScheduledExecutorService resyncExecutor) {
    this.store = store;
    this.listerWatcher = listerWatcher;
    this.apiTypeClass = apiTypeClass;
    this.resyncFunc = resyncFunc;
    if (fullResyncPeriod < 0) {
      throw new IllegalArgumentException("Invalid resync period provided, It should be a non-negative value");
    }
    this.fullResyncPeriod = fullResyncPeriod;
    this.operationContext = context;
    this.eventListeners = eventListeners;

    this.reflector = new Reflector<>(apiTypeClass, listerWatcher, store, operationContext);
    this.resyncExecutor = resyncExecutor;
  }

  public Controller(Class<T> apiTypeClass, Store<T> store, ListerWatcher<T, L> listerWatcher, Supplier<Boolean> resyncFunc, long fullResyncPeriod, OperationContext context, ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners) {
      this(apiTypeClass, store, listerWatcher, resyncFunc, fullResyncPeriod, context, eventListeners, Executors.newSingleThreadScheduledExecutor());
  }

  public void run() {
    log.info("informer#Controller: ready to run resync and reflector runnable");

    scheduleResync();
    
    try {
      reflector.listAndWatch();
    } catch (Exception exception) {
      log.warn("Reflector list-watching job exiting because the thread-pool is shutting down", exception);
      this.eventListeners.forEach(listener -> listener.onException(exception));
    }
  }

  void scheduleResync() {
    // Start the resync runnable
    if (fullResyncPeriod > 0) {
      ResyncRunnable resyncRunnable = new ResyncRunnable(store, resyncFunc);
      resyncFuture = resyncExecutor.scheduleWithFixedDelay(resyncRunnable, fullResyncPeriod, fullResyncPeriod, TimeUnit.MILLISECONDS);
    } else {
      log.info("informer#Controller: resync skipped due to 0 full resync period");
    }
  }

  /**
   * Stops the resync thread pool first, then stops the reflector.
   */
  public void stop() {
    synchronized (this) {
      reflector.stop();
      if (resyncFuture != null) {
        resyncFuture.cancel(true);
      }
      resyncExecutor.shutdown();
    }
  }

  /**
   * Returns true if the queue has been resynced
   * @return boolean value about queue sync status
   */
  public boolean hasSynced() {
    return this.store.hasSynced();
  }

  /**
   * Returns the latest resource version watched by controller.
   * @return latest resource version
   */
  public String lastSyncResourceVersion() {
    return reflector.getLastSyncResourceVersion();
  }

  Reflector<T, L> getReflector() {
    return reflector;
  }

  ScheduledExecutorService getResyncExecutor() {
    return this.resyncExecutor;
  }
  
  public boolean isRunning() {
    return this.reflector.isRunning();
  }
  
  public long getFullResyncPeriod() {
    return fullResyncPeriod;
  }
}
