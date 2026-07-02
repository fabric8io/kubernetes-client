package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class GCEPersistentDiskVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.GCEPersistentDiskVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String fsType;
  private Integer partition;
  private String pdName;
  private Boolean readOnly;

  public GCEPersistentDiskVolumeSourceFluent() {
  }
  
  public GCEPersistentDiskVolumeSourceFluent(GCEPersistentDiskVolumeSource instance) {
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
  
  protected void copyInstance(GCEPersistentDiskVolumeSource instance) {
    instance = instance != null ? instance : new GCEPersistentDiskVolumeSource();
    if (instance != null) {
        this.withFsType(instance.getFsType());
        this.withPartition(instance.getPartition());
        this.withPdName(instance.getPdName());
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
    GCEPersistentDiskVolumeSourceFluent that = (GCEPersistentDiskVolumeSourceFluent) o;
    if (!(Objects.equals(fsType, that.fsType))) {
      return false;
    }
    if (!(Objects.equals(partition, that.partition))) {
      return false;
    }
    if (!(Objects.equals(pdName, that.pdName))) {
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
  
  public String getFsType() {
    return this.fsType;
  }
  
  public Integer getPartition() {
    return this.partition;
  }
  
  public String getPdName() {
    return this.pdName;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFsType() {
    return this.fsType != null;
  }
  
  public boolean hasPartition() {
    return this.partition != null;
  }
  
  public boolean hasPdName() {
    return this.pdName != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public int hashCode() {
    return Objects.hash(fsType, partition, pdName, readOnly, additionalProperties);
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
    if (!(partition == null)) {
        sb.append("partition:");
        sb.append(partition);
        sb.append(",");
    }
    if (!(pdName == null)) {
        sb.append("pdName:");
        sb.append(pdName);
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
  
  public A withFsType(String fsType) {
    this.fsType = fsType;
    return (A) this;
  }
  
  public A withPartition(Integer partition) {
    this.partition = partition;
    return (A) this;
  }
  
  public A withPdName(String pdName) {
    this.pdName = pdName;
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