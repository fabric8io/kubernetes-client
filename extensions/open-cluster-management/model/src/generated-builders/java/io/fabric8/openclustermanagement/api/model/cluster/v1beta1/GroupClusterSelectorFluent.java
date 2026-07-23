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
public class GroupClusterSelectorFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.GroupClusterSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterClaimSelectorBuilder claimSelector;
  private LabelSelectorBuilder labelSelector;

  public GroupClusterSelectorFluent() {
  }
  
  public GroupClusterSelectorFluent(GroupClusterSelector instance) {
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
  
  public ClusterClaimSelector buildClaimSelector() {
    return this.claimSelector != null ? this.claimSelector.build() : null;
  }
  
  public LabelSelector buildLabelSelector() {
    return this.labelSelector != null ? this.labelSelector.build() : null;
  }
  
  protected void copyInstance(GroupClusterSelector instance) {
    instance = instance != null ? instance : new GroupClusterSelector();
    if (instance != null) {
        this.withClaimSelector(instance.getClaimSelector());
        this.withLabelSelector(instance.getLabelSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClaimSelectorNested<A> editClaimSelector() {
    return this.withNewClaimSelectorLike(Optional.ofNullable(this.buildClaimSelector()).orElse(null));
  }
  
  public LabelSelectorNested<A> editLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(null));
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
    GroupClusterSelectorFluent that = (GroupClusterSelectorFluent) o;
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
  
  public boolean hasClaimSelector() {
    return this.claimSelector != null;
  }
  
  public boolean hasLabelSelector() {
    return this.labelSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(claimSelector, labelSelector, additionalProperties);
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
  public class ClaimSelectorNested<N> extends ClusterClaimSelectorFluent<ClaimSelectorNested<N>> implements Nested<N>{
  
    ClusterClaimSelectorBuilder builder;
  
    ClaimSelectorNested(ClusterClaimSelector item) {
      this.builder = new ClusterClaimSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) GroupClusterSelectorFluent.this.withClaimSelector(builder.build());
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
      return (N) GroupClusterSelectorFluent.this.withLabelSelector(builder.build());
    }
    
    public N endLabelSelector() {
      return and();
    }
    
  }
}