package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Status;
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
public class RepositoryImportStatusFluent<A extends io.fabric8.openshift.api.model.RepositoryImportStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> additionalTags = new ArrayList<String>();
  private ArrayList<ImageImportStatusBuilder> images = new ArrayList<ImageImportStatusBuilder>();
  private Status status;

  public RepositoryImportStatusFluent() {
  }
  
  public RepositoryImportStatusFluent(RepositoryImportStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalTags(Collection<String> items) {
    if (this.additionalTags == null) {
      this.additionalTags = new ArrayList();
    }
    for (String item : items) {
      this.additionalTags.add(item);
    }
    return (A) this;
  }
  
  public A addAllToImages(Collection<ImageImportStatus> items) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    for (ImageImportStatus item : items) {
        ImageImportStatusBuilder builder = new ImageImportStatusBuilder(item);
        _visitables.get("images").add(builder);
        this.images.add(builder);
    }
    return (A) this;
  }
  
  public ImagesNested<A> addNewImage() {
    return new ImagesNested(-1, null);
  }
  
  public ImagesNested<A> addNewImageLike(ImageImportStatus item) {
    return new ImagesNested(-1, item);
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
  
  public A addToAdditionalTags(String... items) {
    if (this.additionalTags == null) {
      this.additionalTags = new ArrayList();
    }
    for (String item : items) {
      this.additionalTags.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalTags(int index,String item) {
    if (this.additionalTags == null) {
      this.additionalTags = new ArrayList();
    }
    this.additionalTags.add(index, item);
    return (A) this;
  }
  
  public A addToImages(ImageImportStatus... items) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    for (ImageImportStatus item : items) {
        ImageImportStatusBuilder builder = new ImageImportStatusBuilder(item);
        _visitables.get("images").add(builder);
        this.images.add(builder);
    }
    return (A) this;
  }
  
  public A addToImages(int index,ImageImportStatus item) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    ImageImportStatusBuilder builder = new ImageImportStatusBuilder(item);
    if (index < 0 || index >= images.size()) {
        _visitables.get("images").add(builder);
        images.add(builder);
    } else {
        _visitables.get("images").add(builder);
        images.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageImportStatus buildFirstImage() {
    return this.images.get(0).build();
  }
  
  public ImageImportStatus buildImage(int index) {
    return this.images.get(index).build();
  }
  
  public List<ImageImportStatus> buildImages() {
    return this.images != null ? build(images) : null;
  }
  
  public ImageImportStatus buildLastImage() {
    return this.images.get(images.size() - 1).build();
  }
  
  public ImageImportStatus buildMatchingImage(Predicate<ImageImportStatusBuilder> predicate) {
      for (ImageImportStatusBuilder item : images) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(RepositoryImportStatus instance) {
    instance = instance != null ? instance : new RepositoryImportStatus();
    if (instance != null) {
        this.withAdditionalTags(instance.getAdditionalTags());
        this.withImages(instance.getImages());
        this.withStatus(instance.getStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImagesNested<A> editFirstImage() {
    if (images.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "images"));
    }
    return this.setNewImageLike(0, this.buildImage(0));
  }
  
  public ImagesNested<A> editImage(int index) {
    if (images.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "images"));
    }
    return this.setNewImageLike(index, this.buildImage(index));
  }
  
  public ImagesNested<A> editLastImage() {
    int index = images.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "images"));
    }
    return this.setNewImageLike(index, this.buildImage(index));
  }
  
  public ImagesNested<A> editMatchingImage(Predicate<ImageImportStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < images.size();i++) {
      if (predicate.test(images.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "images"));
    }
    return this.setNewImageLike(index, this.buildImage(index));
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
    RepositoryImportStatusFluent that = (RepositoryImportStatusFluent) o;
    if (!(Objects.equals(additionalTags, that.additionalTags))) {
      return false;
    }
    if (!(Objects.equals(images, that.images))) {
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
  
  public String getAdditionalTag(int index) {
    return this.additionalTags.get(index);
  }
  
  public List<String> getAdditionalTags() {
    return this.additionalTags;
  }
  
  public String getFirstAdditionalTag() {
    return this.additionalTags.get(0);
  }
  
  public String getLastAdditionalTag() {
    return this.additionalTags.get(additionalTags.size() - 1);
  }
  
  public String getMatchingAdditionalTag(Predicate<String> predicate) {
      for (String item : additionalTags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Status getStatus() {
    return this.status;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalTags() {
    return this.additionalTags != null && !(this.additionalTags.isEmpty());
  }
  
  public boolean hasImages() {
    return this.images != null && !(this.images.isEmpty());
  }
  
  public boolean hasMatchingAdditionalTag(Predicate<String> predicate) {
      for (String item : additionalTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingImage(Predicate<ImageImportStatusBuilder> predicate) {
      for (ImageImportStatusBuilder item : images) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalTags, images, status, additionalProperties);
  }
  
  public A removeAllFromAdditionalTags(Collection<String> items) {
    if (this.additionalTags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalTags.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromImages(Collection<ImageImportStatus> items) {
    if (this.images == null) {
      return (A) this;
    }
    for (ImageImportStatus item : items) {
        ImageImportStatusBuilder builder = new ImageImportStatusBuilder(item);
        _visitables.get("images").remove(builder);
        this.images.remove(builder);
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
  
  public A removeFromAdditionalTags(String... items) {
    if (this.additionalTags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalTags.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromImages(ImageImportStatus... items) {
    if (this.images == null) {
      return (A) this;
    }
    for (ImageImportStatus item : items) {
        ImageImportStatusBuilder builder = new ImageImportStatusBuilder(item);
        _visitables.get("images").remove(builder);
        this.images.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromImages(Predicate<ImageImportStatusBuilder> predicate) {
    if (images == null) {
      return (A) this;
    }
    Iterator<ImageImportStatusBuilder> each = images.iterator();
    List visitables = _visitables.get("images");
    while (each.hasNext()) {
        ImageImportStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ImagesNested<A> setNewImageLike(int index,ImageImportStatus item) {
    return new ImagesNested(index, item);
  }
  
  public A setToAdditionalTags(int index,String item) {
    if (this.additionalTags == null) {
      this.additionalTags = new ArrayList();
    }
    this.additionalTags.set(index, item);
    return (A) this;
  }
  
  public A setToImages(int index,ImageImportStatus item) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    ImageImportStatusBuilder builder = new ImageImportStatusBuilder(item);
    if (index < 0 || index >= images.size()) {
        _visitables.get("images").add(builder);
        images.add(builder);
    } else {
        _visitables.get("images").add(builder);
        images.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalTags == null) && !(additionalTags.isEmpty())) {
        sb.append("additionalTags:");
        sb.append(additionalTags);
        sb.append(",");
    }
    if (!(images == null) && !(images.isEmpty())) {
        sb.append("images:");
        sb.append(images);
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
  
  public A withAdditionalTags(List<String> additionalTags) {
    if (additionalTags != null) {
        this.additionalTags = new ArrayList();
        for (String item : additionalTags) {
          this.addToAdditionalTags(item);
        }
    } else {
      this.additionalTags = null;
    }
    return (A) this;
  }
  
  public A withAdditionalTags(String... additionalTags) {
    if (this.additionalTags != null) {
        this.additionalTags.clear();
        _visitables.remove("additionalTags");
    }
    if (additionalTags != null) {
      for (String item : additionalTags) {
        this.addToAdditionalTags(item);
      }
    }
    return (A) this;
  }
  
  public A withImages(List<ImageImportStatus> images) {
    if (this.images != null) {
      this._visitables.get("images").clear();
    }
    if (images != null) {
        this.images = new ArrayList();
        for (ImageImportStatus item : images) {
          this.addToImages(item);
        }
    } else {
      this.images = null;
    }
    return (A) this;
  }
  
  public A withImages(ImageImportStatus... images) {
    if (this.images != null) {
        this.images.clear();
        _visitables.remove("images");
    }
    if (images != null) {
      for (ImageImportStatus item : images) {
        this.addToImages(item);
      }
    }
    return (A) this;
  }
  
  public A withStatus(Status status) {
    this.status = status;
    return (A) this;
  }
  public class ImagesNested<N> extends ImageImportStatusFluent<ImagesNested<N>> implements Nested<N>{
  
    ImageImportStatusBuilder builder;
    int index;
  
    ImagesNested(int index,ImageImportStatus item) {
      this.index = index;
      this.builder = new ImageImportStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) RepositoryImportStatusFluent.this.setToImages(index, builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
}