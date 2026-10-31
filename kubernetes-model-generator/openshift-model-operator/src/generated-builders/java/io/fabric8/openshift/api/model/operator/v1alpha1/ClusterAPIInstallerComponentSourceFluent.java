package io.fabric8.openshift.api.model.operator.v1alpha1;

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
public class ClusterAPIInstallerComponentSourceFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.ClusterAPIInstallerComponentSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterAPIInstallerComponentImageBuilder image;
  private String type;

  public ClusterAPIInstallerComponentSourceFluent() {
  }
  
  public ClusterAPIInstallerComponentSourceFluent(ClusterAPIInstallerComponentSource instance) {
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
  
  public ClusterAPIInstallerComponentImage buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  protected void copyInstance(ClusterAPIInstallerComponentSource instance) {
    instance = instance != null ? instance : new ClusterAPIInstallerComponentSource();
    if (instance != null) {
        this.withImage(instance.getImage());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new ClusterAPIInstallerComponentImageBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(ClusterAPIInstallerComponentImage item) {
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
    ClusterAPIInstallerComponentSourceFluent that = (ClusterAPIInstallerComponentSourceFluent) o;
    if (!(Objects.equals(image, that.image))) {
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
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(image, type, additionalProperties);
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
  
  public A withImage(ClusterAPIInstallerComponentImage image) {
    this._visitables.remove("image");
    if (image != null) {
        this.image = new ClusterAPIInstallerComponentImageBuilder(image);
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
  
  public A withNewImage(String profile,String ref) {
    return (A) this.withImage(new ClusterAPIInstallerComponentImage(profile, ref));
  }
  
  public ImageNested<A> withNewImageLike(ClusterAPIInstallerComponentImage item) {
    return new ImageNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ImageNested<N> extends ClusterAPIInstallerComponentImageFluent<ImageNested<N>> implements Nested<N>{
  
    ClusterAPIInstallerComponentImageBuilder builder;
  
    ImageNested(ClusterAPIInstallerComponentImage item) {
      this.builder = new ClusterAPIInstallerComponentImageBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAPIInstallerComponentSourceFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
}