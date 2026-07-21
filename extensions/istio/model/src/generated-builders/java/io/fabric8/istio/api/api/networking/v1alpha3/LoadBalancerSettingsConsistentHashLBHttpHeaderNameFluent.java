package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String httpHeaderName;

  public LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent() {
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent(LoadBalancerSettingsConsistentHashLBHttpHeaderName instance) {
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
  
  protected void copyInstance(LoadBalancerSettingsConsistentHashLBHttpHeaderName instance) {
    instance = instance != null ? instance : new LoadBalancerSettingsConsistentHashLBHttpHeaderName();
    if (instance != null) {
        this.withHttpHeaderName(instance.getHttpHeaderName());
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
    LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent that = (LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent) o;
    if (!(Objects.equals(httpHeaderName, that.httpHeaderName))) {
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
  
  public String getHttpHeaderName() {
    return this.httpHeaderName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttpHeaderName() {
    return this.httpHeaderName != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpHeaderName, additionalProperties);
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
    if (!(httpHeaderName == null)) {
        sb.append("httpHeaderName:");
        sb.append(httpHeaderName);
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
  
  public A withHttpHeaderName(String httpHeaderName) {
    this.httpHeaderName = httpHeaderName;
    return (A) this;
  }
  
}