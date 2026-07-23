package io.fabric8.chaosmesh.v1alpha1;

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
public class ConditionalBranchesStatusFluent<A extends io.fabric8.chaosmesh.v1alpha1.ConditionalBranchesStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ConditionalBranchStatusBuilder> branches = new ArrayList<ConditionalBranchStatusBuilder>();
  private List<String> context = new ArrayList<String>();

  public ConditionalBranchesStatusFluent() {
  }
  
  public ConditionalBranchesStatusFluent(ConditionalBranchesStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToBranches(Collection<ConditionalBranchStatus> items) {
    if (this.branches == null) {
      this.branches = new ArrayList();
    }
    for (ConditionalBranchStatus item : items) {
        ConditionalBranchStatusBuilder builder = new ConditionalBranchStatusBuilder(item);
        _visitables.get("branches").add(builder);
        this.branches.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToContext(Collection<String> items) {
    if (this.context == null) {
      this.context = new ArrayList();
    }
    for (String item : items) {
      this.context.add(item);
    }
    return (A) this;
  }
  
  public BranchesNested<A> addNewBranch() {
    return new BranchesNested(-1, null);
  }
  
  public A addNewBranch(String evaluationResult,String target) {
    return (A) this.addToBranches(new ConditionalBranchStatus(evaluationResult, target));
  }
  
  public BranchesNested<A> addNewBranchLike(ConditionalBranchStatus item) {
    return new BranchesNested(-1, item);
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
  
  public A addToBranches(ConditionalBranchStatus... items) {
    if (this.branches == null) {
      this.branches = new ArrayList();
    }
    for (ConditionalBranchStatus item : items) {
        ConditionalBranchStatusBuilder builder = new ConditionalBranchStatusBuilder(item);
        _visitables.get("branches").add(builder);
        this.branches.add(builder);
    }
    return (A) this;
  }
  
  public A addToBranches(int index,ConditionalBranchStatus item) {
    if (this.branches == null) {
      this.branches = new ArrayList();
    }
    ConditionalBranchStatusBuilder builder = new ConditionalBranchStatusBuilder(item);
    if (index < 0 || index >= branches.size()) {
        _visitables.get("branches").add(builder);
        branches.add(builder);
    } else {
        _visitables.get("branches").add(builder);
        branches.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToContext(String... items) {
    if (this.context == null) {
      this.context = new ArrayList();
    }
    for (String item : items) {
      this.context.add(item);
    }
    return (A) this;
  }
  
  public A addToContext(int index,String item) {
    if (this.context == null) {
      this.context = new ArrayList();
    }
    this.context.add(index, item);
    return (A) this;
  }
  
  public ConditionalBranchStatus buildBranch(int index) {
    return this.branches.get(index).build();
  }
  
  public List<ConditionalBranchStatus> buildBranches() {
    return this.branches != null ? build(branches) : null;
  }
  
  public ConditionalBranchStatus buildFirstBranch() {
    return this.branches.get(0).build();
  }
  
  public ConditionalBranchStatus buildLastBranch() {
    return this.branches.get(branches.size() - 1).build();
  }
  
  public ConditionalBranchStatus buildMatchingBranch(Predicate<ConditionalBranchStatusBuilder> predicate) {
      for (ConditionalBranchStatusBuilder item : branches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ConditionalBranchesStatus instance) {
    instance = instance != null ? instance : new ConditionalBranchesStatus();
    if (instance != null) {
        this.withBranches(instance.getBranches());
        this.withContext(instance.getContext());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BranchesNested<A> editBranch(int index) {
    if (branches.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "branches"));
    }
    return this.setNewBranchLike(index, this.buildBranch(index));
  }
  
  public BranchesNested<A> editFirstBranch() {
    if (branches.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "branches"));
    }
    return this.setNewBranchLike(0, this.buildBranch(0));
  }
  
  public BranchesNested<A> editLastBranch() {
    int index = branches.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "branches"));
    }
    return this.setNewBranchLike(index, this.buildBranch(index));
  }
  
  public BranchesNested<A> editMatchingBranch(Predicate<ConditionalBranchStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < branches.size();i++) {
      if (predicate.test(branches.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "branches"));
    }
    return this.setNewBranchLike(index, this.buildBranch(index));
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
    ConditionalBranchesStatusFluent that = (ConditionalBranchesStatusFluent) o;
    if (!(Objects.equals(branches, that.branches))) {
      return false;
    }
    if (!(Objects.equals(context, that.context))) {
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
  
  public List<String> getContext() {
    return this.context;
  }
  
  public String getContext(int index) {
    return this.context.get(index);
  }
  
  public String getFirstContext() {
    return this.context.get(0);
  }
  
  public String getLastContext() {
    return this.context.get(context.size() - 1);
  }
  
  public String getMatchingContext(Predicate<String> predicate) {
      for (String item : context) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBranches() {
    return this.branches != null && !(this.branches.isEmpty());
  }
  
  public boolean hasContext() {
    return this.context != null && !(this.context.isEmpty());
  }
  
  public boolean hasMatchingBranch(Predicate<ConditionalBranchStatusBuilder> predicate) {
      for (ConditionalBranchStatusBuilder item : branches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingContext(Predicate<String> predicate) {
      for (String item : context) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(branches, context, additionalProperties);
  }
  
  public A removeAllFromBranches(Collection<ConditionalBranchStatus> items) {
    if (this.branches == null) {
      return (A) this;
    }
    for (ConditionalBranchStatus item : items) {
        ConditionalBranchStatusBuilder builder = new ConditionalBranchStatusBuilder(item);
        _visitables.get("branches").remove(builder);
        this.branches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromContext(Collection<String> items) {
    if (this.context == null) {
      return (A) this;
    }
    for (String item : items) {
      this.context.remove(item);
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
  
  public A removeFromBranches(ConditionalBranchStatus... items) {
    if (this.branches == null) {
      return (A) this;
    }
    for (ConditionalBranchStatus item : items) {
        ConditionalBranchStatusBuilder builder = new ConditionalBranchStatusBuilder(item);
        _visitables.get("branches").remove(builder);
        this.branches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromContext(String... items) {
    if (this.context == null) {
      return (A) this;
    }
    for (String item : items) {
      this.context.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBranches(Predicate<ConditionalBranchStatusBuilder> predicate) {
    if (branches == null) {
      return (A) this;
    }
    Iterator<ConditionalBranchStatusBuilder> each = branches.iterator();
    List visitables = _visitables.get("branches");
    while (each.hasNext()) {
        ConditionalBranchStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BranchesNested<A> setNewBranchLike(int index,ConditionalBranchStatus item) {
    return new BranchesNested(index, item);
  }
  
  public A setToBranches(int index,ConditionalBranchStatus item) {
    if (this.branches == null) {
      this.branches = new ArrayList();
    }
    ConditionalBranchStatusBuilder builder = new ConditionalBranchStatusBuilder(item);
    if (index < 0 || index >= branches.size()) {
        _visitables.get("branches").add(builder);
        branches.add(builder);
    } else {
        _visitables.get("branches").add(builder);
        branches.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToContext(int index,String item) {
    if (this.context == null) {
      this.context = new ArrayList();
    }
    this.context.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(branches == null) && !(branches.isEmpty())) {
        sb.append("branches:");
        sb.append(branches);
        sb.append(",");
    }
    if (!(context == null) && !(context.isEmpty())) {
        sb.append("context:");
        sb.append(context);
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
  
  public A withBranches(List<ConditionalBranchStatus> branches) {
    if (this.branches != null) {
      this._visitables.get("branches").clear();
    }
    if (branches != null) {
        this.branches = new ArrayList();
        for (ConditionalBranchStatus item : branches) {
          this.addToBranches(item);
        }
    } else {
      this.branches = null;
    }
    return (A) this;
  }
  
  public A withBranches(ConditionalBranchStatus... branches) {
    if (this.branches != null) {
        this.branches.clear();
        _visitables.remove("branches");
    }
    if (branches != null) {
      for (ConditionalBranchStatus item : branches) {
        this.addToBranches(item);
      }
    }
    return (A) this;
  }
  
  public A withContext(List<String> context) {
    if (context != null) {
        this.context = new ArrayList();
        for (String item : context) {
          this.addToContext(item);
        }
    } else {
      this.context = null;
    }
    return (A) this;
  }
  
  public A withContext(String... context) {
    if (this.context != null) {
        this.context.clear();
        _visitables.remove("context");
    }
    if (context != null) {
      for (String item : context) {
        this.addToContext(item);
      }
    }
    return (A) this;
  }
  public class BranchesNested<N> extends ConditionalBranchStatusFluent<BranchesNested<N>> implements Nested<N>{
  
    ConditionalBranchStatusBuilder builder;
    int index;
  
    BranchesNested(int index,ConditionalBranchStatus item) {
      this.index = index;
      this.builder = new ConditionalBranchStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ConditionalBranchesStatusFluent.this.setToBranches(index, builder.build());
    }
    
    public N endBranch() {
      return and();
    }
    
  }
}