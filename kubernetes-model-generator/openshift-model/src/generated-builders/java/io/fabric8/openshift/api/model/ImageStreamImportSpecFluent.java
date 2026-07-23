package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class ImageStreamImportSpecFluent<A extends io.fabric8.openshift.api.model.ImageStreamImportSpecFluent<A>> extends BaseFluent<A>{

  private Boolean _import;
  private Map<String,Object> additionalProperties;
  private ArrayList<ImageImportSpecBuilder> images = new ArrayList<ImageImportSpecBuilder>();
  private RepositoryImportSpecBuilder repository;

  public ImageStreamImportSpecFluent() {
  }
  
  public ImageStreamImportSpecFluent(ImageStreamImportSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToImages(Collection<ImageImportSpec> items) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    for (ImageImportSpec item : items) {
        ImageImportSpecBuilder builder = new ImageImportSpecBuilder(item);
        _visitables.get("images").add(builder);
        this.images.add(builder);
    }
    return (A) this;
  }
  
  public ImagesNested<A> addNewImage() {
    return new ImagesNested(-1, null);
  }
  
  public ImagesNested<A> addNewImageLike(ImageImportSpec item) {
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
  
  public A addToImages(ImageImportSpec... items) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    for (ImageImportSpec item : items) {
        ImageImportSpecBuilder builder = new ImageImportSpecBuilder(item);
        _visitables.get("images").add(builder);
        this.images.add(builder);
    }
    return (A) this;
  }
  
  public A addToImages(int index,ImageImportSpec item) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    ImageImportSpecBuilder builder = new ImageImportSpecBuilder(item);
    if (index < 0 || index >= images.size()) {
        _visitables.get("images").add(builder);
        images.add(builder);
    } else {
        _visitables.get("images").add(builder);
        images.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageImportSpec buildFirstImage() {
    return this.images.get(0).build();
  }
  
  public ImageImportSpec buildImage(int index) {
    return this.images.get(index).build();
  }
  
  public List<ImageImportSpec> buildImages() {
    return this.images != null ? build(images) : null;
  }
  
  public ImageImportSpec buildLastImage() {
    return this.images.get(images.size() - 1).build();
  }
  
  public ImageImportSpec buildMatchingImage(Predicate<ImageImportSpecBuilder> predicate) {
      for (ImageImportSpecBuilder item : images) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RepositoryImportSpec buildRepository() {
    return this.repository != null ? this.repository.build() : null;
  }
  
  protected void copyInstance(ImageStreamImportSpec instance) {
    instance = instance != null ? instance : new ImageStreamImportSpec();
    if (instance != null) {
        this.withImages(instance.getImages());
        this.withImport(instance.getImport());
        this.withRepository(instance.getRepository());
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
  
  public ImagesNested<A> editMatchingImage(Predicate<ImageImportSpecBuilder> predicate) {
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
  
  public RepositoryNested<A> editOrNewRepository() {
    return this.withNewRepositoryLike(Optional.ofNullable(this.buildRepository()).orElse(new RepositoryImportSpecBuilder().build()));
  }
  
  public RepositoryNested<A> editOrNewRepositoryLike(RepositoryImportSpec item) {
    return this.withNewRepositoryLike(Optional.ofNullable(this.buildRepository()).orElse(item));
  }
  
  public RepositoryNested<A> editRepository() {
    return this.withNewRepositoryLike(Optional.ofNullable(this.buildRepository()).orElse(null));
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
    ImageStreamImportSpecFluent that = (ImageStreamImportSpecFluent) o;
    if (!(Objects.equals(images, that.images))) {
      return false;
    }
    if (!(Objects.equals(_import, that._import))) {
      return false;
    }
    if (!(Objects.equals(repository, that.repository))) {
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
  
  public Boolean getImport() {
    return this._import;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImages() {
    return this.images != null && !(this.images.isEmpty());
  }
  
  public boolean hasImport() {
    return this._import != null;
  }
  
  public boolean hasMatchingImage(Predicate<ImageImportSpecBuilder> predicate) {
      for (ImageImportSpecBuilder item : images) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRepository() {
    return this.repository != null;
  }
  
  public int hashCode() {
    return Objects.hash(images, _import, repository, additionalProperties);
  }
  
  public A removeAllFromImages(Collection<ImageImportSpec> items) {
    if (this.images == null) {
      return (A) this;
    }
    for (ImageImportSpec item : items) {
        ImageImportSpecBuilder builder = new ImageImportSpecBuilder(item);
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
  
  public A removeFromImages(ImageImportSpec... items) {
    if (this.images == null) {
      return (A) this;
    }
    for (ImageImportSpec item : items) {
        ImageImportSpecBuilder builder = new ImageImportSpecBuilder(item);
        _visitables.get("images").remove(builder);
        this.images.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromImages(Predicate<ImageImportSpecBuilder> predicate) {
    if (images == null) {
      return (A) this;
    }
    Iterator<ImageImportSpecBuilder> each = images.iterator();
    List visitables = _visitables.get("images");
    while (each.hasNext()) {
        ImageImportSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ImagesNested<A> setNewImageLike(int index,ImageImportSpec item) {
    return new ImagesNested(index, item);
  }
  
  public A setToImages(int index,ImageImportSpec item) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    ImageImportSpecBuilder builder = new ImageImportSpecBuilder(item);
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
    if (!(images == null) && !(images.isEmpty())) {
        sb.append("images:");
        sb.append(images);
        sb.append(",");
    }
    if (!(_import == null)) {
        sb.append("_import:");
        sb.append(_import);
        sb.append(",");
    }
    if (!(repository == null)) {
        sb.append("repository:");
        sb.append(repository);
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
  
  public A withImages(List<ImageImportSpec> images) {
    if (this.images != null) {
      this._visitables.get("images").clear();
    }
    if (images != null) {
        this.images = new ArrayList();
        for (ImageImportSpec item : images) {
          this.addToImages(item);
        }
    } else {
      this.images = null;
    }
    return (A) this;
  }
  
  public A withImages(ImageImportSpec... images) {
    if (this.images != null) {
        this.images.clear();
        _visitables.remove("images");
    }
    if (images != null) {
      for (ImageImportSpec item : images) {
        this.addToImages(item);
      }
    }
    return (A) this;
  }
  
  public A withImport() {
    return withImport(true);
  }
  
  public A withImport(Boolean _import) {
    this._import = _import;
    return (A) this;
  }
  
  public RepositoryNested<A> withNewRepository() {
    return new RepositoryNested(null);
  }
  
  public RepositoryNested<A> withNewRepositoryLike(RepositoryImportSpec item) {
    return new RepositoryNested(item);
  }
  
  public A withRepository(RepositoryImportSpec repository) {
    this._visitables.remove("repository");
    if (repository != null) {
        this.repository = new RepositoryImportSpecBuilder(repository);
        this._visitables.get("repository").add(this.repository);
    } else {
        this.repository = null;
        this._visitables.get("repository").remove(this.repository);
    }
    return (A) this;
  }
  public class ImagesNested<N> extends ImageImportSpecFluent<ImagesNested<N>> implements Nested<N>{
  
    ImageImportSpecBuilder builder;
    int index;
  
    ImagesNested(int index,ImageImportSpec item) {
      this.index = index;
      this.builder = new ImageImportSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamImportSpecFluent.this.setToImages(index, builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class RepositoryNested<N> extends RepositoryImportSpecFluent<RepositoryNested<N>> implements Nested<N>{
  
    RepositoryImportSpecBuilder builder;
  
    RepositoryNested(RepositoryImportSpec item) {
      this.builder = new RepositoryImportSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamImportSpecFluent.this.withRepository(builder.build());
    }
    
    public N endRepository() {
      return and();
    }
    
  }
}