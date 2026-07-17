package io.fabric8.openshift.api.model;

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
public class NamedRoleBindingFluent<A extends io.fabric8.openshift.api.model.NamedRoleBindingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private RoleBindingBuilder roleBinding;

  public NamedRoleBindingFluent() {
  }
  
  public NamedRoleBindingFluent(NamedRoleBinding instance) {
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
  
  public RoleBinding buildRoleBinding() {
    return this.roleBinding != null ? this.roleBinding.build() : null;
  }
  
  protected void copyInstance(NamedRoleBinding instance) {
    instance = instance != null ? instance : new NamedRoleBinding();
    if (instance != null) {
        this.withName(instance.getName());
        this.withRoleBinding(instance.getRoleBinding());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RoleBindingNested<A> editOrNewRoleBinding() {
    return this.withNewRoleBindingLike(Optional.ofNullable(this.buildRoleBinding()).orElse(new RoleBindingBuilder().build()));
  }
  
  public RoleBindingNested<A> editOrNewRoleBindingLike(RoleBinding item) {
    return this.withNewRoleBindingLike(Optional.ofNullable(this.buildRoleBinding()).orElse(item));
  }
  
  public RoleBindingNested<A> editRoleBinding() {
    return this.withNewRoleBindingLike(Optional.ofNullable(this.buildRoleBinding()).orElse(null));
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
    NamedRoleBindingFluent that = (NamedRoleBindingFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(roleBinding, that.roleBinding))) {
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
  
  public boolean hasRoleBinding() {
    return this.roleBinding != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, roleBinding, additionalProperties);
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
    if (!(roleBinding == null)) {
        sb.append("roleBinding:");
        sb.append(roleBinding);
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
  
  public RoleBindingNested<A> withNewRoleBinding() {
    return new RoleBindingNested(null);
  }
  
  public RoleBindingNested<A> withNewRoleBindingLike(RoleBinding item) {
    return new RoleBindingNested(item);
  }
  
  public A withRoleBinding(RoleBinding roleBinding) {
    this._visitables.remove("roleBinding");
    if (roleBinding != null) {
        this.roleBinding = new RoleBindingBuilder(roleBinding);
        this._visitables.get("roleBinding").add(this.roleBinding);
    } else {
        this.roleBinding = null;
        this._visitables.get("roleBinding").remove(this.roleBinding);
    }
    return (A) this;
  }
  public class RoleBindingNested<N> extends RoleBindingFluent<RoleBindingNested<N>> implements Nested<N>{
  
    RoleBindingBuilder builder;
  
    RoleBindingNested(RoleBinding item) {
      this.builder = new RoleBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedRoleBindingFluent.this.withRoleBinding(builder.build());
    }
    
    public N endRoleBinding() {
      return and();
    }
    
  }
}