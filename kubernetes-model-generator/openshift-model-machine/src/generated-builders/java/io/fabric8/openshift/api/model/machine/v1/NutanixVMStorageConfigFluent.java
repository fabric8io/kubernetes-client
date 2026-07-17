package io.fabric8.openshift.api.model.machine.v1;

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
public class NutanixVMStorageConfigFluent<A extends io.fabric8.openshift.api.model.machine.v1.NutanixVMStorageConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String diskMode;
  private NutanixStorageResourceIdentifierBuilder storageContainer;

  public NutanixVMStorageConfigFluent() {
  }
  
  public NutanixVMStorageConfigFluent(NutanixVMStorageConfig instance) {
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
  
  public NutanixStorageResourceIdentifier buildStorageContainer() {
    return this.storageContainer != null ? this.storageContainer.build() : null;
  }
  
  protected void copyInstance(NutanixVMStorageConfig instance) {
    instance = instance != null ? instance : new NutanixVMStorageConfig();
    if (instance != null) {
        this.withDiskMode(instance.getDiskMode());
        this.withStorageContainer(instance.getStorageContainer());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StorageContainerNested<A> editOrNewStorageContainer() {
    return this.withNewStorageContainerLike(Optional.ofNullable(this.buildStorageContainer()).orElse(new NutanixStorageResourceIdentifierBuilder().build()));
  }
  
  public StorageContainerNested<A> editOrNewStorageContainerLike(NutanixStorageResourceIdentifier item) {
    return this.withNewStorageContainerLike(Optional.ofNullable(this.buildStorageContainer()).orElse(item));
  }
  
  public StorageContainerNested<A> editStorageContainer() {
    return this.withNewStorageContainerLike(Optional.ofNullable(this.buildStorageContainer()).orElse(null));
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
    NutanixVMStorageConfigFluent that = (NutanixVMStorageConfigFluent) o;
    if (!(Objects.equals(diskMode, that.diskMode))) {
      return false;
    }
    if (!(Objects.equals(storageContainer, that.storageContainer))) {
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
  
  public String getDiskMode() {
    return this.diskMode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDiskMode() {
    return this.diskMode != null;
  }
  
  public boolean hasStorageContainer() {
    return this.storageContainer != null;
  }
  
  public int hashCode() {
    return Objects.hash(diskMode, storageContainer, additionalProperties);
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
    if (!(diskMode == null)) {
        sb.append("diskMode:");
        sb.append(diskMode);
        sb.append(",");
    }
    if (!(storageContainer == null)) {
        sb.append("storageContainer:");
        sb.append(storageContainer);
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
  
  public A withDiskMode(String diskMode) {
    this.diskMode = diskMode;
    return (A) this;
  }
  
  public StorageContainerNested<A> withNewStorageContainer() {
    return new StorageContainerNested(null);
  }
  
  public A withNewStorageContainer(String type,String uuid) {
    return (A) this.withStorageContainer(new NutanixStorageResourceIdentifier(type, uuid));
  }
  
  public StorageContainerNested<A> withNewStorageContainerLike(NutanixStorageResourceIdentifier item) {
    return new StorageContainerNested(item);
  }
  
  public A withStorageContainer(NutanixStorageResourceIdentifier storageContainer) {
    this._visitables.remove("storageContainer");
    if (storageContainer != null) {
        this.storageContainer = new NutanixStorageResourceIdentifierBuilder(storageContainer);
        this._visitables.get("storageContainer").add(this.storageContainer);
    } else {
        this.storageContainer = null;
        this._visitables.get("storageContainer").remove(this.storageContainer);
    }
    return (A) this;
  }
  public class StorageContainerNested<N> extends NutanixStorageResourceIdentifierFluent<StorageContainerNested<N>> implements Nested<N>{
  
    NutanixStorageResourceIdentifierBuilder builder;
  
    StorageContainerNested(NutanixStorageResourceIdentifier item) {
      this.builder = new NutanixStorageResourceIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixVMStorageConfigFluent.this.withStorageContainer(builder.build());
    }
    
    public N endStorageContainer() {
      return and();
    }
    
  }
}