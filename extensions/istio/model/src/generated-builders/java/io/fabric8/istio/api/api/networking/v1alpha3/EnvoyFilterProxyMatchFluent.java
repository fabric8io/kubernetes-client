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
public class EnvoyFilterProxyMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterProxyMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> metadata;
  private String proxyVersion;

  public EnvoyFilterProxyMatchFluent() {
  }
  
  public EnvoyFilterProxyMatchFluent(EnvoyFilterProxyMatch instance) {
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
  
  public A addToMetadata(Map<String,String> map) {
    if (this.metadata == null && map != null) {
      this.metadata = new LinkedHashMap();
    }
    if (map != null) {
      this.metadata.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMetadata(String key,String value) {
    if (this.metadata == null && key != null && value != null) {
      this.metadata = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.metadata.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(EnvoyFilterProxyMatch instance) {
    instance = instance != null ? instance : new EnvoyFilterProxyMatch();
    if (instance != null) {
        this.withMetadata(instance.getMetadata());
        this.withProxyVersion(instance.getProxyVersion());
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
    EnvoyFilterProxyMatchFluent that = (EnvoyFilterProxyMatchFluent) o;
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(proxyVersion, that.proxyVersion))) {
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
  
  public Map<String,String> getMetadata() {
    return this.metadata;
  }
  
  public String getProxyVersion() {
    return this.proxyVersion;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasProxyVersion() {
    return this.proxyVersion != null;
  }
  
  public int hashCode() {
    return Objects.hash(metadata, proxyVersion, additionalProperties);
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
  
  public A removeFromMetadata(String key) {
    if (this.metadata == null) {
      return (A) this;
    }
    if (key != null && this.metadata != null) {
      this.metadata.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMetadata(Map<String,String> map) {
    if (this.metadata == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.metadata != null) {
          this.metadata.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(metadata == null) && !(metadata.isEmpty())) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(proxyVersion == null)) {
        sb.append("proxyVersion:");
        sb.append(proxyVersion);
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
  
  public <K,V>A withMetadata(Map<String,String> metadata) {
    if (metadata == null) {
      this.metadata = null;
    } else {
      this.metadata = new LinkedHashMap(metadata);
    }
    return (A) this;
  }
  
  public A withProxyVersion(String proxyVersion) {
    this.proxyVersion = proxyVersion;
    return (A) this;
  }
  
}