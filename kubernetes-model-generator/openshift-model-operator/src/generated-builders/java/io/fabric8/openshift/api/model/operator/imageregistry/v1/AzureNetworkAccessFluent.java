package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
public class AzureNetworkAccessFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.AzureNetworkAccessFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AzureNetworkAccessInternalBuilder internal;
  private String type;

  public AzureNetworkAccessFluent() {
  }
  
  public AzureNetworkAccessFluent(AzureNetworkAccess instance) {
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
  
  public AzureNetworkAccessInternal buildInternal() {
    return this.internal != null ? this.internal.build() : null;
  }
  
  protected void copyInstance(AzureNetworkAccess instance) {
    instance = instance != null ? instance : new AzureNetworkAccess();
    if (instance != null) {
        this.withInternal(instance.getInternal());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public InternalNested<A> editInternal() {
    return this.withNewInternalLike(Optional.ofNullable(this.buildInternal()).orElse(null));
  }
  
  public InternalNested<A> editOrNewInternal() {
    return this.withNewInternalLike(Optional.ofNullable(this.buildInternal()).orElse(new AzureNetworkAccessInternalBuilder().build()));
  }
  
  public InternalNested<A> editOrNewInternalLike(AzureNetworkAccessInternal item) {
    return this.withNewInternalLike(Optional.ofNullable(this.buildInternal()).orElse(item));
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
    AzureNetworkAccessFluent that = (AzureNetworkAccessFluent) o;
    if (!(Objects.equals(internal, that.internal))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasInternal() {
    return this.internal != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(internal, type, additionalProperties);
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
    if (!(internal == null)) {
        sb.append("internal:");
        sb.append(internal);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withInternal(AzureNetworkAccessInternal internal) {
    this._visitables.remove("internal");
    if (internal != null) {
        this.internal = new AzureNetworkAccessInternalBuilder(internal);
        this._visitables.get("internal").add(this.internal);
    } else {
        this.internal = null;
        this._visitables.get("internal").remove(this.internal);
    }
    return (A) this;
  }
  
  public InternalNested<A> withNewInternal() {
    return new InternalNested(null);
  }
  
  public A withNewInternal(String networkResourceGroupName,String privateEndpointName,String subnetName,String vnetName) {
    return (A) this.withInternal(new AzureNetworkAccessInternal(networkResourceGroupName, privateEndpointName, subnetName, vnetName));
  }
  
  public InternalNested<A> withNewInternalLike(AzureNetworkAccessInternal item) {
    return new InternalNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class InternalNested<N> extends AzureNetworkAccessInternalFluent<InternalNested<N>> implements Nested<N>{
  
    AzureNetworkAccessInternalBuilder builder;
  
    InternalNested(AzureNetworkAccessInternal item) {
      this.builder = new AzureNetworkAccessInternalBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureNetworkAccessFluent.this.withInternal(builder.build());
    }
    
    public N endInternal() {
      return and();
    }
    
  }
}