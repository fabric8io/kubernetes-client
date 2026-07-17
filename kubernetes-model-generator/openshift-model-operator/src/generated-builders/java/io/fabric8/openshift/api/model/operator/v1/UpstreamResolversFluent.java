package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class UpstreamResolversFluent<A extends io.fabric8.openshift.api.model.operator.v1.UpstreamResolversFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String policy;
  private String protocolStrategy;
  private DNSTransportConfigBuilder transportConfig;
  private ArrayList<UpstreamBuilder> upstreams = new ArrayList<UpstreamBuilder>();

  public UpstreamResolversFluent() {
  }
  
  public UpstreamResolversFluent(UpstreamResolvers instance) {
    this.copyInstance(instance);
  }

  public A addAllToUpstreams(Collection<Upstream> items) {
    if (this.upstreams == null) {
      this.upstreams = new ArrayList();
    }
    for (Upstream item : items) {
        UpstreamBuilder builder = new UpstreamBuilder(item);
        _visitables.get("upstreams").add(builder);
        this.upstreams.add(builder);
    }
    return (A) this;
  }
  
  public UpstreamsNested<A> addNewUpstream() {
    return new UpstreamsNested(-1, null);
  }
  
  public A addNewUpstream(String address,Long port,String type) {
    return (A) this.addToUpstreams(new Upstream(address, port, type));
  }
  
  public UpstreamsNested<A> addNewUpstreamLike(Upstream item) {
    return new UpstreamsNested(-1, item);
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
  
  public A addToUpstreams(Upstream... items) {
    if (this.upstreams == null) {
      this.upstreams = new ArrayList();
    }
    for (Upstream item : items) {
        UpstreamBuilder builder = new UpstreamBuilder(item);
        _visitables.get("upstreams").add(builder);
        this.upstreams.add(builder);
    }
    return (A) this;
  }
  
  public A addToUpstreams(int index,Upstream item) {
    if (this.upstreams == null) {
      this.upstreams = new ArrayList();
    }
    UpstreamBuilder builder = new UpstreamBuilder(item);
    if (index < 0 || index >= upstreams.size()) {
        _visitables.get("upstreams").add(builder);
        upstreams.add(builder);
    } else {
        _visitables.get("upstreams").add(builder);
        upstreams.add(index, builder);
    }
    return (A) this;
  }
  
  public Upstream buildFirstUpstream() {
    return this.upstreams.get(0).build();
  }
  
  public Upstream buildLastUpstream() {
    return this.upstreams.get(upstreams.size() - 1).build();
  }
  
  public Upstream buildMatchingUpstream(Predicate<UpstreamBuilder> predicate) {
      for (UpstreamBuilder item : upstreams) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DNSTransportConfig buildTransportConfig() {
    return this.transportConfig != null ? this.transportConfig.build() : null;
  }
  
  public Upstream buildUpstream(int index) {
    return this.upstreams.get(index).build();
  }
  
  public List<Upstream> buildUpstreams() {
    return this.upstreams != null ? build(upstreams) : null;
  }
  
  protected void copyInstance(UpstreamResolvers instance) {
    instance = instance != null ? instance : new UpstreamResolvers();
    if (instance != null) {
        this.withPolicy(instance.getPolicy());
        this.withProtocolStrategy(instance.getProtocolStrategy());
        this.withTransportConfig(instance.getTransportConfig());
        this.withUpstreams(instance.getUpstreams());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public UpstreamsNested<A> editFirstUpstream() {
    if (upstreams.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "upstreams"));
    }
    return this.setNewUpstreamLike(0, this.buildUpstream(0));
  }
  
  public UpstreamsNested<A> editLastUpstream() {
    int index = upstreams.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "upstreams"));
    }
    return this.setNewUpstreamLike(index, this.buildUpstream(index));
  }
  
  public UpstreamsNested<A> editMatchingUpstream(Predicate<UpstreamBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < upstreams.size();i++) {
      if (predicate.test(upstreams.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "upstreams"));
    }
    return this.setNewUpstreamLike(index, this.buildUpstream(index));
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
  
  public UpstreamsNested<A> editUpstream(int index) {
    if (upstreams.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "upstreams"));
    }
    return this.setNewUpstreamLike(index, this.buildUpstream(index));
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
    UpstreamResolversFluent that = (UpstreamResolversFluent) o;
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
  
  public String getPolicy() {
    return this.policy;
  }
  
  public String getProtocolStrategy() {
    return this.protocolStrategy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingUpstream(Predicate<UpstreamBuilder> predicate) {
      for (UpstreamBuilder item : upstreams) {
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
  
  public A removeAllFromUpstreams(Collection<Upstream> items) {
    if (this.upstreams == null) {
      return (A) this;
    }
    for (Upstream item : items) {
        UpstreamBuilder builder = new UpstreamBuilder(item);
        _visitables.get("upstreams").remove(builder);
        this.upstreams.remove(builder);
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
  
  public A removeFromUpstreams(Upstream... items) {
    if (this.upstreams == null) {
      return (A) this;
    }
    for (Upstream item : items) {
        UpstreamBuilder builder = new UpstreamBuilder(item);
        _visitables.get("upstreams").remove(builder);
        this.upstreams.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromUpstreams(Predicate<UpstreamBuilder> predicate) {
    if (upstreams == null) {
      return (A) this;
    }
    Iterator<UpstreamBuilder> each = upstreams.iterator();
    List visitables = _visitables.get("upstreams");
    while (each.hasNext()) {
        UpstreamBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public UpstreamsNested<A> setNewUpstreamLike(int index,Upstream item) {
    return new UpstreamsNested(index, item);
  }
  
  public A setToUpstreams(int index,Upstream item) {
    if (this.upstreams == null) {
      this.upstreams = new ArrayList();
    }
    UpstreamBuilder builder = new UpstreamBuilder(item);
    if (index < 0 || index >= upstreams.size()) {
        _visitables.get("upstreams").add(builder);
        upstreams.add(builder);
    } else {
        _visitables.get("upstreams").add(builder);
        upstreams.set(index, builder);
    }
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
  
  public A withUpstreams(List<Upstream> upstreams) {
    if (this.upstreams != null) {
      this._visitables.get("upstreams").clear();
    }
    if (upstreams != null) {
        this.upstreams = new ArrayList();
        for (Upstream item : upstreams) {
          this.addToUpstreams(item);
        }
    } else {
      this.upstreams = null;
    }
    return (A) this;
  }
  
  public A withUpstreams(Upstream... upstreams) {
    if (this.upstreams != null) {
        this.upstreams.clear();
        _visitables.remove("upstreams");
    }
    if (upstreams != null) {
      for (Upstream item : upstreams) {
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
      return (N) UpstreamResolversFluent.this.withTransportConfig(builder.build());
    }
    
    public N endTransportConfig() {
      return and();
    }
    
  }
  public class UpstreamsNested<N> extends UpstreamFluent<UpstreamsNested<N>> implements Nested<N>{
  
    UpstreamBuilder builder;
    int index;
  
    UpstreamsNested(int index,Upstream item) {
      this.index = index;
      this.builder = new UpstreamBuilder(this, item);
    }
  
    public N and() {
      return (N) UpstreamResolversFluent.this.setToUpstreams(index, builder.build());
    }
    
    public N endUpstream() {
      return and();
    }
    
  }
}