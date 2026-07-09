package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class ResourceClaimSchedulingStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimSchedulingStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private List<String> unsuitableNodes = new ArrayList<String>();

  public ResourceClaimSchedulingStatusFluent() {
  }
  
  public ResourceClaimSchedulingStatusFluent(ResourceClaimSchedulingStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToUnsuitableNodes(Collection<String> items) {
    if (this.unsuitableNodes == null) {
      this.unsuitableNodes = new ArrayList();
    }
    for (String item : items) {
      this.unsuitableNodes.add(item);
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
  
  public A addToUnsuitableNodes(String... items) {
    if (this.unsuitableNodes == null) {
      this.unsuitableNodes = new ArrayList();
    }
    for (String item : items) {
      this.unsuitableNodes.add(item);
    }
    return (A) this;
  }
  
  public A addToUnsuitableNodes(int index,String item) {
    if (this.unsuitableNodes == null) {
      this.unsuitableNodes = new ArrayList();
    }
    this.unsuitableNodes.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ResourceClaimSchedulingStatus instance) {
    instance = instance != null ? instance : new ResourceClaimSchedulingStatus();
    if (instance != null) {
        this.withName(instance.getName());
        this.withUnsuitableNodes(instance.getUnsuitableNodes());
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
    ResourceClaimSchedulingStatusFluent that = (ResourceClaimSchedulingStatusFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(unsuitableNodes, that.unsuitableNodes))) {
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
  
  public String getFirstUnsuitableNode() {
    return this.unsuitableNodes.get(0);
  }
  
  public String getLastUnsuitableNode() {
    return this.unsuitableNodes.get(unsuitableNodes.size() - 1);
  }
  
  public String getMatchingUnsuitableNode(Predicate<String> predicate) {
      for (String item : unsuitableNodes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getUnsuitableNode(int index) {
    return this.unsuitableNodes.get(index);
  }
  
  public List<String> getUnsuitableNodes() {
    return this.unsuitableNodes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingUnsuitableNode(Predicate<String> predicate) {
      for (String item : unsuitableNodes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasUnsuitableNodes() {
    return this.unsuitableNodes != null && !(this.unsuitableNodes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(name, unsuitableNodes, additionalProperties);
  }
  
  public A removeAllFromUnsuitableNodes(Collection<String> items) {
    if (this.unsuitableNodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.unsuitableNodes.remove(item);
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
  
  public A removeFromUnsuitableNodes(String... items) {
    if (this.unsuitableNodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.unsuitableNodes.remove(item);
    }
    return (A) this;
  }
  
  public A setToUnsuitableNodes(int index,String item) {
    if (this.unsuitableNodes == null) {
      this.unsuitableNodes = new ArrayList();
    }
    this.unsuitableNodes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(unsuitableNodes == null) && !(unsuitableNodes.isEmpty())) {
        sb.append("unsuitableNodes:");
        sb.append(unsuitableNodes);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withUnsuitableNodes(List<String> unsuitableNodes) {
    if (unsuitableNodes != null) {
        this.unsuitableNodes = new ArrayList();
        for (String item : unsuitableNodes) {
          this.addToUnsuitableNodes(item);
        }
    } else {
      this.unsuitableNodes = null;
    }
    return (A) this;
  }
  
  public A withUnsuitableNodes(String... unsuitableNodes) {
    if (this.unsuitableNodes != null) {
        this.unsuitableNodes.clear();
        _visitables.remove("unsuitableNodes");
    }
    if (unsuitableNodes != null) {
      for (String item : unsuitableNodes) {
        this.addToUnsuitableNodes(item);
      }
    }
    return (A) this;
  }
  
}