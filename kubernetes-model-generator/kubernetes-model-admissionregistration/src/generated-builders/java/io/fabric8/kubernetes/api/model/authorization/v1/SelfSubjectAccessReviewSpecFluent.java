package io.fabric8.kubernetes.api.model.authorization.v1;

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
public class SelfSubjectAccessReviewSpecFluent<A extends io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReviewSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NonResourceAttributesBuilder nonResourceAttributes;
  private ResourceAttributesBuilder resourceAttributes;

  public SelfSubjectAccessReviewSpecFluent() {
  }
  
  public SelfSubjectAccessReviewSpecFluent(SelfSubjectAccessReviewSpec instance) {
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
  
  public NonResourceAttributes buildNonResourceAttributes() {
    return this.nonResourceAttributes != null ? this.nonResourceAttributes.build() : null;
  }
  
  public ResourceAttributes buildResourceAttributes() {
    return this.resourceAttributes != null ? this.resourceAttributes.build() : null;
  }
  
  protected void copyInstance(SelfSubjectAccessReviewSpec instance) {
    instance = instance != null ? instance : new SelfSubjectAccessReviewSpec();
    if (instance != null) {
        this.withNonResourceAttributes(instance.getNonResourceAttributes());
        this.withResourceAttributes(instance.getResourceAttributes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NonResourceAttributesNested<A> editNonResourceAttributes() {
    return this.withNewNonResourceAttributesLike(Optional.ofNullable(this.buildNonResourceAttributes()).orElse(null));
  }
  
  public NonResourceAttributesNested<A> editOrNewNonResourceAttributes() {
    return this.withNewNonResourceAttributesLike(Optional.ofNullable(this.buildNonResourceAttributes()).orElse(new NonResourceAttributesBuilder().build()));
  }
  
  public NonResourceAttributesNested<A> editOrNewNonResourceAttributesLike(NonResourceAttributes item) {
    return this.withNewNonResourceAttributesLike(Optional.ofNullable(this.buildNonResourceAttributes()).orElse(item));
  }
  
  public ResourceAttributesNested<A> editOrNewResourceAttributes() {
    return this.withNewResourceAttributesLike(Optional.ofNullable(this.buildResourceAttributes()).orElse(new ResourceAttributesBuilder().build()));
  }
  
  public ResourceAttributesNested<A> editOrNewResourceAttributesLike(ResourceAttributes item) {
    return this.withNewResourceAttributesLike(Optional.ofNullable(this.buildResourceAttributes()).orElse(item));
  }
  
  public ResourceAttributesNested<A> editResourceAttributes() {
    return this.withNewResourceAttributesLike(Optional.ofNullable(this.buildResourceAttributes()).orElse(null));
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
    SelfSubjectAccessReviewSpecFluent that = (SelfSubjectAccessReviewSpecFluent) o;
    if (!(Objects.equals(nonResourceAttributes, that.nonResourceAttributes))) {
      return false;
    }
    if (!(Objects.equals(resourceAttributes, that.resourceAttributes))) {
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
  
  public boolean hasNonResourceAttributes() {
    return this.nonResourceAttributes != null;
  }
  
  public boolean hasResourceAttributes() {
    return this.resourceAttributes != null;
  }
  
  public int hashCode() {
    return Objects.hash(nonResourceAttributes, resourceAttributes, additionalProperties);
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
    if (!(nonResourceAttributes == null)) {
        sb.append("nonResourceAttributes:");
        sb.append(nonResourceAttributes);
        sb.append(",");
    }
    if (!(resourceAttributes == null)) {
        sb.append("resourceAttributes:");
        sb.append(resourceAttributes);
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
  
  public NonResourceAttributesNested<A> withNewNonResourceAttributes() {
    return new NonResourceAttributesNested(null);
  }
  
  public A withNewNonResourceAttributes(String path,String verb) {
    return (A) this.withNonResourceAttributes(new NonResourceAttributes(path, verb));
  }
  
  public NonResourceAttributesNested<A> withNewNonResourceAttributesLike(NonResourceAttributes item) {
    return new NonResourceAttributesNested(item);
  }
  
  public ResourceAttributesNested<A> withNewResourceAttributes() {
    return new ResourceAttributesNested(null);
  }
  
  public ResourceAttributesNested<A> withNewResourceAttributesLike(ResourceAttributes item) {
    return new ResourceAttributesNested(item);
  }
  
  public A withNonResourceAttributes(NonResourceAttributes nonResourceAttributes) {
    this._visitables.remove("nonResourceAttributes");
    if (nonResourceAttributes != null) {
        this.nonResourceAttributes = new NonResourceAttributesBuilder(nonResourceAttributes);
        this._visitables.get("nonResourceAttributes").add(this.nonResourceAttributes);
    } else {
        this.nonResourceAttributes = null;
        this._visitables.get("nonResourceAttributes").remove(this.nonResourceAttributes);
    }
    return (A) this;
  }
  
  public A withResourceAttributes(ResourceAttributes resourceAttributes) {
    this._visitables.remove("resourceAttributes");
    if (resourceAttributes != null) {
        this.resourceAttributes = new ResourceAttributesBuilder(resourceAttributes);
        this._visitables.get("resourceAttributes").add(this.resourceAttributes);
    } else {
        this.resourceAttributes = null;
        this._visitables.get("resourceAttributes").remove(this.resourceAttributes);
    }
    return (A) this;
  }
  public class NonResourceAttributesNested<N> extends NonResourceAttributesFluent<NonResourceAttributesNested<N>> implements Nested<N>{
  
    NonResourceAttributesBuilder builder;
  
    NonResourceAttributesNested(NonResourceAttributes item) {
      this.builder = new NonResourceAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) SelfSubjectAccessReviewSpecFluent.this.withNonResourceAttributes(builder.build());
    }
    
    public N endNonResourceAttributes() {
      return and();
    }
    
  }
  public class ResourceAttributesNested<N> extends ResourceAttributesFluent<ResourceAttributesNested<N>> implements Nested<N>{
  
    ResourceAttributesBuilder builder;
  
    ResourceAttributesNested(ResourceAttributes item) {
      this.builder = new ResourceAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) SelfSubjectAccessReviewSpecFluent.this.withResourceAttributes(builder.build());
    }
    
    public N endResourceAttributes() {
      return and();
    }
    
  }
}