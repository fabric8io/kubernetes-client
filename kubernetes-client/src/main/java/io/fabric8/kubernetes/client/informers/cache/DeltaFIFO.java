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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * The DeltaFIFO inherits from an Object queue since that we're actually
 * reading from it as Deltas but writing it as Kubernetes object.
 *
 * This is taken from official client: https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/cache/DeltaFIFO.java
 * which is ported from official go client: https://github.com/kubernetes/client-go/blob/master/tools/cache/delta_fifo.go
 *
 * Updated to be more type safe, and to take ownership of the lastResourceVersion
 */
public class DeltaFIFO<T extends HasMetadata> implements Store<T, Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>>> {
  private static final Logger log = LoggerFactory.getLogger(DeltaFIFO.class);

  private Function<T, String> keyFunc;

  /**
   * Mapping deltas with key by calling keyFunc
   */
  private Map<String, Deque<AbstractMap.SimpleEntry<DeltaType, Object>>> items;

  /**
   * an underlying queue storing incoming items' keys
   */
  private Deque<String> queue;

  private Store<T, T> knownObjects;

  /**
   * Populated is true if the first batch of items inserted by Replace() has been
   * populated or Delete/Add/Update was called first.
   */
  private boolean populated = false;

  /**
   * It's the number of items inserted by the first call of Replace()
   */
  private int initialPopulationCount;

  /**
   * For thread safety
   */
  private ReadWriteLock lock = new ReentrantReadWriteLock();

  /**
   * indicates if the store is empty
   */
  private Condition notEmpty;

  private volatile String lastSyncResourceVersion;

  public DeltaFIFO(Function<T, String> keyFunc, Store<T, T> knownObjects) {
    this.keyFunc = keyFunc;
    this.knownObjects = knownObjects;
    this.items = new HashMap<>();
    this.queue = new LinkedList<>();
    this.notEmpty = lock.writeLock().newCondition();
  }

