package io.fabric8.openshift.api.model.hive.v1;

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
public class FeatureGateSelectionFluent<A extends io.fabric8.openshift.api.model.hive.v1.FeatureGateSelectionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FeatureGatesEnabledBuilder custom;
  private String featureSet;

  public FeatureGateSelectionFluent() {
  }
  
  public FeatureGateSelectionFluent(FeatureGateSelection instance) {
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
  
  public FeatureGatesEnabled buildCustom() {
    return this.custom != null ? this.custom.build() : null;
  }
  
  protected void copyInstance(FeatureGateSelection instance) {
    instance = instance != null ? instance : new FeatureGateSelection();
    if (instance != null) {
        this.withCustom(instance.getCustom());
        this.withFeatureSet(instance.getFeatureSet());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomNested<A> editCustom() {
    return this.withNewCustomLike(Optional.ofNullable(this.buildCustom()).orElse(null));
  }
  
  public CustomNested<A> editOrNewCustom() {
    return this.withNewCustomLike(Optional.ofNullable(this.buildCustom()).orElse(new FeatureGatesEnabledBuilder().build()));
  }
  
  public CustomNested<A> editOrNewCustomLike(FeatureGatesEnabled item) {
    return this.withNewCustomLike(Optional.ofNullable(this.buildCustom()).orElse(item));
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
    FeatureGateSelectionFluent that = (FeatureGateSelectionFluent) o;
    if (!(Objects.equals(custom, that.custom))) {
      return false;
    }
    if (!(Objects.equals(featureSet, that.featureSet))) {
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
  
  public String getFeatureSet() {
    return this.featureSet;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCustom() {
    return this.custom != null;
  }
  
  public boolean hasFeatureSet() {
    return this.featureSet != null;
  }
  
  public int hashCode() {
    return Objects.hash(custom, featureSet, additionalProperties);
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
    if (!(custom == null)) {
        sb.append("custom:");
        sb.append(custom);
        sb.append(",");
    }
    if (!(featureSet == null)) {
        sb.append("featureSet:");
        sb.append(featureSet);
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
  
  public A withCustom(FeatureGatesEnabled custom) {
    this._visitables.remove("custom");
    if (custom != null) {
        this.custom = new FeatureGatesEnabledBuilder(custom);
        this._visitables.get("custom").add(this.custom);
    } else {
        this.custom = null;
        this._visitables.get("custom").remove(this.custom);
    }
    return (A) this;
  }
  
  public A withFeatureSet(String featureSet) {
    this.featureSet = featureSet;
    return (A) this;
  }
  
  public CustomNested<A> withNewCustom() {
    return new CustomNested(null);
  }
  
  public CustomNested<A> withNewCustomLike(FeatureGatesEnabled item) {
    return new CustomNested(item);
  }
  public class CustomNested<N> extends FeatureGatesEnabledFluent<CustomNested<N>> implements Nested<N>{
  
    FeatureGatesEnabledBuilder builder;
  
    CustomNested(FeatureGatesEnabled item) {
      this.builder = new FeatureGatesEnabledBuilder(this, item);
    }
  
    public N and() {
      return (N) FeatureGateSelectionFluent.this.withCustom(builder.build());
    }
    
    public N endCustom() {
      return and();
    }
    
  }
}