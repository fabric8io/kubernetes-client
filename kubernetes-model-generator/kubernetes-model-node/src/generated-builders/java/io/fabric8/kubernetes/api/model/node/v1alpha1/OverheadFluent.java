package io.fabric8.kubernetes.api.model.node.v1alpha1;

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
public class OverheadFluent<A extends io.fabric8.kubernetes.api.model.node.v1alpha1.OverheadFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Quantity> podFixed;

  public OverheadFluent() {
  }
  
  public OverheadFluent(Overhead instance) {
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
  
  public A addToPodFixed(Map<String,Quantity> map) {
    if (this.podFixed == null && map != null) {
      this.podFixed = new LinkedHashMap();
    }
    if (map != null) {
      this.podFixed.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPodFixed(String key,Quantity value) {
    if (this.podFixed == null && key != null && value != null) {
      this.podFixed = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.podFixed.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(Overhead instance) {
    instance = instance != null ? instance : new Overhead();
    if (instance != null) {
        this.withPodFixed(instance.getPodFixed());
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
    OverheadFluent that = (OverheadFluent) o;
    if (!(Objects.equals(podFixed, that.podFixed))) {
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
  
  public Map<String,Quantity> getPodFixed() {
    return this.podFixed;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPodFixed() {
    return this.podFixed != null;
  }
  
  public int hashCode() {
    return Objects.hash(podFixed, additionalProperties);
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
  
  public A removeFromPodFixed(String key) {
    if (this.podFixed == null) {
      return (A) this;
    }
    if (key != null && this.podFixed != null) {
      this.podFixed.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPodFixed(Map<String,Quantity> map) {
    if (this.podFixed == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.podFixed != null) {
          this.podFixed.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(podFixed == null) && !(podFixed.isEmpty())) {
        sb.append("podFixed:");
        sb.append(podFixed);
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
  
  public <K,V>A withPodFixed(Map<String,Quantity> podFixed) {
    if (podFixed == null) {
      this.podFixed = null;
    } else {
      this.podFixed = new LinkedHashMap(podFixed);
    }
    return (A) this;
  }
  
}