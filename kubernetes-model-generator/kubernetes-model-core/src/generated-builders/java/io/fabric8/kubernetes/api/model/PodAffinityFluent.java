package io.fabric8.kubernetes.api.model;

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
public class PodAffinityFluent<A extends io.fabric8.kubernetes.api.model.PodAffinityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<WeightedPodAffinityTermBuilder> preferredDuringSchedulingIgnoredDuringExecution = new ArrayList<WeightedPodAffinityTermBuilder>();
  private ArrayList<PodAffinityTermBuilder> requiredDuringSchedulingIgnoredDuringExecution = new ArrayList<PodAffinityTermBuilder>();

  public PodAffinityFluent() {
  }
  
  public PodAffinityFluent(PodAffinity instance) {
    this.copyInstance(instance);
  }

  public A addAllToPreferredDuringSchedulingIgnoredDuringExecution(Collection<WeightedPodAffinityTerm> items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (WeightedPodAffinityTerm item : items) {
        WeightedPodAffinityTermBuilder builder = new WeightedPodAffinityTermBuilder(item);
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        this.preferredDuringSchedulingIgnoredDuringExecution.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRequiredDuringSchedulingIgnoredDuringExecution(Collection<PodAffinityTerm> items) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (PodAffinityTerm item : items) {
        PodAffinityTermBuilder builder = new PodAffinityTermBuilder(item);
        _visitables.get("requiredDuringSchedulingIgnoredDuringExecution").add(builder);
        this.requiredDuringSchedulingIgnoredDuringExecution.add(builder);
    }
    return (A) this;
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> addNewPreferredDuringSchedulingIgnoredDuringExecution() {
    return new PreferredDuringSchedulingIgnoredDuringExecutionNested(-1, null);
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> addNewPreferredDuringSchedulingIgnoredDuringExecutionLike(WeightedPodAffinityTerm item) {
    return new PreferredDuringSchedulingIgnoredDuringExecutionNested(-1, item);
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> addNewRequiredDuringSchedulingIgnoredDuringExecution() {
    return new RequiredDuringSchedulingIgnoredDuringExecutionNested(-1, null);
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> addNewRequiredDuringSchedulingIgnoredDuringExecutionLike(PodAffinityTerm item) {
    return new RequiredDuringSchedulingIgnoredDuringExecutionNested(-1, item);
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
  
  public A addToPreferredDuringSchedulingIgnoredDuringExecution(WeightedPodAffinityTerm... items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (WeightedPodAffinityTerm item : items) {
        WeightedPodAffinityTermBuilder builder = new WeightedPodAffinityTermBuilder(item);
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        this.preferredDuringSchedulingIgnoredDuringExecution.add(builder);
    }
    return (A) this;
  }
  
  public A addToPreferredDuringSchedulingIgnoredDuringExecution(int index,WeightedPodAffinityTerm item) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    WeightedPodAffinityTermBuilder builder = new WeightedPodAffinityTermBuilder(item);
    if (index < 0 || index >= preferredDuringSchedulingIgnoredDuringExecution.size()) {
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        preferredDuringSchedulingIgnoredDuringExecution.add(builder);
    } else {
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        preferredDuringSchedulingIgnoredDuringExecution.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRequiredDuringSchedulingIgnoredDuringExecution(PodAffinityTerm... items) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (PodAffinityTerm item : items) {
        PodAffinityTermBuilder builder = new PodAffinityTermBuilder(item);
        _visitables.get("requiredDuringSchedulingIgnoredDuringExecution").add(builder);
        this.requiredDuringSchedulingIgnoredDuringExecution.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequiredDuringSchedulingIgnoredDuringExecution(int index,PodAffinityTerm item) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    PodAffinityTermBuilder builder = new PodAffinityTermBuilder(item);
    if (index < 0 || index >= requiredDuringSchedulingIgnoredDuringExecution.size()) {
        _visitables.get("requiredDuringSchedulingIgnoredDuringExecution").add(builder);
        requiredDuringSchedulingIgnoredDuringExecution.add(builder);
    } else {
        _visitables.get("requiredDuringSchedulingIgnoredDuringExecution").add(builder);
        requiredDuringSchedulingIgnoredDuringExecution.add(index, builder);
    }
    return (A) this;
  }
  
  public WeightedPodAffinityTerm buildFirstPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution.get(0).build();
  }
  
  public PodAffinityTerm buildFirstRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.requiredDuringSchedulingIgnoredDuringExecution.get(0).build();
  }
  
  public WeightedPodAffinityTerm buildLastPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution.get(preferredDuringSchedulingIgnoredDuringExecution.size() - 1).build();
  }
  
  public PodAffinityTerm buildLastRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.requiredDuringSchedulingIgnoredDuringExecution.get(requiredDuringSchedulingIgnoredDuringExecution.size() - 1).build();
  }
  
  public WeightedPodAffinityTerm buildMatchingPreferredDuringSchedulingIgnoredDuringExecution(Predicate<WeightedPodAffinityTermBuilder> predicate) {
      for (WeightedPodAffinityTermBuilder item : preferredDuringSchedulingIgnoredDuringExecution) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodAffinityTerm buildMatchingRequiredDuringSchedulingIgnoredDuringExecution(Predicate<PodAffinityTermBuilder> predicate) {
      for (PodAffinityTermBuilder item : requiredDuringSchedulingIgnoredDuringExecution) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<WeightedPodAffinityTerm> buildPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution != null ? build(preferredDuringSchedulingIgnoredDuringExecution) : null;
  }
  
  public WeightedPodAffinityTerm buildPreferredDuringSchedulingIgnoredDuringExecution(int index) {
    return this.preferredDuringSchedulingIgnoredDuringExecution.get(index).build();
  }
  
  public List<PodAffinityTerm> buildRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.requiredDuringSchedulingIgnoredDuringExecution != null ? build(requiredDuringSchedulingIgnoredDuringExecution) : null;
  }
  
  public PodAffinityTerm buildRequiredDuringSchedulingIgnoredDuringExecution(int index) {
    return this.requiredDuringSchedulingIgnoredDuringExecution.get(index).build();
  }
  
  protected void copyInstance(PodAffinity instance) {
    instance = instance != null ? instance : new PodAffinity();
    if (instance != null) {
        this.withPreferredDuringSchedulingIgnoredDuringExecution(instance.getPreferredDuringSchedulingIgnoredDuringExecution());
        this.withRequiredDuringSchedulingIgnoredDuringExecution(instance.getRequiredDuringSchedulingIgnoredDuringExecution());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> editFirstPreferredDuringSchedulingIgnoredDuringExecution() {
    if (preferredDuringSchedulingIgnoredDuringExecution.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "preferredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewPreferredDuringSchedulingIgnoredDuringExecutionLike(0, this.buildPreferredDuringSchedulingIgnoredDuringExecution(0));
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> editFirstRequiredDuringSchedulingIgnoredDuringExecution() {
    if (requiredDuringSchedulingIgnoredDuringExecution.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "requiredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewRequiredDuringSchedulingIgnoredDuringExecutionLike(0, this.buildRequiredDuringSchedulingIgnoredDuringExecution(0));
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> editLastPreferredDuringSchedulingIgnoredDuringExecution() {
    int index = preferredDuringSchedulingIgnoredDuringExecution.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "preferredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewPreferredDuringSchedulingIgnoredDuringExecutionLike(index, this.buildPreferredDuringSchedulingIgnoredDuringExecution(index));
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> editLastRequiredDuringSchedulingIgnoredDuringExecution() {
    int index = requiredDuringSchedulingIgnoredDuringExecution.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "requiredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewRequiredDuringSchedulingIgnoredDuringExecutionLike(index, this.buildRequiredDuringSchedulingIgnoredDuringExecution(index));
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> editMatchingPreferredDuringSchedulingIgnoredDuringExecution(Predicate<WeightedPodAffinityTermBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < preferredDuringSchedulingIgnoredDuringExecution.size();i++) {
      if (predicate.test(preferredDuringSchedulingIgnoredDuringExecution.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "preferredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewPreferredDuringSchedulingIgnoredDuringExecutionLike(index, this.buildPreferredDuringSchedulingIgnoredDuringExecution(index));
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> editMatchingRequiredDuringSchedulingIgnoredDuringExecution(Predicate<PodAffinityTermBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < requiredDuringSchedulingIgnoredDuringExecution.size();i++) {
      if (predicate.test(requiredDuringSchedulingIgnoredDuringExecution.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "requiredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewRequiredDuringSchedulingIgnoredDuringExecutionLike(index, this.buildRequiredDuringSchedulingIgnoredDuringExecution(index));
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> editPreferredDuringSchedulingIgnoredDuringExecution(int index) {
    if (preferredDuringSchedulingIgnoredDuringExecution.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "preferredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewPreferredDuringSchedulingIgnoredDuringExecutionLike(index, this.buildPreferredDuringSchedulingIgnoredDuringExecution(index));
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> editRequiredDuringSchedulingIgnoredDuringExecution(int index) {
    if (requiredDuringSchedulingIgnoredDuringExecution.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "requiredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewRequiredDuringSchedulingIgnoredDuringExecutionLike(index, this.buildRequiredDuringSchedulingIgnoredDuringExecution(index));
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
    PodAffinityFluent that = (PodAffinityFluent) o;
    if (!(Objects.equals(preferredDuringSchedulingIgnoredDuringExecution, that.preferredDuringSchedulingIgnoredDuringExecution))) {
      return false;
    }
    if (!(Objects.equals(requiredDuringSchedulingIgnoredDuringExecution, that.requiredDuringSchedulingIgnoredDuringExecution))) {
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
  
  public boolean hasMatchingPreferredDuringSchedulingIgnoredDuringExecution(Predicate<WeightedPodAffinityTermBuilder> predicate) {
      for (WeightedPodAffinityTermBuilder item : preferredDuringSchedulingIgnoredDuringExecution) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequiredDuringSchedulingIgnoredDuringExecution(Predicate<PodAffinityTermBuilder> predicate) {
      for (PodAffinityTermBuilder item : requiredDuringSchedulingIgnoredDuringExecution) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution != null && !(this.preferredDuringSchedulingIgnoredDuringExecution.isEmpty());
  }
  
  public boolean hasRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.requiredDuringSchedulingIgnoredDuringExecution != null && !(this.requiredDuringSchedulingIgnoredDuringExecution.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(preferredDuringSchedulingIgnoredDuringExecution, requiredDuringSchedulingIgnoredDuringExecution, additionalProperties);
  }
  
  public A removeAllFromPreferredDuringSchedulingIgnoredDuringExecution(Collection<WeightedPodAffinityTerm> items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (WeightedPodAffinityTerm item : items) {
        WeightedPodAffinityTermBuilder builder = new WeightedPodAffinityTermBuilder(item);
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").remove(builder);
        this.preferredDuringSchedulingIgnoredDuringExecution.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRequiredDuringSchedulingIgnoredDuringExecution(Collection<PodAffinityTerm> items) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (PodAffinityTerm item : items) {
        PodAffinityTermBuilder builder = new PodAffinityTermBuilder(item);
        _visitables.get("requiredDuringSchedulingIgnoredDuringExecution").remove(builder);
        this.requiredDuringSchedulingIgnoredDuringExecution.remove(builder);
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
  
  public A removeFromPreferredDuringSchedulingIgnoredDuringExecution(WeightedPodAffinityTerm... items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (WeightedPodAffinityTerm item : items) {
        WeightedPodAffinityTermBuilder builder = new WeightedPodAffinityTermBuilder(item);
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").remove(builder);
        this.preferredDuringSchedulingIgnoredDuringExecution.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRequiredDuringSchedulingIgnoredDuringExecution(PodAffinityTerm... items) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (PodAffinityTerm item : items) {
        PodAffinityTermBuilder builder = new PodAffinityTermBuilder(item);
        _visitables.get("requiredDuringSchedulingIgnoredDuringExecution").remove(builder);
        this.requiredDuringSchedulingIgnoredDuringExecution.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPreferredDuringSchedulingIgnoredDuringExecution(Predicate<WeightedPodAffinityTermBuilder> predicate) {
    if (preferredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    Iterator<WeightedPodAffinityTermBuilder> each = preferredDuringSchedulingIgnoredDuringExecution.iterator();
    List visitables = _visitables.get("preferredDuringSchedulingIgnoredDuringExecution");
    while (each.hasNext()) {
        WeightedPodAffinityTermBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequiredDuringSchedulingIgnoredDuringExecution(Predicate<PodAffinityTermBuilder> predicate) {
    if (requiredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    Iterator<PodAffinityTermBuilder> each = requiredDuringSchedulingIgnoredDuringExecution.iterator();
    List visitables = _visitables.get("requiredDuringSchedulingIgnoredDuringExecution");
    while (each.hasNext()) {
        PodAffinityTermBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> setNewPreferredDuringSchedulingIgnoredDuringExecutionLike(int index,WeightedPodAffinityTerm item) {
    return new PreferredDuringSchedulingIgnoredDuringExecutionNested(index, item);
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> setNewRequiredDuringSchedulingIgnoredDuringExecutionLike(int index,PodAffinityTerm item) {
    return new RequiredDuringSchedulingIgnoredDuringExecutionNested(index, item);
  }
  
  public A setToPreferredDuringSchedulingIgnoredDuringExecution(int index,WeightedPodAffinityTerm item) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    WeightedPodAffinityTermBuilder builder = new WeightedPodAffinityTermBuilder(item);
    if (index < 0 || index >= preferredDuringSchedulingIgnoredDuringExecution.size()) {
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        preferredDuringSchedulingIgnoredDuringExecution.add(builder);
    } else {
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        preferredDuringSchedulingIgnoredDuringExecution.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRequiredDuringSchedulingIgnoredDuringExecution(int index,PodAffinityTerm item) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution == null) {
      this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    PodAffinityTermBuilder builder = new PodAffinityTermBuilder(item);
    if (index < 0 || index >= requiredDuringSchedulingIgnoredDuringExecution.size()) {
        _visitables.get("requiredDuringSchedulingIgnoredDuringExecution").add(builder);
        requiredDuringSchedulingIgnoredDuringExecution.add(builder);
    } else {
        _visitables.get("requiredDuringSchedulingIgnoredDuringExecution").add(builder);
        requiredDuringSchedulingIgnoredDuringExecution.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(preferredDuringSchedulingIgnoredDuringExecution == null) && !(preferredDuringSchedulingIgnoredDuringExecution.isEmpty())) {
        sb.append("preferredDuringSchedulingIgnoredDuringExecution:");
        sb.append(preferredDuringSchedulingIgnoredDuringExecution);
        sb.append(",");
    }
    if (!(requiredDuringSchedulingIgnoredDuringExecution == null) && !(requiredDuringSchedulingIgnoredDuringExecution.isEmpty())) {
        sb.append("requiredDuringSchedulingIgnoredDuringExecution:");
        sb.append(requiredDuringSchedulingIgnoredDuringExecution);
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
  
  public A withPreferredDuringSchedulingIgnoredDuringExecution(List<WeightedPodAffinityTerm> preferredDuringSchedulingIgnoredDuringExecution) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution != null) {
      this._visitables.get("preferredDuringSchedulingIgnoredDuringExecution").clear();
    }
    if (preferredDuringSchedulingIgnoredDuringExecution != null) {
        this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
        for (WeightedPodAffinityTerm item : preferredDuringSchedulingIgnoredDuringExecution) {
          this.addToPreferredDuringSchedulingIgnoredDuringExecution(item);
        }
    } else {
      this.preferredDuringSchedulingIgnoredDuringExecution = null;
    }
    return (A) this;
  }
  
  public A withPreferredDuringSchedulingIgnoredDuringExecution(WeightedPodAffinityTerm... preferredDuringSchedulingIgnoredDuringExecution) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution != null) {
        this.preferredDuringSchedulingIgnoredDuringExecution.clear();
        _visitables.remove("preferredDuringSchedulingIgnoredDuringExecution");
    }
    if (preferredDuringSchedulingIgnoredDuringExecution != null) {
      for (WeightedPodAffinityTerm item : preferredDuringSchedulingIgnoredDuringExecution) {
        this.addToPreferredDuringSchedulingIgnoredDuringExecution(item);
      }
    }
    return (A) this;
  }
  
  public A withRequiredDuringSchedulingIgnoredDuringExecution(List<PodAffinityTerm> requiredDuringSchedulingIgnoredDuringExecution) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution != null) {
      this._visitables.get("requiredDuringSchedulingIgnoredDuringExecution").clear();
    }
    if (requiredDuringSchedulingIgnoredDuringExecution != null) {
        this.requiredDuringSchedulingIgnoredDuringExecution = new ArrayList();
        for (PodAffinityTerm item : requiredDuringSchedulingIgnoredDuringExecution) {
          this.addToRequiredDuringSchedulingIgnoredDuringExecution(item);
        }
    } else {
      this.requiredDuringSchedulingIgnoredDuringExecution = null;
    }
    return (A) this;
  }
  
  public A withRequiredDuringSchedulingIgnoredDuringExecution(PodAffinityTerm... requiredDuringSchedulingIgnoredDuringExecution) {
    if (this.requiredDuringSchedulingIgnoredDuringExecution != null) {
        this.requiredDuringSchedulingIgnoredDuringExecution.clear();
        _visitables.remove("requiredDuringSchedulingIgnoredDuringExecution");
    }
    if (requiredDuringSchedulingIgnoredDuringExecution != null) {
      for (PodAffinityTerm item : requiredDuringSchedulingIgnoredDuringExecution) {
        this.addToRequiredDuringSchedulingIgnoredDuringExecution(item);
      }
    }
    return (A) this;
  }
  public class PreferredDuringSchedulingIgnoredDuringExecutionNested<N> extends WeightedPodAffinityTermFluent<PreferredDuringSchedulingIgnoredDuringExecutionNested<N>> implements Nested<N>{
  
    WeightedPodAffinityTermBuilder builder;
    int index;
  
    PreferredDuringSchedulingIgnoredDuringExecutionNested(int index,WeightedPodAffinityTerm item) {
      this.index = index;
      this.builder = new WeightedPodAffinityTermBuilder(this, item);
    }
  
    public N and() {
      return (N) PodAffinityFluent.this.setToPreferredDuringSchedulingIgnoredDuringExecution(index, builder.build());
    }
    
    public N endPreferredDuringSchedulingIgnoredDuringExecution() {
      return and();
    }
    
  }
  public class RequiredDuringSchedulingIgnoredDuringExecutionNested<N> extends PodAffinityTermFluent<RequiredDuringSchedulingIgnoredDuringExecutionNested<N>> implements Nested<N>{
  
    PodAffinityTermBuilder builder;
    int index;
  
    RequiredDuringSchedulingIgnoredDuringExecutionNested(int index,PodAffinityTerm item) {
      this.index = index;
      this.builder = new PodAffinityTermBuilder(this, item);
    }
  
    public N and() {
      return (N) PodAffinityFluent.this.setToRequiredDuringSchedulingIgnoredDuringExecution(index, builder.build());
    }
    
    public N endRequiredDuringSchedulingIgnoredDuringExecution() {
      return and();
    }
    
  }
}