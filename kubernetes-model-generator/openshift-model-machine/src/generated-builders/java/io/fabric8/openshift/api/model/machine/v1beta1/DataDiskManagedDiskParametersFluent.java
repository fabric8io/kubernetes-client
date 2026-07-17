package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class DataDiskManagedDiskParametersFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.DataDiskManagedDiskParametersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DiskEncryptionSetParametersBuilder diskEncryptionSet;
  private String storageAccountType;

  public DataDiskManagedDiskParametersFluent() {
  }
  
  public DataDiskManagedDiskParametersFluent(DataDiskManagedDiskParameters instance) {
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
  
  public DiskEncryptionSetParameters buildDiskEncryptionSet() {
    return this.diskEncryptionSet != null ? this.diskEncryptionSet.build() : null;
  }
  
  protected void copyInstance(DataDiskManagedDiskParameters instance) {
    instance = instance != null ? instance : new DataDiskManagedDiskParameters();
    if (instance != null) {
        this.withDiskEncryptionSet(instance.getDiskEncryptionSet());
        this.withStorageAccountType(instance.getStorageAccountType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DiskEncryptionSetNested<A> editDiskEncryptionSet() {
    return this.withNewDiskEncryptionSetLike(Optional.ofNullable(this.buildDiskEncryptionSet()).orElse(null));
  }
  
  public DiskEncryptionSetNested<A> editOrNewDiskEncryptionSet() {
    return this.withNewDiskEncryptionSetLike(Optional.ofNullable(this.buildDiskEncryptionSet()).orElse(new DiskEncryptionSetParametersBuilder().build()));
  }
  
  public DiskEncryptionSetNested<A> editOrNewDiskEncryptionSetLike(DiskEncryptionSetParameters item) {
    return this.withNewDiskEncryptionSetLike(Optional.ofNullable(this.buildDiskEncryptionSet()).orElse(item));
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
    DataDiskManagedDiskParametersFluent that = (DataDiskManagedDiskParametersFluent) o;
    if (!(Objects.equals(diskEncryptionSet, that.diskEncryptionSet))) {
      return false;
    }
    if (!(Objects.equals(storageAccountType, that.storageAccountType))) {
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
  
  public String getStorageAccountType() {
    return this.storageAccountType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDiskEncryptionSet() {
    return this.diskEncryptionSet != null;
  }
  
  public boolean hasStorageAccountType() {
    return this.storageAccountType != null;
  }
  
  public int hashCode() {
    return Objects.hash(diskEncryptionSet, storageAccountType, additionalProperties);
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
    if (!(diskEncryptionSet == null)) {
        sb.append("diskEncryptionSet:");
        sb.append(diskEncryptionSet);
        sb.append(",");
    }
    if (!(storageAccountType == null)) {
        sb.append("storageAccountType:");
        sb.append(storageAccountType);
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
  
  public A withDiskEncryptionSet(DiskEncryptionSetParameters diskEncryptionSet) {
    this._visitables.remove("diskEncryptionSet");
    if (diskEncryptionSet != null) {
        this.diskEncryptionSet = new DiskEncryptionSetParametersBuilder(diskEncryptionSet);
        this._visitables.get("diskEncryptionSet").add(this.diskEncryptionSet);
    } else {
        this.diskEncryptionSet = null;
        this._visitables.get("diskEncryptionSet").remove(this.diskEncryptionSet);
    }
    return (A) this;
  }
  
  public DiskEncryptionSetNested<A> withNewDiskEncryptionSet() {
    return new DiskEncryptionSetNested(null);
  }
  
  public A withNewDiskEncryptionSet(String id) {
    return (A) this.withDiskEncryptionSet(new DiskEncryptionSetParameters(id));
  }
  
  public DiskEncryptionSetNested<A> withNewDiskEncryptionSetLike(DiskEncryptionSetParameters item) {
    return new DiskEncryptionSetNested(item);
  }
  
  public A withStorageAccountType(String storageAccountType) {
    this.storageAccountType = storageAccountType;
    return (A) this;
  }
  public class DiskEncryptionSetNested<N> extends DiskEncryptionSetParametersFluent<DiskEncryptionSetNested<N>> implements Nested<N>{
  
    DiskEncryptionSetParametersBuilder builder;
  
    DiskEncryptionSetNested(DiskEncryptionSetParameters item) {
      this.builder = new DiskEncryptionSetParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) DataDiskManagedDiskParametersFluent.this.withDiskEncryptionSet(builder.build());
    }
    
    public N endDiskEncryptionSet() {
      return and();
    }
    
  }
}