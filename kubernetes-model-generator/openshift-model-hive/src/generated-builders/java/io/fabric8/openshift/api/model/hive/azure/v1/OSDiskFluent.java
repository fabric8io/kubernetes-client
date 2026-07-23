package io.fabric8.openshift.api.model.hive.azure.v1;

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
public class OSDiskFluent<A extends io.fabric8.openshift.api.model.hive.azure.v1.OSDiskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DiskEncryptionSetBuilder diskEncryptionSet;
  private Integer diskSizeGB;
  private String diskType;

  public OSDiskFluent() {
  }
  
  public OSDiskFluent(OSDisk instance) {
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
  
  public DiskEncryptionSet buildDiskEncryptionSet() {
    return this.diskEncryptionSet != null ? this.diskEncryptionSet.build() : null;
  }
  
  protected void copyInstance(OSDisk instance) {
    instance = instance != null ? instance : new OSDisk();
    if (instance != null) {
        this.withDiskEncryptionSet(instance.getDiskEncryptionSet());
        this.withDiskSizeGB(instance.getDiskSizeGB());
        this.withDiskType(instance.getDiskType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DiskEncryptionSetNested<A> editDiskEncryptionSet() {
    return this.withNewDiskEncryptionSetLike(Optional.ofNullable(this.buildDiskEncryptionSet()).orElse(null));
  }
  
  public DiskEncryptionSetNested<A> editOrNewDiskEncryptionSet() {
    return this.withNewDiskEncryptionSetLike(Optional.ofNullable(this.buildDiskEncryptionSet()).orElse(new DiskEncryptionSetBuilder().build()));
  }
  
  public DiskEncryptionSetNested<A> editOrNewDiskEncryptionSetLike(DiskEncryptionSet item) {
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
    OSDiskFluent that = (OSDiskFluent) o;
    if (!(Objects.equals(diskEncryptionSet, that.diskEncryptionSet))) {
      return false;
    }
    if (!(Objects.equals(diskSizeGB, that.diskSizeGB))) {
      return false;
    }
    if (!(Objects.equals(diskType, that.diskType))) {
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
  
  public Integer getDiskSizeGB() {
    return this.diskSizeGB;
  }
  
  public String getDiskType() {
    return this.diskType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDiskEncryptionSet() {
    return this.diskEncryptionSet != null;
  }
  
  public boolean hasDiskSizeGB() {
    return this.diskSizeGB != null;
  }
  
  public boolean hasDiskType() {
    return this.diskType != null;
  }
  
  public int hashCode() {
    return Objects.hash(diskEncryptionSet, diskSizeGB, diskType, additionalProperties);
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
    if (!(diskSizeGB == null)) {
        sb.append("diskSizeGB:");
        sb.append(diskSizeGB);
        sb.append(",");
    }
    if (!(diskType == null)) {
        sb.append("diskType:");
        sb.append(diskType);
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
  
  public A withDiskEncryptionSet(DiskEncryptionSet diskEncryptionSet) {
    this._visitables.remove("diskEncryptionSet");
    if (diskEncryptionSet != null) {
        this.diskEncryptionSet = new DiskEncryptionSetBuilder(diskEncryptionSet);
        this._visitables.get("diskEncryptionSet").add(this.diskEncryptionSet);
    } else {
        this.diskEncryptionSet = null;
        this._visitables.get("diskEncryptionSet").remove(this.diskEncryptionSet);
    }
    return (A) this;
  }
  
  public A withDiskSizeGB(Integer diskSizeGB) {
    this.diskSizeGB = diskSizeGB;
    return (A) this;
  }
  
  public A withDiskType(String diskType) {
    this.diskType = diskType;
    return (A) this;
  }
  
  public DiskEncryptionSetNested<A> withNewDiskEncryptionSet() {
    return new DiskEncryptionSetNested(null);
  }
  
  public A withNewDiskEncryptionSet(String name,String resourceGroup,String subscriptionId) {
    return (A) this.withDiskEncryptionSet(new DiskEncryptionSet(name, resourceGroup, subscriptionId));
  }
  
  public DiskEncryptionSetNested<A> withNewDiskEncryptionSetLike(DiskEncryptionSet item) {
    return new DiskEncryptionSetNested(item);
  }
  public class DiskEncryptionSetNested<N> extends DiskEncryptionSetFluent<DiskEncryptionSetNested<N>> implements Nested<N>{
  
    DiskEncryptionSetBuilder builder;
  
    DiskEncryptionSetNested(DiskEncryptionSet item) {
      this.builder = new DiskEncryptionSetBuilder(this, item);
    }
  
    public N and() {
      return (N) OSDiskFluent.this.withDiskEncryptionSet(builder.build());
    }
    
    public N endDiskEncryptionSet() {
      return and();
    }
    
  }
}