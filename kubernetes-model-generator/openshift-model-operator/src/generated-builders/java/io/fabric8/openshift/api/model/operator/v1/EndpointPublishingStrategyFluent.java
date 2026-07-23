package io.fabric8.openshift.api.model.operator.v1;

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
public class EndpointPublishingStrategyFluent<A extends io.fabric8.openshift.api.model.operator.v1.EndpointPublishingStrategyFluent<A>> extends BaseFluent<A>{

  private PrivateStrategyBuilder _private;
  private Map<String,Object> additionalProperties;
  private HostNetworkStrategyBuilder hostNetwork;
  private LoadBalancerStrategyBuilder loadBalancer;
  private NodePortStrategyBuilder nodePort;
  private String type;

  public EndpointPublishingStrategyFluent() {
  }
  
  public EndpointPublishingStrategyFluent(EndpointPublishingStrategy instance) {
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
  
  public HostNetworkStrategy buildHostNetwork() {
    return this.hostNetwork != null ? this.hostNetwork.build() : null;
  }
  
  public LoadBalancerStrategy buildLoadBalancer() {
    return this.loadBalancer != null ? this.loadBalancer.build() : null;
  }
  
  public NodePortStrategy buildNodePort() {
    return this.nodePort != null ? this.nodePort.build() : null;
  }
  
  public PrivateStrategy buildPrivate() {
    return this._private != null ? this._private.build() : null;
  }
  
  protected void copyInstance(EndpointPublishingStrategy instance) {
    instance = instance != null ? instance : new EndpointPublishingStrategy();
    if (instance != null) {
        this.withHostNetwork(instance.getHostNetwork());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withNodePort(instance.getNodePort());
        this.withPrivate(instance.getPrivate());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HostNetworkNested<A> editHostNetwork() {
    return this.withNewHostNetworkLike(Optional.ofNullable(this.buildHostNetwork()).orElse(null));
  }
  
  public LoadBalancerNested<A> editLoadBalancer() {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(null));
  }
  
  public NodePortNested<A> editNodePort() {
    return this.withNewNodePortLike(Optional.ofNullable(this.buildNodePort()).orElse(null));
  }
  
  public HostNetworkNested<A> editOrNewHostNetwork() {
    return this.withNewHostNetworkLike(Optional.ofNullable(this.buildHostNetwork()).orElse(new HostNetworkStrategyBuilder().build()));
  }
  
  public HostNetworkNested<A> editOrNewHostNetworkLike(HostNetworkStrategy item) {
    return this.withNewHostNetworkLike(Optional.ofNullable(this.buildHostNetwork()).orElse(item));
  }
  
  public LoadBalancerNested<A> editOrNewLoadBalancer() {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(new LoadBalancerStrategyBuilder().build()));
  }
  
  public LoadBalancerNested<A> editOrNewLoadBalancerLike(LoadBalancerStrategy item) {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(item));
  }
  
  public NodePortNested<A> editOrNewNodePort() {
    return this.withNewNodePortLike(Optional.ofNullable(this.buildNodePort()).orElse(new NodePortStrategyBuilder().build()));
  }
  
  public NodePortNested<A> editOrNewNodePortLike(NodePortStrategy item) {
    return this.withNewNodePortLike(Optional.ofNullable(this.buildNodePort()).orElse(item));
  }
  
  public PrivateNested<A> editOrNewPrivate() {
    return this.withNewPrivateLike(Optional.ofNullable(this.buildPrivate()).orElse(new PrivateStrategyBuilder().build()));
  }
  
  public PrivateNested<A> editOrNewPrivateLike(PrivateStrategy item) {
    return this.withNewPrivateLike(Optional.ofNullable(this.buildPrivate()).orElse(item));
  }
  
