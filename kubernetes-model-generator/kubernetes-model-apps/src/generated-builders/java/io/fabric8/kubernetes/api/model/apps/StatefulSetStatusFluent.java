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
public class StatefulSetStatusFluent<A extends io.fabric8.kubernetes.api.model.apps.StatefulSetStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer availableReplicas;
  private Integer collisionCount;
  private ArrayList<StatefulSetConditionBuilder> conditions = new ArrayList<StatefulSetConditionBuilder>();
  private Integer currentReplicas;
  private String currentRevision;
  private Long observedGeneration;
  private Integer readyReplicas;
  private Integer replicas;
  private String updateRevision;
  private Integer updatedReplicas;

  public StatefulSetStatusFluent() {
  }
  
  public StatefulSetStatusFluent(StatefulSetStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<StatefulSetCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (StatefulSetCondition item : items) {
        StatefulSetConditionBuilder builder = new StatefulSetConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new StatefulSetCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(StatefulSetCondition item) {
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
  
  public A addToConditions(StatefulSetCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (StatefulSetCondition item : items) {
        StatefulSetConditionBuilder builder = new StatefulSetConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,StatefulSetCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    StatefulSetConditionBuilder builder = new StatefulSetConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public StatefulSetCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<StatefulSetCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public StatefulSetCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public StatefulSetCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public StatefulSetCondition buildMatchingCondition(Predicate<StatefulSetConditionBuilder> predicate) {
      for (StatefulSetConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(StatefulSetStatus instance) {
    instance = instance != null ? instance : new StatefulSetStatus();
    if (instance != null) {
        this.withAvailableReplicas(instance.getAvailableReplicas());
        this.withCollisionCount(instance.getCollisionCount());
        this.withConditions(instance.getConditions());
        this.withCurrentReplicas(instance.getCurrentReplicas());
        this.withCurrentRevision(instance.getCurrentRevision());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withReadyReplicas(instance.getReadyReplicas());
        this.withReplicas(instance.getReplicas());
        this.withUpdateRevision(instance.getUpdateRevision());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<StatefulSetConditionBuilder> predicate) {
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
    StatefulSetStatusFluent that = (StatefulSetStatusFluent) o;
    if (!(Objects.equals(availableReplicas, that.availableReplicas))) {
      return false;
    }
    if (!(Objects.equals(collisionCount, that.collisionCount))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentReplicas, that.currentReplicas))) {
      return false;
    }
    if (!(Objects.equals(currentRevision, that.currentRevision))) {
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
    if (!(Objects.equals(updateRevision, that.updateRevision))) {
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
  
  public Integer getCurrentReplicas() {
    return this.currentReplicas;
  }
  
  public String getCurrentRevision() {
    return this.currentRevision;
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
  
  public String getUpdateRevision() {
    return this.updateRevision;
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
  
  public boolean hasCurrentReplicas() {
    return this.currentReplicas != null;
  }
  
  public boolean hasCurrentRevision() {
    return this.currentRevision != null;
  }
  
  public boolean hasMatchingCondition(Predicate<StatefulSetConditionBuilder> predicate) {
      for (StatefulSetConditionBuilder item : conditions) {
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
  
  public boolean hasUpdateRevision() {
    return this.updateRevision != null;
  }
  
  public boolean hasUpdatedReplicas() {
    return this.updatedReplicas != null;
  }
  
  public int hashCode() {
    return Objects.hash(availableReplicas, collisionCount, conditions, currentReplicas, currentRevision, observedGeneration, readyReplicas, replicas, updateRevision, updatedReplicas, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<StatefulSetCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (StatefulSetCondition item : items) {
        StatefulSetConditionBuilder builder = new StatefulSetConditionBuilder(item);
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
  
  public A removeFromConditions(StatefulSetCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (StatefulSetCondition item : items) {
        StatefulSetConditionBuilder builder = new StatefulSetConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<StatefulSetConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<StatefulSetConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        StatefulSetConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,StatefulSetCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,StatefulSetCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    StatefulSetConditionBuilder builder = new StatefulSetConditionBuilder(item);
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
    if (!(currentReplicas == null)) {
        sb.append("currentReplicas:");
        sb.append(currentReplicas);
        sb.append(",");
    }
    if (!(currentRevision == null)) {
        sb.append("currentRevision:");
        sb.append(currentRevision);
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
    if (!(updateRevision == null)) {
        sb.append("updateRevision:");
        sb.append(updateRevision);
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
  
  public A withConditions(List<StatefulSetCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (StatefulSetCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(StatefulSetCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (StatefulSetCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentReplicas(Integer currentReplicas) {
    this.currentReplicas = currentReplicas;
    return (A) this;
  }
  
  public A withCurrentRevision(String currentRevision) {
    this.currentRevision = currentRevision;
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
  
  public A withUpdateRevision(String updateRevision) {
    this.updateRevision = updateRevision;
    return (A) this;
  }
  
  public A withUpdatedReplicas(Integer updatedReplicas) {
    this.updatedReplicas = updatedReplicas;
    return (A) this;
  }
  public class ConditionsNested<N> extends StatefulSetConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    StatefulSetConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,StatefulSetCondition item) {
      this.index = index;
      this.builder = new StatefulSetConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) StatefulSetStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}