package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
public class BandwidthEntryFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.BandwidthEntryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer egressBurst;
  private Integer egressRate;
  private Integer ingressBurst;
  private Integer ingressRate;

  public BandwidthEntryFluent() {
  }
  
  public BandwidthEntryFluent(BandwidthEntry instance) {
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
  
  protected void copyInstance(BandwidthEntry instance) {
    instance = instance != null ? instance : new BandwidthEntry();
    if (instance != null) {
        this.withEgressBurst(instance.getEgressBurst());
        this.withEgressRate(instance.getEgressRate());
        this.withIngressBurst(instance.getIngressBurst());
        this.withIngressRate(instance.getIngressRate());
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
    BandwidthEntryFluent that = (BandwidthEntryFluent) o;
    if (!(Objects.equals(egressBurst, that.egressBurst))) {
      return false;
    }
    if (!(Objects.equals(egressRate, that.egressRate))) {
      return false;
    }
    if (!(Objects.equals(ingressBurst, that.ingressBurst))) {
      return false;
    }
    if (!(Objects.equals(ingressRate, that.ingressRate))) {
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
  
  public Integer getEgressBurst() {
    return this.egressBurst;
  }
  
  public Integer getEgressRate() {
    return this.egressRate;
  }
  
  public Integer getIngressBurst() {
    return this.ingressBurst;
  }
  
  public Integer getIngressRate() {
    return this.ingressRate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEgressBurst() {
    return this.egressBurst != null;
  }
  
  public boolean hasEgressRate() {
    return this.egressRate != null;
  }
  
  public boolean hasIngressBurst() {
    return this.ingressBurst != null;
  }
  
  public boolean hasIngressRate() {
    return this.ingressRate != null;
  }
  
  public int hashCode() {
    return Objects.hash(egressBurst, egressRate, ingressBurst, ingressRate, additionalProperties);
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
    if (!(egressBurst == null)) {
        sb.append("egressBurst:");
        sb.append(egressBurst);
        sb.append(",");
    }
    if (!(egressRate == null)) {
        sb.append("egressRate:");
        sb.append(egressRate);
        sb.append(",");
    }
    if (!(ingressBurst == null)) {
        sb.append("ingressBurst:");
        sb.append(ingressBurst);
        sb.append(",");
    }
    if (!(ingressRate == null)) {
        sb.append("ingressRate:");
        sb.append(ingressRate);
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
  
  public A withEgressBurst(Integer egressBurst) {
    this.egressBurst = egressBurst;
    return (A) this;
  }
  
  public A withEgressRate(Integer egressRate) {
    this.egressRate = egressRate;
    return (A) this;
  }
  
  public A withIngressBurst(Integer ingressBurst) {
    this.ingressBurst = ingressBurst;
    return (A) this;
  }
  
  public A withIngressRate(Integer ingressRate) {
    this.ingressRate = ingressRate;
    return (A) this;
  }
  
}