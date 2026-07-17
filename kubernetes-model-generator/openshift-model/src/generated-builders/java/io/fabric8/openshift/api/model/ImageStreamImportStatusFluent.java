package io.fabric8.openshift.api.model;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ImageStreamImportStatusFluent<A extends io.fabric8.openshift.api.model.ImageStreamImportStatusFluent<A>> extends BaseFluent<A>{

  private ImageStreamBuilder _import;
  private Map<String,Object> additionalProperties;
  private ArrayList<ImageImportStatusBuilder> images = new ArrayList<ImageImportStatusBuilder>();
  private RepositoryImportStatusBuilder repository;

  public ImageStreamImportStatusFluent() {
  }
  
  public ImageStreamImportStatusFluent(ImageStreamImportStatus instance) {
    this.copyInstance(instance);
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
  
  public ImageStream buildImport() {
    return this._import != null ? this._import.build() : null;
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
  
  public RepositoryImportStatus buildRepository() {
    return this.repository != null ? this.repository.build() : null;
  }
  
  protected void copyInstance(ImageStreamImportStatus instance) {
    instance = instance != null ? instance : new ImageStreamImportStatus();
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
  
  public ImportNested<A> editImport() {
    return this.withNewImportLike(Optional.ofNullable(this.buildImport()).orElse(null));
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
  
  public ImportNested<A> editOrNewImport() {
    return this.withNewImportLike(Optional.ofNullable(this.buildImport()).orElse(new ImageStreamBuilder().build()));
  }
  
  public ImportNested<A> editOrNewImportLike(ImageStream item) {
    return this.withNewImportLike(Optional.ofNullable(this.buildImport()).orElse(item));
  }
  
  public RepositoryNested<A> editOrNewRepository() {
    return this.withNewRepositoryLike(Optional.ofNullable(this.buildRepository()).orElse(new RepositoryImportStatusBuilder().build()));
  }
  
  public RepositoryNested<A> editOrNewRepositoryLike(RepositoryImportStatus item) {
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
    ImageStreamImportStatusFluent that = (ImageStreamImportStatusFluent) o;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImages() {
    return this.images != null && !(this.images.isEmpty());
  }
  
  public boolean hasImport() {
    return this._import != null;
  }
  
  public boolean hasMatchingImage(Predicate<ImageImportStatusBuilder> predicate) {
      for (ImageImportStatusBuilder item : images) {
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
  
  public A withImport(ImageStream _import) {
    this._visitables.remove("_import");
    if (_import != null) {
        this._import = new ImageStreamBuilder(_import);
        this._visitables.get("_import").add(this._import);
    } else {
        this._import = null;
        this._visitables.get("_import").remove(this._import);
    }
    return (A) this;
  }
  
  public ImportNested<A> withNewImport() {
    return new ImportNested(null);
  }
  
  public ImportNested<A> withNewImportLike(ImageStream item) {
    return new ImportNested(item);
  }
  
  public RepositoryNested<A> withNewRepository() {
    return new RepositoryNested(null);
  }
  
  public RepositoryNested<A> withNewRepositoryLike(RepositoryImportStatus item) {
    return new RepositoryNested(item);
  }
  
  public A withRepository(RepositoryImportStatus repository) {
    this._visitables.remove("repository");
    if (repository != null) {
        this.repository = new RepositoryImportStatusBuilder(repository);
        this._visitables.get("repository").add(this.repository);
    } else {
        this.repository = null;
        this._visitables.get("repository").remove(this.repository);
    }
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
      return (N) ImageStreamImportStatusFluent.this.setToImages(index, builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class ImportNested<N> extends ImageStreamFluent<ImportNested<N>> implements Nested<N>{
  
    ImageStreamBuilder builder;
  
    ImportNested(ImageStream item) {
      this.builder = new ImageStreamBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamImportStatusFluent.this.withImport(builder.build());
    }
    
    public N endImport() {
      return and();
    }
    
  }
  public class RepositoryNested<N> extends RepositoryImportStatusFluent<RepositoryNested<N>> implements Nested<N>{
  
    RepositoryImportStatusBuilder builder;
  
    RepositoryNested(RepositoryImportStatus item) {
      this.builder = new RepositoryImportStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamImportStatusFluent.this.withRepository(builder.build());
    }
    
    public N endRepository() {
      return and();
    }
    
  }
}