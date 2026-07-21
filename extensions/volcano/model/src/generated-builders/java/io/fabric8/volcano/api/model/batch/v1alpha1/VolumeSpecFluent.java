package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimSpec;
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
public class VolumeSpecFluent<A extends io.fabric8.volcano.api.model.batch.v1alpha1.VolumeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mountPath;
  private PersistentVolumeClaimSpec volumeClaim;
  private String volumeClaimName;

  public VolumeSpecFluent() {
  }
  
  public VolumeSpecFluent(VolumeSpec instance) {
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
  
  protected void copyInstance(VolumeSpec instance) {
    instance = instance != null ? instance : new VolumeSpec();
    if (instance != null) {
        this.withMountPath(instance.getMountPath());
        this.withVolumeClaim(instance.getVolumeClaim());
        this.withVolumeClaimName(instance.getVolumeClaimName());
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
    VolumeSpecFluent that = (VolumeSpecFluent) o;
    if (!(Objects.equals(mountPath, that.mountPath))) {
      return false;
    }
    if (!(Objects.equals(volumeClaim, that.volumeClaim))) {
      return false;
    }
    if (!(Objects.equals(volumeClaimName, that.volumeClaimName))) {
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
  
  public String getMountPath() {
    return this.mountPath;
  }
  
  public PersistentVolumeClaimSpec getVolumeClaim() {
    return this.volumeClaim;
  }
  
  public String getVolumeClaimName() {
    return this.volumeClaimName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMountPath() {
    return this.mountPath != null;
  }
  
  public boolean hasVolumeClaim() {
    return this.volumeClaim != null;
  }
  
  public boolean hasVolumeClaimName() {
    return this.volumeClaimName != null;
  }
  
  public int hashCode() {
    return Objects.hash(mountPath, volumeClaim, volumeClaimName, additionalProperties);
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
    if (!(mountPath == null)) {
        sb.append("mountPath:");
        sb.append(mountPath);
        sb.append(",");
    }
    if (!(volumeClaim == null)) {
        sb.append("volumeClaim:");
        sb.append(volumeClaim);
        sb.append(",");
    }
    if (!(volumeClaimName == null)) {
        sb.append("volumeClaimName:");
        sb.append(volumeClaimName);
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
  
  public A withMountPath(String mountPath) {
    this.mountPath = mountPath;
    return (A) this;
  }
  
  public A withVolumeClaim(PersistentVolumeClaimSpec volumeClaim) {
    this.volumeClaim = volumeClaim;
    return (A) this;
  }
  
  public A withVolumeClaimName(String volumeClaimName) {
    this.volumeClaimName = volumeClaimName;
    return (A) this;
  }
  
}