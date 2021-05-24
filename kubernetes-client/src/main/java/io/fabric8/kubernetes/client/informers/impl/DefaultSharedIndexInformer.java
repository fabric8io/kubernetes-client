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
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.cache.Cache;
import io.fabric8.kubernetes.client.informers.cache.Indexer;
import io.fabric8.kubernetes.client.informers.cache.ProcessorListener;
import io.fabric8.kubernetes.client.informers.cache.ProcessorStore;
import io.fabric8.kubernetes.client.informers.cache.Reflector;
import io.fabric8.kubernetes.client.informers.cache.SharedProcessor;
import io.fabric8.kubernetes.client.utils.SerialExecutor;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class DefaultSharedIndexInformer<T extends HasMetadata, L extends KubernetesResourceList<T>> implements SharedIndexInformer<T> {
  private static final Logger log = LoggerFactory.getLogger(DefaultSharedIndexInformer.class);

  private static final long MINIMUM_RESYNC_PERIOD_MILLIS = 1000L;

  // resyncCheckPeriod is how often we want the reflector's resync timer to fire so it can
  private long resyncCheckPeriodMillis;

  private final Reflector<T, L> reflector;
  private final Class<T> apiTypeClass;
  private final ProcessorStore<T> processorStore;
  private final Cache<T> indexer;
  private final SharedProcessor<T> processor;
  private final Executor informerExecutor;

  private final AtomicBoolean started = new AtomicBoolean();
  private volatile boolean stopped = false;

  private ScheduledFuture<?> resyncFuture;

  public DefaultSharedIndexInformer(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, long resyncPeriod, OperationContext context, Executor informerExecutor) {
    if (resyncPeriod < 0) {
      throw new IllegalArgumentException("Invalid resync period provided, It should be a non-negative value");
    } else if (resyncPeriod > 0 && resyncPeriod < MINIMUM_RESYNC_PERIOD_MILLIS) {
      log.warn("DefaultSharedIndexInformer#resyncPeriod {} is too small. Changing it to minimal allowed value of {}", resyncPeriod, MINIMUM_RESYNC_PERIOD_MILLIS);
      resyncPeriod = MINIMUM_RESYNC_PERIOD_MILLIS;
    }
    this.resyncCheckPeriodMillis = resyncPeriod;
    this.apiTypeClass = apiTypeClass;

    this.informerExecutor = informerExecutor;
    // reuse the informer executor, but ensure serial processing
    this.processor = new SharedProcessor<>(new SerialExecutor(informerExecutor));
    this.indexer = new Cache<>();
    this.indexer.setIsRunning(this::isRunning);

    processorStore = new ProcessorStore<>(this.indexer, this.processor);
    this.reflector = new Reflector<>(apiTypeClass, listerWatcher, processorStore, context);
  }

  /**
   * add event callback
   *
   * @param handler event handler
   */
  @Override
  public void addEventHandler(ResourceEventHandler<T> handler) {
    addEventHandlerWithResyncPeriod(handler, resyncCheckPeriodMillis);
  }

  @Override
  public void addEventHandlerWithResyncPeriod(ResourceEventHandler<T> handler, long resyncPeriodMillis) {
    if (resyncPeriodMillis != 0 && resyncPeriodMillis != this.resyncCheckPeriodMillis) {
      log.warn("The specified resyncPeriod {} was changed to match the informer resync {}", this.resyncCheckPeriodMillis);
      resyncPeriodMillis = this.resyncCheckPeriodMillis;
    }
    
    addEventHandler(handler, resyncPeriodMillis != 0);
  }
  
  @Override
  public void addEventHandlerWithoutResync(ResourceEventHandler<T> handler) {
    addEventHandler(handler, false);
  }
  
  synchronized void addEventHandler(ResourceEventHandler<T> handler, boolean resync) {
    if (stopped) {
      log.info("DefaultSharedIndexInformer#Handler was not added to shared informer because it has stopped already");
      return;
    }

    ProcessorListener<T> listener = new ProcessorListener<>(handler);
    this.processor.addListener(listener, resync);
    
    if (!started.get()) {
      return;
    }

    List<T> objectList = this.indexer.list();
    for (T item : objectList) {
      listener.add(new ProcessorListener.AddNotification<>(item));
    }
  }

  @Override
  public String lastSyncResourceVersion() {
    return this.reflector.getLastSyncResourceVersion();
  }

  @Override
  public void run() {
    if (stopped) {
        throw new IllegalStateException("Cannot restart a stopped informer");
    }
    if (!started.compareAndSet(false, true)) {
      return;
    }

    log.info("informer#Controller: ready to run resync and reflector for {} with resync {}", apiTypeClass, resyncCheckPeriodMillis);

    scheduleResync(processorStore::resync);
    
    reflector.listSyncAndWatch();
    // stop called while run is called could be ineffective, check for it afterwards
    synchronized (this) {
      if (stopped) {
        stop();
      }
    }
  }

  @Override
  public synchronized void stop() {
    stopped = true;
    reflector.stop();
    stopResync();
    processor.stop();
  }

  private synchronized void stopResync() {
    if (resyncFuture != null) {
      resyncFuture.cancel(true);
      resyncFuture = null;
    }
  }

  @Override
  public boolean hasSynced() {
    return this.processorStore.hasSynced();
  }

  @Override
  public void addIndexers(Map<String, Function<T, List<String>>> indexers) {
    indexer.addIndexers(indexers);
  }

  @Override
  public Indexer<T> getIndexer() {
    return this.indexer;
  }

  @Override
  public boolean isRunning() {
    return !stopped && started.get() && reflector.isRunning();
  }

  synchronized void scheduleResync(Runnable resyncRunnable) {
    // schedule the resync runnable
    if (resyncCheckPeriodMillis > 0) {
        resyncFuture = Utils.scheduleAtFixedRate(informerExecutor, resyncRunnable, resyncCheckPeriodMillis, resyncCheckPeriodMillis, TimeUnit.MILLISECONDS);
    } else {
      log.debug("informer#Controller: resync skipped due to 0 full resync period {}", apiTypeClass);
    }
  }

  public long getFullResyncPeriod() {
    return resyncCheckPeriodMillis;
  }
  
  void setResyncCheckPeriodMillis(long resyncCheckPeriodMillis) {
    this.resyncCheckPeriodMillis = resyncCheckPeriodMillis;
  }
  
  ScheduledFuture<?> getResyncFuture() {
    return resyncFuture;
  }

  @Override
  public Class<T> getApiTypeClass() {
    return apiTypeClass;
  }

}
