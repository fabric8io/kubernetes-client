package io.fabric8.openshift.api.model.installer.aws.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SubnetFluent<A extends io.fabric8.openshift.api.model.installer.aws.v1.SubnetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String id;
  private ArrayList<SubnetRoleBuilder> roles = new ArrayList<SubnetRoleBuilder>();

  public SubnetFluent() {
  }
  
  public SubnetFluent(Subnet instance) {
    this.copyInstance(instance);
  }

  public A addAllToRoles(Collection<SubnetRole> items) {
    if (this.roles == null) {
      this.roles = new ArrayList();
    }
    for (SubnetRole item : items) {
        SubnetRoleBuilder builder = new SubnetRoleBuilder(item);
        _visitables.get("roles").add(builder);
        this.roles.add(builder);
    }
    return (A) this;
  }
  
  public RolesNested<A> addNewRole() {
    return new RolesNested(-1, null);
  }
  
  public A addNewRole(String type) {
    return (A) this.addToRoles(new SubnetRole(type));
  }
  
  public RolesNested<A> addNewRoleLike(SubnetRole item) {
    return new RolesNested(-1, item);
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
  
  public A addToRoles(SubnetRole... items) {
    if (this.roles == null) {
      this.roles = new ArrayList();
    }
    for (SubnetRole item : items) {
        SubnetRoleBuilder builder = new SubnetRoleBuilder(item);
        _visitables.get("roles").add(builder);
        this.roles.add(builder);
    }
    return (A) this;
  }
  
  public A addToRoles(int index,SubnetRole item) {
    if (this.roles == null) {
      this.roles = new ArrayList();
    }
    SubnetRoleBuilder builder = new SubnetRoleBuilder(item);
    if (index < 0 || index >= roles.size()) {
        _visitables.get("roles").add(builder);
        roles.add(builder);
    } else {
        _visitables.get("roles").add(builder);
        roles.add(index, builder);
    }
    return (A) this;
  }
  
  public SubnetRole buildFirstRole() {
    return this.roles.get(0).build();
  }
  
  public SubnetRole buildLastRole() {
    return this.roles.get(roles.size() - 1).build();
  }
  
  public SubnetRole buildMatchingRole(Predicate<SubnetRoleBuilder> predicate) {
      for (SubnetRoleBuilder item : roles) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SubnetRole buildRole(int index) {
    return this.roles.get(index).build();
  }
  
  public List<SubnetRole> buildRoles() {
    return this.roles != null ? build(roles) : null;
  }
  
  protected void copyInstance(Subnet instance) {
    instance = instance != null ? instance : new Subnet();
    if (instance != null) {
        this.withId(instance.getId());
        this.withRoles(instance.getRoles());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RolesNested<A> editFirstRole() {
    if (roles.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "roles"));
    }
    return this.setNewRoleLike(0, this.buildRole(0));
  }
  
  public RolesNested<A> editLastRole() {
    int index = roles.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "roles"));
    }
    return this.setNewRoleLike(index, this.buildRole(index));
  }
  
  public RolesNested<A> editMatchingRole(Predicate<SubnetRoleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < roles.size();i++) {
      if (predicate.test(roles.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "roles"));
    }
    return this.setNewRoleLike(index, this.buildRole(index));
  }
  
  public RolesNested<A> editRole(int index) {
    if (roles.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "roles"));
    }
    return this.setNewRoleLike(index, this.buildRole(index));
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
    SubnetFluent that = (SubnetFluent) o;
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(roles, that.roles))) {
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
  
  public String getId() {
    return this.id;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasMatchingRole(Predicate<SubnetRoleBuilder> predicate) {
      for (SubnetRoleBuilder item : roles) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRoles() {
    return this.roles != null && !(this.roles.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(id, roles, additionalProperties);
  }
  
  public A removeAllFromRoles(Collection<SubnetRole> items) {
    if (this.roles == null) {
      return (A) this;
    }
    for (SubnetRole item : items) {
        SubnetRoleBuilder builder = new SubnetRoleBuilder(item);
        _visitables.get("roles").remove(builder);
        this.roles.remove(builder);
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
  
  public A removeFromRoles(SubnetRole... items) {
    if (this.roles == null) {
      return (A) this;
    }
    for (SubnetRole item : items) {
        SubnetRoleBuilder builder = new SubnetRoleBuilder(item);
        _visitables.get("roles").remove(builder);
        this.roles.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRoles(Predicate<SubnetRoleBuilder> predicate) {
    if (roles == null) {
      return (A) this;
    }
    Iterator<SubnetRoleBuilder> each = roles.iterator();
    List visitables = _visitables.get("roles");
    while (each.hasNext()) {
        SubnetRoleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RolesNested<A> setNewRoleLike(int index,SubnetRole item) {
    return new RolesNested(index, item);
  }
  
  public A setToRoles(int index,SubnetRole item) {
    if (this.roles == null) {
      this.roles = new ArrayList();
    }
    SubnetRoleBuilder builder = new SubnetRoleBuilder(item);
    if (index < 0 || index >= roles.size()) {
        _visitables.get("roles").add(builder);
        roles.add(builder);
    } else {
        _visitables.get("roles").add(builder);
        roles.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(roles == null) && !(roles.isEmpty())) {
        sb.append("roles:");
        sb.append(roles);
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
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withRoles(List<SubnetRole> roles) {
    if (this.roles != null) {
      this._visitables.get("roles").clear();
    }
    if (roles != null) {
        this.roles = new ArrayList();
        for (SubnetRole item : roles) {
          this.addToRoles(item);
        }
    } else {
      this.roles = null;
    }
    return (A) this;
  }
  
  public A withRoles(SubnetRole... roles) {
    if (this.roles != null) {
        this.roles.clear();
        _visitables.remove("roles");
    }
    if (roles != null) {
      for (SubnetRole item : roles) {
        this.addToRoles(item);
      }
    }
    return (A) this;
  }
  public class RolesNested<N> extends SubnetRoleFluent<RolesNested<N>> implements Nested<N>{
  
    SubnetRoleBuilder builder;
    int index;
  
    RolesNested(int index,SubnetRole item) {
      this.index = index;
      this.builder = new SubnetRoleBuilder(this, item);
    }
  
    public N and() {
      return (N) SubnetFluent.this.setToRoles(index, builder.build());
    }
    
    public N endRole() {
      return and();
    }
    
  }
}