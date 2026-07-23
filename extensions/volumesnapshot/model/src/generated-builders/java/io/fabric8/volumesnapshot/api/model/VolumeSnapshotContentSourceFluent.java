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
public class VolumeSnapshotContentSourceFluent<A extends io.fabric8.volumesnapshot.api.model.VolumeSnapshotContentSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String snapshotHandle;
  private String volumeHandle;

  public VolumeSnapshotContentSourceFluent() {
  }
  
  public VolumeSnapshotContentSourceFluent(VolumeSnapshotContentSource instance) {
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
  
  protected void copyInstance(VolumeSnapshotContentSource instance) {
    instance = instance != null ? instance : new VolumeSnapshotContentSource();
    if (instance != null) {
        this.withSnapshotHandle(instance.getSnapshotHandle());
        this.withVolumeHandle(instance.getVolumeHandle());
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
    VolumeSnapshotContentSourceFluent that = (VolumeSnapshotContentSourceFluent) o;
    if (!(Objects.equals(snapshotHandle, that.snapshotHandle))) {
      return false;
    }
    if (!(Objects.equals(volumeHandle, that.volumeHandle))) {
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
  
  public String getSnapshotHandle() {
    return this.snapshotHandle;
  }
  
  public String getVolumeHandle() {
    return this.volumeHandle;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSnapshotHandle() {
    return this.snapshotHandle != null;
  }
  
  public boolean hasVolumeHandle() {
    return this.volumeHandle != null;
  }
  
  public int hashCode() {
    return Objects.hash(snapshotHandle, volumeHandle, additionalProperties);
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
    if (!(snapshotHandle == null)) {
        sb.append("snapshotHandle:");
        sb.append(snapshotHandle);
        sb.append(",");
    }
    if (!(volumeHandle == null)) {
        sb.append("volumeHandle:");
        sb.append(volumeHandle);
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
  
  public A withSnapshotHandle(String snapshotHandle) {
    this.snapshotHandle = snapshotHandle;
    return (A) this;
  }
  
  public A withVolumeHandle(String volumeHandle) {
    this.volumeHandle = volumeHandle;
    return (A) this;
  }
  
}