package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
public class PodGroupStatusFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.PodGroupStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PodGroupConditionBuilder> conditions = new ArrayList<PodGroupConditionBuilder>();
  private Integer failed;
  private String phase;
  private Integer running;
  private Integer succeeded;

  public PodGroupStatusFluent() {
  }
  
  public PodGroupStatusFluent(PodGroupStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<PodGroupCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (PodGroupCondition item : items) {
        PodGroupConditionBuilder builder = new PodGroupConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(PodGroupCondition item) {
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
  
  public A addToConditions(PodGroupCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (PodGroupCondition item : items) {
        PodGroupConditionBuilder builder = new PodGroupConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,PodGroupCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    PodGroupConditionBuilder builder = new PodGroupConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public PodGroupCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<PodGroupCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public PodGroupCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public PodGroupCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public PodGroupCondition buildMatchingCondition(Predicate<PodGroupConditionBuilder> predicate) {
      for (PodGroupConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PodGroupStatus instance) {
    instance = instance != null ? instance : new PodGroupStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withFailed(instance.getFailed());
        this.withPhase(instance.getPhase());
        this.withRunning(instance.getRunning());
        this.withSucceeded(instance.getSucceeded());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<PodGroupConditionBuilder> predicate) {
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
    PodGroupStatusFluent that = (PodGroupStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(failed, that.failed))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(running, that.running))) {
      return false;
    }
    if (!(Objects.equals(succeeded, that.succeeded))) {
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
  
  public Integer getFailed() {
    return this.failed;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public Integer getRunning() {
    return this.running;
  }
  
  public Integer getSucceeded() {
    return this.succeeded;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFailed() {
    return this.failed != null;
  }
  
  public boolean hasMatchingCondition(Predicate<PodGroupConditionBuilder> predicate) {
      for (PodGroupConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasRunning() {
    return this.running != null;
  }
  
  public boolean hasSucceeded() {
    return this.succeeded != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, failed, phase, running, succeeded, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<PodGroupCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (PodGroupCondition item : items) {
        PodGroupConditionBuilder builder = new PodGroupConditionBuilder(item);
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
  
  public A removeFromConditions(PodGroupCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (PodGroupCondition item : items) {
        PodGroupConditionBuilder builder = new PodGroupConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<PodGroupConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<PodGroupConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        PodGroupConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,PodGroupCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,PodGroupCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    PodGroupConditionBuilder builder = new PodGroupConditionBuilder(item);
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
    if (!(failed == null)) {
        sb.append("failed:");
        sb.append(failed);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(running == null)) {
        sb.append("running:");
        sb.append(running);
        sb.append(",");
    }
    if (!(succeeded == null)) {
        sb.append("succeeded:");
        sb.append(succeeded);
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
  
  public A withConditions(List<PodGroupCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (PodGroupCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(PodGroupCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (PodGroupCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withFailed(Integer failed) {
    this.failed = failed;
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withRunning(Integer running) {
    this.running = running;
    return (A) this;
  }
  
  public A withSucceeded(Integer succeeded) {
    this.succeeded = succeeded;
    return (A) this;
  }
  public class ConditionsNested<N> extends PodGroupConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    PodGroupConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,PodGroupCondition item) {
      this.index = index;
      this.builder = new PodGroupConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}