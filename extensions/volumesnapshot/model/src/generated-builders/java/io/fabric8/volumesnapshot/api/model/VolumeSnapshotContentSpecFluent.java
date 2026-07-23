package io.fabric8.volumesnapshot.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class VolumeSnapshotContentSpecFluent<A extends io.fabric8.volumesnapshot.api.model.VolumeSnapshotContentSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String deletionPolicy;
  private String driver;
  private VolumeSnapshotContentSourceBuilder source;
  private String sourceVolumeMode;
  private String volumeSnapshotClassName;
  private ObjectReferenceBuilder volumeSnapshotRef;

  public VolumeSnapshotContentSpecFluent() {
  }
  
  public VolumeSnapshotContentSpecFluent(VolumeSnapshotContentSpec instance) {
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
  
  public VolumeSnapshotContentSource buildSource() {
    return this.source != null ? this.source.build() : null;
  }
  
  public ObjectReference buildVolumeSnapshotRef() {
    return this.volumeSnapshotRef != null ? this.volumeSnapshotRef.build() : null;
  }
  
  protected void copyInstance(VolumeSnapshotContentSpec instance) {
    instance = instance != null ? instance : new VolumeSnapshotContentSpec();
    if (instance != null) {
        this.withDeletionPolicy(instance.getDeletionPolicy());
        this.withDriver(instance.getDriver());
        this.withSource(instance.getSource());
        this.withSourceVolumeMode(instance.getSourceVolumeMode());
        this.withVolumeSnapshotClassName(instance.getVolumeSnapshotClassName());
        this.withVolumeSnapshotRef(instance.getVolumeSnapshotRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SourceNested<A> editOrNewSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(new VolumeSnapshotContentSourceBuilder().build()));
  }
  
  public SourceNested<A> editOrNewSourceLike(VolumeSnapshotContentSource item) {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(item));
  }
  
  public VolumeSnapshotRefNested<A> editOrNewVolumeSnapshotRef() {
    return this.withNewVolumeSnapshotRefLike(Optional.ofNullable(this.buildVolumeSnapshotRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public VolumeSnapshotRefNested<A> editOrNewVolumeSnapshotRefLike(ObjectReference item) {
    return this.withNewVolumeSnapshotRefLike(Optional.ofNullable(this.buildVolumeSnapshotRef()).orElse(item));
  }
  
  public SourceNested<A> editSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(null));
  }
  
  public VolumeSnapshotRefNested<A> editVolumeSnapshotRef() {
    return this.withNewVolumeSnapshotRefLike(Optional.ofNullable(this.buildVolumeSnapshotRef()).orElse(null));
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
    VolumeSnapshotContentSpecFluent that = (VolumeSnapshotContentSpecFluent) o;
    if (!(Objects.equals(deletionPolicy, that.deletionPolicy))) {
      return false;
    }
    if (!(Objects.equals(driver, that.driver))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(sourceVolumeMode, that.sourceVolumeMode))) {
      return false;
    }
    if (!(Objects.equals(volumeSnapshotClassName, that.volumeSnapshotClassName))) {
      return false;
    }
    if (!(Objects.equals(volumeSnapshotRef, that.volumeSnapshotRef))) {
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
  
  public String getDeletionPolicy() {
    return this.deletionPolicy;
  }
  
  public String getDriver() {
    return this.driver;
  }
  
  public String getSourceVolumeMode() {
    return this.sourceVolumeMode;
  }
  
  public String getVolumeSnapshotClassName() {
    return this.volumeSnapshotClassName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeletionPolicy() {
    return this.deletionPolicy != null;
  }
  
  public boolean hasDriver() {
    return this.driver != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasSourceVolumeMode() {
    return this.sourceVolumeMode != null;
  }
  
  public boolean hasVolumeSnapshotClassName() {
    return this.volumeSnapshotClassName != null;
  }
  
  public boolean hasVolumeSnapshotRef() {
    return this.volumeSnapshotRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(deletionPolicy, driver, source, sourceVolumeMode, volumeSnapshotClassName, volumeSnapshotRef, additionalProperties);
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
    if (!(deletionPolicy == null)) {
        sb.append("deletionPolicy:");
        sb.append(deletionPolicy);
        sb.append(",");
    }
    if (!(driver == null)) {
        sb.append("driver:");
        sb.append(driver);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(sourceVolumeMode == null)) {
        sb.append("sourceVolumeMode:");
        sb.append(sourceVolumeMode);
        sb.append(",");
    }
    if (!(volumeSnapshotClassName == null)) {
        sb.append("volumeSnapshotClassName:");
        sb.append(volumeSnapshotClassName);
        sb.append(",");
    }
    if (!(volumeSnapshotRef == null)) {
        sb.append("volumeSnapshotRef:");
        sb.append(volumeSnapshotRef);
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
  
  public A withDeletionPolicy(String deletionPolicy) {
    this.deletionPolicy = deletionPolicy;
    return (A) this;
  }
  
  public A withDriver(String driver) {
    this.driver = driver;
    return (A) this;
  }
  
  public SourceNested<A> withNewSource() {
    return new SourceNested(null);
  }
  
  public A withNewSource(String snapshotHandle,String volumeHandle) {
    return (A) this.withSource(new VolumeSnapshotContentSource(snapshotHandle, volumeHandle));
  }
  
  public SourceNested<A> withNewSourceLike(VolumeSnapshotContentSource item) {
    return new SourceNested(item);
  }
  
  public VolumeSnapshotRefNested<A> withNewVolumeSnapshotRef() {
    return new VolumeSnapshotRefNested(null);
  }
  
  public VolumeSnapshotRefNested<A> withNewVolumeSnapshotRefLike(ObjectReference item) {
    return new VolumeSnapshotRefNested(item);
  }
  
  public A withSource(VolumeSnapshotContentSource source) {
    this._visitables.remove("source");
    if (source != null) {
        this.source = new VolumeSnapshotContentSourceBuilder(source);
        this._visitables.get("source").add(this.source);
    } else {
        this.source = null;
        this._visitables.get("source").remove(this.source);
    }
    return (A) this;
  }
  
  public A withSourceVolumeMode(String sourceVolumeMode) {
    this.sourceVolumeMode = sourceVolumeMode;
    return (A) this;
  }
  
  public A withVolumeSnapshotClassName(String volumeSnapshotClassName) {
    this.volumeSnapshotClassName = volumeSnapshotClassName;
    return (A) this;
  }
  
  public A withVolumeSnapshotRef(ObjectReference volumeSnapshotRef) {
    this._visitables.remove("volumeSnapshotRef");
    if (volumeSnapshotRef != null) {
        this.volumeSnapshotRef = new ObjectReferenceBuilder(volumeSnapshotRef);
        this._visitables.get("volumeSnapshotRef").add(this.volumeSnapshotRef);
    } else {
        this.volumeSnapshotRef = null;
        this._visitables.get("volumeSnapshotRef").remove(this.volumeSnapshotRef);
    }
    return (A) this;
  }
  public class SourceNested<N> extends VolumeSnapshotContentSourceFluent<SourceNested<N>> implements Nested<N>{
  
    VolumeSnapshotContentSourceBuilder builder;
  
    SourceNested(VolumeSnapshotContentSource item) {
      this.builder = new VolumeSnapshotContentSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeSnapshotContentSpecFluent.this.withSource(builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
  public class VolumeSnapshotRefNested<N> extends ObjectReferenceFluent<VolumeSnapshotRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    VolumeSnapshotRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeSnapshotContentSpecFluent.this.withVolumeSnapshotRef(builder.build());
    }
    
    public N endVolumeSnapshotRef() {
      return and();
    }
    
  }
}