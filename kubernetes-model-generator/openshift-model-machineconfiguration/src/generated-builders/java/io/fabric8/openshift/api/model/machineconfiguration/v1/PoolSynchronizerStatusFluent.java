package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class PoolSynchronizerStatusFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.PoolSynchronizerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long availableMachineCount;
  private Long machineCount;
  private Long observedGeneration;
  private String poolSynchronizerType;
  private Long readyMachineCount;
  private Long unavailableMachineCount;
  private Long updatedMachineCount;

  public PoolSynchronizerStatusFluent() {
  }
  
  public PoolSynchronizerStatusFluent(PoolSynchronizerStatus instance) {
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
  
  protected void copyInstance(PoolSynchronizerStatus instance) {
    instance = instance != null ? instance : new PoolSynchronizerStatus();
    if (instance != null) {
        this.withAvailableMachineCount(instance.getAvailableMachineCount());
        this.withMachineCount(instance.getMachineCount());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPoolSynchronizerType(instance.getPoolSynchronizerType());
        this.withReadyMachineCount(instance.getReadyMachineCount());
        this.withUnavailableMachineCount(instance.getUnavailableMachineCount());
        this.withUpdatedMachineCount(instance.getUpdatedMachineCount());
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
    PoolSynchronizerStatusFluent that = (PoolSynchronizerStatusFluent) o;
    if (!(Objects.equals(availableMachineCount, that.availableMachineCount))) {
      return false;
    }
    if (!(Objects.equals(machineCount, that.machineCount))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(poolSynchronizerType, that.poolSynchronizerType))) {
      return false;
    }
    if (!(Objects.equals(readyMachineCount, that.readyMachineCount))) {
      return false;
    }
    if (!(Objects.equals(unavailableMachineCount, that.unavailableMachineCount))) {
      return false;
    }
    if (!(Objects.equals(updatedMachineCount, that.updatedMachineCount))) {
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
  
  public Long getAvailableMachineCount() {
    return this.availableMachineCount;
  }
  
  public Long getMachineCount() {
    return this.machineCount;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public String getPoolSynchronizerType() {
    return this.poolSynchronizerType;
  }
  
  public Long getReadyMachineCount() {
    return this.readyMachineCount;
  }
  
  public Long getUnavailableMachineCount() {
    return this.unavailableMachineCount;
  }
  
  public Long getUpdatedMachineCount() {
    return this.updatedMachineCount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailableMachineCount() {
    return this.availableMachineCount != null;
  }
  
  public boolean hasMachineCount() {
    return this.machineCount != null;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasPoolSynchronizerType() {
    return this.poolSynchronizerType != null;
  }
  
  public boolean hasReadyMachineCount() {
    return this.readyMachineCount != null;
  }
  
  public boolean hasUnavailableMachineCount() {
    return this.unavailableMachineCount != null;
  }
  
  public boolean hasUpdatedMachineCount() {
    return this.updatedMachineCount != null;
  }
  
  public int hashCode() {
    return Objects.hash(availableMachineCount, machineCount, observedGeneration, poolSynchronizerType, readyMachineCount, unavailableMachineCount, updatedMachineCount, additionalProperties);
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
    if (!(availableMachineCount == null)) {
        sb.append("availableMachineCount:");
        sb.append(availableMachineCount);
        sb.append(",");
    }
    if (!(machineCount == null)) {
        sb.append("machineCount:");
        sb.append(machineCount);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(poolSynchronizerType == null)) {
        sb.append("poolSynchronizerType:");
        sb.append(poolSynchronizerType);
        sb.append(",");
    }
    if (!(readyMachineCount == null)) {
        sb.append("readyMachineCount:");
        sb.append(readyMachineCount);
        sb.append(",");
    }
    if (!(unavailableMachineCount == null)) {
        sb.append("unavailableMachineCount:");
        sb.append(unavailableMachineCount);
        sb.append(",");
    }
    if (!(updatedMachineCount == null)) {
        sb.append("updatedMachineCount:");
        sb.append(updatedMachineCount);
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
  
  public A withAvailableMachineCount(Long availableMachineCount) {
    this.availableMachineCount = availableMachineCount;
    return (A) this;
  }
  
  public A withMachineCount(Long machineCount) {
    this.machineCount = machineCount;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withPoolSynchronizerType(String poolSynchronizerType) {
    this.poolSynchronizerType = poolSynchronizerType;
    return (A) this;
  }
  
  public A withReadyMachineCount(Long readyMachineCount) {
    this.readyMachineCount = readyMachineCount;
    return (A) this;
  }
  
  public A withUnavailableMachineCount(Long unavailableMachineCount) {
    this.unavailableMachineCount = unavailableMachineCount;
    return (A) this;
  }
  
  public A withUpdatedMachineCount(Long updatedMachineCount) {
    this.updatedMachineCount = updatedMachineCount;
    return (A) this;
  }
  
}