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
package io.fabric8.kubernetes.client.utils.informers.cache;

import java.util.List;

/**
 * Indexer extends Store interface and add index/de-index methods.
 *
 * @param <T> resource
 */
public interface Indexer<T> extends Store<T> {
  /**
   * Retrieve list of obejcts that match on the named indexing function.
   *
   * @param indexName specific indexing function
   * @param obj object
   * @return matched objects
   */
  List<T> index(String indexName, T obj);

  /**
   * Returns the set of keys that match on the named indexing function.
   *
   * @param indexName specific indexing function
   * @param indexKey specific index key
   * @return matched keys
   */
  List<String> indexKeys(String indexName, String indexKey);

  /**
   * Lists objects that match on the named indexing function with the exact key.
   *
   * @param indexName specific indexing function
   * @param indexKey specific index key
   * @return matched objects
   */
  List<T> byIndex(String indexName, String indexKey);
}
