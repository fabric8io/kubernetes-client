package io.fabric8.openshift.api.model.config.v1;

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
public class NutanixPrismElementEndpointFluent<A extends io.fabric8.openshift.api.model.config.v1.NutanixPrismElementEndpointFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NutanixPrismEndpointBuilder endpoint;
  private String name;

  public NutanixPrismElementEndpointFluent() {
  }
  
  public NutanixPrismElementEndpointFluent(NutanixPrismElementEndpoint instance) {
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
  
  public NutanixPrismEndpoint buildEndpoint() {
    return this.endpoint != null ? this.endpoint.build() : null;
  }
  
  protected void copyInstance(NutanixPrismElementEndpoint instance) {
    instance = instance != null ? instance : new NutanixPrismElementEndpoint();
    if (instance != null) {
        this.withEndpoint(instance.getEndpoint());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EndpointNested<A> editEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(null));
  }
  
  public EndpointNested<A> editOrNewEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(new NutanixPrismEndpointBuilder().build()));
  }
  
  public EndpointNested<A> editOrNewEndpointLike(NutanixPrismEndpoint item) {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(item));
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
    NutanixPrismElementEndpointFluent that = (NutanixPrismElementEndpointFluent) o;
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(endpoint, name, additionalProperties);
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
    if (!(endpoint == null)) {
        sb.append("endpoint:");
        sb.append(endpoint);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withEndpoint(NutanixPrismEndpoint endpoint) {
    this._visitables.remove("endpoint");
    if (endpoint != null) {
        this.endpoint = new NutanixPrismEndpointBuilder(endpoint);
        this._visitables.get("endpoint").add(this.endpoint);
    } else {
        this.endpoint = null;
        this._visitables.get("endpoint").remove(this.endpoint);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public EndpointNested<A> withNewEndpoint() {
    return new EndpointNested(null);
  }
  
  public A withNewEndpoint(String address,Integer port) {
    return (A) this.withEndpoint(new NutanixPrismEndpoint(address, port));
  }
  
  public EndpointNested<A> withNewEndpointLike(NutanixPrismEndpoint item) {
    return new EndpointNested(item);
  }
  public class EndpointNested<N> extends NutanixPrismEndpointFluent<EndpointNested<N>> implements Nested<N>{
  
    NutanixPrismEndpointBuilder builder;
  
    EndpointNested(NutanixPrismEndpoint item) {
      this.builder = new NutanixPrismEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixPrismElementEndpointFluent.this.withEndpoint(builder.build());
    }
    
    public N endEndpoint() {
      return and();
    }
    
  }
}