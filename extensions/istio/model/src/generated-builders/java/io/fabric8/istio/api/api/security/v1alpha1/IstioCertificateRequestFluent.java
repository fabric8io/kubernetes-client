package io.fabric8.istio.api.api.security.v1alpha1;

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
public class IstioCertificateRequestFluent<A extends io.fabric8.istio.api.api.security.v1alpha1.IstioCertificateRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String csr;
  private Object metadata;
  private Long validityDuration;

  public IstioCertificateRequestFluent() {
  }
  
  public IstioCertificateRequestFluent(IstioCertificateRequest instance) {
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
  
  protected void copyInstance(IstioCertificateRequest instance) {
    instance = instance != null ? instance : new IstioCertificateRequest();
    if (instance != null) {
        this.withCsr(instance.getCsr());
        this.withMetadata(instance.getMetadata());
        this.withValidityDuration(instance.getValidityDuration());
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
    IstioCertificateRequestFluent that = (IstioCertificateRequestFluent) o;
    if (!(Objects.equals(csr, that.csr))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(validityDuration, that.validityDuration))) {
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
  
  public String getCsr() {
    return this.csr;
  }
  
  public Object getMetadata() {
    return this.metadata;
  }
  
  public Long getValidityDuration() {
    return this.validityDuration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCsr() {
    return this.csr != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasValidityDuration() {
    return this.validityDuration != null;
  }
  
  public int hashCode() {
    return Objects.hash(csr, metadata, validityDuration, additionalProperties);
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
    if (!(csr == null)) {
        sb.append("csr:");
        sb.append(csr);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(validityDuration == null)) {
        sb.append("validityDuration:");
        sb.append(validityDuration);
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
  
  public A withCsr(String csr) {
    this.csr = csr;
    return (A) this;
  }
  
  public A withMetadata(Object metadata) {
    this.metadata = metadata;
    return (A) this;
  }
  
  public A withValidityDuration(Long validityDuration) {
    this.validityDuration = validityDuration;
    return (A) this;
  }
  
}