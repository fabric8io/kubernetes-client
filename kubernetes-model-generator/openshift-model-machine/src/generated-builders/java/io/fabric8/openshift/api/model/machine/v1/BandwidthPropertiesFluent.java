package io.fabric8.openshift.api.model.machine.v1;

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
public class BandwidthPropertiesFluent<A extends io.fabric8.openshift.api.model.machine.v1.BandwidthPropertiesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long internetMaxBandwidthIn;
  private Long internetMaxBandwidthOut;

  public BandwidthPropertiesFluent() {
  }
  
  public BandwidthPropertiesFluent(BandwidthProperties instance) {
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
  
  protected void copyInstance(BandwidthProperties instance) {
    instance = instance != null ? instance : new BandwidthProperties();
    if (instance != null) {
        this.withInternetMaxBandwidthIn(instance.getInternetMaxBandwidthIn());
        this.withInternetMaxBandwidthOut(instance.getInternetMaxBandwidthOut());
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
    BandwidthPropertiesFluent that = (BandwidthPropertiesFluent) o;
    if (!(Objects.equals(internetMaxBandwidthIn, that.internetMaxBandwidthIn))) {
      return false;
    }
    if (!(Objects.equals(internetMaxBandwidthOut, that.internetMaxBandwidthOut))) {
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
  
  public Long getInternetMaxBandwidthIn() {
    return this.internetMaxBandwidthIn;
  }
  
  public Long getInternetMaxBandwidthOut() {
    return this.internetMaxBandwidthOut;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasInternetMaxBandwidthIn() {
    return this.internetMaxBandwidthIn != null;
  }
  
  public boolean hasInternetMaxBandwidthOut() {
    return this.internetMaxBandwidthOut != null;
  }
  
  public int hashCode() {
    return Objects.hash(internetMaxBandwidthIn, internetMaxBandwidthOut, additionalProperties);
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
    if (!(internetMaxBandwidthIn == null)) {
        sb.append("internetMaxBandwidthIn:");
        sb.append(internetMaxBandwidthIn);
        sb.append(",");
    }
    if (!(internetMaxBandwidthOut == null)) {
        sb.append("internetMaxBandwidthOut:");
        sb.append(internetMaxBandwidthOut);
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
  
  public A withInternetMaxBandwidthIn(Long internetMaxBandwidthIn) {
    this.internetMaxBandwidthIn = internetMaxBandwidthIn;
    return (A) this;
  }
  
  public A withInternetMaxBandwidthOut(Long internetMaxBandwidthOut) {
    this.internetMaxBandwidthOut = internetMaxBandwidthOut;
    return (A) this;
  }
  
}