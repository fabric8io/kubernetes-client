package io.fabric8.knative.pkg.apis;

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
public class FieldErrorFluent<A extends io.fabric8.knative.pkg.apis.FieldErrorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String details;
  private Integer level;
  private String message;
  private List<String> paths = new ArrayList<String>();

  public FieldErrorFluent() {
  }
  
  public FieldErrorFluent(FieldError instance) {
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
  
  protected void copyInstance(FieldError instance) {
    instance = instance != null ? instance : new FieldError();
    if (instance != null) {
        this.withDetails(instance.getDetails());
        this.withLevel(instance.getLevel());
        this.withMessage(instance.getMessage());
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
    FieldErrorFluent that = (FieldErrorFluent) o;
    if (!(Objects.equals(details, that.details))) {
      return false;
    }
    if (!(Objects.equals(level, that.level))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
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
  
  public String getDetails() {
    return this.details;
  }
  
  public String getFirstPath() {
    return this.paths.get(0);
  }
  
  public String getLastPath() {
    return this.paths.get(paths.size() - 1);
  }
  
  public Integer getLevel() {
    return this.level;
  }
  
  public String getMatchingPath(Predicate<String> predicate) {
      for (String item : paths) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMessage() {
    return this.message;
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
  
  public boolean hasDetails() {
    return this.details != null;
  }
  
  public boolean hasLevel() {
    return this.level != null;
  }
  
  public boolean hasMatchingPath(Predicate<String> predicate) {
      for (String item : paths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasPaths() {
    return this.paths != null && !(this.paths.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(details, level, message, paths, additionalProperties);
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
    if (!(details == null)) {
        sb.append("details:");
        sb.append(details);
        sb.append(",");
    }
    if (!(level == null)) {
        sb.append("level:");
        sb.append(level);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
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
  
  public A withDetails(String details) {
    this.details = details;
    return (A) this;
  }
  
  public A withLevel(Integer level) {
    this.level = level;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
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