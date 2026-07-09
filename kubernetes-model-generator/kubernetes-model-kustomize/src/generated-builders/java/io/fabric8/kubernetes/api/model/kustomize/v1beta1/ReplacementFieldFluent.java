package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
public class ReplacementFieldFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.ReplacementFieldFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String path;
  private SourceSelectorBuilder source;
  private String sourceValue;
  private ArrayList<TargetSelectorBuilder> targets = new ArrayList<TargetSelectorBuilder>();

  public ReplacementFieldFluent() {
  }
  
  public ReplacementFieldFluent(ReplacementField instance) {
    this.copyInstance(instance);
  }

  public A addAllToTargets(Collection<TargetSelector> items) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    for (TargetSelector item : items) {
        TargetSelectorBuilder builder = new TargetSelectorBuilder(item);
        _visitables.get("targets").add(builder);
        this.targets.add(builder);
    }
    return (A) this;
  }
  
  public TargetsNested<A> addNewTarget() {
    return new TargetsNested(-1, null);
  }
  
  public TargetsNested<A> addNewTargetLike(TargetSelector item) {
    return new TargetsNested(-1, item);
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
  
  public A addToTargets(TargetSelector... items) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    for (TargetSelector item : items) {
        TargetSelectorBuilder builder = new TargetSelectorBuilder(item);
        _visitables.get("targets").add(builder);
        this.targets.add(builder);
    }
    return (A) this;
  }
  
  public A addToTargets(int index,TargetSelector item) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    TargetSelectorBuilder builder = new TargetSelectorBuilder(item);
    if (index < 0 || index >= targets.size()) {
        _visitables.get("targets").add(builder);
        targets.add(builder);
    } else {
        _visitables.get("targets").add(builder);
        targets.add(index, builder);
    }
    return (A) this;
  }
  
  public TargetSelector buildFirstTarget() {
    return this.targets.get(0).build();
  }
  
  public TargetSelector buildLastTarget() {
    return this.targets.get(targets.size() - 1).build();
  }
  
  public TargetSelector buildMatchingTarget(Predicate<TargetSelectorBuilder> predicate) {
      for (TargetSelectorBuilder item : targets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SourceSelector buildSource() {
    return this.source != null ? this.source.build() : null;
  }
  
  public TargetSelector buildTarget(int index) {
    return this.targets.get(index).build();
  }
  
  public List<TargetSelector> buildTargets() {
    return this.targets != null ? build(targets) : null;
  }
  
  protected void copyInstance(ReplacementField instance) {
    instance = instance != null ? instance : new ReplacementField();
    if (instance != null) {
        this.withPath(instance.getPath());
        this.withSource(instance.getSource());
        this.withSourceValue(instance.getSourceValue());
        this.withTargets(instance.getTargets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TargetsNested<A> editFirstTarget() {
    if (targets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targets"));
    }
    return this.setNewTargetLike(0, this.buildTarget(0));
  }
  
  public TargetsNested<A> editLastTarget() {
    int index = targets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targets"));
    }
    return this.setNewTargetLike(index, this.buildTarget(index));
  }
  
  public TargetsNested<A> editMatchingTarget(Predicate<TargetSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < targets.size();i++) {
      if (predicate.test(targets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "targets"));
    }
    return this.setNewTargetLike(index, this.buildTarget(index));
  }
  
  public SourceNested<A> editOrNewSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(new SourceSelectorBuilder().build()));
  }
  
  public SourceNested<A> editOrNewSourceLike(SourceSelector item) {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(item));
  }
  
  public SourceNested<A> editSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(null));
  }
  
  public TargetsNested<A> editTarget(int index) {
    if (targets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "targets"));
    }
    return this.setNewTargetLike(index, this.buildTarget(index));
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
    ReplacementFieldFluent that = (ReplacementFieldFluent) o;
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(sourceValue, that.sourceValue))) {
      return false;
    }
    if (!(Objects.equals(targets, that.targets))) {
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
  
  public String getPath() {
    return this.path;
  }
  
  public String getSourceValue() {
    return this.sourceValue;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingTarget(Predicate<TargetSelectorBuilder> predicate) {
      for (TargetSelectorBuilder item : targets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasSourceValue() {
    return this.sourceValue != null;
  }
  
  public boolean hasTargets() {
    return this.targets != null && !(this.targets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(path, source, sourceValue, targets, additionalProperties);
  }
  
  public A removeAllFromTargets(Collection<TargetSelector> items) {
    if (this.targets == null) {
      return (A) this;
    }
    for (TargetSelector item : items) {
        TargetSelectorBuilder builder = new TargetSelectorBuilder(item);
        _visitables.get("targets").remove(builder);
        this.targets.remove(builder);
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
  
  public A removeFromTargets(TargetSelector... items) {
    if (this.targets == null) {
      return (A) this;
    }
    for (TargetSelector item : items) {
        TargetSelectorBuilder builder = new TargetSelectorBuilder(item);
        _visitables.get("targets").remove(builder);
        this.targets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTargets(Predicate<TargetSelectorBuilder> predicate) {
    if (targets == null) {
      return (A) this;
    }
    Iterator<TargetSelectorBuilder> each = targets.iterator();
    List visitables = _visitables.get("targets");
    while (each.hasNext()) {
        TargetSelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TargetsNested<A> setNewTargetLike(int index,TargetSelector item) {
    return new TargetsNested(index, item);
  }
  
  public A setToTargets(int index,TargetSelector item) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    TargetSelectorBuilder builder = new TargetSelectorBuilder(item);
    if (index < 0 || index >= targets.size()) {
        _visitables.get("targets").add(builder);
        targets.add(builder);
    } else {
        _visitables.get("targets").add(builder);
        targets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(sourceValue == null)) {
        sb.append("sourceValue:");
        sb.append(sourceValue);
        sb.append(",");
    }
    if (!(targets == null) && !(targets.isEmpty())) {
        sb.append("targets:");
        sb.append(targets);
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
  
  public SourceNested<A> withNewSource() {
    return new SourceNested(null);
  }
  
  public SourceNested<A> withNewSourceLike(SourceSelector item) {
    return new SourceNested(item);
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withSource(SourceSelector source) {
    this._visitables.remove("source");
    if (source != null) {
        this.source = new SourceSelectorBuilder(source);
        this._visitables.get("source").add(this.source);
    } else {
        this.source = null;
        this._visitables.get("source").remove(this.source);
    }
    return (A) this;
  }
  
  public A withSourceValue(String sourceValue) {
    this.sourceValue = sourceValue;
    return (A) this;
  }
  
  public A withTargets(List<TargetSelector> targets) {
    if (this.targets != null) {
      this._visitables.get("targets").clear();
    }
    if (targets != null) {
        this.targets = new ArrayList();
        for (TargetSelector item : targets) {
          this.addToTargets(item);
        }
    } else {
      this.targets = null;
    }
    return (A) this;
  }
  
  public A withTargets(TargetSelector... targets) {
    if (this.targets != null) {
        this.targets.clear();
        _visitables.remove("targets");
    }
    if (targets != null) {
      for (TargetSelector item : targets) {
        this.addToTargets(item);
      }
    }
    return (A) this;
  }
  public class SourceNested<N> extends SourceSelectorFluent<SourceNested<N>> implements Nested<N>{
  
    SourceSelectorBuilder builder;
  
    SourceNested(SourceSelector item) {
      this.builder = new SourceSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ReplacementFieldFluent.this.withSource(builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
  public class TargetsNested<N> extends TargetSelectorFluent<TargetsNested<N>> implements Nested<N>{
  
    TargetSelectorBuilder builder;
    int index;
  
    TargetsNested(int index,TargetSelector item) {
      this.index = index;
      this.builder = new TargetSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ReplacementFieldFluent.this.setToTargets(index, builder.build());
    }
    
    public N endTarget() {
      return and();
    }
    
  }
}