package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class NutanixVMDiskFluent<A extends io.fabric8.openshift.api.model.machine.v1.NutanixVMDiskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NutanixResourceIdentifierBuilder dataSource;
  private NutanixVMDiskDevicePropertiesBuilder deviceProperties;
  private Quantity diskSize;
  private NutanixVMStorageConfigBuilder storageConfig;

  public NutanixVMDiskFluent() {
  }
  
  public NutanixVMDiskFluent(NutanixVMDisk instance) {
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
  
  public NutanixResourceIdentifier buildDataSource() {
    return this.dataSource != null ? this.dataSource.build() : null;
  }
  
  public NutanixVMDiskDeviceProperties buildDeviceProperties() {
    return this.deviceProperties != null ? this.deviceProperties.build() : null;
  }
  
  public NutanixVMStorageConfig buildStorageConfig() {
    return this.storageConfig != null ? this.storageConfig.build() : null;
  }
  
  protected void copyInstance(NutanixVMDisk instance) {
    instance = instance != null ? instance : new NutanixVMDisk();
    if (instance != null) {
        this.withDataSource(instance.getDataSource());
        this.withDeviceProperties(instance.getDeviceProperties());
        this.withDiskSize(instance.getDiskSize());
        this.withStorageConfig(instance.getStorageConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DataSourceNested<A> editDataSource() {
    return this.withNewDataSourceLike(Optional.ofNullable(this.buildDataSource()).orElse(null));
  }
  
  public DevicePropertiesNested<A> editDeviceProperties() {
    return this.withNewDevicePropertiesLike(Optional.ofNullable(this.buildDeviceProperties()).orElse(null));
  }
  
  public DataSourceNested<A> editOrNewDataSource() {
    return this.withNewDataSourceLike(Optional.ofNullable(this.buildDataSource()).orElse(new NutanixResourceIdentifierBuilder().build()));
  }
  
  public DataSourceNested<A> editOrNewDataSourceLike(NutanixResourceIdentifier item) {
    return this.withNewDataSourceLike(Optional.ofNullable(this.buildDataSource()).orElse(item));
  }
  
  public DevicePropertiesNested<A> editOrNewDeviceProperties() {
    return this.withNewDevicePropertiesLike(Optional.ofNullable(this.buildDeviceProperties()).orElse(new NutanixVMDiskDevicePropertiesBuilder().build()));
  }
  
  public DevicePropertiesNested<A> editOrNewDevicePropertiesLike(NutanixVMDiskDeviceProperties item) {
    return this.withNewDevicePropertiesLike(Optional.ofNullable(this.buildDeviceProperties()).orElse(item));
  }
  
  public StorageConfigNested<A> editOrNewStorageConfig() {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(new NutanixVMStorageConfigBuilder().build()));
  }
  
  public StorageConfigNested<A> editOrNewStorageConfigLike(NutanixVMStorageConfig item) {
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
    NutanixVMDiskFluent that = (NutanixVMDiskFluent) o;
    if (!(Objects.equals(dataSource, that.dataSource))) {
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
  
  public Quantity getDiskSize() {
    return this.diskSize;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDataSource() {
    return this.dataSource != null;
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
    return Objects.hash(dataSource, deviceProperties, diskSize, storageConfig, additionalProperties);
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
    if (!(dataSource == null)) {
        sb.append("dataSource:");
        sb.append(dataSource);
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
  
  public A withDataSource(NutanixResourceIdentifier dataSource) {
    this._visitables.remove("dataSource");
    if (dataSource != null) {
        this.dataSource = new NutanixResourceIdentifierBuilder(dataSource);
        this._visitables.get("dataSource").add(this.dataSource);
    } else {
        this.dataSource = null;
        this._visitables.get("dataSource").remove(this.dataSource);
    }
    return (A) this;
  }
  
  public A withDeviceProperties(NutanixVMDiskDeviceProperties deviceProperties) {
    this._visitables.remove("deviceProperties");
    if (deviceProperties != null) {
        this.deviceProperties = new NutanixVMDiskDevicePropertiesBuilder(deviceProperties);
        this._visitables.get("deviceProperties").add(this.deviceProperties);
    } else {
        this.deviceProperties = null;
        this._visitables.get("deviceProperties").remove(this.deviceProperties);
    }
    return (A) this;
  }
  
  public A withDiskSize(Quantity diskSize) {
    this.diskSize = diskSize;
    return (A) this;
  }
  
  public DataSourceNested<A> withNewDataSource() {
    return new DataSourceNested(null);
  }
  
  public A withNewDataSource(String name,String type,String uuid) {
    return (A) this.withDataSource(new NutanixResourceIdentifier(name, type, uuid));
  }
  
  public DataSourceNested<A> withNewDataSourceLike(NutanixResourceIdentifier item) {
    return new DataSourceNested(item);
  }
  
  public DevicePropertiesNested<A> withNewDeviceProperties() {
    return new DevicePropertiesNested(null);
  }
  
  public A withNewDeviceProperties(String adapterType,Integer deviceIndex,String deviceType) {
    return (A) this.withDeviceProperties(new NutanixVMDiskDeviceProperties(adapterType, deviceIndex, deviceType));
  }
  
  public DevicePropertiesNested<A> withNewDevicePropertiesLike(NutanixVMDiskDeviceProperties item) {
    return new DevicePropertiesNested(item);
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
  
  public StorageConfigNested<A> withNewStorageConfigLike(NutanixVMStorageConfig item) {
    return new StorageConfigNested(item);
  }
  
  public A withStorageConfig(NutanixVMStorageConfig storageConfig) {
    this._visitables.remove("storageConfig");
    if (storageConfig != null) {
        this.storageConfig = new NutanixVMStorageConfigBuilder(storageConfig);
        this._visitables.get("storageConfig").add(this.storageConfig);
    } else {
        this.storageConfig = null;
        this._visitables.get("storageConfig").remove(this.storageConfig);
    }
    return (A) this;
  }
  public class DataSourceNested<N> extends NutanixResourceIdentifierFluent<DataSourceNested<N>> implements Nested<N>{
  
    NutanixResourceIdentifierBuilder builder;
  
    DataSourceNested(NutanixResourceIdentifier item) {
      this.builder = new NutanixResourceIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixVMDiskFluent.this.withDataSource(builder.build());
    }
    
    public N endDataSource() {
      return and();
    }
    
  }
  public class DevicePropertiesNested<N> extends NutanixVMDiskDevicePropertiesFluent<DevicePropertiesNested<N>> implements Nested<N>{
  
    NutanixVMDiskDevicePropertiesBuilder builder;
  
    DevicePropertiesNested(NutanixVMDiskDeviceProperties item) {
      this.builder = new NutanixVMDiskDevicePropertiesBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixVMDiskFluent.this.withDeviceProperties(builder.build());
    }
    
    public N endDeviceProperties() {
      return and();
    }
    
  }
  public class StorageConfigNested<N> extends NutanixVMStorageConfigFluent<StorageConfigNested<N>> implements Nested<N>{
  
    NutanixVMStorageConfigBuilder builder;
  
    StorageConfigNested(NutanixVMStorageConfig item) {
      this.builder = new NutanixVMStorageConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixVMDiskFluent.this.withStorageConfig(builder.build());
    }
    
    public N endStorageConfig() {
      return and();
    }
    
  }
}