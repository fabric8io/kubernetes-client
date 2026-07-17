package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class ClusterAutoscalerSpecScaleDownFluent<A extends io.fabric8.openshift.api.model.autoscaling.v1.ClusterAutoscalerSpecScaleDownFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String delayAfterAdd;
  private String delayAfterDelete;
  private String delayAfterFailure;
  private Boolean enabled;
  private String unneededTime;
  private String utilizationThreshold;

  public ClusterAutoscalerSpecScaleDownFluent() {
  }
  
  public ClusterAutoscalerSpecScaleDownFluent(ClusterAutoscalerSpecScaleDown instance) {
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
  
  protected void copyInstance(ClusterAutoscalerSpecScaleDown instance) {
    instance = instance != null ? instance : new ClusterAutoscalerSpecScaleDown();
    if (instance != null) {
        this.withDelayAfterAdd(instance.getDelayAfterAdd());
        this.withDelayAfterDelete(instance.getDelayAfterDelete());
        this.withDelayAfterFailure(instance.getDelayAfterFailure());
        this.withEnabled(instance.getEnabled());
        this.withUnneededTime(instance.getUnneededTime());
        this.withUtilizationThreshold(instance.getUtilizationThreshold());
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
    ClusterAutoscalerSpecScaleDownFluent that = (ClusterAutoscalerSpecScaleDownFluent) o;
    if (!(Objects.equals(delayAfterAdd, that.delayAfterAdd))) {
      return false;
    }
    if (!(Objects.equals(delayAfterDelete, that.delayAfterDelete))) {
      return false;
    }
    if (!(Objects.equals(delayAfterFailure, that.delayAfterFailure))) {
      return false;
    }
    if (!(Objects.equals(enabled, that.enabled))) {
      return false;
    }
    if (!(Objects.equals(unneededTime, that.unneededTime))) {
      return false;
    }
    if (!(Objects.equals(utilizationThreshold, that.utilizationThreshold))) {
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
  
  public String getDelayAfterAdd() {
    return this.delayAfterAdd;
  }
  
  public String getDelayAfterDelete() {
    return this.delayAfterDelete;
  }
  
  public String getDelayAfterFailure() {
    return this.delayAfterFailure;
  }
  
  public Boolean getEnabled() {
    return this.enabled;
  }
  
  public String getUnneededTime() {
    return this.unneededTime;
  }
  
  public String getUtilizationThreshold() {
    return this.utilizationThreshold;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDelayAfterAdd() {
    return this.delayAfterAdd != null;
  }
  
  public boolean hasDelayAfterDelete() {
    return this.delayAfterDelete != null;
  }
  
  public boolean hasDelayAfterFailure() {
    return this.delayAfterFailure != null;
  }
  
  public boolean hasEnabled() {
    return this.enabled != null;
  }
  
  public boolean hasUnneededTime() {
    return this.unneededTime != null;
  }
  
  public boolean hasUtilizationThreshold() {
    return this.utilizationThreshold != null;
  }
  
  public int hashCode() {
    return Objects.hash(delayAfterAdd, delayAfterDelete, delayAfterFailure, enabled, unneededTime, utilizationThreshold, additionalProperties);
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
    if (!(delayAfterAdd == null)) {
        sb.append("delayAfterAdd:");
        sb.append(delayAfterAdd);
        sb.append(",");
    }
    if (!(delayAfterDelete == null)) {
        sb.append("delayAfterDelete:");
        sb.append(delayAfterDelete);
        sb.append(",");
    }
    if (!(delayAfterFailure == null)) {
        sb.append("delayAfterFailure:");
        sb.append(delayAfterFailure);
        sb.append(",");
    }
    if (!(enabled == null)) {
        sb.append("enabled:");
        sb.append(enabled);
        sb.append(",");
    }
    if (!(unneededTime == null)) {
        sb.append("unneededTime:");
        sb.append(unneededTime);
        sb.append(",");
    }
    if (!(utilizationThreshold == null)) {
        sb.append("utilizationThreshold:");
        sb.append(utilizationThreshold);
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
  
  public A withDelayAfterAdd(String delayAfterAdd) {
    this.delayAfterAdd = delayAfterAdd;
    return (A) this;
  }
  
  public A withDelayAfterDelete(String delayAfterDelete) {
    this.delayAfterDelete = delayAfterDelete;
    return (A) this;
  }
  
  public A withDelayAfterFailure(String delayAfterFailure) {
    this.delayAfterFailure = delayAfterFailure;
    return (A) this;
  }
  
  public A withEnabled() {
    return withEnabled(true);
  }
  
  public A withEnabled(Boolean enabled) {
    this.enabled = enabled;
    return (A) this;
  }
  
  public A withUnneededTime(String unneededTime) {
    this.unneededTime = unneededTime;
    return (A) this;
  }
  
  public A withUtilizationThreshold(String utilizationThreshold) {
    this.utilizationThreshold = utilizationThreshold;
    return (A) this;
  }
  
}