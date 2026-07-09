package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
public class CustomResourceSubresourcesFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceSubresourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CustomResourceSubresourceScaleBuilder scale;
  private CustomResourceSubresourceStatusBuilder status;

  public CustomResourceSubresourcesFluent() {
  }
  
  public CustomResourceSubresourcesFluent(CustomResourceSubresources instance) {
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
  
  public CustomResourceSubresourceScale buildScale() {
    return this.scale != null ? this.scale.build() : null;
  }
  
  public CustomResourceSubresourceStatus buildStatus() {
    return this.status != null ? this.status.build() : null;
  }
  
  protected void copyInstance(CustomResourceSubresources instance) {
    instance = instance != null ? instance : new CustomResourceSubresources();
    if (instance != null) {
        this.withScale(instance.getScale());
        this.withStatus(instance.getStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ScaleNested<A> editOrNewScale() {
    return this.withNewScaleLike(Optional.ofNullable(this.buildScale()).orElse(new CustomResourceSubresourceScaleBuilder().build()));
  }
  
  public ScaleNested<A> editOrNewScaleLike(CustomResourceSubresourceScale item) {
    return this.withNewScaleLike(Optional.ofNullable(this.buildScale()).orElse(item));
  }
  
  public StatusNested<A> editOrNewStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(new CustomResourceSubresourceStatusBuilder().build()));
  }
  
  public StatusNested<A> editOrNewStatusLike(CustomResourceSubresourceStatus item) {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(item));
  }
  
  public ScaleNested<A> editScale() {
    return this.withNewScaleLike(Optional.ofNullable(this.buildScale()).orElse(null));
  }
  
  public StatusNested<A> editStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(null));
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
    CustomResourceSubresourcesFluent that = (CustomResourceSubresourcesFluent) o;
    if (!(Objects.equals(scale, that.scale))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
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
  
  public boolean hasScale() {
    return this.scale != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public int hashCode() {
    return Objects.hash(scale, status, additionalProperties);
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
    if (!(scale == null)) {
        sb.append("scale:");
        sb.append(scale);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
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
  
  public ScaleNested<A> withNewScale() {
    return new ScaleNested(null);
  }
  
  public A withNewScale(String labelSelectorPath,String specReplicasPath,String statusReplicasPath) {
    return (A) this.withScale(new CustomResourceSubresourceScale(labelSelectorPath, specReplicasPath, statusReplicasPath));
  }
  
  public ScaleNested<A> withNewScaleLike(CustomResourceSubresourceScale item) {
    return new ScaleNested(item);
  }
  
  public StatusNested<A> withNewStatus() {
    return new StatusNested(null);
  }
  
  public StatusNested<A> withNewStatusLike(CustomResourceSubresourceStatus item) {
    return new StatusNested(item);
  }
  
  public A withScale(CustomResourceSubresourceScale scale) {
    this._visitables.remove("scale");
    if (scale != null) {
        this.scale = new CustomResourceSubresourceScaleBuilder(scale);
        this._visitables.get("scale").add(this.scale);
    } else {
        this.scale = null;
        this._visitables.get("scale").remove(this.scale);
    }
    return (A) this;
  }
  
  public A withStatus(CustomResourceSubresourceStatus status) {
    this._visitables.remove("status");
    if (status != null) {
        this.status = new CustomResourceSubresourceStatusBuilder(status);
        this._visitables.get("status").add(this.status);
    } else {
        this.status = null;
        this._visitables.get("status").remove(this.status);
    }
    return (A) this;
  }
  public class ScaleNested<N> extends CustomResourceSubresourceScaleFluent<ScaleNested<N>> implements Nested<N>{
  
    CustomResourceSubresourceScaleBuilder builder;
  
    ScaleNested(CustomResourceSubresourceScale item) {
      this.builder = new CustomResourceSubresourceScaleBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceSubresourcesFluent.this.withScale(builder.build());
    }
    
    public N endScale() {
      return and();
    }
    
  }
  public class StatusNested<N> extends CustomResourceSubresourceStatusFluent<StatusNested<N>> implements Nested<N>{
  
    CustomResourceSubresourceStatusBuilder builder;
  
    StatusNested(CustomResourceSubresourceStatus item) {
      this.builder = new CustomResourceSubresourceStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceSubresourcesFluent.this.withStatus(builder.build());
    }
    
    public N endStatus() {
      return and();
    }
    
  }
}