package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class DataDiskPropertiesFluent<A extends io.fabric8.openshift.api.model.machine.v1.DataDiskPropertiesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String category;
  private String diskEncryption;
  private String diskPreservation;
  private String kMSKeyID;
  private String name;
  private String performanceLevel;
  private Long size;
  private String snapshotID;

  public DataDiskPropertiesFluent() {
  }
  
  public DataDiskPropertiesFluent(DataDiskProperties instance) {
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
  
  protected void copyInstance(DataDiskProperties instance) {
    instance = instance != null ? instance : new DataDiskProperties();
    if (instance != null) {
        this.withCategory(instance.getCategory());
        this.withDiskEncryption(instance.getDiskEncryption());
        this.withDiskPreservation(instance.getDiskPreservation());
        this.withKMSKeyID(instance.getKMSKeyID());
        this.withName(instance.getName());
        this.withPerformanceLevel(instance.getPerformanceLevel());
        this.withSize(instance.getSize());
        this.withSnapshotID(instance.getSnapshotID());
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
    DataDiskPropertiesFluent that = (DataDiskPropertiesFluent) o;
    if (!(Objects.equals(category, that.category))) {
      return false;
    }
    if (!(Objects.equals(diskEncryption, that.diskEncryption))) {
      return false;
    }
    if (!(Objects.equals(diskPreservation, that.diskPreservation))) {
      return false;
    }
    if (!(Objects.equals(kMSKeyID, that.kMSKeyID))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(performanceLevel, that.performanceLevel))) {
      return false;
    }
    if (!(Objects.equals(size, that.size))) {
      return false;
    }
    if (!(Objects.equals(snapshotID, that.snapshotID))) {
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
  
  public String getCategory() {
    return this.category;
  }
  
  public String getDiskEncryption() {
    return this.diskEncryption;
  }
  
  public String getDiskPreservation() {
    return this.diskPreservation;
  }
  
  public String getKMSKeyID() {
    return this.kMSKeyID;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getPerformanceLevel() {
    return this.performanceLevel;
  }
  
  public Long getSize() {
    return this.size;
  }
  
  public String getSnapshotID() {
    return this.snapshotID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCategory() {
    return this.category != null;
  }
  
  public boolean hasDiskEncryption() {
    return this.diskEncryption != null;
  }
  
  public boolean hasDiskPreservation() {
    return this.diskPreservation != null;
  }
  
  public boolean hasKMSKeyID() {
    return this.kMSKeyID != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPerformanceLevel() {
    return this.performanceLevel != null;
  }
  
  public boolean hasSize() {
    return this.size != null;
  }
  
  public boolean hasSnapshotID() {
    return this.snapshotID != null;
  }
  
  public int hashCode() {
    return Objects.hash(category, diskEncryption, diskPreservation, kMSKeyID, name, performanceLevel, size, snapshotID, additionalProperties);
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
    if (!(category == null)) {
        sb.append("category:");
        sb.append(category);
        sb.append(",");
    }
    if (!(diskEncryption == null)) {
        sb.append("diskEncryption:");
        sb.append(diskEncryption);
        sb.append(",");
    }
    if (!(diskPreservation == null)) {
        sb.append("diskPreservation:");
        sb.append(diskPreservation);
        sb.append(",");
    }
    if (!(kMSKeyID == null)) {
        sb.append("kMSKeyID:");
        sb.append(kMSKeyID);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(performanceLevel == null)) {
        sb.append("performanceLevel:");
        sb.append(performanceLevel);
        sb.append(",");
    }
    if (!(size == null)) {
        sb.append("size:");
        sb.append(size);
        sb.append(",");
    }
    if (!(snapshotID == null)) {
        sb.append("snapshotID:");
        sb.append(snapshotID);
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
  
  public A withCategory(String category) {
    this.category = category;
    return (A) this;
  }
  
  public A withDiskEncryption(String diskEncryption) {
    this.diskEncryption = diskEncryption;
    return (A) this;
  }
  
  public A withDiskPreservation(String diskPreservation) {
    this.diskPreservation = diskPreservation;
    return (A) this;
  }
  
  public A withKMSKeyID(String kMSKeyID) {
    this.kMSKeyID = kMSKeyID;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withPerformanceLevel(String performanceLevel) {
    this.performanceLevel = performanceLevel;
    return (A) this;
  }
  
  public A withSize(Long size) {
    this.size = size;
    return (A) this;
  }
  
  public A withSnapshotID(String snapshotID) {
    this.snapshotID = snapshotID;
    return (A) this;
  }
  
}