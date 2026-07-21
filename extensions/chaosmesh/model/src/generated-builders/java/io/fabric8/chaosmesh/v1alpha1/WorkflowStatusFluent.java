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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class WorkflowStatusFluent<A extends io.fabric8.chaosmesh.v1alpha1.WorkflowStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<WorkflowConditionBuilder> conditions = new ArrayList<WorkflowConditionBuilder>();
  private String endTime;
  private String entryNode;
  private String startTime;

  public WorkflowStatusFluent() {
  }
  
  public WorkflowStatusFluent(WorkflowStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<WorkflowCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (WorkflowCondition item : items) {
        WorkflowConditionBuilder builder = new WorkflowConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String reason,String startTime,String status,String type) {
    return (A) this.addToConditions(new WorkflowCondition(reason, startTime, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(WorkflowCondition item) {
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
  
  public A addToConditions(WorkflowCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (WorkflowCondition item : items) {
        WorkflowConditionBuilder builder = new WorkflowConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,WorkflowCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    WorkflowConditionBuilder builder = new WorkflowConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public WorkflowCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<WorkflowCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public WorkflowCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public WorkflowCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public WorkflowCondition buildMatchingCondition(Predicate<WorkflowConditionBuilder> predicate) {
      for (WorkflowConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(WorkflowStatus instance) {
    instance = instance != null ? instance : new WorkflowStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withEndTime(instance.getEndTime());
        this.withEntryNode(instance.getEntryNode());
        this.withStartTime(instance.getStartTime());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<WorkflowConditionBuilder> predicate) {
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
    WorkflowStatusFluent that = (WorkflowStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(endTime, that.endTime))) {
      return false;
    }
    if (!(Objects.equals(entryNode, that.entryNode))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
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
  
  public String getEndTime() {
    return this.endTime;
  }
  
  public String getEntryNode() {
    return this.entryNode;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasEndTime() {
    return this.endTime != null;
  }
  
  public boolean hasEntryNode() {
    return this.entryNode != null;
  }
  
  public boolean hasMatchingCondition(Predicate<WorkflowConditionBuilder> predicate) {
      for (WorkflowConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, endTime, entryNode, startTime, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<WorkflowCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (WorkflowCondition item : items) {
        WorkflowConditionBuilder builder = new WorkflowConditionBuilder(item);
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
  
  public A removeFromConditions(WorkflowCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (WorkflowCondition item : items) {
        WorkflowConditionBuilder builder = new WorkflowConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<WorkflowConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<WorkflowConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        WorkflowConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,WorkflowCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,WorkflowCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    WorkflowConditionBuilder builder = new WorkflowConditionBuilder(item);
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
    if (!(endTime == null)) {
        sb.append("endTime:");
        sb.append(endTime);
        sb.append(",");
    }
    if (!(entryNode == null)) {
        sb.append("entryNode:");
        sb.append(entryNode);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
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
  
  public A withConditions(List<WorkflowCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (WorkflowCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(WorkflowCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (WorkflowCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withEndTime(String endTime) {
    this.endTime = endTime;
    return (A) this;
  }
  
  public A withEntryNode(String entryNode) {
    this.entryNode = entryNode;
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  public class ConditionsNested<N> extends WorkflowConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    WorkflowConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,WorkflowCondition item) {
      this.index = index;
      this.builder = new WorkflowConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkflowStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}