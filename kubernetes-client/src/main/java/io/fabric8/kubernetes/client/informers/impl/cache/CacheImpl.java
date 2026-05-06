/*
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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.informers.cache.BasicItemStore;
import io.fabric8.kubernetes.client.informers.cache.Cache;
import io.fabric8.kubernetes.client.informers.cache.ItemStore;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * It basically saves and indexes all the entries.
 * <br>
 * Index reads {@link #byIndex(String, String)}, {@link #indexKeys(String, String)}, {@link #index(String, HasMetadata)}
 * are not globally locked and thus may not be fully consistent with the current state
 *
 * @param <T> type for cache object
 */
public class CacheImpl<T extends HasMetadata> implements Cache<T> {

  private static class Index<T extends HasMetadata> {

    private final Function<T, List<String>> indexer;
    private final Map<Object, Map<String, String>> values = new ConcurrentHashMap<Object, Map<String, String>>();

    public Index(Function<T, List<String>> indexer) {
      this.indexer = indexer;
    }

    public void update(String indexKey, String key, String resourceVersion, boolean remove) {
      if (remove) {
        values.computeIfPresent(indexKey == null ? this : indexKey, (k, v) -> {
          v.remove(key);
          return v.isEmpty() ? null : v;
        });
      } else {
        values.compute(indexKey == null ? this : indexKey, (k, v) -> v == null ? new ConcurrentHashMap<>() : v).put(key,
            nullAsEmpty(resourceVersion));
      }
    }

    public Map<String, String> get(String indexKey) {
      return values.getOrDefault(indexKey == null ? this : indexKey, Map.of());
    }
  }

  // NAMESPACE_INDEX is the default index function for caching objects
  public static final String NAMESPACE_INDEX = "namespace";

  // items stores object instances
  private ItemStore<T> items;

  // indices stores objects' key by their indices
  private final ConcurrentMap<String, Index<T>> indices = new ConcurrentHashMap<>();

  public CacheImpl() {
    this(NAMESPACE_INDEX, Cache::metaNamespaceIndexFunc, Cache::metaNamespaceKeyFunc);
  }

  public CacheImpl(String indexName, Function<T, List<String>> indexFunc, Function<T, String> keyFunc) {
    this.items = new BasicItemStore<>(keyFunc);
    addIndexFunc(indexName, indexFunc);
  }

  public void setItemStore(ItemStore<T> items) {
    this.items = items;
  }

