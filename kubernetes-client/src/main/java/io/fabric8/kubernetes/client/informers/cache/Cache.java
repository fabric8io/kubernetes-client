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

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.ReflectUtils;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * It basically saves and indexes all the entries.
 *
 * @param <T> type for cache object
 */
public class Cache<T> implements Indexer<T> {
  // Defines how to map objects into indices
  private Function<T, String> keyFunc;

  // NAMESPACE_INDEX is the default index function for caching objects
  public static final String NAMESPACE_INDEX = "namespace";

  // indexers stores index functions by their names
  private Map<String, Function<T, List<String>>> indexers = new HashMap<>();

  // items stores object instances
  private Map<String, T> items = new HashMap<>();

  // indices stores objects' key by their indices
  private Map<String, Map<String, Set<String>>> indices = new HashMap<>();

  public Cache() {
    this(NAMESPACE_INDEX, Cache::metaNamespaceIndexFunc, Cache::deletionHandlingMetaNamespaceKeyFunc);
  }

  public Cache(String indexName, Function<T, List<String>> indexFunc, Function<T, String> keyFunc) {
    this.indexers.put(indexName, indexFunc);
    this.keyFunc = keyFunc;
    this.indices.put(indexName, new HashMap<>());
  }

  /**
   * Add objects
   *
   * @param obj object
   */
  @Override
  public synchronized void add(T obj) {
    String key = keyFunc.apply(obj);
    T oldObj = this.items.get(key);
    this.items.put(key, obj);
    this.updateIndices(oldObj, obj, key);
  }

  /**
   * Returns the indexers registered with the cache.
   *
   * @return registered indexers
   */
  @Override
  public Map<String, Function<T, List<String>>> getIndexers() {
    return indexers;
  }

