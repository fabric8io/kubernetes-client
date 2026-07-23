package io.fabric8.openshift.api.model.operator.v1;

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
public class IrreconcilableValidationOverridesFluent<A extends io.fabric8.openshift.api.model.operator.v1.IrreconcilableValidationOverridesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> storage = new ArrayList<String>();

  public IrreconcilableValidationOverridesFluent() {
  }
  
  public IrreconcilableValidationOverridesFluent(IrreconcilableValidationOverrides instance) {
    this.copyInstance(instance);
  }

  public A addAllToStorage(Collection<String> items) {
    if (this.storage == null) {
      this.storage = new ArrayList();
    }
    for (String item : items) {
      this.storage.add(item);
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
  
  public A addToStorage(String... items) {
    if (this.storage == null) {
      this.storage = new ArrayList();
    }
    for (String item : items) {
      this.storage.add(item);
    }
    return (A) this;
  }
  
  public A addToStorage(int index,String item) {
    if (this.storage == null) {
      this.storage = new ArrayList();
    }
    this.storage.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(IrreconcilableValidationOverrides instance) {
    instance = instance != null ? instance : new IrreconcilableValidationOverrides();
    if (instance != null) {
        this.withStorage(instance.getStorage());
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
    IrreconcilableValidationOverridesFluent that = (IrreconcilableValidationOverridesFluent) o;
    if (!(Objects.equals(storage, that.storage))) {
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
  
  public String getFirstStorage() {
    return this.storage.get(0);
  }
  
  public String getLastStorage() {
    return this.storage.get(storage.size() - 1);
  }
  
  public String getMatchingStorage(Predicate<String> predicate) {
      for (String item : storage) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getStorage() {
    return this.storage;
  }
  
  public String getStorage(int index) {
    return this.storage.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingStorage(Predicate<String> predicate) {
      for (String item : storage) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStorage() {
    return this.storage != null && !(this.storage.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(storage, additionalProperties);
  }
  
  public A removeAllFromStorage(Collection<String> items) {
    if (this.storage == null) {
      return (A) this;
    }
    for (String item : items) {
      this.storage.remove(item);
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
  
  public A removeFromStorage(String... items) {
    if (this.storage == null) {
      return (A) this;
    }
    for (String item : items) {
      this.storage.remove(item);
    }
    return (A) this;
  }
  
  public A setToStorage(int index,String item) {
    if (this.storage == null) {
      this.storage = new ArrayList();
    }
    this.storage.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(storage == null) && !(storage.isEmpty())) {
        sb.append("storage:");
        sb.append(storage);
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
  
  public A withStorage(List<String> storage) {
    if (storage != null) {
        this.storage = new ArrayList();
        for (String item : storage) {
          this.addToStorage(item);
        }
    } else {
      this.storage = null;
    }
    return (A) this;
  }
  
  public A withStorage(String... storage) {
    if (this.storage != null) {
        this.storage.clear();
        _visitables.remove("storage");
    }
    if (storage != null) {
      for (String item : storage) {
        this.addToStorage(item);
      }
    }
    return (A) this;
  }
  
}