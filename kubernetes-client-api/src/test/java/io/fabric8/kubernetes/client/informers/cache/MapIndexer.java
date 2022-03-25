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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapIndexer<T> implements Indexer<T> {
  private final Map<String, Map<String, T>> map;

  public MapIndexer() {
    this.map = new HashMap<>();
  }

  @Override
  public List<T> index(String indexName, T obj) {
    return null;
  }

  @Override
  public List<String> indexKeys(String indexName, String indexKey) {
    return null;
  }

  @Override
  public List<T> byIndex(String indexName, String indexKey) {
    return new ArrayList<>(map.getOrDefault(indexKey, new HashMap<>()).values());
  }

  @Override
  public Map<String, Function<T, List<String>>> getIndexers() {
    return null;
  }

  @Override
  public void addIndexers(Map<String, Function<T, List<String>>> indexers) {

  }

  @Override
  public void removeIndexer(String name) {

  }

  @Override
  public List<T> list() {
    return map.values().stream().flatMap(m -> m.values().stream()).collect(Collectors.toList());
  }

  @Override
  public List<String> listKeys() {
    return map.values().stream().flatMap(m -> m.keySet().stream()).collect(Collectors.toList());
  }

  @Override
  public T get(T object) {
    return object;
  }

  @Override
  public T getByKey(String key) {
    for (Map<String, T> m : map.values()) {
      if (m.containsKey(key)) {
        return m.get(key);
      }
    }
    return null;
  }

  protected void put(String index, String key, T object) {
    map.compute(index, (k, v) -> v == null ? new HashMap<>() : v).put(key, object);
  }

  @Override
  public String getKey(T object) {
    return null;
  }
}
