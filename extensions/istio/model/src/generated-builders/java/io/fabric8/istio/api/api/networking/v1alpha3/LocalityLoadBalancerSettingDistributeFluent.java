package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class LocalityLoadBalancerSettingDistributeFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.LocalityLoadBalancerSettingDistributeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String from;
  private Map<String,Long> to;

  public LocalityLoadBalancerSettingDistributeFluent() {
  }
  
  public LocalityLoadBalancerSettingDistributeFluent(LocalityLoadBalancerSettingDistribute instance) {
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
  
  public A addToTo(Map<String,Long> map) {
    if (this.to == null && map != null) {
      this.to = new LinkedHashMap();
    }
    if (map != null) {
      this.to.putAll(map);
    }
    return (A) this;
  }
  
  public A addToTo(String key,Long value) {
    if (this.to == null && key != null && value != null) {
      this.to = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.to.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(LocalityLoadBalancerSettingDistribute instance) {
    instance = instance != null ? instance : new LocalityLoadBalancerSettingDistribute();
    if (instance != null) {
        this.withFrom(instance.getFrom());
        this.withTo(instance.getTo());
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
    LocalityLoadBalancerSettingDistributeFluent that = (LocalityLoadBalancerSettingDistributeFluent) o;
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
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
  
  public String getFrom() {
    return this.from;
  }
  
  public Map<String,Long> getTo() {
    return this.to;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasTo() {
    return this.to != null;
  }
  
  public int hashCode() {
    return Objects.hash(from, to, additionalProperties);
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
  
  public A removeFromTo(String key) {
    if (this.to == null) {
      return (A) this;
    }
    if (key != null && this.to != null) {
      this.to.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromTo(Map<String,Long> map) {
    if (this.to == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.to != null) {
          this.to.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(to == null) && !(to.isEmpty())) {
        sb.append("to:");
        sb.append(to);
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
  
  public A withFrom(String from) {
    this.from = from;
    return (A) this;
  }
  
  public <K,V>A withTo(Map<String,Long> to) {
    if (to == null) {
      this.to = null;
    } else {
      this.to = new LinkedHashMap(to);
    }
    return (A) this;
  }
  
}