/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import io.fabric8.kubernetes.client.informers.ResyncRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.Deque;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
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
public class Controller<T extends HasMetadata, TList extends KubernetesResourceList<T>> {
  private static final Logger log = LoggerFactory.getLogger(Controller.class);

  private static final long DEFAULT_PERIOD = 5000L;

  /**
   * Period controls the timing between one watch ending
   * and the beginning of the next one in milliseconds.
   * It's one second by default as done in go client
   */
  private static final long DEFAULT_DELAY_PERIOD = 1000L;

  /**
   * resync fifo internals in millis
   */
  private long fullResyncPeriod;

  /**
   * Queue stores deltas produced by reflector.
   */
  private DeltaFIFO<T> queue;

  private ListerWatcher<T, TList> listerWatcher;

  private ReflectorRunnable<T, TList> reflector;

  private Supplier<Boolean> resyncFunc;

  private Consumer<Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>>> processFunc;

  private ScheduledExecutorService reflectExecutor;

  private ScheduledExecutorService resyncExecutor;

  private ScheduledFuture resyncFuture;

  private OperationContext operationContext;

  private Class<T> apiTypeClass;

  private ScheduledFuture reflectorFuture;

  public Controller(Class<T> apiTypeClass, DeltaFIFO<T> queue, ListerWatcher<T, TList> listerWatcher, Consumer<Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>>> processFunc, Supplier<Boolean> resyncFunc, long fullResyncPeriod, OperationContext context) {
    this.queue = queue;
    this.listerWatcher = listerWatcher;
    this.apiTypeClass = apiTypeClass;
    this.processFunc = processFunc;
    this.resyncFunc = resyncFunc;
    this.fullResyncPeriod = fullResyncPeriod;
    this.operationContext = context;

    // Starts one daemon thread for reflector
    this.reflectExecutor = Executors.newSingleThreadScheduledExecutor();

    // Starts one daemon thread for resync
    this.resyncExecutor = Executors.newSingleThreadScheduledExecutor();
  }

  public Controller(Class<T> apiTypeClass, DeltaFIFO<T> queue, ListerWatcher<T, TList> listerWatcher, Consumer<Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>>> popProcessFunc, OperationContext context) {
    this(apiTypeClass, queue, listerWatcher, popProcessFunc, null, 0, context);
  }

  public void run() {
    log.info("informer#Controller: ready to run resync and reflector runnable");

    // Start the resync runnable
    if (fullResyncPeriod > 0) {
      ResyncRunnable resyncRunnable = new ResyncRunnable(queue, resyncFunc);
      resyncFuture = resyncExecutor.scheduleAtFixedRate(resyncRunnable::run, fullResyncPeriod, fullResyncPeriod, TimeUnit.MILLISECONDS);
    } else {
      log.info("informer#Controller: resync skipped due to 0 full resync period");
    }

    synchronized (this) {
      reflector = new ReflectorRunnable<T, TList>(apiTypeClass, listerWatcher, queue, operationContext);
      try {
        if (fullResyncPeriod > 0) {
          reflectorFuture = reflectExecutor.scheduleWithFixedDelay(reflector::run, DEFAULT_DELAY_PERIOD, fullResyncPeriod, TimeUnit.MILLISECONDS);
        } else {
          reflectorFuture = reflectExecutor.scheduleWithFixedDelay(reflector::run, DEFAULT_DELAY_PERIOD, DEFAULT_PERIOD, TimeUnit.MILLISECONDS);
        }
      } catch (RejectedExecutionException e) {
        log.warn("reflector list-watching job exiting because the thread-pool is shutting down");
        return;
      }
    }

    // Start the process loop
    this.processLoop();
  }

  /**
   * Stops the resync thread pool first, then stops the reflector.
   */
  public void stop() {
    synchronized (this) {
      if (reflectorFuture != null) {
        reflector.stop();
        reflectorFuture.cancel(true);
      }
      reflectExecutor.shutdown();
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

  /**
   * drains the work queue.
   */
  private void processLoop() {
    while (true) {
      try {
        this.queue.pop(this.processFunc);
      } catch (InterruptedException t) {
        log.error("DefaultController#processLoop got interrupted {}", t.getMessage(), t);
        return;
      } catch (Throwable t) {
        log.error("DefaultController#processLoop recovered from crashing {} ", t.getMessage(), t);
      }
    }
  }

}
