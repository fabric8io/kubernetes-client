package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class PartitionPolicySpecFluent<A extends io.fabric8.volcano.api.model.batch.v1alpha1.PartitionPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer minPartitions;
  private NetworkTopologySpecBuilder networkTopology;
  private Integer partitionSize;
  private Integer totalPartitions;

  public PartitionPolicySpecFluent() {
  }
  
  public PartitionPolicySpecFluent(PartitionPolicySpec instance) {
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
  
  public NetworkTopologySpec buildNetworkTopology() {
    return this.networkTopology != null ? this.networkTopology.build() : null;
  }
  
  protected void copyInstance(PartitionPolicySpec instance) {
    instance = instance != null ? instance : new PartitionPolicySpec();
    if (instance != null) {
        this.withMinPartitions(instance.getMinPartitions());
        this.withNetworkTopology(instance.getNetworkTopology());
        this.withPartitionSize(instance.getPartitionSize());
        this.withTotalPartitions(instance.getTotalPartitions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NetworkTopologyNested<A> editNetworkTopology() {
    return this.withNewNetworkTopologyLike(Optional.ofNullable(this.buildNetworkTopology()).orElse(null));
  }
  
  public NetworkTopologyNested<A> editOrNewNetworkTopology() {
    return this.withNewNetworkTopologyLike(Optional.ofNullable(this.buildNetworkTopology()).orElse(new NetworkTopologySpecBuilder().build()));
  }
  
  public NetworkTopologyNested<A> editOrNewNetworkTopologyLike(NetworkTopologySpec item) {
    return this.withNewNetworkTopologyLike(Optional.ofNullable(this.buildNetworkTopology()).orElse(item));
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
    PartitionPolicySpecFluent that = (PartitionPolicySpecFluent) o;
    if (!(Objects.equals(minPartitions, that.minPartitions))) {
      return false;
    }
    if (!(Objects.equals(networkTopology, that.networkTopology))) {
      return false;
    }
    if (!(Objects.equals(partitionSize, that.partitionSize))) {
      return false;
    }
    if (!(Objects.equals(totalPartitions, that.totalPartitions))) {
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
  
  public Integer getMinPartitions() {
    return this.minPartitions;
  }
  
  public Integer getPartitionSize() {
    return this.partitionSize;
  }
  
  public Integer getTotalPartitions() {
    return this.totalPartitions;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMinPartitions() {
    return this.minPartitions != null;
  }
  
  public boolean hasNetworkTopology() {
    return this.networkTopology != null;
  }
  
  public boolean hasPartitionSize() {
    return this.partitionSize != null;
  }
  
  public boolean hasTotalPartitions() {
    return this.totalPartitions != null;
  }
  
  public int hashCode() {
    return Objects.hash(minPartitions, networkTopology, partitionSize, totalPartitions, additionalProperties);
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
    if (!(minPartitions == null)) {
        sb.append("minPartitions:");
        sb.append(minPartitions);
        sb.append(",");
    }
    if (!(networkTopology == null)) {
        sb.append("networkTopology:");
        sb.append(networkTopology);
        sb.append(",");
    }
    if (!(partitionSize == null)) {
        sb.append("partitionSize:");
        sb.append(partitionSize);
        sb.append(",");
    }
    if (!(totalPartitions == null)) {
        sb.append("totalPartitions:");
        sb.append(totalPartitions);
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
  
  public A withMinPartitions(Integer minPartitions) {
    this.minPartitions = minPartitions;
    return (A) this;
  }
  
  public A withNetworkTopology(NetworkTopologySpec networkTopology) {
    this._visitables.remove("networkTopology");
    if (networkTopology != null) {
        this.networkTopology = new NetworkTopologySpecBuilder(networkTopology);
        this._visitables.get("networkTopology").add(this.networkTopology);
    } else {
        this.networkTopology = null;
        this._visitables.get("networkTopology").remove(this.networkTopology);
    }
    return (A) this;
  }
  
  public NetworkTopologyNested<A> withNewNetworkTopology() {
    return new NetworkTopologyNested(null);
  }
  
  public A withNewNetworkTopology(Integer highestTierAllowed,String highestTierName,String mode) {
    return (A) this.withNetworkTopology(new NetworkTopologySpec(highestTierAllowed, highestTierName, mode));
  }
  
  public NetworkTopologyNested<A> withNewNetworkTopologyLike(NetworkTopologySpec item) {
    return new NetworkTopologyNested(item);
  }
  
  public A withPartitionSize(Integer partitionSize) {
    this.partitionSize = partitionSize;
    return (A) this;
  }
  
  public A withTotalPartitions(Integer totalPartitions) {
    this.totalPartitions = totalPartitions;
    return (A) this;
  }
  public class NetworkTopologyNested<N> extends NetworkTopologySpecFluent<NetworkTopologyNested<N>> implements Nested<N>{
  
    NetworkTopologySpecBuilder builder;
  
    NetworkTopologyNested(NetworkTopologySpec item) {
      this.builder = new NetworkTopologySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PartitionPolicySpecFluent.this.withNetworkTopology(builder.build());
    }
    
    public N endNetworkTopology() {
      return and();
    }
    
  }
}