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

import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;

import java.util.stream.Stream;

/**
 * Holds item state for the {@link SharedIndexInformer}. For events to be consistent the store should remember
 * all entries until they are deleted. At its simplest this is just a map coupled with a key function.
 * <p>
 * Modifications to this store once the informer is running, by anything other than the informer will alter the event stream. If
 * for example an item is not found, an subsequent update from the api version will send notifications to
 * {@link ResourceEventHandler}s as an add.
 * <p>
 * Direct modifications to this store by anything other than the informer will not updated indexes nor emit events.
 * <p>
 * The implementation should be safe with respect to concurrency. Modifications from the informer
 * will be single threaded, but not necessarily the same thread. Reads may be concurrent with writes.
 * <p>
 * See an example implementations {@link BasicItemStore} and {@link ReducedStateItemStore}
 *
 * @param <V>
 */
public interface ItemStore<V> {

  String getKey(V obj);

  V put(String key, V obj);

  V remove(String key);

  Stream<String> keySet();

  Stream<V> values();

  int size();

  V get(String key);

  /**
   * Used to determine if initial add events can be deferred until
   * the entire list operation has completed - when using a limit
   * it may take several batches to complete.
   * <br>
   * If false, then the initial add events must be processed as they
   * occur - meaning that the store state may not be complete.
   *
   * @return
   */
  default boolean isFullState() {
    return true;
  }

}
