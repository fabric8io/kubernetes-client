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
package io.fabric8.kubernetes.client.informers.impl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedInformerEventListener;
import io.fabric8.kubernetes.client.informers.cache.Cache;
import io.fabric8.kubernetes.client.informers.cache.Controller;
import io.fabric8.kubernetes.client.informers.cache.Indexer;
import io.fabric8.kubernetes.client.informers.cache.ProcessorListener;
import io.fabric8.kubernetes.client.informers.cache.ProcessorStore;
import io.fabric8.kubernetes.client.informers.cache.SharedProcessor;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;

public class DefaultSharedIndexInformer<T extends HasMetadata, L extends KubernetesResourceList<T>> implements SharedIndexInformer<T> {
  private static final Logger log = LoggerFactory.getLogger(DefaultSharedIndexInformer.class);

  private static final long MINIMUM_RESYNC_PERIOD_MILLIS = 1000L;

  // resyncCheckPeriod is how often we want the reflector's resync timer to fire so it can
  // call shouldResync to check if any of our listeners need a resync.
  private long resyncCheckPeriodMillis;

  // defaultEventHandlerResyncPeriod is the default resync period for any handlers added via
  // AddEventHandler(i.e they don't specify one and just want to use the shared informer's default
  // value).
  private long defaultEventHandlerResyncPeriod;

  private Cache<T> indexer;

  private SharedProcessor<T> processor;

  private Controller<T, L> controller;

  private Thread controllerThread;

  private volatile boolean started = false;
  private volatile boolean stopped = false;

  public DefaultSharedIndexInformer(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, long resyncPeriod, OperationContext context, ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners) {
    this.resyncCheckPeriodMillis = resyncPeriod;
    this.defaultEventHandlerResyncPeriod = resyncPeriod;

    this.processor = new SharedProcessor<>();
    this.indexer = new Cache<>();
    this.indexer.setIsRunning(this::isRunning);
    
    ProcessorStore<T> processorStore = new ProcessorStore<>(this.indexer, this.processor);

    this.controller = new Controller<>(apiTypeClass, processorStore, listerWatcher, processor::shouldResync, resyncCheckPeriodMillis, context, eventListeners);
    controllerThread = new Thread(controller::run, "informer-controller-" + apiTypeClass.getSimpleName());
  }

  /**
   * add event callback
   *
   * @param handler event handler
   */
  @Override
  public void addEventHandler(ResourceEventHandler<T> handler) {
    addEventHandlerWithResyncPeriod(handler, defaultEventHandlerResyncPeriod);
  }

  @Override
  public void addEventHandlerWithResyncPeriod(ResourceEventHandler<T> handler, long resyncPeriodMillis) {
    if (stopped) {
      log.info("DefaultSharedIndexInformer#Handler was not added to shared informer because it has stopped already");
      return;
    }

    if (resyncPeriodMillis > 0) {
      if (resyncPeriodMillis < MINIMUM_RESYNC_PERIOD_MILLIS) {
        log.warn("DefaultSharedIndexInformer#resyncPeriod {} is too small. Changing it to minimal allowed value of {}", resyncPeriodMillis, MINIMUM_RESYNC_PERIOD_MILLIS);
        resyncPeriodMillis = MINIMUM_RESYNC_PERIOD_MILLIS;
      }

      if (resyncPeriodMillis < this.resyncCheckPeriodMillis) {
        if (started) {
          log.warn("DefaultSharedIndexInformer#resyncPeriod {} is smaller than resyncCheckPeriod {} and the informer has already started. Changing it to {}", resyncPeriodMillis, resyncCheckPeriodMillis);
          resyncPeriodMillis = resyncCheckPeriodMillis;
        } else {
          // if the event handler's resyncPeriod is smaller than the current resyncCheckPeriod
          // update resyncCheckPeriod to match resyncPeriod and adjust the resync periods of all
          // the listeners accordingly.
          this.resyncCheckPeriodMillis = resyncPeriodMillis;
        }
      }
    }

    ProcessorListener<T> listener = new ProcessorListener(handler, determineResyncPeriod(resyncPeriodMillis, this.resyncCheckPeriodMillis));
    if (!started) {
      this.processor.addListener(listener);
      return;
    }

    this.processor.addAndStartListener(listener);
    List<T> objectList = this.indexer.list();
    for (Object item : objectList) {
      listener.add(new ProcessorListener.AddNotification(item));
    }
  }

  @Override
  public String lastSyncResourceVersion() {
    return this.controller.lastSyncResourceVersion();
  }

  @Override
  public void run() {
    if (stopped) {
        throw new IllegalStateException("Cannot restart a stopped informer");
    }
    if (started) {
      return;
    }

    started = true;

    this.processor.run();
    controllerThread.start();
  }

  @Override
  public void stop() {
    if (!started || stopped) {
      return;
    }

    stopped = true;
    controller.stop();
    controllerThread.interrupt();

    processor.stop();
  }

  @Override
  public boolean hasSynced() {
    return controller != null && this.controller.hasSynced();
  }

  @Override
  public void addIndexers(Map<String, Function<T, List<String>>> indexers) {
    indexer.addIndexers(indexers);
  }


  @Override
  public Indexer getIndexer() {
    return this.indexer;
  }

  private long determineResyncPeriod(long desired, long check) {
    if (desired == 0) {
      return desired;
    }

    if (check == 0) {
      return 0;
    }
    return desired < check ? check : desired;
  }

  @Override
  public boolean isRunning() {
    return !stopped && started && controller.isRunning(); 
  }
}
