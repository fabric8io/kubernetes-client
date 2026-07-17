package io.fabric8.openshift.api.model.operatorhub.v1;

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
public class OperatorStatusFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1.OperatorStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ComponentsBuilder components;

  public OperatorStatusFluent() {
  }
  
  public OperatorStatusFluent(OperatorStatus instance) {
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
  
  public Components buildComponents() {
    return this.components != null ? this.components.build() : null;
  }
  
  protected void copyInstance(OperatorStatus instance) {
    instance = instance != null ? instance : new OperatorStatus();
    if (instance != null) {
        this.withComponents(instance.getComponents());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComponentsNested<A> editComponents() {
    return this.withNewComponentsLike(Optional.ofNullable(this.buildComponents()).orElse(null));
  }
  
  public ComponentsNested<A> editOrNewComponents() {
    return this.withNewComponentsLike(Optional.ofNullable(this.buildComponents()).orElse(new ComponentsBuilder().build()));
  }
  
  public ComponentsNested<A> editOrNewComponentsLike(Components item) {
    return this.withNewComponentsLike(Optional.ofNullable(this.buildComponents()).orElse(item));
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
    OperatorStatusFluent that = (OperatorStatusFluent) o;
    if (!(Objects.equals(components, that.components))) {
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
  
  public boolean hasComponents() {
    return this.components != null;
  }
  
  public int hashCode() {
    return Objects.hash(components, additionalProperties);
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
    if (!(components == null)) {
        sb.append("components:");
        sb.append(components);
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
  
  public A withComponents(Components components) {
    this._visitables.remove("components");
    if (components != null) {
        this.components = new ComponentsBuilder(components);
        this._visitables.get("components").add(this.components);
    } else {
        this.components = null;
        this._visitables.get("components").remove(this.components);
    }
    return (A) this;
  }
  
  public ComponentsNested<A> withNewComponents() {
    return new ComponentsNested(null);
  }
  
  public ComponentsNested<A> withNewComponentsLike(Components item) {
    return new ComponentsNested(item);
  }
  public class ComponentsNested<N> extends ComponentsFluent<ComponentsNested<N>> implements Nested<N>{
  
    ComponentsBuilder builder;
  
    ComponentsNested(Components item) {
      this.builder = new ComponentsBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorStatusFluent.this.withComponents(builder.build());
    }
    
    public N endComponents() {
      return and();
    }
    
  }
}