package io.fabric8.kubernetes.api.model;

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
public class NamespaceSpecFluent<A extends io.fabric8.kubernetes.api.model.NamespaceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> finalizers = new ArrayList<String>();

  public NamespaceSpecFluent() {
  }
  
  public NamespaceSpecFluent(NamespaceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToFinalizers(Collection<String> items) {
    if (this.finalizers == null) {
      this.finalizers = new ArrayList();
    }
    for (String item : items) {
      this.finalizers.add(item);
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
  
  public A addToFinalizers(String... items) {
    if (this.finalizers == null) {
      this.finalizers = new ArrayList();
    }
    for (String item : items) {
      this.finalizers.add(item);
    }
    return (A) this;
  }
  
  public A addToFinalizers(int index,String item) {
    if (this.finalizers == null) {
      this.finalizers = new ArrayList();
    }
    this.finalizers.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NamespaceSpec instance) {
    instance = instance != null ? instance : new NamespaceSpec();
    if (instance != null) {
        this.withFinalizers(instance.getFinalizers());
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
    NamespaceSpecFluent that = (NamespaceSpecFluent) o;
    if (!(Objects.equals(finalizers, that.finalizers))) {
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
  
  public String getFinalizer(int index) {
    return this.finalizers.get(index);
  }
  
  public List<String> getFinalizers() {
    return this.finalizers;
  }
  
  public String getFirstFinalizer() {
    return this.finalizers.get(0);
  }
  
  public String getLastFinalizer() {
    return this.finalizers.get(finalizers.size() - 1);
  }
  
  public String getMatchingFinalizer(Predicate<String> predicate) {
      for (String item : finalizers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFinalizers() {
    return this.finalizers != null && !(this.finalizers.isEmpty());
  }
  
  public boolean hasMatchingFinalizer(Predicate<String> predicate) {
      for (String item : finalizers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(finalizers, additionalProperties);
  }
  
  public A removeAllFromFinalizers(Collection<String> items) {
    if (this.finalizers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.finalizers.remove(item);
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
  
  public A removeFromFinalizers(String... items) {
    if (this.finalizers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.finalizers.remove(item);
    }
    return (A) this;
  }
  
  public A setToFinalizers(int index,String item) {
    if (this.finalizers == null) {
      this.finalizers = new ArrayList();
    }
    this.finalizers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(finalizers == null) && !(finalizers.isEmpty())) {
        sb.append("finalizers:");
        sb.append(finalizers);
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
  
  public A withFinalizers(List<String> finalizers) {
    if (finalizers != null) {
        this.finalizers = new ArrayList();
        for (String item : finalizers) {
          this.addToFinalizers(item);
        }
    } else {
      this.finalizers = null;
    }
    return (A) this;
  }
  
  public A withFinalizers(String... finalizers) {
    if (this.finalizers != null) {
        this.finalizers.clear();
        _visitables.remove("finalizers");
    }
    if (finalizers != null) {
      for (String item : finalizers) {
        this.addToFinalizers(item);
      }
    }
    return (A) this;
  }
  
}