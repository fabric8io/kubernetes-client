package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ScopeRestrictionFluent<A extends io.fabric8.openshift.api.model.ScopeRestrictionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterRoleScopeRestrictionBuilder clusterRole;
  private List<String> literals = new ArrayList<String>();

  public ScopeRestrictionFluent() {
  }
  
  public ScopeRestrictionFluent(ScopeRestriction instance) {
    this.copyInstance(instance);
  }

  public A addAllToLiterals(Collection<String> items) {
    if (this.literals == null) {
      this.literals = new ArrayList();
    }
    for (String item : items) {
      this.literals.add(item);
    }
    return (A) this;
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
  
  public A addToLiterals(String... items) {
    if (this.literals == null) {
      this.literals = new ArrayList();
    }
    for (String item : items) {
      this.literals.add(item);
    }
    return (A) this;
  }
  
  public A addToLiterals(int index,String item) {
    if (this.literals == null) {
      this.literals = new ArrayList();
    }
    this.literals.add(index, item);
    return (A) this;
  }
  
  public ClusterRoleScopeRestriction buildClusterRole() {
    return this.clusterRole != null ? this.clusterRole.build() : null;
  }
  
  protected void copyInstance(ScopeRestriction instance) {
    instance = instance != null ? instance : new ScopeRestriction();
    if (instance != null) {
        this.withClusterRole(instance.getClusterRole());
        this.withLiterals(instance.getLiterals());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterRoleNested<A> editClusterRole() {
    return this.withNewClusterRoleLike(Optional.ofNullable(this.buildClusterRole()).orElse(null));
  }
  
  public ClusterRoleNested<A> editOrNewClusterRole() {
    return this.withNewClusterRoleLike(Optional.ofNullable(this.buildClusterRole()).orElse(new ClusterRoleScopeRestrictionBuilder().build()));
  }
  
  public ClusterRoleNested<A> editOrNewClusterRoleLike(ClusterRoleScopeRestriction item) {
    return this.withNewClusterRoleLike(Optional.ofNullable(this.buildClusterRole()).orElse(item));
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
    ScopeRestrictionFluent that = (ScopeRestrictionFluent) o;
    if (!(Objects.equals(clusterRole, that.clusterRole))) {
      return false;
    }
    if (!(Objects.equals(literals, that.literals))) {
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
  
  public String getFirstLiteral() {
    return this.literals.get(0);
  }
  
  public String getLastLiteral() {
    return this.literals.get(literals.size() - 1);
  }
  
  public String getLiteral(int index) {
    return this.literals.get(index);
  }
  
  public List<String> getLiterals() {
    return this.literals;
  }
  
  public String getMatchingLiteral(Predicate<String> predicate) {
      for (String item : literals) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterRole() {
    return this.clusterRole != null;
  }
  
  public boolean hasLiterals() {
    return this.literals != null && !(this.literals.isEmpty());
  }
  
  public boolean hasMatchingLiteral(Predicate<String> predicate) {
      for (String item : literals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clusterRole, literals, additionalProperties);
  }
  
  public A removeAllFromLiterals(Collection<String> items) {
    if (this.literals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.literals.remove(item);
    }
    return (A) this;
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
  
  public A removeFromLiterals(String... items) {
    if (this.literals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.literals.remove(item);
    }
    return (A) this;
  }
  
  public A setToLiterals(int index,String item) {
    if (this.literals == null) {
      this.literals = new ArrayList();
    }
    this.literals.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterRole == null)) {
        sb.append("clusterRole:");
        sb.append(clusterRole);
        sb.append(",");
    }
    if (!(literals == null) && !(literals.isEmpty())) {
        sb.append("literals:");
        sb.append(literals);
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
  
  public A withClusterRole(ClusterRoleScopeRestriction clusterRole) {
    this._visitables.remove("clusterRole");
    if (clusterRole != null) {
        this.clusterRole = new ClusterRoleScopeRestrictionBuilder(clusterRole);
        this._visitables.get("clusterRole").add(this.clusterRole);
    } else {
        this.clusterRole = null;
        this._visitables.get("clusterRole").remove(this.clusterRole);
    }
    return (A) this;
  }
  
  public A withLiterals(List<String> literals) {
    if (literals != null) {
        this.literals = new ArrayList();
        for (String item : literals) {
          this.addToLiterals(item);
        }
    } else {
      this.literals = null;
    }
    return (A) this;
  }
  
  public A withLiterals(String... literals) {
    if (this.literals != null) {
        this.literals.clear();
        _visitables.remove("literals");
    }
    if (literals != null) {
      for (String item : literals) {
        this.addToLiterals(item);
      }
    }
    return (A) this;
  }
  
  public ClusterRoleNested<A> withNewClusterRole() {
    return new ClusterRoleNested(null);
  }
  
  public ClusterRoleNested<A> withNewClusterRoleLike(ClusterRoleScopeRestriction item) {
    return new ClusterRoleNested(item);
  }
  public class ClusterRoleNested<N> extends ClusterRoleScopeRestrictionFluent<ClusterRoleNested<N>> implements Nested<N>{
  
    ClusterRoleScopeRestrictionBuilder builder;
  
    ClusterRoleNested(ClusterRoleScopeRestriction item) {
      this.builder = new ClusterRoleScopeRestrictionBuilder(this, item);
    }
  
    public N and() {
      return (N) ScopeRestrictionFluent.this.withClusterRole(builder.build());
    }
    
    public N endClusterRole() {
      return and();
    }
    
  }
}