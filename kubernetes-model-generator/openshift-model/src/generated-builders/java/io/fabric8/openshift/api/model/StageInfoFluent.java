package io.fabric8.openshift.api.model;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class StageInfoFluent<A extends io.fabric8.openshift.api.model.StageInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long durationMilliseconds;
  private String name;
  private String startTime;
  private ArrayList<StepInfoBuilder> steps = new ArrayList<StepInfoBuilder>();

  public StageInfoFluent() {
  }
  
  public StageInfoFluent(StageInfo instance) {
    this.copyInstance(instance);
  }

  public A addAllToSteps(Collection<StepInfo> items) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    for (StepInfo item : items) {
        StepInfoBuilder builder = new StepInfoBuilder(item);
        _visitables.get("steps").add(builder);
        this.steps.add(builder);
    }
    return (A) this;
  }
  
  public StepsNested<A> addNewStep() {
    return new StepsNested(-1, null);
  }
  
  public A addNewStep(Long durationMilliseconds,String name,String startTime) {
    return (A) this.addToSteps(new StepInfo(durationMilliseconds, name, startTime));
  }
  
  public StepsNested<A> addNewStepLike(StepInfo item) {
    return new StepsNested(-1, item);
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
  
  public A addToSteps(StepInfo... items) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    for (StepInfo item : items) {
        StepInfoBuilder builder = new StepInfoBuilder(item);
        _visitables.get("steps").add(builder);
        this.steps.add(builder);
    }
    return (A) this;
  }
  
  public A addToSteps(int index,StepInfo item) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    StepInfoBuilder builder = new StepInfoBuilder(item);
    if (index < 0 || index >= steps.size()) {
        _visitables.get("steps").add(builder);
        steps.add(builder);
    } else {
        _visitables.get("steps").add(builder);
        steps.add(index, builder);
    }
    return (A) this;
  }
  
  public StepInfo buildFirstStep() {
    return this.steps.get(0).build();
  }
  
  public StepInfo buildLastStep() {
    return this.steps.get(steps.size() - 1).build();
  }
  
  public StepInfo buildMatchingStep(Predicate<StepInfoBuilder> predicate) {
      for (StepInfoBuilder item : steps) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StepInfo buildStep(int index) {
    return this.steps.get(index).build();
  }
  
  public List<StepInfo> buildSteps() {
    return this.steps != null ? build(steps) : null;
  }
  
  protected void copyInstance(StageInfo instance) {
    instance = instance != null ? instance : new StageInfo();
    if (instance != null) {
        this.withDurationMilliseconds(instance.getDurationMilliseconds());
        this.withName(instance.getName());
        this.withStartTime(instance.getStartTime());
        this.withSteps(instance.getSteps());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StepsNested<A> editFirstStep() {
    if (steps.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "steps"));
    }
    return this.setNewStepLike(0, this.buildStep(0));
  }
  
  public StepsNested<A> editLastStep() {
    int index = steps.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
  }
  
  public StepsNested<A> editMatchingStep(Predicate<StepInfoBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < steps.size();i++) {
      if (predicate.test(steps.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
  }
  
  public StepsNested<A> editStep(int index) {
    if (steps.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
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
    StageInfoFluent that = (StageInfoFluent) o;
    if (!(Objects.equals(durationMilliseconds, that.durationMilliseconds))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
      return false;
    }
    if (!(Objects.equals(steps, that.steps))) {
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
  
  public Long getDurationMilliseconds() {
    return this.durationMilliseconds;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDurationMilliseconds() {
    return this.durationMilliseconds != null;
  }
  
  public boolean hasMatchingStep(Predicate<StepInfoBuilder> predicate) {
      for (StepInfoBuilder item : steps) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public boolean hasSteps() {
    return this.steps != null && !(this.steps.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(durationMilliseconds, name, startTime, steps, additionalProperties);
  }
  
  public A removeAllFromSteps(Collection<StepInfo> items) {
    if (this.steps == null) {
      return (A) this;
    }
    for (StepInfo item : items) {
        StepInfoBuilder builder = new StepInfoBuilder(item);
        _visitables.get("steps").remove(builder);
        this.steps.remove(builder);
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
  
  public A removeFromSteps(StepInfo... items) {
    if (this.steps == null) {
      return (A) this;
    }
    for (StepInfo item : items) {
        StepInfoBuilder builder = new StepInfoBuilder(item);
        _visitables.get("steps").remove(builder);
        this.steps.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSteps(Predicate<StepInfoBuilder> predicate) {
    if (steps == null) {
      return (A) this;
    }
    Iterator<StepInfoBuilder> each = steps.iterator();
    List visitables = _visitables.get("steps");
    while (each.hasNext()) {
        StepInfoBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public StepsNested<A> setNewStepLike(int index,StepInfo item) {
    return new StepsNested(index, item);
  }
  
  public A setToSteps(int index,StepInfo item) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    StepInfoBuilder builder = new StepInfoBuilder(item);
    if (index < 0 || index >= steps.size()) {
        _visitables.get("steps").add(builder);
        steps.add(builder);
    } else {
        _visitables.get("steps").add(builder);
        steps.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(durationMilliseconds == null)) {
        sb.append("durationMilliseconds:");
        sb.append(durationMilliseconds);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
        sb.append(",");
    }
    if (!(steps == null) && !(steps.isEmpty())) {
        sb.append("steps:");
        sb.append(steps);
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
  
  public A withDurationMilliseconds(Long durationMilliseconds) {
    this.durationMilliseconds = durationMilliseconds;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  
  public A withSteps(List<StepInfo> steps) {
    if (this.steps != null) {
      this._visitables.get("steps").clear();
    }
    if (steps != null) {
        this.steps = new ArrayList();
        for (StepInfo item : steps) {
          this.addToSteps(item);
        }
    } else {
      this.steps = null;
    }
    return (A) this;
  }
  
  public A withSteps(StepInfo... steps) {
    if (this.steps != null) {
        this.steps.clear();
        _visitables.remove("steps");
    }
    if (steps != null) {
      for (StepInfo item : steps) {
        this.addToSteps(item);
      }
    }
    return (A) this;
  }
  public class StepsNested<N> extends StepInfoFluent<StepsNested<N>> implements Nested<N>{
  
    StepInfoBuilder builder;
    int index;
  
    StepsNested(int index,StepInfo item) {
      this.index = index;
      this.builder = new StepInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) StageInfoFluent.this.setToSteps(index, builder.build());
    }
    
    public N endStep() {
      return and();
    }
    
  }
}