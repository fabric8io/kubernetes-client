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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class IOChaosStatusFluent<A extends io.fabric8.chaosmesh.v1alpha1.IOChaosStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ChaosConditionBuilder> conditions = new ArrayList<ChaosConditionBuilder>();
  private ExperimentStatusBuilder experiment;
  private Map<String,Long> instances;

  public IOChaosStatusFluent() {
  }
  
  public IOChaosStatusFluent(IOChaosStatus instance) {
    this.copyInstance(instance);
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
  
  public A addToInstances(Map<String,Long> map) {
    if (this.instances == null && map != null) {
      this.instances = new LinkedHashMap();
    }
    if (map != null) {
      this.instances.putAll(map);
    }
    return (A) this;
  }
  
  public A addToInstances(String key,Long value) {
    if (this.instances == null && key != null && value != null) {
      this.instances = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.instances.put(key, value);
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
  
  protected void copyInstance(IOChaosStatus instance) {
    instance = instance != null ? instance : new IOChaosStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withExperiment(instance.getExperiment());
        this.withInstances(instance.getInstances());
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
    IOChaosStatusFluent that = (IOChaosStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(experiment, that.experiment))) {
      return false;
    }
    if (!(Objects.equals(instances, that.instances))) {
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
  
  public Map<String,Long> getInstances() {
    return this.instances;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasExperiment() {
    return this.experiment != null;
  }
  
  public boolean hasInstances() {
    return this.instances != null;
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
    return Objects.hash(conditions, experiment, instances, additionalProperties);
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
  
  public A removeFromInstances(String key) {
    if (this.instances == null) {
      return (A) this;
    }
    if (key != null && this.instances != null) {
      this.instances.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromInstances(Map<String,Long> map) {
    if (this.instances == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.instances != null) {
          this.instances.remove(key);
        }
      }
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
    if (!(instances == null) && !(instances.isEmpty())) {
        sb.append("instances:");
        sb.append(instances);
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
  
  public <K,V>A withInstances(Map<String,Long> instances) {
    if (instances == null) {
      this.instances = null;
    } else {
      this.instances = new LinkedHashMap(instances);
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
      return (N) IOChaosStatusFluent.this.setToConditions(index, builder.build());
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
      return (N) IOChaosStatusFluent.this.withExperiment(builder.build());
    }
    
    public N endExperiment() {
      return and();
    }
    
  }
}