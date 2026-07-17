package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class VSpherePermissionFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.VSpherePermissionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> privileges = new ArrayList<String>();

  public VSpherePermissionFluent() {
  }
  
  public VSpherePermissionFluent(VSpherePermission instance) {
    this.copyInstance(instance);
  }

  public A addAllToPrivileges(Collection<String> items) {
    if (this.privileges == null) {
      this.privileges = new ArrayList();
    }
    for (String item : items) {
      this.privileges.add(item);
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
  
  public A addToPrivileges(String... items) {
    if (this.privileges == null) {
      this.privileges = new ArrayList();
    }
    for (String item : items) {
      this.privileges.add(item);
    }
    return (A) this;
  }
  
  public A addToPrivileges(int index,String item) {
    if (this.privileges == null) {
      this.privileges = new ArrayList();
    }
    this.privileges.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(VSpherePermission instance) {
    instance = instance != null ? instance : new VSpherePermission();
    if (instance != null) {
        this.withPrivileges(instance.getPrivileges());
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
    VSpherePermissionFluent that = (VSpherePermissionFluent) o;
    if (!(Objects.equals(privileges, that.privileges))) {
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
  
  public String getFirstPrivilege() {
    return this.privileges.get(0);
  }
  
  public String getLastPrivilege() {
    return this.privileges.get(privileges.size() - 1);
  }
  
  public String getMatchingPrivilege(Predicate<String> predicate) {
      for (String item : privileges) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPrivilege(int index) {
    return this.privileges.get(index);
  }
  
  public List<String> getPrivileges() {
    return this.privileges;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPrivilege(Predicate<String> predicate) {
      for (String item : privileges) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPrivileges() {
    return this.privileges != null && !(this.privileges.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(privileges, additionalProperties);
  }
  
  public A removeAllFromPrivileges(Collection<String> items) {
    if (this.privileges == null) {
      return (A) this;
    }
    for (String item : items) {
      this.privileges.remove(item);
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
  
  public A removeFromPrivileges(String... items) {
    if (this.privileges == null) {
      return (A) this;
    }
    for (String item : items) {
      this.privileges.remove(item);
    }
    return (A) this;
  }
  
  public A setToPrivileges(int index,String item) {
    if (this.privileges == null) {
      this.privileges = new ArrayList();
    }
    this.privileges.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(privileges == null) && !(privileges.isEmpty())) {
        sb.append("privileges:");
        sb.append(privileges);
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
  
  public A withPrivileges(List<String> privileges) {
    if (privileges != null) {
        this.privileges = new ArrayList();
        for (String item : privileges) {
          this.addToPrivileges(item);
        }
    } else {
      this.privileges = null;
    }
    return (A) this;
  }
  
  public A withPrivileges(String... privileges) {
    if (this.privileges != null) {
        this.privileges.clear();
        _visitables.remove("privileges");
    }
    if (privileges != null) {
      for (String item : privileges) {
        this.addToPrivileges(item);
      }
    }
    return (A) this;
  }
  
}