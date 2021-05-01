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

import java.util.concurrent.atomic.AtomicReference;

public class Reflector<T extends HasMetadata, L extends KubernetesResourceList<T>> {

  private static final Logger log = LoggerFactory.getLogger(Reflector.class);

  private final AtomicReference<String> lastSyncResourceVersion;
  private final Class<T> apiTypeClass;
  private final ListerWatcher<T, L> listerWatcher;
  private final Store<T> store;
  private final OperationContext operationContext;
  private final ReflectorWatcher<T> watcher;
  private volatile boolean running = true;
  private final AtomicReference<Watch> watch;

  public Reflector(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, Store store, OperationContext operationContext) {
    this.apiTypeClass = apiTypeClass;
    this.listerWatcher = listerWatcher;
    this.store = store;
    this.operationContext = operationContext;
    this.lastSyncResourceVersion = new AtomicReference<>();
    this.watcher = new ReflectorWatcher<>(store, lastSyncResourceVersion, this::listSyncAndWatch);
    this.watch = new AtomicReference<>(null);
  }

  private L getList() {
    return listerWatcher.list(new ListOptionsBuilder()
      .withWatch(Boolean.FALSE)
      .withResourceVersion(null)
      .withTimeoutSeconds(null).build(), operationContext.getNamespace(), operationContext);
  }

  public void stop() {
    running = false;
    stopWatcher();
  }

  private synchronized void stopWatcher() {
    Watch theWatch = watch.getAndSet(null);
    if (theWatch != null) {
      String ns = operationContext.getNamespace();
      log.debug("Stopping watcher for resource {} v{} in namespace {}", apiTypeClass, lastSyncResourceVersion.get(), ns);
      theWatch.close();
    }
  }

  /**
   * <br>Starts the watch with a fresh store state.
   * <br>Should be called only at start and when HttpGone is seen.
   */
  void listSyncAndWatch() {
    store.isPopulated(false);
    final L list = getList();
    final String latestResourceVersion = list.getMetadata().getResourceVersion();
    lastSyncResourceVersion.set(list.getMetadata().getResourceVersion());
    log.debug("Listing items ({}) for resource {} v{}", list.getItems().size(), apiTypeClass, latestResourceVersion);
    store.replace(list.getItems(), latestResourceVersion);
    startWatcher(latestResourceVersion);
  }

  private synchronized void startWatcher(final String latestResourceVersion) {
    if (!running) {
        return;
    }
    log.debug("Starting watcher for resource {} v{}", apiTypeClass, latestResourceVersion);
    // there's no need to stop the old watch, that will happen automatically when this call completes
    watch.set(
      listerWatcher.watch(new ListOptionsBuilder()
        .withWatch(Boolean.TRUE).withResourceVersion(latestResourceVersion).withTimeoutSeconds(null).build(),
      operationContext.getNamespace(), operationContext, watcher));
  }

  public String getLastSyncResourceVersion() {
    return lastSyncResourceVersion.get();
  }
  
  public boolean isRunning() {
    return running;
  }
}
