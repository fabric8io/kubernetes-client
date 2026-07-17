package io.fabric8.openshift.api.model.config.v1;

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
public class EquinixMetalPlatformStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.EquinixMetalPlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiServerInternalIP;
  private String ingressIP;

  public EquinixMetalPlatformStatusFluent() {
  }
  
  public EquinixMetalPlatformStatusFluent(EquinixMetalPlatformStatus instance) {
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
  
  protected void copyInstance(EquinixMetalPlatformStatus instance) {
    instance = instance != null ? instance : new EquinixMetalPlatformStatus();
    if (instance != null) {
        this.withApiServerInternalIP(instance.getApiServerInternalIP());
        this.withIngressIP(instance.getIngressIP());
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
    EquinixMetalPlatformStatusFluent that = (EquinixMetalPlatformStatusFluent) o;
    if (!(Objects.equals(apiServerInternalIP, that.apiServerInternalIP))) {
      return false;
    }
    if (!(Objects.equals(ingressIP, that.ingressIP))) {
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
  
  public String getApiServerInternalIP() {
    return this.apiServerInternalIP;
  }
  
  public String getIngressIP() {
    return this.ingressIP;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiServerInternalIP() {
    return this.apiServerInternalIP != null;
  }
  
  public boolean hasIngressIP() {
    return this.ingressIP != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiServerInternalIP, ingressIP, additionalProperties);
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
    if (!(apiServerInternalIP == null)) {
        sb.append("apiServerInternalIP:");
        sb.append(apiServerInternalIP);
        sb.append(",");
    }
    if (!(ingressIP == null)) {
        sb.append("ingressIP:");
        sb.append(ingressIP);
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
  
  public A withApiServerInternalIP(String apiServerInternalIP) {
    this.apiServerInternalIP = apiServerInternalIP;
    return (A) this;
  }
  
  public A withIngressIP(String ingressIP) {
    this.ingressIP = ingressIP;
    return (A) this;
  }
  
}