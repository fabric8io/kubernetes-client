package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class SecretSpecFluent<A extends io.fabric8.openshift.api.model.SecretSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mountPath;
  private LocalObjectReferenceBuilder secretSource;

  public SecretSpecFluent() {
  }
  
  public SecretSpecFluent(SecretSpec instance) {
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
  
  public LocalObjectReference buildSecretSource() {
    return this.secretSource != null ? this.secretSource.build() : null;
  }
  
  protected void copyInstance(SecretSpec instance) {
    instance = instance != null ? instance : new SecretSpec();
    if (instance != null) {
        this.withMountPath(instance.getMountPath());
        this.withSecretSource(instance.getSecretSource());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretSourceNested<A> editOrNewSecretSource() {
    return this.withNewSecretSourceLike(Optional.ofNullable(this.buildSecretSource()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public SecretSourceNested<A> editOrNewSecretSourceLike(LocalObjectReference item) {
    return this.withNewSecretSourceLike(Optional.ofNullable(this.buildSecretSource()).orElse(item));
  }
  
  public SecretSourceNested<A> editSecretSource() {
    return this.withNewSecretSourceLike(Optional.ofNullable(this.buildSecretSource()).orElse(null));
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
    SecretSpecFluent that = (SecretSpecFluent) o;
    if (!(Objects.equals(mountPath, that.mountPath))) {
      return false;
    }
    if (!(Objects.equals(secretSource, that.secretSource))) {
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
  
  public String getMountPath() {
    return this.mountPath;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMountPath() {
    return this.mountPath != null;
  }
  
  public boolean hasSecretSource() {
    return this.secretSource != null;
  }
  
  public int hashCode() {
    return Objects.hash(mountPath, secretSource, additionalProperties);
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
    if (!(mountPath == null)) {
        sb.append("mountPath:");
        sb.append(mountPath);
        sb.append(",");
    }
    if (!(secretSource == null)) {
        sb.append("secretSource:");
        sb.append(secretSource);
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
  
  public A withMountPath(String mountPath) {
    this.mountPath = mountPath;
    return (A) this;
  }
  
  public SecretSourceNested<A> withNewSecretSource() {
    return new SecretSourceNested(null);
  }
  
  public A withNewSecretSource(String name) {
    return (A) this.withSecretSource(new LocalObjectReference(name));
  }
  
  public SecretSourceNested<A> withNewSecretSourceLike(LocalObjectReference item) {
    return new SecretSourceNested(item);
  }
  
  public A withSecretSource(LocalObjectReference secretSource) {
    this._visitables.remove("secretSource");
    if (secretSource != null) {
        this.secretSource = new LocalObjectReferenceBuilder(secretSource);
        this._visitables.get("secretSource").add(this.secretSource);
    } else {
        this.secretSource = null;
        this._visitables.get("secretSource").remove(this.secretSource);
    }
    return (A) this;
  }
  public class SecretSourceNested<N> extends LocalObjectReferenceFluent<SecretSourceNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    SecretSourceNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SecretSpecFluent.this.withSecretSource(builder.build());
    }
    
    public N endSecretSource() {
      return and();
    }
    
  }
}