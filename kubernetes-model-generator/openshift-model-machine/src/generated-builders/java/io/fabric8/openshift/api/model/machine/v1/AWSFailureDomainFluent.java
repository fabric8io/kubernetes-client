package io.fabric8.openshift.api.model.machine.v1;

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
public class AWSFailureDomainFluent<A extends io.fabric8.openshift.api.model.machine.v1.AWSFailureDomainFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSFailureDomainPlacementBuilder placement;
  private AWSResourceReferenceBuilder subnet;

  public AWSFailureDomainFluent() {
  }
  
  public AWSFailureDomainFluent(AWSFailureDomain instance) {
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
  
  public AWSFailureDomainPlacement buildPlacement() {
    return this.placement != null ? this.placement.build() : null;
  }
  
  public AWSResourceReference buildSubnet() {
    return this.subnet != null ? this.subnet.build() : null;
  }
  
  protected void copyInstance(AWSFailureDomain instance) {
    instance = instance != null ? instance : new AWSFailureDomain();
    if (instance != null) {
        this.withPlacement(instance.getPlacement());
        this.withSubnet(instance.getSubnet());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PlacementNested<A> editOrNewPlacement() {
    return this.withNewPlacementLike(Optional.ofNullable(this.buildPlacement()).orElse(new AWSFailureDomainPlacementBuilder().build()));
  }
  
  public PlacementNested<A> editOrNewPlacementLike(AWSFailureDomainPlacement item) {
    return this.withNewPlacementLike(Optional.ofNullable(this.buildPlacement()).orElse(item));
  }
  
  public SubnetNested<A> editOrNewSubnet() {
    return this.withNewSubnetLike(Optional.ofNullable(this.buildSubnet()).orElse(new AWSResourceReferenceBuilder().build()));
  }
  
  public SubnetNested<A> editOrNewSubnetLike(AWSResourceReference item) {
    return this.withNewSubnetLike(Optional.ofNullable(this.buildSubnet()).orElse(item));
  }
  
  public PlacementNested<A> editPlacement() {
    return this.withNewPlacementLike(Optional.ofNullable(this.buildPlacement()).orElse(null));
  }
  
  public SubnetNested<A> editSubnet() {
    return this.withNewSubnetLike(Optional.ofNullable(this.buildSubnet()).orElse(null));
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
    AWSFailureDomainFluent that = (AWSFailureDomainFluent) o;
    if (!(Objects.equals(placement, that.placement))) {
      return false;
    }
    if (!(Objects.equals(subnet, that.subnet))) {
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
  
  public boolean hasPlacement() {
    return this.placement != null;
  }
  
  public boolean hasSubnet() {
    return this.subnet != null;
  }
  
  public int hashCode() {
    return Objects.hash(placement, subnet, additionalProperties);
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
    if (!(placement == null)) {
        sb.append("placement:");
        sb.append(placement);
        sb.append(",");
    }
    if (!(subnet == null)) {
        sb.append("subnet:");
        sb.append(subnet);
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
  
  public PlacementNested<A> withNewPlacement() {
    return new PlacementNested(null);
  }
  
  public A withNewPlacement(String availabilityZone) {
    return (A) this.withPlacement(new AWSFailureDomainPlacement(availabilityZone));
  }
  
  public PlacementNested<A> withNewPlacementLike(AWSFailureDomainPlacement item) {
    return new PlacementNested(item);
  }
  
  public SubnetNested<A> withNewSubnet() {
    return new SubnetNested(null);
  }
  
  public SubnetNested<A> withNewSubnetLike(AWSResourceReference item) {
    return new SubnetNested(item);
  }
  
  public A withPlacement(AWSFailureDomainPlacement placement) {
    this._visitables.remove("placement");
    if (placement != null) {
        this.placement = new AWSFailureDomainPlacementBuilder(placement);
        this._visitables.get("placement").add(this.placement);
    } else {
        this.placement = null;
        this._visitables.get("placement").remove(this.placement);
    }
    return (A) this;
  }
  
  public A withSubnet(AWSResourceReference subnet) {
    this._visitables.remove("subnet");
    if (subnet != null) {
        this.subnet = new AWSResourceReferenceBuilder(subnet);
        this._visitables.get("subnet").add(this.subnet);
    } else {
        this.subnet = null;
        this._visitables.get("subnet").remove(this.subnet);
    }
    return (A) this;
  }
  public class PlacementNested<N> extends AWSFailureDomainPlacementFluent<PlacementNested<N>> implements Nested<N>{
  
    AWSFailureDomainPlacementBuilder builder;
  
    PlacementNested(AWSFailureDomainPlacement item) {
      this.builder = new AWSFailureDomainPlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSFailureDomainFluent.this.withPlacement(builder.build());
    }
    
    public N endPlacement() {
      return and();
    }
    
  }
  public class SubnetNested<N> extends AWSResourceReferenceFluent<SubnetNested<N>> implements Nested<N>{
  
    AWSResourceReferenceBuilder builder;
  
    SubnetNested(AWSResourceReference item) {
      this.builder = new AWSResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSFailureDomainFluent.this.withSubnet(builder.build());
    }
    
    public N endSubnet() {
      return and();
    }
    
  }
}