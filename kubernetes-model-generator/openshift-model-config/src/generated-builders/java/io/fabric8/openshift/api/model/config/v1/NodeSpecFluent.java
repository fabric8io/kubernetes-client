package io.fabric8.openshift.api.model.config.v1;

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
public class NodeSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.NodeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cgroupMode;
  private String minimumKubeletVersion;
  private String workerLatencyProfile;

  public NodeSpecFluent() {
  }
  
  public NodeSpecFluent(NodeSpec instance) {
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
  
  protected void copyInstance(NodeSpec instance) {
    instance = instance != null ? instance : new NodeSpec();
    if (instance != null) {
        this.withCgroupMode(instance.getCgroupMode());
        this.withMinimumKubeletVersion(instance.getMinimumKubeletVersion());
        this.withWorkerLatencyProfile(instance.getWorkerLatencyProfile());
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
    NodeSpecFluent that = (NodeSpecFluent) o;
    if (!(Objects.equals(cgroupMode, that.cgroupMode))) {
      return false;
    }
    if (!(Objects.equals(minimumKubeletVersion, that.minimumKubeletVersion))) {
      return false;
    }
    if (!(Objects.equals(workerLatencyProfile, that.workerLatencyProfile))) {
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
  
  public String getCgroupMode() {
    return this.cgroupMode;
  }
  
  public String getMinimumKubeletVersion() {
    return this.minimumKubeletVersion;
  }
  
  public String getWorkerLatencyProfile() {
    return this.workerLatencyProfile;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCgroupMode() {
    return this.cgroupMode != null;
  }
  
  public boolean hasMinimumKubeletVersion() {
    return this.minimumKubeletVersion != null;
  }
  
  public boolean hasWorkerLatencyProfile() {
    return this.workerLatencyProfile != null;
  }
  
  public int hashCode() {
    return Objects.hash(cgroupMode, minimumKubeletVersion, workerLatencyProfile, additionalProperties);
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
    if (!(cgroupMode == null)) {
        sb.append("cgroupMode:");
        sb.append(cgroupMode);
        sb.append(",");
    }
    if (!(minimumKubeletVersion == null)) {
        sb.append("minimumKubeletVersion:");
        sb.append(minimumKubeletVersion);
        sb.append(",");
    }
    if (!(workerLatencyProfile == null)) {
        sb.append("workerLatencyProfile:");
        sb.append(workerLatencyProfile);
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
  
  public A withCgroupMode(String cgroupMode) {
    this.cgroupMode = cgroupMode;
    return (A) this;
  }
  
  public A withMinimumKubeletVersion(String minimumKubeletVersion) {
    this.minimumKubeletVersion = minimumKubeletVersion;
    return (A) this;
  }
  
  public A withWorkerLatencyProfile(String workerLatencyProfile) {
    this.workerLatencyProfile = workerLatencyProfile;
    return (A) this;
  }
  
}