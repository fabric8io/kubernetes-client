package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class MachineConfigurationStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1.MachineConfigurationStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ManagedBootImagesBuilder managedBootImagesStatus;
  private NodeDisruptionPolicyStatusBuilder nodeDisruptionPolicyStatus;
  private Long observedGeneration;

  public MachineConfigurationStatusFluent() {
  }
  
  public MachineConfigurationStatusFluent(MachineConfigurationStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
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
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public ManagedBootImages buildManagedBootImagesStatus() {
    return this.managedBootImagesStatus != null ? this.managedBootImagesStatus.build() : null;
  }
  
  public NodeDisruptionPolicyStatus buildNodeDisruptionPolicyStatus() {
    return this.nodeDisruptionPolicyStatus != null ? this.nodeDisruptionPolicyStatus.build() : null;
  }
  
  protected void copyInstance(MachineConfigurationStatus instance) {
    instance = instance != null ? instance : new MachineConfigurationStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withManagedBootImagesStatus(instance.getManagedBootImagesStatus());
        this.withNodeDisruptionPolicyStatus(instance.getNodeDisruptionPolicyStatus());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ManagedBootImagesStatusNested<A> editManagedBootImagesStatus() {
    return this.withNewManagedBootImagesStatusLike(Optional.ofNullable(this.buildManagedBootImagesStatus()).orElse(null));
  }
  
  public NodeDisruptionPolicyStatusNested<A> editNodeDisruptionPolicyStatus() {
    return this.withNewNodeDisruptionPolicyStatusLike(Optional.ofNullable(this.buildNodeDisruptionPolicyStatus()).orElse(null));
  }
  
  public ManagedBootImagesStatusNested<A> editOrNewManagedBootImagesStatus() {
    return this.withNewManagedBootImagesStatusLike(Optional.ofNullable(this.buildManagedBootImagesStatus()).orElse(new ManagedBootImagesBuilder().build()));
  }
  
  public ManagedBootImagesStatusNested<A> editOrNewManagedBootImagesStatusLike(ManagedBootImages item) {
    return this.withNewManagedBootImagesStatusLike(Optional.ofNullable(this.buildManagedBootImagesStatus()).orElse(item));
  }
  
  public NodeDisruptionPolicyStatusNested<A> editOrNewNodeDisruptionPolicyStatus() {
    return this.withNewNodeDisruptionPolicyStatusLike(Optional.ofNullable(this.buildNodeDisruptionPolicyStatus()).orElse(new NodeDisruptionPolicyStatusBuilder().build()));
  }
  
  public NodeDisruptionPolicyStatusNested<A> editOrNewNodeDisruptionPolicyStatusLike(NodeDisruptionPolicyStatus item) {
    return this.withNewNodeDisruptionPolicyStatusLike(Optional.ofNullable(this.buildNodeDisruptionPolicyStatus()).orElse(item));
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
    MachineConfigurationStatusFluent that = (MachineConfigurationStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(managedBootImagesStatus, that.managedBootImagesStatus))) {
      return false;
    }
    if (!(Objects.equals(nodeDisruptionPolicyStatus, that.nodeDisruptionPolicyStatus))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
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
  
  public boolean hasManagedBootImagesStatus() {
    return this.managedBootImagesStatus != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeDisruptionPolicyStatus() {
    return this.nodeDisruptionPolicyStatus != null;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, managedBootImagesStatus, nodeDisruptionPolicyStatus, observedGeneration, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
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
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
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
    if (!(managedBootImagesStatus == null)) {
        sb.append("managedBootImagesStatus:");
        sb.append(managedBootImagesStatus);
        sb.append(",");
    }
    if (!(nodeDisruptionPolicyStatus == null)) {
        sb.append("nodeDisruptionPolicyStatus:");
        sb.append(nodeDisruptionPolicyStatus);
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
  
  public A withConditions(List<Condition> conditions) {
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
  
  public A withManagedBootImagesStatus(ManagedBootImages managedBootImagesStatus) {
    this._visitables.remove("managedBootImagesStatus");
    if (managedBootImagesStatus != null) {
        this.managedBootImagesStatus = new ManagedBootImagesBuilder(managedBootImagesStatus);
        this._visitables.get("managedBootImagesStatus").add(this.managedBootImagesStatus);
    } else {
        this.managedBootImagesStatus = null;
        this._visitables.get("managedBootImagesStatus").remove(this.managedBootImagesStatus);
    }
    return (A) this;
  }
  
  public ManagedBootImagesStatusNested<A> withNewManagedBootImagesStatus() {
    return new ManagedBootImagesStatusNested(null);
  }
  
  public ManagedBootImagesStatusNested<A> withNewManagedBootImagesStatusLike(ManagedBootImages item) {
    return new ManagedBootImagesStatusNested(item);
  }
  
  public NodeDisruptionPolicyStatusNested<A> withNewNodeDisruptionPolicyStatus() {
    return new NodeDisruptionPolicyStatusNested(null);
  }
  
  public NodeDisruptionPolicyStatusNested<A> withNewNodeDisruptionPolicyStatusLike(NodeDisruptionPolicyStatus item) {
    return new NodeDisruptionPolicyStatusNested(item);
  }
  
  public A withNodeDisruptionPolicyStatus(NodeDisruptionPolicyStatus nodeDisruptionPolicyStatus) {
    this._visitables.remove("nodeDisruptionPolicyStatus");
    if (nodeDisruptionPolicyStatus != null) {
        this.nodeDisruptionPolicyStatus = new NodeDisruptionPolicyStatusBuilder(nodeDisruptionPolicyStatus);
        this._visitables.get("nodeDisruptionPolicyStatus").add(this.nodeDisruptionPolicyStatus);
    } else {
        this.nodeDisruptionPolicyStatus = null;
        this._visitables.get("nodeDisruptionPolicyStatus").remove(this.nodeDisruptionPolicyStatus);
    }
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  public class ManagedBootImagesStatusNested<N> extends ManagedBootImagesFluent<ManagedBootImagesStatusNested<N>> implements Nested<N>{
  
    ManagedBootImagesBuilder builder;
  
    ManagedBootImagesStatusNested(ManagedBootImages item) {
      this.builder = new ManagedBootImagesBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigurationStatusFluent.this.withManagedBootImagesStatus(builder.build());
    }
    
    public N endManagedBootImagesStatus() {
      return and();
    }
    
  }
  public class NodeDisruptionPolicyStatusNested<N> extends NodeDisruptionPolicyStatusFluent<NodeDisruptionPolicyStatusNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicyStatusBuilder builder;
  
    NodeDisruptionPolicyStatusNested(NodeDisruptionPolicyStatus item) {
      this.builder = new NodeDisruptionPolicyStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigurationStatusFluent.this.withNodeDisruptionPolicyStatus(builder.build());
    }
    
    public N endNodeDisruptionPolicyStatus() {
      return and();
    }
    
  }
}