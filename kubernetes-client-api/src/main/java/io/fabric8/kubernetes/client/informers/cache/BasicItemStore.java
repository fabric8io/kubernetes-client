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

import io.fabric8.kubernetes.api.model.HasMetadata;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Stream;

public class BasicItemStore<V extends HasMetadata> implements ItemStore<V> {

  private Function<V, String> keyFunction;
  private ConcurrentHashMap<String, V> store = new ConcurrentHashMap<>();

  public BasicItemStore(Function<V, String> keyFunction) {
    this.keyFunction = keyFunction;
  }

  @Override
  public String getKey(V obj) {
    return keyFunction.apply(obj);
  }

  @Override
  public V put(String key, V obj) {
    return store.put(key, obj);
  }

  @Override
  public V remove(String key) {
    return store.remove(key);
  }

  @Override
  public Stream<String> keySet() {
    return store.keySet().stream();
  }

  @Override
  public Stream<V> values() {
    return store.values().stream();
  }

  @Override
  public V get(String key) {
    return store.get(key);
  }

  @Override
  public int size() {
    return store.size();
  }

}
