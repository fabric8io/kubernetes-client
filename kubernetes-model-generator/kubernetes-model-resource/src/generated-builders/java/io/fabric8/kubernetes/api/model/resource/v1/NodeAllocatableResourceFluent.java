package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NodeAllocatableResourceFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.NodeAllocatableResourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NodeAllocatableMappingBuilder mapping;
  private NodeAllocatableOverheadBuilder overhead;

  public NodeAllocatableResourceFluent() {
  }
  
  public NodeAllocatableResourceFluent(NodeAllocatableResource instance) {
    this.copyInstance(instance);
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
  
  public NodeAllocatableMapping buildMapping() {
    return this.mapping != null ? this.mapping.build() : null;
  }
  
  public NodeAllocatableOverhead buildOverhead() {
    return this.overhead != null ? this.overhead.build() : null;
  }
  
  protected void copyInstance(NodeAllocatableResource instance) {
    instance = instance != null ? instance : new NodeAllocatableResource();
    if (instance != null) {
        this.withMapping(instance.getMapping());
        this.withOverhead(instance.getOverhead());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MappingNested<A> editMapping() {
    return this.withNewMappingLike(Optional.ofNullable(this.buildMapping()).orElse(null));
  }
  
  public MappingNested<A> editOrNewMapping() {
    return this.withNewMappingLike(Optional.ofNullable(this.buildMapping()).orElse(new NodeAllocatableMappingBuilder().build()));
  }
  
  public MappingNested<A> editOrNewMappingLike(NodeAllocatableMapping item) {
    return this.withNewMappingLike(Optional.ofNullable(this.buildMapping()).orElse(item));
  }
  
  public OverheadNested<A> editOrNewOverhead() {
    return this.withNewOverheadLike(Optional.ofNullable(this.buildOverhead()).orElse(new NodeAllocatableOverheadBuilder().build()));
  }
  
  public OverheadNested<A> editOrNewOverheadLike(NodeAllocatableOverhead item) {
    return this.withNewOverheadLike(Optional.ofNullable(this.buildOverhead()).orElse(item));
  }
  
  public OverheadNested<A> editOverhead() {
    return this.withNewOverheadLike(Optional.ofNullable(this.buildOverhead()).orElse(null));
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
    NodeAllocatableResourceFluent that = (NodeAllocatableResourceFluent) o;
    if (!(Objects.equals(mapping, that.mapping))) {
      return false;
    }
    if (!(Objects.equals(overhead, that.overhead))) {
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
  
  public boolean hasMapping() {
    return this.mapping != null;
  }
  
  public boolean hasOverhead() {
    return this.overhead != null;
  }
  
  public int hashCode() {
    return Objects.hash(mapping, overhead, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(mapping == null)) {
        sb.append("mapping:");
        sb.append(mapping);
        sb.append(",");
    }
    if (!(overhead == null)) {
        sb.append("overhead:");
        sb.append(overhead);
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
  
  public A withMapping(NodeAllocatableMapping mapping) {
    this._visitables.remove("mapping");
    if (mapping != null) {
        this.mapping = new NodeAllocatableMappingBuilder(mapping);
        this._visitables.get("mapping").add(this.mapping);
    } else {
        this.mapping = null;
        this._visitables.get("mapping").remove(this.mapping);
    }
    return (A) this;
  }
  
  public MappingNested<A> withNewMapping() {
    return new MappingNested(null);
  }
  
  public MappingNested<A> withNewMappingLike(NodeAllocatableMapping item) {
    return new MappingNested(item);
  }
  
  public OverheadNested<A> withNewOverhead() {
    return new OverheadNested(null);
  }
  
  public OverheadNested<A> withNewOverheadLike(NodeAllocatableOverhead item) {
    return new OverheadNested(item);
  }
  
  public A withOverhead(NodeAllocatableOverhead overhead) {
    this._visitables.remove("overhead");
    if (overhead != null) {
        this.overhead = new NodeAllocatableOverheadBuilder(overhead);
        this._visitables.get("overhead").add(this.overhead);
    } else {
        this.overhead = null;
        this._visitables.get("overhead").remove(this.overhead);
    }
    return (A) this;
  }
  public class MappingNested<N> extends NodeAllocatableMappingFluent<MappingNested<N>> implements Nested<N>{
  
    NodeAllocatableMappingBuilder builder;
  
    MappingNested(NodeAllocatableMapping item) {
      this.builder = new NodeAllocatableMappingBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeAllocatableResourceFluent.this.withMapping(builder.build());
    }
    
    public N endMapping() {
      return and();
    }
    
  }
  public class OverheadNested<N> extends NodeAllocatableOverheadFluent<OverheadNested<N>> implements Nested<N>{
  
    NodeAllocatableOverheadBuilder builder;
  
    OverheadNested(NodeAllocatableOverhead item) {
      this.builder = new NodeAllocatableOverheadBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeAllocatableResourceFluent.this.withOverhead(builder.build());
    }
    
    public N endOverhead() {
      return and();
    }
    
  }
}