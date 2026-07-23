package io.fabric8.volumesnapshot.api.model;

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
public class VolumeSnapshotSourceFluent<A extends io.fabric8.volumesnapshot.api.model.VolumeSnapshotSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String persistentVolumeClaimName;
  private String volumeSnapshotContentName;

  public VolumeSnapshotSourceFluent() {
  }
  
  public VolumeSnapshotSourceFluent(VolumeSnapshotSource instance) {
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
  
  protected void copyInstance(VolumeSnapshotSource instance) {
    instance = instance != null ? instance : new VolumeSnapshotSource();
    if (instance != null) {
        this.withPersistentVolumeClaimName(instance.getPersistentVolumeClaimName());
        this.withVolumeSnapshotContentName(instance.getVolumeSnapshotContentName());
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
    VolumeSnapshotSourceFluent that = (VolumeSnapshotSourceFluent) o;
    if (!(Objects.equals(persistentVolumeClaimName, that.persistentVolumeClaimName))) {
      return false;
    }
    if (!(Objects.equals(volumeSnapshotContentName, that.volumeSnapshotContentName))) {
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
  
  public String getPersistentVolumeClaimName() {
    return this.persistentVolumeClaimName;
  }
  
  public String getVolumeSnapshotContentName() {
    return this.volumeSnapshotContentName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPersistentVolumeClaimName() {
    return this.persistentVolumeClaimName != null;
  }
  
  public boolean hasVolumeSnapshotContentName() {
    return this.volumeSnapshotContentName != null;
  }
  
  public int hashCode() {
    return Objects.hash(persistentVolumeClaimName, volumeSnapshotContentName, additionalProperties);
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
    if (!(persistentVolumeClaimName == null)) {
        sb.append("persistentVolumeClaimName:");
        sb.append(persistentVolumeClaimName);
        sb.append(",");
    }
    if (!(volumeSnapshotContentName == null)) {
        sb.append("volumeSnapshotContentName:");
        sb.append(volumeSnapshotContentName);
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
  
  public A withPersistentVolumeClaimName(String persistentVolumeClaimName) {
    this.persistentVolumeClaimName = persistentVolumeClaimName;
    return (A) this;
  }
  
  public A withVolumeSnapshotContentName(String volumeSnapshotContentName) {
    this.volumeSnapshotContentName = volumeSnapshotContentName;
    return (A) this;
  }
  
}