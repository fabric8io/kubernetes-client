package io.fabric8.autoscaling.api.model.v1;

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
public class EvictionRequirementFluent<A extends io.fabric8.autoscaling.api.model.v1.EvictionRequirementFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String changeRequirement;
  private List<String> resources = new ArrayList<String>();

  public EvictionRequirementFluent() {
  }
  
  public EvictionRequirementFluent(EvictionRequirement instance) {
    this.copyInstance(instance);
  }

  public A addAllToResources(Collection<String> items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (String item : items) {
      this.resources.add(item);
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
  
  public A addToResources(String... items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (String item : items) {
      this.resources.add(item);
    }
    return (A) this;
  }
  
  public A addToResources(int index,String item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(EvictionRequirement instance) {
    instance = instance != null ? instance : new EvictionRequirement();
    if (instance != null) {
        this.withChangeRequirement(instance.getChangeRequirement());
        this.withResources(instance.getResources());
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
    EvictionRequirementFluent that = (EvictionRequirementFluent) o;
    if (!(Objects.equals(changeRequirement, that.changeRequirement))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
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
  
  public String getChangeRequirement() {
    return this.changeRequirement;
  }
  
  public String getFirstResource() {
    return this.resources.get(0);
  }
  
  public String getLastResource() {
    return this.resources.get(resources.size() - 1);
  }
  
  public String getMatchingResource(Predicate<String> predicate) {
      for (String item : resources) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getResource(int index) {
    return this.resources.get(index);
  }
  
  public List<String> getResources() {
    return this.resources;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasChangeRequirement() {
    return this.changeRequirement != null;
  }
  
  public boolean hasMatchingResource(Predicate<String> predicate) {
      for (String item : resources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResources() {
    return this.resources != null && !(this.resources.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(changeRequirement, resources, additionalProperties);
  }
  
  public A removeAllFromResources(Collection<String> items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (String item : items) {
      this.resources.remove(item);
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
  
  public A removeFromResources(String... items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (String item : items) {
      this.resources.remove(item);
    }
    return (A) this;
  }
  
  public A setToResources(int index,String item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(changeRequirement == null)) {
        sb.append("changeRequirement:");
        sb.append(changeRequirement);
        sb.append(",");
    }
    if (!(resources == null) && !(resources.isEmpty())) {
        sb.append("resources:");
        sb.append(resources);
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
  
  public A withChangeRequirement(String changeRequirement) {
    this.changeRequirement = changeRequirement;
    return (A) this;
  }
  
  public A withResources(List<String> resources) {
    if (resources != null) {
        this.resources = new ArrayList();
        for (String item : resources) {
          this.addToResources(item);
        }
    } else {
      this.resources = null;
    }
    return (A) this;
  }
  
  public A withResources(String... resources) {
    if (this.resources != null) {
        this.resources.clear();
        _visitables.remove("resources");
    }
    if (resources != null) {
      for (String item : resources) {
        this.addToResources(item);
      }
    }
    return (A) this;
  }
  
}