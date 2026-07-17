package io.fabric8.openshift.api.model.operator.v1;

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
public class IngressControllerLoggingFluent<A extends io.fabric8.openshift.api.model.operator.v1.IngressControllerLoggingFluent<A>> extends BaseFluent<A>{

  private AccessLoggingBuilder access;
  private Map<String,Object> additionalProperties;

  public IngressControllerLoggingFluent() {
  }
  
  public IngressControllerLoggingFluent(IngressControllerLogging instance) {
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
  
  public AccessLogging buildAccess() {
    return this.access != null ? this.access.build() : null;
  }
  
  protected void copyInstance(IngressControllerLogging instance) {
    instance = instance != null ? instance : new IngressControllerLogging();
    if (instance != null) {
        this.withAccess(instance.getAccess());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AccessNested<A> editAccess() {
    return this.withNewAccessLike(Optional.ofNullable(this.buildAccess()).orElse(null));
  }
  
  public AccessNested<A> editOrNewAccess() {
    return this.withNewAccessLike(Optional.ofNullable(this.buildAccess()).orElse(new AccessLoggingBuilder().build()));
  }
  
  public AccessNested<A> editOrNewAccessLike(AccessLogging item) {
    return this.withNewAccessLike(Optional.ofNullable(this.buildAccess()).orElse(item));
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
    IngressControllerLoggingFluent that = (IngressControllerLoggingFluent) o;
    if (!(Objects.equals(access, that.access))) {
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
  
  public boolean hasAccess() {
    return this.access != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public int hashCode() {
    return Objects.hash(access, additionalProperties);
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
    if (!(access == null)) {
        sb.append("access:");
        sb.append(access);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccess(AccessLogging access) {
    this._visitables.remove("access");
    if (access != null) {
        this.access = new AccessLoggingBuilder(access);
        this._visitables.get("access").add(this.access);
    } else {
        this.access = null;
        this._visitables.get("access").remove(this.access);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public AccessNested<A> withNewAccess() {
    return new AccessNested(null);
  }
  
  public AccessNested<A> withNewAccessLike(AccessLogging item) {
    return new AccessNested(item);
  }
  public class AccessNested<N> extends AccessLoggingFluent<AccessNested<N>> implements Nested<N>{
  
    AccessLoggingBuilder builder;
  
    AccessNested(AccessLogging item) {
      this.builder = new AccessLoggingBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerLoggingFluent.this.withAccess(builder.build());
    }
    
    public N endAccess() {
      return and();
    }
    
  }
}