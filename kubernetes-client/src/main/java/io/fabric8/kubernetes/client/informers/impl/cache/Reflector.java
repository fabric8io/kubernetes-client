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
import io.fabric8.kubernetes.client.informers.impl.ListerWatcher;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Reflector<T extends HasMetadata, L extends KubernetesResourceList<T>> {

  private static final Logger log = LoggerFactory.getLogger(Reflector.class);

  private volatile String lastSyncResourceVersion;
  private final Class<T> apiTypeClass;
  private final ListerWatcher<T, L> listerWatcher;
  private final SyncableStore<T> store;
  private final ReflectorWatcher watcher;
  private volatile boolean running;
  private volatile boolean watching;
  private volatile CompletableFuture<Watch> watchFuture;
  private volatile Future<?> reconnectFuture;

  public Reflector(Class<T> apiTypeClass, ListerWatcher<T, L> listerWatcher, SyncableStore<T> store) {
    this.apiTypeClass = apiTypeClass;
    this.listerWatcher = listerWatcher;
    this.store = store;
    this.watcher = new ReflectorWatcher();
  }

  public CompletableFuture<Void> start() {
    this.running = true;
    return listSyncAndWatch();
  }

  public void stop() {
    running = false;
    Future<?> future = reconnectFuture;
    if (future != null) {
      future.cancel(true);
    }
    stopWatcher();
  }

  private synchronized void stopWatcher() {
    if (watchFuture != null) {
      watchFuture.cancel(true);
      try {
        Watch w = watchFuture.getNow(null);
        if (w != null) {
          stopWatch(w);
        }
      } catch (CompletionException | CancellationException e) {
        // do nothing
      }
      watchFuture = null;
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
    if (!running) {
      return CompletableFuture.completedFuture(null);
    }
    Set<String> nextKeys = new ConcurrentSkipListSet<>();
    return processList(nextKeys, null).thenAccept(result -> {
      store.retainAll(nextKeys);
      final String latestResourceVersion = result.getMetadata().getResourceVersion();
      lastSyncResourceVersion = latestResourceVersion;
      log.debug("Listing items ({}) for resource {} v{}", nextKeys.size(), apiTypeClass, latestResourceVersion);
      CompletableFuture<Watch> started = startWatcher(latestResourceVersion);
      if (started != null) {
        // outside of the lock
        started.whenComplete((w, t) -> {
          if (w != null) {
            if (running) {
              watching = true;
            } else {
              stopWatch(w);
            }
          }
        });
      }
    });
  }

  private CompletableFuture<L> processList(Set<String> nextKeys, String continueVal) {
    CompletableFuture<L> futureResult = listerWatcher
        .submitList(new ListOptionsBuilder().withLimit(listerWatcher.getLimit()).withContinue(continueVal).build());

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

  private void stopWatch(Watch w) {
    String ns = listerWatcher.getNamespace();
    log.debug("Stopping watcher for resource {} v{} in namespace {}", apiTypeClass, lastSyncResourceVersion, ns);
    w.close();
    watchStopped(); // proactively report as stopped
  }

  private synchronized CompletableFuture<Watch> startWatcher(final String latestResourceVersion) {
    if (!running) {
      return null;
    }
    log.debug("Starting watcher for resource {} v{}", apiTypeClass, latestResourceVersion);
    // there's no need to stop the old watch, that will happen automatically when this call completes
    watchFuture = listerWatcher.submitWatch(new ListOptionsBuilder().withResourceVersion(latestResourceVersion)
        .withTimeoutSeconds(null)
        .build(), watcher);
    return watchFuture;
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
        log.debug("Event received {} {} resourceVersion {}", action.name(), resource.getKind(),
            resource.getMetadata().getResourceVersion());
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
          listSyncAndWatch().whenComplete((v, t) -> {
            if (t != null) {
              watchStopped();
              // start a whole new list/watch cycle, can be run in the scheduler thread because
              // any further operations will happen on the io thread
              reconnectFuture = Utils.schedule(Runnable::run, Reflector.this::listSyncAndWatch,
                  listerWatcher.getWatchReconnectInterval(), TimeUnit.MILLISECONDS);
            }
          });
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

  ReflectorWatcher getWatcher() {
    return watcher;
  }

}
