package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Long;
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
public class VolumeSnapshotContentStatusFluent<A extends io.fabric8.volumesnapshot.api.model.VolumeSnapshotContentStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long creationTime;
  private VolumeSnapshotErrorBuilder error;
  private Boolean readyToUse;
  private Long restoreSize;
  private String snapshotHandle;
  private String volumeGroupSnapshotHandle;

  public VolumeSnapshotContentStatusFluent() {
  }
  
  public VolumeSnapshotContentStatusFluent(VolumeSnapshotContentStatus instance) {
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
  
  public VolumeSnapshotError buildError() {
    return this.error != null ? this.error.build() : null;
  }
  
  protected void copyInstance(VolumeSnapshotContentStatus instance) {
    instance = instance != null ? instance : new VolumeSnapshotContentStatus();
    if (instance != null) {
        this.withCreationTime(instance.getCreationTime());
        this.withError(instance.getError());
        this.withReadyToUse(instance.getReadyToUse());
        this.withRestoreSize(instance.getRestoreSize());
        this.withSnapshotHandle(instance.getSnapshotHandle());
        this.withVolumeGroupSnapshotHandle(instance.getVolumeGroupSnapshotHandle());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ErrorNested<A> editError() {
    return this.withNewErrorLike(Optional.ofNullable(this.buildError()).orElse(null));
  }
  
  public ErrorNested<A> editOrNewError() {
    return this.withNewErrorLike(Optional.ofNullable(this.buildError()).orElse(new VolumeSnapshotErrorBuilder().build()));
  }
  
  public ErrorNested<A> editOrNewErrorLike(VolumeSnapshotError item) {
    return this.withNewErrorLike(Optional.ofNullable(this.buildError()).orElse(item));
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
    VolumeSnapshotContentStatusFluent that = (VolumeSnapshotContentStatusFluent) o;
    if (!(Objects.equals(creationTime, that.creationTime))) {
      return false;
    }
    if (!(Objects.equals(error, that.error))) {
      return false;
    }
    if (!(Objects.equals(readyToUse, that.readyToUse))) {
      return false;
    }
    if (!(Objects.equals(restoreSize, that.restoreSize))) {
      return false;
    }
    if (!(Objects.equals(snapshotHandle, that.snapshotHandle))) {
      return false;
    }
    if (!(Objects.equals(volumeGroupSnapshotHandle, that.volumeGroupSnapshotHandle))) {
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
  
  public Long getCreationTime() {
    return this.creationTime;
  }
  
  public Boolean getReadyToUse() {
    return this.readyToUse;
  }
  
  public Long getRestoreSize() {
    return this.restoreSize;
  }
  
  public String getSnapshotHandle() {
    return this.snapshotHandle;
  }
  
  public String getVolumeGroupSnapshotHandle() {
    return this.volumeGroupSnapshotHandle;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCreationTime() {
    return this.creationTime != null;
  }
  
  public boolean hasError() {
    return this.error != null;
  }
  
  public boolean hasReadyToUse() {
    return this.readyToUse != null;
  }
  
  public boolean hasRestoreSize() {
    return this.restoreSize != null;
  }
  
  public boolean hasSnapshotHandle() {
    return this.snapshotHandle != null;
  }
  
  public boolean hasVolumeGroupSnapshotHandle() {
    return this.volumeGroupSnapshotHandle != null;
  }
  
  public int hashCode() {
    return Objects.hash(creationTime, error, readyToUse, restoreSize, snapshotHandle, volumeGroupSnapshotHandle, additionalProperties);
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
    if (!(creationTime == null)) {
        sb.append("creationTime:");
        sb.append(creationTime);
        sb.append(",");
    }
    if (!(error == null)) {
        sb.append("error:");
        sb.append(error);
        sb.append(",");
    }
    if (!(readyToUse == null)) {
        sb.append("readyToUse:");
        sb.append(readyToUse);
        sb.append(",");
    }
    if (!(restoreSize == null)) {
        sb.append("restoreSize:");
        sb.append(restoreSize);
        sb.append(",");
    }
    if (!(snapshotHandle == null)) {
        sb.append("snapshotHandle:");
        sb.append(snapshotHandle);
        sb.append(",");
    }
    if (!(volumeGroupSnapshotHandle == null)) {
        sb.append("volumeGroupSnapshotHandle:");
        sb.append(volumeGroupSnapshotHandle);
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
  
  public A withCreationTime(Long creationTime) {
    this.creationTime = creationTime;
    return (A) this;
  }
  
  public A withError(VolumeSnapshotError error) {
    this._visitables.remove("error");
    if (error != null) {
        this.error = new VolumeSnapshotErrorBuilder(error);
        this._visitables.get("error").add(this.error);
    } else {
        this.error = null;
        this._visitables.get("error").remove(this.error);
    }
    return (A) this;
  }
  
  public ErrorNested<A> withNewError() {
    return new ErrorNested(null);
  }
  
  public A withNewError(String message,String time) {
    return (A) this.withError(new VolumeSnapshotError(message, time));
  }
  
  public ErrorNested<A> withNewErrorLike(VolumeSnapshotError item) {
    return new ErrorNested(item);
  }
  
  public A withReadyToUse() {
    return withReadyToUse(true);
  }
  
  public A withReadyToUse(Boolean readyToUse) {
    this.readyToUse = readyToUse;
    return (A) this;
  }
  
  public A withRestoreSize(Long restoreSize) {
    this.restoreSize = restoreSize;
    return (A) this;
  }
  
  public A withSnapshotHandle(String snapshotHandle) {
    this.snapshotHandle = snapshotHandle;
    return (A) this;
  }
  
  public A withVolumeGroupSnapshotHandle(String volumeGroupSnapshotHandle) {
    this.volumeGroupSnapshotHandle = volumeGroupSnapshotHandle;
    return (A) this;
  }
  public class ErrorNested<N> extends VolumeSnapshotErrorFluent<ErrorNested<N>> implements Nested<N>{
  
    VolumeSnapshotErrorBuilder builder;
  
    ErrorNested(VolumeSnapshotError item) {
      this.builder = new VolumeSnapshotErrorBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeSnapshotContentStatusFluent.this.withError(builder.build());
    }
    
    public N endError() {
      return and();
    }
    
  }
}