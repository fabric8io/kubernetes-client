package io.fabric8.kubernetes.api.model;

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
public class AffinityFluent<A extends io.fabric8.kubernetes.api.model.AffinityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NodeAffinityBuilder nodeAffinity;
  private PodAffinityBuilder podAffinity;
  private PodAntiAffinityBuilder podAntiAffinity;

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
  
  public NodeAffinity buildNodeAffinity() {
    return this.nodeAffinity != null ? this.nodeAffinity.build() : null;
  }
  
  public PodAffinity buildPodAffinity() {
    return this.podAffinity != null ? this.podAffinity.build() : null;
  }
  
  public PodAntiAffinity buildPodAntiAffinity() {
    return this.podAntiAffinity != null ? this.podAntiAffinity.build() : null;
  }
  
  protected void copyInstance(Affinity instance) {
    instance = instance != null ? instance : new Affinity();
    if (instance != null) {
        this.withNodeAffinity(instance.getNodeAffinity());
        this.withPodAffinity(instance.getPodAffinity());
        this.withPodAntiAffinity(instance.getPodAntiAffinity());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NodeAffinityNested<A> editNodeAffinity() {
    return this.withNewNodeAffinityLike(Optional.ofNullable(this.buildNodeAffinity()).orElse(null));
  }
  
  public NodeAffinityNested<A> editOrNewNodeAffinity() {
    return this.withNewNodeAffinityLike(Optional.ofNullable(this.buildNodeAffinity()).orElse(new NodeAffinityBuilder().build()));
  }
  
  public NodeAffinityNested<A> editOrNewNodeAffinityLike(NodeAffinity item) {
    return this.withNewNodeAffinityLike(Optional.ofNullable(this.buildNodeAffinity()).orElse(item));
  }
  
  public PodAffinityNested<A> editOrNewPodAffinity() {
    return this.withNewPodAffinityLike(Optional.ofNullable(this.buildPodAffinity()).orElse(new PodAffinityBuilder().build()));
  }
  
  public PodAffinityNested<A> editOrNewPodAffinityLike(PodAffinity item) {
    return this.withNewPodAffinityLike(Optional.ofNullable(this.buildPodAffinity()).orElse(item));
  }
  
  public PodAntiAffinityNested<A> editOrNewPodAntiAffinity() {
    return this.withNewPodAntiAffinityLike(Optional.ofNullable(this.buildPodAntiAffinity()).orElse(new PodAntiAffinityBuilder().build()));
  }
  
  public PodAntiAffinityNested<A> editOrNewPodAntiAffinityLike(PodAntiAffinity item) {
    return this.withNewPodAntiAffinityLike(Optional.ofNullable(this.buildPodAntiAffinity()).orElse(item));
  }
  
  public PodAffinityNested<A> editPodAffinity() {
    return this.withNewPodAffinityLike(Optional.ofNullable(this.buildPodAffinity()).orElse(null));
  }
  
  public PodAntiAffinityNested<A> editPodAntiAffinity() {
    return this.withNewPodAntiAffinityLike(Optional.ofNullable(this.buildPodAntiAffinity()).orElse(null));
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
    if (!(Objects.equals(nodeAffinity, that.nodeAffinity))) {
      return false;
    }
    if (!(Objects.equals(podAffinity, that.podAffinity))) {
      return false;
    }
    if (!(Objects.equals(podAntiAffinity, that.podAntiAffinity))) {
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
  
  public boolean hasNodeAffinity() {
    return this.nodeAffinity != null;
  }
  
  public boolean hasPodAffinity() {
    return this.podAffinity != null;
  }
  
  public boolean hasPodAntiAffinity() {
    return this.podAntiAffinity != null;
  }
  
  public int hashCode() {
    return Objects.hash(nodeAffinity, podAffinity, podAntiAffinity, additionalProperties);
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
    if (!(nodeAffinity == null)) {
        sb.append("nodeAffinity:");
        sb.append(nodeAffinity);
        sb.append(",");
    }
    if (!(podAffinity == null)) {
        sb.append("podAffinity:");
        sb.append(podAffinity);
        sb.append(",");
    }
    if (!(podAntiAffinity == null)) {
        sb.append("podAntiAffinity:");
        sb.append(podAntiAffinity);
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
  
  public NodeAffinityNested<A> withNewNodeAffinity() {
    return new NodeAffinityNested(null);
  }
  
  public NodeAffinityNested<A> withNewNodeAffinityLike(NodeAffinity item) {
    return new NodeAffinityNested(item);
  }
  
  public PodAffinityNested<A> withNewPodAffinity() {
    return new PodAffinityNested(null);
  }
  
  public PodAffinityNested<A> withNewPodAffinityLike(PodAffinity item) {
    return new PodAffinityNested(item);
  }
  
  public PodAntiAffinityNested<A> withNewPodAntiAffinity() {
    return new PodAntiAffinityNested(null);
  }
  
  public PodAntiAffinityNested<A> withNewPodAntiAffinityLike(PodAntiAffinity item) {
    return new PodAntiAffinityNested(item);
  }
  
  public A withNodeAffinity(NodeAffinity nodeAffinity) {
    this._visitables.remove("nodeAffinity");
    if (nodeAffinity != null) {
        this.nodeAffinity = new NodeAffinityBuilder(nodeAffinity);
        this._visitables.get("nodeAffinity").add(this.nodeAffinity);
    } else {
        this.nodeAffinity = null;
        this._visitables.get("nodeAffinity").remove(this.nodeAffinity);
    }
    return (A) this;
  }
  
  public A withPodAffinity(PodAffinity podAffinity) {
    this._visitables.remove("podAffinity");
    if (podAffinity != null) {
        this.podAffinity = new PodAffinityBuilder(podAffinity);
        this._visitables.get("podAffinity").add(this.podAffinity);
    } else {
        this.podAffinity = null;
        this._visitables.get("podAffinity").remove(this.podAffinity);
    }
    return (A) this;
  }
  
  public A withPodAntiAffinity(PodAntiAffinity podAntiAffinity) {
    this._visitables.remove("podAntiAffinity");
    if (podAntiAffinity != null) {
        this.podAntiAffinity = new PodAntiAffinityBuilder(podAntiAffinity);
        this._visitables.get("podAntiAffinity").add(this.podAntiAffinity);
    } else {
        this.podAntiAffinity = null;
        this._visitables.get("podAntiAffinity").remove(this.podAntiAffinity);
    }
    return (A) this;
  }
  public class NodeAffinityNested<N> extends NodeAffinityFluent<NodeAffinityNested<N>> implements Nested<N>{
  
    NodeAffinityBuilder builder;
  
    NodeAffinityNested(NodeAffinity item) {
      this.builder = new NodeAffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) AffinityFluent.this.withNodeAffinity(builder.build());
    }
    
    public N endNodeAffinity() {
      return and();
    }
    
  }
  public class PodAffinityNested<N> extends PodAffinityFluent<PodAffinityNested<N>> implements Nested<N>{
  
    PodAffinityBuilder builder;
  
    PodAffinityNested(PodAffinity item) {
      this.builder = new PodAffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) AffinityFluent.this.withPodAffinity(builder.build());
    }
    
    public N endPodAffinity() {
      return and();
    }
    
  }
  public class PodAntiAffinityNested<N> extends PodAntiAffinityFluent<PodAntiAffinityNested<N>> implements Nested<N>{
  
    PodAntiAffinityBuilder builder;
  
    PodAntiAffinityNested(PodAntiAffinity item) {
      this.builder = new PodAntiAffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) AffinityFluent.this.withPodAntiAffinity(builder.build());
    }
    
    public N endPodAntiAffinity() {
      return and();
    }
    
  }
}