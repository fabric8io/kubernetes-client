package io.fabric8.openshift.api.model.hive.v1;

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
public class MachineSetStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.MachineSetStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String errorMessage;
  private String errorReason;
  private Integer maxReplicas;
  private Integer minReplicas;
  private String name;
  private Integer readyReplicas;
  private Integer replicas;

  public MachineSetStatusFluent() {
  }
  
  public MachineSetStatusFluent(MachineSetStatus instance) {
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
  
  protected void copyInstance(MachineSetStatus instance) {
    instance = instance != null ? instance : new MachineSetStatus();
    if (instance != null) {
        this.withErrorMessage(instance.getErrorMessage());
        this.withErrorReason(instance.getErrorReason());
        this.withMaxReplicas(instance.getMaxReplicas());
        this.withMinReplicas(instance.getMinReplicas());
        this.withName(instance.getName());
        this.withReadyReplicas(instance.getReadyReplicas());
        this.withReplicas(instance.getReplicas());
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
    MachineSetStatusFluent that = (MachineSetStatusFluent) o;
    if (!(Objects.equals(errorMessage, that.errorMessage))) {
      return false;
    }
    if (!(Objects.equals(errorReason, that.errorReason))) {
      return false;
    }
    if (!(Objects.equals(maxReplicas, that.maxReplicas))) {
      return false;
    }
    if (!(Objects.equals(minReplicas, that.minReplicas))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(readyReplicas, that.readyReplicas))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
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
  
  public String getErrorMessage() {
    return this.errorMessage;
  }
  
  public String getErrorReason() {
    return this.errorReason;
  }
  
  public Integer getMaxReplicas() {
    return this.maxReplicas;
  }
  
  public Integer getMinReplicas() {
    return this.minReplicas;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Integer getReadyReplicas() {
    return this.readyReplicas;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasErrorMessage() {
    return this.errorMessage != null;
  }
  
  public boolean hasErrorReason() {
    return this.errorReason != null;
  }
  
  public boolean hasMaxReplicas() {
    return this.maxReplicas != null;
  }
  
  public boolean hasMinReplicas() {
    return this.minReplicas != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasReadyReplicas() {
    return this.readyReplicas != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public int hashCode() {
    return Objects.hash(errorMessage, errorReason, maxReplicas, minReplicas, name, readyReplicas, replicas, additionalProperties);
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
    if (!(errorMessage == null)) {
        sb.append("errorMessage:");
        sb.append(errorMessage);
        sb.append(",");
    }
    if (!(errorReason == null)) {
        sb.append("errorReason:");
        sb.append(errorReason);
        sb.append(",");
    }
    if (!(maxReplicas == null)) {
        sb.append("maxReplicas:");
        sb.append(maxReplicas);
        sb.append(",");
    }
    if (!(minReplicas == null)) {
        sb.append("minReplicas:");
        sb.append(minReplicas);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(readyReplicas == null)) {
        sb.append("readyReplicas:");
        sb.append(readyReplicas);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
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
  
  public A withErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return (A) this;
  }
  
  public A withErrorReason(String errorReason) {
    this.errorReason = errorReason;
    return (A) this;
  }
  
  public A withMaxReplicas(Integer maxReplicas) {
    this.maxReplicas = maxReplicas;
    return (A) this;
  }
  
  public A withMinReplicas(Integer minReplicas) {
    this.minReplicas = minReplicas;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withReadyReplicas(Integer readyReplicas) {
    this.readyReplicas = readyReplicas;
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
}