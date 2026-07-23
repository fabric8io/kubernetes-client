package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import java.lang.Boolean;
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
public class DynamicHopFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.DynamicHopFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean bfdEnabled;
  private LabelSelectorBuilder namespaceSelector;
  private String networkAttachmentName;
  private LabelSelectorBuilder podSelector;

  public DynamicHopFluent() {
  }
  
  public DynamicHopFluent(DynamicHop instance) {
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
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public LabelSelector buildPodSelector() {
    return this.podSelector != null ? this.podSelector.build() : null;
  }
  
  protected void copyInstance(DynamicHop instance) {
    instance = instance != null ? instance : new DynamicHop();
    if (instance != null) {
        this.withBfdEnabled(instance.getBfdEnabled());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withNetworkAttachmentName(instance.getNetworkAttachmentName());
        this.withPodSelector(instance.getPodSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
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
    DynamicHopFluent that = (DynamicHopFluent) o;
    if (!(Objects.equals(bfdEnabled, that.bfdEnabled))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(networkAttachmentName, that.networkAttachmentName))) {
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
  
  public Boolean getBfdEnabled() {
    return this.bfdEnabled;
  }
  
  public String getNetworkAttachmentName() {
    return this.networkAttachmentName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBfdEnabled() {
    return this.bfdEnabled != null;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasNetworkAttachmentName() {
    return this.networkAttachmentName != null;
  }
  
  public boolean hasPodSelector() {
    return this.podSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(bfdEnabled, namespaceSelector, networkAttachmentName, podSelector, additionalProperties);
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
    if (!(bfdEnabled == null)) {
        sb.append("bfdEnabled:");
        sb.append(bfdEnabled);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(networkAttachmentName == null)) {
        sb.append("networkAttachmentName:");
        sb.append(networkAttachmentName);
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
  
  public A withBfdEnabled() {
    return withBfdEnabled(true);
  }
  
  public A withBfdEnabled(Boolean bfdEnabled) {
    this.bfdEnabled = bfdEnabled;
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
  
  public A withNetworkAttachmentName(String networkAttachmentName) {
    this.networkAttachmentName = networkAttachmentName;
    return (A) this;
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
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) DynamicHopFluent.this.withNamespaceSelector(builder.build());
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
      return (N) DynamicHopFluent.this.withPodSelector(builder.build());
    }
    
    public N endPodSelector() {
      return and();
    }
    
  }
}