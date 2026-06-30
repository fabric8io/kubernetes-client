package io.fabric8.kubernetes.api.model;

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
public class VolumeNodeAffinityFluent<A extends io.fabric8.kubernetes.api.model.VolumeNodeAffinityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NodeSelectorBuilder required;

  public VolumeNodeAffinityFluent() {
  }
  
  public VolumeNodeAffinityFluent(VolumeNodeAffinity instance) {
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
  
  public NodeSelector buildRequired() {
    return this.required != null ? this.required.build() : null;
  }
  
  protected void copyInstance(VolumeNodeAffinity instance) {
    instance = instance != null ? instance : new VolumeNodeAffinity();
    if (instance != null) {
        this.withRequired(instance.getRequired());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequiredNested<A> editOrNewRequired() {
    return this.withNewRequiredLike(Optional.ofNullable(this.buildRequired()).orElse(new NodeSelectorBuilder().build()));
  }
  
  public RequiredNested<A> editOrNewRequiredLike(NodeSelector item) {
    return this.withNewRequiredLike(Optional.ofNullable(this.buildRequired()).orElse(item));
  }
  
  public RequiredNested<A> editRequired() {
    return this.withNewRequiredLike(Optional.ofNullable(this.buildRequired()).orElse(null));
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
    VolumeNodeAffinityFluent that = (VolumeNodeAffinityFluent) o;
    if (!(Objects.equals(required, that.required))) {
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
  
  public boolean hasRequired() {
    return this.required != null;
  }
  
  public int hashCode() {
    return Objects.hash(required, additionalProperties);
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
    if (!(required == null)) {
        sb.append("required:");
        sb.append(required);
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
  
  public RequiredNested<A> withNewRequired() {
    return new RequiredNested(null);
  }
  
  public RequiredNested<A> withNewRequiredLike(NodeSelector item) {
    return new RequiredNested(item);
  }
  
  public A withRequired(NodeSelector required) {
    this._visitables.remove("required");
    if (required != null) {
        this.required = new NodeSelectorBuilder(required);
        this._visitables.get("required").add(this.required);
    } else {
        this.required = null;
        this._visitables.get("required").remove(this.required);
    }
    return (A) this;
  }
  public class RequiredNested<N> extends NodeSelectorFluent<RequiredNested<N>> implements Nested<N>{
  
    NodeSelectorBuilder builder;
  
    RequiredNested(NodeSelector item) {
      this.builder = new NodeSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeNodeAffinityFluent.this.withRequired(builder.build());
    }
    
    public N endRequired() {
      return and();
    }
    
  }
}