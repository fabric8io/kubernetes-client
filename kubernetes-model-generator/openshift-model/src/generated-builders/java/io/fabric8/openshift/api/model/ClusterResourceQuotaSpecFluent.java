package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ResourceQuotaSpec;
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
public class ClusterResourceQuotaSpecFluent<A extends io.fabric8.openshift.api.model.ClusterResourceQuotaSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ResourceQuotaSpec quota;
  private ClusterResourceQuotaSelectorBuilder selector;

  public ClusterResourceQuotaSpecFluent() {
  }
  
  public ClusterResourceQuotaSpecFluent(ClusterResourceQuotaSpec instance) {
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
  
  public ClusterResourceQuotaSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(ClusterResourceQuotaSpec instance) {
    instance = instance != null ? instance : new ClusterResourceQuotaSpec();
    if (instance != null) {
        this.withQuota(instance.getQuota());
        this.withSelector(instance.getSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new ClusterResourceQuotaSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(ClusterResourceQuotaSelector item) {
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
    ClusterResourceQuotaSpecFluent that = (ClusterResourceQuotaSpecFluent) o;
    if (!(Objects.equals(quota, that.quota))) {
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
  
  public ResourceQuotaSpec getQuota() {
    return this.quota;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasQuota() {
    return this.quota != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public int hashCode() {
    return Objects.hash(quota, selector, additionalProperties);
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
    if (!(quota == null)) {
        sb.append("quota:");
        sb.append(quota);
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
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(ClusterResourceQuotaSelector item) {
    return new SelectorNested(item);
  }
  
  public A withQuota(ResourceQuotaSpec quota) {
    this.quota = quota;
    return (A) this;
  }
  
  public A withSelector(ClusterResourceQuotaSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new ClusterResourceQuotaSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  public class SelectorNested<N> extends ClusterResourceQuotaSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    ClusterResourceQuotaSelectorBuilder builder;
  
    SelectorNested(ClusterResourceQuotaSelector item) {
      this.builder = new ClusterResourceQuotaSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterResourceQuotaSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}