/*
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.stream.Stream;

public class DefaultSharedIndexInformer<T extends HasMetadata, L extends KubernetesResourceList<T>>
    implements SharedIndexInformer<T> {
  private static final Logger logger = LoggerFactory.getLogger(DefaultSharedIndexInformer.class);

  private static final long MINIMUM_RESYNC_PERIOD_MILLIS = 1000L;

  // resyncCheckPeriod is how often we want the reflector's resync timer to fire so it can
  // call shouldResync to check if any of our listeners need a resync.
  private long resyncCheckPeriodMillis;

  // defaultEventHandlerResyncPeriod is the default resync period for any handlers added via
  // AddEventHandler(i.e they don't specify one and just want to use the shared informer's default
  // value).
  private final long defaultEventHandlerResyncPeriod;

  private volatile long lastChecked = -1;
  private final int errorThresholdIntervalMillis;
  private final int maxNumberOfAttempts;
  private final AtomicInteger numberOfAttempts = new AtomicInteger();

  private final Reflector<T, L> reflector;
  private final Class<T> apiTypeClass;
  private final String description;

  private final AtomicBoolean started = new AtomicBoolean();
  private volatile boolean stopped = false;

  private Future<?> resyncFuture;
  private Stream<T> initialState;

  /**
   * Create a new informer with complete sensitivity to transient disconnections (i.e. configured with no threshold interval or
   * error number).
   *
   * @see DefaultSharedIndexInformer#DefaultSharedIndexInformer(Class, ListerWatcher, long, Executor, int, int)
   *      DefaultSharedIndexInformer
   */
  public DefaultSharedIndexInformer(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, long resyncPeriod,
      Executor informerExecutor) {
    this(apiTypeClass, listerWatcher, resyncPeriod, informerExecutor, -1, -1);
  }

  /**
   * Create a new informer.
   *
   * @param apiTypeClass the class representing the type of Kubernetes resources this informer watches
   * @param listerWatcher the {@link ListerWatcher} the informer will use to watch and list resources
   * @param resyncPeriod maximum number of milliseconds to wait before checking if a resync is required
   * @param informerExecutor the {@link Executor} the informer will use to schedule its background tasks
   * @param errorThresholdIntervalMillis interval of time (in milliseconds) within which {@link #isWatching()} probing must
   *        return a negative response before triggering an actual negative response. Use with {@link #maxNumberOfAttempts} to
   *        specify the informer's sensitivity to transient disconnections. Null or negative values disable this threshold
   *        mechanism and the actual result is immediately returned.
   * @param errorThresholdNumber number of negative probing of {@link #isWatching()} that must occur during the interval
   *        specified by {@link #errorThresholdIntervalMillis} before an actual negative response is returned by
   *        {@link #isWatching()}. Use with {@link #errorThresholdIntervalMillis} to specify the informer's sensitivity to
   *        transient disconnections. Null or negative values disable this threshold mechanism and the actual result is
   *        immediately returned.
   */
  public DefaultSharedIndexInformer(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, long resyncPeriod,
      Executor informerExecutor, int errorThresholdIntervalMillis, int errorThresholdNumber) {
    this(apiTypeClass, Reflector.newWith(listerWatcher, informerExecutor), resyncPeriod, errorThresholdIntervalMillis,
        errorThresholdNumber);
  }

  DefaultSharedIndexInformer(Class<T> apiTypeClass, Reflector<T, L> reflector, long resyncPeriod,
      int errorThresholdIntervalMillis, int maxNumberOfAttempts) {
    if (resyncPeriod < 0) {
      throw new IllegalArgumentException("Invalid resync period provided, It should be a non-negative value");
    }
    this.resyncCheckPeriodMillis = resyncPeriod;
    this.defaultEventHandlerResyncPeriod = resyncPeriod;
    this.apiTypeClass = apiTypeClass;
    this.description = reflector.toString();

    this.reflector = reflector;

    this.maxNumberOfAttempts = maxNumberOfAttempts;
    this.errorThresholdIntervalMillis = errorThresholdIntervalMillis;
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
  public SharedIndexInformer<T> removeEventHandler(ResourceEventHandler<? super T> handler) {
    final var processor = processor();
    var listener = processor.removeProcessorListener(handler);
    if (!started.get() && listener.isPresent()) {
      var listenerResyncPeriod = listener.orElseThrow().getResyncPeriodInMillis();
      if (listenerResyncPeriod != 0 && resyncCheckPeriodMillis == listenerResyncPeriod) {
        processor.getMinimalNonZeroResyncPeriod()
            .ifPresent(l -> this.resyncCheckPeriodMillis = l);
      }
    }
    return this;
  }

  @Override
  public SharedIndexInformer<T> addEventHandlerWithResyncPeriod(ResourceEventHandler<? super T> handler,
      long resyncPeriodMillis) {
    if (stopped) {
      logger.info("DefaultSharedIndexInformer#Handler was not added to {} because it has stopped already", this);
      return this;
    }

    if (resyncPeriodMillis > 0) {
      if (resyncPeriodMillis < MINIMUM_RESYNC_PERIOD_MILLIS) {
        logger.warn(
            "DefaultSharedIndexInformer#resyncPeriod {} is too small for {}. Changing it to minimal allowed value of {}",
            resyncPeriodMillis, this, MINIMUM_RESYNC_PERIOD_MILLIS);
        resyncPeriodMillis = MINIMUM_RESYNC_PERIOD_MILLIS;
      }

      if (resyncPeriodMillis < this.resyncCheckPeriodMillis) {
        if (started.get()) {
          logger.warn(
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

    processor().addProcessorListener(handler,
        determineResyncPeriod(resyncPeriodMillis, this.resyncCheckPeriodMillis), getStore()::list);

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
        initialState.forEach(store().cache()::put);
        reflector.usingInitialState();
      }
    }

    logger.debug("Ready to run resync and reflector for {} with resync {}", this, resyncCheckPeriodMillis);

    scheduleResync(processor()::shouldResync);

    return reflector.start();
  }

  public CompletableFuture<Void> started() {
    return reflector.getStartFuture();
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
    processor().stop();
  }

  private synchronized void stopResync() {
    if (resyncFuture != null) {
      resyncFuture.cancel(true);
      resyncFuture = null;
    }
  }

  @Override
  public SharedIndexInformer<T> addIndexers(Map<String, Function<T, List<String>>> indexers) {
    getIndexer().addIndexers(indexers);
    return this;
  }

  @Override
  public Indexer<T> getIndexer() {
    return store().cache();
  }

  @Override
  public Store<T> getStore() {
    return getIndexer();
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
    final var watching = reflector.isWatching();
    // if a cooldown window is configured, check if we had too many negative results in the configured window
    if (errorThresholdIntervalMillis > 0 && maxNumberOfAttempts > 0) {
      if (!watching) {
        final var now = System.currentTimeMillis();
        try {
          final var timeSinceLastChecked = now - lastChecked;
          if (lastChecked < 0 || timeSinceLastChecked < errorThresholdIntervalMillis) {
            // within the threshold window, return true if we haven't reached the max number of attempts, false otherwise
            return numberOfAttempts.getAndIncrement() < maxNumberOfAttempts;
          } else {
            // more time elapsed than the threshold interval, so set the number of attempts to 1 (this becomes the first attempt of the new threshold window) and return true
            numberOfAttempts.set(1);
            return true;
          }
        } finally {
          lastChecked = now;
        }
      } else {
        // reset number of attempts
        numberOfAttempts.set(0);
      }
    }

    return watching;
  }

  synchronized void scheduleResync(BooleanSupplier resyncFunc) {
    // schedule the resync runnable
    if (resyncCheckPeriodMillis > 0) {
      resyncFuture = Utils.scheduleAtFixedRate(reflector.executor(), () -> {
        if (logger.isDebugEnabled()) {
          logger.debug("Checking for resync at interval for {}", this);
        }
        if (resyncFunc.getAsBoolean()) {
          logger.debug("Resync running for {}", this);
          store().resync();
        }
      }, resyncCheckPeriodMillis,
          resyncCheckPeriodMillis, TimeUnit.MILLISECONDS);
    } else {
      logger.debug("Resync skipped due to 0 full resync period for {}", this);
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
    getIndexer().removeIndexer(name);
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
    store().cache().setItemStore(itemStore);
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

  private SharedProcessor<T> processor() {
    return store().processor();
  }

  private ProcessorStore<T> store() {
    return reflector.store();
  }
}
