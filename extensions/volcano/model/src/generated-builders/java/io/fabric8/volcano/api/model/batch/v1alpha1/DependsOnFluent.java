package io.fabric8.volcano.api.model.batch.v1alpha1;

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
public class DependsOnFluent<A extends io.fabric8.volcano.api.model.batch.v1alpha1.DependsOnFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String iteration;
  private List<String> name = new ArrayList<String>();

  public DependsOnFluent() {
  }
  
  public DependsOnFluent(DependsOn instance) {
    this.copyInstance(instance);
  }

  public A addAllToName(Collection<String> items) {
    if (this.name == null) {
      this.name = new ArrayList();
    }
    for (String item : items) {
      this.name.add(item);
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
  
  public A addToName(String... items) {
    if (this.name == null) {
      this.name = new ArrayList();
    }
    for (String item : items) {
      this.name.add(item);
    }
    return (A) this;
  }
  
  public A addToName(int index,String item) {
    if (this.name == null) {
      this.name = new ArrayList();
    }
    this.name.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(DependsOn instance) {
    instance = instance != null ? instance : new DependsOn();
    if (instance != null) {
        this.withIteration(instance.getIteration());
        this.withName(instance.getName());
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
    DependsOnFluent that = (DependsOnFluent) o;
    if (!(Objects.equals(iteration, that.iteration))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getFirstName() {
    return this.name.get(0);
  }
  
  public String getIteration() {
    return this.iteration;
  }
  
  public String getLastName() {
    return this.name.get(name.size() - 1);
  }
  
  public String getMatchingName(Predicate<String> predicate) {
      for (String item : name) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getName() {
    return this.name;
  }
  
  public String getName(int index) {
    return this.name.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIteration() {
    return this.iteration != null;
  }
  
  public boolean hasMatchingName(Predicate<String> predicate) {
      for (String item : name) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null && !(this.name.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(iteration, name, additionalProperties);
  }
  
  public A removeAllFromName(Collection<String> items) {
    if (this.name == null) {
      return (A) this;
    }
    for (String item : items) {
      this.name.remove(item);
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
  
  public A removeFromName(String... items) {
    if (this.name == null) {
      return (A) this;
    }
    for (String item : items) {
      this.name.remove(item);
    }
    return (A) this;
  }
  
  public A setToName(int index,String item) {
    if (this.name == null) {
      this.name = new ArrayList();
    }
    this.name.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(iteration == null)) {
        sb.append("iteration:");
        sb.append(iteration);
        sb.append(",");
    }
    if (!(name == null) && !(name.isEmpty())) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withIteration(String iteration) {
    this.iteration = iteration;
    return (A) this;
  }
  
  public A withName(List<String> name) {
    if (name != null) {
        this.name = new ArrayList();
        for (String item : name) {
          this.addToName(item);
        }
    } else {
      this.name = null;
    }
    return (A) this;
  }
  
  public A withName(String... name) {
    if (this.name != null) {
        this.name.clear();
        _visitables.remove("name");
    }
    if (name != null) {
      for (String item : name) {
        this.addToName(item);
      }
    }
    return (A) this;
  }
  
}