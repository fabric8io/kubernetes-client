package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class GCPChaosStatusFluent<A extends io.fabric8.chaosmesh.v1alpha1.GCPChaosStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> attachedDiskStrings = new ArrayList<String>();
  private ArrayList<ChaosConditionBuilder> conditions = new ArrayList<ChaosConditionBuilder>();
  private ExperimentStatusBuilder experiment;

  public GCPChaosStatusFluent() {
  }
  
  public GCPChaosStatusFluent(GCPChaosStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAttachedDiskStrings(Collection<String> items) {
    if (this.attachedDiskStrings == null) {
      this.attachedDiskStrings = new ArrayList();
    }
    for (String item : items) {
      this.attachedDiskStrings.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<ChaosCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ChaosCondition item : items) {
        ChaosConditionBuilder builder = new ChaosConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String reason,String status,String type) {
    return (A) this.addToConditions(new ChaosCondition(reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(ChaosCondition item) {
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
  
  public A addToAttachedDiskStrings(String... items) {
    if (this.attachedDiskStrings == null) {
      this.attachedDiskStrings = new ArrayList();
    }
    for (String item : items) {
      this.attachedDiskStrings.add(item);
    }
    return (A) this;
  }
  
  public A addToAttachedDiskStrings(int index,String item) {
    if (this.attachedDiskStrings == null) {
      this.attachedDiskStrings = new ArrayList();
    }
    this.attachedDiskStrings.add(index, item);
    return (A) this;
  }
  
  public A addToConditions(ChaosCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ChaosCondition item : items) {
        ChaosConditionBuilder builder = new ChaosConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ChaosCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ChaosConditionBuilder builder = new ChaosConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public ChaosCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<ChaosCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ExperimentStatus buildExperiment() {
    return this.experiment != null ? this.experiment.build() : null;
  }
  
  public ChaosCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ChaosCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ChaosCondition buildMatchingCondition(Predicate<ChaosConditionBuilder> predicate) {
      for (ChaosConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(GCPChaosStatus instance) {
    instance = instance != null ? instance : new GCPChaosStatus();
    if (instance != null) {
        this.withAttachedDiskStrings(instance.getAttachedDiskStrings());
        this.withConditions(instance.getConditions());
        this.withExperiment(instance.getExperiment());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ExperimentNested<A> editExperiment() {
    return this.withNewExperimentLike(Optional.ofNullable(this.buildExperiment()).orElse(null));
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ChaosConditionBuilder> predicate) {
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
  
  public ExperimentNested<A> editOrNewExperiment() {
    return this.withNewExperimentLike(Optional.ofNullable(this.buildExperiment()).orElse(new ExperimentStatusBuilder().build()));
  }
  
  public ExperimentNested<A> editOrNewExperimentLike(ExperimentStatus item) {
    return this.withNewExperimentLike(Optional.ofNullable(this.buildExperiment()).orElse(item));
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
    GCPChaosStatusFluent that = (GCPChaosStatusFluent) o;
    if (!(Objects.equals(attachedDiskStrings, that.attachedDiskStrings))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(experiment, that.experiment))) {
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
  
  public String getAttachedDiskString(int index) {
    return this.attachedDiskStrings.get(index);
  }
  
  public List<String> getAttachedDiskStrings() {
    return this.attachedDiskStrings;
  }
  
  public String getFirstAttachedDiskString() {
    return this.attachedDiskStrings.get(0);
  }
  
  public String getLastAttachedDiskString() {
    return this.attachedDiskStrings.get(attachedDiskStrings.size() - 1);
  }
  
  public String getMatchingAttachedDiskString(Predicate<String> predicate) {
      for (String item : attachedDiskStrings) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttachedDiskStrings() {
    return this.attachedDiskStrings != null && !(this.attachedDiskStrings.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasExperiment() {
    return this.experiment != null;
  }
  
  public boolean hasMatchingAttachedDiskString(Predicate<String> predicate) {
      for (String item : attachedDiskStrings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<ChaosConditionBuilder> predicate) {
      for (ChaosConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(attachedDiskStrings, conditions, experiment, additionalProperties);
  }
  
  public A removeAllFromAttachedDiskStrings(Collection<String> items) {
    if (this.attachedDiskStrings == null) {
      return (A) this;
    }
    for (String item : items) {
      this.attachedDiskStrings.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<ChaosCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ChaosCondition item : items) {
        ChaosConditionBuilder builder = new ChaosConditionBuilder(item);
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
  
  public A removeFromAttachedDiskStrings(String... items) {
    if (this.attachedDiskStrings == null) {
      return (A) this;
    }
    for (String item : items) {
      this.attachedDiskStrings.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromConditions(ChaosCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ChaosCondition item : items) {
        ChaosConditionBuilder builder = new ChaosConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ChaosConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ChaosConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ChaosConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,ChaosCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToAttachedDiskStrings(int index,String item) {
    if (this.attachedDiskStrings == null) {
      this.attachedDiskStrings = new ArrayList();
    }
    this.attachedDiskStrings.set(index, item);
    return (A) this;
  }
  
  public A setToConditions(int index,ChaosCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ChaosConditionBuilder builder = new ChaosConditionBuilder(item);
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
    if (!(attachedDiskStrings == null) && !(attachedDiskStrings.isEmpty())) {
        sb.append("attachedDiskStrings:");
        sb.append(attachedDiskStrings);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(experiment == null)) {
        sb.append("experiment:");
        sb.append(experiment);
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
  
  public A withAttachedDiskStrings(List<String> attachedDiskStrings) {
    if (attachedDiskStrings != null) {
        this.attachedDiskStrings = new ArrayList();
        for (String item : attachedDiskStrings) {
          this.addToAttachedDiskStrings(item);
        }
    } else {
      this.attachedDiskStrings = null;
    }
    return (A) this;
  }
  
  public A withAttachedDiskStrings(String... attachedDiskStrings) {
    if (this.attachedDiskStrings != null) {
        this.attachedDiskStrings.clear();
        _visitables.remove("attachedDiskStrings");
    }
    if (attachedDiskStrings != null) {
      for (String item : attachedDiskStrings) {
        this.addToAttachedDiskStrings(item);
      }
    }
    return (A) this;
  }
  
  public A withConditions(List<ChaosCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ChaosCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ChaosCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ChaosCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withExperiment(ExperimentStatus experiment) {
    this._visitables.remove("experiment");
    if (experiment != null) {
        this.experiment = new ExperimentStatusBuilder(experiment);
        this._visitables.get("experiment").add(this.experiment);
    } else {
        this.experiment = null;
        this._visitables.get("experiment").remove(this.experiment);
    }
    return (A) this;
  }
  
  public ExperimentNested<A> withNewExperiment() {
    return new ExperimentNested(null);
  }
  
  public ExperimentNested<A> withNewExperimentLike(ExperimentStatus item) {
    return new ExperimentNested(item);
  }
  public class ConditionsNested<N> extends ChaosConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ChaosConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,ChaosCondition item) {
      this.index = index;
      this.builder = new ChaosConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPChaosStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ExperimentNested<N> extends ExperimentStatusFluent<ExperimentNested<N>> implements Nested<N>{
  
    ExperimentStatusBuilder builder;
  
    ExperimentNested(ExperimentStatus item) {
      this.builder = new ExperimentStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPChaosStatusFluent.this.withExperiment(builder.build());
    }
    
    public N endExperiment() {
      return and();
    }
    
  }
}