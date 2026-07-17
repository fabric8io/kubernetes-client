package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ImageStreamTagFluent<A extends io.fabric8.openshift.api.model.ImageStreamTagFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private ArrayList<TagEventConditionBuilder> conditions = new ArrayList<TagEventConditionBuilder>();
  private Long generation;
  private ImageBuilder image;
  private String kind;
  private ImageLookupPolicyBuilder lookupPolicy;
  private ObjectMetaBuilder metadata;
  private TagReferenceBuilder tag;

  public ImageStreamTagFluent() {
  }
  
  public ImageStreamTagFluent(ImageStreamTag instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<TagEventCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (TagEventCondition item : items) {
        TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(TagEventCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(TagEventCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (TagEventCondition item : items) {
        TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,TagEventCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public TagEventCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<TagEventCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public TagEventCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public Image buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  public TagEventCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ImageLookupPolicy buildLookupPolicy() {
    return this.lookupPolicy != null ? this.lookupPolicy.build() : null;
  }
  
  public TagEventCondition buildMatchingCondition(Predicate<TagEventConditionBuilder> predicate) {
      for (TagEventConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public TagReference buildTag() {
    return this.tag != null ? this.tag.build() : null;
  }
  
  protected void copyInstance(ImageStreamTag instance) {
    instance = instance != null ? instance : new ImageStreamTag();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withConditions(instance.getConditions());
        this.withGeneration(instance.getGeneration());
        this.withImage(instance.getImage());
        this.withKind(instance.getKind());
        this.withLookupPolicy(instance.getLookupPolicy());
        this.withMetadata(instance.getMetadata());
        this.withTag(instance.getTag());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public LookupPolicyNested<A> editLookupPolicy() {
    return this.withNewLookupPolicyLike(Optional.ofNullable(this.buildLookupPolicy()).orElse(null));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<TagEventConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new ImageBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(Image item) {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(item));
  }
  
  public LookupPolicyNested<A> editOrNewLookupPolicy() {
    return this.withNewLookupPolicyLike(Optional.ofNullable(this.buildLookupPolicy()).orElse(new ImageLookupPolicyBuilder().build()));
  }
  
  public LookupPolicyNested<A> editOrNewLookupPolicyLike(ImageLookupPolicy item) {
    return this.withNewLookupPolicyLike(Optional.ofNullable(this.buildLookupPolicy()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public TagNested<A> editOrNewTag() {
    return this.withNewTagLike(Optional.ofNullable(this.buildTag()).orElse(new TagReferenceBuilder().build()));
  }
  
  public TagNested<A> editOrNewTagLike(TagReference item) {
    return this.withNewTagLike(Optional.ofNullable(this.buildTag()).orElse(item));
  }
  
  public TagNested<A> editTag() {
    return this.withNewTagLike(Optional.ofNullable(this.buildTag()).orElse(null));
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
    ImageStreamTagFluent that = (ImageStreamTagFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(generation, that.generation))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(lookupPolicy, that.lookupPolicy))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public Long getGeneration() {
    return this.generation;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasGeneration() {
    return this.generation != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLookupPolicy() {
    return this.lookupPolicy != null;
  }
  
  public boolean hasMatchingCondition(Predicate<TagEventConditionBuilder> predicate) {
      for (TagEventConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasTag() {
    return this.tag != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, conditions, generation, image, kind, lookupPolicy, metadata, tag, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<TagEventCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (TagEventCondition item : items) {
        TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromConditions(TagEventCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (TagEventCondition item : items) {
        TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<TagEventConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<TagEventConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        TagEventConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,TagEventCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,TagEventCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(generation == null)) {
        sb.append("generation:");
        sb.append(generation);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(lookupPolicy == null)) {
        sb.append("lookupPolicy:");
        sb.append(lookupPolicy);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withConditions(List<TagEventCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (TagEventCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(TagEventCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (TagEventCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withGeneration(Long generation) {
    this.generation = generation;
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
  
  public A withKind(String kind) {
    this.kind = kind;
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
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public ImageNested<A> withNewImage() {
    return new ImageNested(null);
  }
  
  public ImageNested<A> withNewImageLike(Image item) {
    return new ImageNested(item);
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
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public TagNested<A> withNewTag() {
    return new TagNested(null);
  }
  
  public TagNested<A> withNewTagLike(TagReference item) {
    return new TagNested(item);
  }
  
  public A withTag(TagReference tag) {
    this._visitables.remove("tag");
    if (tag != null) {
        this.tag = new TagReferenceBuilder(tag);
        this._visitables.get("tag").add(this.tag);
    } else {
        this.tag = null;
        this._visitables.get("tag").remove(this.tag);
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends TagEventConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    TagEventConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,TagEventCondition item) {
      this.index = index;
      this.builder = new TagEventConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamTagFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ImageNested<N> extends ImageFluent<ImageNested<N>> implements Nested<N>{
  
    ImageBuilder builder;
  
    ImageNested(Image item) {
      this.builder = new ImageBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamTagFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class LookupPolicyNested<N> extends ImageLookupPolicyFluent<LookupPolicyNested<N>> implements Nested<N>{
  
    ImageLookupPolicyBuilder builder;
  
    LookupPolicyNested(ImageLookupPolicy item) {
      this.builder = new ImageLookupPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamTagFluent.this.withLookupPolicy(builder.build());
    }
    
    public N endLookupPolicy() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamTagFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class TagNested<N> extends TagReferenceFluent<TagNested<N>> implements Nested<N>{
  
    TagReferenceBuilder builder;
  
    TagNested(TagReference item) {
      this.builder = new TagReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamTagFluent.this.withTag(builder.build());
    }
    
    public N endTag() {
      return and();
    }
    
  }
}