package io.fabric8.knative.eventing.v1alpha1;

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
public class SecretFluent<A extends io.fabric8.knative.eventing.v1alpha1.SecretFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretReferenceBuilder ref;

  public SecretFluent() {
  }
  
  public SecretFluent(Secret instance) {
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
  
  public SecretReference buildRef() {
    return this.ref != null ? this.ref.build() : null;
  }
  
  protected void copyInstance(Secret instance) {
    instance = instance != null ? instance : new Secret();
    if (instance != null) {
        this.withRef(instance.getRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RefNested<A> editOrNewRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(new SecretReferenceBuilder().build()));
  }
  
  public RefNested<A> editOrNewRefLike(SecretReference item) {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(item));
  }
  
  public RefNested<A> editRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(null));
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
    SecretFluent that = (SecretFluent) o;
    if (!(Objects.equals(ref, that.ref))) {
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
  
  public boolean hasRef() {
    return this.ref != null;
  }
  
  public int hashCode() {
    return Objects.hash(ref, additionalProperties);
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
    if (!(ref == null)) {
        sb.append("ref:");
        sb.append(ref);
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
  
  public RefNested<A> withNewRef() {
    return new RefNested(null);
  }
  
  public A withNewRef(String name) {
    return (A) this.withRef(new SecretReference(name));
  }
  
  public RefNested<A> withNewRefLike(SecretReference item) {
    return new RefNested(item);
  }
  
  public A withRef(SecretReference ref) {
    this._visitables.remove("ref");
    if (ref != null) {
        this.ref = new SecretReferenceBuilder(ref);
        this._visitables.get("ref").add(this.ref);
    } else {
        this.ref = null;
        this._visitables.get("ref").remove(this.ref);
    }
    return (A) this;
  }
  public class RefNested<N> extends SecretReferenceFluent<RefNested<N>> implements Nested<N>{
  
    SecretReferenceBuilder builder;
  
    RefNested(SecretReference item) {
      this.builder = new SecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SecretFluent.this.withRef(builder.build());
    }
    
    public N endRef() {
      return and();
    }
    
  }
}