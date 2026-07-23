package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.openshift.api.model.customresourcestatus.conditions.v1.Condition;
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
public class ClusterDeploymentCustomizationStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterDeploymentCustomizationStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder clusterDeploymentRef;
  private LocalObjectReferenceBuilder clusterPoolRef;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String lastAppliedConfiguration;

  public ClusterDeploymentCustomizationStatusFluent() {
  }
  
  public ClusterDeploymentCustomizationStatusFluent(ClusterDeploymentCustomizationStatus instance) {
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
  
  public LocalObjectReference buildClusterDeploymentRef() {
    return this.clusterDeploymentRef != null ? this.clusterDeploymentRef.build() : null;
  }
  
  public LocalObjectReference buildClusterPoolRef() {
    return this.clusterPoolRef != null ? this.clusterPoolRef.build() : null;
  }
  
  protected void copyInstance(ClusterDeploymentCustomizationStatus instance) {
    instance = instance != null ? instance : new ClusterDeploymentCustomizationStatus();
    if (instance != null) {
        this.withClusterDeploymentRef(instance.getClusterDeploymentRef());
        this.withClusterPoolRef(instance.getClusterPoolRef());
        this.withConditions(instance.getConditions());
        this.withLastAppliedConfiguration(instance.getLastAppliedConfiguration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterDeploymentRefNested<A> editClusterDeploymentRef() {
    return this.withNewClusterDeploymentRefLike(Optional.ofNullable(this.buildClusterDeploymentRef()).orElse(null));
  }
  
  public ClusterPoolRefNested<A> editClusterPoolRef() {
    return this.withNewClusterPoolRefLike(Optional.ofNullable(this.buildClusterPoolRef()).orElse(null));
  }
  
  public ClusterDeploymentRefNested<A> editOrNewClusterDeploymentRef() {
    return this.withNewClusterDeploymentRefLike(Optional.ofNullable(this.buildClusterDeploymentRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ClusterDeploymentRefNested<A> editOrNewClusterDeploymentRefLike(LocalObjectReference item) {
    return this.withNewClusterDeploymentRefLike(Optional.ofNullable(this.buildClusterDeploymentRef()).orElse(item));
  }
  
  public ClusterPoolRefNested<A> editOrNewClusterPoolRef() {
    return this.withNewClusterPoolRefLike(Optional.ofNullable(this.buildClusterPoolRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ClusterPoolRefNested<A> editOrNewClusterPoolRefLike(LocalObjectReference item) {
    return this.withNewClusterPoolRefLike(Optional.ofNullable(this.buildClusterPoolRef()).orElse(item));
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
    ClusterDeploymentCustomizationStatusFluent that = (ClusterDeploymentCustomizationStatusFluent) o;
    if (!(Objects.equals(clusterDeploymentRef, that.clusterDeploymentRef))) {
      return false;
    }
    if (!(Objects.equals(clusterPoolRef, that.clusterPoolRef))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(lastAppliedConfiguration, that.lastAppliedConfiguration))) {
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
  
  public String getLastAppliedConfiguration() {
    return this.lastAppliedConfiguration;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterDeploymentRef() {
    return this.clusterDeploymentRef != null;
  }
  
  public boolean hasClusterPoolRef() {
    return this.clusterPoolRef != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasLastAppliedConfiguration() {
    return this.lastAppliedConfiguration != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clusterDeploymentRef, clusterPoolRef, conditions, lastAppliedConfiguration, additionalProperties);
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
    if (!(clusterDeploymentRef == null)) {
        sb.append("clusterDeploymentRef:");
        sb.append(clusterDeploymentRef);
        sb.append(",");
    }
    if (!(clusterPoolRef == null)) {
        sb.append("clusterPoolRef:");
        sb.append(clusterPoolRef);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(lastAppliedConfiguration == null)) {
        sb.append("lastAppliedConfiguration:");
        sb.append(lastAppliedConfiguration);
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
  
  public A withClusterDeploymentRef(LocalObjectReference clusterDeploymentRef) {
    this._visitables.remove("clusterDeploymentRef");
    if (clusterDeploymentRef != null) {
        this.clusterDeploymentRef = new LocalObjectReferenceBuilder(clusterDeploymentRef);
        this._visitables.get("clusterDeploymentRef").add(this.clusterDeploymentRef);
    } else {
        this.clusterDeploymentRef = null;
        this._visitables.get("clusterDeploymentRef").remove(this.clusterDeploymentRef);
    }
    return (A) this;
  }
  
  public A withClusterPoolRef(LocalObjectReference clusterPoolRef) {
    this._visitables.remove("clusterPoolRef");
    if (clusterPoolRef != null) {
        this.clusterPoolRef = new LocalObjectReferenceBuilder(clusterPoolRef);
        this._visitables.get("clusterPoolRef").add(this.clusterPoolRef);
    } else {
        this.clusterPoolRef = null;
        this._visitables.get("clusterPoolRef").remove(this.clusterPoolRef);
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
  
  public A withLastAppliedConfiguration(String lastAppliedConfiguration) {
    this.lastAppliedConfiguration = lastAppliedConfiguration;
    return (A) this;
  }
  
  public ClusterDeploymentRefNested<A> withNewClusterDeploymentRef() {
    return new ClusterDeploymentRefNested(null);
  }
  
  public A withNewClusterDeploymentRef(String name) {
    return (A) this.withClusterDeploymentRef(new LocalObjectReference(name));
  }
  
  public ClusterDeploymentRefNested<A> withNewClusterDeploymentRefLike(LocalObjectReference item) {
    return new ClusterDeploymentRefNested(item);
  }
  
  public ClusterPoolRefNested<A> withNewClusterPoolRef() {
    return new ClusterPoolRefNested(null);
  }
  
  public A withNewClusterPoolRef(String name) {
    return (A) this.withClusterPoolRef(new LocalObjectReference(name));
  }
  
  public ClusterPoolRefNested<A> withNewClusterPoolRefLike(LocalObjectReference item) {
    return new ClusterPoolRefNested(item);
  }
  public class ClusterDeploymentRefNested<N> extends LocalObjectReferenceFluent<ClusterDeploymentRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ClusterDeploymentRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentCustomizationStatusFluent.this.withClusterDeploymentRef(builder.build());
    }
    
    public N endClusterDeploymentRef() {
      return and();
    }
    
  }
  public class ClusterPoolRefNested<N> extends LocalObjectReferenceFluent<ClusterPoolRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ClusterPoolRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentCustomizationStatusFluent.this.withClusterPoolRef(builder.build());
    }
    
    public N endClusterPoolRef() {
      return and();
    }
    
  }
}