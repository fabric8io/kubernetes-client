package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class LoadBalancerSettingsConsistentHashFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LoadBalancerSettingsConsistentHashLBBuilder consistentHash;

  public LoadBalancerSettingsConsistentHashFluent() {
  }
  
  public LoadBalancerSettingsConsistentHashFluent(LoadBalancerSettingsConsistentHash instance) {
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
  
  public LoadBalancerSettingsConsistentHashLB buildConsistentHash() {
    return this.consistentHash != null ? this.consistentHash.build() : null;
  }
  
  protected void copyInstance(LoadBalancerSettingsConsistentHash instance) {
    instance = instance != null ? instance : new LoadBalancerSettingsConsistentHash();
    if (instance != null) {
        this.withConsistentHash(instance.getConsistentHash());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConsistentHashNested<A> editConsistentHash() {
    return this.withNewConsistentHashLike(Optional.ofNullable(this.buildConsistentHash()).orElse(null));
  }
  
  public ConsistentHashNested<A> editOrNewConsistentHash() {
    return this.withNewConsistentHashLike(Optional.ofNullable(this.buildConsistentHash()).orElse(new LoadBalancerSettingsConsistentHashLBBuilder().build()));
  }
  
  public ConsistentHashNested<A> editOrNewConsistentHashLike(LoadBalancerSettingsConsistentHashLB item) {
    return this.withNewConsistentHashLike(Optional.ofNullable(this.buildConsistentHash()).orElse(item));
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
    LoadBalancerSettingsConsistentHashFluent that = (LoadBalancerSettingsConsistentHashFluent) o;
    if (!(Objects.equals(consistentHash, that.consistentHash))) {
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
  
  public boolean hasConsistentHash() {
    return this.consistentHash != null;
  }
  
  public int hashCode() {
    return Objects.hash(consistentHash, additionalProperties);
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
    if (!(consistentHash == null)) {
        sb.append("consistentHash:");
        sb.append(consistentHash);
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
  
  public A withConsistentHash(LoadBalancerSettingsConsistentHashLB consistentHash) {
    this._visitables.remove("consistentHash");
    if (consistentHash != null) {
        this.consistentHash = new LoadBalancerSettingsConsistentHashLBBuilder(consistentHash);
        this._visitables.get("consistentHash").add(this.consistentHash);
    } else {
        this.consistentHash = null;
        this._visitables.get("consistentHash").remove(this.consistentHash);
    }
    return (A) this;
  }
  
  public ConsistentHashNested<A> withNewConsistentHash() {
    return new ConsistentHashNested(null);
  }
  
  public ConsistentHashNested<A> withNewConsistentHashLike(LoadBalancerSettingsConsistentHashLB item) {
    return new ConsistentHashNested(item);
  }
  public class ConsistentHashNested<N> extends LoadBalancerSettingsConsistentHashLBFluent<ConsistentHashNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBBuilder builder;
  
    ConsistentHashNested(LoadBalancerSettingsConsistentHashLB item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashFluent.this.withConsistentHash(builder.build());
    }
    
    public N endConsistentHash() {
      return and();
    }
    
  }
}