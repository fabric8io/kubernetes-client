package io.fabric8.kubernetes.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class HorizontalPodAutoscalerStatusFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer currentCPUUtilizationPercentage;
  private Integer currentReplicas;
  private Integer desiredReplicas;
  private String lastScaleTime;
  private Long observedGeneration;

  public HorizontalPodAutoscalerStatusFluent() {
  }
  
  public HorizontalPodAutoscalerStatusFluent(HorizontalPodAutoscalerStatus instance) {
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
  
  protected void copyInstance(HorizontalPodAutoscalerStatus instance) {
    instance = instance != null ? instance : new HorizontalPodAutoscalerStatus();
    if (instance != null) {
        this.withCurrentCPUUtilizationPercentage(instance.getCurrentCPUUtilizationPercentage());
        this.withCurrentReplicas(instance.getCurrentReplicas());
        this.withDesiredReplicas(instance.getDesiredReplicas());
        this.withLastScaleTime(instance.getLastScaleTime());
        this.withObservedGeneration(instance.getObservedGeneration());
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
    HorizontalPodAutoscalerStatusFluent that = (HorizontalPodAutoscalerStatusFluent) o;
    if (!(Objects.equals(currentCPUUtilizationPercentage, that.currentCPUUtilizationPercentage))) {
      return false;
    }
    if (!(Objects.equals(currentReplicas, that.currentReplicas))) {
      return false;
    }
    if (!(Objects.equals(desiredReplicas, that.desiredReplicas))) {
      return false;
    }
    if (!(Objects.equals(lastScaleTime, that.lastScaleTime))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
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
  
  public Integer getCurrentCPUUtilizationPercentage() {
    return this.currentCPUUtilizationPercentage;
  }
  
  public Integer getCurrentReplicas() {
    return this.currentReplicas;
  }
  
  public Integer getDesiredReplicas() {
    return this.desiredReplicas;
  }
  
  public String getLastScaleTime() {
    return this.lastScaleTime;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentCPUUtilizationPercentage() {
    return this.currentCPUUtilizationPercentage != null;
  }
  
  public boolean hasCurrentReplicas() {
    return this.currentReplicas != null;
  }
  
  public boolean hasDesiredReplicas() {
    return this.desiredReplicas != null;
  }
  
  public boolean hasLastScaleTime() {
    return this.lastScaleTime != null;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(currentCPUUtilizationPercentage, currentReplicas, desiredReplicas, lastScaleTime, observedGeneration, additionalProperties);
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
    if (!(currentCPUUtilizationPercentage == null)) {
        sb.append("currentCPUUtilizationPercentage:");
        sb.append(currentCPUUtilizationPercentage);
        sb.append(",");
    }
    if (!(currentReplicas == null)) {
        sb.append("currentReplicas:");
        sb.append(currentReplicas);
        sb.append(",");
    }
    if (!(desiredReplicas == null)) {
        sb.append("desiredReplicas:");
        sb.append(desiredReplicas);
        sb.append(",");
    }
    if (!(lastScaleTime == null)) {
        sb.append("lastScaleTime:");
        sb.append(lastScaleTime);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
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
  
  public A withCurrentCPUUtilizationPercentage(Integer currentCPUUtilizationPercentage) {
    this.currentCPUUtilizationPercentage = currentCPUUtilizationPercentage;
    return (A) this;
  }
  
  public A withCurrentReplicas(Integer currentReplicas) {
    this.currentReplicas = currentReplicas;
    return (A) this;
  }
  
  public A withDesiredReplicas(Integer desiredReplicas) {
    this.desiredReplicas = desiredReplicas;
    return (A) this;
  }
  
  public A withLastScaleTime(String lastScaleTime) {
    this.lastScaleTime = lastScaleTime;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
}