  /**
   * Add items to the delta FIFO.
   *
   * @param obj object
   */
  @Override
  public void add(T obj) {
    lock.writeLock().lock();
    lastSyncResourceVersion = obj.getMetadata().getResourceVersion();
    try {
      populated = true;
      this.queueActionLocked(DeltaType.ADDITION, obj);
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * Update items in delta FIFO
   *
   * @param obj object
   */
  @Override
  public void update(T obj) {
    lock.writeLock().lock();
    lastSyncResourceVersion = obj.getMetadata().getResourceVersion();
    try {
      populated = true;
      this.queueActionLocked(DeltaType.UPDATION, obj);
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * Delete items from the delta FIFO
   *
   * @param obj object
   */
  @Override
  public void delete(T obj) {
    String id = this.keyOf(obj);
    lock.writeLock().lock();
    lastSyncResourceVersion = obj.getMetadata().getResourceVersion();
    try {
      this.populated = true;
      // We only want to skip the deletion action if the object doesn't
      // exist in the knownObjects and it doesn't have corresponding item
      // in items.
      if (this.knownObjects.getByKey(id) == null && !this.items.containsKey(id)) {
        return;
      }
      this.queueActionLocked(DeltaType.DELETION, obj);
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * Replace the item forcibly.
   *
   * @param list list of objects
   * @param resourceVersion resource version
   */
  public void replace(List<T> list, String resourceVersion) {
    lock.writeLock().lock();
    lastSyncResourceVersion = resourceVersion;
    try {
      Set<String> keys = new HashSet<>();
      for (Object obj : list) {
        String key = this.keyOf(obj);
        keys.add(key);
        this.queueActionLocked(DeltaType.SYNCHRONIZATION, obj);
      }

      // Detect deletions not already in the queue.
      List<String> knownKeys = this.knownObjects.listKeys();
      int queueDeletion = 0;
      for (String knownKey : knownKeys) {
        if (keys.contains(knownKey)) {
          continue;
        }

        Object deletedObj = this.knownObjects.getByKey(knownKey);
        if (deletedObj == null) {
          log.warn("Key {} doesn't exist in the known object store, placing DeleteFinalStateUnknown marker without object", knownKey);
        }
        queueDeletion++;
        this.queueActionLocked(DeltaType.DELETION, new DeletedFinalStateUnknown<>(knownKey, deletedObj));
      }

      if (!this.populated) {
        this.populated = true;
        this.initialPopulationCount = list.size() + queueDeletion;
      }
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * Resync the delta FIFO. First, it locks the queue to block any more write
   * operation until it finishes all the pending items in the queue.
   *
   */
  public void resync() {
    lock.writeLock().lock();
    try {
      List<String> keys = this.knownObjects.listKeys();
      for (String key : keys) {
        syncKeyLocked(key);
      }
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * List keys list.
   *
   * @return the list
   */
  @Override
  public List<String> listKeys() {
    lock.readLock().lock();
    try {
      List<String> keyList = new ArrayList<>(items.size());
      for (Map.Entry<String, Deque<AbstractMap.SimpleEntry<DeltaType, Object>>> entry : items.entrySet()) {
        keyList.add(entry.getKey());
      }
      return keyList;
    } finally {
      lock.readLock().unlock();
    }
  }

  /**
   * Get object
   *
   * @param obj the object
   * @return the object
   */
  @Override
  public Deque<SimpleEntry<DeltaType, Object>> get(T obj) {
    String key = this.keyOf(obj);
    return this.getByKey(key);
  }

  /**
   * Gets by key
   *
   * @param key specific key
   * @return the object
   */
  @Override
  public Deque<AbstractMap.SimpleEntry<DeltaType, Object>> getByKey(String key) {
    lock.readLock().lock();
    try {
      Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltas = this.items.get(key);
      if (deltas != null) {
        // return a shallow copy
        return new LinkedList<>(deltas);
      }
    } finally {
      lock.readLock().unlock();
    }
    return null;
  }

  /**
   * List objects
   *
   * @return the list
   */
  @Override
  public List<Deque<SimpleEntry<DeltaType, Object>>> list() {
    lock.readLock().lock();
    List<Deque<SimpleEntry<DeltaType, Object>>> objects = new ArrayList<>();
    try {
      for (Map.Entry<String, Deque<AbstractMap.SimpleEntry<DeltaType, Object>>> entry : items.entrySet()) {
        Deque<AbstractMap.SimpleEntry<DeltaType, Object>> copiedDeltas = new LinkedList<>(entry.getValue());
        objects.add(copiedDeltas);
      }
    } finally {
      lock.readLock().unlock();
    }
    return objects;
  }

  /**
   * @return the last known resource version
   */
  public String getLastSyncResourceVersion() {
    return lastSyncResourceVersion;
  }

  /**
   * Pop Deltas
   *
   * @param func the func
   * @return the deltas
   * @throws InterruptedException interruption exception
   */
  public Deque<AbstractMap.SimpleEntry<DeltaType, Object>> pop(Consumer<Deque<AbstractMap.SimpleEntry<DeltaType, Object>>> func) throws InterruptedException {
    lock.writeLock().lock();
    try {
      while (true) {
        while (queue.isEmpty()) {
          notEmpty.await();
        }

        // There should be data now
        String id = this.queue.removeFirst();
        if (this.initialPopulationCount > 0) {
          this.initialPopulationCount--;
        }
        if (!this.items.containsKey(id)) {
          // Item may have been deleted subsequently
          continue;
        }

        Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltas = this.items.get(id);
        this.items.remove(id);
        func.accept(deltas);
        // Don't make any copyDeltas here
        return deltas;
      }
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * Has synced boolean
   *
   * @return the boolean
   */
  public boolean hasSynced() {
    lock.readLock().lock();
    try {
      return this.populated && this.initialPopulationCount == 0;
    } finally {
      lock.readLock().unlock();
    }
  }

  public void isPopulated(boolean isPopulated) {
    lock.writeLock().lock();
    try {
      this.populated = isPopulated;
    } finally {
      lock.writeLock().unlock();
    }
  }


  /**
   * Exposes f's keyFunc, but also detects the key of a Deltas object or
   * DeletedFinalStateUnknown objects.
   *
   * @param obj object
   * @return key of deltas object
   */
  private String keyOf(Object obj) {
    Object innerObj = obj;
    if (obj instanceof Deque) {
      Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltas = (Deque<AbstractMap.SimpleEntry<DeltaType, Object>>) obj;
      if (deltas.size() == 0) {
        throw new NoSuchElementException("0 length deltas object; can't get key");
      }
      innerObj = deltas.peekLast().getValue();
    }
    if (innerObj instanceof DeletedFinalStateUnknown) {
      return ((DeletedFinalStateUnknown) innerObj).key;
    }
    return keyFunc.apply((T) innerObj);
  }


  /**
   * Appends to the delta list for the object. Caller must hold the lock.
   *
   * @param actionType action type
   * @param obj object
   */
  private void queueActionLocked(DeltaType actionType, Object obj) {
    String id = this.keyOf(obj);

    Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltas = items.get(id);
    if (deltas == null) {
      Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltaList = new LinkedList<>();
      deltaList.add(new AbstractMap.SimpleEntry<>(actionType, obj));
      deltas = new LinkedList<>(deltaList);
    } else {
      deltas.add(new AbstractMap.SimpleEntry<>(actionType, obj));
    }

    Deque<AbstractMap.SimpleEntry<DeltaType, Object>> combinedDeltaList =
      combineDeltas((LinkedList<AbstractMap.SimpleEntry<DeltaType, Object>>) deltas);

    boolean exist = items.containsKey(id);
    if (combinedDeltaList != null && combinedDeltaList.size() > 0) {
      if (!exist) {
        this.queue.add(id);
      }
      this.items.put(id, new LinkedList<>(combinedDeltaList));
      notEmpty.signalAll();
    } else {
      this.items.remove(id);
    }
  }

  /**
   * Add Sync delta.
   * Caller must hold the lock.
   *
   * @param key key for resource
   */
  private void syncKeyLocked(String key) {
    T obj = this.knownObjects.getByKey(key);
    if (obj == null) {
      return;
    }

    String id = this.keyOf(obj);
    Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltas = this.items.get(id);
    if (deltas != null && !deltas.isEmpty()) {
      return;
    }
    this.queueActionLocked(DeltaType.SYNCHRONIZATION, obj);
  }

  private Deque<AbstractMap.SimpleEntry<DeltaType, Object>> combineDeltas(LinkedList<AbstractMap.SimpleEntry<DeltaType, Object>> deltas) {
    if (deltas.size() < 2) {
      return deltas;
    }

    int size = deltas.size();
    AbstractMap.SimpleEntry<DeltaType, Object> d1 = deltas.peekLast();
    AbstractMap.SimpleEntry<DeltaType, Object> d2 = deltas.get(size - 2);
    AbstractMap.SimpleEntry<DeltaType, Object> out = isDuplicate(d1, d2);
    if (out != null) {
      Deque<AbstractMap.SimpleEntry<DeltaType, Object>> newDeltas = new LinkedList<>();
      newDeltas.addAll(deltas.subList(0, size - 2));
      newDeltas.add(out);
      return newDeltas;
    }
    return deltas;
  }

  /**
   * Keep the one with the most information if both are deletions.
   *
   * @param d1 the most one
   * @param d2 the elder one
   * @return the most one
   */
  private AbstractMap.SimpleEntry<DeltaType, Object> isDuplicate(AbstractMap.SimpleEntry<DeltaType, Object> d1, AbstractMap.SimpleEntry<DeltaType, Object> d2) {
    AbstractMap.SimpleEntry<DeltaType, Object> deletionDelta = isDeletionDup(d1, d2);
    if (deletionDelta != null) {
      return deletionDelta;
    }
    return null;
  }

  /**
   * Keep the one with the most information if both are deletions.
   *
   * @param d1 the most one
   * @param d2 the elder one
   * @return the most one
   */
  private AbstractMap.SimpleEntry<DeltaType, Object> isDeletionDup(AbstractMap.SimpleEntry<DeltaType, Object> d1, AbstractMap.SimpleEntry<DeltaType, Object> d2) {
    if (!d1.getKey().equals(DeltaType.DELETION) || !d2.getKey().equals(DeltaType.DELETION)) {
      return null;
    }

    Object obj = d2.getValue();

    return (obj instanceof DeletedFinalStateUnknown) ? d1 : d2;
  }

  Map<String, Deque<AbstractMap.SimpleEntry<DeltaType, Object>>> getItems() { return items; }

  /**
   * DeletedFinalStateUnknown is placed into a DeltaFIFO in the case where
   * an object was deleted but the watch deletion event was missed. In this
   * case we don't know the final resting state of the object, so there is a
   * chance the included `Obj` is stale.
   *
   * @param <T> object
   */
  public static final class DeletedFinalStateUnknown<T> {
    private String key;
    private T obj;

    DeletedFinalStateUnknown(String key, T obj) {
      this.key = key;
      this.obj = obj;
    }

    String getKey() { return key; }

    public T getObj() { return obj; }
  }


  public enum DeltaType {
    ADDITION,

    UPDATION,

    DELETION,

    SYNCHRONIZATION
  }
}
