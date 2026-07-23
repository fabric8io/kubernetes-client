package io.fabric8.openshift.api.model.console.v1;

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
public class ConsolePluginProxyFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsolePluginProxyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String alias;
  private String authorization;
  private String caCertificate;
  private ConsolePluginProxyEndpointBuilder endpoint;

  public ConsolePluginProxyFluent() {
  }
  
  public ConsolePluginProxyFluent(ConsolePluginProxy instance) {
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
  
  public ConsolePluginProxyEndpoint buildEndpoint() {
    return this.endpoint != null ? this.endpoint.build() : null;
  }
  
  protected void copyInstance(ConsolePluginProxy instance) {
    instance = instance != null ? instance : new ConsolePluginProxy();
    if (instance != null) {
        this.withAlias(instance.getAlias());
        this.withAuthorization(instance.getAuthorization());
        this.withCaCertificate(instance.getCaCertificate());
        this.withEndpoint(instance.getEndpoint());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EndpointNested<A> editEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(null));
  }
  
  public EndpointNested<A> editOrNewEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(new ConsolePluginProxyEndpointBuilder().build()));
  }
  
  public EndpointNested<A> editOrNewEndpointLike(ConsolePluginProxyEndpoint item) {
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
    ConsolePluginProxyFluent that = (ConsolePluginProxyFluent) o;
    if (!(Objects.equals(alias, that.alias))) {
      return false;
    }
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(caCertificate, that.caCertificate))) {
      return false;
    }
    if (!(Objects.equals(endpoint, that.endpoint))) {
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
  
  public String getAlias() {
    return this.alias;
  }
  
  public String getAuthorization() {
    return this.authorization;
  }
  
  public String getCaCertificate() {
    return this.caCertificate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlias() {
    return this.alias != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasCaCertificate() {
    return this.caCertificate != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public int hashCode() {
    return Objects.hash(alias, authorization, caCertificate, endpoint, additionalProperties);
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
    if (!(alias == null)) {
        sb.append("alias:");
        sb.append(alias);
        sb.append(",");
    }
    if (!(authorization == null)) {
        sb.append("authorization:");
        sb.append(authorization);
        sb.append(",");
    }
    if (!(caCertificate == null)) {
        sb.append("caCertificate:");
        sb.append(caCertificate);
        sb.append(",");
    }
    if (!(endpoint == null)) {
        sb.append("endpoint:");
        sb.append(endpoint);
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
  
  public A withAlias(String alias) {
    this.alias = alias;
    return (A) this;
  }
  
  public A withAuthorization(String authorization) {
    this.authorization = authorization;
    return (A) this;
  }
  
  public A withCaCertificate(String caCertificate) {
    this.caCertificate = caCertificate;
    return (A) this;
  }
  
  public A withEndpoint(ConsolePluginProxyEndpoint endpoint) {
    this._visitables.remove("endpoint");
    if (endpoint != null) {
        this.endpoint = new ConsolePluginProxyEndpointBuilder(endpoint);
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
  
  public EndpointNested<A> withNewEndpointLike(ConsolePluginProxyEndpoint item) {
    return new EndpointNested(item);
  }
  public class EndpointNested<N> extends ConsolePluginProxyEndpointFluent<EndpointNested<N>> implements Nested<N>{
  
    ConsolePluginProxyEndpointBuilder builder;
  
    EndpointNested(ConsolePluginProxyEndpoint item) {
      this.builder = new ConsolePluginProxyEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsolePluginProxyFluent.this.withEndpoint(builder.build());
    }
    
    public N endEndpoint() {
      return and();
    }
    
  }
}