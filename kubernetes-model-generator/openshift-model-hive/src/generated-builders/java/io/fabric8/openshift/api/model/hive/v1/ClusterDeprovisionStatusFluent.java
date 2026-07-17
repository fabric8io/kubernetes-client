package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class ClusterDeprovisionStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterDeprovisionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean completed;
  private ArrayList<ClusterDeprovisionConditionBuilder> conditions = new ArrayList<ClusterDeprovisionConditionBuilder>();

  public ClusterDeprovisionStatusFluent() {
  }
  
  public ClusterDeprovisionStatusFluent(ClusterDeprovisionStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<ClusterDeprovisionCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterDeprovisionCondition item : items) {
        ClusterDeprovisionConditionBuilder builder = new ClusterDeprovisionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(ClusterDeprovisionCondition item) {
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
  
  public A addToConditions(ClusterDeprovisionCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterDeprovisionCondition item : items) {
        ClusterDeprovisionConditionBuilder builder = new ClusterDeprovisionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ClusterDeprovisionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterDeprovisionConditionBuilder builder = new ClusterDeprovisionConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterDeprovisionCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<ClusterDeprovisionCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ClusterDeprovisionCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ClusterDeprovisionCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ClusterDeprovisionCondition buildMatchingCondition(Predicate<ClusterDeprovisionConditionBuilder> predicate) {
      for (ClusterDeprovisionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterDeprovisionStatus instance) {
    instance = instance != null ? instance : new ClusterDeprovisionStatus();
    if (instance != null) {
        this.withCompleted(instance.getCompleted());
        this.withConditions(instance.getConditions());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ClusterDeprovisionConditionBuilder> predicate) {
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
    ClusterDeprovisionStatusFluent that = (ClusterDeprovisionStatusFluent) o;
    if (!(Objects.equals(completed, that.completed))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
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
  
  public Boolean getCompleted() {
    return this.completed;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompleted() {
    return this.completed != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<ClusterDeprovisionConditionBuilder> predicate) {
      for (ClusterDeprovisionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(completed, conditions, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<ClusterDeprovisionCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterDeprovisionCondition item : items) {
        ClusterDeprovisionConditionBuilder builder = new ClusterDeprovisionConditionBuilder(item);
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
  
  public A removeFromConditions(ClusterDeprovisionCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterDeprovisionCondition item : items) {
        ClusterDeprovisionConditionBuilder builder = new ClusterDeprovisionConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ClusterDeprovisionConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ClusterDeprovisionConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ClusterDeprovisionConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,ClusterDeprovisionCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,ClusterDeprovisionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterDeprovisionConditionBuilder builder = new ClusterDeprovisionConditionBuilder(item);
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
    if (!(completed == null)) {
        sb.append("completed:");
        sb.append(completed);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
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
  
  public A withCompleted() {
    return withCompleted(true);
  }
  
  public A withCompleted(Boolean completed) {
    this.completed = completed;
    return (A) this;
  }
  
  public A withConditions(List<ClusterDeprovisionCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ClusterDeprovisionCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ClusterDeprovisionCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ClusterDeprovisionCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends ClusterDeprovisionConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ClusterDeprovisionConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,ClusterDeprovisionCondition item) {
      this.index = index;
      this.builder = new ClusterDeprovisionConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeprovisionStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}