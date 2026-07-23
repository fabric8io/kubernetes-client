package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class ClusterProvisionStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterProvisionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterProvisionConditionBuilder> conditions = new ArrayList<ClusterProvisionConditionBuilder>();
  private LocalObjectReferenceBuilder jobRef;

  public ClusterProvisionStatusFluent() {
  }
  
  public ClusterProvisionStatusFluent(ClusterProvisionStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<ClusterProvisionCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterProvisionCondition item : items) {
        ClusterProvisionConditionBuilder builder = new ClusterProvisionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(ClusterProvisionCondition item) {
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
  
  public A addToConditions(ClusterProvisionCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterProvisionCondition item : items) {
        ClusterProvisionConditionBuilder builder = new ClusterProvisionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ClusterProvisionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterProvisionConditionBuilder builder = new ClusterProvisionConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterProvisionCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<ClusterProvisionCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ClusterProvisionCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public LocalObjectReference buildJobRef() {
    return this.jobRef != null ? this.jobRef.build() : null;
  }
  
  public ClusterProvisionCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ClusterProvisionCondition buildMatchingCondition(Predicate<ClusterProvisionConditionBuilder> predicate) {
      for (ClusterProvisionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterProvisionStatus instance) {
    instance = instance != null ? instance : new ClusterProvisionStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withJobRef(instance.getJobRef());
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
  
  public JobRefNested<A> editJobRef() {
    return this.withNewJobRefLike(Optional.ofNullable(this.buildJobRef()).orElse(null));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ClusterProvisionConditionBuilder> predicate) {
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
  
  public JobRefNested<A> editOrNewJobRef() {
    return this.withNewJobRefLike(Optional.ofNullable(this.buildJobRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public JobRefNested<A> editOrNewJobRefLike(LocalObjectReference item) {
    return this.withNewJobRefLike(Optional.ofNullable(this.buildJobRef()).orElse(item));
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
    ClusterProvisionStatusFluent that = (ClusterProvisionStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(jobRef, that.jobRef))) {
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
  
  public boolean hasJobRef() {
    return this.jobRef != null;
  }
  
  public boolean hasMatchingCondition(Predicate<ClusterProvisionConditionBuilder> predicate) {
      for (ClusterProvisionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, jobRef, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<ClusterProvisionCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterProvisionCondition item : items) {
        ClusterProvisionConditionBuilder builder = new ClusterProvisionConditionBuilder(item);
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
  
  public A removeFromConditions(ClusterProvisionCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterProvisionCondition item : items) {
        ClusterProvisionConditionBuilder builder = new ClusterProvisionConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ClusterProvisionConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ClusterProvisionConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ClusterProvisionConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,ClusterProvisionCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,ClusterProvisionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterProvisionConditionBuilder builder = new ClusterProvisionConditionBuilder(item);
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
    if (!(jobRef == null)) {
        sb.append("jobRef:");
        sb.append(jobRef);
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
  
  public A withConditions(List<ClusterProvisionCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ClusterProvisionCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ClusterProvisionCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ClusterProvisionCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withJobRef(LocalObjectReference jobRef) {
    this._visitables.remove("jobRef");
    if (jobRef != null) {
        this.jobRef = new LocalObjectReferenceBuilder(jobRef);
        this._visitables.get("jobRef").add(this.jobRef);
    } else {
        this.jobRef = null;
        this._visitables.get("jobRef").remove(this.jobRef);
    }
    return (A) this;
  }
  
  public JobRefNested<A> withNewJobRef() {
    return new JobRefNested(null);
  }
  
  public A withNewJobRef(String name) {
    return (A) this.withJobRef(new LocalObjectReference(name));
  }
  
  public JobRefNested<A> withNewJobRefLike(LocalObjectReference item) {
    return new JobRefNested(item);
  }
  public class ConditionsNested<N> extends ClusterProvisionConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ClusterProvisionConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,ClusterProvisionCondition item) {
      this.index = index;
      this.builder = new ClusterProvisionConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterProvisionStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class JobRefNested<N> extends LocalObjectReferenceFluent<JobRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    JobRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterProvisionStatusFluent.this.withJobRef(builder.build());
    }
    
    public N endJobRef() {
      return and();
    }
    
  }
}