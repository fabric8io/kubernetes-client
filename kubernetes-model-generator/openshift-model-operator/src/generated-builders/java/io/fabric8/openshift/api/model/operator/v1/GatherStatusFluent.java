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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class GatherStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1.GatherStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<GathererStatusBuilder> gatherers = new ArrayList<GathererStatusBuilder>();
  private String lastGatherDuration;
  private String lastGatherTime;

  public GatherStatusFluent() {
  }
  
  public GatherStatusFluent(GatherStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToGatherers(Collection<GathererStatus> items) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    for (GathererStatus item : items) {
        GathererStatusBuilder builder = new GathererStatusBuilder(item);
        _visitables.get("gatherers").add(builder);
        this.gatherers.add(builder);
    }
    return (A) this;
  }
  
  public GatherersNested<A> addNewGatherer() {
    return new GatherersNested(-1, null);
  }
  
  public GatherersNested<A> addNewGathererLike(GathererStatus item) {
    return new GatherersNested(-1, item);
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
  
  public A addToGatherers(GathererStatus... items) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    for (GathererStatus item : items) {
        GathererStatusBuilder builder = new GathererStatusBuilder(item);
        _visitables.get("gatherers").add(builder);
        this.gatherers.add(builder);
    }
    return (A) this;
  }
  
  public A addToGatherers(int index,GathererStatus item) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    GathererStatusBuilder builder = new GathererStatusBuilder(item);
    if (index < 0 || index >= gatherers.size()) {
        _visitables.get("gatherers").add(builder);
        gatherers.add(builder);
    } else {
        _visitables.get("gatherers").add(builder);
        gatherers.add(index, builder);
    }
    return (A) this;
  }
  
  public GathererStatus buildFirstGatherer() {
    return this.gatherers.get(0).build();
  }
  
  public GathererStatus buildGatherer(int index) {
    return this.gatherers.get(index).build();
  }
  
  public List<GathererStatus> buildGatherers() {
    return this.gatherers != null ? build(gatherers) : null;
  }
  
  public GathererStatus buildLastGatherer() {
    return this.gatherers.get(gatherers.size() - 1).build();
  }
  
  public GathererStatus buildMatchingGatherer(Predicate<GathererStatusBuilder> predicate) {
      for (GathererStatusBuilder item : gatherers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(GatherStatus instance) {
    instance = instance != null ? instance : new GatherStatus();
    if (instance != null) {
        this.withGatherers(instance.getGatherers());
        this.withLastGatherDuration(instance.getLastGatherDuration());
        this.withLastGatherTime(instance.getLastGatherTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GatherersNested<A> editFirstGatherer() {
    if (gatherers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gatherers"));
    }
    return this.setNewGathererLike(0, this.buildGatherer(0));
  }
  
  public GatherersNested<A> editGatherer(int index) {
    if (gatherers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gatherers"));
    }
    return this.setNewGathererLike(index, this.buildGatherer(index));
  }
  
  public GatherersNested<A> editLastGatherer() {
    int index = gatherers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gatherers"));
    }
    return this.setNewGathererLike(index, this.buildGatherer(index));
  }
  
  public GatherersNested<A> editMatchingGatherer(Predicate<GathererStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gatherers.size();i++) {
      if (predicate.test(gatherers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gatherers"));
    }
    return this.setNewGathererLike(index, this.buildGatherer(index));
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
    GatherStatusFluent that = (GatherStatusFluent) o;
    if (!(Objects.equals(gatherers, that.gatherers))) {
      return false;
    }
    if (!(Objects.equals(lastGatherDuration, that.lastGatherDuration))) {
      return false;
    }
    if (!(Objects.equals(lastGatherTime, that.lastGatherTime))) {
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
  
  public String getLastGatherDuration() {
    return this.lastGatherDuration;
  }
  
  public String getLastGatherTime() {
    return this.lastGatherTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGatherers() {
    return this.gatherers != null && !(this.gatherers.isEmpty());
  }
  
  public boolean hasLastGatherDuration() {
    return this.lastGatherDuration != null;
  }
  
  public boolean hasLastGatherTime() {
    return this.lastGatherTime != null;
  }
  
  public boolean hasMatchingGatherer(Predicate<GathererStatusBuilder> predicate) {
      for (GathererStatusBuilder item : gatherers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(gatherers, lastGatherDuration, lastGatherTime, additionalProperties);
  }
  
  public A removeAllFromGatherers(Collection<GathererStatus> items) {
    if (this.gatherers == null) {
      return (A) this;
    }
    for (GathererStatus item : items) {
        GathererStatusBuilder builder = new GathererStatusBuilder(item);
        _visitables.get("gatherers").remove(builder);
        this.gatherers.remove(builder);
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
  
  public A removeFromGatherers(GathererStatus... items) {
    if (this.gatherers == null) {
      return (A) this;
    }
    for (GathererStatus item : items) {
        GathererStatusBuilder builder = new GathererStatusBuilder(item);
        _visitables.get("gatherers").remove(builder);
        this.gatherers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromGatherers(Predicate<GathererStatusBuilder> predicate) {
    if (gatherers == null) {
      return (A) this;
    }
    Iterator<GathererStatusBuilder> each = gatherers.iterator();
    List visitables = _visitables.get("gatherers");
    while (each.hasNext()) {
        GathererStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public GatherersNested<A> setNewGathererLike(int index,GathererStatus item) {
    return new GatherersNested(index, item);
  }
  
  public A setToGatherers(int index,GathererStatus item) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    GathererStatusBuilder builder = new GathererStatusBuilder(item);
    if (index < 0 || index >= gatherers.size()) {
        _visitables.get("gatherers").add(builder);
        gatherers.add(builder);
    } else {
        _visitables.get("gatherers").add(builder);
        gatherers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(gatherers == null) && !(gatherers.isEmpty())) {
        sb.append("gatherers:");
        sb.append(gatherers);
        sb.append(",");
    }
    if (!(lastGatherDuration == null)) {
        sb.append("lastGatherDuration:");
        sb.append(lastGatherDuration);
        sb.append(",");
    }
    if (!(lastGatherTime == null)) {
        sb.append("lastGatherTime:");
        sb.append(lastGatherTime);
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
  
  public A withGatherers(List<GathererStatus> gatherers) {
    if (this.gatherers != null) {
      this._visitables.get("gatherers").clear();
    }
    if (gatherers != null) {
        this.gatherers = new ArrayList();
        for (GathererStatus item : gatherers) {
          this.addToGatherers(item);
        }
    } else {
      this.gatherers = null;
    }
    return (A) this;
  }
  
  public A withGatherers(GathererStatus... gatherers) {
    if (this.gatherers != null) {
        this.gatherers.clear();
        _visitables.remove("gatherers");
    }
    if (gatherers != null) {
      for (GathererStatus item : gatherers) {
        this.addToGatherers(item);
      }
    }
    return (A) this;
  }
  
  public A withLastGatherDuration(String lastGatherDuration) {
    this.lastGatherDuration = lastGatherDuration;
    return (A) this;
  }
  
  public A withLastGatherTime(String lastGatherTime) {
    this.lastGatherTime = lastGatherTime;
    return (A) this;
  }
  public class GatherersNested<N> extends GathererStatusFluent<GatherersNested<N>> implements Nested<N>{
  
    GathererStatusBuilder builder;
    int index;
  
    GatherersNested(int index,GathererStatus item) {
      this.index = index;
      this.builder = new GathererStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) GatherStatusFluent.this.setToGatherers(index, builder.build());
    }
    
    public N endGatherer() {
      return and();
    }
    
  }
}