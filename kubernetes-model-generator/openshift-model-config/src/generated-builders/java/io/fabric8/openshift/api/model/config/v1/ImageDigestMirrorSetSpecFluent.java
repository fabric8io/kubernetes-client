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
public class ImageDigestMirrorSetSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.ImageDigestMirrorSetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ImageDigestMirrorsBuilder> imageDigestMirrors = new ArrayList<ImageDigestMirrorsBuilder>();

  public ImageDigestMirrorSetSpecFluent() {
  }
  
  public ImageDigestMirrorSetSpecFluent(ImageDigestMirrorSetSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToImageDigestMirrors(Collection<ImageDigestMirrors> items) {
    if (this.imageDigestMirrors == null) {
      this.imageDigestMirrors = new ArrayList();
    }
    for (ImageDigestMirrors item : items) {
        ImageDigestMirrorsBuilder builder = new ImageDigestMirrorsBuilder(item);
        _visitables.get("imageDigestMirrors").add(builder);
        this.imageDigestMirrors.add(builder);
    }
    return (A) this;
  }
  
  public ImageDigestMirrorsNested<A> addNewImageDigestMirror() {
    return new ImageDigestMirrorsNested(-1, null);
  }
  
  public ImageDigestMirrorsNested<A> addNewImageDigestMirrorLike(ImageDigestMirrors item) {
    return new ImageDigestMirrorsNested(-1, item);
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
  
  public A addToImageDigestMirrors(ImageDigestMirrors... items) {
    if (this.imageDigestMirrors == null) {
      this.imageDigestMirrors = new ArrayList();
    }
    for (ImageDigestMirrors item : items) {
        ImageDigestMirrorsBuilder builder = new ImageDigestMirrorsBuilder(item);
        _visitables.get("imageDigestMirrors").add(builder);
        this.imageDigestMirrors.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageDigestMirrors(int index,ImageDigestMirrors item) {
    if (this.imageDigestMirrors == null) {
      this.imageDigestMirrors = new ArrayList();
    }
    ImageDigestMirrorsBuilder builder = new ImageDigestMirrorsBuilder(item);
    if (index < 0 || index >= imageDigestMirrors.size()) {
        _visitables.get("imageDigestMirrors").add(builder);
        imageDigestMirrors.add(builder);
    } else {
        _visitables.get("imageDigestMirrors").add(builder);
        imageDigestMirrors.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageDigestMirrors buildFirstImageDigestMirror() {
    return this.imageDigestMirrors.get(0).build();
  }
  
  public ImageDigestMirrors buildImageDigestMirror(int index) {
    return this.imageDigestMirrors.get(index).build();
  }
  
  public List<ImageDigestMirrors> buildImageDigestMirrors() {
    return this.imageDigestMirrors != null ? build(imageDigestMirrors) : null;
  }
  
  public ImageDigestMirrors buildLastImageDigestMirror() {
    return this.imageDigestMirrors.get(imageDigestMirrors.size() - 1).build();
  }
  
  public ImageDigestMirrors buildMatchingImageDigestMirror(Predicate<ImageDigestMirrorsBuilder> predicate) {
      for (ImageDigestMirrorsBuilder item : imageDigestMirrors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ImageDigestMirrorSetSpec instance) {
    instance = instance != null ? instance : new ImageDigestMirrorSetSpec();
    if (instance != null) {
        this.withImageDigestMirrors(instance.getImageDigestMirrors());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageDigestMirrorsNested<A> editFirstImageDigestMirror() {
    if (imageDigestMirrors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageDigestMirrors"));
    }
    return this.setNewImageDigestMirrorLike(0, this.buildImageDigestMirror(0));
  }
  
  public ImageDigestMirrorsNested<A> editImageDigestMirror(int index) {
    if (imageDigestMirrors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageDigestMirrors"));
    }
    return this.setNewImageDigestMirrorLike(index, this.buildImageDigestMirror(index));
  }
  
  public ImageDigestMirrorsNested<A> editLastImageDigestMirror() {
    int index = imageDigestMirrors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageDigestMirrors"));
    }
    return this.setNewImageDigestMirrorLike(index, this.buildImageDigestMirror(index));
  }
  
  public ImageDigestMirrorsNested<A> editMatchingImageDigestMirror(Predicate<ImageDigestMirrorsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageDigestMirrors.size();i++) {
      if (predicate.test(imageDigestMirrors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageDigestMirrors"));
    }
    return this.setNewImageDigestMirrorLike(index, this.buildImageDigestMirror(index));
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
    ImageDigestMirrorSetSpecFluent that = (ImageDigestMirrorSetSpecFluent) o;
    if (!(Objects.equals(imageDigestMirrors, that.imageDigestMirrors))) {
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
  
  public boolean hasImageDigestMirrors() {
    return this.imageDigestMirrors != null && !(this.imageDigestMirrors.isEmpty());
  }
  
  public boolean hasMatchingImageDigestMirror(Predicate<ImageDigestMirrorsBuilder> predicate) {
      for (ImageDigestMirrorsBuilder item : imageDigestMirrors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(imageDigestMirrors, additionalProperties);
  }
  
  public A removeAllFromImageDigestMirrors(Collection<ImageDigestMirrors> items) {
    if (this.imageDigestMirrors == null) {
      return (A) this;
    }
    for (ImageDigestMirrors item : items) {
        ImageDigestMirrorsBuilder builder = new ImageDigestMirrorsBuilder(item);
        _visitables.get("imageDigestMirrors").remove(builder);
        this.imageDigestMirrors.remove(builder);
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
  
  public A removeFromImageDigestMirrors(ImageDigestMirrors... items) {
    if (this.imageDigestMirrors == null) {
      return (A) this;
    }
    for (ImageDigestMirrors item : items) {
        ImageDigestMirrorsBuilder builder = new ImageDigestMirrorsBuilder(item);
        _visitables.get("imageDigestMirrors").remove(builder);
        this.imageDigestMirrors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromImageDigestMirrors(Predicate<ImageDigestMirrorsBuilder> predicate) {
    if (imageDigestMirrors == null) {
      return (A) this;
    }
    Iterator<ImageDigestMirrorsBuilder> each = imageDigestMirrors.iterator();
    List visitables = _visitables.get("imageDigestMirrors");
    while (each.hasNext()) {
        ImageDigestMirrorsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ImageDigestMirrorsNested<A> setNewImageDigestMirrorLike(int index,ImageDigestMirrors item) {
    return new ImageDigestMirrorsNested(index, item);
  }
  
  public A setToImageDigestMirrors(int index,ImageDigestMirrors item) {
    if (this.imageDigestMirrors == null) {
      this.imageDigestMirrors = new ArrayList();
    }
    ImageDigestMirrorsBuilder builder = new ImageDigestMirrorsBuilder(item);
    if (index < 0 || index >= imageDigestMirrors.size()) {
        _visitables.get("imageDigestMirrors").add(builder);
        imageDigestMirrors.add(builder);
    } else {
        _visitables.get("imageDigestMirrors").add(builder);
        imageDigestMirrors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(imageDigestMirrors == null) && !(imageDigestMirrors.isEmpty())) {
        sb.append("imageDigestMirrors:");
        sb.append(imageDigestMirrors);
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
  
  public A withImageDigestMirrors(List<ImageDigestMirrors> imageDigestMirrors) {
    if (this.imageDigestMirrors != null) {
      this._visitables.get("imageDigestMirrors").clear();
    }
    if (imageDigestMirrors != null) {
        this.imageDigestMirrors = new ArrayList();
        for (ImageDigestMirrors item : imageDigestMirrors) {
          this.addToImageDigestMirrors(item);
        }
    } else {
      this.imageDigestMirrors = null;
    }
    return (A) this;
  }
  
  public A withImageDigestMirrors(ImageDigestMirrors... imageDigestMirrors) {
    if (this.imageDigestMirrors != null) {
        this.imageDigestMirrors.clear();
        _visitables.remove("imageDigestMirrors");
    }
    if (imageDigestMirrors != null) {
      for (ImageDigestMirrors item : imageDigestMirrors) {
        this.addToImageDigestMirrors(item);
      }
    }
    return (A) this;
  }
  public class ImageDigestMirrorsNested<N> extends ImageDigestMirrorsFluent<ImageDigestMirrorsNested<N>> implements Nested<N>{
  
    ImageDigestMirrorsBuilder builder;
    int index;
  
    ImageDigestMirrorsNested(int index,ImageDigestMirrors item) {
      this.index = index;
      this.builder = new ImageDigestMirrorsBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageDigestMirrorSetSpecFluent.this.setToImageDigestMirrors(index, builder.build());
    }
    
    public N endImageDigestMirror() {
      return and();
    }
    
  }
}