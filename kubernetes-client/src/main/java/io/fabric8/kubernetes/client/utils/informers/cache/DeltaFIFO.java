package io.fabric8.kubernetes.client.utils.informers.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * The DeltaFIFO inherits from an Object queue since that we're actually
 * reading from it as Deltas but writing it as Kubernetes object.
 */
public class DeltaFIFO<T> implements Store<Object> {
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

  private Store<T> knownObjects;

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

  public DeltaFIFO(Function<T, String> keyFunc, Store knownObjects) {
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
  public void add(Object obj) {
//    System.out.println("DeltaFIFO add LOCK O");
    lock.writeLock().lock();
    try {
      populated = true;
      this.queueActionLocked(DeltaType.ADDITION, obj);
    } finally {
//      System.out.println("DeltaFIFO add UNLOCK -");
      lock.writeLock().unlock();
    }
  }

  /**
   * Update items in delta FIFO
   *
   * @param obj object
   */
  @Override
  public void update(Object obj) {
    lock.writeLock().lock();
//    System.out.println("DeltaFIFO Update LOCK O");
    try {
      populated = true;
      this.queueActionLocked(DeltaType.UPDATION, obj);
    } finally {
//      System.out.println("DeltaFIFO Update UNLOCK -");
      lock.writeLock().unlock();
    }
  }

  /**
   * Delete items from the delta FIFO
   *
   * @param obj object
   */
  @Override
  public void delete(Object obj) {
    String id = this.keyOf(obj);
//    System.out.println("DeltaFIFO delete trying to lock O");
    lock.writeLock().lock();
//    System.out.println("DeltaFIFO delete LOCK O");
    try {
      this.populated = true;
      if (this.knownObjects == null) {
        if (!this.items.containsKey(id)) {
          // Maybe this was deleted when a relist happened
          // don't provide a second report of the same deletion.
          return;
        }
      } else {
        // We only want to skip the deletion action if the object doesn't
        // exist in the knownObjects and it doesn't have corresponding item
        // in items.
        if (this.knownObjects.getByKey(id) == null && !this.items.containsKey(id)) {
          return;
        }
      }
      this.queueActionLocked(DeltaType.DELETION, obj);
    } finally {
//      System.out.println("DELTAFIFO delete UNLOCK -");
      lock.writeLock().unlock();
    }
  }

  /**
   * Replace the item forcibly.
   *
   * @param list list of objects
   * @param resourceVersion resource version
   */
  @Override
  public void replace(List list, String resourceVersion) {
//    System.out.println("DeltaFIFO replace trying to LOCK O");
    lock.writeLock().lock();
//    System.out.println("DELTAFIFO replace LOCK O");
    try {
      Set<String> keys = new HashSet<>();
      for (Object obj : list) {
        String key = this.keyOf(obj);
        keys.add(key);
        this.queueActionLocked(DeltaType.SYNCHRONIZATION, obj);
      }

      if (this.knownObjects == null) {
        for (Map.Entry<String, Deque<AbstractMap.SimpleEntry<DeltaType, Object>>> entry : this.items.entrySet()) {
          if (keys.contains(entry.getKey())) {
            continue;
          }

          Object deletedObj = null;
          AbstractMap.SimpleEntry<DeltaType, Object> delta = entry.getValue().peekLast(); // Get newest
          if (delta != null) {
            deletedObj = delta.getValue();
          }
          this.queueActionLocked(DeltaType.DELETION, new DeletedFinalStateUnknown(entry.getKey(), deletedObj));
        }

        if (!this.populated) {
          this.populated = true;
          this.initialPopulationCount = list.size();
        }
        return;
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
//      System.out.println("DELTAFIFO replace UNLOCK -");
    }
  }

  /**
   * Resync the delta FIFO. First, it locks the queue to block any more write
   * operation until it finishes all the pending items in the queue.
   *
   */
  @Override
  public void resync() {
    lock.writeLock().lock();
//    System.out.println("DELTAFIFO resync LOCK O");
    try {
      if (this.knownObjects == null) {
        return;
      }

      List<String> keys = this.knownObjects.listKeys();
      for (String key : keys) {
        syncKeyLocked(key);
      }
    } finally {
//      System.out.println("DELTAFIFO resync UNLOCK -");
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
//    System.out.println("DELTAFIFO listKeys trying to LOCK O");
    lock.readLock().lock();
//    System.out.println("DELTAFIFO listKeys LOCK O");
    try {
      List<String> keyList = new ArrayList<>(items.size());
      for (Map.Entry<String, Deque<AbstractMap.SimpleEntry<DeltaType, Object>>> entry : items.entrySet()) {
        keyList.add(entry.getKey());
      }
      return keyList;
    } finally {
//      System.out.println("DELTAFIFO listKeys UNLOCK -");
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
  public Object get(Object obj) {
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
//    System.out.println("DeltaFIFO getByKey trying to LOCK O");
    lock.readLock().lock();
//    System.out.println("DeltaFIFO getByKey LOCK O");
    try {
      Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltas = this.items.get(key);
      if (deltas != null) {
        // return a shallow copy
        return new LinkedList<>(deltas);
      }
    } finally {
//      System.out.println("DeltaFIFO getByKey UNLOCK -");
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
  public List<Object> list() {
//    System.out.println("DeltaFIFO list trying to lock O");
    lock.readLock().lock();
//    System.out.println("DeltaFIFO list LOCKed O");
    List<Object> objects = new ArrayList<>();
    try {
      for (Map.Entry<String, Deque<AbstractMap.SimpleEntry<DeltaType, Object>>> entry : items.entrySet()) {
        Deque<AbstractMap.SimpleEntry<DeltaType, Object>> copiedDeltas = new LinkedList<>(entry.getValue());
        objects.add(copiedDeltas);
      }
    } finally {
//      System.out.println("DeltaFIFO list UNLOCK -");
      lock.readLock().unlock();
    }
    return objects;
  }

  /**
   * Pop Deltas
   *
   * @param func the func
   * @return the deltas
   * @throws InterruptedException interruption exception
   */
  public Deque<AbstractMap.SimpleEntry<DeltaType, Object>> pop(Consumer<Deque<AbstractMap.SimpleEntry<DeltaType, Object>>> func) throws InterruptedException {
//    System.out.println("DeltaFIFO pop Locking ... ");
    lock.writeLock().lock();
//    System.out.println("DeltaFIFO pop LOCK O");
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
//      System.out.println("DeltaFIFO pop UNLOCK -");
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
//    System.out.println("DeltaFIFO hasSynced LOCK O");
    try {
      return this.populated && this.initialPopulationCount == 0;
    } finally {
      lock.readLock().unlock();
//      System.out.println("DeltaFIFO hasSynced UNLOCK -");
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

    // if object is supposed to be deleted (last event is Deleted),
    // then we should ignore Sync events, because it would result in
    // recreation of this object.
    if (actionType == DeltaType.SYNCHRONIZATION && this.willObjectBeDeletedLocked(id)) {
      return;
    }

    Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltas = items.get(id);
    if (deltas == null) {
      Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltaList = new LinkedList<>();
      deltaList.add(new AbstractMap.SimpleEntry<>(actionType, obj));
      deltas = new LinkedList<>(deltaList);
    } else {
      deltas.add(new AbstractMap.SimpleEntry<DeltaType, Object>(actionType, obj));
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
   * Returns true only if the last delta for the given object is Deleted.
   * Caller must hold the lock.
   *
   * @param id id of the object
   * @return boolean value
   */
  private boolean willObjectBeDeletedLocked(String id) {
    if (!this.items.containsKey(id)) {
      return false;
    }

    Deque<AbstractMap.SimpleEntry<DeltaType, Object>> deltas = this.items.get(id);
    return !(deltas == null || deltas.isEmpty())
      && deltas.peekLast().getKey().equals(DeltaType.DELETION);
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
    if (deltas != null && !(deltas == null || deltas.isEmpty())) {
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
