package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class StorageStateStatusFluent<A extends io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageStateStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String currentStorageVersionHash;
  private String lastHeartbeatTime;
  private List<String> persistedStorageVersionHashes = new ArrayList<String>();

  public StorageStateStatusFluent() {
  }
  
  public StorageStateStatusFluent(StorageStateStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToPersistedStorageVersionHashes(Collection<String> items) {
    if (this.persistedStorageVersionHashes == null) {
      this.persistedStorageVersionHashes = new ArrayList();
    }
    for (String item : items) {
      this.persistedStorageVersionHashes.add(item);
    }
    return (A) this;
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
  
  public A addToPersistedStorageVersionHashes(String... items) {
    if (this.persistedStorageVersionHashes == null) {
      this.persistedStorageVersionHashes = new ArrayList();
    }
    for (String item : items) {
      this.persistedStorageVersionHashes.add(item);
    }
    return (A) this;
  }
  
  public A addToPersistedStorageVersionHashes(int index,String item) {
    if (this.persistedStorageVersionHashes == null) {
      this.persistedStorageVersionHashes = new ArrayList();
    }
    this.persistedStorageVersionHashes.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(StorageStateStatus instance) {
    instance = instance != null ? instance : new StorageStateStatus();
    if (instance != null) {
        this.withCurrentStorageVersionHash(instance.getCurrentStorageVersionHash());
        this.withLastHeartbeatTime(instance.getLastHeartbeatTime());
        this.withPersistedStorageVersionHashes(instance.getPersistedStorageVersionHashes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    StorageStateStatusFluent that = (StorageStateStatusFluent) o;
    if (!(Objects.equals(currentStorageVersionHash, that.currentStorageVersionHash))) {
      return false;
    }
    if (!(Objects.equals(lastHeartbeatTime, that.lastHeartbeatTime))) {
      return false;
    }
    if (!(Objects.equals(persistedStorageVersionHashes, that.persistedStorageVersionHashes))) {
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
  
  public String getCurrentStorageVersionHash() {
    return this.currentStorageVersionHash;
  }
  
  public String getFirstPersistedStorageVersionHash() {
    return this.persistedStorageVersionHashes.get(0);
  }
  
  public String getLastHeartbeatTime() {
    return this.lastHeartbeatTime;
  }
  
  public String getLastPersistedStorageVersionHash() {
    return this.persistedStorageVersionHashes.get(persistedStorageVersionHashes.size() - 1);
  }
  
  public String getMatchingPersistedStorageVersionHash(Predicate<String> predicate) {
      for (String item : persistedStorageVersionHashes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPersistedStorageVersionHash(int index) {
    return this.persistedStorageVersionHashes.get(index);
  }
  
  public List<String> getPersistedStorageVersionHashes() {
    return this.persistedStorageVersionHashes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentStorageVersionHash() {
    return this.currentStorageVersionHash != null;
  }
  
  public boolean hasLastHeartbeatTime() {
    return this.lastHeartbeatTime != null;
  }
  
  public boolean hasMatchingPersistedStorageVersionHash(Predicate<String> predicate) {
      for (String item : persistedStorageVersionHashes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPersistedStorageVersionHashes() {
    return this.persistedStorageVersionHashes != null && !(this.persistedStorageVersionHashes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(currentStorageVersionHash, lastHeartbeatTime, persistedStorageVersionHashes, additionalProperties);
  }
  
  public A removeAllFromPersistedStorageVersionHashes(Collection<String> items) {
    if (this.persistedStorageVersionHashes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.persistedStorageVersionHashes.remove(item);
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
  
  public A removeFromPersistedStorageVersionHashes(String... items) {
    if (this.persistedStorageVersionHashes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.persistedStorageVersionHashes.remove(item);
    }
    return (A) this;
  }
  
  public A setToPersistedStorageVersionHashes(int index,String item) {
    if (this.persistedStorageVersionHashes == null) {
      this.persistedStorageVersionHashes = new ArrayList();
    }
    this.persistedStorageVersionHashes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(currentStorageVersionHash == null)) {
        sb.append("currentStorageVersionHash:");
        sb.append(currentStorageVersionHash);
        sb.append(",");
    }
    if (!(lastHeartbeatTime == null)) {
        sb.append("lastHeartbeatTime:");
        sb.append(lastHeartbeatTime);
        sb.append(",");
    }
    if (!(persistedStorageVersionHashes == null) && !(persistedStorageVersionHashes.isEmpty())) {
        sb.append("persistedStorageVersionHashes:");
        sb.append(persistedStorageVersionHashes);
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
  
  public A withCurrentStorageVersionHash(String currentStorageVersionHash) {
    this.currentStorageVersionHash = currentStorageVersionHash;
    return (A) this;
  }
  
  public A withLastHeartbeatTime(String lastHeartbeatTime) {
    this.lastHeartbeatTime = lastHeartbeatTime;
    return (A) this;
  }
  
  public A withPersistedStorageVersionHashes(List<String> persistedStorageVersionHashes) {
    if (persistedStorageVersionHashes != null) {
        this.persistedStorageVersionHashes = new ArrayList();
        for (String item : persistedStorageVersionHashes) {
          this.addToPersistedStorageVersionHashes(item);
        }
    } else {
      this.persistedStorageVersionHashes = null;
    }
    return (A) this;
  }
  
  public A withPersistedStorageVersionHashes(String... persistedStorageVersionHashes) {
    if (this.persistedStorageVersionHashes != null) {
        this.persistedStorageVersionHashes.clear();
        _visitables.remove("persistedStorageVersionHashes");
    }
    if (persistedStorageVersionHashes != null) {
      for (String item : persistedStorageVersionHashes) {
        this.addToPersistedStorageVersionHashes(item);
      }
    }
    return (A) this;
  }
  
}