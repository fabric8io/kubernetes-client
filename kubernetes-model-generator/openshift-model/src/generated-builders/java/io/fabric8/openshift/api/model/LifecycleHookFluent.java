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
public class LifecycleHookFluent<A extends io.fabric8.openshift.api.model.LifecycleHookFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ExecNewPodHookBuilder execNewPod;
  private String failurePolicy;
  private ArrayList<TagImageHookBuilder> tagImages = new ArrayList<TagImageHookBuilder>();

  public LifecycleHookFluent() {
  }
  
  public LifecycleHookFluent(LifecycleHook instance) {
    this.copyInstance(instance);
  }

  public A addAllToTagImages(Collection<TagImageHook> items) {
    if (this.tagImages == null) {
      this.tagImages = new ArrayList();
    }
    for (TagImageHook item : items) {
        TagImageHookBuilder builder = new TagImageHookBuilder(item);
        _visitables.get("tagImages").add(builder);
        this.tagImages.add(builder);
    }
    return (A) this;
  }
  
  public TagImagesNested<A> addNewTagImage() {
    return new TagImagesNested(-1, null);
  }
  
  public TagImagesNested<A> addNewTagImageLike(TagImageHook item) {
    return new TagImagesNested(-1, item);
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
  
  public A addToTagImages(TagImageHook... items) {
    if (this.tagImages == null) {
      this.tagImages = new ArrayList();
    }
    for (TagImageHook item : items) {
        TagImageHookBuilder builder = new TagImageHookBuilder(item);
        _visitables.get("tagImages").add(builder);
        this.tagImages.add(builder);
    }
    return (A) this;
  }
  
  public A addToTagImages(int index,TagImageHook item) {
    if (this.tagImages == null) {
      this.tagImages = new ArrayList();
    }
    TagImageHookBuilder builder = new TagImageHookBuilder(item);
    if (index < 0 || index >= tagImages.size()) {
        _visitables.get("tagImages").add(builder);
        tagImages.add(builder);
    } else {
        _visitables.get("tagImages").add(builder);
        tagImages.add(index, builder);
    }
    return (A) this;
  }
  
  public ExecNewPodHook buildExecNewPod() {
    return this.execNewPod != null ? this.execNewPod.build() : null;
  }
  
  public TagImageHook buildFirstTagImage() {
    return this.tagImages.get(0).build();
  }
  
  public TagImageHook buildLastTagImage() {
    return this.tagImages.get(tagImages.size() - 1).build();
  }
  
  public TagImageHook buildMatchingTagImage(Predicate<TagImageHookBuilder> predicate) {
      for (TagImageHookBuilder item : tagImages) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TagImageHook buildTagImage(int index) {
    return this.tagImages.get(index).build();
  }
  
  public List<TagImageHook> buildTagImages() {
    return this.tagImages != null ? build(tagImages) : null;
  }
  
  protected void copyInstance(LifecycleHook instance) {
    instance = instance != null ? instance : new LifecycleHook();
    if (instance != null) {
        this.withExecNewPod(instance.getExecNewPod());
        this.withFailurePolicy(instance.getFailurePolicy());
        this.withTagImages(instance.getTagImages());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExecNewPodNested<A> editExecNewPod() {
    return this.withNewExecNewPodLike(Optional.ofNullable(this.buildExecNewPod()).orElse(null));
  }
  
  public TagImagesNested<A> editFirstTagImage() {
    if (tagImages.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tagImages"));
    }
    return this.setNewTagImageLike(0, this.buildTagImage(0));
  }
  
  public TagImagesNested<A> editLastTagImage() {
    int index = tagImages.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tagImages"));
    }
    return this.setNewTagImageLike(index, this.buildTagImage(index));
  }
  
  public TagImagesNested<A> editMatchingTagImage(Predicate<TagImageHookBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tagImages.size();i++) {
      if (predicate.test(tagImages.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tagImages"));
    }
    return this.setNewTagImageLike(index, this.buildTagImage(index));
  }
  
  public ExecNewPodNested<A> editOrNewExecNewPod() {
    return this.withNewExecNewPodLike(Optional.ofNullable(this.buildExecNewPod()).orElse(new ExecNewPodHookBuilder().build()));
  }
  
  public ExecNewPodNested<A> editOrNewExecNewPodLike(ExecNewPodHook item) {
    return this.withNewExecNewPodLike(Optional.ofNullable(this.buildExecNewPod()).orElse(item));
  }
  
  public TagImagesNested<A> editTagImage(int index) {
    if (tagImages.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tagImages"));
    }
    return this.setNewTagImageLike(index, this.buildTagImage(index));
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
    LifecycleHookFluent that = (LifecycleHookFluent) o;
    if (!(Objects.equals(execNewPod, that.execNewPod))) {
      return false;
    }
    if (!(Objects.equals(failurePolicy, that.failurePolicy))) {
      return false;
    }
    if (!(Objects.equals(tagImages, that.tagImages))) {
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
  
  public String getFailurePolicy() {
    return this.failurePolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExecNewPod() {
    return this.execNewPod != null;
  }
  
  public boolean hasFailurePolicy() {
    return this.failurePolicy != null;
  }
  
  public boolean hasMatchingTagImage(Predicate<TagImageHookBuilder> predicate) {
      for (TagImageHookBuilder item : tagImages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTagImages() {
    return this.tagImages != null && !(this.tagImages.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(execNewPod, failurePolicy, tagImages, additionalProperties);
  }
  
  public A removeAllFromTagImages(Collection<TagImageHook> items) {
    if (this.tagImages == null) {
      return (A) this;
    }
    for (TagImageHook item : items) {
        TagImageHookBuilder builder = new TagImageHookBuilder(item);
        _visitables.get("tagImages").remove(builder);
        this.tagImages.remove(builder);
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
  
  public A removeFromTagImages(TagImageHook... items) {
    if (this.tagImages == null) {
      return (A) this;
    }
    for (TagImageHook item : items) {
        TagImageHookBuilder builder = new TagImageHookBuilder(item);
        _visitables.get("tagImages").remove(builder);
        this.tagImages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTagImages(Predicate<TagImageHookBuilder> predicate) {
    if (tagImages == null) {
      return (A) this;
    }
    Iterator<TagImageHookBuilder> each = tagImages.iterator();
    List visitables = _visitables.get("tagImages");
    while (each.hasNext()) {
        TagImageHookBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TagImagesNested<A> setNewTagImageLike(int index,TagImageHook item) {
    return new TagImagesNested(index, item);
  }
  
  public A setToTagImages(int index,TagImageHook item) {
    if (this.tagImages == null) {
      this.tagImages = new ArrayList();
    }
    TagImageHookBuilder builder = new TagImageHookBuilder(item);
    if (index < 0 || index >= tagImages.size()) {
        _visitables.get("tagImages").add(builder);
        tagImages.add(builder);
    } else {
        _visitables.get("tagImages").add(builder);
        tagImages.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(execNewPod == null)) {
        sb.append("execNewPod:");
        sb.append(execNewPod);
        sb.append(",");
    }
    if (!(failurePolicy == null)) {
        sb.append("failurePolicy:");
        sb.append(failurePolicy);
        sb.append(",");
    }
    if (!(tagImages == null) && !(tagImages.isEmpty())) {
        sb.append("tagImages:");
        sb.append(tagImages);
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
  
  public A withExecNewPod(ExecNewPodHook execNewPod) {
    this._visitables.remove("execNewPod");
    if (execNewPod != null) {
        this.execNewPod = new ExecNewPodHookBuilder(execNewPod);
        this._visitables.get("execNewPod").add(this.execNewPod);
    } else {
        this.execNewPod = null;
        this._visitables.get("execNewPod").remove(this.execNewPod);
    }
    return (A) this;
  }
  
  public A withFailurePolicy(String failurePolicy) {
    this.failurePolicy = failurePolicy;
    return (A) this;
  }
  
  public ExecNewPodNested<A> withNewExecNewPod() {
    return new ExecNewPodNested(null);
  }
  
  public ExecNewPodNested<A> withNewExecNewPodLike(ExecNewPodHook item) {
    return new ExecNewPodNested(item);
  }
  
  public A withTagImages(List<TagImageHook> tagImages) {
    if (this.tagImages != null) {
      this._visitables.get("tagImages").clear();
    }
    if (tagImages != null) {
        this.tagImages = new ArrayList();
        for (TagImageHook item : tagImages) {
          this.addToTagImages(item);
        }
    } else {
      this.tagImages = null;
    }
    return (A) this;
  }
  
  public A withTagImages(TagImageHook... tagImages) {
    if (this.tagImages != null) {
        this.tagImages.clear();
        _visitables.remove("tagImages");
    }
    if (tagImages != null) {
      for (TagImageHook item : tagImages) {
        this.addToTagImages(item);
      }
    }
    return (A) this;
  }
  public class ExecNewPodNested<N> extends ExecNewPodHookFluent<ExecNewPodNested<N>> implements Nested<N>{
  
    ExecNewPodHookBuilder builder;
  
    ExecNewPodNested(ExecNewPodHook item) {
      this.builder = new ExecNewPodHookBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleHookFluent.this.withExecNewPod(builder.build());
    }
    
    public N endExecNewPod() {
      return and();
    }
    
  }
  public class TagImagesNested<N> extends TagImageHookFluent<TagImagesNested<N>> implements Nested<N>{
  
    TagImageHookBuilder builder;
    int index;
  
    TagImagesNested(int index,TagImageHook item) {
      this.index = index;
      this.builder = new TagImageHookBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleHookFluent.this.setToTagImages(index, builder.build());
    }
    
    public N endTagImage() {
      return and();
    }
    
  }
}