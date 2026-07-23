package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class APIServerEncryptionFluent<A extends io.fabric8.openshift.api.model.config.v1.APIServerEncryptionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private KMSConfigBuilder kms;
  private String type;

  public APIServerEncryptionFluent() {
  }
  
  public APIServerEncryptionFluent(APIServerEncryption instance) {
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
  
  public KMSConfig buildKms() {
    return this.kms != null ? this.kms.build() : null;
  }
  
  protected void copyInstance(APIServerEncryption instance) {
    instance = instance != null ? instance : new APIServerEncryption();
    if (instance != null) {
        this.withKms(instance.getKms());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KmsNested<A> editKms() {
    return this.withNewKmsLike(Optional.ofNullable(this.buildKms()).orElse(null));
  }
  
  public KmsNested<A> editOrNewKms() {
    return this.withNewKmsLike(Optional.ofNullable(this.buildKms()).orElse(new KMSConfigBuilder().build()));
  }
  
  public KmsNested<A> editOrNewKmsLike(KMSConfig item) {
    return this.withNewKmsLike(Optional.ofNullable(this.buildKms()).orElse(item));
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
    APIServerEncryptionFluent that = (APIServerEncryptionFluent) o;
    if (!(Objects.equals(kms, that.kms))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasKms() {
    return this.kms != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(kms, type, additionalProperties);
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
    if (!(kms == null)) {
        sb.append("kms:");
        sb.append(kms);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withKms(KMSConfig kms) {
    this._visitables.remove("kms");
    if (kms != null) {
        this.kms = new KMSConfigBuilder(kms);
        this._visitables.get("kms").add(this.kms);
    } else {
        this.kms = null;
        this._visitables.get("kms").remove(this.kms);
    }
    return (A) this;
  }
  
  public KmsNested<A> withNewKms() {
    return new KmsNested(null);
  }
  
  public KmsNested<A> withNewKmsLike(KMSConfig item) {
    return new KmsNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class KmsNested<N> extends KMSConfigFluent<KmsNested<N>> implements Nested<N>{
  
    KMSConfigBuilder builder;
  
    KmsNested(KMSConfig item) {
      this.builder = new KMSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServerEncryptionFluent.this.withKms(builder.build());
    }
    
    public N endKms() {
      return and();
    }
    
  }
}