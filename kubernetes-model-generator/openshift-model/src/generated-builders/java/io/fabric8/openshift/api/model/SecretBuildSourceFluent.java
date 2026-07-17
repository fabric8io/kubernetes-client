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
public class SecretBuildSourceFluent<A extends io.fabric8.openshift.api.model.SecretBuildSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String destinationDir;
  private LocalObjectReferenceBuilder secret;

  public SecretBuildSourceFluent() {
  }
  
  public SecretBuildSourceFluent(SecretBuildSource instance) {
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
  
  public LocalObjectReference buildSecret() {
    return this.secret != null ? this.secret.build() : null;
  }
  
  protected void copyInstance(SecretBuildSource instance) {
    instance = instance != null ? instance : new SecretBuildSource();
    if (instance != null) {
        this.withDestinationDir(instance.getDestinationDir());
        this.withSecret(instance.getSecret());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretNested<A> editOrNewSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public SecretNested<A> editOrNewSecretLike(LocalObjectReference item) {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(item));
  }
  
  public SecretNested<A> editSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(null));
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
    SecretBuildSourceFluent that = (SecretBuildSourceFluent) o;
    if (!(Objects.equals(destinationDir, that.destinationDir))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
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
  
  public String getDestinationDir() {
    return this.destinationDir;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDestinationDir() {
    return this.destinationDir != null;
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public int hashCode() {
    return Objects.hash(destinationDir, secret, additionalProperties);
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
    if (!(destinationDir == null)) {
        sb.append("destinationDir:");
        sb.append(destinationDir);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
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
  
  public A withDestinationDir(String destinationDir) {
    this.destinationDir = destinationDir;
    return (A) this;
  }
  
  public SecretNested<A> withNewSecret() {
    return new SecretNested(null);
  }
  
  public A withNewSecret(String name) {
    return (A) this.withSecret(new LocalObjectReference(name));
  }
  
  public SecretNested<A> withNewSecretLike(LocalObjectReference item) {
    return new SecretNested(item);
  }
  
  public A withSecret(LocalObjectReference secret) {
    this._visitables.remove("secret");
    if (secret != null) {
        this.secret = new LocalObjectReferenceBuilder(secret);
        this._visitables.get("secret").add(this.secret);
    } else {
        this.secret = null;
        this._visitables.get("secret").remove(this.secret);
    }
    return (A) this;
  }
  public class SecretNested<N> extends LocalObjectReferenceFluent<SecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    SecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SecretBuildSourceFluent.this.withSecret(builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
}