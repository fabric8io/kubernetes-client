package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class ProjectedVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.ProjectedVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer defaultMode;
  private ArrayList<VolumeProjectionBuilder> sources = new ArrayList<VolumeProjectionBuilder>();

  public ProjectedVolumeSourceFluent() {
  }
  
  public ProjectedVolumeSourceFluent(ProjectedVolumeSource instance) {
    this.copyInstance(instance);
  }

  public A addAllToSources(Collection<VolumeProjection> items) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    for (VolumeProjection item : items) {
        VolumeProjectionBuilder builder = new VolumeProjectionBuilder(item);
        _visitables.get("sources").add(builder);
        this.sources.add(builder);
    }
    return (A) this;
  }
  
  public SourcesNested<A> addNewSource() {
    return new SourcesNested(-1, null);
  }
  
  public SourcesNested<A> addNewSourceLike(VolumeProjection item) {
    return new SourcesNested(-1, item);
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
  
  public A addToSources(VolumeProjection... items) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    for (VolumeProjection item : items) {
        VolumeProjectionBuilder builder = new VolumeProjectionBuilder(item);
        _visitables.get("sources").add(builder);
        this.sources.add(builder);
    }
    return (A) this;
  }
  
  public A addToSources(int index,VolumeProjection item) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    VolumeProjectionBuilder builder = new VolumeProjectionBuilder(item);
    if (index < 0 || index >= sources.size()) {
        _visitables.get("sources").add(builder);
        sources.add(builder);
    } else {
        _visitables.get("sources").add(builder);
        sources.add(index, builder);
    }
    return (A) this;
  }
  
  public VolumeProjection buildFirstSource() {
    return this.sources.get(0).build();
  }
  
  public VolumeProjection buildLastSource() {
    return this.sources.get(sources.size() - 1).build();
  }
  
  public VolumeProjection buildMatchingSource(Predicate<VolumeProjectionBuilder> predicate) {
      for (VolumeProjectionBuilder item : sources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VolumeProjection buildSource(int index) {
    return this.sources.get(index).build();
  }
  
  public List<VolumeProjection> buildSources() {
    return this.sources != null ? build(sources) : null;
  }
  
  protected void copyInstance(ProjectedVolumeSource instance) {
    instance = instance != null ? instance : new ProjectedVolumeSource();
    if (instance != null) {
        this.withDefaultMode(instance.getDefaultMode());
        this.withSources(instance.getSources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SourcesNested<A> editFirstSource() {
    if (sources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "sources"));
    }
    return this.setNewSourceLike(0, this.buildSource(0));
  }
  
  public SourcesNested<A> editLastSource() {
    int index = sources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "sources"));
    }
    return this.setNewSourceLike(index, this.buildSource(index));
  }
  
  public SourcesNested<A> editMatchingSource(Predicate<VolumeProjectionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < sources.size();i++) {
      if (predicate.test(sources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "sources"));
    }
    return this.setNewSourceLike(index, this.buildSource(index));
  }
  
  public SourcesNested<A> editSource(int index) {
    if (sources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "sources"));
    }
    return this.setNewSourceLike(index, this.buildSource(index));
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
    ProjectedVolumeSourceFluent that = (ProjectedVolumeSourceFluent) o;
    if (!(Objects.equals(defaultMode, that.defaultMode))) {
      return false;
    }
    if (!(Objects.equals(sources, that.sources))) {
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
  
  public Integer getDefaultMode() {
    return this.defaultMode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefaultMode() {
    return this.defaultMode != null;
  }
  
  public boolean hasMatchingSource(Predicate<VolumeProjectionBuilder> predicate) {
      for (VolumeProjectionBuilder item : sources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSources() {
    return this.sources != null && !(this.sources.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(defaultMode, sources, additionalProperties);
  }
  
  public A removeAllFromSources(Collection<VolumeProjection> items) {
    if (this.sources == null) {
      return (A) this;
    }
    for (VolumeProjection item : items) {
        VolumeProjectionBuilder builder = new VolumeProjectionBuilder(item);
        _visitables.get("sources").remove(builder);
        this.sources.remove(builder);
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
  
  public A removeFromSources(VolumeProjection... items) {
    if (this.sources == null) {
      return (A) this;
    }
    for (VolumeProjection item : items) {
        VolumeProjectionBuilder builder = new VolumeProjectionBuilder(item);
        _visitables.get("sources").remove(builder);
        this.sources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSources(Predicate<VolumeProjectionBuilder> predicate) {
    if (sources == null) {
      return (A) this;
    }
    Iterator<VolumeProjectionBuilder> each = sources.iterator();
    List visitables = _visitables.get("sources");
    while (each.hasNext()) {
        VolumeProjectionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SourcesNested<A> setNewSourceLike(int index,VolumeProjection item) {
    return new SourcesNested(index, item);
  }
  
  public A setToSources(int index,VolumeProjection item) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    VolumeProjectionBuilder builder = new VolumeProjectionBuilder(item);
    if (index < 0 || index >= sources.size()) {
        _visitables.get("sources").add(builder);
        sources.add(builder);
    } else {
        _visitables.get("sources").add(builder);
        sources.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(defaultMode == null)) {
        sb.append("defaultMode:");
        sb.append(defaultMode);
        sb.append(",");
    }
    if (!(sources == null) && !(sources.isEmpty())) {
        sb.append("sources:");
        sb.append(sources);
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
  
  public A withDefaultMode(Integer defaultMode) {
    this.defaultMode = defaultMode;
    return (A) this;
  }
  
  public A withSources(List<VolumeProjection> sources) {
    if (this.sources != null) {
      this._visitables.get("sources").clear();
    }
    if (sources != null) {
        this.sources = new ArrayList();
        for (VolumeProjection item : sources) {
          this.addToSources(item);
        }
    } else {
      this.sources = null;
    }
    return (A) this;
  }
  
  public A withSources(VolumeProjection... sources) {
    if (this.sources != null) {
        this.sources.clear();
        _visitables.remove("sources");
    }
    if (sources != null) {
      for (VolumeProjection item : sources) {
        this.addToSources(item);
      }
    }
    return (A) this;
  }
  public class SourcesNested<N> extends VolumeProjectionFluent<SourcesNested<N>> implements Nested<N>{
  
    VolumeProjectionBuilder builder;
    int index;
  
    SourcesNested(int index,VolumeProjection item) {
      this.index = index;
      this.builder = new VolumeProjectionBuilder(this, item);
    }
  
    public N and() {
      return (N) ProjectedVolumeSourceFluent.this.setToSources(index, builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
}