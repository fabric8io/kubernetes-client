package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class ContainerMetricsFluent<A extends io.fabric8.kubernetes.api.model.metrics.v1beta1.ContainerMetricsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private Map<String,Quantity> usage;

  public ContainerMetricsFluent() {
  }
  
  public ContainerMetricsFluent(ContainerMetrics instance) {
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
  
  public A addToUsage(Map<String,Quantity> map) {
    if (this.usage == null && map != null) {
      this.usage = new LinkedHashMap();
    }
    if (map != null) {
      this.usage.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUsage(String key,Quantity value) {
    if (this.usage == null && key != null && value != null) {
      this.usage = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.usage.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(ContainerMetrics instance) {
    instance = instance != null ? instance : new ContainerMetrics();
    if (instance != null) {
        this.withName(instance.getName());
        this.withUsage(instance.getUsage());
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
    ContainerMetricsFluent that = (ContainerMetricsFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(usage, that.usage))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public Map<String,Quantity> getUsage() {
    return this.usage;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasUsage() {
    return this.usage != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, usage, additionalProperties);
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
  
  public A removeFromUsage(String key) {
    if (this.usage == null) {
      return (A) this;
    }
    if (key != null && this.usage != null) {
      this.usage.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUsage(Map<String,Quantity> map) {
    if (this.usage == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.usage != null) {
          this.usage.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(usage == null) && !(usage.isEmpty())) {
        sb.append("usage:");
        sb.append(usage);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public <K,V>A withUsage(Map<String,Quantity> usage) {
    if (usage == null) {
      this.usage = null;
    } else {
      this.usage = new LinkedHashMap(usage);
    }
    return (A) this;
  }
  
}