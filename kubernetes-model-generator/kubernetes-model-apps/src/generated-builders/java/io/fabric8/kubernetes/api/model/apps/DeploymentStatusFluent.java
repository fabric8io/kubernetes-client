package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DeploymentStatusFluent<A extends io.fabric8.kubernetes.api.model.apps.DeploymentStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer availableReplicas;
  private Integer collisionCount;
  private ArrayList<DeploymentConditionBuilder> conditions = new ArrayList<DeploymentConditionBuilder>();
  private Long observedGeneration;
  private Integer readyReplicas;
  private Integer replicas;
  private Integer terminatingReplicas;
  private Integer unavailableReplicas;
  private Integer updatedReplicas;

  public DeploymentStatusFluent() {
  }
  
  public DeploymentStatusFluent(DeploymentStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<DeploymentCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (DeploymentCondition item : items) {
        DeploymentConditionBuilder builder = new DeploymentConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(DeploymentCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(DeploymentCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (DeploymentCondition item : items) {
        DeploymentConditionBuilder builder = new DeploymentConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,DeploymentCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    DeploymentConditionBuilder builder = new DeploymentConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public DeploymentCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<DeploymentCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public DeploymentCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public DeploymentCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public DeploymentCondition buildMatchingCondition(Predicate<DeploymentConditionBuilder> predicate) {
      for (DeploymentConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(DeploymentStatus instance) {
    instance = instance != null ? instance : new DeploymentStatus();
    if (instance != null) {
        this.withAvailableReplicas(instance.getAvailableReplicas());
        this.withCollisionCount(instance.getCollisionCount());
        this.withConditions(instance.getConditions());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withReadyReplicas(instance.getReadyReplicas());
        this.withReplicas(instance.getReplicas());
        this.withTerminatingReplicas(instance.getTerminatingReplicas());
        this.withUnavailableReplicas(instance.getUnavailableReplicas());
        this.withUpdatedReplicas(instance.getUpdatedReplicas());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<DeploymentConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
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
    DeploymentStatusFluent that = (DeploymentStatusFluent) o;
    if (!(Objects.equals(availableReplicas, that.availableReplicas))) {
      return false;
    }
    if (!(Objects.equals(collisionCount, that.collisionCount))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(readyReplicas, that.readyReplicas))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(terminatingReplicas, that.terminatingReplicas))) {
      return false;
    }
    if (!(Objects.equals(unavailableReplicas, that.unavailableReplicas))) {
      return false;
    }
    if (!(Objects.equals(updatedReplicas, that.updatedReplicas))) {
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
  
  public Integer getAvailableReplicas() {
    return this.availableReplicas;
  }
  
  public Integer getCollisionCount() {
    return this.collisionCount;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public Integer getReadyReplicas() {
    return this.readyReplicas;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public Integer getTerminatingReplicas() {
    return this.terminatingReplicas;
  }
  
  public Integer getUnavailableReplicas() {
    return this.unavailableReplicas;
  }
  
  public Integer getUpdatedReplicas() {
    return this.updatedReplicas;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailableReplicas() {
    return this.availableReplicas != null;
  }
  
  public boolean hasCollisionCount() {
    return this.collisionCount != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<DeploymentConditionBuilder> predicate) {
      for (DeploymentConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasReadyReplicas() {
    return this.readyReplicas != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasTerminatingReplicas() {
    return this.terminatingReplicas != null;
  }
  
  public boolean hasUnavailableReplicas() {
    return this.unavailableReplicas != null;
  }
  
  public boolean hasUpdatedReplicas() {
    return this.updatedReplicas != null;
  }
  
  public int hashCode() {
    return Objects.hash(availableReplicas, collisionCount, conditions, observedGeneration, readyReplicas, replicas, terminatingReplicas, unavailableReplicas, updatedReplicas, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<DeploymentCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (DeploymentCondition item : items) {
        DeploymentConditionBuilder builder = new DeploymentConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromConditions(DeploymentCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (DeploymentCondition item : items) {
        DeploymentConditionBuilder builder = new DeploymentConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<DeploymentConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<DeploymentConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        DeploymentConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,DeploymentCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,DeploymentCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    DeploymentConditionBuilder builder = new DeploymentConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availableReplicas == null)) {
        sb.append("availableReplicas:");
        sb.append(availableReplicas);
        sb.append(",");
    }
    if (!(collisionCount == null)) {
        sb.append("collisionCount:");
        sb.append(collisionCount);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(readyReplicas == null)) {
        sb.append("readyReplicas:");
        sb.append(readyReplicas);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(terminatingReplicas == null)) {
        sb.append("terminatingReplicas:");
        sb.append(terminatingReplicas);
        sb.append(",");
    }
    if (!(unavailableReplicas == null)) {
        sb.append("unavailableReplicas:");
        sb.append(unavailableReplicas);
        sb.append(",");
    }
    if (!(updatedReplicas == null)) {
        sb.append("updatedReplicas:");
        sb.append(updatedReplicas);
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
  
  public A withAvailableReplicas(Integer availableReplicas) {
    this.availableReplicas = availableReplicas;
    return (A) this;
  }
  
  public A withCollisionCount(Integer collisionCount) {
    this.collisionCount = collisionCount;
    return (A) this;
  }
  
  public A withConditions(List<DeploymentCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (DeploymentCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(DeploymentCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (DeploymentCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withReadyReplicas(Integer readyReplicas) {
    this.readyReplicas = readyReplicas;
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withTerminatingReplicas(Integer terminatingReplicas) {
    this.terminatingReplicas = terminatingReplicas;
    return (A) this;
  }
  
  public A withUnavailableReplicas(Integer unavailableReplicas) {
    this.unavailableReplicas = unavailableReplicas;
    return (A) this;
  }
  
  public A withUpdatedReplicas(Integer updatedReplicas) {
    this.updatedReplicas = updatedReplicas;
    return (A) this;
  }
  public class ConditionsNested<N> extends DeploymentConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    DeploymentConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,DeploymentCondition item) {
      this.index = index;
      this.builder = new DeploymentConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}