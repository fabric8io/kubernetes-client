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
public class OperatorHubStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.OperatorHubStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<HubSourceStatusBuilder> sources = new ArrayList<HubSourceStatusBuilder>();

  public OperatorHubStatusFluent() {
  }
  
  public OperatorHubStatusFluent(OperatorHubStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToSources(Collection<HubSourceStatus> items) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    for (HubSourceStatus item : items) {
        HubSourceStatusBuilder builder = new HubSourceStatusBuilder(item);
        _visitables.get("sources").add(builder);
        this.sources.add(builder);
    }
    return (A) this;
  }
  
  public SourcesNested<A> addNewSource() {
    return new SourcesNested(-1, null);
  }
  
  public A addNewSource(Boolean disabled,String message,String name,String status) {
    return (A) this.addToSources(new HubSourceStatus(disabled, message, name, status));
  }
  
  public SourcesNested<A> addNewSourceLike(HubSourceStatus item) {
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
  
  public A addToSources(HubSourceStatus... items) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    for (HubSourceStatus item : items) {
        HubSourceStatusBuilder builder = new HubSourceStatusBuilder(item);
        _visitables.get("sources").add(builder);
        this.sources.add(builder);
    }
    return (A) this;
  }
  
  public A addToSources(int index,HubSourceStatus item) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    HubSourceStatusBuilder builder = new HubSourceStatusBuilder(item);
    if (index < 0 || index >= sources.size()) {
        _visitables.get("sources").add(builder);
        sources.add(builder);
    } else {
        _visitables.get("sources").add(builder);
        sources.add(index, builder);
    }
    return (A) this;
  }
  
  public HubSourceStatus buildFirstSource() {
    return this.sources.get(0).build();
  }
  
  public HubSourceStatus buildLastSource() {
    return this.sources.get(sources.size() - 1).build();
  }
  
  public HubSourceStatus buildMatchingSource(Predicate<HubSourceStatusBuilder> predicate) {
      for (HubSourceStatusBuilder item : sources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HubSourceStatus buildSource(int index) {
    return this.sources.get(index).build();
  }
  
  public List<HubSourceStatus> buildSources() {
    return this.sources != null ? build(sources) : null;
  }
  
  protected void copyInstance(OperatorHubStatus instance) {
    instance = instance != null ? instance : new OperatorHubStatus();
    if (instance != null) {
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
  
  public SourcesNested<A> editMatchingSource(Predicate<HubSourceStatusBuilder> predicate) {
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
    OperatorHubStatusFluent that = (OperatorHubStatusFluent) o;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingSource(Predicate<HubSourceStatusBuilder> predicate) {
      for (HubSourceStatusBuilder item : sources) {
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
    return Objects.hash(sources, additionalProperties);
  }
  
  public A removeAllFromSources(Collection<HubSourceStatus> items) {
    if (this.sources == null) {
      return (A) this;
    }
    for (HubSourceStatus item : items) {
        HubSourceStatusBuilder builder = new HubSourceStatusBuilder(item);
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
  
  public A removeFromSources(HubSourceStatus... items) {
    if (this.sources == null) {
      return (A) this;
    }
    for (HubSourceStatus item : items) {
        HubSourceStatusBuilder builder = new HubSourceStatusBuilder(item);
        _visitables.get("sources").remove(builder);
        this.sources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSources(Predicate<HubSourceStatusBuilder> predicate) {
    if (sources == null) {
      return (A) this;
    }
    Iterator<HubSourceStatusBuilder> each = sources.iterator();
    List visitables = _visitables.get("sources");
    while (each.hasNext()) {
        HubSourceStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SourcesNested<A> setNewSourceLike(int index,HubSourceStatus item) {
    return new SourcesNested(index, item);
  }
  
  public A setToSources(int index,HubSourceStatus item) {
    if (this.sources == null) {
      this.sources = new ArrayList();
    }
    HubSourceStatusBuilder builder = new HubSourceStatusBuilder(item);
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
  
  public A withSources(List<HubSourceStatus> sources) {
    if (this.sources != null) {
      this._visitables.get("sources").clear();
    }
    if (sources != null) {
        this.sources = new ArrayList();
        for (HubSourceStatus item : sources) {
          this.addToSources(item);
        }
    } else {
      this.sources = null;
    }
    return (A) this;
  }
  
  public A withSources(HubSourceStatus... sources) {
    if (this.sources != null) {
        this.sources.clear();
        _visitables.remove("sources");
    }
    if (sources != null) {
      for (HubSourceStatus item : sources) {
        this.addToSources(item);
      }
    }
    return (A) this;
  }
  public class SourcesNested<N> extends HubSourceStatusFluent<SourcesNested<N>> implements Nested<N>{
  
    HubSourceStatusBuilder builder;
    int index;
  
    SourcesNested(int index,HubSourceStatus item) {
      this.index = index;
      this.builder = new HubSourceStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorHubStatusFluent.this.setToSources(index, builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
}