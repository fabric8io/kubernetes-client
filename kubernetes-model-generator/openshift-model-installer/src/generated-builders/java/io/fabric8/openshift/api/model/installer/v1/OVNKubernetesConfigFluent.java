package io.fabric8.openshift.api.model.installer.v1;

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
public class OVNKubernetesConfigFluent<A extends io.fabric8.openshift.api.model.installer.v1.OVNKubernetesConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IPv4OVNKubernetesConfigBuilder ipv4;

  public OVNKubernetesConfigFluent() {
  }
  
  public OVNKubernetesConfigFluent(OVNKubernetesConfig instance) {
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
  
  public IPv4OVNKubernetesConfig buildIpv4() {
    return this.ipv4 != null ? this.ipv4.build() : null;
  }
  
  protected void copyInstance(OVNKubernetesConfig instance) {
    instance = instance != null ? instance : new OVNKubernetesConfig();
    if (instance != null) {
        this.withIpv4(instance.getIpv4());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public Ipv4Nested<A> editIpv4() {
    return this.withNewIpv4Like(Optional.ofNullable(this.buildIpv4()).orElse(null));
  }
  
  public Ipv4Nested<A> editOrNewIpv4() {
    return this.withNewIpv4Like(Optional.ofNullable(this.buildIpv4()).orElse(new IPv4OVNKubernetesConfigBuilder().build()));
  }
  
  public Ipv4Nested<A> editOrNewIpv4Like(IPv4OVNKubernetesConfig item) {
    return this.withNewIpv4Like(Optional.ofNullable(this.buildIpv4()).orElse(item));
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
    OVNKubernetesConfigFluent that = (OVNKubernetesConfigFluent) o;
    if (!(Objects.equals(ipv4, that.ipv4))) {
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
  
  public boolean hasIpv4() {
    return this.ipv4 != null;
  }
  
  public int hashCode() {
    return Objects.hash(ipv4, additionalProperties);
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
    if (!(ipv4 == null)) {
        sb.append("ipv4:");
        sb.append(ipv4);
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
  
  public A withIpv4(IPv4OVNKubernetesConfig ipv4) {
    this._visitables.remove("ipv4");
    if (ipv4 != null) {
        this.ipv4 = new IPv4OVNKubernetesConfigBuilder(ipv4);
        this._visitables.get("ipv4").add(this.ipv4);
    } else {
        this.ipv4 = null;
        this._visitables.get("ipv4").remove(this.ipv4);
    }
    return (A) this;
  }
  
  public Ipv4Nested<A> withNewIpv4() {
    return new Ipv4Nested(null);
  }
  
  public A withNewIpv4(String internalJoinSubnet) {
    return (A) this.withIpv4(new IPv4OVNKubernetesConfig(internalJoinSubnet));
  }
  
  public Ipv4Nested<A> withNewIpv4Like(IPv4OVNKubernetesConfig item) {
    return new Ipv4Nested(item);
  }
  public class Ipv4Nested<N> extends IPv4OVNKubernetesConfigFluent<Ipv4Nested<N>> implements Nested<N>{
  
    IPv4OVNKubernetesConfigBuilder builder;
  
    Ipv4Nested(IPv4OVNKubernetesConfig item) {
      this.builder = new IPv4OVNKubernetesConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OVNKubernetesConfigFluent.this.withIpv4(builder.build());
    }
    
    public N endIpv4() {
      return and();
    }
    
  }
}