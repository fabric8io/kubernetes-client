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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

public class ReflectorWatcher<T extends HasMetadata> implements Watcher<T> {

  private static final Logger log = LoggerFactory.getLogger(ReflectorWatcher.class);

  private final Store<T> store;
  private final AtomicReference<String> lastSyncResourceVersion;
  private final Runnable onHttpGone;

  public ReflectorWatcher(Store<T> store, AtomicReference<String> lastSyncResourceVersion, Runnable onHttpGone) {
    this.store = store;
    this.lastSyncResourceVersion = lastSyncResourceVersion;
    this.onHttpGone = onHttpGone;
  }

  @Override
  public void eventReceived(Action action, T resource) {
    if (action == null) {
      throw new KubernetesClientException("Unrecognized event");
    }
    if (resource == null) {
      throw new KubernetesClientException("Unrecognized resource");  
    }
    if (log.isDebugEnabled()) {
      log.debug("Event received {} {}# resourceVersion {}", action.name(), resource.getKind(), resource.getMetadata().getResourceVersion());
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
    lastSyncResourceVersion.set(resource.getMetadata().getResourceVersion());
  }

  @Override
  public void onClose(WatcherException exception) {
    // this close was triggered by an exception,
    // not the user, it is expected that the watch retry will handle this
    log.warn("Watch closing with exception", exception);
    if (exception.isHttpGone()) {
        onHttpGone.run();
    }
  }

  @Override
  public void onClose() {
    log.debug("Watch gracefully closed");
  }

  @Override
  public boolean reconnecting() {
    return true;
  }
  
}
