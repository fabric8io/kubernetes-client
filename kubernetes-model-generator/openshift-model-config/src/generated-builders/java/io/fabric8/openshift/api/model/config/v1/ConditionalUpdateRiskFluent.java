package io.fabric8.openshift.api.model.config.v1;

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
public class ConditionalUpdateRiskFluent<A extends io.fabric8.openshift.api.model.config.v1.ConditionalUpdateRiskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterConditionBuilder> matchingRules = new ArrayList<ClusterConditionBuilder>();
  private String message;
  private String name;
  private String url;

  public ConditionalUpdateRiskFluent() {
  }
  
  public ConditionalUpdateRiskFluent(ConditionalUpdateRisk instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchingRules(Collection<ClusterCondition> items) {
    if (this.matchingRules == null) {
      this.matchingRules = new ArrayList();
    }
    for (ClusterCondition item : items) {
        ClusterConditionBuilder builder = new ClusterConditionBuilder(item);
        _visitables.get("matchingRules").add(builder);
        this.matchingRules.add(builder);
    }
    return (A) this;
  }
  
  public MatchingRulesNested<A> addNewMatchingRule() {
    return new MatchingRulesNested(-1, null);
  }
  
  public MatchingRulesNested<A> addNewMatchingRuleLike(ClusterCondition item) {
    return new MatchingRulesNested(-1, item);
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
  
  public A addToMatchingRules(ClusterCondition... items) {
    if (this.matchingRules == null) {
      this.matchingRules = new ArrayList();
    }
    for (ClusterCondition item : items) {
        ClusterConditionBuilder builder = new ClusterConditionBuilder(item);
        _visitables.get("matchingRules").add(builder);
        this.matchingRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchingRules(int index,ClusterCondition item) {
    if (this.matchingRules == null) {
      this.matchingRules = new ArrayList();
    }
    ClusterConditionBuilder builder = new ClusterConditionBuilder(item);
    if (index < 0 || index >= matchingRules.size()) {
        _visitables.get("matchingRules").add(builder);
        matchingRules.add(builder);
    } else {
        _visitables.get("matchingRules").add(builder);
        matchingRules.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterCondition buildFirstMatchingRule() {
    return this.matchingRules.get(0).build();
  }
  
  public ClusterCondition buildLastMatchingRule() {
    return this.matchingRules.get(matchingRules.size() - 1).build();
  }
  
  public ClusterCondition buildMatchingMatchingRule(Predicate<ClusterConditionBuilder> predicate) {
      for (ClusterConditionBuilder item : matchingRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterCondition buildMatchingRule(int index) {
    return this.matchingRules.get(index).build();
  }
  
  public List<ClusterCondition> buildMatchingRules() {
    return this.matchingRules != null ? build(matchingRules) : null;
  }
  
  protected void copyInstance(ConditionalUpdateRisk instance) {
    instance = instance != null ? instance : new ConditionalUpdateRisk();
    if (instance != null) {
        this.withMatchingRules(instance.getMatchingRules());
        this.withMessage(instance.getMessage());
        this.withName(instance.getName());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchingRulesNested<A> editFirstMatchingRule() {
    if (matchingRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matchingRules"));
    }
    return this.setNewMatchingRuleLike(0, this.buildMatchingRule(0));
  }
  
  public MatchingRulesNested<A> editLastMatchingRule() {
    int index = matchingRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matchingRules"));
    }
    return this.setNewMatchingRuleLike(index, this.buildMatchingRule(index));
  }
  
  public MatchingRulesNested<A> editMatchingMatchingRule(Predicate<ClusterConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < matchingRules.size();i++) {
      if (predicate.test(matchingRules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "matchingRules"));
    }
    return this.setNewMatchingRuleLike(index, this.buildMatchingRule(index));
  }
  
  public MatchingRulesNested<A> editMatchingRule(int index) {
    if (matchingRules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "matchingRules"));
    }
    return this.setNewMatchingRuleLike(index, this.buildMatchingRule(index));
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
    ConditionalUpdateRiskFluent that = (ConditionalUpdateRiskFluent) o;
    if (!(Objects.equals(matchingRules, that.matchingRules))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getMessage() {
    return this.message;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingMatchingRule(Predicate<ClusterConditionBuilder> predicate) {
      for (ClusterConditionBuilder item : matchingRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRules() {
    return this.matchingRules != null && !(this.matchingRules.isEmpty());
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(matchingRules, message, name, url, additionalProperties);
  }
  
  public A removeAllFromMatchingRules(Collection<ClusterCondition> items) {
    if (this.matchingRules == null) {
      return (A) this;
    }
    for (ClusterCondition item : items) {
        ClusterConditionBuilder builder = new ClusterConditionBuilder(item);
        _visitables.get("matchingRules").remove(builder);
        this.matchingRules.remove(builder);
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
  
  public A removeFromMatchingRules(ClusterCondition... items) {
    if (this.matchingRules == null) {
      return (A) this;
    }
    for (ClusterCondition item : items) {
        ClusterConditionBuilder builder = new ClusterConditionBuilder(item);
        _visitables.get("matchingRules").remove(builder);
        this.matchingRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatchingRules(Predicate<ClusterConditionBuilder> predicate) {
    if (matchingRules == null) {
      return (A) this;
    }
    Iterator<ClusterConditionBuilder> each = matchingRules.iterator();
    List visitables = _visitables.get("matchingRules");
    while (each.hasNext()) {
        ClusterConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchingRulesNested<A> setNewMatchingRuleLike(int index,ClusterCondition item) {
    return new MatchingRulesNested(index, item);
  }
  
  public A setToMatchingRules(int index,ClusterCondition item) {
    if (this.matchingRules == null) {
      this.matchingRules = new ArrayList();
    }
    ClusterConditionBuilder builder = new ClusterConditionBuilder(item);
    if (index < 0 || index >= matchingRules.size()) {
        _visitables.get("matchingRules").add(builder);
        matchingRules.add(builder);
    } else {
        _visitables.get("matchingRules").add(builder);
        matchingRules.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(matchingRules == null) && !(matchingRules.isEmpty())) {
        sb.append("matchingRules:");
        sb.append(matchingRules);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withMatchingRules(List<ClusterCondition> matchingRules) {
    if (this.matchingRules != null) {
      this._visitables.get("matchingRules").clear();
    }
    if (matchingRules != null) {
        this.matchingRules = new ArrayList();
        for (ClusterCondition item : matchingRules) {
          this.addToMatchingRules(item);
        }
    } else {
      this.matchingRules = null;
    }
    return (A) this;
  }
  
  public A withMatchingRules(ClusterCondition... matchingRules) {
    if (this.matchingRules != null) {
        this.matchingRules.clear();
        _visitables.remove("matchingRules");
    }
    if (matchingRules != null) {
      for (ClusterCondition item : matchingRules) {
        this.addToMatchingRules(item);
      }
    }
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class MatchingRulesNested<N> extends ClusterConditionFluent<MatchingRulesNested<N>> implements Nested<N>{
  
    ClusterConditionBuilder builder;
    int index;
  
    MatchingRulesNested(int index,ClusterCondition item) {
      this.index = index;
      this.builder = new ClusterConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ConditionalUpdateRiskFluent.this.setToMatchingRules(index, builder.build());
    }
    
    public N endMatchingRule() {
      return and();
    }
    
  }
}