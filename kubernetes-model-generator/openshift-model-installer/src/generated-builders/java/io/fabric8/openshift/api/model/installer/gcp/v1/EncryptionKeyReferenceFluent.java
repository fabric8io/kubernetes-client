package io.fabric8.openshift.api.model.installer.gcp.v1;

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
public class EncryptionKeyReferenceFluent<A extends io.fabric8.openshift.api.model.installer.gcp.v1.EncryptionKeyReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private KMSKeyReferenceBuilder kmsKey;
  private String kmsKeyServiceAccount;

  public EncryptionKeyReferenceFluent() {
  }
  
  public EncryptionKeyReferenceFluent(EncryptionKeyReference instance) {
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
  
  public KMSKeyReference buildKmsKey() {
    return this.kmsKey != null ? this.kmsKey.build() : null;
  }
  
  protected void copyInstance(EncryptionKeyReference instance) {
    instance = instance != null ? instance : new EncryptionKeyReference();
    if (instance != null) {
        this.withKmsKey(instance.getKmsKey());
        this.withKmsKeyServiceAccount(instance.getKmsKeyServiceAccount());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KmsKeyNested<A> editKmsKey() {
    return this.withNewKmsKeyLike(Optional.ofNullable(this.buildKmsKey()).orElse(null));
  }
  
  public KmsKeyNested<A> editOrNewKmsKey() {
    return this.withNewKmsKeyLike(Optional.ofNullable(this.buildKmsKey()).orElse(new KMSKeyReferenceBuilder().build()));
  }
  
  public KmsKeyNested<A> editOrNewKmsKeyLike(KMSKeyReference item) {
    return this.withNewKmsKeyLike(Optional.ofNullable(this.buildKmsKey()).orElse(item));
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
    EncryptionKeyReferenceFluent that = (EncryptionKeyReferenceFluent) o;
    if (!(Objects.equals(kmsKey, that.kmsKey))) {
      return false;
    }
    if (!(Objects.equals(kmsKeyServiceAccount, that.kmsKeyServiceAccount))) {
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
  
  public String getKmsKeyServiceAccount() {
    return this.kmsKeyServiceAccount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasKmsKey() {
    return this.kmsKey != null;
  }
  
  public boolean hasKmsKeyServiceAccount() {
    return this.kmsKeyServiceAccount != null;
  }
  
  public int hashCode() {
    return Objects.hash(kmsKey, kmsKeyServiceAccount, additionalProperties);
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
    if (!(kmsKey == null)) {
        sb.append("kmsKey:");
        sb.append(kmsKey);
        sb.append(",");
    }
    if (!(kmsKeyServiceAccount == null)) {
        sb.append("kmsKeyServiceAccount:");
        sb.append(kmsKeyServiceAccount);
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
  
  public A withKmsKey(KMSKeyReference kmsKey) {
    this._visitables.remove("kmsKey");
    if (kmsKey != null) {
        this.kmsKey = new KMSKeyReferenceBuilder(kmsKey);
        this._visitables.get("kmsKey").add(this.kmsKey);
    } else {
        this.kmsKey = null;
        this._visitables.get("kmsKey").remove(this.kmsKey);
    }
    return (A) this;
  }
  
  public A withKmsKeyServiceAccount(String kmsKeyServiceAccount) {
    this.kmsKeyServiceAccount = kmsKeyServiceAccount;
    return (A) this;
  }
  
  public KmsKeyNested<A> withNewKmsKey() {
    return new KmsKeyNested(null);
  }
  
  public A withNewKmsKey(String keyRing,String location,String name,String projectID) {
    return (A) this.withKmsKey(new KMSKeyReference(keyRing, location, name, projectID));
  }
  
  public KmsKeyNested<A> withNewKmsKeyLike(KMSKeyReference item) {
    return new KmsKeyNested(item);
  }
  public class KmsKeyNested<N> extends KMSKeyReferenceFluent<KmsKeyNested<N>> implements Nested<N>{
  
    KMSKeyReferenceBuilder builder;
  
    KmsKeyNested(KMSKeyReference item) {
      this.builder = new KMSKeyReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EncryptionKeyReferenceFluent.this.withKmsKey(builder.build());
    }
    
    public N endKmsKey() {
      return and();
    }
    
  }
}