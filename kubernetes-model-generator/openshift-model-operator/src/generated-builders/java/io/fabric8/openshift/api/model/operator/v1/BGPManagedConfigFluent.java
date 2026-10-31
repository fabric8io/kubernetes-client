package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class BGPManagedConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.BGPManagedConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long asNumber;
  private String bgpTopology;

  public BGPManagedConfigFluent() {
  }
  
  public BGPManagedConfigFluent(BGPManagedConfig instance) {
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
  
  protected void copyInstance(BGPManagedConfig instance) {
    instance = instance != null ? instance : new BGPManagedConfig();
    if (instance != null) {
        this.withAsNumber(instance.getAsNumber());
        this.withBgpTopology(instance.getBgpTopology());
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
    BGPManagedConfigFluent that = (BGPManagedConfigFluent) o;
    if (!(Objects.equals(asNumber, that.asNumber))) {
      return false;
    }
    if (!(Objects.equals(bgpTopology, that.bgpTopology))) {
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
  
  public Long getAsNumber() {
    return this.asNumber;
  }
  
  public String getBgpTopology() {
    return this.bgpTopology;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAsNumber() {
    return this.asNumber != null;
  }
  
  public boolean hasBgpTopology() {
    return this.bgpTopology != null;
  }
  
  public int hashCode() {
    return Objects.hash(asNumber, bgpTopology, additionalProperties);
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
    if (!(asNumber == null)) {
        sb.append("asNumber:");
        sb.append(asNumber);
        sb.append(",");
    }
    if (!(bgpTopology == null)) {
        sb.append("bgpTopology:");
        sb.append(bgpTopology);
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
  
  public A withAsNumber(Long asNumber) {
    this.asNumber = asNumber;
    return (A) this;
  }
  
  public A withBgpTopology(String bgpTopology) {
    this.bgpTopology = bgpTopology;
    return (A) this;
  }
  
}