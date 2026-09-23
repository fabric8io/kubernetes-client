package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class HostPlacementFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.HostPlacementFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String affinity;
  private DedicatedHostBuilder dedicatedHost;

  public HostPlacementFluent() {
  }
  
  public HostPlacementFluent(HostPlacement instance) {
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
  
  public DedicatedHost buildDedicatedHost() {
    return this.dedicatedHost != null ? this.dedicatedHost.build() : null;
  }
  
  protected void copyInstance(HostPlacement instance) {
    instance = instance != null ? instance : new HostPlacement();
    if (instance != null) {
        this.withAffinity(instance.getAffinity());
        this.withDedicatedHost(instance.getDedicatedHost());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DedicatedHostNested<A> editDedicatedHost() {
    return this.withNewDedicatedHostLike(Optional.ofNullable(this.buildDedicatedHost()).orElse(null));
  }
  
  public DedicatedHostNested<A> editOrNewDedicatedHost() {
    return this.withNewDedicatedHostLike(Optional.ofNullable(this.buildDedicatedHost()).orElse(new DedicatedHostBuilder().build()));
  }
  
  public DedicatedHostNested<A> editOrNewDedicatedHostLike(DedicatedHost item) {
    return this.withNewDedicatedHostLike(Optional.ofNullable(this.buildDedicatedHost()).orElse(item));
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
    HostPlacementFluent that = (HostPlacementFluent) o;
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(dedicatedHost, that.dedicatedHost))) {
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
  
  public String getAffinity() {
    return this.affinity;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasDedicatedHost() {
    return this.dedicatedHost != null;
  }
  
  public int hashCode() {
    return Objects.hash(affinity, dedicatedHost, additionalProperties);
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
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(dedicatedHost == null)) {
        sb.append("dedicatedHost:");
        sb.append(dedicatedHost);
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
  
  public A withAffinity(String affinity) {
    this.affinity = affinity;
    return (A) this;
  }
  
  public A withDedicatedHost(DedicatedHost dedicatedHost) {
    this._visitables.remove("dedicatedHost");
    if (dedicatedHost != null) {
        this.dedicatedHost = new DedicatedHostBuilder(dedicatedHost);
        this._visitables.get("dedicatedHost").add(this.dedicatedHost);
    } else {
        this.dedicatedHost = null;
        this._visitables.get("dedicatedHost").remove(this.dedicatedHost);
    }
    return (A) this;
  }
  
  public DedicatedHostNested<A> withNewDedicatedHost() {
    return new DedicatedHostNested(null);
  }
  
  public DedicatedHostNested<A> withNewDedicatedHostLike(DedicatedHost item) {
    return new DedicatedHostNested(item);
  }
  public class DedicatedHostNested<N> extends DedicatedHostFluent<DedicatedHostNested<N>> implements Nested<N>{
  
    DedicatedHostBuilder builder;
  
    DedicatedHostNested(DedicatedHost item) {
      this.builder = new DedicatedHostBuilder(this, item);
    }
  
    public N and() {
      return (N) HostPlacementFluent.this.withDedicatedHost(builder.build());
    }
    
    public N endDedicatedHost() {
      return and();
    }
    
  }
}