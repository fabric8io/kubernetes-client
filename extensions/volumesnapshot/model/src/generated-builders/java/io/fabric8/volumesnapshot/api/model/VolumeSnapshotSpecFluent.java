package io.fabric8.volumesnapshot.api.model;

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
public class VolumeSnapshotSpecFluent<A extends io.fabric8.volumesnapshot.api.model.VolumeSnapshotSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VolumeSnapshotSourceBuilder source;
  private String volumeSnapshotClassName;

  public VolumeSnapshotSpecFluent() {
  }
  
  public VolumeSnapshotSpecFluent(VolumeSnapshotSpec instance) {
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
  
  public VolumeSnapshotSource buildSource() {
    return this.source != null ? this.source.build() : null;
  }
  
  protected void copyInstance(VolumeSnapshotSpec instance) {
    instance = instance != null ? instance : new VolumeSnapshotSpec();
    if (instance != null) {
        this.withSource(instance.getSource());
        this.withVolumeSnapshotClassName(instance.getVolumeSnapshotClassName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SourceNested<A> editOrNewSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(new VolumeSnapshotSourceBuilder().build()));
  }
  
  public SourceNested<A> editOrNewSourceLike(VolumeSnapshotSource item) {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(item));
  }
  
  public SourceNested<A> editSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(null));
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
    VolumeSnapshotSpecFluent that = (VolumeSnapshotSpecFluent) o;
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(volumeSnapshotClassName, that.volumeSnapshotClassName))) {
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
  
  public String getVolumeSnapshotClassName() {
    return this.volumeSnapshotClassName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasVolumeSnapshotClassName() {
    return this.volumeSnapshotClassName != null;
  }
  
  public int hashCode() {
    return Objects.hash(source, volumeSnapshotClassName, additionalProperties);
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
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(volumeSnapshotClassName == null)) {
        sb.append("volumeSnapshotClassName:");
        sb.append(volumeSnapshotClassName);
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
  
  public SourceNested<A> withNewSource() {
    return new SourceNested(null);
  }
  
  public A withNewSource(String persistentVolumeClaimName,String volumeSnapshotContentName) {
    return (A) this.withSource(new VolumeSnapshotSource(persistentVolumeClaimName, volumeSnapshotContentName));
  }
  
  public SourceNested<A> withNewSourceLike(VolumeSnapshotSource item) {
    return new SourceNested(item);
  }
  
  public A withSource(VolumeSnapshotSource source) {
    this._visitables.remove("source");
    if (source != null) {
        this.source = new VolumeSnapshotSourceBuilder(source);
        this._visitables.get("source").add(this.source);
    } else {
        this.source = null;
        this._visitables.get("source").remove(this.source);
    }
    return (A) this;
  }
  
  public A withVolumeSnapshotClassName(String volumeSnapshotClassName) {
    this.volumeSnapshotClassName = volumeSnapshotClassName;
    return (A) this;
  }
  public class SourceNested<N> extends VolumeSnapshotSourceFluent<SourceNested<N>> implements Nested<N>{
  
    VolumeSnapshotSourceBuilder builder;
  
    SourceNested(VolumeSnapshotSource item) {
      this.builder = new VolumeSnapshotSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeSnapshotSpecFluent.this.withSource(builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
}