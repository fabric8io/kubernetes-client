package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Integer;
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
public class AddOnPlacementScoreStatusFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.AddOnPlacementScoreStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<AddOnPlacementScoreItemBuilder> scores = new ArrayList<AddOnPlacementScoreItemBuilder>();
  private String validUntil;

  public AddOnPlacementScoreStatusFluent() {
  }
  
  public AddOnPlacementScoreStatusFluent(AddOnPlacementScoreStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToScores(Collection<AddOnPlacementScoreItem> items) {
    if (this.scores == null) {
      this.scores = new ArrayList();
    }
    for (AddOnPlacementScoreItem item : items) {
        AddOnPlacementScoreItemBuilder builder = new AddOnPlacementScoreItemBuilder(item);
        _visitables.get("scores").add(builder);
        this.scores.add(builder);
    }
    return (A) this;
  }
  
  public ScoresNested<A> addNewScore() {
    return new ScoresNested(-1, null);
  }
  
  public A addNewScore(String name,Integer value) {
    return (A) this.addToScores(new AddOnPlacementScoreItem(name, value));
  }
  
  public ScoresNested<A> addNewScoreLike(AddOnPlacementScoreItem item) {
    return new ScoresNested(-1, item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToScores(AddOnPlacementScoreItem... items) {
    if (this.scores == null) {
      this.scores = new ArrayList();
    }
    for (AddOnPlacementScoreItem item : items) {
        AddOnPlacementScoreItemBuilder builder = new AddOnPlacementScoreItemBuilder(item);
        _visitables.get("scores").add(builder);
        this.scores.add(builder);
    }
    return (A) this;
  }
  
  public A addToScores(int index,AddOnPlacementScoreItem item) {
    if (this.scores == null) {
      this.scores = new ArrayList();
    }
    AddOnPlacementScoreItemBuilder builder = new AddOnPlacementScoreItemBuilder(item);
    if (index < 0 || index >= scores.size()) {
        _visitables.get("scores").add(builder);
        scores.add(builder);
    } else {
        _visitables.get("scores").add(builder);
        scores.add(index, builder);
    }
    return (A) this;
  }
  
  public AddOnPlacementScoreItem buildFirstScore() {
    return this.scores.get(0).build();
  }
  
  public AddOnPlacementScoreItem buildLastScore() {
    return this.scores.get(scores.size() - 1).build();
  }
  
  public AddOnPlacementScoreItem buildMatchingScore(Predicate<AddOnPlacementScoreItemBuilder> predicate) {
      for (AddOnPlacementScoreItemBuilder item : scores) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AddOnPlacementScoreItem buildScore(int index) {
    return this.scores.get(index).build();
  }
  
  public List<AddOnPlacementScoreItem> buildScores() {
    return this.scores != null ? build(scores) : null;
  }
  
  protected void copyInstance(AddOnPlacementScoreStatus instance) {
    instance = instance != null ? instance : new AddOnPlacementScoreStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withScores(instance.getScores());
        this.withValidUntil(instance.getValidUntil());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ScoresNested<A> editFirstScore() {
    if (scores.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "scores"));
    }
    return this.setNewScoreLike(0, this.buildScore(0));
  }
  
  public ScoresNested<A> editLastScore() {
    int index = scores.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "scores"));
    }
    return this.setNewScoreLike(index, this.buildScore(index));
  }
  
  public ScoresNested<A> editMatchingScore(Predicate<AddOnPlacementScoreItemBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < scores.size();i++) {
      if (predicate.test(scores.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "scores"));
    }
    return this.setNewScoreLike(index, this.buildScore(index));
  }
  
  public ScoresNested<A> editScore(int index) {
    if (scores.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "scores"));
    }
    return this.setNewScoreLike(index, this.buildScore(index));
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
    AddOnPlacementScoreStatusFluent that = (AddOnPlacementScoreStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(scores, that.scores))) {
      return false;
    }
    if (!(Objects.equals(validUntil, that.validUntil))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getValidUntil() {
    return this.validUntil;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingScore(Predicate<AddOnPlacementScoreItemBuilder> predicate) {
      for (AddOnPlacementScoreItemBuilder item : scores) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasScores() {
    return this.scores != null && !(this.scores.isEmpty());
  }
  
  public boolean hasValidUntil() {
    return this.validUntil != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, scores, validUntil, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromScores(Collection<AddOnPlacementScoreItem> items) {
    if (this.scores == null) {
      return (A) this;
    }
    for (AddOnPlacementScoreItem item : items) {
        AddOnPlacementScoreItemBuilder builder = new AddOnPlacementScoreItemBuilder(item);
        _visitables.get("scores").remove(builder);
        this.scores.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromScores(AddOnPlacementScoreItem... items) {
    if (this.scores == null) {
      return (A) this;
    }
    for (AddOnPlacementScoreItem item : items) {
        AddOnPlacementScoreItemBuilder builder = new AddOnPlacementScoreItemBuilder(item);
        _visitables.get("scores").remove(builder);
        this.scores.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromScores(Predicate<AddOnPlacementScoreItemBuilder> predicate) {
    if (scores == null) {
      return (A) this;
    }
    Iterator<AddOnPlacementScoreItemBuilder> each = scores.iterator();
    List visitables = _visitables.get("scores");
    while (each.hasNext()) {
        AddOnPlacementScoreItemBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ScoresNested<A> setNewScoreLike(int index,AddOnPlacementScoreItem item) {
    return new ScoresNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToScores(int index,AddOnPlacementScoreItem item) {
    if (this.scores == null) {
      this.scores = new ArrayList();
    }
    AddOnPlacementScoreItemBuilder builder = new AddOnPlacementScoreItemBuilder(item);
    if (index < 0 || index >= scores.size()) {
        _visitables.get("scores").add(builder);
        scores.add(builder);
    } else {
        _visitables.get("scores").add(builder);
        scores.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(scores == null) && !(scores.isEmpty())) {
        sb.append("scores:");
        sb.append(scores);
        sb.append(",");
    }
    if (!(validUntil == null)) {
        sb.append("validUntil:");
        sb.append(validUntil);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withScores(List<AddOnPlacementScoreItem> scores) {
    if (this.scores != null) {
      this._visitables.get("scores").clear();
    }
    if (scores != null) {
        this.scores = new ArrayList();
        for (AddOnPlacementScoreItem item : scores) {
          this.addToScores(item);
        }
    } else {
      this.scores = null;
    }
    return (A) this;
  }
  
  public A withScores(AddOnPlacementScoreItem... scores) {
    if (this.scores != null) {
        this.scores.clear();
        _visitables.remove("scores");
    }
    if (scores != null) {
      for (AddOnPlacementScoreItem item : scores) {
        this.addToScores(item);
      }
    }
    return (A) this;
  }
  
  public A withValidUntil(String validUntil) {
    this.validUntil = validUntil;
    return (A) this;
  }
  public class ScoresNested<N> extends AddOnPlacementScoreItemFluent<ScoresNested<N>> implements Nested<N>{
  
    AddOnPlacementScoreItemBuilder builder;
    int index;
  
    ScoresNested(int index,AddOnPlacementScoreItem item) {
      this.index = index;
      this.builder = new AddOnPlacementScoreItemBuilder(this, item);
    }
  
    public N and() {
      return (N) AddOnPlacementScoreStatusFluent.this.setToScores(index, builder.build());
    }
    
    public N endScore() {
      return and();
    }
    
  }
}