package io.fabric8.openshift.api.model.machine.v1alpha1;

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
public class BlockDeviceStorageFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.BlockDeviceStorageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String type;
  private BlockDeviceVolumeBuilder volume;

  public BlockDeviceStorageFluent() {
  }
  
  public BlockDeviceStorageFluent(BlockDeviceStorage instance) {
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
  
  public BlockDeviceVolume buildVolume() {
    return this.volume != null ? this.volume.build() : null;
  }
  
  protected void copyInstance(BlockDeviceStorage instance) {
    instance = instance != null ? instance : new BlockDeviceStorage();
    if (instance != null) {
        this.withType(instance.getType());
        this.withVolume(instance.getVolume());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VolumeNested<A> editOrNewVolume() {
    return this.withNewVolumeLike(Optional.ofNullable(this.buildVolume()).orElse(new BlockDeviceVolumeBuilder().build()));
  }
  
  public VolumeNested<A> editOrNewVolumeLike(BlockDeviceVolume item) {
    return this.withNewVolumeLike(Optional.ofNullable(this.buildVolume()).orElse(item));
  }
  
  public VolumeNested<A> editVolume() {
    return this.withNewVolumeLike(Optional.ofNullable(this.buildVolume()).orElse(null));
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
    BlockDeviceStorageFluent that = (BlockDeviceStorageFluent) o;
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(volume, that.volume))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasVolume() {
    return this.volume != null;
  }
  
  public int hashCode() {
    return Objects.hash(type, volume, additionalProperties);
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
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(volume == null)) {
        sb.append("volume:");
        sb.append(volume);
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
  
  public VolumeNested<A> withNewVolume() {
    return new VolumeNested(null);
  }
  
  public A withNewVolume(String availabilityZone,String type) {
    return (A) this.withVolume(new BlockDeviceVolume(availabilityZone, type));
  }
  
  public VolumeNested<A> withNewVolumeLike(BlockDeviceVolume item) {
    return new VolumeNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withVolume(BlockDeviceVolume volume) {
    this._visitables.remove("volume");
    if (volume != null) {
        this.volume = new BlockDeviceVolumeBuilder(volume);
        this._visitables.get("volume").add(this.volume);
    } else {
        this.volume = null;
        this._visitables.get("volume").remove(this.volume);
    }
    return (A) this;
  }
  public class VolumeNested<N> extends BlockDeviceVolumeFluent<VolumeNested<N>> implements Nested<N>{
  
    BlockDeviceVolumeBuilder builder;
  
    VolumeNested(BlockDeviceVolume item) {
      this.builder = new BlockDeviceVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) BlockDeviceStorageFluent.this.withVolume(builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
}