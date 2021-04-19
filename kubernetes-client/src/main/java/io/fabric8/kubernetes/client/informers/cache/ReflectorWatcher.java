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

import java.util.Optional;

public class ReflectorWatcher<T extends HasMetadata, V> implements Watcher<T> {

  private static final Logger log = LoggerFactory.getLogger(ReflectorWatcher.class);

  private final Store<T, V> store;
  private final Runnable onClose;
  private final Runnable onHttpGone;

  public ReflectorWatcher(Store<T, V> store, Runnable onClose, Runnable onHttpGone) {
    this.store = store;
    this.onClose = onClose;
    this.onHttpGone = onHttpGone;
  }

  @Override
  public void eventReceived(Action action, T resource) {
    if (action == null) {
      final String errorMessage = String.format("Unrecognized event %s", resource.getMetadata().getName());
      log.error(errorMessage);
      throw new KubernetesClientException(errorMessage);
    }
    log.info("Event received {}", action.name());
    switch (action) {
      case ERROR:
        final String errorMessage = String.format("ERROR event for %s", resource.getMetadata().getName());
        log.error(errorMessage);
        throw new KubernetesClientException(errorMessage);
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
    log.debug("{}#Receiving resourceVersion {}", resource.getKind(), resource.getMetadata().getResourceVersion());
  }

  @Override
  public void onClose(WatcherException exception) {
    log.error("Watch closing");
    Optional.ofNullable(exception)
      .map(e -> {
        log.debug("Exception received during watch", e);
        return exception;
      })
      .filter(WatcherException::isHttpGone)
      .ifPresent(c -> onHttpGone.run());
    onClose.run();
  }

  @Override
  public void onClose() {
    log.info("Watch gracefully closed");
    onClose.run();
  }
}
