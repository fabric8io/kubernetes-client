package io.fabric8.kubernetes.api.model;

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
public class EphemeralVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.EphemeralVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PersistentVolumeClaimTemplateBuilder volumeClaimTemplate;

  public EphemeralVolumeSourceFluent() {
  }
  
  public EphemeralVolumeSourceFluent(EphemeralVolumeSource instance) {
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
  
  public PersistentVolumeClaimTemplate buildVolumeClaimTemplate() {
    return this.volumeClaimTemplate != null ? this.volumeClaimTemplate.build() : null;
  }
  
  protected void copyInstance(EphemeralVolumeSource instance) {
    instance = instance != null ? instance : new EphemeralVolumeSource();
    if (instance != null) {
        this.withVolumeClaimTemplate(instance.getVolumeClaimTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VolumeClaimTemplateNested<A> editOrNewVolumeClaimTemplate() {
    return this.withNewVolumeClaimTemplateLike(Optional.ofNullable(this.buildVolumeClaimTemplate()).orElse(new PersistentVolumeClaimTemplateBuilder().build()));
  }
  
  public VolumeClaimTemplateNested<A> editOrNewVolumeClaimTemplateLike(PersistentVolumeClaimTemplate item) {
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
    EphemeralVolumeSourceFluent that = (EphemeralVolumeSourceFluent) o;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasVolumeClaimTemplate() {
    return this.volumeClaimTemplate != null;
  }
  
  public int hashCode() {
    return Objects.hash(volumeClaimTemplate, additionalProperties);
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
  
  public VolumeClaimTemplateNested<A> withNewVolumeClaimTemplate() {
    return new VolumeClaimTemplateNested(null);
  }
  
  public VolumeClaimTemplateNested<A> withNewVolumeClaimTemplateLike(PersistentVolumeClaimTemplate item) {
    return new VolumeClaimTemplateNested(item);
  }
  
  public A withVolumeClaimTemplate(PersistentVolumeClaimTemplate volumeClaimTemplate) {
    this._visitables.remove("volumeClaimTemplate");
    if (volumeClaimTemplate != null) {
        this.volumeClaimTemplate = new PersistentVolumeClaimTemplateBuilder(volumeClaimTemplate);
        this._visitables.get("volumeClaimTemplate").add(this.volumeClaimTemplate);
    } else {
        this.volumeClaimTemplate = null;
        this._visitables.get("volumeClaimTemplate").remove(this.volumeClaimTemplate);
    }
    return (A) this;
  }
  public class VolumeClaimTemplateNested<N> extends PersistentVolumeClaimTemplateFluent<VolumeClaimTemplateNested<N>> implements Nested<N>{
  
    PersistentVolumeClaimTemplateBuilder builder;
  
    VolumeClaimTemplateNested(PersistentVolumeClaimTemplate item) {
      this.builder = new PersistentVolumeClaimTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) EphemeralVolumeSourceFluent.this.withVolumeClaimTemplate(builder.build());
    }
    
    public N endVolumeClaimTemplate() {
      return and();
    }
    
  }
}