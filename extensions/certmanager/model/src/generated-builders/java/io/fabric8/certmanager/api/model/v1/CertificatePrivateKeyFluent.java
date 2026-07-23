package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class CertificatePrivateKeyFluent<A extends io.fabric8.certmanager.api.model.v1.CertificatePrivateKeyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String algorithm;
  private String encoding;
  private String rotationPolicy;
  private Integer size;

  public CertificatePrivateKeyFluent() {
  }
  
  public CertificatePrivateKeyFluent(CertificatePrivateKey instance) {
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
  
  protected void copyInstance(CertificatePrivateKey instance) {
    instance = instance != null ? instance : new CertificatePrivateKey();
    if (instance != null) {
        this.withAlgorithm(instance.getAlgorithm());
        this.withEncoding(instance.getEncoding());
        this.withRotationPolicy(instance.getRotationPolicy());
        this.withSize(instance.getSize());
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
    CertificatePrivateKeyFluent that = (CertificatePrivateKeyFluent) o;
    if (!(Objects.equals(algorithm, that.algorithm))) {
      return false;
    }
    if (!(Objects.equals(encoding, that.encoding))) {
      return false;
    }
    if (!(Objects.equals(rotationPolicy, that.rotationPolicy))) {
      return false;
    }
    if (!(Objects.equals(size, that.size))) {
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
  
  public String getAlgorithm() {
    return this.algorithm;
  }
  
  public String getEncoding() {
    return this.encoding;
  }
  
  public String getRotationPolicy() {
    return this.rotationPolicy;
  }
  
  public Integer getSize() {
    return this.size;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlgorithm() {
    return this.algorithm != null;
  }
  
  public boolean hasEncoding() {
    return this.encoding != null;
  }
  
  public boolean hasRotationPolicy() {
    return this.rotationPolicy != null;
  }
  
  public boolean hasSize() {
    return this.size != null;
  }
  
  public int hashCode() {
    return Objects.hash(algorithm, encoding, rotationPolicy, size, additionalProperties);
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
    if (!(algorithm == null)) {
        sb.append("algorithm:");
        sb.append(algorithm);
        sb.append(",");
    }
    if (!(encoding == null)) {
        sb.append("encoding:");
        sb.append(encoding);
        sb.append(",");
    }
    if (!(rotationPolicy == null)) {
        sb.append("rotationPolicy:");
        sb.append(rotationPolicy);
        sb.append(",");
    }
    if (!(size == null)) {
        sb.append("size:");
        sb.append(size);
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
  
  public A withAlgorithm(String algorithm) {
    this.algorithm = algorithm;
    return (A) this;
  }
  
  public A withEncoding(String encoding) {
    this.encoding = encoding;
    return (A) this;
  }
  
  public A withRotationPolicy(String rotationPolicy) {
    this.rotationPolicy = rotationPolicy;
    return (A) this;
  }
  
  public A withSize(Integer size) {
    this.size = size;
    return (A) this;
  }
  
}