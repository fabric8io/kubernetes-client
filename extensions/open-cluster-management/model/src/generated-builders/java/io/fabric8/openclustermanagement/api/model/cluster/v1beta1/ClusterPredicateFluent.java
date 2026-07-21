package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
public class ClusterPredicateFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ClusterPredicateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterSelectorBuilder requiredClusterSelector;

  public ClusterPredicateFluent() {
  }
  
  public ClusterPredicateFluent(ClusterPredicate instance) {
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
  
  public ClusterSelector buildRequiredClusterSelector() {
    return this.requiredClusterSelector != null ? this.requiredClusterSelector.build() : null;
  }
  
  protected void copyInstance(ClusterPredicate instance) {
    instance = instance != null ? instance : new ClusterPredicate();
    if (instance != null) {
        this.withRequiredClusterSelector(instance.getRequiredClusterSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequiredClusterSelectorNested<A> editOrNewRequiredClusterSelector() {
    return this.withNewRequiredClusterSelectorLike(Optional.ofNullable(this.buildRequiredClusterSelector()).orElse(new ClusterSelectorBuilder().build()));
  }
  
  public RequiredClusterSelectorNested<A> editOrNewRequiredClusterSelectorLike(ClusterSelector item) {
    return this.withNewRequiredClusterSelectorLike(Optional.ofNullable(this.buildRequiredClusterSelector()).orElse(item));
  }
  
  public RequiredClusterSelectorNested<A> editRequiredClusterSelector() {
    return this.withNewRequiredClusterSelectorLike(Optional.ofNullable(this.buildRequiredClusterSelector()).orElse(null));
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
    ClusterPredicateFluent that = (ClusterPredicateFluent) o;
    if (!(Objects.equals(requiredClusterSelector, that.requiredClusterSelector))) {
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
  
  public boolean hasRequiredClusterSelector() {
    return this.requiredClusterSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(requiredClusterSelector, additionalProperties);
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
    if (!(requiredClusterSelector == null)) {
        sb.append("requiredClusterSelector:");
        sb.append(requiredClusterSelector);
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
  
  public RequiredClusterSelectorNested<A> withNewRequiredClusterSelector() {
    return new RequiredClusterSelectorNested(null);
  }
  
  public RequiredClusterSelectorNested<A> withNewRequiredClusterSelectorLike(ClusterSelector item) {
    return new RequiredClusterSelectorNested(item);
  }
  
  public A withRequiredClusterSelector(ClusterSelector requiredClusterSelector) {
    this._visitables.remove("requiredClusterSelector");
    if (requiredClusterSelector != null) {
        this.requiredClusterSelector = new ClusterSelectorBuilder(requiredClusterSelector);
        this._visitables.get("requiredClusterSelector").add(this.requiredClusterSelector);
    } else {
        this.requiredClusterSelector = null;
        this._visitables.get("requiredClusterSelector").remove(this.requiredClusterSelector);
    }
    return (A) this;
  }
  public class RequiredClusterSelectorNested<N> extends ClusterSelectorFluent<RequiredClusterSelectorNested<N>> implements Nested<N>{
  
    ClusterSelectorBuilder builder;
  
    RequiredClusterSelectorNested(ClusterSelector item) {
      this.builder = new ClusterSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPredicateFluent.this.withRequiredClusterSelector(builder.build());
    }
    
    public N endRequiredClusterSelector() {
      return and();
    }
    
  }
}