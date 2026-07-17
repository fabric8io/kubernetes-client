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
public class PublicKeyFluent<A extends io.fabric8.openshift.api.model.config.v1.PublicKeyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String keyData;
  private String rekorKeyData;

  public PublicKeyFluent() {
  }
  
  public PublicKeyFluent(PublicKey instance) {
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
  
  protected void copyInstance(PublicKey instance) {
    instance = instance != null ? instance : new PublicKey();
    if (instance != null) {
        this.withKeyData(instance.getKeyData());
        this.withRekorKeyData(instance.getRekorKeyData());
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
    PublicKeyFluent that = (PublicKeyFluent) o;
    if (!(Objects.equals(keyData, that.keyData))) {
      return false;
    }
    if (!(Objects.equals(rekorKeyData, that.rekorKeyData))) {
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
  
  public String getKeyData() {
    return this.keyData;
  }
  
  public String getRekorKeyData() {
    return this.rekorKeyData;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasKeyData() {
    return this.keyData != null;
  }
  
  public boolean hasRekorKeyData() {
    return this.rekorKeyData != null;
  }
  
  public int hashCode() {
    return Objects.hash(keyData, rekorKeyData, additionalProperties);
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
    if (!(keyData == null)) {
        sb.append("keyData:");
        sb.append(keyData);
        sb.append(",");
    }
    if (!(rekorKeyData == null)) {
        sb.append("rekorKeyData:");
        sb.append(rekorKeyData);
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
  
  public A withKeyData(String keyData) {
    this.keyData = keyData;
    return (A) this;
  }
  
  public A withRekorKeyData(String rekorKeyData) {
    this.rekorKeyData = rekorKeyData;
    return (A) this;
  }
  
}