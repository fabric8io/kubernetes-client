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

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Wraps a {@link Cache} and a {@link SharedProcessor} to distribute events related to changes and syncs
 */
public class ProcessorStore<T extends HasMetadata> implements SyncableStore<T> {

  private CacheImpl<T> cache;
  private SharedProcessor<T> processor;

  public ProcessorStore(CacheImpl<T> cache, SharedProcessor<T> processor) {
    this.cache = cache;
    this.processor = processor;
  }

  @Override
  public void add(T obj) {
    update(obj);
  }

  @Override
  public void update(T obj) {
    T oldObj = this.cache.put(obj);
    if (oldObj != null) {
      this.processor.distribute(new ProcessorListener.UpdateNotification<>(oldObj, obj),
          Objects.equals(oldObj.getMetadata().getResourceVersion(), obj.getMetadata().getResourceVersion()));
    } else {
      this.processor.distribute(new ProcessorListener.AddNotification<>(obj), false);
    }
  }

  @Override
  public void delete(T obj) {
    Object oldObj = this.cache.remove(obj);
    if (oldObj != null) {
      this.processor.distribute(new ProcessorListener.DeleteNotification<>(obj, false), false);
    }
  }

  @Override
  public List<T> list() {
    return cache.list();
  }

  @Override
  public List<String> listKeys() {
    return cache.listKeys();
  }

  @Override
  public T get(T object) {
    return cache.get(object);
  }

  @Override
  public T getByKey(String key) {
    return cache.getByKey(key);
  }

  @Override
  public void retainAll(Set<String> nextKeys) {
    List<T> current = cache.list();
    if (nextKeys.isEmpty() && current.isEmpty()) {
      this.processor.distribute(l -> l.getHandler().onNothing(), false);
      return;
    }
    current.forEach(v -> {
      String key = cache.getKey(v);
      if (!nextKeys.contains(key)) {
        cache.remove(v);
        this.processor.distribute(new ProcessorListener.DeleteNotification<>(v, true), false);        
      }
    });
  }
  
  @Override
  public String getKey(T obj) {
    return cache.getKey(obj);
  }

  @Override
  public void resync() {
    this.cache.list()
        .forEach(i -> this.processor.distribute(new ProcessorListener.UpdateNotification<>(i, i), true));
  }

}
