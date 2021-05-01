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

/**
 * Store is a generic object storage interface. Reflector knows how to watch a server
 * and update a store. A generic store is provided, which allows Reflector to be used
 * as a local caching system, and an Least Recently Used store, which allows Reflector
 * to work like a queue of items yet to be processed.
 *
 * It makes no assumptions about the stored object identity; it is the responsibility
 * of a Store implementation to provide a mechanism to correctly key objects and to
 * define the contract for obtaining objects by some arbitrary key type.
 *
 * This is ported from official go client: https://github.com/kubernetes/client-go/blob/master/tools/cache/store.go
 *
 * @param <T> resource
 */
public interface Store<T> {
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
   *  Returns a list of all the items.
   *
   * @return list of all items
   */
  List<T> list();

  /**
   * returns a list of all keys of the object currently in the store.
   *
   * @return list of all keys
   */
  List<String> listKeys();

  /**
   * Returns the requested item.
   *
   * @param object object
   * @return requested item if exists.
   */
  Object get(T object);

  /**
   * Returns the request item with specific key.
   *
   * @param key specific key
   * @return the requested item
   */
  T getByKey(String key);

  /**
   * Deletes the contents of the store, using instead the given list.
   * Store takes ownership of the list, you should not reference it
   * after calling this function
   *
   * @param list list of objects
   * @param resourceVersion resource version
   */
  void replace(List<T> list, String resourceVersion);

  /**
   * Sends a resync event for each item.
   */
  void resync();

  /**
   * Updates the status of cache in case of any API error from Kubernetes server
   *
   * @param isPopulated boolean value indicating whether cache is populated or not
   */
  void isPopulated(boolean isPopulated);

  /**
   * true if synced
   */
  default boolean hasSynced() {
      return true;
  }

}
