package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PolicySetStatusPlacementFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.PolicySetStatusPlacementFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String placement;
  private String placementBinding;
  private String placementRule;

  public PolicySetStatusPlacementFluent() {
  }
  
  public PolicySetStatusPlacementFluent(PolicySetStatusPlacement instance) {
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
  
  protected void copyInstance(PolicySetStatusPlacement instance) {
    instance = instance != null ? instance : new PolicySetStatusPlacement();
    if (instance != null) {
        this.withPlacement(instance.getPlacement());
        this.withPlacementBinding(instance.getPlacementBinding());
        this.withPlacementRule(instance.getPlacementRule());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    PolicySetStatusPlacementFluent that = (PolicySetStatusPlacementFluent) o;
    if (!(Objects.equals(placement, that.placement))) {
      return false;
    }
    if (!(Objects.equals(placementBinding, that.placementBinding))) {
      return false;
    }
    if (!(Objects.equals(placementRule, that.placementRule))) {
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
  
  public String getPlacement() {
    return this.placement;
  }
  
  public String getPlacementBinding() {
    return this.placementBinding;
  }
  
  public String getPlacementRule() {
    return this.placementRule;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPlacement() {
    return this.placement != null;
  }
  
  public boolean hasPlacementBinding() {
    return this.placementBinding != null;
  }
  
  public boolean hasPlacementRule() {
    return this.placementRule != null;
  }
  
  public int hashCode() {
    return Objects.hash(placement, placementBinding, placementRule, additionalProperties);
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
    if (!(placement == null)) {
        sb.append("placement:");
        sb.append(placement);
        sb.append(",");
    }
    if (!(placementBinding == null)) {
        sb.append("placementBinding:");
        sb.append(placementBinding);
        sb.append(",");
    }
    if (!(placementRule == null)) {
        sb.append("placementRule:");
        sb.append(placementRule);
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
  
  public A withPlacement(String placement) {
    this.placement = placement;
    return (A) this;
  }
  
  public A withPlacementBinding(String placementBinding) {
    this.placementBinding = placementBinding;
    return (A) this;
  }
  
  public A withPlacementRule(String placementRule) {
    this.placementRule = placementRule;
    return (A) this;
  }
  
}