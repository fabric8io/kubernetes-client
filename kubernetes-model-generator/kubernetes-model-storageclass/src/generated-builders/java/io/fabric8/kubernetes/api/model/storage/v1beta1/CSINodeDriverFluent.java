package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class CSINodeDriverFluent<A extends io.fabric8.kubernetes.api.model.storage.v1beta1.CSINodeDriverFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VolumeNodeResourcesBuilder allocatable;
  private String name;
  private String nodeID;
  private List<String> topologyKeys = new ArrayList<String>();

  public CSINodeDriverFluent() {
  }
  
  public CSINodeDriverFluent(CSINodeDriver instance) {
    this.copyInstance(instance);
  }

  public A addAllToTopologyKeys(Collection<String> items) {
    if (this.topologyKeys == null) {
      this.topologyKeys = new ArrayList();
    }
    for (String item : items) {
      this.topologyKeys.add(item);
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
  
  public A addToTopologyKeys(String... items) {
    if (this.topologyKeys == null) {
      this.topologyKeys = new ArrayList();
    }
    for (String item : items) {
      this.topologyKeys.add(item);
    }
    return (A) this;
  }
  
  public A addToTopologyKeys(int index,String item) {
    if (this.topologyKeys == null) {
      this.topologyKeys = new ArrayList();
    }
    this.topologyKeys.add(index, item);
    return (A) this;
  }
  
  public VolumeNodeResources buildAllocatable() {
    return this.allocatable != null ? this.allocatable.build() : null;
  }
  
  protected void copyInstance(CSINodeDriver instance) {
    instance = instance != null ? instance : new CSINodeDriver();
    if (instance != null) {
        this.withAllocatable(instance.getAllocatable());
        this.withName(instance.getName());
        this.withNodeID(instance.getNodeID());
        this.withTopologyKeys(instance.getTopologyKeys());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllocatableNested<A> editAllocatable() {
    return this.withNewAllocatableLike(Optional.ofNullable(this.buildAllocatable()).orElse(null));
  }
  
  public AllocatableNested<A> editOrNewAllocatable() {
    return this.withNewAllocatableLike(Optional.ofNullable(this.buildAllocatable()).orElse(new VolumeNodeResourcesBuilder().build()));
  }
  
  public AllocatableNested<A> editOrNewAllocatableLike(VolumeNodeResources item) {
    return this.withNewAllocatableLike(Optional.ofNullable(this.buildAllocatable()).orElse(item));
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
    CSINodeDriverFluent that = (CSINodeDriverFluent) o;
    if (!(Objects.equals(allocatable, that.allocatable))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(nodeID, that.nodeID))) {
      return false;
    }
    if (!(Objects.equals(topologyKeys, that.topologyKeys))) {
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
  
  public String getFirstTopologyKey() {
    return this.topologyKeys.get(0);
  }
  
  public String getLastTopologyKey() {
    return this.topologyKeys.get(topologyKeys.size() - 1);
  }
  
  public String getMatchingTopologyKey(Predicate<String> predicate) {
      for (String item : topologyKeys) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNodeID() {
    return this.nodeID;
  }
  
  public String getTopologyKey(int index) {
    return this.topologyKeys.get(index);
  }
  
  public List<String> getTopologyKeys() {
    return this.topologyKeys;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocatable() {
    return this.allocatable != null;
  }
  
  public boolean hasMatchingTopologyKey(Predicate<String> predicate) {
      for (String item : topologyKeys) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNodeID() {
    return this.nodeID != null;
  }
  
  public boolean hasTopologyKeys() {
    return this.topologyKeys != null && !(this.topologyKeys.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allocatable, name, nodeID, topologyKeys, additionalProperties);
  }
  
  public A removeAllFromTopologyKeys(Collection<String> items) {
    if (this.topologyKeys == null) {
      return (A) this;
    }
    for (String item : items) {
      this.topologyKeys.remove(item);
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
  
  public A removeFromTopologyKeys(String... items) {
    if (this.topologyKeys == null) {
      return (A) this;
    }
    for (String item : items) {
      this.topologyKeys.remove(item);
    }
    return (A) this;
  }
  
  public A setToTopologyKeys(int index,String item) {
    if (this.topologyKeys == null) {
      this.topologyKeys = new ArrayList();
    }
    this.topologyKeys.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allocatable == null)) {
        sb.append("allocatable:");
        sb.append(allocatable);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(nodeID == null)) {
        sb.append("nodeID:");
        sb.append(nodeID);
        sb.append(",");
    }
    if (!(topologyKeys == null) && !(topologyKeys.isEmpty())) {
        sb.append("topologyKeys:");
        sb.append(topologyKeys);
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
  
  public A withAllocatable(VolumeNodeResources allocatable) {
    this._visitables.remove("allocatable");
    if (allocatable != null) {
        this.allocatable = new VolumeNodeResourcesBuilder(allocatable);
        this._visitables.get("allocatable").add(this.allocatable);
    } else {
        this.allocatable = null;
        this._visitables.get("allocatable").remove(this.allocatable);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public AllocatableNested<A> withNewAllocatable() {
    return new AllocatableNested(null);
  }
  
  public A withNewAllocatable(Integer count) {
    return (A) this.withAllocatable(new VolumeNodeResources(count));
  }
  
  public AllocatableNested<A> withNewAllocatableLike(VolumeNodeResources item) {
    return new AllocatableNested(item);
  }
  
  public A withNodeID(String nodeID) {
    this.nodeID = nodeID;
    return (A) this;
  }
  
  public A withTopologyKeys(List<String> topologyKeys) {
    if (topologyKeys != null) {
        this.topologyKeys = new ArrayList();
        for (String item : topologyKeys) {
          this.addToTopologyKeys(item);
        }
    } else {
      this.topologyKeys = null;
    }
    return (A) this;
  }
  
  public A withTopologyKeys(String... topologyKeys) {
    if (this.topologyKeys != null) {
        this.topologyKeys.clear();
        _visitables.remove("topologyKeys");
    }
    if (topologyKeys != null) {
      for (String item : topologyKeys) {
        this.addToTopologyKeys(item);
      }
    }
    return (A) this;
  }
  public class AllocatableNested<N> extends VolumeNodeResourcesFluent<AllocatableNested<N>> implements Nested<N>{
  
    VolumeNodeResourcesBuilder builder;
  
    AllocatableNested(VolumeNodeResources item) {
      this.builder = new VolumeNodeResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) CSINodeDriverFluent.this.withAllocatable(builder.build());
    }
    
    public N endAllocatable() {
      return and();
    }
    
  }
}