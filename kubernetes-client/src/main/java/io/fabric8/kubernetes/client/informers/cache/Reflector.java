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
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

public class Reflector<T extends HasMetadata, L extends KubernetesResourceList<T>> {

  private static final Logger log = LoggerFactory.getLogger(Reflector.class);

  private volatile String lastSyncResourceVersion;
  private final Class<T> apiTypeClass;
  private final ListerWatcher<T, L> listerWatcher;
  private final SyncableStore<T> store;
  private final ReflectorWatcher watcher;
  private volatile boolean running;
  private volatile boolean watching;
  private final AtomicReference<Watch> watch;

  public Reflector(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, SyncableStore<T> store) {
    this.apiTypeClass = apiTypeClass;
    this.listerWatcher = listerWatcher;
    this.store = store;
    this.watcher = new ReflectorWatcher();
    this.watch = new AtomicReference<>(null);
  }

  protected L getList() {
    return listerWatcher.list(new ListOptions());
  }

  public void stop() {
    running = false;
    stopWatcher();
  }

  private synchronized void stopWatcher() {
    Watch theWatch = watch.getAndSet(null);
    if (theWatch != null) {
      String ns = listerWatcher.getNamespace();
      log.debug("Stopping watcher for resource {} v{} in namespace {}", apiTypeClass, lastSyncResourceVersion, ns);
      theWatch.close();
      watchStopped(); // proactively report as stopped
    }
  }

  /**
   * <br>Starts the watch with a fresh store state.
   * <br>Should be called only at start and when HttpGone is seen.
   */
  public void listSyncAndWatch() {
    running = true;
    final L list = getList();
    final String latestResourceVersion = list.getMetadata().getResourceVersion();
    lastSyncResourceVersion = latestResourceVersion;
    log.debug("Listing items ({}) for resource {} v{}", list.getItems().size(), apiTypeClass, latestResourceVersion);
    store.replace(list.getItems());
    startWatcher(latestResourceVersion);
  }

  private synchronized void startWatcher(final String latestResourceVersion) {
    if (!running) {
        return;
    }
    log.debug("Starting watcher for resource {} v{}", apiTypeClass, latestResourceVersion);
    // there's no need to stop the old watch, that will happen automatically when this call completes
    watch.set(
        listerWatcher.watch(new ListOptionsBuilder().withResourceVersion(latestResourceVersion)
            .withTimeoutSeconds(null)
            .build(), watcher));
    watching = true;
  }
  
  private synchronized void watchStopped() {
    watching = false;
  }

  public String getLastSyncResourceVersion() {
    return lastSyncResourceVersion;
  }
  
  public boolean isRunning() {
    return running;
  }
  
  public boolean isWatching() {
    return watching;
  }
  
  class ReflectorWatcher implements Watcher<T> {

    @Override
    public void eventReceived(Action action, T resource) {
      if (action == null) {
        throw new KubernetesClientException("Unrecognized event");
      }
      if (resource == null) {
        throw new KubernetesClientException("Unrecognized resource");  
      }
      if (log.isDebugEnabled()) {
        log.debug("Event received {} {} resourceVersion {}", action.name(), resource.getKind(), resource.getMetadata().getResourceVersion());
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
      boolean restarted = false;
      try {
        if (exception.isHttpGone()) {
          log.debug("Watch restarting due to http gone");
          listSyncAndWatch();
          restarted = true;
        } else {
          log.warn("Watch closing with exception", exception);
          running = false; // shouldn't happen, but it means the watch won't restart
        }
      } finally {
        if (!restarted) {
          watchStopped(); // report the watch as stopped after a problem
        }
      }
    }

    @Override
    public void onClose() {
      watchStopped();
      log.debug("Watch gracefully closed");
    }

    @Override
    public boolean reconnecting() {
      return true;
    }
    
  }
  
  public ReflectorWatcher getWatcher() {
    return watcher;
  }

}
