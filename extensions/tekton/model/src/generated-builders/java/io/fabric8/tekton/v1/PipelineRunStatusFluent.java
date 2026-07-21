package io.fabric8.tekton.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PipelineRunStatusFluent<A extends io.fabric8.tekton.v1.PipelineRunStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private ArrayList<ChildStatusReferenceBuilder> childReferences = new ArrayList<ChildStatusReferenceBuilder>();
  private String completionTime;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String finallyStartTime;
  private Long observedGeneration;
  private PipelineSpecBuilder pipelineSpec;
  private ProvenanceBuilder provenance;
  private ArrayList<PipelineRunResultBuilder> results = new ArrayList<PipelineRunResultBuilder>();
  private ArrayList<SkippedTaskBuilder> skippedTasks = new ArrayList<SkippedTaskBuilder>();
  private Map<String,String> spanContext;
  private String startTime;

  public PipelineRunStatusFluent() {
  }
  
  public PipelineRunStatusFluent(PipelineRunStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToChildReferences(Collection<ChildStatusReference> items) {
    if (this.childReferences == null) {
      this.childReferences = new ArrayList();
    }
    for (ChildStatusReference item : items) {
        ChildStatusReferenceBuilder builder = new ChildStatusReferenceBuilder(item);
        _visitables.get("childReferences").add(builder);
        this.childReferences.add(builder);
    }
    return (A) this;
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
  
  public A addAllToResults(Collection<PipelineRunResult> items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (PipelineRunResult item : items) {
        PipelineRunResultBuilder builder = new PipelineRunResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSkippedTasks(Collection<SkippedTask> items) {
    if (this.skippedTasks == null) {
      this.skippedTasks = new ArrayList();
    }
    for (SkippedTask item : items) {
        SkippedTaskBuilder builder = new SkippedTaskBuilder(item);
        _visitables.get("skippedTasks").add(builder);
        this.skippedTasks.add(builder);
    }
    return (A) this;
  }
  
  public ChildReferencesNested<A> addNewChildReference() {
    return new ChildReferencesNested(-1, null);
  }
  
  public ChildReferencesNested<A> addNewChildReferenceLike(ChildStatusReference item) {
    return new ChildReferencesNested(-1, item);
  }
  
  public ResultsNested<A> addNewResult() {
    return new ResultsNested(-1, null);
  }
  
  public ResultsNested<A> addNewResultLike(PipelineRunResult item) {
    return new ResultsNested(-1, item);
  }
  
  public SkippedTasksNested<A> addNewSkippedTask() {
    return new SkippedTasksNested(-1, null);
  }
  
  public SkippedTasksNested<A> addNewSkippedTaskLike(SkippedTask item) {
    return new SkippedTasksNested(-1, item);
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
  
  public A addToChildReferences(ChildStatusReference... items) {
    if (this.childReferences == null) {
      this.childReferences = new ArrayList();
    }
    for (ChildStatusReference item : items) {
        ChildStatusReferenceBuilder builder = new ChildStatusReferenceBuilder(item);
        _visitables.get("childReferences").add(builder);
        this.childReferences.add(builder);
    }
    return (A) this;
  }
  
  public A addToChildReferences(int index,ChildStatusReference item) {
    if (this.childReferences == null) {
      this.childReferences = new ArrayList();
    }
    ChildStatusReferenceBuilder builder = new ChildStatusReferenceBuilder(item);
    if (index < 0 || index >= childReferences.size()) {
        _visitables.get("childReferences").add(builder);
        childReferences.add(builder);
    } else {
        _visitables.get("childReferences").add(builder);
        childReferences.add(index, builder);
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
  
  public A addToResults(PipelineRunResult... items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (PipelineRunResult item : items) {
        PipelineRunResultBuilder builder = new PipelineRunResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addToResults(int index,PipelineRunResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    PipelineRunResultBuilder builder = new PipelineRunResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSkippedTasks(SkippedTask... items) {
    if (this.skippedTasks == null) {
      this.skippedTasks = new ArrayList();
    }
    for (SkippedTask item : items) {
        SkippedTaskBuilder builder = new SkippedTaskBuilder(item);
        _visitables.get("skippedTasks").add(builder);
        this.skippedTasks.add(builder);
    }
    return (A) this;
  }
  
  public A addToSkippedTasks(int index,SkippedTask item) {
    if (this.skippedTasks == null) {
      this.skippedTasks = new ArrayList();
    }
    SkippedTaskBuilder builder = new SkippedTaskBuilder(item);
    if (index < 0 || index >= skippedTasks.size()) {
        _visitables.get("skippedTasks").add(builder);
        skippedTasks.add(builder);
    } else {
        _visitables.get("skippedTasks").add(builder);
        skippedTasks.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSpanContext(Map<String,String> map) {
    if (this.spanContext == null && map != null) {
      this.spanContext = new LinkedHashMap();
    }
    if (map != null) {
      this.spanContext.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSpanContext(String key,String value) {
    if (this.spanContext == null && key != null && value != null) {
      this.spanContext = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.spanContext.put(key, value);
    }
    return (A) this;
  }
  
  public ChildStatusReference buildChildReference(int index) {
    return this.childReferences.get(index).build();
  }
  
  public List<ChildStatusReference> buildChildReferences() {
    return this.childReferences != null ? build(childReferences) : null;
  }
  
  public ChildStatusReference buildFirstChildReference() {
    return this.childReferences.get(0).build();
  }
  
  public PipelineRunResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public SkippedTask buildFirstSkippedTask() {
    return this.skippedTasks.get(0).build();
  }
  
  public ChildStatusReference buildLastChildReference() {
    return this.childReferences.get(childReferences.size() - 1).build();
  }
  
  public PipelineRunResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public SkippedTask buildLastSkippedTask() {
    return this.skippedTasks.get(skippedTasks.size() - 1).build();
  }
  
  public ChildStatusReference buildMatchingChildReference(Predicate<ChildStatusReferenceBuilder> predicate) {
      for (ChildStatusReferenceBuilder item : childReferences) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineRunResult buildMatchingResult(Predicate<PipelineRunResultBuilder> predicate) {
      for (PipelineRunResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SkippedTask buildMatchingSkippedTask(Predicate<SkippedTaskBuilder> predicate) {
      for (SkippedTaskBuilder item : skippedTasks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineSpec buildPipelineSpec() {
    return this.pipelineSpec != null ? this.pipelineSpec.build() : null;
  }
  
  public Provenance buildProvenance() {
    return this.provenance != null ? this.provenance.build() : null;
  }
  
  public PipelineRunResult buildResult(int index) {
    return this.results.get(index).build();
  }
  
  public List<PipelineRunResult> buildResults() {
    return this.results != null ? build(results) : null;
  }
  
  public SkippedTask buildSkippedTask(int index) {
    return this.skippedTasks.get(index).build();
  }
  
  public List<SkippedTask> buildSkippedTasks() {
    return this.skippedTasks != null ? build(skippedTasks) : null;
  }
  
  protected void copyInstance(PipelineRunStatus instance) {
    instance = instance != null ? instance : new PipelineRunStatus();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withChildReferences(instance.getChildReferences());
        this.withCompletionTime(instance.getCompletionTime());
        this.withConditions(instance.getConditions());
        this.withFinallyStartTime(instance.getFinallyStartTime());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPipelineSpec(instance.getPipelineSpec());
        this.withProvenance(instance.getProvenance());
        this.withResults(instance.getResults());
        this.withSkippedTasks(instance.getSkippedTasks());
        this.withSpanContext(instance.getSpanContext());
        this.withStartTime(instance.getStartTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ChildReferencesNested<A> editChildReference(int index) {
    if (childReferences.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "childReferences"));
    }
    return this.setNewChildReferenceLike(index, this.buildChildReference(index));
  }
  
  public ChildReferencesNested<A> editFirstChildReference() {
    if (childReferences.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "childReferences"));
    }
    return this.setNewChildReferenceLike(0, this.buildChildReference(0));
  }
  
  public ResultsNested<A> editFirstResult() {
    if (results.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(0, this.buildResult(0));
  }
  
  public SkippedTasksNested<A> editFirstSkippedTask() {
    if (skippedTasks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "skippedTasks"));
    }
    return this.setNewSkippedTaskLike(0, this.buildSkippedTask(0));
  }
  
  public ChildReferencesNested<A> editLastChildReference() {
    int index = childReferences.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "childReferences"));
    }
    return this.setNewChildReferenceLike(index, this.buildChildReference(index));
  }
  
  public ResultsNested<A> editLastResult() {
    int index = results.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public SkippedTasksNested<A> editLastSkippedTask() {
    int index = skippedTasks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "skippedTasks"));
    }
    return this.setNewSkippedTaskLike(index, this.buildSkippedTask(index));
  }
  
  public ChildReferencesNested<A> editMatchingChildReference(Predicate<ChildStatusReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < childReferences.size();i++) {
      if (predicate.test(childReferences.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "childReferences"));
    }
    return this.setNewChildReferenceLike(index, this.buildChildReference(index));
  }
  
  public ResultsNested<A> editMatchingResult(Predicate<PipelineRunResultBuilder> predicate) {
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
  
  public SkippedTasksNested<A> editMatchingSkippedTask(Predicate<SkippedTaskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < skippedTasks.size();i++) {
      if (predicate.test(skippedTasks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "skippedTasks"));
    }
    return this.setNewSkippedTaskLike(index, this.buildSkippedTask(index));
  }
  
  public PipelineSpecNested<A> editOrNewPipelineSpec() {
    return this.withNewPipelineSpecLike(Optional.ofNullable(this.buildPipelineSpec()).orElse(new PipelineSpecBuilder().build()));
  }
  
  public PipelineSpecNested<A> editOrNewPipelineSpecLike(PipelineSpec item) {
    return this.withNewPipelineSpecLike(Optional.ofNullable(this.buildPipelineSpec()).orElse(item));
  }
  
  public ProvenanceNested<A> editOrNewProvenance() {
    return this.withNewProvenanceLike(Optional.ofNullable(this.buildProvenance()).orElse(new ProvenanceBuilder().build()));
  }
  
  public ProvenanceNested<A> editOrNewProvenanceLike(Provenance item) {
    return this.withNewProvenanceLike(Optional.ofNullable(this.buildProvenance()).orElse(item));
  }
  
  public PipelineSpecNested<A> editPipelineSpec() {
    return this.withNewPipelineSpecLike(Optional.ofNullable(this.buildPipelineSpec()).orElse(null));
  }
  
  public ProvenanceNested<A> editProvenance() {
    return this.withNewProvenanceLike(Optional.ofNullable(this.buildProvenance()).orElse(null));
  }
  
  public ResultsNested<A> editResult(int index) {
    if (results.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public SkippedTasksNested<A> editSkippedTask(int index) {
    if (skippedTasks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "skippedTasks"));
    }
    return this.setNewSkippedTaskLike(index, this.buildSkippedTask(index));
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
    PipelineRunStatusFluent that = (PipelineRunStatusFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(childReferences, that.childReferences))) {
      return false;
    }
    if (!(Objects.equals(completionTime, that.completionTime))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(finallyStartTime, that.finallyStartTime))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(pipelineSpec, that.pipelineSpec))) {
      return false;
    }
    if (!(Objects.equals(provenance, that.provenance))) {
      return false;
    }
    if (!(Objects.equals(results, that.results))) {
      return false;
    }
    if (!(Objects.equals(skippedTasks, that.skippedTasks))) {
      return false;
    }
    if (!(Objects.equals(spanContext, that.spanContext))) {
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
  
  public String getFinallyStartTime() {
    return this.finallyStartTime;
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
  
  public Map<String,String> getSpanContext() {
    return this.spanContext;
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
  
  public boolean hasChildReferences() {
    return this.childReferences != null && !(this.childReferences.isEmpty());
  }
  
  public boolean hasCompletionTime() {
    return this.completionTime != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFinallyStartTime() {
    return this.finallyStartTime != null;
  }
  
  public boolean hasMatchingChildReference(Predicate<ChildStatusReferenceBuilder> predicate) {
      for (ChildStatusReferenceBuilder item : childReferences) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResult(Predicate<PipelineRunResultBuilder> predicate) {
      for (PipelineRunResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSkippedTask(Predicate<SkippedTaskBuilder> predicate) {
      for (SkippedTaskBuilder item : skippedTasks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasPipelineSpec() {
    return this.pipelineSpec != null;
  }
  
  public boolean hasProvenance() {
    return this.provenance != null;
  }
  
  public boolean hasResults() {
    return this.results != null && !(this.results.isEmpty());
  }
  
  public boolean hasSkippedTasks() {
    return this.skippedTasks != null && !(this.skippedTasks.isEmpty());
  }
  
  public boolean hasSpanContext() {
    return this.spanContext != null;
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotations, childReferences, completionTime, conditions, finallyStartTime, observedGeneration, pipelineSpec, provenance, results, skippedTasks, spanContext, startTime, additionalProperties);
  }
  
  public A removeAllFromChildReferences(Collection<ChildStatusReference> items) {
    if (this.childReferences == null) {
      return (A) this;
    }
    for (ChildStatusReference item : items) {
        ChildStatusReferenceBuilder builder = new ChildStatusReferenceBuilder(item);
        _visitables.get("childReferences").remove(builder);
        this.childReferences.remove(builder);
    }
    return (A) this;
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
  
  public A removeAllFromResults(Collection<PipelineRunResult> items) {
    if (this.results == null) {
      return (A) this;
    }
    for (PipelineRunResult item : items) {
        PipelineRunResultBuilder builder = new PipelineRunResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSkippedTasks(Collection<SkippedTask> items) {
    if (this.skippedTasks == null) {
      return (A) this;
    }
    for (SkippedTask item : items) {
        SkippedTaskBuilder builder = new SkippedTaskBuilder(item);
        _visitables.get("skippedTasks").remove(builder);
        this.skippedTasks.remove(builder);
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
  
  public A removeFromChildReferences(ChildStatusReference... items) {
    if (this.childReferences == null) {
      return (A) this;
    }
    for (ChildStatusReference item : items) {
        ChildStatusReferenceBuilder builder = new ChildStatusReferenceBuilder(item);
        _visitables.get("childReferences").remove(builder);
        this.childReferences.remove(builder);
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
  
  public A removeFromResults(PipelineRunResult... items) {
    if (this.results == null) {
      return (A) this;
    }
    for (PipelineRunResult item : items) {
        PipelineRunResultBuilder builder = new PipelineRunResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSkippedTasks(SkippedTask... items) {
    if (this.skippedTasks == null) {
      return (A) this;
    }
    for (SkippedTask item : items) {
        SkippedTaskBuilder builder = new SkippedTaskBuilder(item);
        _visitables.get("skippedTasks").remove(builder);
        this.skippedTasks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSpanContext(String key) {
    if (this.spanContext == null) {
      return (A) this;
    }
    if (key != null && this.spanContext != null) {
      this.spanContext.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSpanContext(Map<String,String> map) {
    if (this.spanContext == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.spanContext != null) {
          this.spanContext.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromChildReferences(Predicate<ChildStatusReferenceBuilder> predicate) {
    if (childReferences == null) {
      return (A) this;
    }
    Iterator<ChildStatusReferenceBuilder> each = childReferences.iterator();
    List visitables = _visitables.get("childReferences");
    while (each.hasNext()) {
        ChildStatusReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResults(Predicate<PipelineRunResultBuilder> predicate) {
    if (results == null) {
      return (A) this;
    }
    Iterator<PipelineRunResultBuilder> each = results.iterator();
    List visitables = _visitables.get("results");
    while (each.hasNext()) {
        PipelineRunResultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSkippedTasks(Predicate<SkippedTaskBuilder> predicate) {
    if (skippedTasks == null) {
      return (A) this;
    }
    Iterator<SkippedTaskBuilder> each = skippedTasks.iterator();
    List visitables = _visitables.get("skippedTasks");
    while (each.hasNext()) {
        SkippedTaskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ChildReferencesNested<A> setNewChildReferenceLike(int index,ChildStatusReference item) {
    return new ChildReferencesNested(index, item);
  }
  
  public ResultsNested<A> setNewResultLike(int index,PipelineRunResult item) {
    return new ResultsNested(index, item);
  }
  
  public SkippedTasksNested<A> setNewSkippedTaskLike(int index,SkippedTask item) {
    return new SkippedTasksNested(index, item);
  }
  
  public A setToChildReferences(int index,ChildStatusReference item) {
    if (this.childReferences == null) {
      this.childReferences = new ArrayList();
    }
    ChildStatusReferenceBuilder builder = new ChildStatusReferenceBuilder(item);
    if (index < 0 || index >= childReferences.size()) {
        _visitables.get("childReferences").add(builder);
        childReferences.add(builder);
    } else {
        _visitables.get("childReferences").add(builder);
        childReferences.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToResults(int index,PipelineRunResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    PipelineRunResultBuilder builder = new PipelineRunResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSkippedTasks(int index,SkippedTask item) {
    if (this.skippedTasks == null) {
      this.skippedTasks = new ArrayList();
    }
    SkippedTaskBuilder builder = new SkippedTaskBuilder(item);
    if (index < 0 || index >= skippedTasks.size()) {
        _visitables.get("skippedTasks").add(builder);
        skippedTasks.add(builder);
    } else {
        _visitables.get("skippedTasks").add(builder);
        skippedTasks.set(index, builder);
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
    if (!(childReferences == null) && !(childReferences.isEmpty())) {
        sb.append("childReferences:");
        sb.append(childReferences);
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
    if (!(finallyStartTime == null)) {
        sb.append("finallyStartTime:");
        sb.append(finallyStartTime);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(pipelineSpec == null)) {
        sb.append("pipelineSpec:");
        sb.append(pipelineSpec);
        sb.append(",");
    }
    if (!(provenance == null)) {
        sb.append("provenance:");
        sb.append(provenance);
        sb.append(",");
    }
    if (!(results == null) && !(results.isEmpty())) {
        sb.append("results:");
        sb.append(results);
        sb.append(",");
    }
    if (!(skippedTasks == null) && !(skippedTasks.isEmpty())) {
        sb.append("skippedTasks:");
        sb.append(skippedTasks);
        sb.append(",");
    }
    if (!(spanContext == null) && !(spanContext.isEmpty())) {
        sb.append("spanContext:");
        sb.append(spanContext);
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
  
  public A withChildReferences(List<ChildStatusReference> childReferences) {
    if (this.childReferences != null) {
      this._visitables.get("childReferences").clear();
    }
    if (childReferences != null) {
        this.childReferences = new ArrayList();
        for (ChildStatusReference item : childReferences) {
          this.addToChildReferences(item);
        }
    } else {
      this.childReferences = null;
    }
    return (A) this;
  }
  
  public A withChildReferences(ChildStatusReference... childReferences) {
    if (this.childReferences != null) {
        this.childReferences.clear();
        _visitables.remove("childReferences");
    }
    if (childReferences != null) {
      for (ChildStatusReference item : childReferences) {
        this.addToChildReferences(item);
      }
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
  
  public A withFinallyStartTime(String finallyStartTime) {
    this.finallyStartTime = finallyStartTime;
    return (A) this;
  }
  
  public PipelineSpecNested<A> withNewPipelineSpec() {
    return new PipelineSpecNested(null);
  }
  
  public PipelineSpecNested<A> withNewPipelineSpecLike(PipelineSpec item) {
    return new PipelineSpecNested(item);
  }
  
  public ProvenanceNested<A> withNewProvenance() {
    return new ProvenanceNested(null);
  }
  
  public ProvenanceNested<A> withNewProvenanceLike(Provenance item) {
    return new ProvenanceNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withPipelineSpec(PipelineSpec pipelineSpec) {
    this._visitables.remove("pipelineSpec");
    if (pipelineSpec != null) {
        this.pipelineSpec = new PipelineSpecBuilder(pipelineSpec);
        this._visitables.get("pipelineSpec").add(this.pipelineSpec);
    } else {
        this.pipelineSpec = null;
        this._visitables.get("pipelineSpec").remove(this.pipelineSpec);
    }
    return (A) this;
  }
  
  public A withProvenance(Provenance provenance) {
    this._visitables.remove("provenance");
    if (provenance != null) {
        this.provenance = new ProvenanceBuilder(provenance);
        this._visitables.get("provenance").add(this.provenance);
    } else {
        this.provenance = null;
        this._visitables.get("provenance").remove(this.provenance);
    }
    return (A) this;
  }
  
  public A withResults(List<PipelineRunResult> results) {
    if (this.results != null) {
      this._visitables.get("results").clear();
    }
    if (results != null) {
        this.results = new ArrayList();
        for (PipelineRunResult item : results) {
          this.addToResults(item);
        }
    } else {
      this.results = null;
    }
    return (A) this;
  }
  
  public A withResults(PipelineRunResult... results) {
    if (this.results != null) {
        this.results.clear();
        _visitables.remove("results");
    }
    if (results != null) {
      for (PipelineRunResult item : results) {
        this.addToResults(item);
      }
    }
    return (A) this;
  }
  
  public A withSkippedTasks(List<SkippedTask> skippedTasks) {
    if (this.skippedTasks != null) {
      this._visitables.get("skippedTasks").clear();
    }
    if (skippedTasks != null) {
        this.skippedTasks = new ArrayList();
        for (SkippedTask item : skippedTasks) {
          this.addToSkippedTasks(item);
        }
    } else {
      this.skippedTasks = null;
    }
    return (A) this;
  }
  
  public A withSkippedTasks(SkippedTask... skippedTasks) {
    if (this.skippedTasks != null) {
        this.skippedTasks.clear();
        _visitables.remove("skippedTasks");
    }
    if (skippedTasks != null) {
      for (SkippedTask item : skippedTasks) {
        this.addToSkippedTasks(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withSpanContext(Map<String,String> spanContext) {
    if (spanContext == null) {
      this.spanContext = null;
    } else {
      this.spanContext = new LinkedHashMap(spanContext);
    }
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  public class ChildReferencesNested<N> extends ChildStatusReferenceFluent<ChildReferencesNested<N>> implements Nested<N>{
  
    ChildStatusReferenceBuilder builder;
    int index;
  
    ChildReferencesNested(int index,ChildStatusReference item) {
      this.index = index;
      this.builder = new ChildStatusReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunStatusFluent.this.setToChildReferences(index, builder.build());
    }
    
    public N endChildReference() {
      return and();
    }
    
  }
  public class PipelineSpecNested<N> extends PipelineSpecFluent<PipelineSpecNested<N>> implements Nested<N>{
  
    PipelineSpecBuilder builder;
  
    PipelineSpecNested(PipelineSpec item) {
      this.builder = new PipelineSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunStatusFluent.this.withPipelineSpec(builder.build());
    }
    
    public N endPipelineSpec() {
      return and();
    }
    
  }
  public class ProvenanceNested<N> extends ProvenanceFluent<ProvenanceNested<N>> implements Nested<N>{
  
    ProvenanceBuilder builder;
  
    ProvenanceNested(Provenance item) {
      this.builder = new ProvenanceBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunStatusFluent.this.withProvenance(builder.build());
    }
    
    public N endProvenance() {
      return and();
    }
    
  }
  public class ResultsNested<N> extends PipelineRunResultFluent<ResultsNested<N>> implements Nested<N>{
  
    PipelineRunResultBuilder builder;
    int index;
  
    ResultsNested(int index,PipelineRunResult item) {
      this.index = index;
      this.builder = new PipelineRunResultBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunStatusFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
  public class SkippedTasksNested<N> extends SkippedTaskFluent<SkippedTasksNested<N>> implements Nested<N>{
  
    SkippedTaskBuilder builder;
    int index;
  
    SkippedTasksNested(int index,SkippedTask item) {
      this.index = index;
      this.builder = new SkippedTaskBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunStatusFluent.this.setToSkippedTasks(index, builder.build());
    }
    
    public N endSkippedTask() {
      return and();
    }
    
  }
}