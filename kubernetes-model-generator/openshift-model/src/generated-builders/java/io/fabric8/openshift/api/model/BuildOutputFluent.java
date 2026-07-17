package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class BuildOutputFluent<A extends io.fabric8.openshift.api.model.BuildOutputFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ImageLabelBuilder> imageLabels = new ArrayList<ImageLabelBuilder>();
  private LocalObjectReferenceBuilder pushSecret;
  private ObjectReferenceBuilder to;

  public BuildOutputFluent() {
  }
  
  public BuildOutputFluent(BuildOutput instance) {
    this.copyInstance(instance);
  }

  public A addAllToImageLabels(Collection<ImageLabel> items) {
    if (this.imageLabels == null) {
      this.imageLabels = new ArrayList();
    }
    for (ImageLabel item : items) {
        ImageLabelBuilder builder = new ImageLabelBuilder(item);
        _visitables.get("imageLabels").add(builder);
        this.imageLabels.add(builder);
    }
    return (A) this;
  }
  
  public ImageLabelsNested<A> addNewImageLabel() {
    return new ImageLabelsNested(-1, null);
  }
  
  public A addNewImageLabel(String name,String value) {
    return (A) this.addToImageLabels(new ImageLabel(name, value));
  }
  
  public ImageLabelsNested<A> addNewImageLabelLike(ImageLabel item) {
    return new ImageLabelsNested(-1, item);
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
  
  public A addToImageLabels(ImageLabel... items) {
    if (this.imageLabels == null) {
      this.imageLabels = new ArrayList();
    }
    for (ImageLabel item : items) {
        ImageLabelBuilder builder = new ImageLabelBuilder(item);
        _visitables.get("imageLabels").add(builder);
        this.imageLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageLabels(int index,ImageLabel item) {
    if (this.imageLabels == null) {
      this.imageLabels = new ArrayList();
    }
    ImageLabelBuilder builder = new ImageLabelBuilder(item);
    if (index < 0 || index >= imageLabels.size()) {
        _visitables.get("imageLabels").add(builder);
        imageLabels.add(builder);
    } else {
        _visitables.get("imageLabels").add(builder);
        imageLabels.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageLabel buildFirstImageLabel() {
    return this.imageLabels.get(0).build();
  }
  
  public ImageLabel buildImageLabel(int index) {
    return this.imageLabels.get(index).build();
  }
  
  public List<ImageLabel> buildImageLabels() {
    return this.imageLabels != null ? build(imageLabels) : null;
  }
  
  public ImageLabel buildLastImageLabel() {
    return this.imageLabels.get(imageLabels.size() - 1).build();
  }
  
  public ImageLabel buildMatchingImageLabel(Predicate<ImageLabelBuilder> predicate) {
      for (ImageLabelBuilder item : imageLabels) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LocalObjectReference buildPushSecret() {
    return this.pushSecret != null ? this.pushSecret.build() : null;
  }
  
  public ObjectReference buildTo() {
    return this.to != null ? this.to.build() : null;
  }
  
  protected void copyInstance(BuildOutput instance) {
    instance = instance != null ? instance : new BuildOutput();
    if (instance != null) {
        this.withImageLabels(instance.getImageLabels());
        this.withPushSecret(instance.getPushSecret());
        this.withTo(instance.getTo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageLabelsNested<A> editFirstImageLabel() {
    if (imageLabels.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageLabels"));
    }
    return this.setNewImageLabelLike(0, this.buildImageLabel(0));
  }
  
  public ImageLabelsNested<A> editImageLabel(int index) {
    if (imageLabels.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageLabels"));
    }
    return this.setNewImageLabelLike(index, this.buildImageLabel(index));
  }
  
  public ImageLabelsNested<A> editLastImageLabel() {
    int index = imageLabels.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageLabels"));
    }
    return this.setNewImageLabelLike(index, this.buildImageLabel(index));
  }
  
  public ImageLabelsNested<A> editMatchingImageLabel(Predicate<ImageLabelBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageLabels.size();i++) {
      if (predicate.test(imageLabels.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageLabels"));
    }
    return this.setNewImageLabelLike(index, this.buildImageLabel(index));
  }
  
  public PushSecretNested<A> editOrNewPushSecret() {
    return this.withNewPushSecretLike(Optional.ofNullable(this.buildPushSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public PushSecretNested<A> editOrNewPushSecretLike(LocalObjectReference item) {
    return this.withNewPushSecretLike(Optional.ofNullable(this.buildPushSecret()).orElse(item));
  }
  
  public ToNested<A> editOrNewTo() {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ToNested<A> editOrNewToLike(ObjectReference item) {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(item));
  }
  
  public PushSecretNested<A> editPushSecret() {
    return this.withNewPushSecretLike(Optional.ofNullable(this.buildPushSecret()).orElse(null));
  }
  
  public ToNested<A> editTo() {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(null));
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
    BuildOutputFluent that = (BuildOutputFluent) o;
    if (!(Objects.equals(imageLabels, that.imageLabels))) {
      return false;
    }
    if (!(Objects.equals(pushSecret, that.pushSecret))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
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
  
  public boolean hasImageLabels() {
    return this.imageLabels != null && !(this.imageLabels.isEmpty());
  }
  
  public boolean hasMatchingImageLabel(Predicate<ImageLabelBuilder> predicate) {
      for (ImageLabelBuilder item : imageLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPushSecret() {
    return this.pushSecret != null;
  }
  
  public boolean hasTo() {
    return this.to != null;
  }
  
  public int hashCode() {
    return Objects.hash(imageLabels, pushSecret, to, additionalProperties);
  }
  
  public A removeAllFromImageLabels(Collection<ImageLabel> items) {
    if (this.imageLabels == null) {
      return (A) this;
    }
    for (ImageLabel item : items) {
        ImageLabelBuilder builder = new ImageLabelBuilder(item);
        _visitables.get("imageLabels").remove(builder);
        this.imageLabels.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromImageLabels(ImageLabel... items) {
    if (this.imageLabels == null) {
      return (A) this;
    }
    for (ImageLabel item : items) {
        ImageLabelBuilder builder = new ImageLabelBuilder(item);
        _visitables.get("imageLabels").remove(builder);
        this.imageLabels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromImageLabels(Predicate<ImageLabelBuilder> predicate) {
    if (imageLabels == null) {
      return (A) this;
    }
    Iterator<ImageLabelBuilder> each = imageLabels.iterator();
    List visitables = _visitables.get("imageLabels");
    while (each.hasNext()) {
        ImageLabelBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ImageLabelsNested<A> setNewImageLabelLike(int index,ImageLabel item) {
    return new ImageLabelsNested(index, item);
  }
  
  public A setToImageLabels(int index,ImageLabel item) {
    if (this.imageLabels == null) {
      this.imageLabels = new ArrayList();
    }
    ImageLabelBuilder builder = new ImageLabelBuilder(item);
    if (index < 0 || index >= imageLabels.size()) {
        _visitables.get("imageLabels").add(builder);
        imageLabels.add(builder);
    } else {
        _visitables.get("imageLabels").add(builder);
        imageLabels.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(imageLabels == null) && !(imageLabels.isEmpty())) {
        sb.append("imageLabels:");
        sb.append(imageLabels);
        sb.append(",");
    }
    if (!(pushSecret == null)) {
        sb.append("pushSecret:");
        sb.append(pushSecret);
        sb.append(",");
    }
    if (!(to == null)) {
        sb.append("to:");
        sb.append(to);
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
  
  public A withImageLabels(List<ImageLabel> imageLabels) {
    if (this.imageLabels != null) {
      this._visitables.get("imageLabels").clear();
    }
    if (imageLabels != null) {
        this.imageLabels = new ArrayList();
        for (ImageLabel item : imageLabels) {
          this.addToImageLabels(item);
        }
    } else {
      this.imageLabels = null;
    }
    return (A) this;
  }
  
  public A withImageLabels(ImageLabel... imageLabels) {
    if (this.imageLabels != null) {
        this.imageLabels.clear();
        _visitables.remove("imageLabels");
    }
    if (imageLabels != null) {
      for (ImageLabel item : imageLabels) {
        this.addToImageLabels(item);
      }
    }
    return (A) this;
  }
  
  public PushSecretNested<A> withNewPushSecret() {
    return new PushSecretNested(null);
  }
  
  public A withNewPushSecret(String name) {
    return (A) this.withPushSecret(new LocalObjectReference(name));
  }
  
  public PushSecretNested<A> withNewPushSecretLike(LocalObjectReference item) {
    return new PushSecretNested(item);
  }
  
  public ToNested<A> withNewTo() {
    return new ToNested(null);
  }
  
  public ToNested<A> withNewToLike(ObjectReference item) {
    return new ToNested(item);
  }
  
  public A withPushSecret(LocalObjectReference pushSecret) {
    this._visitables.remove("pushSecret");
    if (pushSecret != null) {
        this.pushSecret = new LocalObjectReferenceBuilder(pushSecret);
        this._visitables.get("pushSecret").add(this.pushSecret);
    } else {
        this.pushSecret = null;
        this._visitables.get("pushSecret").remove(this.pushSecret);
    }
    return (A) this;
  }
  
  public A withTo(ObjectReference to) {
    this._visitables.remove("to");
    if (to != null) {
        this.to = new ObjectReferenceBuilder(to);
        this._visitables.get("to").add(this.to);
    } else {
        this.to = null;
        this._visitables.get("to").remove(this.to);
    }
    return (A) this;
  }
  public class ImageLabelsNested<N> extends ImageLabelFluent<ImageLabelsNested<N>> implements Nested<N>{
  
    ImageLabelBuilder builder;
    int index;
  
    ImageLabelsNested(int index,ImageLabel item) {
      this.index = index;
      this.builder = new ImageLabelBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildOutputFluent.this.setToImageLabels(index, builder.build());
    }
    
    public N endImageLabel() {
      return and();
    }
    
  }
  public class PushSecretNested<N> extends LocalObjectReferenceFluent<PushSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    PushSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildOutputFluent.this.withPushSecret(builder.build());
    }
    
    public N endPushSecret() {
      return and();
    }
    
  }
  public class ToNested<N> extends ObjectReferenceFluent<ToNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ToNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildOutputFluent.this.withTo(builder.build());
    }
    
    public N endTo() {
      return and();
    }
    
  }
}