package io.fabric8.tekton.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TaskRunStatusFieldsFluent<A extends io.fabric8.tekton.v1.TaskRunStatusFieldsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArtifactsBuilder artifacts;
  private String completionTime;
  private String podName;
  private ProvenanceBuilder provenance;
  private ArrayList<TaskRunResultBuilder> results = new ArrayList<TaskRunResultBuilder>();
  private ArrayList<TaskRunStatusBuilder> retriesStatus = new ArrayList<TaskRunStatusBuilder>();
  private ArrayList<SidecarStateBuilder> sidecars = new ArrayList<SidecarStateBuilder>();
  private Map<String,String> spanContext;
  private String startTime;
  private ArrayList<StepStateBuilder> steps = new ArrayList<StepStateBuilder>();
  private TaskSpecBuilder taskSpec;

  public TaskRunStatusFieldsFluent() {
  }
  
  public TaskRunStatusFieldsFluent(TaskRunStatusFields instance) {
    this.copyInstance(instance);
  }

  public A addAllToResults(Collection<TaskRunResult> items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (TaskRunResult item : items) {
        TaskRunResultBuilder builder = new TaskRunResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRetriesStatus(Collection<TaskRunStatus> items) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    for (TaskRunStatus item : items) {
        TaskRunStatusBuilder builder = new TaskRunStatusBuilder(item);
        _visitables.get("retriesStatus").add(builder);
        this.retriesStatus.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSidecars(Collection<SidecarState> items) {
    if (this.sidecars == null) {
      this.sidecars = new ArrayList();
    }
    for (SidecarState item : items) {
        SidecarStateBuilder builder = new SidecarStateBuilder(item);
        _visitables.get("sidecars").add(builder);
        this.sidecars.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSteps(Collection<StepState> items) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    for (StepState item : items) {
        StepStateBuilder builder = new StepStateBuilder(item);
        _visitables.get("steps").add(builder);
        this.steps.add(builder);
    }
    return (A) this;
  }
  
  public ResultsNested<A> addNewResult() {
    return new ResultsNested(-1, null);
  }
  
  public ResultsNested<A> addNewResultLike(TaskRunResult item) {
    return new ResultsNested(-1, item);
  }
  
  public RetriesStatusNested<A> addNewRetriesStatus() {
    return new RetriesStatusNested(-1, null);
  }
  
  public RetriesStatusNested<A> addNewRetriesStatusLike(TaskRunStatus item) {
    return new RetriesStatusNested(-1, item);
  }
  
  public SidecarsNested<A> addNewSidecar() {
    return new SidecarsNested(-1, null);
  }
  
  public SidecarsNested<A> addNewSidecarLike(SidecarState item) {
    return new SidecarsNested(-1, item);
  }
  
  public StepsNested<A> addNewStep() {
    return new StepsNested(-1, null);
  }
  
  public StepsNested<A> addNewStepLike(StepState item) {
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
  
  public A addToResults(TaskRunResult... items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (TaskRunResult item : items) {
        TaskRunResultBuilder builder = new TaskRunResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addToResults(int index,TaskRunResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    TaskRunResultBuilder builder = new TaskRunResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRetriesStatus(TaskRunStatus... items) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    for (TaskRunStatus item : items) {
        TaskRunStatusBuilder builder = new TaskRunStatusBuilder(item);
        _visitables.get("retriesStatus").add(builder);
        this.retriesStatus.add(builder);
    }
    return (A) this;
  }
  
  public A addToRetriesStatus(int index,TaskRunStatus item) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    TaskRunStatusBuilder builder = new TaskRunStatusBuilder(item);
    if (index < 0 || index >= retriesStatus.size()) {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.add(builder);
    } else {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSidecars(SidecarState... items) {
    if (this.sidecars == null) {
      this.sidecars = new ArrayList();
    }
    for (SidecarState item : items) {
        SidecarStateBuilder builder = new SidecarStateBuilder(item);
        _visitables.get("sidecars").add(builder);
        this.sidecars.add(builder);
    }
    return (A) this;
  }
  
  public A addToSidecars(int index,SidecarState item) {
    if (this.sidecars == null) {
      this.sidecars = new ArrayList();
    }
    SidecarStateBuilder builder = new SidecarStateBuilder(item);
    if (index < 0 || index >= sidecars.size()) {
        _visitables.get("sidecars").add(builder);
        sidecars.add(builder);
    } else {
        _visitables.get("sidecars").add(builder);
        sidecars.add(index, builder);
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
  
  public A addToSteps(StepState... items) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    for (StepState item : items) {
        StepStateBuilder builder = new StepStateBuilder(item);
        _visitables.get("steps").add(builder);
        this.steps.add(builder);
    }
    return (A) this;
  }
  
  public A addToSteps(int index,StepState item) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    StepStateBuilder builder = new StepStateBuilder(item);
    if (index < 0 || index >= steps.size()) {
        _visitables.get("steps").add(builder);
        steps.add(builder);
    } else {
        _visitables.get("steps").add(builder);
        steps.add(index, builder);
    }
    return (A) this;
  }
  
  public Artifacts buildArtifacts() {
    return this.artifacts != null ? this.artifacts.build() : null;
  }
  
  public TaskRunResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public TaskRunStatus buildFirstRetriesStatus() {
    return this.retriesStatus.get(0).build();
  }
  
  public SidecarState buildFirstSidecar() {
    return this.sidecars.get(0).build();
  }
  
  public StepState buildFirstStep() {
    return this.steps.get(0).build();
  }
  
  public TaskRunResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public TaskRunStatus buildLastRetriesStatus() {
    return this.retriesStatus.get(retriesStatus.size() - 1).build();
  }
  
  public SidecarState buildLastSidecar() {
    return this.sidecars.get(sidecars.size() - 1).build();
  }
  
  public StepState buildLastStep() {
    return this.steps.get(steps.size() - 1).build();
  }
  
  public TaskRunResult buildMatchingResult(Predicate<TaskRunResultBuilder> predicate) {
      for (TaskRunResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaskRunStatus buildMatchingRetriesStatus(Predicate<TaskRunStatusBuilder> predicate) {
      for (TaskRunStatusBuilder item : retriesStatus) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SidecarState buildMatchingSidecar(Predicate<SidecarStateBuilder> predicate) {
      for (SidecarStateBuilder item : sidecars) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StepState buildMatchingStep(Predicate<StepStateBuilder> predicate) {
      for (StepStateBuilder item : steps) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Provenance buildProvenance() {
    return this.provenance != null ? this.provenance.build() : null;
  }
  
  public TaskRunResult buildResult(int index) {
    return this.results.get(index).build();
  }
  
  public List<TaskRunResult> buildResults() {
    return this.results != null ? build(results) : null;
  }
  
  public List<TaskRunStatus> buildRetriesStatus() {
    return this.retriesStatus != null ? build(retriesStatus) : null;
  }
  
  public TaskRunStatus buildRetriesStatus(int index) {
    return this.retriesStatus.get(index).build();
  }
  
  public SidecarState buildSidecar(int index) {
    return this.sidecars.get(index).build();
  }
  
  public List<SidecarState> buildSidecars() {
    return this.sidecars != null ? build(sidecars) : null;
  }
  
  public StepState buildStep(int index) {
    return this.steps.get(index).build();
  }
  
  public List<StepState> buildSteps() {
    return this.steps != null ? build(steps) : null;
  }
  
  public TaskSpec buildTaskSpec() {
    return this.taskSpec != null ? this.taskSpec.build() : null;
  }
  
  protected void copyInstance(TaskRunStatusFields instance) {
    instance = instance != null ? instance : new TaskRunStatusFields();
    if (instance != null) {
        this.withArtifacts(instance.getArtifacts());
        this.withCompletionTime(instance.getCompletionTime());
        this.withPodName(instance.getPodName());
        this.withProvenance(instance.getProvenance());
        this.withResults(instance.getResults());
        this.withRetriesStatus(instance.getRetriesStatus());
        this.withSidecars(instance.getSidecars());
        this.withSpanContext(instance.getSpanContext());
        this.withStartTime(instance.getStartTime());
        this.withSteps(instance.getSteps());
        this.withTaskSpec(instance.getTaskSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ArtifactsNested<A> editArtifacts() {
    return this.withNewArtifactsLike(Optional.ofNullable(this.buildArtifacts()).orElse(null));
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
  
  public SidecarsNested<A> editFirstSidecar() {
    if (sidecars.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "sidecars"));
    }
    return this.setNewSidecarLike(0, this.buildSidecar(0));
  }
  
  public StepsNested<A> editFirstStep() {
    if (steps.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "steps"));
    }
    return this.setNewStepLike(0, this.buildStep(0));
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
  
  public SidecarsNested<A> editLastSidecar() {
    int index = sidecars.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "sidecars"));
    }
    return this.setNewSidecarLike(index, this.buildSidecar(index));
  }
  
  public StepsNested<A> editLastStep() {
    int index = steps.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
  }
  
  public ResultsNested<A> editMatchingResult(Predicate<TaskRunResultBuilder> predicate) {
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
  
  public RetriesStatusNested<A> editMatchingRetriesStatus(Predicate<TaskRunStatusBuilder> predicate) {
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
  
  public SidecarsNested<A> editMatchingSidecar(Predicate<SidecarStateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < sidecars.size();i++) {
      if (predicate.test(sidecars.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "sidecars"));
    }
    return this.setNewSidecarLike(index, this.buildSidecar(index));
  }
  
  public StepsNested<A> editMatchingStep(Predicate<StepStateBuilder> predicate) {
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
  
  public ArtifactsNested<A> editOrNewArtifacts() {
    return this.withNewArtifactsLike(Optional.ofNullable(this.buildArtifacts()).orElse(new ArtifactsBuilder().build()));
  }
  
  public ArtifactsNested<A> editOrNewArtifactsLike(Artifacts item) {
    return this.withNewArtifactsLike(Optional.ofNullable(this.buildArtifacts()).orElse(item));
  }
  
  public ProvenanceNested<A> editOrNewProvenance() {
    return this.withNewProvenanceLike(Optional.ofNullable(this.buildProvenance()).orElse(new ProvenanceBuilder().build()));
  }
  
  public ProvenanceNested<A> editOrNewProvenanceLike(Provenance item) {
    return this.withNewProvenanceLike(Optional.ofNullable(this.buildProvenance()).orElse(item));
  }
  
  public TaskSpecNested<A> editOrNewTaskSpec() {
    return this.withNewTaskSpecLike(Optional.ofNullable(this.buildTaskSpec()).orElse(new TaskSpecBuilder().build()));
  }
  
  public TaskSpecNested<A> editOrNewTaskSpecLike(TaskSpec item) {
    return this.withNewTaskSpecLike(Optional.ofNullable(this.buildTaskSpec()).orElse(item));
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
  
  public RetriesStatusNested<A> editRetriesStatus(int index) {
    if (retriesStatus.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "retriesStatus"));
    }
    return this.setNewRetriesStatusLike(index, this.buildRetriesStatus(index));
  }
  
  public SidecarsNested<A> editSidecar(int index) {
    if (sidecars.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "sidecars"));
    }
    return this.setNewSidecarLike(index, this.buildSidecar(index));
  }
  
  public StepsNested<A> editStep(int index) {
    if (steps.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
  }
  
  public TaskSpecNested<A> editTaskSpec() {
    return this.withNewTaskSpecLike(Optional.ofNullable(this.buildTaskSpec()).orElse(null));
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
    TaskRunStatusFieldsFluent that = (TaskRunStatusFieldsFluent) o;
    if (!(Objects.equals(artifacts, that.artifacts))) {
      return false;
    }
    if (!(Objects.equals(completionTime, that.completionTime))) {
      return false;
    }
    if (!(Objects.equals(podName, that.podName))) {
      return false;
    }
    if (!(Objects.equals(provenance, that.provenance))) {
      return false;
    }
    if (!(Objects.equals(results, that.results))) {
      return false;
    }
    if (!(Objects.equals(retriesStatus, that.retriesStatus))) {
      return false;
    }
    if (!(Objects.equals(sidecars, that.sidecars))) {
      return false;
    }
    if (!(Objects.equals(spanContext, that.spanContext))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
      return false;
    }
    if (!(Objects.equals(steps, that.steps))) {
      return false;
    }
    if (!(Objects.equals(taskSpec, that.taskSpec))) {
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
  
  public String getPodName() {
    return this.podName;
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
  
  public boolean hasArtifacts() {
    return this.artifacts != null;
  }
  
  public boolean hasCompletionTime() {
    return this.completionTime != null;
  }
  
  public boolean hasMatchingResult(Predicate<TaskRunResultBuilder> predicate) {
      for (TaskRunResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRetriesStatus(Predicate<TaskRunStatusBuilder> predicate) {
      for (TaskRunStatusBuilder item : retriesStatus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSidecar(Predicate<SidecarStateBuilder> predicate) {
      for (SidecarStateBuilder item : sidecars) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStep(Predicate<StepStateBuilder> predicate) {
      for (StepStateBuilder item : steps) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPodName() {
    return this.podName != null;
  }
  
  public boolean hasProvenance() {
    return this.provenance != null;
  }
  
  public boolean hasResults() {
    return this.results != null && !(this.results.isEmpty());
  }
  
  public boolean hasRetriesStatus() {
    return this.retriesStatus != null && !(this.retriesStatus.isEmpty());
  }
  
  public boolean hasSidecars() {
    return this.sidecars != null && !(this.sidecars.isEmpty());
  }
  
  public boolean hasSpanContext() {
    return this.spanContext != null;
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public boolean hasSteps() {
    return this.steps != null && !(this.steps.isEmpty());
  }
  
  public boolean hasTaskSpec() {
    return this.taskSpec != null;
  }
  
  public int hashCode() {
    return Objects.hash(artifacts, completionTime, podName, provenance, results, retriesStatus, sidecars, spanContext, startTime, steps, taskSpec, additionalProperties);
  }
  
  public A removeAllFromResults(Collection<TaskRunResult> items) {
    if (this.results == null) {
      return (A) this;
    }
    for (TaskRunResult item : items) {
        TaskRunResultBuilder builder = new TaskRunResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRetriesStatus(Collection<TaskRunStatus> items) {
    if (this.retriesStatus == null) {
      return (A) this;
    }
    for (TaskRunStatus item : items) {
        TaskRunStatusBuilder builder = new TaskRunStatusBuilder(item);
        _visitables.get("retriesStatus").remove(builder);
        this.retriesStatus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSidecars(Collection<SidecarState> items) {
    if (this.sidecars == null) {
      return (A) this;
    }
    for (SidecarState item : items) {
        SidecarStateBuilder builder = new SidecarStateBuilder(item);
        _visitables.get("sidecars").remove(builder);
        this.sidecars.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSteps(Collection<StepState> items) {
    if (this.steps == null) {
      return (A) this;
    }
    for (StepState item : items) {
        StepStateBuilder builder = new StepStateBuilder(item);
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
  
  public A removeFromResults(TaskRunResult... items) {
    if (this.results == null) {
      return (A) this;
    }
    for (TaskRunResult item : items) {
        TaskRunResultBuilder builder = new TaskRunResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRetriesStatus(TaskRunStatus... items) {
    if (this.retriesStatus == null) {
      return (A) this;
    }
    for (TaskRunStatus item : items) {
        TaskRunStatusBuilder builder = new TaskRunStatusBuilder(item);
        _visitables.get("retriesStatus").remove(builder);
        this.retriesStatus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSidecars(SidecarState... items) {
    if (this.sidecars == null) {
      return (A) this;
    }
    for (SidecarState item : items) {
        SidecarStateBuilder builder = new SidecarStateBuilder(item);
        _visitables.get("sidecars").remove(builder);
        this.sidecars.remove(builder);
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
  
  public A removeFromSteps(StepState... items) {
    if (this.steps == null) {
      return (A) this;
    }
    for (StepState item : items) {
        StepStateBuilder builder = new StepStateBuilder(item);
        _visitables.get("steps").remove(builder);
        this.steps.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResults(Predicate<TaskRunResultBuilder> predicate) {
    if (results == null) {
      return (A) this;
    }
    Iterator<TaskRunResultBuilder> each = results.iterator();
    List visitables = _visitables.get("results");
    while (each.hasNext()) {
        TaskRunResultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRetriesStatus(Predicate<TaskRunStatusBuilder> predicate) {
    if (retriesStatus == null) {
      return (A) this;
    }
    Iterator<TaskRunStatusBuilder> each = retriesStatus.iterator();
    List visitables = _visitables.get("retriesStatus");
    while (each.hasNext()) {
        TaskRunStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSidecars(Predicate<SidecarStateBuilder> predicate) {
    if (sidecars == null) {
      return (A) this;
    }
    Iterator<SidecarStateBuilder> each = sidecars.iterator();
    List visitables = _visitables.get("sidecars");
    while (each.hasNext()) {
        SidecarStateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSteps(Predicate<StepStateBuilder> predicate) {
    if (steps == null) {
      return (A) this;
    }
    Iterator<StepStateBuilder> each = steps.iterator();
    List visitables = _visitables.get("steps");
    while (each.hasNext()) {
        StepStateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResultsNested<A> setNewResultLike(int index,TaskRunResult item) {
    return new ResultsNested(index, item);
  }
  
  public RetriesStatusNested<A> setNewRetriesStatusLike(int index,TaskRunStatus item) {
    return new RetriesStatusNested(index, item);
  }
  
  public SidecarsNested<A> setNewSidecarLike(int index,SidecarState item) {
    return new SidecarsNested(index, item);
  }
  
  public StepsNested<A> setNewStepLike(int index,StepState item) {
    return new StepsNested(index, item);
  }
  
  public A setToResults(int index,TaskRunResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    TaskRunResultBuilder builder = new TaskRunResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRetriesStatus(int index,TaskRunStatus item) {
    if (this.retriesStatus == null) {
      this.retriesStatus = new ArrayList();
    }
    TaskRunStatusBuilder builder = new TaskRunStatusBuilder(item);
    if (index < 0 || index >= retriesStatus.size()) {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.add(builder);
    } else {
        _visitables.get("retriesStatus").add(builder);
        retriesStatus.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSidecars(int index,SidecarState item) {
    if (this.sidecars == null) {
      this.sidecars = new ArrayList();
    }
    SidecarStateBuilder builder = new SidecarStateBuilder(item);
    if (index < 0 || index >= sidecars.size()) {
        _visitables.get("sidecars").add(builder);
        sidecars.add(builder);
    } else {
        _visitables.get("sidecars").add(builder);
        sidecars.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSteps(int index,StepState item) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    StepStateBuilder builder = new StepStateBuilder(item);
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
    if (!(artifacts == null)) {
        sb.append("artifacts:");
        sb.append(artifacts);
        sb.append(",");
    }
    if (!(completionTime == null)) {
        sb.append("completionTime:");
        sb.append(completionTime);
        sb.append(",");
    }
    if (!(podName == null)) {
        sb.append("podName:");
        sb.append(podName);
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
    if (!(retriesStatus == null) && !(retriesStatus.isEmpty())) {
        sb.append("retriesStatus:");
        sb.append(retriesStatus);
        sb.append(",");
    }
    if (!(sidecars == null) && !(sidecars.isEmpty())) {
        sb.append("sidecars:");
        sb.append(sidecars);
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
    if (!(steps == null) && !(steps.isEmpty())) {
        sb.append("steps:");
        sb.append(steps);
        sb.append(",");
    }
    if (!(taskSpec == null)) {
        sb.append("taskSpec:");
        sb.append(taskSpec);
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
  
  public A withArtifacts(Artifacts artifacts) {
    this._visitables.remove("artifacts");
    if (artifacts != null) {
        this.artifacts = new ArtifactsBuilder(artifacts);
        this._visitables.get("artifacts").add(this.artifacts);
    } else {
        this.artifacts = null;
        this._visitables.get("artifacts").remove(this.artifacts);
    }
    return (A) this;
  }
  
  public A withCompletionTime(String completionTime) {
    this.completionTime = completionTime;
    return (A) this;
  }
  
  public ArtifactsNested<A> withNewArtifacts() {
    return new ArtifactsNested(null);
  }
  
  public ArtifactsNested<A> withNewArtifactsLike(Artifacts item) {
    return new ArtifactsNested(item);
  }
  
  public ProvenanceNested<A> withNewProvenance() {
    return new ProvenanceNested(null);
  }
  
  public ProvenanceNested<A> withNewProvenanceLike(Provenance item) {
    return new ProvenanceNested(item);
  }
  
  public TaskSpecNested<A> withNewTaskSpec() {
    return new TaskSpecNested(null);
  }
  
  public TaskSpecNested<A> withNewTaskSpecLike(TaskSpec item) {
    return new TaskSpecNested(item);
  }
  
  public A withPodName(String podName) {
    this.podName = podName;
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
  
  public A withResults(List<TaskRunResult> results) {
    if (this.results != null) {
      this._visitables.get("results").clear();
    }
    if (results != null) {
        this.results = new ArrayList();
        for (TaskRunResult item : results) {
          this.addToResults(item);
        }
    } else {
      this.results = null;
    }
    return (A) this;
  }
  
  public A withResults(TaskRunResult... results) {
    if (this.results != null) {
        this.results.clear();
        _visitables.remove("results");
    }
    if (results != null) {
      for (TaskRunResult item : results) {
        this.addToResults(item);
      }
    }
    return (A) this;
  }
  
  public A withRetriesStatus(List<TaskRunStatus> retriesStatus) {
    if (this.retriesStatus != null) {
      this._visitables.get("retriesStatus").clear();
    }
    if (retriesStatus != null) {
        this.retriesStatus = new ArrayList();
        for (TaskRunStatus item : retriesStatus) {
          this.addToRetriesStatus(item);
        }
    } else {
      this.retriesStatus = null;
    }
    return (A) this;
  }
  
  public A withRetriesStatus(TaskRunStatus... retriesStatus) {
    if (this.retriesStatus != null) {
        this.retriesStatus.clear();
        _visitables.remove("retriesStatus");
    }
    if (retriesStatus != null) {
      for (TaskRunStatus item : retriesStatus) {
        this.addToRetriesStatus(item);
      }
    }
    return (A) this;
  }
  
  public A withSidecars(List<SidecarState> sidecars) {
    if (this.sidecars != null) {
      this._visitables.get("sidecars").clear();
    }
    if (sidecars != null) {
        this.sidecars = new ArrayList();
        for (SidecarState item : sidecars) {
          this.addToSidecars(item);
        }
    } else {
      this.sidecars = null;
    }
    return (A) this;
  }
  
  public A withSidecars(SidecarState... sidecars) {
    if (this.sidecars != null) {
        this.sidecars.clear();
        _visitables.remove("sidecars");
    }
    if (sidecars != null) {
      for (SidecarState item : sidecars) {
        this.addToSidecars(item);
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
  
  public A withSteps(List<StepState> steps) {
    if (this.steps != null) {
      this._visitables.get("steps").clear();
    }
    if (steps != null) {
        this.steps = new ArrayList();
        for (StepState item : steps) {
          this.addToSteps(item);
        }
    } else {
      this.steps = null;
    }
    return (A) this;
  }
  
  public A withSteps(StepState... steps) {
    if (this.steps != null) {
        this.steps.clear();
        _visitables.remove("steps");
    }
    if (steps != null) {
      for (StepState item : steps) {
        this.addToSteps(item);
      }
    }
    return (A) this;
  }
  
  public A withTaskSpec(TaskSpec taskSpec) {
    this._visitables.remove("taskSpec");
    if (taskSpec != null) {
        this.taskSpec = new TaskSpecBuilder(taskSpec);
        this._visitables.get("taskSpec").add(this.taskSpec);
    } else {
        this.taskSpec = null;
        this._visitables.get("taskSpec").remove(this.taskSpec);
    }
    return (A) this;
  }
  public class ArtifactsNested<N> extends ArtifactsFluent<ArtifactsNested<N>> implements Nested<N>{
  
    ArtifactsBuilder builder;
  
    ArtifactsNested(Artifacts item) {
      this.builder = new ArtifactsBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunStatusFieldsFluent.this.withArtifacts(builder.build());
    }
    
    public N endArtifacts() {
      return and();
    }
    
  }
  public class ProvenanceNested<N> extends ProvenanceFluent<ProvenanceNested<N>> implements Nested<N>{
  
    ProvenanceBuilder builder;
  
    ProvenanceNested(Provenance item) {
      this.builder = new ProvenanceBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunStatusFieldsFluent.this.withProvenance(builder.build());
    }
    
    public N endProvenance() {
      return and();
    }
    
  }
  public class ResultsNested<N> extends TaskRunResultFluent<ResultsNested<N>> implements Nested<N>{
  
    TaskRunResultBuilder builder;
    int index;
  
    ResultsNested(int index,TaskRunResult item) {
      this.index = index;
      this.builder = new TaskRunResultBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunStatusFieldsFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
  public class RetriesStatusNested<N> extends TaskRunStatusFluent<RetriesStatusNested<N>> implements Nested<N>{
  
    TaskRunStatusBuilder builder;
    int index;
  
    RetriesStatusNested(int index,TaskRunStatus item) {
      this.index = index;
      this.builder = new TaskRunStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunStatusFieldsFluent.this.setToRetriesStatus(index, builder.build());
    }
    
    public N endRetriesStatus() {
      return and();
    }
    
  }
  public class SidecarsNested<N> extends SidecarStateFluent<SidecarsNested<N>> implements Nested<N>{
  
    SidecarStateBuilder builder;
    int index;
  
    SidecarsNested(int index,SidecarState item) {
      this.index = index;
      this.builder = new SidecarStateBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunStatusFieldsFluent.this.setToSidecars(index, builder.build());
    }
    
    public N endSidecar() {
      return and();
    }
    
  }
  public class StepsNested<N> extends StepStateFluent<StepsNested<N>> implements Nested<N>{
  
    StepStateBuilder builder;
    int index;
  
    StepsNested(int index,StepState item) {
      this.index = index;
      this.builder = new StepStateBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunStatusFieldsFluent.this.setToSteps(index, builder.build());
    }
    
    public N endStep() {
      return and();
    }
    
  }
  public class TaskSpecNested<N> extends TaskSpecFluent<TaskSpecNested<N>> implements Nested<N>{
  
    TaskSpecBuilder builder;
  
    TaskSpecNested(TaskSpec item) {
      this.builder = new TaskSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunStatusFieldsFluent.this.withTaskSpec(builder.build());
    }
    
    public N endTaskSpec() {
      return and();
    }
    
  }
}