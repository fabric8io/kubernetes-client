package io.fabric8.kubernetes.api.model;

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
public class ResourceQuotaStatusFluent<A extends io.fabric8.kubernetes.api.model.ResourceQuotaStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Quantity> hard;
  private Map<String,Quantity> used;

  public ResourceQuotaStatusFluent() {
  }
  
  public ResourceQuotaStatusFluent(ResourceQuotaStatus instance) {
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
  
  public A addToHard(Map<String,Quantity> map) {
    if (this.hard == null && map != null) {
      this.hard = new LinkedHashMap();
    }
    if (map != null) {
      this.hard.putAll(map);
    }
    return (A) this;
  }
  
  public A addToHard(String key,Quantity value) {
    if (this.hard == null && key != null && value != null) {
      this.hard = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.hard.put(key, value);
    }
    return (A) this;
  }
  
  public A addToUsed(Map<String,Quantity> map) {
    if (this.used == null && map != null) {
      this.used = new LinkedHashMap();
    }
    if (map != null) {
      this.used.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUsed(String key,Quantity value) {
    if (this.used == null && key != null && value != null) {
      this.used = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.used.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(ResourceQuotaStatus instance) {
    instance = instance != null ? instance : new ResourceQuotaStatus();
    if (instance != null) {
        this.withHard(instance.getHard());
        this.withUsed(instance.getUsed());
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
    ResourceQuotaStatusFluent that = (ResourceQuotaStatusFluent) o;
    if (!(Objects.equals(hard, that.hard))) {
      return false;
    }
    if (!(Objects.equals(used, that.used))) {
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
  
  public Map<String,Quantity> getHard() {
    return this.hard;
  }
  
  public Map<String,Quantity> getUsed() {
    return this.used;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHard() {
    return this.hard != null;
  }
  
  public boolean hasUsed() {
    return this.used != null;
  }
  
  public int hashCode() {
    return Objects.hash(hard, used, additionalProperties);
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
  
  public A removeFromHard(String key) {
    if (this.hard == null) {
      return (A) this;
    }
    if (key != null && this.hard != null) {
      this.hard.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromHard(Map<String,Quantity> map) {
    if (this.hard == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.hard != null) {
          this.hard.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromUsed(String key) {
    if (this.used == null) {
      return (A) this;
    }
    if (key != null && this.used != null) {
      this.used.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUsed(Map<String,Quantity> map) {
    if (this.used == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.used != null) {
          this.used.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hard == null) && !(hard.isEmpty())) {
        sb.append("hard:");
        sb.append(hard);
        sb.append(",");
    }
    if (!(used == null) && !(used.isEmpty())) {
        sb.append("used:");
        sb.append(used);
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
  
  public <K,V>A withHard(Map<String,Quantity> hard) {
    if (hard == null) {
      this.hard = null;
    } else {
      this.hard = new LinkedHashMap(hard);
    }
    return (A) this;
  }
  
  public <K,V>A withUsed(Map<String,Quantity> used) {
    if (used == null) {
      this.used = null;
    } else {
      this.used = new LinkedHashMap(used);
    }
    return (A) this;
  }
  
}