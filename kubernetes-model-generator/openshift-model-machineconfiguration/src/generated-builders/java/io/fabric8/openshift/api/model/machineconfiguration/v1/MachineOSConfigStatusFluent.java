package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class MachineOSConfigStatusFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineOSConfigStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String currentImagePullSpec;
  private ObjectReferenceBuilder machineOSBuild;
  private Long observedGeneration;

  public MachineOSConfigStatusFluent() {
  }
  
  public MachineOSConfigStatusFluent(MachineOSConfigStatus instance) {
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
  
  public ObjectReference buildMachineOSBuild() {
    return this.machineOSBuild != null ? this.machineOSBuild.build() : null;
  }
  
  protected void copyInstance(MachineOSConfigStatus instance) {
    instance = instance != null ? instance : new MachineOSConfigStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withCurrentImagePullSpec(instance.getCurrentImagePullSpec());
        this.withMachineOSBuild(instance.getMachineOSBuild());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MachineOSBuildNested<A> editMachineOSBuild() {
    return this.withNewMachineOSBuildLike(Optional.ofNullable(this.buildMachineOSBuild()).orElse(null));
  }
  
  public MachineOSBuildNested<A> editOrNewMachineOSBuild() {
    return this.withNewMachineOSBuildLike(Optional.ofNullable(this.buildMachineOSBuild()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public MachineOSBuildNested<A> editOrNewMachineOSBuildLike(ObjectReference item) {
    return this.withNewMachineOSBuildLike(Optional.ofNullable(this.buildMachineOSBuild()).orElse(item));
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
    MachineOSConfigStatusFluent that = (MachineOSConfigStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentImagePullSpec, that.currentImagePullSpec))) {
      return false;
    }
    if (!(Objects.equals(machineOSBuild, that.machineOSBuild))) {
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
  
  public String getCurrentImagePullSpec() {
    return this.currentImagePullSpec;
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
  
  public boolean hasCurrentImagePullSpec() {
    return this.currentImagePullSpec != null;
  }
  
  public boolean hasMachineOSBuild() {
    return this.machineOSBuild != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, currentImagePullSpec, machineOSBuild, observedGeneration, additionalProperties);
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
    if (!(currentImagePullSpec == null)) {
        sb.append("currentImagePullSpec:");
        sb.append(currentImagePullSpec);
        sb.append(",");
    }
    if (!(machineOSBuild == null)) {
        sb.append("machineOSBuild:");
        sb.append(machineOSBuild);
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
  
  public A withCurrentImagePullSpec(String currentImagePullSpec) {
    this.currentImagePullSpec = currentImagePullSpec;
    return (A) this;
  }
  
  public A withMachineOSBuild(ObjectReference machineOSBuild) {
    this._visitables.remove("machineOSBuild");
    if (machineOSBuild != null) {
        this.machineOSBuild = new ObjectReferenceBuilder(machineOSBuild);
        this._visitables.get("machineOSBuild").add(this.machineOSBuild);
    } else {
        this.machineOSBuild = null;
        this._visitables.get("machineOSBuild").remove(this.machineOSBuild);
    }
    return (A) this;
  }
  
  public MachineOSBuildNested<A> withNewMachineOSBuild() {
    return new MachineOSBuildNested(null);
  }
  
  public A withNewMachineOSBuild(String group,String name,String namespace,String resource) {
    return (A) this.withMachineOSBuild(new ObjectReference(group, name, namespace, resource));
  }
  
  public MachineOSBuildNested<A> withNewMachineOSBuildLike(ObjectReference item) {
    return new MachineOSBuildNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  public class MachineOSBuildNested<N> extends ObjectReferenceFluent<MachineOSBuildNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    MachineOSBuildNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSConfigStatusFluent.this.withMachineOSBuild(builder.build());
    }
    
    public N endMachineOSBuild() {
      return and();
    }
    
  }
}