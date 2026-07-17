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
public class DeploymentTriggerPolicyFluent<A extends io.fabric8.openshift.api.model.DeploymentTriggerPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DeploymentTriggerImageChangeParamsBuilder imageChangeParams;
  private String type;

  public DeploymentTriggerPolicyFluent() {
  }
  
  public DeploymentTriggerPolicyFluent(DeploymentTriggerPolicy instance) {
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
  
  public DeploymentTriggerImageChangeParams buildImageChangeParams() {
    return this.imageChangeParams != null ? this.imageChangeParams.build() : null;
  }
  
  protected void copyInstance(DeploymentTriggerPolicy instance) {
    instance = instance != null ? instance : new DeploymentTriggerPolicy();
    if (instance != null) {
        this.withImageChangeParams(instance.getImageChangeParams());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageChangeParamsNested<A> editImageChangeParams() {
    return this.withNewImageChangeParamsLike(Optional.ofNullable(this.buildImageChangeParams()).orElse(null));
  }
  
  public ImageChangeParamsNested<A> editOrNewImageChangeParams() {
    return this.withNewImageChangeParamsLike(Optional.ofNullable(this.buildImageChangeParams()).orElse(new DeploymentTriggerImageChangeParamsBuilder().build()));
  }
  
  public ImageChangeParamsNested<A> editOrNewImageChangeParamsLike(DeploymentTriggerImageChangeParams item) {
    return this.withNewImageChangeParamsLike(Optional.ofNullable(this.buildImageChangeParams()).orElse(item));
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
    DeploymentTriggerPolicyFluent that = (DeploymentTriggerPolicyFluent) o;
    if (!(Objects.equals(imageChangeParams, that.imageChangeParams))) {
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
  
  public boolean hasImageChangeParams() {
    return this.imageChangeParams != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(imageChangeParams, type, additionalProperties);
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
    if (!(imageChangeParams == null)) {
        sb.append("imageChangeParams:");
        sb.append(imageChangeParams);
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
  
  public A withImageChangeParams(DeploymentTriggerImageChangeParams imageChangeParams) {
    this._visitables.remove("imageChangeParams");
    if (imageChangeParams != null) {
        this.imageChangeParams = new DeploymentTriggerImageChangeParamsBuilder(imageChangeParams);
        this._visitables.get("imageChangeParams").add(this.imageChangeParams);
    } else {
        this.imageChangeParams = null;
        this._visitables.get("imageChangeParams").remove(this.imageChangeParams);
    }
    return (A) this;
  }
  
  public ImageChangeParamsNested<A> withNewImageChangeParams() {
    return new ImageChangeParamsNested(null);
  }
  
  public ImageChangeParamsNested<A> withNewImageChangeParamsLike(DeploymentTriggerImageChangeParams item) {
    return new ImageChangeParamsNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ImageChangeParamsNested<N> extends DeploymentTriggerImageChangeParamsFluent<ImageChangeParamsNested<N>> implements Nested<N>{
  
    DeploymentTriggerImageChangeParamsBuilder builder;
  
    ImageChangeParamsNested(DeploymentTriggerImageChangeParams item) {
      this.builder = new DeploymentTriggerImageChangeParamsBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentTriggerPolicyFluent.this.withImageChangeParams(builder.build());
    }
    
    public N endImageChangeParams() {
      return and();
    }
    
  }
}