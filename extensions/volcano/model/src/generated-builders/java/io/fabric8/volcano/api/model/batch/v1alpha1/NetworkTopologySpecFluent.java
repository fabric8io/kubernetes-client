package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class NetworkTopologySpecFluent<A extends io.fabric8.volcano.api.model.batch.v1alpha1.NetworkTopologySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer highestTierAllowed;
  private String highestTierName;
  private String mode;

  public NetworkTopologySpecFluent() {
  }
  
  public NetworkTopologySpecFluent(NetworkTopologySpec instance) {
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
  
  protected void copyInstance(NetworkTopologySpec instance) {
    instance = instance != null ? instance : new NetworkTopologySpec();
    if (instance != null) {
        this.withHighestTierAllowed(instance.getHighestTierAllowed());
        this.withHighestTierName(instance.getHighestTierName());
        this.withMode(instance.getMode());
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
    NetworkTopologySpecFluent that = (NetworkTopologySpecFluent) o;
    if (!(Objects.equals(highestTierAllowed, that.highestTierAllowed))) {
      return false;
    }
    if (!(Objects.equals(highestTierName, that.highestTierName))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
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
  
  public Integer getHighestTierAllowed() {
    return this.highestTierAllowed;
  }
  
  public String getHighestTierName() {
    return this.highestTierName;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHighestTierAllowed() {
    return this.highestTierAllowed != null;
  }
  
  public boolean hasHighestTierName() {
    return this.highestTierName != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(highestTierAllowed, highestTierName, mode, additionalProperties);
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
    if (!(highestTierAllowed == null)) {
        sb.append("highestTierAllowed:");
        sb.append(highestTierAllowed);
        sb.append(",");
    }
    if (!(highestTierName == null)) {
        sb.append("highestTierName:");
        sb.append(highestTierName);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
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
  
  public A withHighestTierAllowed(Integer highestTierAllowed) {
    this.highestTierAllowed = highestTierAllowed;
    return (A) this;
  }
  
  public A withHighestTierName(String highestTierName) {
    this.highestTierName = highestTierName;
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
}