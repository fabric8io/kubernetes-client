package io.fabric8.knative.duck.v1;

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
public class AuthStatusFluent<A extends io.fabric8.knative.duck.v1.AuthStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String serviceAccountName;
  private List<String> serviceAccountNames = new ArrayList<String>();

  public AuthStatusFluent() {
  }
  
  public AuthStatusFluent(AuthStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToServiceAccountNames(Collection<String> items) {
    if (this.serviceAccountNames == null) {
      this.serviceAccountNames = new ArrayList();
    }
    for (String item : items) {
      this.serviceAccountNames.add(item);
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
  
  public A addToServiceAccountNames(String... items) {
    if (this.serviceAccountNames == null) {
      this.serviceAccountNames = new ArrayList();
    }
    for (String item : items) {
      this.serviceAccountNames.add(item);
    }
    return (A) this;
  }
  
  public A addToServiceAccountNames(int index,String item) {
    if (this.serviceAccountNames == null) {
      this.serviceAccountNames = new ArrayList();
    }
    this.serviceAccountNames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(AuthStatus instance) {
    instance = instance != null ? instance : new AuthStatus();
    if (instance != null) {
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withServiceAccountNames(instance.getServiceAccountNames());
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
    AuthStatusFluent that = (AuthStatusFluent) o;
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountNames, that.serviceAccountNames))) {
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
  
  public String getFirstServiceAccountName() {
    return this.serviceAccountNames.get(0);
  }
  
  public String getLastServiceAccountName() {
    return this.serviceAccountNames.get(serviceAccountNames.size() - 1);
  }
  
  public String getMatchingServiceAccountName(Predicate<String> predicate) {
      for (String item : serviceAccountNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public String getServiceAccountName(int index) {
    return this.serviceAccountNames.get(index);
  }
  
  public List<String> getServiceAccountNames() {
    return this.serviceAccountNames;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingServiceAccountName(Predicate<String> predicate) {
      for (String item : serviceAccountNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasServiceAccountNames() {
    return this.serviceAccountNames != null && !(this.serviceAccountNames.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(serviceAccountName, serviceAccountNames, additionalProperties);
  }
  
  public A removeAllFromServiceAccountNames(Collection<String> items) {
    if (this.serviceAccountNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceAccountNames.remove(item);
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
  
  public A removeFromServiceAccountNames(String... items) {
    if (this.serviceAccountNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceAccountNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToServiceAccountNames(int index,String item) {
    if (this.serviceAccountNames == null) {
      this.serviceAccountNames = new ArrayList();
    }
    this.serviceAccountNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(serviceAccountNames == null) && !(serviceAccountNames.isEmpty())) {
        sb.append("serviceAccountNames:");
        sb.append(serviceAccountNames);
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
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withServiceAccountNames(List<String> serviceAccountNames) {
    if (serviceAccountNames != null) {
        this.serviceAccountNames = new ArrayList();
        for (String item : serviceAccountNames) {
          this.addToServiceAccountNames(item);
        }
    } else {
      this.serviceAccountNames = null;
    }
    return (A) this;
  }
  
  public A withServiceAccountNames(String... serviceAccountNames) {
    if (this.serviceAccountNames != null) {
        this.serviceAccountNames.clear();
        _visitables.remove("serviceAccountNames");
    }
    if (serviceAccountNames != null) {
      for (String item : serviceAccountNames) {
        this.addToServiceAccountNames(item);
      }
    }
    return (A) this;
  }
  
}