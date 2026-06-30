package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class EnvFromSourceFluent<A extends io.fabric8.kubernetes.api.model.EnvFromSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapEnvSourceBuilder configMapRef;
  private String prefix;
  private SecretEnvSourceBuilder secretRef;

  public EnvFromSourceFluent() {
  }
  
  public EnvFromSourceFluent(EnvFromSource instance) {
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
  
  public ConfigMapEnvSource buildConfigMapRef() {
    return this.configMapRef != null ? this.configMapRef.build() : null;
  }
  
  public SecretEnvSource buildSecretRef() {
    return this.secretRef != null ? this.secretRef.build() : null;
  }
  
  protected void copyInstance(EnvFromSource instance) {
    instance = instance != null ? instance : new EnvFromSource();
    if (instance != null) {
        this.withConfigMapRef(instance.getConfigMapRef());
        this.withPrefix(instance.getPrefix());
        this.withSecretRef(instance.getSecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigMapRefNested<A> editConfigMapRef() {
    return this.withNewConfigMapRefLike(Optional.ofNullable(this.buildConfigMapRef()).orElse(null));
  }
  
  public ConfigMapRefNested<A> editOrNewConfigMapRef() {
    return this.withNewConfigMapRefLike(Optional.ofNullable(this.buildConfigMapRef()).orElse(new ConfigMapEnvSourceBuilder().build()));
  }
  
  public ConfigMapRefNested<A> editOrNewConfigMapRefLike(ConfigMapEnvSource item) {
    return this.withNewConfigMapRefLike(Optional.ofNullable(this.buildConfigMapRef()).orElse(item));
  }
  
  public SecretRefNested<A> editOrNewSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(new SecretEnvSourceBuilder().build()));
  }
  
  public SecretRefNested<A> editOrNewSecretRefLike(SecretEnvSource item) {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(item));
  }
  
  public SecretRefNested<A> editSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(null));
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
    EnvFromSourceFluent that = (EnvFromSourceFluent) o;
    if (!(Objects.equals(configMapRef, that.configMapRef))) {
      return false;
    }
    if (!(Objects.equals(prefix, that.prefix))) {
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
  
  public String getPrefix() {
    return this.prefix;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigMapRef() {
    return this.configMapRef != null;
  }
  
  public boolean hasPrefix() {
    return this.prefix != null;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(configMapRef, prefix, secretRef, additionalProperties);
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
    if (!(configMapRef == null)) {
        sb.append("configMapRef:");
        sb.append(configMapRef);
        sb.append(",");
    }
    if (!(prefix == null)) {
        sb.append("prefix:");
        sb.append(prefix);
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
  
  public A withConfigMapRef(ConfigMapEnvSource configMapRef) {
    this._visitables.remove("configMapRef");
    if (configMapRef != null) {
        this.configMapRef = new ConfigMapEnvSourceBuilder(configMapRef);
        this._visitables.get("configMapRef").add(this.configMapRef);
    } else {
        this.configMapRef = null;
        this._visitables.get("configMapRef").remove(this.configMapRef);
    }
    return (A) this;
  }
  
  public ConfigMapRefNested<A> withNewConfigMapRef() {
    return new ConfigMapRefNested(null);
  }
  
  public A withNewConfigMapRef(String name,Boolean optional) {
    return (A) this.withConfigMapRef(new ConfigMapEnvSource(name, optional));
  }
  
  public ConfigMapRefNested<A> withNewConfigMapRefLike(ConfigMapEnvSource item) {
    return new ConfigMapRefNested(item);
  }
  
  public SecretRefNested<A> withNewSecretRef() {
    return new SecretRefNested(null);
  }
  
  public A withNewSecretRef(String name,Boolean optional) {
    return (A) this.withSecretRef(new SecretEnvSource(name, optional));
  }
  
  public SecretRefNested<A> withNewSecretRefLike(SecretEnvSource item) {
    return new SecretRefNested(item);
  }
  
  public A withPrefix(String prefix) {
    this.prefix = prefix;
    return (A) this;
  }
  
  public A withSecretRef(SecretEnvSource secretRef) {
    this._visitables.remove("secretRef");
    if (secretRef != null) {
        this.secretRef = new SecretEnvSourceBuilder(secretRef);
        this._visitables.get("secretRef").add(this.secretRef);
    } else {
        this.secretRef = null;
        this._visitables.get("secretRef").remove(this.secretRef);
    }
    return (A) this;
  }
  public class ConfigMapRefNested<N> extends ConfigMapEnvSourceFluent<ConfigMapRefNested<N>> implements Nested<N>{
  
    ConfigMapEnvSourceBuilder builder;
  
    ConfigMapRefNested(ConfigMapEnvSource item) {
      this.builder = new ConfigMapEnvSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvFromSourceFluent.this.withConfigMapRef(builder.build());
    }
    
    public N endConfigMapRef() {
      return and();
    }
    
  }
  public class SecretRefNested<N> extends SecretEnvSourceFluent<SecretRefNested<N>> implements Nested<N>{
  
    SecretEnvSourceBuilder builder;
  
    SecretRefNested(SecretEnvSource item) {
      this.builder = new SecretEnvSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvFromSourceFluent.this.withSecretRef(builder.build());
    }
    
    public N endSecretRef() {
      return and();
    }
    
  }
}