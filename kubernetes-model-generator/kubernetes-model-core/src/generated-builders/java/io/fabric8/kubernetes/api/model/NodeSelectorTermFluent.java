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
public class NodeSelectorTermFluent<A extends io.fabric8.kubernetes.api.model.NodeSelectorTermFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NodeSelectorRequirementBuilder> matchExpressions = new ArrayList<NodeSelectorRequirementBuilder>();
  private ArrayList<NodeSelectorRequirementBuilder> matchFields = new ArrayList<NodeSelectorRequirementBuilder>();

  public NodeSelectorTermFluent() {
  }
  
  public NodeSelectorTermFluent(NodeSelectorTerm instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchExpressions(Collection<NodeSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (NodeSelectorRequirement item : items) {
        NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").add(builder);
        this.matchExpressions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMatchFields(Collection<NodeSelectorRequirement> items) {
    if (this.matchFields == null) {
      this.matchFields = new ArrayList();
    }
    for (NodeSelectorRequirement item : items) {
        NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
        _visitables.get("matchFields").add(builder);
        this.matchFields.add(builder);
    }
    return (A) this;
  }
  
  public MatchExpressionsNested<A> addNewMatchExpression() {
    return new MatchExpressionsNested(-1, null);
  }
  
  public MatchExpressionsNested<A> addNewMatchExpressionLike(NodeSelectorRequirement item) {
    return new MatchExpressionsNested(-1, item);
  }
  
  public MatchFieldsNested<A> addNewMatchField() {
    return new MatchFieldsNested(-1, null);
  }
  
  public MatchFieldsNested<A> addNewMatchFieldLike(NodeSelectorRequirement item) {
    return new MatchFieldsNested(-1, item);
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
  
  public A addToMatchExpressions(NodeSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (NodeSelectorRequirement item : items) {
        NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").add(builder);
        this.matchExpressions.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchExpressions(int index,NodeSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
    if (index < 0 || index >= matchExpressions.size()) {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.add(builder);
    } else {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMatchFields(NodeSelectorRequirement... items) {
    if (this.matchFields == null) {
      this.matchFields = new ArrayList();
    }
    for (NodeSelectorRequirement item : items) {
        NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
        _visitables.get("matchFields").add(builder);
        this.matchFields.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchFields(int index,NodeSelectorRequirement item) {
    if (this.matchFields == null) {
      this.matchFields = new ArrayList();
    }
    NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
    if (index < 0 || index >= matchFields.size()) {
        _visitables.get("matchFields").add(builder);
        matchFields.add(builder);
    } else {
        _visitables.get("matchFields").add(builder);
        matchFields.add(index, builder);
    }
    return (A) this;
  }
  
  public NodeSelectorRequirement buildFirstMatchExpression() {
    return this.matchExpressions.get(0).build();
  }
  
  public NodeSelectorRequirement buildFirstMatchField() {
    return this.matchFields.get(0).build();
  }
  
  public NodeSelectorRequirement buildLastMatchExpression() {
    return this.matchExpressions.get(matchExpressions.size() - 1).build();
  }
  
  public NodeSelectorRequirement buildLastMatchField() {
    return this.matchFields.get(matchFields.size() - 1).build();
  }
  
  public NodeSelectorRequirement buildMatchExpression(int index) {
    return this.matchExpressions.get(index).build();
  }
  
  public List<NodeSelectorRequirement> buildMatchExpressions() {
    return this.matchExpressions != null ? build(matchExpressions) : null;
  }
  
  public NodeSelectorRequirement buildMatchField(int index) {
    return this.matchFields.get(index).build();
  }
  
  public List<NodeSelectorRequirement> buildMatchFields() {
    return this.matchFields != null ? build(matchFields) : null;
  }
  
  public NodeSelectorRequirement buildMatchingMatchExpression(Predicate<NodeSelectorRequirementBuilder> predicate) {
      for (NodeSelectorRequirementBuilder item : matchExpressions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeSelectorRequirement buildMatchingMatchField(Predicate<NodeSelectorRequirementBuilder> predicate) {
      for (NodeSelectorRequirementBuilder item : matchFields) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(NodeSelectorTerm instance) {
    instance = instance != null ? instance : new NodeSelectorTerm();
    if (instance != null) {
        this.withMatchExpressions(instance.getMatchExpressions());
        this.withMatchFields(instance.getMatchFields());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchExpressionsNested<A> editFirstMatchExpression() {
    if (matchExpressions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matchExpressions"));
    }
    return this.setNewMatchExpressionLike(0, this.buildMatchExpression(0));
  }
  
  public MatchFieldsNested<A> editFirstMatchField() {
    if (matchFields.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matchFields"));
    }
    return this.setNewMatchFieldLike(0, this.buildMatchField(0));
  }
  
  public MatchExpressionsNested<A> editLastMatchExpression() {
    int index = matchExpressions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matchExpressions"));
    }
    return this.setNewMatchExpressionLike(index, this.buildMatchExpression(index));
  }
  
  public MatchFieldsNested<A> editLastMatchField() {
    int index = matchFields.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matchFields"));
    }
    return this.setNewMatchFieldLike(index, this.buildMatchField(index));
  }
  
  public MatchExpressionsNested<A> editMatchExpression(int index) {
    if (matchExpressions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "matchExpressions"));
    }
    return this.setNewMatchExpressionLike(index, this.buildMatchExpression(index));
  }
  
  public MatchFieldsNested<A> editMatchField(int index) {
    if (matchFields.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "matchFields"));
    }
    return this.setNewMatchFieldLike(index, this.buildMatchField(index));
  }
  
  public MatchExpressionsNested<A> editMatchingMatchExpression(Predicate<NodeSelectorRequirementBuilder> predicate) {
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
  
  public MatchFieldsNested<A> editMatchingMatchField(Predicate<NodeSelectorRequirementBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < matchFields.size();i++) {
      if (predicate.test(matchFields.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "matchFields"));
    }
    return this.setNewMatchFieldLike(index, this.buildMatchField(index));
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
    NodeSelectorTermFluent that = (NodeSelectorTermFluent) o;
    if (!(Objects.equals(matchExpressions, that.matchExpressions))) {
      return false;
    }
    if (!(Objects.equals(matchFields, that.matchFields))) {
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
  
  public boolean hasMatchFields() {
    return this.matchFields != null && !(this.matchFields.isEmpty());
  }
  
  public boolean hasMatchingMatchExpression(Predicate<NodeSelectorRequirementBuilder> predicate) {
      for (NodeSelectorRequirementBuilder item : matchExpressions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMatchField(Predicate<NodeSelectorRequirementBuilder> predicate) {
      for (NodeSelectorRequirementBuilder item : matchFields) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(matchExpressions, matchFields, additionalProperties);
  }
  
  public A removeAllFromMatchExpressions(Collection<NodeSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (NodeSelectorRequirement item : items) {
        NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").remove(builder);
        this.matchExpressions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMatchFields(Collection<NodeSelectorRequirement> items) {
    if (this.matchFields == null) {
      return (A) this;
    }
    for (NodeSelectorRequirement item : items) {
        NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
        _visitables.get("matchFields").remove(builder);
        this.matchFields.remove(builder);
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
  
  public A removeFromMatchExpressions(NodeSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (NodeSelectorRequirement item : items) {
        NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
        _visitables.get("matchExpressions").remove(builder);
        this.matchExpressions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMatchFields(NodeSelectorRequirement... items) {
    if (this.matchFields == null) {
      return (A) this;
    }
    for (NodeSelectorRequirement item : items) {
        NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
        _visitables.get("matchFields").remove(builder);
        this.matchFields.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatchExpressions(Predicate<NodeSelectorRequirementBuilder> predicate) {
    if (matchExpressions == null) {
      return (A) this;
    }
    Iterator<NodeSelectorRequirementBuilder> each = matchExpressions.iterator();
    List visitables = _visitables.get("matchExpressions");
    while (each.hasNext()) {
        NodeSelectorRequirementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatchFields(Predicate<NodeSelectorRequirementBuilder> predicate) {
    if (matchFields == null) {
      return (A) this;
    }
    Iterator<NodeSelectorRequirementBuilder> each = matchFields.iterator();
    List visitables = _visitables.get("matchFields");
    while (each.hasNext()) {
        NodeSelectorRequirementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchExpressionsNested<A> setNewMatchExpressionLike(int index,NodeSelectorRequirement item) {
    return new MatchExpressionsNested(index, item);
  }
  
  public MatchFieldsNested<A> setNewMatchFieldLike(int index,NodeSelectorRequirement item) {
    return new MatchFieldsNested(index, item);
  }
  
  public A setToMatchExpressions(int index,NodeSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
    if (index < 0 || index >= matchExpressions.size()) {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.add(builder);
    } else {
        _visitables.get("matchExpressions").add(builder);
        matchExpressions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMatchFields(int index,NodeSelectorRequirement item) {
    if (this.matchFields == null) {
      this.matchFields = new ArrayList();
    }
    NodeSelectorRequirementBuilder builder = new NodeSelectorRequirementBuilder(item);
    if (index < 0 || index >= matchFields.size()) {
        _visitables.get("matchFields").add(builder);
        matchFields.add(builder);
    } else {
        _visitables.get("matchFields").add(builder);
        matchFields.set(index, builder);
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
    if (!(matchFields == null) && !(matchFields.isEmpty())) {
        sb.append("matchFields:");
        sb.append(matchFields);
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
  
  public A withMatchExpressions(List<NodeSelectorRequirement> matchExpressions) {
    if (this.matchExpressions != null) {
      this._visitables.get("matchExpressions").clear();
    }
    if (matchExpressions != null) {
        this.matchExpressions = new ArrayList();
        for (NodeSelectorRequirement item : matchExpressions) {
          this.addToMatchExpressions(item);
        }
    } else {
      this.matchExpressions = null;
    }
    return (A) this;
  }
  
  public A withMatchExpressions(NodeSelectorRequirement... matchExpressions) {
    if (this.matchExpressions != null) {
        this.matchExpressions.clear();
        _visitables.remove("matchExpressions");
    }
    if (matchExpressions != null) {
      for (NodeSelectorRequirement item : matchExpressions) {
        this.addToMatchExpressions(item);
      }
    }
    return (A) this;
  }
  
  public A withMatchFields(List<NodeSelectorRequirement> matchFields) {
    if (this.matchFields != null) {
      this._visitables.get("matchFields").clear();
    }
    if (matchFields != null) {
        this.matchFields = new ArrayList();
        for (NodeSelectorRequirement item : matchFields) {
          this.addToMatchFields(item);
        }
    } else {
      this.matchFields = null;
    }
    return (A) this;
  }
  
  public A withMatchFields(NodeSelectorRequirement... matchFields) {
    if (this.matchFields != null) {
        this.matchFields.clear();
        _visitables.remove("matchFields");
    }
    if (matchFields != null) {
      for (NodeSelectorRequirement item : matchFields) {
        this.addToMatchFields(item);
      }
    }
    return (A) this;
  }
  public class MatchExpressionsNested<N> extends NodeSelectorRequirementFluent<MatchExpressionsNested<N>> implements Nested<N>{
  
    NodeSelectorRequirementBuilder builder;
    int index;
  
    MatchExpressionsNested(int index,NodeSelectorRequirement item) {
      this.index = index;
      this.builder = new NodeSelectorRequirementBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeSelectorTermFluent.this.setToMatchExpressions(index, builder.build());
    }
    
    public N endMatchExpression() {
      return and();
    }
    
  }
  public class MatchFieldsNested<N> extends NodeSelectorRequirementFluent<MatchFieldsNested<N>> implements Nested<N>{
  
    NodeSelectorRequirementBuilder builder;
    int index;
  
    MatchFieldsNested(int index,NodeSelectorRequirement item) {
      this.index = index;
      this.builder = new NodeSelectorRequirementBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeSelectorTermFluent.this.setToMatchFields(index, builder.build());
    }
    
    public N endMatchField() {
      return and();
    }
    
  }
}