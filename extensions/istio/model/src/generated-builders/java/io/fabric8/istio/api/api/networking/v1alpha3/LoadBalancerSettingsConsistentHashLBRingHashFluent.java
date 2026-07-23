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
public class LoadBalancerSettingsConsistentHashLBRingHashFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBRingHashFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LoadBalancerSettingsConsistentHashLBRingHashBuilder ringHash;

  public LoadBalancerSettingsConsistentHashLBRingHashFluent() {
  }
  
  public LoadBalancerSettingsConsistentHashLBRingHashFluent(LoadBalancerSettingsConsistentHashLBRingHash instance) {
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
  
  public LoadBalancerSettingsConsistentHashLBRingHash buildRingHash() {
    return this.ringHash != null ? this.ringHash.build() : null;
  }
  
  protected void copyInstance(LoadBalancerSettingsConsistentHashLBRingHash instance) {
    instance = instance != null ? instance : new LoadBalancerSettingsConsistentHashLBRingHash();
    if (instance != null) {
        this.withRingHash(instance.getRingHash());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RingHashNested<A> editOrNewRingHash() {
    return this.withNewRingHashLike(Optional.ofNullable(this.buildRingHash()).orElse(new LoadBalancerSettingsConsistentHashLBRingHashBuilder().build()));
  }
  
  public RingHashNested<A> editOrNewRingHashLike(LoadBalancerSettingsConsistentHashLBRingHash item) {
    return this.withNewRingHashLike(Optional.ofNullable(this.buildRingHash()).orElse(item));
  }
  
  public RingHashNested<A> editRingHash() {
    return this.withNewRingHashLike(Optional.ofNullable(this.buildRingHash()).orElse(null));
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
    LoadBalancerSettingsConsistentHashLBRingHashFluent that = (LoadBalancerSettingsConsistentHashLBRingHashFluent) o;
    if (!(Objects.equals(ringHash, that.ringHash))) {
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
  
  public boolean hasRingHash() {
    return this.ringHash != null;
  }
  
  public int hashCode() {
    return Objects.hash(ringHash, additionalProperties);
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
    if (!(ringHash == null)) {
        sb.append("ringHash:");
        sb.append(ringHash);
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
  
  public RingHashNested<A> withNewRingHash() {
    return new RingHashNested(null);
  }
  
  public RingHashNested<A> withNewRingHashLike(LoadBalancerSettingsConsistentHashLBRingHash item) {
    return new RingHashNested(item);
  }
  
  public A withRingHash(LoadBalancerSettingsConsistentHashLBRingHash ringHash) {
    this._visitables.remove("ringHash");
    if (ringHash != null) {
        this.ringHash = new LoadBalancerSettingsConsistentHashLBRingHashBuilder(ringHash);
        this._visitables.get("ringHash").add(this.ringHash);
    } else {
        this.ringHash = null;
        this._visitables.get("ringHash").remove(this.ringHash);
    }
    return (A) this;
  }
  public class RingHashNested<N> extends LoadBalancerSettingsConsistentHashLBRingHashFluent<RingHashNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBRingHashBuilder builder;
  
    RingHashNested(LoadBalancerSettingsConsistentHashLBRingHash item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBRingHashBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashLBRingHashFluent.this.withRingHash(builder.build());
    }
    
    public N endRingHash() {
      return and();
    }
    
  }
}