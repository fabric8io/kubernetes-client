package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
public class PinnedImageSetSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1alpha1.PinnedImageSetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PinnedImageRefBuilder> pinnedImages = new ArrayList<PinnedImageRefBuilder>();

  public PinnedImageSetSpecFluent() {
  }
  
  public PinnedImageSetSpecFluent(PinnedImageSetSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPinnedImages(Collection<PinnedImageRef> items) {
    if (this.pinnedImages == null) {
      this.pinnedImages = new ArrayList();
    }
    for (PinnedImageRef item : items) {
        PinnedImageRefBuilder builder = new PinnedImageRefBuilder(item);
        _visitables.get("pinnedImages").add(builder);
        this.pinnedImages.add(builder);
    }
    return (A) this;
  }
  
  public PinnedImagesNested<A> addNewPinnedImage() {
    return new PinnedImagesNested(-1, null);
  }
  
  public A addNewPinnedImage(String name) {
    return (A) this.addToPinnedImages(new PinnedImageRef(name));
  }
  
  public PinnedImagesNested<A> addNewPinnedImageLike(PinnedImageRef item) {
    return new PinnedImagesNested(-1, item);
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
  
  public A addToPinnedImages(PinnedImageRef... items) {
    if (this.pinnedImages == null) {
      this.pinnedImages = new ArrayList();
    }
    for (PinnedImageRef item : items) {
        PinnedImageRefBuilder builder = new PinnedImageRefBuilder(item);
        _visitables.get("pinnedImages").add(builder);
        this.pinnedImages.add(builder);
    }
    return (A) this;
  }
  
  public A addToPinnedImages(int index,PinnedImageRef item) {
    if (this.pinnedImages == null) {
      this.pinnedImages = new ArrayList();
    }
    PinnedImageRefBuilder builder = new PinnedImageRefBuilder(item);
    if (index < 0 || index >= pinnedImages.size()) {
        _visitables.get("pinnedImages").add(builder);
        pinnedImages.add(builder);
    } else {
        _visitables.get("pinnedImages").add(builder);
        pinnedImages.add(index, builder);
    }
    return (A) this;
  }
  
  public PinnedImageRef buildFirstPinnedImage() {
    return this.pinnedImages.get(0).build();
  }
  
  public PinnedImageRef buildLastPinnedImage() {
    return this.pinnedImages.get(pinnedImages.size() - 1).build();
  }
  
  public PinnedImageRef buildMatchingPinnedImage(Predicate<PinnedImageRefBuilder> predicate) {
      for (PinnedImageRefBuilder item : pinnedImages) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PinnedImageRef buildPinnedImage(int index) {
    return this.pinnedImages.get(index).build();
  }
  
  public List<PinnedImageRef> buildPinnedImages() {
    return this.pinnedImages != null ? build(pinnedImages) : null;
  }
  
  protected void copyInstance(PinnedImageSetSpec instance) {
    instance = instance != null ? instance : new PinnedImageSetSpec();
    if (instance != null) {
        this.withPinnedImages(instance.getPinnedImages());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PinnedImagesNested<A> editFirstPinnedImage() {
    if (pinnedImages.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pinnedImages"));
    }
    return this.setNewPinnedImageLike(0, this.buildPinnedImage(0));
  }
  
  public PinnedImagesNested<A> editLastPinnedImage() {
    int index = pinnedImages.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pinnedImages"));
    }
    return this.setNewPinnedImageLike(index, this.buildPinnedImage(index));
  }
  
  public PinnedImagesNested<A> editMatchingPinnedImage(Predicate<PinnedImageRefBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pinnedImages.size();i++) {
      if (predicate.test(pinnedImages.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pinnedImages"));
    }
    return this.setNewPinnedImageLike(index, this.buildPinnedImage(index));
  }
  
  public PinnedImagesNested<A> editPinnedImage(int index) {
    if (pinnedImages.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pinnedImages"));
    }
    return this.setNewPinnedImageLike(index, this.buildPinnedImage(index));
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
    PinnedImageSetSpecFluent that = (PinnedImageSetSpecFluent) o;
    if (!(Objects.equals(pinnedImages, that.pinnedImages))) {
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
  
  public boolean hasMatchingPinnedImage(Predicate<PinnedImageRefBuilder> predicate) {
      for (PinnedImageRefBuilder item : pinnedImages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPinnedImages() {
    return this.pinnedImages != null && !(this.pinnedImages.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(pinnedImages, additionalProperties);
  }
  
  public A removeAllFromPinnedImages(Collection<PinnedImageRef> items) {
    if (this.pinnedImages == null) {
      return (A) this;
    }
    for (PinnedImageRef item : items) {
        PinnedImageRefBuilder builder = new PinnedImageRefBuilder(item);
        _visitables.get("pinnedImages").remove(builder);
        this.pinnedImages.remove(builder);
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
  
  public A removeFromPinnedImages(PinnedImageRef... items) {
    if (this.pinnedImages == null) {
      return (A) this;
    }
    for (PinnedImageRef item : items) {
        PinnedImageRefBuilder builder = new PinnedImageRefBuilder(item);
        _visitables.get("pinnedImages").remove(builder);
        this.pinnedImages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPinnedImages(Predicate<PinnedImageRefBuilder> predicate) {
    if (pinnedImages == null) {
      return (A) this;
    }
    Iterator<PinnedImageRefBuilder> each = pinnedImages.iterator();
    List visitables = _visitables.get("pinnedImages");
    while (each.hasNext()) {
        PinnedImageRefBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PinnedImagesNested<A> setNewPinnedImageLike(int index,PinnedImageRef item) {
    return new PinnedImagesNested(index, item);
  }
  
  public A setToPinnedImages(int index,PinnedImageRef item) {
    if (this.pinnedImages == null) {
      this.pinnedImages = new ArrayList();
    }
    PinnedImageRefBuilder builder = new PinnedImageRefBuilder(item);
    if (index < 0 || index >= pinnedImages.size()) {
        _visitables.get("pinnedImages").add(builder);
        pinnedImages.add(builder);
    } else {
        _visitables.get("pinnedImages").add(builder);
        pinnedImages.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(pinnedImages == null) && !(pinnedImages.isEmpty())) {
        sb.append("pinnedImages:");
        sb.append(pinnedImages);
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
  
  public A withPinnedImages(List<PinnedImageRef> pinnedImages) {
    if (this.pinnedImages != null) {
      this._visitables.get("pinnedImages").clear();
    }
    if (pinnedImages != null) {
        this.pinnedImages = new ArrayList();
        for (PinnedImageRef item : pinnedImages) {
          this.addToPinnedImages(item);
        }
    } else {
      this.pinnedImages = null;
    }
    return (A) this;
  }
  
  public A withPinnedImages(PinnedImageRef... pinnedImages) {
    if (this.pinnedImages != null) {
        this.pinnedImages.clear();
        _visitables.remove("pinnedImages");
    }
    if (pinnedImages != null) {
      for (PinnedImageRef item : pinnedImages) {
        this.addToPinnedImages(item);
      }
    }
    return (A) this;
  }
  public class PinnedImagesNested<N> extends PinnedImageRefFluent<PinnedImagesNested<N>> implements Nested<N>{
  
    PinnedImageRefBuilder builder;
    int index;
  
    PinnedImagesNested(int index,PinnedImageRef item) {
      this.index = index;
      this.builder = new PinnedImageRefBuilder(this, item);
    }
  
    public N and() {
      return (N) PinnedImageSetSpecFluent.this.setToPinnedImages(index, builder.build());
    }
    
    public N endPinnedImage() {
      return and();
    }
    
  }
}