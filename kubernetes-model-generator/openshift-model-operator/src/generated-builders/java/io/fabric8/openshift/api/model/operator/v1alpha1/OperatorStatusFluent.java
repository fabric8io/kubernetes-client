package io.fabric8.openshift.api.model.operator.v1alpha1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OperatorStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.OperatorStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<OperatorConditionBuilder> conditions = new ArrayList<OperatorConditionBuilder>();
  private VersionAvailabilityBuilder currentVersionAvailability;
  private Long observedGeneration;
  private String state;
  private VersionAvailabilityBuilder targetVersionAvailability;
  private String taskSummary;

  public OperatorStatusFluent() {
  }
  
  public OperatorStatusFluent(OperatorStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<OperatorCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (OperatorCondition item : items) {
        OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new OperatorCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(OperatorCondition item) {
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
  
  public A addToConditions(OperatorCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (OperatorCondition item : items) {
        OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,OperatorCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public OperatorCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<OperatorCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public VersionAvailability buildCurrentVersionAvailability() {
    return this.currentVersionAvailability != null ? this.currentVersionAvailability.build() : null;
  }
  
  public OperatorCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public OperatorCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public OperatorCondition buildMatchingCondition(Predicate<OperatorConditionBuilder> predicate) {
      for (OperatorConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VersionAvailability buildTargetVersionAvailability() {
    return this.targetVersionAvailability != null ? this.targetVersionAvailability.build() : null;
  }
  
  protected void copyInstance(OperatorStatus instance) {
    instance = instance != null ? instance : new OperatorStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withCurrentVersionAvailability(instance.getCurrentVersionAvailability());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withState(instance.getState());
        this.withTargetVersionAvailability(instance.getTargetVersionAvailability());
        this.withTaskSummary(instance.getTaskSummary());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public CurrentVersionAvailabilityNested<A> editCurrentVersionAvailability() {
    return this.withNewCurrentVersionAvailabilityLike(Optional.ofNullable(this.buildCurrentVersionAvailability()).orElse(null));
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<OperatorConditionBuilder> predicate) {
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
  
  public CurrentVersionAvailabilityNested<A> editOrNewCurrentVersionAvailability() {
    return this.withNewCurrentVersionAvailabilityLike(Optional.ofNullable(this.buildCurrentVersionAvailability()).orElse(new VersionAvailabilityBuilder().build()));
  }
  
  public CurrentVersionAvailabilityNested<A> editOrNewCurrentVersionAvailabilityLike(VersionAvailability item) {
    return this.withNewCurrentVersionAvailabilityLike(Optional.ofNullable(this.buildCurrentVersionAvailability()).orElse(item));
  }
  
  public TargetVersionAvailabilityNested<A> editOrNewTargetVersionAvailability() {
    return this.withNewTargetVersionAvailabilityLike(Optional.ofNullable(this.buildTargetVersionAvailability()).orElse(new VersionAvailabilityBuilder().build()));
  }
  
  public TargetVersionAvailabilityNested<A> editOrNewTargetVersionAvailabilityLike(VersionAvailability item) {
    return this.withNewTargetVersionAvailabilityLike(Optional.ofNullable(this.buildTargetVersionAvailability()).orElse(item));
  }
  
  public TargetVersionAvailabilityNested<A> editTargetVersionAvailability() {
    return this.withNewTargetVersionAvailabilityLike(Optional.ofNullable(this.buildTargetVersionAvailability()).orElse(null));
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
    OperatorStatusFluent that = (OperatorStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentVersionAvailability, that.currentVersionAvailability))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
      return false;
    }
    if (!(Objects.equals(targetVersionAvailability, that.targetVersionAvailability))) {
      return false;
    }
    if (!(Objects.equals(taskSummary, that.taskSummary))) {
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
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public String getState() {
    return this.state;
  }
  
  public String getTaskSummary() {
    return this.taskSummary;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasCurrentVersionAvailability() {
    return this.currentVersionAvailability != null;
  }
  
  public boolean hasMatchingCondition(Predicate<OperatorConditionBuilder> predicate) {
      for (OperatorConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasTargetVersionAvailability() {
    return this.targetVersionAvailability != null;
  }
  
  public boolean hasTaskSummary() {
    return this.taskSummary != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, currentVersionAvailability, observedGeneration, state, targetVersionAvailability, taskSummary, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<OperatorCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (OperatorCondition item : items) {
        OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
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
  
  public A removeFromConditions(OperatorCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (OperatorCondition item : items) {
        OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<OperatorConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<OperatorConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        OperatorConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,OperatorCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,OperatorCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
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
    if (!(currentVersionAvailability == null)) {
        sb.append("currentVersionAvailability:");
        sb.append(currentVersionAvailability);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(targetVersionAvailability == null)) {
        sb.append("targetVersionAvailability:");
        sb.append(targetVersionAvailability);
        sb.append(",");
    }
    if (!(taskSummary == null)) {
        sb.append("taskSummary:");
        sb.append(taskSummary);
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
  
  public A withConditions(List<OperatorCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (OperatorCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(OperatorCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (OperatorCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentVersionAvailability(VersionAvailability currentVersionAvailability) {
    this._visitables.remove("currentVersionAvailability");
    if (currentVersionAvailability != null) {
        this.currentVersionAvailability = new VersionAvailabilityBuilder(currentVersionAvailability);
        this._visitables.get("currentVersionAvailability").add(this.currentVersionAvailability);
    } else {
        this.currentVersionAvailability = null;
        this._visitables.get("currentVersionAvailability").remove(this.currentVersionAvailability);
    }
    return (A) this;
  }
  
  public CurrentVersionAvailabilityNested<A> withNewCurrentVersionAvailability() {
    return new CurrentVersionAvailabilityNested(null);
  }
  
  public CurrentVersionAvailabilityNested<A> withNewCurrentVersionAvailabilityLike(VersionAvailability item) {
    return new CurrentVersionAvailabilityNested(item);
  }
  
  public TargetVersionAvailabilityNested<A> withNewTargetVersionAvailability() {
    return new TargetVersionAvailabilityNested(null);
  }
  
  public TargetVersionAvailabilityNested<A> withNewTargetVersionAvailabilityLike(VersionAvailability item) {
    return new TargetVersionAvailabilityNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  
  public A withTargetVersionAvailability(VersionAvailability targetVersionAvailability) {
    this._visitables.remove("targetVersionAvailability");
    if (targetVersionAvailability != null) {
        this.targetVersionAvailability = new VersionAvailabilityBuilder(targetVersionAvailability);
        this._visitables.get("targetVersionAvailability").add(this.targetVersionAvailability);
    } else {
        this.targetVersionAvailability = null;
        this._visitables.get("targetVersionAvailability").remove(this.targetVersionAvailability);
    }
    return (A) this;
  }
  
  public A withTaskSummary(String taskSummary) {
    this.taskSummary = taskSummary;
    return (A) this;
  }
  public class ConditionsNested<N> extends OperatorConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    OperatorConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,OperatorCondition item) {
      this.index = index;
      this.builder = new OperatorConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class CurrentVersionAvailabilityNested<N> extends VersionAvailabilityFluent<CurrentVersionAvailabilityNested<N>> implements Nested<N>{
  
    VersionAvailabilityBuilder builder;
  
    CurrentVersionAvailabilityNested(VersionAvailability item) {
      this.builder = new VersionAvailabilityBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorStatusFluent.this.withCurrentVersionAvailability(builder.build());
    }
    
    public N endCurrentVersionAvailability() {
      return and();
    }
    
  }
  public class TargetVersionAvailabilityNested<N> extends VersionAvailabilityFluent<TargetVersionAvailabilityNested<N>> implements Nested<N>{
  
    VersionAvailabilityBuilder builder;
  
    TargetVersionAvailabilityNested(VersionAvailability item) {
      this.builder = new VersionAvailabilityBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorStatusFluent.this.withTargetVersionAvailability(builder.build());
    }
    
    public N endTargetVersionAvailability() {
      return and();
    }
    
  }
}