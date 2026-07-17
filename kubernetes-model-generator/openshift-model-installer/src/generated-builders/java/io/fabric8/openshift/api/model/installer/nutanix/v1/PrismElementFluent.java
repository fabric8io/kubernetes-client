package io.fabric8.openshift.api.model.installer.nutanix.v1;

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
public class PrismElementFluent<A extends io.fabric8.openshift.api.model.installer.nutanix.v1.PrismElementFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PrismEndpointBuilder endpoint;
  private String name;
  private String uuid;

  public PrismElementFluent() {
  }
  
  public PrismElementFluent(PrismElement instance) {
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
  
  public PrismEndpoint buildEndpoint() {
    return this.endpoint != null ? this.endpoint.build() : null;
  }
  
  protected void copyInstance(PrismElement instance) {
    instance = instance != null ? instance : new PrismElement();
    if (instance != null) {
        this.withEndpoint(instance.getEndpoint());
        this.withName(instance.getName());
        this.withUuid(instance.getUuid());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EndpointNested<A> editEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(null));
  }
  
  public EndpointNested<A> editOrNewEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(new PrismEndpointBuilder().build()));
  }
  
  public EndpointNested<A> editOrNewEndpointLike(PrismEndpoint item) {
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
    PrismElementFluent that = (PrismElementFluent) o;
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(uuid, that.uuid))) {
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
  
  public String getUuid() {
    return this.uuid;
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
  
  public boolean hasUuid() {
    return this.uuid != null;
  }
  
  public int hashCode() {
    return Objects.hash(endpoint, name, uuid, additionalProperties);
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
    if (!(uuid == null)) {
        sb.append("uuid:");
        sb.append(uuid);
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
  
  public A withEndpoint(PrismEndpoint endpoint) {
    this._visitables.remove("endpoint");
    if (endpoint != null) {
        this.endpoint = new PrismEndpointBuilder(endpoint);
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
    return (A) this.withEndpoint(new PrismEndpoint(address, port));
  }
  
  public EndpointNested<A> withNewEndpointLike(PrismEndpoint item) {
    return new EndpointNested(item);
  }
  
  public A withUuid(String uuid) {
    this.uuid = uuid;
    return (A) this;
  }
  public class EndpointNested<N> extends PrismEndpointFluent<EndpointNested<N>> implements Nested<N>{
  
    PrismEndpointBuilder builder;
  
    EndpointNested(PrismEndpoint item) {
      this.builder = new PrismEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) PrismElementFluent.this.withEndpoint(builder.build());
    }
    
    public N endEndpoint() {
      return and();
    }
    
  }
}