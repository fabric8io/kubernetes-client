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
public class LabelSelectorFluent<A extends io.fabric8.kubernetes.api.model.LabelSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<LabelSelectorRequirementBuilder> matchExpressions = new ArrayList<LabelSelectorRequirementBuilder>();
  private Map<String,String> matchLabels;

  public LabelSelectorFluent() {
  }
  
  public LabelSelectorFluent(LabelSelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchExpressions(Collection<LabelSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (LabelSelectorRequirement item : items) {
        LabelSelectorRequirementBuilder builder = new LabelSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").add(builder);
        this.matchExpressions.add(builder);
    }
    return (A) this;
  }
  
  public MatchExpressionsNested<A> addNewMatchExpression() {
    return new MatchExpressionsNested(-1, null);
  }
  
  public MatchExpressionsNested<A> addNewMatchExpressionLike(LabelSelectorRequirement item) {
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
  
  public A addToMatchExpressions(LabelSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (LabelSelectorRequirement item : items) {
        LabelSelectorRequirementBuilder builder = new LabelSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").add(builder);
        this.matchExpressions.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchExpressions(int index,LabelSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    LabelSelectorRequirementBuilder builder = new LabelSelectorRequirementBuilder(item);
    if (index < 0 || index >= matchExpressions.size()) {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.add(builder);
    } else {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMatchLabels(Map<String,String> map) {
    if (this.matchLabels == null && map != null) {
      this.matchLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.matchLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMatchLabels(String key,String value) {
    if (this.matchLabels == null && key != null && value != null) {
      this.matchLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.matchLabels.put(key, value);
    }
    return (A) this;
  }
  
  public LabelSelectorRequirement buildFirstMatchExpression() {
    return this.matchExpressions.get(0).build();
  }
  
  public LabelSelectorRequirement buildLastMatchExpression() {
    return this.matchExpressions.get(matchExpressions.size() - 1).build();
  }
  
  public LabelSelectorRequirement buildMatchExpression(int index) {
    return this.matchExpressions.get(index).build();
  }
  
  public List<LabelSelectorRequirement> buildMatchExpressions() {
    return this.matchExpressions != null ? build(matchExpressions) : null;
  }
  
  public LabelSelectorRequirement buildMatchingMatchExpression(Predicate<LabelSelectorRequirementBuilder> predicate) {
      for (LabelSelectorRequirementBuilder item : matchExpressions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(LabelSelector instance) {
    instance = instance != null ? instance : new LabelSelector();
    if (instance != null) {
        this.withMatchExpressions(instance.getMatchExpressions());
        this.withMatchLabels(instance.getMatchLabels());
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
  
  public MatchExpressionsNested<A> editMatchingMatchExpression(Predicate<LabelSelectorRequirementBuilder> predicate) {
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
    LabelSelectorFluent that = (LabelSelectorFluent) o;
    if (!(Objects.equals(matchExpressions, that.matchExpressions))) {
      return false;
    }
    if (!(Objects.equals(matchLabels, that.matchLabels))) {
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
  
  public Map<String,String> getMatchLabels() {
    return this.matchLabels;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchExpressions() {
    return this.matchExpressions != null && !(this.matchExpressions.isEmpty());
  }
  
  public boolean hasMatchLabels() {
    return this.matchLabels != null;
  }
  
  public boolean hasMatchingMatchExpression(Predicate<LabelSelectorRequirementBuilder> predicate) {
      for (LabelSelectorRequirementBuilder item : matchExpressions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(matchExpressions, matchLabels, additionalProperties);
  }
  
  public A removeAllFromMatchExpressions(Collection<LabelSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (LabelSelectorRequirement item : items) {
        LabelSelectorRequirementBuilder builder = new LabelSelectorRequirementBuilder(item);
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
  
  public A removeFromMatchExpressions(LabelSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (LabelSelectorRequirement item : items) {
        LabelSelectorRequirementBuilder builder = new LabelSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").remove(builder);
        this.matchExpressions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMatchLabels(String key) {
    if (this.matchLabels == null) {
      return (A) this;
    }
    if (key != null && this.matchLabels != null) {
      this.matchLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMatchLabels(Map<String,String> map) {
    if (this.matchLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.matchLabels != null) {
          this.matchLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatchExpressions(Predicate<LabelSelectorRequirementBuilder> predicate) {
    if (matchExpressions == null) {
      return (A) this;
    }
    Iterator<LabelSelectorRequirementBuilder> each = matchExpressions.iterator();
    List visitables = _visitables.get("matchExpressions");
    while (each.hasNext()) {
        LabelSelectorRequirementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchExpressionsNested<A> setNewMatchExpressionLike(int index,LabelSelectorRequirement item) {
    return new MatchExpressionsNested(index, item);
  }
  
  public A setToMatchExpressions(int index,LabelSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    LabelSelectorRequirementBuilder builder = new LabelSelectorRequirementBuilder(item);
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
    if (!(matchLabels == null) && !(matchLabels.isEmpty())) {
        sb.append("matchLabels:");
        sb.append(matchLabels);
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
  
  public A withMatchExpressions(List<LabelSelectorRequirement> matchExpressions) {
    if (this.matchExpressions != null) {
      this._visitables.get("matchExpressions").clear();
    }
    if (matchExpressions != null) {
        this.matchExpressions = new ArrayList();
        for (LabelSelectorRequirement item : matchExpressions) {
          this.addToMatchExpressions(item);
        }
    } else {
      this.matchExpressions = null;
    }
    return (A) this;
  }
  
  public A withMatchExpressions(LabelSelectorRequirement... matchExpressions) {
    if (this.matchExpressions != null) {
        this.matchExpressions.clear();
        _visitables.remove("matchExpressions");
    }
    if (matchExpressions != null) {
      for (LabelSelectorRequirement item : matchExpressions) {
        this.addToMatchExpressions(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withMatchLabels(Map<String,String> matchLabels) {
    if (matchLabels == null) {
      this.matchLabels = null;
    } else {
      this.matchLabels = new LinkedHashMap(matchLabels);
    }
    return (A) this;
  }
  public class MatchExpressionsNested<N> extends LabelSelectorRequirementFluent<MatchExpressionsNested<N>> implements Nested<N>{
  
    LabelSelectorRequirementBuilder builder;
    int index;
  
    MatchExpressionsNested(int index,LabelSelectorRequirement item) {
      this.index = index;
      this.builder = new LabelSelectorRequirementBuilder(this, item);
    }
  
    public N and() {
      return (N) LabelSelectorFluent.this.setToMatchExpressions(index, builder.build());
    }
    
    public N endMatchExpression() {
      return and();
    }
    
  }
}