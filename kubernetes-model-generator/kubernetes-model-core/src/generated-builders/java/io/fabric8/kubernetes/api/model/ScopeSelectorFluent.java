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
public class ScopeSelectorFluent<A extends io.fabric8.kubernetes.api.model.ScopeSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ScopedResourceSelectorRequirementBuilder> matchExpressions = new ArrayList<ScopedResourceSelectorRequirementBuilder>();

  public ScopeSelectorFluent() {
  }
  
  public ScopeSelectorFluent(ScopeSelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchExpressions(Collection<ScopedResourceSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (ScopedResourceSelectorRequirement item : items) {
        ScopedResourceSelectorRequirementBuilder builder = new ScopedResourceSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").add(builder);
        this.matchExpressions.add(builder);
    }
    return (A) this;
  }
  
  public MatchExpressionsNested<A> addNewMatchExpression() {
    return new MatchExpressionsNested(-1, null);
  }
  
  public MatchExpressionsNested<A> addNewMatchExpressionLike(ScopedResourceSelectorRequirement item) {
    return new MatchExpressionsNested(-1, item);
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
  
  public A addToMatchExpressions(ScopedResourceSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (ScopedResourceSelectorRequirement item : items) {
        ScopedResourceSelectorRequirementBuilder builder = new ScopedResourceSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").add(builder);
        this.matchExpressions.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchExpressions(int index,ScopedResourceSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    ScopedResourceSelectorRequirementBuilder builder = new ScopedResourceSelectorRequirementBuilder(item);
    if (index < 0 || index >= matchExpressions.size()) {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.add(builder);
    } else {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.add(index, builder);
    }
    return (A) this;
  }
  
  public ScopedResourceSelectorRequirement buildFirstMatchExpression() {
    return this.matchExpressions.get(0).build();
  }
  
  public ScopedResourceSelectorRequirement buildLastMatchExpression() {
    return this.matchExpressions.get(matchExpressions.size() - 1).build();
  }
  
  public ScopedResourceSelectorRequirement buildMatchExpression(int index) {
    return this.matchExpressions.get(index).build();
  }
  
  public List<ScopedResourceSelectorRequirement> buildMatchExpressions() {
    return this.matchExpressions != null ? build(matchExpressions) : null;
  }
  
  public ScopedResourceSelectorRequirement buildMatchingMatchExpression(Predicate<ScopedResourceSelectorRequirementBuilder> predicate) {
      for (ScopedResourceSelectorRequirementBuilder item : matchExpressions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ScopeSelector instance) {
    instance = instance != null ? instance : new ScopeSelector();
    if (instance != null) {
        this.withMatchExpressions(instance.getMatchExpressions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchExpressionsNested<A> editFirstMatchExpression() {
    if (matchExpressions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matchExpressions"));
    }
    return this.setNewMatchExpressionLike(0, this.buildMatchExpression(0));
  }
  
  public MatchExpressionsNested<A> editLastMatchExpression() {
    int index = matchExpressions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matchExpressions"));
    }
    return this.setNewMatchExpressionLike(index, this.buildMatchExpression(index));
  }
  
  public MatchExpressionsNested<A> editMatchExpression(int index) {
    if (matchExpressions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "matchExpressions"));
    }
    return this.setNewMatchExpressionLike(index, this.buildMatchExpression(index));
  }
  
  public MatchExpressionsNested<A> editMatchingMatchExpression(Predicate<ScopedResourceSelectorRequirementBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < matchExpressions.size();i++) {
      if (predicate.test(matchExpressions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "matchExpressions"));
    }
    return this.setNewMatchExpressionLike(index, this.buildMatchExpression(index));
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
    ScopeSelectorFluent that = (ScopeSelectorFluent) o;
    if (!(Objects.equals(matchExpressions, that.matchExpressions))) {
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
  
  public boolean hasMatchExpressions() {
    return this.matchExpressions != null && !(this.matchExpressions.isEmpty());
  }
  
  public boolean hasMatchingMatchExpression(Predicate<ScopedResourceSelectorRequirementBuilder> predicate) {
      for (ScopedResourceSelectorRequirementBuilder item : matchExpressions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(matchExpressions, additionalProperties);
  }
  
  public A removeAllFromMatchExpressions(Collection<ScopedResourceSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (ScopedResourceSelectorRequirement item : items) {
        ScopedResourceSelectorRequirementBuilder builder = new ScopedResourceSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").remove(builder);
        this.matchExpressions.remove(builder);
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
  
  public A removeFromMatchExpressions(ScopedResourceSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (ScopedResourceSelectorRequirement item : items) {
        ScopedResourceSelectorRequirementBuilder builder = new ScopedResourceSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").remove(builder);
        this.matchExpressions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatchExpressions(Predicate<ScopedResourceSelectorRequirementBuilder> predicate) {
    if (matchExpressions == null) {
      return (A) this;
    }
    Iterator<ScopedResourceSelectorRequirementBuilder> each = matchExpressions.iterator();
    List visitables = _visitables.get("matchExpressions");
    while (each.hasNext()) {
        ScopedResourceSelectorRequirementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchExpressionsNested<A> setNewMatchExpressionLike(int index,ScopedResourceSelectorRequirement item) {
    return new MatchExpressionsNested(index, item);
  }
  
  public A setToMatchExpressions(int index,ScopedResourceSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    ScopedResourceSelectorRequirementBuilder builder = new ScopedResourceSelectorRequirementBuilder(item);
    if (index < 0 || index >= matchExpressions.size()) {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.add(builder);
    } else {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(matchExpressions == null) && !(matchExpressions.isEmpty())) {
        sb.append("matchExpressions:");
        sb.append(matchExpressions);
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
  
  public A withMatchExpressions(List<ScopedResourceSelectorRequirement> matchExpressions) {
    if (this.matchExpressions != null) {
      this._visitables.get("matchExpressions").clear();
    }
    if (matchExpressions != null) {
        this.matchExpressions = new ArrayList();
        for (ScopedResourceSelectorRequirement item : matchExpressions) {
          this.addToMatchExpressions(item);
        }
    } else {
      this.matchExpressions = null;
    }
    return (A) this;
  }
  
  public A withMatchExpressions(ScopedResourceSelectorRequirement... matchExpressions) {
    if (this.matchExpressions != null) {
        this.matchExpressions.clear();
        _visitables.remove("matchExpressions");
    }
    if (matchExpressions != null) {
      for (ScopedResourceSelectorRequirement item : matchExpressions) {
        this.addToMatchExpressions(item);
      }
    }
    return (A) this;
  }
  public class MatchExpressionsNested<N> extends ScopedResourceSelectorRequirementFluent<MatchExpressionsNested<N>> implements Nested<N>{
  
    ScopedResourceSelectorRequirementBuilder builder;
    int index;
  
    MatchExpressionsNested(int index,ScopedResourceSelectorRequirement item) {
      this.index = index;
      this.builder = new ScopedResourceSelectorRequirementBuilder(this, item);
    }
  
    public N and() {
      return (N) ScopeSelectorFluent.this.setToMatchExpressions(index, builder.build());
    }
    
    public N endMatchExpression() {
      return and();
    }
    
  }
}