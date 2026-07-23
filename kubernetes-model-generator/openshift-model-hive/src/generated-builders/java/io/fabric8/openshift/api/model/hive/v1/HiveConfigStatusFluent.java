package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class HiveConfigStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.HiveConfigStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String aggregatorClientCAHash;
  private ArrayList<HiveConfigConditionBuilder> conditions = new ArrayList<HiveConfigConditionBuilder>();
  private Boolean configApplied;
  private Long observedGeneration;

  public HiveConfigStatusFluent() {
  }
  
  public HiveConfigStatusFluent(HiveConfigStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<HiveConfigCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (HiveConfigCondition item : items) {
        HiveConfigConditionBuilder builder = new HiveConfigConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(HiveConfigCondition item) {
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
  
  public A addToConditions(HiveConfigCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (HiveConfigCondition item : items) {
        HiveConfigConditionBuilder builder = new HiveConfigConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,HiveConfigCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    HiveConfigConditionBuilder builder = new HiveConfigConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public HiveConfigCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<HiveConfigCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public HiveConfigCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public HiveConfigCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public HiveConfigCondition buildMatchingCondition(Predicate<HiveConfigConditionBuilder> predicate) {
      for (HiveConfigConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(HiveConfigStatus instance) {
    instance = instance != null ? instance : new HiveConfigStatus();
    if (instance != null) {
        this.withAggregatorClientCAHash(instance.getAggregatorClientCAHash());
        this.withConditions(instance.getConditions());
        this.withConfigApplied(instance.getConfigApplied());
        this.withObservedGeneration(instance.getObservedGeneration());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<HiveConfigConditionBuilder> predicate) {
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
    HiveConfigStatusFluent that = (HiveConfigStatusFluent) o;
    if (!(Objects.equals(aggregatorClientCAHash, that.aggregatorClientCAHash))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(configApplied, that.configApplied))) {
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
  
  public String getAggregatorClientCAHash() {
    return this.aggregatorClientCAHash;
  }
  
  public Boolean getConfigApplied() {
    return this.configApplied;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAggregatorClientCAHash() {
    return this.aggregatorClientCAHash != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasConfigApplied() {
    return this.configApplied != null;
  }
  
  public boolean hasMatchingCondition(Predicate<HiveConfigConditionBuilder> predicate) {
      for (HiveConfigConditionBuilder item : conditions) {
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
    return Objects.hash(aggregatorClientCAHash, conditions, configApplied, observedGeneration, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<HiveConfigCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (HiveConfigCondition item : items) {
        HiveConfigConditionBuilder builder = new HiveConfigConditionBuilder(item);
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
  
  public A removeFromConditions(HiveConfigCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (HiveConfigCondition item : items) {
        HiveConfigConditionBuilder builder = new HiveConfigConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<HiveConfigConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<HiveConfigConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        HiveConfigConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,HiveConfigCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,HiveConfigCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    HiveConfigConditionBuilder builder = new HiveConfigConditionBuilder(item);
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
    if (!(aggregatorClientCAHash == null)) {
        sb.append("aggregatorClientCAHash:");
        sb.append(aggregatorClientCAHash);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(configApplied == null)) {
        sb.append("configApplied:");
        sb.append(configApplied);
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
  
  public A withAggregatorClientCAHash(String aggregatorClientCAHash) {
    this.aggregatorClientCAHash = aggregatorClientCAHash;
    return (A) this;
  }
  
  public A withConditions(List<HiveConfigCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (HiveConfigCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(HiveConfigCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (HiveConfigCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withConfigApplied() {
    return withConfigApplied(true);
  }
  
  public A withConfigApplied(Boolean configApplied) {
    this.configApplied = configApplied;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  public class ConditionsNested<N> extends HiveConfigConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    HiveConfigConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,HiveConfigCondition item) {
      this.index = index;
      this.builder = new HiveConfigConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}