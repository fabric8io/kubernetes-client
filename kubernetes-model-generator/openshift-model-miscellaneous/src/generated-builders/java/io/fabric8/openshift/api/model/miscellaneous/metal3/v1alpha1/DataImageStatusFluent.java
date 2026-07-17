package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class DataImageStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.DataImageStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AttachedImageReferenceBuilder attachedImage;
  private DataImageErrorBuilder error;
  private String lastReconciled;

  public DataImageStatusFluent() {
  }
  
  public DataImageStatusFluent(DataImageStatus instance) {
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
  
  public AttachedImageReference buildAttachedImage() {
    return this.attachedImage != null ? this.attachedImage.build() : null;
  }
  
  public DataImageError buildError() {
    return this.error != null ? this.error.build() : null;
  }
  
  protected void copyInstance(DataImageStatus instance) {
    instance = instance != null ? instance : new DataImageStatus();
    if (instance != null) {
        this.withAttachedImage(instance.getAttachedImage());
        this.withError(instance.getError());
        this.withLastReconciled(instance.getLastReconciled());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AttachedImageNested<A> editAttachedImage() {
    return this.withNewAttachedImageLike(Optional.ofNullable(this.buildAttachedImage()).orElse(null));
  }
  
  public ErrorNested<A> editError() {
    return this.withNewErrorLike(Optional.ofNullable(this.buildError()).orElse(null));
  }
  
  public AttachedImageNested<A> editOrNewAttachedImage() {
    return this.withNewAttachedImageLike(Optional.ofNullable(this.buildAttachedImage()).orElse(new AttachedImageReferenceBuilder().build()));
  }
  
  public AttachedImageNested<A> editOrNewAttachedImageLike(AttachedImageReference item) {
    return this.withNewAttachedImageLike(Optional.ofNullable(this.buildAttachedImage()).orElse(item));
  }
  
  public ErrorNested<A> editOrNewError() {
    return this.withNewErrorLike(Optional.ofNullable(this.buildError()).orElse(new DataImageErrorBuilder().build()));
  }
  
  public ErrorNested<A> editOrNewErrorLike(DataImageError item) {
    return this.withNewErrorLike(Optional.ofNullable(this.buildError()).orElse(item));
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
    DataImageStatusFluent that = (DataImageStatusFluent) o;
    if (!(Objects.equals(attachedImage, that.attachedImage))) {
      return false;
    }
    if (!(Objects.equals(error, that.error))) {
      return false;
    }
    if (!(Objects.equals(lastReconciled, that.lastReconciled))) {
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
  
  public String getLastReconciled() {
    return this.lastReconciled;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttachedImage() {
    return this.attachedImage != null;
  }
  
  public boolean hasError() {
    return this.error != null;
  }
  
  public boolean hasLastReconciled() {
    return this.lastReconciled != null;
  }
  
  public int hashCode() {
    return Objects.hash(attachedImage, error, lastReconciled, additionalProperties);
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
    if (!(attachedImage == null)) {
        sb.append("attachedImage:");
        sb.append(attachedImage);
        sb.append(",");
    }
    if (!(error == null)) {
        sb.append("error:");
        sb.append(error);
        sb.append(",");
    }
    if (!(lastReconciled == null)) {
        sb.append("lastReconciled:");
        sb.append(lastReconciled);
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
  
  public A withAttachedImage(AttachedImageReference attachedImage) {
    this._visitables.remove("attachedImage");
    if (attachedImage != null) {
        this.attachedImage = new AttachedImageReferenceBuilder(attachedImage);
        this._visitables.get("attachedImage").add(this.attachedImage);
    } else {
        this.attachedImage = null;
        this._visitables.get("attachedImage").remove(this.attachedImage);
    }
    return (A) this;
  }
  
  public A withError(DataImageError error) {
    this._visitables.remove("error");
    if (error != null) {
        this.error = new DataImageErrorBuilder(error);
        this._visitables.get("error").add(this.error);
    } else {
        this.error = null;
        this._visitables.get("error").remove(this.error);
    }
    return (A) this;
  }
  
  public A withLastReconciled(String lastReconciled) {
    this.lastReconciled = lastReconciled;
    return (A) this;
  }
  
  public AttachedImageNested<A> withNewAttachedImage() {
    return new AttachedImageNested(null);
  }
  
  public A withNewAttachedImage(String url) {
    return (A) this.withAttachedImage(new AttachedImageReference(url));
  }
  
  public AttachedImageNested<A> withNewAttachedImageLike(AttachedImageReference item) {
    return new AttachedImageNested(item);
  }
  
  public ErrorNested<A> withNewError() {
    return new ErrorNested(null);
  }
  
  public A withNewError(Integer count,String message) {
    return (A) this.withError(new DataImageError(count, message));
  }
  
  public ErrorNested<A> withNewErrorLike(DataImageError item) {
    return new ErrorNested(item);
  }
  public class AttachedImageNested<N> extends AttachedImageReferenceFluent<AttachedImageNested<N>> implements Nested<N>{
  
    AttachedImageReferenceBuilder builder;
  
    AttachedImageNested(AttachedImageReference item) {
      this.builder = new AttachedImageReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) DataImageStatusFluent.this.withAttachedImage(builder.build());
    }
    
    public N endAttachedImage() {
      return and();
    }
    
  }
  public class ErrorNested<N> extends DataImageErrorFluent<ErrorNested<N>> implements Nested<N>{
  
    DataImageErrorBuilder builder;
  
    ErrorNested(DataImageError item) {
      this.builder = new DataImageErrorBuilder(this, item);
    }
  
    public N and() {
      return (N) DataImageStatusFluent.this.withError(builder.build());
    }
    
    public N endError() {
      return and();
    }
    
  }
}