package io.fabric8.openshift.api.model.operator.v1;

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
public class AzureCSIDriverConfigSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.AzureCSIDriverConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AzureDiskEncryptionSetBuilder diskEncryptionSet;

  public AzureCSIDriverConfigSpecFluent() {
  }
  
  public AzureCSIDriverConfigSpecFluent(AzureCSIDriverConfigSpec instance) {
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
  
  public AzureDiskEncryptionSet buildDiskEncryptionSet() {
    return this.diskEncryptionSet != null ? this.diskEncryptionSet.build() : null;
  }
  
  protected void copyInstance(AzureCSIDriverConfigSpec instance) {
    instance = instance != null ? instance : new AzureCSIDriverConfigSpec();
    if (instance != null) {
        this.withDiskEncryptionSet(instance.getDiskEncryptionSet());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DiskEncryptionSetNested<A> editDiskEncryptionSet() {
    return this.withNewDiskEncryptionSetLike(Optional.ofNullable(this.buildDiskEncryptionSet()).orElse(null));
  }
  
  public DiskEncryptionSetNested<A> editOrNewDiskEncryptionSet() {
    return this.withNewDiskEncryptionSetLike(Optional.ofNullable(this.buildDiskEncryptionSet()).orElse(new AzureDiskEncryptionSetBuilder().build()));
  }
  
  public DiskEncryptionSetNested<A> editOrNewDiskEncryptionSetLike(AzureDiskEncryptionSet item) {
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
    AzureCSIDriverConfigSpecFluent that = (AzureCSIDriverConfigSpecFluent) o;
    if (!(Objects.equals(diskEncryptionSet, that.diskEncryptionSet))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDiskEncryptionSet() {
    return this.diskEncryptionSet != null;
  }
  
  public int hashCode() {
    return Objects.hash(diskEncryptionSet, additionalProperties);
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
  
  public A withDiskEncryptionSet(AzureDiskEncryptionSet diskEncryptionSet) {
    this._visitables.remove("diskEncryptionSet");
    if (diskEncryptionSet != null) {
        this.diskEncryptionSet = new AzureDiskEncryptionSetBuilder(diskEncryptionSet);
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
  
  public A withNewDiskEncryptionSet(String name,String resourceGroup,String subscriptionID) {
    return (A) this.withDiskEncryptionSet(new AzureDiskEncryptionSet(name, resourceGroup, subscriptionID));
  }
  
  public DiskEncryptionSetNested<A> withNewDiskEncryptionSetLike(AzureDiskEncryptionSet item) {
    return new DiskEncryptionSetNested(item);
  }
  public class DiskEncryptionSetNested<N> extends AzureDiskEncryptionSetFluent<DiskEncryptionSetNested<N>> implements Nested<N>{
  
    AzureDiskEncryptionSetBuilder builder;
  
    DiskEncryptionSetNested(AzureDiskEncryptionSet item) {
      this.builder = new AzureDiskEncryptionSetBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureCSIDriverConfigSpecFluent.this.withDiskEncryptionSet(builder.build());
    }
    
    public N endDiskEncryptionSet() {
      return and();
    }
    
  }
}