package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class NetworkDataRoutev6Fluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkDataRoutev6Fluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NetworkGatewayv6Builder gateway;
  private String network;
  private Integer prefix;
  private NetworkDataServicev6Builder services;

  public NetworkDataRoutev6Fluent() {
  }
  
  public NetworkDataRoutev6Fluent(NetworkDataRoutev6 instance) {
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
  
  public NetworkGatewayv6 buildGateway() {
    return this.gateway != null ? this.gateway.build() : null;
  }
  
  public NetworkDataServicev6 buildServices() {
    return this.services != null ? this.services.build() : null;
  }
  
  protected void copyInstance(NetworkDataRoutev6 instance) {
    instance = instance != null ? instance : new NetworkDataRoutev6();
    if (instance != null) {
        this.withGateway(instance.getGateway());
        this.withNetwork(instance.getNetwork());
        this.withPrefix(instance.getPrefix());
        this.withServices(instance.getServices());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GatewayNested<A> editGateway() {
    return this.withNewGatewayLike(Optional.ofNullable(this.buildGateway()).orElse(null));
  }
  
  public GatewayNested<A> editOrNewGateway() {
    return this.withNewGatewayLike(Optional.ofNullable(this.buildGateway()).orElse(new NetworkGatewayv6Builder().build()));
  }
  
  public GatewayNested<A> editOrNewGatewayLike(NetworkGatewayv6 item) {
    return this.withNewGatewayLike(Optional.ofNullable(this.buildGateway()).orElse(item));
  }
  
  public ServicesNested<A> editOrNewServices() {
    return this.withNewServicesLike(Optional.ofNullable(this.buildServices()).orElse(new NetworkDataServicev6Builder().build()));
  }
  
  public ServicesNested<A> editOrNewServicesLike(NetworkDataServicev6 item) {
    return this.withNewServicesLike(Optional.ofNullable(this.buildServices()).orElse(item));
  }
  
  public ServicesNested<A> editServices() {
    return this.withNewServicesLike(Optional.ofNullable(this.buildServices()).orElse(null));
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
    NetworkDataRoutev6Fluent that = (NetworkDataRoutev6Fluent) o;
    if (!(Objects.equals(gateway, that.gateway))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(prefix, that.prefix))) {
      return false;
    }
    if (!(Objects.equals(services, that.services))) {
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
  
  public String getNetwork() {
    return this.network;
  }
  
  public Integer getPrefix() {
    return this.prefix;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGateway() {
    return this.gateway != null;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasPrefix() {
    return this.prefix != null;
  }
  
  public boolean hasServices() {
    return this.services != null;
  }
  
  public int hashCode() {
    return Objects.hash(gateway, network, prefix, services, additionalProperties);
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
    if (!(gateway == null)) {
        sb.append("gateway:");
        sb.append(gateway);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(prefix == null)) {
        sb.append("prefix:");
        sb.append(prefix);
        sb.append(",");
    }
    if (!(services == null)) {
        sb.append("services:");
        sb.append(services);
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
  
  public A withGateway(NetworkGatewayv6 gateway) {
    this._visitables.remove("gateway");
    if (gateway != null) {
        this.gateway = new NetworkGatewayv6Builder(gateway);
        this._visitables.get("gateway").add(this.gateway);
    } else {
        this.gateway = null;
        this._visitables.get("gateway").remove(this.gateway);
    }
    return (A) this;
  }
  
  public A withNetwork(String network) {
    this.network = network;
    return (A) this;
  }
  
  public GatewayNested<A> withNewGateway() {
    return new GatewayNested(null);
  }
  
  public GatewayNested<A> withNewGatewayLike(NetworkGatewayv6 item) {
    return new GatewayNested(item);
  }
  
  public ServicesNested<A> withNewServices() {
    return new ServicesNested(null);
  }
  
  public ServicesNested<A> withNewServicesLike(NetworkDataServicev6 item) {
    return new ServicesNested(item);
  }
  
  public A withPrefix(Integer prefix) {
    this.prefix = prefix;
    return (A) this;
  }
  
  public A withServices(NetworkDataServicev6 services) {
    this._visitables.remove("services");
    if (services != null) {
        this.services = new NetworkDataServicev6Builder(services);
        this._visitables.get("services").add(this.services);
    } else {
        this.services = null;
        this._visitables.get("services").remove(this.services);
    }
    return (A) this;
  }
  public class GatewayNested<N> extends NetworkGatewayv6Fluent<GatewayNested<N>> implements Nested<N>{
  
    NetworkGatewayv6Builder builder;
  
    GatewayNested(NetworkGatewayv6 item) {
      this.builder = new NetworkGatewayv6Builder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataRoutev6Fluent.this.withGateway(builder.build());
    }
    
    public N endGateway() {
      return and();
    }
    
  }
  public class ServicesNested<N> extends NetworkDataServicev6Fluent<ServicesNested<N>> implements Nested<N>{
  
    NetworkDataServicev6Builder builder;
  
    ServicesNested(NetworkDataServicev6 item) {
      this.builder = new NetworkDataServicev6Builder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataRoutev6Fluent.this.withServices(builder.build());
    }
    
    public N endServices() {
      return and();
    }
    
  }
}