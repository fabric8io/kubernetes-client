package io.fabric8.kubernetes.api.model;

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
public class SessionAffinityConfigFluent<A extends io.fabric8.kubernetes.api.model.SessionAffinityConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClientIPConfigBuilder clientIP;

  public SessionAffinityConfigFluent() {
  }
  
  public SessionAffinityConfigFluent(SessionAffinityConfig instance) {
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
  
  public ClientIPConfig buildClientIP() {
    return this.clientIP != null ? this.clientIP.build() : null;
  }
  
  protected void copyInstance(SessionAffinityConfig instance) {
    instance = instance != null ? instance : new SessionAffinityConfig();
    if (instance != null) {
        this.withClientIP(instance.getClientIP());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientIPNested<A> editClientIP() {
    return this.withNewClientIPLike(Optional.ofNullable(this.buildClientIP()).orElse(null));
  }
  
  public ClientIPNested<A> editOrNewClientIP() {
    return this.withNewClientIPLike(Optional.ofNullable(this.buildClientIP()).orElse(new ClientIPConfigBuilder().build()));
  }
  
  public ClientIPNested<A> editOrNewClientIPLike(ClientIPConfig item) {
    return this.withNewClientIPLike(Optional.ofNullable(this.buildClientIP()).orElse(item));
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
    SessionAffinityConfigFluent that = (SessionAffinityConfigFluent) o;
    if (!(Objects.equals(clientIP, that.clientIP))) {
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
  
  public boolean hasClientIP() {
    return this.clientIP != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientIP, additionalProperties);
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
    if (!(clientIP == null)) {
        sb.append("clientIP:");
        sb.append(clientIP);
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
  
  public A withClientIP(ClientIPConfig clientIP) {
    this._visitables.remove("clientIP");
    if (clientIP != null) {
        this.clientIP = new ClientIPConfigBuilder(clientIP);
        this._visitables.get("clientIP").add(this.clientIP);
    } else {
        this.clientIP = null;
        this._visitables.get("clientIP").remove(this.clientIP);
    }
    return (A) this;
  }
  
  public ClientIPNested<A> withNewClientIP() {
    return new ClientIPNested(null);
  }
  
  public A withNewClientIP(Integer timeoutSeconds) {
    return (A) this.withClientIP(new ClientIPConfig(timeoutSeconds));
  }
  
  public ClientIPNested<A> withNewClientIPLike(ClientIPConfig item) {
    return new ClientIPNested(item);
  }
  public class ClientIPNested<N> extends ClientIPConfigFluent<ClientIPNested<N>> implements Nested<N>{
  
    ClientIPConfigBuilder builder;
  
    ClientIPNested(ClientIPConfig item) {
      this.builder = new ClientIPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SessionAffinityConfigFluent.this.withClientIP(builder.build());
    }
    
    public N endClientIP() {
      return and();
    }
    
  }
}