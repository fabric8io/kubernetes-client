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

import java.util.AbstractMap;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
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

  /**
   * Queue stores deltas produced by reflector.
   */
  private final DeltaFIFO<T> queue;

  private final ListerWatcher<T, L> listerWatcher;

  private Reflector<T, L> reflector;

  private final Supplier<Boolean> resyncFunc;

  private final Consumer<Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>>> processFunc;

  private final ScheduledExecutorService reflectExecutor;

  private final ScheduledExecutorService resyncExecutor;

  private ScheduledFuture resyncFuture;

  private final OperationContext operationContext;

  private final ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners;

  private final Class<T> apiTypeClass;

  public Controller(Class<T> apiTypeClass, DeltaFIFO<T> queue, ListerWatcher<T, L> listerWatcher, Consumer<Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>>> processFunc, Supplier<Boolean> resyncFunc, long fullResyncPeriod, OperationContext context, ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners) {
    this.queue = queue;
    this.listerWatcher = listerWatcher;
    this.apiTypeClass = apiTypeClass;
    this.processFunc = processFunc;
    this.resyncFunc = resyncFunc;
    if (fullResyncPeriod < 0) {
      throw new IllegalArgumentException("Invalid resync period provided, It should be a non-negative value");
    }
    this.fullResyncPeriod = fullResyncPeriod;
    this.operationContext = context;
    this.eventListeners = eventListeners;

    // Starts one daemon thread for reflector
    this.reflectExecutor = Executors.newSingleThreadScheduledExecutor();

    // Starts one daemon thread for resync
    this.resyncExecutor = Executors.newSingleThreadScheduledExecutor();
    initReflector();
  }

  public void run() {
    log.info("informer#Controller: ready to run resync and reflector runnable");

    // Start the resync runnable
    if (fullResyncPeriod > 0) {
      ResyncRunnable resyncRunnable = new ResyncRunnable(queue, resyncFunc);
      resyncFuture = resyncExecutor.scheduleAtFixedRate(resyncRunnable, fullResyncPeriod, fullResyncPeriod, TimeUnit.MILLISECONDS);
    } else {
      log.info("informer#Controller: resync skipped due to 0 full resync period");
    }

    try {
      reflector.listAndWatch();

      // Start the process loop
      this.processLoop();
    } catch (Exception exception) {
      log.warn("Reflector list-watching job exiting because the thread-pool is shutting down", exception);
      this.eventListeners.forEach(listener -> listener.onException(exception));
    }
  }

  /**
   * Stops the resync thread pool first, then stops the reflector.
   */
  public void stop() {
    synchronized (this) {
      reflector.stop();
      reflectExecutor.shutdown();
      resyncFuture.cancel(true);
      resyncExecutor.shutdown();
    }
  }

  /**
   * Returns true if the queue has been resynced
   * @return boolean value about queue sync status
   */
  public boolean hasSynced() {
    return this.queue.hasSynced();
  }

  /**
   * Returns the latest resource version watched by controller.
   * @return latest resource version
   */
  public String lastSyncResourceVersion() {
    if (reflector == null) {
      return "";
    }
    return reflector.getLastSyncResourceVersion();
  }

  Reflector<T, L> getReflector() {
    return reflector;
  }

  /**
   * drains the work queue.
   */
  private void processLoop() throws Exception {
    while (!Thread.currentThread().isInterrupted()) {
      try {
        this.queue.pop(this.processFunc);
      } catch (InterruptedException t) {
        log.warn("DefaultController#processLoop got interrupted {}", t.getMessage(), t);
        Thread.currentThread().interrupt();
        return;
      } catch (Exception e) {
        log.error("DefaultController#processLoop recovered from crashing {} ", e.getMessage(), e);
        throw e;
      }
    }
  }

  private void initReflector() {
      reflector = new Reflector<>(apiTypeClass, listerWatcher, queue, operationContext, fullResyncPeriod);
  }
}
