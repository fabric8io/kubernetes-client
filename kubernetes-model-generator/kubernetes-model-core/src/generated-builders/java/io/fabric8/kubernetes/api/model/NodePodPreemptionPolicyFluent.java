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
public class NodePodPreemptionPolicyFluent<A extends io.fabric8.kubernetes.api.model.NodePodPreemptionPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> disableResizePreemption = new ArrayList<String>();

  public NodePodPreemptionPolicyFluent() {
  }
  
  public NodePodPreemptionPolicyFluent(NodePodPreemptionPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToDisableResizePreemption(Collection<String> items) {
    if (this.disableResizePreemption == null) {
      this.disableResizePreemption = new ArrayList();
    }
    for (String item : items) {
      this.disableResizePreemption.add(item);
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
  
  public A addToDisableResizePreemption(String... items) {
    if (this.disableResizePreemption == null) {
      this.disableResizePreemption = new ArrayList();
    }
    for (String item : items) {
      this.disableResizePreemption.add(item);
    }
    return (A) this;
  }
  
  public A addToDisableResizePreemption(int index,String item) {
    if (this.disableResizePreemption == null) {
      this.disableResizePreemption = new ArrayList();
    }
    this.disableResizePreemption.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NodePodPreemptionPolicy instance) {
    instance = instance != null ? instance : new NodePodPreemptionPolicy();
    if (instance != null) {
        this.withDisableResizePreemption(instance.getDisableResizePreemption());
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
    NodePodPreemptionPolicyFluent that = (NodePodPreemptionPolicyFluent) o;
    if (!(Objects.equals(disableResizePreemption, that.disableResizePreemption))) {
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
  
  public List<String> getDisableResizePreemption() {
    return this.disableResizePreemption;
  }
  
  public String getDisableResizePreemption(int index) {
    return this.disableResizePreemption.get(index);
  }
  
  public String getFirstDisableResizePreemption() {
    return this.disableResizePreemption.get(0);
  }
  
  public String getLastDisableResizePreemption() {
    return this.disableResizePreemption.get(disableResizePreemption.size() - 1);
  }
  
  public String getMatchingDisableResizePreemption(Predicate<String> predicate) {
      for (String item : disableResizePreemption) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisableResizePreemption() {
    return this.disableResizePreemption != null && !(this.disableResizePreemption.isEmpty());
  }
  
  public boolean hasMatchingDisableResizePreemption(Predicate<String> predicate) {
      for (String item : disableResizePreemption) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(disableResizePreemption, additionalProperties);
  }
  
  public A removeAllFromDisableResizePreemption(Collection<String> items) {
    if (this.disableResizePreemption == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disableResizePreemption.remove(item);
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
  
  public A removeFromDisableResizePreemption(String... items) {
    if (this.disableResizePreemption == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disableResizePreemption.remove(item);
    }
    return (A) this;
  }
  
  public A setToDisableResizePreemption(int index,String item) {
    if (this.disableResizePreemption == null) {
      this.disableResizePreemption = new ArrayList();
    }
    this.disableResizePreemption.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(disableResizePreemption == null) && !(disableResizePreemption.isEmpty())) {
        sb.append("disableResizePreemption:");
        sb.append(disableResizePreemption);
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
  
  public A withDisableResizePreemption(List<String> disableResizePreemption) {
    if (disableResizePreemption != null) {
        this.disableResizePreemption = new ArrayList();
        for (String item : disableResizePreemption) {
          this.addToDisableResizePreemption(item);
        }
    } else {
      this.disableResizePreemption = null;
    }
    return (A) this;
  }
  
  public A withDisableResizePreemption(String... disableResizePreemption) {
    if (this.disableResizePreemption != null) {
        this.disableResizePreemption.clear();
        _visitables.remove("disableResizePreemption");
    }
    if (disableResizePreemption != null) {
      for (String item : disableResizePreemption) {
        this.addToDisableResizePreemption(item);
      }
    }
    return (A) this;
  }
  
}