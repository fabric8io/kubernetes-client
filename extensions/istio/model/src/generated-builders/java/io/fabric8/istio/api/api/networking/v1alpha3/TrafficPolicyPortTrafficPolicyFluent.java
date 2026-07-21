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
public class TrafficPolicyPortTrafficPolicyFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.TrafficPolicyPortTrafficPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConnectionPoolSettingsBuilder connectionPool;
  private LoadBalancerSettingsBuilder loadBalancer;
  private OutlierDetectionBuilder outlierDetection;
  private PortSelectorBuilder port;
  private ClientTLSSettingsBuilder tls;

  public TrafficPolicyPortTrafficPolicyFluent() {
  }
  
  public TrafficPolicyPortTrafficPolicyFluent(TrafficPolicyPortTrafficPolicy instance) {
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
  
  public LoadBalancerSettings buildLoadBalancer() {
    return this.loadBalancer != null ? this.loadBalancer.build() : null;
  }
  
  public OutlierDetection buildOutlierDetection() {
    return this.outlierDetection != null ? this.outlierDetection.build() : null;
  }
  
  public PortSelector buildPort() {
    return this.port != null ? this.port.build() : null;
  }
  
  public ClientTLSSettings buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(TrafficPolicyPortTrafficPolicy instance) {
    instance = instance != null ? instance : new TrafficPolicyPortTrafficPolicy();
    if (instance != null) {
        this.withConnectionPool(instance.getConnectionPool());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withOutlierDetection(instance.getOutlierDetection());
        this.withPort(instance.getPort());
        this.withTls(instance.getTls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConnectionPoolNested<A> editConnectionPool() {
    return this.withNewConnectionPoolLike(Optional.ofNullable(this.buildConnectionPool()).orElse(null));
  }
  
  public LoadBalancerNested<A> editLoadBalancer() {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(null));
  }
  
  public ConnectionPoolNested<A> editOrNewConnectionPool() {
    return this.withNewConnectionPoolLike(Optional.ofNullable(this.buildConnectionPool()).orElse(new ConnectionPoolSettingsBuilder().build()));
  }
  
  public ConnectionPoolNested<A> editOrNewConnectionPoolLike(ConnectionPoolSettings item) {
    return this.withNewConnectionPoolLike(Optional.ofNullable(this.buildConnectionPool()).orElse(item));
  }
  
  public LoadBalancerNested<A> editOrNewLoadBalancer() {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(new LoadBalancerSettingsBuilder().build()));
  }
  
  public LoadBalancerNested<A> editOrNewLoadBalancerLike(LoadBalancerSettings item) {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(item));
  }
  
  public OutlierDetectionNested<A> editOrNewOutlierDetection() {
    return this.withNewOutlierDetectionLike(Optional.ofNullable(this.buildOutlierDetection()).orElse(new OutlierDetectionBuilder().build()));
  }
  
  public OutlierDetectionNested<A> editOrNewOutlierDetectionLike(OutlierDetection item) {
    return this.withNewOutlierDetectionLike(Optional.ofNullable(this.buildOutlierDetection()).orElse(item));
  }
  
  public PortNested<A> editOrNewPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(new PortSelectorBuilder().build()));
  }
  
  public PortNested<A> editOrNewPortLike(PortSelector item) {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(item));
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new ClientTLSSettingsBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(ClientTLSSettings item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public OutlierDetectionNested<A> editOutlierDetection() {
    return this.withNewOutlierDetectionLike(Optional.ofNullable(this.buildOutlierDetection()).orElse(null));
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
    TrafficPolicyPortTrafficPolicyFluent that = (TrafficPolicyPortTrafficPolicyFluent) o;
    if (!(Objects.equals(connectionPool, that.connectionPool))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
      return false;
    }
    if (!(Objects.equals(outlierDetection, that.outlierDetection))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConnectionPool() {
    return this.connectionPool != null;
  }
  
  public boolean hasLoadBalancer() {
    return this.loadBalancer != null;
  }
  
  public boolean hasOutlierDetection() {
    return this.outlierDetection != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public int hashCode() {
    return Objects.hash(connectionPool, loadBalancer, outlierDetection, port, tls, additionalProperties);
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
    if (!(connectionPool == null)) {
        sb.append("connectionPool:");
        sb.append(connectionPool);
        sb.append(",");
    }
    if (!(loadBalancer == null)) {
        sb.append("loadBalancer:");
        sb.append(loadBalancer);
        sb.append(",");
    }
    if (!(outlierDetection == null)) {
        sb.append("outlierDetection:");
        sb.append(outlierDetection);
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
  
  public A withLoadBalancer(LoadBalancerSettings loadBalancer) {
    this._visitables.remove("loadBalancer");
    if (loadBalancer != null) {
        this.loadBalancer = new LoadBalancerSettingsBuilder(loadBalancer);
        this._visitables.get("loadBalancer").add(this.loadBalancer);
    } else {
        this.loadBalancer = null;
        this._visitables.get("loadBalancer").remove(this.loadBalancer);
    }
    return (A) this;
  }
  
  public ConnectionPoolNested<A> withNewConnectionPool() {
    return new ConnectionPoolNested(null);
  }
  
  public ConnectionPoolNested<A> withNewConnectionPoolLike(ConnectionPoolSettings item) {
    return new ConnectionPoolNested(item);
  }
  
  public LoadBalancerNested<A> withNewLoadBalancer() {
    return new LoadBalancerNested(null);
  }
  
  public LoadBalancerNested<A> withNewLoadBalancerLike(LoadBalancerSettings item) {
    return new LoadBalancerNested(item);
  }
  
  public OutlierDetectionNested<A> withNewOutlierDetection() {
    return new OutlierDetectionNested(null);
  }
  
  public OutlierDetectionNested<A> withNewOutlierDetectionLike(OutlierDetection item) {
    return new OutlierDetectionNested(item);
  }
  
  public PortNested<A> withNewPort() {
    return new PortNested(null);
  }
  
  public A withNewPort(Long number) {
    return (A) this.withPort(new PortSelector(number));
  }
  
  public PortNested<A> withNewPortLike(PortSelector item) {
    return new PortNested(item);
  }
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public TlsNested<A> withNewTlsLike(ClientTLSSettings item) {
    return new TlsNested(item);
  }
  
  public A withOutlierDetection(OutlierDetection outlierDetection) {
    this._visitables.remove("outlierDetection");
    if (outlierDetection != null) {
        this.outlierDetection = new OutlierDetectionBuilder(outlierDetection);
        this._visitables.get("outlierDetection").add(this.outlierDetection);
    } else {
        this.outlierDetection = null;
        this._visitables.get("outlierDetection").remove(this.outlierDetection);
    }
    return (A) this;
  }
  
  public A withPort(PortSelector port) {
    this._visitables.remove("port");
    if (port != null) {
        this.port = new PortSelectorBuilder(port);
        this._visitables.get("port").add(this.port);
    } else {
        this.port = null;
        this._visitables.get("port").remove(this.port);
    }
    return (A) this;
  }
  
  public A withTls(ClientTLSSettings tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new ClientTLSSettingsBuilder(tls);
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
      return (N) TrafficPolicyPortTrafficPolicyFluent.this.withConnectionPool(builder.build());
    }
    
    public N endConnectionPool() {
      return and();
    }
    
  }
  public class LoadBalancerNested<N> extends LoadBalancerSettingsFluent<LoadBalancerNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsBuilder builder;
  
    LoadBalancerNested(LoadBalancerSettings item) {
      this.builder = new LoadBalancerSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyPortTrafficPolicyFluent.this.withLoadBalancer(builder.build());
    }
    
    public N endLoadBalancer() {
      return and();
    }
    
  }
  public class OutlierDetectionNested<N> extends OutlierDetectionFluent<OutlierDetectionNested<N>> implements Nested<N>{
  
    OutlierDetectionBuilder builder;
  
    OutlierDetectionNested(OutlierDetection item) {
      this.builder = new OutlierDetectionBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyPortTrafficPolicyFluent.this.withOutlierDetection(builder.build());
    }
    
    public N endOutlierDetection() {
      return and();
    }
    
  }
  public class PortNested<N> extends PortSelectorFluent<PortNested<N>> implements Nested<N>{
  
    PortSelectorBuilder builder;
  
    PortNested(PortSelector item) {
      this.builder = new PortSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyPortTrafficPolicyFluent.this.withPort(builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class TlsNested<N> extends ClientTLSSettingsFluent<TlsNested<N>> implements Nested<N>{
  
    ClientTLSSettingsBuilder builder;
  
    TlsNested(ClientTLSSettings item) {
      this.builder = new ClientTLSSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyPortTrafficPolicyFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}