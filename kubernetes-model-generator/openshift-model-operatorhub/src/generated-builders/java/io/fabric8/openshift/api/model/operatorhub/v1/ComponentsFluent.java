package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class ComponentsFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1.ComponentsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder labelSelector;
  private ArrayList<RichReferenceBuilder> refs = new ArrayList<RichReferenceBuilder>();

  public ComponentsFluent() {
  }
  
  public ComponentsFluent(Components instance) {
    this.copyInstance(instance);
  }

  public A addAllToRefs(Collection<RichReference> items) {
    if (this.refs == null) {
      this.refs = new ArrayList();
    }
    for (RichReference item : items) {
        RichReferenceBuilder builder = new RichReferenceBuilder(item);
        _visitables.get("refs").add(builder);
        this.refs.add(builder);
    }
    return (A) this;
  }
  
  public RefsNested<A> addNewRef() {
    return new RefsNested(-1, null);
  }
  
  public RefsNested<A> addNewRefLike(RichReference item) {
    return new RefsNested(-1, item);
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
  
  public A addToRefs(RichReference... items) {
    if (this.refs == null) {
      this.refs = new ArrayList();
    }
    for (RichReference item : items) {
        RichReferenceBuilder builder = new RichReferenceBuilder(item);
        _visitables.get("refs").add(builder);
        this.refs.add(builder);
    }
    return (A) this;
  }
  
  public A addToRefs(int index,RichReference item) {
    if (this.refs == null) {
      this.refs = new ArrayList();
    }
    RichReferenceBuilder builder = new RichReferenceBuilder(item);
    if (index < 0 || index >= refs.size()) {
        _visitables.get("refs").add(builder);
        refs.add(builder);
    } else {
        _visitables.get("refs").add(builder);
        refs.add(index, builder);
    }
    return (A) this;
  }
  
  public RichReference buildFirstRef() {
    return this.refs.get(0).build();
  }
  
  public LabelSelector buildLabelSelector() {
    return this.labelSelector != null ? this.labelSelector.build() : null;
  }
  
  public RichReference buildLastRef() {
    return this.refs.get(refs.size() - 1).build();
  }
  
  public RichReference buildMatchingRef(Predicate<RichReferenceBuilder> predicate) {
      for (RichReferenceBuilder item : refs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RichReference buildRef(int index) {
    return this.refs.get(index).build();
  }
  
  public List<RichReference> buildRefs() {
    return this.refs != null ? build(refs) : null;
  }
  
  protected void copyInstance(Components instance) {
    instance = instance != null ? instance : new Components();
    if (instance != null) {
        this.withLabelSelector(instance.getLabelSelector());
        this.withRefs(instance.getRefs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RefsNested<A> editFirstRef() {
    if (refs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "refs"));
    }
    return this.setNewRefLike(0, this.buildRef(0));
  }
  
  public LabelSelectorNested<A> editLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(null));
  }
  
  public RefsNested<A> editLastRef() {
    int index = refs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "refs"));
    }
    return this.setNewRefLike(index, this.buildRef(index));
  }
  
  public RefsNested<A> editMatchingRef(Predicate<RichReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < refs.size();i++) {
      if (predicate.test(refs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "refs"));
    }
    return this.setNewRefLike(index, this.buildRef(index));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelectorLike(LabelSelector item) {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(item));
  }
  
  public RefsNested<A> editRef(int index) {
    if (refs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "refs"));
    }
    return this.setNewRefLike(index, this.buildRef(index));
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
    ComponentsFluent that = (ComponentsFluent) o;
    if (!(Objects.equals(labelSelector, that.labelSelector))) {
      return false;
    }
    if (!(Objects.equals(refs, that.refs))) {
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
  
  public boolean hasLabelSelector() {
    return this.labelSelector != null;
  }
  
  public boolean hasMatchingRef(Predicate<RichReferenceBuilder> predicate) {
      for (RichReferenceBuilder item : refs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRefs() {
    return this.refs != null && !(this.refs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(labelSelector, refs, additionalProperties);
  }
  
  public A removeAllFromRefs(Collection<RichReference> items) {
    if (this.refs == null) {
      return (A) this;
    }
    for (RichReference item : items) {
        RichReferenceBuilder builder = new RichReferenceBuilder(item);
        _visitables.get("refs").remove(builder);
        this.refs.remove(builder);
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
  
  public A removeFromRefs(RichReference... items) {
    if (this.refs == null) {
      return (A) this;
    }
    for (RichReference item : items) {
        RichReferenceBuilder builder = new RichReferenceBuilder(item);
        _visitables.get("refs").remove(builder);
        this.refs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRefs(Predicate<RichReferenceBuilder> predicate) {
    if (refs == null) {
      return (A) this;
    }
    Iterator<RichReferenceBuilder> each = refs.iterator();
    List visitables = _visitables.get("refs");
    while (each.hasNext()) {
        RichReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RefsNested<A> setNewRefLike(int index,RichReference item) {
    return new RefsNested(index, item);
  }
  
  public A setToRefs(int index,RichReference item) {
    if (this.refs == null) {
      this.refs = new ArrayList();
    }
    RichReferenceBuilder builder = new RichReferenceBuilder(item);
    if (index < 0 || index >= refs.size()) {
        _visitables.get("refs").add(builder);
        refs.add(builder);
    } else {
        _visitables.get("refs").add(builder);
        refs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(labelSelector == null)) {
        sb.append("labelSelector:");
        sb.append(labelSelector);
        sb.append(",");
    }
    if (!(refs == null) && !(refs.isEmpty())) {
        sb.append("refs:");
        sb.append(refs);
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
  
  public A withLabelSelector(LabelSelector labelSelector) {
    this._visitables.remove("labelSelector");
    if (labelSelector != null) {
        this.labelSelector = new LabelSelectorBuilder(labelSelector);
        this._visitables.get("labelSelector").add(this.labelSelector);
    } else {
        this.labelSelector = null;
        this._visitables.get("labelSelector").remove(this.labelSelector);
    }
    return (A) this;
  }
  
  public LabelSelectorNested<A> withNewLabelSelector() {
    return new LabelSelectorNested(null);
  }
  
  public LabelSelectorNested<A> withNewLabelSelectorLike(LabelSelector item) {
    return new LabelSelectorNested(item);
  }
  
  public A withRefs(List<RichReference> refs) {
    if (this.refs != null) {
      this._visitables.get("refs").clear();
    }
    if (refs != null) {
        this.refs = new ArrayList();
        for (RichReference item : refs) {
          this.addToRefs(item);
        }
    } else {
      this.refs = null;
    }
    return (A) this;
  }
  
  public A withRefs(RichReference... refs) {
    if (this.refs != null) {
        this.refs.clear();
        _visitables.remove("refs");
    }
    if (refs != null) {
      for (RichReference item : refs) {
        this.addToRefs(item);
      }
    }
    return (A) this;
  }
  public class LabelSelectorNested<N> extends LabelSelectorFluent<LabelSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    LabelSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ComponentsFluent.this.withLabelSelector(builder.build());
    }
    
    public N endLabelSelector() {
      return and();
    }
    
  }
  public class RefsNested<N> extends RichReferenceFluent<RefsNested<N>> implements Nested<N>{
  
    RichReferenceBuilder builder;
    int index;
  
    RefsNested(int index,RichReference item) {
      this.index = index;
      this.builder = new RichReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ComponentsFluent.this.setToRefs(index, builder.build());
    }
    
    public N endRef() {
      return and();
    }
    
  }
}