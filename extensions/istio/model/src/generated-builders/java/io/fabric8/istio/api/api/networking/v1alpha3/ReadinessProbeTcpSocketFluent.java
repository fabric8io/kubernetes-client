package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ReadinessProbeTcpSocketFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ReadinessProbeTcpSocketFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TCPHealthCheckConfigBuilder tcpSocket;

  public ReadinessProbeTcpSocketFluent() {
  }
  
  public ReadinessProbeTcpSocketFluent(ReadinessProbeTcpSocket instance) {
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
  
  public TCPHealthCheckConfig buildTcpSocket() {
    return this.tcpSocket != null ? this.tcpSocket.build() : null;
  }
  
  protected void copyInstance(ReadinessProbeTcpSocket instance) {
    instance = instance != null ? instance : new ReadinessProbeTcpSocket();
    if (instance != null) {
        this.withTcpSocket(instance.getTcpSocket());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TcpSocketNested<A> editOrNewTcpSocket() {
    return this.withNewTcpSocketLike(Optional.ofNullable(this.buildTcpSocket()).orElse(new TCPHealthCheckConfigBuilder().build()));
  }
  
  public TcpSocketNested<A> editOrNewTcpSocketLike(TCPHealthCheckConfig item) {
    return this.withNewTcpSocketLike(Optional.ofNullable(this.buildTcpSocket()).orElse(item));
  }
  
  public TcpSocketNested<A> editTcpSocket() {
    return this.withNewTcpSocketLike(Optional.ofNullable(this.buildTcpSocket()).orElse(null));
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
    ReadinessProbeTcpSocketFluent that = (ReadinessProbeTcpSocketFluent) o;
    if (!(Objects.equals(tcpSocket, that.tcpSocket))) {
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
  
  public boolean hasTcpSocket() {
    return this.tcpSocket != null;
  }
  
  public int hashCode() {
    return Objects.hash(tcpSocket, additionalProperties);
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
    if (!(tcpSocket == null)) {
        sb.append("tcpSocket:");
        sb.append(tcpSocket);
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
  
  public TcpSocketNested<A> withNewTcpSocket() {
    return new TcpSocketNested(null);
  }
  
  public A withNewTcpSocket(String host,Long port) {
    return (A) this.withTcpSocket(new TCPHealthCheckConfig(host, port));
  }
  
  public TcpSocketNested<A> withNewTcpSocketLike(TCPHealthCheckConfig item) {
    return new TcpSocketNested(item);
  }
  
  public A withTcpSocket(TCPHealthCheckConfig tcpSocket) {
    this._visitables.remove("tcpSocket");
    if (tcpSocket != null) {
        this.tcpSocket = new TCPHealthCheckConfigBuilder(tcpSocket);
        this._visitables.get("tcpSocket").add(this.tcpSocket);
    } else {
        this.tcpSocket = null;
        this._visitables.get("tcpSocket").remove(this.tcpSocket);
    }
    return (A) this;
  }
  public class TcpSocketNested<N> extends TCPHealthCheckConfigFluent<TcpSocketNested<N>> implements Nested<N>{
  
    TCPHealthCheckConfigBuilder builder;
  
    TcpSocketNested(TCPHealthCheckConfig item) {
      this.builder = new TCPHealthCheckConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReadinessProbeTcpSocketFluent.this.withTcpSocket(builder.build());
    }
    
    public N endTcpSocket() {
      return and();
    }
    
  }
}