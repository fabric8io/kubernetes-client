package io.fabric8.tekton.v1beta1;

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
public class CustomRunStatusFieldsFluent<A extends io.fabric8.tekton.v1beta1.CustomRunStatusFieldsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String completionTime;
  private Object extraFields;
  private ArrayList<CustomRunResultBuilder> results = new ArrayList<CustomRunResultBuilder>();
  private ArrayList<CustomRunStatusBuilder> retriesStatus = new ArrayList<CustomRunStatusBuilder>();
  private String startTime;

  public CustomRunStatusFieldsFluent() {
  }
  
  public CustomRunStatusFieldsFluent(CustomRunStatusFields instance) {
    this.copyInstance(instance);
  }

  public A addAllToResults(Collection<CustomRunResult> items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (CustomRunResult item : items) {
        CustomRunResultBuilder builder = new CustomRunResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRetriesStatus(Collection<CustomRunStatus> items) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    for (CustomRunStatus item : items) {
        CustomRunStatusBuilder builder = new CustomRunStatusBuilder(item);
        _visitables.get("retriesStatus").add(builder);
        this.retriesStatus.add(builder);
    }
    return (A) this;
  }
  
  public ResultsNested<A> addNewResult() {
    return new ResultsNested(-1, null);
  }
  
  public A addNewResult(String name,String value) {
    return (A) this.addToResults(new CustomRunResult(name, value));
  }
  
  public ResultsNested<A> addNewResultLike(CustomRunResult item) {
    return new ResultsNested(-1, item);
  }
  
  public RetriesStatusNested<A> addNewRetriesStatus() {
    return new RetriesStatusNested(-1, null);
  }
  
  public RetriesStatusNested<A> addNewRetriesStatusLike(CustomRunStatus item) {
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
  
  public A addToResults(CustomRunResult... items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (CustomRunResult item : items) {
        CustomRunResultBuilder builder = new CustomRunResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addToResults(int index,CustomRunResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    CustomRunResultBuilder builder = new CustomRunResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRetriesStatus(CustomRunStatus... items) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    for (CustomRunStatus item : items) {
        CustomRunStatusBuilder builder = new CustomRunStatusBuilder(item);
        _visitables.get("retriesStatus").add(builder);
        this.retriesStatus.add(builder);
    }
    return (A) this;
  }
  
  public A addToRetriesStatus(int index,CustomRunStatus item) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    CustomRunStatusBuilder builder = new CustomRunStatusBuilder(item);
    if (index < 0 || index >= retriesStatus.size()) {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.add(builder);
    } else {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.add(index, builder);
    }
    return (A) this;
  }
  
  public CustomRunResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public CustomRunStatus buildFirstRetriesStatus() {
    return this.retriesStatus.get(0).build();
  }
  
  public CustomRunResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public CustomRunStatus buildLastRetriesStatus() {
    return this.retriesStatus.get(retriesStatus.size() - 1).build();
  }
  
  public CustomRunResult buildMatchingResult(Predicate<CustomRunResultBuilder> predicate) {
      for (CustomRunResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public CustomRunStatus buildMatchingRetriesStatus(Predicate<CustomRunStatusBuilder> predicate) {
      for (CustomRunStatusBuilder item : retriesStatus) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public CustomRunResult buildResult(int index) {
    return this.results.get(index).build();
  }
  
  public List<CustomRunResult> buildResults() {
    return this.results != null ? build(results) : null;
  }
  
  public List<CustomRunStatus> buildRetriesStatus() {
    return this.retriesStatus != null ? build(retriesStatus) : null;
  }
  
  public CustomRunStatus buildRetriesStatus(int index) {
    return this.retriesStatus.get(index).build();
  }
  
  protected void copyInstance(CustomRunStatusFields instance) {
    instance = instance != null ? instance : new CustomRunStatusFields();
    if (instance != null) {
        this.withCompletionTime(instance.getCompletionTime());
        this.withExtraFields(instance.getExtraFields());
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
  
  public ResultsNested<A> editMatchingResult(Predicate<CustomRunResultBuilder> predicate) {
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
  
  public RetriesStatusNested<A> editMatchingRetriesStatus(Predicate<CustomRunStatusBuilder> predicate) {
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
    CustomRunStatusFieldsFluent that = (CustomRunStatusFieldsFluent) o;
    if (!(Objects.equals(completionTime, that.completionTime))) {
      return false;
    }
    if (!(Objects.equals(extraFields, that.extraFields))) {
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
  
  public String getCompletionTime() {
    return this.completionTime;
  }
  
  public Object getExtraFields() {
    return this.extraFields;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompletionTime() {
    return this.completionTime != null;
  }
  
  public boolean hasExtraFields() {
    return this.extraFields != null;
  }
  
  public boolean hasMatchingResult(Predicate<CustomRunResultBuilder> predicate) {
      for (CustomRunResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRetriesStatus(Predicate<CustomRunStatusBuilder> predicate) {
      for (CustomRunStatusBuilder item : retriesStatus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
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
    return Objects.hash(completionTime, extraFields, results, retriesStatus, startTime, additionalProperties);
  }
  
  public A removeAllFromResults(Collection<CustomRunResult> items) {
    if (this.results == null) {
      return (A) this;
    }
    for (CustomRunResult item : items) {
        CustomRunResultBuilder builder = new CustomRunResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRetriesStatus(Collection<CustomRunStatus> items) {
    if (this.retriesStatus == null) {
      return (A) this;
    }
    for (CustomRunStatus item : items) {
        CustomRunStatusBuilder builder = new CustomRunStatusBuilder(item);
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
  
  public A removeFromResults(CustomRunResult... items) {
    if (this.results == null) {
      return (A) this;
    }
    for (CustomRunResult item : items) {
        CustomRunResultBuilder builder = new CustomRunResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRetriesStatus(CustomRunStatus... items) {
    if (this.retriesStatus == null) {
      return (A) this;
    }
    for (CustomRunStatus item : items) {
        CustomRunStatusBuilder builder = new CustomRunStatusBuilder(item);
        _visitables.get("retriesStatus").remove(builder);
        this.retriesStatus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResults(Predicate<CustomRunResultBuilder> predicate) {
    if (results == null) {
      return (A) this;
    }
    Iterator<CustomRunResultBuilder> each = results.iterator();
    List visitables = _visitables.get("results");
    while (each.hasNext()) {
        CustomRunResultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRetriesStatus(Predicate<CustomRunStatusBuilder> predicate) {
    if (retriesStatus == null) {
      return (A) this;
    }
    Iterator<CustomRunStatusBuilder> each = retriesStatus.iterator();
    List visitables = _visitables.get("retriesStatus");
    while (each.hasNext()) {
        CustomRunStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResultsNested<A> setNewResultLike(int index,CustomRunResult item) {
    return new ResultsNested(index, item);
  }
  
  public RetriesStatusNested<A> setNewRetriesStatusLike(int index,CustomRunStatus item) {
    return new RetriesStatusNested(index, item);
  }
  
  public A setToResults(int index,CustomRunResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    CustomRunResultBuilder builder = new CustomRunResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRetriesStatus(int index,CustomRunStatus item) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    CustomRunStatusBuilder builder = new CustomRunStatusBuilder(item);
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
    if (!(completionTime == null)) {
        sb.append("completionTime:");
        sb.append(completionTime);
        sb.append(",");
    }
    if (!(extraFields == null)) {
        sb.append("extraFields:");
        sb.append(extraFields);
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
  
  public A withCompletionTime(String completionTime) {
    this.completionTime = completionTime;
    return (A) this;
  }
  
  public A withExtraFields(Object extraFields) {
    this.extraFields = extraFields;
    return (A) this;
  }
  
  public A withResults(List<CustomRunResult> results) {
    if (this.results != null) {
      this._visitables.get("results").clear();
    }
    if (results != null) {
        this.results = new ArrayList();
        for (CustomRunResult item : results) {
          this.addToResults(item);
        }
    } else {
      this.results = null;
    }
    return (A) this;
  }
  
  public A withResults(CustomRunResult... results) {
    if (this.results != null) {
        this.results.clear();
        _visitables.remove("results");
    }
    if (results != null) {
      for (CustomRunResult item : results) {
        this.addToResults(item);
      }
    }
    return (A) this;
  }
  
  public A withRetriesStatus(List<CustomRunStatus> retriesStatus) {
    if (this.retriesStatus != null) {
      this._visitables.get("retriesStatus").clear();
    }
    if (retriesStatus != null) {
        this.retriesStatus = new ArrayList();
        for (CustomRunStatus item : retriesStatus) {
          this.addToRetriesStatus(item);
        }
    } else {
      this.retriesStatus = null;
    }
    return (A) this;
  }
  
  public A withRetriesStatus(CustomRunStatus... retriesStatus) {
    if (this.retriesStatus != null) {
        this.retriesStatus.clear();
        _visitables.remove("retriesStatus");
    }
    if (retriesStatus != null) {
      for (CustomRunStatus item : retriesStatus) {
        this.addToRetriesStatus(item);
      }
    }
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  public class ResultsNested<N> extends CustomRunResultFluent<ResultsNested<N>> implements Nested<N>{
  
    CustomRunResultBuilder builder;
    int index;
  
    ResultsNested(int index,CustomRunResult item) {
      this.index = index;
      this.builder = new CustomRunResultBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomRunStatusFieldsFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
  public class RetriesStatusNested<N> extends CustomRunStatusFluent<RetriesStatusNested<N>> implements Nested<N>{
  
    CustomRunStatusBuilder builder;
    int index;
  
    RetriesStatusNested(int index,CustomRunStatus item) {
      this.index = index;
      this.builder = new CustomRunStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomRunStatusFieldsFluent.this.setToRetriesStatus(index, builder.build());
    }
    
    public N endRetriesStatus() {
      return and();
    }
    
  }
}