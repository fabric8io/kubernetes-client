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
public class ConnectionPoolSettingsFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ConnectionPoolSettingsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConnectionPoolSettingsHTTPSettingsBuilder http;
  private ConnectionPoolSettingsTCPSettingsBuilder tcp;

  public ConnectionPoolSettingsFluent() {
  }
  
  public ConnectionPoolSettingsFluent(ConnectionPoolSettings instance) {
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
  
  public ConnectionPoolSettingsHTTPSettings buildHttp() {
    return this.http != null ? this.http.build() : null;
  }
  
  public ConnectionPoolSettingsTCPSettings buildTcp() {
    return this.tcp != null ? this.tcp.build() : null;
  }
  
  protected void copyInstance(ConnectionPoolSettings instance) {
    instance = instance != null ? instance : new ConnectionPoolSettings();
    if (instance != null) {
        this.withHttp(instance.getHttp());
        this.withTcp(instance.getTcp());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpNested<A> editHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(null));
  }
  
  public HttpNested<A> editOrNewHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(new ConnectionPoolSettingsHTTPSettingsBuilder().build()));
  }
  
  public HttpNested<A> editOrNewHttpLike(ConnectionPoolSettingsHTTPSettings item) {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(item));
  }
  
  public TcpNested<A> editOrNewTcp() {
    return this.withNewTcpLike(Optional.ofNullable(this.buildTcp()).orElse(new ConnectionPoolSettingsTCPSettingsBuilder().build()));
  }
  
  public TcpNested<A> editOrNewTcpLike(ConnectionPoolSettingsTCPSettings item) {
    return this.withNewTcpLike(Optional.ofNullable(this.buildTcp()).orElse(item));
  }
  
  public TcpNested<A> editTcp() {
    return this.withNewTcpLike(Optional.ofNullable(this.buildTcp()).orElse(null));
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
    ConnectionPoolSettingsFluent that = (ConnectionPoolSettingsFluent) o;
    if (!(Objects.equals(http, that.http))) {
      return false;
    }
    if (!(Objects.equals(tcp, that.tcp))) {
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
  
  public boolean hasHttp() {
    return this.http != null;
  }
  
  public boolean hasTcp() {
    return this.tcp != null;
  }
  
  public int hashCode() {
    return Objects.hash(http, tcp, additionalProperties);
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
    if (!(http == null)) {
        sb.append("http:");
        sb.append(http);
        sb.append(",");
    }
    if (!(tcp == null)) {
        sb.append("tcp:");
        sb.append(tcp);
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
  
  public A withHttp(ConnectionPoolSettingsHTTPSettings http) {
    this._visitables.remove("http");
    if (http != null) {
        this.http = new ConnectionPoolSettingsHTTPSettingsBuilder(http);
        this._visitables.get("http").add(this.http);
    } else {
        this.http = null;
        this._visitables.get("http").remove(this.http);
    }
    return (A) this;
  }
  
  public HttpNested<A> withNewHttp() {
    return new HttpNested(null);
  }
  
  public HttpNested<A> withNewHttpLike(ConnectionPoolSettingsHTTPSettings item) {
    return new HttpNested(item);
  }
  
  public TcpNested<A> withNewTcp() {
    return new TcpNested(null);
  }
  
  public TcpNested<A> withNewTcpLike(ConnectionPoolSettingsTCPSettings item) {
    return new TcpNested(item);
  }
  
  public A withTcp(ConnectionPoolSettingsTCPSettings tcp) {
    this._visitables.remove("tcp");
    if (tcp != null) {
        this.tcp = new ConnectionPoolSettingsTCPSettingsBuilder(tcp);
        this._visitables.get("tcp").add(this.tcp);
    } else {
        this.tcp = null;
        this._visitables.get("tcp").remove(this.tcp);
    }
    return (A) this;
  }
  public class HttpNested<N> extends ConnectionPoolSettingsHTTPSettingsFluent<HttpNested<N>> implements Nested<N>{
  
    ConnectionPoolSettingsHTTPSettingsBuilder builder;
  
    HttpNested(ConnectionPoolSettingsHTTPSettings item) {
      this.builder = new ConnectionPoolSettingsHTTPSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) ConnectionPoolSettingsFluent.this.withHttp(builder.build());
    }
    
    public N endHttp() {
      return and();
    }
    
  }
  public class TcpNested<N> extends ConnectionPoolSettingsTCPSettingsFluent<TcpNested<N>> implements Nested<N>{
  
    ConnectionPoolSettingsTCPSettingsBuilder builder;
  
    TcpNested(ConnectionPoolSettingsTCPSettings item) {
      this.builder = new ConnectionPoolSettingsTCPSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) ConnectionPoolSettingsFluent.this.withTcp(builder.build());
    }
    
    public N endTcp() {
      return and();
    }
    
  }
}