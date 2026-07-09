package io.fabric8.kubernetes.api.model.policy.v1beta1;

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
public class RuntimeClassStrategyOptionsFluent<A extends io.fabric8.kubernetes.api.model.policy.v1beta1.RuntimeClassStrategyOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> allowedRuntimeClassNames = new ArrayList<String>();
  private String defaultRuntimeClassName;

  public RuntimeClassStrategyOptionsFluent() {
  }
  
  public RuntimeClassStrategyOptionsFluent(RuntimeClassStrategyOptions instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedRuntimeClassNames(Collection<String> items) {
    if (this.allowedRuntimeClassNames == null) {
      this.allowedRuntimeClassNames = new ArrayList();
    }
    for (String item : items) {
      this.allowedRuntimeClassNames.add(item);
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
  
  public A addToAllowedRuntimeClassNames(String... items) {
    if (this.allowedRuntimeClassNames == null) {
      this.allowedRuntimeClassNames = new ArrayList();
    }
    for (String item : items) {
      this.allowedRuntimeClassNames.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedRuntimeClassNames(int index,String item) {
    if (this.allowedRuntimeClassNames == null) {
      this.allowedRuntimeClassNames = new ArrayList();
    }
    this.allowedRuntimeClassNames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(RuntimeClassStrategyOptions instance) {
    instance = instance != null ? instance : new RuntimeClassStrategyOptions();
    if (instance != null) {
        this.withAllowedRuntimeClassNames(instance.getAllowedRuntimeClassNames());
        this.withDefaultRuntimeClassName(instance.getDefaultRuntimeClassName());
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
    RuntimeClassStrategyOptionsFluent that = (RuntimeClassStrategyOptionsFluent) o;
    if (!(Objects.equals(allowedRuntimeClassNames, that.allowedRuntimeClassNames))) {
      return false;
    }
    if (!(Objects.equals(defaultRuntimeClassName, that.defaultRuntimeClassName))) {
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
  
  public String getAllowedRuntimeClassName(int index) {
    return this.allowedRuntimeClassNames.get(index);
  }
  
  public List<String> getAllowedRuntimeClassNames() {
    return this.allowedRuntimeClassNames;
  }
  
  public String getDefaultRuntimeClassName() {
    return this.defaultRuntimeClassName;
  }
  
  public String getFirstAllowedRuntimeClassName() {
    return this.allowedRuntimeClassNames.get(0);
  }
  
  public String getLastAllowedRuntimeClassName() {
    return this.allowedRuntimeClassNames.get(allowedRuntimeClassNames.size() - 1);
  }
  
  public String getMatchingAllowedRuntimeClassName(Predicate<String> predicate) {
      for (String item : allowedRuntimeClassNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowedRuntimeClassNames() {
    return this.allowedRuntimeClassNames != null && !(this.allowedRuntimeClassNames.isEmpty());
  }
  
  public boolean hasDefaultRuntimeClassName() {
    return this.defaultRuntimeClassName != null;
  }
  
  public boolean hasMatchingAllowedRuntimeClassName(Predicate<String> predicate) {
      for (String item : allowedRuntimeClassNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(allowedRuntimeClassNames, defaultRuntimeClassName, additionalProperties);
  }
  
  public A removeAllFromAllowedRuntimeClassNames(Collection<String> items) {
    if (this.allowedRuntimeClassNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedRuntimeClassNames.remove(item);
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
  
  public A removeFromAllowedRuntimeClassNames(String... items) {
    if (this.allowedRuntimeClassNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedRuntimeClassNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToAllowedRuntimeClassNames(int index,String item) {
    if (this.allowedRuntimeClassNames == null) {
      this.allowedRuntimeClassNames = new ArrayList();
    }
    this.allowedRuntimeClassNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowedRuntimeClassNames == null) && !(allowedRuntimeClassNames.isEmpty())) {
        sb.append("allowedRuntimeClassNames:");
        sb.append(allowedRuntimeClassNames);
        sb.append(",");
    }
    if (!(defaultRuntimeClassName == null)) {
        sb.append("defaultRuntimeClassName:");
        sb.append(defaultRuntimeClassName);
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
  
  public A withAllowedRuntimeClassNames(List<String> allowedRuntimeClassNames) {
    if (allowedRuntimeClassNames != null) {
        this.allowedRuntimeClassNames = new ArrayList();
        for (String item : allowedRuntimeClassNames) {
          this.addToAllowedRuntimeClassNames(item);
        }
    } else {
      this.allowedRuntimeClassNames = null;
    }
    return (A) this;
  }
  
  public A withAllowedRuntimeClassNames(String... allowedRuntimeClassNames) {
    if (this.allowedRuntimeClassNames != null) {
        this.allowedRuntimeClassNames.clear();
        _visitables.remove("allowedRuntimeClassNames");
    }
    if (allowedRuntimeClassNames != null) {
      for (String item : allowedRuntimeClassNames) {
        this.addToAllowedRuntimeClassNames(item);
      }
    }
    return (A) this;
  }
  
  public A withDefaultRuntimeClassName(String defaultRuntimeClassName) {
    this.defaultRuntimeClassName = defaultRuntimeClassName;
    return (A) this;
  }
  
}