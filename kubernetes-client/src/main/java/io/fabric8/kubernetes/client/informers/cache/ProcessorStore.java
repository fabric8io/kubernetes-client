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

/**
 * Wraps a {@link Cache} and a {@link SharedProcessor} to distribute events related to changes and syncs
 */
public class ProcessorStore<T> implements SyncableStore<T> {

  private Cache<T> cache;
  private SharedProcessor<T> processor;

  public ProcessorStore(Cache<T> cache, SharedProcessor<T> processor) {
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
      this.processor.distribute(new ProcessorListener.UpdateNotification<>(oldObj, obj), false);
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
  public void replace(List<T> list) {
    Map<String, T> oldState = cache.replace(list);
    
    if (list.isEmpty() && oldState.isEmpty()) {
      this.processor.distribute(l -> l.getHandler().onNothing(), false);      
    }

    // now that the store is up-to-date, process the notifications
    for (T newValue : list) {
      T old = oldState.remove(cache.getKey(newValue));
      if (old == null) {
        this.processor.distribute(new ProcessorListener.AddNotification<>(newValue), true);
      } else {
        this.processor.distribute(new ProcessorListener.UpdateNotification<>(old, newValue), true);
      }
    }
    // deletes are not marked as sync=true in keeping with the old code
    oldState.values()
        .forEach(old -> this.processor.distribute(new ProcessorListener.DeleteNotification<>(old, true), false));
  }

  @Override
  public void resync() {
    this.cache.list()
        .forEach(i -> this.processor.distribute(new ProcessorListener.UpdateNotification<>(i, i), true));
  }

}