  public PrivateNested<A> editPrivate() {
    return this.withNewPrivateLike(Optional.ofNullable(this.buildPrivate()).orElse(null));
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
    EndpointPublishingStrategyFluent that = (EndpointPublishingStrategyFluent) o;
    if (!(Objects.equals(hostNetwork, that.hostNetwork))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
      return false;
    }
    if (!(Objects.equals(nodePort, that.nodePort))) {
      return false;
    }
    if (!(Objects.equals(_private, that._private))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHostNetwork() {
    return this.hostNetwork != null;
  }
  
  public boolean hasLoadBalancer() {
    return this.loadBalancer != null;
  }
  
  public boolean hasNodePort() {
    return this.nodePort != null;
  }
  
  public boolean hasPrivate() {
    return this._private != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostNetwork, loadBalancer, nodePort, _private, type, additionalProperties);
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
    if (!(hostNetwork == null)) {
        sb.append("hostNetwork:");
        sb.append(hostNetwork);
        sb.append(",");
    }
    if (!(loadBalancer == null)) {
        sb.append("loadBalancer:");
        sb.append(loadBalancer);
        sb.append(",");
    }
    if (!(nodePort == null)) {
        sb.append("nodePort:");
        sb.append(nodePort);
        sb.append(",");
    }
    if (!(_private == null)) {
        sb.append("_private:");
        sb.append(_private);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withHostNetwork(HostNetworkStrategy hostNetwork) {
    this._visitables.remove("hostNetwork");
    if (hostNetwork != null) {
        this.hostNetwork = new HostNetworkStrategyBuilder(hostNetwork);
        this._visitables.get("hostNetwork").add(this.hostNetwork);
    } else {
        this.hostNetwork = null;
        this._visitables.get("hostNetwork").remove(this.hostNetwork);
    }
    return (A) this;
  }
  
  public A withLoadBalancer(LoadBalancerStrategy loadBalancer) {
    this._visitables.remove("loadBalancer");
    if (loadBalancer != null) {
        this.loadBalancer = new LoadBalancerStrategyBuilder(loadBalancer);
        this._visitables.get("loadBalancer").add(this.loadBalancer);
    } else {
        this.loadBalancer = null;
        this._visitables.get("loadBalancer").remove(this.loadBalancer);
    }
    return (A) this;
  }
  
  public HostNetworkNested<A> withNewHostNetwork() {
    return new HostNetworkNested(null);
  }
  
  public A withNewHostNetwork(Integer httpPort,Integer httpsPort,String protocol,Integer statsPort) {
    return (A) this.withHostNetwork(new HostNetworkStrategy(httpPort, httpsPort, protocol, statsPort));
  }
  
  public HostNetworkNested<A> withNewHostNetworkLike(HostNetworkStrategy item) {
    return new HostNetworkNested(item);
  }
  
  public LoadBalancerNested<A> withNewLoadBalancer() {
    return new LoadBalancerNested(null);
  }
  
  public LoadBalancerNested<A> withNewLoadBalancerLike(LoadBalancerStrategy item) {
    return new LoadBalancerNested(item);
  }
  
  public NodePortNested<A> withNewNodePort() {
    return new NodePortNested(null);
  }
  
  public A withNewNodePort(String protocol) {
    return (A) this.withNodePort(new NodePortStrategy(protocol));
  }
  
  public NodePortNested<A> withNewNodePortLike(NodePortStrategy item) {
    return new NodePortNested(item);
  }
  
  public PrivateNested<A> withNewPrivate() {
    return new PrivateNested(null);
  }
  
  public A withNewPrivate(String protocol) {
    return (A) this.withPrivate(new PrivateStrategy(protocol));
  }
  
  public PrivateNested<A> withNewPrivateLike(PrivateStrategy item) {
    return new PrivateNested(item);
  }
  
  public A withNodePort(NodePortStrategy nodePort) {
    this._visitables.remove("nodePort");
    if (nodePort != null) {
        this.nodePort = new NodePortStrategyBuilder(nodePort);
        this._visitables.get("nodePort").add(this.nodePort);
    } else {
        this.nodePort = null;
        this._visitables.get("nodePort").remove(this.nodePort);
    }
    return (A) this;
  }
  
  public A withPrivate(PrivateStrategy _private) {
    this._visitables.remove("_private");
    if (_private != null) {
        this._private = new PrivateStrategyBuilder(_private);
        this._visitables.get("_private").add(this._private);
    } else {
        this._private = null;
        this._visitables.get("_private").remove(this._private);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class HostNetworkNested<N> extends HostNetworkStrategyFluent<HostNetworkNested<N>> implements Nested<N>{
  
    HostNetworkStrategyBuilder builder;
  
    HostNetworkNested(HostNetworkStrategy item) {
      this.builder = new HostNetworkStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointPublishingStrategyFluent.this.withHostNetwork(builder.build());
    }
    
    public N endHostNetwork() {
      return and();
    }
    
  }
  public class LoadBalancerNested<N> extends LoadBalancerStrategyFluent<LoadBalancerNested<N>> implements Nested<N>{
  
    LoadBalancerStrategyBuilder builder;
  
    LoadBalancerNested(LoadBalancerStrategy item) {
      this.builder = new LoadBalancerStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointPublishingStrategyFluent.this.withLoadBalancer(builder.build());
    }
    
    public N endLoadBalancer() {
      return and();
    }
    
  }
  public class NodePortNested<N> extends NodePortStrategyFluent<NodePortNested<N>> implements Nested<N>{
  
    NodePortStrategyBuilder builder;
  
    NodePortNested(NodePortStrategy item) {
      this.builder = new NodePortStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointPublishingStrategyFluent.this.withNodePort(builder.build());
    }
    
    public N endNodePort() {
      return and();
    }
    
  }
  public class PrivateNested<N> extends PrivateStrategyFluent<PrivateNested<N>> implements Nested<N>{
  
    PrivateStrategyBuilder builder;
  
    PrivateNested(PrivateStrategy item) {
      this.builder = new PrivateStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointPublishingStrategyFluent.this.withPrivate(builder.build());
    }
    
    public N endPrivate() {
      return and();
    }
    
  }
}