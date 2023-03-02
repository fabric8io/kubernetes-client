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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.informers.ExceptionHandler;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.cache.Indexer;
import io.fabric8.kubernetes.client.informers.cache.ItemStore;
import io.fabric8.kubernetes.client.informers.cache.Store;
import io.fabric8.kubernetes.client.informers.impl.cache.CacheImpl;
import io.fabric8.kubernetes.client.informers.impl.cache.ProcessorStore;
import io.fabric8.kubernetes.client.informers.impl.cache.Reflector;
import io.fabric8.kubernetes.client.informers.impl.cache.SharedProcessor;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.stream.Stream;

public class DefaultSharedIndexInformer<T extends HasMetadata, L extends KubernetesResourceList<T>>
    implements SharedIndexInformer<T> {
  private static final Logger log = LoggerFactory.getLogger(DefaultSharedIndexInformer.class);

  private static final long MINIMUM_RESYNC_PERIOD_MILLIS = 1000L;

  // resyncCheckPeriod is how often we want the reflector's resync timer to fire so it can
  // call shouldResync to check if any of our listeners need a resync.
  private long resyncCheckPeriodMillis;

  // defaultEventHandlerResyncPeriod is the default resync period for any handlers added via
  // AddEventHandler(i.e they don't specify one and just want to use the shared informer's default
  // value).
  private final long defaultEventHandlerResyncPeriod;

  private final Reflector<T, L> reflector;
  private final Class<T> apiTypeClass;
  private final ProcessorStore<T> processorStore;
  private final CacheImpl<T> indexer = new CacheImpl<>();
  private final SharedProcessor<T> processor;
  private final Executor informerExecutor;
  private final String description;

  private final AtomicBoolean started = new AtomicBoolean();
  private volatile boolean stopped = false;

  private Future<?> resyncFuture;

  private Stream<T> initialState;

  public DefaultSharedIndexInformer(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, long resyncPeriod,
      Executor informerExecutor) {
    if (resyncPeriod < 0) {
      throw new IllegalArgumentException("Invalid resync period provided, It should be a non-negative value");
    }
    this.resyncCheckPeriodMillis = resyncPeriod;
    this.defaultEventHandlerResyncPeriod = resyncPeriod;
    this.apiTypeClass = apiTypeClass;
    this.description = listerWatcher.getApiEndpointPath();

    this.informerExecutor = informerExecutor;
    // reuse the informer executor, but ensure serial processing
    this.processor = new SharedProcessor<>(informerExecutor, description);

    processorStore = new ProcessorStore<>(this.indexer, this.processor);
    this.reflector = new Reflector<>(listerWatcher, processorStore);
  }

  /**
   * add event callback
   *
   * @param handler event handler
   */
  @Override
  public DefaultSharedIndexInformer<T, L> addEventHandler(ResourceEventHandler<? super T> handler) {
    addEventHandlerWithResyncPeriod(handler, defaultEventHandlerResyncPeriod);
    return this;
  }

  @Override
  public SharedIndexInformer<T> addEventHandlerWithResyncPeriod(ResourceEventHandler<? super T> handler,
      long resyncPeriodMillis) {
    if (stopped) {
      log.info("DefaultSharedIndexInformer#Handler was not added to {} because it has stopped already", this);
      return this;
    }

    if (resyncPeriodMillis > 0) {
      if (resyncPeriodMillis < MINIMUM_RESYNC_PERIOD_MILLIS) {
        log.warn("DefaultSharedIndexInformer#resyncPeriod {} is too small for {}. Changing it to minimal allowed value of {}",
            resyncPeriodMillis, this, MINIMUM_RESYNC_PERIOD_MILLIS);
        resyncPeriodMillis = MINIMUM_RESYNC_PERIOD_MILLIS;
      }

      if (resyncPeriodMillis < this.resyncCheckPeriodMillis) {
        if (started.get()) {
          log.warn(
              "DefaultSharedIndexInformer#resyncPeriod {} is smaller than resyncCheckPeriod {} and the {} informer has already started. Changing it to {}",
              resyncPeriodMillis, resyncCheckPeriodMillis, this, resyncCheckPeriodMillis);
          resyncPeriodMillis = resyncCheckPeriodMillis;
        } else {
          // if the event handler's resyncPeriod is smaller than the current resyncCheckPeriod
          // update resyncCheckPeriod to match resyncPeriod and adjust the resync periods of all
          // the listeners accordingly.
          this.resyncCheckPeriodMillis = resyncPeriodMillis;
        }
      }
    }

    this.processor.addProcessorListener(handler,
        determineResyncPeriod(resyncPeriodMillis, this.resyncCheckPeriodMillis), this.indexer::list);

    return this;
  }

  @Override
  public String lastSyncResourceVersion() {
    return this.reflector.getLastSyncResourceVersion();
  }

  @Override
  public CompletableFuture<Void> start() {
    if (stopped) {
      throw new IllegalStateException("Cannot restart a stopped informer");
    }
    synchronized (this) {
      if (!started.compareAndSet(false, true)) {
        return reflector.getStartFuture();
      }

      if (initialState != null) {
        initialState.forEach(indexer::put);
        reflector.usingInitialState();
      }
    }

    log.debug("Ready to run resync and reflector for {} with resync {}", this, resyncCheckPeriodMillis);

    scheduleResync(processor::shouldResync);

    return reflector.start();
  }

  @Override
  public SharedIndexInformer<T> run() {
    Utils.waitUntilReadyOrFail(start(), -1, TimeUnit.MILLISECONDS);
    return this;
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
  public SharedIndexInformer<T> addIndexers(Map<String, Function<T, List<String>>> indexers) {
    indexer.addIndexers(indexers);
    return this;
  }

  @Override
  public Indexer<T> getIndexer() {
    return this.indexer;
  }

  @Override
  public Store<T> getStore() {
    return this.indexer;
  }

  private long determineResyncPeriod(long desired, long check) {
    if (desired == 0) {
      return desired;
    }

    if (check == 0) {
      return 0;
    }
    return Math.max(desired, check);
  }

  @Override
  public boolean isRunning() {
    return !stopped && started.get() && !reflector.isStopped();
  }

  @Override
  public boolean isWatching() {
    return reflector.isWatching();
  }

  synchronized void scheduleResync(BooleanSupplier resyncFunc) {
    // schedule the resync runnable
    if (resyncCheckPeriodMillis > 0) {
      resyncFuture = Utils.scheduleAtFixedRate(informerExecutor, () -> {
        if (log.isDebugEnabled()) {
          log.debug("Checking for resync at interval for {}", this);
        }
        if (resyncFunc.getAsBoolean()) {
          log.debug("Resync running for {}", this);
          processorStore.resync();
        }
      }, resyncCheckPeriodMillis,
          resyncCheckPeriodMillis, TimeUnit.MILLISECONDS);
    } else {
      log.debug("Resync skipped due to 0 full resync period for {}", this);
    }
  }

  public long getFullResyncPeriod() {
    return resyncCheckPeriodMillis;
  }

  Future<?> getResyncFuture() {
    return resyncFuture;
  }

  @Override
  public Class<T> getApiTypeClass() {
    return apiTypeClass;
  }

  @Override
  public SharedIndexInformer<T> removeIndexer(String name) {
    this.indexer.removeIndexer(name);
    return this;
  }

  @Override
  public synchronized SharedIndexInformer<T> initialState(Stream<T> items) {
    if (started.get()) {
      throw new KubernetesClientException("Informer cannot be running when initial state is added");
    }
    this.initialState = items;
    return this;
  }

  @Override
  public synchronized SharedIndexInformer<T> itemStore(ItemStore<T> itemStore) {
    if (started.get()) {
      throw new KubernetesClientException("Informer cannot be running when setting item store");
    }
    this.indexer.setItemStore(itemStore);
    return this;
  }

  @Override
  public String toString() {
    return this.description;
  }

  @Override
  public CompletableFuture<Void> stopped() {
    return this.reflector.getStopFuture();
  }

  @Override
  public synchronized DefaultSharedIndexInformer<T, L> exceptionHandler(ExceptionHandler handler) {
    if (started.get()) {
      throw new KubernetesClientException("Informer cannot be running when handler is set");
    }
    this.reflector.setExceptionHandler(handler);
    return this;
  }

}
