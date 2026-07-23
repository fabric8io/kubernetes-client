package io.fabric8.openshift.api.model.operator.v1;

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
public class PerspectiveFluent<A extends io.fabric8.openshift.api.model.operator.v1.PerspectiveFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String id;
  private ArrayList<PinnedResourceReferenceBuilder> pinnedResources = new ArrayList<PinnedResourceReferenceBuilder>();
  private PerspectiveVisibilityBuilder visibility;

  public PerspectiveFluent() {
  }
  
  public PerspectiveFluent(Perspective instance) {
    this.copyInstance(instance);
  }

  public A addAllToPinnedResources(Collection<PinnedResourceReference> items) {
    if (this.pinnedResources == null) {
      this.pinnedResources = new ArrayList();
    }
    for (PinnedResourceReference item : items) {
        PinnedResourceReferenceBuilder builder = new PinnedResourceReferenceBuilder(item);
        _visitables.get("pinnedResources").add(builder);
        this.pinnedResources.add(builder);
    }
    return (A) this;
  }
  
  public PinnedResourcesNested<A> addNewPinnedResource() {
    return new PinnedResourcesNested(-1, null);
  }
  
  public A addNewPinnedResource(String group,String resource,String version) {
    return (A) this.addToPinnedResources(new PinnedResourceReference(group, resource, version));
  }
  
  public PinnedResourcesNested<A> addNewPinnedResourceLike(PinnedResourceReference item) {
    return new PinnedResourcesNested(-1, item);
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
  
  public A addToPinnedResources(PinnedResourceReference... items) {
    if (this.pinnedResources == null) {
      this.pinnedResources = new ArrayList();
    }
    for (PinnedResourceReference item : items) {
        PinnedResourceReferenceBuilder builder = new PinnedResourceReferenceBuilder(item);
        _visitables.get("pinnedResources").add(builder);
        this.pinnedResources.add(builder);
    }
    return (A) this;
  }
  
  public A addToPinnedResources(int index,PinnedResourceReference item) {
    if (this.pinnedResources == null) {
      this.pinnedResources = new ArrayList();
    }
    PinnedResourceReferenceBuilder builder = new PinnedResourceReferenceBuilder(item);
    if (index < 0 || index >= pinnedResources.size()) {
        _visitables.get("pinnedResources").add(builder);
        pinnedResources.add(builder);
    } else {
        _visitables.get("pinnedResources").add(builder);
        pinnedResources.add(index, builder);
    }
    return (A) this;
  }
  
  public PinnedResourceReference buildFirstPinnedResource() {
    return this.pinnedResources.get(0).build();
  }
  
  public PinnedResourceReference buildLastPinnedResource() {
    return this.pinnedResources.get(pinnedResources.size() - 1).build();
  }
  
  public PinnedResourceReference buildMatchingPinnedResource(Predicate<PinnedResourceReferenceBuilder> predicate) {
      for (PinnedResourceReferenceBuilder item : pinnedResources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PinnedResourceReference buildPinnedResource(int index) {
    return this.pinnedResources.get(index).build();
  }
  
  public List<PinnedResourceReference> buildPinnedResources() {
    return this.pinnedResources != null ? build(pinnedResources) : null;
  }
  
  public PerspectiveVisibility buildVisibility() {
    return this.visibility != null ? this.visibility.build() : null;
  }
  
  protected void copyInstance(Perspective instance) {
    instance = instance != null ? instance : new Perspective();
    if (instance != null) {
        this.withId(instance.getId());
        this.withPinnedResources(instance.getPinnedResources());
        this.withVisibility(instance.getVisibility());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PinnedResourcesNested<A> editFirstPinnedResource() {
    if (pinnedResources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pinnedResources"));
    }
    return this.setNewPinnedResourceLike(0, this.buildPinnedResource(0));
  }
  
  public PinnedResourcesNested<A> editLastPinnedResource() {
    int index = pinnedResources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pinnedResources"));
    }
    return this.setNewPinnedResourceLike(index, this.buildPinnedResource(index));
  }
  
  public PinnedResourcesNested<A> editMatchingPinnedResource(Predicate<PinnedResourceReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pinnedResources.size();i++) {
      if (predicate.test(pinnedResources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pinnedResources"));
    }
    return this.setNewPinnedResourceLike(index, this.buildPinnedResource(index));
  }
  
  public VisibilityNested<A> editOrNewVisibility() {
    return this.withNewVisibilityLike(Optional.ofNullable(this.buildVisibility()).orElse(new PerspectiveVisibilityBuilder().build()));
  }
  
  public VisibilityNested<A> editOrNewVisibilityLike(PerspectiveVisibility item) {
    return this.withNewVisibilityLike(Optional.ofNullable(this.buildVisibility()).orElse(item));
  }
  
  public PinnedResourcesNested<A> editPinnedResource(int index) {
    if (pinnedResources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pinnedResources"));
    }
    return this.setNewPinnedResourceLike(index, this.buildPinnedResource(index));
  }
  
  public VisibilityNested<A> editVisibility() {
    return this.withNewVisibilityLike(Optional.ofNullable(this.buildVisibility()).orElse(null));
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
    PerspectiveFluent that = (PerspectiveFluent) o;
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(pinnedResources, that.pinnedResources))) {
      return false;
    }
    if (!(Objects.equals(visibility, that.visibility))) {
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
  
  public String getId() {
    return this.id;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasMatchingPinnedResource(Predicate<PinnedResourceReferenceBuilder> predicate) {
      for (PinnedResourceReferenceBuilder item : pinnedResources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPinnedResources() {
    return this.pinnedResources != null && !(this.pinnedResources.isEmpty());
  }
  
  public boolean hasVisibility() {
    return this.visibility != null;
  }
  
  public int hashCode() {
    return Objects.hash(id, pinnedResources, visibility, additionalProperties);
  }
  
  public A removeAllFromPinnedResources(Collection<PinnedResourceReference> items) {
    if (this.pinnedResources == null) {
      return (A) this;
    }
    for (PinnedResourceReference item : items) {
        PinnedResourceReferenceBuilder builder = new PinnedResourceReferenceBuilder(item);
        _visitables.get("pinnedResources").remove(builder);
        this.pinnedResources.remove(builder);
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
  
  public A removeFromPinnedResources(PinnedResourceReference... items) {
    if (this.pinnedResources == null) {
      return (A) this;
    }
    for (PinnedResourceReference item : items) {
        PinnedResourceReferenceBuilder builder = new PinnedResourceReferenceBuilder(item);
        _visitables.get("pinnedResources").remove(builder);
        this.pinnedResources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPinnedResources(Predicate<PinnedResourceReferenceBuilder> predicate) {
    if (pinnedResources == null) {
      return (A) this;
    }
    Iterator<PinnedResourceReferenceBuilder> each = pinnedResources.iterator();
    List visitables = _visitables.get("pinnedResources");
    while (each.hasNext()) {
        PinnedResourceReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PinnedResourcesNested<A> setNewPinnedResourceLike(int index,PinnedResourceReference item) {
    return new PinnedResourcesNested(index, item);
  }
  
  public A setToPinnedResources(int index,PinnedResourceReference item) {
    if (this.pinnedResources == null) {
      this.pinnedResources = new ArrayList();
    }
    PinnedResourceReferenceBuilder builder = new PinnedResourceReferenceBuilder(item);
    if (index < 0 || index >= pinnedResources.size()) {
        _visitables.get("pinnedResources").add(builder);
        pinnedResources.add(builder);
    } else {
        _visitables.get("pinnedResources").add(builder);
        pinnedResources.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(pinnedResources == null) && !(pinnedResources.isEmpty())) {
        sb.append("pinnedResources:");
        sb.append(pinnedResources);
        sb.append(",");
    }
    if (!(visibility == null)) {
        sb.append("visibility:");
        sb.append(visibility);
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
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public VisibilityNested<A> withNewVisibility() {
    return new VisibilityNested(null);
  }
  
  public VisibilityNested<A> withNewVisibilityLike(PerspectiveVisibility item) {
    return new VisibilityNested(item);
  }
  
  public A withPinnedResources(List<PinnedResourceReference> pinnedResources) {
    if (this.pinnedResources != null) {
      this._visitables.get("pinnedResources").clear();
    }
    if (pinnedResources != null) {
        this.pinnedResources = new ArrayList();
        for (PinnedResourceReference item : pinnedResources) {
          this.addToPinnedResources(item);
        }
    } else {
      this.pinnedResources = null;
    }
    return (A) this;
  }
  
  public A withPinnedResources(PinnedResourceReference... pinnedResources) {
    if (this.pinnedResources != null) {
        this.pinnedResources.clear();
        _visitables.remove("pinnedResources");
    }
    if (pinnedResources != null) {
      for (PinnedResourceReference item : pinnedResources) {
        this.addToPinnedResources(item);
      }
    }
    return (A) this;
  }
  
  public A withVisibility(PerspectiveVisibility visibility) {
    this._visitables.remove("visibility");
    if (visibility != null) {
        this.visibility = new PerspectiveVisibilityBuilder(visibility);
        this._visitables.get("visibility").add(this.visibility);
    } else {
        this.visibility = null;
        this._visitables.get("visibility").remove(this.visibility);
    }
    return (A) this;
  }
  public class PinnedResourcesNested<N> extends PinnedResourceReferenceFluent<PinnedResourcesNested<N>> implements Nested<N>{
  
    PinnedResourceReferenceBuilder builder;
    int index;
  
    PinnedResourcesNested(int index,PinnedResourceReference item) {
      this.index = index;
      this.builder = new PinnedResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PerspectiveFluent.this.setToPinnedResources(index, builder.build());
    }
    
    public N endPinnedResource() {
      return and();
    }
    
  }
  public class VisibilityNested<N> extends PerspectiveVisibilityFluent<VisibilityNested<N>> implements Nested<N>{
  
    PerspectiveVisibilityBuilder builder;
  
    VisibilityNested(PerspectiveVisibility item) {
      this.builder = new PerspectiveVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) PerspectiveFluent.this.withVisibility(builder.build());
    }
    
    public N endVisibility() {
      return and();
    }
    
  }
}