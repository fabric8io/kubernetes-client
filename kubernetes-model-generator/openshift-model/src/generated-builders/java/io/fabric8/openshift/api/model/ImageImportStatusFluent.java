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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ImageImportStatusFluent<A extends io.fabric8.openshift.api.model.ImageImportStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ImageBuilder image;
  private ArrayList<ImageBuilder> manifests = new ArrayList<ImageBuilder>();
  private Status status;
  private String tag;

  public ImageImportStatusFluent() {
  }
  
  public ImageImportStatusFluent(ImageImportStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToManifests(Collection<Image> items) {
    if (this.manifests == null) {
      this.manifests = new ArrayList();
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("manifests").add(builder);
        this.manifests.add(builder);
    }
    return (A) this;
  }
  
  public ManifestsNested<A> addNewManifest() {
    return new ManifestsNested(-1, null);
  }
  
  public ManifestsNested<A> addNewManifestLike(Image item) {
    return new ManifestsNested(-1, item);
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
  
  public A addToManifests(Image... items) {
    if (this.manifests == null) {
      this.manifests = new ArrayList();
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("manifests").add(builder);
        this.manifests.add(builder);
    }
    return (A) this;
  }
  
  public A addToManifests(int index,Image item) {
    if (this.manifests == null) {
      this.manifests = new ArrayList();
    }
    ImageBuilder builder = new ImageBuilder(item);
    if (index < 0 || index >= manifests.size()) {
        _visitables.get("manifests").add(builder);
        manifests.add(builder);
    } else {
        _visitables.get("manifests").add(builder);
        manifests.add(index, builder);
    }
    return (A) this;
  }
  
  public Image buildFirstManifest() {
    return this.manifests.get(0).build();
  }
  
  public Image buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  public Image buildLastManifest() {
    return this.manifests.get(manifests.size() - 1).build();
  }
  
  public Image buildManifest(int index) {
    return this.manifests.get(index).build();
  }
  
  public List<Image> buildManifests() {
    return this.manifests != null ? build(manifests) : null;
  }
  
  public Image buildMatchingManifest(Predicate<ImageBuilder> predicate) {
      for (ImageBuilder item : manifests) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ImageImportStatus instance) {
    instance = instance != null ? instance : new ImageImportStatus();
    if (instance != null) {
        this.withImage(instance.getImage());
        this.withManifests(instance.getManifests());
        this.withStatus(instance.getStatus());
        this.withTag(instance.getTag());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ManifestsNested<A> editFirstManifest() {
    if (manifests.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "manifests"));
    }
    return this.setNewManifestLike(0, this.buildManifest(0));
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public ManifestsNested<A> editLastManifest() {
    int index = manifests.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "manifests"));
    }
    return this.setNewManifestLike(index, this.buildManifest(index));
  }
  
  public ManifestsNested<A> editManifest(int index) {
    if (manifests.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "manifests"));
    }
    return this.setNewManifestLike(index, this.buildManifest(index));
  }
  
  public ManifestsNested<A> editMatchingManifest(Predicate<ImageBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < manifests.size();i++) {
      if (predicate.test(manifests.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "manifests"));
    }
    return this.setNewManifestLike(index, this.buildManifest(index));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new ImageBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(Image item) {
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
    ImageImportStatusFluent that = (ImageImportStatusFluent) o;
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(manifests, that.manifests))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(tag, that.tag))) {
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
  
  public Status getStatus() {
    return this.status;
  }
  
  public String getTag() {
    return this.tag;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasManifests() {
    return this.manifests != null && !(this.manifests.isEmpty());
  }
  
  public boolean hasMatchingManifest(Predicate<ImageBuilder> predicate) {
      for (ImageBuilder item : manifests) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasTag() {
    return this.tag != null;
  }
  
  public int hashCode() {
    return Objects.hash(image, manifests, status, tag, additionalProperties);
  }
  
  public A removeAllFromManifests(Collection<Image> items) {
    if (this.manifests == null) {
      return (A) this;
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("manifests").remove(builder);
        this.manifests.remove(builder);
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
  
  public A removeFromManifests(Image... items) {
    if (this.manifests == null) {
      return (A) this;
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("manifests").remove(builder);
        this.manifests.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromManifests(Predicate<ImageBuilder> predicate) {
    if (manifests == null) {
      return (A) this;
    }
    Iterator<ImageBuilder> each = manifests.iterator();
    List visitables = _visitables.get("manifests");
    while (each.hasNext()) {
        ImageBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ManifestsNested<A> setNewManifestLike(int index,Image item) {
    return new ManifestsNested(index, item);
  }
  
  public A setToManifests(int index,Image item) {
    if (this.manifests == null) {
      this.manifests = new ArrayList();
    }
    ImageBuilder builder = new ImageBuilder(item);
    if (index < 0 || index >= manifests.size()) {
        _visitables.get("manifests").add(builder);
        manifests.add(builder);
    } else {
        _visitables.get("manifests").add(builder);
        manifests.set(index, builder);
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
    if (!(manifests == null) && !(manifests.isEmpty())) {
        sb.append("manifests:");
        sb.append(manifests);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(tag == null)) {
        sb.append("tag:");
        sb.append(tag);
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
  
  public A withImage(Image image) {
    this._visitables.remove("image");
    if (image != null) {
        this.image = new ImageBuilder(image);
        this._visitables.get("image").add(this.image);
    } else {
        this.image = null;
        this._visitables.get("image").remove(this.image);
    }
    return (A) this;
  }
  
  public A withManifests(List<Image> manifests) {
    if (this.manifests != null) {
      this._visitables.get("manifests").clear();
    }
    if (manifests != null) {
        this.manifests = new ArrayList();
        for (Image item : manifests) {
          this.addToManifests(item);
        }
    } else {
      this.manifests = null;
    }
    return (A) this;
  }
  
  public A withManifests(Image... manifests) {
    if (this.manifests != null) {
        this.manifests.clear();
        _visitables.remove("manifests");
    }
    if (manifests != null) {
      for (Image item : manifests) {
        this.addToManifests(item);
      }
    }
    return (A) this;
  }
  
  public ImageNested<A> withNewImage() {
    return new ImageNested(null);
  }
  
  public ImageNested<A> withNewImageLike(Image item) {
    return new ImageNested(item);
  }
  
  public A withStatus(Status status) {
    this.status = status;
    return (A) this;
  }
  
  public A withTag(String tag) {
    this.tag = tag;
    return (A) this;
  }
  public class ImageNested<N> extends ImageFluent<ImageNested<N>> implements Nested<N>{
  
    ImageBuilder builder;
  
    ImageNested(Image item) {
      this.builder = new ImageBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageImportStatusFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class ManifestsNested<N> extends ImageFluent<ManifestsNested<N>> implements Nested<N>{
  
    ImageBuilder builder;
    int index;
  
    ManifestsNested(int index,Image item) {
      this.index = index;
      this.builder = new ImageBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageImportStatusFluent.this.setToManifests(index, builder.build());
    }
    
    public N endManifest() {
      return and();
    }
    
  }
}