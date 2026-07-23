package io.fabric8.openshift.api.model;

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
public class DeploymentCauseFluent<A extends io.fabric8.openshift.api.model.DeploymentCauseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DeploymentCauseImageTriggerBuilder imageTrigger;
  private String type;

  public DeploymentCauseFluent() {
  }
  
  public DeploymentCauseFluent(DeploymentCause instance) {
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
  
  public DeploymentCauseImageTrigger buildImageTrigger() {
    return this.imageTrigger != null ? this.imageTrigger.build() : null;
  }
  
  protected void copyInstance(DeploymentCause instance) {
    instance = instance != null ? instance : new DeploymentCause();
    if (instance != null) {
        this.withImageTrigger(instance.getImageTrigger());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageTriggerNested<A> editImageTrigger() {
    return this.withNewImageTriggerLike(Optional.ofNullable(this.buildImageTrigger()).orElse(null));
  }
  
  public ImageTriggerNested<A> editOrNewImageTrigger() {
    return this.withNewImageTriggerLike(Optional.ofNullable(this.buildImageTrigger()).orElse(new DeploymentCauseImageTriggerBuilder().build()));
  }
  
  public ImageTriggerNested<A> editOrNewImageTriggerLike(DeploymentCauseImageTrigger item) {
    return this.withNewImageTriggerLike(Optional.ofNullable(this.buildImageTrigger()).orElse(item));
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
    DeploymentCauseFluent that = (DeploymentCauseFluent) o;
    if (!(Objects.equals(imageTrigger, that.imageTrigger))) {
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
  
  public boolean hasImageTrigger() {
    return this.imageTrigger != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(imageTrigger, type, additionalProperties);
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
    if (!(imageTrigger == null)) {
        sb.append("imageTrigger:");
        sb.append(imageTrigger);
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
  
  public A withImageTrigger(DeploymentCauseImageTrigger imageTrigger) {
    this._visitables.remove("imageTrigger");
    if (imageTrigger != null) {
        this.imageTrigger = new DeploymentCauseImageTriggerBuilder(imageTrigger);
        this._visitables.get("imageTrigger").add(this.imageTrigger);
    } else {
        this.imageTrigger = null;
        this._visitables.get("imageTrigger").remove(this.imageTrigger);
    }
    return (A) this;
  }
  
  public ImageTriggerNested<A> withNewImageTrigger() {
    return new ImageTriggerNested(null);
  }
  
  public ImageTriggerNested<A> withNewImageTriggerLike(DeploymentCauseImageTrigger item) {
    return new ImageTriggerNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ImageTriggerNested<N> extends DeploymentCauseImageTriggerFluent<ImageTriggerNested<N>> implements Nested<N>{
  
    DeploymentCauseImageTriggerBuilder builder;
  
    ImageTriggerNested(DeploymentCauseImageTrigger item) {
      this.builder = new DeploymentCauseImageTriggerBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentCauseFluent.this.withImageTrigger(builder.build());
    }
    
    public N endImageTrigger() {
      return and();
    }
    
  }
}