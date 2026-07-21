package io.fabric8.tekton.v1beta1;

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
public class PipelineTaskInputResourceFluent<A extends io.fabric8.tekton.v1beta1.PipelineTaskInputResourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> from = new ArrayList<String>();
  private String name;
  private String resource;

  public PipelineTaskInputResourceFluent() {
  }
  
  public PipelineTaskInputResourceFluent(PipelineTaskInputResource instance) {
    this.copyInstance(instance);
  }

  public A addAllToFrom(Collection<String> items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (String item : items) {
      this.from.add(item);
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
  
  public A addToFrom(String... items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (String item : items) {
      this.from.add(item);
    }
    return (A) this;
  }
  
  public A addToFrom(int index,String item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    this.from.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(PipelineTaskInputResource instance) {
    instance = instance != null ? instance : new PipelineTaskInputResource();
    if (instance != null) {
        this.withFrom(instance.getFrom());
        this.withName(instance.getName());
        this.withResource(instance.getResource());
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
    PipelineTaskInputResourceFluent that = (PipelineTaskInputResourceFluent) o;
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(resource, that.resource))) {
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
  
  public String getFirstFrom() {
    return this.from.get(0);
  }
  
  public List<String> getFrom() {
    return this.from;
  }
  
  public String getFrom(int index) {
    return this.from.get(index);
  }
  
  public String getLastFrom() {
    return this.from.get(from.size() - 1);
  }
  
  public String getMatchingFrom(Predicate<String> predicate) {
      for (String item : from) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getResource() {
    return this.resource;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFrom() {
    return this.from != null && !(this.from.isEmpty());
  }
  
  public boolean hasMatchingFrom(Predicate<String> predicate) {
      for (String item : from) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public int hashCode() {
    return Objects.hash(from, name, resource, additionalProperties);
  }
  
  public A removeAllFromFrom(Collection<String> items) {
    if (this.from == null) {
      return (A) this;
    }
    for (String item : items) {
      this.from.remove(item);
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
  
  public A removeFromFrom(String... items) {
    if (this.from == null) {
      return (A) this;
    }
    for (String item : items) {
      this.from.remove(item);
    }
    return (A) this;
  }
  
  public A setToFrom(int index,String item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    this.from.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(from == null) && !(from.isEmpty())) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
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
  
  public A withFrom(List<String> from) {
    if (from != null) {
        this.from = new ArrayList();
        for (String item : from) {
          this.addToFrom(item);
        }
    } else {
      this.from = null;
    }
    return (A) this;
  }
  
  public A withFrom(String... from) {
    if (this.from != null) {
        this.from.clear();
        _visitables.remove("from");
    }
    if (from != null) {
      for (String item : from) {
        this.addToFrom(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withResource(String resource) {
    this.resource = resource;
    return (A) this;
  }
  
}