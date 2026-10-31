package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class NetworkSelectorFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.NetworkSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterUserDefinedNetworkSelectorBuilder clusterUserDefinedNetworkSelector;
  private NetworkAttachmentDefinitionSelectorBuilder networkAttachmentDefinitionSelector;
  private String networkSelectionType;
  private PrimaryUserDefinedNetworkSelectorBuilder primaryUserDefinedNetworkSelector;
  private SecondaryUserDefinedNetworkSelectorBuilder secondaryUserDefinedNetworkSelector;

  public NetworkSelectorFluent() {
  }
  
  public NetworkSelectorFluent(NetworkSelector instance) {
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
  
  public ClusterUserDefinedNetworkSelector buildClusterUserDefinedNetworkSelector() {
    return this.clusterUserDefinedNetworkSelector != null ? this.clusterUserDefinedNetworkSelector.build() : null;
  }
  
  public NetworkAttachmentDefinitionSelector buildNetworkAttachmentDefinitionSelector() {
    return this.networkAttachmentDefinitionSelector != null ? this.networkAttachmentDefinitionSelector.build() : null;
  }
  
  public PrimaryUserDefinedNetworkSelector buildPrimaryUserDefinedNetworkSelector() {
    return this.primaryUserDefinedNetworkSelector != null ? this.primaryUserDefinedNetworkSelector.build() : null;
  }
  
  public SecondaryUserDefinedNetworkSelector buildSecondaryUserDefinedNetworkSelector() {
    return this.secondaryUserDefinedNetworkSelector != null ? this.secondaryUserDefinedNetworkSelector.build() : null;
  }
  
  protected void copyInstance(NetworkSelector instance) {
    instance = instance != null ? instance : new NetworkSelector();
    if (instance != null) {
        this.withClusterUserDefinedNetworkSelector(instance.getClusterUserDefinedNetworkSelector());
        this.withNetworkAttachmentDefinitionSelector(instance.getNetworkAttachmentDefinitionSelector());
        this.withNetworkSelectionType(instance.getNetworkSelectionType());
        this.withPrimaryUserDefinedNetworkSelector(instance.getPrimaryUserDefinedNetworkSelector());
        this.withSecondaryUserDefinedNetworkSelector(instance.getSecondaryUserDefinedNetworkSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterUserDefinedNetworkSelectorNested<A> editClusterUserDefinedNetworkSelector() {
    return this.withNewClusterUserDefinedNetworkSelectorLike(Optional.ofNullable(this.buildClusterUserDefinedNetworkSelector()).orElse(null));
  }
  
  public NetworkAttachmentDefinitionSelectorNested<A> editNetworkAttachmentDefinitionSelector() {
    return this.withNewNetworkAttachmentDefinitionSelectorLike(Optional.ofNullable(this.buildNetworkAttachmentDefinitionSelector()).orElse(null));
  }
  
  public ClusterUserDefinedNetworkSelectorNested<A> editOrNewClusterUserDefinedNetworkSelector() {
    return this.withNewClusterUserDefinedNetworkSelectorLike(Optional.ofNullable(this.buildClusterUserDefinedNetworkSelector()).orElse(new ClusterUserDefinedNetworkSelectorBuilder().build()));
  }
  
  public ClusterUserDefinedNetworkSelectorNested<A> editOrNewClusterUserDefinedNetworkSelectorLike(ClusterUserDefinedNetworkSelector item) {
    return this.withNewClusterUserDefinedNetworkSelectorLike(Optional.ofNullable(this.buildClusterUserDefinedNetworkSelector()).orElse(item));
  }
  
  public NetworkAttachmentDefinitionSelectorNested<A> editOrNewNetworkAttachmentDefinitionSelector() {
    return this.withNewNetworkAttachmentDefinitionSelectorLike(Optional.ofNullable(this.buildNetworkAttachmentDefinitionSelector()).orElse(new NetworkAttachmentDefinitionSelectorBuilder().build()));
  }
  
  public NetworkAttachmentDefinitionSelectorNested<A> editOrNewNetworkAttachmentDefinitionSelectorLike(NetworkAttachmentDefinitionSelector item) {
    return this.withNewNetworkAttachmentDefinitionSelectorLike(Optional.ofNullable(this.buildNetworkAttachmentDefinitionSelector()).orElse(item));
  }
  
  public PrimaryUserDefinedNetworkSelectorNested<A> editOrNewPrimaryUserDefinedNetworkSelector() {
    return this.withNewPrimaryUserDefinedNetworkSelectorLike(Optional.ofNullable(this.buildPrimaryUserDefinedNetworkSelector()).orElse(new PrimaryUserDefinedNetworkSelectorBuilder().build()));
  }
  
  public PrimaryUserDefinedNetworkSelectorNested<A> editOrNewPrimaryUserDefinedNetworkSelectorLike(PrimaryUserDefinedNetworkSelector item) {
    return this.withNewPrimaryUserDefinedNetworkSelectorLike(Optional.ofNullable(this.buildPrimaryUserDefinedNetworkSelector()).orElse(item));
  }
  
  public SecondaryUserDefinedNetworkSelectorNested<A> editOrNewSecondaryUserDefinedNetworkSelector() {
    return this.withNewSecondaryUserDefinedNetworkSelectorLike(Optional.ofNullable(this.buildSecondaryUserDefinedNetworkSelector()).orElse(new SecondaryUserDefinedNetworkSelectorBuilder().build()));
  }
  
  public SecondaryUserDefinedNetworkSelectorNested<A> editOrNewSecondaryUserDefinedNetworkSelectorLike(SecondaryUserDefinedNetworkSelector item) {
    return this.withNewSecondaryUserDefinedNetworkSelectorLike(Optional.ofNullable(this.buildSecondaryUserDefinedNetworkSelector()).orElse(item));
  }
  
  public PrimaryUserDefinedNetworkSelectorNested<A> editPrimaryUserDefinedNetworkSelector() {
    return this.withNewPrimaryUserDefinedNetworkSelectorLike(Optional.ofNullable(this.buildPrimaryUserDefinedNetworkSelector()).orElse(null));
  }
  
  public SecondaryUserDefinedNetworkSelectorNested<A> editSecondaryUserDefinedNetworkSelector() {
    return this.withNewSecondaryUserDefinedNetworkSelectorLike(Optional.ofNullable(this.buildSecondaryUserDefinedNetworkSelector()).orElse(null));
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
    NetworkSelectorFluent that = (NetworkSelectorFluent) o;
    if (!(Objects.equals(clusterUserDefinedNetworkSelector, that.clusterUserDefinedNetworkSelector))) {
      return false;
    }
    if (!(Objects.equals(networkAttachmentDefinitionSelector, that.networkAttachmentDefinitionSelector))) {
      return false;
    }
    if (!(Objects.equals(networkSelectionType, that.networkSelectionType))) {
      return false;
    }
    if (!(Objects.equals(primaryUserDefinedNetworkSelector, that.primaryUserDefinedNetworkSelector))) {
      return false;
    }
    if (!(Objects.equals(secondaryUserDefinedNetworkSelector, that.secondaryUserDefinedNetworkSelector))) {
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
  
  public String getNetworkSelectionType() {
    return this.networkSelectionType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterUserDefinedNetworkSelector() {
    return this.clusterUserDefinedNetworkSelector != null;
  }
  
  public boolean hasNetworkAttachmentDefinitionSelector() {
    return this.networkAttachmentDefinitionSelector != null;
  }
  
  public boolean hasNetworkSelectionType() {
    return this.networkSelectionType != null;
  }
  
  public boolean hasPrimaryUserDefinedNetworkSelector() {
    return this.primaryUserDefinedNetworkSelector != null;
  }
  
  public boolean hasSecondaryUserDefinedNetworkSelector() {
    return this.secondaryUserDefinedNetworkSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterUserDefinedNetworkSelector, networkAttachmentDefinitionSelector, networkSelectionType, primaryUserDefinedNetworkSelector, secondaryUserDefinedNetworkSelector, additionalProperties);
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
    if (!(clusterUserDefinedNetworkSelector == null)) {
        sb.append("clusterUserDefinedNetworkSelector:");
        sb.append(clusterUserDefinedNetworkSelector);
        sb.append(",");
    }
    if (!(networkAttachmentDefinitionSelector == null)) {
        sb.append("networkAttachmentDefinitionSelector:");
        sb.append(networkAttachmentDefinitionSelector);
        sb.append(",");
    }
    if (!(networkSelectionType == null)) {
        sb.append("networkSelectionType:");
        sb.append(networkSelectionType);
        sb.append(",");
    }
    if (!(primaryUserDefinedNetworkSelector == null)) {
        sb.append("primaryUserDefinedNetworkSelector:");
        sb.append(primaryUserDefinedNetworkSelector);
        sb.append(",");
    }
    if (!(secondaryUserDefinedNetworkSelector == null)) {
        sb.append("secondaryUserDefinedNetworkSelector:");
        sb.append(secondaryUserDefinedNetworkSelector);
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
  
  public A withClusterUserDefinedNetworkSelector(ClusterUserDefinedNetworkSelector clusterUserDefinedNetworkSelector) {
    this._visitables.remove("clusterUserDefinedNetworkSelector");
    if (clusterUserDefinedNetworkSelector != null) {
        this.clusterUserDefinedNetworkSelector = new ClusterUserDefinedNetworkSelectorBuilder(clusterUserDefinedNetworkSelector);
        this._visitables.get("clusterUserDefinedNetworkSelector").add(this.clusterUserDefinedNetworkSelector);
    } else {
        this.clusterUserDefinedNetworkSelector = null;
        this._visitables.get("clusterUserDefinedNetworkSelector").remove(this.clusterUserDefinedNetworkSelector);
    }
    return (A) this;
  }
  
  public A withNetworkAttachmentDefinitionSelector(NetworkAttachmentDefinitionSelector networkAttachmentDefinitionSelector) {
    this._visitables.remove("networkAttachmentDefinitionSelector");
    if (networkAttachmentDefinitionSelector != null) {
        this.networkAttachmentDefinitionSelector = new NetworkAttachmentDefinitionSelectorBuilder(networkAttachmentDefinitionSelector);
        this._visitables.get("networkAttachmentDefinitionSelector").add(this.networkAttachmentDefinitionSelector);
    } else {
        this.networkAttachmentDefinitionSelector = null;
        this._visitables.get("networkAttachmentDefinitionSelector").remove(this.networkAttachmentDefinitionSelector);
    }
    return (A) this;
  }
  
  public A withNetworkSelectionType(String networkSelectionType) {
    this.networkSelectionType = networkSelectionType;
    return (A) this;
  }
  
  public ClusterUserDefinedNetworkSelectorNested<A> withNewClusterUserDefinedNetworkSelector() {
    return new ClusterUserDefinedNetworkSelectorNested(null);
  }
  
  public ClusterUserDefinedNetworkSelectorNested<A> withNewClusterUserDefinedNetworkSelectorLike(ClusterUserDefinedNetworkSelector item) {
    return new ClusterUserDefinedNetworkSelectorNested(item);
  }
  
  public NetworkAttachmentDefinitionSelectorNested<A> withNewNetworkAttachmentDefinitionSelector() {
    return new NetworkAttachmentDefinitionSelectorNested(null);
  }
  
  public NetworkAttachmentDefinitionSelectorNested<A> withNewNetworkAttachmentDefinitionSelectorLike(NetworkAttachmentDefinitionSelector item) {
    return new NetworkAttachmentDefinitionSelectorNested(item);
  }
  
  public PrimaryUserDefinedNetworkSelectorNested<A> withNewPrimaryUserDefinedNetworkSelector() {
    return new PrimaryUserDefinedNetworkSelectorNested(null);
  }
  
  public PrimaryUserDefinedNetworkSelectorNested<A> withNewPrimaryUserDefinedNetworkSelectorLike(PrimaryUserDefinedNetworkSelector item) {
    return new PrimaryUserDefinedNetworkSelectorNested(item);
  }
  
  public SecondaryUserDefinedNetworkSelectorNested<A> withNewSecondaryUserDefinedNetworkSelector() {
    return new SecondaryUserDefinedNetworkSelectorNested(null);
  }
  
  public SecondaryUserDefinedNetworkSelectorNested<A> withNewSecondaryUserDefinedNetworkSelectorLike(SecondaryUserDefinedNetworkSelector item) {
    return new SecondaryUserDefinedNetworkSelectorNested(item);
  }
  
  public A withPrimaryUserDefinedNetworkSelector(PrimaryUserDefinedNetworkSelector primaryUserDefinedNetworkSelector) {
    this._visitables.remove("primaryUserDefinedNetworkSelector");
    if (primaryUserDefinedNetworkSelector != null) {
        this.primaryUserDefinedNetworkSelector = new PrimaryUserDefinedNetworkSelectorBuilder(primaryUserDefinedNetworkSelector);
        this._visitables.get("primaryUserDefinedNetworkSelector").add(this.primaryUserDefinedNetworkSelector);
    } else {
        this.primaryUserDefinedNetworkSelector = null;
        this._visitables.get("primaryUserDefinedNetworkSelector").remove(this.primaryUserDefinedNetworkSelector);
    }
    return (A) this;
  }
  
  public A withSecondaryUserDefinedNetworkSelector(SecondaryUserDefinedNetworkSelector secondaryUserDefinedNetworkSelector) {
    this._visitables.remove("secondaryUserDefinedNetworkSelector");
    if (secondaryUserDefinedNetworkSelector != null) {
        this.secondaryUserDefinedNetworkSelector = new SecondaryUserDefinedNetworkSelectorBuilder(secondaryUserDefinedNetworkSelector);
        this._visitables.get("secondaryUserDefinedNetworkSelector").add(this.secondaryUserDefinedNetworkSelector);
    } else {
        this.secondaryUserDefinedNetworkSelector = null;
        this._visitables.get("secondaryUserDefinedNetworkSelector").remove(this.secondaryUserDefinedNetworkSelector);
    }
    return (A) this;
  }
  public class ClusterUserDefinedNetworkSelectorNested<N> extends ClusterUserDefinedNetworkSelectorFluent<ClusterUserDefinedNetworkSelectorNested<N>> implements Nested<N>{
  
    ClusterUserDefinedNetworkSelectorBuilder builder;
  
    ClusterUserDefinedNetworkSelectorNested(ClusterUserDefinedNetworkSelector item) {
      this.builder = new ClusterUserDefinedNetworkSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSelectorFluent.this.withClusterUserDefinedNetworkSelector(builder.build());
    }
    
    public N endClusterUserDefinedNetworkSelector() {
      return and();
    }
    
  }
  public class NetworkAttachmentDefinitionSelectorNested<N> extends NetworkAttachmentDefinitionSelectorFluent<NetworkAttachmentDefinitionSelectorNested<N>> implements Nested<N>{
  
    NetworkAttachmentDefinitionSelectorBuilder builder;
  
    NetworkAttachmentDefinitionSelectorNested(NetworkAttachmentDefinitionSelector item) {
      this.builder = new NetworkAttachmentDefinitionSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSelectorFluent.this.withNetworkAttachmentDefinitionSelector(builder.build());
    }
    
    public N endNetworkAttachmentDefinitionSelector() {
      return and();
    }
    
  }
  public class PrimaryUserDefinedNetworkSelectorNested<N> extends PrimaryUserDefinedNetworkSelectorFluent<PrimaryUserDefinedNetworkSelectorNested<N>> implements Nested<N>{
  
    PrimaryUserDefinedNetworkSelectorBuilder builder;
  
    PrimaryUserDefinedNetworkSelectorNested(PrimaryUserDefinedNetworkSelector item) {
      this.builder = new PrimaryUserDefinedNetworkSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSelectorFluent.this.withPrimaryUserDefinedNetworkSelector(builder.build());
    }
    
    public N endPrimaryUserDefinedNetworkSelector() {
      return and();
    }
    
  }
  public class SecondaryUserDefinedNetworkSelectorNested<N> extends SecondaryUserDefinedNetworkSelectorFluent<SecondaryUserDefinedNetworkSelectorNested<N>> implements Nested<N>{
  
    SecondaryUserDefinedNetworkSelectorBuilder builder;
  
    SecondaryUserDefinedNetworkSelectorNested(SecondaryUserDefinedNetworkSelector item) {
      this.builder = new SecondaryUserDefinedNetworkSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSelectorFluent.this.withSecondaryUserDefinedNetworkSelector(builder.build());
    }
    
    public N endSecondaryUserDefinedNetworkSelector() {
      return and();
    }
    
  }
}