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

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * By default an informer stores every item that exists in memory.
 * If that is too much memory for your application,
 * you may instead reduce what is actually stored by using this item store.
 */
public class ReducedStateItemStore<V extends HasMetadata> implements ItemStore<V> {

  private static final String METADATA = "metadata";
  private final ConcurrentHashMap<String, Object[]> store = new ConcurrentHashMap<>();
  private final List<String[]> fields = new ArrayList<>();
  private final Class<V> typeClass;
  private final KeyState keyState;
  private KubernetesSerialization serialization;

  public static class KeyState {

    final Function<HasMetadata, String> keyFunction;
    final Function<String, String[]> keyFieldFunction;
    final List<String[]> keyFields;

    /**
     * The key function must decompose a given key into the given fields - in field order
     *
     * @param keyFieldFunction to convert a key into fields
     * @param keyFields the fields represented by the key
     */
    public KeyState(Function<HasMetadata, String> keyFunction, Function<String, String[]> keyFieldFunction,
        String[]... keyFields) {
      this.keyFunction = keyFunction;
      this.keyFieldFunction = keyFieldFunction;
      this.keyFields = Arrays.asList(keyFields);
    }

  }

  public static final KeyState NAME_KEY_STATE = new KeyState(Cache::metaNamespaceKeyFunc,
      k -> {
        int index = k.indexOf("/");
        if (index == -1) {
          return new String[] { null, k };
        }
        return new String[] { k.substring(0, index), k.substring(index + 1) };
      }, new String[] { METADATA, "namespace" }, new String[] { METADATA, "name" });

  public static final KeyState UID_KEY_STATE = new KeyState(Cache::metaUidKeyFunc,
      k -> new String[] { k }, new String[] { METADATA, "uid" });

  /**
   * Create a state store with only the fields specified.
   * <p>
   * metadata.resourceVersion - will automatically be saved as will
   * the necessary key fields.
   * <p>
   * If you are using custom indexers, then the fields used by those
   * indexes must be added to the valueFields - otherwise the indexer won't be able to delete the
   * index entries when the item is removed.
   * <p>
   * For example in level event handling systems all you may need beyond the
   * key is the ownerReferences. You would use withValueFields("metadata.ownerReferences")
   * for that.
   * <p>
   * NOTE: If you use this feature, you should only use the informer cache/store for basic
   * existence checks and maintain your own cache of full resource objects.
   * <p>
   * Only simple names are allowed in field paths - '.' is reserved as the separator.
   * <p>
   * Whatever is provided as the {@link KeyState} should match the keyFunction provided to the informer.
   *
   * @param keyState information about the key fields/function
   * @param typeClass the expected type
   * @param valueFields the additional fields to save
   */
  public ReducedStateItemStore(KeyState keyState, Class<V> typeClass, KubernetesSerialization serialization,
      String... valueFields) {
    this.keyState = keyState;
    fields.add(new String[] { METADATA, "resourceVersion" });
    if (valueFields != null) {
      for (int i = 0; i < valueFields.length; i++) {
        fields.add(valueFields[i].split("\\."));
      }
    }
    this.typeClass = typeClass;
    this.serialization = serialization;
  }

  Object[] store(V value) {
    if (value == null) {
      return null;
    }
    Map<String, Object> raw = serialization.convertValue(value, Map.class);
    return fields.stream().map(f -> GenericKubernetesResource.get(raw, (Object[]) f)).toArray();
  }

  V restore(String key, Object[] values) {
    if (values == null) {
      return null;
    }
    Map<String, Object> raw = new HashMap<>();
    applyFields(values, raw, this.fields);
    String[] keyParts = this.keyState.keyFieldFunction.apply(key);
    applyFields(keyParts, raw, this.keyState.keyFields);

    return serialization.convertValue(raw, typeClass);
  }

  private static void applyFields(Object[] values, Map<String, Object> raw, List<String[]> fields) {
    for (int i = 0; i < fields.size(); i++) {
      Object value = values[i];
      if (value == null) {
        continue;
      }
      String[] path = fields.get(i);
      Map<String, Object> parent = raw;
      for (int j = 0; j < path.length - 1; j++) {
        parent = (Map<String, Object>) parent.computeIfAbsent(path[j], k -> new LinkedHashMap<String, Object>());
      }
      parent.put(path[path.length - 1], value);
    }
  }

  @Override
  public V put(String key, V obj) {
    return restore(key, store.put(key, store(obj)));
  }

  @Override
  public V remove(String key) {
    return restore(key, store.remove(key));
  }

  @Override
  public Stream<String> keySet() {
    return store.keySet().stream();
  }

  @Override
  public Stream<V> values() {
    return store.entrySet().stream().map(e -> restore(e.getKey(), e.getValue()));
  }

  @Override
  public V get(String key) {
    return restore(key, store.get(key));
  }

  public String getResourceVersion(String key) {
    return (String) store.getOrDefault(key, new Object[1])[0];
  }

  @Override
  public int size() {
    return store.size();
  }

  @Override
  public String getKey(V obj) {
    return this.keyState.keyFunction.apply(obj);
  }

  @Override
  public boolean isFullState() {
    return false;
  }

}
