package io.fabric8.kubernetes.api.model;

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
public class ContainerStateTerminatedFluent<A extends io.fabric8.kubernetes.api.model.ContainerStateTerminatedFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerID;
  private Integer exitCode;
  private String finishedAt;
  private String message;
  private String reason;
  private Integer signal;
  private String startedAt;

  public ContainerStateTerminatedFluent() {
  }
  
  public ContainerStateTerminatedFluent(ContainerStateTerminated instance) {
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
  
  protected void copyInstance(ContainerStateTerminated instance) {
    instance = instance != null ? instance : new ContainerStateTerminated();
    if (instance != null) {
        this.withContainerID(instance.getContainerID());
        this.withExitCode(instance.getExitCode());
        this.withFinishedAt(instance.getFinishedAt());
        this.withMessage(instance.getMessage());
        this.withReason(instance.getReason());
        this.withSignal(instance.getSignal());
        this.withStartedAt(instance.getStartedAt());
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
    ContainerStateTerminatedFluent that = (ContainerStateTerminatedFluent) o;
    if (!(Objects.equals(containerID, that.containerID))) {
      return false;
    }
    if (!(Objects.equals(exitCode, that.exitCode))) {
      return false;
    }
    if (!(Objects.equals(finishedAt, that.finishedAt))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(signal, that.signal))) {
      return false;
    }
    if (!(Objects.equals(startedAt, that.startedAt))) {
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
  
  public String getContainerID() {
    return this.containerID;
  }
  
  public Integer getExitCode() {
    return this.exitCode;
  }
  
  public String getFinishedAt() {
    return this.finishedAt;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public Integer getSignal() {
    return this.signal;
  }
  
  public String getStartedAt() {
    return this.startedAt;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerID() {
    return this.containerID != null;
  }
  
  public boolean hasExitCode() {
    return this.exitCode != null;
  }
  
  public boolean hasFinishedAt() {
    return this.finishedAt != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasSignal() {
    return this.signal != null;
  }
  
  public boolean hasStartedAt() {
    return this.startedAt != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerID, exitCode, finishedAt, message, reason, signal, startedAt, additionalProperties);
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
    if (!(containerID == null)) {
        sb.append("containerID:");
        sb.append(containerID);
        sb.append(",");
    }
    if (!(exitCode == null)) {
        sb.append("exitCode:");
        sb.append(exitCode);
        sb.append(",");
    }
    if (!(finishedAt == null)) {
        sb.append("finishedAt:");
        sb.append(finishedAt);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(signal == null)) {
        sb.append("signal:");
        sb.append(signal);
        sb.append(",");
    }
    if (!(startedAt == null)) {
        sb.append("startedAt:");
        sb.append(startedAt);
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
  
  public A withContainerID(String containerID) {
    this.containerID = containerID;
    return (A) this;
  }
  
  public A withExitCode(Integer exitCode) {
    this.exitCode = exitCode;
    return (A) this;
  }
  
  public A withFinishedAt(String finishedAt) {
    this.finishedAt = finishedAt;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withSignal(Integer signal) {
    this.signal = signal;
    return (A) this;
  }
  
  public A withStartedAt(String startedAt) {
    this.startedAt = startedAt;
    return (A) this;
  }
  
}