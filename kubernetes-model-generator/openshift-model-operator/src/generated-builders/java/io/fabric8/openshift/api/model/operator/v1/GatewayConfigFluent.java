package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class GatewayConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.GatewayConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ipForwarding;
  private IPv4GatewayConfigBuilder ipv4;
  private IPv6GatewayConfigBuilder ipv6;
  private Boolean routingViaHost;

  public GatewayConfigFluent() {
  }
  
  public GatewayConfigFluent(GatewayConfig instance) {
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
  
  public IPv4GatewayConfig buildIpv4() {
    return this.ipv4 != null ? this.ipv4.build() : null;
  }
  
  public IPv6GatewayConfig buildIpv6() {
    return this.ipv6 != null ? this.ipv6.build() : null;
  }
  
  protected void copyInstance(GatewayConfig instance) {
    instance = instance != null ? instance : new GatewayConfig();
    if (instance != null) {
        this.withIpForwarding(instance.getIpForwarding());
        this.withIpv4(instance.getIpv4());
        this.withIpv6(instance.getIpv6());
        this.withRoutingViaHost(instance.getRoutingViaHost());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public Ipv4Nested<A> editIpv4() {
    return this.withNewIpv4Like(Optional.ofNullable(this.buildIpv4()).orElse(null));
  }
  
  public Ipv6Nested<A> editIpv6() {
    return this.withNewIpv6Like(Optional.ofNullable(this.buildIpv6()).orElse(null));
  }
  
  public Ipv4Nested<A> editOrNewIpv4() {
    return this.withNewIpv4Like(Optional.ofNullable(this.buildIpv4()).orElse(new IPv4GatewayConfigBuilder().build()));
  }
  
  public Ipv4Nested<A> editOrNewIpv4Like(IPv4GatewayConfig item) {
    return this.withNewIpv4Like(Optional.ofNullable(this.buildIpv4()).orElse(item));
  }
  
  public Ipv6Nested<A> editOrNewIpv6() {
    return this.withNewIpv6Like(Optional.ofNullable(this.buildIpv6()).orElse(new IPv6GatewayConfigBuilder().build()));
  }
  
  public Ipv6Nested<A> editOrNewIpv6Like(IPv6GatewayConfig item) {
    return this.withNewIpv6Like(Optional.ofNullable(this.buildIpv6()).orElse(item));
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
    GatewayConfigFluent that = (GatewayConfigFluent) o;
    if (!(Objects.equals(ipForwarding, that.ipForwarding))) {
      return false;
    }
    if (!(Objects.equals(ipv4, that.ipv4))) {
      return false;
    }
    if (!(Objects.equals(ipv6, that.ipv6))) {
      return false;
    }
    if (!(Objects.equals(routingViaHost, that.routingViaHost))) {
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
  
  public String getIpForwarding() {
    return this.ipForwarding;
  }
  
  public Boolean getRoutingViaHost() {
    return this.routingViaHost;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIpForwarding() {
    return this.ipForwarding != null;
  }
  
  public boolean hasIpv4() {
    return this.ipv4 != null;
  }
  
  public boolean hasIpv6() {
    return this.ipv6 != null;
  }
  
  public boolean hasRoutingViaHost() {
    return this.routingViaHost != null;
  }
  
  public int hashCode() {
    return Objects.hash(ipForwarding, ipv4, ipv6, routingViaHost, additionalProperties);
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
    if (!(ipForwarding == null)) {
        sb.append("ipForwarding:");
        sb.append(ipForwarding);
        sb.append(",");
    }
    if (!(ipv4 == null)) {
        sb.append("ipv4:");
        sb.append(ipv4);
        sb.append(",");
    }
    if (!(ipv6 == null)) {
        sb.append("ipv6:");
        sb.append(ipv6);
        sb.append(",");
    }
    if (!(routingViaHost == null)) {
        sb.append("routingViaHost:");
        sb.append(routingViaHost);
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
  
  public A withIpForwarding(String ipForwarding) {
    this.ipForwarding = ipForwarding;
    return (A) this;
  }
  
  public A withIpv4(IPv4GatewayConfig ipv4) {
    this._visitables.remove("ipv4");
    if (ipv4 != null) {
        this.ipv4 = new IPv4GatewayConfigBuilder(ipv4);
        this._visitables.get("ipv4").add(this.ipv4);
    } else {
        this.ipv4 = null;
        this._visitables.get("ipv4").remove(this.ipv4);
    }
    return (A) this;
  }
  
  public A withIpv6(IPv6GatewayConfig ipv6) {
    this._visitables.remove("ipv6");
    if (ipv6 != null) {
        this.ipv6 = new IPv6GatewayConfigBuilder(ipv6);
        this._visitables.get("ipv6").add(this.ipv6);
    } else {
        this.ipv6 = null;
        this._visitables.get("ipv6").remove(this.ipv6);
    }
    return (A) this;
  }
  
  public Ipv4Nested<A> withNewIpv4() {
    return new Ipv4Nested(null);
  }
  
  public A withNewIpv4(String internalMasqueradeSubnet) {
    return (A) this.withIpv4(new IPv4GatewayConfig(internalMasqueradeSubnet));
  }
  
  public Ipv4Nested<A> withNewIpv4Like(IPv4GatewayConfig item) {
    return new Ipv4Nested(item);
  }
  
  public Ipv6Nested<A> withNewIpv6() {
    return new Ipv6Nested(null);
  }
  
  public A withNewIpv6(String internalMasqueradeSubnet) {
    return (A) this.withIpv6(new IPv6GatewayConfig(internalMasqueradeSubnet));
  }
  
  public Ipv6Nested<A> withNewIpv6Like(IPv6GatewayConfig item) {
    return new Ipv6Nested(item);
  }
  
  public A withRoutingViaHost() {
    return withRoutingViaHost(true);
  }
  
  public A withRoutingViaHost(Boolean routingViaHost) {
    this.routingViaHost = routingViaHost;
    return (A) this;
  }
  public class Ipv4Nested<N> extends IPv4GatewayConfigFluent<Ipv4Nested<N>> implements Nested<N>{
  
    IPv4GatewayConfigBuilder builder;
  
    Ipv4Nested(IPv4GatewayConfig item) {
      this.builder = new IPv4GatewayConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayConfigFluent.this.withIpv4(builder.build());
    }
    
    public N endIpv4() {
      return and();
    }
    
  }
  public class Ipv6Nested<N> extends IPv6GatewayConfigFluent<Ipv6Nested<N>> implements Nested<N>{
  
    IPv6GatewayConfigBuilder builder;
  
    Ipv6Nested(IPv6GatewayConfig item) {
      this.builder = new IPv6GatewayConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayConfigFluent.this.withIpv6(builder.build());
    }
    
    public N endIpv6() {
      return and();
    }
    
  }
}