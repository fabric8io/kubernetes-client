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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface Watchable<T> {

  /**
   * Watch returns {@link Watch} interface that watches requested resource
   *
   * @param watcher Watcher interface of Kubernetes resource
   * @return watch interface {@link Watch}
   */
  Watch watch(Watcher<T> watcher);

  /**
   * Watch returns {@link Watch} interface that watches requested resource
   * <p>
   * The passed in options may be modified as a side-effect of this call.
   * <br>
   * Values that already exist at this context, such as the labels, fields,
   * and resourceVersion will be overridden on the passed in options regardless of initial values.
   *
   * @param options options available for watch operation
   * @param watcher Watcher interface of Kubernetes resource
   * @return watch interface {@link Watch}
   */
  Watch watch(ListOptions options, Watcher<T> watcher);

  /**
   * Watch returns {@link Watch} interface that watches requested resource from
   * specified resourceVersion
   *
   * @param resourceVersion resource version from where to start watch
   * @param watcher Watcher interface of Kubernetes resource
   * @deprecated Please use {@link #watch(ListOptions, Watcher)} instead, it has a parameter of resourceVersion
   * @return watch interface {@link Watch}
   */
  @Deprecated
  Watch watch(String resourceVersion, Watcher<T> watcher);

  /**
   * Helper method to use the WatchList feature to list resources.
   * A watch is used under the covers, but will be terminated after the initial events.
   * <br>
   * Not specifying a resourceVersion on the context or using 0 will perform a "consistent read"
   * from the time at which the request started processing.
   * 
   * @param onItem a consumer to be called for each item
   * @return a CompletableFuture that provides the terminal resourceVersion, or any underlying exception during processing. It
   *         may be
   *         cancelled to terminate the streamingList operation early
   */
  default CompletableFuture<String> streamingList(Consumer<T> onItem) {
    CompletableFuture<String> future = new CompletableFuture<>();
    Watch watch = this.watch(new ListOptionsBuilder().withSendInitialEvents(true)
        .withResourceVersionMatch("NotOlderThan")
        .withAllowWatchBookmarks(true)
        .build(), new Watcher<T>() {

          @Override
          public void eventReceived(Action action, T resource) {
            switch (action) {
              case ADDED:
                onItem.accept(resource);
                break;
              case BOOKMARK:
                if (resource instanceof HasMetadata) {
                  future.complete(Optional.ofNullable(((HasMetadata) resource).getMetadata())
                      .map(ObjectMeta::getResourceVersion).orElse(null));
                } else {
                  future.complete(null);
                }
                break;
              default:
                if (action == Action.ERROR && resource instanceof Status) {
                  Status status = (Status) resource;
                  future.completeExceptionally(new KubernetesClientException(status));
                } else {
                  future.completeExceptionally(
                      new KubernetesClientException("Unexpected event before list ending bookmark: " + action));
                }
                break;
            }
          }

          @Override
          public void onClose(WatcherException cause) {
            future.completeExceptionally(cause);
          }

        });
    future.whenComplete((v, t) -> watch.close());
    return future;
  }

}
