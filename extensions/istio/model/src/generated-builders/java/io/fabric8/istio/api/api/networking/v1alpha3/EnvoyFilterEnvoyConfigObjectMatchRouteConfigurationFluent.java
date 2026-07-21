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
public class EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EnvoyFilterRouteConfigurationMatchBuilder routeConfiguration;

  public EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent() {
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent(EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration instance) {
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
  
  public EnvoyFilterRouteConfigurationMatch buildRouteConfiguration() {
    return this.routeConfiguration != null ? this.routeConfiguration.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration instance) {
    instance = instance != null ? instance : new EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration();
    if (instance != null) {
        this.withRouteConfiguration(instance.getRouteConfiguration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RouteConfigurationNested<A> editOrNewRouteConfiguration() {
    return this.withNewRouteConfigurationLike(Optional.ofNullable(this.buildRouteConfiguration()).orElse(new EnvoyFilterRouteConfigurationMatchBuilder().build()));
  }
  
  public RouteConfigurationNested<A> editOrNewRouteConfigurationLike(EnvoyFilterRouteConfigurationMatch item) {
    return this.withNewRouteConfigurationLike(Optional.ofNullable(this.buildRouteConfiguration()).orElse(item));
  }
  
  public RouteConfigurationNested<A> editRouteConfiguration() {
    return this.withNewRouteConfigurationLike(Optional.ofNullable(this.buildRouteConfiguration()).orElse(null));
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
    EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent that = (EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent) o;
    if (!(Objects.equals(routeConfiguration, that.routeConfiguration))) {
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
  
  public boolean hasRouteConfiguration() {
    return this.routeConfiguration != null;
  }
  
  public int hashCode() {
    return Objects.hash(routeConfiguration, additionalProperties);
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
    if (!(routeConfiguration == null)) {
        sb.append("routeConfiguration:");
        sb.append(routeConfiguration);
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
  
  public RouteConfigurationNested<A> withNewRouteConfiguration() {
    return new RouteConfigurationNested(null);
  }
  
  public RouteConfigurationNested<A> withNewRouteConfigurationLike(EnvoyFilterRouteConfigurationMatch item) {
    return new RouteConfigurationNested(item);
  }
  
  public A withRouteConfiguration(EnvoyFilterRouteConfigurationMatch routeConfiguration) {
    this._visitables.remove("routeConfiguration");
    if (routeConfiguration != null) {
        this.routeConfiguration = new EnvoyFilterRouteConfigurationMatchBuilder(routeConfiguration);
        this._visitables.get("routeConfiguration").add(this.routeConfiguration);
    } else {
        this.routeConfiguration = null;
        this._visitables.get("routeConfiguration").remove(this.routeConfiguration);
    }
    return (A) this;
  }
  public class RouteConfigurationNested<N> extends EnvoyFilterRouteConfigurationMatchFluent<RouteConfigurationNested<N>> implements Nested<N>{
  
    EnvoyFilterRouteConfigurationMatchBuilder builder;
  
    RouteConfigurationNested(EnvoyFilterRouteConfigurationMatch item) {
      this.builder = new EnvoyFilterRouteConfigurationMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent.this.withRouteConfiguration(builder.build());
    }
    
    public N endRouteConfiguration() {
      return and();
    }
    
  }
}