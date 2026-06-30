package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class AzureDiskVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.AzureDiskVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cachingMode;
  private String diskName;
  private String diskURI;
  private String fsType;
  private String kind;
  private Boolean readOnly;

  public AzureDiskVolumeSourceFluent() {
  }
  
  public AzureDiskVolumeSourceFluent(AzureDiskVolumeSource instance) {
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
  
  protected void copyInstance(AzureDiskVolumeSource instance) {
    instance = instance != null ? instance : new AzureDiskVolumeSource();
    if (instance != null) {
        this.withCachingMode(instance.getCachingMode());
        this.withDiskName(instance.getDiskName());
        this.withDiskURI(instance.getDiskURI());
        this.withFsType(instance.getFsType());
        this.withKind(instance.getKind());
        this.withReadOnly(instance.getReadOnly());
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
    AzureDiskVolumeSourceFluent that = (AzureDiskVolumeSourceFluent) o;
    if (!(Objects.equals(cachingMode, that.cachingMode))) {
      return false;
    }
    if (!(Objects.equals(diskName, that.diskName))) {
      return false;
    }
    if (!(Objects.equals(diskURI, that.diskURI))) {
      return false;
    }
    if (!(Objects.equals(fsType, that.fsType))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
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
  
  public String getCachingMode() {
    return this.cachingMode;
  }
  
  public String getDiskName() {
    return this.diskName;
  }
  
  public String getDiskURI() {
    return this.diskURI;
  }
  
  public String getFsType() {
    return this.fsType;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCachingMode() {
    return this.cachingMode != null;
  }
  
  public boolean hasDiskName() {
    return this.diskName != null;
  }
  
  public boolean hasDiskURI() {
    return this.diskURI != null;
  }
  
  public boolean hasFsType() {
    return this.fsType != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public int hashCode() {
    return Objects.hash(cachingMode, diskName, diskURI, fsType, kind, readOnly, additionalProperties);
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
    if (!(cachingMode == null)) {
        sb.append("cachingMode:");
        sb.append(cachingMode);
        sb.append(",");
    }
    if (!(diskName == null)) {
        sb.append("diskName:");
        sb.append(diskName);
        sb.append(",");
    }
    if (!(diskURI == null)) {
        sb.append("diskURI:");
        sb.append(diskURI);
        sb.append(",");
    }
    if (!(fsType == null)) {
        sb.append("fsType:");
        sb.append(fsType);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
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
  
  public A withCachingMode(String cachingMode) {
    this.cachingMode = cachingMode;
    return (A) this;
  }
  
  public A withDiskName(String diskName) {
    this.diskName = diskName;
    return (A) this;
  }
  
  public A withDiskURI(String diskURI) {
    this.diskURI = diskURI;
    return (A) this;
  }
  
  public A withFsType(String fsType) {
    this.fsType = fsType;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
}