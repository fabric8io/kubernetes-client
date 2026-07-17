package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ImageTagMirrorSetSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.ImageTagMirrorSetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ImageTagMirrorsBuilder> imageTagMirrors = new ArrayList<ImageTagMirrorsBuilder>();

  public ImageTagMirrorSetSpecFluent() {
  }
  
  public ImageTagMirrorSetSpecFluent(ImageTagMirrorSetSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToImageTagMirrors(Collection<ImageTagMirrors> items) {
    if (this.imageTagMirrors == null) {
      this.imageTagMirrors = new ArrayList();
    }
    for (ImageTagMirrors item : items) {
        ImageTagMirrorsBuilder builder = new ImageTagMirrorsBuilder(item);
        _visitables.get("imageTagMirrors").add(builder);
        this.imageTagMirrors.add(builder);
    }
    return (A) this;
  }
  
  public ImageTagMirrorsNested<A> addNewImageTagMirror() {
    return new ImageTagMirrorsNested(-1, null);
  }
  
  public ImageTagMirrorsNested<A> addNewImageTagMirrorLike(ImageTagMirrors item) {
    return new ImageTagMirrorsNested(-1, item);
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
  
  public A addToImageTagMirrors(ImageTagMirrors... items) {
    if (this.imageTagMirrors == null) {
      this.imageTagMirrors = new ArrayList();
    }
    for (ImageTagMirrors item : items) {
        ImageTagMirrorsBuilder builder = new ImageTagMirrorsBuilder(item);
        _visitables.get("imageTagMirrors").add(builder);
        this.imageTagMirrors.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageTagMirrors(int index,ImageTagMirrors item) {
    if (this.imageTagMirrors == null) {
      this.imageTagMirrors = new ArrayList();
    }
    ImageTagMirrorsBuilder builder = new ImageTagMirrorsBuilder(item);
    if (index < 0 || index >= imageTagMirrors.size()) {
        _visitables.get("imageTagMirrors").add(builder);
        imageTagMirrors.add(builder);
    } else {
        _visitables.get("imageTagMirrors").add(builder);
        imageTagMirrors.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageTagMirrors buildFirstImageTagMirror() {
    return this.imageTagMirrors.get(0).build();
  }
  
  public ImageTagMirrors buildImageTagMirror(int index) {
    return this.imageTagMirrors.get(index).build();
  }
  
  public List<ImageTagMirrors> buildImageTagMirrors() {
    return this.imageTagMirrors != null ? build(imageTagMirrors) : null;
  }
  
  public ImageTagMirrors buildLastImageTagMirror() {
    return this.imageTagMirrors.get(imageTagMirrors.size() - 1).build();
  }
  
  public ImageTagMirrors buildMatchingImageTagMirror(Predicate<ImageTagMirrorsBuilder> predicate) {
      for (ImageTagMirrorsBuilder item : imageTagMirrors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ImageTagMirrorSetSpec instance) {
    instance = instance != null ? instance : new ImageTagMirrorSetSpec();
    if (instance != null) {
        this.withImageTagMirrors(instance.getImageTagMirrors());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageTagMirrorsNested<A> editFirstImageTagMirror() {
    if (imageTagMirrors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageTagMirrors"));
    }
    return this.setNewImageTagMirrorLike(0, this.buildImageTagMirror(0));
  }
  
  public ImageTagMirrorsNested<A> editImageTagMirror(int index) {
    if (imageTagMirrors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageTagMirrors"));
    }
    return this.setNewImageTagMirrorLike(index, this.buildImageTagMirror(index));
  }
  
  public ImageTagMirrorsNested<A> editLastImageTagMirror() {
    int index = imageTagMirrors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageTagMirrors"));
    }
    return this.setNewImageTagMirrorLike(index, this.buildImageTagMirror(index));
  }
  
  public ImageTagMirrorsNested<A> editMatchingImageTagMirror(Predicate<ImageTagMirrorsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageTagMirrors.size();i++) {
      if (predicate.test(imageTagMirrors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageTagMirrors"));
    }
    return this.setNewImageTagMirrorLike(index, this.buildImageTagMirror(index));
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
    ImageTagMirrorSetSpecFluent that = (ImageTagMirrorSetSpecFluent) o;
    if (!(Objects.equals(imageTagMirrors, that.imageTagMirrors))) {
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
  
  public boolean hasImageTagMirrors() {
    return this.imageTagMirrors != null && !(this.imageTagMirrors.isEmpty());
  }
  
  public boolean hasMatchingImageTagMirror(Predicate<ImageTagMirrorsBuilder> predicate) {
      for (ImageTagMirrorsBuilder item : imageTagMirrors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(imageTagMirrors, additionalProperties);
  }
  
  public A removeAllFromImageTagMirrors(Collection<ImageTagMirrors> items) {
    if (this.imageTagMirrors == null) {
      return (A) this;
    }
    for (ImageTagMirrors item : items) {
        ImageTagMirrorsBuilder builder = new ImageTagMirrorsBuilder(item);
        _visitables.get("imageTagMirrors").remove(builder);
        this.imageTagMirrors.remove(builder);
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
  
  public A removeFromImageTagMirrors(ImageTagMirrors... items) {
    if (this.imageTagMirrors == null) {
      return (A) this;
    }
    for (ImageTagMirrors item : items) {
        ImageTagMirrorsBuilder builder = new ImageTagMirrorsBuilder(item);
        _visitables.get("imageTagMirrors").remove(builder);
        this.imageTagMirrors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromImageTagMirrors(Predicate<ImageTagMirrorsBuilder> predicate) {
    if (imageTagMirrors == null) {
      return (A) this;
    }
    Iterator<ImageTagMirrorsBuilder> each = imageTagMirrors.iterator();
    List visitables = _visitables.get("imageTagMirrors");
    while (each.hasNext()) {
        ImageTagMirrorsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ImageTagMirrorsNested<A> setNewImageTagMirrorLike(int index,ImageTagMirrors item) {
    return new ImageTagMirrorsNested(index, item);
  }
  
  public A setToImageTagMirrors(int index,ImageTagMirrors item) {
    if (this.imageTagMirrors == null) {
      this.imageTagMirrors = new ArrayList();
    }
    ImageTagMirrorsBuilder builder = new ImageTagMirrorsBuilder(item);
    if (index < 0 || index >= imageTagMirrors.size()) {
        _visitables.get("imageTagMirrors").add(builder);
        imageTagMirrors.add(builder);
    } else {
        _visitables.get("imageTagMirrors").add(builder);
        imageTagMirrors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(imageTagMirrors == null) && !(imageTagMirrors.isEmpty())) {
        sb.append("imageTagMirrors:");
        sb.append(imageTagMirrors);
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
  
  public A withImageTagMirrors(List<ImageTagMirrors> imageTagMirrors) {
    if (this.imageTagMirrors != null) {
      this._visitables.get("imageTagMirrors").clear();
    }
    if (imageTagMirrors != null) {
        this.imageTagMirrors = new ArrayList();
        for (ImageTagMirrors item : imageTagMirrors) {
          this.addToImageTagMirrors(item);
        }
    } else {
      this.imageTagMirrors = null;
    }
    return (A) this;
  }
  
  public A withImageTagMirrors(ImageTagMirrors... imageTagMirrors) {
    if (this.imageTagMirrors != null) {
        this.imageTagMirrors.clear();
        _visitables.remove("imageTagMirrors");
    }
    if (imageTagMirrors != null) {
      for (ImageTagMirrors item : imageTagMirrors) {
        this.addToImageTagMirrors(item);
      }
    }
    return (A) this;
  }
  public class ImageTagMirrorsNested<N> extends ImageTagMirrorsFluent<ImageTagMirrorsNested<N>> implements Nested<N>{
  
    ImageTagMirrorsBuilder builder;
    int index;
  
    ImageTagMirrorsNested(int index,ImageTagMirrors item) {
      this.index = index;
      this.builder = new ImageTagMirrorsBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageTagMirrorSetSpecFluent.this.setToImageTagMirrors(index, builder.build());
    }
    
    public N endImageTagMirror() {
      return and();
    }
    
  }
}