package io.fabric8.kubernetes.api.model;

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
public class VsphereVirtualDiskVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.VsphereVirtualDiskVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String fsType;
  private String storagePolicyID;
  private String storagePolicyName;
  private String volumePath;

  public VsphereVirtualDiskVolumeSourceFluent() {
  }
  
  public VsphereVirtualDiskVolumeSourceFluent(VsphereVirtualDiskVolumeSource instance) {
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
  
  protected void copyInstance(VsphereVirtualDiskVolumeSource instance) {
    instance = instance != null ? instance : new VsphereVirtualDiskVolumeSource();
    if (instance != null) {
        this.withFsType(instance.getFsType());
        this.withStoragePolicyID(instance.getStoragePolicyID());
        this.withStoragePolicyName(instance.getStoragePolicyName());
        this.withVolumePath(instance.getVolumePath());
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
    VsphereVirtualDiskVolumeSourceFluent that = (VsphereVirtualDiskVolumeSourceFluent) o;
    if (!(Objects.equals(fsType, that.fsType))) {
      return false;
    }
    if (!(Objects.equals(storagePolicyID, that.storagePolicyID))) {
      return false;
    }
    if (!(Objects.equals(storagePolicyName, that.storagePolicyName))) {
      return false;
    }
    if (!(Objects.equals(volumePath, that.volumePath))) {
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
  
  public String getFsType() {
    return this.fsType;
  }
  
  public String getStoragePolicyID() {
    return this.storagePolicyID;
  }
  
  public String getStoragePolicyName() {
    return this.storagePolicyName;
  }
  
  public String getVolumePath() {
    return this.volumePath;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFsType() {
    return this.fsType != null;
  }
  
  public boolean hasStoragePolicyID() {
    return this.storagePolicyID != null;
  }
  
  public boolean hasStoragePolicyName() {
    return this.storagePolicyName != null;
  }
  
  public boolean hasVolumePath() {
    return this.volumePath != null;
  }
  
  public int hashCode() {
    return Objects.hash(fsType, storagePolicyID, storagePolicyName, volumePath, additionalProperties);
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
    if (!(fsType == null)) {
        sb.append("fsType:");
        sb.append(fsType);
        sb.append(",");
    }
    if (!(storagePolicyID == null)) {
        sb.append("storagePolicyID:");
        sb.append(storagePolicyID);
        sb.append(",");
    }
    if (!(storagePolicyName == null)) {
        sb.append("storagePolicyName:");
        sb.append(storagePolicyName);
        sb.append(",");
    }
    if (!(volumePath == null)) {
        sb.append("volumePath:");
        sb.append(volumePath);
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
  
  public A withFsType(String fsType) {
    this.fsType = fsType;
    return (A) this;
  }
  
  public A withStoragePolicyID(String storagePolicyID) {
    this.storagePolicyID = storagePolicyID;
    return (A) this;
  }
  
  public A withStoragePolicyName(String storagePolicyName) {
    this.storagePolicyName = storagePolicyName;
    return (A) this;
  }
  
  public A withVolumePath(String volumePath) {
    this.volumePath = volumePath;
    return (A) this;
  }
  
}