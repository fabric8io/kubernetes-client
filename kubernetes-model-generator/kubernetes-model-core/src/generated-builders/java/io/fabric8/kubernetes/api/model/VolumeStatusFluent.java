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
public class VolumeStatusFluent<A extends io.fabric8.kubernetes.api.model.VolumeStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ImageVolumeStatusBuilder image;

  public VolumeStatusFluent() {
  }
  
  public VolumeStatusFluent(VolumeStatus instance) {
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
  
  public ImageVolumeStatus buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  protected void copyInstance(VolumeStatus instance) {
    instance = instance != null ? instance : new VolumeStatus();
    if (instance != null) {
        this.withImage(instance.getImage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new ImageVolumeStatusBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(ImageVolumeStatus item) {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(item));
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
    VolumeStatusFluent that = (VolumeStatusFluent) o;
    if (!(Objects.equals(image, that.image))) {
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
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public int hashCode() {
    return Objects.hash(image, additionalProperties);
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
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
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
  
  public A withImage(ImageVolumeStatus image) {
    this._visitables.remove("image");
    if (image != null) {
        this.image = new ImageVolumeStatusBuilder(image);
        this._visitables.get("image").add(this.image);
    } else {
        this.image = null;
        this._visitables.get("image").remove(this.image);
    }
    return (A) this;
  }
  
  public ImageNested<A> withNewImage() {
    return new ImageNested(null);
  }
  
  public A withNewImage(String imageRef) {
    return (A) this.withImage(new ImageVolumeStatus(imageRef));
  }
  
  public ImageNested<A> withNewImageLike(ImageVolumeStatus item) {
    return new ImageNested(item);
  }
  public class ImageNested<N> extends ImageVolumeStatusFluent<ImageNested<N>> implements Nested<N>{
  
    ImageVolumeStatusBuilder builder;
  
    ImageNested(ImageVolumeStatus item) {
      this.builder = new ImageVolumeStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeStatusFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
}