package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class HostSelectorFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HostSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String inNamespace;
  private ArrayList<HostSelectorRequirementBuilder> matchExpressions = new ArrayList<HostSelectorRequirementBuilder>();
  private Map<String,String> matchLabels;

  public HostSelectorFluent() {
  }
  
  public HostSelectorFluent(HostSelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchExpressions(Collection<HostSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (HostSelectorRequirement item : items) {
        HostSelectorRequirementBuilder builder = new HostSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").add(builder);
        this.matchExpressions.add(builder);
    }
    return (A) this;
  }
  
  public MatchExpressionsNested<A> addNewMatchExpression() {
    return new MatchExpressionsNested(-1, null);
  }
  
  public MatchExpressionsNested<A> addNewMatchExpressionLike(HostSelectorRequirement item) {
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
  
  public A addToMatchExpressions(HostSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (HostSelectorRequirement item : items) {
        HostSelectorRequirementBuilder builder = new HostSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").add(builder);
        this.matchExpressions.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchExpressions(int index,HostSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    HostSelectorRequirementBuilder builder = new HostSelectorRequirementBuilder(item);
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
  
  public HostSelectorRequirement buildFirstMatchExpression() {
    return this.matchExpressions.get(0).build();
  }
  
  public HostSelectorRequirement buildLastMatchExpression() {
    return this.matchExpressions.get(matchExpressions.size() - 1).build();
  }
  
  public HostSelectorRequirement buildMatchExpression(int index) {
    return this.matchExpressions.get(index).build();
  }
  
  public List<HostSelectorRequirement> buildMatchExpressions() {
    return this.matchExpressions != null ? build(matchExpressions) : null;
  }
  
  public HostSelectorRequirement buildMatchingMatchExpression(Predicate<HostSelectorRequirementBuilder> predicate) {
      for (HostSelectorRequirementBuilder item : matchExpressions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(HostSelector instance) {
    instance = instance != null ? instance : new HostSelector();
    if (instance != null) {
        this.withInNamespace(instance.getInNamespace());
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
  
  public MatchExpressionsNested<A> editMatchingMatchExpression(Predicate<HostSelectorRequirementBuilder> predicate) {
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
    HostSelectorFluent that = (HostSelectorFluent) o;
    if (!(Objects.equals(inNamespace, that.inNamespace))) {
      return false;
    }
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
  
  public String getInNamespace() {
    return this.inNamespace;
  }
  
  public Map<String,String> getMatchLabels() {
    return this.matchLabels;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasInNamespace() {
    return this.inNamespace != null;
  }
  
  public boolean hasMatchExpressions() {
    return this.matchExpressions != null && !(this.matchExpressions.isEmpty());
  }
  
  public boolean hasMatchLabels() {
    return this.matchLabels != null;
  }
  
  public boolean hasMatchingMatchExpression(Predicate<HostSelectorRequirementBuilder> predicate) {
      for (HostSelectorRequirementBuilder item : matchExpressions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(inNamespace, matchExpressions, matchLabels, additionalProperties);
  }
  
  public A removeAllFromMatchExpressions(Collection<HostSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (HostSelectorRequirement item : items) {
        HostSelectorRequirementBuilder builder = new HostSelectorRequirementBuilder(item);
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
  
  public A removeFromMatchExpressions(HostSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (HostSelectorRequirement item : items) {
        HostSelectorRequirementBuilder builder = new HostSelectorRequirementBuilder(item);
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
  
  public A removeMatchingFromMatchExpressions(Predicate<HostSelectorRequirementBuilder> predicate) {
    if (matchExpressions == null) {
      return (A) this;
    }
    Iterator<HostSelectorRequirementBuilder> each = matchExpressions.iterator();
    List visitables = _visitables.get("matchExpressions");
    while (each.hasNext()) {
        HostSelectorRequirementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchExpressionsNested<A> setNewMatchExpressionLike(int index,HostSelectorRequirement item) {
    return new MatchExpressionsNested(index, item);
  }
  
  public A setToMatchExpressions(int index,HostSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    HostSelectorRequirementBuilder builder = new HostSelectorRequirementBuilder(item);
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
    if (!(inNamespace == null)) {
        sb.append("inNamespace:");
        sb.append(inNamespace);
        sb.append(",");
    }
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
  
  public A withInNamespace(String inNamespace) {
    this.inNamespace = inNamespace;
    return (A) this;
  }
  
  public A withMatchExpressions(List<HostSelectorRequirement> matchExpressions) {
    if (this.matchExpressions != null) {
      this._visitables.get("matchExpressions").clear();
    }
    if (matchExpressions != null) {
        this.matchExpressions = new ArrayList();
        for (HostSelectorRequirement item : matchExpressions) {
          this.addToMatchExpressions(item);
        }
    } else {
      this.matchExpressions = null;
    }
    return (A) this;
  }
  
  public A withMatchExpressions(HostSelectorRequirement... matchExpressions) {
    if (this.matchExpressions != null) {
        this.matchExpressions.clear();
        _visitables.remove("matchExpressions");
    }
    if (matchExpressions != null) {
      for (HostSelectorRequirement item : matchExpressions) {
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
  public class MatchExpressionsNested<N> extends HostSelectorRequirementFluent<MatchExpressionsNested<N>> implements Nested<N>{
  
    HostSelectorRequirementBuilder builder;
    int index;
  
    MatchExpressionsNested(int index,HostSelectorRequirement item) {
      this.index = index;
      this.builder = new HostSelectorRequirementBuilder(this, item);
    }
  
    public N and() {
      return (N) HostSelectorFluent.this.setToMatchExpressions(index, builder.build());
    }
    
    public N endMatchExpression() {
      return and();
    }
    
  }
}