package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorBuilder;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorFluent;
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
public class ACMEExternalAccountBindingFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEExternalAccountBindingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String keyAlgorithm;
  private String keyID;
  private SecretKeySelectorBuilder keySecretRef;

  public ACMEExternalAccountBindingFluent() {
  }
  
  public ACMEExternalAccountBindingFluent(ACMEExternalAccountBinding instance) {
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
  
  public SecretKeySelector buildKeySecretRef() {
    return this.keySecretRef != null ? this.keySecretRef.build() : null;
  }
  
  protected void copyInstance(ACMEExternalAccountBinding instance) {
    instance = instance != null ? instance : new ACMEExternalAccountBinding();
    if (instance != null) {
        this.withKeyAlgorithm(instance.getKeyAlgorithm());
        this.withKeyID(instance.getKeyID());
        this.withKeySecretRef(instance.getKeySecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KeySecretRefNested<A> editKeySecretRef() {
    return this.withNewKeySecretRefLike(Optional.ofNullable(this.buildKeySecretRef()).orElse(null));
  }
  
  public KeySecretRefNested<A> editOrNewKeySecretRef() {
    return this.withNewKeySecretRefLike(Optional.ofNullable(this.buildKeySecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public KeySecretRefNested<A> editOrNewKeySecretRefLike(SecretKeySelector item) {
    return this.withNewKeySecretRefLike(Optional.ofNullable(this.buildKeySecretRef()).orElse(item));
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
    ACMEExternalAccountBindingFluent that = (ACMEExternalAccountBindingFluent) o;
    if (!(Objects.equals(keyAlgorithm, that.keyAlgorithm))) {
      return false;
    }
    if (!(Objects.equals(keyID, that.keyID))) {
      return false;
    }
    if (!(Objects.equals(keySecretRef, that.keySecretRef))) {
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
  
  public String getKeyAlgorithm() {
    return this.keyAlgorithm;
  }
  
  public String getKeyID() {
    return this.keyID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasKeyAlgorithm() {
    return this.keyAlgorithm != null;
  }
  
  public boolean hasKeyID() {
    return this.keyID != null;
  }
  
  public boolean hasKeySecretRef() {
    return this.keySecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(keyAlgorithm, keyID, keySecretRef, additionalProperties);
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
    if (!(keyAlgorithm == null)) {
        sb.append("keyAlgorithm:");
        sb.append(keyAlgorithm);
        sb.append(",");
    }
    if (!(keyID == null)) {
        sb.append("keyID:");
        sb.append(keyID);
        sb.append(",");
    }
    if (!(keySecretRef == null)) {
        sb.append("keySecretRef:");
        sb.append(keySecretRef);
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
  
  public A withKeyAlgorithm(String keyAlgorithm) {
    this.keyAlgorithm = keyAlgorithm;
    return (A) this;
  }
  
  public A withKeyID(String keyID) {
    this.keyID = keyID;
    return (A) this;
  }
  
  public A withKeySecretRef(SecretKeySelector keySecretRef) {
    this._visitables.remove("keySecretRef");
    if (keySecretRef != null) {
        this.keySecretRef = new SecretKeySelectorBuilder(keySecretRef);
        this._visitables.get("keySecretRef").add(this.keySecretRef);
    } else {
        this.keySecretRef = null;
        this._visitables.get("keySecretRef").remove(this.keySecretRef);
    }
    return (A) this;
  }
  
  public KeySecretRefNested<A> withNewKeySecretRef() {
    return new KeySecretRefNested(null);
  }
  
  public A withNewKeySecretRef(String key,String name) {
    return (A) this.withKeySecretRef(new SecretKeySelector(key, name));
  }
  
  public KeySecretRefNested<A> withNewKeySecretRefLike(SecretKeySelector item) {
    return new KeySecretRefNested(item);
  }
  public class KeySecretRefNested<N> extends SecretKeySelectorFluent<KeySecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    KeySecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEExternalAccountBindingFluent.this.withKeySecretRef(builder.build());
    }
    
    public N endKeySecretRef() {
      return and();
    }
    
  }
}