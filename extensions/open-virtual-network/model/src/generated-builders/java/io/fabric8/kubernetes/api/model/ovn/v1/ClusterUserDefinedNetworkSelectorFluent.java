package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class ClusterUserDefinedNetworkSelectorFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.ClusterUserDefinedNetworkSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder networkSelector;

  public ClusterUserDefinedNetworkSelectorFluent() {
  }
  
  public ClusterUserDefinedNetworkSelectorFluent(ClusterUserDefinedNetworkSelector instance) {
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
  
  public LabelSelector buildNetworkSelector() {
    return this.networkSelector != null ? this.networkSelector.build() : null;
  }
  
  protected void copyInstance(ClusterUserDefinedNetworkSelector instance) {
    instance = instance != null ? instance : new ClusterUserDefinedNetworkSelector();
    if (instance != null) {
        this.withNetworkSelector(instance.getNetworkSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NetworkSelectorNested<A> editNetworkSelector() {
    return this.withNewNetworkSelectorLike(Optional.ofNullable(this.buildNetworkSelector()).orElse(null));
  }
  
  public NetworkSelectorNested<A> editOrNewNetworkSelector() {
    return this.withNewNetworkSelectorLike(Optional.ofNullable(this.buildNetworkSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NetworkSelectorNested<A> editOrNewNetworkSelectorLike(LabelSelector item) {
    return this.withNewNetworkSelectorLike(Optional.ofNullable(this.buildNetworkSelector()).orElse(item));
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
    ClusterUserDefinedNetworkSelectorFluent that = (ClusterUserDefinedNetworkSelectorFluent) o;
    if (!(Objects.equals(networkSelector, that.networkSelector))) {
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
  
  public boolean hasNetworkSelector() {
    return this.networkSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(networkSelector, additionalProperties);
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
    if (!(networkSelector == null)) {
        sb.append("networkSelector:");
        sb.append(networkSelector);
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
  
  public A withNetworkSelector(LabelSelector networkSelector) {
    this._visitables.remove("networkSelector");
    if (networkSelector != null) {
        this.networkSelector = new LabelSelectorBuilder(networkSelector);
        this._visitables.get("networkSelector").add(this.networkSelector);
    } else {
        this.networkSelector = null;
        this._visitables.get("networkSelector").remove(this.networkSelector);
    }
    return (A) this;
  }
  
  public NetworkSelectorNested<A> withNewNetworkSelector() {
    return new NetworkSelectorNested(null);
  }
  
  public NetworkSelectorNested<A> withNewNetworkSelectorLike(LabelSelector item) {
    return new NetworkSelectorNested(item);
  }
  public class NetworkSelectorNested<N> extends LabelSelectorFluent<NetworkSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NetworkSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterUserDefinedNetworkSelectorFluent.this.withNetworkSelector(builder.build());
    }
    
    public N endNetworkSelector() {
      return and();
    }
    
  }
}