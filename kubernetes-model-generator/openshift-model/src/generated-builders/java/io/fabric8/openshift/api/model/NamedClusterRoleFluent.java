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
public class NamedClusterRoleFluent<A extends io.fabric8.openshift.api.model.NamedClusterRoleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private ClusterRoleBuilder role;

  public NamedClusterRoleFluent() {
  }
  
  public NamedClusterRoleFluent(NamedClusterRole instance) {
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
  
  public ClusterRole buildRole() {
    return this.role != null ? this.role.build() : null;
  }
  
  protected void copyInstance(NamedClusterRole instance) {
    instance = instance != null ? instance : new NamedClusterRole();
    if (instance != null) {
        this.withName(instance.getName());
        this.withRole(instance.getRole());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RoleNested<A> editOrNewRole() {
    return this.withNewRoleLike(Optional.ofNullable(this.buildRole()).orElse(new ClusterRoleBuilder().build()));
  }
  
  public RoleNested<A> editOrNewRoleLike(ClusterRole item) {
    return this.withNewRoleLike(Optional.ofNullable(this.buildRole()).orElse(item));
  }
  
  public RoleNested<A> editRole() {
    return this.withNewRoleLike(Optional.ofNullable(this.buildRole()).orElse(null));
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
    NamedClusterRoleFluent that = (NamedClusterRoleFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
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
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, role, additionalProperties);
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
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
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
  
  public RoleNested<A> withNewRole() {
    return new RoleNested(null);
  }
  
  public RoleNested<A> withNewRoleLike(ClusterRole item) {
    return new RoleNested(item);
  }
  
  public A withRole(ClusterRole role) {
    this._visitables.remove("role");
    if (role != null) {
        this.role = new ClusterRoleBuilder(role);
        this._visitables.get("role").add(this.role);
    } else {
        this.role = null;
        this._visitables.get("role").remove(this.role);
    }
    return (A) this;
  }
  public class RoleNested<N> extends ClusterRoleFluent<RoleNested<N>> implements Nested<N>{
  
    ClusterRoleBuilder builder;
  
    RoleNested(ClusterRole item) {
      this.builder = new ClusterRoleBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedClusterRoleFluent.this.withRole(builder.build());
    }
    
    public N endRole() {
      return and();
    }
    
  }
}