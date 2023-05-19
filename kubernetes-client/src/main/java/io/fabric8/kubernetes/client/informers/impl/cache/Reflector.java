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
package io.fabric8.kubernetes.client.informers.impl.cache;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.internal.AbstractWatchManager;
import io.fabric8.kubernetes.client.informers.ExceptionHandler;
import io.fabric8.kubernetes.client.informers.impl.ListerWatcher;
import io.fabric8.kubernetes.client.utils.ExponentialBackoffIntervalCalculator;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.LongSupplier;

public class Reflector<T extends HasMetadata, L extends KubernetesResourceList<T>> {

  private static final Logger log = LoggerFactory.getLogger(Reflector.class);

  private static long MIN_TIMEOUT = TimeUnit.MINUTES.toSeconds(5);

  private volatile String lastSyncResourceVersion;
  private final ListerWatcher<T, L> listerWatcher;
  private final SyncableStore<T> store;
  private final ReflectorWatcher watcher;
  private volatile boolean watching;
  private volatile CompletableFuture<AbstractWatchManager<T>> watchFuture;
  private volatile CompletableFuture<?> reconnectFuture;
  private final CompletableFuture<Void> startFuture = new CompletableFuture<>();
  private final CompletableFuture<Void> stopFuture = new CompletableFuture<>();
  private final ExponentialBackoffIntervalCalculator retryIntervalCalculator;
  //default behavior - retry if started and it's not a watcherexception
  private volatile ExceptionHandler handler = (b, t) -> b && !(t instanceof WatcherException);
  private long minTimeout = MIN_TIMEOUT;

  private CompletableFuture<Void> timeoutFuture;

  private boolean cachedListing = true;

  public Reflector(ListerWatcher<T, L> listerWatcher, SyncableStore<T> store) {
    this.listerWatcher = listerWatcher;
    this.store = store;
    this.watcher = new ReflectorWatcher();
    this.retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(listerWatcher.getWatchReconnectInterval(),
        ExponentialBackoffIntervalCalculator.UNLIMITED_RETRIES);
  }

  public CompletableFuture<Void> start() {
    listSyncAndWatch();
    return startFuture;
  }

  public CompletableFuture<Void> getStartFuture() {
    return startFuture;
  }

  public void stop() {
    startFuture.completeExceptionally(new KubernetesClientException("informer manually stopped before starting"));
    Future<?> future = reconnectFuture;
    if (future != null) {
      future.cancel(true);
    }
    stopWatcher();
    stopFuture.complete(null);
  }

  private synchronized void stopWatcher() {
    Optional.ofNullable(watchFuture).ifPresent(theFuture -> {
      watchFuture = null;
      theFuture.whenComplete((w, t) -> {
        if (w != null) {
          stopWatch(w);
        }
      });
    });
    if (timeoutFuture != null) {
      timeoutFuture.cancel(true);
    }
  }

  /**
   * <br>
   * Starts the watch with a fresh store state.
   * <br>
   * Should be called only at start and when HttpGone is seen.
   *
   * @return a future that completes when the list and watch are established
   */
  public CompletableFuture<Void> listSyncAndWatch() {
    if (isStopped()) {
      return CompletableFuture.completedFuture(null);
    }
    Set<String> nextKeys = new ConcurrentSkipListSet<>();
    CompletableFuture<Void> theFuture = processList(nextKeys, null).thenCompose(result -> {
      store.retainAll(nextKeys);
      final String latestResourceVersion = result.getMetadata().getResourceVersion();
      lastSyncResourceVersion = latestResourceVersion;
      log.debug("Listing items ({}) for {} at v{}", nextKeys.size(), this, latestResourceVersion);
      return startWatcher(latestResourceVersion);
    }).thenAccept(w -> {
      if (w != null) {
        if (!isStopped()) {
          if (log.isDebugEnabled()) {
            log.debug("Watch started for {}", Reflector.this);
          }
          watching = true;
        } else {
          stopWatch(w);
        }
      }
    });
    theFuture.whenComplete((v, t) -> {
      if (t != null) {
        onException("listSyncAndWatch", t);
      } else {
        startFuture.complete(null);
        retryIntervalCalculator.resetReconnectAttempts();
      }
    });
    return theFuture;
  }

  private void onException(String operation, Throwable t) {
    if (handler.retryAfterException(startFuture.isDone() && !startFuture.isCompletedExceptionally(), t)) {
      log.warn("{} failed for {}, will retry", operation, Reflector.this, t);
      reconnect();
    } else {
      log.error("{} failed for {}, will stop", operation, Reflector.this, t);
      startFuture.completeExceptionally(t);
      stopFuture.completeExceptionally(t);
    }
  }

  protected void reconnect() {
    if (isStopped()) {
      return;
    }
    // this can be run in the scheduler thread because
    // any further operations will happen on the io thread
    reconnectFuture = Utils.schedule(Runnable::run, this::listSyncAndWatch,
        retryIntervalCalculator.nextReconnectInterval(), TimeUnit.MILLISECONDS);
  }

