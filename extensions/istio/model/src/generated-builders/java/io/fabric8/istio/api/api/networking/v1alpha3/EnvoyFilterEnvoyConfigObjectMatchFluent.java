package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
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
public class EnvoyFilterEnvoyConfigObjectMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EnvoyFilterPatchContext context;
  private VisitableBuilder<? extends IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes,?> objectTypes;
  private EnvoyFilterProxyMatchBuilder proxy;

  public EnvoyFilterEnvoyConfigObjectMatchFluent() {
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchFluent(EnvoyFilterEnvoyConfigObjectMatch instance) {
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
  
  public IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes buildObjectTypes() {
    return this.objectTypes != null ? this.objectTypes.build() : null;
  }
  
  public EnvoyFilterProxyMatch buildProxy() {
    return this.proxy != null ? this.proxy.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "EnvoyFilterEnvoyConfigObjectMatchCluster":
    
          return (VisitableBuilder<T,?>) new EnvoyFilterEnvoyConfigObjectMatchClusterBuilder((EnvoyFilterEnvoyConfigObjectMatchCluster) item);
    
      case "EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration":
    
          return (VisitableBuilder<T,?>) new EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder((EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration) item);
    
      case "EnvoyFilterEnvoyConfigObjectMatchWaypoint":
    
          return (VisitableBuilder<T,?>) new EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder((EnvoyFilterEnvoyConfigObjectMatchWaypoint) item);
    
      case "EnvoyFilterEnvoyConfigObjectMatchListener":
    
          return (VisitableBuilder<T,?>) new EnvoyFilterEnvoyConfigObjectMatchListenerBuilder((EnvoyFilterEnvoyConfigObjectMatchListener) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(EnvoyFilterEnvoyConfigObjectMatch instance) {
    instance = instance != null ? instance : new EnvoyFilterEnvoyConfigObjectMatch();
    if (instance != null) {
        this.withObjectTypes(instance.getObjectTypes());
        this.withContext(instance.getContext());
        this.withProxy(instance.getProxy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ProxyNested<A> editOrNewProxy() {
    return this.withNewProxyLike(Optional.ofNullable(this.buildProxy()).orElse(new EnvoyFilterProxyMatchBuilder().build()));
  }
  
  public ProxyNested<A> editOrNewProxyLike(EnvoyFilterProxyMatch item) {
    return this.withNewProxyLike(Optional.ofNullable(this.buildProxy()).orElse(item));
  }
  
  public ProxyNested<A> editProxy() {
    return this.withNewProxyLike(Optional.ofNullable(this.buildProxy()).orElse(null));
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
    EnvoyFilterEnvoyConfigObjectMatchFluent that = (EnvoyFilterEnvoyConfigObjectMatchFluent) o;
    if (!(Objects.equals(objectTypes, that.objectTypes))) {
      return false;
    }
    if (!(Objects.equals(context, that.context))) {
      return false;
    }
    if (!(Objects.equals(proxy, that.proxy))) {
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
  
  public EnvoyFilterPatchContext getContext() {
    return this.context;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContext() {
    return this.context != null;
  }
  
  public boolean hasObjectTypes() {
    return this.objectTypes != null;
  }
  
  public boolean hasProxy() {
    return this.proxy != null;
  }
  
  public int hashCode() {
    return Objects.hash(objectTypes, context, proxy, additionalProperties);
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
    if (!(objectTypes == null)) {
        sb.append("objectTypes:");
        sb.append(objectTypes);
        sb.append(",");
    }
    if (!(context == null)) {
        sb.append("context:");
        sb.append(context);
        sb.append(",");
    }
    if (!(proxy == null)) {
        sb.append("proxy:");
        sb.append(proxy);
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
  
  public A withContext(EnvoyFilterPatchContext context) {
    this.context = context;
    return (A) this;
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchClusterTypesNested<A> withNewEnvoyFilterEnvoyConfigObjectMatchClusterTypes() {
    return new EnvoyFilterEnvoyConfigObjectMatchClusterTypesNested(null);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchClusterTypesNested<A> withNewEnvoyFilterEnvoyConfigObjectMatchClusterTypesLike(EnvoyFilterEnvoyConfigObjectMatchCluster item) {
    return new EnvoyFilterEnvoyConfigObjectMatchClusterTypesNested(item);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchListenerTypesNested<A> withNewEnvoyFilterEnvoyConfigObjectMatchListenerTypes() {
    return new EnvoyFilterEnvoyConfigObjectMatchListenerTypesNested(null);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchListenerTypesNested<A> withNewEnvoyFilterEnvoyConfigObjectMatchListenerTypesLike(EnvoyFilterEnvoyConfigObjectMatchListener item) {
    return new EnvoyFilterEnvoyConfigObjectMatchListenerTypesNested(item);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypesNested<A> withNewEnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypes() {
    return new EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypesNested(null);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypesNested<A> withNewEnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypesLike(EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration item) {
    return new EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypesNested(item);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchWaypointTypesNested<A> withNewEnvoyFilterEnvoyConfigObjectMatchWaypointTypes() {
    return new EnvoyFilterEnvoyConfigObjectMatchWaypointTypesNested(null);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchWaypointTypesNested<A> withNewEnvoyFilterEnvoyConfigObjectMatchWaypointTypesLike(EnvoyFilterEnvoyConfigObjectMatchWaypoint item) {
    return new EnvoyFilterEnvoyConfigObjectMatchWaypointTypesNested(item);
  }
  
  public ProxyNested<A> withNewProxy() {
    return new ProxyNested(null);
  }
  
  public ProxyNested<A> withNewProxyLike(EnvoyFilterProxyMatch item) {
    return new ProxyNested(item);
  }
  
  public A withObjectTypes(IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes objectTypes) {
    if (objectTypes == null) {
        this.objectTypes = null;
        this._visitables.remove("objectTypes");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes,?> builder = builder(objectTypes);
        this._visitables.get("objectTypes").clear();
        this._visitables.get("objectTypes").add(builder);
        this.objectTypes = builder;
        return (A) this;
    }
  }
  
  public A withProxy(EnvoyFilterProxyMatch proxy) {
    this._visitables.remove("proxy");
    if (proxy != null) {
        this.proxy = new EnvoyFilterProxyMatchBuilder(proxy);
        this._visitables.get("proxy").add(this.proxy);
    } else {
        this.proxy = null;
        this._visitables.get("proxy").remove(this.proxy);
    }
    return (A) this;
  }
  public class EnvoyFilterEnvoyConfigObjectMatchClusterTypesNested<N> extends EnvoyFilterEnvoyConfigObjectMatchClusterFluent<EnvoyFilterEnvoyConfigObjectMatchClusterTypesNested<N>> implements Nested<N>{
  
    EnvoyFilterEnvoyConfigObjectMatchClusterBuilder builder;
  
    EnvoyFilterEnvoyConfigObjectMatchClusterTypesNested(EnvoyFilterEnvoyConfigObjectMatchCluster item) {
      this.builder = new EnvoyFilterEnvoyConfigObjectMatchClusterBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectMatchFluent.this.withObjectTypes(builder.build());
    }
    
    public N endEnvoyFilterEnvoyConfigObjectMatchClusterTypes() {
      return and();
    }
    
  }
  public class EnvoyFilterEnvoyConfigObjectMatchListenerTypesNested<N> extends EnvoyFilterEnvoyConfigObjectMatchListenerFluent<EnvoyFilterEnvoyConfigObjectMatchListenerTypesNested<N>> implements Nested<N>{
  
    EnvoyFilterEnvoyConfigObjectMatchListenerBuilder builder;
  
    EnvoyFilterEnvoyConfigObjectMatchListenerTypesNested(EnvoyFilterEnvoyConfigObjectMatchListener item) {
      this.builder = new EnvoyFilterEnvoyConfigObjectMatchListenerBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectMatchFluent.this.withObjectTypes(builder.build());
    }
    
    public N endEnvoyFilterEnvoyConfigObjectMatchListenerTypes() {
      return and();
    }
    
  }
  public class EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypesNested<N> extends EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent<EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypesNested<N>> implements Nested<N>{
  
    EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder builder;
  
    EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypesNested(EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration item) {
      this.builder = new EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectMatchFluent.this.withObjectTypes(builder.build());
    }
    
    public N endEnvoyFilterEnvoyConfigObjectMatchRouteConfigurationTypes() {
      return and();
    }
    
  }
  public class EnvoyFilterEnvoyConfigObjectMatchWaypointTypesNested<N> extends EnvoyFilterEnvoyConfigObjectMatchWaypointFluent<EnvoyFilterEnvoyConfigObjectMatchWaypointTypesNested<N>> implements Nested<N>{
  
    EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder builder;
  
    EnvoyFilterEnvoyConfigObjectMatchWaypointTypesNested(EnvoyFilterEnvoyConfigObjectMatchWaypoint item) {
      this.builder = new EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectMatchFluent.this.withObjectTypes(builder.build());
    }
    
    public N endEnvoyFilterEnvoyConfigObjectMatchWaypointTypes() {
      return and();
    }
    
  }
  public class ProxyNested<N> extends EnvoyFilterProxyMatchFluent<ProxyNested<N>> implements Nested<N>{
  
    EnvoyFilterProxyMatchBuilder builder;
  
    ProxyNested(EnvoyFilterProxyMatch item) {
      this.builder = new EnvoyFilterProxyMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectMatchFluent.this.withProxy(builder.build());
    }
    
    public N endProxy() {
      return and();
    }
    
  }
}