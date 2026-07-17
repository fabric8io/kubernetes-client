package io.fabric8.openshift.api.model.operator.v1;

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
public class ExportNetworkFlowsFluent<A extends io.fabric8.openshift.api.model.operator.v1.ExportNetworkFlowsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IPFIXConfigBuilder ipfix;
  private NetFlowConfigBuilder netFlow;
  private SFlowConfigBuilder sFlow;

  public ExportNetworkFlowsFluent() {
  }
  
  public ExportNetworkFlowsFluent(ExportNetworkFlows instance) {
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
  
  public IPFIXConfig buildIpfix() {
    return this.ipfix != null ? this.ipfix.build() : null;
  }
  
  public NetFlowConfig buildNetFlow() {
    return this.netFlow != null ? this.netFlow.build() : null;
  }
  
  public SFlowConfig buildSFlow() {
    return this.sFlow != null ? this.sFlow.build() : null;
  }
  
  protected void copyInstance(ExportNetworkFlows instance) {
    instance = instance != null ? instance : new ExportNetworkFlows();
    if (instance != null) {
        this.withIpfix(instance.getIpfix());
        this.withNetFlow(instance.getNetFlow());
        this.withSFlow(instance.getSFlow());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IpfixNested<A> editIpfix() {
    return this.withNewIpfixLike(Optional.ofNullable(this.buildIpfix()).orElse(null));
  }
  
  public NetFlowNested<A> editNetFlow() {
    return this.withNewNetFlowLike(Optional.ofNullable(this.buildNetFlow()).orElse(null));
  }
  
  public IpfixNested<A> editOrNewIpfix() {
    return this.withNewIpfixLike(Optional.ofNullable(this.buildIpfix()).orElse(new IPFIXConfigBuilder().build()));
  }
  
  public IpfixNested<A> editOrNewIpfixLike(IPFIXConfig item) {
    return this.withNewIpfixLike(Optional.ofNullable(this.buildIpfix()).orElse(item));
  }
  
  public NetFlowNested<A> editOrNewNetFlow() {
    return this.withNewNetFlowLike(Optional.ofNullable(this.buildNetFlow()).orElse(new NetFlowConfigBuilder().build()));
  }
  
  public NetFlowNested<A> editOrNewNetFlowLike(NetFlowConfig item) {
    return this.withNewNetFlowLike(Optional.ofNullable(this.buildNetFlow()).orElse(item));
  }
  
  public SFlowNested<A> editOrNewSFlow() {
    return this.withNewSFlowLike(Optional.ofNullable(this.buildSFlow()).orElse(new SFlowConfigBuilder().build()));
  }
  
  public SFlowNested<A> editOrNewSFlowLike(SFlowConfig item) {
    return this.withNewSFlowLike(Optional.ofNullable(this.buildSFlow()).orElse(item));
  }
  
  public SFlowNested<A> editSFlow() {
    return this.withNewSFlowLike(Optional.ofNullable(this.buildSFlow()).orElse(null));
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
    ExportNetworkFlowsFluent that = (ExportNetworkFlowsFluent) o;
    if (!(Objects.equals(ipfix, that.ipfix))) {
      return false;
    }
    if (!(Objects.equals(netFlow, that.netFlow))) {
      return false;
    }
    if (!(Objects.equals(sFlow, that.sFlow))) {
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
  
  public boolean hasIpfix() {
    return this.ipfix != null;
  }
  
  public boolean hasNetFlow() {
    return this.netFlow != null;
  }
  
  public boolean hasSFlow() {
    return this.sFlow != null;
  }
  
  public int hashCode() {
    return Objects.hash(ipfix, netFlow, sFlow, additionalProperties);
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
    if (!(ipfix == null)) {
        sb.append("ipfix:");
        sb.append(ipfix);
        sb.append(",");
    }
    if (!(netFlow == null)) {
        sb.append("netFlow:");
        sb.append(netFlow);
        sb.append(",");
    }
    if (!(sFlow == null)) {
        sb.append("sFlow:");
        sb.append(sFlow);
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
  
  public A withIpfix(IPFIXConfig ipfix) {
    this._visitables.remove("ipfix");
    if (ipfix != null) {
        this.ipfix = new IPFIXConfigBuilder(ipfix);
        this._visitables.get("ipfix").add(this.ipfix);
    } else {
        this.ipfix = null;
        this._visitables.get("ipfix").remove(this.ipfix);
    }
    return (A) this;
  }
  
  public A withNetFlow(NetFlowConfig netFlow) {
    this._visitables.remove("netFlow");
    if (netFlow != null) {
        this.netFlow = new NetFlowConfigBuilder(netFlow);
        this._visitables.get("netFlow").add(this.netFlow);
    } else {
        this.netFlow = null;
        this._visitables.get("netFlow").remove(this.netFlow);
    }
    return (A) this;
  }
  
  public IpfixNested<A> withNewIpfix() {
    return new IpfixNested(null);
  }
  
  public IpfixNested<A> withNewIpfixLike(IPFIXConfig item) {
    return new IpfixNested(item);
  }
  
  public NetFlowNested<A> withNewNetFlow() {
    return new NetFlowNested(null);
  }
  
  public NetFlowNested<A> withNewNetFlowLike(NetFlowConfig item) {
    return new NetFlowNested(item);
  }
  
  public SFlowNested<A> withNewSFlow() {
    return new SFlowNested(null);
  }
  
  public SFlowNested<A> withNewSFlowLike(SFlowConfig item) {
    return new SFlowNested(item);
  }
  
  public A withSFlow(SFlowConfig sFlow) {
    this._visitables.remove("sFlow");
    if (sFlow != null) {
        this.sFlow = new SFlowConfigBuilder(sFlow);
        this._visitables.get("sFlow").add(this.sFlow);
    } else {
        this.sFlow = null;
        this._visitables.get("sFlow").remove(this.sFlow);
    }
    return (A) this;
  }
  public class IpfixNested<N> extends IPFIXConfigFluent<IpfixNested<N>> implements Nested<N>{
  
    IPFIXConfigBuilder builder;
  
    IpfixNested(IPFIXConfig item) {
      this.builder = new IPFIXConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ExportNetworkFlowsFluent.this.withIpfix(builder.build());
    }
    
    public N endIpfix() {
      return and();
    }
    
  }
  public class NetFlowNested<N> extends NetFlowConfigFluent<NetFlowNested<N>> implements Nested<N>{
  
    NetFlowConfigBuilder builder;
  
    NetFlowNested(NetFlowConfig item) {
      this.builder = new NetFlowConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ExportNetworkFlowsFluent.this.withNetFlow(builder.build());
    }
    
    public N endNetFlow() {
      return and();
    }
    
  }
  public class SFlowNested<N> extends SFlowConfigFluent<SFlowNested<N>> implements Nested<N>{
  
    SFlowConfigBuilder builder;
  
    SFlowNested(SFlowConfig item) {
      this.builder = new SFlowConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ExportNetworkFlowsFluent.this.withSFlow(builder.build());
    }
    
    public N endSFlow() {
      return and();
    }
    
  }
}