package io.fabric8.openshift.api.model.machine.v1alpha1;

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
public class RootVolumeFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.RootVolumeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String availabilityZone;
  private String deviceType;
  private Integer diskSize;
  private String sourceType;
  private String sourceUUID;
  private String volumeType;

  public RootVolumeFluent() {
  }
  
  public RootVolumeFluent(RootVolume instance) {
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
  
  protected void copyInstance(RootVolume instance) {
    instance = instance != null ? instance : new RootVolume();
    if (instance != null) {
        this.withAvailabilityZone(instance.getAvailabilityZone());
        this.withDeviceType(instance.getDeviceType());
        this.withDiskSize(instance.getDiskSize());
        this.withSourceType(instance.getSourceType());
        this.withSourceUUID(instance.getSourceUUID());
        this.withVolumeType(instance.getVolumeType());
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
    RootVolumeFluent that = (RootVolumeFluent) o;
    if (!(Objects.equals(availabilityZone, that.availabilityZone))) {
      return false;
    }
    if (!(Objects.equals(deviceType, that.deviceType))) {
      return false;
    }
    if (!(Objects.equals(diskSize, that.diskSize))) {
      return false;
    }
    if (!(Objects.equals(sourceType, that.sourceType))) {
      return false;
    }
    if (!(Objects.equals(sourceUUID, that.sourceUUID))) {
      return false;
    }
    if (!(Objects.equals(volumeType, that.volumeType))) {
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
  
  public String getAvailabilityZone() {
    return this.availabilityZone;
  }
  
  public String getDeviceType() {
    return this.deviceType;
  }
  
  public Integer getDiskSize() {
    return this.diskSize;
  }
  
  public String getSourceType() {
    return this.sourceType;
  }
  
  public String getSourceUUID() {
    return this.sourceUUID;
  }
  
  public String getVolumeType() {
    return this.volumeType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailabilityZone() {
    return this.availabilityZone != null;
  }
  
  public boolean hasDeviceType() {
    return this.deviceType != null;
  }
  
  public boolean hasDiskSize() {
    return this.diskSize != null;
  }
  
  public boolean hasSourceType() {
    return this.sourceType != null;
  }
  
  public boolean hasSourceUUID() {
    return this.sourceUUID != null;
  }
  
  public boolean hasVolumeType() {
    return this.volumeType != null;
  }
  
  public int hashCode() {
    return Objects.hash(availabilityZone, deviceType, diskSize, sourceType, sourceUUID, volumeType, additionalProperties);
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
    if (!(availabilityZone == null)) {
        sb.append("availabilityZone:");
        sb.append(availabilityZone);
        sb.append(",");
    }
    if (!(deviceType == null)) {
        sb.append("deviceType:");
        sb.append(deviceType);
        sb.append(",");
    }
    if (!(diskSize == null)) {
        sb.append("diskSize:");
        sb.append(diskSize);
        sb.append(",");
    }
    if (!(sourceType == null)) {
        sb.append("sourceType:");
        sb.append(sourceType);
        sb.append(",");
    }
    if (!(sourceUUID == null)) {
        sb.append("sourceUUID:");
        sb.append(sourceUUID);
        sb.append(",");
    }
    if (!(volumeType == null)) {
        sb.append("volumeType:");
        sb.append(volumeType);
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
  
  public A withAvailabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
    return (A) this;
  }
  
  public A withDeviceType(String deviceType) {
    this.deviceType = deviceType;
    return (A) this;
  }
  
  public A withDiskSize(Integer diskSize) {
    this.diskSize = diskSize;
    return (A) this;
  }
  
  public A withSourceType(String sourceType) {
    this.sourceType = sourceType;
    return (A) this;
  }
  
  public A withSourceUUID(String sourceUUID) {
    this.sourceUUID = sourceUUID;
    return (A) this;
  }
  
  public A withVolumeType(String volumeType) {
    this.volumeType = volumeType;
    return (A) this;
  }
  
}