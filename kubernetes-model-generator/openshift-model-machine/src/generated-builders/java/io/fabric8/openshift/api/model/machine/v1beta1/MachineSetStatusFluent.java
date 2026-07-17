package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class MachineSetStatusFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.MachineSetStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authoritativeAPI;
  private Integer availableReplicas;
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private String errorMessage;
  private String errorReason;
  private Integer fullyLabeledReplicas;
  private Long observedGeneration;
  private Integer readyReplicas;
  private Integer replicas;
  private Long synchronizedGeneration;

  public MachineSetStatusFluent() {
  }
  
  public MachineSetStatusFluent(MachineSetStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(Condition item) {
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ConditionBuilder builder = new ConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public Condition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<Condition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public Condition buildMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(MachineSetStatus instance) {
    instance = instance != null ? instance : new MachineSetStatus();
    if (instance != null) {
        this.withAuthoritativeAPI(instance.getAuthoritativeAPI());
        this.withAvailableReplicas(instance.getAvailableReplicas());
        this.withConditions(instance.getConditions());
        this.withErrorMessage(instance.getErrorMessage());
        this.withErrorReason(instance.getErrorReason());
        this.withFullyLabeledReplicas(instance.getFullyLabeledReplicas());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withReadyReplicas(instance.getReadyReplicas());
        this.withReplicas(instance.getReplicas());
        this.withSynchronizedGeneration(instance.getSynchronizedGeneration());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ConditionBuilder> predicate) {
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
    MachineSetStatusFluent that = (MachineSetStatusFluent) o;
    if (!(Objects.equals(authoritativeAPI, that.authoritativeAPI))) {
      return false;
    }
    if (!(Objects.equals(availableReplicas, that.availableReplicas))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(errorMessage, that.errorMessage))) {
      return false;
    }
    if (!(Objects.equals(errorReason, that.errorReason))) {
      return false;
    }
    if (!(Objects.equals(fullyLabeledReplicas, that.fullyLabeledReplicas))) {
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
    if (!(Objects.equals(synchronizedGeneration, that.synchronizedGeneration))) {
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
  
  public String getAuthoritativeAPI() {
    return this.authoritativeAPI;
  }
  
  public Integer getAvailableReplicas() {
    return this.availableReplicas;
  }
  
  public String getErrorMessage() {
    return this.errorMessage;
  }
  
  public String getErrorReason() {
    return this.errorReason;
  }
  
  public Integer getFullyLabeledReplicas() {
    return this.fullyLabeledReplicas;
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
  
  public Long getSynchronizedGeneration() {
    return this.synchronizedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthoritativeAPI() {
    return this.authoritativeAPI != null;
  }
  
  public boolean hasAvailableReplicas() {
    return this.availableReplicas != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasErrorMessage() {
    return this.errorMessage != null;
  }
  
  public boolean hasErrorReason() {
    return this.errorReason != null;
  }
  
  public boolean hasFullyLabeledReplicas() {
    return this.fullyLabeledReplicas != null;
  }
  
  public boolean hasMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
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
  
  public boolean hasSynchronizedGeneration() {
    return this.synchronizedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(authoritativeAPI, availableReplicas, conditions, errorMessage, errorReason, fullyLabeledReplicas, observedGeneration, readyReplicas, replicas, synchronizedGeneration, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,Condition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ConditionBuilder builder = new ConditionBuilder(item);
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
    if (!(authoritativeAPI == null)) {
        sb.append("authoritativeAPI:");
        sb.append(authoritativeAPI);
        sb.append(",");
    }
    if (!(availableReplicas == null)) {
        sb.append("availableReplicas:");
        sb.append(availableReplicas);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(errorMessage == null)) {
        sb.append("errorMessage:");
        sb.append(errorMessage);
        sb.append(",");
    }
    if (!(errorReason == null)) {
        sb.append("errorReason:");
        sb.append(errorReason);
        sb.append(",");
    }
    if (!(fullyLabeledReplicas == null)) {
        sb.append("fullyLabeledReplicas:");
        sb.append(fullyLabeledReplicas);
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
    if (!(synchronizedGeneration == null)) {
        sb.append("synchronizedGeneration:");
        sb.append(synchronizedGeneration);
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
  
  public A withAuthoritativeAPI(String authoritativeAPI) {
    this.authoritativeAPI = authoritativeAPI;
    return (A) this;
  }
  
  public A withAvailableReplicas(Integer availableReplicas) {
    this.availableReplicas = availableReplicas;
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
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
  
  public A withErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return (A) this;
  }
  
  public A withErrorReason(String errorReason) {
    this.errorReason = errorReason;
    return (A) this;
  }
  
  public A withFullyLabeledReplicas(Integer fullyLabeledReplicas) {
    this.fullyLabeledReplicas = fullyLabeledReplicas;
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
  
  public A withSynchronizedGeneration(Long synchronizedGeneration) {
    this.synchronizedGeneration = synchronizedGeneration;
    return (A) this;
  }
  public class ConditionsNested<N> extends ConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,Condition item) {
      this.index = index;
      this.builder = new ConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineSetStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}