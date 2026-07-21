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
public class EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String domainName;
  private String name;
  private EnvoyFilterRouteConfigurationMatchRouteMatchBuilder route;

  public EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent() {
  }
  
  public EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent(EnvoyFilterRouteConfigurationMatchVirtualHostMatch instance) {
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
  
  public EnvoyFilterRouteConfigurationMatchRouteMatch buildRoute() {
    return this.route != null ? this.route.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterRouteConfigurationMatchVirtualHostMatch instance) {
    instance = instance != null ? instance : new EnvoyFilterRouteConfigurationMatchVirtualHostMatch();
    if (instance != null) {
        this.withDomainName(instance.getDomainName());
        this.withName(instance.getName());
        this.withRoute(instance.getRoute());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RouteNested<A> editOrNewRoute() {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(new EnvoyFilterRouteConfigurationMatchRouteMatchBuilder().build()));
  }
  
  public RouteNested<A> editOrNewRouteLike(EnvoyFilterRouteConfigurationMatchRouteMatch item) {
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
    EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent that = (EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent) o;
    if (!(Objects.equals(domainName, that.domainName))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(route, that.route))) {
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
  
  public String getDomainName() {
    return this.domainName;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDomainName() {
    return this.domainName != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRoute() {
    return this.route != null;
  }
  
  public int hashCode() {
    return Objects.hash(domainName, name, route, additionalProperties);
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
    if (!(domainName == null)) {
        sb.append("domainName:");
        sb.append(domainName);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(route == null)) {
        sb.append("route:");
        sb.append(route);
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
  
  public A withDomainName(String domainName) {
    this.domainName = domainName;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public RouteNested<A> withNewRoute() {
    return new RouteNested(null);
  }
  
  public RouteNested<A> withNewRouteLike(EnvoyFilterRouteConfigurationMatchRouteMatch item) {
    return new RouteNested(item);
  }
  
  public A withRoute(EnvoyFilterRouteConfigurationMatchRouteMatch route) {
    this._visitables.remove("route");
    if (route != null) {
        this.route = new EnvoyFilterRouteConfigurationMatchRouteMatchBuilder(route);
        this._visitables.get("route").add(this.route);
    } else {
        this.route = null;
        this._visitables.get("route").remove(this.route);
    }
    return (A) this;
  }
  public class RouteNested<N> extends EnvoyFilterRouteConfigurationMatchRouteMatchFluent<RouteNested<N>> implements Nested<N>{
  
    EnvoyFilterRouteConfigurationMatchRouteMatchBuilder builder;
  
    RouteNested(EnvoyFilterRouteConfigurationMatchRouteMatch item) {
      this.builder = new EnvoyFilterRouteConfigurationMatchRouteMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent.this.withRoute(builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
}