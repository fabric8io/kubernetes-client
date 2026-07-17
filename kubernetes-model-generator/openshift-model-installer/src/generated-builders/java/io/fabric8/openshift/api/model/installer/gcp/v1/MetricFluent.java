package io.fabric8.openshift.api.model.installer.gcp.v1;

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
public class MetricFluent<A extends io.fabric8.openshift.api.model.installer.gcp.v1.MetricFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> dimensions;
  private String limit;
  private String service;

  public MetricFluent() {
  }
  
  public MetricFluent(Metric instance) {
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
  
  public A addToDimensions(Map<String,String> map) {
    if (this.dimensions == null && map != null) {
      this.dimensions = new LinkedHashMap();
    }
    if (map != null) {
      this.dimensions.putAll(map);
    }
    return (A) this;
  }
  
  public A addToDimensions(String key,String value) {
    if (this.dimensions == null && key != null && value != null) {
      this.dimensions = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.dimensions.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(Metric instance) {
    instance = instance != null ? instance : new Metric();
    if (instance != null) {
        this.withDimensions(instance.getDimensions());
        this.withLimit(instance.getLimit());
        this.withService(instance.getService());
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
    MetricFluent that = (MetricFluent) o;
    if (!(Objects.equals(dimensions, that.dimensions))) {
      return false;
    }
    if (!(Objects.equals(limit, that.limit))) {
      return false;
    }
    if (!(Objects.equals(service, that.service))) {
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
  
  public Map<String,String> getDimensions() {
    return this.dimensions;
  }
  
  public String getLimit() {
    return this.limit;
  }
  
  public String getService() {
    return this.service;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDimensions() {
    return this.dimensions != null;
  }
  
  public boolean hasLimit() {
    return this.limit != null;
  }
  
  public boolean hasService() {
    return this.service != null;
  }
  
  public int hashCode() {
    return Objects.hash(dimensions, limit, service, additionalProperties);
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
  
  public A removeFromDimensions(String key) {
    if (this.dimensions == null) {
      return (A) this;
    }
    if (key != null && this.dimensions != null) {
      this.dimensions.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromDimensions(Map<String,String> map) {
    if (this.dimensions == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.dimensions != null) {
          this.dimensions.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dimensions == null) && !(dimensions.isEmpty())) {
        sb.append("dimensions:");
        sb.append(dimensions);
        sb.append(",");
    }
    if (!(limit == null)) {
        sb.append("limit:");
        sb.append(limit);
        sb.append(",");
    }
    if (!(service == null)) {
        sb.append("service:");
        sb.append(service);
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
  
  public <K,V>A withDimensions(Map<String,String> dimensions) {
    if (dimensions == null) {
      this.dimensions = null;
    } else {
      this.dimensions = new LinkedHashMap(dimensions);
    }
    return (A) this;
  }
  
  public A withLimit(String limit) {
    this.limit = limit;
    return (A) this;
  }
  
  public A withService(String service) {
    this.service = service;
    return (A) this;
  }
  
}