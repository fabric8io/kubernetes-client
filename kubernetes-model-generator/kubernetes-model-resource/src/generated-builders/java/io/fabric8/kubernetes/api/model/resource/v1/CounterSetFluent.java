package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CounterSetFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.CounterSetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Counter> counters;
  private String name;

  public CounterSetFluent() {
  }
  
  public CounterSetFluent(CounterSet instance) {
    this.copyInstance(instance);
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
  
  public A addToCounters(Map<String,Counter> map) {
    if (this.counters == null && map != null) {
      this.counters = new LinkedHashMap();
    }
    if (map != null) {
      this.counters.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCounters(String key,Counter value) {
    if (this.counters == null && key != null && value != null) {
      this.counters = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.counters.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(CounterSet instance) {
    instance = instance != null ? instance : new CounterSet();
    if (instance != null) {
        this.withCounters(instance.getCounters());
        this.withName(instance.getName());
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
    CounterSetFluent that = (CounterSetFluent) o;
    if (!(Objects.equals(counters, that.counters))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public Map<String,Counter> getCounters() {
    return this.counters;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCounters() {
    return this.counters != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(counters, name, additionalProperties);
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
  
  public A removeFromCounters(String key) {
    if (this.counters == null) {
      return (A) this;
    }
    if (key != null && this.counters != null) {
      this.counters.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCounters(Map<String,Counter> map) {
    if (this.counters == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.counters != null) {
          this.counters.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(counters == null) && !(counters.isEmpty())) {
        sb.append("counters:");
        sb.append(counters);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public <K,V>A withCounters(Map<String,Counter> counters) {
    if (counters == null) {
      this.counters = null;
    } else {
      this.counters = new LinkedHashMap(counters);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
}