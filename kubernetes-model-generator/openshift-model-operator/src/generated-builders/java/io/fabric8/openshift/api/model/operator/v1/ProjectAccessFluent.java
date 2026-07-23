package io.fabric8.openshift.api.model.operator.v1;

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
public class ProjectAccessFluent<A extends io.fabric8.openshift.api.model.operator.v1.ProjectAccessFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> availableClusterRoles = new ArrayList<String>();

  public ProjectAccessFluent() {
  }
  
  public ProjectAccessFluent(ProjectAccess instance) {
    this.copyInstance(instance);
  }

  public A addAllToAvailableClusterRoles(Collection<String> items) {
    if (this.availableClusterRoles == null) {
      this.availableClusterRoles = new ArrayList();
    }
    for (String item : items) {
      this.availableClusterRoles.add(item);
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
  
  public A addToAvailableClusterRoles(String... items) {
    if (this.availableClusterRoles == null) {
      this.availableClusterRoles = new ArrayList();
    }
    for (String item : items) {
      this.availableClusterRoles.add(item);
    }
    return (A) this;
  }
  
  public A addToAvailableClusterRoles(int index,String item) {
    if (this.availableClusterRoles == null) {
      this.availableClusterRoles = new ArrayList();
    }
    this.availableClusterRoles.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ProjectAccess instance) {
    instance = instance != null ? instance : new ProjectAccess();
    if (instance != null) {
        this.withAvailableClusterRoles(instance.getAvailableClusterRoles());
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
    ProjectAccessFluent that = (ProjectAccessFluent) o;
    if (!(Objects.equals(availableClusterRoles, that.availableClusterRoles))) {
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
  
  public String getAvailableClusterRole(int index) {
    return this.availableClusterRoles.get(index);
  }
  
  public List<String> getAvailableClusterRoles() {
    return this.availableClusterRoles;
  }
  
  public String getFirstAvailableClusterRole() {
    return this.availableClusterRoles.get(0);
  }
  
  public String getLastAvailableClusterRole() {
    return this.availableClusterRoles.get(availableClusterRoles.size() - 1);
  }
  
  public String getMatchingAvailableClusterRole(Predicate<String> predicate) {
      for (String item : availableClusterRoles) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailableClusterRoles() {
    return this.availableClusterRoles != null && !(this.availableClusterRoles.isEmpty());
  }
  
  public boolean hasMatchingAvailableClusterRole(Predicate<String> predicate) {
      for (String item : availableClusterRoles) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(availableClusterRoles, additionalProperties);
  }
  
  public A removeAllFromAvailableClusterRoles(Collection<String> items) {
    if (this.availableClusterRoles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.availableClusterRoles.remove(item);
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
  
  public A removeFromAvailableClusterRoles(String... items) {
    if (this.availableClusterRoles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.availableClusterRoles.remove(item);
    }
    return (A) this;
  }
  
  public A setToAvailableClusterRoles(int index,String item) {
    if (this.availableClusterRoles == null) {
      this.availableClusterRoles = new ArrayList();
    }
    this.availableClusterRoles.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availableClusterRoles == null) && !(availableClusterRoles.isEmpty())) {
        sb.append("availableClusterRoles:");
        sb.append(availableClusterRoles);
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
  
  public A withAvailableClusterRoles(List<String> availableClusterRoles) {
    if (availableClusterRoles != null) {
        this.availableClusterRoles = new ArrayList();
        for (String item : availableClusterRoles) {
          this.addToAvailableClusterRoles(item);
        }
    } else {
      this.availableClusterRoles = null;
    }
    return (A) this;
  }
  
  public A withAvailableClusterRoles(String... availableClusterRoles) {
    if (this.availableClusterRoles != null) {
        this.availableClusterRoles.clear();
        _visitables.remove("availableClusterRoles");
    }
    if (availableClusterRoles != null) {
      for (String item : availableClusterRoles) {
        this.addToAvailableClusterRoles(item);
      }
    }
    return (A) this;
  }
  
}