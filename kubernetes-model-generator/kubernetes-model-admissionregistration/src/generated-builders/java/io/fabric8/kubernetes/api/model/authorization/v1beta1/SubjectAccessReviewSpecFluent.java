package io.fabric8.kubernetes.api.model.authorization.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class SubjectAccessReviewSpecFluent<A extends io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReviewSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,List<String>> extra;
  private List<String> group = new ArrayList<String>();
  private NonResourceAttributesBuilder nonResourceAttributes;
  private ResourceAttributesBuilder resourceAttributes;
  private String uid;
  private String user;

  public SubjectAccessReviewSpecFluent() {
  }
  
  public SubjectAccessReviewSpecFluent(SubjectAccessReviewSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToGroup(Collection<String> items) {
    if (this.group == null) {
      this.group = new ArrayList();
    }
    for (String item : items) {
      this.group.add(item);
    }
    return (A) this;
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
  
  public A addToExtra(Map<String,List<String>> map) {
    if (this.extra == null && map != null) {
      this.extra = new LinkedHashMap();
    }
    if (map != null) {
      this.extra.putAll(map);
    }
    return (A) this;
  }
  
  public A addToExtra(String key,List<String> value) {
    if (this.extra == null && key != null && value != null) {
      this.extra = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.extra.put(key, value);
    }
    return (A) this;
  }
  
  public A addToGroup(String... items) {
    if (this.group == null) {
      this.group = new ArrayList();
    }
    for (String item : items) {
      this.group.add(item);
    }
    return (A) this;
  }
  
  public A addToGroup(int index,String item) {
    if (this.group == null) {
      this.group = new ArrayList();
    }
    this.group.add(index, item);
    return (A) this;
  }
  
  public NonResourceAttributes buildNonResourceAttributes() {
    return this.nonResourceAttributes != null ? this.nonResourceAttributes.build() : null;
  }
  
  public ResourceAttributes buildResourceAttributes() {
    return this.resourceAttributes != null ? this.resourceAttributes.build() : null;
  }
  
  protected void copyInstance(SubjectAccessReviewSpec instance) {
    instance = instance != null ? instance : new SubjectAccessReviewSpec();
    if (instance != null) {
        this.withExtra(instance.getExtra());
        this.withGroup(instance.getGroup());
        this.withNonResourceAttributes(instance.getNonResourceAttributes());
        this.withResourceAttributes(instance.getResourceAttributes());
        this.withUid(instance.getUid());
        this.withUser(instance.getUser());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NonResourceAttributesNested<A> editNonResourceAttributes() {
    return this.withNewNonResourceAttributesLike(Optional.ofNullable(this.buildNonResourceAttributes()).orElse(null));
  }
  
  public NonResourceAttributesNested<A> editOrNewNonResourceAttributes() {
    return this.withNewNonResourceAttributesLike(Optional.ofNullable(this.buildNonResourceAttributes()).orElse(new NonResourceAttributesBuilder().build()));
  }
  
  public NonResourceAttributesNested<A> editOrNewNonResourceAttributesLike(NonResourceAttributes item) {
    return this.withNewNonResourceAttributesLike(Optional.ofNullable(this.buildNonResourceAttributes()).orElse(item));
  }
  
  public ResourceAttributesNested<A> editOrNewResourceAttributes() {
    return this.withNewResourceAttributesLike(Optional.ofNullable(this.buildResourceAttributes()).orElse(new ResourceAttributesBuilder().build()));
  }
  
  public ResourceAttributesNested<A> editOrNewResourceAttributesLike(ResourceAttributes item) {
    return this.withNewResourceAttributesLike(Optional.ofNullable(this.buildResourceAttributes()).orElse(item));
  }
  
  public ResourceAttributesNested<A> editResourceAttributes() {
    return this.withNewResourceAttributesLike(Optional.ofNullable(this.buildResourceAttributes()).orElse(null));
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
    SubjectAccessReviewSpecFluent that = (SubjectAccessReviewSpecFluent) o;
    if (!(Objects.equals(extra, that.extra))) {
      return false;
    }
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(nonResourceAttributes, that.nonResourceAttributes))) {
      return false;
    }
    if (!(Objects.equals(resourceAttributes, that.resourceAttributes))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
      return false;
    }
    if (!(Objects.equals(user, that.user))) {
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
  
  public Map<String,List<String>> getExtra() {
    return this.extra;
  }
  
  public String getFirstGroup() {
    return this.group.get(0);
  }
  
  public List<String> getGroup() {
    return this.group;
  }
  
  public String getGroup(int index) {
    return this.group.get(index);
  }
  
  public String getLastGroup() {
    return this.group.get(group.size() - 1);
  }
  
  public String getMatchingGroup(Predicate<String> predicate) {
      for (String item : group) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public String getUser() {
    return this.user;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExtra() {
    return this.extra != null;
  }
  
  public boolean hasGroup() {
    return this.group != null && !(this.group.isEmpty());
  }
  
  public boolean hasMatchingGroup(Predicate<String> predicate) {
      for (String item : group) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNonResourceAttributes() {
    return this.nonResourceAttributes != null;
  }
  
  public boolean hasResourceAttributes() {
    return this.resourceAttributes != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public boolean hasUser() {
    return this.user != null;
  }
  
  public int hashCode() {
    return Objects.hash(extra, group, nonResourceAttributes, resourceAttributes, uid, user, additionalProperties);
  }
  
  public A removeAllFromGroup(Collection<String> items) {
    if (this.group == null) {
      return (A) this;
    }
    for (String item : items) {
      this.group.remove(item);
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
  
  public A removeFromExtra(String key) {
    if (this.extra == null) {
      return (A) this;
    }
    if (key != null && this.extra != null) {
      this.extra.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromExtra(Map<String,List<String>> map) {
    if (this.extra == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.extra != null) {
          this.extra.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromGroup(String... items) {
    if (this.group == null) {
      return (A) this;
    }
    for (String item : items) {
      this.group.remove(item);
    }
    return (A) this;
  }
  
  public A setToGroup(int index,String item) {
    if (this.group == null) {
      this.group = new ArrayList();
    }
    this.group.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(extra == null) && !(extra.isEmpty())) {
        sb.append("extra:");
        sb.append(extra);
        sb.append(",");
    }
    if (!(group == null) && !(group.isEmpty())) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(nonResourceAttributes == null)) {
        sb.append("nonResourceAttributes:");
        sb.append(nonResourceAttributes);
        sb.append(",");
    }
    if (!(resourceAttributes == null)) {
        sb.append("resourceAttributes:");
        sb.append(resourceAttributes);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
        sb.append(",");
    }
    if (!(user == null)) {
        sb.append("user:");
        sb.append(user);
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
  
  public <K,V>A withExtra(Map<String,List<String>> extra) {
    if (extra == null) {
      this.extra = null;
    } else {
      this.extra = new LinkedHashMap(extra);
    }
    return (A) this;
  }
  
  public A withGroup(List<String> group) {
    if (group != null) {
        this.group = new ArrayList();
        for (String item : group) {
          this.addToGroup(item);
        }
    } else {
      this.group = null;
    }
    return (A) this;
  }
  
  public A withGroup(String... group) {
    if (this.group != null) {
        this.group.clear();
        _visitables.remove("group");
    }
    if (group != null) {
      for (String item : group) {
        this.addToGroup(item);
      }
    }
    return (A) this;
  }
  
  public NonResourceAttributesNested<A> withNewNonResourceAttributes() {
    return new NonResourceAttributesNested(null);
  }
  
  public A withNewNonResourceAttributes(String path,String verb) {
    return (A) this.withNonResourceAttributes(new NonResourceAttributes(path, verb));
  }
  
  public NonResourceAttributesNested<A> withNewNonResourceAttributesLike(NonResourceAttributes item) {
    return new NonResourceAttributesNested(item);
  }
  
  public ResourceAttributesNested<A> withNewResourceAttributes() {
    return new ResourceAttributesNested(null);
  }
  
  public ResourceAttributesNested<A> withNewResourceAttributesLike(ResourceAttributes item) {
    return new ResourceAttributesNested(item);
  }
  
  public A withNonResourceAttributes(NonResourceAttributes nonResourceAttributes) {
    this._visitables.remove("nonResourceAttributes");
    if (nonResourceAttributes != null) {
        this.nonResourceAttributes = new NonResourceAttributesBuilder(nonResourceAttributes);
        this._visitables.get("nonResourceAttributes").add(this.nonResourceAttributes);
    } else {
        this.nonResourceAttributes = null;
        this._visitables.get("nonResourceAttributes").remove(this.nonResourceAttributes);
    }
    return (A) this;
  }
  
  public A withResourceAttributes(ResourceAttributes resourceAttributes) {
    this._visitables.remove("resourceAttributes");
    if (resourceAttributes != null) {
        this.resourceAttributes = new ResourceAttributesBuilder(resourceAttributes);
        this._visitables.get("resourceAttributes").add(this.resourceAttributes);
    } else {
        this.resourceAttributes = null;
        this._visitables.get("resourceAttributes").remove(this.resourceAttributes);
    }
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  
  public A withUser(String user) {
    this.user = user;
    return (A) this;
  }
  public class NonResourceAttributesNested<N> extends NonResourceAttributesFluent<NonResourceAttributesNested<N>> implements Nested<N>{
  
    NonResourceAttributesBuilder builder;
  
    NonResourceAttributesNested(NonResourceAttributes item) {
      this.builder = new NonResourceAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) SubjectAccessReviewSpecFluent.this.withNonResourceAttributes(builder.build());
    }
    
    public N endNonResourceAttributes() {
      return and();
    }
    
  }
  public class ResourceAttributesNested<N> extends ResourceAttributesFluent<ResourceAttributesNested<N>> implements Nested<N>{
  
    ResourceAttributesBuilder builder;
  
    ResourceAttributesNested(ResourceAttributes item) {
      this.builder = new ResourceAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) SubjectAccessReviewSpecFluent.this.withResourceAttributes(builder.build());
    }
    
    public N endResourceAttributes() {
      return and();
    }
    
  }
}