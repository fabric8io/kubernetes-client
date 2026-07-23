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
public class OSDiskFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.OSDiskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cachingType;
  private DiskSettingsBuilder diskSettings;
  private Integer diskSizeGB;
  private OSDiskManagedDiskParametersBuilder managedDisk;
  private String osType;

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
  
  public DiskSettings buildDiskSettings() {
    return this.diskSettings != null ? this.diskSettings.build() : null;
  }
  
  public OSDiskManagedDiskParameters buildManagedDisk() {
    return this.managedDisk != null ? this.managedDisk.build() : null;
  }
  
  protected void copyInstance(OSDisk instance) {
    instance = instance != null ? instance : new OSDisk();
    if (instance != null) {
        this.withCachingType(instance.getCachingType());
        this.withDiskSettings(instance.getDiskSettings());
        this.withDiskSizeGB(instance.getDiskSizeGB());
        this.withManagedDisk(instance.getManagedDisk());
        this.withOsType(instance.getOsType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DiskSettingsNested<A> editDiskSettings() {
    return this.withNewDiskSettingsLike(Optional.ofNullable(this.buildDiskSettings()).orElse(null));
  }
  
  public ManagedDiskNested<A> editManagedDisk() {
    return this.withNewManagedDiskLike(Optional.ofNullable(this.buildManagedDisk()).orElse(null));
  }
  
  public DiskSettingsNested<A> editOrNewDiskSettings() {
    return this.withNewDiskSettingsLike(Optional.ofNullable(this.buildDiskSettings()).orElse(new DiskSettingsBuilder().build()));
  }
  
  public DiskSettingsNested<A> editOrNewDiskSettingsLike(DiskSettings item) {
    return this.withNewDiskSettingsLike(Optional.ofNullable(this.buildDiskSettings()).orElse(item));
  }
  
  public ManagedDiskNested<A> editOrNewManagedDisk() {
    return this.withNewManagedDiskLike(Optional.ofNullable(this.buildManagedDisk()).orElse(new OSDiskManagedDiskParametersBuilder().build()));
  }
  
  public ManagedDiskNested<A> editOrNewManagedDiskLike(OSDiskManagedDiskParameters item) {
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
    OSDiskFluent that = (OSDiskFluent) o;
    if (!(Objects.equals(cachingType, that.cachingType))) {
      return false;
    }
    if (!(Objects.equals(diskSettings, that.diskSettings))) {
      return false;
    }
    if (!(Objects.equals(diskSizeGB, that.diskSizeGB))) {
      return false;
    }
    if (!(Objects.equals(managedDisk, that.managedDisk))) {
      return false;
    }
    if (!(Objects.equals(osType, that.osType))) {
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
  
  public Integer getDiskSizeGB() {
    return this.diskSizeGB;
  }
  
  public String getOsType() {
    return this.osType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCachingType() {
    return this.cachingType != null;
  }
  
  public boolean hasDiskSettings() {
    return this.diskSettings != null;
  }
  
  public boolean hasDiskSizeGB() {
    return this.diskSizeGB != null;
  }
  
  public boolean hasManagedDisk() {
    return this.managedDisk != null;
  }
  
  public boolean hasOsType() {
    return this.osType != null;
  }
  
  public int hashCode() {
    return Objects.hash(cachingType, diskSettings, diskSizeGB, managedDisk, osType, additionalProperties);
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
    if (!(diskSettings == null)) {
        sb.append("diskSettings:");
        sb.append(diskSettings);
        sb.append(",");
    }
    if (!(diskSizeGB == null)) {
        sb.append("diskSizeGB:");
        sb.append(diskSizeGB);
        sb.append(",");
    }
    if (!(managedDisk == null)) {
        sb.append("managedDisk:");
        sb.append(managedDisk);
        sb.append(",");
    }
    if (!(osType == null)) {
        sb.append("osType:");
        sb.append(osType);
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
  
  public A withDiskSettings(DiskSettings diskSettings) {
    this._visitables.remove("diskSettings");
    if (diskSettings != null) {
        this.diskSettings = new DiskSettingsBuilder(diskSettings);
        this._visitables.get("diskSettings").add(this.diskSettings);
    } else {
        this.diskSettings = null;
        this._visitables.get("diskSettings").remove(this.diskSettings);
    }
    return (A) this;
  }
  
  public A withDiskSizeGB(Integer diskSizeGB) {
    this.diskSizeGB = diskSizeGB;
    return (A) this;
  }
  
  public A withManagedDisk(OSDiskManagedDiskParameters managedDisk) {
    this._visitables.remove("managedDisk");
    if (managedDisk != null) {
        this.managedDisk = new OSDiskManagedDiskParametersBuilder(managedDisk);
        this._visitables.get("managedDisk").add(this.managedDisk);
    } else {
        this.managedDisk = null;
        this._visitables.get("managedDisk").remove(this.managedDisk);
    }
    return (A) this;
  }
  
  public DiskSettingsNested<A> withNewDiskSettings() {
    return new DiskSettingsNested(null);
  }
  
  public A withNewDiskSettings(String ephemeralStorageLocation) {
    return (A) this.withDiskSettings(new DiskSettings(ephemeralStorageLocation));
  }
  
  public DiskSettingsNested<A> withNewDiskSettingsLike(DiskSettings item) {
    return new DiskSettingsNested(item);
  }
  
  public ManagedDiskNested<A> withNewManagedDisk() {
    return new ManagedDiskNested(null);
  }
  
  public ManagedDiskNested<A> withNewManagedDiskLike(OSDiskManagedDiskParameters item) {
    return new ManagedDiskNested(item);
  }
  
  public A withOsType(String osType) {
    this.osType = osType;
    return (A) this;
  }
  public class DiskSettingsNested<N> extends DiskSettingsFluent<DiskSettingsNested<N>> implements Nested<N>{
  
    DiskSettingsBuilder builder;
  
    DiskSettingsNested(DiskSettings item) {
      this.builder = new DiskSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) OSDiskFluent.this.withDiskSettings(builder.build());
    }
    
    public N endDiskSettings() {
      return and();
    }
    
  }
  public class ManagedDiskNested<N> extends OSDiskManagedDiskParametersFluent<ManagedDiskNested<N>> implements Nested<N>{
  
    OSDiskManagedDiskParametersBuilder builder;
  
    ManagedDiskNested(OSDiskManagedDiskParameters item) {
      this.builder = new OSDiskManagedDiskParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) OSDiskFluent.this.withManagedDisk(builder.build());
    }
    
    public N endManagedDisk() {
      return and();
    }
    
  }
}