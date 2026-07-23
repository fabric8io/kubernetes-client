package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class Metal3DataTemplateStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3DataTemplateStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Integer> indexes;
  private String lastUpdated;

  public Metal3DataTemplateStatusFluent() {
  }
  
  public Metal3DataTemplateStatusFluent(Metal3DataTemplateStatus instance) {
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
  
  public A addToIndexes(Map<String,Integer> map) {
    if (this.indexes == null && map != null) {
      this.indexes = new LinkedHashMap();
    }
    if (map != null) {
      this.indexes.putAll(map);
    }
    return (A) this;
  }
  
  public A addToIndexes(String key,Integer value) {
    if (this.indexes == null && key != null && value != null) {
      this.indexes = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.indexes.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(Metal3DataTemplateStatus instance) {
    instance = instance != null ? instance : new Metal3DataTemplateStatus();
    if (instance != null) {
        this.withIndexes(instance.getIndexes());
        this.withLastUpdated(instance.getLastUpdated());
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
    Metal3DataTemplateStatusFluent that = (Metal3DataTemplateStatusFluent) o;
    if (!(Objects.equals(indexes, that.indexes))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
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
  
  public Map<String,Integer> getIndexes() {
    return this.indexes;
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIndexes() {
    return this.indexes != null;
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public int hashCode() {
    return Objects.hash(indexes, lastUpdated, additionalProperties);
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
  
  public A removeFromIndexes(String key) {
    if (this.indexes == null) {
      return (A) this;
    }
    if (key != null && this.indexes != null) {
      this.indexes.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromIndexes(Map<String,Integer> map) {
    if (this.indexes == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.indexes != null) {
          this.indexes.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(indexes == null) && !(indexes.isEmpty())) {
        sb.append("indexes:");
        sb.append(indexes);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
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
  
  public <K,V>A withIndexes(Map<String,Integer> indexes) {
    if (indexes == null) {
      this.indexes = null;
    } else {
      this.indexes = new LinkedHashMap(indexes);
    }
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
}