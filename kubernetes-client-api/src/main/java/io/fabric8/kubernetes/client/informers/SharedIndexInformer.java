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

import io.fabric8.kubernetes.client.informers.cache.Cache;
import io.fabric8.kubernetes.client.informers.cache.Indexer;
import io.fabric8.kubernetes.client.informers.cache.ItemStore;
import io.fabric8.kubernetes.client.informers.cache.Store;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * SharedInxedInformer extends SharedInformer and provides indexer operability additionally.
 */
public interface SharedIndexInformer<T> extends AutoCloseable {

  /**
   * Add indexers
   *
   * @param indexers indexers
   */
  SharedIndexInformer<T> addIndexers(Map<String, Function<T, List<String>>> indexers);

  /**
   * Remove the namesapce index
   *
   * @return this
   */
  default SharedIndexInformer<T> removeNamespaceIndex() {
    return removeIndexer(Cache.NAMESPACE_INDEX);
  }

  /**
   * Remove the named index
   *
   * @param name
   * @return this
   */
  SharedIndexInformer<T> removeIndexer(String name);

  /**
   * returns the internal indexer store.
   *
   * @return the internal indexer store
   */
  Indexer<T> getIndexer();

  /**
   * Add event handler.
   * <p>
   * The handler methods will be called using the client's {@link Executor}
   *
   * @param handler event handler
   */
  SharedIndexInformer<T> addEventHandler(ResourceEventHandler<? super T> handler);

  /**
   * Adds an event handler to the shared informer using the specified resync period.
   * Events to a single handler are delivered sequentially, but there is no
   * coordination between different handlers.
   * <p>
   * The handler methods will be called using the client's {@link Executor}
   *
   * @param handle the event handler
   * @param resyncPeriod the specific resync period
   */
  SharedIndexInformer<T> addEventHandlerWithResyncPeriod(ResourceEventHandler<? super T> handle, long resyncPeriod);

  /**
   * Starts the shared informer, which will be stopped when {@link #stop()} is called.
   *
   * <br>
   * Only one start attempt is made - subsequent calls will not re-start the informer.
   *
   * <br>
   * If the informer is not already running, this is a blocking call
   */
  SharedIndexInformer<T> run();

  /**
   * Stops the shared informer. The informer cannot be started again.
   */
  void stop();

  @Override
  default void close() {
    stop();
  }

  /**
   * Return true if the informer has ever synced
   */
  default boolean hasSynced() {
    return lastSyncResourceVersion() != null;
  }

  /**
   * The resource version observed when last synced with the underlying store.
   * The value returned is not synchronized with access to the underlying store
   * and is not thread-safe.
   *
   * @return string value or null if never synced
   */
  String lastSyncResourceVersion();

  /**
   * Return true if the informer is running
   */
  boolean isRunning();

  /**
   * Return the class this informer is watching
   */
  Class<T> getApiTypeClass();

  /**
   * Return true if the informer is actively watching
   * <br>
   * Will return false when {@link #isRunning()} is true when the watch needs to be re-established.
   */
  boolean isWatching();

  /**
   * Return the Store associated with this informer
   *
   * @return the store
   */
  Store<T> getStore();

  /**
   * Sets the initial state of the informer store, which will
   * be replaced by the initial list operation. This will emit
   * relevant delete and update events, rather than just adds.
   * <br>
   * Can only be called before the informer is running
   *
   * @param items
   */
  SharedIndexInformer<T> initialState(Stream<T> items);

  SharedIndexInformer<T> itemStore(ItemStore<T> itemStore);

  /**
   * A non-blocking alternative to run. Starts the shared informer, which will be stopped when {@link #stop()} is called.
   * <br>
   * Only one start attempt is made - subsequent calls will not re-start the informer.
   */
  CompletableFuture<Void> start();

}
