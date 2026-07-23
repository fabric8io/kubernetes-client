package io.fabric8.openshift.api.model.operator.v1;

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
public class AWSEFSVolumeMetricsRecursiveWalkConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.AWSEFSVolumeMetricsRecursiveWalkConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer fsRateLimit;
  private Integer refreshPeriodMinutes;

  public AWSEFSVolumeMetricsRecursiveWalkConfigFluent() {
  }
  
  public AWSEFSVolumeMetricsRecursiveWalkConfigFluent(AWSEFSVolumeMetricsRecursiveWalkConfig instance) {
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
  
  protected void copyInstance(AWSEFSVolumeMetricsRecursiveWalkConfig instance) {
    instance = instance != null ? instance : new AWSEFSVolumeMetricsRecursiveWalkConfig();
    if (instance != null) {
        this.withFsRateLimit(instance.getFsRateLimit());
        this.withRefreshPeriodMinutes(instance.getRefreshPeriodMinutes());
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
    AWSEFSVolumeMetricsRecursiveWalkConfigFluent that = (AWSEFSVolumeMetricsRecursiveWalkConfigFluent) o;
    if (!(Objects.equals(fsRateLimit, that.fsRateLimit))) {
      return false;
    }
    if (!(Objects.equals(refreshPeriodMinutes, that.refreshPeriodMinutes))) {
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
  
  public Integer getFsRateLimit() {
    return this.fsRateLimit;
  }
  
  public Integer getRefreshPeriodMinutes() {
    return this.refreshPeriodMinutes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFsRateLimit() {
    return this.fsRateLimit != null;
  }
  
  public boolean hasRefreshPeriodMinutes() {
    return this.refreshPeriodMinutes != null;
  }
  
  public int hashCode() {
    return Objects.hash(fsRateLimit, refreshPeriodMinutes, additionalProperties);
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
    if (!(fsRateLimit == null)) {
        sb.append("fsRateLimit:");
        sb.append(fsRateLimit);
        sb.append(",");
    }
    if (!(refreshPeriodMinutes == null)) {
        sb.append("refreshPeriodMinutes:");
        sb.append(refreshPeriodMinutes);
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
  
  public A withFsRateLimit(Integer fsRateLimit) {
    this.fsRateLimit = fsRateLimit;
    return (A) this;
  }
  
  public A withRefreshPeriodMinutes(Integer refreshPeriodMinutes) {
    this.refreshPeriodMinutes = refreshPeriodMinutes;
    return (A) this;
  }
  
}