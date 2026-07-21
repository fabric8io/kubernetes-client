package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class AdminPolicyBasedExternalRouteSpecFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRouteSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ExternalNetworkSourceBuilder from;
  private ExternalNextHopsBuilder nextHops;

  public AdminPolicyBasedExternalRouteSpecFluent() {
  }
  
  public AdminPolicyBasedExternalRouteSpecFluent(AdminPolicyBasedExternalRouteSpec instance) {
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
  
  public ExternalNetworkSource buildFrom() {
    return this.from != null ? this.from.build() : null;
  }
  
  public ExternalNextHops buildNextHops() {
    return this.nextHops != null ? this.nextHops.build() : null;
  }
  
  protected void copyInstance(AdminPolicyBasedExternalRouteSpec instance) {
    instance = instance != null ? instance : new AdminPolicyBasedExternalRouteSpec();
    if (instance != null) {
        this.withFrom(instance.getFrom());
        this.withNextHops(instance.getNextHops());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromNested<A> editFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(null));
  }
  
  public NextHopsNested<A> editNextHops() {
    return this.withNewNextHopsLike(Optional.ofNullable(this.buildNextHops()).orElse(null));
  }
  
  public FromNested<A> editOrNewFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(new ExternalNetworkSourceBuilder().build()));
  }
  
  public FromNested<A> editOrNewFromLike(ExternalNetworkSource item) {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(item));
  }
  
  public NextHopsNested<A> editOrNewNextHops() {
    return this.withNewNextHopsLike(Optional.ofNullable(this.buildNextHops()).orElse(new ExternalNextHopsBuilder().build()));
  }
  
  public NextHopsNested<A> editOrNewNextHopsLike(ExternalNextHops item) {
    return this.withNewNextHopsLike(Optional.ofNullable(this.buildNextHops()).orElse(item));
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
    AdminPolicyBasedExternalRouteSpecFluent that = (AdminPolicyBasedExternalRouteSpecFluent) o;
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(nextHops, that.nextHops))) {
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
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasNextHops() {
    return this.nextHops != null;
  }
  
  public int hashCode() {
    return Objects.hash(from, nextHops, additionalProperties);
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
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(nextHops == null)) {
        sb.append("nextHops:");
        sb.append(nextHops);
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
  
  public A withFrom(ExternalNetworkSource from) {
    this._visitables.remove("from");
    if (from != null) {
        this.from = new ExternalNetworkSourceBuilder(from);
        this._visitables.get("from").add(this.from);
    } else {
        this.from = null;
        this._visitables.get("from").remove(this.from);
    }
    return (A) this;
  }
  
  public FromNested<A> withNewFrom() {
    return new FromNested(null);
  }
  
  public FromNested<A> withNewFromLike(ExternalNetworkSource item) {
    return new FromNested(item);
  }
  
  public NextHopsNested<A> withNewNextHops() {
    return new NextHopsNested(null);
  }
  
  public NextHopsNested<A> withNewNextHopsLike(ExternalNextHops item) {
    return new NextHopsNested(item);
  }
  
  public A withNextHops(ExternalNextHops nextHops) {
    this._visitables.remove("nextHops");
    if (nextHops != null) {
        this.nextHops = new ExternalNextHopsBuilder(nextHops);
        this._visitables.get("nextHops").add(this.nextHops);
    } else {
        this.nextHops = null;
        this._visitables.get("nextHops").remove(this.nextHops);
    }
    return (A) this;
  }
  public class FromNested<N> extends ExternalNetworkSourceFluent<FromNested<N>> implements Nested<N>{
  
    ExternalNetworkSourceBuilder builder;
  
    FromNested(ExternalNetworkSource item) {
      this.builder = new ExternalNetworkSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) AdminPolicyBasedExternalRouteSpecFluent.this.withFrom(builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class NextHopsNested<N> extends ExternalNextHopsFluent<NextHopsNested<N>> implements Nested<N>{
  
    ExternalNextHopsBuilder builder;
  
    NextHopsNested(ExternalNextHops item) {
      this.builder = new ExternalNextHopsBuilder(this, item);
    }
  
    public N and() {
      return (N) AdminPolicyBasedExternalRouteSpecFluent.this.withNextHops(builder.build());
    }
    
    public N endNextHops() {
      return and();
    }
    
  }
}