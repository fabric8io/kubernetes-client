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

import java.util.List;

public interface SyncableStore<T> extends Store<T> {

  /**
   * Inserts an item into the store
   *
   * @param obj object
   */
  void add(T obj);

  /**
   * Sets an item  in the store to its updated state.
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
   * Deletes the contents of the store, using instead the given list.
   * Store takes ownership of the list, you should not reference it
   * after calling this function
   *
   * @param list list of objects
   */
  void replace(List<T> list);

  /**
   * Sends a resync event for each item.
   */
  void resync();

}
