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
public class OutboundTrafficPolicyFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.OutboundTrafficPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DestinationBuilder egressProxy;
  private OutboundTrafficPolicyMode mode;

  public OutboundTrafficPolicyFluent() {
  }
  
  public OutboundTrafficPolicyFluent(OutboundTrafficPolicy instance) {
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
  
  public Destination buildEgressProxy() {
    return this.egressProxy != null ? this.egressProxy.build() : null;
  }
  
  protected void copyInstance(OutboundTrafficPolicy instance) {
    instance = instance != null ? instance : new OutboundTrafficPolicy();
    if (instance != null) {
        this.withEgressProxy(instance.getEgressProxy());
        this.withMode(instance.getMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EgressProxyNested<A> editEgressProxy() {
    return this.withNewEgressProxyLike(Optional.ofNullable(this.buildEgressProxy()).orElse(null));
  }
  
  public EgressProxyNested<A> editOrNewEgressProxy() {
    return this.withNewEgressProxyLike(Optional.ofNullable(this.buildEgressProxy()).orElse(new DestinationBuilder().build()));
  }
  
  public EgressProxyNested<A> editOrNewEgressProxyLike(Destination item) {
    return this.withNewEgressProxyLike(Optional.ofNullable(this.buildEgressProxy()).orElse(item));
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
    OutboundTrafficPolicyFluent that = (OutboundTrafficPolicyFluent) o;
    if (!(Objects.equals(egressProxy, that.egressProxy))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
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
  
  public OutboundTrafficPolicyMode getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEgressProxy() {
    return this.egressProxy != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(egressProxy, mode, additionalProperties);
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
    if (!(egressProxy == null)) {
        sb.append("egressProxy:");
        sb.append(egressProxy);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
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
  
  public A withEgressProxy(Destination egressProxy) {
    this._visitables.remove("egressProxy");
    if (egressProxy != null) {
        this.egressProxy = new DestinationBuilder(egressProxy);
        this._visitables.get("egressProxy").add(this.egressProxy);
    } else {
        this.egressProxy = null;
        this._visitables.get("egressProxy").remove(this.egressProxy);
    }
    return (A) this;
  }
  
  public A withMode(OutboundTrafficPolicyMode mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public EgressProxyNested<A> withNewEgressProxy() {
    return new EgressProxyNested(null);
  }
  
  public EgressProxyNested<A> withNewEgressProxyLike(Destination item) {
    return new EgressProxyNested(item);
  }
  public class EgressProxyNested<N> extends DestinationFluent<EgressProxyNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    EgressProxyNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) OutboundTrafficPolicyFluent.this.withEgressProxy(builder.build());
    }
    
    public N endEgressProxy() {
      return and();
    }
    
  }
}