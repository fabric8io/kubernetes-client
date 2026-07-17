package io.fabric8.openshift.api.model.insights.v1alpha2;

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
public class StorageFluent<A extends io.fabric8.openshift.api.model.insights.v1alpha2.StorageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PersistentVolumeConfigBuilder persistentVolume;
  private String type;

  public StorageFluent() {
  }
  
  public StorageFluent(Storage instance) {
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
  
  public PersistentVolumeConfig buildPersistentVolume() {
    return this.persistentVolume != null ? this.persistentVolume.build() : null;
  }
  
  protected void copyInstance(Storage instance) {
    instance = instance != null ? instance : new Storage();
    if (instance != null) {
        this.withPersistentVolume(instance.getPersistentVolume());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PersistentVolumeNested<A> editOrNewPersistentVolume() {
    return this.withNewPersistentVolumeLike(Optional.ofNullable(this.buildPersistentVolume()).orElse(new PersistentVolumeConfigBuilder().build()));
  }
  
  public PersistentVolumeNested<A> editOrNewPersistentVolumeLike(PersistentVolumeConfig item) {
    return this.withNewPersistentVolumeLike(Optional.ofNullable(this.buildPersistentVolume()).orElse(item));
  }
  
  public PersistentVolumeNested<A> editPersistentVolume() {
    return this.withNewPersistentVolumeLike(Optional.ofNullable(this.buildPersistentVolume()).orElse(null));
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
    StorageFluent that = (StorageFluent) o;
    if (!(Objects.equals(persistentVolume, that.persistentVolume))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public boolean hasPersistentVolume() {
    return this.persistentVolume != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(persistentVolume, type, additionalProperties);
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
    if (!(persistentVolume == null)) {
        sb.append("persistentVolume:");
        sb.append(persistentVolume);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public PersistentVolumeNested<A> withNewPersistentVolume() {
    return new PersistentVolumeNested(null);
  }
  
  public PersistentVolumeNested<A> withNewPersistentVolumeLike(PersistentVolumeConfig item) {
    return new PersistentVolumeNested(item);
  }
  
  public A withPersistentVolume(PersistentVolumeConfig persistentVolume) {
    this._visitables.remove("persistentVolume");
    if (persistentVolume != null) {
        this.persistentVolume = new PersistentVolumeConfigBuilder(persistentVolume);
        this._visitables.get("persistentVolume").add(this.persistentVolume);
    } else {
        this.persistentVolume = null;
        this._visitables.get("persistentVolume").remove(this.persistentVolume);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class PersistentVolumeNested<N> extends PersistentVolumeConfigFluent<PersistentVolumeNested<N>> implements Nested<N>{
  
    PersistentVolumeConfigBuilder builder;
  
    PersistentVolumeNested(PersistentVolumeConfig item) {
      this.builder = new PersistentVolumeConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) StorageFluent.this.withPersistentVolume(builder.build());
    }
    
    public N endPersistentVolume() {
      return and();
    }
    
  }
}