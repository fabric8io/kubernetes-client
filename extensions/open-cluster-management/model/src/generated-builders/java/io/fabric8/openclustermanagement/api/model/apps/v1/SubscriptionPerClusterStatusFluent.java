package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class SubscriptionPerClusterStatusFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.SubscriptionPerClusterStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,SubscriptionUnitStatus> packages;

  public SubscriptionPerClusterStatusFluent() {
  }
  
  public SubscriptionPerClusterStatusFluent(SubscriptionPerClusterStatus instance) {
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
  
  public A addToPackages(Map<String,SubscriptionUnitStatus> map) {
    if (this.packages == null && map != null) {
      this.packages = new LinkedHashMap();
    }
    if (map != null) {
      this.packages.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPackages(String key,SubscriptionUnitStatus value) {
    if (this.packages == null && key != null && value != null) {
      this.packages = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.packages.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(SubscriptionPerClusterStatus instance) {
    instance = instance != null ? instance : new SubscriptionPerClusterStatus();
    if (instance != null) {
        this.withPackages(instance.getPackages());
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
    SubscriptionPerClusterStatusFluent that = (SubscriptionPerClusterStatusFluent) o;
    if (!(Objects.equals(packages, that.packages))) {
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
  
  public Map<String,SubscriptionUnitStatus> getPackages() {
    return this.packages;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPackages() {
    return this.packages != null;
  }
  
  public int hashCode() {
    return Objects.hash(packages, additionalProperties);
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
  
  public A removeFromPackages(String key) {
    if (this.packages == null) {
      return (A) this;
    }
    if (key != null && this.packages != null) {
      this.packages.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPackages(Map<String,SubscriptionUnitStatus> map) {
    if (this.packages == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.packages != null) {
          this.packages.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(packages == null) && !(packages.isEmpty())) {
        sb.append("packages:");
        sb.append(packages);
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
  
  public <K,V>A withPackages(Map<String,SubscriptionUnitStatus> packages) {
    if (packages == null) {
      this.packages = null;
    } else {
      this.packages = new LinkedHashMap(packages);
    }
    return (A) this;
  }
  
}