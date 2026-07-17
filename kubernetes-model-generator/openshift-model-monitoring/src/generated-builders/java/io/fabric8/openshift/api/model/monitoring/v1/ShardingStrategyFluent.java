package io.fabric8.openshift.api.model.monitoring.v1;

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
public class ShardingStrategyFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ShardingStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mode;
  private TopologyShardingStrategyBuilder topology;

  public ShardingStrategyFluent() {
  }
  
  public ShardingStrategyFluent(ShardingStrategy instance) {
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
  
  public TopologyShardingStrategy buildTopology() {
    return this.topology != null ? this.topology.build() : null;
  }
  
  protected void copyInstance(ShardingStrategy instance) {
    instance = instance != null ? instance : new ShardingStrategy();
    if (instance != null) {
        this.withMode(instance.getMode());
        this.withTopology(instance.getTopology());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TopologyNested<A> editOrNewTopology() {
    return this.withNewTopologyLike(Optional.ofNullable(this.buildTopology()).orElse(new TopologyShardingStrategyBuilder().build()));
  }
  
  public TopologyNested<A> editOrNewTopologyLike(TopologyShardingStrategy item) {
    return this.withNewTopologyLike(Optional.ofNullable(this.buildTopology()).orElse(item));
  }
  
  public TopologyNested<A> editTopology() {
    return this.withNewTopologyLike(Optional.ofNullable(this.buildTopology()).orElse(null));
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
    ShardingStrategyFluent that = (ShardingStrategyFluent) o;
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(topology, that.topology))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasTopology() {
    return this.topology != null;
  }
  
  public int hashCode() {
    return Objects.hash(mode, topology, additionalProperties);
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
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(topology == null)) {
        sb.append("topology:");
        sb.append(topology);
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
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public TopologyNested<A> withNewTopology() {
    return new TopologyNested(null);
  }
  
  public TopologyNested<A> withNewTopologyLike(TopologyShardingStrategy item) {
    return new TopologyNested(item);
  }
  
  public A withTopology(TopologyShardingStrategy topology) {
    this._visitables.remove("topology");
    if (topology != null) {
        this.topology = new TopologyShardingStrategyBuilder(topology);
        this._visitables.get("topology").add(this.topology);
    } else {
        this.topology = null;
        this._visitables.get("topology").remove(this.topology);
    }
    return (A) this;
  }
  public class TopologyNested<N> extends TopologyShardingStrategyFluent<TopologyNested<N>> implements Nested<N>{
  
    TopologyShardingStrategyBuilder builder;
  
    TopologyNested(TopologyShardingStrategy item) {
      this.builder = new TopologyShardingStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) ShardingStrategyFluent.this.withTopology(builder.build());
    }
    
    public N endTopology() {
      return and();
    }
    
  }
}