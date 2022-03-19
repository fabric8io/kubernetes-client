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
import java.util.Map;
import java.util.function.Function;

/**
 * Indexer extends Store interface and add index/de-index methods.
 *
 * This implementation has been taken from official client:
 * https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/cache/Indexer.java
 * which has been ported from official go client: https://github.com/kubernetes/client-go/blob/master/tools/cache/index.go
 *
 * @param <T> resource
 */
public interface Indexer<T> extends Store<T> {
  /**
   * Retrieve list of objects that match on the named indexing function.
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

  /**
   * Return the indexers registered with the store.
   *
   * @return registered indexers
   */
  Map<String, Function<T, List<String>>> getIndexers();

  /**
   * Add additional indexers to the store.
   *
   * @param indexers indexers to add
   */
  void addIndexers(Map<String, Function<T, List<String>>> indexers);

  /**
   * Remove the named index
   *
   * @param name
   */
  void removeIndexer(String name);
}
