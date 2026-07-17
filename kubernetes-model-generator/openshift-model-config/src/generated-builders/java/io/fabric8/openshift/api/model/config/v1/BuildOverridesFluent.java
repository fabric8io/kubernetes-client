package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Toleration;
import java.lang.Boolean;
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
public class BuildOverridesFluent<A extends io.fabric8.openshift.api.model.config.v1.BuildOverridesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean forcePull;
  private ArrayList<ImageLabelBuilder> imageLabels = new ArrayList<ImageLabelBuilder>();
  private Map<String,String> nodeSelector;
  private List<Toleration> tolerations = new ArrayList<Toleration>();

  public BuildOverridesFluent() {
  }
  
  public BuildOverridesFluent(BuildOverrides instance) {
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
  
  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
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
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
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
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.add(index, item);
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
  
  protected void copyInstance(BuildOverrides instance) {
    instance = instance != null ? instance : new BuildOverrides();
    if (instance != null) {
        this.withForcePull(instance.getForcePull());
        this.withImageLabels(instance.getImageLabels());
        this.withNodeSelector(instance.getNodeSelector());
        this.withTolerations(instance.getTolerations());
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
    BuildOverridesFluent that = (BuildOverridesFluent) o;
    if (!(Objects.equals(forcePull, that.forcePull))) {
      return false;
    }
    if (!(Objects.equals(imageLabels, that.imageLabels))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
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
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public Boolean getForcePull() {
    return this.forcePull;
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public Toleration getMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasForcePull() {
    return this.forcePull != null;
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
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(forcePull, imageLabels, nodeSelector, tolerations, additionalProperties);
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
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
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
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
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
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(forcePull == null)) {
        sb.append("forcePull:");
        sb.append(forcePull);
        sb.append(",");
    }
    if (!(imageLabels == null) && !(imageLabels.isEmpty())) {
        sb.append("imageLabels:");
        sb.append(imageLabels);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
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
  
  public A withForcePull() {
    return withForcePull(true);
  }
  
  public A withForcePull(Boolean forcePull) {
    this.forcePull = forcePull;
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
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
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
      return (N) BuildOverridesFluent.this.setToImageLabels(index, builder.build());
    }
    
    public N endImageLabel() {
      return and();
    }
    
  }
}