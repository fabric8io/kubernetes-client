package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CSINodeStatusFluent<A extends io.fabric8.kubernetes.api.model.storage.CSINodeStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<StorageHealthBuilder> storageHealth = new ArrayList<StorageHealthBuilder>();

  public CSINodeStatusFluent() {
  }
  
  public CSINodeStatusFluent(CSINodeStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToStorageHealth(Collection<StorageHealth> items) {
    if (this.storageHealth == null) {
      this.storageHealth = new ArrayList();
    }
    for (StorageHealth item : items) {
        StorageHealthBuilder builder = new StorageHealthBuilder(item);
        _visitables.get("storageHealth").add(builder);
        this.storageHealth.add(builder);
    }
    return (A) this;
  }
  
  public StorageHealthNested<A> addNewStorageHealth() {
    return new StorageHealthNested(-1, null);
  }
  
  public StorageHealthNested<A> addNewStorageHealthLike(StorageHealth item) {
    return new StorageHealthNested(-1, item);
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToStorageHealth(StorageHealth... items) {
    if (this.storageHealth == null) {
      this.storageHealth = new ArrayList();
    }
    for (StorageHealth item : items) {
        StorageHealthBuilder builder = new StorageHealthBuilder(item);
        _visitables.get("storageHealth").add(builder);
        this.storageHealth.add(builder);
    }
    return (A) this;
  }
  
  public A addToStorageHealth(int index,StorageHealth item) {
    if (this.storageHealth == null) {
      this.storageHealth = new ArrayList();
    }
    StorageHealthBuilder builder = new StorageHealthBuilder(item);
    if (index < 0 || index >= storageHealth.size()) {
        _visitables.get("storageHealth").add(builder);
        storageHealth.add(builder);
    } else {
        _visitables.get("storageHealth").add(builder);
        storageHealth.add(index, builder);
    }
    return (A) this;
  }
  
  public StorageHealth buildFirstStorageHealth() {
    return this.storageHealth.get(0).build();
  }
  
  public StorageHealth buildLastStorageHealth() {
    return this.storageHealth.get(storageHealth.size() - 1).build();
  }
  
  public StorageHealth buildMatchingStorageHealth(Predicate<StorageHealthBuilder> predicate) {
      for (StorageHealthBuilder item : storageHealth) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<StorageHealth> buildStorageHealth() {
    return this.storageHealth != null ? build(storageHealth) : null;
  }
  
  public StorageHealth buildStorageHealth(int index) {
    return this.storageHealth.get(index).build();
  }
  
  protected void copyInstance(CSINodeStatus instance) {
    instance = instance != null ? instance : new CSINodeStatus();
    if (instance != null) {
        this.withStorageHealth(instance.getStorageHealth());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StorageHealthNested<A> editFirstStorageHealth() {
    if (storageHealth.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "storageHealth"));
    }
    return this.setNewStorageHealthLike(0, this.buildStorageHealth(0));
  }
  
  public StorageHealthNested<A> editLastStorageHealth() {
    int index = storageHealth.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "storageHealth"));
    }
    return this.setNewStorageHealthLike(index, this.buildStorageHealth(index));
  }
  
  public StorageHealthNested<A> editMatchingStorageHealth(Predicate<StorageHealthBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < storageHealth.size();i++) {
      if (predicate.test(storageHealth.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "storageHealth"));
    }
    return this.setNewStorageHealthLike(index, this.buildStorageHealth(index));
  }
  
  public StorageHealthNested<A> editStorageHealth(int index) {
    if (storageHealth.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "storageHealth"));
    }
    return this.setNewStorageHealthLike(index, this.buildStorageHealth(index));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    CSINodeStatusFluent that = (CSINodeStatusFluent) o;
    if (!(Objects.equals(storageHealth, that.storageHealth))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingStorageHealth(Predicate<StorageHealthBuilder> predicate) {
      for (StorageHealthBuilder item : storageHealth) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStorageHealth() {
    return this.storageHealth != null && !(this.storageHealth.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(storageHealth, additionalProperties);
  }
  
  public A removeAllFromStorageHealth(Collection<StorageHealth> items) {
    if (this.storageHealth == null) {
      return (A) this;
    }
    for (StorageHealth item : items) {
        StorageHealthBuilder builder = new StorageHealthBuilder(item);
        _visitables.get("storageHealth").remove(builder);
        this.storageHealth.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromStorageHealth(StorageHealth... items) {
    if (this.storageHealth == null) {
      return (A) this;
    }
    for (StorageHealth item : items) {
        StorageHealthBuilder builder = new StorageHealthBuilder(item);
        _visitables.get("storageHealth").remove(builder);
        this.storageHealth.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromStorageHealth(Predicate<StorageHealthBuilder> predicate) {
    if (storageHealth == null) {
      return (A) this;
    }
    Iterator<StorageHealthBuilder> each = storageHealth.iterator();
    List visitables = _visitables.get("storageHealth");
    while (each.hasNext()) {
        StorageHealthBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public StorageHealthNested<A> setNewStorageHealthLike(int index,StorageHealth item) {
    return new StorageHealthNested(index, item);
  }
  
  public A setToStorageHealth(int index,StorageHealth item) {
    if (this.storageHealth == null) {
      this.storageHealth = new ArrayList();
    }
    StorageHealthBuilder builder = new StorageHealthBuilder(item);
    if (index < 0 || index >= storageHealth.size()) {
        _visitables.get("storageHealth").add(builder);
        storageHealth.add(builder);
    } else {
        _visitables.get("storageHealth").add(builder);
        storageHealth.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(storageHealth == null) && !(storageHealth.isEmpty())) {
        sb.append("storageHealth:");
        sb.append(storageHealth);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withStorageHealth(List<StorageHealth> storageHealth) {
    if (this.storageHealth != null) {
      this._visitables.get("storageHealth").clear();
    }
    if (storageHealth != null) {
        this.storageHealth = new ArrayList();
        for (StorageHealth item : storageHealth) {
          this.addToStorageHealth(item);
        }
    } else {
      this.storageHealth = null;
    }
    return (A) this;
  }
  
  public A withStorageHealth(StorageHealth... storageHealth) {
    if (this.storageHealth != null) {
        this.storageHealth.clear();
        _visitables.remove("storageHealth");
    }
    if (storageHealth != null) {
      for (StorageHealth item : storageHealth) {
        this.addToStorageHealth(item);
      }
    }
    return (A) this;
  }
  public class StorageHealthNested<N> extends StorageHealthFluent<StorageHealthNested<N>> implements Nested<N>{
  
    StorageHealthBuilder builder;
    int index;
  
    StorageHealthNested(int index,StorageHealth item) {
      this.index = index;
      this.builder = new StorageHealthBuilder(this, item);
    }
  
    public N and() {
      return (N) CSINodeStatusFluent.this.setToStorageHealth(index, builder.build());
    }
    
    public N endStorageHealth() {
      return and();
    }
    
  }
}