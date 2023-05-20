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
package io.fabric8.kubernetes.client.informers.impl.cache;

import io.fabric8.kubernetes.client.informers.cache.Store;

import java.util.List;
import java.util.Set;

/**
 * Extends a {@link Store}, but also has the responsibility of
 * notifying listeners on all operations.
 */
public interface SyncableStore<T> extends Store<T> {

  /**
   * Inserts an item into the store
   *
   * @param obj object
   */
  void add(T obj);

  /**
   * Sets an item in the store to its updated state.
   *
   * @param obj object
   */
  void update(T obj);

  /**
   * Removes an item from the store
   *
   * @param obj object
   */
  void delete(T obj);

  /**
   * Sends a resync event for each item.
   */
  void resync();

  /**
   * Retain only the values with keys in the given set
   *
   * @param nextKeys to retain
   */
  void retainAll(Set<String> nextKeys);

  /**
   * Process a batch of updates
   * 
   * @param items
   */
  void update(List<T> items);

}
