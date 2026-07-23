package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class NamedResourcesIntSliceFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.NamedResourcesIntSliceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Long> ints = new ArrayList<Long>();

  public NamedResourcesIntSliceFluent() {
  }
  
  public NamedResourcesIntSliceFluent(NamedResourcesIntSlice instance) {
    this.copyInstance(instance);
  }

  public A addAllToInts(Collection<Long> items) {
    if (this.ints == null) {
      this.ints = new ArrayList();
    }
    for (Long item : items) {
      this.ints.add(item);
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
  
  public A addToInts(Long... items) {
    if (this.ints == null) {
      this.ints = new ArrayList();
    }
    for (Long item : items) {
      this.ints.add(item);
    }
    return (A) this;
  }
  
  public A addToInts(int index,Long item) {
    if (this.ints == null) {
      this.ints = new ArrayList();
    }
    this.ints.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NamedResourcesIntSlice instance) {
    instance = instance != null ? instance : new NamedResourcesIntSlice();
    if (instance != null) {
        this.withInts(instance.getInts());
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
    NamedResourcesIntSliceFluent that = (NamedResourcesIntSliceFluent) o;
    if (!(Objects.equals(ints, that.ints))) {
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
  
  public Long getFirstInt() {
    return this.ints.get(0);
  }
  
  public Long getInt(int index) {
    return this.ints.get(index);
  }
  
  public List<Long> getInts() {
    return this.ints;
  }
  
  public Long getLastInt() {
    return this.ints.get(ints.size() - 1);
  }
  
  public Long getMatchingInt(Predicate<Long> predicate) {
      for (Long item : ints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasInts() {
    return this.ints != null && !(this.ints.isEmpty());
  }
  
  public boolean hasMatchingInt(Predicate<Long> predicate) {
      for (Long item : ints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(ints, additionalProperties);
  }
  
  public A removeAllFromInts(Collection<Long> items) {
    if (this.ints == null) {
      return (A) this;
    }
    for (Long item : items) {
      this.ints.remove(item);
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
  
  public A removeFromInts(Long... items) {
    if (this.ints == null) {
      return (A) this;
    }
    for (Long item : items) {
      this.ints.remove(item);
    }
    return (A) this;
  }
  
  public A setToInts(int index,Long item) {
    if (this.ints == null) {
      this.ints = new ArrayList();
    }
    this.ints.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ints == null) && !(ints.isEmpty())) {
        sb.append("ints:");
        sb.append(ints);
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
  
  public A withInts(List<Long> ints) {
    if (ints != null) {
        this.ints = new ArrayList();
        for (Long item : ints) {
          this.addToInts(item);
        }
    } else {
      this.ints = null;
    }
    return (A) this;
  }
  
  public A withInts(Long... ints) {
    if (this.ints != null) {
        this.ints.clear();
        _visitables.remove("ints");
    }
    if (ints != null) {
      for (Long item : ints) {
        this.addToInts(item);
      }
    }
    return (A) this;
  }
  
}