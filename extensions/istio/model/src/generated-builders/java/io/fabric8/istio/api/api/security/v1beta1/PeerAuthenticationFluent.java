package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorFluent;
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
public class PeerAuthenticationFluent<A extends io.fabric8.istio.api.api.security.v1beta1.PeerAuthenticationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PeerAuthenticationMutualTLSBuilder mtls;
  private Map<String,PeerAuthenticationMutualTLS> portLevelMtls;
  private WorkloadSelectorBuilder selector;

  public PeerAuthenticationFluent() {
  }
  
  public PeerAuthenticationFluent(PeerAuthentication instance) {
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
  
  public A addToPortLevelMtls(Map<String,PeerAuthenticationMutualTLS> map) {
    if (this.portLevelMtls == null && map != null) {
      this.portLevelMtls = new LinkedHashMap();
    }
    if (map != null) {
      this.portLevelMtls.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPortLevelMtls(String key,PeerAuthenticationMutualTLS value) {
    if (this.portLevelMtls == null && key != null && value != null) {
      this.portLevelMtls = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.portLevelMtls.put(key, value);
    }
    return (A) this;
  }
  
  public PeerAuthenticationMutualTLS buildMtls() {
    return this.mtls != null ? this.mtls.build() : null;
  }
  
  public WorkloadSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(PeerAuthentication instance) {
    instance = instance != null ? instance : new PeerAuthentication();
    if (instance != null) {
        this.withMtls(instance.getMtls());
        this.withPortLevelMtls(instance.getPortLevelMtls());
        this.withSelector(instance.getSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MtlsNested<A> editMtls() {
    return this.withNewMtlsLike(Optional.ofNullable(this.buildMtls()).orElse(null));
  }
  
  public MtlsNested<A> editOrNewMtls() {
    return this.withNewMtlsLike(Optional.ofNullable(this.buildMtls()).orElse(new PeerAuthenticationMutualTLSBuilder().build()));
  }
  
  public MtlsNested<A> editOrNewMtlsLike(PeerAuthenticationMutualTLS item) {
    return this.withNewMtlsLike(Optional.ofNullable(this.buildMtls()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new WorkloadSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(WorkloadSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    PeerAuthenticationFluent that = (PeerAuthenticationFluent) o;
    if (!(Objects.equals(mtls, that.mtls))) {
      return false;
    }
    if (!(Objects.equals(portLevelMtls, that.portLevelMtls))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
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
  
  public Map<String,PeerAuthenticationMutualTLS> getPortLevelMtls() {
    return this.portLevelMtls;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMtls() {
    return this.mtls != null;
  }
  
  public boolean hasPortLevelMtls() {
    return this.portLevelMtls != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public int hashCode() {
    return Objects.hash(mtls, portLevelMtls, selector, additionalProperties);
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
  
  public A removeFromPortLevelMtls(String key) {
    if (this.portLevelMtls == null) {
      return (A) this;
    }
    if (key != null && this.portLevelMtls != null) {
      this.portLevelMtls.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPortLevelMtls(Map<String,PeerAuthenticationMutualTLS> map) {
    if (this.portLevelMtls == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.portLevelMtls != null) {
          this.portLevelMtls.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(mtls == null)) {
        sb.append("mtls:");
        sb.append(mtls);
        sb.append(",");
    }
    if (!(portLevelMtls == null) && !(portLevelMtls.isEmpty())) {
        sb.append("portLevelMtls:");
        sb.append(portLevelMtls);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
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
  
  public A withMtls(PeerAuthenticationMutualTLS mtls) {
    this._visitables.remove("mtls");
    if (mtls != null) {
        this.mtls = new PeerAuthenticationMutualTLSBuilder(mtls);
        this._visitables.get("mtls").add(this.mtls);
    } else {
        this.mtls = null;
        this._visitables.get("mtls").remove(this.mtls);
    }
    return (A) this;
  }
  
  public MtlsNested<A> withNewMtls() {
    return new MtlsNested(null);
  }
  
  public MtlsNested<A> withNewMtlsLike(PeerAuthenticationMutualTLS item) {
    return new MtlsNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(WorkloadSelector item) {
    return new SelectorNested(item);
  }
  
  public <K,V>A withPortLevelMtls(Map<String,PeerAuthenticationMutualTLS> portLevelMtls) {
    if (portLevelMtls == null) {
      this.portLevelMtls = null;
    } else {
      this.portLevelMtls = new LinkedHashMap(portLevelMtls);
    }
    return (A) this;
  }
  
  public A withSelector(WorkloadSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new WorkloadSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  public class MtlsNested<N> extends PeerAuthenticationMutualTLSFluent<MtlsNested<N>> implements Nested<N>{
  
    PeerAuthenticationMutualTLSBuilder builder;
  
    MtlsNested(PeerAuthenticationMutualTLS item) {
      this.builder = new PeerAuthenticationMutualTLSBuilder(this, item);
    }
  
    public N and() {
      return (N) PeerAuthenticationFluent.this.withMtls(builder.build());
    }
    
    public N endMtls() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends WorkloadSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    SelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PeerAuthenticationFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}