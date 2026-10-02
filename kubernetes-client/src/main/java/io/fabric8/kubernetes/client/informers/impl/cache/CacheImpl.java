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
import java.util.HashMap;
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

  /**
   * One index: the keys and resource versions recorded under each index value, plus the reverse record of the
   * buckets each key is in. Invariant: {@code bucketsByKey} holds a key if and only if {@code values} holds it,
   * in exactly those buckets.
   * <p>
   * {@code values} is read without the {@link CacheImpl} monitor, {@code bucketsByKey} only under it.
   */
  private static class Index<T extends HasMetadata> {

    private final Function<T, List<String>> indexer;
    private final Map<Object, Map<String, String>> values = new ConcurrentHashMap<>();
    private final Map<String, Set<Object>> bucketsByKey = new HashMap<>();

    public Index(Function<T, List<String>> indexer) {
      this.indexer = indexer;
    }

    /**
     * Records the key in the buckets of the given index values and removes it from the buckets it was recorded
     * in before. The old buckets come from that record rather than from a previous version of the object, so a
     * key is cleaned up correctly even if the object was mutated in place or is no longer available.
     *
     * @param key the key
     * @param indexValues the index values of the object, possibly empty
     * @param resourceVersion the resource version of the object, ignored when there are no index values
     */
    public void put(String key, Collection<String> indexValues, String resourceVersion) {
      Set<Object> buckets = buckets(indexValues);
      Set<Object> previous = buckets.isEmpty() ? bucketsByKey.remove(key) : bucketsByKey.put(key, buckets);
      if (previous != null) {
        for (Object bucket : previous) {
          if (!buckets.contains(bucket)) {
            removeFrom(bucket, key);
          }
        }
      }
      for (Object bucket : buckets) {
        values.computeIfAbsent(bucket, k -> new ConcurrentHashMap<>()).put(key, nullAsEmpty(resourceVersion));
      }
    }

    public void remove(String key) {
      Set<Object> previous = bucketsByKey.remove(key);
      if (previous != null) {
        previous.forEach(bucket -> removeFrom(bucket, key));
      }
    }

    public Map<String, String> get(String indexKey) {
      return values.getOrDefault(bucket(indexKey), Map.of());
    }

    /**
     * The result is free of nulls and duplicates, since {@link #bucket(String)} maps a null index value to this
     * index and the multi value case deduplicates before collapsing, so the immutable {@link Set#of} forms are
     * safe.
     */
    private Set<Object> buckets(Collection<String> indexValues) {
      if (indexValues.isEmpty()) {
        return Set.of();
      }
      if (indexValues.size() == 1) {
        return Set.of(bucket(indexValues.iterator().next()));
      }
      Set<Object> buckets = new LinkedHashSet<>();
      for (String indexValue : indexValues) {
        buckets.add(bucket(indexValue));
      }
      return buckets.size() == 1 ? Set.of(buckets.iterator().next()) : buckets;
    }

    private void removeFrom(Object bucket, String key) {
      values.computeIfPresent(bucket, (k, v) -> {
        v.remove(key);
        return v.isEmpty() ? null : v;
      });
    }

    private Object bucket(String indexKey) {
      return indexKey == null ? this : indexKey;
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
        .unmodifiableMap(indices.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().indexer)));
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
    this.updateIndices(obj, key);
    return oldObj;
  }

  /**
   * Delete the object. The index entries of its key are removed even if the {@link ItemStore} no longer
   * holds the object.
   *
   * @param obj object
   * @return the old object, or {@code null} if the {@link ItemStore} did not hold it
   */
  public synchronized T remove(T obj) {
    String key = getKey(obj);
    T old = this.items.remove(key);
    indices.values().forEach(index -> index.remove(key));
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
    Set<String> keys = new HashSet<>();
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
      T item = this.items.get(entry.getKey());
      if (item == null) {
        continue;
      }
      if (!Objects.equals(nullAsEmpty(item.getMetadata().getResourceVersion()), entry.getValue())) {
        List<String> values = index.indexer.apply(item);
        if (values == null || !values.contains(indexKey)) {
          continue; // out-of-date
        }
      }
      // Dedup only after the entry is accepted: a stale entry that fails the
      // consistency check above must not block a legitimate match in another
      // bucket from being recorded under the same key.
      if (visitedKeys != null && !visitedKeys.add(entry.getKey())) {
        continue;
      }
      result.add(item);
    }
  }

  /**
   * Records the key in every managed index, under the index values its indexer returns for the object.
   *
   * @param obj the object
   * @param key the key
   */
  private void updateIndices(T obj, String key) {
    indices.values().forEach(index -> updateIndex(key, obj, index));
  }

  private void updateIndex(String key, T obj, Index<T> index) {
    List<String> indexValues = getIndexValues(obj, index.indexer);
    index.put(key, indexValues, indexValues.isEmpty() ? null : obj.getMetadata().getResourceVersion());
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

    items.values().forEach(v -> updateIndex(getKey(v), v, index));
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