  /**
   * Returns the indexers registered with the cache.
   *
   * @return registered indexers
   */
  @Override
  public synchronized Map<String, Function<T, List<String>>> getIndexers() {
    return Collections
        .unmodifiableMap(indices.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().indexer)));
  }

  @Override
  public synchronized void addIndexers(Map<String, Function<T, List<String>>> indexersNew) {
    Set<String> intersection = new HashSet<>(indices.keySet());
    intersection.retainAll(indexersNew.keySet());
    if (!intersection.isEmpty()) {
      throw new IllegalArgumentException("Indexer conflict: " + intersection);
    }

    for (Map.Entry<String, Function<T, List<String>>> indexEntry : indexersNew.entrySet()) {
      addIndexFunc(indexEntry.getKey(), indexEntry.getValue());
    }
  }

  /**
   * Update the object.
   *
   * @param obj the object
   * @return the old object
   */
  public synchronized T put(T obj) {
    if (obj == null) {
      return null;
    }
    String key = getKey(obj);
    T oldObj = this.items.put(key, obj);
    this.updateIndices(oldObj, obj, key);
    return oldObj;
  }

  /**
   * Delete the object.
   *
   * @param obj object
   * @return the old object
   */
  public synchronized T remove(T obj) {
    String key = getKey(obj);
    T old = this.items.remove(key);
    if (old != null) {
      this.updateIndices(old, null, key);
    }
    return old;
  }

  /**
   * List keys
   *
   * @return the list of keys
   */
  @Override
  public List<String> listKeys() {
    return this.items.keySet().collect(Collectors.toList());
  }

  /**
   * Get object
   *
   * @param obj the object
   * @return the object
   */
  @Override
  public T get(T obj) {
    String key = getKey(obj);
    return this.getByKey(key);
  }

  /**
   * Get the key for the given object
   */
  @Override
  public String getKey(T obj) {
    String result = this.items.getKey(obj);
    return nullAsEmpty(result);
  }

  private static String nullAsEmpty(String result) {
    return result == null ? "" : result;
  }

  /**
   * List all objects in the cache.
   *
   * @return the list
   */
  @Override
  public List<T> list() {
    return this.items.values().collect(Collectors.toList());
  }

  /**
   * Gets get by key.
   *
   * @param key specific key
   * @return the get by key
   */
  @Override
  public T getByKey(String key) {
    return this.items.get(key);
  }

  /**
   * Get objects
   *
   * @param indexName specific indexing function
   * @param obj object
   * @return the list
   */
  @Override
  public List<T> index(String indexName, T obj) {
    Index<T> index = getIndex(indexName);
    List<String> indexKeys = index.indexer.apply(obj);
    if (indexKeys == null || indexKeys.isEmpty()) {
      return List.of();
    }
    List<T> result = new ArrayList<>();
    Set<String> keys = new HashSet<String>();
    for (String indexKey : indexKeys) {
      byIndex(index, indexKey, result, keys);
    }

    return result;
  }

  private Index<T> getIndex(String indexName) {
    return Optional.ofNullable(this.indices.get(indexName))
        .orElseThrow(() -> new IllegalArgumentException(String.format("index %s doesn't exist!", indexName)));
  }

  /**
   * Index keys list
   *
   * @param indexName specific indexing function
   * @param indexKey specific index key
   * @return the list
   */
  @Override
  public List<String> indexKeys(String indexName, String indexKey) {
    return byIndex(indexName, indexKey).stream().map(this::getKey).collect(Collectors.toList());
  }

  /**
   * By index list
   *
   * @param indexName specific indexing function
   * @param indexKey specific index key
   * @return the list
   */
  @Override
  public List<T> byIndex(String indexName, String indexKey) {
    List<T> result = new ArrayList<>();
    byIndex(getIndex(indexName), indexKey, result, null);
    return result;
  }

  private void byIndex(Index<T> index, String indexKey, List<T> result, Set<String> visitedKeys) {
    Map<String, String> objs = index.get(indexKey);
    for (Map.Entry<String, String> entry : objs.entrySet()) {
      if (visitedKeys != null && !visitedKeys.add(entry.getKey())) {
        continue;
      }
      T item = this.items.get(entry.getKey());
      if (item != null) {
        if (!Objects.equals(nullAsEmpty(item.getMetadata().getResourceVersion()), entry.getValue())) {
          List<String> values = index.indexer.apply(item);
          if (values == null || !values.contains(indexKey)) {
            continue; // out-of-date
          }
        }
        result.add(item);
      }
    }
  }

  /**
   * UpdateIndices modifies the objects location in the managed indexes, if there is
   * an update, you must provide an oldObj
   *
   *
   * @param oldObj old object
   * @param newObj new object
   * @param key the key
   */
  private void updateIndices(T oldObj, T newObj, String key) {
    indices.values().forEach(i -> updateIndex(key, oldObj, newObj, i));
  }

  private void updateIndex(String key, T oldObj, T newObj, Index<T> index) {
    List<String> oldValues = getIndexValues(oldObj, index.indexer);
    Collection<String> newIndexValues = new LinkedHashSet<>(getIndexValues(newObj, index.indexer));
    for (String indexValue : oldValues) {
      if (!newIndexValues.contains(indexValue)) {
        index.update(indexValue, key, null, true);
      }
    }
    for (String indexValue : newIndexValues) {
      index.update(indexValue, key, newObj.getMetadata().getResourceVersion(), false);
    }
  }

  private List<String> getIndexValues(T obj, Function<T, List<String>> indexFunc) {
    if (obj != null) {
      List<String> values = indexFunc.apply(obj);
      if (values != null) {
        return values;
      }
    }
    return List.of();
  }

  /**
   * Add index func.
   *
   * @param indexName the index name
   * @param indexFunc the index func
   */
  public synchronized CacheImpl<T> addIndexFunc(String indexName, Function<T, List<String>> indexFunc) {
    if (this.indices.containsKey(indexName)) {
      throw new IllegalArgumentException("Indexer conflict: " + indexName);
    }
    Index<T> index = new Index<>(indexFunc);
    this.indices.put(indexName, index);

    items.values().forEach(v -> updateIndex(getKey(v), null, v, index));
    return this;
  }

  /**
   * It's is a convenient default KeyFunc which know show to make keys for API
   * objects which implement HasMetadata interface. The key uses the format
   * namespace/name unless namespace is empty, then it's just name
   *
   * @param obj specific object
   * @return the key
   */
  public static String metaNamespaceKeyFunc(Object obj) {
    if (obj == null) {
      return "";
    }
    ObjectMeta metadata = null;
    if (obj instanceof String) {
      return (String) obj;
    } else if (obj instanceof ObjectMeta) {
      metadata = (ObjectMeta) obj;
    } else if (obj instanceof HasMetadata) {
      metadata = ((HasMetadata) obj).getMetadata();
    }
    if (metadata == null) {
      throw new RuntimeException("Object is bad :" + obj);
    }

    return namespaceKeyFunc(metadata.getNamespace(), metadata.getName());
  }

  /**
   * Default index function that indexes based on an object's namespace and name.
   *
   * @see #metaNamespaceKeyFunc
   */
  public static String namespaceKeyFunc(String objectNamespace, String objectName) {
    if (Utils.isNullOrEmpty(objectNamespace)) {
      return objectName;
    }
    return objectNamespace + "/" + objectName;
  }

  /**
   * It is a default index function that indexes based on an object's namespace
   *
   * @param obj the specific object
   * @return the indexed value
   */
  public static List<String> metaNamespaceIndexFunc(Object obj) {
    final ObjectMeta metadata;
    if (obj instanceof HasMetadata) {
      metadata = ((HasMetadata) obj).getMetadata();
    } else if (obj instanceof ObjectMeta) {
      metadata = (ObjectMeta) obj;
    } else {
      metadata = null;
    }
    return metadata == null ? Collections.emptyList() : Collections.singletonList(metadata.getNamespace());
  }

  @Override
  public synchronized void removeIndexer(String name) {
    this.indices.remove(name);
  }

  public boolean isFullState() {
    return items.isFullState();
  }

  public Object getLockObject() {
    return this;
  }

}
