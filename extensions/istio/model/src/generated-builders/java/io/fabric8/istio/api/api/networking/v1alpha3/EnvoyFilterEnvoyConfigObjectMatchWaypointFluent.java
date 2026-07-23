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
public class EnvoyFilterEnvoyConfigObjectMatchWaypointFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchWaypointFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EnvoyFilterWaypointMatchBuilder waypoint;

  public EnvoyFilterEnvoyConfigObjectMatchWaypointFluent() {
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchWaypointFluent(EnvoyFilterEnvoyConfigObjectMatchWaypoint instance) {
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
  
  public EnvoyFilterWaypointMatch buildWaypoint() {
    return this.waypoint != null ? this.waypoint.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterEnvoyConfigObjectMatchWaypoint instance) {
    instance = instance != null ? instance : new EnvoyFilterEnvoyConfigObjectMatchWaypoint();
    if (instance != null) {
        this.withWaypoint(instance.getWaypoint());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public WaypointNested<A> editOrNewWaypoint() {
    return this.withNewWaypointLike(Optional.ofNullable(this.buildWaypoint()).orElse(new EnvoyFilterWaypointMatchBuilder().build()));
  }
  
  public WaypointNested<A> editOrNewWaypointLike(EnvoyFilterWaypointMatch item) {
    return this.withNewWaypointLike(Optional.ofNullable(this.buildWaypoint()).orElse(item));
  }
  
  public WaypointNested<A> editWaypoint() {
    return this.withNewWaypointLike(Optional.ofNullable(this.buildWaypoint()).orElse(null));
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
    EnvoyFilterEnvoyConfigObjectMatchWaypointFluent that = (EnvoyFilterEnvoyConfigObjectMatchWaypointFluent) o;
    if (!(Objects.equals(waypoint, that.waypoint))) {
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
  
  public boolean hasWaypoint() {
    return this.waypoint != null;
  }
  
  public int hashCode() {
    return Objects.hash(waypoint, additionalProperties);
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
    if (!(waypoint == null)) {
        sb.append("waypoint:");
        sb.append(waypoint);
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
  
  public WaypointNested<A> withNewWaypoint() {
    return new WaypointNested(null);
  }
  
  public WaypointNested<A> withNewWaypointLike(EnvoyFilterWaypointMatch item) {
    return new WaypointNested(item);
  }
  
  public A withWaypoint(EnvoyFilterWaypointMatch waypoint) {
    this._visitables.remove("waypoint");
    if (waypoint != null) {
        this.waypoint = new EnvoyFilterWaypointMatchBuilder(waypoint);
        this._visitables.get("waypoint").add(this.waypoint);
    } else {
        this.waypoint = null;
        this._visitables.get("waypoint").remove(this.waypoint);
    }
    return (A) this;
  }
  public class WaypointNested<N> extends EnvoyFilterWaypointMatchFluent<WaypointNested<N>> implements Nested<N>{
  
    EnvoyFilterWaypointMatchBuilder builder;
  
    WaypointNested(EnvoyFilterWaypointMatch item) {
      this.builder = new EnvoyFilterWaypointMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectMatchWaypointFluent.this.withWaypoint(builder.build());
    }
    
    public N endWaypoint() {
      return and();
    }
    
  }
}