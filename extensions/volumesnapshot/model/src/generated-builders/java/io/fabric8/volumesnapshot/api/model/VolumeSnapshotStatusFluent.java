package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class VolumeSnapshotStatusFluent<A extends io.fabric8.volumesnapshot.api.model.VolumeSnapshotStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String boundVolumeSnapshotContentName;
  private String creationTime;
  private VolumeSnapshotErrorBuilder error;
  private Boolean readyToUse;
  private Quantity restoreSize;
  private String volumeGroupSnapshotName;

  public VolumeSnapshotStatusFluent() {
  }
  
  public VolumeSnapshotStatusFluent(VolumeSnapshotStatus instance) {
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
  
  protected void copyInstance(VolumeSnapshotStatus instance) {
    instance = instance != null ? instance : new VolumeSnapshotStatus();
    if (instance != null) {
        this.withBoundVolumeSnapshotContentName(instance.getBoundVolumeSnapshotContentName());
        this.withCreationTime(instance.getCreationTime());
        this.withError(instance.getError());
        this.withReadyToUse(instance.getReadyToUse());
        this.withRestoreSize(instance.getRestoreSize());
        this.withVolumeGroupSnapshotName(instance.getVolumeGroupSnapshotName());
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
    VolumeSnapshotStatusFluent that = (VolumeSnapshotStatusFluent) o;
    if (!(Objects.equals(boundVolumeSnapshotContentName, that.boundVolumeSnapshotContentName))) {
      return false;
    }
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
    if (!(Objects.equals(volumeGroupSnapshotName, that.volumeGroupSnapshotName))) {
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
  
  public String getBoundVolumeSnapshotContentName() {
    return this.boundVolumeSnapshotContentName;
  }
  
  public String getCreationTime() {
    return this.creationTime;
  }
  
  public Boolean getReadyToUse() {
    return this.readyToUse;
  }
  
  public Quantity getRestoreSize() {
    return this.restoreSize;
  }
  
  public String getVolumeGroupSnapshotName() {
    return this.volumeGroupSnapshotName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBoundVolumeSnapshotContentName() {
    return this.boundVolumeSnapshotContentName != null;
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
  
  public boolean hasVolumeGroupSnapshotName() {
    return this.volumeGroupSnapshotName != null;
  }
  
  public int hashCode() {
    return Objects.hash(boundVolumeSnapshotContentName, creationTime, error, readyToUse, restoreSize, volumeGroupSnapshotName, additionalProperties);
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
    if (!(boundVolumeSnapshotContentName == null)) {
        sb.append("boundVolumeSnapshotContentName:");
        sb.append(boundVolumeSnapshotContentName);
        sb.append(",");
    }
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
    if (!(volumeGroupSnapshotName == null)) {
        sb.append("volumeGroupSnapshotName:");
        sb.append(volumeGroupSnapshotName);
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
  
  public A withBoundVolumeSnapshotContentName(String boundVolumeSnapshotContentName) {
    this.boundVolumeSnapshotContentName = boundVolumeSnapshotContentName;
    return (A) this;
  }
  
  public A withCreationTime(String creationTime) {
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
  
  public A withNewRestoreSize(String amount) {
    return (A) this.withRestoreSize(new Quantity(amount));
  }
  
  public A withNewRestoreSize(String amount,String format) {
    return (A) this.withRestoreSize(new Quantity(amount, format));
  }
  
  public A withReadyToUse() {
    return withReadyToUse(true);
  }
  
  public A withReadyToUse(Boolean readyToUse) {
    this.readyToUse = readyToUse;
    return (A) this;
  }
  
  public A withRestoreSize(Quantity restoreSize) {
    this.restoreSize = restoreSize;
    return (A) this;
  }
  
  public A withVolumeGroupSnapshotName(String volumeGroupSnapshotName) {
    this.volumeGroupSnapshotName = volumeGroupSnapshotName;
    return (A) this;
  }
  public class ErrorNested<N> extends VolumeSnapshotErrorFluent<ErrorNested<N>> implements Nested<N>{
  
    VolumeSnapshotErrorBuilder builder;
  
    ErrorNested(VolumeSnapshotError item) {
      this.builder = new VolumeSnapshotErrorBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeSnapshotStatusFluent.this.withError(builder.build());
    }
    
    public N endError() {
      return and();
    }
    
  }
}