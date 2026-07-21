package io.fabric8.certmanager.api.model.acme.v1;

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
public class ACMEChallengeSolverHTTP01Fluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01Fluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder gatewayHTTPRoute;
  private ACMEChallengeSolverHTTP01IngressBuilder ingress;

  public ACMEChallengeSolverHTTP01Fluent() {
  }
  
  public ACMEChallengeSolverHTTP01Fluent(ACMEChallengeSolverHTTP01 instance) {
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
  
  public ACMEChallengeSolverHTTP01GatewayHTTPRoute buildGatewayHTTPRoute() {
    return this.gatewayHTTPRoute != null ? this.gatewayHTTPRoute.build() : null;
  }
  
  public ACMEChallengeSolverHTTP01Ingress buildIngress() {
    return this.ingress != null ? this.ingress.build() : null;
  }
  
  protected void copyInstance(ACMEChallengeSolverHTTP01 instance) {
    instance = instance != null ? instance : new ACMEChallengeSolverHTTP01();
    if (instance != null) {
        this.withGatewayHTTPRoute(instance.getGatewayHTTPRoute());
        this.withIngress(instance.getIngress());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GatewayHTTPRouteNested<A> editGatewayHTTPRoute() {
    return this.withNewGatewayHTTPRouteLike(Optional.ofNullable(this.buildGatewayHTTPRoute()).orElse(null));
  }
  
  public IngressNested<A> editIngress() {
    return this.withNewIngressLike(Optional.ofNullable(this.buildIngress()).orElse(null));
  }
  
  public GatewayHTTPRouteNested<A> editOrNewGatewayHTTPRoute() {
    return this.withNewGatewayHTTPRouteLike(Optional.ofNullable(this.buildGatewayHTTPRoute()).orElse(new ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder().build()));
  }
  
  public GatewayHTTPRouteNested<A> editOrNewGatewayHTTPRouteLike(ACMEChallengeSolverHTTP01GatewayHTTPRoute item) {
    return this.withNewGatewayHTTPRouteLike(Optional.ofNullable(this.buildGatewayHTTPRoute()).orElse(item));
  }
  
  public IngressNested<A> editOrNewIngress() {
    return this.withNewIngressLike(Optional.ofNullable(this.buildIngress()).orElse(new ACMEChallengeSolverHTTP01IngressBuilder().build()));
  }
  
  public IngressNested<A> editOrNewIngressLike(ACMEChallengeSolverHTTP01Ingress item) {
    return this.withNewIngressLike(Optional.ofNullable(this.buildIngress()).orElse(item));
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
    ACMEChallengeSolverHTTP01Fluent that = (ACMEChallengeSolverHTTP01Fluent) o;
    if (!(Objects.equals(gatewayHTTPRoute, that.gatewayHTTPRoute))) {
      return false;
    }
    if (!(Objects.equals(ingress, that.ingress))) {
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
  
  public boolean hasGatewayHTTPRoute() {
    return this.gatewayHTTPRoute != null;
  }
  
  public boolean hasIngress() {
    return this.ingress != null;
  }
  
  public int hashCode() {
    return Objects.hash(gatewayHTTPRoute, ingress, additionalProperties);
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
    if (!(gatewayHTTPRoute == null)) {
        sb.append("gatewayHTTPRoute:");
        sb.append(gatewayHTTPRoute);
        sb.append(",");
    }
    if (!(ingress == null)) {
        sb.append("ingress:");
        sb.append(ingress);
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
  
  public A withGatewayHTTPRoute(ACMEChallengeSolverHTTP01GatewayHTTPRoute gatewayHTTPRoute) {
    this._visitables.remove("gatewayHTTPRoute");
    if (gatewayHTTPRoute != null) {
        this.gatewayHTTPRoute = new ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder(gatewayHTTPRoute);
        this._visitables.get("gatewayHTTPRoute").add(this.gatewayHTTPRoute);
    } else {
        this.gatewayHTTPRoute = null;
        this._visitables.get("gatewayHTTPRoute").remove(this.gatewayHTTPRoute);
    }
    return (A) this;
  }
  
  public A withIngress(ACMEChallengeSolverHTTP01Ingress ingress) {
    this._visitables.remove("ingress");
    if (ingress != null) {
        this.ingress = new ACMEChallengeSolverHTTP01IngressBuilder(ingress);
        this._visitables.get("ingress").add(this.ingress);
    } else {
        this.ingress = null;
        this._visitables.get("ingress").remove(this.ingress);
    }
    return (A) this;
  }
  
  public GatewayHTTPRouteNested<A> withNewGatewayHTTPRoute() {
    return new GatewayHTTPRouteNested(null);
  }
  
  public GatewayHTTPRouteNested<A> withNewGatewayHTTPRouteLike(ACMEChallengeSolverHTTP01GatewayHTTPRoute item) {
    return new GatewayHTTPRouteNested(item);
  }
  
  public IngressNested<A> withNewIngress() {
    return new IngressNested(null);
  }
  
  public IngressNested<A> withNewIngressLike(ACMEChallengeSolverHTTP01Ingress item) {
    return new IngressNested(item);
  }
  public class GatewayHTTPRouteNested<N> extends ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent<GatewayHTTPRouteNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder builder;
  
    GatewayHTTPRouteNested(ACMEChallengeSolverHTTP01GatewayHTTPRoute item) {
      this.builder = new ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01Fluent.this.withGatewayHTTPRoute(builder.build());
    }
    
    public N endGatewayHTTPRoute() {
      return and();
    }
    
  }
  public class IngressNested<N> extends ACMEChallengeSolverHTTP01IngressFluent<IngressNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01IngressBuilder builder;
  
    IngressNested(ACMEChallengeSolverHTTP01Ingress item) {
      this.builder = new ACMEChallengeSolverHTTP01IngressBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01Fluent.this.withIngress(builder.build());
    }
    
    public N endIngress() {
      return and();
    }
    
  }
}