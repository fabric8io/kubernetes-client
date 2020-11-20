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
package io.fabric8.kubernetes.client.dsl.base;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;

public class WaitForConditionWatcher<T extends HasMetadata> implements Watcher<T> {

  private final Predicate<T> condition;
  private final CompletableFuture<T> future;

  public WaitForConditionWatcher(Predicate<T> condition) {
    this.condition = condition;
    this.future = new CompletableFuture<>();
  }

  public CompletableFuture<T> getFuture() {
    return future;
  }

  @Override
  public void eventReceived(Action action, T resource) {
    switch (action) {
      case ADDED:
      case MODIFIED:
        if (condition.test(resource)) {
          future.complete(resource);
        }
        break;
      case DELETED:
        if (condition.test(null)) {
          future.complete(null);
        }
        break;
      case ERROR:
        future.completeExceptionally(new WatcherException("Action.ERROR received"));
        break;
    }
  }

  @Override
  public void onClose(WatcherException cause) {
    future.completeExceptionally(cause);
  }

  @Override
  public void onClose() {
    future.completeExceptionally(new WatcherException("Watcher closed"));
  }
}
