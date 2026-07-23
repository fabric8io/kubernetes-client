package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class VerticalPodAutoscalerStatusFluent<A extends io.fabric8.autoscaling.api.model.v1.VerticalPodAutoscalerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<VerticalPodAutoscalerConditionBuilder> conditions = new ArrayList<VerticalPodAutoscalerConditionBuilder>();
  private Long observedGeneration;
  private RecommendedPodResourcesBuilder recommendation;

  public VerticalPodAutoscalerStatusFluent() {
  }
  
  public VerticalPodAutoscalerStatusFluent(VerticalPodAutoscalerStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<VerticalPodAutoscalerCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (VerticalPodAutoscalerCondition item : items) {
        VerticalPodAutoscalerConditionBuilder builder = new VerticalPodAutoscalerConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(VerticalPodAutoscalerCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(VerticalPodAutoscalerCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (VerticalPodAutoscalerCondition item : items) {
        VerticalPodAutoscalerConditionBuilder builder = new VerticalPodAutoscalerConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,VerticalPodAutoscalerCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    VerticalPodAutoscalerConditionBuilder builder = new VerticalPodAutoscalerConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public VerticalPodAutoscalerCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<VerticalPodAutoscalerCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public VerticalPodAutoscalerCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public VerticalPodAutoscalerCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public VerticalPodAutoscalerCondition buildMatchingCondition(Predicate<VerticalPodAutoscalerConditionBuilder> predicate) {
      for (VerticalPodAutoscalerConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RecommendedPodResources buildRecommendation() {
    return this.recommendation != null ? this.recommendation.build() : null;
  }
  
  protected void copyInstance(VerticalPodAutoscalerStatus instance) {
    instance = instance != null ? instance : new VerticalPodAutoscalerStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withRecommendation(instance.getRecommendation());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<VerticalPodAutoscalerConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public RecommendationNested<A> editOrNewRecommendation() {
    return this.withNewRecommendationLike(Optional.ofNullable(this.buildRecommendation()).orElse(new RecommendedPodResourcesBuilder().build()));
  }
  
  public RecommendationNested<A> editOrNewRecommendationLike(RecommendedPodResources item) {
    return this.withNewRecommendationLike(Optional.ofNullable(this.buildRecommendation()).orElse(item));
  }
  
  public RecommendationNested<A> editRecommendation() {
    return this.withNewRecommendationLike(Optional.ofNullable(this.buildRecommendation()).orElse(null));
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
    VerticalPodAutoscalerStatusFluent that = (VerticalPodAutoscalerStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(recommendation, that.recommendation))) {
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
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<VerticalPodAutoscalerConditionBuilder> predicate) {
      for (VerticalPodAutoscalerConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasRecommendation() {
    return this.recommendation != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, observedGeneration, recommendation, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<VerticalPodAutoscalerCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (VerticalPodAutoscalerCondition item : items) {
        VerticalPodAutoscalerConditionBuilder builder = new VerticalPodAutoscalerConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromConditions(VerticalPodAutoscalerCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (VerticalPodAutoscalerCondition item : items) {
        VerticalPodAutoscalerConditionBuilder builder = new VerticalPodAutoscalerConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<VerticalPodAutoscalerConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<VerticalPodAutoscalerConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        VerticalPodAutoscalerConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,VerticalPodAutoscalerCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,VerticalPodAutoscalerCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    VerticalPodAutoscalerConditionBuilder builder = new VerticalPodAutoscalerConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
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
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(recommendation == null)) {
        sb.append("recommendation:");
        sb.append(recommendation);
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
  
  public A withConditions(List<VerticalPodAutoscalerCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (VerticalPodAutoscalerCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(VerticalPodAutoscalerCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (VerticalPodAutoscalerCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public RecommendationNested<A> withNewRecommendation() {
    return new RecommendationNested(null);
  }
  
  public RecommendationNested<A> withNewRecommendationLike(RecommendedPodResources item) {
    return new RecommendationNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withRecommendation(RecommendedPodResources recommendation) {
    this._visitables.remove("recommendation");
    if (recommendation != null) {
        this.recommendation = new RecommendedPodResourcesBuilder(recommendation);
        this._visitables.get("recommendation").add(this.recommendation);
    } else {
        this.recommendation = null;
        this._visitables.get("recommendation").remove(this.recommendation);
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends VerticalPodAutoscalerConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    VerticalPodAutoscalerConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,VerticalPodAutoscalerCondition item) {
      this.index = index;
      this.builder = new VerticalPodAutoscalerConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class RecommendationNested<N> extends RecommendedPodResourcesFluent<RecommendationNested<N>> implements Nested<N>{
  
    RecommendedPodResourcesBuilder builder;
  
    RecommendationNested(RecommendedPodResources item) {
      this.builder = new RecommendedPodResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerStatusFluent.this.withRecommendation(builder.build());
    }
    
    public N endRecommendation() {
      return and();
    }
    
  }
}