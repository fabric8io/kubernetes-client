package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ContainerStateRunning;
import io.fabric8.kubernetes.api.model.ContainerStateTerminated;
import io.fabric8.kubernetes.api.model.ContainerStateWaiting;
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
public class StepStateFluent<A extends io.fabric8.tekton.v1.StepStateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String container;
  private String imageID;
  private ArrayList<ArtifactBuilder> inputs = new ArrayList<ArtifactBuilder>();
  private String name;
  private ArrayList<ArtifactBuilder> outputs = new ArrayList<ArtifactBuilder>();
  private ProvenanceBuilder provenance;
  private ArrayList<TaskRunResultBuilder> results = new ArrayList<TaskRunResultBuilder>();
  private ContainerStateRunning running;
  private ContainerStateTerminated terminated;
  private String terminationReason;
  private ContainerStateWaiting waiting;

  public StepStateFluent() {
  }
  
  public StepStateFluent(StepState instance) {
    this.copyInstance(instance);
  }

  public A addAllToInputs(Collection<Artifact> items) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    for (Artifact item : items) {
        ArtifactBuilder builder = new ArtifactBuilder(item);
        _visitables.get("inputs").add(builder);
        this.inputs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOutputs(Collection<Artifact> items) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    for (Artifact item : items) {
        ArtifactBuilder builder = new ArtifactBuilder(item);
        _visitables.get("outputs").add(builder);
        this.outputs.add(builder);
    }
    return (A) this;
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
  
  public InputsNested<A> addNewInput() {
    return new InputsNested(-1, null);
  }
  
  public InputsNested<A> addNewInputLike(Artifact item) {
    return new InputsNested(-1, item);
  }
  
  public OutputsNested<A> addNewOutput() {
    return new OutputsNested(-1, null);
  }
  
  public OutputsNested<A> addNewOutputLike(Artifact item) {
    return new OutputsNested(-1, item);
  }
  
  public ResultsNested<A> addNewResult() {
    return new ResultsNested(-1, null);
  }
  
  public ResultsNested<A> addNewResultLike(TaskRunResult item) {
    return new ResultsNested(-1, item);
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
  
  public A addToInputs(Artifact... items) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    for (Artifact item : items) {
        ArtifactBuilder builder = new ArtifactBuilder(item);
        _visitables.get("inputs").add(builder);
        this.inputs.add(builder);
    }
    return (A) this;
  }
  
  public A addToInputs(int index,Artifact item) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    ArtifactBuilder builder = new ArtifactBuilder(item);
    if (index < 0 || index >= inputs.size()) {
        _visitables.get("inputs").add(builder);
        inputs.add(builder);
    } else {
        _visitables.get("inputs").add(builder);
        inputs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOutputs(Artifact... items) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    for (Artifact item : items) {
        ArtifactBuilder builder = new ArtifactBuilder(item);
        _visitables.get("outputs").add(builder);
        this.outputs.add(builder);
    }
    return (A) this;
  }
  
  public A addToOutputs(int index,Artifact item) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    ArtifactBuilder builder = new ArtifactBuilder(item);
    if (index < 0 || index >= outputs.size()) {
        _visitables.get("outputs").add(builder);
        outputs.add(builder);
    } else {
        _visitables.get("outputs").add(builder);
        outputs.add(index, builder);
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
  
  public Artifact buildFirstInput() {
    return this.inputs.get(0).build();
  }
  
  public Artifact buildFirstOutput() {
    return this.outputs.get(0).build();
  }
  
  public TaskRunResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public Artifact buildInput(int index) {
    return this.inputs.get(index).build();
  }
  
  public List<Artifact> buildInputs() {
    return this.inputs != null ? build(inputs) : null;
  }
  
  public Artifact buildLastInput() {
    return this.inputs.get(inputs.size() - 1).build();
  }
  
  public Artifact buildLastOutput() {
    return this.outputs.get(outputs.size() - 1).build();
  }
  
  public TaskRunResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public Artifact buildMatchingInput(Predicate<ArtifactBuilder> predicate) {
      for (ArtifactBuilder item : inputs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Artifact buildMatchingOutput(Predicate<ArtifactBuilder> predicate) {
      for (ArtifactBuilder item : outputs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaskRunResult buildMatchingResult(Predicate<TaskRunResultBuilder> predicate) {
      for (TaskRunResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Artifact buildOutput(int index) {
    return this.outputs.get(index).build();
  }
  
  public List<Artifact> buildOutputs() {
    return this.outputs != null ? build(outputs) : null;
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
  
  protected void copyInstance(StepState instance) {
    instance = instance != null ? instance : new StepState();
    if (instance != null) {
        this.withContainer(instance.getContainer());
        this.withImageID(instance.getImageID());
        this.withInputs(instance.getInputs());
        this.withName(instance.getName());
        this.withOutputs(instance.getOutputs());
        this.withProvenance(instance.getProvenance());
        this.withResults(instance.getResults());
        this.withRunning(instance.getRunning());
        this.withTerminated(instance.getTerminated());
        this.withTerminationReason(instance.getTerminationReason());
        this.withWaiting(instance.getWaiting());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public InputsNested<A> editFirstInput() {
    if (inputs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "inputs"));
    }
    return this.setNewInputLike(0, this.buildInput(0));
  }
  
  public OutputsNested<A> editFirstOutput() {
    if (outputs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "outputs"));
    }
    return this.setNewOutputLike(0, this.buildOutput(0));
  }
  
  public ResultsNested<A> editFirstResult() {
    if (results.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(0, this.buildResult(0));
  }
  
  public InputsNested<A> editInput(int index) {
    if (inputs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "inputs"));
    }
    return this.setNewInputLike(index, this.buildInput(index));
  }
  
  public InputsNested<A> editLastInput() {
    int index = inputs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "inputs"));
    }
    return this.setNewInputLike(index, this.buildInput(index));
  }
  
  public OutputsNested<A> editLastOutput() {
    int index = outputs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "outputs"));
    }
    return this.setNewOutputLike(index, this.buildOutput(index));
  }
  
  public ResultsNested<A> editLastResult() {
    int index = results.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public InputsNested<A> editMatchingInput(Predicate<ArtifactBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < inputs.size();i++) {
      if (predicate.test(inputs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "inputs"));
    }
    return this.setNewInputLike(index, this.buildInput(index));
  }
  
  public OutputsNested<A> editMatchingOutput(Predicate<ArtifactBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < outputs.size();i++) {
      if (predicate.test(outputs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "outputs"));
    }
    return this.setNewOutputLike(index, this.buildOutput(index));
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
  
  public ProvenanceNested<A> editOrNewProvenance() {
    return this.withNewProvenanceLike(Optional.ofNullable(this.buildProvenance()).orElse(new ProvenanceBuilder().build()));
  }
  
  public ProvenanceNested<A> editOrNewProvenanceLike(Provenance item) {
    return this.withNewProvenanceLike(Optional.ofNullable(this.buildProvenance()).orElse(item));
  }
  
  public OutputsNested<A> editOutput(int index) {
    if (outputs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "outputs"));
    }
    return this.setNewOutputLike(index, this.buildOutput(index));
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
    StepStateFluent that = (StepStateFluent) o;
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(imageID, that.imageID))) {
      return false;
    }
    if (!(Objects.equals(inputs, that.inputs))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(outputs, that.outputs))) {
      return false;
    }
    if (!(Objects.equals(provenance, that.provenance))) {
      return false;
    }
    if (!(Objects.equals(results, that.results))) {
      return false;
    }
    if (!(Objects.equals(running, that.running))) {
      return false;
    }
    if (!(Objects.equals(terminated, that.terminated))) {
      return false;
    }
    if (!(Objects.equals(terminationReason, that.terminationReason))) {
      return false;
    }
    if (!(Objects.equals(waiting, that.waiting))) {
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
  
  public String getContainer() {
    return this.container;
  }
  
  public String getImageID() {
    return this.imageID;
  }
  
  public String getName() {
    return this.name;
  }
  
  public ContainerStateRunning getRunning() {
    return this.running;
  }
  
  public ContainerStateTerminated getTerminated() {
    return this.terminated;
  }
  
  public String getTerminationReason() {
    return this.terminationReason;
  }
  
  public ContainerStateWaiting getWaiting() {
    return this.waiting;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasImageID() {
    return this.imageID != null;
  }
  
  public boolean hasInputs() {
    return this.inputs != null && !(this.inputs.isEmpty());
  }
  
  public boolean hasMatchingInput(Predicate<ArtifactBuilder> predicate) {
      for (ArtifactBuilder item : inputs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOutput(Predicate<ArtifactBuilder> predicate) {
      for (ArtifactBuilder item : outputs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResult(Predicate<TaskRunResultBuilder> predicate) {
      for (TaskRunResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasOutputs() {
    return this.outputs != null && !(this.outputs.isEmpty());
  }
  
  public boolean hasProvenance() {
    return this.provenance != null;
  }
  
  public boolean hasResults() {
    return this.results != null && !(this.results.isEmpty());
  }
  
  public boolean hasRunning() {
    return this.running != null;
  }
  
  public boolean hasTerminated() {
    return this.terminated != null;
  }
  
  public boolean hasTerminationReason() {
    return this.terminationReason != null;
  }
  
  public boolean hasWaiting() {
    return this.waiting != null;
  }
  
  public int hashCode() {
    return Objects.hash(container, imageID, inputs, name, outputs, provenance, results, running, terminated, terminationReason, waiting, additionalProperties);
  }
  
  public A removeAllFromInputs(Collection<Artifact> items) {
    if (this.inputs == null) {
      return (A) this;
    }
    for (Artifact item : items) {
        ArtifactBuilder builder = new ArtifactBuilder(item);
        _visitables.get("inputs").remove(builder);
        this.inputs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOutputs(Collection<Artifact> items) {
    if (this.outputs == null) {
      return (A) this;
    }
    for (Artifact item : items) {
        ArtifactBuilder builder = new ArtifactBuilder(item);
        _visitables.get("outputs").remove(builder);
        this.outputs.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromInputs(Artifact... items) {
    if (this.inputs == null) {
      return (A) this;
    }
    for (Artifact item : items) {
        ArtifactBuilder builder = new ArtifactBuilder(item);
        _visitables.get("inputs").remove(builder);
        this.inputs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOutputs(Artifact... items) {
    if (this.outputs == null) {
      return (A) this;
    }
    for (Artifact item : items) {
        ArtifactBuilder builder = new ArtifactBuilder(item);
        _visitables.get("outputs").remove(builder);
        this.outputs.remove(builder);
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
  
  public A removeMatchingFromInputs(Predicate<ArtifactBuilder> predicate) {
    if (inputs == null) {
      return (A) this;
    }
    Iterator<ArtifactBuilder> each = inputs.iterator();
    List visitables = _visitables.get("inputs");
    while (each.hasNext()) {
        ArtifactBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOutputs(Predicate<ArtifactBuilder> predicate) {
    if (outputs == null) {
      return (A) this;
    }
    Iterator<ArtifactBuilder> each = outputs.iterator();
    List visitables = _visitables.get("outputs");
    while (each.hasNext()) {
        ArtifactBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public InputsNested<A> setNewInputLike(int index,Artifact item) {
    return new InputsNested(index, item);
  }
  
  public OutputsNested<A> setNewOutputLike(int index,Artifact item) {
    return new OutputsNested(index, item);
  }
  
  public ResultsNested<A> setNewResultLike(int index,TaskRunResult item) {
    return new ResultsNested(index, item);
  }
  
  public A setToInputs(int index,Artifact item) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    ArtifactBuilder builder = new ArtifactBuilder(item);
    if (index < 0 || index >= inputs.size()) {
        _visitables.get("inputs").add(builder);
        inputs.add(builder);
    } else {
        _visitables.get("inputs").add(builder);
        inputs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOutputs(int index,Artifact item) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    ArtifactBuilder builder = new ArtifactBuilder(item);
    if (index < 0 || index >= outputs.size()) {
        _visitables.get("outputs").add(builder);
        outputs.add(builder);
    } else {
        _visitables.get("outputs").add(builder);
        outputs.set(index, builder);
    }
    return (A) this;
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(imageID == null)) {
        sb.append("imageID:");
        sb.append(imageID);
        sb.append(",");
    }
    if (!(inputs == null) && !(inputs.isEmpty())) {
        sb.append("inputs:");
        sb.append(inputs);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(outputs == null) && !(outputs.isEmpty())) {
        sb.append("outputs:");
        sb.append(outputs);
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
    if (!(running == null)) {
        sb.append("running:");
        sb.append(running);
        sb.append(",");
    }
    if (!(terminated == null)) {
        sb.append("terminated:");
        sb.append(terminated);
        sb.append(",");
    }
    if (!(terminationReason == null)) {
        sb.append("terminationReason:");
        sb.append(terminationReason);
        sb.append(",");
    }
    if (!(waiting == null)) {
        sb.append("waiting:");
        sb.append(waiting);
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
  
  public A withContainer(String container) {
    this.container = container;
    return (A) this;
  }
  
  public A withImageID(String imageID) {
    this.imageID = imageID;
    return (A) this;
  }
  
  public A withInputs(List<Artifact> inputs) {
    if (this.inputs != null) {
      this._visitables.get("inputs").clear();
    }
    if (inputs != null) {
        this.inputs = new ArrayList();
        for (Artifact item : inputs) {
          this.addToInputs(item);
        }
    } else {
      this.inputs = null;
    }
    return (A) this;
  }
  
  public A withInputs(Artifact... inputs) {
    if (this.inputs != null) {
        this.inputs.clear();
        _visitables.remove("inputs");
    }
    if (inputs != null) {
      for (Artifact item : inputs) {
        this.addToInputs(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ProvenanceNested<A> withNewProvenance() {
    return new ProvenanceNested(null);
  }
  
  public ProvenanceNested<A> withNewProvenanceLike(Provenance item) {
    return new ProvenanceNested(item);
  }
  
  public A withNewRunning(String startedAt) {
    return (A) this.withRunning(new ContainerStateRunning(startedAt));
  }
  
  public A withNewWaiting(String message,String reason) {
    return (A) this.withWaiting(new ContainerStateWaiting(message, reason));
  }
  
  public A withOutputs(List<Artifact> outputs) {
    if (this.outputs != null) {
      this._visitables.get("outputs").clear();
    }
    if (outputs != null) {
        this.outputs = new ArrayList();
        for (Artifact item : outputs) {
          this.addToOutputs(item);
        }
    } else {
      this.outputs = null;
    }
    return (A) this;
  }
  
  public A withOutputs(Artifact... outputs) {
    if (this.outputs != null) {
        this.outputs.clear();
        _visitables.remove("outputs");
    }
    if (outputs != null) {
      for (Artifact item : outputs) {
        this.addToOutputs(item);
      }
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
  
  public A withRunning(ContainerStateRunning running) {
    this.running = running;
    return (A) this;
  }
  
  public A withTerminated(ContainerStateTerminated terminated) {
    this.terminated = terminated;
    return (A) this;
  }
  
  public A withTerminationReason(String terminationReason) {
    this.terminationReason = terminationReason;
    return (A) this;
  }
  
  public A withWaiting(ContainerStateWaiting waiting) {
    this.waiting = waiting;
    return (A) this;
  }
  public class InputsNested<N> extends ArtifactFluent<InputsNested<N>> implements Nested<N>{
  
    ArtifactBuilder builder;
    int index;
  
    InputsNested(int index,Artifact item) {
      this.index = index;
      this.builder = new ArtifactBuilder(this, item);
    }
  
    public N and() {
      return (N) StepStateFluent.this.setToInputs(index, builder.build());
    }
    
    public N endInput() {
      return and();
    }
    
  }
  public class OutputsNested<N> extends ArtifactFluent<OutputsNested<N>> implements Nested<N>{
  
    ArtifactBuilder builder;
    int index;
  
    OutputsNested(int index,Artifact item) {
      this.index = index;
      this.builder = new ArtifactBuilder(this, item);
    }
  
    public N and() {
      return (N) StepStateFluent.this.setToOutputs(index, builder.build());
    }
    
    public N endOutput() {
      return and();
    }
    
  }
  public class ProvenanceNested<N> extends ProvenanceFluent<ProvenanceNested<N>> implements Nested<N>{
  
    ProvenanceBuilder builder;
  
    ProvenanceNested(Provenance item) {
      this.builder = new ProvenanceBuilder(this, item);
    }
  
    public N and() {
      return (N) StepStateFluent.this.withProvenance(builder.build());
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
      return (N) StepStateFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
}