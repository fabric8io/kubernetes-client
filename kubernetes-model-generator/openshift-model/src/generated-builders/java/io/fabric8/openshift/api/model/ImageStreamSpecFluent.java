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
public class ImageStreamSpecFluent<A extends io.fabric8.openshift.api.model.ImageStreamSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String dockerImageRepository;
  private ImageLookupPolicyBuilder lookupPolicy;
  private ArrayList<TagReferenceBuilder> tags = new ArrayList<TagReferenceBuilder>();

  public ImageStreamSpecFluent() {
  }
  
  public ImageStreamSpecFluent(ImageStreamSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTags(Collection<TagReference> items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (TagReference item : items) {
        TagReferenceBuilder builder = new TagReferenceBuilder(item);
        _visitables.get("tags").add(builder);
        this.tags.add(builder);
    }
    return (A) this;
  }
  
  public TagsNested<A> addNewTag() {
    return new TagsNested(-1, null);
  }
  
  public TagsNested<A> addNewTagLike(TagReference item) {
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
  
  public A addToTags(TagReference... items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (TagReference item : items) {
        TagReferenceBuilder builder = new TagReferenceBuilder(item);
        _visitables.get("tags").add(builder);
        this.tags.add(builder);
    }
    return (A) this;
  }
  
  public A addToTags(int index,TagReference item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    TagReferenceBuilder builder = new TagReferenceBuilder(item);
    if (index < 0 || index >= tags.size()) {
        _visitables.get("tags").add(builder);
        tags.add(builder);
    } else {
        _visitables.get("tags").add(builder);
        tags.add(index, builder);
    }
    return (A) this;
  }
  
  public TagReference buildFirstTag() {
    return this.tags.get(0).build();
  }
  
  public TagReference buildLastTag() {
    return this.tags.get(tags.size() - 1).build();
  }
  
  public ImageLookupPolicy buildLookupPolicy() {
    return this.lookupPolicy != null ? this.lookupPolicy.build() : null;
  }
  
  public TagReference buildMatchingTag(Predicate<TagReferenceBuilder> predicate) {
      for (TagReferenceBuilder item : tags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TagReference buildTag(int index) {
    return this.tags.get(index).build();
  }
  
  public List<TagReference> buildTags() {
    return this.tags != null ? build(tags) : null;
  }
  
  protected void copyInstance(ImageStreamSpec instance) {
    instance = instance != null ? instance : new ImageStreamSpec();
    if (instance != null) {
        this.withDockerImageRepository(instance.getDockerImageRepository());
        this.withLookupPolicy(instance.getLookupPolicy());
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
  
  public LookupPolicyNested<A> editLookupPolicy() {
    return this.withNewLookupPolicyLike(Optional.ofNullable(this.buildLookupPolicy()).orElse(null));
  }
  
  public TagsNested<A> editMatchingTag(Predicate<TagReferenceBuilder> predicate) {
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
  
  public LookupPolicyNested<A> editOrNewLookupPolicy() {
    return this.withNewLookupPolicyLike(Optional.ofNullable(this.buildLookupPolicy()).orElse(new ImageLookupPolicyBuilder().build()));
  }
  
  public LookupPolicyNested<A> editOrNewLookupPolicyLike(ImageLookupPolicy item) {
    return this.withNewLookupPolicyLike(Optional.ofNullable(this.buildLookupPolicy()).orElse(item));
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
    ImageStreamSpecFluent that = (ImageStreamSpecFluent) o;
    if (!(Objects.equals(dockerImageRepository, that.dockerImageRepository))) {
      return false;
    }
    if (!(Objects.equals(lookupPolicy, that.lookupPolicy))) {
      return false;
    }
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
  
  public String getDockerImageRepository() {
    return this.dockerImageRepository;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDockerImageRepository() {
    return this.dockerImageRepository != null;
  }
  
  public boolean hasLookupPolicy() {
    return this.lookupPolicy != null;
  }
  
  public boolean hasMatchingTag(Predicate<TagReferenceBuilder> predicate) {
      for (TagReferenceBuilder item : tags) {
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
    return Objects.hash(dockerImageRepository, lookupPolicy, tags, additionalProperties);
  }
  
  public A removeAllFromTags(Collection<TagReference> items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (TagReference item : items) {
        TagReferenceBuilder builder = new TagReferenceBuilder(item);
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
  
  public A removeFromTags(TagReference... items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (TagReference item : items) {
        TagReferenceBuilder builder = new TagReferenceBuilder(item);
        _visitables.get("tags").remove(builder);
        this.tags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTags(Predicate<TagReferenceBuilder> predicate) {
    if (tags == null) {
      return (A) this;
    }
    Iterator<TagReferenceBuilder> each = tags.iterator();
    List visitables = _visitables.get("tags");
    while (each.hasNext()) {
        TagReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TagsNested<A> setNewTagLike(int index,TagReference item) {
    return new TagsNested(index, item);
  }
  
  public A setToTags(int index,TagReference item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    TagReferenceBuilder builder = new TagReferenceBuilder(item);
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
    if (!(dockerImageRepository == null)) {
        sb.append("dockerImageRepository:");
        sb.append(dockerImageRepository);
        sb.append(",");
    }
    if (!(lookupPolicy == null)) {
        sb.append("lookupPolicy:");
        sb.append(lookupPolicy);
        sb.append(",");
    }
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
  
  public A withDockerImageRepository(String dockerImageRepository) {
    this.dockerImageRepository = dockerImageRepository;
    return (A) this;
  }
  
  public A withLookupPolicy(ImageLookupPolicy lookupPolicy) {
    this._visitables.remove("lookupPolicy");
    if (lookupPolicy != null) {
        this.lookupPolicy = new ImageLookupPolicyBuilder(lookupPolicy);
        this._visitables.get("lookupPolicy").add(this.lookupPolicy);
    } else {
        this.lookupPolicy = null;
        this._visitables.get("lookupPolicy").remove(this.lookupPolicy);
    }
    return (A) this;
  }
  
  public LookupPolicyNested<A> withNewLookupPolicy() {
    return new LookupPolicyNested(null);
  }
  
  public A withNewLookupPolicy(Boolean local) {
    return (A) this.withLookupPolicy(new ImageLookupPolicy(local));
  }
  
  public LookupPolicyNested<A> withNewLookupPolicyLike(ImageLookupPolicy item) {
    return new LookupPolicyNested(item);
  }
  
  public A withTags(List<TagReference> tags) {
    if (this.tags != null) {
      this._visitables.get("tags").clear();
    }
    if (tags != null) {
        this.tags = new ArrayList();
        for (TagReference item : tags) {
          this.addToTags(item);
        }
    } else {
      this.tags = null;
    }
    return (A) this;
  }
  
  public A withTags(TagReference... tags) {
    if (this.tags != null) {
        this.tags.clear();
        _visitables.remove("tags");
    }
    if (tags != null) {
      for (TagReference item : tags) {
        this.addToTags(item);
      }
    }
    return (A) this;
  }
  public class LookupPolicyNested<N> extends ImageLookupPolicyFluent<LookupPolicyNested<N>> implements Nested<N>{
  
    ImageLookupPolicyBuilder builder;
  
    LookupPolicyNested(ImageLookupPolicy item) {
      this.builder = new ImageLookupPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamSpecFluent.this.withLookupPolicy(builder.build());
    }
    
    public N endLookupPolicy() {
      return and();
    }
    
  }
  public class TagsNested<N> extends TagReferenceFluent<TagsNested<N>> implements Nested<N>{
  
    TagReferenceBuilder builder;
    int index;
  
    TagsNested(int index,TagReference item) {
      this.index = index;
      this.builder = new TagReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamSpecFluent.this.setToTags(index, builder.build());
    }
    
    public N endTag() {
      return and();
    }
    
  }
}