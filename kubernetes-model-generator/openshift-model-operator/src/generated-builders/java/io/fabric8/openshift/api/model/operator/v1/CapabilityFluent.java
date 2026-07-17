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
public class CapabilityFluent<A extends io.fabric8.openshift.api.model.operator.v1.CapabilityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private CapabilityVisibilityBuilder visibility;

  public CapabilityFluent() {
  }
  
  public CapabilityFluent(Capability instance) {
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
  
  public CapabilityVisibility buildVisibility() {
    return this.visibility != null ? this.visibility.build() : null;
  }
  
  protected void copyInstance(Capability instance) {
    instance = instance != null ? instance : new Capability();
    if (instance != null) {
        this.withName(instance.getName());
        this.withVisibility(instance.getVisibility());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VisibilityNested<A> editOrNewVisibility() {
    return this.withNewVisibilityLike(Optional.ofNullable(this.buildVisibility()).orElse(new CapabilityVisibilityBuilder().build()));
  }
  
  public VisibilityNested<A> editOrNewVisibilityLike(CapabilityVisibility item) {
    return this.withNewVisibilityLike(Optional.ofNullable(this.buildVisibility()).orElse(item));
  }
  
  public VisibilityNested<A> editVisibility() {
    return this.withNewVisibilityLike(Optional.ofNullable(this.buildVisibility()).orElse(null));
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
    CapabilityFluent that = (CapabilityFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(visibility, that.visibility))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasVisibility() {
    return this.visibility != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, visibility, additionalProperties);
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
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(visibility == null)) {
        sb.append("visibility:");
        sb.append(visibility);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public VisibilityNested<A> withNewVisibility() {
    return new VisibilityNested(null);
  }
  
  public A withNewVisibility(String state) {
    return (A) this.withVisibility(new CapabilityVisibility(state));
  }
  
  public VisibilityNested<A> withNewVisibilityLike(CapabilityVisibility item) {
    return new VisibilityNested(item);
  }
  
  public A withVisibility(CapabilityVisibility visibility) {
    this._visitables.remove("visibility");
    if (visibility != null) {
        this.visibility = new CapabilityVisibilityBuilder(visibility);
        this._visitables.get("visibility").add(this.visibility);
    } else {
        this.visibility = null;
        this._visitables.get("visibility").remove(this.visibility);
    }
    return (A) this;
  }
  public class VisibilityNested<N> extends CapabilityVisibilityFluent<VisibilityNested<N>> implements Nested<N>{
  
    CapabilityVisibilityBuilder builder;
  
    VisibilityNested(CapabilityVisibility item) {
      this.builder = new CapabilityVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) CapabilityFluent.this.withVisibility(builder.build());
    }
    
    public N endVisibility() {
      return and();
    }
    
  }
}