package io.fabric8.openshift.api.model.config.v1;

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
public class VSpherePlatformNodeNetworkingFluent<A extends io.fabric8.openshift.api.model.config.v1.VSpherePlatformNodeNetworkingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VSpherePlatformNodeNetworkingSpecBuilder external;
  private VSpherePlatformNodeNetworkingSpecBuilder internal;

  public VSpherePlatformNodeNetworkingFluent() {
  }
  
  public VSpherePlatformNodeNetworkingFluent(VSpherePlatformNodeNetworking instance) {
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
  
  public VSpherePlatformNodeNetworkingSpec buildExternal() {
    return this.external != null ? this.external.build() : null;
  }
  
  public VSpherePlatformNodeNetworkingSpec buildInternal() {
    return this.internal != null ? this.internal.build() : null;
  }
  
  protected void copyInstance(VSpherePlatformNodeNetworking instance) {
    instance = instance != null ? instance : new VSpherePlatformNodeNetworking();
    if (instance != null) {
        this.withExternal(instance.getExternal());
        this.withInternal(instance.getInternal());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExternalNested<A> editExternal() {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(null));
  }
  
  public InternalNested<A> editInternal() {
    return this.withNewInternalLike(Optional.ofNullable(this.buildInternal()).orElse(null));
  }
  
  public ExternalNested<A> editOrNewExternal() {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(new VSpherePlatformNodeNetworkingSpecBuilder().build()));
  }
  
  public ExternalNested<A> editOrNewExternalLike(VSpherePlatformNodeNetworkingSpec item) {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(item));
  }
  
  public InternalNested<A> editOrNewInternal() {
    return this.withNewInternalLike(Optional.ofNullable(this.buildInternal()).orElse(new VSpherePlatformNodeNetworkingSpecBuilder().build()));
  }
  
  public InternalNested<A> editOrNewInternalLike(VSpherePlatformNodeNetworkingSpec item) {
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
    VSpherePlatformNodeNetworkingFluent that = (VSpherePlatformNodeNetworkingFluent) o;
    if (!(Objects.equals(external, that.external))) {
      return false;
    }
    if (!(Objects.equals(internal, that.internal))) {
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
  
  public boolean hasExternal() {
    return this.external != null;
  }
  
  public boolean hasInternal() {
    return this.internal != null;
  }
  
  public int hashCode() {
    return Objects.hash(external, internal, additionalProperties);
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
    if (!(external == null)) {
        sb.append("external:");
        sb.append(external);
        sb.append(",");
    }
    if (!(internal == null)) {
        sb.append("internal:");
        sb.append(internal);
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
  
  public A withExternal(VSpherePlatformNodeNetworkingSpec external) {
    this._visitables.remove("external");
    if (external != null) {
        this.external = new VSpherePlatformNodeNetworkingSpecBuilder(external);
        this._visitables.get("external").add(this.external);
    } else {
        this.external = null;
        this._visitables.get("external").remove(this.external);
    }
    return (A) this;
  }
  
  public A withInternal(VSpherePlatformNodeNetworkingSpec internal) {
    this._visitables.remove("internal");
    if (internal != null) {
        this.internal = new VSpherePlatformNodeNetworkingSpecBuilder(internal);
        this._visitables.get("internal").add(this.internal);
    } else {
        this.internal = null;
        this._visitables.get("internal").remove(this.internal);
    }
    return (A) this;
  }
  
  public ExternalNested<A> withNewExternal() {
    return new ExternalNested(null);
  }
  
  public ExternalNested<A> withNewExternalLike(VSpherePlatformNodeNetworkingSpec item) {
    return new ExternalNested(item);
  }
  
  public InternalNested<A> withNewInternal() {
    return new InternalNested(null);
  }
  
  public InternalNested<A> withNewInternalLike(VSpherePlatformNodeNetworkingSpec item) {
    return new InternalNested(item);
  }
  public class ExternalNested<N> extends VSpherePlatformNodeNetworkingSpecFluent<ExternalNested<N>> implements Nested<N>{
  
    VSpherePlatformNodeNetworkingSpecBuilder builder;
  
    ExternalNested(VSpherePlatformNodeNetworkingSpec item) {
      this.builder = new VSpherePlatformNodeNetworkingSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) VSpherePlatformNodeNetworkingFluent.this.withExternal(builder.build());
    }
    
    public N endExternal() {
      return and();
    }
    
  }
  public class InternalNested<N> extends VSpherePlatformNodeNetworkingSpecFluent<InternalNested<N>> implements Nested<N>{
  
    VSpherePlatformNodeNetworkingSpecBuilder builder;
  
    InternalNested(VSpherePlatformNodeNetworkingSpec item) {
      this.builder = new VSpherePlatformNodeNetworkingSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) VSpherePlatformNodeNetworkingFluent.this.withInternal(builder.build());
    }
    
    public N endInternal() {
      return and();
    }
    
  }
}