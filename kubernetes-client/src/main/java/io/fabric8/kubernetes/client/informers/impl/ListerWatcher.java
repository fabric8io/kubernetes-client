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
package io.fabric8.kubernetes.client.informers.impl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.internal.AbstractWatchManager;

import java.util.concurrent.CompletableFuture;

/**
 * ListerWatcher is any object that knows how to perform an initial list and
 * start a watch on a resource.
 *
 * @param <T> type
 * @param <L> list for that type
 */
public interface ListerWatcher<T extends HasMetadata, L> {
  CompletableFuture<AbstractWatchManager<T>> submitWatch(ListOptions params, Watcher<T> watcher);

  CompletableFuture<L> submitList(ListOptions listOptions);

  Long getLimit();

  int getWatchReconnectInterval();

  String getApiEndpointPath();
}
