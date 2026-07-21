package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
public class ClusterSelectorFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ClusterSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterCelSelectorBuilder celSelector;
  private ClusterClaimSelectorBuilder claimSelector;
  private LabelSelectorBuilder labelSelector;

  public ClusterSelectorFluent() {
  }
  
  public ClusterSelectorFluent(ClusterSelector instance) {
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
  
  public ClusterCelSelector buildCelSelector() {
    return this.celSelector != null ? this.celSelector.build() : null;
  }
  
  public ClusterClaimSelector buildClaimSelector() {
    return this.claimSelector != null ? this.claimSelector.build() : null;
  }
  
  public LabelSelector buildLabelSelector() {
    return this.labelSelector != null ? this.labelSelector.build() : null;
  }
  
  protected void copyInstance(ClusterSelector instance) {
    instance = instance != null ? instance : new ClusterSelector();
    if (instance != null) {
        this.withCelSelector(instance.getCelSelector());
        this.withClaimSelector(instance.getClaimSelector());
        this.withLabelSelector(instance.getLabelSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CelSelectorNested<A> editCelSelector() {
    return this.withNewCelSelectorLike(Optional.ofNullable(this.buildCelSelector()).orElse(null));
  }
  
  public ClaimSelectorNested<A> editClaimSelector() {
    return this.withNewClaimSelectorLike(Optional.ofNullable(this.buildClaimSelector()).orElse(null));
  }
  
  public LabelSelectorNested<A> editLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(null));
  }
  
  public CelSelectorNested<A> editOrNewCelSelector() {
    return this.withNewCelSelectorLike(Optional.ofNullable(this.buildCelSelector()).orElse(new ClusterCelSelectorBuilder().build()));
  }
  
  public CelSelectorNested<A> editOrNewCelSelectorLike(ClusterCelSelector item) {
    return this.withNewCelSelectorLike(Optional.ofNullable(this.buildCelSelector()).orElse(item));
  }
  
  public ClaimSelectorNested<A> editOrNewClaimSelector() {
    return this.withNewClaimSelectorLike(Optional.ofNullable(this.buildClaimSelector()).orElse(new ClusterClaimSelectorBuilder().build()));
  }
  
  public ClaimSelectorNested<A> editOrNewClaimSelectorLike(ClusterClaimSelector item) {
    return this.withNewClaimSelectorLike(Optional.ofNullable(this.buildClaimSelector()).orElse(item));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelectorLike(LabelSelector item) {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(item));
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
    ClusterSelectorFluent that = (ClusterSelectorFluent) o;
    if (!(Objects.equals(celSelector, that.celSelector))) {
      return false;
    }
    if (!(Objects.equals(claimSelector, that.claimSelector))) {
      return false;
    }
    if (!(Objects.equals(labelSelector, that.labelSelector))) {
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
  
  public boolean hasCelSelector() {
    return this.celSelector != null;
  }
  
  public boolean hasClaimSelector() {
    return this.claimSelector != null;
  }
  
  public boolean hasLabelSelector() {
    return this.labelSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(celSelector, claimSelector, labelSelector, additionalProperties);
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
    if (!(celSelector == null)) {
        sb.append("celSelector:");
        sb.append(celSelector);
        sb.append(",");
    }
    if (!(claimSelector == null)) {
        sb.append("claimSelector:");
        sb.append(claimSelector);
        sb.append(",");
    }
    if (!(labelSelector == null)) {
        sb.append("labelSelector:");
        sb.append(labelSelector);
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
  
  public A withCelSelector(ClusterCelSelector celSelector) {
    this._visitables.remove("celSelector");
    if (celSelector != null) {
        this.celSelector = new ClusterCelSelectorBuilder(celSelector);
        this._visitables.get("celSelector").add(this.celSelector);
    } else {
        this.celSelector = null;
        this._visitables.get("celSelector").remove(this.celSelector);
    }
    return (A) this;
  }
  
  public A withClaimSelector(ClusterClaimSelector claimSelector) {
    this._visitables.remove("claimSelector");
    if (claimSelector != null) {
        this.claimSelector = new ClusterClaimSelectorBuilder(claimSelector);
        this._visitables.get("claimSelector").add(this.claimSelector);
    } else {
        this.claimSelector = null;
        this._visitables.get("claimSelector").remove(this.claimSelector);
    }
    return (A) this;
  }
  
  public A withLabelSelector(LabelSelector labelSelector) {
    this._visitables.remove("labelSelector");
    if (labelSelector != null) {
        this.labelSelector = new LabelSelectorBuilder(labelSelector);
        this._visitables.get("labelSelector").add(this.labelSelector);
    } else {
        this.labelSelector = null;
        this._visitables.get("labelSelector").remove(this.labelSelector);
    }
    return (A) this;
  }
  
  public CelSelectorNested<A> withNewCelSelector() {
    return new CelSelectorNested(null);
  }
  
  public CelSelectorNested<A> withNewCelSelectorLike(ClusterCelSelector item) {
    return new CelSelectorNested(item);
  }
  
  public ClaimSelectorNested<A> withNewClaimSelector() {
    return new ClaimSelectorNested(null);
  }
  
  public ClaimSelectorNested<A> withNewClaimSelectorLike(ClusterClaimSelector item) {
    return new ClaimSelectorNested(item);
  }
  
  public LabelSelectorNested<A> withNewLabelSelector() {
    return new LabelSelectorNested(null);
  }
  
  public LabelSelectorNested<A> withNewLabelSelectorLike(LabelSelector item) {
    return new LabelSelectorNested(item);
  }
  public class CelSelectorNested<N> extends ClusterCelSelectorFluent<CelSelectorNested<N>> implements Nested<N>{
  
    ClusterCelSelectorBuilder builder;
  
    CelSelectorNested(ClusterCelSelector item) {
      this.builder = new ClusterCelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterSelectorFluent.this.withCelSelector(builder.build());
    }
    
    public N endCelSelector() {
      return and();
    }
    
  }
  public class ClaimSelectorNested<N> extends ClusterClaimSelectorFluent<ClaimSelectorNested<N>> implements Nested<N>{
  
    ClusterClaimSelectorBuilder builder;
  
    ClaimSelectorNested(ClusterClaimSelector item) {
      this.builder = new ClusterClaimSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterSelectorFluent.this.withClaimSelector(builder.build());
    }
    
    public N endClaimSelector() {
      return and();
    }
    
  }
  public class LabelSelectorNested<N> extends LabelSelectorFluent<LabelSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    LabelSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterSelectorFluent.this.withLabelSelector(builder.build());
    }
    
    public N endLabelSelector() {
      return and();
    }
    
  }
}