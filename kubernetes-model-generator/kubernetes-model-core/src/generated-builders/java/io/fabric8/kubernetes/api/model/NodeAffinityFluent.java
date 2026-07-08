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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NodeAffinityFluent<A extends io.fabric8.kubernetes.api.model.NodeAffinityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PreferredSchedulingTermBuilder> preferredDuringSchedulingIgnoredDuringExecution = new ArrayList<PreferredSchedulingTermBuilder>();
  private NodeSelectorBuilder requiredDuringSchedulingIgnoredDuringExecution;

  public NodeAffinityFluent() {
  }
  
  public NodeAffinityFluent(NodeAffinity instance) {
    this.copyInstance(instance);
  }

  public A addAllToPreferredDuringSchedulingIgnoredDuringExecution(Collection<PreferredSchedulingTerm> items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (PreferredSchedulingTerm item : items) {
        PreferredSchedulingTermBuilder builder = new PreferredSchedulingTermBuilder(item);
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        this.preferredDuringSchedulingIgnoredDuringExecution.add(builder);
    }
    return (A) this;
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> addNewPreferredDuringSchedulingIgnoredDuringExecution() {
    return new PreferredDuringSchedulingIgnoredDuringExecutionNested(-1, null);
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> addNewPreferredDuringSchedulingIgnoredDuringExecutionLike(PreferredSchedulingTerm item) {
    return new PreferredDuringSchedulingIgnoredDuringExecutionNested(-1, item);
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
  
  public A addToPreferredDuringSchedulingIgnoredDuringExecution(PreferredSchedulingTerm... items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    for (PreferredSchedulingTerm item : items) {
        PreferredSchedulingTermBuilder builder = new PreferredSchedulingTermBuilder(item);
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        this.preferredDuringSchedulingIgnoredDuringExecution.add(builder);
    }
    return (A) this;
  }
  
  public A addToPreferredDuringSchedulingIgnoredDuringExecution(int index,PreferredSchedulingTerm item) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    PreferredSchedulingTermBuilder builder = new PreferredSchedulingTermBuilder(item);
    if (index < 0 || index >= preferredDuringSchedulingIgnoredDuringExecution.size()) {
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        preferredDuringSchedulingIgnoredDuringExecution.add(builder);
    } else {
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        preferredDuringSchedulingIgnoredDuringExecution.add(index, builder);
    }
    return (A) this;
  }
  
  public PreferredSchedulingTerm buildFirstPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution.get(0).build();
  }
  
  public PreferredSchedulingTerm buildLastPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution.get(preferredDuringSchedulingIgnoredDuringExecution.size() - 1).build();
  }
  
  public PreferredSchedulingTerm buildMatchingPreferredDuringSchedulingIgnoredDuringExecution(Predicate<PreferredSchedulingTermBuilder> predicate) {
      for (PreferredSchedulingTermBuilder item : preferredDuringSchedulingIgnoredDuringExecution) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<PreferredSchedulingTerm> buildPreferredDuringSchedulingIgnoredDuringExecution() {
    return this.preferredDuringSchedulingIgnoredDuringExecution != null ? build(preferredDuringSchedulingIgnoredDuringExecution) : null;
  }
  
  public PreferredSchedulingTerm buildPreferredDuringSchedulingIgnoredDuringExecution(int index) {
    return this.preferredDuringSchedulingIgnoredDuringExecution.get(index).build();
  }
  
  public NodeSelector buildRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.requiredDuringSchedulingIgnoredDuringExecution != null ? this.requiredDuringSchedulingIgnoredDuringExecution.build() : null;
  }
  
  protected void copyInstance(NodeAffinity instance) {
    instance = instance != null ? instance : new NodeAffinity();
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
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> editLastPreferredDuringSchedulingIgnoredDuringExecution() {
    int index = preferredDuringSchedulingIgnoredDuringExecution.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "preferredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewPreferredDuringSchedulingIgnoredDuringExecutionLike(index, this.buildPreferredDuringSchedulingIgnoredDuringExecution(index));
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> editMatchingPreferredDuringSchedulingIgnoredDuringExecution(Predicate<PreferredSchedulingTermBuilder> predicate) {
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
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> editOrNewRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.withNewRequiredDuringSchedulingIgnoredDuringExecutionLike(Optional.ofNullable(this.buildRequiredDuringSchedulingIgnoredDuringExecution()).orElse(new NodeSelectorBuilder().build()));
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> editOrNewRequiredDuringSchedulingIgnoredDuringExecutionLike(NodeSelector item) {
    return this.withNewRequiredDuringSchedulingIgnoredDuringExecutionLike(Optional.ofNullable(this.buildRequiredDuringSchedulingIgnoredDuringExecution()).orElse(item));
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> editPreferredDuringSchedulingIgnoredDuringExecution(int index) {
    if (preferredDuringSchedulingIgnoredDuringExecution.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "preferredDuringSchedulingIgnoredDuringExecution"));
    }
    return this.setNewPreferredDuringSchedulingIgnoredDuringExecutionLike(index, this.buildPreferredDuringSchedulingIgnoredDuringExecution(index));
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> editRequiredDuringSchedulingIgnoredDuringExecution() {
    return this.withNewRequiredDuringSchedulingIgnoredDuringExecutionLike(Optional.ofNullable(this.buildRequiredDuringSchedulingIgnoredDuringExecution()).orElse(null));
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
    NodeAffinityFluent that = (NodeAffinityFluent) o;
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
  
  public boolean hasMatchingPreferredDuringSchedulingIgnoredDuringExecution(Predicate<PreferredSchedulingTermBuilder> predicate) {
      for (PreferredSchedulingTermBuilder item : preferredDuringSchedulingIgnoredDuringExecution) {
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
    return this.requiredDuringSchedulingIgnoredDuringExecution != null;
  }
  
  public int hashCode() {
    return Objects.hash(preferredDuringSchedulingIgnoredDuringExecution, requiredDuringSchedulingIgnoredDuringExecution, additionalProperties);
  }
  
  public A removeAllFromPreferredDuringSchedulingIgnoredDuringExecution(Collection<PreferredSchedulingTerm> items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (PreferredSchedulingTerm item : items) {
        PreferredSchedulingTermBuilder builder = new PreferredSchedulingTermBuilder(item);
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").remove(builder);
        this.preferredDuringSchedulingIgnoredDuringExecution.remove(builder);
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
  
  public A removeFromPreferredDuringSchedulingIgnoredDuringExecution(PreferredSchedulingTerm... items) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    for (PreferredSchedulingTerm item : items) {
        PreferredSchedulingTermBuilder builder = new PreferredSchedulingTermBuilder(item);
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").remove(builder);
        this.preferredDuringSchedulingIgnoredDuringExecution.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPreferredDuringSchedulingIgnoredDuringExecution(Predicate<PreferredSchedulingTermBuilder> predicate) {
    if (preferredDuringSchedulingIgnoredDuringExecution == null) {
      return (A) this;
    }
    Iterator<PreferredSchedulingTermBuilder> each = preferredDuringSchedulingIgnoredDuringExecution.iterator();
    List visitables = _visitables.get("preferredDuringSchedulingIgnoredDuringExecution");
    while (each.hasNext()) {
        PreferredSchedulingTermBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PreferredDuringSchedulingIgnoredDuringExecutionNested<A> setNewPreferredDuringSchedulingIgnoredDuringExecutionLike(int index,PreferredSchedulingTerm item) {
    return new PreferredDuringSchedulingIgnoredDuringExecutionNested(index, item);
  }
  
  public A setToPreferredDuringSchedulingIgnoredDuringExecution(int index,PreferredSchedulingTerm item) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution == null) {
      this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
    }
    PreferredSchedulingTermBuilder builder = new PreferredSchedulingTermBuilder(item);
    if (index < 0 || index >= preferredDuringSchedulingIgnoredDuringExecution.size()) {
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        preferredDuringSchedulingIgnoredDuringExecution.add(builder);
    } else {
        _visitables.get("preferredDuringSchedulingIgnoredDuringExecution").add(builder);
        preferredDuringSchedulingIgnoredDuringExecution.set(index, builder);
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
    if (!(requiredDuringSchedulingIgnoredDuringExecution == null)) {
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
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> withNewRequiredDuringSchedulingIgnoredDuringExecution() {
    return new RequiredDuringSchedulingIgnoredDuringExecutionNested(null);
  }
  
  public RequiredDuringSchedulingIgnoredDuringExecutionNested<A> withNewRequiredDuringSchedulingIgnoredDuringExecutionLike(NodeSelector item) {
    return new RequiredDuringSchedulingIgnoredDuringExecutionNested(item);
  }
  
  public A withPreferredDuringSchedulingIgnoredDuringExecution(List<PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution != null) {
      this._visitables.get("preferredDuringSchedulingIgnoredDuringExecution").clear();
    }
    if (preferredDuringSchedulingIgnoredDuringExecution != null) {
        this.preferredDuringSchedulingIgnoredDuringExecution = new ArrayList();
        for (PreferredSchedulingTerm item : preferredDuringSchedulingIgnoredDuringExecution) {
          this.addToPreferredDuringSchedulingIgnoredDuringExecution(item);
        }
    } else {
      this.preferredDuringSchedulingIgnoredDuringExecution = null;
    }
    return (A) this;
  }
  
  public A withPreferredDuringSchedulingIgnoredDuringExecution(PreferredSchedulingTerm... preferredDuringSchedulingIgnoredDuringExecution) {
    if (this.preferredDuringSchedulingIgnoredDuringExecution != null) {
        this.preferredDuringSchedulingIgnoredDuringExecution.clear();
        _visitables.remove("preferredDuringSchedulingIgnoredDuringExecution");
    }
    if (preferredDuringSchedulingIgnoredDuringExecution != null) {
      for (PreferredSchedulingTerm item : preferredDuringSchedulingIgnoredDuringExecution) {
        this.addToPreferredDuringSchedulingIgnoredDuringExecution(item);
      }
    }
    return (A) this;
  }
  
  public A withRequiredDuringSchedulingIgnoredDuringExecution(NodeSelector requiredDuringSchedulingIgnoredDuringExecution) {
    this._visitables.remove("requiredDuringSchedulingIgnoredDuringExecution");
    if (requiredDuringSchedulingIgnoredDuringExecution != null) {
        this.requiredDuringSchedulingIgnoredDuringExecution = new NodeSelectorBuilder(requiredDuringSchedulingIgnoredDuringExecution);
        this._visitables.get("requiredDuringSchedulingIgnoredDuringExecution").add(this.requiredDuringSchedulingIgnoredDuringExecution);
    } else {
        this.requiredDuringSchedulingIgnoredDuringExecution = null;
        this._visitables.get("requiredDuringSchedulingIgnoredDuringExecution").remove(this.requiredDuringSchedulingIgnoredDuringExecution);
    }
    return (A) this;
  }
  public class PreferredDuringSchedulingIgnoredDuringExecutionNested<N> extends PreferredSchedulingTermFluent<PreferredDuringSchedulingIgnoredDuringExecutionNested<N>> implements Nested<N>{
  
    PreferredSchedulingTermBuilder builder;
    int index;
  
    PreferredDuringSchedulingIgnoredDuringExecutionNested(int index,PreferredSchedulingTerm item) {
      this.index = index;
      this.builder = new PreferredSchedulingTermBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeAffinityFluent.this.setToPreferredDuringSchedulingIgnoredDuringExecution(index, builder.build());
    }
    
    public N endPreferredDuringSchedulingIgnoredDuringExecution() {
      return and();
    }
    
  }
  public class RequiredDuringSchedulingIgnoredDuringExecutionNested<N> extends NodeSelectorFluent<RequiredDuringSchedulingIgnoredDuringExecutionNested<N>> implements Nested<N>{
  
    NodeSelectorBuilder builder;
  
    RequiredDuringSchedulingIgnoredDuringExecutionNested(NodeSelector item) {
      this.builder = new NodeSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeAffinityFluent.this.withRequiredDuringSchedulingIgnoredDuringExecution(builder.build());
    }
    
    public N endRequiredDuringSchedulingIgnoredDuringExecution() {
      return and();
    }
    
  }
}