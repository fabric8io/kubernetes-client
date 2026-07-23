package io.fabric8.kubernetes.api.model.extensions;

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
public class DaemonSetStatusFluent<A extends io.fabric8.kubernetes.api.model.extensions.DaemonSetStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer collisionCount;
  private ArrayList<DaemonSetConditionBuilder> conditions = new ArrayList<DaemonSetConditionBuilder>();
  private Integer currentNumberScheduled;
  private Integer desiredNumberScheduled;
  private Integer numberAvailable;
  private Integer numberMisscheduled;
  private Integer numberReady;
  private Integer numberUnavailable;
  private Long observedGeneration;
  private Integer updatedNumberScheduled;

  public DaemonSetStatusFluent() {
  }
  
  public DaemonSetStatusFluent(DaemonSetStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<DaemonSetCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (DaemonSetCondition item : items) {
        DaemonSetConditionBuilder builder = new DaemonSetConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new DaemonSetCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(DaemonSetCondition item) {
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
  
  public A addToConditions(DaemonSetCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (DaemonSetCondition item : items) {
        DaemonSetConditionBuilder builder = new DaemonSetConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,DaemonSetCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    DaemonSetConditionBuilder builder = new DaemonSetConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public DaemonSetCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<DaemonSetCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public DaemonSetCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public DaemonSetCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public DaemonSetCondition buildMatchingCondition(Predicate<DaemonSetConditionBuilder> predicate) {
      for (DaemonSetConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(DaemonSetStatus instance) {
    instance = instance != null ? instance : new DaemonSetStatus();
    if (instance != null) {
        this.withCollisionCount(instance.getCollisionCount());
        this.withConditions(instance.getConditions());
        this.withCurrentNumberScheduled(instance.getCurrentNumberScheduled());
        this.withDesiredNumberScheduled(instance.getDesiredNumberScheduled());
        this.withNumberAvailable(instance.getNumberAvailable());
        this.withNumberMisscheduled(instance.getNumberMisscheduled());
        this.withNumberReady(instance.getNumberReady());
        this.withNumberUnavailable(instance.getNumberUnavailable());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withUpdatedNumberScheduled(instance.getUpdatedNumberScheduled());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<DaemonSetConditionBuilder> predicate) {
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
    DaemonSetStatusFluent that = (DaemonSetStatusFluent) o;
    if (!(Objects.equals(collisionCount, that.collisionCount))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentNumberScheduled, that.currentNumberScheduled))) {
      return false;
    }
    if (!(Objects.equals(desiredNumberScheduled, that.desiredNumberScheduled))) {
      return false;
    }
    if (!(Objects.equals(numberAvailable, that.numberAvailable))) {
      return false;
    }
    if (!(Objects.equals(numberMisscheduled, that.numberMisscheduled))) {
      return false;
    }
    if (!(Objects.equals(numberReady, that.numberReady))) {
      return false;
    }
    if (!(Objects.equals(numberUnavailable, that.numberUnavailable))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(updatedNumberScheduled, that.updatedNumberScheduled))) {
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
  
  public Integer getCollisionCount() {
    return this.collisionCount;
  }
  
  public Integer getCurrentNumberScheduled() {
    return this.currentNumberScheduled;
  }
  
  public Integer getDesiredNumberScheduled() {
    return this.desiredNumberScheduled;
  }
  
  public Integer getNumberAvailable() {
    return this.numberAvailable;
  }
  
  public Integer getNumberMisscheduled() {
    return this.numberMisscheduled;
  }
  
  public Integer getNumberReady() {
    return this.numberReady;
  }
  
  public Integer getNumberUnavailable() {
    return this.numberUnavailable;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public Integer getUpdatedNumberScheduled() {
    return this.updatedNumberScheduled;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCollisionCount() {
    return this.collisionCount != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasCurrentNumberScheduled() {
    return this.currentNumberScheduled != null;
  }
  
  public boolean hasDesiredNumberScheduled() {
    return this.desiredNumberScheduled != null;
  }
  
  public boolean hasMatchingCondition(Predicate<DaemonSetConditionBuilder> predicate) {
      for (DaemonSetConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNumberAvailable() {
    return this.numberAvailable != null;
  }
  
  public boolean hasNumberMisscheduled() {
    return this.numberMisscheduled != null;
  }
  
  public boolean hasNumberReady() {
    return this.numberReady != null;
  }
  
  public boolean hasNumberUnavailable() {
    return this.numberUnavailable != null;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasUpdatedNumberScheduled() {
    return this.updatedNumberScheduled != null;
  }
  
  public int hashCode() {
    return Objects.hash(collisionCount, conditions, currentNumberScheduled, desiredNumberScheduled, numberAvailable, numberMisscheduled, numberReady, numberUnavailable, observedGeneration, updatedNumberScheduled, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<DaemonSetCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (DaemonSetCondition item : items) {
        DaemonSetConditionBuilder builder = new DaemonSetConditionBuilder(item);
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
  
  public A removeFromConditions(DaemonSetCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (DaemonSetCondition item : items) {
        DaemonSetConditionBuilder builder = new DaemonSetConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<DaemonSetConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<DaemonSetConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        DaemonSetConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,DaemonSetCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,DaemonSetCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    DaemonSetConditionBuilder builder = new DaemonSetConditionBuilder(item);
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
    if (!(currentNumberScheduled == null)) {
        sb.append("currentNumberScheduled:");
        sb.append(currentNumberScheduled);
        sb.append(",");
    }
    if (!(desiredNumberScheduled == null)) {
        sb.append("desiredNumberScheduled:");
        sb.append(desiredNumberScheduled);
        sb.append(",");
    }
    if (!(numberAvailable == null)) {
        sb.append("numberAvailable:");
        sb.append(numberAvailable);
        sb.append(",");
    }
    if (!(numberMisscheduled == null)) {
        sb.append("numberMisscheduled:");
        sb.append(numberMisscheduled);
        sb.append(",");
    }
    if (!(numberReady == null)) {
        sb.append("numberReady:");
        sb.append(numberReady);
        sb.append(",");
    }
    if (!(numberUnavailable == null)) {
        sb.append("numberUnavailable:");
        sb.append(numberUnavailable);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(updatedNumberScheduled == null)) {
        sb.append("updatedNumberScheduled:");
        sb.append(updatedNumberScheduled);
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
  
  public A withCollisionCount(Integer collisionCount) {
    this.collisionCount = collisionCount;
    return (A) this;
  }
  
  public A withConditions(List<DaemonSetCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (DaemonSetCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(DaemonSetCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (DaemonSetCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentNumberScheduled(Integer currentNumberScheduled) {
    this.currentNumberScheduled = currentNumberScheduled;
    return (A) this;
  }
  
  public A withDesiredNumberScheduled(Integer desiredNumberScheduled) {
    this.desiredNumberScheduled = desiredNumberScheduled;
    return (A) this;
  }
  
  public A withNumberAvailable(Integer numberAvailable) {
    this.numberAvailable = numberAvailable;
    return (A) this;
  }
  
  public A withNumberMisscheduled(Integer numberMisscheduled) {
    this.numberMisscheduled = numberMisscheduled;
    return (A) this;
  }
  
  public A withNumberReady(Integer numberReady) {
    this.numberReady = numberReady;
    return (A) this;
  }
  
  public A withNumberUnavailable(Integer numberUnavailable) {
    this.numberUnavailable = numberUnavailable;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withUpdatedNumberScheduled(Integer updatedNumberScheduled) {
    this.updatedNumberScheduled = updatedNumberScheduled;
    return (A) this;
  }
  public class ConditionsNested<N> extends DaemonSetConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    DaemonSetConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,DaemonSetCondition item) {
      this.index = index;
      this.builder = new DaemonSetConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) DaemonSetStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}