  @Override
  public void addIndexers(Map<String, Function<T, List<String>>> indexersNew) {
    if (!items.isEmpty()) {
      throw new IllegalStateException("Cannot add indexers to a Cache which is not empty");
    }

    Set<String> intersection = new HashSet<>(indexers.keySet());
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
   */
  @Override
  public synchronized void update(T obj) {
    String key = keyFunc.apply(obj);
    T oldObj = this.items.get(key);
    this.items.put(key, obj);
    this.updateIndices(oldObj, obj, key);
  }

  /**
   * Delete the object.
   *
   * @param obj object
   */
  @Override
  public synchronized void delete(T obj) {
    String key = keyFunc.apply(obj);
    boolean exists = this.items.containsKey(key);
    if (exists) {
      this.deleteFromIndices(this.items.get(key), key);
      this.items.remove(key);
    }
  }

  /**
   * Replace the content in the cache completely.
   *
   * @param list list of objects
   * @param resourceVersion resource version
   */
  @Override
  public synchronized void replace(List<T> list, String resourceVersion) {
    Map<String, T> newItems = new HashMap<>();
    for (T item : list) {
      String key = keyFunc.apply(item);
      newItems.put(key, item);
    }
    this.items = newItems;

    // rebuild any index
    this.indices = new HashMap<>();
    for (Map.Entry<String, T> itemEntry : items.entrySet()) {
      this.updateIndices(null, itemEntry.getValue(), itemEntry.getKey());
    }
  }

  /**
   * Resync
   */
  @Override
  public void resync() {
    // Do nothing
  }

  /**
   * List keys
   *
   * @return the list of keys
   */
  @Override
  public synchronized List<String> listKeys() {
    List<String> keys = new ArrayList<>(this.items.size());
    for (Map.Entry<String, T> entry : this.items.entrySet()) {
      keys.add(entry.getKey());
    }
    return keys;
  }

  /**
   * Get object
   *
   * @param obj the object
   * @return the object
   */
  @Override
  public synchronized T get(T obj) {
    String key = this.keyFunc.apply(obj);
    return this.getByKey(key);
  }

  /**
   * List all objects in the cache.
   *
   * @return the list
   */
  @Override
  public synchronized List<T> list() {
    List<T> itemList = new ArrayList<>(this.items.size());
    for (Map.Entry<String, T> entry : this.items.entrySet()) {
      itemList.add(entry.getValue());
    }
    return itemList;
  }

  /**
   * Gets get by key.
   *
   * @param key specific key
   * @return the get by key
   */
  @Override
  public synchronized T getByKey(String key) {
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
  public synchronized List<T> index(String indexName, Object obj) {
    if (!this.indexers.containsKey(indexName)) {
      throw new IllegalArgumentException(String.format("index %s doesn't exist!", indexName));
    }
    Function<T, List<String>> indexFunc = this.indexers.get(indexName);
    List<String> indexKeys = indexFunc.apply((T) obj);
    Map<String, Set<String>> index = this.indices.get(indexName);
    if (index.isEmpty()) {
      return new ArrayList<>();
    }

    Set<String> returnKeySet = new HashSet<>();
    for (String indexKey : indexKeys) {
      Set<String> set = index.get(indexKey);
      if (set.isEmpty()) {
        continue;
      }
      returnKeySet.addAll(set);
    }

    List<T> items = new ArrayList<>(returnKeySet.size());
    for (String absoluteKey : returnKeySet) {
      items.add(this.items.get(absoluteKey));
    }
    return items;
  }

  /**
   * Index keys list
   *
   * @param indexName specific indexing function
   * @param indexKey specific index key
   * @return the list
   */
  @Override
  public synchronized List<String> indexKeys(String indexName, String indexKey) {
    if (!this.indexers.containsKey(indexName)) {
      throw new IllegalArgumentException(String.format("index %s doesn't exist!", indexName));
    }
    Map<String, Set<String>> index = this.indices.get(indexName);
    Set<String> set = index.get(indexKey);
    List<String> keys = new ArrayList<>(set.size());
    for (String key : set) {
      keys.add(key);
    }
    return keys;
  }

  /**
   * By index list
   *
   * @param indexName specific indexing function
   * @param indexKey specific index key
   * @return the list
   */
  @Override
  public synchronized List<T> byIndex(String indexName, String indexKey) {
    if (!this.indexers.containsKey(indexName)) {
      throw new IllegalArgumentException(String.format("index %s doesn't exist!", indexName));
    }
    Map<String, Set<String>> index = this.indices.get(indexName);
    Set<String> set = index.get(indexKey);
    if (set == null) {
      return Arrays.asList();
    }
    List<T> items = new ArrayList<>(set.size());
    for (String key : set) {
      items.add(this.items.get(key));
    }
    return items;
  }

  @Override
  public void isPopulated(boolean isPopulated) {
    // Do nothing
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
  public void updateIndices(T oldObj, T newObj, String key) {
    if (oldObj != null) {
      deleteFromIndices(oldObj, key);
    }

    for (Map.Entry<String, Function<T, List<String>>> indexEntry : indexers.entrySet()) {
      String indexName = indexEntry.getKey();
      Function<T, List<String>> indexFunc = indexEntry.getValue();
      List<String> indexValues = indexFunc.apply(newObj);
      if (indexValues == null || indexValues.isEmpty()) {
        continue;
      }

      Map<String, Set<String>> index = this.indices.computeIfAbsent(indexName, k -> new HashMap<>());
      for (String indexValue : indexValues) {
        Set<String> indexSet = index.computeIfAbsent(indexValue, k -> new HashSet<>());
        indexSet.add(key);
      }
    }
  }

  /**
   * Removes the object from each of the managed indexes.
   *
   * It is intended to be called from a function that already has a lock on the cache.
   *
   * @param oldObj the old object
   * @param key the key
   */
  private void deleteFromIndices(T oldObj, String key) {
    for (Map.Entry<String, Function<T, List<String>>> indexEntry : this.indexers.entrySet()) {
      Function<T, List<String>> indexFunc = indexEntry.getValue();
      List<String> indexValues = indexFunc.apply(oldObj);
      if (indexValues == null || indexValues.isEmpty()) {
        continue;
      }

      Map<String, Set<String>> index = this.indices.get(indexEntry.getKey());
      if (index == null) {
        continue;
      }
      for (String indexValue : indexValues) {
        Set<String> indexSet = index.get(indexValue);
        if (indexSet != null) {
          indexSet.remove(key);
        }
      }
    }
  }

  /**
   * Add index func.
   *
   * @param indexName the index name
   * @param indexFunc the index func
   */
  public void addIndexFunc(String indexName, Function<T, List<String>> indexFunc) {
    this.indices.put(indexName, new HashMap<>());
    this.indexers.put(indexName, indexFunc);
  }

  /**
   * Checks for DeletedFinalStateUnknown objects before calling metaNamespaceKeyFunc
   *
   * @param object the specific object
   * @param <T> object type
   * @return the key
   */
  public static <T> String deletionHandlingMetaNamespaceKeyFunc(T object) {
    if (object instanceof DeltaFIFO.DeletedFinalStateUnknown) {
      DeltaFIFO.DeletedFinalStateUnknown deleteObj = (DeltaFIFO.DeletedFinalStateUnknown) object;
      return deleteObj.getKey();
    }
    return metaNamespaceKeyFunc(object);
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
    try {
      if( obj == null ) {
        return "";
      }
      ObjectMeta metadata;
      if(obj instanceof String) {
        return (String) obj;
      } else if (obj instanceof ObjectMeta) {
        metadata = (ObjectMeta) obj;
      } else {
        metadata = ReflectUtils.objectMetadata(obj);
        if (metadata == null) {
          throw new RuntimeException("Object is bad :" + obj);
        }
      }

      return namespaceKeyFunc(metadata.getNamespace(), metadata.getName());
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
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
    try {
      ObjectMeta metadata = ReflectUtils.objectMetadata(obj);
      return metadata == null ? Collections.emptyList() : Collections.singletonList(metadata.getNamespace());
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }
}

