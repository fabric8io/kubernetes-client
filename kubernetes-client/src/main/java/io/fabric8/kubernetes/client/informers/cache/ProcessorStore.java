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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Wraps a {@link Store} to distribute events related to changes and syncs 
 * @param <T>
 */
public class ProcessorStore<T> implements Store<T> {

  private Store<T> actualStore;
  private SharedProcessor<T> processor;
  private volatile boolean populated;

  public ProcessorStore(Store<T> actualStore, SharedProcessor<T> processor) {
    this.actualStore = actualStore;
    this.processor = processor;
  }

  @Override
  public void add(T obj) {
    update(obj, false);
  }

  @Override
  public void update(T obj) {
    update(obj, false);
  }

  private synchronized void update(T obj, boolean sync) {
    Object oldObj = this.actualStore.get(obj);
    if (oldObj != null) {
      this.actualStore.update(obj);
      this.processor.distribute(new ProcessorListener.UpdateNotification(oldObj, obj), sync);
    } else {
      this.actualStore.add(obj);
      this.processor.distribute(new ProcessorListener.AddNotification(obj), sync);
    }
  }

  @Override
  public synchronized void delete(T obj) {
    Object oldObj = this.actualStore.get(obj);
    if (oldObj != null) {
      this.actualStore.delete(obj);
      this.processor.distribute(new ProcessorListener.DeleteNotification(obj, false), false);
    }
  }

  @Override
  public List<T> list() {
    return actualStore.list();
  }

  @Override
  public List<String> listKeys() {
    return actualStore.listKeys();
  }

  @Override
  public Object get(T object) {
    return actualStore.get(object);
  }

  @Override
  public T getByKey(String key) {
    return actualStore.getByKey(key);
  }

  @Override
  public synchronized void replace(List<T> list, String resourceVersion) {
    Set<String> keys = new HashSet<>();
    for (T obj : list) {
      keys.add(Cache.metaNamespaceKeyFunc(obj));
      update(obj, true);
    }
    for (T obj : actualStore.list()) {
      if (!keys.contains(Cache.metaNamespaceKeyFunc(obj))) {
        this.processor.distribute(new ProcessorListener.DeleteNotification(obj, true), false);
      }
    }
    actualStore.replace(list, resourceVersion);
    populated = true;
  }

  @Override
  public void resync() {
    this.actualStore.list()
        .forEach(i -> this.processor.distribute(new ProcessorListener.UpdateNotification<T>(i, i), true));
  }

  @Override
  public void isPopulated(boolean isPopulated) {
    this.populated = isPopulated;
  }

  @Override
  public boolean hasSynced() {
    return populated;
  }

}
