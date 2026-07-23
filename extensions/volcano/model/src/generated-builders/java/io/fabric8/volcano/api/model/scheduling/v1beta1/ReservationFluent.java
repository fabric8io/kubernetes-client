package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class ReservationFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.ReservationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> nodes = new ArrayList<String>();
  private Map<String,Quantity> resource;

  public ReservationFluent() {
  }
  
  public ReservationFluent(Reservation instance) {
    this.copyInstance(instance);
  }

  public A addAllToNodes(Collection<String> items) {
    if (this.nodes == null) {
      this.nodes = new ArrayList();
    }
    for (String item : items) {
      this.nodes.add(item);
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
  
  public A addToNodes(String... items) {
    if (this.nodes == null) {
      this.nodes = new ArrayList();
    }
    for (String item : items) {
      this.nodes.add(item);
    }
    return (A) this;
  }
  
  public A addToNodes(int index,String item) {
    if (this.nodes == null) {
      this.nodes = new ArrayList();
    }
    this.nodes.add(index, item);
    return (A) this;
  }
  
  public A addToResource(Map<String,Quantity> map) {
    if (this.resource == null && map != null) {
      this.resource = new LinkedHashMap();
    }
    if (map != null) {
      this.resource.putAll(map);
    }
    return (A) this;
  }
  
  public A addToResource(String key,Quantity value) {
    if (this.resource == null && key != null && value != null) {
      this.resource = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.resource.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(Reservation instance) {
    instance = instance != null ? instance : new Reservation();
    if (instance != null) {
        this.withNodes(instance.getNodes());
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
    ReservationFluent that = (ReservationFluent) o;
    if (!(Objects.equals(nodes, that.nodes))) {
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
  
  public String getFirstNode() {
    return this.nodes.get(0);
  }
  
  public String getLastNode() {
    return this.nodes.get(nodes.size() - 1);
  }
  
  public String getMatchingNode(Predicate<String> predicate) {
      for (String item : nodes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNode(int index) {
    return this.nodes.get(index);
  }
  
  public List<String> getNodes() {
    return this.nodes;
  }
  
  public Map<String,Quantity> getResource() {
    return this.resource;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingNode(Predicate<String> predicate) {
      for (String item : nodes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodes() {
    return this.nodes != null && !(this.nodes.isEmpty());
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public int hashCode() {
    return Objects.hash(nodes, resource, additionalProperties);
  }
  
  public A removeAllFromNodes(Collection<String> items) {
    if (this.nodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nodes.remove(item);
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
  
  public A removeFromNodes(String... items) {
    if (this.nodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nodes.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromResource(String key) {
    if (this.resource == null) {
      return (A) this;
    }
    if (key != null && this.resource != null) {
      this.resource.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromResource(Map<String,Quantity> map) {
    if (this.resource == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.resource != null) {
          this.resource.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToNodes(int index,String item) {
    if (this.nodes == null) {
      this.nodes = new ArrayList();
    }
    this.nodes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(nodes == null) && !(nodes.isEmpty())) {
        sb.append("nodes:");
        sb.append(nodes);
        sb.append(",");
    }
    if (!(resource == null) && !(resource.isEmpty())) {
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
  
  public A withNodes(List<String> nodes) {
    if (nodes != null) {
        this.nodes = new ArrayList();
        for (String item : nodes) {
          this.addToNodes(item);
        }
    } else {
      this.nodes = null;
    }
    return (A) this;
  }
  
  public A withNodes(String... nodes) {
    if (this.nodes != null) {
        this.nodes.clear();
        _visitables.remove("nodes");
    }
    if (nodes != null) {
      for (String item : nodes) {
        this.addToNodes(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withResource(Map<String,Quantity> resource) {
    if (resource == null) {
      this.resource = null;
    } else {
      this.resource = new LinkedHashMap(resource);
    }
    return (A) this;
  }
  
}