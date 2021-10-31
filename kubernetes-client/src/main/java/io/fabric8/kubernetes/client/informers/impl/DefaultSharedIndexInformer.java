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
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.ResyncRunnable;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.cache.Cache;
import io.fabric8.kubernetes.client.informers.cache.Indexer;
import io.fabric8.kubernetes.client.informers.cache.ProcessorStore;
import io.fabric8.kubernetes.client.informers.cache.Reflector;
import io.fabric8.kubernetes.client.informers.cache.SharedProcessor;
import io.fabric8.kubernetes.client.informers.cache.Store;
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
import java.util.function.Supplier;

public class DefaultSharedIndexInformer<T extends HasMetadata, L extends KubernetesResourceList<T>> implements SharedIndexInformer<T> {
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
  private final Cache<T> indexer;
  private final SharedProcessor<T> processor;
  private final Executor informerExecutor;

  private final AtomicBoolean started = new AtomicBoolean();
  private volatile boolean stopped = false;

  private ScheduledFuture<?> resyncFuture;

  public DefaultSharedIndexInformer(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, long resyncPeriod, Executor informerExecutor) {
    if (resyncPeriod < 0) {
      throw new IllegalArgumentException("Invalid resync period provided, It should be a non-negative value");
    }
    this.resyncCheckPeriodMillis = resyncPeriod;
    this.defaultEventHandlerResyncPeriod = resyncPeriod;
    this.apiTypeClass = apiTypeClass;

    this.informerExecutor = informerExecutor;
    // reuse the informer executor, but ensure serial processing
    this.processor = new SharedProcessor<>(new SerialExecutor(informerExecutor));
    this.indexer = new Cache<>();
    this.indexer.setIsRunning(this::isRunning);

    processorStore = new ProcessorStore<>(this.indexer, this.processor);
    this.reflector = new Reflector<>(apiTypeClass, listerWatcher, processorStore);
  }

  /**
   * add event callback
   *
   * @param handler event handler
   */
  @Override
  public void addEventHandler(ResourceEventHandler<? super T> handler) {
    addEventHandlerWithResyncPeriod(handler, defaultEventHandlerResyncPeriod);
  }

  @Override
  public void addEventHandlerWithResyncPeriod(ResourceEventHandler<? super T> handler, long resyncPeriodMillis) {
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
        if (started.get()) {
          log.warn("DefaultSharedIndexInformer#resyncPeriod {} is smaller than resyncCheckPeriod {} and the informer has already started. Changing it to {}", resyncPeriodMillis, resyncCheckPeriodMillis,resyncCheckPeriodMillis);
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

    log.debug("informer: ready to run resync and reflector for {} with resync {}", apiTypeClass, resyncCheckPeriodMillis);

    scheduleResync(processor::shouldResync);

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
  public void addIndexers(Map<String, Function<T, List<String>>> indexers) {
    indexer.addIndexers(indexers);
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
    return !stopped && started.get() && reflector.isRunning();
  }
  
  @Override
  public boolean isWatching() {
    return reflector.isWatching();
  }
  
  synchronized void scheduleResync(Supplier<Boolean> resyncFunc) {
    // schedule the resync runnable
    if (resyncCheckPeriodMillis > 0) {
      ResyncRunnable<T> resyncRunnable = new ResyncRunnable<>(processorStore, resyncFunc);
      resyncFuture = Utils.scheduleAtFixedRate(informerExecutor, resyncRunnable, resyncCheckPeriodMillis, resyncCheckPeriodMillis, TimeUnit.MILLISECONDS);
    } else {
      log.debug("informer#Controller: resync skipped due to 0 full resync period {}", apiTypeClass);
    }
  }

  public long getFullResyncPeriod() {
    return resyncCheckPeriodMillis;
  }

  ScheduledFuture<?> getResyncFuture() {
    return resyncFuture;
  }

  @Override
  public Class<T> getApiTypeClass() {
    return apiTypeClass;
  }

}
