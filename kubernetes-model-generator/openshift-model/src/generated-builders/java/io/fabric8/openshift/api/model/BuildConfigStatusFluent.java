package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class BuildConfigStatusFluent<A extends io.fabric8.openshift.api.model.BuildConfigStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ImageChangeTriggerStatusBuilder> imageChangeTriggers = new ArrayList<ImageChangeTriggerStatusBuilder>();
  private Long lastVersion;

  public BuildConfigStatusFluent() {
  }
  
  public BuildConfigStatusFluent(BuildConfigStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToImageChangeTriggers(Collection<ImageChangeTriggerStatus> items) {
    if (this.imageChangeTriggers == null) {
      this.imageChangeTriggers = new ArrayList();
    }
    for (ImageChangeTriggerStatus item : items) {
        ImageChangeTriggerStatusBuilder builder = new ImageChangeTriggerStatusBuilder(item);
        _visitables.get("imageChangeTriggers").add(builder);
        this.imageChangeTriggers.add(builder);
    }
    return (A) this;
  }
  
  public ImageChangeTriggersNested<A> addNewImageChangeTrigger() {
    return new ImageChangeTriggersNested(-1, null);
  }
  
  public ImageChangeTriggersNested<A> addNewImageChangeTriggerLike(ImageChangeTriggerStatus item) {
    return new ImageChangeTriggersNested(-1, item);
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
  
  public A addToImageChangeTriggers(ImageChangeTriggerStatus... items) {
    if (this.imageChangeTriggers == null) {
      this.imageChangeTriggers = new ArrayList();
    }
    for (ImageChangeTriggerStatus item : items) {
        ImageChangeTriggerStatusBuilder builder = new ImageChangeTriggerStatusBuilder(item);
        _visitables.get("imageChangeTriggers").add(builder);
        this.imageChangeTriggers.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageChangeTriggers(int index,ImageChangeTriggerStatus item) {
    if (this.imageChangeTriggers == null) {
      this.imageChangeTriggers = new ArrayList();
    }
    ImageChangeTriggerStatusBuilder builder = new ImageChangeTriggerStatusBuilder(item);
    if (index < 0 || index >= imageChangeTriggers.size()) {
        _visitables.get("imageChangeTriggers").add(builder);
        imageChangeTriggers.add(builder);
    } else {
        _visitables.get("imageChangeTriggers").add(builder);
        imageChangeTriggers.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageChangeTriggerStatus buildFirstImageChangeTrigger() {
    return this.imageChangeTriggers.get(0).build();
  }
  
  public ImageChangeTriggerStatus buildImageChangeTrigger(int index) {
    return this.imageChangeTriggers.get(index).build();
  }
  
  public List<ImageChangeTriggerStatus> buildImageChangeTriggers() {
    return this.imageChangeTriggers != null ? build(imageChangeTriggers) : null;
  }
  
  public ImageChangeTriggerStatus buildLastImageChangeTrigger() {
    return this.imageChangeTriggers.get(imageChangeTriggers.size() - 1).build();
  }
  
  public ImageChangeTriggerStatus buildMatchingImageChangeTrigger(Predicate<ImageChangeTriggerStatusBuilder> predicate) {
      for (ImageChangeTriggerStatusBuilder item : imageChangeTriggers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(BuildConfigStatus instance) {
    instance = instance != null ? instance : new BuildConfigStatus();
    if (instance != null) {
        this.withImageChangeTriggers(instance.getImageChangeTriggers());
        this.withLastVersion(instance.getLastVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageChangeTriggersNested<A> editFirstImageChangeTrigger() {
    if (imageChangeTriggers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageChangeTriggers"));
    }
    return this.setNewImageChangeTriggerLike(0, this.buildImageChangeTrigger(0));
  }
  
  public ImageChangeTriggersNested<A> editImageChangeTrigger(int index) {
    if (imageChangeTriggers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageChangeTriggers"));
    }
    return this.setNewImageChangeTriggerLike(index, this.buildImageChangeTrigger(index));
  }
  
  public ImageChangeTriggersNested<A> editLastImageChangeTrigger() {
    int index = imageChangeTriggers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageChangeTriggers"));
    }
    return this.setNewImageChangeTriggerLike(index, this.buildImageChangeTrigger(index));
  }
  
  public ImageChangeTriggersNested<A> editMatchingImageChangeTrigger(Predicate<ImageChangeTriggerStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageChangeTriggers.size();i++) {
      if (predicate.test(imageChangeTriggers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageChangeTriggers"));
    }
    return this.setNewImageChangeTriggerLike(index, this.buildImageChangeTrigger(index));
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
    BuildConfigStatusFluent that = (BuildConfigStatusFluent) o;
    if (!(Objects.equals(imageChangeTriggers, that.imageChangeTriggers))) {
      return false;
    }
    if (!(Objects.equals(lastVersion, that.lastVersion))) {
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
  
  public Long getLastVersion() {
    return this.lastVersion;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImageChangeTriggers() {
    return this.imageChangeTriggers != null && !(this.imageChangeTriggers.isEmpty());
  }
  
  public boolean hasLastVersion() {
    return this.lastVersion != null;
  }
  
  public boolean hasMatchingImageChangeTrigger(Predicate<ImageChangeTriggerStatusBuilder> predicate) {
      for (ImageChangeTriggerStatusBuilder item : imageChangeTriggers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(imageChangeTriggers, lastVersion, additionalProperties);
  }
  
  public A removeAllFromImageChangeTriggers(Collection<ImageChangeTriggerStatus> items) {
    if (this.imageChangeTriggers == null) {
      return (A) this;
    }
    for (ImageChangeTriggerStatus item : items) {
        ImageChangeTriggerStatusBuilder builder = new ImageChangeTriggerStatusBuilder(item);
        _visitables.get("imageChangeTriggers").remove(builder);
        this.imageChangeTriggers.remove(builder);
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
  
  public A removeFromImageChangeTriggers(ImageChangeTriggerStatus... items) {
    if (this.imageChangeTriggers == null) {
      return (A) this;
    }
    for (ImageChangeTriggerStatus item : items) {
        ImageChangeTriggerStatusBuilder builder = new ImageChangeTriggerStatusBuilder(item);
        _visitables.get("imageChangeTriggers").remove(builder);
        this.imageChangeTriggers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromImageChangeTriggers(Predicate<ImageChangeTriggerStatusBuilder> predicate) {
    if (imageChangeTriggers == null) {
      return (A) this;
    }
    Iterator<ImageChangeTriggerStatusBuilder> each = imageChangeTriggers.iterator();
    List visitables = _visitables.get("imageChangeTriggers");
    while (each.hasNext()) {
        ImageChangeTriggerStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ImageChangeTriggersNested<A> setNewImageChangeTriggerLike(int index,ImageChangeTriggerStatus item) {
    return new ImageChangeTriggersNested(index, item);
  }
  
  public A setToImageChangeTriggers(int index,ImageChangeTriggerStatus item) {
    if (this.imageChangeTriggers == null) {
      this.imageChangeTriggers = new ArrayList();
    }
    ImageChangeTriggerStatusBuilder builder = new ImageChangeTriggerStatusBuilder(item);
    if (index < 0 || index >= imageChangeTriggers.size()) {
        _visitables.get("imageChangeTriggers").add(builder);
        imageChangeTriggers.add(builder);
    } else {
        _visitables.get("imageChangeTriggers").add(builder);
        imageChangeTriggers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(imageChangeTriggers == null) && !(imageChangeTriggers.isEmpty())) {
        sb.append("imageChangeTriggers:");
        sb.append(imageChangeTriggers);
        sb.append(",");
    }
    if (!(lastVersion == null)) {
        sb.append("lastVersion:");
        sb.append(lastVersion);
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
  
  public A withImageChangeTriggers(List<ImageChangeTriggerStatus> imageChangeTriggers) {
    if (this.imageChangeTriggers != null) {
      this._visitables.get("imageChangeTriggers").clear();
    }
    if (imageChangeTriggers != null) {
        this.imageChangeTriggers = new ArrayList();
        for (ImageChangeTriggerStatus item : imageChangeTriggers) {
          this.addToImageChangeTriggers(item);
        }
    } else {
      this.imageChangeTriggers = null;
    }
    return (A) this;
  }
  
  public A withImageChangeTriggers(ImageChangeTriggerStatus... imageChangeTriggers) {
    if (this.imageChangeTriggers != null) {
        this.imageChangeTriggers.clear();
        _visitables.remove("imageChangeTriggers");
    }
    if (imageChangeTriggers != null) {
      for (ImageChangeTriggerStatus item : imageChangeTriggers) {
        this.addToImageChangeTriggers(item);
      }
    }
    return (A) this;
  }
  
  public A withLastVersion(Long lastVersion) {
    this.lastVersion = lastVersion;
    return (A) this;
  }
  public class ImageChangeTriggersNested<N> extends ImageChangeTriggerStatusFluent<ImageChangeTriggersNested<N>> implements Nested<N>{
  
    ImageChangeTriggerStatusBuilder builder;
    int index;
  
    ImageChangeTriggersNested(int index,ImageChangeTriggerStatus item) {
      this.index = index;
      this.builder = new ImageChangeTriggerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildConfigStatusFluent.this.setToImageChangeTriggers(index, builder.build());
    }
    
    public N endImageChangeTrigger() {
      return and();
    }
    
  }
}