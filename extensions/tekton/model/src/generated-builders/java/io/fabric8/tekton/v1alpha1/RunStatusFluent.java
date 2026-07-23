package io.fabric8.tekton.v1alpha1;

import io.fabric8.knative.pkg.apis.Condition;
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
public class RunStatusFluent<A extends io.fabric8.tekton.v1alpha1.RunStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private String completionTime;
  private List<Condition> conditions = new ArrayList<Condition>();
  private Object extraFields;
  private Long observedGeneration;
  private ArrayList<RunResultBuilder> results = new ArrayList<RunResultBuilder>();
  private ArrayList<RunStatusBuilder> retriesStatus = new ArrayList<RunStatusBuilder>();
  private String startTime;

  public RunStatusFluent() {
  }
  
  public RunStatusFluent(RunStatus instance) {
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
  
  public A addAllToResults(Collection<RunResult> items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (RunResult item : items) {
        RunResultBuilder builder = new RunResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRetriesStatus(Collection<RunStatus> items) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    for (RunStatus item : items) {
        RunStatusBuilder builder = new RunStatusBuilder(item);
        _visitables.get("retriesStatus").add(builder);
        this.retriesStatus.add(builder);
    }
    return (A) this;
  }
  
  public ResultsNested<A> addNewResult() {
    return new ResultsNested(-1, null);
  }
  
  public A addNewResult(String name,String value) {
    return (A) this.addToResults(new RunResult(name, value));
  }
  
  public ResultsNested<A> addNewResultLike(RunResult item) {
    return new ResultsNested(-1, item);
  }
  
  public RetriesStatusNested<A> addNewRetriesStatus() {
    return new RetriesStatusNested(-1, null);
  }
  
  public RetriesStatusNested<A> addNewRetriesStatusLike(RunStatus item) {
    return new RetriesStatusNested(-1, item);
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
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
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
  
  public A addToResults(RunResult... items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (RunResult item : items) {
        RunResultBuilder builder = new RunResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addToResults(int index,RunResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    RunResultBuilder builder = new RunResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRetriesStatus(RunStatus... items) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    for (RunStatus item : items) {
        RunStatusBuilder builder = new RunStatusBuilder(item);
        _visitables.get("retriesStatus").add(builder);
        this.retriesStatus.add(builder);
    }
    return (A) this;
  }
  
  public A addToRetriesStatus(int index,RunStatus item) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    RunStatusBuilder builder = new RunStatusBuilder(item);
    if (index < 0 || index >= retriesStatus.size()) {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.add(builder);
    } else {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.add(index, builder);
    }
    return (A) this;
  }
  
  public RunResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public RunStatus buildFirstRetriesStatus() {
    return this.retriesStatus.get(0).build();
  }
  
  public RunResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public RunStatus buildLastRetriesStatus() {
    return this.retriesStatus.get(retriesStatus.size() - 1).build();
  }
  
  public RunResult buildMatchingResult(Predicate<RunResultBuilder> predicate) {
      for (RunResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RunStatus buildMatchingRetriesStatus(Predicate<RunStatusBuilder> predicate) {
      for (RunStatusBuilder item : retriesStatus) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RunResult buildResult(int index) {
    return this.results.get(index).build();
  }
  
  public List<RunResult> buildResults() {
    return this.results != null ? build(results) : null;
  }
  
  public List<RunStatus> buildRetriesStatus() {
    return this.retriesStatus != null ? build(retriesStatus) : null;
  }
  
  public RunStatus buildRetriesStatus(int index) {
    return this.retriesStatus.get(index).build();
  }
  
  protected void copyInstance(RunStatus instance) {
    instance = instance != null ? instance : new RunStatus();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withCompletionTime(instance.getCompletionTime());
        this.withConditions(instance.getConditions());
        this.withExtraFields(instance.getExtraFields());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withResults(instance.getResults());
        this.withRetriesStatus(instance.getRetriesStatus());
        this.withStartTime(instance.getStartTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResultsNested<A> editFirstResult() {
    if (results.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(0, this.buildResult(0));
  }
  
  public RetriesStatusNested<A> editFirstRetriesStatus() {
    if (retriesStatus.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "retriesStatus"));
    }
    return this.setNewRetriesStatusLike(0, this.buildRetriesStatus(0));
  }
  
  public ResultsNested<A> editLastResult() {
    int index = results.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public RetriesStatusNested<A> editLastRetriesStatus() {
    int index = retriesStatus.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "retriesStatus"));
    }
    return this.setNewRetriesStatusLike(index, this.buildRetriesStatus(index));
  }
  
  public ResultsNested<A> editMatchingResult(Predicate<RunResultBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < results.size();i++) {
      if (predicate.test(results.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public RetriesStatusNested<A> editMatchingRetriesStatus(Predicate<RunStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < retriesStatus.size();i++) {
      if (predicate.test(retriesStatus.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "retriesStatus"));
    }
    return this.setNewRetriesStatusLike(index, this.buildRetriesStatus(index));
  }
  
  public ResultsNested<A> editResult(int index) {
    if (results.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public RetriesStatusNested<A> editRetriesStatus(int index) {
    if (retriesStatus.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "retriesStatus"));
    }
    return this.setNewRetriesStatusLike(index, this.buildRetriesStatus(index));
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
    RunStatusFluent that = (RunStatusFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(completionTime, that.completionTime))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(extraFields, that.extraFields))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(results, that.results))) {
      return false;
    }
    if (!(Objects.equals(retriesStatus, that.retriesStatus))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
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
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public String getCompletionTime() {
    return this.completionTime;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Object getExtraFields() {
    return this.extraFields;
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
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasCompletionTime() {
    return this.completionTime != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasExtraFields() {
    return this.extraFields != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResult(Predicate<RunResultBuilder> predicate) {
      for (RunResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRetriesStatus(Predicate<RunStatusBuilder> predicate) {
      for (RunStatusBuilder item : retriesStatus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasResults() {
    return this.results != null && !(this.results.isEmpty());
  }
  
  public boolean hasRetriesStatus() {
    return this.retriesStatus != null && !(this.retriesStatus.isEmpty());
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotations, completionTime, conditions, extraFields, observedGeneration, results, retriesStatus, startTime, additionalProperties);
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
  
  public A removeAllFromResults(Collection<RunResult> items) {
    if (this.results == null) {
      return (A) this;
    }
    for (RunResult item : items) {
        RunResultBuilder builder = new RunResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRetriesStatus(Collection<RunStatus> items) {
    if (this.retriesStatus == null) {
      return (A) this;
    }
    for (RunStatus item : items) {
        RunStatusBuilder builder = new RunStatusBuilder(item);
        _visitables.get("retriesStatus").remove(builder);
        this.retriesStatus.remove(builder);
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
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
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
  
  public A removeFromResults(RunResult... items) {
    if (this.results == null) {
      return (A) this;
    }
    for (RunResult item : items) {
        RunResultBuilder builder = new RunResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRetriesStatus(RunStatus... items) {
    if (this.retriesStatus == null) {
      return (A) this;
    }
    for (RunStatus item : items) {
        RunStatusBuilder builder = new RunStatusBuilder(item);
        _visitables.get("retriesStatus").remove(builder);
        this.retriesStatus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResults(Predicate<RunResultBuilder> predicate) {
    if (results == null) {
      return (A) this;
    }
    Iterator<RunResultBuilder> each = results.iterator();
    List visitables = _visitables.get("results");
    while (each.hasNext()) {
        RunResultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRetriesStatus(Predicate<RunStatusBuilder> predicate) {
    if (retriesStatus == null) {
      return (A) this;
    }
    Iterator<RunStatusBuilder> each = retriesStatus.iterator();
    List visitables = _visitables.get("retriesStatus");
    while (each.hasNext()) {
        RunStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResultsNested<A> setNewResultLike(int index,RunResult item) {
    return new ResultsNested(index, item);
  }
  
  public RetriesStatusNested<A> setNewRetriesStatusLike(int index,RunStatus item) {
    return new RetriesStatusNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToResults(int index,RunResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    RunResultBuilder builder = new RunResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRetriesStatus(int index,RunStatus item) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    RunStatusBuilder builder = new RunStatusBuilder(item);
    if (index < 0 || index >= retriesStatus.size()) {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.add(builder);
    } else {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(completionTime == null)) {
        sb.append("completionTime:");
        sb.append(completionTime);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(extraFields == null)) {
        sb.append("extraFields:");
        sb.append(extraFields);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(results == null) && !(results.isEmpty())) {
        sb.append("results:");
        sb.append(results);
        sb.append(",");
    }
    if (!(retriesStatus == null) && !(retriesStatus.isEmpty())) {
        sb.append("retriesStatus:");
        sb.append(retriesStatus);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
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
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withCompletionTime(String completionTime) {
    this.completionTime = completionTime;
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
  
  public A withExtraFields(Object extraFields) {
    this.extraFields = extraFields;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withResults(List<RunResult> results) {
    if (this.results != null) {
      this._visitables.get("results").clear();
    }
    if (results != null) {
        this.results = new ArrayList();
        for (RunResult item : results) {
          this.addToResults(item);
        }
    } else {
      this.results = null;
    }
    return (A) this;
  }
  
  public A withResults(RunResult... results) {
    if (this.results != null) {
        this.results.clear();
        _visitables.remove("results");
    }
    if (results != null) {
      for (RunResult item : results) {
        this.addToResults(item);
      }
    }
    return (A) this;
  }
  
  public A withRetriesStatus(List<RunStatus> retriesStatus) {
    if (this.retriesStatus != null) {
      this._visitables.get("retriesStatus").clear();
    }
    if (retriesStatus != null) {
        this.retriesStatus = new ArrayList();
        for (RunStatus item : retriesStatus) {
          this.addToRetriesStatus(item);
        }
    } else {
      this.retriesStatus = null;
    }
    return (A) this;
  }
  
  public A withRetriesStatus(RunStatus... retriesStatus) {
    if (this.retriesStatus != null) {
        this.retriesStatus.clear();
        _visitables.remove("retriesStatus");
    }
    if (retriesStatus != null) {
      for (RunStatus item : retriesStatus) {
        this.addToRetriesStatus(item);
      }
    }
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  public class ResultsNested<N> extends RunResultFluent<ResultsNested<N>> implements Nested<N>{
  
    RunResultBuilder builder;
    int index;
  
    ResultsNested(int index,RunResult item) {
      this.index = index;
      this.builder = new RunResultBuilder(this, item);
    }
  
    public N and() {
      return (N) RunStatusFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
  public class RetriesStatusNested<N> extends RunStatusFluent<RetriesStatusNested<N>> implements Nested<N>{
  
    RunStatusBuilder builder;
    int index;
  
    RetriesStatusNested(int index,RunStatus item) {
      this.index = index;
      this.builder = new RunStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) RunStatusFluent.this.setToRetriesStatus(index, builder.build());
    }
    
    public N endRetriesStatus() {
      return and();
    }
    
  }
}