package io.fabric8.openshift.api.model.config.v1;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OperatorHubSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.OperatorHubSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean disableAllDefaultSources;
  private ArrayList<HubSourceBuilder> sources = new ArrayList<HubSourceBuilder>();

  public OperatorHubSpecFluent() {
  }
  
  public OperatorHubSpecFluent(OperatorHubSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToSources(Collection<HubSource> items) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    for (HubSource item : items) {
        HubSourceBuilder builder = new HubSourceBuilder(item);
        _visitables.get("sources").add(builder);
        this.sources.add(builder);
    }
    return (A) this;
  }
  
  public SourcesNested<A> addNewSource() {
    return new SourcesNested(-1, null);
  }
  
  public A addNewSource(Boolean disabled,String name) {
    return (A) this.addToSources(new HubSource(disabled, name));
  }
  
  public SourcesNested<A> addNewSourceLike(HubSource item) {
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
  
  public A addToSources(HubSource... items) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    for (HubSource item : items) {
        HubSourceBuilder builder = new HubSourceBuilder(item);
        _visitables.get("sources").add(builder);
        this.sources.add(builder);
    }
    return (A) this;
  }
  
  public A addToSources(int index,HubSource item) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    HubSourceBuilder builder = new HubSourceBuilder(item);
    if (index < 0 || index >= sources.size()) {
        _visitables.get("sources").add(builder);
        sources.add(builder);
    } else {
        _visitables.get("sources").add(builder);
        sources.add(index, builder);
    }
    return (A) this;
  }
  
  public HubSource buildFirstSource() {
    return this.sources.get(0).build();
  }
  
  public HubSource buildLastSource() {
    return this.sources.get(sources.size() - 1).build();
  }
  
  public HubSource buildMatchingSource(Predicate<HubSourceBuilder> predicate) {
      for (HubSourceBuilder item : sources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HubSource buildSource(int index) {
    return this.sources.get(index).build();
  }
  
  public List<HubSource> buildSources() {
    return this.sources != null ? build(sources) : null;
  }
  
  protected void copyInstance(OperatorHubSpec instance) {
    instance = instance != null ? instance : new OperatorHubSpec();
    if (instance != null) {
        this.withDisableAllDefaultSources(instance.getDisableAllDefaultSources());
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
  
  public SourcesNested<A> editMatchingSource(Predicate<HubSourceBuilder> predicate) {
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
    OperatorHubSpecFluent that = (OperatorHubSpecFluent) o;
    if (!(Objects.equals(disableAllDefaultSources, that.disableAllDefaultSources))) {
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
  
  public Boolean getDisableAllDefaultSources() {
    return this.disableAllDefaultSources;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisableAllDefaultSources() {
    return this.disableAllDefaultSources != null;
  }
  
  public boolean hasMatchingSource(Predicate<HubSourceBuilder> predicate) {
      for (HubSourceBuilder item : sources) {
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
    return Objects.hash(disableAllDefaultSources, sources, additionalProperties);
  }
  
  public A removeAllFromSources(Collection<HubSource> items) {
    if (this.sources == null) {
      return (A) this;
    }
    for (HubSource item : items) {
        HubSourceBuilder builder = new HubSourceBuilder(item);
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
  
  public A removeFromSources(HubSource... items) {
    if (this.sources == null) {
      return (A) this;
    }
    for (HubSource item : items) {
        HubSourceBuilder builder = new HubSourceBuilder(item);
        _visitables.get("sources").remove(builder);
        this.sources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSources(Predicate<HubSourceBuilder> predicate) {
    if (sources == null) {
      return (A) this;
    }
    Iterator<HubSourceBuilder> each = sources.iterator();
    List visitables = _visitables.get("sources");
    while (each.hasNext()) {
        HubSourceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SourcesNested<A> setNewSourceLike(int index,HubSource item) {
    return new SourcesNested(index, item);
  }
  
  public A setToSources(int index,HubSource item) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    HubSourceBuilder builder = new HubSourceBuilder(item);
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
    if (!(disableAllDefaultSources == null)) {
        sb.append("disableAllDefaultSources:");
        sb.append(disableAllDefaultSources);
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
  
  public A withDisableAllDefaultSources() {
    return withDisableAllDefaultSources(true);
  }
  
  public A withDisableAllDefaultSources(Boolean disableAllDefaultSources) {
    this.disableAllDefaultSources = disableAllDefaultSources;
    return (A) this;
  }
  
  public A withSources(List<HubSource> sources) {
    if (this.sources != null) {
      this._visitables.get("sources").clear();
    }
    if (sources != null) {
        this.sources = new ArrayList();
        for (HubSource item : sources) {
          this.addToSources(item);
        }
    } else {
      this.sources = null;
    }
    return (A) this;
  }
  
  public A withSources(HubSource... sources) {
    if (this.sources != null) {
        this.sources.clear();
        _visitables.remove("sources");
    }
    if (sources != null) {
      for (HubSource item : sources) {
        this.addToSources(item);
      }
    }
    return (A) this;
  }
  public class SourcesNested<N> extends HubSourceFluent<SourcesNested<N>> implements Nested<N>{
  
    HubSourceBuilder builder;
    int index;
  
    SourcesNested(int index,HubSource item) {
      this.index = index;
      this.builder = new HubSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorHubSpecFluent.this.setToSources(index, builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
}