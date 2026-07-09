package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class NetworkPolicyPeerFluent<A extends io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyPeerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IPBlockBuilder ipBlock;
  private LabelSelectorBuilder namespaceSelector;
  private LabelSelectorBuilder podSelector;

  public NetworkPolicyPeerFluent() {
  }
  
  public NetworkPolicyPeerFluent(NetworkPolicyPeer instance) {
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
  
  public IPBlock buildIpBlock() {
    return this.ipBlock != null ? this.ipBlock.build() : null;
  }
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public LabelSelector buildPodSelector() {
    return this.podSelector != null ? this.podSelector.build() : null;
  }
  
  protected void copyInstance(NetworkPolicyPeer instance) {
    instance = instance != null ? instance : new NetworkPolicyPeer();
    if (instance != null) {
        this.withIpBlock(instance.getIpBlock());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withPodSelector(instance.getPodSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IpBlockNested<A> editIpBlock() {
    return this.withNewIpBlockLike(Optional.ofNullable(this.buildIpBlock()).orElse(null));
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public IpBlockNested<A> editOrNewIpBlock() {
    return this.withNewIpBlockLike(Optional.ofNullable(this.buildIpBlock()).orElse(new IPBlockBuilder().build()));
  }
  
  public IpBlockNested<A> editOrNewIpBlockLike(IPBlock item) {
    return this.withNewIpBlockLike(Optional.ofNullable(this.buildIpBlock()).orElse(item));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public PodSelectorNested<A> editOrNewPodSelector() {
    return this.withNewPodSelectorLike(Optional.ofNullable(this.buildPodSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public PodSelectorNested<A> editOrNewPodSelectorLike(LabelSelector item) {
    return this.withNewPodSelectorLike(Optional.ofNullable(this.buildPodSelector()).orElse(item));
  }
  
  public PodSelectorNested<A> editPodSelector() {
    return this.withNewPodSelectorLike(Optional.ofNullable(this.buildPodSelector()).orElse(null));
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
    NetworkPolicyPeerFluent that = (NetworkPolicyPeerFluent) o;
    if (!(Objects.equals(ipBlock, that.ipBlock))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(podSelector, that.podSelector))) {
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
  
  public boolean hasIpBlock() {
    return this.ipBlock != null;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasPodSelector() {
    return this.podSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(ipBlock, namespaceSelector, podSelector, additionalProperties);
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
    if (!(ipBlock == null)) {
        sb.append("ipBlock:");
        sb.append(ipBlock);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(podSelector == null)) {
        sb.append("podSelector:");
        sb.append(podSelector);
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
  
  public A withIpBlock(IPBlock ipBlock) {
    this._visitables.remove("ipBlock");
    if (ipBlock != null) {
        this.ipBlock = new IPBlockBuilder(ipBlock);
        this._visitables.get("ipBlock").add(this.ipBlock);
    } else {
        this.ipBlock = null;
        this._visitables.get("ipBlock").remove(this.ipBlock);
    }
    return (A) this;
  }
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public IpBlockNested<A> withNewIpBlock() {
    return new IpBlockNested(null);
  }
  
  public IpBlockNested<A> withNewIpBlockLike(IPBlock item) {
    return new IpBlockNested(item);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public PodSelectorNested<A> withNewPodSelector() {
    return new PodSelectorNested(null);
  }
  
  public PodSelectorNested<A> withNewPodSelectorLike(LabelSelector item) {
    return new PodSelectorNested(item);
  }
  
  public A withPodSelector(LabelSelector podSelector) {
    this._visitables.remove("podSelector");
    if (podSelector != null) {
        this.podSelector = new LabelSelectorBuilder(podSelector);
        this._visitables.get("podSelector").add(this.podSelector);
    } else {
        this.podSelector = null;
        this._visitables.get("podSelector").remove(this.podSelector);
    }
    return (A) this;
  }
  public class IpBlockNested<N> extends IPBlockFluent<IpBlockNested<N>> implements Nested<N>{
  
    IPBlockBuilder builder;
  
    IpBlockNested(IPBlock item) {
      this.builder = new IPBlockBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicyPeerFluent.this.withIpBlock(builder.build());
    }
    
    public N endIpBlock() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicyPeerFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class PodSelectorNested<N> extends LabelSelectorFluent<PodSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    PodSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicyPeerFluent.this.withPodSelector(builder.build());
    }
    
    public N endPodSelector() {
      return and();
    }
    
  }
}