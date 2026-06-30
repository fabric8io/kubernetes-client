package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class VolumeMountStatusFluent<A extends io.fabric8.kubernetes.api.model.VolumeMountStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mountPath;
  private String name;
  private Boolean readOnly;
  private String recursiveReadOnly;
  private VolumeStatusBuilder volumeStatus;

  public VolumeMountStatusFluent() {
  }
  
  public VolumeMountStatusFluent(VolumeMountStatus instance) {
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
  
  public VolumeStatus buildVolumeStatus() {
    return this.volumeStatus != null ? this.volumeStatus.build() : null;
  }
  
  protected void copyInstance(VolumeMountStatus instance) {
    instance = instance != null ? instance : new VolumeMountStatus();
    if (instance != null) {
        this.withMountPath(instance.getMountPath());
        this.withName(instance.getName());
        this.withReadOnly(instance.getReadOnly());
        this.withRecursiveReadOnly(instance.getRecursiveReadOnly());
        this.withVolumeStatus(instance.getVolumeStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VolumeStatusNested<A> editOrNewVolumeStatus() {
    return this.withNewVolumeStatusLike(Optional.ofNullable(this.buildVolumeStatus()).orElse(new VolumeStatusBuilder().build()));
  }
  
  public VolumeStatusNested<A> editOrNewVolumeStatusLike(VolumeStatus item) {
    return this.withNewVolumeStatusLike(Optional.ofNullable(this.buildVolumeStatus()).orElse(item));
  }
  
  public VolumeStatusNested<A> editVolumeStatus() {
    return this.withNewVolumeStatusLike(Optional.ofNullable(this.buildVolumeStatus()).orElse(null));
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
    VolumeMountStatusFluent that = (VolumeMountStatusFluent) o;
    if (!(Objects.equals(mountPath, that.mountPath))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(recursiveReadOnly, that.recursiveReadOnly))) {
      return false;
    }
    if (!(Objects.equals(volumeStatus, that.volumeStatus))) {
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
  
  public String getMountPath() {
    return this.mountPath;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public String getRecursiveReadOnly() {
    return this.recursiveReadOnly;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMountPath() {
    return this.mountPath != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasRecursiveReadOnly() {
    return this.recursiveReadOnly != null;
  }
  
  public boolean hasVolumeStatus() {
    return this.volumeStatus != null;
  }
  
  public int hashCode() {
    return Objects.hash(mountPath, name, readOnly, recursiveReadOnly, volumeStatus, additionalProperties);
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
    if (!(mountPath == null)) {
        sb.append("mountPath:");
        sb.append(mountPath);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
        sb.append(",");
    }
    if (!(recursiveReadOnly == null)) {
        sb.append("recursiveReadOnly:");
        sb.append(recursiveReadOnly);
        sb.append(",");
    }
    if (!(volumeStatus == null)) {
        sb.append("volumeStatus:");
        sb.append(volumeStatus);
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
  
  public A withMountPath(String mountPath) {
    this.mountPath = mountPath;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public VolumeStatusNested<A> withNewVolumeStatus() {
    return new VolumeStatusNested(null);
  }
  
  public VolumeStatusNested<A> withNewVolumeStatusLike(VolumeStatus item) {
    return new VolumeStatusNested(item);
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
  public A withRecursiveReadOnly(String recursiveReadOnly) {
    this.recursiveReadOnly = recursiveReadOnly;
    return (A) this;
  }
  
  public A withVolumeStatus(VolumeStatus volumeStatus) {
    this._visitables.remove("volumeStatus");
    if (volumeStatus != null) {
        this.volumeStatus = new VolumeStatusBuilder(volumeStatus);
        this._visitables.get("volumeStatus").add(this.volumeStatus);
    } else {
        this.volumeStatus = null;
        this._visitables.get("volumeStatus").remove(this.volumeStatus);
    }
    return (A) this;
  }
  public class VolumeStatusNested<N> extends VolumeStatusFluent<VolumeStatusNested<N>> implements Nested<N>{
  
    VolumeStatusBuilder builder;
  
    VolumeStatusNested(VolumeStatus item) {
      this.builder = new VolumeStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeMountStatusFluent.this.withVolumeStatus(builder.build());
    }
    
    public N endVolumeStatus() {
      return and();
    }
    
  }
}