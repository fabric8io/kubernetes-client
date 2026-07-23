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
public class IPFIXConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.IPFIXConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> collectors = new ArrayList<String>();

  public IPFIXConfigFluent() {
  }
  
  public IPFIXConfigFluent(IPFIXConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToCollectors(Collection<String> items) {
    if (this.collectors == null) {
      this.collectors = new ArrayList();
    }
    for (String item : items) {
      this.collectors.add(item);
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
  
  public A addToCollectors(String... items) {
    if (this.collectors == null) {
      this.collectors = new ArrayList();
    }
    for (String item : items) {
      this.collectors.add(item);
    }
    return (A) this;
  }
  
  public A addToCollectors(int index,String item) {
    if (this.collectors == null) {
      this.collectors = new ArrayList();
    }
    this.collectors.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(IPFIXConfig instance) {
    instance = instance != null ? instance : new IPFIXConfig();
    if (instance != null) {
        this.withCollectors(instance.getCollectors());
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
    IPFIXConfigFluent that = (IPFIXConfigFluent) o;
    if (!(Objects.equals(collectors, that.collectors))) {
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
  
  public String getCollector(int index) {
    return this.collectors.get(index);
  }
  
  public List<String> getCollectors() {
    return this.collectors;
  }
  
  public String getFirstCollector() {
    return this.collectors.get(0);
  }
  
  public String getLastCollector() {
    return this.collectors.get(collectors.size() - 1);
  }
  
  public String getMatchingCollector(Predicate<String> predicate) {
      for (String item : collectors) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCollectors() {
    return this.collectors != null && !(this.collectors.isEmpty());
  }
  
  public boolean hasMatchingCollector(Predicate<String> predicate) {
      for (String item : collectors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(collectors, additionalProperties);
  }
  
  public A removeAllFromCollectors(Collection<String> items) {
    if (this.collectors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.collectors.remove(item);
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
  
  public A removeFromCollectors(String... items) {
    if (this.collectors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.collectors.remove(item);
    }
    return (A) this;
  }
  
  public A setToCollectors(int index,String item) {
    if (this.collectors == null) {
      this.collectors = new ArrayList();
    }
    this.collectors.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(collectors == null) && !(collectors.isEmpty())) {
        sb.append("collectors:");
        sb.append(collectors);
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
  
  public A withCollectors(List<String> collectors) {
    if (collectors != null) {
        this.collectors = new ArrayList();
        for (String item : collectors) {
          this.addToCollectors(item);
        }
    } else {
      this.collectors = null;
    }
    return (A) this;
  }
  
  public A withCollectors(String... collectors) {
    if (this.collectors != null) {
        this.collectors.clear();
        _visitables.remove("collectors");
    }
    if (collectors != null) {
      for (String item : collectors) {
        this.addToCollectors(item);
      }
    }
    return (A) this;
  }
  
}