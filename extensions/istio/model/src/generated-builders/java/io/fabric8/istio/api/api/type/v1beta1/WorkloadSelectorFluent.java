package io.fabric8.istio.api.api.type.v1beta1;

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
public class WorkloadSelectorFluent<A extends io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> matchLabels;

  public WorkloadSelectorFluent() {
  }
  
  public WorkloadSelectorFluent(WorkloadSelector instance) {
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
  
  public A addToMatchLabels(Map<String,String> map) {
    if (this.matchLabels == null && map != null) {
      this.matchLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.matchLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMatchLabels(String key,String value) {
    if (this.matchLabels == null && key != null && value != null) {
      this.matchLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.matchLabels.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(WorkloadSelector instance) {
    instance = instance != null ? instance : new WorkloadSelector();
    if (instance != null) {
        this.withMatchLabels(instance.getMatchLabels());
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
    WorkloadSelectorFluent that = (WorkloadSelectorFluent) o;
    if (!(Objects.equals(matchLabels, that.matchLabels))) {
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
  
  public Map<String,String> getMatchLabels() {
    return this.matchLabels;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchLabels() {
    return this.matchLabels != null;
  }
  
  public int hashCode() {
    return Objects.hash(matchLabels, additionalProperties);
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
  
  public A removeFromMatchLabels(String key) {
    if (this.matchLabels == null) {
      return (A) this;
    }
    if (key != null && this.matchLabels != null) {
      this.matchLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMatchLabels(Map<String,String> map) {
    if (this.matchLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.matchLabels != null) {
          this.matchLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(matchLabels == null) && !(matchLabels.isEmpty())) {
        sb.append("matchLabels:");
        sb.append(matchLabels);
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
  
  public <K,V>A withMatchLabels(Map<String,String> matchLabels) {
    if (matchLabels == null) {
      this.matchLabels = null;
    } else {
      this.matchLabels = new LinkedHashMap(matchLabels);
    }
    return (A) this;
  }
  
}