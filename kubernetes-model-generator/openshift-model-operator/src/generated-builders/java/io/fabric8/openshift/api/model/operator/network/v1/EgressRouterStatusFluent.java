package io.fabric8.openshift.api.model.operator.network.v1;

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
public class EgressRouterStatusFluent<A extends io.fabric8.openshift.api.model.operator.network.v1.EgressRouterStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EgressRouterStatusConditionBuilder> conditions = new ArrayList<EgressRouterStatusConditionBuilder>();

  public EgressRouterStatusFluent() {
  }
  
  public EgressRouterStatusFluent(EgressRouterStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<EgressRouterStatusCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (EgressRouterStatusCondition item : items) {
        EgressRouterStatusConditionBuilder builder = new EgressRouterStatusConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new EgressRouterStatusCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(EgressRouterStatusCondition item) {
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
  
  public A addToConditions(EgressRouterStatusCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (EgressRouterStatusCondition item : items) {
        EgressRouterStatusConditionBuilder builder = new EgressRouterStatusConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,EgressRouterStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    EgressRouterStatusConditionBuilder builder = new EgressRouterStatusConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public EgressRouterStatusCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<EgressRouterStatusCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public EgressRouterStatusCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public EgressRouterStatusCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public EgressRouterStatusCondition buildMatchingCondition(Predicate<EgressRouterStatusConditionBuilder> predicate) {
      for (EgressRouterStatusConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(EgressRouterStatus instance) {
    instance = instance != null ? instance : new EgressRouterStatus();
    if (instance != null) {
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<EgressRouterStatusConditionBuilder> predicate) {
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
    EgressRouterStatusFluent that = (EgressRouterStatusFluent) o;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<EgressRouterStatusConditionBuilder> predicate) {
      for (EgressRouterStatusConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<EgressRouterStatusCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (EgressRouterStatusCondition item : items) {
        EgressRouterStatusConditionBuilder builder = new EgressRouterStatusConditionBuilder(item);
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
  
  public A removeFromConditions(EgressRouterStatusCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (EgressRouterStatusCondition item : items) {
        EgressRouterStatusConditionBuilder builder = new EgressRouterStatusConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<EgressRouterStatusConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<EgressRouterStatusConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        EgressRouterStatusConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,EgressRouterStatusCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,EgressRouterStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    EgressRouterStatusConditionBuilder builder = new EgressRouterStatusConditionBuilder(item);
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
  
  public A withConditions(List<EgressRouterStatusCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (EgressRouterStatusCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(EgressRouterStatusCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (EgressRouterStatusCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends EgressRouterStatusConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    EgressRouterStatusConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,EgressRouterStatusCondition item) {
      this.index = index;
      this.builder = new EgressRouterStatusConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressRouterStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}