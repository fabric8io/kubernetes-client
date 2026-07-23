package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.openshift.api.model.machine.v1.NutanixVMDiskDeviceProperties;
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
public class DataDiskFluent<A extends io.fabric8.openshift.api.model.installer.nutanix.v1.DataDiskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private StorageResourceReferenceBuilder dataSourceImage;
  private NutanixVMDiskDeviceProperties deviceProperties;
  private Quantity diskSize;
  private StorageConfigBuilder storageConfig;

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
  
  public StorageResourceReference buildDataSourceImage() {
    return this.dataSourceImage != null ? this.dataSourceImage.build() : null;
  }
  
  public StorageConfig buildStorageConfig() {
    return this.storageConfig != null ? this.storageConfig.build() : null;
  }
  
  protected void copyInstance(DataDisk instance) {
    instance = instance != null ? instance : new DataDisk();
    if (instance != null) {
        this.withDataSourceImage(instance.getDataSourceImage());
        this.withDeviceProperties(instance.getDeviceProperties());
        this.withDiskSize(instance.getDiskSize());
        this.withStorageConfig(instance.getStorageConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DataSourceImageNested<A> editDataSourceImage() {
    return this.withNewDataSourceImageLike(Optional.ofNullable(this.buildDataSourceImage()).orElse(null));
  }
  
  public DataSourceImageNested<A> editOrNewDataSourceImage() {
    return this.withNewDataSourceImageLike(Optional.ofNullable(this.buildDataSourceImage()).orElse(new StorageResourceReferenceBuilder().build()));
  }
  
  public DataSourceImageNested<A> editOrNewDataSourceImageLike(StorageResourceReference item) {
    return this.withNewDataSourceImageLike(Optional.ofNullable(this.buildDataSourceImage()).orElse(item));
  }
  
  public StorageConfigNested<A> editOrNewStorageConfig() {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(new StorageConfigBuilder().build()));
  }
  
  public StorageConfigNested<A> editOrNewStorageConfigLike(StorageConfig item) {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(item));
  }
  
  public StorageConfigNested<A> editStorageConfig() {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(null));
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
    if (!(Objects.equals(dataSourceImage, that.dataSourceImage))) {
      return false;
    }
    if (!(Objects.equals(deviceProperties, that.deviceProperties))) {
      return false;
    }
    if (!(Objects.equals(diskSize, that.diskSize))) {
      return false;
    }
    if (!(Objects.equals(storageConfig, that.storageConfig))) {
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
  
  public NutanixVMDiskDeviceProperties getDeviceProperties() {
    return this.deviceProperties;
  }
  
  public Quantity getDiskSize() {
    return this.diskSize;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDataSourceImage() {
    return this.dataSourceImage != null;
  }
  
  public boolean hasDeviceProperties() {
    return this.deviceProperties != null;
  }
  
  public boolean hasDiskSize() {
    return this.diskSize != null;
  }
  
  public boolean hasStorageConfig() {
    return this.storageConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(dataSourceImage, deviceProperties, diskSize, storageConfig, additionalProperties);
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
    if (!(dataSourceImage == null)) {
        sb.append("dataSourceImage:");
        sb.append(dataSourceImage);
        sb.append(",");
    }
    if (!(deviceProperties == null)) {
        sb.append("deviceProperties:");
        sb.append(deviceProperties);
        sb.append(",");
    }
    if (!(diskSize == null)) {
        sb.append("diskSize:");
        sb.append(diskSize);
        sb.append(",");
    }
    if (!(storageConfig == null)) {
        sb.append("storageConfig:");
        sb.append(storageConfig);
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
  
  public A withDataSourceImage(StorageResourceReference dataSourceImage) {
    this._visitables.remove("dataSourceImage");
    if (dataSourceImage != null) {
        this.dataSourceImage = new StorageResourceReferenceBuilder(dataSourceImage);
        this._visitables.get("dataSourceImage").add(this.dataSourceImage);
    } else {
        this.dataSourceImage = null;
        this._visitables.get("dataSourceImage").remove(this.dataSourceImage);
    }
    return (A) this;
  }
  
  public A withDeviceProperties(NutanixVMDiskDeviceProperties deviceProperties) {
    this.deviceProperties = deviceProperties;
    return (A) this;
  }
  
  public A withDiskSize(Quantity diskSize) {
    this.diskSize = diskSize;
    return (A) this;
  }
  
  public DataSourceImageNested<A> withNewDataSourceImage() {
    return new DataSourceImageNested(null);
  }
  
  public A withNewDataSourceImage(String name,String referenceName,String uuid) {
    return (A) this.withDataSourceImage(new StorageResourceReference(name, referenceName, uuid));
  }
  
  public DataSourceImageNested<A> withNewDataSourceImageLike(StorageResourceReference item) {
    return new DataSourceImageNested(item);
  }
  
  public A withNewDeviceProperties(String adapterType,Integer deviceIndex,String deviceType) {
    return (A) this.withDeviceProperties(new NutanixVMDiskDeviceProperties(adapterType, deviceIndex, deviceType));
  }
  
  public A withNewDiskSize(String amount) {
    return (A) this.withDiskSize(new Quantity(amount));
  }
  
  public A withNewDiskSize(String amount,String format) {
    return (A) this.withDiskSize(new Quantity(amount, format));
  }
  
  public StorageConfigNested<A> withNewStorageConfig() {
    return new StorageConfigNested(null);
  }
  
  public StorageConfigNested<A> withNewStorageConfigLike(StorageConfig item) {
    return new StorageConfigNested(item);
  }
  
  public A withStorageConfig(StorageConfig storageConfig) {
    this._visitables.remove("storageConfig");
    if (storageConfig != null) {
        this.storageConfig = new StorageConfigBuilder(storageConfig);
        this._visitables.get("storageConfig").add(this.storageConfig);
    } else {
        this.storageConfig = null;
        this._visitables.get("storageConfig").remove(this.storageConfig);
    }
    return (A) this;
  }
  public class DataSourceImageNested<N> extends StorageResourceReferenceFluent<DataSourceImageNested<N>> implements Nested<N>{
  
    StorageResourceReferenceBuilder builder;
  
    DataSourceImageNested(StorageResourceReference item) {
      this.builder = new StorageResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) DataDiskFluent.this.withDataSourceImage(builder.build());
    }
    
    public N endDataSourceImage() {
      return and();
    }
    
  }
  public class StorageConfigNested<N> extends StorageConfigFluent<StorageConfigNested<N>> implements Nested<N>{
  
    StorageConfigBuilder builder;
  
    StorageConfigNested(StorageConfig item) {
      this.builder = new StorageConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) DataDiskFluent.this.withStorageConfig(builder.build());
    }
    
    public N endStorageConfig() {
      return and();
    }
    
  }
}