package io.fabric8.openshift.api.model.hive.aws.v1;

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
public class PrivateLinkAccessStatusFluent<A extends io.fabric8.openshift.api.model.hive.aws.v1.PrivateLinkAccessStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hostedZoneID;
  private String vpcEndpointID;
  private VPCEndpointServiceBuilder vpcEndpointService;

  public PrivateLinkAccessStatusFluent() {
  }
  
  public PrivateLinkAccessStatusFluent(PrivateLinkAccessStatus instance) {
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
  
  public VPCEndpointService buildVpcEndpointService() {
    return this.vpcEndpointService != null ? this.vpcEndpointService.build() : null;
  }
  
  protected void copyInstance(PrivateLinkAccessStatus instance) {
    instance = instance != null ? instance : new PrivateLinkAccessStatus();
    if (instance != null) {
        this.withHostedZoneID(instance.getHostedZoneID());
        this.withVpcEndpointID(instance.getVpcEndpointID());
        this.withVpcEndpointService(instance.getVpcEndpointService());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VpcEndpointServiceNested<A> editOrNewVpcEndpointService() {
    return this.withNewVpcEndpointServiceLike(Optional.ofNullable(this.buildVpcEndpointService()).orElse(new VPCEndpointServiceBuilder().build()));
  }
  
  public VpcEndpointServiceNested<A> editOrNewVpcEndpointServiceLike(VPCEndpointService item) {
    return this.withNewVpcEndpointServiceLike(Optional.ofNullable(this.buildVpcEndpointService()).orElse(item));
  }
  
  public VpcEndpointServiceNested<A> editVpcEndpointService() {
    return this.withNewVpcEndpointServiceLike(Optional.ofNullable(this.buildVpcEndpointService()).orElse(null));
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
    PrivateLinkAccessStatusFluent that = (PrivateLinkAccessStatusFluent) o;
    if (!(Objects.equals(hostedZoneID, that.hostedZoneID))) {
      return false;
    }
    if (!(Objects.equals(vpcEndpointID, that.vpcEndpointID))) {
      return false;
    }
    if (!(Objects.equals(vpcEndpointService, that.vpcEndpointService))) {
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
  
  public String getHostedZoneID() {
    return this.hostedZoneID;
  }
  
  public String getVpcEndpointID() {
    return this.vpcEndpointID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHostedZoneID() {
    return this.hostedZoneID != null;
  }
  
  public boolean hasVpcEndpointID() {
    return this.vpcEndpointID != null;
  }
  
  public boolean hasVpcEndpointService() {
    return this.vpcEndpointService != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostedZoneID, vpcEndpointID, vpcEndpointService, additionalProperties);
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
    if (!(hostedZoneID == null)) {
        sb.append("hostedZoneID:");
        sb.append(hostedZoneID);
        sb.append(",");
    }
    if (!(vpcEndpointID == null)) {
        sb.append("vpcEndpointID:");
        sb.append(vpcEndpointID);
        sb.append(",");
    }
    if (!(vpcEndpointService == null)) {
        sb.append("vpcEndpointService:");
        sb.append(vpcEndpointService);
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
  
  public A withHostedZoneID(String hostedZoneID) {
    this.hostedZoneID = hostedZoneID;
    return (A) this;
  }
  
  public VpcEndpointServiceNested<A> withNewVpcEndpointService() {
    return new VpcEndpointServiceNested(null);
  }
  
  public VpcEndpointServiceNested<A> withNewVpcEndpointServiceLike(VPCEndpointService item) {
    return new VpcEndpointServiceNested(item);
  }
  
  public A withVpcEndpointID(String vpcEndpointID) {
    this.vpcEndpointID = vpcEndpointID;
    return (A) this;
  }
  
  public A withVpcEndpointService(VPCEndpointService vpcEndpointService) {
    this._visitables.remove("vpcEndpointService");
    if (vpcEndpointService != null) {
        this.vpcEndpointService = new VPCEndpointServiceBuilder(vpcEndpointService);
        this._visitables.get("vpcEndpointService").add(this.vpcEndpointService);
    } else {
        this.vpcEndpointService = null;
        this._visitables.get("vpcEndpointService").remove(this.vpcEndpointService);
    }
    return (A) this;
  }
  public class VpcEndpointServiceNested<N> extends VPCEndpointServiceFluent<VpcEndpointServiceNested<N>> implements Nested<N>{
  
    VPCEndpointServiceBuilder builder;
  
    VpcEndpointServiceNested(VPCEndpointService item) {
      this.builder = new VPCEndpointServiceBuilder(this, item);
    }
  
    public N and() {
      return (N) PrivateLinkAccessStatusFluent.this.withVpcEndpointService(builder.build());
    }
    
    public N endVpcEndpointService() {
      return and();
    }
    
  }
}