package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class ImageChangeCauseFluent<A extends io.fabric8.openshift.api.model.ImageChangeCauseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder fromRef;
  private String imageID;

  public ImageChangeCauseFluent() {
  }
  
  public ImageChangeCauseFluent(ImageChangeCause instance) {
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
  
  public ObjectReference buildFromRef() {
    return this.fromRef != null ? this.fromRef.build() : null;
  }
  
  protected void copyInstance(ImageChangeCause instance) {
    instance = instance != null ? instance : new ImageChangeCause();
    if (instance != null) {
        this.withFromRef(instance.getFromRef());
        this.withImageID(instance.getImageID());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromRefNested<A> editFromRef() {
    return this.withNewFromRefLike(Optional.ofNullable(this.buildFromRef()).orElse(null));
  }
  
  public FromRefNested<A> editOrNewFromRef() {
    return this.withNewFromRefLike(Optional.ofNullable(this.buildFromRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public FromRefNested<A> editOrNewFromRefLike(ObjectReference item) {
    return this.withNewFromRefLike(Optional.ofNullable(this.buildFromRef()).orElse(item));
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
    ImageChangeCauseFluent that = (ImageChangeCauseFluent) o;
    if (!(Objects.equals(fromRef, that.fromRef))) {
      return false;
    }
    if (!(Objects.equals(imageID, that.imageID))) {
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
  
  public String getImageID() {
    return this.imageID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFromRef() {
    return this.fromRef != null;
  }
  
  public boolean hasImageID() {
    return this.imageID != null;
  }
  
  public int hashCode() {
    return Objects.hash(fromRef, imageID, additionalProperties);
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
    if (!(fromRef == null)) {
        sb.append("fromRef:");
        sb.append(fromRef);
        sb.append(",");
    }
    if (!(imageID == null)) {
        sb.append("imageID:");
        sb.append(imageID);
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
  
  public A withFromRef(ObjectReference fromRef) {
    this._visitables.remove("fromRef");
    if (fromRef != null) {
        this.fromRef = new ObjectReferenceBuilder(fromRef);
        this._visitables.get("fromRef").add(this.fromRef);
    } else {
        this.fromRef = null;
        this._visitables.get("fromRef").remove(this.fromRef);
    }
    return (A) this;
  }
  
  public A withImageID(String imageID) {
    this.imageID = imageID;
    return (A) this;
  }
  
  public FromRefNested<A> withNewFromRef() {
    return new FromRefNested(null);
  }
  
  public FromRefNested<A> withNewFromRefLike(ObjectReference item) {
    return new FromRefNested(item);
  }
  public class FromRefNested<N> extends ObjectReferenceFluent<FromRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    FromRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageChangeCauseFluent.this.withFromRef(builder.build());
    }
    
    public N endFromRef() {
      return and();
    }
    
  }
}