package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HorizontalPodAutoscalerStatusFluent<A extends io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscalerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<HorizontalPodAutoscalerConditionBuilder> conditions = new ArrayList<HorizontalPodAutoscalerConditionBuilder>();
  private ArrayList<MetricStatusBuilder> currentMetrics = new ArrayList<MetricStatusBuilder>();
  private Integer currentReplicas;
  private Integer desiredReplicas;
  private String lastScaleTime;
  private Long observedGeneration;

  public HorizontalPodAutoscalerStatusFluent() {
  }
  
  public HorizontalPodAutoscalerStatusFluent(HorizontalPodAutoscalerStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<HorizontalPodAutoscalerCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (HorizontalPodAutoscalerCondition item : items) {
        HorizontalPodAutoscalerConditionBuilder builder = new HorizontalPodAutoscalerConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToCurrentMetrics(Collection<MetricStatus> items) {
    if (this.currentMetrics == null) {
      this.currentMetrics = new ArrayList();
    }
    for (MetricStatus item : items) {
        MetricStatusBuilder builder = new MetricStatusBuilder(item);
        _visitables.get("currentMetrics").add(builder);
        this.currentMetrics.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new HorizontalPodAutoscalerCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(HorizontalPodAutoscalerCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public CurrentMetricsNested<A> addNewCurrentMetric() {
    return new CurrentMetricsNested(-1, null);
  }
  
  public CurrentMetricsNested<A> addNewCurrentMetricLike(MetricStatus item) {
    return new CurrentMetricsNested(-1, item);
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
  
  public A addToConditions(HorizontalPodAutoscalerCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (HorizontalPodAutoscalerCondition item : items) {
        HorizontalPodAutoscalerConditionBuilder builder = new HorizontalPodAutoscalerConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,HorizontalPodAutoscalerCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    HorizontalPodAutoscalerConditionBuilder builder = new HorizontalPodAutoscalerConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToCurrentMetrics(MetricStatus... items) {
    if (this.currentMetrics == null) {
      this.currentMetrics = new ArrayList();
    }
    for (MetricStatus item : items) {
        MetricStatusBuilder builder = new MetricStatusBuilder(item);
        _visitables.get("currentMetrics").add(builder);
        this.currentMetrics.add(builder);
    }
    return (A) this;
  }
  
  public A addToCurrentMetrics(int index,MetricStatus item) {
    if (this.currentMetrics == null) {
      this.currentMetrics = new ArrayList();
    }
    MetricStatusBuilder builder = new MetricStatusBuilder(item);
    if (index < 0 || index >= currentMetrics.size()) {
        _visitables.get("currentMetrics").add(builder);
        currentMetrics.add(builder);
    } else {
        _visitables.get("currentMetrics").add(builder);
        currentMetrics.add(index, builder);
    }
    return (A) this;
  }
  
  public HorizontalPodAutoscalerCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<HorizontalPodAutoscalerCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public MetricStatus buildCurrentMetric(int index) {
    return this.currentMetrics.get(index).build();
  }
  
  public List<MetricStatus> buildCurrentMetrics() {
    return this.currentMetrics != null ? build(currentMetrics) : null;
  }
  
  public HorizontalPodAutoscalerCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public MetricStatus buildFirstCurrentMetric() {
    return this.currentMetrics.get(0).build();
  }
  
  public HorizontalPodAutoscalerCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public MetricStatus buildLastCurrentMetric() {
    return this.currentMetrics.get(currentMetrics.size() - 1).build();
  }
  
  public HorizontalPodAutoscalerCondition buildMatchingCondition(Predicate<HorizontalPodAutoscalerConditionBuilder> predicate) {
      for (HorizontalPodAutoscalerConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetricStatus buildMatchingCurrentMetric(Predicate<MetricStatusBuilder> predicate) {
      for (MetricStatusBuilder item : currentMetrics) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(HorizontalPodAutoscalerStatus instance) {
    instance = instance != null ? instance : new HorizontalPodAutoscalerStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withCurrentMetrics(instance.getCurrentMetrics());
        this.withCurrentReplicas(instance.getCurrentReplicas());
        this.withDesiredReplicas(instance.getDesiredReplicas());
        this.withLastScaleTime(instance.getLastScaleTime());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public CurrentMetricsNested<A> editCurrentMetric(int index) {
    if (currentMetrics.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "currentMetrics"));
    }
    return this.setNewCurrentMetricLike(index, this.buildCurrentMetric(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public CurrentMetricsNested<A> editFirstCurrentMetric() {
    if (currentMetrics.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "currentMetrics"));
    }
    return this.setNewCurrentMetricLike(0, this.buildCurrentMetric(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public CurrentMetricsNested<A> editLastCurrentMetric() {
    int index = currentMetrics.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "currentMetrics"));
    }
    return this.setNewCurrentMetricLike(index, this.buildCurrentMetric(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<HorizontalPodAutoscalerConditionBuilder> predicate) {
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
  
  public CurrentMetricsNested<A> editMatchingCurrentMetric(Predicate<MetricStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < currentMetrics.size();i++) {
      if (predicate.test(currentMetrics.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "currentMetrics"));
    }
    return this.setNewCurrentMetricLike(index, this.buildCurrentMetric(index));
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
    HorizontalPodAutoscalerStatusFluent that = (HorizontalPodAutoscalerStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentMetrics, that.currentMetrics))) {
      return false;
    }
    if (!(Objects.equals(currentReplicas, that.currentReplicas))) {
      return false;
    }
    if (!(Objects.equals(desiredReplicas, that.desiredReplicas))) {
      return false;
    }
    if (!(Objects.equals(lastScaleTime, that.lastScaleTime))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
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
  
  public Integer getCurrentReplicas() {
    return this.currentReplicas;
  }
  
  public Integer getDesiredReplicas() {
    return this.desiredReplicas;
  }
  
  public String getLastScaleTime() {
    return this.lastScaleTime;
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
  
  public boolean hasCurrentMetrics() {
    return this.currentMetrics != null && !(this.currentMetrics.isEmpty());
  }
  
  public boolean hasCurrentReplicas() {
    return this.currentReplicas != null;
  }
  
  public boolean hasDesiredReplicas() {
    return this.desiredReplicas != null;
  }
  
  public boolean hasLastScaleTime() {
    return this.lastScaleTime != null;
  }
  
  public boolean hasMatchingCondition(Predicate<HorizontalPodAutoscalerConditionBuilder> predicate) {
      for (HorizontalPodAutoscalerConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCurrentMetric(Predicate<MetricStatusBuilder> predicate) {
      for (MetricStatusBuilder item : currentMetrics) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, currentMetrics, currentReplicas, desiredReplicas, lastScaleTime, observedGeneration, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<HorizontalPodAutoscalerCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (HorizontalPodAutoscalerCondition item : items) {
        HorizontalPodAutoscalerConditionBuilder builder = new HorizontalPodAutoscalerConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromCurrentMetrics(Collection<MetricStatus> items) {
    if (this.currentMetrics == null) {
      return (A) this;
    }
    for (MetricStatus item : items) {
        MetricStatusBuilder builder = new MetricStatusBuilder(item);
        _visitables.get("currentMetrics").remove(builder);
        this.currentMetrics.remove(builder);
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
  
  public A removeFromConditions(HorizontalPodAutoscalerCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (HorizontalPodAutoscalerCondition item : items) {
        HorizontalPodAutoscalerConditionBuilder builder = new HorizontalPodAutoscalerConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromCurrentMetrics(MetricStatus... items) {
    if (this.currentMetrics == null) {
      return (A) this;
    }
    for (MetricStatus item : items) {
        MetricStatusBuilder builder = new MetricStatusBuilder(item);
        _visitables.get("currentMetrics").remove(builder);
        this.currentMetrics.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<HorizontalPodAutoscalerConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<HorizontalPodAutoscalerConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        HorizontalPodAutoscalerConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromCurrentMetrics(Predicate<MetricStatusBuilder> predicate) {
    if (currentMetrics == null) {
      return (A) this;
    }
    Iterator<MetricStatusBuilder> each = currentMetrics.iterator();
    List visitables = _visitables.get("currentMetrics");
    while (each.hasNext()) {
        MetricStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,HorizontalPodAutoscalerCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public CurrentMetricsNested<A> setNewCurrentMetricLike(int index,MetricStatus item) {
    return new CurrentMetricsNested(index, item);
  }
  
  public A setToConditions(int index,HorizontalPodAutoscalerCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    HorizontalPodAutoscalerConditionBuilder builder = new HorizontalPodAutoscalerConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToCurrentMetrics(int index,MetricStatus item) {
    if (this.currentMetrics == null) {
      this.currentMetrics = new ArrayList();
    }
    MetricStatusBuilder builder = new MetricStatusBuilder(item);
    if (index < 0 || index >= currentMetrics.size()) {
        _visitables.get("currentMetrics").add(builder);
        currentMetrics.add(builder);
    } else {
        _visitables.get("currentMetrics").add(builder);
        currentMetrics.set(index, builder);
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
    if (!(currentMetrics == null) && !(currentMetrics.isEmpty())) {
        sb.append("currentMetrics:");
        sb.append(currentMetrics);
        sb.append(",");
    }
    if (!(currentReplicas == null)) {
        sb.append("currentReplicas:");
        sb.append(currentReplicas);
        sb.append(",");
    }
    if (!(desiredReplicas == null)) {
        sb.append("desiredReplicas:");
        sb.append(desiredReplicas);
        sb.append(",");
    }
    if (!(lastScaleTime == null)) {
        sb.append("lastScaleTime:");
        sb.append(lastScaleTime);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
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
  
  public A withConditions(List<HorizontalPodAutoscalerCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (HorizontalPodAutoscalerCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(HorizontalPodAutoscalerCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (HorizontalPodAutoscalerCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentMetrics(List<MetricStatus> currentMetrics) {
    if (this.currentMetrics != null) {
      this._visitables.get("currentMetrics").clear();
    }
    if (currentMetrics != null) {
        this.currentMetrics = new ArrayList();
        for (MetricStatus item : currentMetrics) {
          this.addToCurrentMetrics(item);
        }
    } else {
      this.currentMetrics = null;
    }
    return (A) this;
  }
  
  public A withCurrentMetrics(MetricStatus... currentMetrics) {
    if (this.currentMetrics != null) {
        this.currentMetrics.clear();
        _visitables.remove("currentMetrics");
    }
    if (currentMetrics != null) {
      for (MetricStatus item : currentMetrics) {
        this.addToCurrentMetrics(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentReplicas(Integer currentReplicas) {
    this.currentReplicas = currentReplicas;
    return (A) this;
  }
  
  public A withDesiredReplicas(Integer desiredReplicas) {
    this.desiredReplicas = desiredReplicas;
    return (A) this;
  }
  
  public A withLastScaleTime(String lastScaleTime) {
    this.lastScaleTime = lastScaleTime;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  public class ConditionsNested<N> extends HorizontalPodAutoscalerConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    HorizontalPodAutoscalerConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,HorizontalPodAutoscalerCondition item) {
      this.index = index;
      this.builder = new HorizontalPodAutoscalerConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) HorizontalPodAutoscalerStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class CurrentMetricsNested<N> extends MetricStatusFluent<CurrentMetricsNested<N>> implements Nested<N>{
  
    MetricStatusBuilder builder;
    int index;
  
    CurrentMetricsNested(int index,MetricStatus item) {
      this.index = index;
      this.builder = new MetricStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) HorizontalPodAutoscalerStatusFluent.this.setToCurrentMetrics(index, builder.build());
    }
    
    public N endCurrentMetric() {
      return and();
    }
    
  }
}