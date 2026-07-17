package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class Metal3RemediationStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String lastRemediated;
  private String phase;
  private Integer retryCount;

  public Metal3RemediationStatusFluent() {
  }
  
  public Metal3RemediationStatusFluent(Metal3RemediationStatus instance) {
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
  
  protected void copyInstance(Metal3RemediationStatus instance) {
    instance = instance != null ? instance : new Metal3RemediationStatus();
    if (instance != null) {
        this.withLastRemediated(instance.getLastRemediated());
        this.withPhase(instance.getPhase());
        this.withRetryCount(instance.getRetryCount());
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
    Metal3RemediationStatusFluent that = (Metal3RemediationStatusFluent) o;
    if (!(Objects.equals(lastRemediated, that.lastRemediated))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(retryCount, that.retryCount))) {
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
  
  public String getLastRemediated() {
    return this.lastRemediated;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public Integer getRetryCount() {
    return this.retryCount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLastRemediated() {
    return this.lastRemediated != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasRetryCount() {
    return this.retryCount != null;
  }
  
  public int hashCode() {
    return Objects.hash(lastRemediated, phase, retryCount, additionalProperties);
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
    if (!(lastRemediated == null)) {
        sb.append("lastRemediated:");
        sb.append(lastRemediated);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(retryCount == null)) {
        sb.append("retryCount:");
        sb.append(retryCount);
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
  
  public A withLastRemediated(String lastRemediated) {
    this.lastRemediated = lastRemediated;
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withRetryCount(Integer retryCount) {
    this.retryCount = retryCount;
    return (A) this;
  }
  
}