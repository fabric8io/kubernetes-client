package io.fabric8.openshift.api.model.operator.v1;

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
public class IPv6GatewayConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.IPv6GatewayConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String internalMasqueradeSubnet;

  public IPv6GatewayConfigFluent() {
  }
  
  public IPv6GatewayConfigFluent(IPv6GatewayConfig instance) {
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
  
  protected void copyInstance(IPv6GatewayConfig instance) {
    instance = instance != null ? instance : new IPv6GatewayConfig();
    if (instance != null) {
        this.withInternalMasqueradeSubnet(instance.getInternalMasqueradeSubnet());
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
    IPv6GatewayConfigFluent that = (IPv6GatewayConfigFluent) o;
    if (!(Objects.equals(internalMasqueradeSubnet, that.internalMasqueradeSubnet))) {
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
  
  public String getInternalMasqueradeSubnet() {
    return this.internalMasqueradeSubnet;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasInternalMasqueradeSubnet() {
    return this.internalMasqueradeSubnet != null;
  }
  
  public int hashCode() {
    return Objects.hash(internalMasqueradeSubnet, additionalProperties);
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
    if (!(internalMasqueradeSubnet == null)) {
        sb.append("internalMasqueradeSubnet:");
        sb.append(internalMasqueradeSubnet);
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
  
  public A withInternalMasqueradeSubnet(String internalMasqueradeSubnet) {
    this.internalMasqueradeSubnet = internalMasqueradeSubnet;
    return (A) this;
  }
  
}