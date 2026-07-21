package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
public class NodeGroupAffinityFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.NodeGroupAffinityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> preferredDuringSchedulingIgnoredDuringExecution = new ArrayList<String>();
  private List<String> requiredDuringSchedulingIgnoredDuringExecution = new ArrayList<String>();

  public NodeGroupAffinityFluent() {
  }
  
  public NodeGroupAffinityFluent(NodeGroupAffinity instance) {
    this.copyInstance(instance);
  }

  public A addAllToPreferredDuringSchedulingIgnoredDuringExecution(Collection<String> items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (String item : items) {
      this.preferredDuringSchedulingIgnoredDuringExecution.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRequiredDuringSchedulingIgnoredDuringExecution(Collection<String> items) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (String item : items) {
      this.requiredDuringSchedulingIgnoredDuringExecution.add(item);
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
  
  public A addToPreferredDuringSchedulingIgnoredDuringExecution(String... items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (String item : items) {
      this.preferredDuringSchedulingIgnoredDuringExecution.add(item);
    }
    return (A) this;
  }
  
  public A addToPreferredDuringSchedulingIgnoredDuringExecution(int index,String item) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    this.preferredDuringSchedulingIgnoredDuringExecution.add(index, item);
    return (A) this;
  }
  
  public A addToRequiredDuringSchedulingIgnoredDuringExecution(String... items) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (String item : items) {
      this.requiredDuringSchedulingIgnoredDuringExecution.add(item);
    }
    return (A) this;
  }
  
  public A addToRequiredDuringSchedulingIgnoredDuringExecution(int index,String item) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    this.requiredDuringSchedulingIgnoredDuringExecution.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NodeGroupAffinity instance) {
    instance = instance != null ? instance : new NodeGroupAffinity();
    if (instance != null) {
        this.withPreferredDuringSchedulingIgnoredDuringExecution(instance.getPreferredDuringSchedulingIgnoredDuringExecution());
        this.withRequiredDuringSchedulingIgnoredDuringExecution(instance.getRequiredDuringSchedulingIgnoredDuringExecution());
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
    NodeGroupAffinityFluent that = (NodeGroupAffinityFluent) o;
    if (!(Objects.equals(preferredDuringSchedulingIgnoredDuringExecution, that.preferredDuringSchedulingIgnoredDuringExecution))) {
      return false;
    }
    if (!(Objects.equals(requiredDuringSchedulingIgnoredDuringExecution, that.requiredDuringSchedulingIgnoredDuringExecution))) {
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
  
  public String getFirstPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution.get(0);
  }
  
  public String getFirstRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.requiredDuringSchedulingIgnoredDuringExecution.get(0);
  }
  
  public String getLastPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution.get(preferredDuringSchedulingIgnoredDuringExecution.size() - 1);
  }
  
  public String getLastRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.requiredDuringSchedulingIgnoredDuringExecution.get(requiredDuringSchedulingIgnoredDuringExecution.size() - 1);
  }
  
  public String getMatchingPreferredDuringSchedulingIgnoredDuringExecution(Predicate<String> predicate) {
      for (String item : preferredDuringSchedulingIgnoredDuringExecution) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRequiredDuringSchedulingIgnoredDuringExecution(Predicate<String> predicate) {
      for (String item : requiredDuringSchedulingIgnoredDuringExecution) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution;
  }
  
  public String getPreferredDuringSchedulingIgnoredDuringExecution(int index) {
    return this.preferredDuringSchedulingIgnoredDuringExecution.get(index);
  }
  
  public List<String> getRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.requiredDuringSchedulingIgnoredDuringExecution;
  }
  
  public String getRequiredDuringSchedulingIgnoredDuringExecution(int index) {
    return this.requiredDuringSchedulingIgnoredDuringExecution.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPreferredDuringSchedulingIgnoredDuringExecution(Predicate<String> predicate) {
      for (String item : preferredDuringSchedulingIgnoredDuringExecution) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequiredDuringSchedulingIgnoredDuringExecution(Predicate<String> predicate) {
      for (String item : requiredDuringSchedulingIgnoredDuringExecution) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution != null && !(this.preferredDuringSchedulingIgnoredDuringExecution.isEmpty());
  }
  
  public boolean hasRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.requiredDuringSchedulingIgnoredDuringExecution != null && !(this.requiredDuringSchedulingIgnoredDuringExecution.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(preferredDuringSchedulingIgnoredDuringExecution, requiredDuringSchedulingIgnoredDuringExecution, additionalProperties);
  }
  
  public A removeAllFromPreferredDuringSchedulingIgnoredDuringExecution(Collection<String> items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (String item : items) {
      this.preferredDuringSchedulingIgnoredDuringExecution.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRequiredDuringSchedulingIgnoredDuringExecution(Collection<String> items) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (String item : items) {
      this.requiredDuringSchedulingIgnoredDuringExecution.remove(item);
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
  
  public A removeFromPreferredDuringSchedulingIgnoredDuringExecution(String... items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (String item : items) {
      this.preferredDuringSchedulingIgnoredDuringExecution.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRequiredDuringSchedulingIgnoredDuringExecution(String... items) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (String item : items) {
      this.requiredDuringSchedulingIgnoredDuringExecution.remove(item);
    }
    return (A) this;
  }
  
  public A setToPreferredDuringSchedulingIgnoredDuringExecution(int index,String item) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    this.preferredDuringSchedulingIgnoredDuringExecution.set(index, item);
    return (A) this;
  }
  
  public A setToRequiredDuringSchedulingIgnoredDuringExecution(int index,String item) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    this.requiredDuringSchedulingIgnoredDuringExecution.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(preferredDuringSchedulingIgnoredDuringExecution == null) && !(preferredDuringSchedulingIgnoredDuringExecution.isEmpty())) {
        sb.append("preferredDuringSchedulingIgnoredDuringExecution:");
        sb.append(preferredDuringSchedulingIgnoredDuringExecution);
        sb.append(",");
    }
    if (!(requiredDuringSchedulingIgnoredDuringExecution == null) && !(requiredDuringSchedulingIgnoredDuringExecution.isEmpty())) {
        sb.append("requiredDuringSchedulingIgnoredDuringExecution:");
        sb.append(requiredDuringSchedulingIgnoredDuringExecution);
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
  
  public A withPreferredDuringSchedulingIgnoredDuringExecution(List<String> preferredDuringSchedulingIgnoredDuringExecution) {
    if (preferredDuringSchedulingIgnoredDuringExecution != null) {
        this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
        for (String item : preferredDuringSchedulingIgnoredDuringExecution) {
          this.addToPreferredDuringSchedulingIgnoredDuringExecution(item);
        }
    } else {
      this.preferredDuringSchedulingIgnoredDuringExecution = null;
    }
    return (A) this;
  }
  
  public A withPreferredDuringSchedulingIgnoredDuringExecution(String... preferredDuringSchedulingIgnoredDuringExecution) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution != null) {
        this.preferredDuringSchedulingIgnoredDuringExecution.clear();
        _visitables.remove("preferredDuringSchedulingIgnoredDuringExecution");
    }
    if (preferredDuringSchedulingIgnoredDuringExecution != null) {
      for (String item : preferredDuringSchedulingIgnoredDuringExecution) {
        this.addToPreferredDuringSchedulingIgnoredDuringExecution(item);
      }
    }
    return (A) this;
  }
  
  public A withRequiredDuringSchedulingIgnoredDuringExecution(List<String> requiredDuringSchedulingIgnoredDuringExecution) {
    if (requiredDuringSchedulingIgnoredDuringExecution != null) {
        this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
        for (String item : requiredDuringSchedulingIgnoredDuringExecution) {
          this.addToRequiredDuringSchedulingIgnoredDuringExecution(item);
        }
    } else {
      this.requiredDuringSchedulingIgnoredDuringExecution = null;
    }
    return (A) this;
  }
  
  public A withRequiredDuringSchedulingIgnoredDuringExecution(String... requiredDuringSchedulingIgnoredDuringExecution) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution != null) {
        this.requiredDuringSchedulingIgnoredDuringExecution.clear();
        _visitables.remove("requiredDuringSchedulingIgnoredDuringExecution");
    }
    if (requiredDuringSchedulingIgnoredDuringExecution != null) {
      for (String item : requiredDuringSchedulingIgnoredDuringExecution) {
        this.addToRequiredDuringSchedulingIgnoredDuringExecution(item);
      }
    }
    return (A) this;
  }
  
}