  private CompletableFuture<L> processList(Set<String> nextKeys, String continueVal) {
    CompletableFuture<L> futureResult = listerWatcher
        .submitList(
            new ListOptionsBuilder()
                // if caching is allowed, start with 0 - meaning any cached version is fine for the initial listing
                .withResourceVersion(isCachedListing(continueVal) ? "0" : null)
                .withLimit(listerWatcher.getLimit()).withContinue(continueVal)
                .build());

    return futureResult.thenCompose(result -> {
      result.getItems().forEach(i -> {
        String key = store.getKey(i);
        nextKeys.add(key);
      });
      store.update(result.getItems());
      String nextContinueVal = result.getMetadata().getContinue();
      if (Utils.isNotNullOrEmpty(nextContinueVal)) {
        return processList(nextKeys, nextContinueVal);
      }
      return CompletableFuture.completedFuture(result);
    });
  }

  private boolean isCachedListing(String continueVal) {
    // allow an initial cached listing only if there's no initial state, no limit, we haven't already sync'd, and this isn't a continue request
    return cachedListing && listerWatcher.getLimit() == null && lastSyncResourceVersion == null && continueVal == null;
  }

  private void stopWatch(Watch w) {
    log.debug("Stopping watcher for {} at v{}", this, lastSyncResourceVersion);
    w.close();
    watchStopped(); // proactively report as stopped
  }

  private synchronized CompletableFuture<? extends Watch> startWatcher(final String latestResourceVersion) {
    if (isStopped()) {
      return CompletableFuture.completedFuture(null);
    }
    log.debug("Starting watcher for {} at v{}", this, latestResourceVersion);
    // there's no need to stop the old watch, that will happen automatically when this call completes
    CompletableFuture<AbstractWatchManager<T>> future = listerWatcher.submitWatch(
        new ListOptionsBuilder().withResourceVersion(latestResourceVersion)
            // this would match the behavior of the go client, but requires changing a lot of mock expectations
            // so instead we'll terminate below and set a fail-safe here
            // .withTimeoutSeconds((long) ((Math.random() + 1) * minTimeout))
            .withTimeoutSeconds(minTimeout * 2)
            .build(),
        watcher);

    // the alternative to this is to localize the logic in the AbstractWatchManager, however since
    // we only need it for informers, it seems fine here
    LongSupplier timeout = () -> (long) ((Math.random() + 1) * minTimeout);
    if (timeoutFuture != null) {
      timeoutFuture.cancel(true);
    }
    timeoutFuture = new CompletableFuture<>();
    Utils.scheduleWithVariableRate(timeoutFuture, Runnable::run,
        () -> future.thenAccept(AbstractWatchManager::closeRequest), timeout.getAsLong(), timeout, TimeUnit.SECONDS);
    watchFuture = future;
    return watchFuture;
  }

  public void setMinTimeout(long minTimeout) {
    this.minTimeout = minTimeout;
  }

  private synchronized void watchStopped() {
    watching = false;
  }

  public String getLastSyncResourceVersion() {
    return lastSyncResourceVersion;
  }

  public boolean isStopped() {
    return stopFuture.isDone();
  }

  public boolean isWatching() {
    return watching;
  }

  class ReflectorWatcher implements Watcher<T> {

    @Override
    public void eventReceived(Action action, T resource) {
      // always process what we receive as the watch manager will have already
      // processed the resourceVersion update
      if (action == null) {
        throw new KubernetesClientException("Unrecognized event for " + Reflector.this);
      }
      if (resource == null) {
        throw new KubernetesClientException("Unrecognized resource for " + Reflector.this);
      }
      if (log.isDebugEnabled()) {
        log.debug("Event received {} {} resourceVersion v{} for {}", action.name(),
            resource.getKind(),
            resource.getMetadata().getResourceVersion(), Reflector.this);
      }
      switch (action) {
        case ERROR:
          throw new KubernetesClientException("ERROR event");
        case ADDED:
          store.add(resource);
          break;
        case MODIFIED:
          store.update(resource);
          break;
        case DELETED:
          store.delete(resource);
          break;
      }
      lastSyncResourceVersion = resource.getMetadata().getResourceVersion();
    }

    @Override
    public void onClose(WatcherException exception) {
      // this close was triggered by an exception,
      // not the user, it is expected that the watch retry will handle this
      watchStopped();
      if (exception.isHttpGone()) {
        if (log.isDebugEnabled()) {
          log.debug("Watch restarting due to http gone for {}", Reflector.this);
        }
        // start a whole new list/watch cycle
        reconnect();
      } else {
        onException("watch", exception);
      }
    }

    @Override
    public void onClose() {
      watchStopped();
      log.debug("Watch gracefully closed for {}", Reflector.this);
    }

    @Override
    public boolean reconnecting() {
      return true;
    }
  }

  ReflectorWatcher getWatcher() {
    return watcher;
  }

  @Override
  public String toString() {
    return listerWatcher.getApiEndpointPath();
  }

  public CompletableFuture<Void> getStopFuture() {
    return stopFuture;
  }

  public void setExceptionHandler(ExceptionHandler handler) {
    this.handler = handler;
  }

  public void usingInitialState() {
    this.cachedListing = false;
  }

}
