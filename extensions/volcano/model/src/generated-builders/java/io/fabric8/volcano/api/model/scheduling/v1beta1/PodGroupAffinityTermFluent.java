package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class PodGroupAffinityTermFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.PodGroupAffinityTermFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder namespaceSelector;
  private LabelSelectorBuilder podGroupSelector;
  private Integer topologyTier;
  private String topologyTierName;
  private Integer weight;

  public PodGroupAffinityTermFluent() {
  }
  
  public PodGroupAffinityTermFluent(PodGroupAffinityTerm instance) {
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
  
  public LabelSelector buildPodGroupSelector() {
    return this.podGroupSelector != null ? this.podGroupSelector.build() : null;
  }
  
  protected void copyInstance(PodGroupAffinityTerm instance) {
    instance = instance != null ? instance : new PodGroupAffinityTerm();
    if (instance != null) {
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withPodGroupSelector(instance.getPodGroupSelector());
        this.withTopologyTier(instance.getTopologyTier());
        this.withTopologyTierName(instance.getTopologyTierName());
        this.withWeight(instance.getWeight());
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
  
  public PodGroupSelectorNested<A> editOrNewPodGroupSelector() {
    return this.withNewPodGroupSelectorLike(Optional.ofNullable(this.buildPodGroupSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public PodGroupSelectorNested<A> editOrNewPodGroupSelectorLike(LabelSelector item) {
    return this.withNewPodGroupSelectorLike(Optional.ofNullable(this.buildPodGroupSelector()).orElse(item));
  }
  
  public PodGroupSelectorNested<A> editPodGroupSelector() {
    return this.withNewPodGroupSelectorLike(Optional.ofNullable(this.buildPodGroupSelector()).orElse(null));
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
    PodGroupAffinityTermFluent that = (PodGroupAffinityTermFluent) o;
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(podGroupSelector, that.podGroupSelector))) {
      return false;
    }
    if (!(Objects.equals(topologyTier, that.topologyTier))) {
      return false;
    }
    if (!(Objects.equals(topologyTierName, that.topologyTierName))) {
      return false;
    }
    if (!(Objects.equals(weight, that.weight))) {
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
  
  public Integer getTopologyTier() {
    return this.topologyTier;
  }
  
  public String getTopologyTierName() {
    return this.topologyTierName;
  }
  
  public Integer getWeight() {
    return this.weight;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasPodGroupSelector() {
    return this.podGroupSelector != null;
  }
  
  public boolean hasTopologyTier() {
    return this.topologyTier != null;
  }
  
  public boolean hasTopologyTierName() {
    return this.topologyTierName != null;
  }
  
  public boolean hasWeight() {
    return this.weight != null;
  }
  
  public int hashCode() {
    return Objects.hash(namespaceSelector, podGroupSelector, topologyTier, topologyTierName, weight, additionalProperties);
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
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(podGroupSelector == null)) {
        sb.append("podGroupSelector:");
        sb.append(podGroupSelector);
        sb.append(",");
    }
    if (!(topologyTier == null)) {
        sb.append("topologyTier:");
        sb.append(topologyTier);
        sb.append(",");
    }
    if (!(topologyTierName == null)) {
        sb.append("topologyTierName:");
        sb.append(topologyTierName);
        sb.append(",");
    }
    if (!(weight == null)) {
        sb.append("weight:");
        sb.append(weight);
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
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public PodGroupSelectorNested<A> withNewPodGroupSelector() {
    return new PodGroupSelectorNested(null);
  }
  
  public PodGroupSelectorNested<A> withNewPodGroupSelectorLike(LabelSelector item) {
    return new PodGroupSelectorNested(item);
  }
  
  public A withPodGroupSelector(LabelSelector podGroupSelector) {
    this._visitables.remove("podGroupSelector");
    if (podGroupSelector != null) {
        this.podGroupSelector = new LabelSelectorBuilder(podGroupSelector);
        this._visitables.get("podGroupSelector").add(this.podGroupSelector);
    } else {
        this.podGroupSelector = null;
        this._visitables.get("podGroupSelector").remove(this.podGroupSelector);
    }
    return (A) this;
  }
  
  public A withTopologyTier(Integer topologyTier) {
    this.topologyTier = topologyTier;
    return (A) this;
  }
  
  public A withTopologyTierName(String topologyTierName) {
    this.topologyTierName = topologyTierName;
    return (A) this;
  }
  
  public A withWeight(Integer weight) {
    this.weight = weight;
    return (A) this;
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupAffinityTermFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class PodGroupSelectorNested<N> extends LabelSelectorFluent<PodGroupSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    PodGroupSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupAffinityTermFluent.this.withPodGroupSelector(builder.build());
    }
    
    public N endPodGroupSelector() {
      return and();
    }
    
  }
}