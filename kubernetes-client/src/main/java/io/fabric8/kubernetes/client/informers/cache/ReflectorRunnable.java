/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import io.fabric8.kubernetes.api.model.ListMeta;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReflectorRunnable<T extends HasMetadata, TList extends KubernetesResourceList<T>> implements Runnable {
  private static final Logger log = LoggerFactory.getLogger(ReflectorRunnable.class);

  private String lastSyncResourceVersion;
  private Watch watch;
  private ListerWatcher<T, TList> listerWatcher;
  private Store<T> store;
  private Class<T> apiTypeClass;
  private AtomicBoolean isActive = new AtomicBoolean(true);
  private OperationContext operationContext;

  public ReflectorRunnable(Class<T> apiTypeClass, ListerWatcher listerWatcher, Store store, OperationContext operationContext) {
    this.listerWatcher = listerWatcher;
    this.store = store;
    this.apiTypeClass = apiTypeClass;
    this.operationContext = operationContext;
  }

  /**
   * Run first lists all items and get the resource version at the moment of call
   * and then use the resource version to watch.
   */
  public void run() {
    try {
      log.info("{}#Start listing and watching...", apiTypeClass);

      TList list = listerWatcher.list(new ListOptionsBuilder().withWatch(Boolean.FALSE).withResourceVersion(null).withTimeoutSeconds(null).build(), null, operationContext);

      ListMeta listMeta = list.getMetadata();
      String resourceVersion = listMeta.getResourceVersion();
      List<T> items = list.getItems();

      if (log.isDebugEnabled()) {
        log.debug("{}#Extract resourceVersion {} list meta", apiTypeClass, resourceVersion);
      }
      this.syncWith(items, resourceVersion);
      this.lastSyncResourceVersion = resourceVersion;

      if (log.isDebugEnabled()) {
        log.debug("{}#Start watching with {}...", apiTypeClass, lastSyncResourceVersion);
      }

      if (!isActive.get()) {
        if (watch != null) {
          log.info("Closing watch");
          watch.close();
          return;
        }
      }
      if (watch != null) {
        log.info("Closing existing watch and waiting");
        watch.close();
      }
      try {
        // Use resource version to watch
        watch = listerWatcher.watch(new ListOptionsBuilder().withWatch(Boolean.TRUE).withResourceVersion(resourceVersion).withTimeoutSeconds(null).build(),
          null, operationContext, new Watcher<T>() {
            @Override
            public void eventReceived(Action action, T resource) {
              log.info("Event received ", action.name());
              if (action == null) {
                log.error("unrecognized event {}", resource);
              }
              if (action == Action.ERROR) {
                String errorMessage = String.format("got ERROR event for ", resource.getMetadata().getName());
                log.error(errorMessage);
                throw new RuntimeException(errorMessage);
              }

              ObjectMeta meta = resource.getMetadata();
              String newResourceVersion = meta.getResourceVersion();
              switch (action) {
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
              lastSyncResourceVersion = newResourceVersion;
              if (log.isDebugEnabled()) {
                log.debug("{}#Receiving resourceVersion {}", apiTypeClass, lastSyncResourceVersion);
              }
            }

            @Override
            public void onClose(KubernetesClientException exception) {
              log.error("Watch closing.");
              if (exception != null) {
                exception.printStackTrace();
                log.error("watch closed due to  " + exception.getMessage());
              }
            }
          });
      } catch (Throwable t) {
        log.info("{}#Watch connection got exception {}", apiTypeClass, t.getMessage());
      }
    } catch (Exception exception) {
      log.error("Failure in list-watch: {}", exception.getMessage());
      exception.printStackTrace();
    }
  }

  public void stop() {
    isActive.set(false);
  }

  private void syncWith(List<T> items, String resourceVersion) {
    this.store.replace(items, resourceVersion);
  }

  public String getLastSyncResourceVersion() {
    return lastSyncResourceVersion;
  }

}
