package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DataDiskFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.DataDiskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cachingType;
  private String deletionPolicy;
  private Integer diskSizeGB;
  private Integer lun;
  private DataDiskManagedDiskParametersBuilder managedDisk;
  private String nameSuffix;

  public DataDiskFluent() {
  }
  
  public DataDiskFluent(DataDisk instance) {
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
  
  public DataDiskManagedDiskParameters buildManagedDisk() {
    return this.managedDisk != null ? this.managedDisk.build() : null;
  }
  
  protected void copyInstance(DataDisk instance) {
    instance = instance != null ? instance : new DataDisk();
    if (instance != null) {
        this.withCachingType(instance.getCachingType());
        this.withDeletionPolicy(instance.getDeletionPolicy());
        this.withDiskSizeGB(instance.getDiskSizeGB());
        this.withLun(instance.getLun());
        this.withManagedDisk(instance.getManagedDisk());
        this.withNameSuffix(instance.getNameSuffix());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ManagedDiskNested<A> editManagedDisk() {
    return this.withNewManagedDiskLike(Optional.ofNullable(this.buildManagedDisk()).orElse(null));
  }
  
  public ManagedDiskNested<A> editOrNewManagedDisk() {
    return this.withNewManagedDiskLike(Optional.ofNullable(this.buildManagedDisk()).orElse(new DataDiskManagedDiskParametersBuilder().build()));
  }
  
  public ManagedDiskNested<A> editOrNewManagedDiskLike(DataDiskManagedDiskParameters item) {
    return this.withNewManagedDiskLike(Optional.ofNullable(this.buildManagedDisk()).orElse(item));
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
    DataDiskFluent that = (DataDiskFluent) o;
    if (!(Objects.equals(cachingType, that.cachingType))) {
      return false;
    }
    if (!(Objects.equals(deletionPolicy, that.deletionPolicy))) {
      return false;
    }
    if (!(Objects.equals(diskSizeGB, that.diskSizeGB))) {
      return false;
    }
    if (!(Objects.equals(lun, that.lun))) {
      return false;
    }
    if (!(Objects.equals(managedDisk, that.managedDisk))) {
      return false;
    }
    if (!(Objects.equals(nameSuffix, that.nameSuffix))) {
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
  
  public String getCachingType() {
    return this.cachingType;
  }
  
  public String getDeletionPolicy() {
    return this.deletionPolicy;
  }
  
  public Integer getDiskSizeGB() {
    return this.diskSizeGB;
  }
  
  public Integer getLun() {
    return this.lun;
  }
  
  public String getNameSuffix() {
    return this.nameSuffix;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCachingType() {
    return this.cachingType != null;
  }
  
  public boolean hasDeletionPolicy() {
    return this.deletionPolicy != null;
  }
  
  public boolean hasDiskSizeGB() {
    return this.diskSizeGB != null;
  }
  
  public boolean hasLun() {
    return this.lun != null;
  }
  
  public boolean hasManagedDisk() {
    return this.managedDisk != null;
  }
  
  public boolean hasNameSuffix() {
    return this.nameSuffix != null;
  }
  
  public int hashCode() {
    return Objects.hash(cachingType, deletionPolicy, diskSizeGB, lun, managedDisk, nameSuffix, additionalProperties);
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
    if (!(cachingType == null)) {
        sb.append("cachingType:");
        sb.append(cachingType);
        sb.append(",");
    }
    if (!(deletionPolicy == null)) {
        sb.append("deletionPolicy:");
        sb.append(deletionPolicy);
        sb.append(",");
    }
    if (!(diskSizeGB == null)) {
        sb.append("diskSizeGB:");
        sb.append(diskSizeGB);
        sb.append(",");
    }
    if (!(lun == null)) {
        sb.append("lun:");
        sb.append(lun);
        sb.append(",");
    }
    if (!(managedDisk == null)) {
        sb.append("managedDisk:");
        sb.append(managedDisk);
        sb.append(",");
    }
    if (!(nameSuffix == null)) {
        sb.append("nameSuffix:");
        sb.append(nameSuffix);
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
  
  public A withCachingType(String cachingType) {
    this.cachingType = cachingType;
    return (A) this;
  }
  
  public A withDeletionPolicy(String deletionPolicy) {
    this.deletionPolicy = deletionPolicy;
    return (A) this;
  }
  
  public A withDiskSizeGB(Integer diskSizeGB) {
    this.diskSizeGB = diskSizeGB;
    return (A) this;
  }
  
  public A withLun(Integer lun) {
    this.lun = lun;
    return (A) this;
  }
  
  public A withManagedDisk(DataDiskManagedDiskParameters managedDisk) {
    this._visitables.remove("managedDisk");
    if (managedDisk != null) {
        this.managedDisk = new DataDiskManagedDiskParametersBuilder(managedDisk);
        this._visitables.get("managedDisk").add(this.managedDisk);
    } else {
        this.managedDisk = null;
        this._visitables.get("managedDisk").remove(this.managedDisk);
    }
    return (A) this;
  }
  
  public A withNameSuffix(String nameSuffix) {
    this.nameSuffix = nameSuffix;
    return (A) this;
  }
  
  public ManagedDiskNested<A> withNewManagedDisk() {
    return new ManagedDiskNested(null);
  }
  
  public ManagedDiskNested<A> withNewManagedDiskLike(DataDiskManagedDiskParameters item) {
    return new ManagedDiskNested(item);
  }
  public class ManagedDiskNested<N> extends DataDiskManagedDiskParametersFluent<ManagedDiskNested<N>> implements Nested<N>{
  
    DataDiskManagedDiskParametersBuilder builder;
  
    ManagedDiskNested(DataDiskManagedDiskParameters item) {
      this.builder = new DataDiskManagedDiskParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) DataDiskFluent.this.withManagedDisk(builder.build());
    }
    
    public N endManagedDisk() {
      return and();
    }
    
  }
}