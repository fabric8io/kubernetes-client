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
public class NodeAllocatableResourceClaimStatusFluent<A extends io.fabric8.kubernetes.api.model.NodeAllocatableResourceClaimStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> containers = new ArrayList<String>();
  private String resourceClaimName;
  private Map<String,Quantity> resources;

  public NodeAllocatableResourceClaimStatusFluent() {
  }
  
  public NodeAllocatableResourceClaimStatusFluent(NodeAllocatableResourceClaimStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainers(Collection<String> items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (String item : items) {
      this.containers.add(item);
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
  
  public A addToContainers(String... items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (String item : items) {
      this.containers.add(item);
    }
    return (A) this;
  }
  
  public A addToContainers(int index,String item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    this.containers.add(index, item);
    return (A) this;
  }
  
  public A addToResources(Map<String,Quantity> map) {
    if (this.resources == null && map != null) {
      this.resources = new LinkedHashMap();
    }
    if (map != null) {
      this.resources.putAll(map);
    }
    return (A) this;
  }
  
  public A addToResources(String key,Quantity value) {
    if (this.resources == null && key != null && value != null) {
      this.resources = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.resources.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(NodeAllocatableResourceClaimStatus instance) {
    instance = instance != null ? instance : new NodeAllocatableResourceClaimStatus();
    if (instance != null) {
        this.withContainers(instance.getContainers());
        this.withResourceClaimName(instance.getResourceClaimName());
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
    NodeAllocatableResourceClaimStatusFluent that = (NodeAllocatableResourceClaimStatusFluent) o;
    if (!(Objects.equals(containers, that.containers))) {
      return false;
    }
    if (!(Objects.equals(resourceClaimName, that.resourceClaimName))) {
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
  
  public String getContainer(int index) {
    return this.containers.get(index);
  }
  
  public List<String> getContainers() {
    return this.containers;
  }
  
  public String getFirstContainer() {
    return this.containers.get(0);
  }
  
  public String getLastContainer() {
    return this.containers.get(containers.size() - 1);
  }
  
  public String getMatchingContainer(Predicate<String> predicate) {
      for (String item : containers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getResourceClaimName() {
    return this.resourceClaimName;
  }
  
  public Map<String,Quantity> getResources() {
    return this.resources;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainers() {
    return this.containers != null && !(this.containers.isEmpty());
  }
  
  public boolean hasMatchingContainer(Predicate<String> predicate) {
      for (String item : containers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResourceClaimName() {
    return this.resourceClaimName != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public int hashCode() {
    return Objects.hash(containers, resourceClaimName, resources, additionalProperties);
  }
  
  public A removeAllFromContainers(Collection<String> items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containers.remove(item);
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
  
  public A removeFromContainers(String... items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromResources(String key) {
    if (this.resources == null) {
      return (A) this;
    }
    if (key != null && this.resources != null) {
      this.resources.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromResources(Map<String,Quantity> map) {
    if (this.resources == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.resources != null) {
          this.resources.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToContainers(int index,String item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    this.containers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containers == null) && !(containers.isEmpty())) {
        sb.append("containers:");
        sb.append(containers);
        sb.append(",");
    }
    if (!(resourceClaimName == null)) {
        sb.append("resourceClaimName:");
        sb.append(resourceClaimName);
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
  
  public A withContainers(List<String> containers) {
    if (containers != null) {
        this.containers = new ArrayList();
        for (String item : containers) {
          this.addToContainers(item);
        }
    } else {
      this.containers = null;
    }
    return (A) this;
  }
  
  public A withContainers(String... containers) {
    if (this.containers != null) {
        this.containers.clear();
        _visitables.remove("containers");
    }
    if (containers != null) {
      for (String item : containers) {
        this.addToContainers(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceClaimName(String resourceClaimName) {
    this.resourceClaimName = resourceClaimName;
    return (A) this;
  }
  
  public <K,V>A withResources(Map<String,Quantity> resources) {
    if (resources == null) {
      this.resources = null;
    } else {
      this.resources = new LinkedHashMap(resources);
    }
    return (A) this;
  }
  
}