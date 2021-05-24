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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Wraps a {@link Store} to distribute events related to changes and syncs 
 * @param <T>
 */
public class ProcessorStore<T> implements Store<T> {
  
  private static final Logger log = LoggerFactory.getLogger(ProcessorStore.class);

  private Store<T> actualStore;
  private SharedProcessor<T> processor;
  private volatile boolean populated;

  public ProcessorStore(Store<T> actualStore, SharedProcessor<T> processor) {
    this.actualStore = actualStore;
    this.processor = processor;
  }

  @Override
  public void add(T obj) {
    update(obj);
  }

  @Override
  public synchronized void update(T obj) {
    Object oldObj = this.actualStore.get(obj);
    if (oldObj != null) {
      this.actualStore.update(obj);
      this.processor.distribute(new ProcessorListener.UpdateNotification(oldObj, obj), false);
    } else {
      this.actualStore.add(obj);
      this.processor.distribute(new ProcessorListener.AddNotification(obj), false);
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
    // it shouldn't happen, but it's possible for metaNamespaceKeyFunc to return null, so manually collect
    Map<String, T> oldState = new HashMap<>();
    actualStore.list().stream().forEach(old -> oldState.put(Cache.metaNamespaceKeyFunc(old), old));

    actualStore.replace(list, resourceVersion);
    populated = true;
    
    // now that the store is up-to-date, process the notifications
    for (T newValue : list) {
      T old = oldState.remove(Cache.metaNamespaceKeyFunc(newValue));
      if (old == null) {
        this.processor.distribute(new ProcessorListener.AddNotification(newValue), true);
      } else {
        this.processor.distribute(new ProcessorListener.UpdateNotification(old, newValue), true);
      }
    }
    // deletes are not marked as sync=true in keeping with the old code
    oldState.values()
        .forEach(old -> this.processor.distribute(new ProcessorListener.DeleteNotification(old, true), false));
  }

  @Override
  public void resync() {
    log.debug("resync");
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
