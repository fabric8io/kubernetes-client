package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class EnvoyFilterWaypointMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterWaypointMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EnvoyFilterWaypointMatchFilterMatchBuilder filter;
  private Long portNumber;
  private EnvoyFilterWaypointMatchRouteMatchBuilder route;

  public EnvoyFilterWaypointMatchFluent() {
  }
  
  public EnvoyFilterWaypointMatchFluent(EnvoyFilterWaypointMatch instance) {
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
  
  public EnvoyFilterWaypointMatchFilterMatch buildFilter() {
    return this.filter != null ? this.filter.build() : null;
  }
  
  public EnvoyFilterWaypointMatchRouteMatch buildRoute() {
    return this.route != null ? this.route.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterWaypointMatch instance) {
    instance = instance != null ? instance : new EnvoyFilterWaypointMatch();
    if (instance != null) {
        this.withFilter(instance.getFilter());
        this.withPortNumber(instance.getPortNumber());
        this.withRoute(instance.getRoute());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FilterNested<A> editFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(null));
  }
  
  public FilterNested<A> editOrNewFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(new EnvoyFilterWaypointMatchFilterMatchBuilder().build()));
  }
  
  public FilterNested<A> editOrNewFilterLike(EnvoyFilterWaypointMatchFilterMatch item) {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(item));
  }
  
  public RouteNested<A> editOrNewRoute() {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(new EnvoyFilterWaypointMatchRouteMatchBuilder().build()));
  }
  
  public RouteNested<A> editOrNewRouteLike(EnvoyFilterWaypointMatchRouteMatch item) {
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
    EnvoyFilterWaypointMatchFluent that = (EnvoyFilterWaypointMatchFluent) o;
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(portNumber, that.portNumber))) {
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
  
  public Long getPortNumber() {
    return this.portNumber;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasPortNumber() {
    return this.portNumber != null;
  }
  
  public boolean hasRoute() {
    return this.route != null;
  }
  
  public int hashCode() {
    return Objects.hash(filter, portNumber, route, additionalProperties);
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
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(portNumber == null)) {
        sb.append("portNumber:");
        sb.append(portNumber);
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
  
  public A withFilter(EnvoyFilterWaypointMatchFilterMatch filter) {
    this._visitables.remove("filter");
    if (filter != null) {
        this.filter = new EnvoyFilterWaypointMatchFilterMatchBuilder(filter);
        this._visitables.get("filter").add(this.filter);
    } else {
        this.filter = null;
        this._visitables.get("filter").remove(this.filter);
    }
    return (A) this;
  }
  
  public FilterNested<A> withNewFilter() {
    return new FilterNested(null);
  }
  
  public FilterNested<A> withNewFilterLike(EnvoyFilterWaypointMatchFilterMatch item) {
    return new FilterNested(item);
  }
  
  public RouteNested<A> withNewRoute() {
    return new RouteNested(null);
  }
  
  public A withNewRoute(String name) {
    return (A) this.withRoute(new EnvoyFilterWaypointMatchRouteMatch(name));
  }
  
  public RouteNested<A> withNewRouteLike(EnvoyFilterWaypointMatchRouteMatch item) {
    return new RouteNested(item);
  }
  
  public A withPortNumber(Long portNumber) {
    this.portNumber = portNumber;
    return (A) this;
  }
  
  public A withRoute(EnvoyFilterWaypointMatchRouteMatch route) {
    this._visitables.remove("route");
    if (route != null) {
        this.route = new EnvoyFilterWaypointMatchRouteMatchBuilder(route);
        this._visitables.get("route").add(this.route);
    } else {
        this.route = null;
        this._visitables.get("route").remove(this.route);
    }
    return (A) this;
  }
  public class FilterNested<N> extends EnvoyFilterWaypointMatchFilterMatchFluent<FilterNested<N>> implements Nested<N>{
  
    EnvoyFilterWaypointMatchFilterMatchBuilder builder;
  
    FilterNested(EnvoyFilterWaypointMatchFilterMatch item) {
      this.builder = new EnvoyFilterWaypointMatchFilterMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterWaypointMatchFluent.this.withFilter(builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class RouteNested<N> extends EnvoyFilterWaypointMatchRouteMatchFluent<RouteNested<N>> implements Nested<N>{
  
    EnvoyFilterWaypointMatchRouteMatchBuilder builder;
  
    RouteNested(EnvoyFilterWaypointMatchRouteMatch item) {
      this.builder = new EnvoyFilterWaypointMatchRouteMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterWaypointMatchFluent.this.withRoute(builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
}