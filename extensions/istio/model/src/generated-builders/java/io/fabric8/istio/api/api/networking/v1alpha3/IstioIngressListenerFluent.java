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
public class IstioIngressListenerFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.IstioIngressListenerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bind;
  private CaptureMode captureMode;
  private ConnectionPoolSettingsBuilder connectionPool;
  private String defaultEndpoint;
  private SidecarPortBuilder port;
  private ServerTLSSettingsBuilder tls;

  public IstioIngressListenerFluent() {
  }
  
  public IstioIngressListenerFluent(IstioIngressListener instance) {
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
  
  public ConnectionPoolSettings buildConnectionPool() {
    return this.connectionPool != null ? this.connectionPool.build() : null;
  }
  
  public SidecarPort buildPort() {
    return this.port != null ? this.port.build() : null;
  }
  
  public ServerTLSSettings buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(IstioIngressListener instance) {
    instance = instance != null ? instance : new IstioIngressListener();
    if (instance != null) {
        this.withBind(instance.getBind());
        this.withCaptureMode(instance.getCaptureMode());
        this.withConnectionPool(instance.getConnectionPool());
        this.withDefaultEndpoint(instance.getDefaultEndpoint());
        this.withPort(instance.getPort());
        this.withTls(instance.getTls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConnectionPoolNested<A> editConnectionPool() {
    return this.withNewConnectionPoolLike(Optional.ofNullable(this.buildConnectionPool()).orElse(null));
  }
  
  public ConnectionPoolNested<A> editOrNewConnectionPool() {
    return this.withNewConnectionPoolLike(Optional.ofNullable(this.buildConnectionPool()).orElse(new ConnectionPoolSettingsBuilder().build()));
  }
  
  public ConnectionPoolNested<A> editOrNewConnectionPoolLike(ConnectionPoolSettings item) {
    return this.withNewConnectionPoolLike(Optional.ofNullable(this.buildConnectionPool()).orElse(item));
  }
  
  public PortNested<A> editOrNewPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(new SidecarPortBuilder().build()));
  }
  
  public PortNested<A> editOrNewPortLike(SidecarPort item) {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(item));
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new ServerTLSSettingsBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(ServerTLSSettings item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public PortNested<A> editPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(null));
  }
  
  public TlsNested<A> editTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(null));
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
    IstioIngressListenerFluent that = (IstioIngressListenerFluent) o;
    if (!(Objects.equals(bind, that.bind))) {
      return false;
    }
    if (!(Objects.equals(captureMode, that.captureMode))) {
      return false;
    }
    if (!(Objects.equals(connectionPool, that.connectionPool))) {
      return false;
    }
    if (!(Objects.equals(defaultEndpoint, that.defaultEndpoint))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(tls, that.tls))) {
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
  
  public String getBind() {
    return this.bind;
  }
  
  public CaptureMode getCaptureMode() {
    return this.captureMode;
  }
  
  public String getDefaultEndpoint() {
    return this.defaultEndpoint;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBind() {
    return this.bind != null;
  }
  
  public boolean hasCaptureMode() {
    return this.captureMode != null;
  }
  
  public boolean hasConnectionPool() {
    return this.connectionPool != null;
  }
  
  public boolean hasDefaultEndpoint() {
    return this.defaultEndpoint != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public int hashCode() {
    return Objects.hash(bind, captureMode, connectionPool, defaultEndpoint, port, tls, additionalProperties);
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
    if (!(bind == null)) {
        sb.append("bind:");
        sb.append(bind);
        sb.append(",");
    }
    if (!(captureMode == null)) {
        sb.append("captureMode:");
        sb.append(captureMode);
        sb.append(",");
    }
    if (!(connectionPool == null)) {
        sb.append("connectionPool:");
        sb.append(connectionPool);
        sb.append(",");
    }
    if (!(defaultEndpoint == null)) {
        sb.append("defaultEndpoint:");
        sb.append(defaultEndpoint);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(tls == null)) {
        sb.append("tls:");
        sb.append(tls);
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
  
  public A withBind(String bind) {
    this.bind = bind;
    return (A) this;
  }
  
  public A withCaptureMode(CaptureMode captureMode) {
    this.captureMode = captureMode;
    return (A) this;
  }
  
  public A withConnectionPool(ConnectionPoolSettings connectionPool) {
    this._visitables.remove("connectionPool");
    if (connectionPool != null) {
        this.connectionPool = new ConnectionPoolSettingsBuilder(connectionPool);
        this._visitables.get("connectionPool").add(this.connectionPool);
    } else {
        this.connectionPool = null;
        this._visitables.get("connectionPool").remove(this.connectionPool);
    }
    return (A) this;
  }
  
  public A withDefaultEndpoint(String defaultEndpoint) {
    this.defaultEndpoint = defaultEndpoint;
    return (A) this;
  }
  
  public ConnectionPoolNested<A> withNewConnectionPool() {
    return new ConnectionPoolNested(null);
  }
  
  public ConnectionPoolNested<A> withNewConnectionPoolLike(ConnectionPoolSettings item) {
    return new ConnectionPoolNested(item);
  }
  
  public PortNested<A> withNewPort() {
    return new PortNested(null);
  }
  
  public A withNewPort(String name,Long number,String protocol,Long targetPort) {
    return (A) this.withPort(new SidecarPort(name, number, protocol, targetPort));
  }
  
  public PortNested<A> withNewPortLike(SidecarPort item) {
    return new PortNested(item);
  }
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public TlsNested<A> withNewTlsLike(ServerTLSSettings item) {
    return new TlsNested(item);
  }
  
  public A withPort(SidecarPort port) {
    this._visitables.remove("port");
    if (port != null) {
        this.port = new SidecarPortBuilder(port);
        this._visitables.get("port").add(this.port);
    } else {
        this.port = null;
        this._visitables.get("port").remove(this.port);
    }
    return (A) this;
  }
  
  public A withTls(ServerTLSSettings tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new ServerTLSSettingsBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  public class ConnectionPoolNested<N> extends ConnectionPoolSettingsFluent<ConnectionPoolNested<N>> implements Nested<N>{
  
    ConnectionPoolSettingsBuilder builder;
  
    ConnectionPoolNested(ConnectionPoolSettings item) {
      this.builder = new ConnectionPoolSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) IstioIngressListenerFluent.this.withConnectionPool(builder.build());
    }
    
    public N endConnectionPool() {
      return and();
    }
    
  }
  public class PortNested<N> extends SidecarPortFluent<PortNested<N>> implements Nested<N>{
  
    SidecarPortBuilder builder;
  
    PortNested(SidecarPort item) {
      this.builder = new SidecarPortBuilder(this, item);
    }
  
    public N and() {
      return (N) IstioIngressListenerFluent.this.withPort(builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class TlsNested<N> extends ServerTLSSettingsFluent<TlsNested<N>> implements Nested<N>{
  
    ServerTLSSettingsBuilder builder;
  
    TlsNested(ServerTLSSettings item) {
      this.builder = new ServerTLSSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) IstioIngressListenerFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}