package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class ClusterPoolStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterPoolStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterPoolConditionBuilder> conditions = new ArrayList<ClusterPoolConditionBuilder>();
  private Integer ready;
  private Integer size;
  private Integer standby;

  public ClusterPoolStatusFluent() {
  }
  
  public ClusterPoolStatusFluent(ClusterPoolStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<ClusterPoolCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterPoolCondition item : items) {
        ClusterPoolConditionBuilder builder = new ClusterPoolConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(ClusterPoolCondition item) {
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
  
  public A addToConditions(ClusterPoolCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterPoolCondition item : items) {
        ClusterPoolConditionBuilder builder = new ClusterPoolConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ClusterPoolCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterPoolConditionBuilder builder = new ClusterPoolConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterPoolCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<ClusterPoolCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ClusterPoolCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ClusterPoolCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ClusterPoolCondition buildMatchingCondition(Predicate<ClusterPoolConditionBuilder> predicate) {
      for (ClusterPoolConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterPoolStatus instance) {
    instance = instance != null ? instance : new ClusterPoolStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withReady(instance.getReady());
        this.withSize(instance.getSize());
        this.withStandby(instance.getStandby());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ClusterPoolConditionBuilder> predicate) {
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
    ClusterPoolStatusFluent that = (ClusterPoolStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(ready, that.ready))) {
      return false;
    }
    if (!(Objects.equals(size, that.size))) {
      return false;
    }
    if (!(Objects.equals(standby, that.standby))) {
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
  
  public Integer getReady() {
    return this.ready;
  }
  
  public Integer getSize() {
    return this.size;
  }
  
  public Integer getStandby() {
    return this.standby;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<ClusterPoolConditionBuilder> predicate) {
      for (ClusterPoolConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReady() {
    return this.ready != null;
  }
  
  public boolean hasSize() {
    return this.size != null;
  }
  
  public boolean hasStandby() {
    return this.standby != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, ready, size, standby, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<ClusterPoolCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterPoolCondition item : items) {
        ClusterPoolConditionBuilder builder = new ClusterPoolConditionBuilder(item);
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
  
  public A removeFromConditions(ClusterPoolCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterPoolCondition item : items) {
        ClusterPoolConditionBuilder builder = new ClusterPoolConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ClusterPoolConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ClusterPoolConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ClusterPoolConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,ClusterPoolCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,ClusterPoolCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterPoolConditionBuilder builder = new ClusterPoolConditionBuilder(item);
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
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(ready == null)) {
        sb.append("ready:");
        sb.append(ready);
        sb.append(",");
    }
    if (!(size == null)) {
        sb.append("size:");
        sb.append(size);
        sb.append(",");
    }
    if (!(standby == null)) {
        sb.append("standby:");
        sb.append(standby);
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
  
  public A withConditions(List<ClusterPoolCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ClusterPoolCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ClusterPoolCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ClusterPoolCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withReady(Integer ready) {
    this.ready = ready;
    return (A) this;
  }
  
  public A withSize(Integer size) {
    this.size = size;
    return (A) this;
  }
  
  public A withStandby(Integer standby) {
    this.standby = standby;
    return (A) this;
  }
  public class ConditionsNested<N> extends ClusterPoolConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ClusterPoolConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,ClusterPoolCondition item) {
      this.index = index;
      this.builder = new ClusterPoolConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}