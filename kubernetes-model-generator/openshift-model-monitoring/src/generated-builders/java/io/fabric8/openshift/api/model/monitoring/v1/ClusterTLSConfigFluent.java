package io.fabric8.openshift.api.model.monitoring.v1;

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
public class ClusterTLSConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ClusterTLSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SafeTLSConfigBuilder client;
  private WebTLSConfigBuilder server;

  public ClusterTLSConfigFluent() {
  }
  
  public ClusterTLSConfigFluent(ClusterTLSConfig instance) {
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
  
  public SafeTLSConfig buildClient() {
    return this.client != null ? this.client.build() : null;
  }
  
  public WebTLSConfig buildServer() {
    return this.server != null ? this.server.build() : null;
  }
  
  protected void copyInstance(ClusterTLSConfig instance) {
    instance = instance != null ? instance : new ClusterTLSConfig();
    if (instance != null) {
        this.withClient(instance.getClient());
        this.withServer(instance.getServer());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientNested<A> editClient() {
    return this.withNewClientLike(Optional.ofNullable(this.buildClient()).orElse(null));
  }
  
  public ClientNested<A> editOrNewClient() {
    return this.withNewClientLike(Optional.ofNullable(this.buildClient()).orElse(new SafeTLSConfigBuilder().build()));
  }
  
  public ClientNested<A> editOrNewClientLike(SafeTLSConfig item) {
    return this.withNewClientLike(Optional.ofNullable(this.buildClient()).orElse(item));
  }
  
  public ServerNested<A> editOrNewServer() {
    return this.withNewServerLike(Optional.ofNullable(this.buildServer()).orElse(new WebTLSConfigBuilder().build()));
  }
  
  public ServerNested<A> editOrNewServerLike(WebTLSConfig item) {
    return this.withNewServerLike(Optional.ofNullable(this.buildServer()).orElse(item));
  }
  
  public ServerNested<A> editServer() {
    return this.withNewServerLike(Optional.ofNullable(this.buildServer()).orElse(null));
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
    ClusterTLSConfigFluent that = (ClusterTLSConfigFluent) o;
    if (!(Objects.equals(client, that.client))) {
      return false;
    }
    if (!(Objects.equals(server, that.server))) {
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
  
  public boolean hasClient() {
    return this.client != null;
  }
  
  public boolean hasServer() {
    return this.server != null;
  }
  
  public int hashCode() {
    return Objects.hash(client, server, additionalProperties);
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
    if (!(client == null)) {
        sb.append("client:");
        sb.append(client);
        sb.append(",");
    }
    if (!(server == null)) {
        sb.append("server:");
        sb.append(server);
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
  
  public A withClient(SafeTLSConfig client) {
    this._visitables.remove("client");
    if (client != null) {
        this.client = new SafeTLSConfigBuilder(client);
        this._visitables.get("client").add(this.client);
    } else {
        this.client = null;
        this._visitables.get("client").remove(this.client);
    }
    return (A) this;
  }
  
  public ClientNested<A> withNewClient() {
    return new ClientNested(null);
  }
  
  public ClientNested<A> withNewClientLike(SafeTLSConfig item) {
    return new ClientNested(item);
  }
  
  public ServerNested<A> withNewServer() {
    return new ServerNested(null);
  }
  
  public ServerNested<A> withNewServerLike(WebTLSConfig item) {
    return new ServerNested(item);
  }
  
  public A withServer(WebTLSConfig server) {
    this._visitables.remove("server");
    if (server != null) {
        this.server = new WebTLSConfigBuilder(server);
        this._visitables.get("server").add(this.server);
    } else {
        this.server = null;
        this._visitables.get("server").remove(this.server);
    }
    return (A) this;
  }
  public class ClientNested<N> extends SafeTLSConfigFluent<ClientNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    ClientNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterTLSConfigFluent.this.withClient(builder.build());
    }
    
    public N endClient() {
      return and();
    }
    
  }
  public class ServerNested<N> extends WebTLSConfigFluent<ServerNested<N>> implements Nested<N>{
  
    WebTLSConfigBuilder builder;
  
    ServerNested(WebTLSConfig item) {
      this.builder = new WebTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterTLSConfigFluent.this.withServer(builder.build());
    }
    
    public N endServer() {
      return and();
    }
    
  }
}