package io.fabric8.openshift.api.model.machine.v1alpha1;

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
public class AdditionalBlockDeviceFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.AdditionalBlockDeviceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private Integer sizeGiB;
  private BlockDeviceStorageBuilder storage;

  public AdditionalBlockDeviceFluent() {
  }
  
  public AdditionalBlockDeviceFluent(AdditionalBlockDevice instance) {
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
  
  public BlockDeviceStorage buildStorage() {
    return this.storage != null ? this.storage.build() : null;
  }
  
  protected void copyInstance(AdditionalBlockDevice instance) {
    instance = instance != null ? instance : new AdditionalBlockDevice();
    if (instance != null) {
        this.withName(instance.getName());
        this.withSizeGiB(instance.getSizeGiB());
        this.withStorage(instance.getStorage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StorageNested<A> editOrNewStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(new BlockDeviceStorageBuilder().build()));
  }
  
  public StorageNested<A> editOrNewStorageLike(BlockDeviceStorage item) {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(item));
  }
  
  public StorageNested<A> editStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(null));
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
    AdditionalBlockDeviceFluent that = (AdditionalBlockDeviceFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(sizeGiB, that.sizeGiB))) {
      return false;
    }
    if (!(Objects.equals(storage, that.storage))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public Integer getSizeGiB() {
    return this.sizeGiB;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSizeGiB() {
    return this.sizeGiB != null;
  }
  
  public boolean hasStorage() {
    return this.storage != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, sizeGiB, storage, additionalProperties);
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
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(sizeGiB == null)) {
        sb.append("sizeGiB:");
        sb.append(sizeGiB);
        sb.append(",");
    }
    if (!(storage == null)) {
        sb.append("storage:");
        sb.append(storage);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public StorageNested<A> withNewStorage() {
    return new StorageNested(null);
  }
  
  public StorageNested<A> withNewStorageLike(BlockDeviceStorage item) {
    return new StorageNested(item);
  }
  
  public A withSizeGiB(Integer sizeGiB) {
    this.sizeGiB = sizeGiB;
    return (A) this;
  }
  
  public A withStorage(BlockDeviceStorage storage) {
    this._visitables.remove("storage");
    if (storage != null) {
        this.storage = new BlockDeviceStorageBuilder(storage);
        this._visitables.get("storage").add(this.storage);
    } else {
        this.storage = null;
        this._visitables.get("storage").remove(this.storage);
    }
    return (A) this;
  }
  public class StorageNested<N> extends BlockDeviceStorageFluent<StorageNested<N>> implements Nested<N>{
  
    BlockDeviceStorageBuilder builder;
  
    StorageNested(BlockDeviceStorage item) {
      this.builder = new BlockDeviceStorageBuilder(this, item);
    }
  
    public N and() {
      return (N) AdditionalBlockDeviceFluent.this.withStorage(builder.build());
    }
    
    public N endStorage() {
      return and();
    }
    
  }
}