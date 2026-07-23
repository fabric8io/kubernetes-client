package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
public class AffinityFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.AffinityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NodeGroupAffinityBuilder nodeGroupAffinity;
  private NodeGroupAntiAffinityBuilder nodeGroupAntiAffinity;

  public AffinityFluent() {
  }
  
  public AffinityFluent(Affinity instance) {
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
  
  public NodeGroupAffinity buildNodeGroupAffinity() {
    return this.nodeGroupAffinity != null ? this.nodeGroupAffinity.build() : null;
  }
  
  public NodeGroupAntiAffinity buildNodeGroupAntiAffinity() {
    return this.nodeGroupAntiAffinity != null ? this.nodeGroupAntiAffinity.build() : null;
  }
  
  protected void copyInstance(Affinity instance) {
    instance = instance != null ? instance : new Affinity();
    if (instance != null) {
        this.withNodeGroupAffinity(instance.getNodeGroupAffinity());
        this.withNodeGroupAntiAffinity(instance.getNodeGroupAntiAffinity());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NodeGroupAffinityNested<A> editNodeGroupAffinity() {
    return this.withNewNodeGroupAffinityLike(Optional.ofNullable(this.buildNodeGroupAffinity()).orElse(null));
  }
  
  public NodeGroupAntiAffinityNested<A> editNodeGroupAntiAffinity() {
    return this.withNewNodeGroupAntiAffinityLike(Optional.ofNullable(this.buildNodeGroupAntiAffinity()).orElse(null));
  }
  
  public NodeGroupAffinityNested<A> editOrNewNodeGroupAffinity() {
    return this.withNewNodeGroupAffinityLike(Optional.ofNullable(this.buildNodeGroupAffinity()).orElse(new NodeGroupAffinityBuilder().build()));
  }
  
  public NodeGroupAffinityNested<A> editOrNewNodeGroupAffinityLike(NodeGroupAffinity item) {
    return this.withNewNodeGroupAffinityLike(Optional.ofNullable(this.buildNodeGroupAffinity()).orElse(item));
  }
  
  public NodeGroupAntiAffinityNested<A> editOrNewNodeGroupAntiAffinity() {
    return this.withNewNodeGroupAntiAffinityLike(Optional.ofNullable(this.buildNodeGroupAntiAffinity()).orElse(new NodeGroupAntiAffinityBuilder().build()));
  }
  
  public NodeGroupAntiAffinityNested<A> editOrNewNodeGroupAntiAffinityLike(NodeGroupAntiAffinity item) {
    return this.withNewNodeGroupAntiAffinityLike(Optional.ofNullable(this.buildNodeGroupAntiAffinity()).orElse(item));
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
    AffinityFluent that = (AffinityFluent) o;
    if (!(Objects.equals(nodeGroupAffinity, that.nodeGroupAffinity))) {
      return false;
    }
    if (!(Objects.equals(nodeGroupAntiAffinity, that.nodeGroupAntiAffinity))) {
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
  
  public boolean hasNodeGroupAffinity() {
    return this.nodeGroupAffinity != null;
  }
  
  public boolean hasNodeGroupAntiAffinity() {
    return this.nodeGroupAntiAffinity != null;
  }
  
  public int hashCode() {
    return Objects.hash(nodeGroupAffinity, nodeGroupAntiAffinity, additionalProperties);
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
    if (!(nodeGroupAffinity == null)) {
        sb.append("nodeGroupAffinity:");
        sb.append(nodeGroupAffinity);
        sb.append(",");
    }
    if (!(nodeGroupAntiAffinity == null)) {
        sb.append("nodeGroupAntiAffinity:");
        sb.append(nodeGroupAntiAffinity);
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
  
  public NodeGroupAffinityNested<A> withNewNodeGroupAffinity() {
    return new NodeGroupAffinityNested(null);
  }
  
  public NodeGroupAffinityNested<A> withNewNodeGroupAffinityLike(NodeGroupAffinity item) {
    return new NodeGroupAffinityNested(item);
  }
  
  public NodeGroupAntiAffinityNested<A> withNewNodeGroupAntiAffinity() {
    return new NodeGroupAntiAffinityNested(null);
  }
  
  public NodeGroupAntiAffinityNested<A> withNewNodeGroupAntiAffinityLike(NodeGroupAntiAffinity item) {
    return new NodeGroupAntiAffinityNested(item);
  }
  
  public A withNodeGroupAffinity(NodeGroupAffinity nodeGroupAffinity) {
    this._visitables.remove("nodeGroupAffinity");
    if (nodeGroupAffinity != null) {
        this.nodeGroupAffinity = new NodeGroupAffinityBuilder(nodeGroupAffinity);
        this._visitables.get("nodeGroupAffinity").add(this.nodeGroupAffinity);
    } else {
        this.nodeGroupAffinity = null;
        this._visitables.get("nodeGroupAffinity").remove(this.nodeGroupAffinity);
    }
    return (A) this;
  }
  
  public A withNodeGroupAntiAffinity(NodeGroupAntiAffinity nodeGroupAntiAffinity) {
    this._visitables.remove("nodeGroupAntiAffinity");
    if (nodeGroupAntiAffinity != null) {
        this.nodeGroupAntiAffinity = new NodeGroupAntiAffinityBuilder(nodeGroupAntiAffinity);
        this._visitables.get("nodeGroupAntiAffinity").add(this.nodeGroupAntiAffinity);
    } else {
        this.nodeGroupAntiAffinity = null;
        this._visitables.get("nodeGroupAntiAffinity").remove(this.nodeGroupAntiAffinity);
    }
    return (A) this;
  }
  public class NodeGroupAffinityNested<N> extends NodeGroupAffinityFluent<NodeGroupAffinityNested<N>> implements Nested<N>{
  
    NodeGroupAffinityBuilder builder;
  
    NodeGroupAffinityNested(NodeGroupAffinity item) {
      this.builder = new NodeGroupAffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) AffinityFluent.this.withNodeGroupAffinity(builder.build());
    }
    
    public N endNodeGroupAffinity() {
      return and();
    }
    
  }
  public class NodeGroupAntiAffinityNested<N> extends NodeGroupAntiAffinityFluent<NodeGroupAntiAffinityNested<N>> implements Nested<N>{
  
    NodeGroupAntiAffinityBuilder builder;
  
    NodeGroupAntiAffinityNested(NodeGroupAntiAffinity item) {
      this.builder = new NodeGroupAntiAffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) AffinityFluent.this.withNodeGroupAntiAffinity(builder.build());
    }
    
    public N endNodeGroupAntiAffinity() {
      return and();
    }
    
  }
}