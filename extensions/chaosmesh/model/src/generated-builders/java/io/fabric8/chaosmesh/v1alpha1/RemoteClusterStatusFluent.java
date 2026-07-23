package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class RemoteClusterStatusFluent<A extends io.fabric8.chaosmesh.v1alpha1.RemoteClusterStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RemoteClusterConditionBuilder> conditions = new ArrayList<RemoteClusterConditionBuilder>();
  private String currentVersion;
  private Long observedGeneration;

  public RemoteClusterStatusFluent() {
  }
  
  public RemoteClusterStatusFluent(RemoteClusterStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<RemoteClusterCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (RemoteClusterCondition item : items) {
        RemoteClusterConditionBuilder builder = new RemoteClusterConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String reason,String status,String type) {
    return (A) this.addToConditions(new RemoteClusterCondition(reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(RemoteClusterCondition item) {
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
  
  public A addToConditions(RemoteClusterCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (RemoteClusterCondition item : items) {
        RemoteClusterConditionBuilder builder = new RemoteClusterConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,RemoteClusterCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    RemoteClusterConditionBuilder builder = new RemoteClusterConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public RemoteClusterCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<RemoteClusterCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public RemoteClusterCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public RemoteClusterCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public RemoteClusterCondition buildMatchingCondition(Predicate<RemoteClusterConditionBuilder> predicate) {
      for (RemoteClusterConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(RemoteClusterStatus instance) {
    instance = instance != null ? instance : new RemoteClusterStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withCurrentVersion(instance.getCurrentVersion());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<RemoteClusterConditionBuilder> predicate) {
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
    RemoteClusterStatusFluent that = (RemoteClusterStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentVersion, that.currentVersion))) {
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
  
  public String getCurrentVersion() {
    return this.currentVersion;
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
  
  public boolean hasCurrentVersion() {
    return this.currentVersion != null;
  }
  
  public boolean hasMatchingCondition(Predicate<RemoteClusterConditionBuilder> predicate) {
      for (RemoteClusterConditionBuilder item : conditions) {
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
    return Objects.hash(conditions, currentVersion, observedGeneration, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<RemoteClusterCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (RemoteClusterCondition item : items) {
        RemoteClusterConditionBuilder builder = new RemoteClusterConditionBuilder(item);
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
  
  public A removeFromConditions(RemoteClusterCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (RemoteClusterCondition item : items) {
        RemoteClusterConditionBuilder builder = new RemoteClusterConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<RemoteClusterConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<RemoteClusterConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        RemoteClusterConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,RemoteClusterCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,RemoteClusterCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    RemoteClusterConditionBuilder builder = new RemoteClusterConditionBuilder(item);
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
    if (!(currentVersion == null)) {
        sb.append("currentVersion:");
        sb.append(currentVersion);
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
  
  public A withConditions(List<RemoteClusterCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (RemoteClusterCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(RemoteClusterCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (RemoteClusterCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentVersion(String currentVersion) {
    this.currentVersion = currentVersion;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  public class ConditionsNested<N> extends RemoteClusterConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    RemoteClusterConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,RemoteClusterCondition item) {
      this.index = index;
      this.builder = new RemoteClusterConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteClusterStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}