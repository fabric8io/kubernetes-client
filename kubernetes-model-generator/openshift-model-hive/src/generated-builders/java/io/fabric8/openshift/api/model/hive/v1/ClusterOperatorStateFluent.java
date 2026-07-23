package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.openshift.api.model.config.v1.ClusterOperatorStatusCondition;
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
public class ClusterOperatorStateFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterOperatorStateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<ClusterOperatorStatusCondition> conditions = new ArrayList<ClusterOperatorStatusCondition>();
  private String name;

  public ClusterOperatorStateFluent() {
  }
  
  public ClusterOperatorStateFluent(ClusterOperatorState instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<ClusterOperatorStatusCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterOperatorStatusCondition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new ClusterOperatorStatusCondition(lastTransitionTime, message, reason, status, type));
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
  
  public A addToConditions(ClusterOperatorStatusCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterOperatorStatusCondition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ClusterOperatorStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ClusterOperatorState instance) {
    instance = instance != null ? instance : new ClusterOperatorState();
    if (instance != null) {
        this.withConditions(instance.getConditions());
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
    ClusterOperatorStateFluent that = (ClusterOperatorStateFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
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
  
  public ClusterOperatorStatusCondition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<ClusterOperatorStatusCondition> getConditions() {
    return this.conditions;
  }
  
  public ClusterOperatorStatusCondition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public ClusterOperatorStatusCondition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public ClusterOperatorStatusCondition getMatchingCondition(Predicate<ClusterOperatorStatusCondition> predicate) {
      for (ClusterOperatorStatusCondition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<ClusterOperatorStatusCondition> predicate) {
      for (ClusterOperatorStatusCondition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, name, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<ClusterOperatorStatusCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterOperatorStatusCondition item : items) {
      this.conditions.remove(item);
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
  
  public A removeFromConditions(ClusterOperatorStatusCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterOperatorStatusCondition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,ClusterOperatorStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(name == null)) {
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
  
  public A withConditions(List<ClusterOperatorStatusCondition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ClusterOperatorStatusCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ClusterOperatorStatusCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ClusterOperatorStatusCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
}