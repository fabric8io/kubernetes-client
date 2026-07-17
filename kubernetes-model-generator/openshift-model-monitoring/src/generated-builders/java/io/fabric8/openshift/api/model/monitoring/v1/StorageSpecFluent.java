package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EmptyDirVolumeSource;
import io.fabric8.kubernetes.api.model.EphemeralVolumeSource;
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
public class StorageSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.StorageSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean disableMountSubPath;
  private EmptyDirVolumeSource emptyDir;
  private EphemeralVolumeSource ephemeral;
  private EmbeddedPersistentVolumeClaimBuilder volumeClaimTemplate;

  public StorageSpecFluent() {
  }
  
  public StorageSpecFluent(StorageSpec instance) {
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
  
  public EmbeddedPersistentVolumeClaim buildVolumeClaimTemplate() {
    return this.volumeClaimTemplate != null ? this.volumeClaimTemplate.build() : null;
  }
  
  protected void copyInstance(StorageSpec instance) {
    instance = instance != null ? instance : new StorageSpec();
    if (instance != null) {
        this.withDisableMountSubPath(instance.getDisableMountSubPath());
        this.withEmptyDir(instance.getEmptyDir());
        this.withEphemeral(instance.getEphemeral());
        this.withVolumeClaimTemplate(instance.getVolumeClaimTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VolumeClaimTemplateNested<A> editOrNewVolumeClaimTemplate() {
    return this.withNewVolumeClaimTemplateLike(Optional.ofNullable(this.buildVolumeClaimTemplate()).orElse(new EmbeddedPersistentVolumeClaimBuilder().build()));
  }
  
  public VolumeClaimTemplateNested<A> editOrNewVolumeClaimTemplateLike(EmbeddedPersistentVolumeClaim item) {
    return this.withNewVolumeClaimTemplateLike(Optional.ofNullable(this.buildVolumeClaimTemplate()).orElse(item));
  }
  
  public VolumeClaimTemplateNested<A> editVolumeClaimTemplate() {
    return this.withNewVolumeClaimTemplateLike(Optional.ofNullable(this.buildVolumeClaimTemplate()).orElse(null));
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
    StorageSpecFluent that = (StorageSpecFluent) o;
    if (!(Objects.equals(disableMountSubPath, that.disableMountSubPath))) {
      return false;
    }
    if (!(Objects.equals(emptyDir, that.emptyDir))) {
      return false;
    }
    if (!(Objects.equals(ephemeral, that.ephemeral))) {
      return false;
    }
    if (!(Objects.equals(volumeClaimTemplate, that.volumeClaimTemplate))) {
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
  
  public Boolean getDisableMountSubPath() {
    return this.disableMountSubPath;
  }
  
  public EmptyDirVolumeSource getEmptyDir() {
    return this.emptyDir;
  }
  
  public EphemeralVolumeSource getEphemeral() {
    return this.ephemeral;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisableMountSubPath() {
    return this.disableMountSubPath != null;
  }
  
  public boolean hasEmptyDir() {
    return this.emptyDir != null;
  }
  
  public boolean hasEphemeral() {
    return this.ephemeral != null;
  }
  
  public boolean hasVolumeClaimTemplate() {
    return this.volumeClaimTemplate != null;
  }
  
  public int hashCode() {
    return Objects.hash(disableMountSubPath, emptyDir, ephemeral, volumeClaimTemplate, additionalProperties);
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
    if (!(disableMountSubPath == null)) {
        sb.append("disableMountSubPath:");
        sb.append(disableMountSubPath);
        sb.append(",");
    }
    if (!(emptyDir == null)) {
        sb.append("emptyDir:");
        sb.append(emptyDir);
        sb.append(",");
    }
    if (!(ephemeral == null)) {
        sb.append("ephemeral:");
        sb.append(ephemeral);
        sb.append(",");
    }
    if (!(volumeClaimTemplate == null)) {
        sb.append("volumeClaimTemplate:");
        sb.append(volumeClaimTemplate);
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
  
  public A withDisableMountSubPath() {
    return withDisableMountSubPath(true);
  }
  
  public A withDisableMountSubPath(Boolean disableMountSubPath) {
    this.disableMountSubPath = disableMountSubPath;
    return (A) this;
  }
  
  public A withEmptyDir(EmptyDirVolumeSource emptyDir) {
    this.emptyDir = emptyDir;
    return (A) this;
  }
  
  public A withEphemeral(EphemeralVolumeSource ephemeral) {
    this.ephemeral = ephemeral;
    return (A) this;
  }
  
  public VolumeClaimTemplateNested<A> withNewVolumeClaimTemplate() {
    return new VolumeClaimTemplateNested(null);
  }
  
  public VolumeClaimTemplateNested<A> withNewVolumeClaimTemplateLike(EmbeddedPersistentVolumeClaim item) {
    return new VolumeClaimTemplateNested(item);
  }
  
  public A withVolumeClaimTemplate(EmbeddedPersistentVolumeClaim volumeClaimTemplate) {
    this._visitables.remove("volumeClaimTemplate");
    if (volumeClaimTemplate != null) {
        this.volumeClaimTemplate = new EmbeddedPersistentVolumeClaimBuilder(volumeClaimTemplate);
        this._visitables.get("volumeClaimTemplate").add(this.volumeClaimTemplate);
    } else {
        this.volumeClaimTemplate = null;
        this._visitables.get("volumeClaimTemplate").remove(this.volumeClaimTemplate);
    }
    return (A) this;
  }
  public class VolumeClaimTemplateNested<N> extends EmbeddedPersistentVolumeClaimFluent<VolumeClaimTemplateNested<N>> implements Nested<N>{
  
    EmbeddedPersistentVolumeClaimBuilder builder;
  
    VolumeClaimTemplateNested(EmbeddedPersistentVolumeClaim item) {
      this.builder = new EmbeddedPersistentVolumeClaimBuilder(this, item);
    }
  
    public N and() {
      return (N) StorageSpecFluent.this.withVolumeClaimTemplate(builder.build());
    }
    
    public N endVolumeClaimTemplate() {
      return and();
    }
    
  }
}