package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class FilterFluent<A extends io.fabric8.chaosmesh.v1alpha1.FilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> methods = new ArrayList<String>();
  private String path;
  private Integer percent;

  public FilterFluent() {
  }
  
  public FilterFluent(Filter instance) {
    this.copyInstance(instance);
  }

  public A addAllToMethods(Collection<String> items) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    for (String item : items) {
      this.methods.add(item);
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
  
  public A addToMethods(String... items) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    for (String item : items) {
      this.methods.add(item);
    }
    return (A) this;
  }
  
  public A addToMethods(int index,String item) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    this.methods.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Filter instance) {
    instance = instance != null ? instance : new Filter();
    if (instance != null) {
        this.withMethods(instance.getMethods());
        this.withPath(instance.getPath());
        this.withPercent(instance.getPercent());
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
    FilterFluent that = (FilterFluent) o;
    if (!(Objects.equals(methods, that.methods))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(percent, that.percent))) {
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
  
  public String getFirstMethod() {
    return this.methods.get(0);
  }
  
  public String getLastMethod() {
    return this.methods.get(methods.size() - 1);
  }
  
  public String getMatchingMethod(Predicate<String> predicate) {
      for (String item : methods) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMethod(int index) {
    return this.methods.get(index);
  }
  
  public List<String> getMethods() {
    return this.methods;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public Integer getPercent() {
    return this.percent;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingMethod(Predicate<String> predicate) {
      for (String item : methods) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMethods() {
    return this.methods != null && !(this.methods.isEmpty());
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPercent() {
    return this.percent != null;
  }
  
  public int hashCode() {
    return Objects.hash(methods, path, percent, additionalProperties);
  }
  
  public A removeAllFromMethods(Collection<String> items) {
    if (this.methods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.methods.remove(item);
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
  
  public A removeFromMethods(String... items) {
    if (this.methods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.methods.remove(item);
    }
    return (A) this;
  }
  
  public A setToMethods(int index,String item) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    this.methods.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(methods == null) && !(methods.isEmpty())) {
        sb.append("methods:");
        sb.append(methods);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(percent == null)) {
        sb.append("percent:");
        sb.append(percent);
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
  
  public A withMethods(List<String> methods) {
    if (methods != null) {
        this.methods = new ArrayList();
        for (String item : methods) {
          this.addToMethods(item);
        }
    } else {
      this.methods = null;
    }
    return (A) this;
  }
  
  public A withMethods(String... methods) {
    if (this.methods != null) {
        this.methods.clear();
        _visitables.remove("methods");
    }
    if (methods != null) {
      for (String item : methods) {
        this.addToMethods(item);
      }
    }
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPercent(Integer percent) {
    this.percent = percent;
    return (A) this;
  }
  
}