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
public class RootPathsFluent<A extends io.fabric8.kubernetes.api.model.RootPathsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> paths = new ArrayList<String>();

  public RootPathsFluent() {
  }
  
  public RootPathsFluent(RootPaths instance) {
    this.copyInstance(instance);
  }

  public A addAllToPaths(Collection<String> items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (String item : items) {
      this.paths.add(item);
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
  
  public A addToPaths(String... items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (String item : items) {
      this.paths.add(item);
    }
    return (A) this;
  }
  
  public A addToPaths(int index,String item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    this.paths.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(RootPaths instance) {
    instance = instance != null ? instance : new RootPaths();
    if (instance != null) {
        this.withPaths(instance.getPaths());
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
    RootPathsFluent that = (RootPathsFluent) o;
    if (!(Objects.equals(paths, that.paths))) {
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
  
  public String getFirstPath() {
    return this.paths.get(0);
  }
  
  public String getLastPath() {
    return this.paths.get(paths.size() - 1);
  }
  
  public String getMatchingPath(Predicate<String> predicate) {
      for (String item : paths) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPath(int index) {
    return this.paths.get(index);
  }
  
  public List<String> getPaths() {
    return this.paths;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPath(Predicate<String> predicate) {
      for (String item : paths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPaths() {
    return this.paths != null && !(this.paths.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(paths, additionalProperties);
  }
  
  public A removeAllFromPaths(Collection<String> items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.paths.remove(item);
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
  
  public A removeFromPaths(String... items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.paths.remove(item);
    }
    return (A) this;
  }
  
  public A setToPaths(int index,String item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    this.paths.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(paths == null) && !(paths.isEmpty())) {
        sb.append("paths:");
        sb.append(paths);
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
  
  public A withPaths(List<String> paths) {
    if (paths != null) {
        this.paths = new ArrayList();
        for (String item : paths) {
          this.addToPaths(item);
        }
    } else {
      this.paths = null;
    }
    return (A) this;
  }
  
  public A withPaths(String... paths) {
    if (this.paths != null) {
        this.paths.clear();
        _visitables.remove("paths");
    }
    if (paths != null) {
      for (String item : paths) {
        this.addToPaths(item);
      }
    }
    return (A) this;
  }
  
}