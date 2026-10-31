package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class DynamicHostAllocationSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.DynamicHostAllocationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<TagSpecificationBuilder> tags = new ArrayList<TagSpecificationBuilder>();

  public DynamicHostAllocationSpecFluent() {
  }
  
  public DynamicHostAllocationSpecFluent(DynamicHostAllocationSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTags(Collection<TagSpecification> items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (TagSpecification item : items) {
        TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
        _visitables.get("tags").add(builder);
        this.tags.add(builder);
    }
    return (A) this;
  }
  
  public TagsNested<A> addNewTag() {
    return new TagsNested(-1, null);
  }
  
  public A addNewTag(String name,String value) {
    return (A) this.addToTags(new TagSpecification(name, value));
  }
  
  public TagsNested<A> addNewTagLike(TagSpecification item) {
    return new TagsNested(-1, item);
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
  
  public A addToTags(TagSpecification... items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (TagSpecification item : items) {
        TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
        _visitables.get("tags").add(builder);
        this.tags.add(builder);
    }
    return (A) this;
  }
  
  public A addToTags(int index,TagSpecification item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
    if (index < 0 || index >= tags.size()) {
        _visitables.get("tags").add(builder);
        tags.add(builder);
    } else {
        _visitables.get("tags").add(builder);
        tags.add(index, builder);
    }
    return (A) this;
  }
  
  public TagSpecification buildFirstTag() {
    return this.tags.get(0).build();
  }
  
  public TagSpecification buildLastTag() {
    return this.tags.get(tags.size() - 1).build();
  }
  
  public TagSpecification buildMatchingTag(Predicate<TagSpecificationBuilder> predicate) {
      for (TagSpecificationBuilder item : tags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TagSpecification buildTag(int index) {
    return this.tags.get(index).build();
  }
  
  public List<TagSpecification> buildTags() {
    return this.tags != null ? build(tags) : null;
  }
  
  protected void copyInstance(DynamicHostAllocationSpec instance) {
    instance = instance != null ? instance : new DynamicHostAllocationSpec();
    if (instance != null) {
        this.withTags(instance.getTags());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TagsNested<A> editFirstTag() {
    if (tags.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tags"));
    }
    return this.setNewTagLike(0, this.buildTag(0));
  }
  
  public TagsNested<A> editLastTag() {
    int index = tags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tags"));
    }
    return this.setNewTagLike(index, this.buildTag(index));
  }
  
  public TagsNested<A> editMatchingTag(Predicate<TagSpecificationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tags.size();i++) {
      if (predicate.test(tags.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tags"));
    }
    return this.setNewTagLike(index, this.buildTag(index));
  }
  
  public TagsNested<A> editTag(int index) {
    if (tags.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tags"));
    }
    return this.setNewTagLike(index, this.buildTag(index));
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
    DynamicHostAllocationSpecFluent that = (DynamicHostAllocationSpecFluent) o;
    if (!(Objects.equals(tags, that.tags))) {
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
  
  public boolean hasMatchingTag(Predicate<TagSpecificationBuilder> predicate) {
      for (TagSpecificationBuilder item : tags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTags() {
    return this.tags != null && !(this.tags.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(tags, additionalProperties);
  }
  
  public A removeAllFromTags(Collection<TagSpecification> items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (TagSpecification item : items) {
        TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
        _visitables.get("tags").remove(builder);
        this.tags.remove(builder);
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
  
  public A removeFromTags(TagSpecification... items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (TagSpecification item : items) {
        TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
        _visitables.get("tags").remove(builder);
        this.tags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTags(Predicate<TagSpecificationBuilder> predicate) {
    if (tags == null) {
      return (A) this;
    }
    Iterator<TagSpecificationBuilder> each = tags.iterator();
    List visitables = _visitables.get("tags");
    while (each.hasNext()) {
        TagSpecificationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TagsNested<A> setNewTagLike(int index,TagSpecification item) {
    return new TagsNested(index, item);
  }
  
  public A setToTags(int index,TagSpecification item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    TagSpecificationBuilder builder = new TagSpecificationBuilder(item);
    if (index < 0 || index >= tags.size()) {
        _visitables.get("tags").add(builder);
        tags.add(builder);
    } else {
        _visitables.get("tags").add(builder);
        tags.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
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
  
  public A withTags(List<TagSpecification> tags) {
    if (this.tags != null) {
      this._visitables.get("tags").clear();
    }
    if (tags != null) {
        this.tags = new ArrayList();
        for (TagSpecification item : tags) {
          this.addToTags(item);
        }
    } else {
      this.tags = null;
    }
    return (A) this;
  }
  
  public A withTags(TagSpecification... tags) {
    if (this.tags != null) {
        this.tags.clear();
        _visitables.remove("tags");
    }
    if (tags != null) {
      for (TagSpecification item : tags) {
        this.addToTags(item);
      }
    }
    return (A) this;
  }
  public class TagsNested<N> extends TagSpecificationFluent<TagsNested<N>> implements Nested<N>{
  
    TagSpecificationBuilder builder;
    int index;
  
    TagsNested(int index,TagSpecification item) {
      this.index = index;
      this.builder = new TagSpecificationBuilder(this, item);
    }
  
    public N and() {
      return (N) DynamicHostAllocationSpecFluent.this.setToTags(index, builder.build());
    }
    
    public N endTag() {
      return and();
    }
    
  }
}