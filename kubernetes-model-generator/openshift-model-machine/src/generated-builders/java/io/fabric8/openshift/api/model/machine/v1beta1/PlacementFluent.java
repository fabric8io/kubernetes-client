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
public class PlacementFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.PlacementFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String availabilityZone;
  private HostPlacementBuilder host;
  private String region;
  private String tenancy;

  public PlacementFluent() {
  }
  
  public PlacementFluent(Placement instance) {
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
  
  public HostPlacement buildHost() {
    return this.host != null ? this.host.build() : null;
  }
  
  protected void copyInstance(Placement instance) {
    instance = instance != null ? instance : new Placement();
    if (instance != null) {
        this.withAvailabilityZone(instance.getAvailabilityZone());
        this.withHost(instance.getHost());
        this.withRegion(instance.getRegion());
        this.withTenancy(instance.getTenancy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HostNested<A> editHost() {
    return this.withNewHostLike(Optional.ofNullable(this.buildHost()).orElse(null));
  }
  
  public HostNested<A> editOrNewHost() {
    return this.withNewHostLike(Optional.ofNullable(this.buildHost()).orElse(new HostPlacementBuilder().build()));
  }
  
  public HostNested<A> editOrNewHostLike(HostPlacement item) {
    return this.withNewHostLike(Optional.ofNullable(this.buildHost()).orElse(item));
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
    PlacementFluent that = (PlacementFluent) o;
    if (!(Objects.equals(availabilityZone, that.availabilityZone))) {
      return false;
    }
    if (!(Objects.equals(host, that.host))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(tenancy, that.tenancy))) {
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
  
  public String getAvailabilityZone() {
    return this.availabilityZone;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getTenancy() {
    return this.tenancy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailabilityZone() {
    return this.availabilityZone != null;
  }
  
  public boolean hasHost() {
    return this.host != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasTenancy() {
    return this.tenancy != null;
  }
  
  public int hashCode() {
    return Objects.hash(availabilityZone, host, region, tenancy, additionalProperties);
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
    if (!(availabilityZone == null)) {
        sb.append("availabilityZone:");
        sb.append(availabilityZone);
        sb.append(",");
    }
    if (!(host == null)) {
        sb.append("host:");
        sb.append(host);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(tenancy == null)) {
        sb.append("tenancy:");
        sb.append(tenancy);
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
  
  public A withAvailabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
    return (A) this;
  }
  
  public A withHost(HostPlacement host) {
    this._visitables.remove("host");
    if (host != null) {
        this.host = new HostPlacementBuilder(host);
        this._visitables.get("host").add(this.host);
    } else {
        this.host = null;
        this._visitables.get("host").remove(this.host);
    }
    return (A) this;
  }
  
  public HostNested<A> withNewHost() {
    return new HostNested(null);
  }
  
  public HostNested<A> withNewHostLike(HostPlacement item) {
    return new HostNested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withTenancy(String tenancy) {
    this.tenancy = tenancy;
    return (A) this;
  }
  public class HostNested<N> extends HostPlacementFluent<HostNested<N>> implements Nested<N>{
  
    HostPlacementBuilder builder;
  
    HostNested(HostPlacement item) {
      this.builder = new HostPlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementFluent.this.withHost(builder.build());
    }
    
    public N endHost() {
      return and();
    }
    
  }
}