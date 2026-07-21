package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
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
public class KeyRefFluent<A extends io.fabric8.tekton.v1alpha1.KeyRefFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String data;
  private String hashAlgorithm;
  private String kms;
  private SecretReference secretRef;

  public KeyRefFluent() {
  }
  
  public KeyRefFluent(KeyRef instance) {
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
  
  protected void copyInstance(KeyRef instance) {
    instance = instance != null ? instance : new KeyRef();
    if (instance != null) {
        this.withData(instance.getData());
        this.withHashAlgorithm(instance.getHashAlgorithm());
        this.withKms(instance.getKms());
        this.withSecretRef(instance.getSecretRef());
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
    KeyRefFluent that = (KeyRefFluent) o;
    if (!(Objects.equals(data, that.data))) {
      return false;
    }
    if (!(Objects.equals(hashAlgorithm, that.hashAlgorithm))) {
      return false;
    }
    if (!(Objects.equals(kms, that.kms))) {
      return false;
    }
    if (!(Objects.equals(secretRef, that.secretRef))) {
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
  
  public String getData() {
    return this.data;
  }
  
  public String getHashAlgorithm() {
    return this.hashAlgorithm;
  }
  
  public String getKms() {
    return this.kms;
  }
  
  public SecretReference getSecretRef() {
    return this.secretRef;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasData() {
    return this.data != null;
  }
  
  public boolean hasHashAlgorithm() {
    return this.hashAlgorithm != null;
  }
  
  public boolean hasKms() {
    return this.kms != null;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(data, hashAlgorithm, kms, secretRef, additionalProperties);
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
    if (!(data == null)) {
        sb.append("data:");
        sb.append(data);
        sb.append(",");
    }
    if (!(hashAlgorithm == null)) {
        sb.append("hashAlgorithm:");
        sb.append(hashAlgorithm);
        sb.append(",");
    }
    if (!(kms == null)) {
        sb.append("kms:");
        sb.append(kms);
        sb.append(",");
    }
    if (!(secretRef == null)) {
        sb.append("secretRef:");
        sb.append(secretRef);
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
  
  public A withData(String data) {
    this.data = data;
    return (A) this;
  }
  
  public A withHashAlgorithm(String hashAlgorithm) {
    this.hashAlgorithm = hashAlgorithm;
    return (A) this;
  }
  
  public A withKms(String kms) {
    this.kms = kms;
    return (A) this;
  }
  
  public A withNewSecretRef(String name,String namespace) {
    return (A) this.withSecretRef(new SecretReference(name, namespace));
  }
  
  public A withSecretRef(SecretReference secretRef) {
    this.secretRef = secretRef;
    return (A) this;
  }
  
}