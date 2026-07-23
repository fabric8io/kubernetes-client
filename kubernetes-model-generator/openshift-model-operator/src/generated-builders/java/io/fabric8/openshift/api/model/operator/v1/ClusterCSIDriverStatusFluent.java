package io.fabric8.openshift.api.model.operator.v1;

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
public class ClusterCSIDriverStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriverStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<OperatorConditionBuilder> conditions = new ArrayList<OperatorConditionBuilder>();
  private ArrayList<GenerationStatusBuilder> generations = new ArrayList<GenerationStatusBuilder>();
  private Integer latestAvailableRevision;
  private Long observedGeneration;
  private Integer readyReplicas;
  private String version;

  public ClusterCSIDriverStatusFluent() {
  }
  
  public ClusterCSIDriverStatusFluent(ClusterCSIDriverStatus instance) {
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
  
  public A addAllToGenerations(Collection<GenerationStatus> items) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    for (GenerationStatus item : items) {
        GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
        _visitables.get("generations").add(builder);
        this.generations.add(builder);
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
  
  public GenerationsNested<A> addNewGeneration() {
    return new GenerationsNested(-1, null);
  }
  
  public GenerationsNested<A> addNewGenerationLike(GenerationStatus item) {
    return new GenerationsNested(-1, item);
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
  
  public A addToGenerations(GenerationStatus... items) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    for (GenerationStatus item : items) {
        GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
        _visitables.get("generations").add(builder);
        this.generations.add(builder);
    }
    return (A) this;
  }
  
  public A addToGenerations(int index,GenerationStatus item) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
    if (index < 0 || index >= generations.size()) {
        _visitables.get("generations").add(builder);
        generations.add(builder);
    } else {
        _visitables.get("generations").add(builder);
        generations.add(index, builder);
    }
    return (A) this;
  }
  
  public OperatorCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<OperatorCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public OperatorCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public GenerationStatus buildFirstGeneration() {
    return this.generations.get(0).build();
  }
  
  public GenerationStatus buildGeneration(int index) {
    return this.generations.get(index).build();
  }
  
  public List<GenerationStatus> buildGenerations() {
    return this.generations != null ? build(generations) : null;
  }
  
  public OperatorCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public GenerationStatus buildLastGeneration() {
    return this.generations.get(generations.size() - 1).build();
  }
  
  public OperatorCondition buildMatchingCondition(Predicate<OperatorConditionBuilder> predicate) {
      for (OperatorConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GenerationStatus buildMatchingGeneration(Predicate<GenerationStatusBuilder> predicate) {
      for (GenerationStatusBuilder item : generations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterCSIDriverStatus instance) {
    instance = instance != null ? instance : new ClusterCSIDriverStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withGenerations(instance.getGenerations());
        this.withLatestAvailableRevision(instance.getLatestAvailableRevision());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withReadyReplicas(instance.getReadyReplicas());
        this.withVersion(instance.getVersion());
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
  
  public GenerationsNested<A> editFirstGeneration() {
    if (generations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "generations"));
    }
    return this.setNewGenerationLike(0, this.buildGeneration(0));
  }
  
  public GenerationsNested<A> editGeneration(int index) {
    if (generations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "generations"));
    }
    return this.setNewGenerationLike(index, this.buildGeneration(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public GenerationsNested<A> editLastGeneration() {
    int index = generations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "generations"));
    }
    return this.setNewGenerationLike(index, this.buildGeneration(index));
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
  
  public GenerationsNested<A> editMatchingGeneration(Predicate<GenerationStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < generations.size();i++) {
      if (predicate.test(generations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "generations"));
    }
    return this.setNewGenerationLike(index, this.buildGeneration(index));
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
    ClusterCSIDriverStatusFluent that = (ClusterCSIDriverStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(generations, that.generations))) {
      return false;
    }
    if (!(Objects.equals(latestAvailableRevision, that.latestAvailableRevision))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(readyReplicas, that.readyReplicas))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public Integer getLatestAvailableRevision() {
    return this.latestAvailableRevision;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public Integer getReadyReplicas() {
    return this.readyReplicas;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasGenerations() {
    return this.generations != null && !(this.generations.isEmpty());
  }
  
  public boolean hasLatestAvailableRevision() {
    return this.latestAvailableRevision != null;
  }
  
  public boolean hasMatchingCondition(Predicate<OperatorConditionBuilder> predicate) {
      for (OperatorConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGeneration(Predicate<GenerationStatusBuilder> predicate) {
      for (GenerationStatusBuilder item : generations) {
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
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, generations, latestAvailableRevision, observedGeneration, readyReplicas, version, additionalProperties);
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
  
  public A removeAllFromGenerations(Collection<GenerationStatus> items) {
    if (this.generations == null) {
      return (A) this;
    }
    for (GenerationStatus item : items) {
        GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
        _visitables.get("generations").remove(builder);
        this.generations.remove(builder);
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
  
  public A removeFromGenerations(GenerationStatus... items) {
    if (this.generations == null) {
      return (A) this;
    }
    for (GenerationStatus item : items) {
        GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
        _visitables.get("generations").remove(builder);
        this.generations.remove(builder);
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
  
  public A removeMatchingFromGenerations(Predicate<GenerationStatusBuilder> predicate) {
    if (generations == null) {
      return (A) this;
    }
    Iterator<GenerationStatusBuilder> each = generations.iterator();
    List visitables = _visitables.get("generations");
    while (each.hasNext()) {
        GenerationStatusBuilder builder = each.next();
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
  
  public GenerationsNested<A> setNewGenerationLike(int index,GenerationStatus item) {
    return new GenerationsNested(index, item);
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
  
  public A setToGenerations(int index,GenerationStatus item) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
    if (index < 0 || index >= generations.size()) {
        _visitables.get("generations").add(builder);
        generations.add(builder);
    } else {
        _visitables.get("generations").add(builder);
        generations.set(index, builder);
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
    if (!(generations == null) && !(generations.isEmpty())) {
        sb.append("generations:");
        sb.append(generations);
        sb.append(",");
    }
    if (!(latestAvailableRevision == null)) {
        sb.append("latestAvailableRevision:");
        sb.append(latestAvailableRevision);
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
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withGenerations(List<GenerationStatus> generations) {
    if (this.generations != null) {
      this._visitables.get("generations").clear();
    }
    if (generations != null) {
        this.generations = new ArrayList();
        for (GenerationStatus item : generations) {
          this.addToGenerations(item);
        }
    } else {
      this.generations = null;
    }
    return (A) this;
  }
  
  public A withGenerations(GenerationStatus... generations) {
    if (this.generations != null) {
        this.generations.clear();
        _visitables.remove("generations");
    }
    if (generations != null) {
      for (GenerationStatus item : generations) {
        this.addToGenerations(item);
      }
    }
    return (A) this;
  }
  
  public A withLatestAvailableRevision(Integer latestAvailableRevision) {
    this.latestAvailableRevision = latestAvailableRevision;
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
  
  public A withVersion(String version) {
    this.version = version;
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
      return (N) ClusterCSIDriverStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class GenerationsNested<N> extends GenerationStatusFluent<GenerationsNested<N>> implements Nested<N>{
  
    GenerationStatusBuilder builder;
    int index;
  
    GenerationsNested(int index,GenerationStatus item) {
      this.index = index;
      this.builder = new GenerationStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterCSIDriverStatusFluent.this.setToGenerations(index, builder.build());
    }
    
    public N endGeneration() {
      return and();
    }
    
  }
}