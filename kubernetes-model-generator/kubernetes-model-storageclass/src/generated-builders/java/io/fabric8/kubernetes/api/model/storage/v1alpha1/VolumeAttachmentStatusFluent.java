package io.fabric8.kubernetes.api.model.storage.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class VolumeAttachmentStatusFluent<A extends io.fabric8.kubernetes.api.model.storage.v1alpha1.VolumeAttachmentStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VolumeErrorBuilder attachError;
  private Boolean attached;
  private Map<String,String> attachmentMetadata;
  private VolumeErrorBuilder detachError;

  public VolumeAttachmentStatusFluent() {
  }
  
  public VolumeAttachmentStatusFluent(VolumeAttachmentStatus instance) {
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
  
  public A addToAttachmentMetadata(Map<String,String> map) {
    if (this.attachmentMetadata == null && map != null) {
      this.attachmentMetadata = new LinkedHashMap();
    }
    if (map != null) {
      this.attachmentMetadata.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAttachmentMetadata(String key,String value) {
    if (this.attachmentMetadata == null && key != null && value != null) {
      this.attachmentMetadata = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.attachmentMetadata.put(key, value);
    }
    return (A) this;
  }
  
  public VolumeError buildAttachError() {
    return this.attachError != null ? this.attachError.build() : null;
  }
  
  public VolumeError buildDetachError() {
    return this.detachError != null ? this.detachError.build() : null;
  }
  
  protected void copyInstance(VolumeAttachmentStatus instance) {
    instance = instance != null ? instance : new VolumeAttachmentStatus();
    if (instance != null) {
        this.withAttachError(instance.getAttachError());
        this.withAttached(instance.getAttached());
        this.withAttachmentMetadata(instance.getAttachmentMetadata());
        this.withDetachError(instance.getDetachError());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AttachErrorNested<A> editAttachError() {
    return this.withNewAttachErrorLike(Optional.ofNullable(this.buildAttachError()).orElse(null));
  }
  
  public DetachErrorNested<A> editDetachError() {
    return this.withNewDetachErrorLike(Optional.ofNullable(this.buildDetachError()).orElse(null));
  }
  
  public AttachErrorNested<A> editOrNewAttachError() {
    return this.withNewAttachErrorLike(Optional.ofNullable(this.buildAttachError()).orElse(new VolumeErrorBuilder().build()));
  }
  
  public AttachErrorNested<A> editOrNewAttachErrorLike(VolumeError item) {
    return this.withNewAttachErrorLike(Optional.ofNullable(this.buildAttachError()).orElse(item));
  }
  
  public DetachErrorNested<A> editOrNewDetachError() {
    return this.withNewDetachErrorLike(Optional.ofNullable(this.buildDetachError()).orElse(new VolumeErrorBuilder().build()));
  }
  
  public DetachErrorNested<A> editOrNewDetachErrorLike(VolumeError item) {
    return this.withNewDetachErrorLike(Optional.ofNullable(this.buildDetachError()).orElse(item));
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
    VolumeAttachmentStatusFluent that = (VolumeAttachmentStatusFluent) o;
    if (!(Objects.equals(attachError, that.attachError))) {
      return false;
    }
    if (!(Objects.equals(attached, that.attached))) {
      return false;
    }
    if (!(Objects.equals(attachmentMetadata, that.attachmentMetadata))) {
      return false;
    }
    if (!(Objects.equals(detachError, that.detachError))) {
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
  
  public Boolean getAttached() {
    return this.attached;
  }
  
  public Map<String,String> getAttachmentMetadata() {
    return this.attachmentMetadata;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttachError() {
    return this.attachError != null;
  }
  
  public boolean hasAttached() {
    return this.attached != null;
  }
  
  public boolean hasAttachmentMetadata() {
    return this.attachmentMetadata != null;
  }
  
  public boolean hasDetachError() {
    return this.detachError != null;
  }
  
  public int hashCode() {
    return Objects.hash(attachError, attached, attachmentMetadata, detachError, additionalProperties);
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
  
  public A removeFromAttachmentMetadata(String key) {
    if (this.attachmentMetadata == null) {
      return (A) this;
    }
    if (key != null && this.attachmentMetadata != null) {
      this.attachmentMetadata.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAttachmentMetadata(Map<String,String> map) {
    if (this.attachmentMetadata == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.attachmentMetadata != null) {
          this.attachmentMetadata.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(attachError == null)) {
        sb.append("attachError:");
        sb.append(attachError);
        sb.append(",");
    }
    if (!(attached == null)) {
        sb.append("attached:");
        sb.append(attached);
        sb.append(",");
    }
    if (!(attachmentMetadata == null) && !(attachmentMetadata.isEmpty())) {
        sb.append("attachmentMetadata:");
        sb.append(attachmentMetadata);
        sb.append(",");
    }
    if (!(detachError == null)) {
        sb.append("detachError:");
        sb.append(detachError);
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
  
  public A withAttachError(VolumeError attachError) {
    this._visitables.remove("attachError");
    if (attachError != null) {
        this.attachError = new VolumeErrorBuilder(attachError);
        this._visitables.get("attachError").add(this.attachError);
    } else {
        this.attachError = null;
        this._visitables.get("attachError").remove(this.attachError);
    }
    return (A) this;
  }
  
  public A withAttached() {
    return withAttached(true);
  }
  
  public A withAttached(Boolean attached) {
    this.attached = attached;
    return (A) this;
  }
  
  public <K,V>A withAttachmentMetadata(Map<String,String> attachmentMetadata) {
    if (attachmentMetadata == null) {
      this.attachmentMetadata = null;
    } else {
      this.attachmentMetadata = new LinkedHashMap(attachmentMetadata);
    }
    return (A) this;
  }
  
  public A withDetachError(VolumeError detachError) {
    this._visitables.remove("detachError");
    if (detachError != null) {
        this.detachError = new VolumeErrorBuilder(detachError);
        this._visitables.get("detachError").add(this.detachError);
    } else {
        this.detachError = null;
        this._visitables.get("detachError").remove(this.detachError);
    }
    return (A) this;
  }
  
  public AttachErrorNested<A> withNewAttachError() {
    return new AttachErrorNested(null);
  }
  
  public A withNewAttachError(String message,String time) {
    return (A) this.withAttachError(new VolumeError(message, time));
  }
  
  public AttachErrorNested<A> withNewAttachErrorLike(VolumeError item) {
    return new AttachErrorNested(item);
  }
  
  public DetachErrorNested<A> withNewDetachError() {
    return new DetachErrorNested(null);
  }
  
  public A withNewDetachError(String message,String time) {
    return (A) this.withDetachError(new VolumeError(message, time));
  }
  
  public DetachErrorNested<A> withNewDetachErrorLike(VolumeError item) {
    return new DetachErrorNested(item);
  }
  public class AttachErrorNested<N> extends VolumeErrorFluent<AttachErrorNested<N>> implements Nested<N>{
  
    VolumeErrorBuilder builder;
  
    AttachErrorNested(VolumeError item) {
      this.builder = new VolumeErrorBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeAttachmentStatusFluent.this.withAttachError(builder.build());
    }
    
    public N endAttachError() {
      return and();
    }
    
  }
  public class DetachErrorNested<N> extends VolumeErrorFluent<DetachErrorNested<N>> implements Nested<N>{
  
    VolumeErrorBuilder builder;
  
    DetachErrorNested(VolumeError item) {
      this.builder = new VolumeErrorBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeAttachmentStatusFluent.this.withDetachError(builder.build());
    }
    
    public N endDetachError() {
      return and();
    }
    
  }
}