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
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Reflector<T extends HasMetadata, L extends KubernetesResourceList<T>> {

  private static final Logger log = LoggerFactory.getLogger(Reflector.class);
  private static final Long WATCH_RESTART_DELAY_MILLIS = 5000L;

  private final AtomicReference<String> lastSyncResourceVersion;
  private final Class<T> apiTypeClass;
  private final ListerWatcher<T, L> listerWatcher;
  private final Store<T> store;
  private final OperationContext operationContext;
  private final long resyncPeriodMillis;
  private final ScheduledExecutorService resyncExecutor;
  private final ReflectorWatcher<T> watcher;
  private final AtomicBoolean isActive;
  private final AtomicBoolean isWatcherStarted;
  private final AtomicReference<Watch> watch;

  public Reflector(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, Store store, OperationContext operationContext, long resyncPeriodMillis) {
    this(apiTypeClass, listerWatcher, store, operationContext, resyncPeriodMillis, Executors.newSingleThreadScheduledExecutor());
  }

  public Reflector(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, Store store, OperationContext operationContext, long resyncPeriodMillis, ScheduledExecutorService resyncExecutor) {
    this.apiTypeClass = apiTypeClass;
    this.listerWatcher = listerWatcher;
    this.store = store;
    this.operationContext = operationContext;
    this.resyncPeriodMillis = resyncPeriodMillis;
    this.lastSyncResourceVersion = new AtomicReference<>();
    this.resyncExecutor = resyncExecutor;
    this.watcher = new ReflectorWatcher<>(store, lastSyncResourceVersion, this::startWatcher, this::reListAndSync);
    this.isActive = new AtomicBoolean(true);
    this.isWatcherStarted = new AtomicBoolean(false);
    this.watch = new AtomicReference<>(null);
  }

  private L getList() {
    return listerWatcher.list(new ListOptionsBuilder()
      .withWatch(Boolean.FALSE)
      .withResourceVersion(null)
      .withTimeoutSeconds(null).build(), operationContext.getNamespace(), operationContext);
  }

  public void listAndWatch() {
    log.info("Started ReflectorRunnable watch for {}", apiTypeClass);
    reListAndSync();
    startWatcher();
  }

  public void stop() {
    isActive.set(false);
    if (watch.get() != null) {
      watch.get().close();
      watch.set(null);
    }
  }

  public long getResyncPeriodMillis() {
    return resyncPeriodMillis;
  }

  private void reListAndSync() {
    store.isPopulated(false);
    final L list = getList();
    final String latestResourceVersion = list.getMetadata().getResourceVersion();
    log.debug("Listing items ({}) for resource {} v{}", list.getItems().size(), apiTypeClass, latestResourceVersion);
    lastSyncResourceVersion.set(latestResourceVersion);
    store.replace(list.getItems(), latestResourceVersion);
    if (!isActive.get()) {
      resyncExecutor.shutdown();
    }
  }

  private void startWatcher() {
    log.debug("Starting watcher for resource {} v{}", apiTypeClass, lastSyncResourceVersion.get());
    if (watch.get() != null) {
      log.debug("Stopping previous watcher");
      watch.get().close();
    }
    if (isWatcherStarted.get()) {
      log.debug("Watcher already started, delaying execution of new watcher");
      try {
        Thread.sleep(WATCH_RESTART_DELAY_MILLIS);
      } catch (InterruptedException e) {
        log.error("Reflector thread was interrupted");
        Thread.currentThread().interrupt();
        return;
      }
    }
    if (isActive.get()) {
      isWatcherStarted.set(true);
      watch.set(
        listerWatcher.watch(new ListOptionsBuilder()
          .withWatch(Boolean.TRUE).withResourceVersion(lastSyncResourceVersion.get()).withTimeoutSeconds(null).build(),
        operationContext.getNamespace(), operationContext, watcher)
      );
    }
  }

  public String getLastSyncResourceVersion() {
    return lastSyncResourceVersion.get();
  }
}
