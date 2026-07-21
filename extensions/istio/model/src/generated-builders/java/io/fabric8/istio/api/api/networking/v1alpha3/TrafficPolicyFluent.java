package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Double;
import java.lang.Long;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TrafficPolicyFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.TrafficPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConnectionPoolSettingsBuilder connectionPool;
  private LoadBalancerSettingsBuilder loadBalancer;
  private OutlierDetectionBuilder outlierDetection;
  private ArrayList<TrafficPolicyPortTrafficPolicyBuilder> portLevelSettings = new ArrayList<TrafficPolicyPortTrafficPolicyBuilder>();
  private TrafficPolicyProxyProtocolBuilder proxyProtocol;
  private TrafficPolicyRetryBudgetBuilder retryBudget;
  private ClientTLSSettingsBuilder tls;
  private TrafficPolicyTunnelSettingsBuilder tunnel;

  public TrafficPolicyFluent() {
  }
  
  public TrafficPolicyFluent(TrafficPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToPortLevelSettings(Collection<TrafficPolicyPortTrafficPolicy> items) {
    if (this.portLevelSettings == null) {
      this.portLevelSettings = new ArrayList();
    }
    for (TrafficPolicyPortTrafficPolicy item : items) {
        TrafficPolicyPortTrafficPolicyBuilder builder = new TrafficPolicyPortTrafficPolicyBuilder(item);
        _visitables.get("portLevelSettings").add(builder);
        this.portLevelSettings.add(builder);
    }
    return (A) this;
  }
  
  public PortLevelSettingsNested<A> addNewPortLevelSetting() {
    return new PortLevelSettingsNested(-1, null);
  }
  
  public PortLevelSettingsNested<A> addNewPortLevelSettingLike(TrafficPolicyPortTrafficPolicy item) {
    return new PortLevelSettingsNested(-1, item);
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
  
  public A addToPortLevelSettings(TrafficPolicyPortTrafficPolicy... items) {
    if (this.portLevelSettings == null) {
      this.portLevelSettings = new ArrayList();
    }
    for (TrafficPolicyPortTrafficPolicy item : items) {
        TrafficPolicyPortTrafficPolicyBuilder builder = new TrafficPolicyPortTrafficPolicyBuilder(item);
        _visitables.get("portLevelSettings").add(builder);
        this.portLevelSettings.add(builder);
    }
    return (A) this;
  }
  
  public A addToPortLevelSettings(int index,TrafficPolicyPortTrafficPolicy item) {
    if (this.portLevelSettings == null) {
      this.portLevelSettings = new ArrayList();
    }
    TrafficPolicyPortTrafficPolicyBuilder builder = new TrafficPolicyPortTrafficPolicyBuilder(item);
    if (index < 0 || index >= portLevelSettings.size()) {
        _visitables.get("portLevelSettings").add(builder);
        portLevelSettings.add(builder);
    } else {
        _visitables.get("portLevelSettings").add(builder);
        portLevelSettings.add(index, builder);
    }
    return (A) this;
  }
  
  public ConnectionPoolSettings buildConnectionPool() {
    return this.connectionPool != null ? this.connectionPool.build() : null;
  }
  
  public TrafficPolicyPortTrafficPolicy buildFirstPortLevelSetting() {
    return this.portLevelSettings.get(0).build();
  }
  
  public TrafficPolicyPortTrafficPolicy buildLastPortLevelSetting() {
    return this.portLevelSettings.get(portLevelSettings.size() - 1).build();
  }
  
  public LoadBalancerSettings buildLoadBalancer() {
    return this.loadBalancer != null ? this.loadBalancer.build() : null;
  }
  
  public TrafficPolicyPortTrafficPolicy buildMatchingPortLevelSetting(Predicate<TrafficPolicyPortTrafficPolicyBuilder> predicate) {
      for (TrafficPolicyPortTrafficPolicyBuilder item : portLevelSettings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OutlierDetection buildOutlierDetection() {
    return this.outlierDetection != null ? this.outlierDetection.build() : null;
  }
  
  public TrafficPolicyPortTrafficPolicy buildPortLevelSetting(int index) {
    return this.portLevelSettings.get(index).build();
  }
  
  public List<TrafficPolicyPortTrafficPolicy> buildPortLevelSettings() {
    return this.portLevelSettings != null ? build(portLevelSettings) : null;
  }
  
  public TrafficPolicyProxyProtocol buildProxyProtocol() {
    return this.proxyProtocol != null ? this.proxyProtocol.build() : null;
  }
  
  public TrafficPolicyRetryBudget buildRetryBudget() {
    return this.retryBudget != null ? this.retryBudget.build() : null;
  }
  
  public ClientTLSSettings buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  public TrafficPolicyTunnelSettings buildTunnel() {
    return this.tunnel != null ? this.tunnel.build() : null;
  }
  
  protected void copyInstance(TrafficPolicy instance) {
    instance = instance != null ? instance : new TrafficPolicy();
    if (instance != null) {
        this.withConnectionPool(instance.getConnectionPool());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withOutlierDetection(instance.getOutlierDetection());
        this.withPortLevelSettings(instance.getPortLevelSettings());
        this.withProxyProtocol(instance.getProxyProtocol());
        this.withRetryBudget(instance.getRetryBudget());
        this.withTls(instance.getTls());
        this.withTunnel(instance.getTunnel());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConnectionPoolNested<A> editConnectionPool() {
    return this.withNewConnectionPoolLike(Optional.ofNullable(this.buildConnectionPool()).orElse(null));
  }
  
  public PortLevelSettingsNested<A> editFirstPortLevelSetting() {
    if (portLevelSettings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "portLevelSettings"));
    }
    return this.setNewPortLevelSettingLike(0, this.buildPortLevelSetting(0));
  }
  
  public PortLevelSettingsNested<A> editLastPortLevelSetting() {
    int index = portLevelSettings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "portLevelSettings"));
    }
    return this.setNewPortLevelSettingLike(index, this.buildPortLevelSetting(index));
  }
  
  public LoadBalancerNested<A> editLoadBalancer() {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(null));
  }
  
  public PortLevelSettingsNested<A> editMatchingPortLevelSetting(Predicate<TrafficPolicyPortTrafficPolicyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < portLevelSettings.size();i++) {
      if (predicate.test(portLevelSettings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "portLevelSettings"));
    }
    return this.setNewPortLevelSettingLike(index, this.buildPortLevelSetting(index));
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
  
  public ProxyProtocolNested<A> editOrNewProxyProtocol() {
    return this.withNewProxyProtocolLike(Optional.ofNullable(this.buildProxyProtocol()).orElse(new TrafficPolicyProxyProtocolBuilder().build()));
  }
  
  public ProxyProtocolNested<A> editOrNewProxyProtocolLike(TrafficPolicyProxyProtocol item) {
    return this.withNewProxyProtocolLike(Optional.ofNullable(this.buildProxyProtocol()).orElse(item));
  }
  
  public RetryBudgetNested<A> editOrNewRetryBudget() {
    return this.withNewRetryBudgetLike(Optional.ofNullable(this.buildRetryBudget()).orElse(new TrafficPolicyRetryBudgetBuilder().build()));
  }
  
  public RetryBudgetNested<A> editOrNewRetryBudgetLike(TrafficPolicyRetryBudget item) {
    return this.withNewRetryBudgetLike(Optional.ofNullable(this.buildRetryBudget()).orElse(item));
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new ClientTLSSettingsBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(ClientTLSSettings item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public TunnelNested<A> editOrNewTunnel() {
    return this.withNewTunnelLike(Optional.ofNullable(this.buildTunnel()).orElse(new TrafficPolicyTunnelSettingsBuilder().build()));
  }
  
  public TunnelNested<A> editOrNewTunnelLike(TrafficPolicyTunnelSettings item) {
    return this.withNewTunnelLike(Optional.ofNullable(this.buildTunnel()).orElse(item));
  }
  
  public OutlierDetectionNested<A> editOutlierDetection() {
    return this.withNewOutlierDetectionLike(Optional.ofNullable(this.buildOutlierDetection()).orElse(null));
  }
  
  public PortLevelSettingsNested<A> editPortLevelSetting(int index) {
    if (portLevelSettings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "portLevelSettings"));
    }
    return this.setNewPortLevelSettingLike(index, this.buildPortLevelSetting(index));
  }
  
  public ProxyProtocolNested<A> editProxyProtocol() {
    return this.withNewProxyProtocolLike(Optional.ofNullable(this.buildProxyProtocol()).orElse(null));
  }
  
  public RetryBudgetNested<A> editRetryBudget() {
    return this.withNewRetryBudgetLike(Optional.ofNullable(this.buildRetryBudget()).orElse(null));
  }
  
  public TlsNested<A> editTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(null));
  }
  
  public TunnelNested<A> editTunnel() {
    return this.withNewTunnelLike(Optional.ofNullable(this.buildTunnel()).orElse(null));
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
    TrafficPolicyFluent that = (TrafficPolicyFluent) o;
    if (!(Objects.equals(connectionPool, that.connectionPool))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
      return false;
    }
    if (!(Objects.equals(outlierDetection, that.outlierDetection))) {
      return false;
    }
    if (!(Objects.equals(portLevelSettings, that.portLevelSettings))) {
      return false;
    }
    if (!(Objects.equals(proxyProtocol, that.proxyProtocol))) {
      return false;
    }
    if (!(Objects.equals(retryBudget, that.retryBudget))) {
      return false;
    }
    if (!(Objects.equals(tls, that.tls))) {
      return false;
    }
    if (!(Objects.equals(tunnel, that.tunnel))) {
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
  
  public boolean hasMatchingPortLevelSetting(Predicate<TrafficPolicyPortTrafficPolicyBuilder> predicate) {
      for (TrafficPolicyPortTrafficPolicyBuilder item : portLevelSettings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOutlierDetection() {
    return this.outlierDetection != null;
  }
  
  public boolean hasPortLevelSettings() {
    return this.portLevelSettings != null && !(this.portLevelSettings.isEmpty());
  }
  
  public boolean hasProxyProtocol() {
    return this.proxyProtocol != null;
  }
  
  public boolean hasRetryBudget() {
    return this.retryBudget != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public boolean hasTunnel() {
    return this.tunnel != null;
  }
  
  public int hashCode() {
    return Objects.hash(connectionPool, loadBalancer, outlierDetection, portLevelSettings, proxyProtocol, retryBudget, tls, tunnel, additionalProperties);
  }
  
  public A removeAllFromPortLevelSettings(Collection<TrafficPolicyPortTrafficPolicy> items) {
    if (this.portLevelSettings == null) {
      return (A) this;
    }
    for (TrafficPolicyPortTrafficPolicy item : items) {
        TrafficPolicyPortTrafficPolicyBuilder builder = new TrafficPolicyPortTrafficPolicyBuilder(item);
        _visitables.get("portLevelSettings").remove(builder);
        this.portLevelSettings.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromPortLevelSettings(TrafficPolicyPortTrafficPolicy... items) {
    if (this.portLevelSettings == null) {
      return (A) this;
    }
    for (TrafficPolicyPortTrafficPolicy item : items) {
        TrafficPolicyPortTrafficPolicyBuilder builder = new TrafficPolicyPortTrafficPolicyBuilder(item);
        _visitables.get("portLevelSettings").remove(builder);
        this.portLevelSettings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPortLevelSettings(Predicate<TrafficPolicyPortTrafficPolicyBuilder> predicate) {
    if (portLevelSettings == null) {
      return (A) this;
    }
    Iterator<TrafficPolicyPortTrafficPolicyBuilder> each = portLevelSettings.iterator();
    List visitables = _visitables.get("portLevelSettings");
    while (each.hasNext()) {
        TrafficPolicyPortTrafficPolicyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PortLevelSettingsNested<A> setNewPortLevelSettingLike(int index,TrafficPolicyPortTrafficPolicy item) {
    return new PortLevelSettingsNested(index, item);
  }
  
  public A setToPortLevelSettings(int index,TrafficPolicyPortTrafficPolicy item) {
    if (this.portLevelSettings == null) {
      this.portLevelSettings = new ArrayList();
    }
    TrafficPolicyPortTrafficPolicyBuilder builder = new TrafficPolicyPortTrafficPolicyBuilder(item);
    if (index < 0 || index >= portLevelSettings.size()) {
        _visitables.get("portLevelSettings").add(builder);
        portLevelSettings.add(builder);
    } else {
        _visitables.get("portLevelSettings").add(builder);
        portLevelSettings.set(index, builder);
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
    if (!(portLevelSettings == null) && !(portLevelSettings.isEmpty())) {
        sb.append("portLevelSettings:");
        sb.append(portLevelSettings);
        sb.append(",");
    }
    if (!(proxyProtocol == null)) {
        sb.append("proxyProtocol:");
        sb.append(proxyProtocol);
        sb.append(",");
    }
    if (!(retryBudget == null)) {
        sb.append("retryBudget:");
        sb.append(retryBudget);
        sb.append(",");
    }
    if (!(tls == null)) {
        sb.append("tls:");
        sb.append(tls);
        sb.append(",");
    }
    if (!(tunnel == null)) {
        sb.append("tunnel:");
        sb.append(tunnel);
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
  
  public ProxyProtocolNested<A> withNewProxyProtocol() {
    return new ProxyProtocolNested(null);
  }
  
  public ProxyProtocolNested<A> withNewProxyProtocolLike(TrafficPolicyProxyProtocol item) {
    return new ProxyProtocolNested(item);
  }
  
  public RetryBudgetNested<A> withNewRetryBudget() {
    return new RetryBudgetNested(null);
  }
  
  public A withNewRetryBudget(Long minRetryConcurrency,Double percent) {
    return (A) this.withRetryBudget(new TrafficPolicyRetryBudget(minRetryConcurrency, percent));
  }
  
  public RetryBudgetNested<A> withNewRetryBudgetLike(TrafficPolicyRetryBudget item) {
    return new RetryBudgetNested(item);
  }
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public TlsNested<A> withNewTlsLike(ClientTLSSettings item) {
    return new TlsNested(item);
  }
  
  public TunnelNested<A> withNewTunnel() {
    return new TunnelNested(null);
  }
  
  public A withNewTunnel(String protocol,String targetHost,Long targetPort) {
    return (A) this.withTunnel(new TrafficPolicyTunnelSettings(protocol, targetHost, targetPort));
  }
  
  public TunnelNested<A> withNewTunnelLike(TrafficPolicyTunnelSettings item) {
    return new TunnelNested(item);
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
  
  public A withPortLevelSettings(List<TrafficPolicyPortTrafficPolicy> portLevelSettings) {
    if (this.portLevelSettings != null) {
      this._visitables.get("portLevelSettings").clear();
    }
    if (portLevelSettings != null) {
        this.portLevelSettings = new ArrayList();
        for (TrafficPolicyPortTrafficPolicy item : portLevelSettings) {
          this.addToPortLevelSettings(item);
        }
    } else {
      this.portLevelSettings = null;
    }
    return (A) this;
  }
  
  public A withPortLevelSettings(TrafficPolicyPortTrafficPolicy... portLevelSettings) {
    if (this.portLevelSettings != null) {
        this.portLevelSettings.clear();
        _visitables.remove("portLevelSettings");
    }
    if (portLevelSettings != null) {
      for (TrafficPolicyPortTrafficPolicy item : portLevelSettings) {
        this.addToPortLevelSettings(item);
      }
    }
    return (A) this;
  }
  
  public A withProxyProtocol(TrafficPolicyProxyProtocol proxyProtocol) {
    this._visitables.remove("proxyProtocol");
    if (proxyProtocol != null) {
        this.proxyProtocol = new TrafficPolicyProxyProtocolBuilder(proxyProtocol);
        this._visitables.get("proxyProtocol").add(this.proxyProtocol);
    } else {
        this.proxyProtocol = null;
        this._visitables.get("proxyProtocol").remove(this.proxyProtocol);
    }
    return (A) this;
  }
  
  public A withRetryBudget(TrafficPolicyRetryBudget retryBudget) {
    this._visitables.remove("retryBudget");
    if (retryBudget != null) {
        this.retryBudget = new TrafficPolicyRetryBudgetBuilder(retryBudget);
        this._visitables.get("retryBudget").add(this.retryBudget);
    } else {
        this.retryBudget = null;
        this._visitables.get("retryBudget").remove(this.retryBudget);
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
  
  public A withTunnel(TrafficPolicyTunnelSettings tunnel) {
    this._visitables.remove("tunnel");
    if (tunnel != null) {
        this.tunnel = new TrafficPolicyTunnelSettingsBuilder(tunnel);
        this._visitables.get("tunnel").add(this.tunnel);
    } else {
        this.tunnel = null;
        this._visitables.get("tunnel").remove(this.tunnel);
    }
    return (A) this;
  }
  public class ConnectionPoolNested<N> extends ConnectionPoolSettingsFluent<ConnectionPoolNested<N>> implements Nested<N>{
  
    ConnectionPoolSettingsBuilder builder;
  
    ConnectionPoolNested(ConnectionPoolSettings item) {
      this.builder = new ConnectionPoolSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyFluent.this.withConnectionPool(builder.build());
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
      return (N) TrafficPolicyFluent.this.withLoadBalancer(builder.build());
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
      return (N) TrafficPolicyFluent.this.withOutlierDetection(builder.build());
    }
    
    public N endOutlierDetection() {
      return and();
    }
    
  }
  public class PortLevelSettingsNested<N> extends TrafficPolicyPortTrafficPolicyFluent<PortLevelSettingsNested<N>> implements Nested<N>{
  
    TrafficPolicyPortTrafficPolicyBuilder builder;
    int index;
  
    PortLevelSettingsNested(int index,TrafficPolicyPortTrafficPolicy item) {
      this.index = index;
      this.builder = new TrafficPolicyPortTrafficPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyFluent.this.setToPortLevelSettings(index, builder.build());
    }
    
    public N endPortLevelSetting() {
      return and();
    }
    
  }
  public class ProxyProtocolNested<N> extends TrafficPolicyProxyProtocolFluent<ProxyProtocolNested<N>> implements Nested<N>{
  
    TrafficPolicyProxyProtocolBuilder builder;
  
    ProxyProtocolNested(TrafficPolicyProxyProtocol item) {
      this.builder = new TrafficPolicyProxyProtocolBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyFluent.this.withProxyProtocol(builder.build());
    }
    
    public N endProxyProtocol() {
      return and();
    }
    
  }
  public class RetryBudgetNested<N> extends TrafficPolicyRetryBudgetFluent<RetryBudgetNested<N>> implements Nested<N>{
  
    TrafficPolicyRetryBudgetBuilder builder;
  
    RetryBudgetNested(TrafficPolicyRetryBudget item) {
      this.builder = new TrafficPolicyRetryBudgetBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyFluent.this.withRetryBudget(builder.build());
    }
    
    public N endRetryBudget() {
      return and();
    }
    
  }
  public class TlsNested<N> extends ClientTLSSettingsFluent<TlsNested<N>> implements Nested<N>{
  
    ClientTLSSettingsBuilder builder;
  
    TlsNested(ClientTLSSettings item) {
      this.builder = new ClientTLSSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
  public class TunnelNested<N> extends TrafficPolicyTunnelSettingsFluent<TunnelNested<N>> implements Nested<N>{
  
    TrafficPolicyTunnelSettingsBuilder builder;
  
    TunnelNested(TrafficPolicyTunnelSettings item) {
      this.builder = new TrafficPolicyTunnelSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficPolicyFluent.this.withTunnel(builder.build());
    }
    
    public N endTunnel() {
      return and();
    }
    
  }
}