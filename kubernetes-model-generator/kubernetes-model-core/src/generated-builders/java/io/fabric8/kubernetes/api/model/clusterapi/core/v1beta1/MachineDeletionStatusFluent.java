package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class MachineDeletionStatusFluent<A extends io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.MachineDeletionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String nodeDrainStartTime;
  private String waitForNodeVolumeDetachStartTime;

  public MachineDeletionStatusFluent() {
  }
  
  public MachineDeletionStatusFluent(MachineDeletionStatus instance) {
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
  
  protected void copyInstance(MachineDeletionStatus instance) {
    instance = instance != null ? instance : new MachineDeletionStatus();
    if (instance != null) {
        this.withNodeDrainStartTime(instance.getNodeDrainStartTime());
        this.withWaitForNodeVolumeDetachStartTime(instance.getWaitForNodeVolumeDetachStartTime());
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
    MachineDeletionStatusFluent that = (MachineDeletionStatusFluent) o;
    if (!(Objects.equals(nodeDrainStartTime, that.nodeDrainStartTime))) {
      return false;
    }
    if (!(Objects.equals(waitForNodeVolumeDetachStartTime, that.waitForNodeVolumeDetachStartTime))) {
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
  
  public String getNodeDrainStartTime() {
    return this.nodeDrainStartTime;
  }
  
  public String getWaitForNodeVolumeDetachStartTime() {
    return this.waitForNodeVolumeDetachStartTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNodeDrainStartTime() {
    return this.nodeDrainStartTime != null;
  }
  
  public boolean hasWaitForNodeVolumeDetachStartTime() {
    return this.waitForNodeVolumeDetachStartTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(nodeDrainStartTime, waitForNodeVolumeDetachStartTime, additionalProperties);
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
    if (!(nodeDrainStartTime == null)) {
        sb.append("nodeDrainStartTime:");
        sb.append(nodeDrainStartTime);
        sb.append(",");
    }
    if (!(waitForNodeVolumeDetachStartTime == null)) {
        sb.append("waitForNodeVolumeDetachStartTime:");
        sb.append(waitForNodeVolumeDetachStartTime);
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
  
  public A withNodeDrainStartTime(String nodeDrainStartTime) {
    this.nodeDrainStartTime = nodeDrainStartTime;
    return (A) this;
  }
  
  public A withWaitForNodeVolumeDetachStartTime(String waitForNodeVolumeDetachStartTime) {
    this.waitForNodeVolumeDetachStartTime = waitForNodeVolumeDetachStartTime;
    return (A) this;
  }
  
}