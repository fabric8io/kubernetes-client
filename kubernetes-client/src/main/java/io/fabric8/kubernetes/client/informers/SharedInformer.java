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

import io.fabric8.kubernetes.client.informers.cache.Store;

/**
 * SharedInformer defines basic methods of an informer.
 *
 * This has been ported from official go client: https://github.com/kubernetes/client-go/blob/master/tools/cache/shared_informer.go
 */
public interface SharedInformer<T> {

  /**
   * Add event handler
   *
   * @param handler event handler
   */
  void addEventHandler(ResourceEventHandler<T> handler);

  /**
   * Adds an event handler to the shared informer using the specified resync period.
   * Events to a single handler are delivered sequentially, but there is no
   * coordination between different handlers.
   *
   * @param handle the event handler
   * @param resyncPeriod the specific resync period
   */
  void addEventHandlerWithResyncPeriod(ResourceEventHandler<T> handle, long resyncPeriod);

  /**
   * Starts the shared informer, which will be stopped until stop() is called.
   */
  void run();

  /**
   * Stops the shared informer.
   */
  void stop();

  boolean hasSynced();

  /**
   * The resource version observed when last synced with the underlying store.
   * The value returned is not synchronized with access to the underlying store
   * and is not thread-safe.
   *
   * @return string value
   */
  String lastSyncResourceVersion();

  /**
   * @return the informer's local cache as a Store
   */
  Store<T, T> getStore();
}
