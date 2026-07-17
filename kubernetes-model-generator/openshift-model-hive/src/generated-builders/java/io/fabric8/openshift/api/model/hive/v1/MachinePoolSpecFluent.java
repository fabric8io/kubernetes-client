package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.Taint;
import java.lang.Integer;
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
public class MachinePoolSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.MachinePoolSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MachinePoolAutoscalingBuilder autoscaling;
  private LocalObjectReferenceBuilder clusterDeploymentRef;
  private Map<String,String> labels;
  private Map<String,String> machineLabels;
  private String name;
  private MachinePoolPlatformBuilder platform;
  private Long replicas;
  private List<Taint> taints = new ArrayList<Taint>();

  public MachinePoolSpecFluent() {
  }
  
  public MachinePoolSpecFluent(MachinePoolSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTaints(Collection<Taint> items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
      this.taints.add(item);
    }
    return (A) this;
  }
  
  public A addNewTaint(String effect,String key,String timeAdded,String value) {
    return (A) this.addToTaints(new Taint(effect, key, timeAdded, value));
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
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToMachineLabels(Map<String,String> map) {
    if (this.machineLabels == null && map != null) {
      this.machineLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.machineLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMachineLabels(String key,String value) {
    if (this.machineLabels == null && key != null && value != null) {
      this.machineLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.machineLabels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTaints(Taint... items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
      this.taints.add(item);
    }
    return (A) this;
  }
  
  public A addToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    this.taints.add(index, item);
    return (A) this;
  }
  
  public MachinePoolAutoscaling buildAutoscaling() {
    return this.autoscaling != null ? this.autoscaling.build() : null;
  }
  
  public LocalObjectReference buildClusterDeploymentRef() {
    return this.clusterDeploymentRef != null ? this.clusterDeploymentRef.build() : null;
  }
  
  public MachinePoolPlatform buildPlatform() {
    return this.platform != null ? this.platform.build() : null;
  }
  
  protected void copyInstance(MachinePoolSpec instance) {
    instance = instance != null ? instance : new MachinePoolSpec();
    if (instance != null) {
        this.withAutoscaling(instance.getAutoscaling());
        this.withClusterDeploymentRef(instance.getClusterDeploymentRef());
        this.withLabels(instance.getLabels());
        this.withMachineLabels(instance.getMachineLabels());
        this.withName(instance.getName());
        this.withPlatform(instance.getPlatform());
        this.withReplicas(instance.getReplicas());
        this.withTaints(instance.getTaints());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AutoscalingNested<A> editAutoscaling() {
    return this.withNewAutoscalingLike(Optional.ofNullable(this.buildAutoscaling()).orElse(null));
  }
  
  public ClusterDeploymentRefNested<A> editClusterDeploymentRef() {
    return this.withNewClusterDeploymentRefLike(Optional.ofNullable(this.buildClusterDeploymentRef()).orElse(null));
  }
  
  public AutoscalingNested<A> editOrNewAutoscaling() {
    return this.withNewAutoscalingLike(Optional.ofNullable(this.buildAutoscaling()).orElse(new MachinePoolAutoscalingBuilder().build()));
  }
  
  public AutoscalingNested<A> editOrNewAutoscalingLike(MachinePoolAutoscaling item) {
    return this.withNewAutoscalingLike(Optional.ofNullable(this.buildAutoscaling()).orElse(item));
  }
  
  public ClusterDeploymentRefNested<A> editOrNewClusterDeploymentRef() {
    return this.withNewClusterDeploymentRefLike(Optional.ofNullable(this.buildClusterDeploymentRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ClusterDeploymentRefNested<A> editOrNewClusterDeploymentRefLike(LocalObjectReference item) {
    return this.withNewClusterDeploymentRefLike(Optional.ofNullable(this.buildClusterDeploymentRef()).orElse(item));
  }
  
  public PlatformNested<A> editOrNewPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(new MachinePoolPlatformBuilder().build()));
  }
  
  public PlatformNested<A> editOrNewPlatformLike(MachinePoolPlatform item) {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(item));
  }
  
  public PlatformNested<A> editPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(null));
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
    MachinePoolSpecFluent that = (MachinePoolSpecFluent) o;
    if (!(Objects.equals(autoscaling, that.autoscaling))) {
      return false;
    }
    if (!(Objects.equals(clusterDeploymentRef, that.clusterDeploymentRef))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(machineLabels, that.machineLabels))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(taints, that.taints))) {
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
  
  public Taint getFirstTaint() {
    return this.taints.get(0);
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public Taint getLastTaint() {
    return this.taints.get(taints.size() - 1);
  }
  
  public Map<String,String> getMachineLabels() {
    return this.machineLabels;
  }
  
  public Taint getMatchingTaint(Predicate<Taint> predicate) {
      for (Taint item : taints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Long getReplicas() {
    return this.replicas;
  }
  
  public Taint getTaint(int index) {
    return this.taints.get(index);
  }
  
  public List<Taint> getTaints() {
    return this.taints;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutoscaling() {
    return this.autoscaling != null;
  }
  
  public boolean hasClusterDeploymentRef() {
    return this.clusterDeploymentRef != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasMachineLabels() {
    return this.machineLabels != null;
  }
  
  public boolean hasMatchingTaint(Predicate<Taint> predicate) {
      for (Taint item : taints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasTaints() {
    return this.taints != null && !(this.taints.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(autoscaling, clusterDeploymentRef, labels, machineLabels, name, platform, replicas, taints, additionalProperties);
  }
  
  public A removeAllFromTaints(Collection<Taint> items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
      this.taints.remove(item);
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
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromMachineLabels(String key) {
    if (this.machineLabels == null) {
      return (A) this;
    }
    if (key != null && this.machineLabels != null) {
      this.machineLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMachineLabels(Map<String,String> map) {
    if (this.machineLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.machineLabels != null) {
          this.machineLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTaints(Taint... items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
      this.taints.remove(item);
    }
    return (A) this;
  }
  
  public A setToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    this.taints.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(autoscaling == null)) {
        sb.append("autoscaling:");
        sb.append(autoscaling);
        sb.append(",");
    }
    if (!(clusterDeploymentRef == null)) {
        sb.append("clusterDeploymentRef:");
        sb.append(clusterDeploymentRef);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(machineLabels == null) && !(machineLabels.isEmpty())) {
        sb.append("machineLabels:");
        sb.append(machineLabels);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(taints == null) && !(taints.isEmpty())) {
        sb.append("taints:");
        sb.append(taints);
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
  
  public A withAutoscaling(MachinePoolAutoscaling autoscaling) {
    this._visitables.remove("autoscaling");
    if (autoscaling != null) {
        this.autoscaling = new MachinePoolAutoscalingBuilder(autoscaling);
        this._visitables.get("autoscaling").add(this.autoscaling);
    } else {
        this.autoscaling = null;
        this._visitables.get("autoscaling").remove(this.autoscaling);
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
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public <K,V>A withMachineLabels(Map<String,String> machineLabels) {
    if (machineLabels == null) {
      this.machineLabels = null;
    } else {
      this.machineLabels = new LinkedHashMap(machineLabels);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public AutoscalingNested<A> withNewAutoscaling() {
    return new AutoscalingNested(null);
  }
  
  public A withNewAutoscaling(Integer maxReplicas,Integer minReplicas) {
    return (A) this.withAutoscaling(new MachinePoolAutoscaling(maxReplicas, minReplicas));
  }
  
  public AutoscalingNested<A> withNewAutoscalingLike(MachinePoolAutoscaling item) {
    return new AutoscalingNested(item);
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
  
  public PlatformNested<A> withNewPlatform() {
    return new PlatformNested(null);
  }
  
  public PlatformNested<A> withNewPlatformLike(MachinePoolPlatform item) {
    return new PlatformNested(item);
  }
  
  public A withPlatform(MachinePoolPlatform platform) {
    this._visitables.remove("platform");
    if (platform != null) {
        this.platform = new MachinePoolPlatformBuilder(platform);
        this._visitables.get("platform").add(this.platform);
    } else {
        this.platform = null;
        this._visitables.get("platform").remove(this.platform);
    }
    return (A) this;
  }
  
  public A withReplicas(Long replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withTaints(List<Taint> taints) {
    if (taints != null) {
        this.taints = new ArrayList();
        for (Taint item : taints) {
          this.addToTaints(item);
        }
    } else {
      this.taints = null;
    }
    return (A) this;
  }
  
  public A withTaints(Taint... taints) {
    if (this.taints != null) {
        this.taints.clear();
        _visitables.remove("taints");
    }
    if (taints != null) {
      for (Taint item : taints) {
        this.addToTaints(item);
      }
    }
    return (A) this;
  }
  public class AutoscalingNested<N> extends MachinePoolAutoscalingFluent<AutoscalingNested<N>> implements Nested<N>{
  
    MachinePoolAutoscalingBuilder builder;
  
    AutoscalingNested(MachinePoolAutoscaling item) {
      this.builder = new MachinePoolAutoscalingBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolSpecFluent.this.withAutoscaling(builder.build());
    }
    
    public N endAutoscaling() {
      return and();
    }
    
  }
  public class ClusterDeploymentRefNested<N> extends LocalObjectReferenceFluent<ClusterDeploymentRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ClusterDeploymentRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolSpecFluent.this.withClusterDeploymentRef(builder.build());
    }
    
    public N endClusterDeploymentRef() {
      return and();
    }
    
  }
  public class PlatformNested<N> extends MachinePoolPlatformFluent<PlatformNested<N>> implements Nested<N>{
  
    MachinePoolPlatformBuilder builder;
  
    PlatformNested(MachinePoolPlatform item) {
      this.builder = new MachinePoolPlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolSpecFluent.this.withPlatform(builder.build());
    }
    
    public N endPlatform() {
      return and();
    }
    
  }
}