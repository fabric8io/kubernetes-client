package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class SystemDiskPropertiesFluent<A extends io.fabric8.openshift.api.model.machine.v1.SystemDiskPropertiesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String category;
  private String name;
  private String performanceLevel;
  private Long size;

  public SystemDiskPropertiesFluent() {
  }
  
  public SystemDiskPropertiesFluent(SystemDiskProperties instance) {
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
  
  protected void copyInstance(SystemDiskProperties instance) {
    instance = instance != null ? instance : new SystemDiskProperties();
    if (instance != null) {
        this.withCategory(instance.getCategory());
        this.withName(instance.getName());
        this.withPerformanceLevel(instance.getPerformanceLevel());
        this.withSize(instance.getSize());
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
    SystemDiskPropertiesFluent that = (SystemDiskPropertiesFluent) o;
    if (!(Objects.equals(category, that.category))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(performanceLevel, that.performanceLevel))) {
      return false;
    }
    if (!(Objects.equals(size, that.size))) {
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
  
  public String getCategory() {
    return this.category;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getPerformanceLevel() {
    return this.performanceLevel;
  }
  
  public Long getSize() {
    return this.size;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCategory() {
    return this.category != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPerformanceLevel() {
    return this.performanceLevel != null;
  }
  
  public boolean hasSize() {
    return this.size != null;
  }
  
  public int hashCode() {
    return Objects.hash(category, name, performanceLevel, size, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(category == null)) {
        sb.append("category:");
        sb.append(category);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(performanceLevel == null)) {
        sb.append("performanceLevel:");
        sb.append(performanceLevel);
        sb.append(",");
    }
    if (!(size == null)) {
        sb.append("size:");
        sb.append(size);
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
  
  public A withCategory(String category) {
    this.category = category;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withPerformanceLevel(String performanceLevel) {
    this.performanceLevel = performanceLevel;
    return (A) this;
  }
  
  public A withSize(Long size) {
    this.size = size;
    return (A) this;
  }
  
}