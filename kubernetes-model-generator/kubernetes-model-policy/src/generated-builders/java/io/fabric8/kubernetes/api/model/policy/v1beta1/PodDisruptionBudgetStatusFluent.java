package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Integer;
import java.lang.Long;
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
public class PodDisruptionBudgetStatusFluent<A extends io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private Integer currentHealthy;
  private Integer desiredHealthy;
  private Map<String,String> disruptedPods;
  private Integer disruptionsAllowed;
  private Integer expectedPods;
  private Long observedGeneration;

  public PodDisruptionBudgetStatusFluent() {
  }
  
  public PodDisruptionBudgetStatusFluent(PodDisruptionBudgetStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToDisruptedPods(Map<String,String> map) {
    if (this.disruptedPods == null && map != null) {
      this.disruptedPods = new LinkedHashMap();
    }
    if (map != null) {
      this.disruptedPods.putAll(map);
    }
    return (A) this;
  }
  
  public A addToDisruptedPods(String key,String value) {
    if (this.disruptedPods == null && key != null && value != null) {
      this.disruptedPods = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.disruptedPods.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(PodDisruptionBudgetStatus instance) {
    instance = instance != null ? instance : new PodDisruptionBudgetStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withCurrentHealthy(instance.getCurrentHealthy());
        this.withDesiredHealthy(instance.getDesiredHealthy());
        this.withDisruptedPods(instance.getDisruptedPods());
        this.withDisruptionsAllowed(instance.getDisruptionsAllowed());
        this.withExpectedPods(instance.getExpectedPods());
        this.withObservedGeneration(instance.getObservedGeneration());
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
    PodDisruptionBudgetStatusFluent that = (PodDisruptionBudgetStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentHealthy, that.currentHealthy))) {
      return false;
    }
    if (!(Objects.equals(desiredHealthy, that.desiredHealthy))) {
      return false;
    }
    if (!(Objects.equals(disruptedPods, that.disruptedPods))) {
      return false;
    }
    if (!(Objects.equals(disruptionsAllowed, that.disruptionsAllowed))) {
      return false;
    }
    if (!(Objects.equals(expectedPods, that.expectedPods))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Integer getCurrentHealthy() {
    return this.currentHealthy;
  }
  
  public Integer getDesiredHealthy() {
    return this.desiredHealthy;
  }
  
  public Map<String,String> getDisruptedPods() {
    return this.disruptedPods;
  }
  
  public Integer getDisruptionsAllowed() {
    return this.disruptionsAllowed;
  }
  
  public Integer getExpectedPods() {
    return this.expectedPods;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasCurrentHealthy() {
    return this.currentHealthy != null;
  }
  
  public boolean hasDesiredHealthy() {
    return this.desiredHealthy != null;
  }
  
  public boolean hasDisruptedPods() {
    return this.disruptedPods != null;
  }
  
  public boolean hasDisruptionsAllowed() {
    return this.disruptionsAllowed != null;
  }
  
  public boolean hasExpectedPods() {
    return this.expectedPods != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, currentHealthy, desiredHealthy, disruptedPods, disruptionsAllowed, expectedPods, observedGeneration, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromDisruptedPods(String key) {
    if (this.disruptedPods == null) {
      return (A) this;
    }
    if (key != null && this.disruptedPods != null) {
      this.disruptedPods.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromDisruptedPods(Map<String,String> map) {
    if (this.disruptedPods == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.disruptedPods != null) {
          this.disruptedPods.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
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
    if (!(currentHealthy == null)) {
        sb.append("currentHealthy:");
        sb.append(currentHealthy);
        sb.append(",");
    }
    if (!(desiredHealthy == null)) {
        sb.append("desiredHealthy:");
        sb.append(desiredHealthy);
        sb.append(",");
    }
    if (!(disruptedPods == null) && !(disruptedPods.isEmpty())) {
        sb.append("disruptedPods:");
        sb.append(disruptedPods);
        sb.append(",");
    }
    if (!(disruptionsAllowed == null)) {
        sb.append("disruptionsAllowed:");
        sb.append(disruptionsAllowed);
        sb.append(",");
    }
    if (!(expectedPods == null)) {
        sb.append("expectedPods:");
        sb.append(expectedPods);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentHealthy(Integer currentHealthy) {
    this.currentHealthy = currentHealthy;
    return (A) this;
  }
  
  public A withDesiredHealthy(Integer desiredHealthy) {
    this.desiredHealthy = desiredHealthy;
    return (A) this;
  }
  
  public <K,V>A withDisruptedPods(Map<String,String> disruptedPods) {
    if (disruptedPods == null) {
      this.disruptedPods = null;
    } else {
      this.disruptedPods = new LinkedHashMap(disruptedPods);
    }
    return (A) this;
  }
  
  public A withDisruptionsAllowed(Integer disruptionsAllowed) {
    this.disruptionsAllowed = disruptionsAllowed;
    return (A) this;
  }
  
  public A withExpectedPods(Integer expectedPods) {
    this.expectedPods = expectedPods;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
}