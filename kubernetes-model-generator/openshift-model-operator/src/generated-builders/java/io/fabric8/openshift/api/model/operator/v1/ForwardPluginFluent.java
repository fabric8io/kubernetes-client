package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class ForwardPluginFluent<A extends io.fabric8.openshift.api.model.operator.v1.ForwardPluginFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String policy;
  private String protocolStrategy;
  private DNSTransportConfigBuilder transportConfig;
  private List<String> upstreams = new ArrayList<String>();

  public ForwardPluginFluent() {
  }
  
  public ForwardPluginFluent(ForwardPlugin instance) {
    this.copyInstance(instance);
  }

  public A addAllToUpstreams(Collection<String> items) {
    if (this.upstreams == null) {
      this.upstreams = new ArrayList();
    }
    for (String item : items) {
      this.upstreams.add(item);
    }
    return (A) this;
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
  
  public A addToUpstreams(String... items) {
    if (this.upstreams == null) {
      this.upstreams = new ArrayList();
    }
    for (String item : items) {
      this.upstreams.add(item);
    }
    return (A) this;
  }
  
  public A addToUpstreams(int index,String item) {
    if (this.upstreams == null) {
      this.upstreams = new ArrayList();
    }
    this.upstreams.add(index, item);
    return (A) this;
  }
  
  public DNSTransportConfig buildTransportConfig() {
    return this.transportConfig != null ? this.transportConfig.build() : null;
  }
  
  protected void copyInstance(ForwardPlugin instance) {
    instance = instance != null ? instance : new ForwardPlugin();
    if (instance != null) {
        this.withPolicy(instance.getPolicy());
        this.withProtocolStrategy(instance.getProtocolStrategy());
        this.withTransportConfig(instance.getTransportConfig());
        this.withUpstreams(instance.getUpstreams());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TransportConfigNested<A> editOrNewTransportConfig() {
    return this.withNewTransportConfigLike(Optional.ofNullable(this.buildTransportConfig()).orElse(new DNSTransportConfigBuilder().build()));
  }
  
  public TransportConfigNested<A> editOrNewTransportConfigLike(DNSTransportConfig item) {
    return this.withNewTransportConfigLike(Optional.ofNullable(this.buildTransportConfig()).orElse(item));
  }
  
  public TransportConfigNested<A> editTransportConfig() {
    return this.withNewTransportConfigLike(Optional.ofNullable(this.buildTransportConfig()).orElse(null));
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
    ForwardPluginFluent that = (ForwardPluginFluent) o;
    if (!(Objects.equals(policy, that.policy))) {
      return false;
    }
    if (!(Objects.equals(protocolStrategy, that.protocolStrategy))) {
      return false;
    }
    if (!(Objects.equals(transportConfig, that.transportConfig))) {
      return false;
    }
    if (!(Objects.equals(upstreams, that.upstreams))) {
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
  
  public String getFirstUpstream() {
    return this.upstreams.get(0);
  }
  
  public String getLastUpstream() {
    return this.upstreams.get(upstreams.size() - 1);
  }
  
  public String getMatchingUpstream(Predicate<String> predicate) {
      for (String item : upstreams) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPolicy() {
    return this.policy;
  }
  
  public String getProtocolStrategy() {
    return this.protocolStrategy;
  }
  
  public String getUpstream(int index) {
    return this.upstreams.get(index);
  }
  
  public List<String> getUpstreams() {
    return this.upstreams;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingUpstream(Predicate<String> predicate) {
      for (String item : upstreams) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicy() {
    return this.policy != null;
  }
  
  public boolean hasProtocolStrategy() {
    return this.protocolStrategy != null;
  }
  
  public boolean hasTransportConfig() {
    return this.transportConfig != null;
  }
  
  public boolean hasUpstreams() {
    return this.upstreams != null && !(this.upstreams.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(policy, protocolStrategy, transportConfig, upstreams, additionalProperties);
  }
  
  public A removeAllFromUpstreams(Collection<String> items) {
    if (this.upstreams == null) {
      return (A) this;
    }
    for (String item : items) {
      this.upstreams.remove(item);
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
  
  public A removeFromUpstreams(String... items) {
    if (this.upstreams == null) {
      return (A) this;
    }
    for (String item : items) {
      this.upstreams.remove(item);
    }
    return (A) this;
  }
  
  public A setToUpstreams(int index,String item) {
    if (this.upstreams == null) {
      this.upstreams = new ArrayList();
    }
    this.upstreams.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(policy == null)) {
        sb.append("policy:");
        sb.append(policy);
        sb.append(",");
    }
    if (!(protocolStrategy == null)) {
        sb.append("protocolStrategy:");
        sb.append(protocolStrategy);
        sb.append(",");
    }
    if (!(transportConfig == null)) {
        sb.append("transportConfig:");
        sb.append(transportConfig);
        sb.append(",");
    }
    if (!(upstreams == null) && !(upstreams.isEmpty())) {
        sb.append("upstreams:");
        sb.append(upstreams);
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
  
  public TransportConfigNested<A> withNewTransportConfig() {
    return new TransportConfigNested(null);
  }
  
  public TransportConfigNested<A> withNewTransportConfigLike(DNSTransportConfig item) {
    return new TransportConfigNested(item);
  }
  
  public A withPolicy(String policy) {
    this.policy = policy;
    return (A) this;
  }
  
  public A withProtocolStrategy(String protocolStrategy) {
    this.protocolStrategy = protocolStrategy;
    return (A) this;
  }
  
  public A withTransportConfig(DNSTransportConfig transportConfig) {
    this._visitables.remove("transportConfig");
    if (transportConfig != null) {
        this.transportConfig = new DNSTransportConfigBuilder(transportConfig);
        this._visitables.get("transportConfig").add(this.transportConfig);
    } else {
        this.transportConfig = null;
        this._visitables.get("transportConfig").remove(this.transportConfig);
    }
    return (A) this;
  }
  
  public A withUpstreams(List<String> upstreams) {
    if (upstreams != null) {
        this.upstreams = new ArrayList();
        for (String item : upstreams) {
          this.addToUpstreams(item);
        }
    } else {
      this.upstreams = null;
    }
    return (A) this;
  }
  
  public A withUpstreams(String... upstreams) {
    if (this.upstreams != null) {
        this.upstreams.clear();
        _visitables.remove("upstreams");
    }
    if (upstreams != null) {
      for (String item : upstreams) {
        this.addToUpstreams(item);
      }
    }
    return (A) this;
  }
  public class TransportConfigNested<N> extends DNSTransportConfigFluent<TransportConfigNested<N>> implements Nested<N>{
  
    DNSTransportConfigBuilder builder;
  
    TransportConfigNested(DNSTransportConfig item) {
      this.builder = new DNSTransportConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ForwardPluginFluent.this.withTransportConfig(builder.build());
    }
    
    public N endTransportConfig() {
      return and();
    }
    
  }
}