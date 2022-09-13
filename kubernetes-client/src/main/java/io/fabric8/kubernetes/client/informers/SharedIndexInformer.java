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
package io.fabric8.kubernetes.client.informers;

import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.informers.cache.Indexer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * SharedInxedInformer extends SharedInformer and provides indexer operability additionally.
 */
public interface SharedIndexInformer<T> extends SharedInformer<T> {

  /**
   * Add indexers
   *
   * @param indexers indexers
   */
  void addIndexers(Map<String, Function<T, List<String>>> indexers);

  /**
   * returns the internal indexer store.
   *
   * @return the internal indexer store
   */
  Indexer<T> getIndexer();

  /**
   * Return a future that will allow notification of informer stopping.
   * <p>
   * If {@link #stop()} is called, the future will be completed with a null value.
   * <p>
   * If an exception occurs that terminates the informer, then it will be exceptionally completed with that exception
   * - typically a {@link WatcherException}
   */
  CompletableFuture<Void> stopped();
}
