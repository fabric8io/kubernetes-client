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
public class TopologySelectorTermFluent<A extends io.fabric8.kubernetes.api.model.TopologySelectorTermFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<TopologySelectorLabelRequirementBuilder> matchLabelExpressions = new ArrayList<TopologySelectorLabelRequirementBuilder>();

  public TopologySelectorTermFluent() {
  }
  
  public TopologySelectorTermFluent(TopologySelectorTerm instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchLabelExpressions(Collection<TopologySelectorLabelRequirement> items) {
    if (this.matchLabelExpressions == null) {
      this.matchLabelExpressions = new ArrayList();
    }
    for (TopologySelectorLabelRequirement item : items) {
        TopologySelectorLabelRequirementBuilder builder = new TopologySelectorLabelRequirementBuilder(item);
        _visitables.get("matchLabelExpressions").add(builder);
        this.matchLabelExpressions.add(builder);
    }
    return (A) this;
  }
  
  public MatchLabelExpressionsNested<A> addNewMatchLabelExpression() {
    return new MatchLabelExpressionsNested(-1, null);
  }
  
  public MatchLabelExpressionsNested<A> addNewMatchLabelExpressionLike(TopologySelectorLabelRequirement item) {
    return new MatchLabelExpressionsNested(-1, item);
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
  
  public A addToMatchLabelExpressions(TopologySelectorLabelRequirement... items) {
    if (this.matchLabelExpressions == null) {
      this.matchLabelExpressions = new ArrayList();
    }
    for (TopologySelectorLabelRequirement item : items) {
        TopologySelectorLabelRequirementBuilder builder = new TopologySelectorLabelRequirementBuilder(item);
        _visitables.get("matchLabelExpressions").add(builder);
        this.matchLabelExpressions.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchLabelExpressions(int index,TopologySelectorLabelRequirement item) {
    if (this.matchLabelExpressions == null) {
      this.matchLabelExpressions = new ArrayList();
    }
    TopologySelectorLabelRequirementBuilder builder = new TopologySelectorLabelRequirementBuilder(item);
    if (index < 0 || index >= matchLabelExpressions.size()) {
        _visitables.get("matchLabelExpressions").add(builder);
        matchLabelExpressions.add(builder);
    } else {
        _visitables.get("matchLabelExpressions").add(builder);
        matchLabelExpressions.add(index, builder);
    }
    return (A) this;
  }
  
  public TopologySelectorLabelRequirement buildFirstMatchLabelExpression() {
    return this.matchLabelExpressions.get(0).build();
  }
  
  public TopologySelectorLabelRequirement buildLastMatchLabelExpression() {
    return this.matchLabelExpressions.get(matchLabelExpressions.size() - 1).build();
  }
  
  public TopologySelectorLabelRequirement buildMatchLabelExpression(int index) {
    return this.matchLabelExpressions.get(index).build();
  }
  
  public List<TopologySelectorLabelRequirement> buildMatchLabelExpressions() {
    return this.matchLabelExpressions != null ? build(matchLabelExpressions) : null;
  }
  
  public TopologySelectorLabelRequirement buildMatchingMatchLabelExpression(Predicate<TopologySelectorLabelRequirementBuilder> predicate) {
      for (TopologySelectorLabelRequirementBuilder item : matchLabelExpressions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(TopologySelectorTerm instance) {
    instance = instance != null ? instance : new TopologySelectorTerm();
    if (instance != null) {
        this.withMatchLabelExpressions(instance.getMatchLabelExpressions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchLabelExpressionsNested<A> editFirstMatchLabelExpression() {
    if (matchLabelExpressions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matchLabelExpressions"));
    }
    return this.setNewMatchLabelExpressionLike(0, this.buildMatchLabelExpression(0));
  }
  
  public MatchLabelExpressionsNested<A> editLastMatchLabelExpression() {
    int index = matchLabelExpressions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matchLabelExpressions"));
    }
    return this.setNewMatchLabelExpressionLike(index, this.buildMatchLabelExpression(index));
  }
  
  public MatchLabelExpressionsNested<A> editMatchLabelExpression(int index) {
    if (matchLabelExpressions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "matchLabelExpressions"));
    }
    return this.setNewMatchLabelExpressionLike(index, this.buildMatchLabelExpression(index));
  }
  
  public MatchLabelExpressionsNested<A> editMatchingMatchLabelExpression(Predicate<TopologySelectorLabelRequirementBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < matchLabelExpressions.size();i++) {
      if (predicate.test(matchLabelExpressions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "matchLabelExpressions"));
    }
    return this.setNewMatchLabelExpressionLike(index, this.buildMatchLabelExpression(index));
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
    TopologySelectorTermFluent that = (TopologySelectorTermFluent) o;
    if (!(Objects.equals(matchLabelExpressions, that.matchLabelExpressions))) {
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
  
  public boolean hasMatchLabelExpressions() {
    return this.matchLabelExpressions != null && !(this.matchLabelExpressions.isEmpty());
  }
  
  public boolean hasMatchingMatchLabelExpression(Predicate<TopologySelectorLabelRequirementBuilder> predicate) {
      for (TopologySelectorLabelRequirementBuilder item : matchLabelExpressions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(matchLabelExpressions, additionalProperties);
  }
  
  public A removeAllFromMatchLabelExpressions(Collection<TopologySelectorLabelRequirement> items) {
    if (this.matchLabelExpressions == null) {
      return (A) this;
    }
    for (TopologySelectorLabelRequirement item : items) {
        TopologySelectorLabelRequirementBuilder builder = new TopologySelectorLabelRequirementBuilder(item);
        _visitables.get("matchLabelExpressions").remove(builder);
        this.matchLabelExpressions.remove(builder);
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
  
  public A removeFromMatchLabelExpressions(TopologySelectorLabelRequirement... items) {
    if (this.matchLabelExpressions == null) {
      return (A) this;
    }
    for (TopologySelectorLabelRequirement item : items) {
        TopologySelectorLabelRequirementBuilder builder = new TopologySelectorLabelRequirementBuilder(item);
        _visitables.get("matchLabelExpressions").remove(builder);
        this.matchLabelExpressions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatchLabelExpressions(Predicate<TopologySelectorLabelRequirementBuilder> predicate) {
    if (matchLabelExpressions == null) {
      return (A) this;
    }
    Iterator<TopologySelectorLabelRequirementBuilder> each = matchLabelExpressions.iterator();
    List visitables = _visitables.get("matchLabelExpressions");
    while (each.hasNext()) {
        TopologySelectorLabelRequirementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchLabelExpressionsNested<A> setNewMatchLabelExpressionLike(int index,TopologySelectorLabelRequirement item) {
    return new MatchLabelExpressionsNested(index, item);
  }
  
  public A setToMatchLabelExpressions(int index,TopologySelectorLabelRequirement item) {
    if (this.matchLabelExpressions == null) {
      this.matchLabelExpressions = new ArrayList();
    }
    TopologySelectorLabelRequirementBuilder builder = new TopologySelectorLabelRequirementBuilder(item);
    if (index < 0 || index >= matchLabelExpressions.size()) {
        _visitables.get("matchLabelExpressions").add(builder);
        matchLabelExpressions.add(builder);
    } else {
        _visitables.get("matchLabelExpressions").add(builder);
        matchLabelExpressions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(matchLabelExpressions == null) && !(matchLabelExpressions.isEmpty())) {
        sb.append("matchLabelExpressions:");
        sb.append(matchLabelExpressions);
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
  
  public A withMatchLabelExpressions(List<TopologySelectorLabelRequirement> matchLabelExpressions) {
    if (this.matchLabelExpressions != null) {
      this._visitables.get("matchLabelExpressions").clear();
    }
    if (matchLabelExpressions != null) {
        this.matchLabelExpressions = new ArrayList();
        for (TopologySelectorLabelRequirement item : matchLabelExpressions) {
          this.addToMatchLabelExpressions(item);
        }
    } else {
      this.matchLabelExpressions = null;
    }
    return (A) this;
  }
  
  public A withMatchLabelExpressions(TopologySelectorLabelRequirement... matchLabelExpressions) {
    if (this.matchLabelExpressions != null) {
        this.matchLabelExpressions.clear();
        _visitables.remove("matchLabelExpressions");
    }
    if (matchLabelExpressions != null) {
      for (TopologySelectorLabelRequirement item : matchLabelExpressions) {
        this.addToMatchLabelExpressions(item);
      }
    }
    return (A) this;
  }
  public class MatchLabelExpressionsNested<N> extends TopologySelectorLabelRequirementFluent<MatchLabelExpressionsNested<N>> implements Nested<N>{
  
    TopologySelectorLabelRequirementBuilder builder;
    int index;
  
    MatchLabelExpressionsNested(int index,TopologySelectorLabelRequirement item) {
      this.index = index;
      this.builder = new TopologySelectorLabelRequirementBuilder(this, item);
    }
  
    public N and() {
      return (N) TopologySelectorTermFluent.this.setToMatchLabelExpressions(index, builder.build());
    }
    
    public N endMatchLabelExpression() {
      return and();
    }
    
  }
}