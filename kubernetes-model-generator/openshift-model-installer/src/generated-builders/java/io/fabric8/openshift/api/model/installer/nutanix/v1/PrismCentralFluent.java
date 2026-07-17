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
public class PrismCentralFluent<A extends io.fabric8.openshift.api.model.installer.nutanix.v1.PrismCentralFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PrismEndpointBuilder endpoint;
  private String password;
  private String username;

  public PrismCentralFluent() {
  }
  
  public PrismCentralFluent(PrismCentral instance) {
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
  
  protected void copyInstance(PrismCentral instance) {
    instance = instance != null ? instance : new PrismCentral();
    if (instance != null) {
        this.withEndpoint(instance.getEndpoint());
        this.withPassword(instance.getPassword());
        this.withUsername(instance.getUsername());
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
    PrismCentralFluent that = (PrismCentralFluent) o;
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
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
  
  public String getPassword() {
    return this.password;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public int hashCode() {
    return Objects.hash(endpoint, password, username, additionalProperties);
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
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
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
  
  public EndpointNested<A> withNewEndpoint() {
    return new EndpointNested(null);
  }
  
  public A withNewEndpoint(String address,Integer port) {
    return (A) this.withEndpoint(new PrismEndpoint(address, port));
  }
  
  public EndpointNested<A> withNewEndpointLike(PrismEndpoint item) {
    return new EndpointNested(item);
  }
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  public class EndpointNested<N> extends PrismEndpointFluent<EndpointNested<N>> implements Nested<N>{
  
    PrismEndpointBuilder builder;
  
    EndpointNested(PrismEndpoint item) {
      this.builder = new PrismEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) PrismCentralFluent.this.withEndpoint(builder.build());
    }
    
    public N endEndpoint() {
      return and();
    }
    
  }
}