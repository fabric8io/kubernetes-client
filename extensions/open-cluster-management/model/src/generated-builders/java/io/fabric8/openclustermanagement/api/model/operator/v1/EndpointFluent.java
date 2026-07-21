package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class EndpointFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.EndpointFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HostnameConfigBuilder hostname;
  private LoadBalancerConfigBuilder loadBalancer;
  private RouteConfigBuilder route;
  private String type;

  public EndpointFluent() {
  }
  
  public EndpointFluent(Endpoint instance) {
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
  
  public HostnameConfig buildHostname() {
    return this.hostname != null ? this.hostname.build() : null;
  }
  
  public LoadBalancerConfig buildLoadBalancer() {
    return this.loadBalancer != null ? this.loadBalancer.build() : null;
  }
  
  public RouteConfig buildRoute() {
    return this.route != null ? this.route.build() : null;
  }
  
  protected void copyInstance(Endpoint instance) {
    instance = instance != null ? instance : new Endpoint();
    if (instance != null) {
        this.withHostname(instance.getHostname());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withRoute(instance.getRoute());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HostnameNested<A> editHostname() {
    return this.withNewHostnameLike(Optional.ofNullable(this.buildHostname()).orElse(null));
  }
  
  public LoadBalancerNested<A> editLoadBalancer() {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(null));
  }
  
  public HostnameNested<A> editOrNewHostname() {
    return this.withNewHostnameLike(Optional.ofNullable(this.buildHostname()).orElse(new HostnameConfigBuilder().build()));
  }
  
  public HostnameNested<A> editOrNewHostnameLike(HostnameConfig item) {
    return this.withNewHostnameLike(Optional.ofNullable(this.buildHostname()).orElse(item));
  }
  
  public LoadBalancerNested<A> editOrNewLoadBalancer() {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(new LoadBalancerConfigBuilder().build()));
  }
  
  public LoadBalancerNested<A> editOrNewLoadBalancerLike(LoadBalancerConfig item) {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(item));
  }
  
  public RouteNested<A> editOrNewRoute() {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(new RouteConfigBuilder().build()));
  }
  
  public RouteNested<A> editOrNewRouteLike(RouteConfig item) {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(item));
  }
  
  public RouteNested<A> editRoute() {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(null));
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
    EndpointFluent that = (EndpointFluent) o;
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
      return false;
    }
    if (!(Objects.equals(route, that.route))) {
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
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasLoadBalancer() {
    return this.loadBalancer != null;
  }
  
  public boolean hasRoute() {
    return this.route != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostname, loadBalancer, route, type, additionalProperties);
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
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(loadBalancer == null)) {
        sb.append("loadBalancer:");
        sb.append(loadBalancer);
        sb.append(",");
    }
    if (!(route == null)) {
        sb.append("route:");
        sb.append(route);
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
  
  public A withHostname(HostnameConfig hostname) {
    this._visitables.remove("hostname");
    if (hostname != null) {
        this.hostname = new HostnameConfigBuilder(hostname);
        this._visitables.get("hostname").add(this.hostname);
    } else {
        this.hostname = null;
        this._visitables.get("hostname").remove(this.hostname);
    }
    return (A) this;
  }
  
  public A withLoadBalancer(LoadBalancerConfig loadBalancer) {
    this._visitables.remove("loadBalancer");
    if (loadBalancer != null) {
        this.loadBalancer = new LoadBalancerConfigBuilder(loadBalancer);
        this._visitables.get("loadBalancer").add(this.loadBalancer);
    } else {
        this.loadBalancer = null;
        this._visitables.get("loadBalancer").remove(this.loadBalancer);
    }
    return (A) this;
  }
  
  public HostnameNested<A> withNewHostname() {
    return new HostnameNested(null);
  }
  
  public A withNewHostname(String caBundle,String host) {
    return (A) this.withHostname(new HostnameConfig(caBundle, host));
  }
  
  public HostnameNested<A> withNewHostnameLike(HostnameConfig item) {
    return new HostnameNested(item);
  }
  
  public LoadBalancerNested<A> withNewLoadBalancer() {
    return new LoadBalancerNested(null);
  }
  
  public A withNewLoadBalancer(String caBundle,String host) {
    return (A) this.withLoadBalancer(new LoadBalancerConfig(caBundle, host));
  }
  
  public LoadBalancerNested<A> withNewLoadBalancerLike(LoadBalancerConfig item) {
    return new LoadBalancerNested(item);
  }
  
  public RouteNested<A> withNewRoute() {
    return new RouteNested(null);
  }
  
  public A withNewRoute(String caBundle,String host) {
    return (A) this.withRoute(new RouteConfig(caBundle, host));
  }
  
  public RouteNested<A> withNewRouteLike(RouteConfig item) {
    return new RouteNested(item);
  }
  
  public A withRoute(RouteConfig route) {
    this._visitables.remove("route");
    if (route != null) {
        this.route = new RouteConfigBuilder(route);
        this._visitables.get("route").add(this.route);
    } else {
        this.route = null;
        this._visitables.get("route").remove(this.route);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class HostnameNested<N> extends HostnameConfigFluent<HostnameNested<N>> implements Nested<N>{
  
    HostnameConfigBuilder builder;
  
    HostnameNested(HostnameConfig item) {
      this.builder = new HostnameConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withHostname(builder.build());
    }
    
    public N endHostname() {
      return and();
    }
    
  }
  public class LoadBalancerNested<N> extends LoadBalancerConfigFluent<LoadBalancerNested<N>> implements Nested<N>{
  
    LoadBalancerConfigBuilder builder;
  
    LoadBalancerNested(LoadBalancerConfig item) {
      this.builder = new LoadBalancerConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withLoadBalancer(builder.build());
    }
    
    public N endLoadBalancer() {
      return and();
    }
    
  }
  public class RouteNested<N> extends RouteConfigFluent<RouteNested<N>> implements Nested<N>{
  
    RouteConfigBuilder builder;
  
    RouteNested(RouteConfig item) {
      this.builder = new RouteConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withRoute(builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
}