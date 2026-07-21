package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class ExternalDNSAWSConfigFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ExternalDNSAWSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder credentials;

  public ExternalDNSAWSConfigFluent() {
  }
  
  public ExternalDNSAWSConfigFluent(ExternalDNSAWSConfig instance) {
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
  
  public LocalObjectReference buildCredentials() {
    return this.credentials != null ? this.credentials.build() : null;
  }
  
  protected void copyInstance(ExternalDNSAWSConfig instance) {
    instance = instance != null ? instance : new ExternalDNSAWSConfig();
    if (instance != null) {
        this.withCredentials(instance.getCredentials());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsNested<A> editCredentials() {
    return this.withNewCredentialsLike(Optional.ofNullable(this.buildCredentials()).orElse(null));
  }
  
  public CredentialsNested<A> editOrNewCredentials() {
    return this.withNewCredentialsLike(Optional.ofNullable(this.buildCredentials()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsNested<A> editOrNewCredentialsLike(LocalObjectReference item) {
    return this.withNewCredentialsLike(Optional.ofNullable(this.buildCredentials()).orElse(item));
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
    ExternalDNSAWSConfigFluent that = (ExternalDNSAWSConfigFluent) o;
    if (!(Objects.equals(credentials, that.credentials))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCredentials() {
    return this.credentials != null;
  }
  
  public int hashCode() {
    return Objects.hash(credentials, additionalProperties);
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
    if (!(credentials == null)) {
        sb.append("credentials:");
        sb.append(credentials);
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
  
  public A withCredentials(LocalObjectReference credentials) {
    this._visitables.remove("credentials");
    if (credentials != null) {
        this.credentials = new LocalObjectReferenceBuilder(credentials);
        this._visitables.get("credentials").add(this.credentials);
    } else {
        this.credentials = null;
        this._visitables.get("credentials").remove(this.credentials);
    }
    return (A) this;
  }
  
  public CredentialsNested<A> withNewCredentials() {
    return new CredentialsNested(null);
  }
  
  public A withNewCredentials(String name) {
    return (A) this.withCredentials(new LocalObjectReference(name));
  }
  
  public CredentialsNested<A> withNewCredentialsLike(LocalObjectReference item) {
    return new CredentialsNested(item);
  }
  public class CredentialsNested<N> extends LocalObjectReferenceFluent<CredentialsNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ExternalDNSAWSConfigFluent.this.withCredentials(builder.build());
    }
    
    public N endCredentials() {
      return and();
    }
    
  }
}