package io.fabric8.openshift.api.model.hive.gcp.v1;

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
public class ServiceAttachmentFluent<A extends io.fabric8.openshift.api.model.hive.gcp.v1.ServiceAttachmentFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ServiceAttachmentSubnetBuilder subnet;

  public ServiceAttachmentFluent() {
  }
  
  public ServiceAttachmentFluent(ServiceAttachment instance) {
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
  
  public ServiceAttachmentSubnet buildSubnet() {
    return this.subnet != null ? this.subnet.build() : null;
  }
  
  protected void copyInstance(ServiceAttachment instance) {
    instance = instance != null ? instance : new ServiceAttachment();
    if (instance != null) {
        this.withSubnet(instance.getSubnet());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubnetNested<A> editOrNewSubnet() {
    return this.withNewSubnetLike(Optional.ofNullable(this.buildSubnet()).orElse(new ServiceAttachmentSubnetBuilder().build()));
  }
  
  public SubnetNested<A> editOrNewSubnetLike(ServiceAttachmentSubnet item) {
    return this.withNewSubnetLike(Optional.ofNullable(this.buildSubnet()).orElse(item));
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
    ServiceAttachmentFluent that = (ServiceAttachmentFluent) o;
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
  
  public boolean hasSubnet() {
    return this.subnet != null;
  }
  
  public int hashCode() {
    return Objects.hash(subnet, additionalProperties);
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
  
  public SubnetNested<A> withNewSubnet() {
    return new SubnetNested(null);
  }
  
  public SubnetNested<A> withNewSubnetLike(ServiceAttachmentSubnet item) {
    return new SubnetNested(item);
  }
  
  public A withSubnet(ServiceAttachmentSubnet subnet) {
    this._visitables.remove("subnet");
    if (subnet != null) {
        this.subnet = new ServiceAttachmentSubnetBuilder(subnet);
        this._visitables.get("subnet").add(this.subnet);
    } else {
        this.subnet = null;
        this._visitables.get("subnet").remove(this.subnet);
    }
    return (A) this;
  }
  public class SubnetNested<N> extends ServiceAttachmentSubnetFluent<SubnetNested<N>> implements Nested<N>{
  
    ServiceAttachmentSubnetBuilder builder;
  
    SubnetNested(ServiceAttachmentSubnet item) {
      this.builder = new ServiceAttachmentSubnetBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceAttachmentFluent.this.withSubnet(builder.build());
    }
    
    public N endSubnet() {
      return and();
    }
    
  }
}