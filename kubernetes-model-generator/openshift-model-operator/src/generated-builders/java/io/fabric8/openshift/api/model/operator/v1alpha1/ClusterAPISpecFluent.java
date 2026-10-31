package io.fabric8.openshift.api.model.operator.v1alpha1;

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
public class ClusterAPISpecFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.ClusterAPISpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> unmanagedCustomResourceDefinitions = new ArrayList<String>();

  public ClusterAPISpecFluent() {
  }
  
  public ClusterAPISpecFluent(ClusterAPISpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToUnmanagedCustomResourceDefinitions(Collection<String> items) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      this.unmanagedCustomResourceDefinitions = new ArrayList();
    }
    for (String item : items) {
      this.unmanagedCustomResourceDefinitions.add(item);
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
  
  public A addToUnmanagedCustomResourceDefinitions(String... items) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      this.unmanagedCustomResourceDefinitions = new ArrayList();
    }
    for (String item : items) {
      this.unmanagedCustomResourceDefinitions.add(item);
    }
    return (A) this;
  }
  
  public A addToUnmanagedCustomResourceDefinitions(int index,String item) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      this.unmanagedCustomResourceDefinitions = new ArrayList();
    }
    this.unmanagedCustomResourceDefinitions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ClusterAPISpec instance) {
    instance = instance != null ? instance : new ClusterAPISpec();
    if (instance != null) {
        this.withUnmanagedCustomResourceDefinitions(instance.getUnmanagedCustomResourceDefinitions());
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
    ClusterAPISpecFluent that = (ClusterAPISpecFluent) o;
    if (!(Objects.equals(unmanagedCustomResourceDefinitions, that.unmanagedCustomResourceDefinitions))) {
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
  
  public String getFirstUnmanagedCustomResourceDefinition() {
    return this.unmanagedCustomResourceDefinitions.get(0);
  }
  
  public String getLastUnmanagedCustomResourceDefinition() {
    return this.unmanagedCustomResourceDefinitions.get(unmanagedCustomResourceDefinitions.size() - 1);
  }
  
  public String getMatchingUnmanagedCustomResourceDefinition(Predicate<String> predicate) {
      for (String item : unmanagedCustomResourceDefinitions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getUnmanagedCustomResourceDefinition(int index) {
    return this.unmanagedCustomResourceDefinitions.get(index);
  }
  
  public List<String> getUnmanagedCustomResourceDefinitions() {
    return this.unmanagedCustomResourceDefinitions;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingUnmanagedCustomResourceDefinition(Predicate<String> predicate) {
      for (String item : unmanagedCustomResourceDefinitions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUnmanagedCustomResourceDefinitions() {
    return this.unmanagedCustomResourceDefinitions != null && !(this.unmanagedCustomResourceDefinitions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(unmanagedCustomResourceDefinitions, additionalProperties);
  }
  
  public A removeAllFromUnmanagedCustomResourceDefinitions(Collection<String> items) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.unmanagedCustomResourceDefinitions.remove(item);
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
  
  public A removeFromUnmanagedCustomResourceDefinitions(String... items) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.unmanagedCustomResourceDefinitions.remove(item);
    }
    return (A) this;
  }
  
  public A setToUnmanagedCustomResourceDefinitions(int index,String item) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      this.unmanagedCustomResourceDefinitions = new ArrayList();
    }
    this.unmanagedCustomResourceDefinitions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(unmanagedCustomResourceDefinitions == null) && !(unmanagedCustomResourceDefinitions.isEmpty())) {
        sb.append("unmanagedCustomResourceDefinitions:");
        sb.append(unmanagedCustomResourceDefinitions);
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
  
  public A withUnmanagedCustomResourceDefinitions(List<String> unmanagedCustomResourceDefinitions) {
    if (unmanagedCustomResourceDefinitions != null) {
        this.unmanagedCustomResourceDefinitions = new ArrayList();
        for (String item : unmanagedCustomResourceDefinitions) {
          this.addToUnmanagedCustomResourceDefinitions(item);
        }
    } else {
      this.unmanagedCustomResourceDefinitions = null;
    }
    return (A) this;
  }
  
  public A withUnmanagedCustomResourceDefinitions(String... unmanagedCustomResourceDefinitions) {
    if (this.unmanagedCustomResourceDefinitions != null) {
        this.unmanagedCustomResourceDefinitions.clear();
        _visitables.remove("unmanagedCustomResourceDefinitions");
    }
    if (unmanagedCustomResourceDefinitions != null) {
      for (String item : unmanagedCustomResourceDefinitions) {
        this.addToUnmanagedCustomResourceDefinitions(item);
      }
    }
    return (A) this;
  }
  
}