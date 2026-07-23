package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ClusterRoleScopeRestrictionFluent<A extends io.fabric8.openshift.api.model.ClusterRoleScopeRestrictionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowEscalation;
  private List<String> namespaces = new ArrayList<String>();
  private List<String> roleNames = new ArrayList<String>();

  public ClusterRoleScopeRestrictionFluent() {
  }
  
  public ClusterRoleScopeRestrictionFluent(ClusterRoleScopeRestriction instance) {
    this.copyInstance(instance);
  }

  public A addAllToNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRoleNames(Collection<String> items) {
    if (this.roleNames == null) {
      this.roleNames = new ArrayList();
    }
    for (String item : items) {
      this.roleNames.add(item);
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
  
  public A addToNamespaces(String... items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
    }
    return (A) this;
  }
  
  public A addToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.add(index, item);
    return (A) this;
  }
  
  public A addToRoleNames(String... items) {
    if (this.roleNames == null) {
      this.roleNames = new ArrayList();
    }
    for (String item : items) {
      this.roleNames.add(item);
    }
    return (A) this;
  }
  
  public A addToRoleNames(int index,String item) {
    if (this.roleNames == null) {
      this.roleNames = new ArrayList();
    }
    this.roleNames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ClusterRoleScopeRestriction instance) {
    instance = instance != null ? instance : new ClusterRoleScopeRestriction();
    if (instance != null) {
        this.withAllowEscalation(instance.getAllowEscalation());
        this.withNamespaces(instance.getNamespaces());
        this.withRoleNames(instance.getRoleNames());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ClusterRoleScopeRestrictionFluent that = (ClusterRoleScopeRestrictionFluent) o;
    if (!(Objects.equals(allowEscalation, that.allowEscalation))) {
      return false;
    }
    if (!(Objects.equals(namespaces, that.namespaces))) {
      return false;
    }
    if (!(Objects.equals(roleNames, that.roleNames))) {
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
  
  public Boolean getAllowEscalation() {
    return this.allowEscalation;
  }
  
  public String getFirstNamespace() {
    return this.namespaces.get(0);
  }
  
  public String getFirstRoleName() {
    return this.roleNames.get(0);
  }
  
  public String getLastNamespace() {
    return this.namespaces.get(namespaces.size() - 1);
  }
  
  public String getLastRoleName() {
    return this.roleNames.get(roleNames.size() - 1);
  }
  
  public String getMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRoleName(Predicate<String> predicate) {
      for (String item : roleNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNamespace(int index) {
    return this.namespaces.get(index);
  }
  
  public List<String> getNamespaces() {
    return this.namespaces;
  }
  
  public String getRoleName(int index) {
    return this.roleNames.get(index);
  }
  
  public List<String> getRoleNames() {
    return this.roleNames;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowEscalation() {
    return this.allowEscalation != null;
  }
  
  public boolean hasMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRoleName(Predicate<String> predicate) {
      for (String item : roleNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null && !(this.namespaces.isEmpty());
  }
  
  public boolean hasRoleNames() {
    return this.roleNames != null && !(this.roleNames.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allowEscalation, namespaces, roleNames, additionalProperties);
  }
  
  public A removeAllFromNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRoleNames(Collection<String> items) {
    if (this.roleNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.roleNames.remove(item);
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
  
  public A removeFromNamespaces(String... items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRoleNames(String... items) {
    if (this.roleNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.roleNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.set(index, item);
    return (A) this;
  }
  
  public A setToRoleNames(int index,String item) {
    if (this.roleNames == null) {
      this.roleNames = new ArrayList();
    }
    this.roleNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowEscalation == null)) {
        sb.append("allowEscalation:");
        sb.append(allowEscalation);
        sb.append(",");
    }
    if (!(namespaces == null) && !(namespaces.isEmpty())) {
        sb.append("namespaces:");
        sb.append(namespaces);
        sb.append(",");
    }
    if (!(roleNames == null) && !(roleNames.isEmpty())) {
        sb.append("roleNames:");
        sb.append(roleNames);
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
  
  public A withAllowEscalation() {
    return withAllowEscalation(true);
  }
  
  public A withAllowEscalation(Boolean allowEscalation) {
    this.allowEscalation = allowEscalation;
    return (A) this;
  }
  
  public A withNamespaces(List<String> namespaces) {
    if (namespaces != null) {
        this.namespaces = new ArrayList();
        for (String item : namespaces) {
          this.addToNamespaces(item);
        }
    } else {
      this.namespaces = null;
    }
    return (A) this;
  }
  
  public A withNamespaces(String... namespaces) {
    if (this.namespaces != null) {
        this.namespaces.clear();
        _visitables.remove("namespaces");
    }
    if (namespaces != null) {
      for (String item : namespaces) {
        this.addToNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public A withRoleNames(List<String> roleNames) {
    if (roleNames != null) {
        this.roleNames = new ArrayList();
        for (String item : roleNames) {
          this.addToRoleNames(item);
        }
    } else {
      this.roleNames = null;
    }
    return (A) this;
  }
  
  public A withRoleNames(String... roleNames) {
    if (this.roleNames != null) {
        this.roleNames.clear();
        _visitables.remove("roleNames");
    }
    if (roleNames != null) {
      for (String item : roleNames) {
        this.addToRoleNames(item);
      }
    }
    return (A) this;
  }
  
}