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
 * Lister interface is used to list cached items from a running informer.
 *
 * @param <T> the object type
 */
public class Lister<T> {
  private final String namespace;

  private final String indexName;

  private final Indexer<T> indexer;

  public Lister(Indexer<T> indexer) {
    this(indexer, null, Cache.NAMESPACE_INDEX);
  }

  public Lister(Indexer<T> indexer, String namespace) {
    this(indexer, namespace, Cache.NAMESPACE_INDEX);
  }

  public Lister(Indexer<T> indexer, String namespace, String indexName) {
    this.indexer = indexer;
    this.namespace = namespace;
    this.indexName = indexName;
  }

  public List<T> list() {
    if ((namespace == null || namespace.isEmpty())) {
      return indexer.list();
    } else {
      return indexer.byIndex(this.indexName, namespace);
    }
  }

  public T get(String name) {
    String key = name;
    if (namespace != null && !namespace.isEmpty()) {
      key = namespace + "/" + name;
    }
    return indexer.getByKey(key);
  }

  public Lister<T> namespace(String namespace) {
    return new Lister<>(this.indexer, namespace, Cache.NAMESPACE_INDEX);
  }
}
