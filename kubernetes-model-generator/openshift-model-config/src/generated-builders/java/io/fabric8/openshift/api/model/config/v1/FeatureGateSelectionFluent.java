package io.fabric8.openshift.api.model.config.v1;

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
public class FeatureGateSelectionFluent<A extends io.fabric8.openshift.api.model.config.v1.FeatureGateSelectionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CustomFeatureGatesBuilder customNoUpgrade;
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
  
  public CustomFeatureGates buildCustomNoUpgrade() {
    return this.customNoUpgrade != null ? this.customNoUpgrade.build() : null;
  }
  
  protected void copyInstance(FeatureGateSelection instance) {
    instance = instance != null ? instance : new FeatureGateSelection();
    if (instance != null) {
        this.withCustomNoUpgrade(instance.getCustomNoUpgrade());
        this.withFeatureSet(instance.getFeatureSet());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomNoUpgradeNested<A> editCustomNoUpgrade() {
    return this.withNewCustomNoUpgradeLike(Optional.ofNullable(this.buildCustomNoUpgrade()).orElse(null));
  }
  
  public CustomNoUpgradeNested<A> editOrNewCustomNoUpgrade() {
    return this.withNewCustomNoUpgradeLike(Optional.ofNullable(this.buildCustomNoUpgrade()).orElse(new CustomFeatureGatesBuilder().build()));
  }
  
  public CustomNoUpgradeNested<A> editOrNewCustomNoUpgradeLike(CustomFeatureGates item) {
    return this.withNewCustomNoUpgradeLike(Optional.ofNullable(this.buildCustomNoUpgrade()).orElse(item));
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
    if (!(Objects.equals(customNoUpgrade, that.customNoUpgrade))) {
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
  
  public boolean hasCustomNoUpgrade() {
    return this.customNoUpgrade != null;
  }
  
  public boolean hasFeatureSet() {
    return this.featureSet != null;
  }
  
  public int hashCode() {
    return Objects.hash(customNoUpgrade, featureSet, additionalProperties);
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
    if (!(customNoUpgrade == null)) {
        sb.append("customNoUpgrade:");
        sb.append(customNoUpgrade);
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
  
  public A withCustomNoUpgrade(CustomFeatureGates customNoUpgrade) {
    this._visitables.remove("customNoUpgrade");
    if (customNoUpgrade != null) {
        this.customNoUpgrade = new CustomFeatureGatesBuilder(customNoUpgrade);
        this._visitables.get("customNoUpgrade").add(this.customNoUpgrade);
    } else {
        this.customNoUpgrade = null;
        this._visitables.get("customNoUpgrade").remove(this.customNoUpgrade);
    }
    return (A) this;
  }
  
  public A withFeatureSet(String featureSet) {
    this.featureSet = featureSet;
    return (A) this;
  }
  
  public CustomNoUpgradeNested<A> withNewCustomNoUpgrade() {
    return new CustomNoUpgradeNested(null);
  }
  
  public CustomNoUpgradeNested<A> withNewCustomNoUpgradeLike(CustomFeatureGates item) {
    return new CustomNoUpgradeNested(item);
  }
  public class CustomNoUpgradeNested<N> extends CustomFeatureGatesFluent<CustomNoUpgradeNested<N>> implements Nested<N>{
  
    CustomFeatureGatesBuilder builder;
  
    CustomNoUpgradeNested(CustomFeatureGates item) {
      this.builder = new CustomFeatureGatesBuilder(this, item);
    }
  
    public N and() {
      return (N) FeatureGateSelectionFluent.this.withCustomNoUpgrade(builder.build());
    }
    
    public N endCustomNoUpgrade() {
      return and();
    }
    
  }
}