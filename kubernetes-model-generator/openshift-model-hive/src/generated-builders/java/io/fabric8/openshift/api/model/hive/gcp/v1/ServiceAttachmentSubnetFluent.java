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
public class ServiceAttachmentSubnetFluent<A extends io.fabric8.openshift.api.model.hive.gcp.v1.ServiceAttachmentSubnetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cidr;
  private ServiceAttachmentSubnetExistingBuilder existing;

  public ServiceAttachmentSubnetFluent() {
  }
  
  public ServiceAttachmentSubnetFluent(ServiceAttachmentSubnet instance) {
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
  
  public ServiceAttachmentSubnetExisting buildExisting() {
    return this.existing != null ? this.existing.build() : null;
  }
  
  protected void copyInstance(ServiceAttachmentSubnet instance) {
    instance = instance != null ? instance : new ServiceAttachmentSubnet();
    if (instance != null) {
        this.withCidr(instance.getCidr());
        this.withExisting(instance.getExisting());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExistingNested<A> editExisting() {
    return this.withNewExistingLike(Optional.ofNullable(this.buildExisting()).orElse(null));
  }
  
  public ExistingNested<A> editOrNewExisting() {
    return this.withNewExistingLike(Optional.ofNullable(this.buildExisting()).orElse(new ServiceAttachmentSubnetExistingBuilder().build()));
  }
  
  public ExistingNested<A> editOrNewExistingLike(ServiceAttachmentSubnetExisting item) {
    return this.withNewExistingLike(Optional.ofNullable(this.buildExisting()).orElse(item));
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
    ServiceAttachmentSubnetFluent that = (ServiceAttachmentSubnetFluent) o;
    if (!(Objects.equals(cidr, that.cidr))) {
      return false;
    }
    if (!(Objects.equals(existing, that.existing))) {
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
  
  public String getCidr() {
    return this.cidr;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCidr() {
    return this.cidr != null;
  }
  
  public boolean hasExisting() {
    return this.existing != null;
  }
  
  public int hashCode() {
    return Objects.hash(cidr, existing, additionalProperties);
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
    if (!(cidr == null)) {
        sb.append("cidr:");
        sb.append(cidr);
        sb.append(",");
    }
    if (!(existing == null)) {
        sb.append("existing:");
        sb.append(existing);
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
  
  public A withCidr(String cidr) {
    this.cidr = cidr;
    return (A) this;
  }
  
  public A withExisting(ServiceAttachmentSubnetExisting existing) {
    this._visitables.remove("existing");
    if (existing != null) {
        this.existing = new ServiceAttachmentSubnetExistingBuilder(existing);
        this._visitables.get("existing").add(this.existing);
    } else {
        this.existing = null;
        this._visitables.get("existing").remove(this.existing);
    }
    return (A) this;
  }
  
  public ExistingNested<A> withNewExisting() {
    return new ExistingNested(null);
  }
  
  public A withNewExisting(String name,String project) {
    return (A) this.withExisting(new ServiceAttachmentSubnetExisting(name, project));
  }
  
  public ExistingNested<A> withNewExistingLike(ServiceAttachmentSubnetExisting item) {
    return new ExistingNested(item);
  }
  public class ExistingNested<N> extends ServiceAttachmentSubnetExistingFluent<ExistingNested<N>> implements Nested<N>{
  
    ServiceAttachmentSubnetExistingBuilder builder;
  
    ExistingNested(ServiceAttachmentSubnetExisting item) {
      this.builder = new ServiceAttachmentSubnetExistingBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceAttachmentSubnetFluent.this.withExisting(builder.build());
    }
    
    public N endExisting() {
      return and();
    }
    
  }
}