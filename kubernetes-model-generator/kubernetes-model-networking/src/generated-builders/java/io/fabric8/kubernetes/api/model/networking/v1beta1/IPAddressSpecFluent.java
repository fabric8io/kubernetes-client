package io.fabric8.kubernetes.api.model.networking.v1beta1;

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
public class IPAddressSpecFluent<A extends io.fabric8.kubernetes.api.model.networking.v1beta1.IPAddressSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ParentReferenceBuilder parentRef;

  public IPAddressSpecFluent() {
  }
  
  public IPAddressSpecFluent(IPAddressSpec instance) {
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
  
  public ParentReference buildParentRef() {
    return this.parentRef != null ? this.parentRef.build() : null;
  }
  
  protected void copyInstance(IPAddressSpec instance) {
    instance = instance != null ? instance : new IPAddressSpec();
    if (instance != null) {
        this.withParentRef(instance.getParentRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParentRefNested<A> editOrNewParentRef() {
    return this.withNewParentRefLike(Optional.ofNullable(this.buildParentRef()).orElse(new ParentReferenceBuilder().build()));
  }
  
  public ParentRefNested<A> editOrNewParentRefLike(ParentReference item) {
    return this.withNewParentRefLike(Optional.ofNullable(this.buildParentRef()).orElse(item));
  }
  
  public ParentRefNested<A> editParentRef() {
    return this.withNewParentRefLike(Optional.ofNullable(this.buildParentRef()).orElse(null));
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
    IPAddressSpecFluent that = (IPAddressSpecFluent) o;
    if (!(Objects.equals(parentRef, that.parentRef))) {
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
  
  public boolean hasParentRef() {
    return this.parentRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(parentRef, additionalProperties);
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
    if (!(parentRef == null)) {
        sb.append("parentRef:");
        sb.append(parentRef);
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
  
  public ParentRefNested<A> withNewParentRef() {
    return new ParentRefNested(null);
  }
  
  public A withNewParentRef(String group,String name,String namespace,String resource) {
    return (A) this.withParentRef(new ParentReference(group, name, namespace, resource));
  }
  
  public ParentRefNested<A> withNewParentRefLike(ParentReference item) {
    return new ParentRefNested(item);
  }
  
  public A withParentRef(ParentReference parentRef) {
    this._visitables.remove("parentRef");
    if (parentRef != null) {
        this.parentRef = new ParentReferenceBuilder(parentRef);
        this._visitables.get("parentRef").add(this.parentRef);
    } else {
        this.parentRef = null;
        this._visitables.get("parentRef").remove(this.parentRef);
    }
    return (A) this;
  }
  public class ParentRefNested<N> extends ParentReferenceFluent<ParentRefNested<N>> implements Nested<N>{
  
    ParentReferenceBuilder builder;
  
    ParentRefNested(ParentReference item) {
      this.builder = new ParentReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) IPAddressSpecFluent.this.withParentRef(builder.build());
    }
    
    public N endParentRef() {
      return and();
    }
    
  }
}