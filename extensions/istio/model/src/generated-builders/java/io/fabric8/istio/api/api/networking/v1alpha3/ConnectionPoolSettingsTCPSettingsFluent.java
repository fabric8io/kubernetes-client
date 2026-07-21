package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
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
public class ConnectionPoolSettingsTCPSettingsFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ConnectionPoolSettingsTCPSettingsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String connectTimeout;
  private String idleTimeout;
  private String maxConnectionDuration;
  private Integer maxConnections;
  private ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder tcpKeepalive;

  public ConnectionPoolSettingsTCPSettingsFluent() {
  }
  
  public ConnectionPoolSettingsTCPSettingsFluent(ConnectionPoolSettingsTCPSettings instance) {
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
  
  public ConnectionPoolSettingsTCPSettingsTcpKeepalive buildTcpKeepalive() {
    return this.tcpKeepalive != null ? this.tcpKeepalive.build() : null;
  }
  
  protected void copyInstance(ConnectionPoolSettingsTCPSettings instance) {
    instance = instance != null ? instance : new ConnectionPoolSettingsTCPSettings();
    if (instance != null) {
        this.withConnectTimeout(instance.getConnectTimeout());
        this.withIdleTimeout(instance.getIdleTimeout());
        this.withMaxConnectionDuration(instance.getMaxConnectionDuration());
        this.withMaxConnections(instance.getMaxConnections());
        this.withTcpKeepalive(instance.getTcpKeepalive());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TcpKeepaliveNested<A> editOrNewTcpKeepalive() {
    return this.withNewTcpKeepaliveLike(Optional.ofNullable(this.buildTcpKeepalive()).orElse(new ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder().build()));
  }
  
  public TcpKeepaliveNested<A> editOrNewTcpKeepaliveLike(ConnectionPoolSettingsTCPSettingsTcpKeepalive item) {
    return this.withNewTcpKeepaliveLike(Optional.ofNullable(this.buildTcpKeepalive()).orElse(item));
  }
  
  public TcpKeepaliveNested<A> editTcpKeepalive() {
    return this.withNewTcpKeepaliveLike(Optional.ofNullable(this.buildTcpKeepalive()).orElse(null));
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
    ConnectionPoolSettingsTCPSettingsFluent that = (ConnectionPoolSettingsTCPSettingsFluent) o;
    if (!(Objects.equals(connectTimeout, that.connectTimeout))) {
      return false;
    }
    if (!(Objects.equals(idleTimeout, that.idleTimeout))) {
      return false;
    }
    if (!(Objects.equals(maxConnectionDuration, that.maxConnectionDuration))) {
      return false;
    }
    if (!(Objects.equals(maxConnections, that.maxConnections))) {
      return false;
    }
    if (!(Objects.equals(tcpKeepalive, that.tcpKeepalive))) {
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
  
  public String getConnectTimeout() {
    return this.connectTimeout;
  }
  
  public String getIdleTimeout() {
    return this.idleTimeout;
  }
  
  public String getMaxConnectionDuration() {
    return this.maxConnectionDuration;
  }
  
  public Integer getMaxConnections() {
    return this.maxConnections;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConnectTimeout() {
    return this.connectTimeout != null;
  }
  
  public boolean hasIdleTimeout() {
    return this.idleTimeout != null;
  }
  
  public boolean hasMaxConnectionDuration() {
    return this.maxConnectionDuration != null;
  }
  
  public boolean hasMaxConnections() {
    return this.maxConnections != null;
  }
  
  public boolean hasTcpKeepalive() {
    return this.tcpKeepalive != null;
  }
  
  public int hashCode() {
    return Objects.hash(connectTimeout, idleTimeout, maxConnectionDuration, maxConnections, tcpKeepalive, additionalProperties);
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
    if (!(connectTimeout == null)) {
        sb.append("connectTimeout:");
        sb.append(connectTimeout);
        sb.append(",");
    }
    if (!(idleTimeout == null)) {
        sb.append("idleTimeout:");
        sb.append(idleTimeout);
        sb.append(",");
    }
    if (!(maxConnectionDuration == null)) {
        sb.append("maxConnectionDuration:");
        sb.append(maxConnectionDuration);
        sb.append(",");
    }
    if (!(maxConnections == null)) {
        sb.append("maxConnections:");
        sb.append(maxConnections);
        sb.append(",");
    }
    if (!(tcpKeepalive == null)) {
        sb.append("tcpKeepalive:");
        sb.append(tcpKeepalive);
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
  
  public A withConnectTimeout(String connectTimeout) {
    this.connectTimeout = connectTimeout;
    return (A) this;
  }
  
  public A withIdleTimeout(String idleTimeout) {
    this.idleTimeout = idleTimeout;
    return (A) this;
  }
  
  public A withMaxConnectionDuration(String maxConnectionDuration) {
    this.maxConnectionDuration = maxConnectionDuration;
    return (A) this;
  }
  
  public A withMaxConnections(Integer maxConnections) {
    this.maxConnections = maxConnections;
    return (A) this;
  }
  
  public TcpKeepaliveNested<A> withNewTcpKeepalive() {
    return new TcpKeepaliveNested(null);
  }
  
  public A withNewTcpKeepalive(String interval,Long probes,String time) {
    return (A) this.withTcpKeepalive(new ConnectionPoolSettingsTCPSettingsTcpKeepalive(interval, probes, time));
  }
  
  public TcpKeepaliveNested<A> withNewTcpKeepaliveLike(ConnectionPoolSettingsTCPSettingsTcpKeepalive item) {
    return new TcpKeepaliveNested(item);
  }
  
  public A withTcpKeepalive(ConnectionPoolSettingsTCPSettingsTcpKeepalive tcpKeepalive) {
    this._visitables.remove("tcpKeepalive");
    if (tcpKeepalive != null) {
        this.tcpKeepalive = new ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder(tcpKeepalive);
        this._visitables.get("tcpKeepalive").add(this.tcpKeepalive);
    } else {
        this.tcpKeepalive = null;
        this._visitables.get("tcpKeepalive").remove(this.tcpKeepalive);
    }
    return (A) this;
  }
  public class TcpKeepaliveNested<N> extends ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent<TcpKeepaliveNested<N>> implements Nested<N>{
  
    ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder builder;
  
    TcpKeepaliveNested(ConnectionPoolSettingsTCPSettingsTcpKeepalive item) {
      this.builder = new ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder(this, item);
    }
  
    public N and() {
      return (N) ConnectionPoolSettingsTCPSettingsFluent.this.withTcpKeepalive(builder.build());
    }
    
    public N endTcpKeepalive() {
      return and();
    }
    
  }
}